package b.a.q.o0;

import rx.functions.Action1;

/* compiled from: RtcStatsCollector.kt */
/* renamed from: b.a.q.o0.b, reason: use source file name */
/* loaded from: classes.dex */
public final class RtcStatsCollector2<T> implements Action1<Long> {
    public final /* synthetic */ RtcStatsCollector4 j;

    public RtcStatsCollector2(RtcStatsCollector4 rtcStatsCollector4) {
        this.j = rtcStatsCollector4;
    }

    @Override // rx.functions.Action1
    public void call(Long l) {
        this.j.e.n(new RtcStatsCollector(this.j));
    }
}
