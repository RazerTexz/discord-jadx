package b.i.a.c.y2;

import b.i.a.c.Format2;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements MediaCodecUtil.f {
    public final /* synthetic */ Format2 a;

    public /* synthetic */ g(Format2 format2) {
        this.a = format2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
    public final int a(Object obj) {
        try {
            return ((MediaCodecInfo) obj).e(this.a) ? 1 : 0;
        } catch (MediaCodecUtil.DecoderQueryException unused) {
            return -1;
        }
    }
}
