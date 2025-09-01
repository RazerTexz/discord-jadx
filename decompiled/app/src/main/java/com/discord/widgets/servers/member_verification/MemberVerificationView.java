package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.databinding.ViewMemberVerificationBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MemberVerificationView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J;\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationView;", "Landroidx/cardview/widget/CardView;", "", "verificationImageIcon", "verificationTitleText", "", "isVerified", "Lkotlin/Function0;", "", "verificationCallback", "configure", "(IIZLkotlin/jvm/functions/Function0;)V", "Lcom/discord/databinding/ViewMemberVerificationBinding;", "binding", "Lcom/discord/databinding/ViewMemberVerificationBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MemberVerificationView extends CardView {
    private final ViewMemberVerificationBinding binding;

    /* compiled from: MemberVerificationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationView$configure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $verificationCallback;

        public AnonymousClass1(Function0 function0) {
            this.$verificationCallback = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.$verificationCallback;
            if (function0 != null) {
            }
        }
    }

    public MemberVerificationView(Context context) {
        this(context, null, 0, 6, null);
    }

    public MemberVerificationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MemberVerificationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configure$default(MemberVerificationView memberVerificationView, int i, int i2, boolean z2, Function0 function0, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        memberVerificationView.configure(i, i2, z2, function0);
    }

    public final void configure(@DrawableRes int verificationImageIcon, @StringRes int verificationTitleText, boolean isVerified, Function0<Unit> verificationCallback) {
        this.binding.d.setImageResource(verificationImageIcon);
        this.binding.e.setText(verificationTitleText);
        this.binding.c.setOnClickListener(new AnonymousClass1(verificationCallback));
        TextView textView = this.binding.f2201b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationVerifiedCheck");
        textView.setVisibility(isVerified ? 0 : 8);
        MaterialButton materialButton = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.memberVerificationVerifyButton");
        materialButton.setVisibility(isVerified ^ true ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_member_verification, this);
        int i2 = R.id.member_verification_verified_check;
        TextView textView = (TextView) findViewById(R.id.member_verification_verified_check);
        if (textView != null) {
            i2 = R.id.member_verification_verify_button;
            MaterialButton materialButton = (MaterialButton) findViewById(R.id.member_verification_verify_button);
            if (materialButton != null) {
                i2 = R.id.member_verification_verify_icon;
                ImageView imageView = (ImageView) findViewById(R.id.member_verification_verify_icon);
                if (imageView != null) {
                    i2 = R.id.member_verification_verify_text;
                    TextView textView2 = (TextView) findViewById(R.id.member_verification_verify_text);
                    if (textView2 != null) {
                        ViewMemberVerificationBinding viewMemberVerificationBinding = new ViewMemberVerificationBinding(this, textView, materialButton, imageView, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewMemberVerificationBinding, "ViewMemberVerificationBi…ater.from(context), this)");
                        this.binding = viewMemberVerificationBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
