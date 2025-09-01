package co.discord.media_engine.internal;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J,\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\b\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0007\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005R\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lco/discord/media_engine/internal/FrameCounts;", "", "", "Lco/discord/media_engine/internal/I32;", "component1", "()I", "component2", "deltaFrames", "keyFrames", "copy", "(II)Lco/discord/media_engine/internal/FrameCounts;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getDeltaFrames", "getKeyFrames", "<init>", "(II)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class FrameCounts {
    private final int deltaFrames;
    private final int keyFrames;

    public FrameCounts(int i, int i2) {
        this.deltaFrames = i;
        this.keyFrames = i2;
    }

    public static /* synthetic */ FrameCounts copy$default(FrameCounts frameCounts, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = frameCounts.deltaFrames;
        }
        if ((i3 & 2) != 0) {
            i2 = frameCounts.keyFrames;
        }
        return frameCounts.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDeltaFrames() {
        return this.deltaFrames;
    }

    /* renamed from: component2, reason: from getter */
    public final int getKeyFrames() {
        return this.keyFrames;
    }

    public final FrameCounts copy(int deltaFrames, int keyFrames) {
        return new FrameCounts(deltaFrames, keyFrames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrameCounts)) {
            return false;
        }
        FrameCounts frameCounts = (FrameCounts) other;
        return this.deltaFrames == frameCounts.deltaFrames && this.keyFrames == frameCounts.keyFrames;
    }

    public final int getDeltaFrames() {
        return this.deltaFrames;
    }

    public final int getKeyFrames() {
        return this.keyFrames;
    }

    public int hashCode() {
        return (this.deltaFrames * 31) + this.keyFrames;
    }

    public String toString() {
        StringBuilder sbU = outline.U("FrameCounts(deltaFrames=");
        sbU.append(this.deltaFrames);
        sbU.append(", keyFrames=");
        return outline.B(sbU, this.keyFrames, ")");
    }
}
