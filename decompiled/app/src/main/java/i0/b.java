package i0;

import i0.DefaultCallAdapterFactory;
import java.io.IOException;
import retrofit2.Response;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ DefaultCallAdapterFactory.b.a j;
    public final /* synthetic */ Callback3 k;
    public final /* synthetic */ Response l;

    public /* synthetic */ b(DefaultCallAdapterFactory.b.a aVar, Callback3 callback3, Response response) {
        this.j = aVar;
        this.k = callback3;
        this.l = response;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultCallAdapterFactory.b.a aVar = this.j;
        Callback3 callback3 = this.k;
        Response response = this.l;
        if (DefaultCallAdapterFactory.b.this.k.d()) {
            callback3.a(DefaultCallAdapterFactory.b.this, new IOException("Canceled"));
        } else {
            callback3.b(DefaultCallAdapterFactory.b.this, response);
        }
    }
}
