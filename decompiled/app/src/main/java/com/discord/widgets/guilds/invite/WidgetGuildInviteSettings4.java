package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.discord.R;
import com.discord.databinding.WidgetGuildInviteSettingsBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildInviteSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteSettings4 extends FunctionReferenceImpl implements Function1<View, WidgetGuildInviteSettingsBinding> {
    public static final WidgetGuildInviteSettings4 INSTANCE = new WidgetGuildInviteSettings4();

    public WidgetGuildInviteSettings4() {
        super(1, WidgetGuildInviteSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildInviteSettingsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildInviteSettingsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_invite_channel_spinner;
        Spinner spinner = (Spinner) view.findViewById(R.id.guild_invite_channel_spinner);
        if (spinner != null) {
            i = R.id.guild_invite_expires_after_radiogroup;
            RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.guild_invite_expires_after_radiogroup);
            if (radioGroup != null) {
                i = R.id.guild_invite_generate_link;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_invite_generate_link);
                if (materialButton != null) {
                    i = R.id.guild_invite_max_uses_radiogroup;
                    RadioGroup radioGroup2 = (RadioGroup) view.findViewById(R.id.guild_invite_max_uses_radiogroup);
                    if (radioGroup2 != null) {
                        i = R.id.guild_invite_temporary_membership;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.guild_invite_temporary_membership);
                        if (checkedSetting != null) {
                            return new WidgetGuildInviteSettingsBinding((LinearLayout) view, spinner, radioGroup, materialButton, radioGroup2, checkedSetting);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
