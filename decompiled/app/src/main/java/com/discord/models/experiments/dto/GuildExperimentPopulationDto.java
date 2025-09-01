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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB#\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J0\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentPopulationDto;", "", "", "Lcom/discord/models/experiments/dto/GuildExperimentBucketDto;", "component1", "()Ljava/util/List;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter;", "component2", "buckets", "filters", "copy", "(Ljava/util/List;Ljava/util/List;)Lcom/discord/models/experiments/dto/GuildExperimentPopulationDto;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getBuckets", "getFilters", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildExperimentPopulationDto {
    private final List<GuildExperimentBucketDto> buckets;
    private final List<GuildExperimentFilter> filters;

    /* compiled from: GuildExperimentDto.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentPopulationDto$Parser;", "", "Lcom/discord/models/domain/Model$JsonReader;", "jsonReader", "Lcom/discord/models/experiments/dto/GuildExperimentPopulationDto;", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentPopulationDto;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        public final GuildExperimentPopulationDto parse(Model.JsonReader jsonReader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(jsonReader, "jsonReader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            jsonReader.nextListIndexed(new GuildExperimentPopulationDto$Parser$parse$1(ref$ObjectRefC0, jsonReader), new GuildExperimentPopulationDto$Parser$parse$2(ref$ObjectRef, jsonReader));
            List list = (List) ref$ObjectRefC0.element;
            Intrinsics3.checkNotNull(list);
            List listEmptyList = (List) ref$ObjectRef.element;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return new GuildExperimentPopulationDto(list, listEmptyList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildExperimentPopulationDto(List<GuildExperimentBucketDto> list, List<? extends GuildExperimentFilter> list2) {
        Intrinsics3.checkNotNullParameter(list, "buckets");
        Intrinsics3.checkNotNullParameter(list2, "filters");
        this.buckets = list;
        this.filters = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentPopulationDto copy$default(GuildExperimentPopulationDto guildExperimentPopulationDto, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = guildExperimentPopulationDto.buckets;
        }
        if ((i & 2) != 0) {
            list2 = guildExperimentPopulationDto.filters;
        }
        return guildExperimentPopulationDto.copy(list, list2);
    }

    public final List<GuildExperimentBucketDto> component1() {
        return this.buckets;
    }

    public final List<GuildExperimentFilter> component2() {
        return this.filters;
    }

    public final GuildExperimentPopulationDto copy(List<GuildExperimentBucketDto> buckets, List<? extends GuildExperimentFilter> filters) {
        Intrinsics3.checkNotNullParameter(buckets, "buckets");
        Intrinsics3.checkNotNullParameter(filters, "filters");
        return new GuildExperimentPopulationDto(buckets, filters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentPopulationDto)) {
            return false;
        }
        GuildExperimentPopulationDto guildExperimentPopulationDto = (GuildExperimentPopulationDto) other;
        return Intrinsics3.areEqual(this.buckets, guildExperimentPopulationDto.buckets) && Intrinsics3.areEqual(this.filters, guildExperimentPopulationDto.filters);
    }

    public final List<GuildExperimentBucketDto> getBuckets() {
        return this.buckets;
    }

    public final List<GuildExperimentFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        List<GuildExperimentBucketDto> list = this.buckets;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<GuildExperimentFilter> list2 = this.filters;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildExperimentPopulationDto(buckets=");
        sbU.append(this.buckets);
        sbU.append(", filters=");
        return outline.L(sbU, this.filters, ")");
    }
}
