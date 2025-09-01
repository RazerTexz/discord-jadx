package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u001a\u0010\u0006\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\u00050\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "", "invoke", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1 extends Lambda implements Function2<Channel, Map<Long, ? extends Long>, Boolean> {
    public static final WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1 INSTANCE = new WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1();

    public WidgetGlobalSearchModel$Companion$DEFAULT_PERMISSIONS_PREDICATE$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel, Map<Long, ? extends Long> map) {
        return Boolean.valueOf(invoke2(channel, (Map<Long, Long>) map));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel, Map<Long, Long> map) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
        return PermissionUtils.hasAccess(channel, map);
    }
}
