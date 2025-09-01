package com.discord.api.application;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: ProfileApplication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/discord/api/application/ApplicationInstallParams;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Ljava/lang/String;", "a", "", "scopes", "[Ljava/lang/String;", "b", "()[Ljava/lang/String;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.application.ApplicationInstallParams, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ProfileApplication2 {
    private final String permissions;
    private final String[] scopes;

    /* renamed from: a, reason: from getter */
    public final String getPermissions() {
        return this.permissions;
    }

    /* renamed from: b, reason: from getter */
    public final String[] getScopes() {
        return this.scopes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileApplication2)) {
            return false;
        }
        ProfileApplication2 profileApplication2 = (ProfileApplication2) other;
        return Intrinsics3.areEqual(this.permissions, profileApplication2.permissions) && Intrinsics3.areEqual(this.scopes, profileApplication2.scopes);
    }

    public int hashCode() {
        String str = this.permissions;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String[] strArr = this.scopes;
        return iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationInstallParams(permissions=");
        sbU.append(this.permissions);
        sbU.append(", scopes=");
        return outline.J(sbU, Arrays.toString(this.scopes), ")");
    }
}
