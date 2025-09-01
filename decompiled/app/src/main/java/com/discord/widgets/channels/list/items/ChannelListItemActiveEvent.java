package com.discord.widgets.channels.list.items;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemActiveEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemActiveEvent;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/widgets/channels/list/items/ChannelListItemActiveEventData;", "data", "Lcom/discord/widgets/channels/list/items/ChannelListItemActiveEventData;", "getData", "()Lcom/discord/widgets/channels/list/items/ChannelListItemActiveEventData;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "", "type", "I", "getType", "()I", "<init>", "(Lcom/discord/widgets/channels/list/items/ChannelListItemActiveEventData;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelListItemActiveEvent implements ChannelListItem {
    private final ChannelListItemActiveEvent2 data;
    private final String key;
    private final int type;

    public ChannelListItemActiveEvent(ChannelListItemActiveEvent2 channelListItemActiveEvent2) {
        Intrinsics3.checkNotNullParameter(channelListItemActiveEvent2, "data");
        this.data = channelListItemActiveEvent2;
        this.type = 15;
        this.key = getType() + channelListItemActiveEvent2.getLocationInfo().getLocationName();
    }

    public final ChannelListItemActiveEvent2 getData() {
        return this.data;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
