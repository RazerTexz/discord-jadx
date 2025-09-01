package b.i.a.c;

import b.i.a.c.e3.DefaultAllocator;
import b.i.b.a.Supplier2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Supplier2 {
    public static final /* synthetic */ a j = new a();

    @Override // b.i.b.a.Supplier2
    public final Object get() {
        return new DefaultLoadControl(new DefaultAllocator(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }
}
