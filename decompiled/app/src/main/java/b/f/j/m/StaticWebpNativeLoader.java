package b.f.j.m;

import b.f.m.n.NativeLoader;

/* compiled from: StaticWebpNativeLoader.java */
/* renamed from: b.f.j.m.b, reason: use source file name */
/* loaded from: classes3.dex */
public class StaticWebpNativeLoader {
    public static boolean a;

    public static synchronized void a() {
        if (!a) {
            NativeLoader.c("static-webp");
            a = true;
        }
    }
}
