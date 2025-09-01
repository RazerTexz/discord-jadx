package com.discord.widgets.chat.list.entries;

import b.a.d.m0.RoutingPatterns;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.domain.ModelInvite;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.widgets.botuikit.ComponentChatListState;
import com.discord.widgets.botuikit.ComponentExperiments2;
import com.discord.widgets.botuikit.ComponentStateMapper;
import com.discord.widgets.chat.AutocompleteUtils;
import com.discord.widgets.chat.AutocompleteUtils2;
import d0.g0.StringNumberConversions;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;

/* compiled from: ChatListEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "isInExpandedBlockedMessageChunk", "()Z", "shouldShowThreadSpine", "Z", "getShouldShowThreadSpine", "setShouldShowThreadSpine", "(Z)V", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class ChatListEntry implements MGRecyclerDataPayload {
    public static final int APPLICATION_COMMAND = 33;
    public static final int AUTOMOD_BLOCKED = 44;
    public static final int AUTOMOD_SYSTEM_MESSAGE = 45;
    public static final int BLOCKED_MESSAGES = 10;
    public static final int BOT_UI_COMPONENT = 36;
    public static final int CALL_MESSAGE = 19;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DIVIDER = 15;
    public static final int EMPTY_PINS = 16;
    public static final int EPHEMERAL_MESSAGE = 34;
    public static final int GAME_INVITE = 22;
    public static final int GIFT = 26;
    public static final int GUILD_INVITE_REMINDER = 38;
    public static final int GUILD_SCHEDULED_EVENT_INVITE = 43;
    public static final int GUILD_TEMPLATE = 30;
    public static final int GUILD_WELCOME = 25;
    public static final int INVITE = 24;
    public static final int LOAD_INDICATOR = 2;
    public static final int MENTION_FOOTER = 18;
    public static final int MESSAGE = 0;
    public static final int MESSAGE_ATTACHMENT = 28;
    public static final int MESSAGE_EMBED = 21;
    public static final int MESSAGE_FAILED = 20;
    public static final int MESSAGE_HEADER = 17;
    public static final int MESSAGE_MINIMAL = 1;
    public static final int NEW_MESSAGES = 8;
    public static final int REACTIONS = 4;
    public static final int REPLY = 32;
    public static final int SEARCH_EMPTY = 13;
    public static final int SEARCH_ERROR = 14;
    public static final int SEARCH_INDEXING = 12;
    public static final int SEARCH_RESULT_COUNT = 11;
    public static final int SPACER = 7;
    public static final int SPOTIFY_LISTEN_TOGETHER = 23;
    public static final int STAGE_INVITE = 39;
    public static final int START_OF_CHAT = 3;
    public static final int START_OF_PRIVATE_CHAT = 29;
    public static final int STICKER = 31;
    public static final int STICKER_GREET = 41;
    public static final int STICKER_GREET_COMPACT = 42;
    public static final int SYSTEM_MESSAGE = 5;
    public static final int THREAD_DRAFT_FORM = 37;
    public static final int THREAD_EMBED = 35;
    public static final int THREAD_STARTER_DIVIDER = 40;
    public static final int TIMESTAMP = 9;
    public static final int UPLOAD_STATUS = 6;
    private boolean shouldShowThreadSpine;

    /* compiled from: ChatListEntry.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b1\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bi\u0010jJ1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJs\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\r\u001a\u00020\f2\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ9\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010!\u001a\u00060\u000fj\u0002` 2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b(\u0010\u001fJ\u001b\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b,\u0010+J\u001b\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b-\u0010+J\u0091\u0001\u00108\u001a\b\u0012\u0004\u0012\u00020\t0)2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u00010\u00112\u0018\u00106\u001a\u0014\u0012\b\u0012\u00060\u000fj\u0002`5\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000e2\u0016\u00107\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010>\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010?\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010<R\u0016\u0010@\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010A\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010<R\u0016\u0010B\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010<R\u0016\u0010C\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010<R\u0016\u0010D\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u0010<R\u0016\u0010E\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010<R\u0016\u0010F\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u0010<R\u0016\u0010G\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010<R\u0016\u0010H\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010<R\u0016\u0010I\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010<R\u0016\u0010J\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010<R\u0016\u0010K\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010<R\u0016\u0010L\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u0010<R\u0016\u0010M\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010<R\u0016\u0010N\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u0010<R\u0016\u0010O\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u0010<R\u0016\u0010P\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u0010<R\u0016\u0010Q\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u0010<R\u0016\u0010R\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bR\u0010<R\u0016\u0010S\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u0010<R\u0016\u0010T\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bT\u0010<R\u0016\u0010U\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u0010<R\u0016\u0010V\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u0010<R\u0016\u0010W\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u0010<R\u0016\u0010X\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u0010<R\u0016\u0010Y\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010<R\u0016\u0010Z\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bZ\u0010<R\u0016\u0010[\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b[\u0010<R\u0016\u0010\\\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\\\u0010<R\u0016\u0010]\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b]\u0010<R\u0016\u0010^\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u0010<R\u0016\u0010_\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u0010<R\u0016\u0010`\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u0010<R\u0016\u0010a\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u0010<R\u0016\u0010b\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bb\u0010<R\u0016\u0010c\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bc\u0010<R\u0016\u0010d\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bd\u0010<R\u0016\u0010e\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\be\u0010<R\u0016\u0010f\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bf\u0010<R\u0016\u0010g\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bg\u0010<R\u0016\u0010h\u001a\u00020:8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bh\u0010<¨\u0006k"}, d2 = {"Lcom/discord/widgets/chat/list/entries/ChatListEntry$Companion;", "", "Lcom/discord/models/message/Message;", "message", "", "inviteCode", "eventId", "Lcom/discord/utilities/embed/InviteEmbedModel;", "inviteEmbedModel", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "createEntryForInvite", "(Lcom/discord/models/message/Message;Ljava/lang/String;Ljava/lang/String;Lcom/discord/utilities/embed/InviteEmbedModel;)Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "channelMembers", "thread", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "threadEmbedMetadata", "Lcom/discord/api/role/GuildRole;", "guildRoles", "", "animateEmojis", "renderEmbeds", "", "createThreadEmbedEntries", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;Lcom/discord/stores/StoreThreadMessages$ThreadState;Ljava/util/Map;ZZ)Ljava/util/Collection;", "createGiftEntries", "(Lcom/discord/models/message/Message;)Ljava/util/Collection;", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;", "componentStoreState", "createBotComponentEntries", "(Lcom/discord/models/message/Message;JLcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;Z)Ljava/util/Collection;", "createInviteEntries", "(Lcom/discord/models/message/Message;Lcom/discord/utilities/embed/InviteEmbedModel;)Ljava/util/Collection;", "createGuildTemplateEntries", "", "createSpotifyListenTogetherEntries", "(Lcom/discord/models/message/Message;)Ljava/util/List;", "createGameInviteEntries", "createStickerEntries", "Lcom/discord/stores/StoreMessageState$State;", "messageState", "blockedChunkExpanded", "allowAnimatedEmojis", "autoPlayGifs", "isThreadStarterMessage", "author", "Lcom/discord/primitives/RoleId;", "roles", "nickOrUsernames", "createEmbedEntries", "(Lcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;ZZZZZLcom/discord/api/channel/Channel;Lcom/discord/models/member/GuildMember;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "", "APPLICATION_COMMAND", "I", "AUTOMOD_BLOCKED", "AUTOMOD_SYSTEM_MESSAGE", "BLOCKED_MESSAGES", "BOT_UI_COMPONENT", "CALL_MESSAGE", "DIVIDER", "EMPTY_PINS", "EPHEMERAL_MESSAGE", "GAME_INVITE", "GIFT", "GUILD_INVITE_REMINDER", "GUILD_SCHEDULED_EVENT_INVITE", "GUILD_TEMPLATE", "GUILD_WELCOME", "INVITE", "LOAD_INDICATOR", "MENTION_FOOTER", "MESSAGE", "MESSAGE_ATTACHMENT", "MESSAGE_EMBED", "MESSAGE_FAILED", "MESSAGE_HEADER", "MESSAGE_MINIMAL", "NEW_MESSAGES", AutocompleteUtils2.REACTIONS, "REPLY", "SEARCH_EMPTY", "SEARCH_ERROR", "SEARCH_INDEXING", "SEARCH_RESULT_COUNT", "SPACER", "SPOTIFY_LISTEN_TOGETHER", "STAGE_INVITE", "START_OF_CHAT", "START_OF_PRIVATE_CHAT", AutocompleteUtils.STICKER, "STICKER_GREET", "STICKER_GREET_COMPACT", "SYSTEM_MESSAGE", "THREAD_DRAFT_FORM", "THREAD_EMBED", "THREAD_STARTER_DIVIDER", "TIMESTAMP", "UPLOAD_STATUS", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final ChatListEntry createEntryForInvite(Message message, String inviteCode, String eventId, InviteEmbedModel inviteEmbedModel) {
            if (eventId != null) {
                ModelInvite modelInviteResolveInviteForGuildScheduledEvent = inviteEmbedModel.resolveInviteForGuildScheduledEvent(inviteCode, eventId);
                if ((modelInviteResolveInviteForGuildScheduledEvent != null ? modelInviteResolveInviteForGuildScheduledEvent.getGuildScheduledEvent() : null) != null) {
                    GuildScheduledEvent guildScheduledEvent = modelInviteResolveInviteForGuildScheduledEvent.getGuildScheduledEvent();
                    Intrinsics3.checkNotNull(guildScheduledEvent);
                    Intrinsics3.checkNotNullExpressionValue(guildScheduledEvent, "eventInvite.guildScheduledEvent!!");
                    return new GuildScheduledEventInviteEntry(modelInviteResolveInviteForGuildScheduledEvent, inviteCode, guildScheduledEvent);
                }
            }
            ModelInvite modelInviteResolveInviteCodeForPublicStage = inviteEmbedModel.resolveInviteCodeForPublicStage(inviteCode);
            if (modelInviteResolveInviteCodeForPublicStage != null) {
                User author = message.getAuthor();
                Intrinsics3.checkNotNull(author);
                long id2 = author.getId();
                long id3 = message.getId();
                Long guildId = message.getGuildId();
                return new StageInviteEntry(id2, id3, inviteCode, modelInviteResolveInviteCodeForPublicStage, guildId != null ? guildId.longValue() : 0L);
            }
            User author2 = message.getAuthor();
            Intrinsics3.checkNotNull(author2);
            long id4 = author2.getId();
            long id5 = message.getId();
            Long guildId2 = message.getGuildId();
            return new InviteEntry(id4, id5, inviteCode, guildId2 != null ? guildId2.longValue() : 0L, eventId);
        }

        public final Collection<ChatListEntry> createBotComponentEntries(Message message, long guildId, ComponentChatListState.ComponentStoreState componentStoreState, boolean animateEmojis) {
            long id2;
            Intrinsics3.checkNotNullParameter(message, "message");
            if (message.getComponents() == null || !(!r0.isEmpty())) {
                return Collections2.emptyList();
            }
            List<MessageComponent> listProcessComponentsToMessageComponents = ComponentStateMapper.INSTANCE.processComponentsToMessageComponents(message.getComponents(), componentStoreState, ComponentExperiments2.INSTANCE.get(StoreStream.INSTANCE.getExperiments()), animateEmojis);
            Long applicationId = message.getApplicationId();
            if (applicationId != null) {
                id2 = applicationId.longValue();
            } else {
                User author = message.getAuthor();
                Intrinsics3.checkNotNull(author);
                id2 = author.getId();
            }
            return CollectionsJVM.listOf(new BotUiComponentEntry(message, id2, Long.valueOf(guildId), listProcessComponentsToMessageComponents));
        }

        public final List<ChatListEntry> createEmbedEntries(Message message, StoreMessageState.State messageState, boolean blockedChunkExpanded, boolean allowAnimatedEmojis, boolean autoPlayGifs, boolean renderEmbeds, boolean isThreadStarterMessage, Channel channel, GuildMember author, Map<Long, GuildRole> roles, Map<Long, String> nickOrUsernames) {
            int i;
            int i2;
            Integer type;
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
            if (!message.hasAttachments() && (!message.hasEmbeds() || !renderEmbeds)) {
                return Collections2.emptyList();
            }
            HashSet hashSet = new HashSet();
            ArrayList<MessageEmbed> arrayList = new ArrayList();
            List<MessageEmbed> embeds = message.getEmbeds();
            if (embeds != null) {
                for (MessageEmbed messageEmbed : embeds) {
                    if (!hashSet.contains(messageEmbed.getUrl())) {
                        hashSet.add(messageEmbed.getUrl());
                        arrayList.add(messageEmbed);
                    } else if (messageEmbed.getUrl() == null) {
                        arrayList.add(messageEmbed);
                    }
                }
            }
            List<MessageAttachment> attachments = message.getAttachments();
            ArrayList arrayList2 = new ArrayList(arrayList.size() + (attachments != null ? attachments.size() : 0));
            List<MessageAttachment> attachments2 = message.getAttachments();
            if (attachments2 != null) {
                Iterator<T> it = attachments2.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    arrayList2.add(new AttachmentEntry(i3, channel.getGuildId(), message, messageState, (MessageAttachment) it.next(), blockedChunkExpanded, allowAnimatedEmojis, autoPlayGifs, isThreadStarterMessage));
                    i3++;
                }
                i = 0;
                i2 = i3;
            } else {
                i = 0;
                i2 = 0;
            }
            Integer type2 = message.getType();
            if (type2 != null && type2.intValue() == 24) {
                arrayList2.add(new AutoModSystemMessageEmbedEntry(channel, message, messageState, (MessageEmbed) arrayList.get(i), author, allowAnimatedEmojis, roles, nickOrUsernames));
            }
            int i4 = i2;
            for (MessageEmbed messageEmbed2 : arrayList) {
                if (messageEmbed2.getType() != EmbedType.APPLICATION_NEWS && ((type = message.getType()) == null || type.intValue() != 24)) {
                    arrayList2.add(new EmbedEntry(i4, channel.getGuildId(), message, messageState, messageEmbed2, blockedChunkExpanded, allowAnimatedEmojis, autoPlayGifs, isThreadStarterMessage));
                    i4++;
                }
            }
            return arrayList2;
        }

        public final List<ChatListEntry> createGameInviteEntries(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Application application = message.getApplication();
            MessageActivity activity = message.getActivity();
            if (application == null || activity == null) {
                return Collections2.emptyList();
            }
            User author = message.getAuthor();
            Intrinsics3.checkNotNull(author);
            return CollectionsJVM.listOf(new GameInviteEntry(author.getId(), message.getId(), activity, application));
        }

        public final Collection<ChatListEntry> createGiftEntries(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            String content = message.getContent();
            if (content == null || content.length() == 0) {
                return Collections2.emptyList();
            }
            HashMap map = new HashMap();
            Iterator<MatchResult> it = RoutingPatterns.r.findAll(content, 0).iterator();
            while (it.hasNext()) {
                List<String> groupValues = it.next().getGroupValues();
                if (!groupValues.isEmpty()) {
                    String str = groupValues.get(groupValues.size() - 1);
                    User author = message.getAuthor();
                    Intrinsics3.checkNotNull(author);
                    map.put(str, new GiftEntry(author.getId(), message.getId(), message.getChannelId(), str));
                }
            }
            Collection<ChatListEntry> collectionValues = map.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "entries.values");
            return collectionValues;
        }

        public final Collection<ChatListEntry> createGuildTemplateEntries(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            String content = message.getContent();
            if (content != null) {
                if (!(content.length() == 0)) {
                    HashMap map = new HashMap();
                    Iterator<MatchResult> it = RoutingPatterns.q.findAll(content, 0).iterator();
                    while (it.hasNext()) {
                        List<String> groupValues = it.next().getGroupValues();
                        if (!groupValues.isEmpty()) {
                            String str = groupValues.get(groupValues.size() - 1);
                            User author = message.getAuthor();
                            Intrinsics3.checkNotNull(author);
                            map.put(str, new GuildTemplateEntry(author.getId(), message.getId(), str));
                        }
                    }
                    Collection<ChatListEntry> collectionValues = map.values();
                    Intrinsics3.checkNotNullExpressionValue(collectionValues, "entries.values");
                    return collectionValues;
                }
            }
            return Collections2.emptyList();
        }

        public final Collection<ChatListEntry> createInviteEntries(Message message, InviteEmbedModel inviteEmbedModel) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
            String content = message.getContent();
            if (content == null || content.length() == 0) {
                return Collections2.emptyList();
            }
            HashMap map = new HashMap();
            Iterator<MatchResult> it = RoutingPatterns.o.findAll(content, 0).iterator();
            while (it.hasNext()) {
                List<String> groupValues = it.next().getGroupValues();
                if (groupValues.size() == 3) {
                    String str = groupValues.get(1);
                    Long longOrNull = StringNumberConversions.toLongOrNull(groupValues.get(2));
                    map.put(str, createEntryForInvite(message, str, longOrNull != null ? String.valueOf(longOrNull.longValue()) : null, inviteEmbedModel));
                }
            }
            Collection<ChatListEntry> collectionValues = map.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "entries.values");
            return collectionValues;
        }

        public final List<ChatListEntry> createSpotifyListenTogetherEntries(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            MessageActivity activity = message.getActivity();
            if (activity == null || !message.isSpotifyListeningActivity()) {
                return Collections2.emptyList();
            }
            User author = message.getAuthor();
            Intrinsics3.checkNotNull(author);
            return CollectionsJVM.listOf(new SpotifyListenTogetherEntry(author.getId(), message.getId(), activity));
        }

        public final List<ChatListEntry> createStickerEntries(Message message) {
            ArrayList arrayList;
            Intrinsics3.checkNotNullParameter(message, "message");
            List<StickerPartial> stickerItems = message.getStickerItems();
            if (stickerItems == null || stickerItems.isEmpty()) {
                List<Sticker> stickers = message.getStickers();
                if (stickers != null) {
                    arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(stickers, 10));
                    Iterator<T> it = stickers.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new StickerEntry(message, (Sticker) it.next()));
                    }
                } else {
                    arrayList = null;
                }
            } else {
                List<StickerPartial> stickerItems2 = message.getStickerItems();
                arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(stickerItems2, 10));
                Iterator<T> it2 = stickerItems2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new StickerEntry(message, (StickerPartial) it2.next()));
                }
            }
            return arrayList != null ? arrayList : Collections2.emptyList();
        }

        public final Collection<ChatListEntry> createThreadEmbedEntries(Channel channel, Map<Long, GuildMember> channelMembers, Message message, Channel thread, StoreThreadMessages.ThreadState threadEmbedMetadata, Map<Long, GuildRole> guildRoles, boolean animateEmojis, boolean renderEmbeds) {
            Map<Long, String> mapEmptyMap;
            Message mostRecentMessage;
            User author;
            Message mostRecentMessage2;
            Message mostRecentMessage3;
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(channelMembers, "channelMembers");
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(thread, "thread");
            if (!renderEmbeds) {
                return Collections2.emptyList();
            }
            long id2 = message.getId();
            int count = threadEmbedMetadata != null ? threadEmbedMetadata.getCount() : 0;
            Long lValueOf = null;
            Message mostRecentMessage4 = threadEmbedMetadata != null ? threadEmbedMetadata.getMostRecentMessage() : null;
            Map<Long, GuildRole> map = RoleUtils.containsRoleMentions((threadEmbedMetadata == null || (mostRecentMessage3 = threadEmbedMetadata.getMostRecentMessage()) == null) ? null : mostRecentMessage3.getContent()) ? guildRoles : null;
            if (threadEmbedMetadata == null || (mostRecentMessage2 = threadEmbedMetadata.getMostRecentMessage()) == null || (mapEmptyMap = MessageUtils.getNickOrUsernames(mostRecentMessage2, channel, channelMembers, channel.q())) == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            Map<Long, String> map2 = mapEmptyMap;
            if (threadEmbedMetadata != null && (mostRecentMessage = threadEmbedMetadata.getMostRecentMessage()) != null && (author = mostRecentMessage.getAuthor()) != null) {
                lValueOf = Long.valueOf(author.getId());
            }
            return CollectionsJVM.listOf(new ThreadEmbedEntry(id2, thread, count, mostRecentMessage4, map, map2, animateEmojis, channelMembers.get(lValueOf), message));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean getShouldShowThreadSpine() {
        return this.shouldShowThreadSpine;
    }

    public boolean isInExpandedBlockedMessageChunk() {
        return false;
    }

    public final void setShouldShowThreadSpine(boolean z2) {
        this.shouldShowThreadSpine = z2;
    }
}
