package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.Direct;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    public static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    public static int mycounter;
    private WeakReference<ConstraintAnchor> horizontalWrapMax;
    private WeakReference<ConstraintAnchor> horizontalWrapMin;
    public BasicMeasure mBasicMeasureSolver;
    public int mDebugSolverPassCount;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    public ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    public BasicMeasure.Measure mMeasure;
    public BasicMeasure.Measurer mMeasurer;
    public Metrics mMetrics;
    private int mOptimizationLevel;
    public int mPaddingBottom;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public boolean mSkipSolver;
    public LinearSystem mSystem;
    public ChainHead[] mVerticalChainsArray;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;
    private WeakReference<ConstraintAnchor> verticalWrapMax;
    private WeakReference<ConstraintAnchor> verticalWrapMin;

    public ConstraintWidgetContainer() {
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addMaxWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.mSystem.addGreaterThan(solverVariable, this.mSystem.createObjectVariable(constraintAnchor), 0, 5);
    }

    private void addMinWrap(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.mSystem.addGreaterThan(this.mSystem.createObjectVariable(constraintAnchor), solverVariable, 0, 5);
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    public void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        boolean zOptimizeFor = optimizeFor(64);
        addToSolver(linearSystem, zOptimizeFor);
        int size = this.mChildren.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.setInBarrier(0, false);
            constraintWidget.setInBarrier(1, false);
            if (constraintWidget instanceof Barrier) {
                z2 = true;
            }
        }
        if (z2) {
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget2 = this.mChildren.get(i2);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).markWidgets();
                }
            }
        }
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget3 = this.mChildren.get(i3);
            if (constraintWidget3.addFirst()) {
                constraintWidget3.addToSolver(linearSystem, zOptimizeFor);
            }
        }
        if (LinearSystem.USE_DEPENDENCY_ORDERING) {
            HashSet<ConstraintWidget> hashSet = new HashSet<>();
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget4 = this.mChildren.get(i4);
                if (!constraintWidget4.addFirst()) {
                    hashSet.add(constraintWidget4);
                }
            }
            addChildrenToSolverByDependency(this, linearSystem, hashSet, getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator<ConstraintWidget> it = hashSet.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                Optimizer.checkMatchParent(this, linearSystem, next);
                next.addToSolver(linearSystem, zOptimizeFor);
            }
        } else {
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget5 = this.mChildren.get(i5);
                if (constraintWidget5 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.mListDimensionBehaviors;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget5.addToSolver(linearSystem, zOptimizeFor);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.checkMatchParent(this, linearSystem, constraintWidget5);
                    if (!constraintWidget5.addFirst()) {
                        constraintWidget5.addToSolver(linearSystem, zOptimizeFor);
                    }
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, null, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, null, 1);
        }
        return true;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.horizontalWrapMax.get().getFinalValue()) {
            this.horizontalWrapMax = new WeakReference<>(constraintAnchor);
        }
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.horizontalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.horizontalWrapMin.get().getFinalValue()) {
            this.horizontalWrapMin = new WeakReference<>(constraintAnchor);
        }
    }

    public void addVerticalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMax;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.verticalWrapMax.get().getFinalValue()) {
            this.verticalWrapMax = new WeakReference<>(constraintAnchor);
        }
    }

    public void addVerticalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMin;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.verticalWrapMin.get().getFinalValue()) {
            this.verticalWrapMin = new WeakReference<>(constraintAnchor);
        }
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean z2) {
        return this.mDependencyGraph.directMeasure(z2);
    }

    public boolean directMeasureSetup(boolean z2) {
        return this.mDependencyGraph.directMeasureSetup(z2);
    }

    public boolean directMeasureWithOrientation(boolean z2, int i) {
        return this.mDependencyGraph.directMeasureWithOrientation(z2, i);
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0301 A[PHI: r0 r2
      0x0301: PHI (r0v20 boolean) = (r0v19 boolean), (r0v22 boolean), (r0v22 boolean), (r0v22 boolean) binds: [B:140:0x02c5, B:148:0x02e9, B:149:0x02eb, B:151:0x02f1] A[DONT_GENERATE, DONT_INLINE]
      0x0301: PHI (r2v13 boolean) = (r2v12 boolean), (r2v15 boolean), (r2v15 boolean), (r2v15 boolean) binds: [B:140:0x02c5, B:148:0x02e9, B:149:0x02eb, B:151:0x02f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layout() {
        int i;
        int i2;
        boolean z2;
        boolean z3;
        ?? r6;
        boolean z4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int size = this.mChildren.size();
        int iMax = Math.max(0, getWidth());
        int iMax2 = Math.max(0, getHeight());
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
        Metrics metrics = this.mMetrics;
        if (metrics != null) {
            metrics.layouts++;
        }
        if (Optimizer.enabled(this.mOptimizationLevel, 1)) {
            Direct.solvingPass(this, getMeasurer());
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i3);
                if (constraintWidget.isMeasureRequested() && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Barrier) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.isInVirtualLayout()) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidget.getDimensionBehaviour(0);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidget.getDimensionBehaviour(1);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (!(dimensionBehaviour4 == dimensionBehaviour6 && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour5 == dimensionBehaviour6 && constraintWidget.mMatchConstraintDefaultHeight != 1)) {
                        measure(constraintWidget, this.mMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                    }
                }
            }
        }
        if (size <= 2 || !((dimensionBehaviour3 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour2 == dimensionBehaviour) && Optimizer.enabled(this.mOptimizationLevel, 1024) && Grouping.simpleSolvingPass(this, getMeasurer()))) {
            i = iMax2;
            i2 = iMax;
            z2 = false;
        } else {
            if (dimensionBehaviour3 == dimensionBehaviour) {
                if (iMax >= getWidth() || iMax <= 0) {
                    iMax = getWidth();
                } else {
                    setWidth(iMax);
                    this.mWidthMeasuredTooSmall = true;
                }
            }
            if (dimensionBehaviour2 == dimensionBehaviour) {
                if (iMax2 >= getHeight() || iMax2 <= 0) {
                    iMax2 = getHeight();
                } else {
                    setHeight(iMax2);
                    this.mHeightMeasuredTooSmall = true;
                }
            }
            i = iMax2;
            i2 = iMax;
            z2 = true;
        }
        boolean z5 = optimizeFor(64) || optimizeFor(128);
        LinearSystem linearSystem = this.mSystem;
        linearSystem.graphOptimizer = false;
        linearSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel != 0 && z5) {
            linearSystem.newgraphOptimizer = true;
        }
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z6 = horizontalDimensionBehaviour == dimensionBehaviour7 || getVerticalDimensionBehaviour() == dimensionBehaviour7;
        resetChains();
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget2 = this.mChildren.get(i4);
            if (constraintWidget2 instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget2).layout();
            }
        }
        boolean zOptimizeFor = optimizeFor(64);
        boolean z7 = z2;
        int i5 = 0;
        boolean zAddChildrenToSolver = true;
        while (zAddChildrenToSolver) {
            int i6 = i5 + 1;
            try {
                this.mSystem.reset();
                resetChains();
                createObjectVariables(this.mSystem);
                for (int i7 = 0; i7 < size; i7++) {
                    this.mChildren.get(i7).createObjectVariables(this.mSystem);
                }
                zAddChildrenToSolver = addChildrenToSolver(this.mSystem);
                WeakReference<ConstraintAnchor> weakReference = this.verticalWrapMin;
                if (weakReference != null && weakReference.get() != null) {
                    addMinWrap(this.verticalWrapMin.get(), this.mSystem.createObjectVariable(this.mTop));
                    this.verticalWrapMin = null;
                }
                WeakReference<ConstraintAnchor> weakReference2 = this.verticalWrapMax;
                if (weakReference2 != null && weakReference2.get() != null) {
                    addMaxWrap(this.verticalWrapMax.get(), this.mSystem.createObjectVariable(this.mBottom));
                    this.verticalWrapMax = null;
                }
                WeakReference<ConstraintAnchor> weakReference3 = this.horizontalWrapMin;
                if (weakReference3 != null && weakReference3.get() != null) {
                    addMinWrap(this.horizontalWrapMin.get(), this.mSystem.createObjectVariable(this.mLeft));
                    this.horizontalWrapMin = null;
                }
                WeakReference<ConstraintAnchor> weakReference4 = this.horizontalWrapMax;
                if (weakReference4 != null && weakReference4.get() != null) {
                    addMaxWrap(this.horizontalWrapMax.get(), this.mSystem.createObjectVariable(this.mRight));
                    this.horizontalWrapMax = null;
                }
                if (zAddChildrenToSolver) {
                    this.mSystem.minimize();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("EXCEPTION : " + e);
            }
            if (zAddChildrenToSolver) {
                updateChildrenFromSolver(this.mSystem, Optimizer.flags);
            } else {
                updateFromSolver(this.mSystem, zOptimizeFor);
                for (int i8 = 0; i8 < size; i8++) {
                    this.mChildren.get(i8).updateFromSolver(this.mSystem, zOptimizeFor);
                }
            }
            if (z6 && i6 < 8 && Optimizer.flags[2]) {
                int iMax3 = 0;
                int iMax4 = 0;
                for (int i9 = 0; i9 < size; i9++) {
                    ConstraintWidget constraintWidget3 = this.mChildren.get(i9);
                    iMax3 = Math.max(iMax3, constraintWidget3.getWidth() + constraintWidget3.mX);
                    iMax4 = Math.max(iMax4, constraintWidget3.getHeight() + constraintWidget3.mY);
                }
                int iMax5 = Math.max(this.mMinWidth, iMax3);
                int iMax6 = Math.max(this.mMinHeight, iMax4);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour3 != dimensionBehaviour8 || getWidth() >= iMax5) {
                    z3 = false;
                } else {
                    setWidth(iMax5);
                    this.mListDimensionBehaviors[0] = dimensionBehaviour8;
                    z3 = true;
                    z7 = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour8 && getHeight() < iMax6) {
                    setHeight(iMax6);
                    this.mListDimensionBehaviors[1] = dimensionBehaviour8;
                    z3 = true;
                    z7 = true;
                }
            } else {
                z3 = false;
            }
            int iMax7 = Math.max(this.mMinWidth, getWidth());
            if (iMax7 > getWidth()) {
                setWidth(iMax7);
                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                z3 = true;
                z7 = true;
            }
            int iMax8 = Math.max(this.mMinHeight, getHeight());
            if (iMax8 > getHeight()) {
                setHeight(iMax8);
                r6 = 1;
                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z3 = true;
                z4 = true;
            } else {
                r6 = 1;
                z4 = z7;
            }
            if (!z4) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = this.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour9 == dimensionBehaviour10 && i2 > 0 && getWidth() > i2) {
                    this.mWidthMeasuredTooSmall = r6;
                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setWidth(i2);
                    z3 = true;
                    z4 = true;
                }
                if (this.mListDimensionBehaviors[r6] != dimensionBehaviour10 || i <= 0 || getHeight() <= i) {
                    zAddChildrenToSolver = z3;
                    z7 = z4;
                } else {
                    this.mHeightMeasuredTooSmall = r6;
                    this.mListDimensionBehaviors[r6] = ConstraintWidget.DimensionBehaviour.FIXED;
                    setHeight(i);
                    z7 = true;
                    zAddChildrenToSolver = true;
                }
            }
            i5 = i6;
        }
        this.mChildren = arrayList;
        if (z7) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
            dimensionBehaviourArr2[0] = dimensionBehaviour3;
            dimensionBehaviourArr2[1] = dimensionBehaviour2;
        }
        resetSolverVariables(this.mSystem.getCache());
    }

    public long measure(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.mPaddingLeft = i8;
        this.mPaddingTop = i9;
        return this.mBasicMeasureSolver.solverMeasure(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    public boolean optimizeFor(int i) {
        return (this.mOptimizationLevel & i) == i;
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z2) {
        this.mIsRtl = z2;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean zOptimizeFor = optimizeFor(64);
        updateFromSolver(linearSystem, zOptimizeFor);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).updateFromSolver(linearSystem, zOptimizeFor);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromRuns(boolean z2, boolean z3) {
        super.updateFromRuns(z2, z3);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).updateFromRuns(z2, z3);
        }
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }

    public static boolean measure(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i) {
        int i2;
        int i3;
        if (measurer == null) {
            return false;
        }
        measure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        measure.horizontalDimension = constraintWidget.getWidth();
        measure.verticalDimension = constraintWidget.getHeight();
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = dimensionBehaviour == dimensionBehaviour2;
        boolean z3 = measure.verticalBehavior == dimensionBehaviour2;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z5 = z3 && constraintWidget.mDimensionRatio > 0.0f;
        if (z2 && constraintWidget.hasDanglingDimension(0) && constraintWidget.mMatchConstraintDefaultWidth == 0 && !z4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z3 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z2 = false;
        }
        if (z3 && constraintWidget.hasDanglingDimension(1) && constraintWidget.mMatchConstraintDefaultHeight == 0 && !z5) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z2 && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z3 = false;
        }
        if (constraintWidget.isResolvedHorizontally()) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            z2 = false;
        }
        if (constraintWidget.isResolvedVertically()) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            z3 = false;
        }
        if (z4) {
            if (constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z3) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.verticalBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i3 = measure.verticalDimension;
                } else {
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i3 = measure.measuredHeight;
                }
                measure.horizontalBehavior = dimensionBehaviour4;
                int i4 = constraintWidget.mDimensionRatioSide;
                if (i4 != 0 && i4 != -1) {
                    measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() / i3);
                } else {
                    measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() * i3);
                }
            }
        }
        if (z5) {
            if (constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z2) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.horizontalBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i2 = measure.horizontalDimension;
                } else {
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i2 = measure.measuredWidth;
                }
                measure.verticalBehavior = dimensionBehaviour6;
                int i5 = constraintWidget.mDimensionRatioSide;
                if (i5 == 0 || i5 == -1) {
                    measure.verticalDimension = (int) (i2 / constraintWidget.getDimensionRatio());
                } else {
                    measure.verticalDimension = (int) (constraintWidget.getDimensionRatio() * i2);
                }
            }
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.setHasBaseline(measure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(measure.measuredBaseline);
        measure.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return measure.measuredNeedsSolverPass;
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(String str, int i, int i2) {
        super(i, i2);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
        setDebugName(str);
    }
}
