package com.discord.models.experiments.dto;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001)B=\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJP\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\u000eR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0007R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b&\u0010\u000e¨\u0006*"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentDto;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "", "Lcom/discord/models/experiments/dto/GuildExperimentPopulationDto;", "component4", "()Ljava/util/List;", "Lcom/discord/models/experiments/dto/GuildExperimentOverridesDto;", "component5", "experimentIdHash", "hashKey", "revision", "populations", "overrides", "copy", "(JLjava/lang/String;ILjava/util/List;Ljava/util/List;)Lcom/discord/models/experiments/dto/GuildExperimentDto;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getRevision", "Ljava/util/List;", "getPopulations", "J", "getExperimentIdHash", "Ljava/lang/String;", "getHashKey", "getOverrides", "<init>", "(JLjava/lang/String;ILjava/util/List;Ljava/util/List;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildExperimentDto {
    private final long experimentIdHash;
    private final String hashKey;
    private final List<GuildExperimentOverridesDto> overrides;
    private final List<GuildExperimentPopulationDto> populations;
    private final int revision;

    /* compiled from: GuildExperimentDto.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentDto$Parser;", "", "Lcom/discord/models/domain/Model$JsonReader;", "jsonReader", "Lcom/discord/models/experiments/dto/GuildExperimentDto;", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentDto;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, java.util.List] */
        public static final GuildExperimentDto parse(Model.JsonReader jsonReader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(jsonReader, "jsonReader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            ref$ObjectRef4.element = Collections2.emptyList();
            jsonReader.nextListIndexed(new GuildExperimentDto$Parser$parse$1(ref$ObjectRefC0, jsonReader), new GuildExperimentDto$Parser$parse$2(ref$ObjectRef, jsonReader), new GuildExperimentDto$Parser$parse$3(ref$ObjectRef2, jsonReader), new GuildExperimentDto$Parser$parse$4(ref$ObjectRef3, jsonReader), new GuildExperimentDto$Parser$parse$5(ref$ObjectRef4, jsonReader));
            Long l = (Long) ref$ObjectRefC0.element;
            Intrinsics3.checkNotNull(l);
            long jLongValue = l.longValue();
            String str = (String) ref$ObjectRef.element;
            Integer num = (Integer) ref$ObjectRef2.element;
            Intrinsics3.checkNotNull(num);
            int iIntValue = num.intValue();
            List list = (List) ref$ObjectRef4.element;
            List list2 = (List) ref$ObjectRef3.element;
            Intrinsics3.checkNotNull(list2);
            return new GuildExperimentDto(jLongValue, str, iIntValue, list2, list);
        }
    }

    public GuildExperimentDto(long j, String str, int i, List<GuildExperimentPopulationDto> list, List<GuildExperimentOverridesDto> list2) {
        Intrinsics3.checkNotNullParameter(list, "populations");
        Intrinsics3.checkNotNullParameter(list2, "overrides");
        this.experimentIdHash = j;
        this.hashKey = str;
        this.revision = i;
        this.populations = list;
        this.overrides = list2;
    }

    public static /* synthetic */ GuildExperimentDto copy$default(GuildExperimentDto guildExperimentDto, long j, String str, int i, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = guildExperimentDto.experimentIdHash;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = guildExperimentDto.hashKey;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            i = guildExperimentDto.revision;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = guildExperimentDto.populations;
        }
        List list3 = list;
        if ((i2 & 16) != 0) {
            list2 = guildExperimentDto.overrides;
        }
        return guildExperimentDto.copy(j2, str2, i3, list3, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getExperimentIdHash() {
        return this.experimentIdHash;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHashKey() {
        return this.hashKey;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    public final List<GuildExperimentPopulationDto> component4() {
        return this.populations;
    }

    public final List<GuildExperimentOverridesDto> component5() {
        return this.overrides;
    }

    public final GuildExperimentDto copy(long experimentIdHash, String hashKey, int revision, List<GuildExperimentPopulationDto> populations, List<GuildExperimentOverridesDto> overrides) {
        Intrinsics3.checkNotNullParameter(populations, "populations");
        Intrinsics3.checkNotNullParameter(overrides, "overrides");
        return new GuildExperimentDto(experimentIdHash, hashKey, revision, populations, overrides);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentDto)) {
            return false;
        }
        GuildExperimentDto guildExperimentDto = (GuildExperimentDto) other;
        return this.experimentIdHash == guildExperimentDto.experimentIdHash && Intrinsics3.areEqual(this.hashKey, guildExperimentDto.hashKey) && this.revision == guildExperimentDto.revision && Intrinsics3.areEqual(this.populations, guildExperimentDto.populations) && Intrinsics3.areEqual(this.overrides, guildExperimentDto.overrides);
    }

    public final long getExperimentIdHash() {
        return this.experimentIdHash;
    }

    public final String getHashKey() {
        return this.hashKey;
    }

    public final List<GuildExperimentOverridesDto> getOverrides() {
        return this.overrides;
    }

    public final List<GuildExperimentPopulationDto> getPopulations() {
        return this.populations;
    }

    public final int getRevision() {
        return this.revision;
    }

    public int hashCode() {
        long j = this.experimentIdHash;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.hashKey;
        int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.revision) * 31;
        List<GuildExperimentPopulationDto> list = this.populations;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<GuildExperimentOverridesDto> list2 = this.overrides;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildExperimentDto(experimentIdHash=");
        sbU.append(this.experimentIdHash);
        sbU.append(", hashKey=");
        sbU.append(this.hashKey);
        sbU.append(", revision=");
        sbU.append(this.revision);
        sbU.append(", populations=");
        sbU.append(this.populations);
        sbU.append(", overrides=");
        return outline.L(sbU, this.overrides, ")");
    }
}
