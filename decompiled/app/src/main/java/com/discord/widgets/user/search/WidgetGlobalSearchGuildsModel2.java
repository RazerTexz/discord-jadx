package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchGuildsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel$Companion$asDirectMessageItems$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel2 extends Lambda implements Function1<Channel, Boolean> {
    public final /* synthetic */ ModelNotificationSettings $dmSettings;
    public final /* synthetic */ Map $mentionCounts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsModel2(ModelNotificationSettings modelNotificationSettings, Map map) {
        super(1);
        this.$dmSettings = modelNotificationSettings;
        this.$mentionCounts = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        ModelNotificationSettings modelNotificationSettings;
        ModelNotificationSettings.ChannelOverride channelOverride;
        Intrinsics3.checkNotNullParameter(channel, "it");
        return this.$mentionCounts.containsKey(Long.valueOf(channel.getId())) && ((modelNotificationSettings = this.$dmSettings) == null || (channelOverride = modelNotificationSettings.getChannelOverride(channel.getId())) == null || !channelOverride.isMuted());
    }
}
