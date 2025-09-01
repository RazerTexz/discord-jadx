package b.i.a.b.j.t;

import b.d.b.a.outline;
import b.i.a.b.TransportScheduleCallback;
import b.i.a.b.j.EventInternal;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.q.TransportBackend;
import java.util.logging.Logger;

/* compiled from: DefaultScheduler.java */
/* renamed from: b.i.a.b.j.t.a, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class DefaultScheduler implements Runnable {
    public final DefaultScheduler3 j;
    public final TransportContext k;
    public final TransportScheduleCallback l;
    public final EventInternal m;

    public DefaultScheduler(DefaultScheduler3 defaultScheduler3, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.j = defaultScheduler3;
        this.k = transportContext;
        this.l = transportScheduleCallback;
        this.m = eventInternal;
    }

    @Override // java.lang.Runnable
    public void run() {
        DefaultScheduler3 defaultScheduler3 = this.j;
        TransportContext transportContext = this.k;
        TransportScheduleCallback transportScheduleCallback = this.l;
        EventInternal eventInternal = this.m;
        Logger logger = DefaultScheduler3.a;
        try {
            TransportBackend transportBackend = defaultScheduler3.d.get(transportContext.b());
            if (transportBackend == null) {
                String str = String.format("Transport backend '%s' is not registered", transportContext.b());
                DefaultScheduler3.a.warning(str);
                transportScheduleCallback.a(new IllegalArgumentException(str));
            } else {
                defaultScheduler3.f.a(new DefaultScheduler2(defaultScheduler3, transportContext, transportBackend.b(eventInternal)));
                transportScheduleCallback.a(null);
            }
        } catch (Exception e) {
            Logger logger2 = DefaultScheduler3.a;
            StringBuilder sbU = outline.U("Error scheduling event ");
            sbU.append(e.getMessage());
            logger2.warning(sbU.toString());
            transportScheduleCallback.a(e);
        }
    }
}
