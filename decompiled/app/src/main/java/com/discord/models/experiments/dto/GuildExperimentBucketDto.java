package com.discord.models.experiments.dto;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges2;

/* compiled from: GuildExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentBucketDto;", "", "", "component1", "()I", "", "Lkotlin/ranges/IntRange;", "component2", "()Ljava/util/List;", "bucket", "positions", "copy", "(ILjava/util/List;)Lcom/discord/models/experiments/dto/GuildExperimentBucketDto;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getBucket", "Ljava/util/List;", "getPositions", "<init>", "(ILjava/util/List;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildExperimentBucketDto {
    private final int bucket;
    private final List<Ranges2> positions;

    /* compiled from: GuildExperimentDto.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentBucketDto$Parser;", "", "Lcom/discord/models/domain/Model$JsonReader;", "jsonReader", "Lkotlin/ranges/IntRange;", "parsePosition", "(Lcom/discord/models/domain/Model$JsonReader;)Lkotlin/ranges/IntRange;", "reader", "Lcom/discord/models/experiments/dto/GuildExperimentBucketDto;", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentBucketDto;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        public static final /* synthetic */ Ranges2 access$parsePosition(Parser parser, Model.JsonReader jsonReader) {
            return parser.parsePosition(jsonReader);
        }

        private final Ranges2 parsePosition(Model.JsonReader jsonReader) throws IOException {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            ref$IntRef2.element = -1;
            jsonReader.nextObject(new GuildExperimentBucketDto$Parser$parsePosition$1(ref$IntRef, jsonReader, ref$IntRef2));
            return new Ranges2(ref$IntRef.element, ref$IntRef2.element);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
        public final GuildExperimentBucketDto parse(Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Collections2.emptyList();
            reader.nextListIndexed(new GuildExperimentBucketDto$Parser$parse$1(ref$IntRef, reader), new GuildExperimentBucketDto$Parser$parse$2(ref$ObjectRef, reader));
            return new GuildExperimentBucketDto(ref$IntRef.element, (List) ref$ObjectRef.element);
        }
    }

    public GuildExperimentBucketDto(int i, List<Ranges2> list) {
        Intrinsics3.checkNotNullParameter(list, "positions");
        this.bucket = i;
        this.positions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentBucketDto copy$default(GuildExperimentBucketDto guildExperimentBucketDto, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildExperimentBucketDto.bucket;
        }
        if ((i2 & 2) != 0) {
            list = guildExperimentBucketDto.positions;
        }
        return guildExperimentBucketDto.copy(i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    public final List<Ranges2> component2() {
        return this.positions;
    }

    public final GuildExperimentBucketDto copy(int bucket, List<Ranges2> positions) {
        Intrinsics3.checkNotNullParameter(positions, "positions");
        return new GuildExperimentBucketDto(bucket, positions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentBucketDto)) {
            return false;
        }
        GuildExperimentBucketDto guildExperimentBucketDto = (GuildExperimentBucketDto) other;
        return this.bucket == guildExperimentBucketDto.bucket && Intrinsics3.areEqual(this.positions, guildExperimentBucketDto.positions);
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final List<Ranges2> getPositions() {
        return this.positions;
    }

    public int hashCode() {
        int i = this.bucket * 31;
        List<Ranges2> list = this.positions;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildExperimentBucketDto(bucket=");
        sbU.append(this.bucket);
        sbU.append(", positions=");
        return outline.L(sbU, this.positions, ")");
    }
}
