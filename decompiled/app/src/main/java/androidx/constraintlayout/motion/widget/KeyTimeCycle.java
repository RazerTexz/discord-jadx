package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import b.d.b.a.outline;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    public static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;
    private int mWaveShape = 0;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static final int WAVE_OFFSET = 21;
        private static final int WAVE_PERIOD = 20;
        private static final int WAVE_SHAPE = 19;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            mAttrMap.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            mAttrMap.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            mAttrMap.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            mAttrMap.append(R.styleable.KeyTimeCycle_framePosition, 12);
            mAttrMap.append(R.styleable.KeyTimeCycle_curveFit, 13);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            mAttrMap.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            mAttrMap.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            mAttrMap.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            mAttrMap.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            mAttrMap.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        private Loader() {
        }

        public static void read(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        KeyTimeCycle.access$002(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$000(keyTimeCycle)));
                        break;
                    case 2:
                        KeyTimeCycle.access$102(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$100(keyTimeCycle)));
                        break;
                    case 3:
                    case 11:
                    default:
                        StringBuilder sbU = outline.U("unused attribute 0x");
                        sbU.append(Integer.toHexString(index));
                        sbU.append("   ");
                        sbU.append(mAttrMap.get(index));
                        Log.e("KeyTimeCycle", sbU.toString());
                        break;
                    case 4:
                        KeyTimeCycle.access$202(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$200(keyTimeCycle)));
                        break;
                    case 5:
                        KeyTimeCycle.access$802(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$800(keyTimeCycle)));
                        break;
                    case 6:
                        KeyTimeCycle.access$902(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$900(keyTimeCycle)));
                        break;
                    case 7:
                        KeyTimeCycle.access$702(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$700(keyTimeCycle)));
                        break;
                    case 8:
                        KeyTimeCycle.access$1202(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$1200(keyTimeCycle)));
                        break;
                    case 9:
                        KeyTimeCycle.access$1002(keyTimeCycle, typedArray.getString(index));
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                            keyTimeCycle.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyTimeCycle.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTimeCycle.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyTimeCycle.mTargetId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                            break;
                        }
                    case 12:
                        keyTimeCycle.mFramePosition = typedArray.getInt(index, keyTimeCycle.mFramePosition);
                        break;
                    case 13:
                        KeyTimeCycle.access$302(keyTimeCycle, typedArray.getInteger(index, KeyTimeCycle.access$300(keyTimeCycle)));
                        break;
                    case 14:
                        KeyTimeCycle.access$1102(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$1100(keyTimeCycle)));
                        break;
                    case 15:
                        KeyTimeCycle.access$1302(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$1300(keyTimeCycle)));
                        break;
                    case 16:
                        KeyTimeCycle.access$1402(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$1400(keyTimeCycle)));
                        break;
                    case 17:
                        KeyTimeCycle.access$1502(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$1500(keyTimeCycle)));
                        break;
                    case 18:
                        KeyTimeCycle.access$1602(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$1600(keyTimeCycle)));
                        break;
                    case 19:
                        KeyTimeCycle.access$402(keyTimeCycle, typedArray.getInt(index, KeyTimeCycle.access$400(keyTimeCycle)));
                        break;
                    case 20:
                        KeyTimeCycle.access$502(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$500(keyTimeCycle)));
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            KeyTimeCycle.access$602(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$600(keyTimeCycle)));
                            break;
                        } else {
                            KeyTimeCycle.access$602(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$600(keyTimeCycle)));
                            break;
                        }
                }
            }
        }
    }

    public KeyTimeCycle() {
        this.mType = 3;
        this.mCustomConstraints = new HashMap<>();
    }

    public static /* synthetic */ float access$000(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mAlpha;
    }

    public static /* synthetic */ float access$002(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mAlpha = f;
        return f;
    }

    public static /* synthetic */ float access$100(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mElevation;
    }

    public static /* synthetic */ String access$1002(KeyTimeCycle keyTimeCycle, String str) {
        keyTimeCycle.mTransitionEasing = str;
        return str;
    }

    public static /* synthetic */ float access$102(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mElevation = f;
        return f;
    }

    public static /* synthetic */ float access$1100(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mScaleY;
    }

    public static /* synthetic */ float access$1102(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mScaleY = f;
        return f;
    }

    public static /* synthetic */ float access$1200(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1202(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTransitionPathRotate = f;
        return f;
    }

    public static /* synthetic */ float access$1300(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationX;
    }

    public static /* synthetic */ float access$1302(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTranslationX = f;
        return f;
    }

    public static /* synthetic */ float access$1400(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationY;
    }

    public static /* synthetic */ float access$1402(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTranslationY = f;
        return f;
    }

    public static /* synthetic */ float access$1500(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationZ;
    }

    public static /* synthetic */ float access$1502(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTranslationZ = f;
        return f;
    }

    public static /* synthetic */ float access$1600(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mProgress;
    }

    public static /* synthetic */ float access$1602(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mProgress = f;
        return f;
    }

    public static /* synthetic */ float access$200(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotation;
    }

    public static /* synthetic */ float access$202(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mRotation = f;
        return f;
    }

    public static /* synthetic */ int access$300(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mCurveFit;
    }

    public static /* synthetic */ int access$302(KeyTimeCycle keyTimeCycle, int i) {
        keyTimeCycle.mCurveFit = i;
        return i;
    }

    public static /* synthetic */ int access$400(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWaveShape;
    }

    public static /* synthetic */ int access$402(KeyTimeCycle keyTimeCycle, int i) {
        keyTimeCycle.mWaveShape = i;
        return i;
    }

    public static /* synthetic */ float access$500(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWavePeriod;
    }

    public static /* synthetic */ float access$502(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mWavePeriod = f;
        return f;
    }

    public static /* synthetic */ float access$600(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWaveOffset;
    }

    public static /* synthetic */ float access$602(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mWaveOffset = f;
        return f;
    }

    public static /* synthetic */ float access$700(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mScaleX;
    }

    public static /* synthetic */ float access$702(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mScaleX = f;
        return f;
    }

    public static /* synthetic */ float access$800(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotationX;
    }

    public static /* synthetic */ float access$802(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mRotationX = f;
        return f;
    }

    public static /* synthetic */ float access$900(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotationY;
    }

    public static /* synthetic */ float access$902(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mRotationY = f;
        return f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addTimeValues(HashMap<String, TimeCycleSplineSet> map) {
        for (String str : map.keySet()) {
            TimeCycleSplineSet timeCycleSplineSet = map.get(str);
            char c = 7;
            if (!str.startsWith(Key.CUSTOM)) {
                switch (str.hashCode()) {
                    case -1249320806:
                        if (str.equals(Key.ROTATION_X)) {
                            c = 0;
                            break;
                        } else {
                            c = 65535;
                            break;
                        }
                    case -1249320805:
                        if (str.equals(Key.ROTATION_Y)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (str.equals(Key.TRANSLATION_X)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals(Key.TRANSLATION_Y)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals(Key.TRANSLATION_Z)) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals(Key.SCALE_X)) {
                            c = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (!str.equals(Key.SCALE_Y)) {
                        }
                        break;
                    case -40300674:
                        if (str.equals(Key.ROTATION)) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals(Key.ELEVATION)) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals(Key.ALPHA)) {
                            c = 11;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (Float.isNaN(this.mRotationX)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 1:
                        if (Float.isNaN(this.mRotationY)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 2:
                        if (Float.isNaN(this.mTranslationX)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 3:
                        if (Float.isNaN(this.mTranslationY)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 4:
                        if (Float.isNaN(this.mTranslationZ)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 5:
                        if (Float.isNaN(this.mProgress)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 6:
                        if (Float.isNaN(this.mScaleX)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 7:
                        if (Float.isNaN(this.mScaleY)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case '\b':
                        if (Float.isNaN(this.mRotation)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case '\t':
                        if (Float.isNaN(this.mElevation)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case '\n':
                        if (Float.isNaN(this.mTransitionPathRotate)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    case 11:
                        if (Float.isNaN(this.mAlpha)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                    default:
                        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                        break;
                }
            } else {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                if (constraintAttribute != null) {
                    ((TimeCycleSplineSet.CustomSet) timeCycleSplineSet).setPoint(this.mFramePosition, constraintAttribute, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> map) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
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
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add(Key.TRANSLATION_X);
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add(Key.TRANSLATION_Y);
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add(Key.TRANSLATION_Z);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add(Key.TRANSITION_PATH_ROTATE);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(Key.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add(Key.SCALE_Y);
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> map) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            map.put(Key.ALPHA, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            map.put(Key.ELEVATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            map.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            map.put(Key.ROTATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            map.put(Key.ROTATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            map.put(Key.TRANSLATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            map.put(Key.TRANSLATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            map.put(Key.TRANSLATION_Z, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            map.put(Key.TRANSITION_PATH_ROTATE, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            map.put(Key.SCALE_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            map.put(Key.SCALE_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            map.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                map.put(outline.w("CUSTOM,", it.next()), Integer.valueOf(this.mCurveFit));
            }
        }
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
            case "curveFit":
                this.mCurveFit = toInt(obj);
                break;
            case "mTranslationZ":
                this.mTranslationZ = toFloat(obj);
                break;
        }
    }
}
