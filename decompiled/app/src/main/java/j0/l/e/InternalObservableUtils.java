package j0.l.e;

import j0.Notification;
import j0.k.Func1;
import rx.Observable;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

/* compiled from: InternalObservableUtils.java */
/* renamed from: j0.l.e.e, reason: use source file name */
/* loaded from: classes3.dex */
public enum InternalObservableUtils {
    ;

    public static final e j = new e();
    public static final b k = new b();
    public static final Action1<Throwable> l = new a();

    /* compiled from: InternalObservableUtils.java */
    /* renamed from: j0.l.e.e$a */
    public static final class a implements Action1<Throwable> {
        @Override // rx.functions.Action1
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    /* compiled from: InternalObservableUtils.java */
    /* renamed from: j0.l.e.e$b */
    public static final class b implements Func1<Notification<?>, Throwable> {
        @Override // j0.k.Func1
        public Throwable call(Notification<?> notification) {
            return notification.c;
        }
    }

    /* compiled from: InternalObservableUtils.java */
    /* renamed from: j0.l.e.e$c */
    public static final class c implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        public final Func1<? super Observable<? extends Void>, ? extends Observable<?>> j;

        public c(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
            this.j = func1;
        }

        @Override // j0.k.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return this.j.call(observable.G(InternalObservableUtils.j));
        }
    }

    /* compiled from: InternalObservableUtils.java */
    /* renamed from: j0.l.e.e$d */
    public static final class d implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        public final Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> j;

        public d(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
            this.j = func1;
        }

        @Override // j0.k.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return this.j.call(observable.G(InternalObservableUtils.k));
        }
    }

    /* compiled from: InternalObservableUtils.java */
    /* renamed from: j0.l.e.e$e */
    public static final class e implements Func1<Object, Void> {
        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Void call(Object obj) {
            return null;
        }
    }
}
