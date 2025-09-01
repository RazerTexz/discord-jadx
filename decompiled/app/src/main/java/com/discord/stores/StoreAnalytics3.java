package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: StoreAnalytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "", "", "invoke", "()Ljava/util/Map;", "com/discord/stores/StoreAnalytics$trackTextInVoiceOpened$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreAnalytics$trackTextInVoiceOpened$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreAnalytics3 extends Lambda implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics3(Channel channel, StoreAnalytics storeAnalytics, long j, StoreChannelsSelected3 storeChannelsSelected3) {
        super(0);
        this.$channel = channel;
        this.this$0 = storeAnalytics;
        this.$channelId$inlined = j;
        this.$analyticsLocation$inlined = storeChannelsSelected3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends Object> invoke2() {
        Map<String, ? extends Object> mapAccess$getChannelSnapshotAnalyticsProperties = StoreAnalytics.access$getChannelSnapshotAnalyticsProperties(this.this$0, this.$channel, true);
        StoreChannelsSelected3 storeChannelsSelected3 = this.$analyticsLocation$inlined;
        return storeChannelsSelected3 != null ? Maps6.plus(mapAccess$getChannelSnapshotAnalyticsProperties, MapsJVM.mapOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, storeChannelsSelected3.getAnalyticsValue()))) : mapAccess$getChannelSnapshotAnalyticsProperties;
    }
}
