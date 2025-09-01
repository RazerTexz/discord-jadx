package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.ForumTag;
import com.discord.models.member.GuildMember;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: StartOfChatEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\u0010\u001f\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\t\u0012\b\u0010%\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010'\u001a\u00020\u0006\u0012\u0006\u0010(\u001a\u00020\t\u0012\u0006\u0010)\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020\t\u0012\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0012\u0010,\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u001d\u0018\u00010\u0019¢\u0006\u0004\bL\u0010MJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0016\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000bJ\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001e\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u001d\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ¸\u0001\u0010-\u001a\u00020\u00002\f\b\u0002\u0010\u001f\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\t2\b\b\u0002\u0010)\u001a\u00020\t2\b\b\u0002\u0010*\u001a\u00020\t2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0014\b\u0002\u0010,\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u001d\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b/\u0010\bJ\u0010\u00100\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00104\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u000102HÖ\u0003¢\u0006\u0004\b4\u00105R\u0019\u0010$\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u00106\u001a\u0004\b$\u0010\u000bR\u0019\u0010'\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b'\u00107\u001a\u0004\b8\u0010\bR\u0019\u0010#\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b#\u00106\u001a\u0004\b9\u0010\u000bR\u001c\u0010:\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u00101R\u001b\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010=\u001a\u0004\b>\u0010\u0011R\u0019\u0010!\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00106\u001a\u0004\b?\u0010\u000bR\u001d\u0010\u001f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010@\u001a\u0004\bA\u0010\u0005R\u0019\u0010*\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b*\u00106\u001a\u0004\bB\u0010\u000bR\u0019\u0010 \u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b \u00107\u001a\u0004\bC\u0010\bR\u0019\u0010\"\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\bD\u0010\u000bR%\u0010,\u001a\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u001d\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010E\u001a\u0004\bF\u0010\u001cR\u001b\u0010&\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010G\u001a\u0004\bH\u0010\u0014R\u001c\u0010I\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bI\u00107\u001a\u0004\bJ\u0010\bR\u0019\u0010(\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b(\u00106\u001a\u0004\b(\u0010\u000bR\u0019\u0010)\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b)\u00106\u001a\u0004\b)\u0010\u000bR!\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010E\u001a\u0004\bK\u0010\u001c¨\u0006N"}, d2 = {"Lcom/discord/widgets/chat/list/entries/StartOfChatEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Integer;", "Lcom/discord/models/member/GuildMember;", "component8", "()Lcom/discord/models/member/GuildMember;", "component9", "component10", "component11", "component12", "", "Lcom/discord/api/channel/ForumTag;", "component13", "()Ljava/util/List;", "Lcom/discord/primitives/ForumTagId;", "component14", "channelId", "channelName", "canReadMessageHistory", "canManageChannel", "canManageThread", "isThread", "threadAutoArchiveDuration", "threadCreatorMember", "threadCreatorName", "isTextInVoice", "isGuildForumPost", "canAccessRedesignedForumChannels", "availableTags", "appliedTags", "copy", "(JLjava/lang/String;ZZZZLjava/lang/Integer;Lcom/discord/models/member/GuildMember;Ljava/lang/String;ZZZLjava/util/List;Ljava/util/List;)Lcom/discord/widgets/chat/list/entries/StartOfChatEntry;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getThreadCreatorName", "getCanManageThread", "type", "I", "getType", "Ljava/lang/Integer;", "getThreadAutoArchiveDuration", "getCanReadMessageHistory", "J", "getChannelId", "getCanAccessRedesignedForumChannels", "getChannelName", "getCanManageChannel", "Ljava/util/List;", "getAppliedTags", "Lcom/discord/models/member/GuildMember;", "getThreadCreatorMember", "key", "getKey", "getAvailableTags", "<init>", "(JLjava/lang/String;ZZZZLjava/lang/Integer;Lcom/discord/models/member/GuildMember;Ljava/lang/String;ZZZLjava/util/List;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class StartOfChatEntry extends ChatListEntry {
    private final List<Long> appliedTags;
    private final List<ForumTag> availableTags;
    private final boolean canAccessRedesignedForumChannels;
    private final boolean canManageChannel;
    private final boolean canManageThread;
    private final boolean canReadMessageHistory;
    private final long channelId;
    private final String channelName;
    private final boolean isGuildForumPost;
    private final boolean isTextInVoice;
    private final boolean isThread;
    private final String key;
    private final Integer threadAutoArchiveDuration;
    private final GuildMember threadCreatorMember;
    private final String threadCreatorName;
    private final int type;

    public StartOfChatEntry(long j, String str, boolean z2, boolean z3, boolean z4, boolean z5, Integer num, GuildMember guildMember, String str2, boolean z6, boolean z7, boolean z8, List<ForumTag> list, List<Long> list2) {
        Intrinsics3.checkNotNullParameter(str, "channelName");
        Intrinsics3.checkNotNullParameter(str2, "threadCreatorName");
        this.channelId = j;
        this.channelName = str;
        this.canReadMessageHistory = z2;
        this.canManageChannel = z3;
        this.canManageThread = z4;
        this.isThread = z5;
        this.threadAutoArchiveDuration = num;
        this.threadCreatorMember = guildMember;
        this.threadCreatorName = str2;
        this.isTextInVoice = z6;
        this.isGuildForumPost = z7;
        this.canAccessRedesignedForumChannels = z8;
        this.availableTags = list;
        this.appliedTags = list2;
        this.type = 3;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ StartOfChatEntry copy$default(StartOfChatEntry startOfChatEntry, long j, String str, boolean z2, boolean z3, boolean z4, boolean z5, Integer num, GuildMember guildMember, String str2, boolean z6, boolean z7, boolean z8, List list, List list2, int i, Object obj) {
        return startOfChatEntry.copy((i & 1) != 0 ? startOfChatEntry.channelId : j, (i & 2) != 0 ? startOfChatEntry.channelName : str, (i & 4) != 0 ? startOfChatEntry.canReadMessageHistory : z2, (i & 8) != 0 ? startOfChatEntry.canManageChannel : z3, (i & 16) != 0 ? startOfChatEntry.canManageThread : z4, (i & 32) != 0 ? startOfChatEntry.isThread : z5, (i & 64) != 0 ? startOfChatEntry.threadAutoArchiveDuration : num, (i & 128) != 0 ? startOfChatEntry.threadCreatorMember : guildMember, (i & 256) != 0 ? startOfChatEntry.threadCreatorName : str2, (i & 512) != 0 ? startOfChatEntry.isTextInVoice : z6, (i & 1024) != 0 ? startOfChatEntry.isGuildForumPost : z7, (i & 2048) != 0 ? startOfChatEntry.canAccessRedesignedForumChannels : z8, (i & 4096) != 0 ? startOfChatEntry.availableTags : list, (i & 8192) != 0 ? startOfChatEntry.appliedTags : list2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsTextInVoice() {
        return this.isTextInVoice;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsGuildForumPost() {
        return this.isGuildForumPost;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getCanAccessRedesignedForumChannels() {
        return this.canAccessRedesignedForumChannels;
    }

    public final List<ForumTag> component13() {
        return this.availableTags;
    }

    public final List<Long> component14() {
        return this.appliedTags;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanReadMessageHistory() {
        return this.canReadMessageHistory;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCanManageChannel() {
        return this.canManageChannel;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsThread() {
        return this.isThread;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getThreadAutoArchiveDuration() {
        return this.threadAutoArchiveDuration;
    }

    /* renamed from: component8, reason: from getter */
    public final GuildMember getThreadCreatorMember() {
        return this.threadCreatorMember;
    }

    /* renamed from: component9, reason: from getter */
    public final String getThreadCreatorName() {
        return this.threadCreatorName;
    }

    public final StartOfChatEntry copy(long channelId, String channelName, boolean canReadMessageHistory, boolean canManageChannel, boolean canManageThread, boolean isThread, Integer threadAutoArchiveDuration, GuildMember threadCreatorMember, String threadCreatorName, boolean isTextInVoice, boolean isGuildForumPost, boolean canAccessRedesignedForumChannels, List<ForumTag> availableTags, List<Long> appliedTags) {
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        Intrinsics3.checkNotNullParameter(threadCreatorName, "threadCreatorName");
        return new StartOfChatEntry(channelId, channelName, canReadMessageHistory, canManageChannel, canManageThread, isThread, threadAutoArchiveDuration, threadCreatorMember, threadCreatorName, isTextInVoice, isGuildForumPost, canAccessRedesignedForumChannels, availableTags, appliedTags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartOfChatEntry)) {
            return false;
        }
        StartOfChatEntry startOfChatEntry = (StartOfChatEntry) other;
        return this.channelId == startOfChatEntry.channelId && Intrinsics3.areEqual(this.channelName, startOfChatEntry.channelName) && this.canReadMessageHistory == startOfChatEntry.canReadMessageHistory && this.canManageChannel == startOfChatEntry.canManageChannel && this.canManageThread == startOfChatEntry.canManageThread && this.isThread == startOfChatEntry.isThread && Intrinsics3.areEqual(this.threadAutoArchiveDuration, startOfChatEntry.threadAutoArchiveDuration) && Intrinsics3.areEqual(this.threadCreatorMember, startOfChatEntry.threadCreatorMember) && Intrinsics3.areEqual(this.threadCreatorName, startOfChatEntry.threadCreatorName) && this.isTextInVoice == startOfChatEntry.isTextInVoice && this.isGuildForumPost == startOfChatEntry.isGuildForumPost && this.canAccessRedesignedForumChannels == startOfChatEntry.canAccessRedesignedForumChannels && Intrinsics3.areEqual(this.availableTags, startOfChatEntry.availableTags) && Intrinsics3.areEqual(this.appliedTags, startOfChatEntry.appliedTags);
    }

    public final List<Long> getAppliedTags() {
        return this.appliedTags;
    }

    public final List<ForumTag> getAvailableTags() {
        return this.availableTags;
    }

    public final boolean getCanAccessRedesignedForumChannels() {
        return this.canAccessRedesignedForumChannels;
    }

    public final boolean getCanManageChannel() {
        return this.canManageChannel;
    }

    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    public final boolean getCanReadMessageHistory() {
        return this.canReadMessageHistory;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Integer getThreadAutoArchiveDuration() {
        return this.threadAutoArchiveDuration;
    }

    public final GuildMember getThreadCreatorMember() {
        return this.threadCreatorMember;
    }

    public final String getThreadCreatorName() {
        return this.threadCreatorName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        String str = this.channelName;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.canReadMessageHistory;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.canManageChannel;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.canManageThread;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z5 = this.isThread;
        int i7 = z5;
        if (z5 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        Integer num = this.threadAutoArchiveDuration;
        int iHashCode2 = (i8 + (num != null ? num.hashCode() : 0)) * 31;
        GuildMember guildMember = this.threadCreatorMember;
        int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        String str2 = this.threadCreatorName;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z6 = this.isTextInVoice;
        int i9 = z6;
        if (z6 != 0) {
            i9 = 1;
        }
        int i10 = (iHashCode4 + i9) * 31;
        boolean z7 = this.isGuildForumPost;
        int i11 = z7;
        if (z7 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        boolean z8 = this.canAccessRedesignedForumChannels;
        int i13 = (i12 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        List<ForumTag> list = this.availableTags;
        int iHashCode5 = (i13 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.appliedTags;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public final boolean isGuildForumPost() {
        return this.isGuildForumPost;
    }

    public final boolean isTextInVoice() {
        return this.isTextInVoice;
    }

    public final boolean isThread() {
        return this.isThread;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StartOfChatEntry(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", canReadMessageHistory=");
        sbU.append(this.canReadMessageHistory);
        sbU.append(", canManageChannel=");
        sbU.append(this.canManageChannel);
        sbU.append(", canManageThread=");
        sbU.append(this.canManageThread);
        sbU.append(", isThread=");
        sbU.append(this.isThread);
        sbU.append(", threadAutoArchiveDuration=");
        sbU.append(this.threadAutoArchiveDuration);
        sbU.append(", threadCreatorMember=");
        sbU.append(this.threadCreatorMember);
        sbU.append(", threadCreatorName=");
        sbU.append(this.threadCreatorName);
        sbU.append(", isTextInVoice=");
        sbU.append(this.isTextInVoice);
        sbU.append(", isGuildForumPost=");
        sbU.append(this.isGuildForumPost);
        sbU.append(", canAccessRedesignedForumChannels=");
        sbU.append(this.canAccessRedesignedForumChannels);
        sbU.append(", availableTags=");
        sbU.append(this.availableTags);
        sbU.append(", appliedTags=");
        return outline.L(sbU, this.appliedTags, ")");
    }
}
