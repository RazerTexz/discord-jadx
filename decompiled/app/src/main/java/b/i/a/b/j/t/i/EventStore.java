package b.i.a.b.j.t.i;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.i.a.b.j.EventInternal;
import b.i.a.b.j.TransportContext;
import java.io.Closeable;

/* compiled from: EventStore.java */
@WorkerThread
/* renamed from: b.i.a.b.j.t.i.c, reason: use source file name */
/* loaded from: classes3.dex */
public interface EventStore extends Closeable {
    @Nullable
    PersistedEvent a0(TransportContext transportContext, EventInternal eventInternal);

    long h0(TransportContext transportContext);

    int l();

    boolean l0(TransportContext transportContext);

    void m(Iterable<PersistedEvent> iterable);

    void n0(Iterable<PersistedEvent> iterable);

    Iterable<PersistedEvent> r(TransportContext transportContext);

    void v(TransportContext transportContext, long j);

    Iterable<TransportContext> z();
}
