package androidx.core.os;

import android.os.Handler;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Handler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a;\u0010\f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Landroid/os/Handler;", "", "delayInMillis", "", "token", "Lkotlin/Function0;", "", "action", "Ljava/lang/Runnable;", "postDelayed", "(Landroid/os/Handler;JLjava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Runnable;", "uptimeMillis", "postAtTime", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.os.HandlerKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Handler2 {
    public static final Runnable postAtTime(Handler handler, long j, Object obj, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(handler, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        Handler3 handler3 = new Handler3(function0);
        handler.postAtTime(handler3, obj, j);
        return handler3;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long j, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics3.checkNotNullParameter(handler, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        Handler3 handler3 = new Handler3(function0);
        handler.postAtTime(handler3, obj, j);
        return handler3;
    }

    public static final Runnable postDelayed(Handler handler, long j, Object obj, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(handler, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        Handler4 handler4 = new Handler4(function0);
        if (obj == null) {
            handler.postDelayed(handler4, j);
        } else {
            HandlerCompat.postDelayed(handler, handler4, obj, j);
        }
        return handler4;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long j, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics3.checkNotNullParameter(handler, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        Handler4 handler4 = new Handler4(function0);
        if (obj == null) {
            handler.postDelayed(handler4, j);
        } else {
            HandlerCompat.postDelayed(handler, handler4, obj, j);
        }
        return handler4;
    }
}
