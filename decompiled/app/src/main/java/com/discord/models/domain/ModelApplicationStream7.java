package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelApplicationStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB'\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J6\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0005R\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/models/domain/StreamServerUpdate;", "", "", "Lcom/discord/primitives/StreamKey;", "component1", "()Ljava/lang/String;", "component2", "component3", "streamKey", "endpoint", "token", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/domain/StreamServerUpdate;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "getEndpoint", "getStreamKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.StreamServerUpdate, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelApplicationStream7 {
    private final String endpoint;
    private final String streamKey;
    private final String token;

    /* compiled from: ModelApplicationStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/StreamServerUpdate$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/StreamServerUpdate;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/StreamServerUpdate;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.StreamServerUpdate$Parser */
    public static final class Parser implements Model.Parser<ModelApplicationStream7> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelApplicationStream7 parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelApplicationStream7 parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new ModelApplicationStream8(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2));
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("streamKey");
            }
            return new ModelApplicationStream7((String) t, (String) ref$ObjectRef.element, (String) ref$ObjectRef2.element);
        }
    }

    public ModelApplicationStream7(String str, String str2, String str3) {
        Intrinsics3.checkNotNullParameter(str, "streamKey");
        this.streamKey = str;
        this.endpoint = str2;
        this.token = str3;
    }

    public static /* synthetic */ ModelApplicationStream7 copy$default(ModelApplicationStream7 modelApplicationStream7, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelApplicationStream7.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = modelApplicationStream7.endpoint;
        }
        if ((i & 4) != 0) {
            str3 = modelApplicationStream7.token;
        }
        return modelApplicationStream7.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEndpoint() {
        return this.endpoint;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final ModelApplicationStream7 copy(String streamKey, String endpoint, String token) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        return new ModelApplicationStream7(streamKey, endpoint, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream7)) {
            return false;
        }
        ModelApplicationStream7 modelApplicationStream7 = (ModelApplicationStream7) other;
        return Intrinsics3.areEqual(this.streamKey, modelApplicationStream7.streamKey) && Intrinsics3.areEqual(this.endpoint, modelApplicationStream7.endpoint) && Intrinsics3.areEqual(this.token, modelApplicationStream7.token);
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.endpoint;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.token;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamServerUpdate(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", endpoint=");
        sbU.append(this.endpoint);
        sbU.append(", token=");
        return outline.J(sbU, this.token, ")");
    }
}
