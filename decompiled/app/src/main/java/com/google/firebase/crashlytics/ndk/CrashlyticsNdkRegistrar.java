package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import b.i.a.f.e.o.f;
import b.i.c.l.Component4;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.m.d.CrashlyticsNativeComponent;
import b.i.c.m.e.CrashlyticsNdkRegistrar2;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        Component4.b bVarA = Component4.a(CrashlyticsNativeComponent.class);
        bVarA.a(new Dependency2(Context.class, 1, 0));
        bVarA.c(new CrashlyticsNdkRegistrar2(this));
        bVarA.d(2);
        return Arrays.asList(bVarA.b(), f.N("fire-cls-ndk", "17.3.0"));
    }
}
