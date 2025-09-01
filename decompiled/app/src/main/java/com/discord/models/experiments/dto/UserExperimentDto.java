package com.discord.models.experiments.dto;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import b.i.d.TypeAdapterFactory2;
import com.discord.models.domain.Model;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: UserExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0002 !B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001d\u0010\u0007¨\u0006\""}, d2 = {"Lcom/discord/models/experiments/dto/UserExperimentDto;", "", "", "component1", "()J", "", "component2", "()I", "component3", "component4", "nameHash", "revision", "bucket", "population", "copy", "(JIII)Lcom/discord/models/experiments/dto/UserExperimentDto;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getNameHash", "I", "getBucket", "getRevision", "getPopulation", "<init>", "(JIII)V", "Parser", "TypeAdapterFactory", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class UserExperimentDto {
    private final int bucket;
    private final long nameHash;
    private final int population;
    private final int revision;

    /* compiled from: UserExperimentDto.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/experiments/dto/UserExperimentDto$Parser;", "", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "Lcom/discord/models/experiments/dto/UserExperimentDto;", "parse", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/UserExperimentDto;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final UserExperimentDto parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextListIndexed(new UserExperimentDto2(ref$ObjectRefC0, reader), new UserExperimentDto3(ref$ObjectRef, reader), new UserExperimentDto4(ref$ObjectRef2, reader), new UserExperimentDto5(ref$ObjectRef3, reader));
            Long l = (Long) ref$ObjectRefC0.element;
            Intrinsics3.checkNotNull(l);
            long jLongValue = l.longValue();
            Integer num = (Integer) ref$ObjectRef.element;
            Intrinsics3.checkNotNull(num);
            int iIntValue = num.intValue();
            Integer num2 = (Integer) ref$ObjectRef2.element;
            Intrinsics3.checkNotNull(num2);
            int iIntValue2 = num2.intValue();
            Integer num3 = (Integer) ref$ObjectRef3.element;
            Intrinsics3.checkNotNull(num3);
            return new UserExperimentDto(jLongValue, iIntValue, iIntValue2, num3.intValue());
        }
    }

    /* compiled from: UserExperimentDto.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/models/experiments/dto/UserExperimentDto$TypeAdapterFactory;", "Lb/i/d/o;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/reflect/TypeToken;", "type", "Lcom/google/gson/TypeAdapter;", "create", "(Lcom/google/gson/Gson;Lcom/google/gson/reflect/TypeToken;)Lcom/google/gson/TypeAdapter;", "<init>", "()V", "TypeAdapter", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class TypeAdapterFactory implements TypeAdapterFactory2 {
        public static final TypeAdapterFactory INSTANCE = new TypeAdapterFactory();

        /* compiled from: UserExperimentDto.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/models/experiments/dto/UserExperimentDto$TypeAdapterFactory$TypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/models/experiments/dto/UserExperimentDto;", "Lcom/google/gson/stream/JsonWriter;", "out", "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/discord/models/experiments/dto/UserExperimentDto;)V", "Lcom/google/gson/stream/JsonReader;", "in", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/discord/models/experiments/dto/UserExperimentDto;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
        public static final class TypeAdapter extends com.google.gson.TypeAdapter<UserExperimentDto> {
            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ UserExperimentDto read(JsonReader jsonReader) {
                return read(jsonReader);
            }

            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, UserExperimentDto userExperimentDto) {
                write2(jsonWriter, userExperimentDto);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public UserExperimentDto read(JsonReader in) {
                return Parser.parse(new Model.JsonReader(in));
            }

            /* renamed from: write, reason: avoid collision after fix types in other method */
            public void write2(JsonWriter out, UserExperimentDto value) {
                throw new UnsupportedOperationException();
            }
        }

        private TypeAdapterFactory() {
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> com.google.gson.TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (gson == null || type == null || !UserExperimentDto.class.isAssignableFrom(type.getRawType())) {
                return null;
            }
            return new TypeAdapter();
        }
    }

    public UserExperimentDto(long j, int i, int i2, int i3) {
        this.nameHash = j;
        this.revision = i;
        this.bucket = i2;
        this.population = i3;
    }

    public static /* synthetic */ UserExperimentDto copy$default(UserExperimentDto userExperimentDto, long j, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = userExperimentDto.nameHash;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            i = userExperimentDto.revision;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = userExperimentDto.bucket;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = userExperimentDto.population;
        }
        return userExperimentDto.copy(j2, i5, i6, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getNameHash() {
        return this.nameHash;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPopulation() {
        return this.population;
    }

    public final UserExperimentDto copy(long nameHash, int revision, int bucket, int population) {
        return new UserExperimentDto(nameHash, revision, bucket, population);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserExperimentDto)) {
            return false;
        }
        UserExperimentDto userExperimentDto = (UserExperimentDto) other;
        return this.nameHash == userExperimentDto.nameHash && this.revision == userExperimentDto.revision && this.bucket == userExperimentDto.bucket && this.population == userExperimentDto.population;
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final long getNameHash() {
        return this.nameHash;
    }

    public final int getPopulation() {
        return this.population;
    }

    public final int getRevision() {
        return this.revision;
    }

    public int hashCode() {
        long j = this.nameHash;
        return (((((((int) (j ^ (j >>> 32))) * 31) + this.revision) * 31) + this.bucket) * 31) + this.population;
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserExperimentDto(nameHash=");
        sbU.append(this.nameHash);
        sbU.append(", revision=");
        sbU.append(this.revision);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", population=");
        return outline.B(sbU, this.population, ")");
    }
}
