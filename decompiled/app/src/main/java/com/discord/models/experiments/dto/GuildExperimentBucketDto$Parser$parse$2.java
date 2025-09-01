package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentBucketDto;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges2;

/* compiled from: GuildExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parse$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $positions;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: GuildExperimentDto.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/ranges/IntRange;", "kotlin.jvm.PlatformType", "get", "()Lkotlin/ranges/IntRange;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentBucketDto$Parser$parse$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<Ranges2> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Ranges2 get() {
            return get2();
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        /* renamed from: get, reason: avoid collision after fix types in other method */
        public final Ranges2 get2() {
            return GuildExperimentBucketDto.Parser.access$parsePosition(GuildExperimentBucketDto.Parser.INSTANCE, GuildExperimentBucketDto$Parser$parse$2.this.$reader);
        }
    }

    public GuildExperimentBucketDto$Parser$parse$2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$positions = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Ref$ObjectRef ref$ObjectRef = this.$positions;
        ?? NextList = this.$reader.nextList(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(NextList, "reader.nextList { parsePosition(reader) }");
        ref$ObjectRef.element = NextList;
    }
}
