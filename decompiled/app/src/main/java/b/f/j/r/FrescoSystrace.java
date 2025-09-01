package b.f.j.r;

import java.util.Objects;

/* compiled from: FrescoSystrace.java */
/* renamed from: b.f.j.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public class FrescoSystrace {
    public static volatile a a;

    /* compiled from: FrescoSystrace.java */
    /* renamed from: b.f.j.r.b$a */
    public interface a {
    }

    public static a a() {
        if (a == null) {
            synchronized (FrescoSystrace.class) {
                if (a == null) {
                    a = new DefaultFrescoSystrace();
                }
            }
        }
        return a;
    }

    public static boolean b() {
        Objects.requireNonNull(a());
        return false;
    }
}
