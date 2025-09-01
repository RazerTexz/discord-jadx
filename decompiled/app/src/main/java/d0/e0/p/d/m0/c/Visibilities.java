package d0.e0.p.d.m0.c;

import androidx.core.os.EnvironmentCompat;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.Map;

/* compiled from: Visibilities.kt */
/* renamed from: d0.e0.p.d.m0.c.e1, reason: use source file name */
/* loaded from: classes3.dex */
public final class Visibilities {
    public static final Visibilities a = new Visibilities();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Visibility2, Integer> f3246b;

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$a */
    public static final class a extends Visibility2 {
        public static final a c = new a();

        public a() {
            super("inherited", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$b */
    public static final class b extends Visibility2 {
        public static final b c = new b();

        public b() {
            super("internal", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$c */
    public static final class c extends Visibility2 {
        public static final c c = new c();

        public c() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$d */
    public static final class d extends Visibility2 {
        public static final d c = new d();

        public d() {
            super("local", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$e */
    public static final class e extends Visibility2 {
        public static final e c = new e();

        public e() {
            super("private", false);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$f */
    public static final class f extends Visibility2 {
        public static final f c = new f();

        public f() {
            super("private_to_this", false);
        }

        @Override // d0.e0.p.d.m0.c.Visibility2
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$g */
    public static final class g extends Visibility2 {
        public static final g c = new g();

        public g() {
            super("protected", true);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$h */
    public static final class h extends Visibility2 {
        public static final h c = new h();

        public h() {
            super("public", true);
        }
    }

    /* compiled from: Visibilities.kt */
    /* renamed from: d0.e0.p.d.m0.c.e1$i */
    public static final class i extends Visibility2 {
        public static final i c = new i();

        public i() {
            super(EnvironmentCompat.MEDIA_UNKNOWN, false);
        }
    }

    static {
        Map mapCreateMapBuilder = MapsJVM.createMapBuilder();
        mapCreateMapBuilder.put(f.c, 0);
        mapCreateMapBuilder.put(e.c, 0);
        mapCreateMapBuilder.put(b.c, 1);
        mapCreateMapBuilder.put(g.c, 1);
        mapCreateMapBuilder.put(h.c, 2);
        f3246b = MapsJVM.build(mapCreateMapBuilder);
    }

    public final Integer compareLocal$compiler_common(Visibility2 visibility2, Visibility2 visibility22) {
        Intrinsics3.checkNotNullParameter(visibility2, "first");
        Intrinsics3.checkNotNullParameter(visibility22, "second");
        if (visibility2 == visibility22) {
            return 0;
        }
        Map<Visibility2, Integer> map = f3246b;
        Integer num = map.get(visibility2);
        Integer num2 = map.get(visibility22);
        if (num == null || num2 == null || Intrinsics3.areEqual(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "visibility");
        return visibility2 == e.c || visibility2 == f.c;
    }
}
