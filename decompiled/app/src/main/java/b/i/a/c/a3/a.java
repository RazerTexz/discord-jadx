package b.i.a.c.a3;

import android.util.Pair;
import b.i.a.c.Timeline;
import b.i.a.c.a3.MaskingMediaSource;
import b.i.a.c.a3.MediaSource2;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements MediaSource2.b {
    public final /* synthetic */ CompositeMediaSource a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f806b;

    public /* synthetic */ a(CompositeMediaSource compositeMediaSource, Object obj) {
        this.a = compositeMediaSource;
        this.f806b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // b.i.a.c.a3.MediaSource2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(MediaSource2 mediaSource2, Timeline timeline) {
        MaskingMediaSource.a aVar;
        MediaSource2.a aVarB;
        MaskingMediaSource.a aVar2;
        CompositeMediaSource compositeMediaSource = this.a;
        Object obj = this.f806b;
        Objects.requireNonNull(compositeMediaSource);
        MaskingMediaSource maskingMediaSource = (MaskingMediaSource) compositeMediaSource;
        if (maskingMediaSource.q) {
            MaskingMediaSource.a aVar3 = maskingMediaSource.n;
            maskingMediaSource.n = new MaskingMediaSource.a(timeline, aVar3.m, aVar3.n);
            MaskingMediaPeriod maskingMediaPeriod = maskingMediaSource.o;
            if (maskingMediaPeriod != null) {
                maskingMediaSource.v(maskingMediaPeriod.p);
            }
        } else {
            if (!timeline.q()) {
                timeline.n(0, maskingMediaSource.l);
                Timeline.c cVar = maskingMediaSource.l;
                long j = cVar.f1045z;
                Object obj2 = cVar.n;
                MaskingMediaPeriod maskingMediaPeriod2 = maskingMediaSource.o;
                if (maskingMediaPeriod2 != null) {
                    long j2 = maskingMediaPeriod2.k;
                    maskingMediaSource.n.h(maskingMediaPeriod2.j.a, maskingMediaSource.m);
                    long j3 = maskingMediaSource.m.n + j2;
                    long j4 = j3 != maskingMediaSource.n.n(0, maskingMediaSource.l).f1045z ? j3 : j;
                    Pair<Object, Long> pairJ = timeline.j(maskingMediaSource.l, maskingMediaSource.m, 0, j4);
                    Object obj3 = pairJ.first;
                    long jLongValue = ((Long) pairJ.second).longValue();
                    if (maskingMediaSource.r) {
                        MaskingMediaSource.a aVar4 = maskingMediaSource.n;
                        aVar = new MaskingMediaSource.a(timeline, aVar4.m, aVar4.n);
                    } else {
                        aVar = new MaskingMediaSource.a(timeline, obj2, obj3);
                    }
                    maskingMediaSource.n = aVar;
                    MaskingMediaPeriod maskingMediaPeriod3 = maskingMediaSource.o;
                    if (maskingMediaPeriod3 != null) {
                        maskingMediaSource.v(jLongValue);
                        MediaSource2.a aVar5 = maskingMediaPeriod3.j;
                        Object obj4 = aVar5.a;
                        if (maskingMediaSource.n.n != null && obj4.equals(MaskingMediaSource.a.l)) {
                            obj4 = maskingMediaSource.n.n;
                        }
                        aVarB = aVar5.b(obj4);
                    }
                }
                maskingMediaSource.r = true;
                maskingMediaSource.q = true;
                maskingMediaSource.r(maskingMediaSource.n);
                if (aVarB == null) {
                    MaskingMediaPeriod maskingMediaPeriod4 = maskingMediaSource.o;
                    Objects.requireNonNull(maskingMediaPeriod4);
                    maskingMediaPeriod4.d(aVarB);
                    return;
                }
                return;
            }
            if (maskingMediaSource.r) {
                MaskingMediaSource.a aVar6 = maskingMediaSource.n;
                aVar2 = new MaskingMediaSource.a(timeline, aVar6.m, aVar6.n);
            } else {
                aVar2 = new MaskingMediaSource.a(timeline, Timeline.c.j, MaskingMediaSource.a.l);
            }
            maskingMediaSource.n = aVar2;
        }
        aVarB = null;
        maskingMediaSource.r = true;
        maskingMediaSource.q = true;
        maskingMediaSource.r(maskingMediaSource.n);
        if (aVarB == null) {
        }
    }
}
