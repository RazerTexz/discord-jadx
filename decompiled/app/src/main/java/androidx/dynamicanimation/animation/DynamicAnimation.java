package androidx.dynamicanimation.animation;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {

    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;

    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;

    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;

    @SuppressLint({"MinMaxConstant"})
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    private static final float UNSET = Float.MAX_VALUE;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    public float mMaxValue;
    public float mMinValue;
    private float mMinVisibleChange;
    public final FloatPropertyCompat mProperty;
    public boolean mRunning;
    public boolean mStartValueIsSet;
    public final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    public float mValue;
    public float mVelocity;
    public static final ViewProperty TRANSLATION_X = new AnonymousClass1(Key.TRANSLATION_X);
    public static final ViewProperty TRANSLATION_Y = new AnonymousClass2(Key.TRANSLATION_Y);
    public static final ViewProperty TRANSLATION_Z = new AnonymousClass3(Key.TRANSLATION_Z);
    public static final ViewProperty SCALE_X = new AnonymousClass4(Key.SCALE_X);
    public static final ViewProperty SCALE_Y = new AnonymousClass5(Key.SCALE_Y);
    public static final ViewProperty ROTATION = new AnonymousClass6(Key.ROTATION);
    public static final ViewProperty ROTATION_X = new AnonymousClass7(Key.ROTATION_X);
    public static final ViewProperty ROTATION_Y = new AnonymousClass8(Key.ROTATION_Y);
    public static final ViewProperty X = new AnonymousClass9("x");
    public static final ViewProperty Y = new AnonymousClass10("y");
    public static final ViewProperty Z = new AnonymousClass11("z");
    public static final ViewProperty ALPHA = new AnonymousClass12(Key.ALPHA);
    public static final ViewProperty SCROLL_X = new AnonymousClass13("scrollX");
    public static final ViewProperty SCROLL_Y = new AnonymousClass14("scrollY");

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$1, reason: invalid class name */
    public static class AnonymousClass1 extends ViewProperty {
        public AnonymousClass1(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getTranslationX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setTranslationX(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$10, reason: invalid class name */
    public static class AnonymousClass10 extends ViewProperty {
        public AnonymousClass10(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$11, reason: invalid class name */
    public static class AnonymousClass11 extends ViewProperty {
        public AnonymousClass11(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return ViewCompat.getZ(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            ViewCompat.setZ(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$12, reason: invalid class name */
    public static class AnonymousClass12 extends ViewProperty {
        public AnonymousClass12(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getAlpha();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setAlpha(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$13, reason: invalid class name */
    public static class AnonymousClass13 extends ViewProperty {
        public AnonymousClass13(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScrollX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScrollX((int) f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$14, reason: invalid class name */
    public static class AnonymousClass14 extends ViewProperty {
        public AnonymousClass14(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScrollY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScrollY((int) f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$15, reason: invalid class name */
    public class AnonymousClass15 extends FloatPropertyCompat {
        public final /* synthetic */ FloatValueHolder val$floatValueHolder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass15(String str, FloatValueHolder floatValueHolder) {
            super(str);
            this.val$floatValueHolder = floatValueHolder;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(Object obj) {
            return this.val$floatValueHolder.getValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(Object obj, float f) {
            this.val$floatValueHolder.setValue(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$2, reason: invalid class name */
    public static class AnonymousClass2 extends ViewProperty {
        public AnonymousClass2(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getTranslationY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setTranslationY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$3, reason: invalid class name */
    public static class AnonymousClass3 extends ViewProperty {
        public AnonymousClass3(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            ViewCompat.setTranslationZ(view, f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$4, reason: invalid class name */
    public static class AnonymousClass4 extends ViewProperty {
        public AnonymousClass4(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScaleX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScaleX(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$5, reason: invalid class name */
    public static class AnonymousClass5 extends ViewProperty {
        public AnonymousClass5(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getScaleY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setScaleY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$6, reason: invalid class name */
    public static class AnonymousClass6 extends ViewProperty {
        public AnonymousClass6(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getRotation();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setRotation(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$7, reason: invalid class name */
    public static class AnonymousClass7 extends ViewProperty {
        public AnonymousClass7(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getRotationX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setRotationX(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$8, reason: invalid class name */
    public static class AnonymousClass8 extends ViewProperty {
        public AnonymousClass8(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getRotationY();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setRotationY(f);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.DynamicAnimation$9, reason: invalid class name */
    public static class AnonymousClass9 extends ViewProperty {
        public AnonymousClass9(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(View view) {
            return getValue2(view);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(View view, float f) {
            setValue2(view, f);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(View view) {
            return view.getX();
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(View view, float f) {
            view.setX(f);
        }
    }

    public static class MassState {
        public float mValue;
        public float mVelocity;
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f, float f2);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        public /* synthetic */ ViewProperty(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private ViewProperty(String str) {
            super(str);
        }
    }

    public DynamicAnimation(FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new AnonymousClass15("FloatValueHolder", floatValueHolder);
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean z2) {
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0L;
        this.mStartValueIsSet = false;
        for (int i = 0; i < this.mEndListeners.size(); i++) {
            if (this.mEndListeners.get(i) != null) {
                this.mEndListeners.get(i).onAnimationEnd(this, z2, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t) {
        int iIndexOf = arrayList.indexOf(t);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (this.mRunning) {
            return;
        }
        this.mRunning = true;
        if (!this.mStartValueIsSet) {
            this.mValue = getPropertyValue();
        }
        float f = this.mValue;
        if (f > this.mMaxValue || f < this.mMinValue) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        AnimationHandler.getInstance().addAnimationFrameCallback(this, 0L);
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (isRunning()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
            this.mUpdateListeners.add(onAnimationUpdateListener);
        }
        return this;
    }

    @MainThread
    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.mRunning) {
            endAnimationInternal(true);
        }
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean doAnimationFrame(long j) {
        long j2 = this.mLastFrameTime;
        if (j2 == 0) {
            this.mLastFrameTime = j;
            setPropertyValue(this.mValue);
            return false;
        }
        this.mLastFrameTime = j;
        boolean zUpdateValueAndVelocity = updateValueAndVelocity(j - j2);
        float fMin = Math.min(this.mValue, this.mMaxValue);
        this.mValue = fMin;
        float fMax = Math.max(fMin, this.mMinValue);
        this.mValue = fMax;
        setPropertyValue(fMax);
        if (zUpdateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return zUpdateValueAndVelocity;
    }

    public abstract float getAcceleration(float f, float f2);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    public abstract boolean isAtEquilibrium(float f, float f2);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f) {
        this.mMaxValue = f;
        return this;
    }

    public T setMinValue(float f) {
        this.mMinValue = f;
        return this;
    }

    public T setMinimumVisibleChange(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.mMinVisibleChange = f;
        setValueThreshold(f * 0.75f);
        return this;
    }

    public void setPropertyValue(float f) {
        this.mProperty.setValue(this.mTarget, f);
        for (int i = 0; i < this.mUpdateListeners.size(); i++) {
            if (this.mUpdateListeners.get(i) != null) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float f) {
        this.mValue = f;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f) {
        this.mVelocity = f;
        return this;
    }

    public abstract void setValueThreshold(float f);

    @MainThread
    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.mRunning) {
            return;
        }
        startAnimationInternal();
    }

    public abstract boolean updateValueAndVelocity(long j);

    public <K> DynamicAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = k;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat != ROTATION && floatPropertyCompat != ROTATION_X && floatPropertyCompat != ROTATION_Y) {
            if (floatPropertyCompat == ALPHA) {
                this.mMinVisibleChange = 0.00390625f;
                return;
            } else if (floatPropertyCompat != SCALE_X && floatPropertyCompat != SCALE_Y) {
                this.mMinVisibleChange = 1.0f;
                return;
            } else {
                this.mMinVisibleChange = 0.00390625f;
                return;
            }
        }
        this.mMinVisibleChange = 0.1f;
    }
}
