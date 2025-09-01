package b.i.a.c;

import android.content.Context;
import b.i.a.c.c3.DefaultTrackSelector;
import b.i.b.a.Supplier2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Supplier2 {
    public final /* synthetic */ Context j;

    public /* synthetic */ g(Context context) {
        this.j = context;
    }

    @Override // b.i.b.a.Supplier2
    public final Object get() {
        return new DefaultTrackSelector(this.j);
    }
}
