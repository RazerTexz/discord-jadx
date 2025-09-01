package androidx.activity.result;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ActivityResultCaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00018\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"I", "O", "kotlin.jvm.PlatformType", "it", "", "onActivityResult", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* renamed from: androidx.activity.result.ActivityResultCallerKt$registerForActivityResult$resultLauncher$2, reason: use source file name */
/* loaded from: classes.dex */
public final class ActivityResultCaller4<O> implements ActivityResultCallback<O> {
    public final /* synthetic */ Function1 $callback;

    public ActivityResultCaller4(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(O o) {
        this.$callback.invoke(o);
    }
}
