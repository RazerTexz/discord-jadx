package d0.e0.p.d.m0.o;

import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public abstract class c {
    public final boolean a;

    /* compiled from: modifierChecks.kt */
    public static final class a extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f3545b = new a();

        public a() {
            super(false, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class b extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(false, null);
            Intrinsics3.checkNotNullParameter(str, "error");
        }
    }

    /* compiled from: modifierChecks.kt */
    /* renamed from: d0.e0.p.d.m0.o.c$c, reason: collision with other inner class name */
    public static final class C0416c extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final C0416c f3546b = new C0416c();

        public C0416c() {
            super(true, null);
        }
    }

    public c(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = z2;
    }

    public final boolean isSuccess() {
        return this.a;
    }
}
