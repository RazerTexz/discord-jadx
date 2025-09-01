package b.i.c.l;

import b.i.c.t.Provider2;

/* compiled from: ComponentRuntime.java */
/* renamed from: b.i.c.l.h, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class ComponentRuntime implements Provider2 {
    public final ComponentRuntime4 a;

    /* renamed from: b, reason: collision with root package name */
    public final Component4 f1664b;

    public ComponentRuntime(ComponentRuntime4 componentRuntime4, Component4 component4) {
        this.a = componentRuntime4;
        this.f1664b = component4;
    }

    @Override // b.i.c.t.Provider2
    public Object get() {
        ComponentRuntime4 componentRuntime4 = this.a;
        Component4 component4 = this.f1664b;
        int i = ComponentRuntime4.a;
        return component4.e.a(new RestrictedComponentContainer(component4, componentRuntime4));
    }
}
