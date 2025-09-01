package com.discord.utilities.dimmer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DimmerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/dimmer/DimmerView;", "Landroid/widget/RelativeLayout;", "", "dimmed", "showProgressBar", "", "setDimmed", "(ZZ)V", "Landroid/widget/ProgressBar;", "dimmerProgressBar", "Landroid/widget/ProgressBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DimmerView extends RelativeLayout {
    private final ProgressBar dimmerProgressBar;

    public DimmerView(Context context) {
        this(context, null, 0, 6, null);
    }

    public DimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DimmerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void setDimmed$default(DimmerView dimmerView, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z3 = true;
        }
        dimmerView.setDimmed(z2, z3);
    }

    public final void setDimmed(boolean z2) {
        setDimmed$default(this, z2, false, 2, null);
    }

    public final void setDimmed(boolean dimmed, boolean showProgressBar) {
        DimmerView dimmerView;
        if (dimmed) {
            dimmerView = this;
            ViewExtensions.fadeIn$default(dimmerView, 0L, null, null, null, 15, null);
        } else {
            ViewExtensions.fadeOut$default(this, 0L, null, null, 7, null);
            dimmerView = this;
        }
        dimmerView.dimmerProgressBar.setVisibility((dimmed && showProgressBar) ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DimmerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ProgressBar progressBar = new ProgressBar(context);
        this.dimmerProgressBar = progressBar;
        progressBar.setVisibility(8);
        addView(progressBar);
    }
}
