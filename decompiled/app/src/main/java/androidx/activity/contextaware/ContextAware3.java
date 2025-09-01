package androidx.activity.contextaware;

import android.content.Context;
import d0.Result2;
import d0.Result3;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: ContextAware.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"androidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$listener$1", "Landroidx/activity/contextaware/OnContextAvailableListener;", "Landroid/content/Context;", "context", "", "onContextAvailable", "(Landroid/content/Context;)V", "activity-ktx_release"}, k = 1, mv = {1, 4, 1})
/* renamed from: androidx.activity.contextaware.ContextAwareKt$withContextAvailable$$inlined$suspendCancellableCoroutine$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ContextAware3 implements OnContextAvailableListener {
    public final /* synthetic */ CancellableContinuation $co;
    public final /* synthetic */ Function1 $onContextAvailable$inlined;
    public final /* synthetic */ ContextAware $this_withContextAvailable$inlined;

    public ContextAware3(CancellableContinuation cancellableContinuation, ContextAware contextAware, Function1 function1) {
        this.$co = cancellableContinuation;
        this.$this_withContextAvailable$inlined = contextAware;
        this.$onContextAvailable$inlined = function1;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object objM97constructorimpl;
        Intrinsics3.checkNotNullParameter(context, "context");
        CancellableContinuation cancellableContinuation = this.$co;
        try {
            Result2.a aVar = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(this.$onContextAvailable$inlined.invoke(context));
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
        }
        cancellableContinuation.resumeWith(objM97constructorimpl);
    }
}
