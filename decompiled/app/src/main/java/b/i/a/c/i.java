package b.i.a.c;

import b.i.a.c.ExoPlayer2;
import b.i.a.c.f3.Clock4;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.b.a.Supplier2;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Supplier2 {
    public final /* synthetic */ ExoPlayer2.b j;

    public /* synthetic */ i(ExoPlayer2.b bVar) {
        this.j = bVar;
    }

    @Override // b.i.b.a.Supplier2
    public final Object get() {
        Clock4 clock4 = this.j.f923b;
        Objects.requireNonNull(clock4);
        return new AnalyticsCollector(clock4);
    }
}
