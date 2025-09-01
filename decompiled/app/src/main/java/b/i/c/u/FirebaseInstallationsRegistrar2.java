package b.i.c.u;

import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;

/* compiled from: FirebaseInstallationsRegistrar.java */
/* renamed from: b.i.c.u.h, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseInstallationsRegistrar2 implements ComponentFactory {
    public static final FirebaseInstallationsRegistrar2 a = new FirebaseInstallationsRegistrar2();

    @Override // b.i.c.l.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
    }
}
