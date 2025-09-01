package co.discord.media_engine.internal;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005JH\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0005R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001a\u0010\u0005R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, d2 = {"Lco/discord/media_engine/internal/Screenshare;", "", "", "Lco/discord/media_engine/internal/I32;", "component1", "()I", "component2", "component3", "component4", "capturedFramesDropped", "capturedFramesCount", "capturedFramesMean", "capturedFramesStdev", "copy", "(IIII)Lco/discord/media_engine/internal/Screenshare;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCapturedFramesCount", "getCapturedFramesMean", "getCapturedFramesStdev", "getCapturedFramesDropped", "<init>", "(IIII)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Screenshare {
    private final int capturedFramesCount;
    private final int capturedFramesDropped;
    private final int capturedFramesMean;
    private final int capturedFramesStdev;

    public Screenshare(int i, int i2, int i3, int i4) {
        this.capturedFramesDropped = i;
        this.capturedFramesCount = i2;
        this.capturedFramesMean = i3;
        this.capturedFramesStdev = i4;
    }

    public static /* synthetic */ Screenshare copy$default(Screenshare screenshare, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = screenshare.capturedFramesDropped;
        }
        if ((i5 & 2) != 0) {
            i2 = screenshare.capturedFramesCount;
        }
        if ((i5 & 4) != 0) {
            i3 = screenshare.capturedFramesMean;
        }
        if ((i5 & 8) != 0) {
            i4 = screenshare.capturedFramesStdev;
        }
        return screenshare.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCapturedFramesDropped() {
        return this.capturedFramesDropped;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCapturedFramesCount() {
        return this.capturedFramesCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCapturedFramesMean() {
        return this.capturedFramesMean;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCapturedFramesStdev() {
        return this.capturedFramesStdev;
    }

    public final Screenshare copy(int capturedFramesDropped, int capturedFramesCount, int capturedFramesMean, int capturedFramesStdev) {
        return new Screenshare(capturedFramesDropped, capturedFramesCount, capturedFramesMean, capturedFramesStdev);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Screenshare)) {
            return false;
        }
        Screenshare screenshare = (Screenshare) other;
        return this.capturedFramesDropped == screenshare.capturedFramesDropped && this.capturedFramesCount == screenshare.capturedFramesCount && this.capturedFramesMean == screenshare.capturedFramesMean && this.capturedFramesStdev == screenshare.capturedFramesStdev;
    }

    public final int getCapturedFramesCount() {
        return this.capturedFramesCount;
    }

    public final int getCapturedFramesDropped() {
        return this.capturedFramesDropped;
    }

    public final int getCapturedFramesMean() {
        return this.capturedFramesMean;
    }

    public final int getCapturedFramesStdev() {
        return this.capturedFramesStdev;
    }

    public int hashCode() {
        return (((((this.capturedFramesDropped * 31) + this.capturedFramesCount) * 31) + this.capturedFramesMean) * 31) + this.capturedFramesStdev;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Screenshare(capturedFramesDropped=");
        sbU.append(this.capturedFramesDropped);
        sbU.append(", capturedFramesCount=");
        sbU.append(this.capturedFramesCount);
        sbU.append(", capturedFramesMean=");
        sbU.append(this.capturedFramesMean);
        sbU.append(", capturedFramesStdev=");
        return outline.B(sbU, this.capturedFramesStdev, ")");
    }
}
