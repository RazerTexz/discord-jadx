package com.discord.widgets.servers.auditlog;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/User;", "user", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem;", "invoke", "(Lcom/discord/models/user/User;)Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter6 extends Lambda implements Function1<User, WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem> {
    public final /* synthetic */ StoreAuditLog.AuditLogState $auditLogState;
    public final /* synthetic */ Map $guildMembers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter6(Map map, StoreAuditLog.AuditLogState auditLogState) {
        super(1);
        this.$guildMembers = map;
        this.$auditLogState = auditLogState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem invoke(User user) {
        return invoke2(user);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem(user, (GuildMember) outline.f(user, this.$guildMembers), user.getId(), null, Integer.valueOf(user.getDiscriminator()), this.$auditLogState.getFilter().getUserFilter() == user.getId());
    }
}
