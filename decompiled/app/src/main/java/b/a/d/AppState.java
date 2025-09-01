package b.a.d;

import j0.k.Func1;

/* compiled from: AppState.kt */
/* renamed from: b.a.d.k, reason: use source file name */
/* loaded from: classes.dex */
public final class AppState<T, R> implements Func1<Integer, Boolean> {
    public static final AppState j = new AppState();

    @Override // j0.k.Func1
    public Boolean call(Integer num) {
        return Boolean.valueOf(num.intValue() > 0);
    }
}
