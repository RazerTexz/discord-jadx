package co.discord.media_engine;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: VoiceQuality.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004Jd\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lco/discord/media_engine/InboundFrameOpStats;", "", "", "component1", "()Ljava/lang/Long;", "component2", "component3", "component4", "component5", "component6", "component7", NotificationCompat.GROUP_KEY_SILENT, Constants.NORMAL, "merged", "expanded", "accelerated", "preemptiveExpanded", "cng", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lco/discord/media_engine/InboundFrameOpStats;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getCng", "getMerged", "getPreemptiveExpanded", "getNormal", "getSilent", "getAccelerated", "getExpanded", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.InboundFrameOpStats, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class VoiceQuality5 {
    private final Long accelerated;
    private final Long cng;
    private final Long expanded;
    private final Long merged;
    private final Long normal;
    private final Long preemptiveExpanded;
    private final Long silent;

    public VoiceQuality5(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7) {
        this.silent = l;
        this.normal = l2;
        this.merged = l3;
        this.expanded = l4;
        this.accelerated = l5;
        this.preemptiveExpanded = l6;
        this.cng = l7;
    }

    public static /* synthetic */ VoiceQuality5 copy$default(VoiceQuality5 voiceQuality5, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, int i, Object obj) {
        if ((i & 1) != 0) {
            l = voiceQuality5.silent;
        }
        if ((i & 2) != 0) {
            l2 = voiceQuality5.normal;
        }
        Long l8 = l2;
        if ((i & 4) != 0) {
            l3 = voiceQuality5.merged;
        }
        Long l9 = l3;
        if ((i & 8) != 0) {
            l4 = voiceQuality5.expanded;
        }
        Long l10 = l4;
        if ((i & 16) != 0) {
            l5 = voiceQuality5.accelerated;
        }
        Long l11 = l5;
        if ((i & 32) != 0) {
            l6 = voiceQuality5.preemptiveExpanded;
        }
        Long l12 = l6;
        if ((i & 64) != 0) {
            l7 = voiceQuality5.cng;
        }
        return voiceQuality5.copy(l, l8, l9, l10, l11, l12, l7);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getSilent() {
        return this.silent;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getNormal() {
        return this.normal;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getMerged() {
        return this.merged;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getExpanded() {
        return this.expanded;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getAccelerated() {
        return this.accelerated;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getPreemptiveExpanded() {
        return this.preemptiveExpanded;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getCng() {
        return this.cng;
    }

    public final VoiceQuality5 copy(Long silent, Long normal, Long merged, Long expanded, Long accelerated, Long preemptiveExpanded, Long cng) {
        return new VoiceQuality5(silent, normal, merged, expanded, accelerated, preemptiveExpanded, cng);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceQuality5)) {
            return false;
        }
        VoiceQuality5 voiceQuality5 = (VoiceQuality5) other;
        return Intrinsics3.areEqual(this.silent, voiceQuality5.silent) && Intrinsics3.areEqual(this.normal, voiceQuality5.normal) && Intrinsics3.areEqual(this.merged, voiceQuality5.merged) && Intrinsics3.areEqual(this.expanded, voiceQuality5.expanded) && Intrinsics3.areEqual(this.accelerated, voiceQuality5.accelerated) && Intrinsics3.areEqual(this.preemptiveExpanded, voiceQuality5.preemptiveExpanded) && Intrinsics3.areEqual(this.cng, voiceQuality5.cng);
    }

    public final Long getAccelerated() {
        return this.accelerated;
    }

    public final Long getCng() {
        return this.cng;
    }

    public final Long getExpanded() {
        return this.expanded;
    }

    public final Long getMerged() {
        return this.merged;
    }

    public final Long getNormal() {
        return this.normal;
    }

    public final Long getPreemptiveExpanded() {
        return this.preemptiveExpanded;
    }

    public final Long getSilent() {
        return this.silent;
    }

    public int hashCode() {
        Long l = this.silent;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.normal;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.merged;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.expanded;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.accelerated;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.preemptiveExpanded;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.cng;
        return iHashCode6 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundFrameOpStats(silent=");
        sbU.append(this.silent);
        sbU.append(", normal=");
        sbU.append(this.normal);
        sbU.append(", merged=");
        sbU.append(this.merged);
        sbU.append(", expanded=");
        sbU.append(this.expanded);
        sbU.append(", accelerated=");
        sbU.append(this.accelerated);
        sbU.append(", preemptiveExpanded=");
        sbU.append(this.preemptiveExpanded);
        sbU.append(", cng=");
        return outline.G(sbU, this.cng, ")");
    }
}
