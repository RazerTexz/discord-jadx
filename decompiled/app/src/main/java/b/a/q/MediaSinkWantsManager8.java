package b.a.q;

import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;

/* compiled from: MediaSinkWantsManager.kt */
/* renamed from: b.a.q.m, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaSinkWantsManager8 implements Runnable {
    public final /* synthetic */ Function0 j;

    public MediaSinkWantsManager8(Function0 function0) {
        this.j = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        Intrinsics3.checkNotNullExpressionValue(this.j.invoke(), "invoke(...)");
    }
}
