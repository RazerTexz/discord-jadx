package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.thread.MuteConfig;
import com.discord.models.domain.Model;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelMuteConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B'\u0012\u000e\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u000e\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\u001a\u0010\u001bB\u0019\b\u0016\u0012\u000e\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u001a\u0010\u001cB\u0019\b\u0016\u0012\u000e\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\u001a\u0010\u001dB\u0013\b\u0016\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001a\u0010 J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R!\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\tR!\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005¨\u0006\""}, d2 = {"Lcom/discord/models/domain/ModelMuteConfig;", "", "", "Lcom/discord/primitives/Timestamp;", "component1", "()Ljava/lang/Long;", "", "Lcom/discord/primitives/UtcTimestamp;", "component2", "()Ljava/lang/String;", "endTimeMs", "endTime", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/discord/models/domain/ModelMuteConfig;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEndTime", "Ljava/lang/Long;", "getEndTimeMs", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "(Ljava/lang/Long;)V", "(Ljava/lang/String;)V", "Lcom/discord/api/thread/MuteConfig;", "muteConfig", "(Lcom/discord/api/thread/MuteConfig;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelMuteConfig {

    /* renamed from: Parser, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String endTime;
    private final Long endTimeMs;

    /* compiled from: ModelMuteConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/ModelMuteConfig$Parser;", "Lcom/discord/models/domain/Model$Parser;", "Lcom/discord/models/domain/ModelMuteConfig;", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/domain/ModelMuteConfig;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.ModelMuteConfig$Parser, reason: from kotlin metadata */
    public static final class Companion implements Model.Parser<ModelMuteConfig> {
        private Companion() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelMuteConfig parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelMuteConfig parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            reader.nextObject(new ModelMuteConfig2(ref$ObjectRefC0, reader));
            return new ModelMuteConfig((String) ref$ObjectRefC0.element);
        }
    }

    public ModelMuteConfig(Long l, String str) {
        this.endTimeMs = l;
        this.endTime = str;
    }

    public static /* synthetic */ ModelMuteConfig copy$default(ModelMuteConfig modelMuteConfig, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modelMuteConfig.endTimeMs;
        }
        if ((i & 2) != 0) {
            str = modelMuteConfig.endTime;
        }
        return modelMuteConfig.copy(l, str);
    }

    public static ModelMuteConfig parse(Model.JsonReader jsonReader) {
        return INSTANCE.parse(jsonReader);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getEndTimeMs() {
        return this.endTimeMs;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    public final ModelMuteConfig copy(Long endTimeMs, String endTime) {
        return new ModelMuteConfig(endTimeMs, endTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelMuteConfig)) {
            return false;
        }
        ModelMuteConfig modelMuteConfig = (ModelMuteConfig) other;
        return Intrinsics3.areEqual(this.endTimeMs, modelMuteConfig.endTimeMs) && Intrinsics3.areEqual(this.endTime, modelMuteConfig.endTime);
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final Long getEndTimeMs() {
        return this.endTimeMs;
    }

    public int hashCode() {
        Long l = this.endTimeMs;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.endTime;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelMuteConfig(endTimeMs=");
        sbU.append(this.endTimeMs);
        sbU.append(", endTime=");
        return outline.J(sbU, this.endTime, ")");
    }

    public ModelMuteConfig(Long l) {
        this(l, l != null ? TimeUtils.toUTCDateTime$default(Long.valueOf(l.longValue()), null, 2, null) : null);
    }

    public ModelMuteConfig(String str) {
        this(str != null ? Long.valueOf(TimeUtils.parseUTCDate(str)) : null, str);
    }

    public ModelMuteConfig(MuteConfig muteConfig) {
        this(Long.valueOf(TimeUtils.parseUTCDate(muteConfig != null ? muteConfig.getEndTime() : null)), muteConfig != null ? muteConfig.getEndTime() : null);
    }
}
