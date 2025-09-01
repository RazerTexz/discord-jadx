package b.i.c.x;

import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import java.util.Set;

/* compiled from: DefaultUserAgentPublisher.java */
/* renamed from: b.i.c.x.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class DefaultUserAgentPublisher implements ComponentFactory {
    public static final DefaultUserAgentPublisher a = new DefaultUserAgentPublisher();

    @Override // b.i.c.l.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        Set setD = componentContainer.d(LibraryVersion.class);
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.a;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.a;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    GlobalLibraryVersionRegistrar.a = globalLibraryVersionRegistrar;
                }
            }
        }
        return new DefaultUserAgentPublisher2(setD, globalLibraryVersionRegistrar);
    }
}
