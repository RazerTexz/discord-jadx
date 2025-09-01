package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            int i4 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i2 = i4;
            i3 = 2;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e A[PHI: r14 r15
      0x003e: PHI (r14v3 boolean) = (r14v1 boolean), (r14v30 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x003e: PHI (r15v3 boolean) = (r15v1 boolean), (r15v37 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[PHI: r14 r15
      0x0040: PHI (r14v28 boolean) = (r14v1 boolean), (r14v30 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
      0x0040: PHI (r15v35 boolean) = (r15v1 boolean), (r15v37 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016a  */
    /* JADX WARN: Type inference failed for: r2v56, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        ConstraintWidget constraintWidget;
        int i4;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget3;
        float f;
        int size;
        ArrayList<ConstraintWidget> arrayList;
        boolean z5;
        boolean z6;
        boolean z7;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i5;
        ConstraintWidget constraintWidget6 = chainHead.mFirst;
        ConstraintWidget constraintWidget7 = chainHead.mLast;
        ConstraintWidget constraintWidget8 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget9 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        boolean z8 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            int i6 = constraintWidget10.mHorizontalChainStyle;
            z2 = i6 == 0;
            z3 = i6 == 1;
            z4 = i6 == 2;
        } else {
            int i7 = constraintWidget10.mVerticalChainStyle;
            z2 = i7 == 0;
            z3 = i7 == 1;
            if (i7 == 2) {
            }
        }
        ?? r7 = constraintWidget6;
        boolean z9 = false;
        while (true) {
            if (z9) {
                break;
            }
            ConstraintAnchor constraintAnchor3 = r7.mListAnchors[i2];
            int i8 = z4 ? 1 : 4;
            int margin = constraintAnchor3.getMargin();
            float f3 = f2;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = r7.mListDimensionBehaviors[i];
            boolean z10 = z9;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && r7.mResolvedMatchConstraintDefault[i] == 0) {
                z5 = z3;
                z6 = true;
            } else {
                z5 = z3;
                z6 = false;
            }
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && r7 != constraintWidget6) {
                margin = constraintAnchor4.getMargin() + margin;
            }
            int i9 = margin;
            if (!z4 || r7 == constraintWidget6 || r7 == constraintWidget8) {
                z7 = z2;
            } else {
                z7 = z2;
                i8 = 8;
            }
            ConstraintAnchor constraintAnchor5 = constraintAnchor3.mTarget;
            if (constraintAnchor5 != null) {
                if (r7 == constraintWidget8) {
                    constraintWidget4 = constraintWidget10;
                    constraintWidget5 = constraintWidget6;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor5.mSolverVariable, i9, 6);
                } else {
                    constraintWidget4 = constraintWidget10;
                    constraintWidget5 = constraintWidget6;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor5.mSolverVariable, i9, 8);
                }
                linearSystem.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i9, (!z6 || z4) ? i8 : 5);
            } else {
                constraintWidget4 = constraintWidget10;
                constraintWidget5 = constraintWidget6;
            }
            if (z8) {
                if (r7.getVisibility() == 8 || r7.mListDimensionBehaviors[i] != dimensionBehaviour2) {
                    i5 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = r7.mListAnchors;
                    i5 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r7.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i5, 8);
            }
            ConstraintAnchor constraintAnchor6 = r7.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor6 != null) {
                ?? r2 = constraintAnchor6.mOwner;
                ConstraintAnchor[] constraintAnchorArr2 = r2.mListAnchors;
                if (constraintAnchorArr2[i2].mTarget != null && constraintAnchorArr2[i2].mTarget.mOwner == r7) {
                    solverVariable = r2;
                }
            }
            if (solverVariable != null) {
                r7 = solverVariable;
                z9 = z10;
            } else {
                z9 = true;
            }
            z2 = z7;
            f2 = f3;
            z3 = z5;
            constraintWidget10 = constraintWidget4;
            constraintWidget6 = constraintWidget5;
            r7 = r7;
        }
        ConstraintWidget constraintWidget11 = constraintWidget10;
        float f4 = f2;
        ConstraintWidget constraintWidget12 = constraintWidget6;
        boolean z11 = z2;
        boolean z12 = z3;
        if (constraintWidget9 != null) {
            int i10 = i2 + 1;
            if (constraintWidget7.mListAnchors[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor7 = constraintWidget9.mListAnchors[i10];
                if ((constraintWidget9.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget9.mResolvedMatchConstraintDefault[i] == 0) && !z4) {
                    ConstraintAnchor constraintAnchor8 = constraintAnchor7.mTarget;
                    if (constraintAnchor8.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor7.mSolverVariable, constraintAnchor8.mSolverVariable, -constraintAnchor7.getMargin(), 5);
                    }
                    linearSystem.addLowerThan(constraintAnchor7.mSolverVariable, constraintWidget7.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor7.getMargin(), 6);
                } else {
                    if (z4) {
                        ConstraintAnchor constraintAnchor9 = constraintAnchor7.mTarget;
                        if (constraintAnchor9.mOwner == constraintWidgetContainer) {
                            linearSystem.addEquality(constraintAnchor7.mSolverVariable, constraintAnchor9.mSolverVariable, -constraintAnchor7.getMargin(), 4);
                        }
                    }
                    linearSystem.addLowerThan(constraintAnchor7.mSolverVariable, constraintWidget7.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor7.getMargin(), 6);
                }
            }
        }
        if (z8) {
            int i11 = i2 + 1;
            SolverVariable solverVariable5 = constraintWidgetContainer.mListAnchors[i11].mSolverVariable;
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget7.mListAnchors;
            linearSystem.addGreaterThan(solverVariable5, constraintAnchorArr3[i11].mSolverVariable, constraintAnchorArr3[i11].getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
            float f5 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f4 : chainHead.mWidgetsMatchCount;
            float f6 = 0.0f;
            ConstraintWidget constraintWidget13 = null;
            int i12 = 0;
            float f7 = 0.0f;
            while (i12 < size) {
                ConstraintWidget constraintWidget14 = arrayList2.get(i12);
                float f8 = constraintWidget14.mWeight[i];
                if (f8 < f6) {
                    if (chainHead.mHasComplexMatchWeights) {
                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget14.mListAnchors;
                        linearSystem.addEquality(constraintAnchorArr4[i2 + 1].mSolverVariable, constraintAnchorArr4[i2].mSolverVariable, 0, 4);
                        arrayList = arrayList2;
                        i12++;
                        arrayList2 = arrayList;
                        f6 = 0.0f;
                    } else {
                        f8 = 1.0f;
                    }
                }
                if (f8 == f6) {
                    ConstraintAnchor[] constraintAnchorArr5 = constraintWidget14.mListAnchors;
                    linearSystem.addEquality(constraintAnchorArr5[i2 + 1].mSolverVariable, constraintAnchorArr5[i2].mSolverVariable, 0, 8);
                    arrayList = arrayList2;
                    i12++;
                    arrayList2 = arrayList;
                    f6 = 0.0f;
                } else {
                    if (constraintWidget13 != null) {
                        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget13.mListAnchors;
                        SolverVariable solverVariable6 = constraintAnchorArr6[i2].mSolverVariable;
                        int i13 = i2 + 1;
                        SolverVariable solverVariable7 = constraintAnchorArr6[i13].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr7 = constraintWidget14.mListAnchors;
                        SolverVariable solverVariable8 = constraintAnchorArr7[i2].mSolverVariable;
                        SolverVariable solverVariable9 = constraintAnchorArr7[i13].mSolverVariable;
                        arrayList = arrayList2;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f7, f5, f8, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    } else {
                        arrayList = arrayList2;
                    }
                    constraintWidget13 = constraintWidget14;
                    f7 = f8;
                    i12++;
                    arrayList2 = arrayList;
                    f6 = 0.0f;
                }
            }
        }
        if (constraintWidget8 != null && (constraintWidget8 == constraintWidget9 || z4)) {
            ConstraintAnchor constraintAnchor10 = constraintWidget12.mListAnchors[i2];
            int i14 = i2 + 1;
            ConstraintAnchor constraintAnchor11 = constraintWidget7.mListAnchors[i14];
            ConstraintAnchor constraintAnchor12 = constraintAnchor10.mTarget;
            SolverVariable solverVariable10 = constraintAnchor12 != null ? constraintAnchor12.mSolverVariable : null;
            ConstraintAnchor constraintAnchor13 = constraintAnchor11.mTarget;
            SolverVariable solverVariable11 = constraintAnchor13 != null ? constraintAnchor13.mSolverVariable : null;
            ConstraintAnchor constraintAnchor14 = constraintWidget8.mListAnchors[i2];
            ConstraintAnchor constraintAnchor15 = constraintWidget9.mListAnchors[i14];
            if (solverVariable10 != null && solverVariable11 != null) {
                if (i == 0) {
                    f = constraintWidget11.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget11.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor14.mSolverVariable, solverVariable10, constraintAnchor14.getMargin(), f, solverVariable11, constraintAnchor15.mSolverVariable, constraintAnchor15.getMargin(), 7);
            }
        } else if (!z11 || constraintWidget8 == null) {
            int i15 = 8;
            if (z12 && constraintWidget8 != null) {
                int i16 = chainHead.mWidgetsMatchCount;
                boolean z13 = i16 > 0 && chainHead.mWidgetsCount == i16;
                ConstraintWidget constraintWidget15 = constraintWidget8;
                ConstraintWidget constraintWidget16 = constraintWidget15;
                while (constraintWidget15 != null) {
                    ConstraintWidget constraintWidget17 = constraintWidget15.mNextChainWidget[i];
                    while (constraintWidget17 != null && constraintWidget17.getVisibility() == i15) {
                        constraintWidget17 = constraintWidget17.mNextChainWidget[i];
                    }
                    if (constraintWidget15 == constraintWidget8 || constraintWidget15 == constraintWidget9 || constraintWidget17 == null) {
                        constraintWidget = constraintWidget16;
                        i4 = 8;
                    } else {
                        ConstraintWidget constraintWidget18 = constraintWidget17 == constraintWidget9 ? null : constraintWidget17;
                        ConstraintAnchor constraintAnchor16 = constraintWidget15.mListAnchors[i2];
                        SolverVariable solverVariable12 = constraintAnchor16.mSolverVariable;
                        ConstraintAnchor constraintAnchor17 = constraintAnchor16.mTarget;
                        if (constraintAnchor17 != null) {
                            SolverVariable solverVariable13 = constraintAnchor17.mSolverVariable;
                        }
                        int i17 = i2 + 1;
                        SolverVariable solverVariable14 = constraintWidget16.mListAnchors[i17].mSolverVariable;
                        int margin2 = constraintAnchor16.getMargin();
                        int margin3 = constraintWidget15.mListAnchors[i17].getMargin();
                        if (constraintWidget18 != null) {
                            constraintAnchor = constraintWidget18.mListAnchors[i2];
                            solverVariable = constraintAnchor.mSolverVariable;
                            ConstraintAnchor constraintAnchor18 = constraintAnchor.mTarget;
                            solverVariable2 = constraintAnchor18 != null ? constraintAnchor18.mSolverVariable : null;
                        } else {
                            constraintAnchor = constraintWidget9.mListAnchors[i2];
                            solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                            solverVariable2 = constraintWidget15.mListAnchors[i17].mSolverVariable;
                        }
                        int margin4 = constraintAnchor != null ? constraintAnchor.getMargin() + margin3 : margin3;
                        int margin5 = constraintWidget16.mListAnchors[i17].getMargin() + margin2;
                        int i18 = z13 ? 8 : 4;
                        if (solverVariable12 == null || solverVariable14 == null || solverVariable == null || solverVariable2 == null) {
                            constraintWidget2 = constraintWidget18;
                            constraintWidget = constraintWidget16;
                            i4 = 8;
                        } else {
                            constraintWidget2 = constraintWidget18;
                            int i19 = margin4;
                            constraintWidget = constraintWidget16;
                            i4 = 8;
                            linearSystem.addCentering(solverVariable12, solverVariable14, margin5, 0.5f, solverVariable, solverVariable2, i19, i18);
                        }
                        constraintWidget17 = constraintWidget2;
                    }
                    if (constraintWidget15.getVisibility() == i4) {
                        constraintWidget15 = constraintWidget;
                    }
                    constraintWidget16 = constraintWidget15;
                    i15 = 8;
                    constraintWidget15 = constraintWidget17;
                }
                ConstraintAnchor constraintAnchor19 = constraintWidget8.mListAnchors[i2];
                ConstraintAnchor constraintAnchor20 = constraintWidget12.mListAnchors[i2].mTarget;
                int i20 = i2 + 1;
                ConstraintAnchor constraintAnchor21 = constraintWidget9.mListAnchors[i20];
                ConstraintAnchor constraintAnchor22 = constraintWidget7.mListAnchors[i20].mTarget;
                if (constraintAnchor20 == null) {
                    i3 = 5;
                } else if (constraintWidget8 != constraintWidget9) {
                    i3 = 5;
                    linearSystem.addEquality(constraintAnchor19.mSolverVariable, constraintAnchor20.mSolverVariable, constraintAnchor19.getMargin(), 5);
                } else {
                    i3 = 5;
                    if (constraintAnchor22 != null) {
                        linearSystem.addCentering(constraintAnchor19.mSolverVariable, constraintAnchor20.mSolverVariable, constraintAnchor19.getMargin(), 0.5f, constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, constraintAnchor21.getMargin(), 5);
                    }
                }
                if (constraintAnchor22 != null && constraintWidget8 != constraintWidget9) {
                    linearSystem.addEquality(constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, -constraintAnchor21.getMargin(), i3);
                }
            }
        } else {
            int i21 = chainHead.mWidgetsMatchCount;
            boolean z14 = i21 > 0 && chainHead.mWidgetsCount == i21;
            ConstraintWidget constraintWidget19 = constraintWidget8;
            ConstraintWidget constraintWidget20 = constraintWidget19;
            while (constraintWidget19 != null) {
                ConstraintWidget constraintWidget21 = constraintWidget19.mNextChainWidget[i];
                while (constraintWidget21 != null && constraintWidget21.getVisibility() == 8) {
                    constraintWidget21 = constraintWidget21.mNextChainWidget[i];
                }
                if (constraintWidget21 != null || constraintWidget19 == constraintWidget9) {
                    ConstraintAnchor constraintAnchor23 = constraintWidget19.mListAnchors[i2];
                    SolverVariable solverVariable15 = constraintAnchor23.mSolverVariable;
                    ConstraintAnchor constraintAnchor24 = constraintAnchor23.mTarget;
                    SolverVariable solverVariable16 = constraintAnchor24 != null ? constraintAnchor24.mSolverVariable : null;
                    if (constraintWidget20 != constraintWidget19) {
                        solverVariable16 = constraintWidget20.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget19 == constraintWidget8 && constraintWidget20 == constraintWidget19) {
                        ConstraintAnchor[] constraintAnchorArr8 = constraintWidget12.mListAnchors;
                        solverVariable16 = constraintAnchorArr8[i2].mTarget != null ? constraintAnchorArr8[i2].mTarget.mSolverVariable : null;
                    }
                    int margin6 = constraintAnchor23.getMargin();
                    int i22 = i2 + 1;
                    int margin7 = constraintWidget19.mListAnchors[i22].getMargin();
                    if (constraintWidget21 != null) {
                        constraintAnchor2 = constraintWidget21.mListAnchors[i2];
                        SolverVariable solverVariable17 = constraintAnchor2.mSolverVariable;
                        solverVariable4 = constraintWidget19.mListAnchors[i22].mSolverVariable;
                        solverVariable3 = solverVariable17;
                    } else {
                        constraintAnchor2 = constraintWidget7.mListAnchors[i22].mTarget;
                        solverVariable3 = constraintAnchor2 != null ? constraintAnchor2.mSolverVariable : null;
                        solverVariable4 = constraintWidget19.mListAnchors[i22].mSolverVariable;
                    }
                    if (constraintAnchor2 != null) {
                        margin7 += constraintAnchor2.getMargin();
                    }
                    if (constraintWidget20 != null) {
                        margin6 += constraintWidget20.mListAnchors[i22].getMargin();
                    }
                    if (solverVariable15 == null || solverVariable16 == null || solverVariable3 == null || solverVariable4 == null) {
                        constraintWidget3 = constraintWidget21;
                    } else {
                        if (constraintWidget19 == constraintWidget8) {
                            margin6 = constraintWidget8.mListAnchors[i2].getMargin();
                        }
                        int i23 = margin6;
                        constraintWidget3 = constraintWidget21;
                        linearSystem.addCentering(solverVariable15, solverVariable16, i23, 0.5f, solverVariable3, solverVariable4, constraintWidget19 == constraintWidget9 ? constraintWidget9.mListAnchors[i22].getMargin() : margin7, z14 ? 8 : 5);
                    }
                }
                if (constraintWidget19.getVisibility() != 8) {
                    constraintWidget20 = constraintWidget19;
                }
                constraintWidget19 = constraintWidget3;
            }
        }
        if ((!z11 && !z12) || constraintWidget8 == null || constraintWidget8 == constraintWidget9) {
            return;
        }
        ConstraintAnchor[] constraintAnchorArr9 = constraintWidget8.mListAnchors;
        ConstraintAnchor constraintAnchor25 = constraintAnchorArr9[i2];
        int i24 = i2 + 1;
        ConstraintAnchor constraintAnchor26 = constraintWidget9.mListAnchors[i24];
        ConstraintAnchor constraintAnchor27 = constraintAnchor25.mTarget;
        SolverVariable solverVariable18 = constraintAnchor27 != null ? constraintAnchor27.mSolverVariable : null;
        ConstraintAnchor constraintAnchor28 = constraintAnchor26.mTarget;
        SolverVariable solverVariable19 = constraintAnchor28 != null ? constraintAnchor28.mSolverVariable : null;
        if (constraintWidget7 != constraintWidget9) {
            ConstraintAnchor constraintAnchor29 = constraintWidget7.mListAnchors[i24].mTarget;
            solverVariable19 = constraintAnchor29 != null ? constraintAnchor29.mSolverVariable : null;
        }
        if (constraintWidget8 == constraintWidget9) {
            constraintAnchor25 = constraintAnchorArr9[i2];
            constraintAnchor26 = constraintAnchorArr9[i24];
        }
        if (solverVariable18 == null || solverVariable19 == null) {
            return;
        }
        linearSystem.addCentering(constraintAnchor25.mSolverVariable, solverVariable18, constraintAnchor25.getMargin(), 0.5f, solverVariable19, constraintAnchor26.mSolverVariable, constraintWidget9.mListAnchors[i24].getMargin(), 5);
    }
}
