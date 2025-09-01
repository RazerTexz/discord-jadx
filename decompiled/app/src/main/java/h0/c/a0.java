package h0.c;

import java.util.concurrent.Callable;
import org.webrtc.TextureBufferImpl;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a0 implements Callable {
    public final /* synthetic */ TextureBufferImpl j;

    public /* synthetic */ a0(TextureBufferImpl textureBufferImpl) {
        this.j = textureBufferImpl;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.j.a();
    }
}
