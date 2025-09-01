package com.discord.widgets.chat.input.emoji;

import a0.a.a.b;
import b.d.b.a.outline;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmojiPickerContextType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;", "Ljava/io/Serializable;", "<init>", "()V", "Chat", "Global", "Guild", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType$Chat;", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType$Global;", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType$Guild;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class EmojiPickerContextType implements Serializable {

    /* compiled from: EmojiPickerContextType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType$Chat;", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Chat extends EmojiPickerContextType {
        public static final Chat INSTANCE = new Chat();

        private Chat() {
            super(null);
        }
    }

    /* compiled from: EmojiPickerContextType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType$Global;", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Global extends EmojiPickerContextType {
        public static final Global INSTANCE = new Global();

        private Global() {
            super(null);
        }
    }

    /* compiled from: EmojiPickerContextType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType$Guild;", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/widgets/chat/input/emoji/EmojiPickerContextType$Guild;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Guild extends EmojiPickerContextType {
        private final long guildId;

        public Guild(long j) {
            super(null);
            this.guildId = j;
        }

        public static /* synthetic */ Guild copy$default(Guild guild, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = guild.guildId;
            }
            return guild.copy(j);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final Guild copy(long guildId) {
            return new Guild(guildId);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Guild) && this.guildId == ((Guild) other).guildId;
            }
            return true;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            return b.a(this.guildId);
        }

        public String toString() {
            return outline.C(outline.U("Guild(guildId="), this.guildId, ")");
        }
    }

    private EmojiPickerContextType() {
    }

    public /* synthetic */ EmojiPickerContextType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
