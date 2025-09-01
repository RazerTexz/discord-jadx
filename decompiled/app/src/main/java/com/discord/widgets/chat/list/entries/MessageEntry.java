package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.BaseSticker;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessageState;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessageEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001:\u0002^_BÏ\u0001\u0012\u0006\u0010(\u001a\u00020\u0007\u0012\b\u0010)\u001a\u0004\u0018\u00010\n\u0012\b\u0010*\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\r\u0012\u0018\u0010,\u001a\u0014\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011\u0012\u0016\u0010-\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0017\u0012\u0004\u0012\u00020\u00180\u0011\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\"\u0012\u000e\u00107\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`%¢\u0006\u0004\b\\\u0010]J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\"\u0010\u0015\u001a\u0014\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0017\u0012\u0004\u0012\u00020\u00180\u0011HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u000fJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0012\u0010#\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`%HÆ\u0003¢\u0006\u0004\b&\u0010'Jæ\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u00072\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\r2\u001a\b\u0002\u0010,\u001a\u0014\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00112\u0018\b\u0002\u0010-\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0017\u0012\u0004\u0012\u00020\u00180\u00112\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\r2\b\b\u0002\u00103\u001a\u00020\u00022\b\b\u0002\u00104\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\"2\u0010\b\u0002\u00107\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`%HÆ\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b:\u0010;J\u0010\u0010=\u001a\u00020<HÖ\u0001¢\u0006\u0004\b=\u0010>J\u001a\u0010A\u001a\u00020\u00022\b\u0010@\u001a\u0004\u0018\u00010?HÖ\u0003¢\u0006\u0004\bA\u0010BR\u001c\u0010C\u001a\u00020<8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010>R\u001b\u00106\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010F\u001a\u0004\bG\u0010$R\u001c\u0010H\u001a\u00020\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010;R\u001b\u0010*\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010K\u001a\u0004\bL\u0010\u000fR\u0019\u0010(\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010M\u001a\u0004\bN\u0010\tR\u001b\u00102\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010K\u001a\u0004\bO\u0010\u000fR)\u0010-\u001a\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0017\u0012\u0004\u0012\u00020\u00180\u00118\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010P\u001a\u0004\bQ\u0010\u0016R\u0019\u00105\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010R\u001a\u0004\b5\u0010\u0004R!\u00107\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`%8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010S\u001a\u0004\bT\u0010'R\u0019\u00103\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010R\u001a\u0004\b3\u0010\u0004R\u001b\u0010+\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010K\u001a\u0004\bU\u0010\u000fR\u0019\u00104\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010R\u001a\u0004\b4\u0010\u0004R\u001b\u0010)\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010V\u001a\u0004\bW\u0010\fR\u0019\u00100\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010R\u001a\u0004\bX\u0010\u0004R\u001b\u00101\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010Y\u001a\u0004\bZ\u0010\u001dR\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010RR+\u0010,\u001a\u0014\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010P\u001a\u0004\b[\u0010\u0016R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010R¨\u0006`"}, d2 = {"Lcom/discord/widgets/chat/list/entries/MessageEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "component7", "()Z", "component8", "isInExpandedBlockedMessageChunk", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "Lcom/discord/stores/StoreMessageState$State;", "component2", "()Lcom/discord/stores/StoreMessageState$State;", "Lcom/discord/models/member/GuildMember;", "component3", "()Lcom/discord/models/member/GuildMember;", "component4", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component5", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "", "component6", "component9", "Lcom/discord/widgets/chat/list/entries/MessageEntry$ReplyData;", "component10", "()Lcom/discord/widgets/chat/list/entries/MessageEntry$ReplyData;", "component11", "component12", "component13", "component14", "Lcom/discord/widgets/chat/list/entries/MessageEntry$CtaData;", "component15", "()Lcom/discord/widgets/chat/list/entries/MessageEntry$CtaData;", "Lcom/discord/api/permission/PermissionBit;", "component16", "()Ljava/lang/Long;", "message", "messageState", "author", "firstMentionedUser", "roles", "nickOrUsernames", "isMinimal", "isExpandedBlocked", "animateEmojis", "replyData", "interactionAuthor", "isThreadStarterMessage", "isGuildForumPostFirstMessage", "isGuildForumPostAuthor", "ctaData", "permissionsForChannel", "copy", "(Lcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;Lcom/discord/models/member/GuildMember;Lcom/discord/models/member/GuildMember;Ljava/util/Map;Ljava/util/Map;ZZZLcom/discord/widgets/chat/list/entries/MessageEntry$ReplyData;Lcom/discord/models/member/GuildMember;ZZZLcom/discord/widgets/chat/list/entries/MessageEntry$CtaData;Ljava/lang/Long;)Lcom/discord/widgets/chat/list/entries/MessageEntry;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "Lcom/discord/widgets/chat/list/entries/MessageEntry$CtaData;", "getCtaData", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/member/GuildMember;", "getAuthor", "Lcom/discord/models/message/Message;", "getMessage", "getInteractionAuthor", "Ljava/util/Map;", "getNickOrUsernames", "Z", "Ljava/lang/Long;", "getPermissionsForChannel", "getFirstMentionedUser", "Lcom/discord/stores/StoreMessageState$State;", "getMessageState", "getAnimateEmojis", "Lcom/discord/widgets/chat/list/entries/MessageEntry$ReplyData;", "getReplyData", "getRoles", "<init>", "(Lcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;Lcom/discord/models/member/GuildMember;Lcom/discord/models/member/GuildMember;Ljava/util/Map;Ljava/util/Map;ZZZLcom/discord/widgets/chat/list/entries/MessageEntry$ReplyData;Lcom/discord/models/member/GuildMember;ZZZLcom/discord/widgets/chat/list/entries/MessageEntry$CtaData;Ljava/lang/Long;)V", "CtaData", "ReplyData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class MessageEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final GuildMember author;
    private final CtaData ctaData;
    private final GuildMember firstMentionedUser;
    private final GuildMember interactionAuthor;
    private final boolean isExpandedBlocked;
    private final boolean isGuildForumPostAuthor;
    private final boolean isGuildForumPostFirstMessage;
    private final boolean isMinimal;
    private final boolean isThreadStarterMessage;
    private final String key;
    private final Message message;
    private final StoreMessageState.State messageState;
    private final Map<Long, String> nickOrUsernames;
    private final Long permissionsForChannel;
    private final ReplyData replyData;
    private final Map<Long, GuildRole> roles;
    private final int type;

    /* compiled from: MessageEntry.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/chat/list/entries/MessageEntry$CtaData;", "", "Lcom/discord/api/sticker/BaseSticker;", "component1", "()Lcom/discord/api/sticker/BaseSticker;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "sticker", "channel", "copy", "(Lcom/discord/api/sticker/BaseSticker;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/chat/list/entries/MessageEntry$CtaData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/api/sticker/BaseSticker;", "getSticker", "<init>", "(Lcom/discord/api/sticker/BaseSticker;Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CtaData {
        private final Channel channel;
        private final BaseSticker sticker;

        public CtaData(BaseSticker baseSticker, Channel channel) {
            Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.sticker = baseSticker;
            this.channel = channel;
        }

        public static /* synthetic */ CtaData copy$default(CtaData ctaData, BaseSticker baseSticker, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                baseSticker = ctaData.sticker;
            }
            if ((i & 2) != 0) {
                channel = ctaData.channel;
            }
            return ctaData.copy(baseSticker, channel);
        }

        /* renamed from: component1, reason: from getter */
        public final BaseSticker getSticker() {
            return this.sticker;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final CtaData copy(BaseSticker sticker, Channel channel) {
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new CtaData(sticker, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CtaData)) {
                return false;
            }
            CtaData ctaData = (CtaData) other;
            return Intrinsics3.areEqual(this.sticker, ctaData.sticker) && Intrinsics3.areEqual(this.channel, ctaData.channel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final BaseSticker getSticker() {
            return this.sticker;
        }

        public int hashCode() {
            BaseSticker baseSticker = this.sticker;
            int iHashCode = (baseSticker != null ? baseSticker.hashCode() : 0) * 31;
            Channel channel = this.channel;
            return iHashCode + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CtaData(sticker=");
            sbU.append(this.sticker);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MessageEntry.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\r\u0010\n¨\u0006 "}, d2 = {"Lcom/discord/widgets/chat/list/entries/MessageEntry$ReplyData;", "", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "component1", "()Lcom/discord/stores/StoreMessageReplies$MessageState;", "Lcom/discord/widgets/chat/list/entries/MessageEntry;", "component2", "()Lcom/discord/widgets/chat/list/entries/MessageEntry;", "", "component3", "()Z", "messageState", "messageEntry", "isRepliedUserBlocked", "copy", "(Lcom/discord/stores/StoreMessageReplies$MessageState;Lcom/discord/widgets/chat/list/entries/MessageEntry;Z)Lcom/discord/widgets/chat/list/entries/MessageEntry$ReplyData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/list/entries/MessageEntry;", "getMessageEntry", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "getMessageState", "Z", "<init>", "(Lcom/discord/stores/StoreMessageReplies$MessageState;Lcom/discord/widgets/chat/list/entries/MessageEntry;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ReplyData {
        private final boolean isRepliedUserBlocked;
        private final MessageEntry messageEntry;
        private final StoreMessageReplies.MessageState messageState;

        public ReplyData(StoreMessageReplies.MessageState messageState, MessageEntry messageEntry, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageState, "messageState");
            this.messageState = messageState;
            this.messageEntry = messageEntry;
            this.isRepliedUserBlocked = z2;
        }

        public static /* synthetic */ ReplyData copy$default(ReplyData replyData, StoreMessageReplies.MessageState messageState, MessageEntry messageEntry, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                messageState = replyData.messageState;
            }
            if ((i & 2) != 0) {
                messageEntry = replyData.messageEntry;
            }
            if ((i & 4) != 0) {
                z2 = replyData.isRepliedUserBlocked;
            }
            return replyData.copy(messageState, messageEntry, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreMessageReplies.MessageState getMessageState() {
            return this.messageState;
        }

        /* renamed from: component2, reason: from getter */
        public final MessageEntry getMessageEntry() {
            return this.messageEntry;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsRepliedUserBlocked() {
            return this.isRepliedUserBlocked;
        }

        public final ReplyData copy(StoreMessageReplies.MessageState messageState, MessageEntry messageEntry, boolean isRepliedUserBlocked) {
            Intrinsics3.checkNotNullParameter(messageState, "messageState");
            return new ReplyData(messageState, messageEntry, isRepliedUserBlocked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplyData)) {
                return false;
            }
            ReplyData replyData = (ReplyData) other;
            return Intrinsics3.areEqual(this.messageState, replyData.messageState) && Intrinsics3.areEqual(this.messageEntry, replyData.messageEntry) && this.isRepliedUserBlocked == replyData.isRepliedUserBlocked;
        }

        public final MessageEntry getMessageEntry() {
            return this.messageEntry;
        }

        public final StoreMessageReplies.MessageState getMessageState() {
            return this.messageState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            StoreMessageReplies.MessageState messageState = this.messageState;
            int iHashCode = (messageState != null ? messageState.hashCode() : 0) * 31;
            MessageEntry messageEntry = this.messageEntry;
            int iHashCode2 = (iHashCode + (messageEntry != null ? messageEntry.hashCode() : 0)) * 31;
            boolean z2 = this.isRepliedUserBlocked;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public final boolean isRepliedUserBlocked() {
            return this.isRepliedUserBlocked;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ReplyData(messageState=");
            sbU.append(this.messageState);
            sbU.append(", messageEntry=");
            sbU.append(this.messageEntry);
            sbU.append(", isRepliedUserBlocked=");
            return outline.O(sbU, this.isRepliedUserBlocked, ")");
        }

        public /* synthetic */ ReplyData(StoreMessageReplies.MessageState messageState, MessageEntry messageEntry, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(messageState, messageEntry, (i & 4) != 0 ? false : z2);
        }
    }

    public /* synthetic */ MessageEntry(Message message, StoreMessageState.State state, GuildMember guildMember, GuildMember guildMember2, Map map, Map map2, boolean z2, boolean z3, boolean z4, ReplyData replyData, GuildMember guildMember3, boolean z5, boolean z6, boolean z7, CtaData ctaData, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(message, state, guildMember, (i & 8) != 0 ? null : guildMember2, map, map2, (i & 64) != 0 ? false : z2, z3, (i & 256) != 0 ? true : z4, (i & 512) != 0 ? null : replyData, (i & 1024) != 0 ? null : guildMember3, (i & 2048) != 0 ? false : z5, (i & 4096) != 0 ? false : z6, (i & 8192) != 0 ? false : z7, (i & 16384) != 0 ? null : ctaData, l);
    }

    /* renamed from: component7, reason: from getter */
    private final boolean getIsMinimal() {
        return this.isMinimal;
    }

    /* renamed from: component8, reason: from getter */
    private final boolean getIsExpandedBlocked() {
        return this.isExpandedBlocked;
    }

    public static /* synthetic */ MessageEntry copy$default(MessageEntry messageEntry, Message message, StoreMessageState.State state, GuildMember guildMember, GuildMember guildMember2, Map map, Map map2, boolean z2, boolean z3, boolean z4, ReplyData replyData, GuildMember guildMember3, boolean z5, boolean z6, boolean z7, CtaData ctaData, Long l, int i, Object obj) {
        return messageEntry.copy((i & 1) != 0 ? messageEntry.message : message, (i & 2) != 0 ? messageEntry.messageState : state, (i & 4) != 0 ? messageEntry.author : guildMember, (i & 8) != 0 ? messageEntry.firstMentionedUser : guildMember2, (i & 16) != 0 ? messageEntry.roles : map, (i & 32) != 0 ? messageEntry.nickOrUsernames : map2, (i & 64) != 0 ? messageEntry.isMinimal : z2, (i & 128) != 0 ? messageEntry.isExpandedBlocked : z3, (i & 256) != 0 ? messageEntry.animateEmojis : z4, (i & 512) != 0 ? messageEntry.replyData : replyData, (i & 1024) != 0 ? messageEntry.interactionAuthor : guildMember3, (i & 2048) != 0 ? messageEntry.isThreadStarterMessage : z5, (i & 4096) != 0 ? messageEntry.isGuildForumPostFirstMessage : z6, (i & 8192) != 0 ? messageEntry.isGuildForumPostAuthor : z7, (i & 16384) != 0 ? messageEntry.ctaData : ctaData, (i & 32768) != 0 ? messageEntry.permissionsForChannel : l);
    }

    /* renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component10, reason: from getter */
    public final ReplyData getReplyData() {
        return this.replyData;
    }

    /* renamed from: component11, reason: from getter */
    public final GuildMember getInteractionAuthor() {
        return this.interactionAuthor;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsGuildForumPostFirstMessage() {
        return this.isGuildForumPostFirstMessage;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsGuildForumPostAuthor() {
        return this.isGuildForumPostAuthor;
    }

    /* renamed from: component15, reason: from getter */
    public final CtaData getCtaData() {
        return this.ctaData;
    }

    /* renamed from: component16, reason: from getter */
    public final Long getPermissionsForChannel() {
        return this.permissionsForChannel;
    }

    /* renamed from: component2, reason: from getter */
    public final StoreMessageState.State getMessageState() {
        return this.messageState;
    }

    /* renamed from: component3, reason: from getter */
    public final GuildMember getAuthor() {
        return this.author;
    }

    /* renamed from: component4, reason: from getter */
    public final GuildMember getFirstMentionedUser() {
        return this.firstMentionedUser;
    }

    public final Map<Long, GuildRole> component5() {
        return this.roles;
    }

    public final Map<Long, String> component6() {
        return this.nickOrUsernames;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final MessageEntry copy(Message message, StoreMessageState.State messageState, GuildMember author, GuildMember firstMentionedUser, Map<Long, GuildRole> roles, Map<Long, String> nickOrUsernames, boolean isMinimal, boolean isExpandedBlocked, boolean animateEmojis, ReplyData replyData, GuildMember interactionAuthor, boolean isThreadStarterMessage, boolean isGuildForumPostFirstMessage, boolean isGuildForumPostAuthor, CtaData ctaData, Long permissionsForChannel) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
        return new MessageEntry(message, messageState, author, firstMentionedUser, roles, nickOrUsernames, isMinimal, isExpandedBlocked, animateEmojis, replyData, interactionAuthor, isThreadStarterMessage, isGuildForumPostFirstMessage, isGuildForumPostAuthor, ctaData, permissionsForChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEntry)) {
            return false;
        }
        MessageEntry messageEntry = (MessageEntry) other;
        return Intrinsics3.areEqual(this.message, messageEntry.message) && Intrinsics3.areEqual(this.messageState, messageEntry.messageState) && Intrinsics3.areEqual(this.author, messageEntry.author) && Intrinsics3.areEqual(this.firstMentionedUser, messageEntry.firstMentionedUser) && Intrinsics3.areEqual(this.roles, messageEntry.roles) && Intrinsics3.areEqual(this.nickOrUsernames, messageEntry.nickOrUsernames) && this.isMinimal == messageEntry.isMinimal && this.isExpandedBlocked == messageEntry.isExpandedBlocked && this.animateEmojis == messageEntry.animateEmojis && Intrinsics3.areEqual(this.replyData, messageEntry.replyData) && Intrinsics3.areEqual(this.interactionAuthor, messageEntry.interactionAuthor) && this.isThreadStarterMessage == messageEntry.isThreadStarterMessage && this.isGuildForumPostFirstMessage == messageEntry.isGuildForumPostFirstMessage && this.isGuildForumPostAuthor == messageEntry.isGuildForumPostAuthor && Intrinsics3.areEqual(this.ctaData, messageEntry.ctaData) && Intrinsics3.areEqual(this.permissionsForChannel, messageEntry.permissionsForChannel);
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final GuildMember getAuthor() {
        return this.author;
    }

    public final CtaData getCtaData() {
        return this.ctaData;
    }

    public final GuildMember getFirstMentionedUser() {
        return this.firstMentionedUser;
    }

    public final GuildMember getInteractionAuthor() {
        return this.interactionAuthor;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final StoreMessageState.State getMessageState() {
        return this.messageState;
    }

    public final Map<Long, String> getNickOrUsernames() {
        return this.nickOrUsernames;
    }

    public final Long getPermissionsForChannel() {
        return this.permissionsForChannel;
    }

    public final ReplyData getReplyData() {
        return this.replyData;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Message message = this.message;
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        StoreMessageState.State state = this.messageState;
        int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
        GuildMember guildMember = this.author;
        int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        GuildMember guildMember2 = this.firstMentionedUser;
        int iHashCode4 = (iHashCode3 + (guildMember2 != null ? guildMember2.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode5 = (iHashCode4 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.nickOrUsernames;
        int iHashCode6 = (iHashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.isMinimal;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode6 + i) * 31;
        boolean z3 = this.isExpandedBlocked;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.animateEmojis;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        ReplyData replyData = this.replyData;
        int iHashCode7 = (i6 + (replyData != null ? replyData.hashCode() : 0)) * 31;
        GuildMember guildMember3 = this.interactionAuthor;
        int iHashCode8 = (iHashCode7 + (guildMember3 != null ? guildMember3.hashCode() : 0)) * 31;
        boolean z5 = this.isThreadStarterMessage;
        int i7 = z5;
        if (z5 != 0) {
            i7 = 1;
        }
        int i8 = (iHashCode8 + i7) * 31;
        boolean z6 = this.isGuildForumPostFirstMessage;
        int i9 = z6;
        if (z6 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z7 = this.isGuildForumPostAuthor;
        int i11 = (i10 + (z7 ? 1 : z7 ? 1 : 0)) * 31;
        CtaData ctaData = this.ctaData;
        int iHashCode9 = (i11 + (ctaData != null ? ctaData.hashCode() : 0)) * 31;
        Long l = this.permissionsForChannel;
        return iHashCode9 + (l != null ? l.hashCode() : 0);
    }

    public final boolean isGuildForumPostAuthor() {
        return this.isGuildForumPostAuthor;
    }

    public final boolean isGuildForumPostFirstMessage() {
        return this.isGuildForumPostFirstMessage;
    }

    @Override // com.discord.widgets.chat.list.entries.ChatListEntry
    public boolean isInExpandedBlockedMessageChunk() {
        return this.isExpandedBlocked;
    }

    public final boolean isThreadStarterMessage() {
        return this.isThreadStarterMessage;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageEntry(message=");
        sbU.append(this.message);
        sbU.append(", messageState=");
        sbU.append(this.messageState);
        sbU.append(", author=");
        sbU.append(this.author);
        sbU.append(", firstMentionedUser=");
        sbU.append(this.firstMentionedUser);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", nickOrUsernames=");
        sbU.append(this.nickOrUsernames);
        sbU.append(", isMinimal=");
        sbU.append(this.isMinimal);
        sbU.append(", isExpandedBlocked=");
        sbU.append(this.isExpandedBlocked);
        sbU.append(", animateEmojis=");
        sbU.append(this.animateEmojis);
        sbU.append(", replyData=");
        sbU.append(this.replyData);
        sbU.append(", interactionAuthor=");
        sbU.append(this.interactionAuthor);
        sbU.append(", isThreadStarterMessage=");
        sbU.append(this.isThreadStarterMessage);
        sbU.append(", isGuildForumPostFirstMessage=");
        sbU.append(this.isGuildForumPostFirstMessage);
        sbU.append(", isGuildForumPostAuthor=");
        sbU.append(this.isGuildForumPostAuthor);
        sbU.append(", ctaData=");
        sbU.append(this.ctaData);
        sbU.append(", permissionsForChannel=");
        return outline.G(sbU, this.permissionsForChannel, ")");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MessageEntry(Message message, StoreMessageState.State state, GuildMember guildMember, GuildMember guildMember2, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, boolean z3, boolean z4, ReplyData replyData, GuildMember guildMember3, boolean z5, boolean z6, boolean z7, CtaData ctaData, Long l) {
        Integer type;
        Integer type2;
        Integer type3;
        Integer type4;
        Integer type5;
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(map2, "nickOrUsernames");
        this.message = message;
        this.messageState = state;
        this.author = guildMember;
        this.firstMentionedUser = guildMember2;
        this.roles = map;
        this.nickOrUsernames = map2;
        this.isMinimal = z2;
        this.isExpandedBlocked = z3;
        this.animateEmojis = z4;
        this.replyData = replyData;
        this.interactionAuthor = guildMember3;
        this.isThreadStarterMessage = z5;
        this.isGuildForumPostFirstMessage = z6;
        this.isGuildForumPostAuthor = z7;
        this.ctaData = ctaData;
        this.permissionsForChannel = l;
        int i = 19;
        if (z2) {
            i = 1;
        } else if (!message.isInteraction() && (((type = message.getType()) == null || type.intValue() != 0) && ((type2 = message.getType()) == null || type2.intValue() != -1))) {
            Integer type6 = message.getType();
            if (((type6 != null && type6.intValue() == 20) || ((type3 = message.getType()) != null && type3.intValue() == 23)) && message.getInteraction() == null) {
                i = 33;
            } else {
                Integer type7 = message.getType();
                if ((type7 == null || type7.intValue() != 3) && ((type4 = message.getType()) == null || type4.intValue() != 13)) {
                    Integer type8 = message.getType();
                    if ((type8 != null && type8.intValue() == -2) || ((type5 = message.getType()) != null && type5.intValue() == -3)) {
                        i = 20;
                    } else {
                        Integer type9 = message.getType();
                        if (type9 != null && type9.intValue() == -6) {
                            i = 0;
                        } else {
                            Integer type10 = message.getType();
                            if (type10 != null && type10.intValue() == 19) {
                                i = 32;
                            } else {
                                Integer type11 = message.getType();
                                if (type11 != null && type11.intValue() == 22) {
                                    i = 38;
                                } else {
                                    Integer type12 = message.getType();
                                    i = (type12 != null && type12.intValue() == -8) ? 44 : 5;
                                }
                            }
                        }
                    }
                }
            }
        }
        this.type = i;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(' ');
        Object nonce = message.getNonce();
        sb.append(nonce == null ? Long.valueOf(message.getId()) : nonce);
        this.key = sb.toString();
    }
}
