package h0.c;

import org.webrtc.Camera1Session;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ Camera1Session.AnonymousClass2 j;
    public final /* synthetic */ byte[] k;

    public /* synthetic */ b(Camera1Session.AnonymousClass2 anonymousClass2, byte[] bArr) {
        this.j = anonymousClass2;
        this.k = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Camera1Session.AnonymousClass2 anonymousClass2 = this.j;
        Camera1Session.access$1000(Camera1Session.this).post(new a(anonymousClass2, this.k));
    }
}
