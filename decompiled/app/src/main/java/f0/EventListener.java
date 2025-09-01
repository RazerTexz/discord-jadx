package f0;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;

/* compiled from: EventListener.kt */
/* renamed from: f0.t, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class EventListener {
    public static final EventListener a = new a();

    /* compiled from: EventListener.kt */
    /* renamed from: f0.t$a */
    public static final class a extends EventListener {
    }

    /* compiled from: EventListener.kt */
    /* renamed from: f0.t$b */
    public interface b {
        EventListener a(Call2 call2);
    }

    public void a(Call2 call2, Connection2 connection2) {
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(connection2, "connection");
    }
}
