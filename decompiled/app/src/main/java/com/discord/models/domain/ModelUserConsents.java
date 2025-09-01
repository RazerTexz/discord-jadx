package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelUserConsents.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/discord/models/domain/Consent;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "consented", "changedAt", "copy", "(ZLjava/lang/String;)Lcom/discord/models/domain/Consent;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getChangedAt", "Z", "getConsented", "<init>", "(ZLjava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.Consent, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelUserConsents {
    private final String changedAt;
    private final boolean consented;

    public ModelUserConsents() {
        this(false, null, 3, null);
    }

    public ModelUserConsents(boolean z2, String str) {
        this.consented = z2;
        this.changedAt = str;
    }

    public static /* synthetic */ ModelUserConsents copy$default(ModelUserConsents modelUserConsents, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = modelUserConsents.consented;
        }
        if ((i & 2) != 0) {
            str = modelUserConsents.changedAt;
        }
        return modelUserConsents.copy(z2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getConsented() {
        return this.consented;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChangedAt() {
        return this.changedAt;
    }

    public final ModelUserConsents copy(boolean consented, String changedAt) {
        return new ModelUserConsents(consented, changedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserConsents)) {
            return false;
        }
        ModelUserConsents modelUserConsents = (ModelUserConsents) other;
        return this.consented == modelUserConsents.consented && Intrinsics3.areEqual(this.changedAt, modelUserConsents.changedAt);
    }

    public final String getChangedAt() {
        return this.changedAt;
    }

    public final boolean getConsented() {
        return this.consented;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.consented;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.changedAt;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Consent(consented=");
        sbU.append(this.consented);
        sbU.append(", changedAt=");
        return outline.J(sbU, this.changedAt, ")");
    }

    public /* synthetic */ ModelUserConsents(boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : str);
    }
}
