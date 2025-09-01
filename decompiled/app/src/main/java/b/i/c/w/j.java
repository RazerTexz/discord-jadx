package b.i.c.w;

import b.i.c.q.Event3;
import b.i.c.q.EventHandler2;
import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements EventHandler2 {
    public final FirebaseMessaging.a a;

    public j(FirebaseMessaging.a aVar) {
        this.a = aVar;
    }

    @Override // b.i.c.q.EventHandler2
    public final void a(Event3 event3) {
        FirebaseMessaging.a aVar = this.a;
        if (aVar.b()) {
            FirebaseMessaging.this.f.execute(new k(aVar));
        }
    }
}
