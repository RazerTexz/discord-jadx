package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ViewUtils {
    public static final Property<View, Rect> CLIP_BOUNDS;
    private static final ViewUtilsBase IMPL;
    private static final String TAG = "ViewUtils";
    public static final Property<View, Float> TRANSITION_ALPHA;

    /* renamed from: androidx.transition.ViewUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends Property<View, Float> {
        public AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(View view) {
            return get2(view);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Float f) {
            set2(view, f);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(View view) {
            return Float.valueOf(ViewUtils.getTransitionAlpha(view));
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, Float f) {
            ViewUtils.setTransitionAlpha(view, f.floatValue());
        }
    }

    /* renamed from: androidx.transition.ViewUtils$2, reason: invalid class name */
    public static class AnonymousClass2 extends Property<View, Rect> {
        public AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Rect get(View view) {
            return get2(view);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Rect rect) {
            set2(view, rect);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Rect get2(View view) {
            return ViewCompat.getClipBounds(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, Rect rect) {
            ViewCompat.setClipBounds(view, rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            IMPL = new ViewUtilsApi29();
        } else if (i >= 23) {
            IMPL = new ViewUtilsApi23();
        } else if (i >= 22) {
            IMPL = new ViewUtilsApi22();
        } else {
            IMPL = new ViewUtilsApi21();
        }
        TRANSITION_ALPHA = new AnonymousClass1(Float.class, "translationAlpha");
        CLIP_BOUNDS = new AnonymousClass2(Rect.class, "clipBounds");
    }

    private ViewUtils() {
    }

    public static void clearNonTransitionAlpha(@NonNull View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    public static ViewOverlayImpl getOverlay(@NonNull View view) {
        return new ViewOverlayApi18(view);
    }

    public static float getTransitionAlpha(@NonNull View view) {
        return IMPL.getTransitionAlpha(view);
    }

    public static WindowIdImpl getWindowId(@NonNull View view) {
        return new WindowIdApi18(view);
    }

    public static void saveNonTransitionAlpha(@NonNull View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    public static void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    public static void setLeftTopRightBottom(@NonNull View view, int i, int i2, int i3, int i4) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    public static void setTransitionAlpha(@NonNull View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    public static void setTransitionVisibility(@NonNull View view, int i) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        IMPL.setTransitionVisibility(view, i);
    }

    public static void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    public static void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }
}
