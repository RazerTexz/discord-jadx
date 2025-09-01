package com.discord.widgets.chat.list.model;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.MessageReference;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.message.LocalMessageCreators;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.botuikit.ComponentChatListState;
import com.discord.widgets.chat.list.entries.BlockedMessagesEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.chat.list.entries.NewMessagesEntry;
import com.discord.widgets.chat.list.entries.TimestampEntry;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetChatListModelMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 12\u00020\u0001:\u0003123Bc\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0010\u0014\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\u0015\u001a\u00060\u0006j\u0002`\u0007\u0012\u0018\u0010\u0016\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\n\u0010\u0017\u001a\u00060\u0006j\u0002`\u0007\u0012\u000e\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b/\u00100J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\"\u0010\u000e\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0010\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u0010\u0010\tJ\u0018\u0010\u0011\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012Jx\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\b\u0002\u0010\u0014\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u0010\u0015\u001a\u00060\u0006j\u0002`\u00072\u001a\b\u0002\u0010\u0016\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\f\b\u0002\u0010\u0017\u001a\u00060\u0006j\u0002`\u00072\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R+\u0010\u0016\u001a\u0014\u0012\b\u0012\u00060\u0006j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u000fR!\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\u0012R\u001d\u0010\u0014\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\tR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b,\u0010\u0005R\u001d\u0010\u0015\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b-\u0010\tR\u001d\u0010\u0017\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b.\u0010\t¨\u00064"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages;", "", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "component1", "()Ljava/util/List;", "", "Lcom/discord/primitives/MessageId;", "component2", "()J", "component3", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "component4", "()Ljava/util/Map;", "component5", "component6", "()Ljava/lang/Long;", "items", "oldestMessageId", "newestKnownMessageId", "guildMembers", "newMessagesMarkerMessageId", "newestSentByUserMessageId", "copy", "(Ljava/util/List;JJLjava/util/Map;JLjava/lang/Long;)Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getGuildMembers", "Ljava/lang/Long;", "getNewestSentByUserMessageId", "J", "getOldestMessageId", "Ljava/util/List;", "getItems", "getNewestKnownMessageId", "getNewMessagesMarkerMessageId", "<init>", "(Ljava/util/List;JJLjava/util/Map;JLjava/lang/Long;)V", "Companion", "Items", "MessagesWithMetadata", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class WidgetChatListModelMessages {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_CONCAT_COUNT = 5;
    private static final long MESSAGE_CONCAT_TIMESTAMP_DELTA_THRESHOLD = 420000;
    private final Map<Long, GuildMember> guildMembers;
    private final List<ChatListEntry> items;
    private final long newMessagesMarkerMessageId;
    private final long newestKnownMessageId;
    private final Long newestSentByUserMessageId;
    private final long oldestMessageId;

    /* compiled from: WidgetChatListModelMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bd\u0010eJ)\u0010\b\u001a\u0010\u0012\f\u0012\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00070\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\tJW\u0010\u000f\u001a:\u0012\u0016\u0012\u0014 \u000e*\n\u0018\u00010\u0006j\u0004\u0018\u0001`\r0\u0006j\u0002`\r \u000e*\u001c\u0012\u0016\u0012\u0014 \u000e*\n\u0018\u00010\u0006j\u0004\u0018\u0001`\r0\u0006j\u0002`\r\u0018\u00010\u00050\u0005*\u00020\n2\n\u0010\f\u001a\u00060\u0006j\u0002`\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010JU\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0014\u001a\u00060\u0006j\u0002`\u00132\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0013\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJU\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0014\u001a\u00060\u0006j\u0002`\u00132\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0013\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJU\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0014\u001a\u00060\u0006j\u0002`\u00132\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0013\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ=\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J%\u0010*\u001a\u00020)2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u00100J/\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u00105J;\u00108\u001a\u00020.2\u0006\u00102\u001a\u0002012\n\u00106\u001a\u00060\u0006j\u0002`\r2\u0006\u00107\u001a\u00020.2\u0006\u00103\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b8\u00109J1\u0010<\u001a\u00020'2\u0006\u00102\u001a\u0002012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020.H\u0002¢\u0006\u0004\b<\u0010=J)\u0010?\u001a\u00020.2\u0006\u00102\u001a\u0002012\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b?\u0010@J\u001b\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\bB\u0010CJ-\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0D0\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\u00103\u001a\u00060\u0006j\u0002`\r¢\u0006\u0004\bE\u0010FJ\u0099\u0002\u0010\\\u001a\b\u0012\u0004\u0012\u00020%0D2\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0013\u0012\u0004\u0012\u00020\u00160\u00152\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020G0\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020'0\u00152\b\u0010J\u001a\u0004\u0018\u00010\u00032\b\u0010L\u001a\u0004\u0018\u00010K2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010N\u001a\u0004\u0018\u00010M2\u0016\u0010P\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020O0\u00152\u0006\u0010;\u001a\u00020.2\u0006\u0010Q\u001a\u00020.2\u000e\u0010\u0018\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0006\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020.2\u0006\u0010T\u001a\u00020.2\n\u0010\u0014\u001a\u00060\u0006j\u0002`\u00132\u0006\u0010U\u001a\u00020.2\u0016\u0010W\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020V0\u00152\u0006\u0010Y\u001a\u00020X2\b\b\u0002\u0010Z\u001a\u00020.2\b\b\u0002\u0010[\u001a\u00020.¢\u0006\u0004\b\\\u0010]JÁ\u0001\u0010^\u001a\b\u0012\u0004\u0012\u00020%0D2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0013\u0012\u0004\u0012\u00020\u00160\u00152\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020G0\u00152\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020'0\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020.2\u0006\u0010T\u001a\u00020.2\n\u0010\u0014\u001a\u00060\u0006j\u0002`\u00132\u0006\u0010U\u001a\u00020.2\u0016\u0010W\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020V0\u00152\u0006\u0010Y\u001a\u00020X¢\u0006\u0004\b^\u0010_R\u0016\u0010`\u001a\u00020'8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u00068\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u0010c¨\u0006f"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$Companion;", "", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "", "Lcom/discord/api/permission/PermissionBit;", "observePermissionsForChannel", "(Lcom/discord/stores/StorePermissions;Lcom/discord/api/channel/Channel;)Lrx/Observable;", "Lcom/discord/stores/StoreReadStates;", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "kotlin.jvm.PlatformType", "observeUnreadMarkerMessageId", "(Lcom/discord/stores/StoreReadStates;J)Lrx/Observable;", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/primitives/UserId;", "meUserId", "", "Lcom/discord/models/member/GuildMember;", "guildMembers", "permissionsForChannel", "Lcom/discord/widgets/chat/list/entries/MessageEntry$CtaData;", "parseCtaData", "(Lcom/discord/models/message/Message;JLjava/util/Map;Lcom/discord/api/channel/Channel;Ljava/lang/Long;)Lcom/discord/widgets/chat/list/entries/MessageEntry$CtaData;", "parseWelcomeData", "parseRoleSubscriptionPurchaseCtaData", "parentChannel", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "messagesWithMetadata", "Lkotlin/Pair;", "getThreadStarterMessageAndChannel", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/message/Message;Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;)Lkotlin/Pair;", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "messageItems", "", "threadSpineStartIndex", "", "enableThreadSpine", "(Ljava/util/List;I)V", "timestamp", "nextDayTimestamp", "", "willAddTimestamp", "(JJ)Z", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$Items;", "items", "messageId", "tryAddTimestamp", "(Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$Items;JJJ)J", "newMessagesMarkerMessageId", "messageMostRecent", "tryAddNewMessagesSeparator", "(Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$Items;JZJLcom/discord/api/channel/Channel;)Z", "blockedContiguousMessageCount", "blockedChunkExpanded", "addBlockedMessage", "(Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$Items;Lcom/discord/models/message/Message;IZ)I", "previousMessage", "shouldConcatMessage", "(Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$Items;Lcom/discord/models/message/Message;Lcom/discord/models/message/Message;)Z", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages;", "get", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "", "getSingleMessage", "(Lcom/discord/api/channel/Channel;J)Lrx/Observable;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "blockedRelationships", "thread", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "threadEmbedMetadata", "Lcom/discord/stores/StoreMessageState$State;", "messageState", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "repliedMessages", "shouldConcat", "animateEmojis", "autoPlayGifs", "renderEmbeds", "showBotComponents", "Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;", "componentStoreState", "Lcom/discord/utilities/embed/InviteEmbedModel;", "inviteEmbedModel", "isThreadStarterMessage", "showRoleSubscriptionPurchaseSystemMessage", "getMessageItems", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/api/channel/Channel;Lcom/discord/stores/StoreThreadMessages$ThreadState;Lcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;Ljava/util/Map;ZZLjava/lang/Long;ZZZJZLjava/util/Map;Lcom/discord/utilities/embed/InviteEmbedModel;ZZ)Ljava/util/List;", "getThreadStarterMessageItems", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/message/Message;Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;ZZZJZLjava/util/Map;Lcom/discord/utilities/embed/InviteEmbedModel;)Ljava/util/List;", "MAX_CONCAT_COUNT", "I", "MESSAGE_CONCAT_TIMESTAMP_DELTA_THRESHOLD", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ int access$addBlockedMessage(Companion companion, Items items, Message message, int i, boolean z2) {
            return companion.addBlockedMessage(items, message, i, z2);
        }

        public static final /* synthetic */ Tuples2 access$getThreadStarterMessageAndChannel(Companion companion, Channel channel, Channel channel2, Message message, MessagesWithMetadata messagesWithMetadata) {
            return companion.getThreadStarterMessageAndChannel(channel, channel2, message, messagesWithMetadata);
        }

        public static final /* synthetic */ boolean access$shouldConcatMessage(Companion companion, Items items, Message message, Message message2) {
            return companion.shouldConcatMessage(items, message, message2);
        }

        public static final /* synthetic */ boolean access$tryAddNewMessagesSeparator(Companion companion, Items items, long j, boolean z2, long j2, Channel channel) {
            return companion.tryAddNewMessagesSeparator(items, j, z2, j2, channel);
        }

        public static final /* synthetic */ long access$tryAddTimestamp(Companion companion, Items items, long j, long j2, long j3) {
            return companion.tryAddTimestamp(items, j, j2, j3);
        }

        public static final /* synthetic */ boolean access$willAddTimestamp(Companion companion, long j, long j2) {
            return companion.willAddTimestamp(j, j2);
        }

        private final int addBlockedMessage(Items items, Message message, int blockedContiguousMessageCount, boolean blockedChunkExpanded) {
            if (blockedContiguousMessageCount <= 0) {
                return blockedContiguousMessageCount;
            }
            Intrinsics3.checkNotNull(message);
            items.addItem(new BlockedMessagesEntry(message, blockedContiguousMessageCount, blockedChunkExpanded));
            return 0;
        }

        private final void enableThreadSpine(List<ChatListEntry> messageItems, int threadSpineStartIndex) {
            int size = messageItems.size();
            while (threadSpineStartIndex < size) {
                messageItems.get(threadSpineStartIndex).setShouldShowThreadSpine(true);
                threadSpineStartIndex++;
            }
        }

        public static /* synthetic */ List getMessageItems$default(Companion companion, Channel channel, Map map, Map map2, Map map3, Channel channel2, StoreThreadMessages.ThreadState threadState, Message message, StoreMessageState.State state, Map map4, boolean z2, boolean z3, Long l, boolean z4, boolean z5, boolean z6, long j, boolean z7, Map map5, InviteEmbedModel inviteEmbedModel, boolean z8, boolean z9, int i, Object obj) {
            return companion.getMessageItems(channel, map, map2, map3, channel2, threadState, message, state, map4, z2, z3, l, z4, z5, z6, j, z7, map5, inviteEmbedModel, (i & 524288) != 0 ? false : z8, (i & 1048576) != 0 ? false : z9);
        }

        private final Tuples2<Message, Channel> getThreadStarterMessageAndChannel(Channel parentChannel, Channel channel, Message message, MessagesWithMetadata messagesWithMetadata) {
            Message messageCreateThreadStarterMessageNotFoundMessage;
            Map<Long, StoreMessageReplies.MessageState> parentChannelMessageReplyState = messagesWithMetadata.getParentChannelMessageReplyState();
            MessageReference messageReference = message.getMessageReference();
            StoreMessageReplies.MessageState messageState = parentChannelMessageReplyState.get(messageReference != null ? messageReference.getMessageId() : null);
            if (parentChannel == null || !(messageState instanceof StoreMessageReplies.MessageState.Loaded)) {
                long id2 = channel.getId();
                User author = message.getAuthor();
                Intrinsics3.checkNotNull(author);
                messageCreateThreadStarterMessageNotFoundMessage = LocalMessageCreators.createThreadStarterMessageNotFoundMessage(id2, author, ClockFactory.get());
                parentChannel = channel;
            } else {
                messageCreateThreadStarterMessageNotFoundMessage = ((StoreMessageReplies.MessageState.Loaded) messageState).getMessage();
            }
            return new Tuples2<>(messageCreateThreadStarterMessageNotFoundMessage, parentChannel);
        }

        private final Observable<Long> observePermissionsForChannel(StorePermissions storePermissions, Channel channel) {
            if (ChannelUtils.E(channel)) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
                return scalarSynchronousObservable;
            }
            if (ChannelUtils.B(channel)) {
                ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(null);
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable2, "Observable.just(null)");
                return scalarSynchronousObservable2;
            }
            Observable<Long> observableR = storePermissions.observePermissionsForChannel(channel.getId()).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "observePermissionsForCha…  .distinctUntilChanged()");
            return observableR;
        }

        private final Observable<Long> observeUnreadMarkerMessageId(StoreReadStates storeReadStates, long j) {
            Observable<R> observableG = storeReadStates.getUnreadMarker(j).G(WidgetChatListModelMessages4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "getUnreadMarker(channelI… marker.messageId ?: 0L }");
            return ObservableExtensionsKt.computationLatest(observableG).r();
        }

        private final MessageEntry.CtaData parseCtaData(Message message, long meUserId, Map<Long, GuildMember> guildMembers, Channel channel, Long permissionsForChannel) {
            Integer type = message.getType();
            if (type != null && type.intValue() == 7) {
                return parseWelcomeData(message, meUserId, guildMembers, channel, permissionsForChannel);
            }
            if (type != null && type.intValue() == 25) {
                return parseRoleSubscriptionPurchaseCtaData(message, meUserId, guildMembers, channel, permissionsForChannel);
            }
            return null;
        }

        private final MessageEntry.CtaData parseRoleSubscriptionPurchaseCtaData(Message message, long meUserId, Map<Long, GuildMember> guildMembers, Channel channel, Long permissionsForChannel) {
            Guild guild;
            Boolean bot;
            Integer type = message.getType();
            if (type == null || type.intValue() != 25 || (guild = StoreStream.INSTANCE.getGuilds().getGuild(channel.getGuildId())) == null) {
                return null;
            }
            boolean zBooleanValue = false;
            if (!((guild.getSystemChannelFlags() & 32) == 0)) {
                return null;
            }
            GuildMember guildMember = guildMembers.get(Long.valueOf(meUserId));
            if ((guildMember != null ? guildMember.getPending() : true) || !PermissionUtils.can(Permission.SEND_MESSAGES, permissionsForChannel)) {
                return null;
            }
            User author = message.getAuthor();
            if (author != null && (bot = author.getBot()) != null) {
                zBooleanValue = bot.booleanValue();
            }
            if (zBooleanValue) {
                return null;
            }
            return new MessageEntry.CtaData(MessageUtils.INSTANCE.getRoleSubscriptionPurchaseSticker(meUserId, message.getId()), channel);
        }

        private final MessageEntry.CtaData parseWelcomeData(Message message, long meUserId, Map<Long, GuildMember> guildMembers, Channel channel, Long permissionsForChannel) {
            Guild guild;
            Boolean bot;
            Integer type = message.getType();
            if (type == null || type.intValue() != 7 || (guild = StoreStream.INSTANCE.getGuilds().getGuild(channel.getGuildId())) == null) {
                return null;
            }
            boolean zBooleanValue = false;
            if (!((guild.getSystemChannelFlags() & 8) == 0)) {
                return null;
            }
            GuildMember guildMember = guildMembers.get(Long.valueOf(meUserId));
            if ((guildMember != null ? guildMember.getPending() : true) || !PermissionUtils.can(Permission.SEND_MESSAGES, permissionsForChannel)) {
                return null;
            }
            User author = message.getAuthor();
            if (author != null && (bot = author.getBot()) != null) {
                zBooleanValue = bot.booleanValue();
            }
            if (zBooleanValue) {
                return null;
            }
            return new MessageEntry.CtaData(MessageUtils.INSTANCE.getWelcomeSticker(meUserId, message.getId()), channel);
        }

        private final boolean shouldConcatMessage(Items items, Message message, Message previousMessage) {
            Integer type;
            MGRecyclerDataPayload listItemMostRecentlyAdded;
            MGRecyclerDataPayload listItemMostRecentlyAdded2;
            MGRecyclerDataPayload listItemMostRecentlyAdded3;
            if (previousMessage == null || previousMessage.isSystemMessage() || message.hasThread() || previousMessage.hasThread()) {
                return false;
            }
            Integer type2 = message.getType();
            if ((type2 == null || type2.intValue() != 0) && ((type = message.getType()) == null || type.intValue() != -1)) {
                return false;
            }
            MGRecyclerDataPayload listItemMostRecentlyAdded4 = items.getListItemMostRecentlyAdded();
            if ((listItemMostRecentlyAdded4 == null || listItemMostRecentlyAdded4.getType() != 0) && (((listItemMostRecentlyAdded = items.getListItemMostRecentlyAdded()) == null || listItemMostRecentlyAdded.getType() != 1) && (((listItemMostRecentlyAdded2 = items.getListItemMostRecentlyAdded()) == null || listItemMostRecentlyAdded2.getType() != 21) && ((listItemMostRecentlyAdded3 = items.getListItemMostRecentlyAdded()) == null || listItemMostRecentlyAdded3.getType() != 4)))) {
                return false;
            }
            User author = previousMessage.getAuthor();
            Long lValueOf = author != null ? Long.valueOf(author.getId()) : null;
            User author2 = message.getAuthor();
            if (!Intrinsics3.areEqual(lValueOf, author2 != null ? Long.valueOf(author2.getId()) : null)) {
                return false;
            }
            UtcDateTime timestamp = message.getTimestamp();
            long dateTimeMillis = timestamp != null ? timestamp.getDateTimeMillis() : 0L;
            UtcDateTime timestamp2 = previousMessage.getTimestamp();
            if (dateTimeMillis - (timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L) >= WidgetChatListModelMessages.MESSAGE_CONCAT_TIMESTAMP_DELTA_THRESHOLD || previousMessage.hasAttachments() || previousMessage.hasEmbeds()) {
                return false;
            }
            List<User> mentions = previousMessage.getMentions();
            if (!(mentions == null || mentions.isEmpty()) || message.hasAttachments() || message.hasEmbeds()) {
                return false;
            }
            List<User> mentions2 = message.getMentions();
            if (!(mentions2 == null || mentions2.isEmpty()) || items.getConcatCount() >= 5) {
                return false;
            }
            if (message.isWebhook()) {
                User author3 = previousMessage.getAuthor();
                String username = author3 != null ? author3.getUsername() : null;
                User author4 = message.getAuthor();
                if (!Intrinsics3.areEqual(username, author4 != null ? author4.getUsername() : null)) {
                    return false;
                }
            }
            return true;
        }

        private final boolean tryAddNewMessagesSeparator(Items items, long newMessagesMarkerMessageId, boolean messageMostRecent, long messageId, Channel channel) {
            boolean z2 = !messageMostRecent && ((newMessagesMarkerMessageId > 0L ? 1 : (newMessagesMarkerMessageId == 0L ? 0 : -1)) > 0) && MessageUtils.compareMessages(Long.valueOf(messageId), Long.valueOf(newMessagesMarkerMessageId)) == 0;
            if (z2) {
                items.addItem(new NewMessagesEntry(channel.getId(), messageId));
            }
            return z2;
        }

        private final long tryAddTimestamp(Items items, long messageId, long timestamp, long nextDayTimestamp) {
            if (!willAddTimestamp(timestamp, nextDayTimestamp)) {
                return nextDayTimestamp;
            }
            items.addItem(new TimestampEntry(messageId, timestamp));
            Calendar calendar = TimeUtils.toCalendar(timestamp);
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            return calendar.getTimeInMillis();
        }

        private final boolean willAddTimestamp(long timestamp, long nextDayTimestamp) {
            return timestamp > nextDayTimestamp;
        }

        public final Observable<WidgetChatListModelMessages> get(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Observable<MessagesWithMetadata> observable = MessagesWithMetadata.INSTANCE.get(channel);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Channel> observableObserveChannel = companion.getChannels().observeChannel(channel.getParentId());
            Observable<Map<Long, Integer>> observableObserveForType = companion.getUserRelationships().observeForType(2);
            Observable<List<Long>> observableObserveExpandedBlockedMessageIds = companion.getChat().observeExpandedBlockedMessageIds();
            Observable<Map<Long, GuildMember>> observableObserveGuildMembers = companion.getGuilds().observeGuildMembers(channel.getGuildId());
            Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMembers, "StoreStream\n            …dMembers(channel.guildId)");
            Observable<Long> observableObserveUnreadMarkerMessageId = observeUnreadMarkerMessageId(companion.getReadStates(), channel.getId());
            Intrinsics3.checkNotNullExpressionValue(observableObserveUnreadMarkerMessageId, "StoreStream\n            …rkerMessageId(channel.id)");
            return ObservableCombineLatestOverloads2.combineLatest(observable, observableObserveChannel, observableObserveForType, observableObserveExpandedBlockedMessageIds, observableObserveGuildMembers, observableObserveUnreadMarkerMessageId, companion.getGuilds().observeRoles(channel.getGuildId()), observePermissionsForChannel(companion.getPermissions(), channel), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion.getUserSettings(), false, 1, null), companion.getUserSettings().observeIsRenderEmbedsEnabled(), companion.getUsers().observeMeId(), ComponentChatListState.INSTANCE.observeChatListComponentState(), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long.valueOf(channel.getGuildId())), new WidgetChatListModelMessages2(channel));
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public final java.util.List<com.discord.widgets.chat.list.entries.ChatListEntry> getMessageItems(com.discord.api.channel.Channel r32, java.util.Map<java.lang.Long, com.discord.models.member.GuildMember> r33, java.util.Map<java.lang.Long, com.discord.api.role.GuildRole> r34, java.util.Map<java.lang.Long, java.lang.Integer> r35, com.discord.api.channel.Channel r36, com.discord.stores.StoreThreadMessages.ThreadState r37, com.discord.models.message.Message r38, com.discord.stores.StoreMessageState.State r39, java.util.Map<java.lang.Long, ? extends com.discord.stores.StoreMessageReplies.MessageState> r40, boolean r41, boolean r42, java.lang.Long r43, boolean r44, boolean r45, boolean r46, long r47, boolean r49, java.util.Map<java.lang.Long, com.discord.widgets.botuikit.ComponentChatListState.ComponentStoreState> r50, com.discord.utilities.embed.InviteEmbedModel r51, boolean r52, boolean r53) {
            /*
                Method dump skipped, instructions count: 904
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.discord.widgets.chat.list.model.WidgetChatListModelMessages.Companion.getMessageItems(com.discord.api.channel.Channel, java.util.Map, java.util.Map, java.util.Map, com.discord.api.channel.Channel, com.discord.stores.StoreThreadMessages$ThreadState, com.discord.models.message.Message, com.discord.stores.StoreMessageState$State, java.util.Map, boolean, boolean, java.lang.Long, boolean, boolean, boolean, long, boolean, java.util.Map, com.discord.utilities.embed.InviteEmbedModel, boolean, boolean):java.util.List");
        }

        public final Observable<List<ChatListEntry>> getSingleMessage(Channel channel, long messageId) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Message> observableObserveMessagesForChannel = companion.getMessages().observeMessagesForChannel(channel.getId(), messageId);
            Observable<MessagesWithMetadata> observable = MessagesWithMetadata.INSTANCE.get(channel);
            Observable<Map<Long, GuildMember>> observableObserveGuildMembers = companion.getGuilds().observeGuildMembers(channel.getGuildId());
            Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMembers, "StoreStream\n            …dMembers(channel.guildId)");
            return ObservableCombineLatestOverloads2.combineLatest(observableObserveMessagesForChannel, observable, observableObserveGuildMembers, companion.getGuilds().observeRoles(channel.getGuildId()), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), StoreUserSettings.observeIsAutoPlayGifsEnabled$default(companion.getUserSettings(), false, 1, null), companion.getUsers().observeMeId(), companion.getUserSettings().observeIsRenderEmbedsEnabled(), InviteEmbedModel.Companion.observe$default(InviteEmbedModel.INSTANCE, null, null, null, null, 15, null), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long.valueOf(channel.getGuildId())), new WidgetChatListModelMessages3(channel, messageId));
        }

        public final List<ChatListEntry> getThreadStarterMessageItems(Channel parentChannel, Channel channel, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, Integer> blockedRelationships, Message message, MessagesWithMetadata messagesWithMetadata, boolean animateEmojis, boolean autoPlayGifs, boolean renderEmbeds, long meUserId, boolean showBotComponents, Map<Long, ComponentChatListState.ComponentStoreState> componentStoreState, InviteEmbedModel inviteEmbedModel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
            Intrinsics3.checkNotNullParameter(blockedRelationships, "blockedRelationships");
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
            Intrinsics3.checkNotNullParameter(componentStoreState, "componentStoreState");
            Intrinsics3.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
            Tuples2<Message, Channel> threadStarterMessageAndChannel = getThreadStarterMessageAndChannel(parentChannel, channel, message, messagesWithMetadata);
            Message first = threadStarterMessageAndChannel.getFirst();
            return getMessageItems$default(this, threadStarterMessageAndChannel.getSecond(), guildMembers, guildRoles, blockedRelationships, null, null, first, messagesWithMetadata.getMessageState().get(Long.valueOf(first.getId())), messagesWithMetadata.getParentChannelMessageReplyState(), false, false, null, animateEmojis, autoPlayGifs, renderEmbeds, meUserId, showBotComponents, componentStoreState, inviteEmbedModel, true, false, 1048576, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListModelMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\b \u0010\u001eJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0007R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$Items;", "", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "itemList", "", "addItems", "(Ljava/util/List;)V", "item", "addItem", "(Lcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "listItemMostRecentlyAdded", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "getListItemMostRecentlyAdded", "()Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "setListItemMostRecentlyAdded", "(Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "", "concatCount", "I", "getConcatCount", "()I", "setConcatCount", "(I)V", "size", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Items {
        private static final Companion Companion = new Companion(null);

        @Deprecated
        private static final int LIST_CAPACITY_BUFFER = 10;
        private int concatCount;
        private List<ChatListEntry> items;
        private MGRecyclerDataPayload listItemMostRecentlyAdded;

        /* compiled from: WidgetChatListModelMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$Items$Companion;", "", "", "LIST_CAPACITY_BUFFER", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Items(int i) {
            this.items = new ArrayList(i + 10);
        }

        public final void addItem(ChatListEntry item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            this.items.add(item);
            this.listItemMostRecentlyAdded = item;
        }

        public final void addItems(List<? extends ChatListEntry> itemList) {
            Intrinsics3.checkNotNullParameter(itemList, "itemList");
            if (itemList.isEmpty()) {
                return;
            }
            this.items.addAll(itemList);
            this.listItemMostRecentlyAdded = itemList.get(itemList.size() - 1);
        }

        public final int getConcatCount() {
            return this.concatCount;
        }

        public final List<ChatListEntry> getItems() {
            return this.items;
        }

        public final MGRecyclerDataPayload getListItemMostRecentlyAdded() {
            return this.listItemMostRecentlyAdded;
        }

        public final void setConcatCount(int i) {
            this.concatCount = i;
        }

        public final void setItems(List<ChatListEntry> list) {
            Intrinsics3.checkNotNullParameter(list, "<set-?>");
            this.items = list;
        }

        public final void setListItemMostRecentlyAdded(MGRecyclerDataPayload mGRecyclerDataPayload) {
            this.listItemMostRecentlyAdded = mGRecyclerDataPayload;
        }
    }

    /* compiled from: WidgetChatListModelMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010B\u008d\u0001\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0016\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0016\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\r0\u0006\u0012\u0016\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\u000f0\u0006\u0012\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u0006\u0012\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u0006¢\u0006\u0004\b.\u0010/J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\r0\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ \u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\u000f0\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ \u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u0006HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ \u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u0006HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ¢\u0001\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00062\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\r0\u00062\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\u000f0\u00062\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u00062\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u0006HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010\u0005R)\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\r0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u000bR)\u0010\u0017\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\f\u0012\u0004\u0012\u00020\u000f0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b*\u0010\u000bR)\u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b+\u0010\u000bR)\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b,\u0010\u000bR)\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b-\u0010\u000b¨\u00061"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "", "", "Lcom/discord/models/message/Message;", "component1", "()Ljava/util/List;", "", "", "Lcom/discord/primitives/MessageId;", "Lcom/discord/stores/StoreMessageState$State;", "component2", "()Ljava/util/Map;", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "component3", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "component4", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "component5", "component6", "messages", "messageState", "messageThreads", "threadCountsAndLatestMessages", "messageReplyState", "parentChannelMessageReplyState", "copy", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMessages", "Ljava/util/Map;", "getMessageThreads", "getThreadCountsAndLatestMessages", "getMessageState", "getParentChannelMessageReplyState", "getMessageReplyState", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MessagesWithMetadata {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<Long, StoreMessageReplies.MessageState> messageReplyState;
        private final Map<Long, StoreMessageState.State> messageState;
        private final Map<Long, Channel> messageThreads;
        private final List<Message> messages;
        private final Map<Long, StoreMessageReplies.MessageState> parentChannelMessageReplyState;
        private final Map<Long, StoreThreadMessages.ThreadState> threadCountsAndLatestMessages;

        /* compiled from: WidgetChatListModelMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata$Companion;", "", "", "Lcom/discord/models/message/Message;", "messages", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "get", "(Ljava/util/List;)Lrx/Observable;", "Lcom/discord/api/channel/Channel;", "channel", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<MessagesWithMetadata> get(List<Message> messages) {
                Intrinsics3.checkNotNullParameter(messages, "messages");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<MessagesWithMetadata> observableI = Observable.i(companion.getMessageState().getMessageState(), companion.getChannels().observeThreadsFromMessages(messages), companion.getThreadMessages().observeThreadCountAndLatestMessage(), new WidgetChatListModelMessages5(messages));
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n            .…          )\n            }");
                return observableI;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Observable<MessagesWithMetadata> get(Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Observable observableY = StoreStream.INSTANCE.getMessages().observeMessagesForChannel(channel.getId()).Y(new WidgetChatListModelMessages6(channel));
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        )\n              }");
                return observableY;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MessagesWithMetadata(List<Message> list, Map<Long, StoreMessageState.State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
            Intrinsics3.checkNotNullParameter(list, "messages");
            Intrinsics3.checkNotNullParameter(map, "messageState");
            Intrinsics3.checkNotNullParameter(map2, "messageThreads");
            Intrinsics3.checkNotNullParameter(map3, "threadCountsAndLatestMessages");
            Intrinsics3.checkNotNullParameter(map4, "messageReplyState");
            Intrinsics3.checkNotNullParameter(map5, "parentChannelMessageReplyState");
            this.messages = list;
            this.messageState = map;
            this.messageThreads = map2;
            this.threadCountsAndLatestMessages = map3;
            this.messageReplyState = map4;
            this.parentChannelMessageReplyState = map5;
        }

        public static /* synthetic */ MessagesWithMetadata copy$default(MessagesWithMetadata messagesWithMetadata, List list, Map map, Map map2, Map map3, Map map4, Map map5, int i, Object obj) {
            if ((i & 1) != 0) {
                list = messagesWithMetadata.messages;
            }
            if ((i & 2) != 0) {
                map = messagesWithMetadata.messageState;
            }
            Map map6 = map;
            if ((i & 4) != 0) {
                map2 = messagesWithMetadata.messageThreads;
            }
            Map map7 = map2;
            if ((i & 8) != 0) {
                map3 = messagesWithMetadata.threadCountsAndLatestMessages;
            }
            Map map8 = map3;
            if ((i & 16) != 0) {
                map4 = messagesWithMetadata.messageReplyState;
            }
            Map map9 = map4;
            if ((i & 32) != 0) {
                map5 = messagesWithMetadata.parentChannelMessageReplyState;
            }
            return messagesWithMetadata.copy(list, map6, map7, map8, map9, map5);
        }

        public final List<Message> component1() {
            return this.messages;
        }

        public final Map<Long, StoreMessageState.State> component2() {
            return this.messageState;
        }

        public final Map<Long, Channel> component3() {
            return this.messageThreads;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> component4() {
            return this.threadCountsAndLatestMessages;
        }

        public final Map<Long, StoreMessageReplies.MessageState> component5() {
            return this.messageReplyState;
        }

        public final Map<Long, StoreMessageReplies.MessageState> component6() {
            return this.parentChannelMessageReplyState;
        }

        public final MessagesWithMetadata copy(List<Message> messages, Map<Long, StoreMessageState.State> messageState, Map<Long, Channel> messageThreads, Map<Long, StoreThreadMessages.ThreadState> threadCountsAndLatestMessages, Map<Long, ? extends StoreMessageReplies.MessageState> messageReplyState, Map<Long, ? extends StoreMessageReplies.MessageState> parentChannelMessageReplyState) {
            Intrinsics3.checkNotNullParameter(messages, "messages");
            Intrinsics3.checkNotNullParameter(messageState, "messageState");
            Intrinsics3.checkNotNullParameter(messageThreads, "messageThreads");
            Intrinsics3.checkNotNullParameter(threadCountsAndLatestMessages, "threadCountsAndLatestMessages");
            Intrinsics3.checkNotNullParameter(messageReplyState, "messageReplyState");
            Intrinsics3.checkNotNullParameter(parentChannelMessageReplyState, "parentChannelMessageReplyState");
            return new MessagesWithMetadata(messages, messageState, messageThreads, threadCountsAndLatestMessages, messageReplyState, parentChannelMessageReplyState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessagesWithMetadata)) {
                return false;
            }
            MessagesWithMetadata messagesWithMetadata = (MessagesWithMetadata) other;
            return Intrinsics3.areEqual(this.messages, messagesWithMetadata.messages) && Intrinsics3.areEqual(this.messageState, messagesWithMetadata.messageState) && Intrinsics3.areEqual(this.messageThreads, messagesWithMetadata.messageThreads) && Intrinsics3.areEqual(this.threadCountsAndLatestMessages, messagesWithMetadata.threadCountsAndLatestMessages) && Intrinsics3.areEqual(this.messageReplyState, messagesWithMetadata.messageReplyState) && Intrinsics3.areEqual(this.parentChannelMessageReplyState, messagesWithMetadata.parentChannelMessageReplyState);
        }

        public final Map<Long, StoreMessageReplies.MessageState> getMessageReplyState() {
            return this.messageReplyState;
        }

        public final Map<Long, StoreMessageState.State> getMessageState() {
            return this.messageState;
        }

        public final Map<Long, Channel> getMessageThreads() {
            return this.messageThreads;
        }

        public final List<Message> getMessages() {
            return this.messages;
        }

        public final Map<Long, StoreMessageReplies.MessageState> getParentChannelMessageReplyState() {
            return this.parentChannelMessageReplyState;
        }

        public final Map<Long, StoreThreadMessages.ThreadState> getThreadCountsAndLatestMessages() {
            return this.threadCountsAndLatestMessages;
        }

        public int hashCode() {
            List<Message> list = this.messages;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, StoreMessageState.State> map = this.messageState;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Channel> map2 = this.messageThreads;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, StoreThreadMessages.ThreadState> map3 = this.threadCountsAndLatestMessages;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, StoreMessageReplies.MessageState> map4 = this.messageReplyState;
            int iHashCode5 = (iHashCode4 + (map4 != null ? map4.hashCode() : 0)) * 31;
            Map<Long, StoreMessageReplies.MessageState> map5 = this.parentChannelMessageReplyState;
            return iHashCode5 + (map5 != null ? map5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MessagesWithMetadata(messages=");
            sbU.append(this.messages);
            sbU.append(", messageState=");
            sbU.append(this.messageState);
            sbU.append(", messageThreads=");
            sbU.append(this.messageThreads);
            sbU.append(", threadCountsAndLatestMessages=");
            sbU.append(this.threadCountsAndLatestMessages);
            sbU.append(", messageReplyState=");
            sbU.append(this.messageReplyState);
            sbU.append(", parentChannelMessageReplyState=");
            return outline.M(sbU, this.parentChannelMessageReplyState, ")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListModelMessages(List<? extends ChatListEntry> list, long j, long j2, Map<Long, GuildMember> map, long j3, Long l) {
        Intrinsics3.checkNotNullParameter(list, "items");
        this.items = list;
        this.oldestMessageId = j;
        this.newestKnownMessageId = j2;
        this.guildMembers = map;
        this.newMessagesMarkerMessageId = j3;
        this.newestSentByUserMessageId = l;
    }

    public static /* synthetic */ WidgetChatListModelMessages copy$default(WidgetChatListModelMessages widgetChatListModelMessages, List list, long j, long j2, Map map, long j3, Long l, int i, Object obj) {
        return widgetChatListModelMessages.copy((i & 1) != 0 ? widgetChatListModelMessages.items : list, (i & 2) != 0 ? widgetChatListModelMessages.oldestMessageId : j, (i & 4) != 0 ? widgetChatListModelMessages.newestKnownMessageId : j2, (i & 8) != 0 ? widgetChatListModelMessages.guildMembers : map, (i & 16) != 0 ? widgetChatListModelMessages.newMessagesMarkerMessageId : j3, (i & 32) != 0 ? widgetChatListModelMessages.newestSentByUserMessageId : l);
    }

    public final List<ChatListEntry> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final long getOldestMessageId() {
        return this.oldestMessageId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    public final Map<Long, GuildMember> component4() {
        return this.guildMembers;
    }

    /* renamed from: component5, reason: from getter */
    public final long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getNewestSentByUserMessageId() {
        return this.newestSentByUserMessageId;
    }

    public final WidgetChatListModelMessages copy(List<? extends ChatListEntry> items, long oldestMessageId, long newestKnownMessageId, Map<Long, GuildMember> guildMembers, long newMessagesMarkerMessageId, Long newestSentByUserMessageId) {
        Intrinsics3.checkNotNullParameter(items, "items");
        return new WidgetChatListModelMessages(items, oldestMessageId, newestKnownMessageId, guildMembers, newMessagesMarkerMessageId, newestSentByUserMessageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListModelMessages)) {
            return false;
        }
        WidgetChatListModelMessages widgetChatListModelMessages = (WidgetChatListModelMessages) other;
        return Intrinsics3.areEqual(this.items, widgetChatListModelMessages.items) && this.oldestMessageId == widgetChatListModelMessages.oldestMessageId && this.newestKnownMessageId == widgetChatListModelMessages.newestKnownMessageId && Intrinsics3.areEqual(this.guildMembers, widgetChatListModelMessages.guildMembers) && this.newMessagesMarkerMessageId == widgetChatListModelMessages.newMessagesMarkerMessageId && Intrinsics3.areEqual(this.newestSentByUserMessageId, widgetChatListModelMessages.newestSentByUserMessageId);
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final List<ChatListEntry> getItems() {
        return this.items;
    }

    public final long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    public final Long getNewestSentByUserMessageId() {
        return this.newestSentByUserMessageId;
    }

    public final long getOldestMessageId() {
        return this.oldestMessageId;
    }

    public int hashCode() {
        List<ChatListEntry> list = this.items;
        int iA = (b.a(this.newestKnownMessageId) + ((b.a(this.oldestMessageId) + ((list != null ? list.hashCode() : 0) * 31)) * 31)) * 31;
        Map<Long, GuildMember> map = this.guildMembers;
        int iA2 = (b.a(this.newMessagesMarkerMessageId) + ((iA + (map != null ? map.hashCode() : 0)) * 31)) * 31;
        Long l = this.newestSentByUserMessageId;
        return iA2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetChatListModelMessages(items=");
        sbU.append(this.items);
        sbU.append(", oldestMessageId=");
        sbU.append(this.oldestMessageId);
        sbU.append(", newestKnownMessageId=");
        sbU.append(this.newestKnownMessageId);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", newMessagesMarkerMessageId=");
        sbU.append(this.newMessagesMarkerMessageId);
        sbU.append(", newestSentByUserMessageId=");
        return outline.G(sbU, this.newestSentByUserMessageId, ")");
    }
}
