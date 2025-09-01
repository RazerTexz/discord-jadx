package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;

/* compiled from: ModelReadState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'B/\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\"\u0010#BM\b\u0012\u0012\n\u0010$\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u0006\u0012\f\b\u0002\u0010%\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\"\u0010&J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ@\u0010\u0010\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001d\u0010\r\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b \u0010\u0005R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b!\u0010\n¨\u0006("}, d2 = {"Lcom/discord/models/domain/ModelReadState;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "", "component3", "()I", "component4", "channelId", "lastMessageId", "mentionCount", "version", "copy", "(JJII)Lcom/discord/models/domain/ModelReadState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "isMentioned", "()Z", "I", "getVersion", "J", "getChannelId", "getLastMessageId", "getMentionCount", "<init>", "(JJII)V", ModelAuditLogEntry.CHANGE_KEY_ID, "messageId", "(JJJJII)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelReadState {
    private final long channelId;
    private final long lastMessageId;
    private final int mentionCount;
    private final int version;

    /* compiled from: ModelReadState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelReadState$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelReadState;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelReadState;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser implements Model.Parser<ModelReadState> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelReadState parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.Parser
        public ModelReadState parse(Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = 0;
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = 0L;
            Ref$LongRef ref$LongRef2 = new Ref$LongRef();
            ref$LongRef2.element = 0L;
            Ref$LongRef ref$LongRef3 = new Ref$LongRef();
            ref$LongRef3.element = 0L;
            Ref$LongRef ref$LongRef4 = new Ref$LongRef();
            ref$LongRef4.element = 0L;
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            ref$IntRef2.element = 0;
            reader.nextObject(new ModelReadState2(ref$LongRef3, reader, ref$IntRef, ref$LongRef, ref$LongRef2, ref$LongRef4, ref$IntRef2));
            return new ModelReadState(ref$LongRef3.element, ref$LongRef4.element, ref$LongRef.element, ref$LongRef2.element, ref$IntRef.element, ref$IntRef2.element, null);
        }
    }

    public ModelReadState(long j, long j2, int i, int i2) {
        this.channelId = j;
        this.lastMessageId = j2;
        this.mentionCount = i;
        this.version = i2;
    }

    public static /* synthetic */ ModelReadState copy$default(ModelReadState modelReadState, long j, long j2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = modelReadState.channelId;
        }
        long j3 = j;
        if ((i3 & 2) != 0) {
            j2 = modelReadState.lastMessageId;
        }
        long j4 = j2;
        if ((i3 & 4) != 0) {
            i = modelReadState.mentionCount;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = modelReadState.version;
        }
        return modelReadState.copy(j3, j4, i4, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLastMessageId() {
        return this.lastMessageId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMentionCount() {
        return this.mentionCount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final ModelReadState copy(long channelId, long lastMessageId, int mentionCount, int version) {
        return new ModelReadState(channelId, lastMessageId, mentionCount, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelReadState)) {
            return false;
        }
        ModelReadState modelReadState = (ModelReadState) other;
        return this.channelId == modelReadState.channelId && this.lastMessageId == modelReadState.lastMessageId && this.mentionCount == modelReadState.mentionCount && this.version == modelReadState.version;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getLastMessageId() {
        return this.lastMessageId;
    }

    public final int getMentionCount() {
        return this.mentionCount;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.lastMessageId;
        return ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.mentionCount) * 31) + this.version;
    }

    public final boolean isMentioned() {
        return this.mentionCount > 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelReadState(channelId=");
        sbU.append(this.channelId);
        sbU.append(", lastMessageId=");
        sbU.append(this.lastMessageId);
        sbU.append(", mentionCount=");
        sbU.append(this.mentionCount);
        sbU.append(", version=");
        return outline.B(sbU, this.version, ")");
    }

    public /* synthetic */ ModelReadState(long j, long j2, long j3, long j4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, i, i2);
    }

    public /* synthetic */ ModelReadState(long j, long j2, long j3, long j4, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0L : j4, i, i2);
    }

    private ModelReadState(long j, long j2, long j3, long j4, int i, int i2) {
        this(j2 != 0 ? j2 : j, j3 != 0 ? j3 : j4, i, i2);
    }
}
