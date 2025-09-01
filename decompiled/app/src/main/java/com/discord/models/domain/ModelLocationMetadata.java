package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ModelLocationMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/discord/models/domain/ModelLocationMetadata;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "consentRequired", "countryCode", "copy", "(ZLjava/lang/String;)Lcom/discord/models/domain/ModelLocationMetadata;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getConsentRequired", "Ljava/lang/String;", "getCountryCode", "<init>", "(ZLjava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelLocationMetadata {
    private final boolean consentRequired;
    private final String countryCode;

    public ModelLocationMetadata(boolean z2, String str) {
        this.consentRequired = z2;
        this.countryCode = str;
    }

    public static /* synthetic */ ModelLocationMetadata copy$default(ModelLocationMetadata modelLocationMetadata, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = modelLocationMetadata.consentRequired;
        }
        if ((i & 2) != 0) {
            str = modelLocationMetadata.countryCode;
        }
        return modelLocationMetadata.copy(z2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getConsentRequired() {
        return this.consentRequired;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    public final ModelLocationMetadata copy(boolean consentRequired, String countryCode) {
        return new ModelLocationMetadata(consentRequired, countryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLocationMetadata)) {
            return false;
        }
        ModelLocationMetadata modelLocationMetadata = (ModelLocationMetadata) other;
        return this.consentRequired == modelLocationMetadata.consentRequired && Intrinsics3.areEqual(this.countryCode, modelLocationMetadata.countryCode);
    }

    public final boolean getConsentRequired() {
        return this.consentRequired;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.consentRequired;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.countryCode;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelLocationMetadata(consentRequired=");
        sbU.append(this.consentRequired);
        sbU.append(", countryCode=");
        return outline.J(sbU, this.countryCode, ")");
    }
}
