package b.i.a.b.j.t.i;

import b.i.a.b.Encoding2;
import b.i.a.b.j.t.i.t;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class n implements t.b {
    public static final n a = new n();

    @Override // b.i.a.b.j.t.i.t.b
    public Object apply(Object obj) {
        Encoding2 encoding2 = t.j;
        throw new SynchronizationException("Timed out while trying to acquire the lock.", (Throwable) obj);
    }
}
