package b.i.a.c;

import android.content.Context;
import b.i.b.a.Supplier2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Supplier2 {
    public final /* synthetic */ Context j;

    public /* synthetic */ f(Context context) {
        this.j = context;
    }

    @Override // b.i.b.a.Supplier2
    public final Object get() {
        return new DefaultRenderersFactory(this.j);
    }
}
