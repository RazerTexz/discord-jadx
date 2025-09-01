package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.m.LockBasedStorageManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DefaultBuiltIns.kt */
/* renamed from: d0.e0.p.d.m0.b.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final a f = new a(null);
    public static final DefaultBuiltIns g = new DefaultBuiltIns(false, 1, null);

    /* compiled from: DefaultBuiltIns.kt */
    /* renamed from: d0.e0.p.d.m0.b.e$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.access$getInstance$cp();
        }
    }

    public DefaultBuiltIns(boolean z2) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z2) {
            d(false);
        }
    }

    public static final /* synthetic */ DefaultBuiltIns access$getInstance$cp() {
        return g;
    }

    public static final DefaultBuiltIns getInstance() {
        return f.getInstance();
    }

    public /* synthetic */ DefaultBuiltIns(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2);
    }
}
