package b.i.a.b.j.t.h;

import android.content.Context;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.q.AutoValue_BackendRequest;
import b.i.a.b.j.q.BackendRegistry;
import b.i.a.b.j.q.BackendResponse;
import b.i.a.b.j.q.TransportBackend;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.t.i.PersistedEvent;
import b.i.a.b.j.u.SynchronizationGuard;
import b.i.a.b.j.v.Clock3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: Uploader.java */
/* renamed from: b.i.a.b.j.t.h.l, reason: use source file name */
/* loaded from: classes3.dex */
public class Uploader6 {
    public final Context a;

    /* renamed from: b, reason: collision with root package name */
    public final BackendRegistry f791b;
    public final EventStore c;
    public final WorkScheduler d;
    public final Executor e;
    public final SynchronizationGuard f;
    public final Clock3 g;

    public Uploader6(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock3 clock3) {
        this.a = context;
        this.f791b = backendRegistry;
        this.c = eventStore;
        this.d = workScheduler;
        this.e = executor;
        this.f = synchronizationGuard;
        this.g = clock3;
    }

    public void a(TransportContext transportContext, int i) {
        BackendResponse backendResponseA;
        TransportBackend transportBackend = this.f791b.get(transportContext.b());
        Iterable iterable = (Iterable) this.f.a(new Uploader2(this, transportContext));
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                AnimatableValueParser.X("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                backendResponseA = BackendResponse.a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PersistedEvent) it.next()).a());
                }
                byte[] bArrC = transportContext.c();
                if (1 == 0) {
                    throw new IllegalStateException(outline.w("Missing required properties:", ""));
                }
                backendResponseA = transportBackend.a(new AutoValue_BackendRequest(arrayList, bArrC, null));
            }
            this.f.a(new Uploader3(this, backendResponseA, iterable, transportContext, i));
        }
    }
}
