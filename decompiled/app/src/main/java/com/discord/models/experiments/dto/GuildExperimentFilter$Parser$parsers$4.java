package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildExperimentFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/Model$JsonReader;", "p1", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHasFeatureFilter;", "invoke", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHasFeatureFilter;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class GuildExperimentFilter$Parser$parsers$4 extends FunctionReferenceImpl implements Function1<Model.JsonReader, GuildExperimentFilter.GuildHasFeatureFilter> {
    public GuildExperimentFilter$Parser$parsers$4(GuildExperimentFilter.Parser parser) {
        super(1, parser, GuildExperimentFilter.Parser.class, "parseGuildHasFeatureFilter", "parseGuildHasFeatureFilter(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHasFeatureFilter;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GuildExperimentFilter.GuildHasFeatureFilter invoke(Model.JsonReader jsonReader) {
        return invoke2(jsonReader);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildExperimentFilter.GuildHasFeatureFilter invoke2(Model.JsonReader jsonReader) {
        Intrinsics3.checkNotNullParameter(jsonReader, "p1");
        return GuildExperimentFilter.Parser.access$parseGuildHasFeatureFilter((GuildExperimentFilter.Parser) this.receiver, jsonReader);
    }
}
