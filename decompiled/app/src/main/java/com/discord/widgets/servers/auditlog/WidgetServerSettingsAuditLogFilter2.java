package com.discord.widgets.servers.auditlog;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/primitives/GuildId;", "guildId", "", "invoke", "(JLjava/lang/Long;)V", "com/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilter$onViewCreated$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onViewCreated$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter2 extends Lambda implements Function2<Long, Long, Unit> {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter2(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter) {
        super(2);
        this.this$0 = widgetServerSettingsAuditLogFilter;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
        invoke(l.longValue(), l2);
        return Unit.a;
    }

    public final void invoke(long j, Long l) {
        WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, l, null, null, null, 114, null);
    }
}
