package com.discord.widgets.channels.list.items;

import kotlin.Metadata;

/* compiled from: ChannelListItemEventsSeparator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemEventsSeparator;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "", "type", "I", "getType", "()I", "", "isTop", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelListItemEventsSeparator implements ChannelListItem {
    private final String key;
    private final int type = 14;

    public ChannelListItemEventsSeparator(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(z2);
        this.key = sb.toString();
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
