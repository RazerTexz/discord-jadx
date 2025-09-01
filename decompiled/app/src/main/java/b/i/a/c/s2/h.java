package b.i.a.c.s2;

import android.util.SparseArray;
import b.i.a.c.Player2;
import b.i.a.c.f3.FlagSet;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements ListenerSet.b {
    public final /* synthetic */ AnalyticsCollector a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Player2 f1082b;

    public /* synthetic */ h(AnalyticsCollector analyticsCollector, Player2 player2) {
        this.a = analyticsCollector;
        this.f1082b = player2;
    }

    @Override // b.i.a.c.f3.ListenerSet.b
    public final void a(Object obj, FlagSet flagSet) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        SparseArray<AnalyticsListener.a> sparseArray = this.a.n;
        SparseArray sparseArray2 = new SparseArray(flagSet.c());
        for (int i = 0; i < flagSet.c(); i++) {
            int iB = flagSet.b(i);
            AnalyticsListener.a aVar = sparseArray.get(iB);
            Objects.requireNonNull(aVar);
            sparseArray2.append(iB, aVar);
        }
        analyticsListener.K();
    }
}
