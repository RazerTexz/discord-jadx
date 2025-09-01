package co.discord.media_engine.internal;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;
import org.webrtc.MediaStreamTrack;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b¨\u0006!"}, d2 = {"Lco/discord/media_engine/internal/Outbound;", "", "", "component1", "()Ljava/lang/String;", "Lco/discord/media_engine/internal/OutboundAudio;", "component2", "()Lco/discord/media_engine/internal/OutboundAudio;", "", "Lco/discord/media_engine/internal/OutboundVideo;", "component3", "()[Lco/discord/media_engine/internal/OutboundVideo;", ModelAuditLogEntry.CHANGE_KEY_ID, MediaStreamTrack.AUDIO_TRACK_KIND, "videos", "copy", "(Ljava/lang/String;Lco/discord/media_engine/internal/OutboundAudio;[Lco/discord/media_engine/internal/OutboundVideo;)Lco/discord/media_engine/internal/Outbound;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Lco/discord/media_engine/internal/OutboundAudio;", "getAudio", "[Lco/discord/media_engine/internal/OutboundVideo;", "getVideos", "<init>", "(Ljava/lang/String;Lco/discord/media_engine/internal/OutboundAudio;[Lco/discord/media_engine/internal/OutboundVideo;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Outbound {
    private final OutboundAudio audio;
    private final String id;
    private final OutboundVideo[] videos;

    public Outbound(String str, OutboundAudio outboundAudio, OutboundVideo[] outboundVideoArr) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        this.id = str;
        this.audio = outboundAudio;
        this.videos = outboundVideoArr;
    }

    public static /* synthetic */ Outbound copy$default(Outbound outbound, String str, OutboundAudio outboundAudio, OutboundVideo[] outboundVideoArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = outbound.id;
        }
        if ((i & 2) != 0) {
            outboundAudio = outbound.audio;
        }
        if ((i & 4) != 0) {
            outboundVideoArr = outbound.videos;
        }
        return outbound.copy(str, outboundAudio, outboundVideoArr);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final OutboundAudio getAudio() {
        return this.audio;
    }

    /* renamed from: component3, reason: from getter */
    public final OutboundVideo[] getVideos() {
        return this.videos;
    }

    public final Outbound copy(String id2, OutboundAudio audio, OutboundVideo[] videos) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        return new Outbound(id2, audio, videos);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Outbound)) {
            return false;
        }
        Outbound outbound = (Outbound) other;
        return Intrinsics3.areEqual(this.id, outbound.id) && Intrinsics3.areEqual(this.audio, outbound.audio) && Intrinsics3.areEqual(this.videos, outbound.videos);
    }

    public final OutboundAudio getAudio() {
        return this.audio;
    }

    public final String getId() {
        return this.id;
    }

    public final OutboundVideo[] getVideos() {
        return this.videos;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        OutboundAudio outboundAudio = this.audio;
        int iHashCode2 = (iHashCode + (outboundAudio != null ? outboundAudio.hashCode() : 0)) * 31;
        OutboundVideo[] outboundVideoArr = this.videos;
        return iHashCode2 + (outboundVideoArr != null ? Arrays.hashCode(outboundVideoArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Outbound(id=");
        sbU.append(this.id);
        sbU.append(", audio=");
        sbU.append(this.audio);
        sbU.append(", videos=");
        sbU.append(Arrays.toString(this.videos));
        sbU.append(")");
        return sbU.toString();
    }
}
