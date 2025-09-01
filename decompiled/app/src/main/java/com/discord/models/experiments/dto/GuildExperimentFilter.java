package com.discord.models.experiments.dto;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildHubType;
import com.discord.models.domain.Model;
import com.discord.models.experiments.domain.ExperimentHash;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges3;

/* compiled from: GuildExperimentFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentFilter;", "", "<init>", "()V", "GuildHasFeatureFilter", "GuildHubTypesFeatureFilter", "GuildIdRangeFilter", "GuildIdsFilter", "GuildMemberCountRangeFilter", "Parser", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdsFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdRangeFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildMemberCountRangeFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHasFeatureFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHubTypesFeatureFilter;", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class GuildExperimentFilter {

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHasFeatureFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter;", "", "Lcom/discord/api/guild/GuildFeature;", "component1", "()Ljava/util/Set;", "features", "copy", "(Ljava/util/Set;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHasFeatureFilter;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getFeatures", "<init>", "(Ljava/util/Set;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildHasFeatureFilter extends GuildExperimentFilter {
        private final Set<GuildFeature> features;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildHasFeatureFilter(Set<? extends GuildFeature> set) {
            super(null);
            Intrinsics3.checkNotNullParameter(set, "features");
            this.features = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildHasFeatureFilter copy$default(GuildHasFeatureFilter guildHasFeatureFilter, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildHasFeatureFilter.features;
            }
            return guildHasFeatureFilter.copy(set);
        }

        public final Set<GuildFeature> component1() {
            return this.features;
        }

        public final GuildHasFeatureFilter copy(Set<? extends GuildFeature> features) {
            Intrinsics3.checkNotNullParameter(features, "features");
            return new GuildHasFeatureFilter(features);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildHasFeatureFilter) && Intrinsics3.areEqual(this.features, ((GuildHasFeatureFilter) other).features);
            }
            return true;
        }

        public final Set<GuildFeature> getFeatures() {
            return this.features;
        }

        public int hashCode() {
            Set<GuildFeature> set = this.features;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.N(outline.U("GuildHasFeatureFilter(features="), this.features, ")");
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHubTypesFeatureFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter;", "", "Lcom/discord/api/guild/GuildHubType;", "component1", "()Ljava/util/Set;", "hubTypes", "copy", "(Ljava/util/Set;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHubTypesFeatureFilter;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getHubTypes", "<init>", "(Ljava/util/Set;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildHubTypesFeatureFilter extends GuildExperimentFilter {
        private final Set<GuildHubType> hubTypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GuildHubTypesFeatureFilter(Set<? extends GuildHubType> set) {
            super(null);
            Intrinsics3.checkNotNullParameter(set, "hubTypes");
            this.hubTypes = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildHubTypesFeatureFilter copy$default(GuildHubTypesFeatureFilter guildHubTypesFeatureFilter, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildHubTypesFeatureFilter.hubTypes;
            }
            return guildHubTypesFeatureFilter.copy(set);
        }

        public final Set<GuildHubType> component1() {
            return this.hubTypes;
        }

        public final GuildHubTypesFeatureFilter copy(Set<? extends GuildHubType> hubTypes) {
            Intrinsics3.checkNotNullParameter(hubTypes, "hubTypes");
            return new GuildHubTypesFeatureFilter(hubTypes);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildHubTypesFeatureFilter) && Intrinsics3.areEqual(this.hubTypes, ((GuildHubTypesFeatureFilter) other).hubTypes);
            }
            return true;
        }

        public final Set<GuildHubType> getHubTypes() {
            return this.hubTypes;
        }

        public int hashCode() {
            Set<GuildHubType> set = this.hubTypes;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.N(outline.U("GuildHubTypesFeatureFilter(hubTypes="), this.hubTypes, ")");
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdRangeFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter;", "Lkotlin/ranges/LongRange;", "component1", "()Lkotlin/ranges/LongRange;", "range", "copy", "(Lkotlin/ranges/LongRange;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdRangeFilter;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/ranges/LongRange;", "getRange", "<init>", "(Lkotlin/ranges/LongRange;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildIdRangeFilter extends GuildExperimentFilter {
        private final Ranges3 range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildIdRangeFilter(Ranges3 ranges3) {
            super(null);
            Intrinsics3.checkNotNullParameter(ranges3, "range");
            this.range = ranges3;
        }

        public static /* synthetic */ GuildIdRangeFilter copy$default(GuildIdRangeFilter guildIdRangeFilter, Ranges3 ranges3, int i, Object obj) {
            if ((i & 1) != 0) {
                ranges3 = guildIdRangeFilter.range;
            }
            return guildIdRangeFilter.copy(ranges3);
        }

        /* renamed from: component1, reason: from getter */
        public final Ranges3 getRange() {
            return this.range;
        }

        public final GuildIdRangeFilter copy(Ranges3 range) {
            Intrinsics3.checkNotNullParameter(range, "range");
            return new GuildIdRangeFilter(range);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildIdRangeFilter) && Intrinsics3.areEqual(this.range, ((GuildIdRangeFilter) other).range);
            }
            return true;
        }

        public final Ranges3 getRange() {
            return this.range;
        }

        public int hashCode() {
            Ranges3 ranges3 = this.range;
            if (ranges3 != null) {
                return ranges3.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildIdRangeFilter(range=");
            sbU.append(this.range);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R#\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdsFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/util/Set;", "guildIds", "copy", "(Ljava/util/Set;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdsFilter;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getGuildIds", "<init>", "(Ljava/util/Set;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildIdsFilter extends GuildExperimentFilter {
        private final Set<Long> guildIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildIdsFilter(Set<Long> set) {
            super(null);
            Intrinsics3.checkNotNullParameter(set, "guildIds");
            this.guildIds = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildIdsFilter copy$default(GuildIdsFilter guildIdsFilter, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildIdsFilter.guildIds;
            }
            return guildIdsFilter.copy(set);
        }

        public final Set<Long> component1() {
            return this.guildIds;
        }

        public final GuildIdsFilter copy(Set<Long> guildIds) {
            Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
            return new GuildIdsFilter(guildIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildIdsFilter) && Intrinsics3.areEqual(this.guildIds, ((GuildIdsFilter) other).guildIds);
            }
            return true;
        }

        public final Set<Long> getGuildIds() {
            return this.guildIds;
        }

        public int hashCode() {
            Set<Long> set = this.guildIds;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.N(outline.U("GuildIdsFilter(guildIds="), this.guildIds, ")");
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildMemberCountRangeFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter;", "Lkotlin/ranges/LongRange;", "component1", "()Lkotlin/ranges/LongRange;", "range", "copy", "(Lkotlin/ranges/LongRange;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildMemberCountRangeFilter;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/ranges/LongRange;", "getRange", "<init>", "(Lkotlin/ranges/LongRange;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildMemberCountRangeFilter extends GuildExperimentFilter {
        private final Ranges3 range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildMemberCountRangeFilter(Ranges3 ranges3) {
            super(null);
            Intrinsics3.checkNotNullParameter(ranges3, "range");
            this.range = ranges3;
        }

        public static /* synthetic */ GuildMemberCountRangeFilter copy$default(GuildMemberCountRangeFilter guildMemberCountRangeFilter, Ranges3 ranges3, int i, Object obj) {
            if ((i & 1) != 0) {
                ranges3 = guildMemberCountRangeFilter.range;
            }
            return guildMemberCountRangeFilter.copy(ranges3);
        }

        /* renamed from: component1, reason: from getter */
        public final Ranges3 getRange() {
            return this.range;
        }

        public final GuildMemberCountRangeFilter copy(Ranges3 range) {
            Intrinsics3.checkNotNullParameter(range, "range");
            return new GuildMemberCountRangeFilter(range);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildMemberCountRangeFilter) && Intrinsics3.areEqual(this.range, ((GuildMemberCountRangeFilter) other).range);
            }
            return true;
        }

        public final Ranges3 getRange() {
            return this.range;
        }

        public int hashCode() {
            Ranges3 ranges3 = this.range;
            if (ranges3 != null) {
                return ranges3.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildMemberCountRangeFilter(range=");
            sbU.append(this.range);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildExperimentFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019R3\u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u001b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001c0\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006&"}, d2 = {"Lcom/discord/models/experiments/dto/GuildExperimentFilter$Parser;", "", "Lcom/discord/models/domain/Model$JsonReader;", "reader", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdsFilter;", "parseGuildIdsFilter", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdsFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdRangeFilter;", "parseGuildIdRangeFilter", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildIdRangeFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildMemberCountRangeFilter;", "parseGuildMemberCountRangeFilter", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildMemberCountRangeFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHasFeatureFilter;", "parseGuildHasFeatureFilter", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHasFeatureFilter;", "Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHubTypesFeatureFilter;", "parseGuildHubTypesFeatureFilter", "(Lcom/discord/models/domain/Model$JsonReader;)Lcom/discord/models/experiments/dto/GuildExperimentFilter$GuildHubTypesFeatureFilter;", "Lkotlin/ranges/LongRange;", "parseRange", "(Lcom/discord/models/domain/Model$JsonReader;)Lkotlin/ranges/LongRange;", "", "Lcom/discord/models/experiments/dto/GuildExperimentFilter;", "parseFilters", "(Lcom/discord/models/domain/Model$JsonReader;)Ljava/util/List;", "", "", "Lkotlin/Function1;", "parsers", "Ljava/util/Map;", "getParsers", "()Ljava/util/Map;", "MAX_ID_HASH", "J", "MIN_ID_HASH", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parser {
        public static final Parser INSTANCE;
        private static final long MAX_ID_HASH;
        private static final long MIN_ID_HASH;
        private static final Map<Long, Function1<Model.JsonReader, GuildExperimentFilter>> parsers;

        static {
            Parser parser = new Parser();
            INSTANCE = parser;
            ExperimentHash experimentHash = ExperimentHash.INSTANCE;
            parsers = Maps6.mapOf(Tuples.to(Long.valueOf(experimentHash.from("guild_ids")), new GuildExperimentFilter$Parser$parsers$1(parser)), Tuples.to(Long.valueOf(experimentHash.from("guild_id_range")), new GuildExperimentFilter$Parser$parsers$2(parser)), Tuples.to(Long.valueOf(experimentHash.from("guild_member_count_range")), new GuildExperimentFilter$Parser$parsers$3(parser)), Tuples.to(Long.valueOf(experimentHash.from("guild_has_feature")), new GuildExperimentFilter$Parser$parsers$4(parser)), Tuples.to(Long.valueOf(experimentHash.from("guild_hub_types")), new GuildExperimentFilter$Parser$parsers$5(parser)));
            MIN_ID_HASH = experimentHash.from("min_id");
            MAX_ID_HASH = experimentHash.from("max_id");
        }

        private Parser() {
        }

        public static final /* synthetic */ long access$getMAX_ID_HASH$p(Parser parser) {
            return MAX_ID_HASH;
        }

        public static final /* synthetic */ long access$getMIN_ID_HASH$p(Parser parser) {
            return MIN_ID_HASH;
        }

        public static final /* synthetic */ GuildHasFeatureFilter access$parseGuildHasFeatureFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildHasFeatureFilter(jsonReader);
        }

        public static final /* synthetic */ GuildHubTypesFeatureFilter access$parseGuildHubTypesFeatureFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildHubTypesFeatureFilter(jsonReader);
        }

        public static final /* synthetic */ GuildIdRangeFilter access$parseGuildIdRangeFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildIdRangeFilter(jsonReader);
        }

        public static final /* synthetic */ GuildIdsFilter access$parseGuildIdsFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildIdsFilter(jsonReader);
        }

        public static final /* synthetic */ GuildMemberCountRangeFilter access$parseGuildMemberCountRangeFilter(Parser parser, Model.JsonReader jsonReader) {
            return parser.parseGuildMemberCountRangeFilter(jsonReader);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
        private final GuildHasFeatureFilter parseGuildHasFeatureFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Sets5.emptySet();
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1(reader, ref$ObjectRef));
            return new GuildHasFeatureFilter((Set) ref$ObjectRef.element);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.Set] */
        private final GuildHubTypesFeatureFilter parseGuildHubTypesFeatureFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Sets5.emptySet();
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildHubTypesFeatureFilter$1(reader, ref$ObjectRef));
            return new GuildHubTypesFeatureFilter((Set) ref$ObjectRef.element);
        }

        private final GuildIdRangeFilter parseGuildIdRangeFilter(Model.JsonReader reader) {
            return new GuildIdRangeFilter(parseRange(reader));
        }

        private final GuildIdsFilter parseGuildIdsFilter(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            reader.nextListIndexed(new GuildExperimentFilter$Parser$parseGuildIdsFilter$1(reader, ref$ObjectRef));
            List list = (List) ref$ObjectRef.element;
            Intrinsics3.checkNotNull(list);
            return new GuildIdsFilter(_Collections.toSet(list));
        }

        private final GuildMemberCountRangeFilter parseGuildMemberCountRangeFilter(Model.JsonReader reader) {
            return new GuildMemberCountRangeFilter(parseRange(reader));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final Ranges3 parseRange(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextList(new GuildExperimentFilter$Parser$parseRange$1(reader, ref$ObjectRef, ref$ObjectRef2));
            Long l = (Long) ref$ObjectRef.element;
            long jLongValue = l != null ? l.longValue() : 0L;
            Long l2 = (Long) ref$ObjectRef2.element;
            return new Ranges3(jLongValue, l2 != null ? l2.longValue() : RecyclerView.FOREVER_NS);
        }

        public final Map<Long, Function1<Model.JsonReader, GuildExperimentFilter>> getParsers() {
            return parsers;
        }

        public final List<GuildExperimentFilter> parseFilters(Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            ArrayList arrayList = new ArrayList();
            reader.nextList(new GuildExperimentFilter$Parser$parseFilters$1(reader, arrayList));
            return arrayList;
        }
    }

    private GuildExperimentFilter() {
    }

    public /* synthetic */ GuildExperimentFilter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
