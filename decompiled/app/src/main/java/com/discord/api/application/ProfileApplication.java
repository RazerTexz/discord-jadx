package com.discord.api.application;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ProfileApplication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/discord/api/application/ProfileApplication;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "customInstallUrl", "Ljava/lang/String;", "a", ModelAuditLogEntry.CHANGE_KEY_ID, "b", "Lcom/discord/api/application/ApplicationInstallParams;", "installParams", "Lcom/discord/api/application/ApplicationInstallParams;", "c", "()Lcom/discord/api/application/ApplicationInstallParams;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ProfileApplication {
    private final String customInstallUrl;
    private final String id;
    private final ProfileApplication2 installParams;

    /* renamed from: a, reason: from getter */
    public final String getCustomInstallUrl() {
        return this.customInstallUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final ProfileApplication2 getInstallParams() {
        return this.installParams;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileApplication)) {
            return false;
        }
        ProfileApplication profileApplication = (ProfileApplication) other;
        return Intrinsics3.areEqual(this.id, profileApplication.id) && Intrinsics3.areEqual(this.customInstallUrl, profileApplication.customInstallUrl) && Intrinsics3.areEqual(this.installParams, profileApplication.installParams);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.customInstallUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ProfileApplication2 profileApplication2 = this.installParams;
        return iHashCode2 + (profileApplication2 != null ? profileApplication2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ProfileApplication(id=");
        sbU.append(this.id);
        sbU.append(", customInstallUrl=");
        sbU.append(this.customInstallUrl);
        sbU.append(", installParams=");
        sbU.append(this.installParams);
        sbU.append(")");
        return sbU.toString();
    }
}
