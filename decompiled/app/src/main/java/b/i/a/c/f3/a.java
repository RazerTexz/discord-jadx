package b.i.a.c.f3;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.FlagSet;
import b.i.a.c.f3.ListenerSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet j;
    public final /* synthetic */ int k;
    public final /* synthetic */ ListenerSet.a l;

    public /* synthetic */ a(CopyOnWriteArraySet copyOnWriteArraySet, int i, ListenerSet.a aVar) {
        this.j = copyOnWriteArraySet;
        this.k = i;
        this.l = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CopyOnWriteArraySet copyOnWriteArraySet = this.j;
        int i = this.k;
        ListenerSet.a aVar = this.l;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ListenerSet.c cVar = (ListenerSet.c) it.next();
            if (!cVar.d) {
                if (i != -1) {
                    FlagSet.b bVar = cVar.f974b;
                    AnimatableValueParser.D(!bVar.f972b);
                    bVar.a.append(i, true);
                }
                cVar.c = true;
                aVar.invoke(cVar.a);
            }
        }
    }
}
