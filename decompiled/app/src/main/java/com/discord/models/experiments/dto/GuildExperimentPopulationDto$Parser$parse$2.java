package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: GuildExperimentDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GuildExperimentPopulationDto$Parser$parse$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $filters;
    public final /* synthetic */ Model.JsonReader $jsonReader;

    public GuildExperimentPopulationDto$Parser$parse$2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$filters = ref$ObjectRef;
        this.$jsonReader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$filters.element = GuildExperimentFilter.Parser.INSTANCE.parseFilters(this.$jsonReader);
    }
}
