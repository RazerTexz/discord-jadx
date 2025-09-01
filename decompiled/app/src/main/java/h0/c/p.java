package h0.c;

import org.webrtc.JniCommon;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ long j;

    public /* synthetic */ p(long j) {
        this.j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JniCommon.nativeReleaseRef(this.j);
    }
}
