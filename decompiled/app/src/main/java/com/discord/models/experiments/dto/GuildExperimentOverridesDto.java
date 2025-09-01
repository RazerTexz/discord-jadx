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

/* compiled from: GuildExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u0012\b\u0002\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R#\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentOverridesDto;", "", "", "component1", "()I", "", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/util/List;", "bucket", "guilds", "copy", "(ILjava/util/List;)Lcom/discord/models/experiments/dto/GuildExperimentOverridesDto;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getBucket", "Ljava/util/List;", "getGuilds", "<init>", "(ILjava/util/List;)V", "Parser", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildExperimentOverridesDto {
    private final int bucket;
    private final List<Long> guilds;

    /* compiled from: GuildExperimentDto.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentOverridesDto$Parser;", "", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "Lcom/discord/models/experiments/dto/GuildExperimentOverridesDto;", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentOverridesDto;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
        public final GuildExperimentOverridesDto parse(Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Collections2.emptyList();
            reader.nextObject(new GuildExperimentOverridesDto$Parser$parse$1(ref$IntRef, reader, ref$ObjectRef));
            return new GuildExperimentOverridesDto(ref$IntRef.element, (List) ref$ObjectRef.element);
        }
    }

    public GuildExperimentOverridesDto(int i, List<Long> list) {
        Intrinsics3.checkNotNullParameter(list, "guilds");
        this.bucket = i;
        this.guilds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentOverridesDto copy$default(GuildExperimentOverridesDto guildExperimentOverridesDto, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildExperimentOverridesDto.bucket;
        }
        if ((i2 & 2) != 0) {
            list = guildExperimentOverridesDto.guilds;
        }
        return guildExperimentOverridesDto.copy(i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    public final List<Long> component2() {
        return this.guilds;
    }

    public final GuildExperimentOverridesDto copy(int bucket, List<Long> guilds) {
        Intrinsics3.checkNotNullParameter(guilds, "guilds");
        return new GuildExperimentOverridesDto(bucket, guilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentOverridesDto)) {
            return false;
        }
        GuildExperimentOverridesDto guildExperimentOverridesDto = (GuildExperimentOverridesDto) other;
        return this.bucket == guildExperimentOverridesDto.bucket && Intrinsics3.areEqual(this.guilds, guildExperimentOverridesDto.guilds);
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final List<Long> getGuilds() {
        return this.guilds;
    }

    public int hashCode() {
        int i = this.bucket * 31;
        List<Long> list = this.guilds;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildExperimentOverridesDto(bucket=");
        sbU.append(this.bucket);
        sbU.append(", guilds=");
        return outline.L(sbU, this.guilds, ")");
    }
}
