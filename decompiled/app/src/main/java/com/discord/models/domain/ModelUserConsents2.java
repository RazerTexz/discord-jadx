package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.restapi.RestAPIParams;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelUserConsents.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/models/domain/Consents;", "", "Lcom/discord/models/domain/Consent;", "component1", "()Lcom/discord/models/domain/Consent;", "component2", "usageStatistics", RestAPIParams.Consents.Type.PERSONALIZATION, "copy", "(Lcom/discord/models/domain/Consent;Lcom/discord/models/domain/Consent;)Lcom/discord/models/domain/Consents;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/Consent;", "getUsageStatistics", "getPersonalization", "<init>", "(Lcom/discord/models/domain/Consent;Lcom/discord/models/domain/Consent;)V", "Companion", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.domain.Consents, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelUserConsents2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ModelUserConsents2 DEFAULT = new ModelUserConsents2(new ModelUserConsents(false, null, 3, null), new ModelUserConsents(false, null, 3, null));
    private final ModelUserConsents personalization;
    private final ModelUserConsents usageStatistics;

    /* compiled from: ModelUserConsents.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/domain/Consents$Companion;", "", "Lcom/discord/models/domain/Consents;", "DEFAULT", "Lcom/discord/models/domain/Consents;", "getDEFAULT", "()Lcom/discord/models/domain/Consents;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.models.domain.Consents$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ModelUserConsents2 getDEFAULT() {
            return ModelUserConsents2.access$getDEFAULT$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelUserConsents2(ModelUserConsents modelUserConsents, ModelUserConsents modelUserConsents2) {
        Intrinsics3.checkNotNullParameter(modelUserConsents, "usageStatistics");
        Intrinsics3.checkNotNullParameter(modelUserConsents2, RestAPIParams.Consents.Type.PERSONALIZATION);
        this.usageStatistics = modelUserConsents;
        this.personalization = modelUserConsents2;
    }

    public static final /* synthetic */ ModelUserConsents2 access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public static /* synthetic */ ModelUserConsents2 copy$default(ModelUserConsents2 modelUserConsents2, ModelUserConsents modelUserConsents, ModelUserConsents modelUserConsents3, int i, Object obj) {
        if ((i & 1) != 0) {
            modelUserConsents = modelUserConsents2.usageStatistics;
        }
        if ((i & 2) != 0) {
            modelUserConsents3 = modelUserConsents2.personalization;
        }
        return modelUserConsents2.copy(modelUserConsents, modelUserConsents3);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelUserConsents getUsageStatistics() {
        return this.usageStatistics;
    }

    /* renamed from: component2, reason: from getter */
    public final ModelUserConsents getPersonalization() {
        return this.personalization;
    }

    public final ModelUserConsents2 copy(ModelUserConsents usageStatistics, ModelUserConsents personalization) {
        Intrinsics3.checkNotNullParameter(usageStatistics, "usageStatistics");
        Intrinsics3.checkNotNullParameter(personalization, RestAPIParams.Consents.Type.PERSONALIZATION);
        return new ModelUserConsents2(usageStatistics, personalization);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserConsents2)) {
            return false;
        }
        ModelUserConsents2 modelUserConsents2 = (ModelUserConsents2) other;
        return Intrinsics3.areEqual(this.usageStatistics, modelUserConsents2.usageStatistics) && Intrinsics3.areEqual(this.personalization, modelUserConsents2.personalization);
    }

    public final ModelUserConsents getPersonalization() {
        return this.personalization;
    }

    public final ModelUserConsents getUsageStatistics() {
        return this.usageStatistics;
    }

    public int hashCode() {
        ModelUserConsents modelUserConsents = this.usageStatistics;
        int iHashCode = (modelUserConsents != null ? modelUserConsents.hashCode() : 0) * 31;
        ModelUserConsents modelUserConsents2 = this.personalization;
        return iHashCode + (modelUserConsents2 != null ? modelUserConsents2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Consents(usageStatistics=");
        sbU.append(this.usageStatistics);
        sbU.append(", personalization=");
        sbU.append(this.personalization);
        sbU.append(")");
        return sbU.toString();
    }
}
