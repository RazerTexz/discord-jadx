package b.i.a.b.j;

import android.content.Context;
import b.i.a.b.Encoding2;
import b.i.a.b.TransportFactory;
import b.i.a.b.i.CCTDestination;
import b.i.a.b.j.AutoValue_TransportContext;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.t.Scheduler2;
import b.i.a.b.j.t.h.Uploader6;
import b.i.a.b.j.t.h.WorkInitializer;
import b.i.a.b.j.t.h.WorkInitializer3;
import b.i.a.b.j.v.Clock3;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* compiled from: TransportRuntime.java */
/* renamed from: b.i.a.b.j.n, reason: use source file name */
/* loaded from: classes3.dex */
public class TransportRuntime implements TransportInternal {
    public static volatile TransportRuntimeComponent a;

    /* renamed from: b, reason: collision with root package name */
    public final Clock3 f769b;
    public final Clock3 c;
    public final Scheduler2 d;
    public final Uploader6 e;

    public TransportRuntime(Clock3 clock3, Clock3 clock32, Scheduler2 scheduler2, Uploader6 uploader6, WorkInitializer3 workInitializer3) {
        this.f769b = clock3;
        this.c = clock32;
        this.d = scheduler2;
        this.e = uploader6;
        workInitializer3.a.execute(new WorkInitializer(workInitializer3));
    }

    public static TransportRuntime a() {
        TransportRuntimeComponent transportRuntimeComponent = a;
        if (transportRuntimeComponent != null) {
            return ((DaggerTransportRuntimeComponent) transportRuntimeComponent).u.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (a == null) {
            synchronized (TransportRuntime.class) {
                if (a == null) {
                    Objects.requireNonNull(context);
                    a = new DaggerTransportRuntimeComponent(context, null);
                }
            }
        }
    }

    public TransportFactory c(EncodedDestination encodedDestination) {
        Set setSingleton;
        if (encodedDestination instanceof EncodedDestination) {
            Objects.requireNonNull((CCTDestination) encodedDestination);
            setSingleton = Collections.unmodifiableSet(CCTDestination.d);
        } else {
            setSingleton = Collections.singleton(new Encoding2("proto"));
        }
        TransportContext.a aVarA = TransportContext.a();
        Objects.requireNonNull(encodedDestination);
        aVarA.b("cct");
        AutoValue_TransportContext.b bVar = (AutoValue_TransportContext.b) aVarA;
        bVar.f764b = ((CCTDestination) encodedDestination).b();
        return new TransportFactoryImpl(setSingleton, bVar.a(), this);
    }
}
