package com.discord.widgets.guilds.profile;

import b.d.b.a.outline;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guilds/profile/EmojiItem;", "", "", "type", "I", "getType", "()I", "<init>", "(I)V", "Companion", "EmojiData", "MoreEmoji", "Lcom/discord/widgets/guilds/profile/EmojiItem$EmojiData;", "Lcom/discord/widgets/guilds/profile/EmojiItem$MoreEmoji;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.EmojiItem, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class WidgetGuildProfileSheetEmojisAdapter3 {
    public static final int TYPE_EMOJI = 0;
    public static final int TYPE_MORE_EMOJI = 1;
    private final int type;

    /* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/profile/EmojiItem$EmojiData;", "Lcom/discord/widgets/guilds/profile/EmojiItem;", "Lcom/discord/models/domain/emoji/Emoji;", "component1", "()Lcom/discord/models/domain/emoji/Emoji;", "emoji", "copy", "(Lcom/discord/models/domain/emoji/Emoji;)Lcom/discord/widgets/guilds/profile/EmojiItem$EmojiData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/emoji/Emoji;", "getEmoji", "<init>", "(Lcom/discord/models/domain/emoji/Emoji;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.EmojiItem$EmojiData */
    public static final /* data */ class EmojiData extends WidgetGuildProfileSheetEmojisAdapter3 {
        private final Emoji emoji;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmojiData(Emoji emoji) {
            super(0, null);
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            this.emoji = emoji;
        }

        public static /* synthetic */ EmojiData copy$default(EmojiData emojiData, Emoji emoji, int i, Object obj) {
            if ((i & 1) != 0) {
                emoji = emojiData.emoji;
            }
            return emojiData.copy(emoji);
        }

        /* renamed from: component1, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final EmojiData copy(Emoji emoji) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            return new EmojiData(emoji);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof EmojiData) && Intrinsics3.areEqual(this.emoji, ((EmojiData) other).emoji);
            }
            return true;
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public int hashCode() {
            Emoji emoji = this.emoji;
            if (emoji != null) {
                return emoji.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("EmojiData(emoji=");
            sbU.append(this.emoji);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/profile/EmojiItem$MoreEmoji;", "Lcom/discord/widgets/guilds/profile/EmojiItem;", "", "component1", "()I", "extraEmojiCount", "copy", "(I)Lcom/discord/widgets/guilds/profile/EmojiItem$MoreEmoji;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getExtraEmojiCount", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.EmojiItem$MoreEmoji */
    public static final /* data */ class MoreEmoji extends WidgetGuildProfileSheetEmojisAdapter3 {
        private final int extraEmojiCount;

        public MoreEmoji(int i) {
            super(1, null);
            this.extraEmojiCount = i;
        }

        public static /* synthetic */ MoreEmoji copy$default(MoreEmoji moreEmoji, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = moreEmoji.extraEmojiCount;
            }
            return moreEmoji.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getExtraEmojiCount() {
            return this.extraEmojiCount;
        }

        public final MoreEmoji copy(int extraEmojiCount) {
            return new MoreEmoji(extraEmojiCount);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof MoreEmoji) && this.extraEmojiCount == ((MoreEmoji) other).extraEmojiCount;
            }
            return true;
        }

        public final int getExtraEmojiCount() {
            return this.extraEmojiCount;
        }

        public int hashCode() {
            return this.extraEmojiCount;
        }

        public String toString() {
            return outline.B(outline.U("MoreEmoji(extraEmojiCount="), this.extraEmojiCount, ")");
        }
    }

    private WidgetGuildProfileSheetEmojisAdapter3(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ WidgetGuildProfileSheetEmojisAdapter3(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
