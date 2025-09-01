package com.discord.api.auth.mfa;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: EnableMfaResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/api/auth/mfa/EnableMfaResponse;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "token", "Ljava/lang/String;", "a", "", "Lcom/discord/api/auth/mfa/BackupCode;", "backupCodes", "Ljava/util/List;", "getBackupCodes", "()Ljava/util/List;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class EnableMfaResponse {
    private final List<BackupCode> backupCodes;
    private final String token;

    /* renamed from: a, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnableMfaResponse)) {
            return false;
        }
        EnableMfaResponse enableMfaResponse = (EnableMfaResponse) other;
        return Intrinsics3.areEqual(this.token, enableMfaResponse.token) && Intrinsics3.areEqual(this.backupCodes, enableMfaResponse.backupCodes);
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<BackupCode> list = this.backupCodes;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EnableMfaResponse(token=");
        sbU.append(this.token);
        sbU.append(", backupCodes=");
        return outline.L(sbU, this.backupCodes, ")");
    }
}
