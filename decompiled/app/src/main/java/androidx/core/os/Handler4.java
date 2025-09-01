package androidx.core.os;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Handler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
/* renamed from: androidx.core.os.HandlerKt$postDelayed$runnable$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Handler4 implements Runnable {
    public final /* synthetic */ Function0<Unit> $action;

    public Handler4(Function0<Unit> function0) {
        this.$action = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
