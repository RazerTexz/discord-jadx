package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ViewGroupUtilsApi14 {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final String TAG = "ViewGroupUtilsApi14";
    private static Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static LayoutTransition sEmptyLayoutTransition;
    private static Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    /* renamed from: androidx.transition.ViewGroupUtilsApi14$1, reason: invalid class name */
    public static class AnonymousClass1 extends LayoutTransition {
        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    private ViewGroupUtilsApi14() {
    }

    private static void cancelLayoutTransition(LayoutTransition layoutTransition) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!sCancelMethodFetched) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                sCancelMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i(TAG, "Failed to access cancel method by reflection");
            }
            sCancelMethodFetched = true;
        }
        Method method = sCancelMethod;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i(TAG, "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i(TAG, "Failed to invoke cancel method by reflection");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z2) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        LayoutTransition layoutTransition;
        boolean z3 = false;
        if (sEmptyLayoutTransition == null) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            sEmptyLayoutTransition = anonymousClass1;
            anonymousClass1.setAnimator(2, null);
            sEmptyLayoutTransition.setAnimator(0, null);
            sEmptyLayoutTransition.setAnimator(1, null);
            sEmptyLayoutTransition.setAnimator(3, null);
            sEmptyLayoutTransition.setAnimator(4, null);
        }
        if (z2) {
            LayoutTransition layoutTransition2 = viewGroup.getLayoutTransition();
            if (layoutTransition2 != null) {
                if (layoutTransition2.isRunning()) {
                    cancelLayoutTransition(layoutTransition2);
                }
                if (layoutTransition2 != sEmptyLayoutTransition) {
                    viewGroup.setTag(R.id.transition_layout_save, layoutTransition2);
                }
            }
            viewGroup.setLayoutTransition(sEmptyLayoutTransition);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!sLayoutSuppressedFieldFetched) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                sLayoutSuppressedField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(TAG, "Failed to access mLayoutSuppressed field by reflection");
            }
            sLayoutSuppressedFieldFetched = true;
        }
        Field field = sLayoutSuppressedField;
        if (field != null) {
            try {
                boolean z4 = field.getBoolean(viewGroup);
                if (z4) {
                    try {
                        sLayoutSuppressedField.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z3 = z4;
                        Log.i(TAG, "Failed to get mLayoutSuppressed field by reflection");
                        if (z3) {
                        }
                        int i = R.id.transition_layout_save;
                        layoutTransition = (LayoutTransition) viewGroup.getTag(i);
                        if (layoutTransition == null) {
                        }
                    }
                }
                z3 = z4;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z3) {
            viewGroup.requestLayout();
        }
        int i2 = R.id.transition_layout_save;
        layoutTransition = (LayoutTransition) viewGroup.getTag(i2);
        if (layoutTransition == null) {
            viewGroup.setTag(i2, null);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }
}
