package com.discord.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.discord.utilities.display.DisplayUtils;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: AppScrollingNestedViewBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/discord/app/AppScrollingNestedViewBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$ScrollingViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "Landroid/view/View;", "child", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AppScrollingNestedViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppScrollingNestedViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View child, WindowInsetsCompat insets) {
        Intrinsics3.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics3.checkNotNullParameter(child, "child");
        Intrinsics3.checkNotNullParameter(insets, "insets");
        ViewCompat.setOnApplyWindowInsetsListener(child, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER().onApplyWindowInsets(child, insets);
        Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "NO_OP_WINDOW_INSETS_LIST…ndowInsets(child, insets)");
        return windowInsetsCompatOnApplyWindowInsets;
    }
}
