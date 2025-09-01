package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import b.d.b.a.outline;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    public static final String NAME = "KeyCycle";
    private static final String TAG = "KeyCycle";
    private String mTransitionEasing = null;
    private int mCurveFit = 0;
    private int mWaveShape = -1;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mProgress = Float.NaN;
    private int mWaveVariesBy = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    public static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
        }

        private Loader() {
        }

        public static /* synthetic */ void access$000(KeyCycle keyCycle, TypedArray typedArray) {
            read(keyCycle, typedArray);
        }

        private static void read(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            keyCycle.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyCycle.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyCycle.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            break;
                        }
                    case 2:
                        keyCycle.mFramePosition = typedArray.getInt(index, keyCycle.mFramePosition);
                        break;
                    case 3:
                        KeyCycle.access$102(keyCycle, typedArray.getString(index));
                        break;
                    case 4:
                        KeyCycle.access$202(keyCycle, typedArray.getInteger(index, KeyCycle.access$200(keyCycle)));
                        break;
                    case 5:
                        KeyCycle.access$302(keyCycle, typedArray.getInt(index, KeyCycle.access$300(keyCycle)));
                        break;
                    case 6:
                        KeyCycle.access$402(keyCycle, typedArray.getFloat(index, KeyCycle.access$400(keyCycle)));
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            KeyCycle.access$502(keyCycle, typedArray.getDimension(index, KeyCycle.access$500(keyCycle)));
                            break;
                        } else {
                            KeyCycle.access$502(keyCycle, typedArray.getFloat(index, KeyCycle.access$500(keyCycle)));
                            break;
                        }
                    case 8:
                        KeyCycle.access$602(keyCycle, typedArray.getInt(index, KeyCycle.access$600(keyCycle)));
                        break;
                    case 9:
                        KeyCycle.access$702(keyCycle, typedArray.getFloat(index, KeyCycle.access$700(keyCycle)));
                        break;
                    case 10:
                        KeyCycle.access$802(keyCycle, typedArray.getDimension(index, KeyCycle.access$800(keyCycle)));
                        break;
                    case 11:
                        KeyCycle.access$902(keyCycle, typedArray.getFloat(index, KeyCycle.access$900(keyCycle)));
                        break;
                    case 12:
                        KeyCycle.access$1002(keyCycle, typedArray.getFloat(index, KeyCycle.access$1000(keyCycle)));
                        break;
                    case 13:
                        KeyCycle.access$1102(keyCycle, typedArray.getFloat(index, KeyCycle.access$1100(keyCycle)));
                        break;
                    case 14:
                        KeyCycle.access$1202(keyCycle, typedArray.getFloat(index, KeyCycle.access$1200(keyCycle)));
                        break;
                    case 15:
                        KeyCycle.access$1302(keyCycle, typedArray.getFloat(index, KeyCycle.access$1300(keyCycle)));
                        break;
                    case 16:
                        KeyCycle.access$1402(keyCycle, typedArray.getFloat(index, KeyCycle.access$1400(keyCycle)));
                        break;
                    case 17:
                        KeyCycle.access$1502(keyCycle, typedArray.getDimension(index, KeyCycle.access$1500(keyCycle)));
                        break;
                    case 18:
                        KeyCycle.access$1602(keyCycle, typedArray.getDimension(index, KeyCycle.access$1600(keyCycle)));
                        break;
                    case 19:
                        KeyCycle.access$1702(keyCycle, typedArray.getDimension(index, KeyCycle.access$1700(keyCycle)));
                        break;
                    case 20:
                        KeyCycle.access$1802(keyCycle, typedArray.getFloat(index, KeyCycle.access$1800(keyCycle)));
                        break;
                    default:
                        StringBuilder sbU = outline.U("unused attribute 0x");
                        sbU.append(Integer.toHexString(index));
                        sbU.append("   ");
                        sbU.append(mAttrMap.get(index));
                        Log.e("KeyCycle", sbU.toString());
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new HashMap<>();
    }

    public static /* synthetic */ float access$1000(KeyCycle keyCycle) {
        return keyCycle.mRotationX;
    }

    public static /* synthetic */ float access$1002(KeyCycle keyCycle, float f) {
        keyCycle.mRotationX = f;
        return f;
    }

    public static /* synthetic */ String access$102(KeyCycle keyCycle, String str) {
        keyCycle.mTransitionEasing = str;
        return str;
    }

    public static /* synthetic */ float access$1100(KeyCycle keyCycle) {
        return keyCycle.mRotationY;
    }

    public static /* synthetic */ float access$1102(KeyCycle keyCycle, float f) {
        keyCycle.mRotationY = f;
        return f;
    }

    public static /* synthetic */ float access$1200(KeyCycle keyCycle) {
        return keyCycle.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1202(KeyCycle keyCycle, float f) {
        keyCycle.mTransitionPathRotate = f;
        return f;
    }

    public static /* synthetic */ float access$1300(KeyCycle keyCycle) {
        return keyCycle.mScaleX;
    }

    public static /* synthetic */ float access$1302(KeyCycle keyCycle, float f) {
        keyCycle.mScaleX = f;
        return f;
    }

    public static /* synthetic */ float access$1400(KeyCycle keyCycle) {
        return keyCycle.mScaleY;
    }

    public static /* synthetic */ float access$1402(KeyCycle keyCycle, float f) {
        keyCycle.mScaleY = f;
        return f;
    }

    public static /* synthetic */ float access$1500(KeyCycle keyCycle) {
        return keyCycle.mTranslationX;
    }

    public static /* synthetic */ float access$1502(KeyCycle keyCycle, float f) {
        keyCycle.mTranslationX = f;
        return f;
    }

    public static /* synthetic */ float access$1600(KeyCycle keyCycle) {
        return keyCycle.mTranslationY;
    }

    public static /* synthetic */ float access$1602(KeyCycle keyCycle, float f) {
        keyCycle.mTranslationY = f;
        return f;
    }

    public static /* synthetic */ float access$1700(KeyCycle keyCycle) {
        return keyCycle.mTranslationZ;
    }

    public static /* synthetic */ float access$1702(KeyCycle keyCycle, float f) {
        keyCycle.mTranslationZ = f;
        return f;
    }

    public static /* synthetic */ float access$1800(KeyCycle keyCycle) {
        return keyCycle.mProgress;
    }

    public static /* synthetic */ float access$1802(KeyCycle keyCycle, float f) {
        keyCycle.mProgress = f;
        return f;
    }

    public static /* synthetic */ int access$200(KeyCycle keyCycle) {
        return keyCycle.mCurveFit;
    }

    public static /* synthetic */ int access$202(KeyCycle keyCycle, int i) {
        keyCycle.mCurveFit = i;
        return i;
    }

    public static /* synthetic */ int access$300(KeyCycle keyCycle) {
        return keyCycle.mWaveShape;
    }

    public static /* synthetic */ int access$302(KeyCycle keyCycle, int i) {
        keyCycle.mWaveShape = i;
        return i;
    }

    public static /* synthetic */ float access$400(KeyCycle keyCycle) {
        return keyCycle.mWavePeriod;
    }

    public static /* synthetic */ float access$402(KeyCycle keyCycle, float f) {
        keyCycle.mWavePeriod = f;
        return f;
    }

    public static /* synthetic */ float access$500(KeyCycle keyCycle) {
        return keyCycle.mWaveOffset;
    }

    public static /* synthetic */ float access$502(KeyCycle keyCycle, float f) {
        keyCycle.mWaveOffset = f;
        return f;
    }

    public static /* synthetic */ int access$600(KeyCycle keyCycle) {
        return keyCycle.mWaveVariesBy;
    }

    public static /* synthetic */ int access$602(KeyCycle keyCycle, int i) {
        keyCycle.mWaveVariesBy = i;
        return i;
    }

    public static /* synthetic */ float access$700(KeyCycle keyCycle) {
        return keyCycle.mAlpha;
    }

    public static /* synthetic */ float access$702(KeyCycle keyCycle, float f) {
        keyCycle.mAlpha = f;
        return f;
    }

    public static /* synthetic */ float access$800(KeyCycle keyCycle) {
        return keyCycle.mElevation;
    }

    public static /* synthetic */ float access$802(KeyCycle keyCycle, float f) {
        keyCycle.mElevation = f;
        return f;
    }

    public static /* synthetic */ float access$900(KeyCycle keyCycle) {
        return keyCycle.mRotation;
    }

    public static /* synthetic */ float access$902(KeyCycle keyCycle, float f) {
        keyCycle.mRotation = f;
        return f;
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> map) {
        for (String str : map.keySet()) {
            if (str.startsWith(Key.CUSTOM)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    map.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value)) {
                    map.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> map) {
        SplineSet splineSet;
        StringBuilder sbU = outline.U("add ");
        sbU.append(map.size());
        sbU.append(" values");
        Debug.logStack("KeyCycle", sbU.toString(), 2);
        for (String str : map.keySet()) {
            splineSet = map.get(str);
            str.hashCode();
            str.hashCode();
            switch (str) {
                case "rotationX":
                    splineSet.setPoint(this.mFramePosition, this.mRotationX);
                    break;
                case "rotationY":
                    splineSet.setPoint(this.mFramePosition, this.mRotationY);
                    break;
                case "translationX":
                    splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                    break;
                case "translationY":
                    splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                    break;
                case "translationZ":
                    splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                    break;
                case "progress":
                    splineSet.setPoint(this.mFramePosition, this.mProgress);
                    break;
                case "scaleX":
                    splineSet.setPoint(this.mFramePosition, this.mScaleX);
                    break;
                case "scaleY":
                    splineSet.setPoint(this.mFramePosition, this.mScaleY);
                    break;
                case "rotation":
                    splineSet.setPoint(this.mFramePosition, this.mRotation);
                    break;
                case "elevation":
                    splineSet.setPoint(this.mFramePosition, this.mElevation);
                    break;
                case "transitionPathRotate":
                    splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                    break;
                case "alpha":
                    splineSet.setPoint(this.mFramePosition, this.mAlpha);
                    break;
                case "waveOffset":
                    splineSet.setPoint(this.mFramePosition, this.mWaveOffset);
                    break;
                default:
                    Log.v("KeyCycle", "WARNING KeyCycle UNKNOWN  " + str);
                    break;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add(Key.ALPHA);
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add(Key.ELEVATION);
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add(Key.ROTATION_X);
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add(Key.ROTATION_Y);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(Key.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add(Key.SCALE_Y);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add(Key.TRANSITION_PATH_ROTATE);
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add(Key.TRANSLATION_X);
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add(Key.TRANSLATION_Y);
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add(Key.TRANSLATION_Z);
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public float getValue(String str) {
        str.hashCode();
        switch (str) {
            case "rotationX":
                return this.mRotationX;
            case "rotationY":
                return this.mRotationY;
            case "translationX":
                return this.mTranslationX;
            case "translationY":
                return this.mTranslationY;
            case "translationZ":
                return this.mTranslationZ;
            case "progress":
                return this.mProgress;
            case "scaleX":
                return this.mScaleX;
            case "scaleY":
                return this.mScaleY;
            case "rotation":
                return this.mRotation;
            case "elevation":
                return this.mElevation;
            case "transitionPathRotate":
                return this.mTransitionPathRotate;
            case "alpha":
                return this.mAlpha;
            case "waveOffset":
                return this.mWaveOffset;
            default:
                Log.v("KeyCycle", "WARNING! KeyCycle UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.access$000(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "transitionEasing":
                this.mTransitionEasing = obj.toString();
                break;
            case "rotationX":
                this.mRotationX = toFloat(obj);
                break;
            case "rotationY":
                this.mRotationY = toFloat(obj);
                break;
            case "translationX":
                this.mTranslationX = toFloat(obj);
                break;
            case "translationY":
                this.mTranslationY = toFloat(obj);
                break;
            case "progress":
                this.mProgress = toFloat(obj);
                break;
            case "scaleX":
                this.mScaleX = toFloat(obj);
                break;
            case "scaleY":
                this.mScaleY = toFloat(obj);
                break;
            case "rotation":
                this.mRotation = toFloat(obj);
                break;
            case "elevation":
                this.mElevation = toFloat(obj);
                break;
            case "transitionPathRotate":
                this.mTransitionPathRotate = toFloat(obj);
                break;
            case "alpha":
                this.mAlpha = toFloat(obj);
                break;
            case "waveOffset":
                this.mWaveOffset = toFloat(obj);
                break;
            case "wavePeriod":
                this.mWavePeriod = toFloat(obj);
                break;
            case "curveFit":
                this.mCurveFit = toInt(obj);
                break;
            case "mTranslationZ":
                this.mTranslationZ = toFloat(obj);
                break;
        }
    }
}
