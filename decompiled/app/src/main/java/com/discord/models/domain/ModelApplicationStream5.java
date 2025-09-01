package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelApplicationStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0002 !B#\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ2\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\b¨\u0006\""}, d2 = {"Lcom/discord/models/domain/StreamDelete;", "", "", "Lcom/discord/primitives/StreamKey;", "component1", "()Ljava/lang/String;", "Lcom/discord/models/domain/StreamDelete$Reason;", "component2", "()Lcom/discord/models/domain/StreamDelete$Reason;", "", "component3", "()Z", "streamKey", ModelAuditLogEntry.CHANGE_KEY_REASON, "unavailable", "copy", "(Ljava/lang/String;Lcom/discord/models/domain/StreamDelete$Reason;Z)Lcom/discord/models/domain/StreamDelete;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStreamKey", "Z", "getUnavailable", "Lcom/discord/models/domain/StreamDelete$Reason;", "getReason", "<init>", "(Ljava/lang/String;Lcom/discord/models/domain/StreamDelete$Reason;Z)V", "Parser", "Reason", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.StreamDelete, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelApplicationStream5 {
    private final Reason reason;
    private final String streamKey;
    private final boolean unavailable;

    /* compiled from: ModelApplicationStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/StreamDelete$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/StreamDelete;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/StreamDelete;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.StreamDelete$Parser */
    public static final class Parser implements Model.Parser<ModelApplicationStream5> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelApplicationStream5 parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
        @Override // com.discord.models.domain.Model.Parser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ModelApplicationStream5 parse(Model.JsonReader reader) throws IOException {
            Reason reason;
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new ModelApplicationStream6(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2));
            String str = (String) ref$ObjectRef.element;
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -2033943558) {
                    if (iHashCode != 620910836) {
                        reason = (iHashCode == 1627077614 && str.equals("stream_full")) ? Reason.STREAM_FULL : Reason.UNKNOWN;
                    } else if (str.equals("unauthorized")) {
                        reason = Reason.UNAUTHORIZED;
                    }
                } else if (str.equals("user_requested")) {
                    reason = Reason.USER_REQUESTED;
                }
            }
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("streamKey");
            }
            String str2 = (String) t;
            Boolean bool = (Boolean) ref$ObjectRef2.element;
            return new ModelApplicationStream5(str2, reason, bool != null ? bool.booleanValue() : false);
        }
    }

    /* compiled from: ModelApplicationStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/models/domain/StreamDelete$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_REQUESTED", "STREAM_FULL", "UNAUTHORIZED", "UNKNOWN", "app_models_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.StreamDelete$Reason */
    public enum Reason {
        USER_REQUESTED,
        STREAM_FULL,
        UNAUTHORIZED,
        UNKNOWN
    }

    public ModelApplicationStream5(String str, Reason reason, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, "streamKey");
        Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.streamKey = str;
        this.reason = reason;
        this.unavailable = z2;
    }

    public static /* synthetic */ ModelApplicationStream5 copy$default(ModelApplicationStream5 modelApplicationStream5, String str, Reason reason, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelApplicationStream5.streamKey;
        }
        if ((i & 2) != 0) {
            reason = modelApplicationStream5.reason;
        }
        if ((i & 4) != 0) {
            z2 = modelApplicationStream5.unavailable;
        }
        return modelApplicationStream5.copy(str, reason, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* renamed from: component2, reason: from getter */
    public final Reason getReason() {
        return this.reason;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getUnavailable() {
        return this.unavailable;
    }

    public final ModelApplicationStream5 copy(String streamKey, Reason reason, boolean unavailable) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        return new ModelApplicationStream5(streamKey, reason, unavailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream5)) {
            return false;
        }
        ModelApplicationStream5 modelApplicationStream5 = (ModelApplicationStream5) other;
        return Intrinsics3.areEqual(this.streamKey, modelApplicationStream5.streamKey) && Intrinsics3.areEqual(this.reason, modelApplicationStream5.reason) && this.unavailable == modelApplicationStream5.unavailable;
    }

    public final Reason getReason() {
        return this.reason;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final boolean getUnavailable() {
        return this.unavailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Reason reason = this.reason;
        int iHashCode2 = (iHashCode + (reason != null ? reason.hashCode() : 0)) * 31;
        boolean z2 = this.unavailable;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamDelete(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", unavailable=");
        return outline.O(sbU, this.unavailable, ")");
    }
}
