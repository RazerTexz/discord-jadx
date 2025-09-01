package b.i.a.c.e3;

import b.i.a.c.e3.SlidingPercentile;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Comparator {
    public static final /* synthetic */ d j = new d();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = SlidingPercentile.a;
        return ((SlidingPercentile.b) obj).a - ((SlidingPercentile.b) obj2).a;
    }
}
