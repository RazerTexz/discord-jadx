package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNetworkMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackNetworkMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "errorCode", "Ljava/lang/Long;", "getErrorCode", "()Ljava/lang/Long;", "", "url", "Ljava/lang/CharSequence;", "getUrl", "()Ljava/lang/CharSequence;", "requestMethod", "getRequestMethod", "statusCode", "getStatusCode", "errorMessage", "getErrorMessage", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/CharSequence;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkMetadata {
    private final Long errorCode;
    private final CharSequence errorMessage;
    private final CharSequence requestMethod;
    private final Long statusCode;
    private final CharSequence url;

    public TrackNetworkMetadata() {
        this(null, null, null, null, null, 31);
    }

    public TrackNetworkMetadata(CharSequence charSequence, CharSequence charSequence2, Long l, Long l2, CharSequence charSequence3) {
        this.url = charSequence;
        this.requestMethod = charSequence2;
        this.statusCode = l;
        this.errorCode = l2;
        this.errorMessage = charSequence3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkMetadata)) {
            return false;
        }
        TrackNetworkMetadata trackNetworkMetadata = (TrackNetworkMetadata) other;
        return Intrinsics3.areEqual(this.url, trackNetworkMetadata.url) && Intrinsics3.areEqual(this.requestMethod, trackNetworkMetadata.requestMethod) && Intrinsics3.areEqual(this.statusCode, trackNetworkMetadata.statusCode) && Intrinsics3.areEqual(this.errorCode, trackNetworkMetadata.errorCode) && Intrinsics3.areEqual(this.errorMessage, trackNetworkMetadata.errorMessage);
    }

    public int hashCode() {
        CharSequence charSequence = this.url;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.requestMethod;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.statusCode;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.errorCode;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.errorMessage;
        return iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkMetadata(url=");
        sbU.append(this.url);
        sbU.append(", requestMethod=");
        sbU.append(this.requestMethod);
        sbU.append(", statusCode=");
        sbU.append(this.statusCode);
        sbU.append(", errorCode=");
        sbU.append(this.errorCode);
        sbU.append(", errorMessage=");
        return outline.E(sbU, this.errorMessage, ")");
    }

    public TrackNetworkMetadata(CharSequence charSequence, CharSequence charSequence2, Long l, Long l2, CharSequence charSequence3, int i) {
        charSequence = (i & 1) != 0 ? null : charSequence;
        charSequence2 = (i & 2) != 0 ? null : charSequence2;
        l = (i & 4) != 0 ? null : l;
        int i2 = i & 8;
        charSequence3 = (i & 16) != 0 ? null : charSequence3;
        this.url = charSequence;
        this.requestMethod = charSequence2;
        this.statusCode = l;
        this.errorCode = null;
        this.errorMessage = charSequence3;
    }
}
