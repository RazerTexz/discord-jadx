package com.discord.samsung;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: SamsungConnect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/samsung/SamsungConnect$SamsungCallbackException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", "errorCode", "errorMsg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "samsung_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.samsung.SamsungConnect$SamsungCallbackException, reason: use source file name */
/* loaded from: classes.dex */
public final class SamsungConnect3 extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnect3(String str, String str2) {
        super('[' + str + "] " + str2);
        Intrinsics3.checkNotNullParameter(str, "errorCode");
    }
}
