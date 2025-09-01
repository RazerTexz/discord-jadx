package b.i.a.c;

import android.content.Context;
import b.i.a.c.a3.DefaultMediaSourceFactory;
import b.i.a.c.x2.DefaultExtractorsFactory;
import b.i.b.a.Supplier2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Supplier2 {
    public final /* synthetic */ Context j;

    public /* synthetic */ h(Context context) {
        this.j = context;
    }

    @Override // b.i.b.a.Supplier2
    public final Object get() {
        return new DefaultMediaSourceFactory(this.j, new DefaultExtractorsFactory());
    }
}
