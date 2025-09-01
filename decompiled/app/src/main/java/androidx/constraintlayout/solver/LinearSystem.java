package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    public final Cache mCache;
    private Row mGoal;
    public ArrayRow[] mRows;
    private Row mTempGoal;
    public boolean hasSimpleDefinition = false;
    public int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int TABLE_SIZE = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    public int mNumColumns = 1;
    public int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
    private int mPoolVariablesCount = 0;

    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z2);

        void updateFromSystem(LinearSystem linearSystem);
    }

    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable solverVariableAcquire = this.mCache.solverVariablePool.acquire();
        if (solverVariableAcquire == null) {
            solverVariableAcquire = new SolverVariable(type, str);
            solverVariableAcquire.setType(type, str);
        } else {
            solverVariableAcquire.reset();
            solverVariableAcquire.setType(type, str);
        }
        int i = this.mPoolVariablesCount;
        int i2 = POOL_SIZE;
        if (i >= i2) {
            int i3 = i2 * 2;
            POOL_SIZE = i3;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i3);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i4 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i4 + 1;
        solverVariableArr[i4] = solverVariableAcquire;
        return solverVariableAcquire;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        int i;
        if (SIMPLIFY_SYNONYMS && arrayRow.isSimpleDefinition) {
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        } else {
            ArrayRow[] arrayRowArr = this.mRows;
            int i2 = this.mNumRows;
            arrayRowArr[i2] = arrayRow;
            SolverVariable solverVariable = arrayRow.variable;
            solverVariable.definitionId = i2;
            this.mNumRows = i2 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i3 = 0;
            while (i3 < this.mNumRows) {
                if (this.mRows[i3] == null) {
                    System.out.println("WTF");
                }
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (arrayRowArr2[i3] != null && arrayRowArr2[i3].isSimpleDefinition) {
                    ArrayRow arrayRow2 = arrayRowArr2[i3];
                    arrayRow2.variable.setFinalValue(this, arrayRow2.constantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow2);
                    } else {
                        this.mCache.arrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.mNumRows;
                        if (i4 >= i) {
                            break;
                        }
                        ArrayRow[] arrayRowArr3 = this.mRows;
                        int i6 = i4 - 1;
                        arrayRowArr3[i6] = arrayRowArr3[i4];
                        if (arrayRowArr3[i6].variable.definitionId == i4) {
                            arrayRowArr3[i6].variable.definitionId = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.mRows[i5] = null;
                    }
                    this.mNumRows = i - 1;
                    i3--;
                }
                i3++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void addSingleError(ArrayRow arrayRow, int i) {
        addSingleError(arrayRow, i, 0);
    }

    private void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(type, null);
        solverVariableAcquireSolverVariable.setName(str);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.f30id = i;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, solverVariableAcquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String strW = "";
        for (int i = 0; i < this.mNumRows; i++) {
            StringBuilder sbU = outline.U(strW);
            sbU.append(this.mRows[i]);
            strW = outline.w(sbU.toString(), "\n");
        }
        StringBuilder sbU2 = outline.U(strW);
        sbU2.append(this.mGoal);
        sbU2.append("\n");
        System.out.println(sbU2.toString());
    }

    private void displaySolverVariables() {
        StringBuilder sbU = outline.U("Display Rows (");
        sbU.append(this.mNumRows);
        sbU.append("x");
        System.out.println(outline.B(sbU, this.mNumColumns, ")\n"));
    }

    private int enforceBFS(Row row) throws Exception {
        boolean z2;
        int i = 0;
        while (true) {
            if (i >= this.mNumRows) {
                z2 = false;
                break;
            }
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i].variable.mType != SolverVariable.Type.UNRESTRICTED && arrayRowArr[i].constantValue < 0.0f) {
                z2 = true;
                break;
            }
            i++;
        }
        if (!z2) {
            return 0;
        }
        boolean z3 = false;
        int i2 = 0;
        while (!z3) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.bfs++;
            }
            i2++;
            float f = Float.MAX_VALUE;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            for (int i6 = 0; i6 < this.mNumRows; i6++) {
                ArrayRow arrayRow = this.mRows[i6];
                if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.constantValue < 0.0f) {
                    int i7 = 9;
                    if (SKIP_COLUMNS) {
                        int currentSize = arrayRow.variables.getCurrentSize();
                        int i8 = 0;
                        while (i8 < currentSize) {
                            SolverVariable variable = arrayRow.variables.getVariable(i8);
                            float f2 = arrayRow.variables.get(variable);
                            if (f2 > 0.0f) {
                                int i9 = 0;
                                while (i9 < i7) {
                                    float f3 = variable.strengthVector[i9] / f2;
                                    if ((f3 < f && i9 == i5) || i9 > i5) {
                                        i4 = variable.f30id;
                                        i5 = i9;
                                        i3 = i6;
                                        f = f3;
                                    }
                                    i9++;
                                    i7 = 9;
                                }
                            }
                            i8++;
                            i7 = 9;
                        }
                    } else {
                        for (int i10 = 1; i10 < this.mNumColumns; i10++) {
                            SolverVariable solverVariable = this.mCache.mIndexedVariables[i10];
                            float f4 = arrayRow.variables.get(solverVariable);
                            if (f4 > 0.0f) {
                                for (int i11 = 0; i11 < 9; i11++) {
                                    float f5 = solverVariable.strengthVector[i11] / f4;
                                    if ((f5 < f && i11 == i5) || i11 > i5) {
                                        i4 = i10;
                                        i5 = i11;
                                        i3 = i6;
                                        f = f5;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i3 != -1) {
                ArrayRow arrayRow2 = this.mRows[i3];
                arrayRow2.variable.definitionId = -1;
                Metrics metrics2 = sMetrics;
                if (metrics2 != null) {
                    metrics2.pivots++;
                }
                arrayRow2.pivot(this.mCache.mIndexedVariables[i4]);
                SolverVariable solverVariable2 = arrayRow2.variable;
                solverVariable2.definitionId = i3;
                solverVariable2.updateReferencesWithNewDefinition(this, arrayRow2);
            } else {
                z3 = true;
            }
            if (i2 > this.mNumColumns / 2) {
                z3 = true;
            }
        }
        return i2;
    }

    private String getDisplaySize(int i) {
        int i2 = i * 4;
        int i3 = i2 / 1024;
        int i4 = i3 / 1024;
        return i4 > 0 ? outline.r("", i4, " Mb") : i3 > 0 ? outline.r("", i3, " Kb") : outline.r("", i2, " bytes");
    }

    private String getDisplayStrength(int i) {
        return i == 1 ? "LOW" : i == 2 ? "MEDIUM" : i == 3 ? "HIGH" : i == 4 ? "HIGHEST" : i == 5 ? "EQUALITY" : i == 8 ? "FIXED" : i == 6 ? "BARRIER" : "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i2 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i2];
        this.mMaxColumns = i2;
        this.mMaxRows = i2;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i2);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int optimize(Row row, boolean z2) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z3 = false;
        int i2 = 0;
        while (!z3) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i2++;
            if (i2 >= this.mNumColumns * 2) {
                return i2;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().f30id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i3 = pivotCandidate.f30id;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.mNumRows; i5++) {
                    ArrayRow arrayRow = this.mRows[i5];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                        float f2 = arrayRow.variables.get(pivotCandidate);
                        if (f2 < 0.0f) {
                            float f3 = (-arrayRow.constantValue) / f2;
                            if (f3 < f) {
                                i4 = i5;
                                f = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i4];
                    arrayRow2.variable.definitionId = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    SolverVariable solverVariable = arrayRow2.variable;
                    solverVariable.definitionId = i4;
                    solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                }
            } else {
                z3 = true;
            }
        }
        return i2;
    }

    private void releaseRows() {
        int i = 0;
        if (OPTIMIZED_ENGINE) {
            while (i < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i];
                if (arrayRow != null) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i] = null;
                i++;
            }
            return;
        }
        while (i < this.mNumRows) {
            ArrayRow arrayRow2 = this.mRows[i];
            if (arrayRow2 != null) {
                this.mCache.arrayRowPool.release(arrayRow2);
            }
            this.mRows[i] = null;
            i++;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableCreateObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableCreateObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableCreateObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableCreateObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable solverVariableCreateObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable solverVariableCreateObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable solverVariableCreateObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable solverVariableCreateObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow arrayRowCreateRow = createRow();
        double d = f;
        double d2 = i;
        arrayRowCreateRow.createRowWithAngle(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable8, (float) (Math.sin(d) * d2));
        addConstraint(arrayRowCreateRow);
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowWithAngle(solverVariableCreateObjectVariable, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable7, (float) (Math.cos(d) * d2));
        addConstraint(arrayRowCreateRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i3 != 8) {
            arrayRowCreateRow.addError(this, i3);
        }
        addConstraint(arrayRowCreateRow);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable solverVariablePickPivot;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.isSimpleDefinition) {
                metrics.simpleconstraints++;
            }
        }
        boolean z2 = true;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z3 = false;
        if (!arrayRow.isSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable solverVariableCreateExtraVariable = createExtraVariable();
                arrayRow.variable = solverVariableCreateExtraVariable;
                int i = this.mNumRows;
                addRow(arrayRow);
                if (this.mNumRows == i + 1) {
                    this.mTempGoal.initFromRow(arrayRow);
                    optimize(this.mTempGoal, true);
                    if (solverVariableCreateExtraVariable.definitionId == -1) {
                        if (arrayRow.variable == solverVariableCreateExtraVariable && (solverVariablePickPivot = arrayRow.pickPivot(solverVariableCreateExtraVariable)) != null) {
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots++;
                            }
                            arrayRow.pivot(solverVariablePickPivot);
                        }
                        if (!arrayRow.isSimpleDefinition) {
                            arrayRow.variable.updateReferencesWithNewDefinition(this, arrayRow);
                        }
                        if (OPTIMIZED_ENGINE) {
                            this.mCache.optimizedArrayRowPool.release(arrayRow);
                        } else {
                            this.mCache.arrayRowPool.release(arrayRow);
                        }
                        this.mNumRows--;
                    }
                } else {
                    z2 = false;
                }
                if (!arrayRow.hasKeyVariable()) {
                    return;
                } else {
                    z3 = z2;
                }
            }
        }
        if (z3) {
            return;
        }
        addRow(arrayRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (USE_BASIC_SYNONYMS && i2 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i);
            return null;
        }
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowEquals(solverVariable, solverVariable2, i);
        if (i2 != 8) {
            arrayRowCreateRow.addError(this, i2);
        }
        addConstraint(arrayRowCreateRow);
        return arrayRowCreateRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i);
        addConstraint(arrayRowCreateRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i);
        if (i2 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i2);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i);
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i);
        if (i2 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i2);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 8) {
            arrayRowCreateRow.addError(this, i);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        if (solverVariable.definitionId != -1 || i != 0) {
            addEquality(solverVariable, solverVariable2, i, 8);
            return;
        }
        if (solverVariable2.isSynonym) {
            solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.synonym];
        }
        if (solverVariable.isSynonym) {
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.synonym];
        } else {
            solverVariable.setSynonym(this, solverVariable2, 0.0f);
        }
    }

    public final void cleanupRows() {
        int i;
        int i2 = 0;
        while (i2 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (arrayRow.isSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.variable;
                solverVariable.computedValue = arrayRow.constantValue;
                solverVariable.removeFromRow(arrayRow);
                int i3 = i2;
                while (true) {
                    i = this.mNumRows;
                    if (i3 >= i - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i4 = i3 + 1;
                    arrayRowArr[i3] = arrayRowArr[i4];
                    i3 = i4;
                }
                this.mRows[i - 1] = null;
                this.mNumRows = i - 1;
                i2--;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                } else {
                    this.mCache.arrayRowPool.release(arrayRow);
                }
            }
            i2++;
        }
    }

    public SolverVariable createErrorVariable(int i, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.f30id = i2;
        solverVariableAcquireSolverVariable.strength = i;
        this.mCache.mIndexedVariables[i2] = solverVariableAcquireSolverVariable;
        this.mGoal.addError(solverVariableAcquireSolverVariable);
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.f30id = i;
        this.mCache.mIndexedVariables[i] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i = solverVariable.f30id;
            if (i == -1 || i > this.mVariablesID || this.mCache.mIndexedVariables[i] == null) {
                if (i != -1) {
                    solverVariable.reset();
                }
                int i2 = this.mVariablesID + 1;
                this.mVariablesID = i2;
                this.mNumColumns++;
                solverVariable.f30id = i2;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[i2] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRowAcquire;
        if (OPTIMIZED_ENGINE) {
            arrayRowAcquire = this.mCache.optimizedArrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        } else {
            arrayRowAcquire = this.mCache.arrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRowAcquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.f30id = i;
        this.mCache.mIndexedVariables[i] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String strB = outline.B(outline.U(" num vars "), this.mVariablesID, "\n");
        for (int i = 0; i < this.mVariablesID + 1; i++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
            if (solverVariable != null && solverVariable.isFinalValue) {
                strB = strB + " $[" + i + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String strW = outline.w(strB, "\n");
        for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
            SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
            SolverVariable solverVariable2 = solverVariableArr[i2];
            if (solverVariable2 != null && solverVariable2.isSynonym) {
                strW = strW + " ~[" + i2 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.synonym] + " + " + solverVariable2.synonymDelta + "\n";
            }
        }
        String strW2 = outline.w(strW, "\n\n #  ");
        for (int i3 = 0; i3 < this.mNumRows; i3++) {
            StringBuilder sbU = outline.U(strW2);
            sbU.append(this.mRows[i3].toReadableString());
            strW2 = outline.w(sbU.toString(), "\n #  ");
        }
        if (this.mGoal != null) {
            StringBuilder sbX = outline.X(strW2, "Goal: ");
            sbX.append(this.mGoal);
            sbX.append("\n");
            strW2 = sbX.toString();
        }
        System.out.println(strW2);
    }

    public void displaySystemInformations() {
        int iSizeInBytes = 0;
        for (int i = 0; i < this.TABLE_SIZE; i++) {
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i] != null) {
                iSizeInBytes = arrayRowArr[i].sizeInBytes() + iSizeInBytes;
            }
        }
        int iSizeInBytes2 = 0;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow[] arrayRowArr2 = this.mRows;
            if (arrayRowArr2[i2] != null) {
                iSizeInBytes2 = arrayRowArr2[i2].sizeInBytes() + iSizeInBytes2;
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sbU = outline.U("Linear System -> Table size: ");
        sbU.append(this.TABLE_SIZE);
        sbU.append(" (");
        int i3 = this.TABLE_SIZE;
        sbU.append(getDisplaySize(i3 * i3));
        sbU.append(") -- row sizes: ");
        sbU.append(getDisplaySize(iSizeInBytes));
        sbU.append(", actual size: ");
        sbU.append(getDisplaySize(iSizeInBytes2));
        sbU.append(" rows: ");
        sbU.append(this.mNumRows);
        sbU.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        sbU.append(this.mMaxRows);
        sbU.append(" cols: ");
        sbU.append(this.mNumColumns);
        sbU.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        sbU.append(this.mMaxColumns);
        sbU.append(" ");
        sbU.append(0);
        sbU.append(" occupied cells, ");
        sbU.append(getDisplaySize(0));
        printStream.println(sbU.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String strW = "";
        for (int i = 0; i < this.mNumRows; i++) {
            if (this.mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                StringBuilder sbU = outline.U(strW);
                sbU.append(this.mRows[i].toReadableString());
                strW = outline.w(sbU.toString(), "\n");
            }
        }
        StringBuilder sbU2 = outline.U(strW);
        sbU2.append(this.mGoal);
        sbU2.append("\n");
        System.out.println(sbU2.toString());
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int iSizeInBytes = 0;
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i] != null) {
                iSizeInBytes = arrayRowArr[i].sizeInBytes() + iSizeInBytes;
            }
        }
        return iSizeInBytes;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public ArrayRow getRow(int i) {
        return this.mRows[i];
    }

    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= this.mNumRows) {
                z2 = true;
                break;
            } else if (!this.mRows[i].isSimpleDefinition) {
                break;
            } else {
                i++;
            }
        }
        if (!z2) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        computeValues();
    }

    public void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i;
        if (!arrayRow.isSimpleDefinition || (solverVariable = arrayRow.variable) == null) {
            return;
        }
        int i2 = solverVariable.definitionId;
        if (i2 != -1) {
            while (true) {
                i = this.mNumRows;
                if (i2 >= i - 1) {
                    break;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                int i3 = i2 + 1;
                SolverVariable solverVariable2 = arrayRowArr[i3].variable;
                if (solverVariable2.definitionId == i3) {
                    solverVariable2.definitionId = i2;
                }
                arrayRowArr[i2] = arrayRowArr[i3];
                i2 = i3;
            }
            this.mNumRows = i - 1;
        }
        SolverVariable solverVariable3 = arrayRow.variable;
        if (!solverVariable3.isFinalValue) {
            solverVariable3.setFinalValue(this, arrayRow.constantValue);
        }
        if (OPTIMIZED_ENGINE) {
            this.mCache.optimizedArrayRowPool.release(arrayRow);
        } else {
            this.mCache.arrayRowPool.release(arrayRow);
        }
    }

    public void reset() {
        Cache cache;
        int i = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i++;
        }
        cache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> map = this.mVariables;
        if (map != null) {
            map.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow[] arrayRowArr = this.mRows;
            if (arrayRowArr[i2] != null) {
                arrayRowArr[i2].used = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    public void addSingleError(ArrayRow arrayRow, int i, int i2) {
        arrayRow.addSingleError(createErrorVariable(i2, null), i);
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        if (USE_BASIC_SYNONYMS && solverVariable.definitionId == -1) {
            float f = i;
            solverVariable.setFinalValue(this, f);
            for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i2];
                if (solverVariable2 != null && solverVariable2.isSynonym && solverVariable2.synonym == solverVariable.f30id) {
                    solverVariable2.setFinalValue(this, solverVariable2.synonymDelta + f);
                }
            }
            return;
        }
        int i3 = solverVariable.definitionId;
        if (i3 != -1) {
            ArrayRow arrayRow = this.mRows[i3];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = i;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = i;
                return;
            } else {
                ArrayRow arrayRowCreateRow = createRow();
                arrayRowCreateRow.createRowEquals(solverVariable, i);
                addConstraint(arrayRowCreateRow);
                return;
            }
        }
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowDefinition(solverVariable, i);
        addConstraint(arrayRowCreateRow2);
    }
}
