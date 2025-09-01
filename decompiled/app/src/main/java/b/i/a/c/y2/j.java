package b.i.a.c.y2;

import android.media.MediaCodec;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ MediaCodec j;

    public /* synthetic */ j(MediaCodec mediaCodec) {
        this.j = mediaCodec;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.start();
    }
}
