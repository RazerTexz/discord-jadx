package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.models.domain.ModelMemberVerificationForm;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ModelMemberVerificationFormResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\u0013\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJJ\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0004R!\u0010\u0013\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\u000fR!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u000b¨\u0006("}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationFormResponse;", "", "", "component1", "()Ljava/lang/String;", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "component2", "()Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "", "Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "component3", "()Ljava/util/List;", "", "Lcom/discord/primitives/GuildId;", "component4", "()Ljava/lang/Long;", "lastSeen", "applicationStatus", "formResponses", "guildId", "copy", "(Ljava/lang/String;Lcom/discord/api/guildjoinrequest/ApplicationStatus;Ljava/util/List;Ljava/lang/Long;)Lcom/discord/models/domain/ModelMemberVerificationFormResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "getApplicationStatus", "Ljava/lang/String;", "getLastSeen", "Ljava/lang/Long;", "getGuildId", "Ljava/util/List;", "getFormResponses", "<init>", "(Ljava/lang/String;Lcom/discord/api/guildjoinrequest/ApplicationStatus;Ljava/util/List;Ljava/lang/Long;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelMemberVerificationFormResponse {
    private final ApplicationStatus applicationStatus;
    private final List<ModelMemberVerificationForm.FormField> formResponses;
    private final Long guildId;
    private final String lastSeen;

    public ModelMemberVerificationFormResponse(String str, ApplicationStatus applicationStatus, List<ModelMemberVerificationForm.FormField> list, Long l) {
        Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
        this.lastSeen = str;
        this.applicationStatus = applicationStatus;
        this.formResponses = list;
        this.guildId = l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelMemberVerificationFormResponse copy$default(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse, String str, ApplicationStatus applicationStatus, List list, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelMemberVerificationFormResponse.lastSeen;
        }
        if ((i & 2) != 0) {
            applicationStatus = modelMemberVerificationFormResponse.applicationStatus;
        }
        if ((i & 4) != 0) {
            list = modelMemberVerificationFormResponse.formResponses;
        }
        if ((i & 8) != 0) {
            l = modelMemberVerificationFormResponse.guildId;
        }
        return modelMemberVerificationFormResponse.copy(str, applicationStatus, list, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLastSeen() {
        return this.lastSeen;
    }

    /* renamed from: component2, reason: from getter */
    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    public final List<ModelMemberVerificationForm.FormField> component3() {
        return this.formResponses;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final ModelMemberVerificationFormResponse copy(String lastSeen, ApplicationStatus applicationStatus, List<ModelMemberVerificationForm.FormField> formResponses, Long guildId) {
        Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
        return new ModelMemberVerificationFormResponse(lastSeen, applicationStatus, formResponses, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelMemberVerificationFormResponse)) {
            return false;
        }
        ModelMemberVerificationFormResponse modelMemberVerificationFormResponse = (ModelMemberVerificationFormResponse) other;
        return Intrinsics3.areEqual(this.lastSeen, modelMemberVerificationFormResponse.lastSeen) && Intrinsics3.areEqual(this.applicationStatus, modelMemberVerificationFormResponse.applicationStatus) && Intrinsics3.areEqual(this.formResponses, modelMemberVerificationFormResponse.formResponses) && Intrinsics3.areEqual(this.guildId, modelMemberVerificationFormResponse.guildId);
    }

    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    public final List<ModelMemberVerificationForm.FormField> getFormResponses() {
        return this.formResponses;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final String getLastSeen() {
        return this.lastSeen;
    }

    public int hashCode() {
        String str = this.lastSeen;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ApplicationStatus applicationStatus = this.applicationStatus;
        int iHashCode2 = (iHashCode + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
        List<ModelMemberVerificationForm.FormField> list = this.formResponses;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Long l = this.guildId;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelMemberVerificationFormResponse(lastSeen=");
        sbU.append(this.lastSeen);
        sbU.append(", applicationStatus=");
        sbU.append(this.applicationStatus);
        sbU.append(", formResponses=");
        sbU.append(this.formResponses);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }
}
