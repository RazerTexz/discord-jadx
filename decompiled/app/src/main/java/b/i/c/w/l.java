package b.i.c.w;

import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements ComponentFactory {
    public static final ComponentFactory a = new l();

    @Override // b.i.c.l.ComponentFactory
    public final Object a(ComponentContainer componentContainer) {
        return FirebaseMessagingRegistrar.lambda$getComponents$0$FirebaseMessagingRegistrar(componentContainer);
    }
}
