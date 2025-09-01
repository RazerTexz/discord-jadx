package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildTransferOwnershipBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsTransferOwnership.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildTransferOwnershipBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildTransferOwnershipBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsTransferOwnership3 extends FunctionReferenceImpl implements Function1<View, WidgetGuildTransferOwnershipBinding> {
    public static final WidgetServerSettingsTransferOwnership3 INSTANCE = new WidgetServerSettingsTransferOwnership3();

    public WidgetServerSettingsTransferOwnership3() {
        super(1, WidgetGuildTransferOwnershipBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildTransferOwnershipBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildTransferOwnershipBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildTransferOwnershipBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_transfer_ownership_acknowledge_check;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.guild_transfer_ownership_acknowledge_check);
        if (checkedSetting != null) {
            i = R.id.guild_transfer_ownership_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_transfer_ownership_cancel);
            if (materialButton != null) {
                i = R.id.guild_transfer_ownership_confirm;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.guild_transfer_ownership_confirm);
                if (materialButton2 != null) {
                    i = R.id.guild_transfer_ownership_mfa_code;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_transfer_ownership_mfa_code);
                    if (textInputLayout != null) {
                        i = R.id.guild_transfer_ownership_mfa_wrap;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.guild_transfer_ownership_mfa_wrap);
                        if (linearLayout != null) {
                            return new WidgetGuildTransferOwnershipBinding((LinearLayout) view, checkedSetting, materialButton, materialButton2, textInputLayout, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
