package com.google.firebase.crashlytics;

import b.i.a.f.e.o.f;
import b.i.c.FirebaseApp2;
import b.i.c.j.a.a;
import b.i.c.l.Component4;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.m.CrashlyticsRegistrar2;
import b.i.c.m.d.CrashlyticsNativeComponent;
import b.i.c.u.g;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        Component4.b bVarA = Component4.a(FirebaseCrashlytics.class);
        bVarA.a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarA.a(new Dependency2(g.class, 1, 0));
        bVarA.a(new Dependency2(a.class, 0, 0));
        bVarA.a(new Dependency2(CrashlyticsNativeComponent.class, 0, 0));
        bVarA.c(new CrashlyticsRegistrar2(this));
        bVarA.d(2);
        return Arrays.asList(bVarA.b(), f.N("fire-cls", "17.3.0"));
    }
}
