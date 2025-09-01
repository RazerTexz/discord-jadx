package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.ViewAddPermissionOwnerBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AddPermissionOwnerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001d\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\u000eB'\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/channels/permissions/AddPermissionOwnerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/util/AttributeSet;", "attrs", "", "initialize", "(Landroid/util/AttributeSet;)V", "Lcom/discord/databinding/ViewAddPermissionOwnerBinding;", "binding", "Lcom/discord/databinding/ViewAddPermissionOwnerBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AddPermissionOwnerView extends ConstraintLayout {
    private final ViewAddPermissionOwnerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPermissionOwnerView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewAddPermissionOwnerBinding viewAddPermissionOwnerBindingA = ViewAddPermissionOwnerBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewAddPermissionOwnerBindingA, "ViewAddPermissionOwnerBi…ater.from(context), this)");
        this.binding = viewAddPermissionOwnerBindingA;
    }

    private final void initialize(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.AddPermissionOwnerView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ermissionOwnerView, 0, 0)");
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            TextView textView = this.binding.f2170b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.label");
            textView.setText(string);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPermissionOwnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewAddPermissionOwnerBinding viewAddPermissionOwnerBindingA = ViewAddPermissionOwnerBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewAddPermissionOwnerBindingA, "ViewAddPermissionOwnerBi…ater.from(context), this)");
        this.binding = viewAddPermissionOwnerBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ AddPermissionOwnerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPermissionOwnerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewAddPermissionOwnerBinding viewAddPermissionOwnerBindingA = ViewAddPermissionOwnerBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewAddPermissionOwnerBindingA, "ViewAddPermissionOwnerBi…ater.from(context), this)");
        this.binding = viewAddPermissionOwnerBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ AddPermissionOwnerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
