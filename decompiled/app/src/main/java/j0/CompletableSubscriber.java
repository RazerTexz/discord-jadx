package j0;

import rx.Subscription;

/* compiled from: CompletableSubscriber.java */
/* renamed from: j0.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface CompletableSubscriber {
    void a(Subscription subscription);

    void onCompleted();

    void onError(Throwable th);
}
