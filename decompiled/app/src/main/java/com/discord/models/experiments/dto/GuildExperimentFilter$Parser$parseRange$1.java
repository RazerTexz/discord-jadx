package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "get", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseRange$1<T> implements Model.JsonReader.ItemFactory<Unit> {
    public final /* synthetic */ Ref$ObjectRef $end;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $start;

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseRange$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Ref$ObjectRef $fieldHash;

        public AnonymousClass1(Ref$ObjectRef ref$ObjectRef) {
            this.$fieldHash = ref$ObjectRef;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$fieldHash.element = (T) GuildExperimentFilter$Parser$parseRange$1.this.$reader.nextLongOrNull();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseRange$1$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Ref$ObjectRef $fieldHash;

        public AnonymousClass2(Ref$ObjectRef ref$ObjectRef) {
            this.$fieldHash = ref$ObjectRef;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Long l = (Long) this.$fieldHash.element;
            GuildExperimentFilter.Parser parser = GuildExperimentFilter.Parser.INSTANCE;
            long jAccess$getMIN_ID_HASH$p = GuildExperimentFilter.Parser.access$getMIN_ID_HASH$p(parser);
            if (l != null && l.longValue() == jAccess$getMIN_ID_HASH$p) {
                GuildExperimentFilter$Parser$parseRange$1 guildExperimentFilter$Parser$parseRange$1 = GuildExperimentFilter$Parser$parseRange$1.this;
                guildExperimentFilter$Parser$parseRange$1.$start.element = (T) guildExperimentFilter$Parser$parseRange$1.$reader.nextLongOrNull();
            } else {
                Long l2 = (Long) this.$fieldHash.element;
                long jAccess$getMAX_ID_HASH$p = GuildExperimentFilter.Parser.access$getMAX_ID_HASH$p(parser);
                if (l2 != null && l2.longValue() == jAccess$getMAX_ID_HASH$p) {
                    GuildExperimentFilter$Parser$parseRange$1 guildExperimentFilter$Parser$parseRange$12 = GuildExperimentFilter$Parser$parseRange$1.this;
                    guildExperimentFilter$Parser$parseRange$12.$end.element = (T) guildExperimentFilter$Parser$parseRange$12.$reader.nextLongOrNull();
                }
            }
            this.$fieldHash.element = null;
        }
    }

    public GuildExperimentFilter$Parser$parseRange$1(Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
        this.$reader = jsonReader;
        this.$start = ref$ObjectRef;
        this.$end = ref$ObjectRef2;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public /* bridge */ /* synthetic */ Unit get() throws IOException {
        get2();
        return Unit.a;
    }

    /* renamed from: get, reason: avoid collision after fix types in other method */
    public final void get2() throws IOException {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        this.$reader.nextListIndexed(new AnonymousClass1(ref$ObjectRef), new AnonymousClass2(ref$ObjectRef));
    }
}
