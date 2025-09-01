package co.discord.media_engine;

import a0.a.a.a;
import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: Statistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JL\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lco/discord/media_engine/PlayoutMetric;", "", "", "component1", "()D", "component2", "component3", "component4", "component5", "component6", "last", "mean", "p75", "p95", "p99", "max", "copy", "(DDDDDD)Lco/discord/media_engine/PlayoutMetric;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "D", "getP95", "getP75", "getLast", "getP99", "getMean", "getMax", "<init>", "(DDDDDD)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class PlayoutMetric {
    private final double last;
    private final double max;
    private final double mean;
    private final double p75;
    private final double p95;
    private final double p99;

    public PlayoutMetric(double d, double d2, double d3, double d4, double d5, double d6) {
        this.last = d;
        this.mean = d2;
        this.p75 = d3;
        this.p95 = d4;
        this.p99 = d5;
        this.max = d6;
    }

    public static /* synthetic */ PlayoutMetric copy$default(PlayoutMetric playoutMetric, double d, double d2, double d3, double d4, double d5, double d6, int i, Object obj) {
        return playoutMetric.copy((i & 1) != 0 ? playoutMetric.last : d, (i & 2) != 0 ? playoutMetric.mean : d2, (i & 4) != 0 ? playoutMetric.p75 : d3, (i & 8) != 0 ? playoutMetric.p95 : d4, (i & 16) != 0 ? playoutMetric.p99 : d5, (i & 32) != 0 ? playoutMetric.max : d6);
    }

    /* renamed from: component1, reason: from getter */
    public final double getLast() {
        return this.last;
    }

    /* renamed from: component2, reason: from getter */
    public final double getMean() {
        return this.mean;
    }

    /* renamed from: component3, reason: from getter */
    public final double getP75() {
        return this.p75;
    }

    /* renamed from: component4, reason: from getter */
    public final double getP95() {
        return this.p95;
    }

    /* renamed from: component5, reason: from getter */
    public final double getP99() {
        return this.p99;
    }

    /* renamed from: component6, reason: from getter */
    public final double getMax() {
        return this.max;
    }

    public final PlayoutMetric copy(double last, double mean, double p75, double p95, double p99, double max) {
        return new PlayoutMetric(last, mean, p75, p95, p99, max);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayoutMetric)) {
            return false;
        }
        PlayoutMetric playoutMetric = (PlayoutMetric) other;
        return Double.compare(this.last, playoutMetric.last) == 0 && Double.compare(this.mean, playoutMetric.mean) == 0 && Double.compare(this.p75, playoutMetric.p75) == 0 && Double.compare(this.p95, playoutMetric.p95) == 0 && Double.compare(this.p99, playoutMetric.p99) == 0 && Double.compare(this.max, playoutMetric.max) == 0;
    }

    public final double getLast() {
        return this.last;
    }

    public final double getMax() {
        return this.max;
    }

    public final double getMean() {
        return this.mean;
    }

    public final double getP75() {
        return this.p75;
    }

    public final double getP95() {
        return this.p95;
    }

    public final double getP99() {
        return this.p99;
    }

    public int hashCode() {
        return a.a(this.max) + ((a.a(this.p99) + ((a.a(this.p95) + ((a.a(this.p75) + ((a.a(this.mean) + (a.a(this.last) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PlayoutMetric(last=");
        sbU.append(this.last);
        sbU.append(", mean=");
        sbU.append(this.mean);
        sbU.append(", p75=");
        sbU.append(this.p75);
        sbU.append(", p95=");
        sbU.append(this.p95);
        sbU.append(", p99=");
        sbU.append(this.p99);
        sbU.append(", max=");
        sbU.append(this.max);
        sbU.append(")");
        return sbU.toString();
    }
}
