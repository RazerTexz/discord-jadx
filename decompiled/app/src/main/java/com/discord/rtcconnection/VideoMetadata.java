package com.discord.rtcconnection;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.rtcconnection.socket.io.Payloads;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: VideoMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\u001e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/discord/rtcconnection/VideoMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "a", "J", "getUserID", "()J", "userID", "Lcom/discord/rtcconnection/socket/io/Payloads$ResolutionType;", "e", "Lcom/discord/rtcconnection/socket/io/Payloads$ResolutionType;", "getType", "()Lcom/discord/rtcconnection/socket/io/Payloads$ResolutionType;", "type", "b", "I", "getMaxWidth", "maxWidth", "c", "getMaxHeight", "maxHeight", "d", "Ljava/lang/Integer;", "getMaxFrameRate", "()Ljava/lang/Integer;", "maxFrameRate", "<init>", "(JIILjava/lang/Integer;Lcom/discord/rtcconnection/socket/io/Payloads$ResolutionType;)V", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class VideoMetadata {

    /* renamed from: a, reason: from kotlin metadata */
    public final long userID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int maxWidth;

    /* renamed from: c, reason: from kotlin metadata */
    public final int maxHeight;

    /* renamed from: d, reason: from kotlin metadata */
    public final Integer maxFrameRate;

    /* renamed from: e, reason: from kotlin metadata */
    public final Payloads.ResolutionType type;

    public VideoMetadata(long j, int i, int i2, Integer num, Payloads.ResolutionType resolutionType) {
        Intrinsics3.checkNotNullParameter(resolutionType, "type");
        this.userID = j;
        this.maxWidth = i;
        this.maxHeight = i2;
        this.maxFrameRate = num;
        this.type = resolutionType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoMetadata)) {
            return false;
        }
        VideoMetadata videoMetadata = (VideoMetadata) other;
        return this.userID == videoMetadata.userID && this.maxWidth == videoMetadata.maxWidth && this.maxHeight == videoMetadata.maxHeight && Intrinsics3.areEqual(this.maxFrameRate, videoMetadata.maxFrameRate) && Intrinsics3.areEqual(this.type, videoMetadata.type);
    }

    public int hashCode() {
        int iA = ((((b.a(this.userID) * 31) + this.maxWidth) * 31) + this.maxHeight) * 31;
        Integer num = this.maxFrameRate;
        int iHashCode = (iA + (num != null ? num.hashCode() : 0)) * 31;
        Payloads.ResolutionType resolutionType = this.type;
        return iHashCode + (resolutionType != null ? resolutionType.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("VideoMetadata(userID=");
        sbU.append(this.userID);
        sbU.append(", maxWidth=");
        sbU.append(this.maxWidth);
        sbU.append(", maxHeight=");
        sbU.append(this.maxHeight);
        sbU.append(", maxFrameRate=");
        sbU.append(this.maxFrameRate);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(")");
        return sbU.toString();
    }
}
