package com.discord.models.experiments.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Experiment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJH\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00072\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\rR\u0019\u0010\u0011\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b\u0011\u0010\t¨\u0006%"}, d2 = {"Lcom/discord/models/experiments/domain/Experiment;", "", "", "component1", "()I", "component2", "component3", "", "component4", "()Z", "Lkotlin/Function0;", "", "component5", "()Lkotlin/jvm/functions/Function0;", "revision", "bucket", "population", "isOverride", "trackExposure", "copy", "(IIIZLkotlin/jvm/functions/Function0;)Lcom/discord/models/experiments/domain/Experiment;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getBucket", "getPopulation", "getRevision", "Lkotlin/jvm/functions/Function0;", "getTrackExposure", "Z", "<init>", "(IIIZLkotlin/jvm/functions/Function0;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Experiment {
    private final int bucket;
    private final boolean isOverride;
    private final int population;
    private final int revision;
    private final Function0<Unit> trackExposure;

    public Experiment(int i, int i2, int i3, boolean z2, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "trackExposure");
        this.revision = i;
        this.bucket = i2;
        this.population = i3;
        this.isOverride = z2;
        this.trackExposure = function0;
    }

    public static /* synthetic */ Experiment copy$default(Experiment experiment, int i, int i2, int i3, boolean z2, Function0 function0, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = experiment.revision;
        }
        if ((i4 & 2) != 0) {
            i2 = experiment.bucket;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = experiment.population;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            z2 = experiment.isOverride;
        }
        boolean z3 = z2;
        if ((i4 & 16) != 0) {
            function0 = experiment.trackExposure;
        }
        return experiment.copy(i, i5, i6, z3, function0);
    }

    /* renamed from: component1, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPopulation() {
        return this.population;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsOverride() {
        return this.isOverride;
    }

    public final Function0<Unit> component5() {
        return this.trackExposure;
    }

    public final Experiment copy(int revision, int bucket, int population, boolean isOverride, Function0<Unit> trackExposure) {
        Intrinsics3.checkNotNullParameter(trackExposure, "trackExposure");
        return new Experiment(revision, bucket, population, isOverride, trackExposure);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Experiment)) {
            return false;
        }
        Experiment experiment = (Experiment) other;
        return this.revision == experiment.revision && this.bucket == experiment.bucket && this.population == experiment.population && this.isOverride == experiment.isOverride && Intrinsics3.areEqual(this.trackExposure, experiment.trackExposure);
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final int getPopulation() {
        return this.population;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final Function0<Unit> getTrackExposure() {
        return this.trackExposure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = ((((this.revision * 31) + this.bucket) * 31) + this.population) * 31;
        boolean z2 = this.isOverride;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        Function0<Unit> function0 = this.trackExposure;
        return i3 + (function0 != null ? function0.hashCode() : 0);
    }

    public final boolean isOverride() {
        return this.isOverride;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Experiment(revision=");
        sbU.append(this.revision);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", population=");
        sbU.append(this.population);
        sbU.append(", isOverride=");
        sbU.append(this.isOverride);
        sbU.append(", trackExposure=");
        sbU.append(this.trackExposure);
        sbU.append(")");
        return sbU.toString();
    }
}
