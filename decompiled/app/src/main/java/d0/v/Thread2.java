package d0.v;

import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Thread.kt */
/* renamed from: d0.v.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Thread2 {

    /* compiled from: Thread.kt */
    /* renamed from: d0.v.a$a */
    public static final class a extends Thread {
        public final /* synthetic */ Function0 j;

        public a(Function0 function0) {
            this.j = function0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.j.invoke();
        }
    }

    public static final Thread thread(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "block");
        a aVar = new a(function0);
        if (z3) {
            aVar.setDaemon(true);
        }
        if (i > 0) {
            aVar.setPriority(i);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z2) {
            aVar.start();
        }
        return aVar;
    }

    public static /* synthetic */ Thread thread$default(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0 function0, int i2, Object obj) {
        return thread((i2 & 1) != 0 ? true : z2, (i2 & 2) != 0 ? false : z3, (i2 & 4) != 0 ? null : classLoader, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? -1 : i, function0);
    }
}
