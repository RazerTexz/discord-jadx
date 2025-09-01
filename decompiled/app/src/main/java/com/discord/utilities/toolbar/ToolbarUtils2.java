package com.discord.utilities.toolbar;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.discord.utilities.dimen.DimenUtils;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ToolbarUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/appcompat/widget/Toolbar;", "Landroid/view/View;", "getNavigationIconView", "(Landroidx/appcompat/widget/Toolbar;)Landroid/view/View;", "view", "", "positionUnreadCountView", "(Landroidx/appcompat/widget/Toolbar;Landroid/view/View;)V", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.toolbar.ToolbarUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ToolbarUtils2 {
    public static final View getNavigationIconView(Toolbar toolbar) {
        Intrinsics3.checkNotNullParameter(toolbar, "$this$getNavigationIconView");
        CharSequence navigationContentDescription = toolbar.getNavigationContentDescription();
        boolean z2 = false;
        if (navigationContentDescription != null) {
            if (navigationContentDescription.length() > 0) {
                z2 = true;
            }
        }
        String navigationContentDescription2 = z2 ? toolbar.getNavigationContentDescription() : "navigationIcon";
        toolbar.setNavigationContentDescription(navigationContentDescription2);
        ArrayList<View> arrayList = new ArrayList<>();
        toolbar.findViewsWithText(arrayList, navigationContentDescription2, 2);
        if (!z2) {
            toolbar.setNavigationContentDescription((CharSequence) null);
        }
        return (View) _Collections.firstOrNull((List) arrayList);
    }

    public static final void positionUnreadCountView(Toolbar toolbar, View view) {
        Intrinsics3.checkNotNullParameter(toolbar, "$this$positionUnreadCountView");
        Intrinsics3.checkNotNullParameter(view, "view");
        View navigationIconView = getNavigationIconView(toolbar);
        if (navigationIconView != null) {
            if (!ViewCompat.isLaidOut(navigationIconView) || navigationIconView.isLayoutRequested()) {
                navigationIconView.addOnLayoutChangeListener(new ToolbarUtilsKt$positionUnreadCountView$$inlined$doOnLayout$1(view));
                return;
            }
            int iDpToPixels = DimenUtils.dpToPixels(2);
            int right = navigationIconView.getRight();
            int bottom = navigationIconView.getBottom();
            float f = 2;
            float f2 = iDpToPixels;
            view.setX((right / f) + f2);
            view.setY((bottom / f) + f2);
        }
    }
}
