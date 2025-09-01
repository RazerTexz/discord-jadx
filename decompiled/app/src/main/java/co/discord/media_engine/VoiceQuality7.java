package co.discord.media_engine;

import b.d.b.a.outline;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: VoiceQuality.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\u001a5\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a'\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", "key", "Lco/discord/media_engine/PlayoutMetric;", "metric", "", "", "result", "", "explodePlayoutMetric", "(Ljava/lang/String;Lco/discord/media_engine/PlayoutMetric;Ljava/util/Map;)V", "", "rtt", "lossRate", "_calculateMos", "(DD)D", "delay", "_calculateR", "x", "min", "max", "clamp", "(DDD)D", "android_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.VoiceQualityKt, reason: use source file name */
/* loaded from: classes.dex */
public final class VoiceQuality7 {
    private static final double _calculateMos(double d, double d2) {
        double d_calculateR = _calculateR(d, d2);
        if (d_calculateR < 0) {
            return 1.0d;
        }
        double d3 = 100;
        if (d_calculateR > d3) {
            return 4.5d;
        }
        return ((d3 - d_calculateR) * (d_calculateR - 60) * 7.1E-6d * d_calculateR) + (0.035d * d_calculateR) + 1;
    }

    private static final double _calculateR(double d, double d2) {
        double d3 = (0.024d * d) + (d > 177.3d ? (d - 177.3d) * 0.11d : 0.0d);
        double d4 = 10;
        return (93.4d - d3) - (((122 * d2) / (d2 + d4)) + d4);
    }

    public static final /* synthetic */ double access$_calculateMos(double d, double d2) {
        return _calculateMos(d, d2);
    }

    public static final /* synthetic */ double access$clamp(double d, double d2, double d3) {
        return clamp(d, d2, d3);
    }

    public static final /* synthetic */ void access$explodePlayoutMetric(String str, PlayoutMetric playoutMetric, Map map) {
        explodePlayoutMetric(str, playoutMetric, map);
    }

    private static final double clamp(double d, double d2, double d3) {
        return d < d2 ? d2 : d3 < d ? d3 : d;
    }

    private static final void explodePlayoutMetric(String str, PlayoutMetric playoutMetric, Map<String, Object> map) {
        map.put(outline.w(str, "_mean"), playoutMetric != null ? Double.valueOf(playoutMetric.getMean()) : obj);
        map.put(str + "_p75", playoutMetric != null ? Double.valueOf(playoutMetric.getP75()) : obj);
        map.put(str + "_p95", playoutMetric != null ? Double.valueOf(playoutMetric.getP95()) : obj);
        map.put(str + "_p99", playoutMetric != null ? Double.valueOf(playoutMetric.getP99()) : obj);
        map.put(str + "_max", playoutMetric != null ? Double.valueOf(playoutMetric.getMax()) : 0);
    }
}
