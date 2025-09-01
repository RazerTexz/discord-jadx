package com.discord.widgets.servers.member_verification;

import android.os.Bundle;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: MemberVerificationPendingDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel;", "invoke", "()Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class MemberVerificationPendingDialog4 extends Lambda implements Function0<MemberVerificationPendingViewModel> {
    public final /* synthetic */ MemberVerificationPendingDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingDialog4(MemberVerificationPendingDialog memberVerificationPendingDialog) {
        super(0);
        this.this$0 = memberVerificationPendingDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MemberVerificationPendingViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MemberVerificationPendingViewModel invoke() {
        Bundle arguments = this.this$0.getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID)) : null;
        Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildId /* = kotlin.Long */");
        long jLongValue = lValueOf.longValue();
        Bundle arguments2 = this.this$0.getArguments();
        return new MemberVerificationPendingViewModel(jLongValue, (MemberVerificationPendingViewModel.DialogState) (arguments2 != null ? arguments2.getSerializable("INTENT_EXTRA_DIALOG_STATE") : null), null, null, 12, null);
    }
}
