package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetMemberVerificationPendingDialogBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: MemberVerificationPendingDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetMemberVerificationPendingDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationPendingDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class MemberVerificationPendingDialog3 extends FunctionReferenceImpl implements Function1<View, WidgetMemberVerificationPendingDialogBinding> {
    public static final MemberVerificationPendingDialog3 INSTANCE = new MemberVerificationPendingDialog3();

    public MemberVerificationPendingDialog3() {
        super(1, WidgetMemberVerificationPendingDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationPendingDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMemberVerificationPendingDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMemberVerificationPendingDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.member_verification_pending_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.member_verification_pending_img);
        if (imageView != null) {
            i = R.id.member_verification_primary_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.member_verification_primary_btn);
            if (materialButton != null) {
                i = R.id.member_verification_secondary_btn;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.member_verification_secondary_btn);
                if (materialButton2 != null) {
                    i = R.id.member_verification_tertiary_btn;
                    TextView textView = (TextView) view.findViewById(R.id.member_verification_tertiary_btn);
                    if (textView != null) {
                        i = R.id.pending_dialog_desc;
                        TextView textView2 = (TextView) view.findViewById(R.id.pending_dialog_desc);
                        if (textView2 != null) {
                            i = R.id.pending_dialog_title;
                            TextView textView3 = (TextView) view.findViewById(R.id.pending_dialog_title);
                            if (textView3 != null) {
                                return new WidgetMemberVerificationPendingDialogBinding((RelativeLayout) view, imageView, materialButton, materialButton2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
