package co.discord.media_engine.internal;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import org.webrtc.MediaStreamTrack;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ<\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\nR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\r¨\u0006&"}, d2 = {"Lco/discord/media_engine/internal/Inbound;", "", "", "component1", "()Ljava/lang/String;", "Lco/discord/media_engine/internal/InboundAudio;", "component2", "()Lco/discord/media_engine/internal/InboundAudio;", "Lco/discord/media_engine/internal/InboundVideo;", "component3", "()Lco/discord/media_engine/internal/InboundVideo;", "Lco/discord/media_engine/internal/InboundPlayout;", "component4", "()Lco/discord/media_engine/internal/InboundPlayout;", ModelAuditLogEntry.CHANGE_KEY_ID, MediaStreamTrack.AUDIO_TRACK_KIND, MediaStreamTrack.VIDEO_TRACK_KIND, "playout", "copy", "(Ljava/lang/String;Lco/discord/media_engine/internal/InboundAudio;Lco/discord/media_engine/internal/InboundVideo;Lco/discord/media_engine/internal/InboundPlayout;)Lco/discord/media_engine/internal/Inbound;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Lco/discord/media_engine/internal/InboundAudio;", "getAudio", "Lco/discord/media_engine/internal/InboundVideo;", "getVideo", "Lco/discord/media_engine/internal/InboundPlayout;", "getPlayout", "<init>", "(Ljava/lang/String;Lco/discord/media_engine/internal/InboundAudio;Lco/discord/media_engine/internal/InboundVideo;Lco/discord/media_engine/internal/InboundPlayout;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Inbound {
    private final InboundAudio audio;
    private final String id;
    private final InboundPlayout playout;
    private final InboundVideo video;

    public Inbound(String str, InboundAudio inboundAudio, InboundVideo inboundVideo, InboundPlayout inboundPlayout) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(inboundAudio, MediaStreamTrack.AUDIO_TRACK_KIND);
        this.id = str;
        this.audio = inboundAudio;
        this.video = inboundVideo;
        this.playout = inboundPlayout;
    }

    public static /* synthetic */ Inbound copy$default(Inbound inbound, String str, InboundAudio inboundAudio, InboundVideo inboundVideo, InboundPlayout inboundPlayout, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inbound.id;
        }
        if ((i & 2) != 0) {
            inboundAudio = inbound.audio;
        }
        if ((i & 4) != 0) {
            inboundVideo = inbound.video;
        }
        if ((i & 8) != 0) {
            inboundPlayout = inbound.playout;
        }
        return inbound.copy(str, inboundAudio, inboundVideo, inboundPlayout);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final InboundAudio getAudio() {
        return this.audio;
    }

    /* renamed from: component3, reason: from getter */
    public final InboundVideo getVideo() {
        return this.video;
    }

    /* renamed from: component4, reason: from getter */
    public final InboundPlayout getPlayout() {
        return this.playout;
    }

    public final Inbound copy(String id2, InboundAudio audio, InboundVideo video, InboundPlayout playout) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(audio, MediaStreamTrack.AUDIO_TRACK_KIND);
        return new Inbound(id2, audio, video, playout);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Inbound)) {
            return false;
        }
        Inbound inbound = (Inbound) other;
        return Intrinsics3.areEqual(this.id, inbound.id) && Intrinsics3.areEqual(this.audio, inbound.audio) && Intrinsics3.areEqual(this.video, inbound.video) && Intrinsics3.areEqual(this.playout, inbound.playout);
    }

    public final InboundAudio getAudio() {
        return this.audio;
    }

    public final String getId() {
        return this.id;
    }

    public final InboundPlayout getPlayout() {
        return this.playout;
    }

    public final InboundVideo getVideo() {
        return this.video;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        InboundAudio inboundAudio = this.audio;
        int iHashCode2 = (iHashCode + (inboundAudio != null ? inboundAudio.hashCode() : 0)) * 31;
        InboundVideo inboundVideo = this.video;
        int iHashCode3 = (iHashCode2 + (inboundVideo != null ? inboundVideo.hashCode() : 0)) * 31;
        InboundPlayout inboundPlayout = this.playout;
        return iHashCode3 + (inboundPlayout != null ? inboundPlayout.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Inbound(id=");
        sbU.append(this.id);
        sbU.append(", audio=");
        sbU.append(this.audio);
        sbU.append(", video=");
        sbU.append(this.video);
        sbU.append(", playout=");
        sbU.append(this.playout);
        sbU.append(")");
        return sbU.toString();
    }
}
