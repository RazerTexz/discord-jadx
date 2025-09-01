package b.i.c.w;

import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {
    public final FirebaseMessaging.a j;

    public k(FirebaseMessaging.a aVar) {
        this.j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseMessaging.this.d.i();
    }
}
