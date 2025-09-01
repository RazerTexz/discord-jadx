package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.databinding.WidgetMemberVerificationSuccessBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: MemberVerificationSuccessDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetMemberVerificationSuccessBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationSuccessBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class MemberVerificationSuccessDialog3 extends FunctionReferenceImpl implements Function1<View, WidgetMemberVerificationSuccessBinding> {
    public static final MemberVerificationSuccessDialog3 INSTANCE = new MemberVerificationSuccessDialog3();

    public MemberVerificationSuccessDialog3() {
        super(1, WidgetMemberVerificationSuccessBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationSuccessBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMemberVerificationSuccessBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMemberVerificationSuccessBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.member_verification_confirm;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.member_verification_confirm);
        if (materialButton != null) {
            i = R.id.member_verification_guild_name;
            TextView textView = (TextView) view.findViewById(R.id.member_verification_guild_name);
            if (textView != null) {
                i = R.id.member_verification_success_card;
                CardView cardView = (CardView) view.findViewById(R.id.member_verification_success_card);
                if (cardView != null) {
                    return new WidgetMemberVerificationSuccessBinding((RelativeLayout) view, materialButton, textView, cardView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
