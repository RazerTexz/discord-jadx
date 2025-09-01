package com.discord.models.experiments.dto;

import com.discord.api.guild.GuildFeature;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $features;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.this.$reader.skipValue();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {

        /* compiled from: GuildExperimentFilter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/api/guild/GuildFeature;", "kotlin.jvm.PlatformType", "get", "()Lcom/discord/api/guild/GuildFeature;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<GuildFeature> {
            public AnonymousClass1() {
            }

            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public /* bridge */ /* synthetic */ GuildFeature get() {
                return get();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public final GuildFeature get() {
                return (GuildFeature) InboundGatewayGsonParser.fromJson(GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.this.$reader, GuildFeature.class);
            }
        }

        public AnonymousClass2() {
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.Set] */
        @Override // java.lang.Runnable
        public final void run() throws IOException {
            GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 = GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.this;
            Ref$ObjectRef ref$ObjectRef = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.$features;
            List listNextList = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.$reader.nextList(new AnonymousClass1());
            Intrinsics3.checkNotNullExpressionValue(listNextList, "reader.nextList {\n      …ass.java)\n              }");
            ref$ObjectRef.element = _Collections.toSet(listNextList);
        }
    }

    public GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1(Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$reader = jsonReader;
        this.$features = ref$ObjectRef;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.$reader.nextListIndexed(new AnonymousClass1(), new AnonymousClass2());
    }
}
