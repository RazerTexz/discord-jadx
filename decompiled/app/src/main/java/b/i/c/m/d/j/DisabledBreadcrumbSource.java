package b.i.c.m.d.j;

import androidx.annotation.Nullable;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.CrashlyticsCore;

/* compiled from: DisabledBreadcrumbSource.java */
/* renamed from: b.i.c.m.d.j.b, reason: use source file name */
/* loaded from: classes3.dex */
public class DisabledBreadcrumbSource implements BreadcrumbSource {
    @Override // b.i.c.m.d.j.BreadcrumbSource
    public void a(@Nullable CrashlyticsCore crashlyticsCore) {
        Logger3.a.b("Could not register handler for breadcrumbs events.");
    }
}
