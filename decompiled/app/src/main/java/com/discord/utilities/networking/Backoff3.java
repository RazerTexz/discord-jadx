package com.discord.utilities.networking;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Backoff.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.networking.Backoff$sam$java_lang_Runnable$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class Backoff3 implements Runnable {
    private final /* synthetic */ Function0 function;

    public Backoff3(Function0 function0) {
        this.function = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
