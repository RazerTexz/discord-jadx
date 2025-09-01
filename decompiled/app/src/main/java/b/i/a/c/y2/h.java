package b.i.a.c.y2;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Comparator {
    public final /* synthetic */ MediaCodecUtil.f j;

    public /* synthetic */ h(MediaCodecUtil.f fVar) {
        this.j = fVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        MediaCodecUtil.f fVar = this.j;
        return fVar.a(obj2) - fVar.a(obj);
    }
}
