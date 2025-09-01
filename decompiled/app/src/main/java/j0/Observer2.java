package j0;

/* compiled from: Observer.java */
/* renamed from: j0.g, reason: use source file name */
/* loaded from: classes3.dex */
public interface Observer2<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
