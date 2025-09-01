package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentBucketDto;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentPopulationDto$Parser$parse$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $buckets;
    public final /* synthetic */ Model.JsonReader $jsonReader;

    /* compiled from: GuildExperimentDto.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentBucketDto;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/models/experiments/dto/GuildExperimentBucketDto;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentPopulationDto$Parser$parse$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<GuildExperimentBucketDto> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ GuildExperimentBucketDto get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final GuildExperimentBucketDto get() {
            return GuildExperimentBucketDto.Parser.INSTANCE.parse(GuildExperimentPopulationDto$Parser$parse$1.this.$jsonReader);
        }
    }

    public GuildExperimentPopulationDto$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$buckets = ref$ObjectRef;
        this.$jsonReader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$buckets.element = this.$jsonReader.nextList(new AnonymousClass1());
    }
}
