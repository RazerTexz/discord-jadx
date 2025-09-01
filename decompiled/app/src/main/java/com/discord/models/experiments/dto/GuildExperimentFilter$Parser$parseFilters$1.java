package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "get", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseFilters$1<T> implements Model.JsonReader.ItemFactory<Unit> {
    public final /* synthetic */ List $filters;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseFilters$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Ref$ObjectRef $filterHash;

        public AnonymousClass1(Ref$ObjectRef ref$ObjectRef) {
            this.$filterHash = ref$ObjectRef;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$filterHash.element = (T) GuildExperimentFilter$Parser$parseFilters$1.this.$reader.nextLongOrNull();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseFilters$1$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ Ref$ObjectRef $filterHash;

        public AnonymousClass2(Ref$ObjectRef ref$ObjectRef) {
            this.$filterHash = ref$ObjectRef;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GuildExperimentFilter guildExperimentFilterInvoke;
            Function1<Model.JsonReader, GuildExperimentFilter> function1 = GuildExperimentFilter.Parser.INSTANCE.getParsers().get((Long) this.$filterHash.element);
            if (function1 != null && (guildExperimentFilterInvoke = function1.invoke(GuildExperimentFilter$Parser$parseFilters$1.this.$reader)) != null) {
                GuildExperimentFilter$Parser$parseFilters$1.this.$filters.add(guildExperimentFilterInvoke);
            }
            this.$filterHash.element = null;
        }
    }

    public GuildExperimentFilter$Parser$parseFilters$1(Model.JsonReader jsonReader, List list) {
        this.$reader = jsonReader;
        this.$filters = list;
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
