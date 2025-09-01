package com.discord.widgets.channels.list.items;

import kotlin.Metadata;

/* compiled from: ChannelListItemGuildRoleSubscriptionsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemGuildRoleSubscriptionsOverview;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "", "type", "I", "getType", "()I", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelListItemGuildRoleSubscriptionsOverview implements ChannelListItem {
    public static final ChannelListItemGuildRoleSubscriptionsOverview INSTANCE;
    private static final String key;
    private static final int type;

    static {
        ChannelListItemGuildRoleSubscriptionsOverview channelListItemGuildRoleSubscriptionsOverview = new ChannelListItemGuildRoleSubscriptionsOverview();
        INSTANCE = channelListItemGuildRoleSubscriptionsOverview;
        type = 21;
        key = String.valueOf(channelListItemGuildRoleSubscriptionsOverview.getType());
    }

    private ChannelListItemGuildRoleSubscriptionsOverview() {
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return type;
    }
}
