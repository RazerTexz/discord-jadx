package b.i.a.c.y2;

import android.media.MediaCodec;
import b.i.a.c.g3.MediaCodecVideoRenderer;
import b.i.a.c.y2.MediaCodecAdapter;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ SynchronousMediaCodecAdapter a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.c f1304b;

    public /* synthetic */ i(SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, MediaCodecAdapter.c cVar) {
        this.a = synchronousMediaCodecAdapter;
        this.f1304b = cVar;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        SynchronousMediaCodecAdapter synchronousMediaCodecAdapter = this.a;
        MediaCodecAdapter.c cVar = this.f1304b;
        Objects.requireNonNull(synchronousMediaCodecAdapter);
        ((MediaCodecVideoRenderer.b) cVar).b(synchronousMediaCodecAdapter, j, j2);
    }
}
