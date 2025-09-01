package b.a.d;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: AppTransformers.kt */
/* loaded from: classes.dex */
public final class y<T, R> implements Observable.c<T, T> {
    public final /* synthetic */ Context j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Function1 l;
    public final /* synthetic */ Function1 m;
    public final /* synthetic */ Function1 n;
    public final /* synthetic */ Function0 o;

    public y(Context context, String str, Function1 function1, Function1 function12, Function1 function13, Function0 function0) {
        this.j = context;
        this.k = str;
        this.l = function1;
        this.m = function12;
        this.n = function13;
        this.o = function0;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Observable observable = (Observable) obj;
        Intrinsics3.checkNotNullExpressionValue(observable, "observable");
        Context context = this.j;
        String str = this.k;
        Function1 function1 = this.l;
        Function1 function12 = this.m;
        Function1 function13 = this.n;
        Function0 function0 = this.o;
        if (function0 == null) {
            function0 = x.j;
        }
        ObservableExtensionsKt.appSubscribe$default(observable, context, str, function1, function12, function13, function0, (Function0) null, 64, (Object) null);
        return null;
    }
}
