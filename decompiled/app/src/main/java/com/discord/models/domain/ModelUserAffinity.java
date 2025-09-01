package com.discord.models.domain;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: ModelUserAffinity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/models/domain/ModelUserAffinity;", "", "", "component1", "()J", "", "component2", "()F", "userId", "affinity", "copy", "(JF)Lcom/discord/models/domain/ModelUserAffinity;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getUserId", "F", "getAffinity", "<init>", "(JF)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelUserAffinity {
    private final float affinity;
    private final long userId;

    public ModelUserAffinity(long j, float f) {
        this.userId = j;
        this.affinity = f;
    }

    public static /* synthetic */ ModelUserAffinity copy$default(ModelUserAffinity modelUserAffinity, long j, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelUserAffinity.userId;
        }
        if ((i & 2) != 0) {
            f = modelUserAffinity.affinity;
        }
        return modelUserAffinity.copy(j, f);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final float getAffinity() {
        return this.affinity;
    }

    public final ModelUserAffinity copy(long userId, float affinity) {
        return new ModelUserAffinity(userId, affinity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserAffinity)) {
            return false;
        }
        ModelUserAffinity modelUserAffinity = (ModelUserAffinity) other;
        return this.userId == modelUserAffinity.userId && Float.compare(this.affinity, modelUserAffinity.affinity) == 0;
    }

    public final float getAffinity() {
        return this.affinity;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long j = this.userId;
        return Float.floatToIntBits(this.affinity) + (((int) (j ^ (j >>> 32))) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelUserAffinity(userId=");
        sbU.append(this.userId);
        sbU.append(", affinity=");
        sbU.append(this.affinity);
        sbU.append(")");
        return sbU.toString();
    }
}
