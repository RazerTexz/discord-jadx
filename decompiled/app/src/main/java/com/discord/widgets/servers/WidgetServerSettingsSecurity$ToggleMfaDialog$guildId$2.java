package com.discord.widgets.servers;

import com.discord.widgets.servers.WidgetServerSettingsSecurity;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsSecurity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$ToggleMfaDialog$guildId$2 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetServerSettingsSecurity.ToggleMfaDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsSecurity$ToggleMfaDialog$guildId$2(WidgetServerSettingsSecurity.ToggleMfaDialog toggleMfaDialog) {
        super(0);
        this.this$0 = toggleMfaDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return WidgetServerSettingsSecurity.ToggleMfaDialog.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_GUILD_ID", -1L);
    }
}
