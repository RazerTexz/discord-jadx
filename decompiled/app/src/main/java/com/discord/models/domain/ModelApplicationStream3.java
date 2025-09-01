package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelApplicationStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001%B7\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\n¢\u0006\u0004\b#\u0010$J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\nHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u0013\u001a\u00020\u00002\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00072\u0012\b\u0002\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR#\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R\u001d\u0010\u000f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0005R\u0019\u0010\u0011\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\t¨\u0006&"}, d2 = {"Lcom/discord/models/domain/StreamCreateOrUpdate;", "", "", "Lcom/discord/primitives/StreamKey;", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "", "", "Lcom/discord/primitives/UserId;", "component4", "()Ljava/util/List;", "streamKey", "rtcServerId", "paused", "viewerIds", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)Lcom/discord/models/domain/StreamCreateOrUpdate;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getViewerIds", "Ljava/lang/String;", "getRtcServerId", "getStreamKey", "Z", "getPaused", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.StreamCreateOrUpdate, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelApplicationStream3 {
    private final boolean paused;
    private final String rtcServerId;
    private final String streamKey;
    private final List<Long> viewerIds;

    /* compiled from: ModelApplicationStream.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/StreamCreateOrUpdate$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/StreamCreateOrUpdate;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/StreamCreateOrUpdate;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.StreamCreateOrUpdate$Parser */
    public static final class Parser implements Model.Parser<ModelApplicationStream3> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelApplicationStream3 parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelApplicationStream3 parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = false;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new ModelApplicationStream4(ref$ObjectRefC0, reader, ref$ObjectRef, ref$BooleanRef, ref$ObjectRef2));
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("streamKey");
            }
            String str = (String) t;
            String str2 = (String) ref$ObjectRef.element;
            boolean z2 = ref$BooleanRef.element;
            List listEmptyList = (List) ref$ObjectRef2.element;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return new ModelApplicationStream3(str, str2, z2, listEmptyList);
        }
    }

    public ModelApplicationStream3(String str, String str2, boolean z2, List<Long> list) {
        Intrinsics3.checkNotNullParameter(str, "streamKey");
        Intrinsics3.checkNotNullParameter(list, "viewerIds");
        this.streamKey = str;
        this.rtcServerId = str2;
        this.paused = z2;
        this.viewerIds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelApplicationStream3 copy$default(ModelApplicationStream3 modelApplicationStream3, String str, String str2, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelApplicationStream3.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = modelApplicationStream3.rtcServerId;
        }
        if ((i & 4) != 0) {
            z2 = modelApplicationStream3.paused;
        }
        if ((i & 8) != 0) {
            list = modelApplicationStream3.viewerIds;
        }
        return modelApplicationStream3.copy(str, str2, z2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRtcServerId() {
        return this.rtcServerId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPaused() {
        return this.paused;
    }

    public final List<Long> component4() {
        return this.viewerIds;
    }

    public final ModelApplicationStream3 copy(String streamKey, String rtcServerId, boolean paused, List<Long> viewerIds) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(viewerIds, "viewerIds");
        return new ModelApplicationStream3(streamKey, rtcServerId, paused, viewerIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream3)) {
            return false;
        }
        ModelApplicationStream3 modelApplicationStream3 = (ModelApplicationStream3) other;
        return Intrinsics3.areEqual(this.streamKey, modelApplicationStream3.streamKey) && Intrinsics3.areEqual(this.rtcServerId, modelApplicationStream3.rtcServerId) && this.paused == modelApplicationStream3.paused && Intrinsics3.areEqual(this.viewerIds, modelApplicationStream3.viewerIds);
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final String getRtcServerId() {
        return this.rtcServerId;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final List<Long> getViewerIds() {
        return this.viewerIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.rtcServerId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.paused;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        List<Long> list = this.viewerIds;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamCreateOrUpdate(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", rtcServerId=");
        sbU.append(this.rtcServerId);
        sbU.append(", paused=");
        sbU.append(this.paused);
        sbU.append(", viewerIds=");
        return outline.L(sbU, this.viewerIds, ")");
    }
}
