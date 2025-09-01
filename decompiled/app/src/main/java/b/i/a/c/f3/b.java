package b.i.a.c.f3;

import android.os.Handler;
import android.os.Message;
import b.i.a.c.f3.FlagSet;
import b.i.a.c.f3.ListenerSet;
import java.util.Iterator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Handler.Callback {
    public final /* synthetic */ ListenerSet j;

    public /* synthetic */ b(ListenerSet listenerSet) {
        this.j = listenerSet;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        ListenerSet listenerSet = this.j;
        Iterator it = listenerSet.d.iterator();
        while (it.hasNext()) {
            ListenerSet.c cVar = (ListenerSet.c) it.next();
            ListenerSet.b<T> bVar = listenerSet.c;
            if (!cVar.d && cVar.c) {
                FlagSet flagSetB = cVar.f974b.b();
                cVar.f974b = new FlagSet.b();
                cVar.c = false;
                bVar.a(cVar.a, flagSetB);
            }
            if (listenerSet.f973b.e(0)) {
                return true;
            }
        }
        return true;
    }
}
