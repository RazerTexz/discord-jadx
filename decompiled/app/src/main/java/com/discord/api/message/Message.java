package com.discord.api.message;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.botuikit.Component;
import com.discord.api.channel.Channel;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.call.MessageCall;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.role_subscription.RoleSubscriptionData;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Message.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R!\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R\u001b\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u00109\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u001f\u001a\u0004\b:\u0010!R!\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u000f\u001a\u0004\b=\u0010\u0011R\u001b\u0010>\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR!\u0010H\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u000f\u001a\u0004\bI\u0010\u0011R\u001b\u0010J\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\u001f\u001a\u0004\bK\u0010!R\u001b\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001b\u0010Q\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010\u0013\u001a\u0004\bR\u0010\u0015R\u001b\u0010S\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\u0004R\u001b\u0010V\u001a\u0004\u0018\u00010\u00008\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001b\u0010Z\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010\u001f\u001a\u0004\b[\u0010!R\u001b\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0019\u0010a\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001b\u0010e\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\be\u0010\u0018\u001a\u0004\bf\u0010\u001aR\u0019\u0010g\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010b\u001a\u0004\bh\u0010dR\u001b\u0010i\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010\u0013\u001a\u0004\bj\u0010\u0015R\u001b\u0010k\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\bk\u0010\u0013\u001a\u0004\bl\u0010\u0015R\u001b\u0010n\u001a\u0004\u0018\u00010m8\u0006@\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u001b\u0010r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\br\u0010T\u001a\u0004\bs\u0010\u0004R!\u0010u\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bu\u0010\u000f\u001a\u0004\bv\u0010\u0011R\u001b\u0010w\u001a\u0004\u0018\u00010G8\u0006@\u0006¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR!\u0010|\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b|\u0010\u000f\u001a\u0004\b}\u0010\u0011R\"\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020~\u0018\u00010\f8\u0006@\u0006¢\u0006\r\n\u0004\b\u007f\u0010\u000f\u001a\u0005\b\u0080\u0001\u0010\u0011¨\u0006\u0081\u0001"}, d2 = {"Lcom/discord/api/message/Message;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "mentionRoles", "Ljava/util/List;", "s", "()Ljava/util/List;", "webhookId", "Ljava/lang/Long;", "G", "()Ljava/lang/Long;", "Lcom/discord/api/utcdatetime/UtcDateTime;", "editedTimestamp", "Lcom/discord/api/utcdatetime/UtcDateTime;", "j", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "Lcom/discord/api/message/embed/MessageEmbed;", "embeds", "k", "mentionEveryone", "Ljava/lang/Boolean;", "r", "()Ljava/lang/Boolean;", "Lcom/discord/api/channel/Channel;", "thread", "Lcom/discord/api/channel/Channel;", "C", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/api/botuikit/Component;", "components", "h", "Lcom/discord/api/message/call/MessageCall;", NotificationCompat.CATEGORY_CALL, "Lcom/discord/api/message/call/MessageCall;", "f", "()Lcom/discord/api/message/call/MessageCall;", "Lcom/discord/api/guildmember/GuildMember;", "member", "Lcom/discord/api/guildmember/GuildMember;", "q", "()Lcom/discord/api/guildmember/GuildMember;", "Lcom/discord/api/message/MessageReference;", "messageReference", "Lcom/discord/api/message/MessageReference;", "u", "()Lcom/discord/api/message/MessageReference;", "tts", ExifInterface.LONGITUDE_EAST, "Lcom/discord/api/message/reaction/MessageReaction;", "reactions", "x", "type", "Ljava/lang/Integer;", "F", "()Ljava/lang/Integer;", "Lcom/discord/api/message/role_subscription/RoleSubscriptionData;", "roleSubscriptionData", "Lcom/discord/api/message/role_subscription/RoleSubscriptionData;", "z", "()Lcom/discord/api/message/role_subscription/RoleSubscriptionData;", "Lcom/discord/api/user/User;", "mentions", "t", "pinned", "w", "Lcom/discord/api/application/Application;", "application", "Lcom/discord/api/application/Application;", "b", "()Lcom/discord/api/application/Application;", "flags", "l", "nonce", "Ljava/lang/String;", "v", "referencedMessage", "Lcom/discord/api/message/Message;", "y", "()Lcom/discord/api/message/Message;", "hit", "n", "Lcom/discord/api/message/activity/MessageActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/api/message/activity/MessageActivity;", "a", "()Lcom/discord/api/message/activity/MessageActivity;", "channelId", "J", "g", "()J", "timestamp", "D", ModelAuditLogEntry.CHANGE_KEY_ID, "o", "guildId", "m", "applicationId", "c", "Lcom/discord/api/interaction/Interaction;", "interaction", "Lcom/discord/api/interaction/Interaction;", "p", "()Lcom/discord/api/interaction/Interaction;", "content", "i", "Lcom/discord/api/sticker/StickerPartial;", "stickerItems", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "author", "Lcom/discord/api/user/User;", "e", "()Lcom/discord/api/user/User;", "Lcom/discord/api/sticker/Sticker;", "stickers", "B", "Lcom/discord/api/message/attachment/MessageAttachment;", "attachments", "d", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Message {
    private final MessageActivity activity;
    private final Application application;
    private final Long applicationId;
    private final List<MessageAttachment> attachments;
    private final User author;
    private final MessageCall call;
    private final long channelId;
    private final List<Component> components;
    private final String content;
    private final UtcDateTime editedTimestamp;
    private final List<MessageEmbed> embeds;
    private final Long flags;
    private final Long guildId;
    private final Boolean hit;
    private final long id;
    private final Interaction interaction;
    private final GuildMember member;
    private final Boolean mentionEveryone;
    private final List<Long> mentionRoles;
    private final List<User> mentions;
    private final MessageReference messageReference;
    private final String nonce;
    private final Boolean pinned;
    private final List<MessageReaction> reactions;
    private final Message referencedMessage;
    private final RoleSubscriptionData roleSubscriptionData;
    private final List<StickerPartial> stickerItems;
    private final List<Sticker> stickers;
    private final Channel thread;
    private final UtcDateTime timestamp;
    private final Boolean tts;
    private final Integer type;
    private final Long webhookId;

    public Message(long j, long j2, User user, String str, UtcDateTime utcDateTime, UtcDateTime utcDateTime2, Boolean bool, Boolean bool2, List list, List list2, List list3, List list4, List list5, String str2, Boolean bool3, Long l, Integer num, MessageActivity messageActivity, Application application, Long l2, MessageReference messageReference, Long l3, List list6, List list7, Message message, Interaction interaction, Channel channel, List list8, MessageCall messageCall, Long l4, GuildMember guildMember, Boolean bool4, RoleSubscriptionData roleSubscriptionData, int i, int i2) {
        User user2 = (i & 4) != 0 ? null : user;
        String str3 = (i & 8) != 0 ? null : str;
        UtcDateTime utcDateTime3 = (i & 16) != 0 ? null : utcDateTime;
        UtcDateTime utcDateTime4 = (i & 32) != 0 ? null : utcDateTime2;
        Boolean bool5 = (i & 64) != 0 ? null : bool;
        Boolean bool6 = (i & 128) != 0 ? null : bool2;
        List list9 = (i & 256) != 0 ? null : list;
        List list10 = (i & 512) != 0 ? null : list2;
        List list11 = (i & 1024) != 0 ? null : list3;
        List list12 = (i & 2048) != 0 ? null : list4;
        List list13 = (i & 4096) != 0 ? null : list5;
        String str4 = (i & 8192) != 0 ? null : str2;
        Boolean bool7 = (i & 16384) != 0 ? null : bool3;
        Long l5 = (i & 32768) != 0 ? null : l;
        Integer num2 = (i & 65536) != 0 ? null : num;
        MessageActivity messageActivity2 = (i & 131072) != 0 ? null : messageActivity;
        Application application2 = (i & 262144) != 0 ? null : application;
        Long l6 = (i & 524288) != 0 ? null : l2;
        MessageReference messageReference2 = (i & 1048576) != 0 ? null : messageReference;
        Long l7 = (i & 2097152) != 0 ? null : l3;
        List list14 = (i & 4194304) != 0 ? null : list6;
        List list15 = (i & 8388608) != 0 ? null : list7;
        Message message2 = (i & 16777216) != 0 ? null : message;
        Interaction interaction2 = (i & 33554432) != 0 ? null : interaction;
        Channel channel2 = (i & 67108864) != 0 ? null : channel;
        List list16 = (i & 134217728) != 0 ? null : list8;
        MessageCall messageCall2 = (i & 268435456) != 0 ? null : messageCall;
        Long l8 = (i & 536870912) != 0 ? null : l4;
        int i3 = i & BasicMeasure.EXACTLY;
        int i4 = i & Integer.MIN_VALUE;
        RoleSubscriptionData roleSubscriptionData2 = (i2 & 1) != 0 ? null : roleSubscriptionData;
        this.id = j;
        this.channelId = j2;
        this.author = user2;
        this.content = str3;
        this.timestamp = utcDateTime3;
        this.editedTimestamp = utcDateTime4;
        this.tts = bool5;
        this.mentionEveryone = bool6;
        this.mentions = list9;
        this.mentionRoles = list10;
        this.attachments = list11;
        this.embeds = list12;
        this.reactions = list13;
        this.nonce = str4;
        this.pinned = bool7;
        this.webhookId = l5;
        this.type = num2;
        this.activity = messageActivity2;
        this.application = application2;
        this.applicationId = l6;
        this.messageReference = messageReference2;
        this.flags = l7;
        this.stickers = list14;
        this.stickerItems = list15;
        this.referencedMessage = message2;
        this.interaction = interaction2;
        this.thread = channel2;
        this.components = list16;
        this.call = messageCall2;
        this.guildId = l8;
        this.member = null;
        this.hit = null;
        this.roleSubscriptionData = roleSubscriptionData2;
    }

    public final List<StickerPartial> A() {
        return this.stickerItems;
    }

    public final List<Sticker> B() {
        return this.stickers;
    }

    /* renamed from: C, reason: from getter */
    public final Channel getThread() {
        return this.thread;
    }

    /* renamed from: D, reason: from getter */
    public final UtcDateTime getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: E, reason: from getter */
    public final Boolean getTts() {
        return this.tts;
    }

    /* renamed from: F, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* renamed from: G, reason: from getter */
    public final Long getWebhookId() {
        return this.webhookId;
    }

    /* renamed from: a, reason: from getter */
    public final MessageActivity getActivity() {
        return this.activity;
    }

    /* renamed from: b, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: c, reason: from getter */
    public final Long getApplicationId() {
        return this.applicationId;
    }

    public final List<MessageAttachment> d() {
        return this.attachments;
    }

    /* renamed from: e, reason: from getter */
    public final User getAuthor() {
        return this.author;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return this.id == message.id && this.channelId == message.channelId && Intrinsics3.areEqual(this.author, message.author) && Intrinsics3.areEqual(this.content, message.content) && Intrinsics3.areEqual(this.timestamp, message.timestamp) && Intrinsics3.areEqual(this.editedTimestamp, message.editedTimestamp) && Intrinsics3.areEqual(this.tts, message.tts) && Intrinsics3.areEqual(this.mentionEveryone, message.mentionEveryone) && Intrinsics3.areEqual(this.mentions, message.mentions) && Intrinsics3.areEqual(this.mentionRoles, message.mentionRoles) && Intrinsics3.areEqual(this.attachments, message.attachments) && Intrinsics3.areEqual(this.embeds, message.embeds) && Intrinsics3.areEqual(this.reactions, message.reactions) && Intrinsics3.areEqual(this.nonce, message.nonce) && Intrinsics3.areEqual(this.pinned, message.pinned) && Intrinsics3.areEqual(this.webhookId, message.webhookId) && Intrinsics3.areEqual(this.type, message.type) && Intrinsics3.areEqual(this.activity, message.activity) && Intrinsics3.areEqual(this.application, message.application) && Intrinsics3.areEqual(this.applicationId, message.applicationId) && Intrinsics3.areEqual(this.messageReference, message.messageReference) && Intrinsics3.areEqual(this.flags, message.flags) && Intrinsics3.areEqual(this.stickers, message.stickers) && Intrinsics3.areEqual(this.stickerItems, message.stickerItems) && Intrinsics3.areEqual(this.referencedMessage, message.referencedMessage) && Intrinsics3.areEqual(this.interaction, message.interaction) && Intrinsics3.areEqual(this.thread, message.thread) && Intrinsics3.areEqual(this.components, message.components) && Intrinsics3.areEqual(this.call, message.call) && Intrinsics3.areEqual(this.guildId, message.guildId) && Intrinsics3.areEqual(this.member, message.member) && Intrinsics3.areEqual(this.hit, message.hit) && Intrinsics3.areEqual(this.roleSubscriptionData, message.roleSubscriptionData);
    }

    /* renamed from: f, reason: from getter */
    public final MessageCall getCall() {
        return this.call;
    }

    /* renamed from: g, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final List<Component> h() {
        return this.components;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.channelId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        User user = this.author;
        int iHashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.timestamp;
        int iHashCode3 = (iHashCode2 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.editedTimestamp;
        int iHashCode4 = (iHashCode3 + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0)) * 31;
        Boolean bool = this.tts;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.mentionEveryone;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        List<User> list = this.mentions;
        int iHashCode7 = (iHashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.mentionRoles;
        int iHashCode8 = (iHashCode7 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<MessageAttachment> list3 = this.attachments;
        int iHashCode9 = (iHashCode8 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<MessageEmbed> list4 = this.embeds;
        int iHashCode10 = (iHashCode9 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<MessageReaction> list5 = this.reactions;
        int iHashCode11 = (iHashCode10 + (list5 != null ? list5.hashCode() : 0)) * 31;
        String str2 = this.nonce;
        int iHashCode12 = (iHashCode11 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool3 = this.pinned;
        int iHashCode13 = (iHashCode12 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l = this.webhookId;
        int iHashCode14 = (iHashCode13 + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.type;
        int iHashCode15 = (iHashCode14 + (num != null ? num.hashCode() : 0)) * 31;
        MessageActivity messageActivity = this.activity;
        int iHashCode16 = (iHashCode15 + (messageActivity != null ? messageActivity.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode17 = (iHashCode16 + (application != null ? application.hashCode() : 0)) * 31;
        Long l2 = this.applicationId;
        int iHashCode18 = (iHashCode17 + (l2 != null ? l2.hashCode() : 0)) * 31;
        MessageReference messageReference = this.messageReference;
        int iHashCode19 = (iHashCode18 + (messageReference != null ? messageReference.hashCode() : 0)) * 31;
        Long l3 = this.flags;
        int iHashCode20 = (iHashCode19 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Sticker> list6 = this.stickers;
        int iHashCode21 = (iHashCode20 + (list6 != null ? list6.hashCode() : 0)) * 31;
        List<StickerPartial> list7 = this.stickerItems;
        int iHashCode22 = (iHashCode21 + (list7 != null ? list7.hashCode() : 0)) * 31;
        Message message = this.referencedMessage;
        int iHashCode23 = (iHashCode22 + (message != null ? message.hashCode() : 0)) * 31;
        Interaction interaction = this.interaction;
        int iHashCode24 = (iHashCode23 + (interaction != null ? interaction.hashCode() : 0)) * 31;
        Channel channel = this.thread;
        int iHashCode25 = (iHashCode24 + (channel != null ? channel.hashCode() : 0)) * 31;
        List<Component> list8 = this.components;
        int iHashCode26 = (iHashCode25 + (list8 != null ? list8.hashCode() : 0)) * 31;
        MessageCall messageCall = this.call;
        int iHashCode27 = (iHashCode26 + (messageCall != null ? messageCall.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode28 = (iHashCode27 + (l4 != null ? l4.hashCode() : 0)) * 31;
        GuildMember guildMember = this.member;
        int iHashCode29 = (iHashCode28 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        Boolean bool4 = this.hit;
        int iHashCode30 = (iHashCode29 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        RoleSubscriptionData roleSubscriptionData = this.roleSubscriptionData;
        return iHashCode30 + (roleSubscriptionData != null ? roleSubscriptionData.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: j, reason: from getter */
    public final UtcDateTime getEditedTimestamp() {
        return this.editedTimestamp;
    }

    public final List<MessageEmbed> k() {
        return this.embeds;
    }

    /* renamed from: l, reason: from getter */
    public final Long getFlags() {
        return this.flags;
    }

    /* renamed from: m, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* renamed from: n, reason: from getter */
    public final Boolean getHit() {
        return this.hit;
    }

    /* renamed from: o, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: p, reason: from getter */
    public final Interaction getInteraction() {
        return this.interaction;
    }

    /* renamed from: q, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* renamed from: r, reason: from getter */
    public final Boolean getMentionEveryone() {
        return this.mentionEveryone;
    }

    public final List<Long> s() {
        return this.mentionRoles;
    }

    public final List<User> t() {
        return this.mentions;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Message(id=");
        sbU.append(this.id);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", author=");
        sbU.append(this.author);
        sbU.append(", content=");
        sbU.append(this.content);
        sbU.append(", timestamp=");
        sbU.append(this.timestamp);
        sbU.append(", editedTimestamp=");
        sbU.append(this.editedTimestamp);
        sbU.append(", tts=");
        sbU.append(this.tts);
        sbU.append(", mentionEveryone=");
        sbU.append(this.mentionEveryone);
        sbU.append(", mentions=");
        sbU.append(this.mentions);
        sbU.append(", mentionRoles=");
        sbU.append(this.mentionRoles);
        sbU.append(", attachments=");
        sbU.append(this.attachments);
        sbU.append(", embeds=");
        sbU.append(this.embeds);
        sbU.append(", reactions=");
        sbU.append(this.reactions);
        sbU.append(", nonce=");
        sbU.append(this.nonce);
        sbU.append(", pinned=");
        sbU.append(this.pinned);
        sbU.append(", webhookId=");
        sbU.append(this.webhookId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", messageReference=");
        sbU.append(this.messageReference);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", stickerItems=");
        sbU.append(this.stickerItems);
        sbU.append(", referencedMessage=");
        sbU.append(this.referencedMessage);
        sbU.append(", interaction=");
        sbU.append(this.interaction);
        sbU.append(", thread=");
        sbU.append(this.thread);
        sbU.append(", components=");
        sbU.append(this.components);
        sbU.append(", call=");
        sbU.append(this.call);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", hit=");
        sbU.append(this.hit);
        sbU.append(", roleSubscriptionData=");
        sbU.append(this.roleSubscriptionData);
        sbU.append(")");
        return sbU.toString();
    }

    /* renamed from: u, reason: from getter */
    public final MessageReference getMessageReference() {
        return this.messageReference;
    }

    /* renamed from: v, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* renamed from: w, reason: from getter */
    public final Boolean getPinned() {
        return this.pinned;
    }

    public final List<MessageReaction> x() {
        return this.reactions;
    }

    /* renamed from: y, reason: from getter */
    public final Message getReferencedMessage() {
        return this.referencedMessage;
    }

    /* renamed from: z, reason: from getter */
    public final RoleSubscriptionData getRoleSubscriptionData() {
        return this.roleSubscriptionData;
    }
}
