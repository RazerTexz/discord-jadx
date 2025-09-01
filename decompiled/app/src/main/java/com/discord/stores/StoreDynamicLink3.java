package com.discord.stores;

import androidx.annotation.RecentlyNonNull;
import b.i.a.f.n.d;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreDynamicLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreDynamicLink3 implements d {
    private final /* synthetic */ Function1 function;

    public StoreDynamicLink3(Function1 function1) {
        this.function = function1;
    }

    @Override // b.i.a.f.n.d
    public final /* synthetic */ void onFailure(@RecentlyNonNull Exception exc) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(exc), "invoke(...)");
    }
}
