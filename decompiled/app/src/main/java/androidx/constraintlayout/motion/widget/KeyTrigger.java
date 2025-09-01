package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import b.d.b.a.outline;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    public static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    public RectF mCollisionRect;
    private Method mFireCross;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private boolean mFireNegativeReset;
    private Method mFirePositiveCross;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    public RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    public float mTriggerSlack;
    private int mCurveFit = -1;
    private String mCross = null;

    public static class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        private Loader() {
        }

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        KeyTrigger.access$102(keyTrigger, typedArray.getString(index));
                        continue;
                    case 2:
                        KeyTrigger.access$202(keyTrigger, typedArray.getString(index));
                        continue;
                    case 4:
                        KeyTrigger.access$302(keyTrigger, typedArray.getString(index));
                        continue;
                    case 5:
                        keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                        continue;
                    case 6:
                        KeyTrigger.access$402(keyTrigger, typedArray.getResourceId(index, KeyTrigger.access$400(keyTrigger)));
                        continue;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            keyTrigger.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyTrigger.mTargetString = typedArray.getString(index);
                            } else {
                                continue;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTrigger.mTargetString = typedArray.getString(index);
                        } else {
                            keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.mFramePosition);
                        keyTrigger.mFramePosition = integer;
                        KeyTrigger.access$002(keyTrigger, (integer + 0.5f) / 100.0f);
                        continue;
                    case 9:
                        KeyTrigger.access$502(keyTrigger, typedArray.getResourceId(index, KeyTrigger.access$500(keyTrigger)));
                        continue;
                    case 10:
                        KeyTrigger.access$602(keyTrigger, typedArray.getBoolean(index, KeyTrigger.access$600(keyTrigger)));
                        continue;
                    case 11:
                        KeyTrigger.access$702(keyTrigger, typedArray.getResourceId(index, KeyTrigger.access$700(keyTrigger)));
                        break;
                }
                StringBuilder sbU = outline.U("unused attribute 0x");
                sbU.append(Integer.toHexString(index));
                sbU.append("   ");
                sbU.append(mAttrMap.get(index));
                Log.e("KeyTrigger", sbU.toString());
            }
        }
    }

    public KeyTrigger() {
        int i = Key.UNSET;
        this.mTriggerReceiver = i;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i;
        this.mTriggerCollisionId = i;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    public static /* synthetic */ float access$002(KeyTrigger keyTrigger, float f) {
        keyTrigger.mFireThreshold = f;
        return f;
    }

    public static /* synthetic */ String access$102(KeyTrigger keyTrigger, String str) {
        keyTrigger.mNegativeCross = str;
        return str;
    }

    public static /* synthetic */ String access$202(KeyTrigger keyTrigger, String str) {
        keyTrigger.mPositiveCross = str;
        return str;
    }

    public static /* synthetic */ String access$302(KeyTrigger keyTrigger, String str) {
        keyTrigger.mCross = str;
        return str;
    }

    public static /* synthetic */ int access$400(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerID;
    }

    public static /* synthetic */ int access$402(KeyTrigger keyTrigger, int i) {
        keyTrigger.mTriggerID = i;
        return i;
    }

    public static /* synthetic */ int access$500(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerCollisionId;
    }

    public static /* synthetic */ int access$502(KeyTrigger keyTrigger, int i) {
        keyTrigger.mTriggerCollisionId = i;
        return i;
    }

    public static /* synthetic */ boolean access$600(KeyTrigger keyTrigger) {
        return keyTrigger.mPostLayout;
    }

    public static /* synthetic */ boolean access$602(KeyTrigger keyTrigger, boolean z2) {
        keyTrigger.mPostLayout = z2;
        return z2;
    }

    public static /* synthetic */ int access$700(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerReceiver;
    }

    public static /* synthetic */ int access$702(KeyTrigger keyTrigger, int i) {
        keyTrigger.mTriggerReceiver = i;
        return i;
    }

    private void setUpRect(RectF rectF, View view, boolean z2) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z2) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> map) {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void conditionallyFire(float f, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = true;
        if (this.mTriggerCollisionId != Key.UNSET) {
            if (this.mTriggerCollisionView == null) {
                this.mTriggerCollisionView = ((ViewGroup) view.getParent()).findViewById(this.mTriggerCollisionId);
            }
            setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
            setUpRect(this.mTargetRect, view, this.mPostLayout);
            if (this.mCollisionRect.intersect(this.mTargetRect)) {
                if (this.mFireCrossReset) {
                    this.mFireCrossReset = false;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.mFirePositiveReset) {
                    this.mFirePositiveReset = false;
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.mFireNegativeReset = true;
                z4 = false;
            } else {
                if (this.mFireCrossReset) {
                    z2 = false;
                } else {
                    this.mFireCrossReset = true;
                    z2 = true;
                }
                if (this.mFireNegativeReset) {
                    this.mFireNegativeReset = false;
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.mFirePositiveReset = true;
                z4 = z6;
                z5 = false;
            }
        } else {
            if (this.mFireCrossReset) {
                float f2 = this.mFireThreshold;
                if ((this.mFireLastPos - f2) * (f - f2) < 0.0f) {
                    this.mFireCrossReset = false;
                    z2 = true;
                }
                if (!this.mFireNegativeReset) {
                    float f3 = this.mFireThreshold;
                    float f4 = f - f3;
                    if ((this.mFireLastPos - f3) * f4 < 0.0f && f4 < 0.0f) {
                        this.mFireNegativeReset = false;
                        z3 = true;
                    }
                    if (this.mFirePositiveReset) {
                        float f5 = this.mFireThreshold;
                        float f6 = f - f5;
                        if ((this.mFireLastPos - f5) * f6 >= 0.0f || f6 <= 0.0f) {
                            z7 = false;
                        } else {
                            this.mFirePositiveReset = false;
                        }
                        z5 = z7;
                        z4 = z3;
                    } else {
                        if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                            this.mFirePositiveReset = true;
                        }
                        z4 = z3;
                        z5 = false;
                    }
                } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                    this.mFireNegativeReset = true;
                }
                z3 = false;
                if (this.mFirePositiveReset) {
                }
            } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                this.mFireCrossReset = true;
            }
            z2 = false;
            if (!this.mFireNegativeReset) {
            }
            z3 = false;
            if (this.mFirePositiveReset) {
            }
        }
        this.mFireLastPos = f;
        if (z4 || z2 || z5) {
            ((MotionLayout) view.getParent()).fireTrigger(this.mTriggerID, z5, f);
        }
        if (this.mTriggerReceiver != Key.UNSET) {
            view = ((MotionLayout) view.getParent()).findViewById(this.mTriggerReceiver);
        }
        if (z4 && this.mNegativeCross != null) {
            if (this.mFireNegativeCross == null) {
                try {
                    this.mFireNegativeCross = view.getClass().getMethod(this.mNegativeCross, new Class[0]);
                } catch (NoSuchMethodException unused) {
                    StringBuilder sbU = outline.U("Could not find method \"");
                    sbU.append(this.mNegativeCross);
                    sbU.append("\"on class ");
                    sbU.append(view.getClass().getSimpleName());
                    sbU.append(" ");
                    sbU.append(Debug.getName(view));
                    Log.e("KeyTrigger", sbU.toString());
                }
            }
            try {
                this.mFireNegativeCross.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                StringBuilder sbU2 = outline.U("Exception in call \"");
                sbU2.append(this.mNegativeCross);
                sbU2.append("\"on class ");
                sbU2.append(view.getClass().getSimpleName());
                sbU2.append(" ");
                sbU2.append(Debug.getName(view));
                Log.e("KeyTrigger", sbU2.toString());
            }
        }
        if (z5 && this.mPositiveCross != null) {
            if (this.mFirePositiveCross == null) {
                try {
                    this.mFirePositiveCross = view.getClass().getMethod(this.mPositiveCross, new Class[0]);
                } catch (NoSuchMethodException unused3) {
                    StringBuilder sbU3 = outline.U("Could not find method \"");
                    sbU3.append(this.mPositiveCross);
                    sbU3.append("\"on class ");
                    sbU3.append(view.getClass().getSimpleName());
                    sbU3.append(" ");
                    sbU3.append(Debug.getName(view));
                    Log.e("KeyTrigger", sbU3.toString());
                }
            }
            try {
                this.mFirePositiveCross.invoke(view, new Object[0]);
            } catch (Exception unused4) {
                StringBuilder sbU4 = outline.U("Exception in call \"");
                sbU4.append(this.mPositiveCross);
                sbU4.append("\"on class ");
                sbU4.append(view.getClass().getSimpleName());
                sbU4.append(" ");
                sbU4.append(Debug.getName(view));
                Log.e("KeyTrigger", sbU4.toString());
            }
        }
        if (!z2 || this.mCross == null) {
            return;
        }
        if (this.mFireCross == null) {
            try {
                this.mFireCross = view.getClass().getMethod(this.mCross, new Class[0]);
            } catch (NoSuchMethodException unused5) {
                StringBuilder sbU5 = outline.U("Could not find method \"");
                sbU5.append(this.mCross);
                sbU5.append("\"on class ");
                sbU5.append(view.getClass().getSimpleName());
                sbU5.append(" ");
                sbU5.append(Debug.getName(view));
                Log.e("KeyTrigger", sbU5.toString());
            }
        }
        try {
            this.mFireCross.invoke(view, new Object[0]);
        } catch (Exception unused6) {
            StringBuilder sbU6 = outline.U("Exception in call \"");
            sbU6.append(this.mCross);
            sbU6.append("\"on class ");
            sbU6.append(view.getClass().getSimpleName());
            sbU6.append(" ");
            sbU6.append(Debug.getName(view));
            Log.e("KeyTrigger", sbU6.toString());
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
    }
}
