package h0.c;

import org.webrtc.Camera1Session;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Camera1Session.AnonymousClass2 j;
    public final /* synthetic */ byte[] k;

    public /* synthetic */ a(Camera1Session.AnonymousClass2 anonymousClass2, byte[] bArr) {
        this.j = anonymousClass2;
        this.k = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Camera1Session.AnonymousClass2 anonymousClass2 = this.j;
        byte[] bArr = this.k;
        if (Camera1Session.access$400(Camera1Session.this) == Camera1Session.SessionState.RUNNING) {
            Camera1Session.access$300(Camera1Session.this).addCallbackBuffer(bArr);
        }
    }
}
