package j0.q;

import j0.q.SubjectSubscriptionManager2;
import rx.functions.Action0;

/* compiled from: SubjectSubscriptionManager.java */
/* renamed from: j0.q.b, reason: use source file name */
/* loaded from: classes3.dex */
public class SubjectSubscriptionManager implements Action0 {
    public final /* synthetic */ SubjectSubscriptionManager2.b j;
    public final /* synthetic */ SubjectSubscriptionManager2 k;

    public SubjectSubscriptionManager(SubjectSubscriptionManager2 subjectSubscriptionManager2, SubjectSubscriptionManager2.b bVar) {
        this.k = subjectSubscriptionManager2;
        this.j = bVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.k.a(this.j);
    }
}
