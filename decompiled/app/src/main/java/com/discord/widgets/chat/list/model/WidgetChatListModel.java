package com.discord.widgets.chat.list.model;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetCompactEntry;
import com.discord.widgets.chat.list.entries.StickerGreetEntry;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: WidgetChatListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0086\b\u0018\u0000 I2\u00020\u0001:\u0002JIB\u009f\u0001\u0012\n\u0010 \u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010!\u001a\u00060\u0002j\u0002`\u0006\u0012\b\u0010\"\u001a\u0004\u0018\u00010\b\u0012\n\u0010#\u001a\u00060\u0002j\u0002`\u000b\u0012\u0016\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\b\u0002\u0010%\u001a\u00060\u0002j\u0002`\u0011\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0010\u0010'\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00180\u0017\u0012\f\b\u0002\u0010(\u001a\u00060\u0002j\u0002`\u0011\u0012\f\b\u0002\u0010)\u001a\u00060\u0002j\u0002`\u0011\u0012\u0006\u0010*\u001a\u00020\u001d¢\u0006\u0004\bG\u0010HJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J \u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0012\u001a\u00060\u0002j\u0002`\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00180\u0017HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u001b\u001a\u00060\u0002j\u0002`\u0011HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0005J\u0014\u0010\u001c\u001a\u00060\u0002j\u0002`\u0011HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0005J\u0010\u0010\u001e\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ¸\u0001\u0010+\u001a\u00020\u00002\f\b\u0002\u0010 \u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010!\u001a\u00060\u0002j\u0002`\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\f\b\u0002\u0010#\u001a\u00060\u0002j\u0002`\u000b2\u0018\b\u0002\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\r2\f\b\u0002\u0010%\u001a\u00060\u0002j\u0002`\u00112\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0012\b\u0002\u0010'\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00180\u00172\f\b\u0002\u0010(\u001a\u00060\u0002j\u0002`\u00112\f\b\u0002\u0010)\u001a\u00060\u0002j\u0002`\u00112\b\b\u0002\u0010*\u001a\u00020\u001dHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u00100\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00104\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u000102HÖ\u0003¢\u0006\u0004\b4\u00105R\u001e\u0010\"\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b7\u0010\nR \u0010 \u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b9\u0010\u0005R\u001d\u0010)\u001a\u00060\u0002j\u0002`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b)\u00108\u001a\u0004\b:\u0010\u0005R\u001c\u0010;\u001a\u00020\u001d8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b;\u0010\u001fR\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010=\u001a\u0004\b>\u0010\u0016R \u0010(\u001a\u00060\u0002j\u0002`\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u00108\u001a\u0004\b?\u0010\u0005R&\u0010'\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00180\u00178\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010@\u001a\u0004\bA\u0010\u001aR \u0010%\u001a\u00060\u0002j\u0002`\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u00108\u001a\u0004\bB\u0010\u0005R\u0019\u0010*\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010<\u001a\u0004\b*\u0010\u001fR \u0010#\u001a\u00060\u0002j\u0002`\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u00108\u001a\u0004\bC\u0010\u0005R \u0010!\u001a\u00060\u0002j\u0002`\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\bD\u0010\u0005R,\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010E\u001a\u0004\bF\u0010\u0010¨\u0006K"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModel;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "Lcom/discord/models/guild/Guild;", "component3", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/primitives/GuildId;", "component4", "", "", "component5", "()Ljava/util/Map;", "Lcom/discord/primitives/MessageId;", "component6", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "component7", "()Ljava/util/List;", "", "Lcom/discord/primitives/RoleId;", "component8", "()Ljava/util/Set;", "component9", "component10", "", "component11", "()Z", "userId", "channelId", "guild", "guildId", "channelNames", "oldestMessageId", "list", "myRoleIds", "newMessagesMarkerMessageId", "newestKnownMessageId", "isLoadingMessages", "copy", "(JJLcom/discord/models/guild/Guild;JLjava/util/Map;JLjava/util/List;Ljava/util/Set;JJZ)Lcom/discord/widgets/chat/list/model/WidgetChatListModel;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "J", "getUserId", "getNewestKnownMessageId", "isSpoilerClickAllowed", "Z", "Ljava/util/List;", "getList", "getNewMessagesMarkerMessageId", "Ljava/util/Set;", "getMyRoleIds", "getOldestMessageId", "getGuildId", "getChannelId", "Ljava/util/Map;", "getChannelNames", "<init>", "(JJLcom/discord/models/guild/Guild;JLjava/util/Map;JLjava/util/List;Ljava/util/Set;JJZ)V", "Companion", "ChatListState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class WidgetChatListModel implements WidgetChatListAdapter.Data {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_MESSAGES_PER_CHANNEL = 25;
    private static final long WUMPUS_PACK_ID = 847199849233514549L;
    private static final long WUMPUS_WAVE_STICKER_ID = 749054660769218631L;
    private final long channelId;
    private final Map<Long, String> channelNames;
    private final Guild guild;
    private final long guildId;
    private final boolean isLoadingMessages;
    private final boolean isSpoilerClickAllowed;
    private final List<ChatListEntry> list;
    private final Set<Long> myRoleIds;
    private final long newMessagesMarkerMessageId;
    private final long newestKnownMessageId;
    private final long oldestMessageId;
    private final long userId;

    /* compiled from: WidgetChatListModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModel$ChatListState;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "DETACHED", "DETACHED_UNTOUCHED", "ATTACHED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum ChatListState {
        DETACHED,
        DETACHED_UNTOUCHED,
        ATTACHED;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: WidgetChatListModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModel$ChatListState$Companion;", "", "", "channelId", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/model/WidgetChatListModel$ChatListState;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<ChatListState> get(long channelId) {
                Observable observableY = StoreStream.INSTANCE.getMessages().observeIsDetached(channelId).Y(new WidgetChatListModel2(channelId));
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                return observableY;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: WidgetChatListModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\b\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0002¢\u0006\u0004\b\f\u0010\rJC\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0016\u001a\u0016\u0012\b\u0012\u00060\tj\u0002`\u0013\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJC\u0010!\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010\u000e0\u000e  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00040\u0004*\u00020\u001d2\n\u0010\u001f\u001a\u00060\tj\u0002`\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010(¨\u0006,"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModel$Companion;", "", "Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/model/WidgetChatListModel;", "getChannel", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "parentChannel", "", "Lcom/discord/primitives/MessageId;", "parentMessageId", "getThreadDraft", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;)Lrx/Observable;", "Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "loadingState", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages;", "messages", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "relationships", "", "shouldShowStickerGreet", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages;Lcom/discord/api/channel/Channel;Ljava/util/Map;)Z", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "getGreetMessageItem", "(Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/stores/StoreMessagesLoader;", "Lcom/discord/primitives/ChannelId;", "channelId", "kotlin.jvm.PlatformType", "observeIsLoadingMessages", "(Lcom/discord/stores/StoreMessagesLoader;J)Lrx/Observable;", "get", "()Lrx/Observable;", "MAX_MESSAGES_PER_CHANNEL", "I", "WUMPUS_PACK_ID", "J", "WUMPUS_WAVE_STICKER_ID", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getChannel(Companion companion, Channel channel) {
            return companion.getChannel(channel);
        }

        public static final /* synthetic */ ChatListEntry access$getGreetMessageItem(Companion companion, WidgetChatListModelMessages widgetChatListModelMessages, Channel channel) {
            return companion.getGreetMessageItem(widgetChatListModelMessages, channel);
        }

        public static final /* synthetic */ Observable access$getThreadDraft(Companion companion, Channel channel, Long l) {
            return companion.getThreadDraft(channel, l);
        }

        public static final /* synthetic */ boolean access$shouldShowStickerGreet(Companion companion, StoreMessagesLoader.ChannelLoadedState channelLoadedState, WidgetChatListModelMessages widgetChatListModelMessages, Channel channel, Map map) {
            return companion.shouldShowStickerGreet(channelLoadedState, widgetChatListModelMessages, channel, map);
        }

        private final Observable<WidgetChatListModel> getChannel(Channel channel) {
            Observable<WidgetChatListModelTop> observable = WidgetChatListModelTop.INSTANCE.get(channel);
            Observable<WidgetChatListModelMessages> observable2 = WidgetChatListModelMessages.INSTANCE.get(channel);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<WidgetChatListModel> observableC = Observable.c(observable, observable2, observeIsLoadingMessages(companion.getMessagesLoader(), channel.getId()), companion.getChannels().observeNames(), companion.getUsers().observeMeId(), companion.getGuilds().observeComputed(channel.getGuildId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getUserRelationships().observe(), ChatListState.INSTANCE.get(channel.getId()), new WidgetChatListModel4(channel));
            Intrinsics3.checkNotNullExpressionValue(observableC, "Observable\n            .…          )\n            }");
            return observableC;
        }

        private final ChatListEntry getGreetMessageItem(WidgetChatListModelMessages messages, Channel channel) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreStickers stickers = companion.getStickers();
            Map<Long, Sticker> stickers2 = stickers.getStickers();
            Long lValueOf = Long.valueOf(WidgetChatListModel.WUMPUS_WAVE_STICKER_ID);
            if (stickers2.get(lValueOf) == null) {
                stickers.fetchStickerPack(WidgetChatListModel.WUMPUS_PACK_ID);
            }
            Sticker sticker = stickers.getStickers().get(lValueOf);
            if (sticker != null) {
                Guild guild = companion.getGuilds().getGuild(channel.getGuildId());
                if (!(((guild != null ? guild.getSystemChannelFlags() : 0) & 8) == 0)) {
                    return null;
                }
                if (messages.getItems().isEmpty()) {
                    return new StickerGreetEntry(sticker, channel.getId(), ChannelUtils.c(channel), channel.getType());
                }
                if (messages.getItems().size() < 25) {
                    return new StickerGreetCompactEntry(sticker, channel.getId(), ChannelUtils.c(channel), channel.getType());
                }
            }
            return null;
        }

        private final Observable<WidgetChatListModel> getThreadDraft(Channel parentChannel, Long parentMessageId) {
            Observable observableJ;
            long guildId = parentChannel.getGuildId();
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Map<Long, String>> observableObserveNames = companion.getChannels().observeNames();
            Observable<Long> observableObserveMeId = companion.getUsers().observeMeId();
            Observable<Map<Long, GuildMember>> observableObserveComputed = companion.getGuilds().observeComputed(guildId);
            Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(guildId);
            Observable<StoreThreadDraft.ThreadDraftState> observableObserveDraftState = companion.getThreadDraft().observeDraftState();
            Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(parentChannel.getId());
            if (parentMessageId != null) {
                Observable<Message> observableObserveMessagesForChannel = companion.getMessages().observeMessagesForChannel(parentChannel.getId(), parentMessageId.longValue());
                Observable<List<ChatListEntry>> singleMessage = WidgetChatListModelMessages.INSTANCE.getSingleMessage(parentChannel, parentMessageId.longValue());
                WidgetChatListModel5 widgetChatListModel5 = WidgetChatListModel5.INSTANCE;
                Object widgetChatListModel8 = widgetChatListModel5;
                if (widgetChatListModel5 != null) {
                    widgetChatListModel8 = new WidgetChatListModel8(widgetChatListModel5);
                }
                observableJ = Observable.j(observableObserveMessagesForChannel, singleMessage, (Func2) widgetChatListModel8);
            } else {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
                ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(new ArrayList());
                WidgetChatListModel6 widgetChatListModel6 = WidgetChatListModel6.INSTANCE;
                Object widgetChatListModel82 = widgetChatListModel6;
                if (widgetChatListModel6 != null) {
                    widgetChatListModel82 = new WidgetChatListModel8(widgetChatListModel6);
                }
                observableJ = Observable.j(scalarSynchronousObservable, scalarSynchronousObservable2, (Func2) widgetChatListModel82);
            }
            Observable<WidgetChatListModel> observableE = Observable.e(observableObserveNames, observableObserveMeId, observableObserveComputed, observableObserveGuild, observableObserveDraftState, observableObservePermissionsForChannel, observableJ, new WidgetChatListModel7(parentChannel, parentMessageId, guildId));
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n          .co…            )\n          }");
            return observableE;
        }

        private final Observable<StoreMessagesLoader.ChannelLoadedState> observeIsLoadingMessages(StoreMessagesLoader storeMessagesLoader, long j) {
            return storeMessagesLoader.getMessagesLoadedState(j).r();
        }

        private final boolean shouldShowStickerGreet(StoreMessagesLoader.ChannelLoadedState loadingState, WidgetChatListModelMessages messages, Channel channel, Map<Long, Integer> relationships) {
            if (loadingState.isOldestMessagesLoaded() && loadingState.isInitialMessagesLoaded() && loadingState.getNewestSentByUserMessageId() == null && messages.getNewestSentByUserMessageId() == null && messages.getItems().size() < 25 && ChannelUtils.m(channel) && !ChannelUtils.E(channel)) {
                User userA = ChannelUtils.a(channel);
                Integer num = relationships.get(userA != null ? Long.valueOf(userA.getId()) : null);
                if (num == null || num.intValue() != 2) {
                    return true;
                }
            }
            return false;
        }

        public final Observable<WidgetChatListModel> get() {
            Observable observableY = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().Y(WidgetChatListModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListModel(long j, long j2, Guild guild, long j3, Map<Long, String> map, long j4, List<? extends ChatListEntry> list, Set<Long> set, long j5, long j6, boolean z2) {
        Intrinsics3.checkNotNullParameter(map, "channelNames");
        Intrinsics3.checkNotNullParameter(list, "list");
        Intrinsics3.checkNotNullParameter(set, "myRoleIds");
        this.userId = j;
        this.channelId = j2;
        this.guild = guild;
        this.guildId = j3;
        this.channelNames = map;
        this.oldestMessageId = j4;
        this.list = list;
        this.myRoleIds = set;
        this.newMessagesMarkerMessageId = j5;
        this.newestKnownMessageId = j6;
        this.isLoadingMessages = z2;
        this.isSpoilerClickAllowed = true;
    }

    public static /* synthetic */ WidgetChatListModel copy$default(WidgetChatListModel widgetChatListModel, long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, long j6, boolean z2, int i, Object obj) {
        return widgetChatListModel.copy((i & 1) != 0 ? widgetChatListModel.getUserId() : j, (i & 2) != 0 ? widgetChatListModel.getChannelId() : j2, (i & 4) != 0 ? widgetChatListModel.getGuild() : guild, (i & 8) != 0 ? widgetChatListModel.getGuildId() : j3, (i & 16) != 0 ? widgetChatListModel.getChannelNames() : map, (i & 32) != 0 ? widgetChatListModel.getOldestMessageId() : j4, (i & 64) != 0 ? widgetChatListModel.getList() : list, (i & 128) != 0 ? widgetChatListModel.getMyRoleIds() : set, (i & 256) != 0 ? widgetChatListModel.getNewMessagesMarkerMessageId() : j5, (i & 512) != 0 ? widgetChatListModel.newestKnownMessageId : j6, (i & 1024) != 0 ? widgetChatListModel.isLoadingMessages : z2);
    }

    public final long component1() {
        return getUserId();
    }

    /* renamed from: component10, reason: from getter */
    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsLoadingMessages() {
        return this.isLoadingMessages;
    }

    public final long component2() {
        return getChannelId();
    }

    public final Guild component3() {
        return getGuild();
    }

    public final long component4() {
        return getGuildId();
    }

    public final Map<Long, String> component5() {
        return getChannelNames();
    }

    public final long component6() {
        return getOldestMessageId();
    }

    public final List<ChatListEntry> component7() {
        return getList();
    }

    public final Set<Long> component8() {
        return getMyRoleIds();
    }

    public final long component9() {
        return getNewMessagesMarkerMessageId();
    }

    public final WidgetChatListModel copy(long userId, long channelId, Guild guild, long guildId, Map<Long, String> channelNames, long oldestMessageId, List<? extends ChatListEntry> list, Set<Long> myRoleIds, long newMessagesMarkerMessageId, long newestKnownMessageId, boolean isLoadingMessages) {
        Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
        Intrinsics3.checkNotNullParameter(list, "list");
        Intrinsics3.checkNotNullParameter(myRoleIds, "myRoleIds");
        return new WidgetChatListModel(userId, channelId, guild, guildId, channelNames, oldestMessageId, list, myRoleIds, newMessagesMarkerMessageId, newestKnownMessageId, isLoadingMessages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListModel)) {
            return false;
        }
        WidgetChatListModel widgetChatListModel = (WidgetChatListModel) other;
        return getUserId() == widgetChatListModel.getUserId() && getChannelId() == widgetChatListModel.getChannelId() && Intrinsics3.areEqual(getGuild(), widgetChatListModel.getGuild()) && getGuildId() == widgetChatListModel.getGuildId() && Intrinsics3.areEqual(getChannelNames(), widgetChatListModel.getChannelNames()) && getOldestMessageId() == widgetChatListModel.getOldestMessageId() && Intrinsics3.areEqual(getList(), widgetChatListModel.getList()) && Intrinsics3.areEqual(getMyRoleIds(), widgetChatListModel.getMyRoleIds()) && getNewMessagesMarkerMessageId() == widgetChatListModel.getNewMessagesMarkerMessageId() && this.newestKnownMessageId == widgetChatListModel.newestKnownMessageId && this.isLoadingMessages == widgetChatListModel.isLoadingMessages;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public List<ChatListEntry> getList() {
        return this.list;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public Set<Long> getMyRoleIds() {
        return this.myRoleIds;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getOldestMessageId() {
        return this.oldestMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    public long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = (b.a(getChannelId()) + (b.a(getUserId()) * 31)) * 31;
        Guild guild = getGuild();
        int iA2 = (b.a(getGuildId()) + ((iA + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
        Map<Long, String> channelNames = getChannelNames();
        int iA3 = (b.a(getOldestMessageId()) + ((iA2 + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
        List<ChatListEntry> list = getList();
        int iHashCode = (iA3 + (list != null ? list.hashCode() : 0)) * 31;
        Set<Long> myRoleIds = getMyRoleIds();
        int iA4 = (b.a(this.newestKnownMessageId) + ((b.a(getNewMessagesMarkerMessageId()) + ((iHashCode + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31)) * 31;
        boolean z2 = this.isLoadingMessages;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iA4 + i;
    }

    public final boolean isLoadingMessages() {
        return this.isLoadingMessages;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
    /* renamed from: isSpoilerClickAllowed, reason: from getter */
    public boolean getIsSpoilerClickAllowed() {
        return this.isSpoilerClickAllowed;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetChatListModel(userId=");
        sbU.append(getUserId());
        sbU.append(", channelId=");
        sbU.append(getChannelId());
        sbU.append(", guild=");
        sbU.append(getGuild());
        sbU.append(", guildId=");
        sbU.append(getGuildId());
        sbU.append(", channelNames=");
        sbU.append(getChannelNames());
        sbU.append(", oldestMessageId=");
        sbU.append(getOldestMessageId());
        sbU.append(", list=");
        sbU.append(getList());
        sbU.append(", myRoleIds=");
        sbU.append(getMyRoleIds());
        sbU.append(", newMessagesMarkerMessageId=");
        sbU.append(getNewMessagesMarkerMessageId());
        sbU.append(", newestKnownMessageId=");
        sbU.append(this.newestKnownMessageId);
        sbU.append(", isLoadingMessages=");
        return outline.O(sbU, this.isLoadingMessages, ")");
    }

    public /* synthetic */ WidgetChatListModel(long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, long j6, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, guild, j3, map, (i & 32) != 0 ? 0L : j4, list, set, (i & 256) != 0 ? 0L : j5, (i & 512) != 0 ? 0L : j6, z2);
    }
}
