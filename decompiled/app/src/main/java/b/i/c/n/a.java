package b.i.c.n;

import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import com.google.firebase.datatransport.TransportRegistrar;

/* compiled from: com.google.firebase:firebase-datatransport@@17.0.3 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements ComponentFactory {
    public static final a a = new a();

    @Override // b.i.c.l.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        return TransportRegistrar.lambda$getComponents$0(componentContainer);
    }
}
