package b.i.a.c.y2;

import android.media.MediaCodec;
import b.i.a.c.g3.MediaCodecVideoRenderer;
import b.i.a.c.y2.MediaCodecAdapter;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ AsynchronousMediaCodecAdapter a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.c f1303b;

    public /* synthetic */ c(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaCodecAdapter.c cVar) {
        this.a = asynchronousMediaCodecAdapter;
        this.f1303b = cVar;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter = this.a;
        MediaCodecAdapter.c cVar = this.f1303b;
        Objects.requireNonNull(asynchronousMediaCodecAdapter);
        ((MediaCodecVideoRenderer.b) cVar).b(asynchronousMediaCodecAdapter, j, j2);
    }
}
