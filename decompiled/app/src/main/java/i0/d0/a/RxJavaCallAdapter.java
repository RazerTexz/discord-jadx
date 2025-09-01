package i0.d0.a;

import i0.Call3;
import i0.CallAdapter;
import j0.Completable2;
import j0.Completable3;
import j0.Single2;
import j0.l.a.OnSubscribeSingle2;
import j0.o.l;
import java.lang.reflect.Type;
import rx.Observable;
import rx.Scheduler;

/* compiled from: RxJavaCallAdapter.java */
/* renamed from: i0.d0.a.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    public final Type a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3736b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public RxJavaCallAdapter(Type type, Scheduler scheduler, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a = type;
        this.f3736b = z3;
        this.c = z4;
        this.d = z5;
        this.e = z6;
    }

    @Override // i0.CallAdapter
    public Type a() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    @Override // i0.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(Call3<R> call3) {
        Observable.a bodyOnSubscribe;
        Observable.a callExecuteOnSubscribe = new CallExecuteOnSubscribe(call3);
        if (!this.f3736b) {
            if (this.c) {
                bodyOnSubscribe = new BodyOnSubscribe(callExecuteOnSubscribe);
            }
            Observable observable = new Observable(l.a(callExecuteOnSubscribe));
            if (!this.d) {
                return new Single2(new OnSubscribeSingle2(observable));
            }
            if (!this.e) {
                return observable;
            }
            try {
                return new Completable3(new Completable2(observable));
            } catch (NullPointerException e) {
                throw e;
            } catch (Throwable th) {
                l.b(th);
                NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
                nullPointerException.initCause(th);
                throw nullPointerException;
            }
        }
        bodyOnSubscribe = new ResultOnSubscribe(callExecuteOnSubscribe);
        callExecuteOnSubscribe = bodyOnSubscribe;
        Observable observable2 = new Observable(l.a(callExecuteOnSubscribe));
        if (!this.d) {
        }
    }
}
