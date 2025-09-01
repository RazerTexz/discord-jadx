package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.DialogGuiildRoleSubscriptionConfirmationBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class GuildRoleSubscriptionConfirmationDialog2 extends FunctionReferenceImpl implements Function1<View, DialogGuiildRoleSubscriptionConfirmationBinding> {
    public static final GuildRoleSubscriptionConfirmationDialog2 INSTANCE = new GuildRoleSubscriptionConfirmationDialog2();

    public GuildRoleSubscriptionConfirmationDialog2() {
        super(1, DialogGuiildRoleSubscriptionConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ DialogGuiildRoleSubscriptionConfirmationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DialogGuiildRoleSubscriptionConfirmationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.cancel);
        if (materialButton != null) {
            i = R.id.confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.confirm);
            if (materialButton2 != null) {
                i = R.id.guild_role_subscription_confirmation_subtitle;
                TextView textView = (TextView) view.findViewById(R.id.guild_role_subscription_confirmation_subtitle);
                if (textView != null) {
                    i = R.id.guild_role_subscription_confirmation_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.guild_role_subscription_confirmation_title);
                    if (textView2 != null) {
                        return new DialogGuiildRoleSubscriptionConfirmationBinding((LinearLayout) view, materialButton, materialButton2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
