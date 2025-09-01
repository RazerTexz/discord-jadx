package com.discord.utilities.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.OnApplyWindowInsetsListener;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: DisplayUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\u0000H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0015\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u0015\u001a\u0015\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u0018\u001a\u0015\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001f\"\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroid/content/Context;", "context", "Landroid/graphics/Rect;", "in", "resizeToFitScreen", "(Landroid/content/Context;Landroid/graphics/Rect;)Landroid/graphics/Rect;", "bounds", "resizeToFit", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Rect;", "getScreenSize", "(Landroid/content/Context;)Landroid/graphics/Rect;", "", "getScreenRefreshRate", "(Landroid/content/Context;)F", "Landroid/view/Display;", "getDisplayCompat", "(Landroid/content/Context;)Landroid/view/Display;", "Landroid/content/res/Resources;", "resources", "", "getStatusBarHeight", "(Landroid/content/res/Resources;)I", "", "hasNavigationBar", "(Landroid/content/res/Resources;)Z", "getNavigationBarHeight", "isGestureNavigationEnabled", "Landroid/view/View;", "view", "", "drawUnderSystemBars", "(Landroid/view/View;)V", "Landroidx/core/view/OnApplyWindowInsetsListener;", "NO_OP_WINDOW_INSETS_LISTENER", "Landroidx/core/view/OnApplyWindowInsetsListener;", "getNO_OP_WINDOW_INSETS_LISTENER", "()Landroidx/core/view/OnApplyWindowInsetsListener;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DisplayUtils {
    private static final OnApplyWindowInsetsListener NO_OP_WINDOW_INSETS_LISTENER = DisplayUtils2.INSTANCE;

    public static final void drawUnderSystemBars(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.setFitsSystemWindows(true);
        view.setSystemUiVisibility(view.getSystemUiVisibility() | 1792);
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private static final Display getDisplayCompat(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            Display display = context.getDisplay();
            Intrinsics3.checkNotNull(display);
            Intrinsics3.checkNotNullExpressionValue(display, "display!!");
            return display;
        }
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics3.checkNotNullExpressionValue(defaultDisplay, "(getSystemService(Contex…owManager).defaultDisplay");
        return defaultDisplay;
    }

    public static final OnApplyWindowInsetsListener getNO_OP_WINDOW_INSETS_LISTENER() {
        return NO_OP_WINDOW_INSETS_LISTENER;
    }

    public static final int getNavigationBarHeight(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final float getScreenRefreshRate(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return getDisplayCompat(context).getRefreshRate();
    }

    public static final Rect getScreenSize(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        int i = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "context.resources");
        return new Rect(0, 0, i, resources2.getDisplayMetrics().heightPixels);
    }

    public static final int getStatusBarHeight(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final boolean hasNavigationBar(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        return identifier > 0 && resources.getBoolean(identifier);
    }

    public static final boolean isGestureNavigationEnabled(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        int identifier = resources.getIdentifier("config_navBarInteractionMode", "integer", "android");
        Integer numValueOf = identifier > 0 ? Integer.valueOf(resources.getInteger(identifier)) : null;
        return numValueOf != null && numValueOf.intValue() == 2;
    }

    public static final Rect resizeToFit(Rect rect, Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "in");
        Intrinsics3.checkNotNullParameter(rect2, "bounds");
        int iWidth = rect.width();
        int iHeight = rect.height();
        if (iWidth > rect2.width()) {
            iHeight = (int) ((rect2.width() / iWidth) * iHeight);
            iWidth = rect2.width();
        }
        if (iHeight > rect2.height()) {
            iWidth = (int) ((rect2.height() / iHeight) * iWidth);
            iHeight = rect2.height();
        }
        return new Rect(0, 0, iWidth, iHeight);
    }

    public static final Rect resizeToFitScreen(Context context, Rect rect) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(rect, "in");
        return resizeToFit(rect, getScreenSize(context));
    }
}
