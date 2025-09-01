package com.discord.models.experiments.dto;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: UnauthenticatedUserExperimentsDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/discord/models/experiments/dto/UnauthenticatedUserExperimentsDto;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/models/experiments/dto/UserExperimentDto;", "component2", "()Ljava/util/List;", "fingerprint", "assignments", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/discord/models/experiments/dto/UnauthenticatedUserExperimentsDto;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFingerprint", "Ljava/util/List;", "getAssignments", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class UnauthenticatedUserExperimentsDto {
    private final List<UserExperimentDto> assignments;
    private final String fingerprint;

    public UnauthenticatedUserExperimentsDto(String str, List<UserExperimentDto> list) {
        Intrinsics3.checkNotNullParameter(str, "fingerprint");
        Intrinsics3.checkNotNullParameter(list, "assignments");
        this.fingerprint = str;
        this.assignments = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UnauthenticatedUserExperimentsDto copy$default(UnauthenticatedUserExperimentsDto unauthenticatedUserExperimentsDto, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unauthenticatedUserExperimentsDto.fingerprint;
        }
        if ((i & 2) != 0) {
            list = unauthenticatedUserExperimentsDto.assignments;
        }
        return unauthenticatedUserExperimentsDto.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final List<UserExperimentDto> component2() {
        return this.assignments;
    }

    public final UnauthenticatedUserExperimentsDto copy(String fingerprint, List<UserExperimentDto> assignments) {
        Intrinsics3.checkNotNullParameter(fingerprint, "fingerprint");
        Intrinsics3.checkNotNullParameter(assignments, "assignments");
        return new UnauthenticatedUserExperimentsDto(fingerprint, assignments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnauthenticatedUserExperimentsDto)) {
            return false;
        }
        UnauthenticatedUserExperimentsDto unauthenticatedUserExperimentsDto = (UnauthenticatedUserExperimentsDto) other;
        return Intrinsics3.areEqual(this.fingerprint, unauthenticatedUserExperimentsDto.fingerprint) && Intrinsics3.areEqual(this.assignments, unauthenticatedUserExperimentsDto.assignments);
    }

    public final List<UserExperimentDto> getAssignments() {
        return this.assignments;
    }

    public final String getFingerprint() {
        return this.fingerprint;
    }

    public int hashCode() {
        String str = this.fingerprint;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<UserExperimentDto> list = this.assignments;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("UnauthenticatedUserExperimentsDto(fingerprint=");
        sbU.append(this.fingerprint);
        sbU.append(", assignments=");
        return outline.L(sbU, this.assignments, ")");
    }
}
