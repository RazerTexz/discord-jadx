package com.discord.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.discord.utilities.display.DisplayUtils;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: AppScrollingViewBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/discord/app/AppScrollingViewBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$ScrollingViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "Landroid/view/View;", "child", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "Lcom/discord/app/AppScrollingViewBehavior$a;", "a", "Lcom/discord/app/AppScrollingViewBehavior$a;", "onApplyWindowInsetsListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AppScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

    /* renamed from: a, reason: from kotlin metadata */
    public final a onApplyWindowInsetsListener;

    /* compiled from: AppScrollingViewBehavior.kt */
    public static final class a implements OnApplyWindowInsetsListener {
        public Rect a;

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "v");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            if (this.a == null) {
                this.a = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
            }
            Rect rect = this.a;
            if (rect == null) {
                rect = new Rect();
            }
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft() + rect.left, rect.top, windowInsetsCompat.getSystemWindowInsetRight() + rect.right, windowInsetsCompat.getSystemWindowInsetTop() + windowInsetsCompat.getSystemWindowInsetBottom() + rect.bottom);
            return windowInsetsCompat;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.onApplyWindowInsetsListener = new a();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View child, WindowInsetsCompat insets) {
        Intrinsics3.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics3.checkNotNullParameter(child, "child");
        Intrinsics3.checkNotNullParameter(insets, "insets");
        ViewCompat.setOnApplyWindowInsetsListener(child, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        this.onApplyWindowInsetsListener.onApplyWindowInsets(child, insets);
        return insets;
    }
}
