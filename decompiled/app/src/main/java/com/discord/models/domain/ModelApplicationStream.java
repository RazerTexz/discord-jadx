package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.LazyJVM;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelApplicationStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00172\u00020\u0001:\u0003\u0018\u0017\u0019B!\b\u0002\u0012\n\u0010\u0013\u001a\u00060\u0006j\u0002`\u0012\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H$¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R!\u0010\u0011\u001a\u00060\u0002j\u0002`\u00038F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0005R \u0010\u0013\u001a\u00060\u0006j\u0002`\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\u0082\u0001\u0002\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/discord/models/domain/ModelApplicationStream;", "Ljava/io/Serializable;", "", "Lcom/discord/primitives/StreamKey;", "encodeStreamKey", "()Ljava/lang/String;", "", "Lcom/discord/primitives/UserId;", "ownerId", "J", "getOwnerId", "()J", "getType", "type", "encodedStreamKey$delegate", "Lkotlin/Lazy;", "getEncodedStreamKey", "encodedStreamKey", "Lcom/discord/primitives/ChannelId;", "channelId", "getChannelId", "<init>", "(JJ)V", "Companion", "CallStream", "GuildStream", "Lcom/discord/models/domain/ModelApplicationStream$GuildStream;", "Lcom/discord/models/domain/ModelApplicationStream$CallStream;", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class ModelApplicationStream implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;

    /* renamed from: encodedStreamKey$delegate, reason: from kotlin metadata */
    private final Lazy encodedStreamKey;
    private final long ownerId;

    /* compiled from: ModelApplicationStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\r\u001a\u00060\u0006j\u0002`\n¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000b\u001a\u00060\u0006j\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ,\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u0010\r\u001a\u00060\u0006j\u0002`\nHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\f\u001a\u00060\u0006j\u0002`\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R \u0010\r\u001a\u00060\u0006j\u0002`\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001e\u0010\t¨\u0006!"}, d2 = {"Lcom/discord/models/domain/ModelApplicationStream$CallStream;", "Lcom/discord/models/domain/ModelApplicationStream;", "", "Lcom/discord/primitives/StreamKey;", "encodeStreamKey", "()Ljava/lang/String;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/UserId;", "component2", "channelId", "ownerId", "copy", "(JJ)Lcom/discord/models/domain/ModelApplicationStream$CallStream;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "type", "Ljava/lang/String;", "getType", "getOwnerId", "<init>", "(JJ)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CallStream extends ModelApplicationStream {
        private final long channelId;
        private final long ownerId;
        private final String type;

        public CallStream(long j, long j2) {
            super(j, j2, null);
            this.channelId = j;
            this.ownerId = j2;
            this.type = ModelApplicationStream9.CALL.getSerializedRepresentation();
        }

        public static /* synthetic */ CallStream copy$default(CallStream callStream, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = callStream.getChannelId();
            }
            if ((i & 2) != 0) {
                j2 = callStream.getOwnerId();
            }
            return callStream.copy(j, j2);
        }

        public final long component1() {
            return getChannelId();
        }

        public final long component2() {
            return getOwnerId();
        }

        public final CallStream copy(long channelId, long ownerId) {
            return new CallStream(channelId, ownerId);
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public String encodeStreamKey() {
            return ModelApplicationStream9.CALL.getSerializedRepresentation() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + getChannelId() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + getOwnerId();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallStream)) {
                return false;
            }
            CallStream callStream = (CallStream) other;
            return getChannelId() == callStream.getChannelId() && getOwnerId() == callStream.getOwnerId();
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public long getChannelId() {
            return this.channelId;
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public long getOwnerId() {
            return this.ownerId;
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public String getType() {
            return this.type;
        }

        public int hashCode() {
            long channelId = getChannelId();
            int i = ((int) (channelId ^ (channelId >>> 32))) * 31;
            long ownerId = getOwnerId();
            return i + ((int) (ownerId ^ (ownerId >>> 32)));
        }

        public String toString() {
            StringBuilder sbU = outline.U("CallStream(channelId=");
            sbU.append(getChannelId());
            sbU.append(", ownerId=");
            sbU.append(getOwnerId());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ModelApplicationStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/models/domain/ModelApplicationStream$Companion;", "", "", "Lcom/discord/primitives/StreamKey;", "streamKey", "Lcom/discord/models/domain/ModelApplicationStream;", "decodeStreamKey", "(Ljava/lang/String;)Lcom/discord/models/domain/ModelApplicationStream;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                ModelApplicationStream9.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[ModelApplicationStream9.GUILD.ordinal()] = 1;
                iArr[ModelApplicationStream9.CALL.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        public final ModelApplicationStream decodeStreamKey(String streamKey) {
            Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
            List listSplit$default = Strings4.split$default((CharSequence) streamKey, new String[]{":"}, false, 0, 6, (Object) null);
            int iOrdinal = ModelApplicationStream9.INSTANCE.fromString((String) listSplit$default.get(0)).ordinal();
            if (iOrdinal == 0) {
                return new GuildStream(Long.parseLong((String) listSplit$default.get(1)), Long.parseLong((String) listSplit$default.get(2)), Long.parseLong((String) listSplit$default.get(3)));
            }
            if (iOrdinal == 1) {
                return new CallStream(Long.parseLong((String) listSplit$default.get(1)), Long.parseLong((String) listSplit$default.get(2)));
            }
            throw new NoWhenBranchMatchedException();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ModelApplicationStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\u000f\u001a\u00060\u0006j\u0002`\n\u0012\n\u0010\u0010\u001a\u00060\u0006j\u0002`\f¢\u0006\u0004\b#\u0010$J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000b\u001a\u00060\u0006j\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0014\u0010\r\u001a\u00060\u0006j\u0002`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\tJ:\u0010\u0011\u001a\u00020\u00002\f\b\u0002\u0010\u000e\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u0010\u000f\u001a\u00060\u0006j\u0002`\n2\f\b\u0002\u0010\u0010\u001a\u00060\u0006j\u0002`\fHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u001d\u0010\u000e\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\tR \u0010\u000f\u001a\u00060\u0006j\u0002`\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\tR \u0010\u0010\u001a\u00060\u0006j\u0002`\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b\"\u0010\t¨\u0006%"}, d2 = {"Lcom/discord/models/domain/ModelApplicationStream$GuildStream;", "Lcom/discord/models/domain/ModelApplicationStream;", "", "Lcom/discord/primitives/StreamKey;", "encodeStreamKey", "()Ljava/lang/String;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "Lcom/discord/primitives/UserId;", "component3", "guildId", "channelId", "ownerId", "copy", "(JJJ)Lcom/discord/models/domain/ModelApplicationStream$GuildStream;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "Ljava/lang/String;", "getType", "J", "getGuildId", "getChannelId", "getOwnerId", "<init>", "(JJJ)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildStream extends ModelApplicationStream {
        private final long channelId;
        private final long guildId;
        private final long ownerId;
        private final String type;

        public GuildStream(long j, long j2, long j3) {
            super(j2, j3, null);
            this.guildId = j;
            this.channelId = j2;
            this.ownerId = j3;
            this.type = ModelApplicationStream9.GUILD.getSerializedRepresentation();
        }

        public static /* synthetic */ GuildStream copy$default(GuildStream guildStream, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = guildStream.guildId;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = guildStream.getChannelId();
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = guildStream.getOwnerId();
            }
            return guildStream.copy(j4, j5, j3);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final long component2() {
            return getChannelId();
        }

        public final long component3() {
            return getOwnerId();
        }

        public final GuildStream copy(long guildId, long channelId, long ownerId) {
            return new GuildStream(guildId, channelId, ownerId);
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public String encodeStreamKey() {
            return ModelApplicationStream9.GUILD.getSerializedRepresentation() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + this.guildId + MentionUtils.EMOJIS_AND_STICKERS_CHAR + getChannelId() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + getOwnerId();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildStream)) {
                return false;
            }
            GuildStream guildStream = (GuildStream) other;
            return this.guildId == guildStream.guildId && getChannelId() == guildStream.getChannelId() && getOwnerId() == guildStream.getOwnerId();
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public long getChannelId() {
            return this.channelId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public long getOwnerId() {
            return this.ownerId;
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public String getType() {
            return this.type;
        }

        public int hashCode() {
            long j = this.guildId;
            long channelId = getChannelId();
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (channelId ^ (channelId >>> 32)))) * 31;
            long ownerId = getOwnerId();
            return i + ((int) (ownerId ^ (ownerId >>> 32)));
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildStream(guildId=");
            sbU.append(this.guildId);
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(", ownerId=");
            sbU.append(getOwnerId());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private ModelApplicationStream(long j, long j2) {
        this.channelId = j;
        this.ownerId = j2;
        this.encodedStreamKey = LazyJVM.lazy(new ModelApplicationStream2(this));
    }

    public abstract String encodeStreamKey();

    public long getChannelId() {
        return this.channelId;
    }

    public final String getEncodedStreamKey() {
        return (String) this.encodedStreamKey.getValue();
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    public abstract String getType();

    public /* synthetic */ ModelApplicationStream(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }
}
