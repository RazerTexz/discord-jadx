package b.i.c.l;

import b.i.c.q.Event3;
import b.i.c.q.EventHandler2;
import java.util.Map;

/* compiled from: EventBus.java */
/* renamed from: b.i.c.l.p, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class EventBus implements Runnable {
    public final Map.Entry j;
    public final Event3 k;

    public EventBus(Map.Entry entry, Event3 event3) {
        this.j = entry;
        this.k = event3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map.Entry entry = this.j;
        ((EventHandler2) entry.getKey()).a(this.k);
    }
}
