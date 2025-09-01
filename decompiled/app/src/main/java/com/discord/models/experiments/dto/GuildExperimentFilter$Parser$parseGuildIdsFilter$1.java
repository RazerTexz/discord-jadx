package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildIdsFilter$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $guildIds;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildIdsFilter$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            GuildExperimentFilter$Parser$parseGuildIdsFilter$1.this.$reader.skipValue();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {

        /* compiled from: GuildExperimentFilter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildIdsFilter$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<Long> {
            public AnonymousClass1() {
            }

            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public /* bridge */ /* synthetic */ Long get() {
                return get();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
            public final Long get() {
                return GuildExperimentFilter$Parser$parseGuildIdsFilter$1.this.$reader.nextLongOrNull();
            }
        }

        public AnonymousClass2() {
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List] */
        @Override // java.lang.Runnable
        public final void run() {
            GuildExperimentFilter$Parser$parseGuildIdsFilter$1 guildExperimentFilter$Parser$parseGuildIdsFilter$1 = GuildExperimentFilter$Parser$parseGuildIdsFilter$1.this;
            guildExperimentFilter$Parser$parseGuildIdsFilter$1.$guildIds.element = guildExperimentFilter$Parser$parseGuildIdsFilter$1.$reader.nextList(new AnonymousClass1());
        }
    }

    public GuildExperimentFilter$Parser$parseGuildIdsFilter$1(Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$reader = jsonReader;
        this.$guildIds = ref$ObjectRef;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.$reader.nextListIndexed(new AnonymousClass1(), new AnonymousClass2());
    }
}
