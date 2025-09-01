package com.discord.widgets.channels.list.items;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.Metadata;

/* compiled from: ChannelListItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "getKey", "()Ljava/lang/String;", "key", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface ChannelListItem extends MGRecyclerDataPayload {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int TYPE_ACTIVE_EVENT = 15;
    public static final int TYPE_ADD_SERVER = 18;
    public static final int TYPE_BOTTOM_NAV_SPACE = 11;
    public static final int TYPE_CATEGORY = 8;
    public static final int TYPE_CHANNEL = 0;
    public static final int TYPE_CHANNEL_PRIVATE = 3;
    public static final int TYPE_CHANNEL_STAGE_VOICE = 13;
    public static final int TYPE_CHANNEL_VOICE = 1;
    public static final int TYPE_CHANNEL_VOICE_USER = 2;
    public static final int TYPE_DIRECTORY = 17;
    public static final int TYPE_GUILD_JOIN_REQUEST = 22;
    public static final int TYPE_GUILD_ROLE_SUBSCRIPTIONS_OVERVIEW = 21;
    public static final int TYPE_GUILD_SCHEDULED_EVENTS = 19;
    public static final int TYPE_HEADER = 6;
    public static final int TYPE_HUB_INVITE = 20;
    public static final int TYPE_INVITE = 9;
    public static final int TYPE_MFA_NOTICE = 7;
    public static final int TYPE_STAGE_AUDIENCE_COUNT = 16;
    public static final int TYPE_STAGE_EVENTS_SEPARATOR = 14;
    public static final int TYPE_THREAD = 12;

    /* compiled from: ChannelListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItem$Companion;", "", "", "TYPE_GUILD_SCHEDULED_EVENTS", "I", "TYPE_CHANNEL_VOICE_USER", "TYPE_HUB_INVITE", "TYPE_STAGE_EVENTS_SEPARATOR", "TYPE_CHANNEL_PRIVATE", "TYPE_CHANNEL", "TYPE_ACTIVE_EVENT", "TYPE_CATEGORY", "TYPE_GUILD_ROLE_SUBSCRIPTIONS_OVERVIEW", "TYPE_GUILD_JOIN_REQUEST", "TYPE_MFA_NOTICE", "TYPE_CHANNEL_STAGE_VOICE", "TYPE_HEADER", "TYPE_CHANNEL_VOICE", "TYPE_DIRECTORY", "TYPE_INVITE", "TYPE_THREAD", "TYPE_STAGE_AUDIENCE_COUNT", "TYPE_ADD_SERVER", "TYPE_BOTTOM_NAV_SPACE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TYPE_ACTIVE_EVENT = 15;
        public static final int TYPE_ADD_SERVER = 18;
        public static final int TYPE_BOTTOM_NAV_SPACE = 11;
        public static final int TYPE_CATEGORY = 8;
        public static final int TYPE_CHANNEL = 0;
        public static final int TYPE_CHANNEL_PRIVATE = 3;
        public static final int TYPE_CHANNEL_STAGE_VOICE = 13;
        public static final int TYPE_CHANNEL_VOICE = 1;
        public static final int TYPE_CHANNEL_VOICE_USER = 2;
        public static final int TYPE_DIRECTORY = 17;
        public static final int TYPE_GUILD_JOIN_REQUEST = 22;
        public static final int TYPE_GUILD_ROLE_SUBSCRIPTIONS_OVERVIEW = 21;
        public static final int TYPE_GUILD_SCHEDULED_EVENTS = 19;
        public static final int TYPE_HEADER = 6;
        public static final int TYPE_HUB_INVITE = 20;
        public static final int TYPE_INVITE = 9;
        public static final int TYPE_MFA_NOTICE = 7;
        public static final int TYPE_STAGE_AUDIENCE_COUNT = 16;
        public static final int TYPE_STAGE_EVENTS_SEPARATOR = 14;
        public static final int TYPE_THREAD = 12;

        private Companion() {
        }
    }

    /* compiled from: ChannelListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static String getKey(ChannelListItem channelListItem) {
            return String.valueOf(channelListItem.getType());
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    String getKey();
}
