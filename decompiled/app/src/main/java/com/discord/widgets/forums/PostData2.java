package com.discord.widgets.forums;

import b.d.b.a.outline;
import com.discord.api.channel.ForumTag;
import com.discord.api.message.reaction.MessageReactionEmoji;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PostData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/forums/PostTagData;", "", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "component1", "()Lcom/discord/api/message/reaction/MessageReactionEmoji;", "", "component2", "()Ljava/lang/String;", "messageReactionEmoji", "tagName", "copy", "(Lcom/discord/api/message/reaction/MessageReactionEmoji;Ljava/lang/String;)Lcom/discord/widgets/forums/PostTagData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTagName", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "getMessageReactionEmoji", "<init>", "(Lcom/discord/api/message/reaction/MessageReactionEmoji;Ljava/lang/String;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.PostTagData, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class PostData2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MessageReactionEmoji messageReactionEmoji;
    private final String tagName;

    /* compiled from: PostData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/forums/PostTagData$Companion;", "", "Lcom/discord/api/channel/ForumTag;", "tag", "", "animated", "Lcom/discord/widgets/forums/PostTagData;", "fromTag", "(Lcom/discord/api/channel/ForumTag;Z)Lcom/discord/widgets/forums/PostTagData;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.PostTagData$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ PostData2 fromTag$default(Companion companion, ForumTag forumTag, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return companion.fromTag(forumTag, z2);
        }

        public final PostData2 fromTag(ForumTag tag, boolean animated) {
            Intrinsics3.checkNotNullParameter(tag, "tag");
            return new PostData2(new MessageReactionEmoji(tag.getCustomEmojiId(), tag.getEmojiName(), animated), tag.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PostData2(MessageReactionEmoji messageReactionEmoji, String str) {
        Intrinsics3.checkNotNullParameter(messageReactionEmoji, "messageReactionEmoji");
        Intrinsics3.checkNotNullParameter(str, "tagName");
        this.messageReactionEmoji = messageReactionEmoji;
        this.tagName = str;
    }

    public static /* synthetic */ PostData2 copy$default(PostData2 postData2, MessageReactionEmoji messageReactionEmoji, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            messageReactionEmoji = postData2.messageReactionEmoji;
        }
        if ((i & 2) != 0) {
            str = postData2.tagName;
        }
        return postData2.copy(messageReactionEmoji, str);
    }

    /* renamed from: component1, reason: from getter */
    public final MessageReactionEmoji getMessageReactionEmoji() {
        return this.messageReactionEmoji;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    public final PostData2 copy(MessageReactionEmoji messageReactionEmoji, String tagName) {
        Intrinsics3.checkNotNullParameter(messageReactionEmoji, "messageReactionEmoji");
        Intrinsics3.checkNotNullParameter(tagName, "tagName");
        return new PostData2(messageReactionEmoji, tagName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostData2)) {
            return false;
        }
        PostData2 postData2 = (PostData2) other;
        return Intrinsics3.areEqual(this.messageReactionEmoji, postData2.messageReactionEmoji) && Intrinsics3.areEqual(this.tagName, postData2.tagName);
    }

    public final MessageReactionEmoji getMessageReactionEmoji() {
        return this.messageReactionEmoji;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public int hashCode() {
        MessageReactionEmoji messageReactionEmoji = this.messageReactionEmoji;
        int iHashCode = (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0) * 31;
        String str = this.tagName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PostTagData(messageReactionEmoji=");
        sbU.append(this.messageReactionEmoji);
        sbU.append(", tagName=");
        return outline.J(sbU, this.tagName, ")");
    }
}
