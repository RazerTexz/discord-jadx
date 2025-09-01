package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroup;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.ViewCreatorMonetizationAcceptTermsStepCardBinding;
import d0.LazyJVM;
import d0.f0._Sequences2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AcceptTermsStepCard.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/AcceptTermsStepCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "onFinishInflate", "()V", "", "imageSrcRes", "I", "descriptionStringRes", "", "termsUrl", "Ljava/lang/String;", "stepNumber", "titleStringRes", "Lcom/discord/databinding/ViewCreatorMonetizationAcceptTermsStepCardBinding;", "binding$delegate", "Lkotlin/Lazy;", "getBinding", "()Lcom/discord/databinding/ViewCreatorMonetizationAcceptTermsStepCardBinding;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AcceptTermsStepCard extends ConstraintLayout {

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;

    @StringRes
    private int descriptionStringRes;

    @DrawableRes
    private int imageSrcRes;
    private int stepNumber;
    private String termsUrl;

    @StringRes
    private int titleStringRes;

    public AcceptTermsStepCard(Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ AcceptTermsStepCard(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final ViewCreatorMonetizationAcceptTermsStepCardBinding getBinding() {
        return (ViewCreatorMonetizationAcceptTermsStepCardBinding) this.binding.getValue();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        List<View> list = _Sequences2.toList(ViewGroup.getChildren(this));
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stepNumber");
        textView.setText(String.valueOf(this.stepNumber));
        getBinding().c.setImageResource(this.imageSrcRes);
        TextView textView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.title");
        FormatUtils.n(textView2, this.titleStringRes, new Object[0], null, 4);
        if (this.termsUrl != null) {
            TextView textView3 = getBinding().f2184b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.description");
            FormatUtils.n(textView3, this.descriptionStringRes, new Object[]{this.termsUrl}, null, 4);
        } else {
            TextView textView4 = getBinding().f2184b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.description");
            FormatUtils.n(textView4, this.descriptionStringRes, new Object[0], null, 4);
        }
        TextView textView5 = getBinding().f2184b;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.description");
        int id2 = textView5.getId();
        for (View view : list) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(view.getLayoutParams());
            ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
            layoutParams.topToBottom = id2;
            Space space = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(space, "binding.imagePadding");
            layoutParams.startToEnd = space.getId();
            layoutParams.endToEnd = 0;
            view.setLayoutParams(layoutParams);
            id2 = view.getId();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptTermsStepCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.binding = LazyJVM.lazy(new AcceptTermsStepCard2(this, context));
        int[] iArr = R.a.AcceptTermsStepCard;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.AcceptTermsStepCard");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        this.stepNumber = androidx.core.content.res.TypedArray.getIntOrThrow(typedArrayObtainStyledAttributes, 2);
        this.imageSrcRes = androidx.core.content.res.TypedArray.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 0);
        this.titleStringRes = androidx.core.content.res.TypedArray.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 3);
        this.descriptionStringRes = androidx.core.content.res.TypedArray.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 1);
        this.termsUrl = typedArrayObtainStyledAttributes.getString(4);
        typedArrayObtainStyledAttributes.recycle();
    }
}
