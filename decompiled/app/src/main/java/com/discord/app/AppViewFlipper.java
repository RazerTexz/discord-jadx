package com.discord.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewFlipper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroup;
import com.discord.R;
import com.discord.app.AppScrollingViewBehavior;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: AppViewFlipper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/discord/app/AppViewFlipper;", "Landroid/widget/ViewFlipper;", "", "onAttachedToWindow", "()V", "", "whichChild", "setDisplayedChild", "(I)V", "onFinishInflate", "j", "I", "previewedChildIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AppViewFlipper extends ViewFlipper {

    /* renamed from: j, reason: from kotlin metadata */
    public int previewedChildIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        ViewExtensions.setForwardingWindowInsetsListener(this);
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.AppViewFlipper, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.AppViewFlipper, 0, 0)");
        try {
            this.previewedChildIndex = typedArrayObtainStyledAttributes.getInt(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof CoordinatorLayout) {
            Iterator<View> it = ViewGroup.getChildren(this).iterator();
            while (it.hasNext()) {
                ViewCompat.setOnApplyWindowInsetsListener(it.next(), new AppScrollingViewBehavior.a());
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            setDisplayedChild(this.previewedChildIndex);
        }
    }

    @Override // android.widget.ViewAnimator
    public void setDisplayedChild(int whichChild) {
        if (getDisplayedChild() != whichChild) {
            super.setDisplayedChild(whichChild);
        }
    }
}
