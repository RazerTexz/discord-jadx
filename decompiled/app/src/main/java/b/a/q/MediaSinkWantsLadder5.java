package b.a.q;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: MediaSinkWantsLadder.kt */
/* renamed from: b.a.q.j0, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaSinkWantsLadder5 {
    public final MediaSinkWantsLadder2 a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaSinkWantsLadder2 f260b;
    public final MediaSinkWantsLadder c;
    public final int d;
    public final MediaSinkWantsLadder e;

    public MediaSinkWantsLadder5(MediaSinkWantsLadder2 mediaSinkWantsLadder2, MediaSinkWantsLadder2 mediaSinkWantsLadder22, MediaSinkWantsLadder mediaSinkWantsLadder, int i, MediaSinkWantsLadder mediaSinkWantsLadder3) {
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder2, "videoBudget");
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder22, "videoCapture");
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder, "videoBitrate");
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder3, "desktopBitrate");
        this.a = mediaSinkWantsLadder2;
        this.f260b = mediaSinkWantsLadder22;
        this.c = mediaSinkWantsLadder;
        this.d = i;
        this.e = mediaSinkWantsLadder3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSinkWantsLadder5)) {
            return false;
        }
        MediaSinkWantsLadder5 mediaSinkWantsLadder5 = (MediaSinkWantsLadder5) obj;
        return Intrinsics3.areEqual(this.a, mediaSinkWantsLadder5.a) && Intrinsics3.areEqual(this.f260b, mediaSinkWantsLadder5.f260b) && Intrinsics3.areEqual(this.c, mediaSinkWantsLadder5.c) && this.d == mediaSinkWantsLadder5.d && Intrinsics3.areEqual(this.e, mediaSinkWantsLadder5.e);
    }

    public int hashCode() {
        MediaSinkWantsLadder2 mediaSinkWantsLadder2 = this.a;
        int iHashCode = (mediaSinkWantsLadder2 != null ? mediaSinkWantsLadder2.hashCode() : 0) * 31;
        MediaSinkWantsLadder2 mediaSinkWantsLadder22 = this.f260b;
        int iHashCode2 = (iHashCode + (mediaSinkWantsLadder22 != null ? mediaSinkWantsLadder22.hashCode() : 0)) * 31;
        MediaSinkWantsLadder mediaSinkWantsLadder = this.c;
        int iHashCode3 = (((iHashCode2 + (mediaSinkWantsLadder != null ? mediaSinkWantsLadder.hashCode() : 0)) * 31) + this.d) * 31;
        MediaSinkWantsLadder mediaSinkWantsLadder3 = this.e;
        return iHashCode3 + (mediaSinkWantsLadder3 != null ? mediaSinkWantsLadder3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("VideoQualityManagerOptions(videoBudget=");
        sbU.append(this.a);
        sbU.append(", videoCapture=");
        sbU.append(this.f260b);
        sbU.append(", videoBitrate=");
        sbU.append(this.c);
        sbU.append(", videoBitrateFloor=");
        sbU.append(this.d);
        sbU.append(", desktopBitrate=");
        sbU.append(this.e);
        sbU.append(")");
        return sbU.toString();
    }
}
