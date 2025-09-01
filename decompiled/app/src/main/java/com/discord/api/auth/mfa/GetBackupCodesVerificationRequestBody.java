package com.discord.api.auth.mfa;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GetBackupCodesVerificationRequestBody.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/api/auth/mfa/GetBackupCodesVerificationRequestBody;", "", "", "key", "Ljava/lang/String;", "", "regenerate", "Z", "nonce", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class GetBackupCodesVerificationRequestBody {
    private final String key;
    private final String nonce;
    private final boolean regenerate;

    public GetBackupCodesVerificationRequestBody(String str, String str2, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(str2, "nonce");
        this.key = str;
        this.nonce = str2;
        this.regenerate = z2;
    }
}
