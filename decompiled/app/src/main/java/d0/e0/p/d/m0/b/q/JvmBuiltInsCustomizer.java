package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JvmBuiltInsCustomizer.kt */
/* renamed from: d0.e0.p.d.m0.b.q.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer extends KotlinBuiltIns {
    public static final a f = new a(null);
    public static final KotlinBuiltIns g = new JvmBuiltInsCustomizer();

    /* compiled from: JvmBuiltInsCustomizer.kt */
    /* renamed from: d0.e0.p.d.m0.b.q.b$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KotlinBuiltIns getInstance() {
            return JvmBuiltInsCustomizer.access$getInstance$cp();
        }
    }

    public JvmBuiltInsCustomizer() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        d(true);
    }

    public static final /* synthetic */ KotlinBuiltIns access$getInstance$cp() {
        return g;
    }

    @Override // d0.e0.p.d.m0.b.KotlinBuiltIns
    public /* bridge */ /* synthetic */ PlatformDependentDeclarationFilter h() {
        return PlatformDependentDeclarationFilter.a.a;
    }
}
