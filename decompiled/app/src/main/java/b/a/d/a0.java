package b.a.d;

import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: AppTransformers.kt */
/* loaded from: classes.dex */
public final class a0<T, R> implements Observable.c<T, R> {
    public final /* synthetic */ Function1 j;
    public final /* synthetic */ Function1 k;
    public final /* synthetic */ Function1 l;

    public a0(Function1 function1, Function1 function12, Function1 function13) {
        this.j = function1;
        this.k = function12;
        this.l = function13;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        return ((Observable) obj).Y(new z(this));
    }
}
