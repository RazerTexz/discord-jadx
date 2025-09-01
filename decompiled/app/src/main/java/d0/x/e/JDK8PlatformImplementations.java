package d0.x.e;

import d0.c0.Random;
import d0.c0.f.PlatformThreadLocalRandom;
import d0.x.d.JDK7PlatformImplementations;

/* compiled from: JDK8PlatformImplementations.kt */
/* renamed from: d0.x.e.a, reason: use source file name */
/* loaded from: classes3.dex */
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {
    @Override // d0.x.PlatformImplementations
    public Random defaultPlatformRandom() {
        return new PlatformThreadLocalRandom();
    }
}
