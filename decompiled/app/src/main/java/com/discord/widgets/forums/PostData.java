package com.discord.widgets.forums;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: PostData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b;\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u00100\u001a\u00020\u0002\u0012\b\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\u00102\u001a\u00060\bj\u0002`\t\u0012\u0016\u00103\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\r0\f\u0012\u0016\u00104\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\f\u0012\u0016\u00105\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\f\u0012\b\u00106\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u00107\u001a\u00020\u0019\u0012\b\u00108\u001a\u0004\u0018\u00010\b\u0012\b\u00109\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010:\u001a\u0004\u0018\u00010!\u0012\b\u0010;\u001a\u0004\u0018\u00010$\u0012\u0006\u0010<\u001a\u00020\u0019\u0012\u0006\u0010=\u001a\u00020(\u0012\b\u0010>\u001a\u0004\u0018\u00010\u001e\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020-0,¢\u0006\u0004\bf\u0010gJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ \u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010%\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b'\u0010\u001bJ\u0010\u0010)\u001a\u00020(HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0012\u0010+\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b+\u0010 J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,HÆ\u0003¢\u0006\u0004\b.\u0010/Jø\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u00100\u001a\u00020\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\f\b\u0002\u00102\u001a\u00060\bj\u0002`\t2\u0018\b\u0002\u00103\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\r0\f2\u0018\b\u0002\u00104\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\f2\u0018\b\u0002\u00105\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\f2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u00107\u001a\u00020\u00192\n\b\u0002\u00108\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010<\u001a\u00020\u00192\b\b\u0002\u0010=\u001a\u00020(2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001e2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020-0,HÆ\u0001¢\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\bD\u0010EJ\u001a\u0010G\u001a\u00020\u00192\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bG\u0010HR\u001b\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010I\u001a\u0004\bJ\u0010\u0007R\u0019\u0010K\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bK\u0010\u001bR)\u00104\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\f8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010M\u001a\u0004\bN\u0010\u000fR)\u00105\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010M\u001a\u0004\bO\u0010\u000fR\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010P\u001a\u0004\bQ\u0010/R\u0019\u00107\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010L\u001a\u0004\b7\u0010\u001bR\u001b\u0010;\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010R\u001a\u0004\bS\u0010&R\u0019\u00100\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010T\u001a\u0004\bU\u0010\u0004R\u0019\u0010V\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010L\u001a\u0004\bV\u0010\u001bR\u001b\u00106\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010W\u001a\u0004\bX\u0010\u0018R\u0019\u0010<\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010L\u001a\u0004\b<\u0010\u001bR)\u00103\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010M\u001a\u0004\bY\u0010\u000fR\u001b\u00109\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010Z\u001a\u0004\b[\u0010 R\u001b\u0010>\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010Z\u001a\u0004\b\\\u0010 R\u001b\u0010:\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010]\u001a\u0004\b^\u0010#R\u0019\u0010_\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010L\u001a\u0004\b_\u0010\u001bR\u001d\u00102\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010`\u001a\u0004\ba\u0010\u000bR\u0019\u0010=\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010b\u001a\u0004\bc\u0010*R\u001b\u00108\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010d\u001a\u0004\be\u0010\u001d¨\u0006h"}, d2 = {"Lcom/discord/widgets/forums/PostData;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/user/User;", "component2", "()Lcom/discord/models/user/User;", "", "Lcom/discord/primitives/UserId;", "component3", "()J", "", "Lcom/discord/models/member/GuildMember;", "component4", "()Ljava/util/Map;", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component5", "Lcom/discord/primitives/ChannelId;", "", "component6", "Lcom/discord/models/message/Message;", "component7", "()Lcom/discord/models/message/Message;", "", "component8", "()Z", "component9", "()Ljava/lang/Long;", "", "component10", "()Ljava/lang/Integer;", "Lcom/discord/widgets/forums/PostTagData;", "component11", "()Lcom/discord/widgets/forums/PostTagData;", "Lcom/discord/api/message/reaction/MessageReaction;", "component12", "()Lcom/discord/api/message/reaction/MessageReaction;", "component13", "Lcom/discord/widgets/forums/ForumPostReadState;", "component14", "()Lcom/discord/widgets/forums/ForumPostReadState;", "component15", "", "Lcom/discord/models/guild/UserGuildMember;", "component16", "()Ljava/util/List;", "channel", "owner", "myUserId", "guildMembers", "guildRoles", "channelNames", "firstMessage", "isFirstMessageBlocked", "mostRecentMessageTimestamp", "messageCount", "tag", "mostCommonReaction", "isDefaultReaction", "readState", "unreadCount", "typingUsers", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/user/User;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/message/Message;ZLjava/lang/Long;Ljava/lang/Integer;Lcom/discord/widgets/forums/PostTagData;Lcom/discord/api/message/reaction/MessageReaction;ZLcom/discord/widgets/forums/ForumPostReadState;Ljava/lang/Integer;Ljava/util/List;)Lcom/discord/widgets/forums/PostData;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/User;", "getOwner", "isPinned", "Z", "Ljava/util/Map;", "getGuildRoles", "getChannelNames", "Ljava/util/List;", "getTypingUsers", "Lcom/discord/api/message/reaction/MessageReaction;", "getMostCommonReaction", "Lcom/discord/api/channel/Channel;", "getChannel", "isActivePost", "Lcom/discord/models/message/Message;", "getFirstMessage", "getGuildMembers", "Ljava/lang/Integer;", "getMessageCount", "getUnreadCount", "Lcom/discord/widgets/forums/PostTagData;", "getTag", "isMe", "J", "getMyUserId", "Lcom/discord/widgets/forums/ForumPostReadState;", "getReadState", "Ljava/lang/Long;", "getMostRecentMessageTimestamp", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/user/User;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/message/Message;ZLjava/lang/Long;Ljava/lang/Integer;Lcom/discord/widgets/forums/PostTagData;Lcom/discord/api/message/reaction/MessageReaction;ZLcom/discord/widgets/forums/ForumPostReadState;Ljava/lang/Integer;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class PostData {
    private final Channel channel;
    private final Map<Long, String> channelNames;
    private final Message firstMessage;
    private final Map<Long, GuildMember> guildMembers;
    private final Map<Long, GuildRole> guildRoles;
    private final boolean isActivePost;
    private final boolean isDefaultReaction;
    private final boolean isFirstMessageBlocked;
    private final boolean isMe;
    private final boolean isPinned;
    private final Integer messageCount;
    private final MessageReaction mostCommonReaction;
    private final Long mostRecentMessageTimestamp;
    private final long myUserId;
    private final User owner;
    private final ForumPostReadState readState;
    private final PostData2 tag;
    private final List<UserGuildMember> typingUsers;
    private final Integer unreadCount;

    public PostData(Channel channel, User user, long j, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, String> map3, Message message, boolean z2, Long l, Integer num, PostData2 postData2, MessageReaction messageReaction, boolean z3, ForumPostReadState forumPostReadState, Integer num2, List<UserGuildMember> list) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, "guildMembers");
        Intrinsics3.checkNotNullParameter(map2, "guildRoles");
        Intrinsics3.checkNotNullParameter(map3, "channelNames");
        Intrinsics3.checkNotNullParameter(forumPostReadState, "readState");
        Intrinsics3.checkNotNullParameter(list, "typingUsers");
        this.channel = channel;
        this.owner = user;
        this.myUserId = j;
        this.guildMembers = map;
        this.guildRoles = map2;
        this.channelNames = map3;
        this.firstMessage = message;
        this.isFirstMessageBlocked = z2;
        this.mostRecentMessageTimestamp = l;
        this.messageCount = num;
        this.tag = postData2;
        this.mostCommonReaction = messageReaction;
        this.isDefaultReaction = z3;
        this.readState = forumPostReadState;
        this.unreadCount = num2;
        this.typingUsers = list;
        this.isActivePost = !ChannelUtils.j(channel);
        this.isPinned = ChannelUtils.A(channel);
        this.isMe = user != null && user.getId() == j;
    }

    public static /* synthetic */ PostData copy$default(PostData postData, Channel channel, User user, long j, Map map, Map map2, Map map3, Message message, boolean z2, Long l, Integer num, PostData2 postData2, MessageReaction messageReaction, boolean z3, ForumPostReadState forumPostReadState, Integer num2, List list, int i, Object obj) {
        return postData.copy((i & 1) != 0 ? postData.channel : channel, (i & 2) != 0 ? postData.owner : user, (i & 4) != 0 ? postData.myUserId : j, (i & 8) != 0 ? postData.guildMembers : map, (i & 16) != 0 ? postData.guildRoles : map2, (i & 32) != 0 ? postData.channelNames : map3, (i & 64) != 0 ? postData.firstMessage : message, (i & 128) != 0 ? postData.isFirstMessageBlocked : z2, (i & 256) != 0 ? postData.mostRecentMessageTimestamp : l, (i & 512) != 0 ? postData.messageCount : num, (i & 1024) != 0 ? postData.tag : postData2, (i & 2048) != 0 ? postData.mostCommonReaction : messageReaction, (i & 4096) != 0 ? postData.isDefaultReaction : z3, (i & 8192) != 0 ? postData.readState : forumPostReadState, (i & 16384) != 0 ? postData.unreadCount : num2, (i & 32768) != 0 ? postData.typingUsers : list);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getMessageCount() {
        return this.messageCount;
    }

    /* renamed from: component11, reason: from getter */
    public final PostData2 getTag() {
        return this.tag;
    }

    /* renamed from: component12, reason: from getter */
    public final MessageReaction getMostCommonReaction() {
        return this.mostCommonReaction;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsDefaultReaction() {
        return this.isDefaultReaction;
    }

    /* renamed from: component14, reason: from getter */
    public final ForumPostReadState getReadState() {
        return this.readState;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getUnreadCount() {
        return this.unreadCount;
    }

    public final List<UserGuildMember> component16() {
        return this.typingUsers;
    }

    /* renamed from: component2, reason: from getter */
    public final User getOwner() {
        return this.owner;
    }

    /* renamed from: component3, reason: from getter */
    public final long getMyUserId() {
        return this.myUserId;
    }

    public final Map<Long, GuildMember> component4() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> component5() {
        return this.guildRoles;
    }

    public final Map<Long, String> component6() {
        return this.channelNames;
    }

    /* renamed from: component7, reason: from getter */
    public final Message getFirstMessage() {
        return this.firstMessage;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsFirstMessageBlocked() {
        return this.isFirstMessageBlocked;
    }

    /* renamed from: component9, reason: from getter */
    public final Long getMostRecentMessageTimestamp() {
        return this.mostRecentMessageTimestamp;
    }

    public final PostData copy(Channel channel, User owner, long myUserId, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Message firstMessage, boolean isFirstMessageBlocked, Long mostRecentMessageTimestamp, Integer messageCount, PostData2 tag, MessageReaction mostCommonReaction, boolean isDefaultReaction, ForumPostReadState readState, Integer unreadCount, List<UserGuildMember> typingUsers) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
        Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
        Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
        Intrinsics3.checkNotNullParameter(readState, "readState");
        Intrinsics3.checkNotNullParameter(typingUsers, "typingUsers");
        return new PostData(channel, owner, myUserId, guildMembers, guildRoles, channelNames, firstMessage, isFirstMessageBlocked, mostRecentMessageTimestamp, messageCount, tag, mostCommonReaction, isDefaultReaction, readState, unreadCount, typingUsers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostData)) {
            return false;
        }
        PostData postData = (PostData) other;
        return Intrinsics3.areEqual(this.channel, postData.channel) && Intrinsics3.areEqual(this.owner, postData.owner) && this.myUserId == postData.myUserId && Intrinsics3.areEqual(this.guildMembers, postData.guildMembers) && Intrinsics3.areEqual(this.guildRoles, postData.guildRoles) && Intrinsics3.areEqual(this.channelNames, postData.channelNames) && Intrinsics3.areEqual(this.firstMessage, postData.firstMessage) && this.isFirstMessageBlocked == postData.isFirstMessageBlocked && Intrinsics3.areEqual(this.mostRecentMessageTimestamp, postData.mostRecentMessageTimestamp) && Intrinsics3.areEqual(this.messageCount, postData.messageCount) && Intrinsics3.areEqual(this.tag, postData.tag) && Intrinsics3.areEqual(this.mostCommonReaction, postData.mostCommonReaction) && this.isDefaultReaction == postData.isDefaultReaction && Intrinsics3.areEqual(this.readState, postData.readState) && Intrinsics3.areEqual(this.unreadCount, postData.unreadCount) && Intrinsics3.areEqual(this.typingUsers, postData.typingUsers);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final Message getFirstMessage() {
        return this.firstMessage;
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final Integer getMessageCount() {
        return this.messageCount;
    }

    public final MessageReaction getMostCommonReaction() {
        return this.mostCommonReaction;
    }

    public final Long getMostRecentMessageTimestamp() {
        return this.mostRecentMessageTimestamp;
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    public final User getOwner() {
        return this.owner;
    }

    public final ForumPostReadState getReadState() {
        return this.readState;
    }

    public final PostData2 getTag() {
        return this.tag;
    }

    public final List<UserGuildMember> getTypingUsers() {
        return this.typingUsers;
    }

    public final Integer getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        User user = this.owner;
        int iA = (b.a(this.myUserId) + ((iHashCode + (user != null ? user.hashCode() : 0)) * 31)) * 31;
        Map<Long, GuildMember> map = this.guildMembers;
        int iHashCode2 = (iA + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map2 = this.guildRoles;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, String> map3 = this.channelNames;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Message message = this.firstMessage;
        int iHashCode5 = (iHashCode4 + (message != null ? message.hashCode() : 0)) * 31;
        boolean z2 = this.isFirstMessageBlocked;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode5 + i) * 31;
        Long l = this.mostRecentMessageTimestamp;
        int iHashCode6 = (i2 + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.messageCount;
        int iHashCode7 = (iHashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        PostData2 postData2 = this.tag;
        int iHashCode8 = (iHashCode7 + (postData2 != null ? postData2.hashCode() : 0)) * 31;
        MessageReaction messageReaction = this.mostCommonReaction;
        int iHashCode9 = (iHashCode8 + (messageReaction != null ? messageReaction.hashCode() : 0)) * 31;
        boolean z3 = this.isDefaultReaction;
        int i3 = (iHashCode9 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        ForumPostReadState forumPostReadState = this.readState;
        int iHashCode10 = (i3 + (forumPostReadState != null ? forumPostReadState.hashCode() : 0)) * 31;
        Integer num2 = this.unreadCount;
        int iHashCode11 = (iHashCode10 + (num2 != null ? num2.hashCode() : 0)) * 31;
        List<UserGuildMember> list = this.typingUsers;
        return iHashCode11 + (list != null ? list.hashCode() : 0);
    }

    /* renamed from: isActivePost, reason: from getter */
    public final boolean getIsActivePost() {
        return this.isActivePost;
    }

    public final boolean isDefaultReaction() {
        return this.isDefaultReaction;
    }

    public final boolean isFirstMessageBlocked() {
        return this.isFirstMessageBlocked;
    }

    /* renamed from: isMe, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    /* renamed from: isPinned, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    public String toString() {
        StringBuilder sbU = outline.U("PostData(channel=");
        sbU.append(this.channel);
        sbU.append(", owner=");
        sbU.append(this.owner);
        sbU.append(", myUserId=");
        sbU.append(this.myUserId);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", firstMessage=");
        sbU.append(this.firstMessage);
        sbU.append(", isFirstMessageBlocked=");
        sbU.append(this.isFirstMessageBlocked);
        sbU.append(", mostRecentMessageTimestamp=");
        sbU.append(this.mostRecentMessageTimestamp);
        sbU.append(", messageCount=");
        sbU.append(this.messageCount);
        sbU.append(", tag=");
        sbU.append(this.tag);
        sbU.append(", mostCommonReaction=");
        sbU.append(this.mostCommonReaction);
        sbU.append(", isDefaultReaction=");
        sbU.append(this.isDefaultReaction);
        sbU.append(", readState=");
        sbU.append(this.readState);
        sbU.append(", unreadCount=");
        sbU.append(this.unreadCount);
        sbU.append(", typingUsers=");
        return outline.L(sbU, this.typingUsers, ")");
    }
}
