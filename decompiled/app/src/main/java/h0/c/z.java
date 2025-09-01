package h0.c;

import java.util.Objects;
import org.webrtc.TextureBufferImpl;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ TextureBufferImpl j;
    public final /* synthetic */ TextureBufferImpl.RefCountMonitor k;

    public /* synthetic */ z(TextureBufferImpl textureBufferImpl, TextureBufferImpl.RefCountMonitor refCountMonitor) {
        this.j = textureBufferImpl;
        this.k = refCountMonitor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextureBufferImpl textureBufferImpl = this.j;
        TextureBufferImpl.RefCountMonitor refCountMonitor = this.k;
        Objects.requireNonNull(textureBufferImpl);
        refCountMonitor.onDestroy(textureBufferImpl);
    }
}
