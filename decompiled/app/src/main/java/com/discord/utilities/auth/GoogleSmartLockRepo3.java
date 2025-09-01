package com.discord.utilities.auth;

import b.d.b.a.outline;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GoogleSmartLockRepo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/auth/SmartLockSignInAttempt;", "", "", "component1", "()Z", "component2", "usedAutomaticCredentials", "signedInWithoutError", "copy", "(ZZ)Lcom/discord/utilities/auth/SmartLockSignInAttempt;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSignedInWithoutError", "getUsedAutomaticCredentials", "<init>", "(ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.auth.SmartLockSignInAttempt, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class GoogleSmartLockRepo3 {
    private final boolean signedInWithoutError;
    private final boolean usedAutomaticCredentials;

    public GoogleSmartLockRepo3() {
        this(false, false, 3, null);
    }

    public GoogleSmartLockRepo3(boolean z2, boolean z3) {
        this.usedAutomaticCredentials = z2;
        this.signedInWithoutError = z3;
    }

    public static /* synthetic */ GoogleSmartLockRepo3 copy$default(GoogleSmartLockRepo3 googleSmartLockRepo3, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = googleSmartLockRepo3.usedAutomaticCredentials;
        }
        if ((i & 2) != 0) {
            z3 = googleSmartLockRepo3.signedInWithoutError;
        }
        return googleSmartLockRepo3.copy(z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getUsedAutomaticCredentials() {
        return this.usedAutomaticCredentials;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSignedInWithoutError() {
        return this.signedInWithoutError;
    }

    public final GoogleSmartLockRepo3 copy(boolean usedAutomaticCredentials, boolean signedInWithoutError) {
        return new GoogleSmartLockRepo3(usedAutomaticCredentials, signedInWithoutError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleSmartLockRepo3)) {
            return false;
        }
        GoogleSmartLockRepo3 googleSmartLockRepo3 = (GoogleSmartLockRepo3) other;
        return this.usedAutomaticCredentials == googleSmartLockRepo3.usedAutomaticCredentials && this.signedInWithoutError == googleSmartLockRepo3.signedInWithoutError;
    }

    public final boolean getSignedInWithoutError() {
        return this.signedInWithoutError;
    }

    public final boolean getUsedAutomaticCredentials() {
        return this.usedAutomaticCredentials;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.usedAutomaticCredentials;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.signedInWithoutError;
        return i + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("SmartLockSignInAttempt(usedAutomaticCredentials=");
        sbU.append(this.usedAutomaticCredentials);
        sbU.append(", signedInWithoutError=");
        return outline.O(sbU, this.signedInWithoutError, ")");
    }

    public /* synthetic */ GoogleSmartLockRepo3(boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? true : z3);
    }
}
