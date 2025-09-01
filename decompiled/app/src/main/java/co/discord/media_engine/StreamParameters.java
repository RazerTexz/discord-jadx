package co.discord.media_engine;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StreamParameters.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0010\u0010\u0010\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\nJ`\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\nJ\u001a\u0010\u001f\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b'\u0010\nR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010!\u001a\u0004\b*\u0010\nR\u0019\u0010\u0017\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b+\u0010\nR\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b,\u0010\n¨\u0006/"}, d2 = {"Lco/discord/media_engine/StreamParameters;", "", "Lco/discord/media_engine/MediaType;", "component1", "()Lco/discord/media_engine/MediaType;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "component4", "", "component5", "()Z", "component6", "component7", "component8", "type", "rid", "ssrc", "rtxSsrc", "active", "maxBitrate", "quality", "maxPixelCount", "copy", "(Lco/discord/media_engine/MediaType;Ljava/lang/String;IIZIII)Lco/discord/media_engine/StreamParameters;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getSsrc", "Z", "getActive", "Lco/discord/media_engine/MediaType;", "getType", "getQuality", "Ljava/lang/String;", "getRid", "getMaxPixelCount", "getMaxBitrate", "getRtxSsrc", "<init>", "(Lco/discord/media_engine/MediaType;Ljava/lang/String;IIZIII)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class StreamParameters {
    private final boolean active;
    private final int maxBitrate;
    private final int maxPixelCount;
    private final int quality;
    private final String rid;
    private final int rtxSsrc;
    private final int ssrc;
    private final StreamParameters2 type;

    public StreamParameters(StreamParameters2 streamParameters2, String str, int i, int i2, boolean z2, int i3, int i4, int i5) {
        Intrinsics3.checkNotNullParameter(streamParameters2, "type");
        Intrinsics3.checkNotNullParameter(str, "rid");
        this.type = streamParameters2;
        this.rid = str;
        this.ssrc = i;
        this.rtxSsrc = i2;
        this.active = z2;
        this.maxBitrate = i3;
        this.quality = i4;
        this.maxPixelCount = i5;
    }

    public static /* synthetic */ StreamParameters copy$default(StreamParameters streamParameters, StreamParameters2 streamParameters2, String str, int i, int i2, boolean z2, int i3, int i4, int i5, int i6, Object obj) {
        return streamParameters.copy((i6 & 1) != 0 ? streamParameters.type : streamParameters2, (i6 & 2) != 0 ? streamParameters.rid : str, (i6 & 4) != 0 ? streamParameters.ssrc : i, (i6 & 8) != 0 ? streamParameters.rtxSsrc : i2, (i6 & 16) != 0 ? streamParameters.active : z2, (i6 & 32) != 0 ? streamParameters.maxBitrate : i3, (i6 & 64) != 0 ? streamParameters.quality : i4, (i6 & 128) != 0 ? streamParameters.maxPixelCount : i5);
    }

    /* renamed from: component1, reason: from getter */
    public final StreamParameters2 getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRid() {
        return this.rid;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRtxSsrc() {
        return this.rtxSsrc;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getActive() {
        return this.active;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMaxBitrate() {
        return this.maxBitrate;
    }

    /* renamed from: component7, reason: from getter */
    public final int getQuality() {
        return this.quality;
    }

    /* renamed from: component8, reason: from getter */
    public final int getMaxPixelCount() {
        return this.maxPixelCount;
    }

    public final StreamParameters copy(StreamParameters2 type, String rid, int ssrc, int rtxSsrc, boolean active, int maxBitrate, int quality, int maxPixelCount) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(rid, "rid");
        return new StreamParameters(type, rid, ssrc, rtxSsrc, active, maxBitrate, quality, maxPixelCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamParameters)) {
            return false;
        }
        StreamParameters streamParameters = (StreamParameters) other;
        return Intrinsics3.areEqual(this.type, streamParameters.type) && Intrinsics3.areEqual(this.rid, streamParameters.rid) && this.ssrc == streamParameters.ssrc && this.rtxSsrc == streamParameters.rtxSsrc && this.active == streamParameters.active && this.maxBitrate == streamParameters.maxBitrate && this.quality == streamParameters.quality && this.maxPixelCount == streamParameters.maxPixelCount;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final int getMaxBitrate() {
        return this.maxBitrate;
    }

    public final int getMaxPixelCount() {
        return this.maxPixelCount;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final String getRid() {
        return this.rid;
    }

    public final int getRtxSsrc() {
        return this.rtxSsrc;
    }

    public final int getSsrc() {
        return this.ssrc;
    }

    public final StreamParameters2 getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        StreamParameters2 streamParameters2 = this.type;
        int iHashCode = (streamParameters2 != null ? streamParameters2.hashCode() : 0) * 31;
        String str = this.rid;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.ssrc) * 31) + this.rtxSsrc) * 31;
        boolean z2 = this.active;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return ((((((iHashCode2 + i) * 31) + this.maxBitrate) * 31) + this.quality) * 31) + this.maxPixelCount;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamParameters(type=");
        sbU.append(this.type);
        sbU.append(", rid=");
        sbU.append(this.rid);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", rtxSsrc=");
        sbU.append(this.rtxSsrc);
        sbU.append(", active=");
        sbU.append(this.active);
        sbU.append(", maxBitrate=");
        sbU.append(this.maxBitrate);
        sbU.append(", quality=");
        sbU.append(this.quality);
        sbU.append(", maxPixelCount=");
        return outline.B(sbU, this.maxPixelCount, ")");
    }
}
