package b.a.e;

import d0.z.d.Intrinsics3;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* compiled from: Backgrounded.kt */
/* renamed from: b.a.e.d, reason: use source file name */
/* loaded from: classes.dex */
public final class Backgrounded4 {
    public static boolean a = true;

    /* renamed from: b, reason: collision with root package name */
    public static final Subject<Boolean, Boolean> f65b;
    public static Subscription c;
    public static final Backgrounded4 d = new Backgrounded4();

    static {
        BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0(true);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(isBackgrounded)");
        f65b = behaviorSubjectL0;
    }

    public final Observable<Boolean> a() {
        Observable<Boolean> observableR = f65b.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "emitter.distinctUntilChanged()");
        return observableR;
    }
}
