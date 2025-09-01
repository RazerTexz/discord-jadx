package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelUserAffinities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J0\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/discord/models/domain/ModelUserAffinities;", "", "", "Lcom/discord/models/domain/ModelUserAffinity;", "component1", "()Ljava/util/List;", "component2", "userAffinities", "inverseUserAffinities", "copy", "(Ljava/util/List;Ljava/util/List;)Lcom/discord/models/domain/ModelUserAffinities;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getUserAffinities", "getInverseUserAffinities", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelUserAffinities {
    private final List<ModelUserAffinity> inverseUserAffinities;
    private final List<ModelUserAffinity> userAffinities;

    public ModelUserAffinities(List<ModelUserAffinity> list, List<ModelUserAffinity> list2) {
        Intrinsics3.checkNotNullParameter(list, "userAffinities");
        Intrinsics3.checkNotNullParameter(list2, "inverseUserAffinities");
        this.userAffinities = list;
        this.inverseUserAffinities = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelUserAffinities copy$default(ModelUserAffinities modelUserAffinities, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelUserAffinities.userAffinities;
        }
        if ((i & 2) != 0) {
            list2 = modelUserAffinities.inverseUserAffinities;
        }
        return modelUserAffinities.copy(list, list2);
    }

    public final List<ModelUserAffinity> component1() {
        return this.userAffinities;
    }

    public final List<ModelUserAffinity> component2() {
        return this.inverseUserAffinities;
    }

    public final ModelUserAffinities copy(List<ModelUserAffinity> userAffinities, List<ModelUserAffinity> inverseUserAffinities) {
        Intrinsics3.checkNotNullParameter(userAffinities, "userAffinities");
        Intrinsics3.checkNotNullParameter(inverseUserAffinities, "inverseUserAffinities");
        return new ModelUserAffinities(userAffinities, inverseUserAffinities);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserAffinities)) {
            return false;
        }
        ModelUserAffinities modelUserAffinities = (ModelUserAffinities) other;
        return Intrinsics3.areEqual(this.userAffinities, modelUserAffinities.userAffinities) && Intrinsics3.areEqual(this.inverseUserAffinities, modelUserAffinities.inverseUserAffinities);
    }

    public final List<ModelUserAffinity> getInverseUserAffinities() {
        return this.inverseUserAffinities;
    }

    public final List<ModelUserAffinity> getUserAffinities() {
        return this.userAffinities;
    }

    public int hashCode() {
        List<ModelUserAffinity> list = this.userAffinities;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<ModelUserAffinity> list2 = this.inverseUserAffinities;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelUserAffinities(userAffinities=");
        sbU.append(this.userAffinities);
        sbU.append(", inverseUserAffinities=");
        return outline.L(sbU, this.inverseUserAffinities, ")");
    }
}
