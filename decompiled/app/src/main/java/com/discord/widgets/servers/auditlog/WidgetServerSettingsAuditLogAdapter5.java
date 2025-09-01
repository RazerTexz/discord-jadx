package com.discord.widgets.servers.auditlog;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsAuditLogAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/UserId;", "<anonymous parameter 0>", "Lcom/discord/primitives/GuildId;", "<anonymous parameter 1>", "", "invoke", "(JLjava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter$onAuditLogAvatarClicked$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter5 extends Lambda implements Function2<Long, Long, Unit> {
    public static final WidgetServerSettingsAuditLogAdapter5 INSTANCE = new WidgetServerSettingsAuditLogAdapter5();

    public WidgetServerSettingsAuditLogAdapter5() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
        invoke(l.longValue(), l2);
        return Unit.a;
    }

    public final void invoke(long j, Long l) {
    }
}
