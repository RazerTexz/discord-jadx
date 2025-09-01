package co.discord.media_engine;

import android.content.Context;
import android.util.AttributeSet;
import com.hammerandchisel.libdiscord.Discord;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;

/* compiled from: VideoStreamRenderer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013J-\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lco/discord/media_engine/VideoStreamRenderer;", "Lorg/webrtc/SurfaceViewRenderer;", "Lcom/hammerandchisel/libdiscord/Discord;", "discord", "", "streamId", "Lorg/webrtc/RendererCommon$RendererEvents;", "events", "", "attachToStream", "(Lcom/hammerandchisel/libdiscord/Discord;Ljava/lang/String;Lorg/webrtc/RendererCommon$RendererEvents;)V", "streamIdentifier", "Ljava/lang/String;", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Muxer", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class VideoStreamRenderer extends SurfaceViewRenderer {
    private static final Muxer Muxer = new Muxer(null);

    @Deprecated
    private static Map<String, Set<VideoStreamRenderer>> streams = new LinkedHashMap();
    private String streamIdentifier;

    /* compiled from: VideoStreamRenderer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nR(\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lco/discord/media_engine/VideoStreamRenderer$Muxer;", "", "Lcom/hammerandchisel/libdiscord/Discord;", "discord", "Lco/discord/media_engine/VideoStreamRenderer;", "sink", "", "streamId", "", "removeSink", "(Lcom/hammerandchisel/libdiscord/Discord;Lco/discord/media_engine/VideoStreamRenderer;Ljava/lang/String;)V", "addSink", "", "", "streams", "Ljava/util/Map;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Muxer {
        private Muxer() {
        }

        public final void addSink(Discord discord, VideoStreamRenderer sink, String streamId) {
            Intrinsics3.checkNotNullParameter(discord, "discord");
            Intrinsics3.checkNotNullParameter(sink, "sink");
            Intrinsics3.checkNotNullParameter(streamId, "streamId");
            synchronized (VideoStreamRenderer.access$getStreams$cp()) {
                VideoStreamRenderer.access$Muxer();
                Set set = (Set) VideoStreamRenderer.access$getStreams$cp().get(streamId);
                if (set != null) {
                    synchronized (set) {
                        set.add(sink);
                    }
                } else {
                    Set setMutableSetOf = Sets5.mutableSetOf(sink);
                    discord.setVideoOutputSink(streamId, new VideoStreamRenderer2(setMutableSetOf));
                    VideoStreamRenderer.access$Muxer();
                    VideoStreamRenderer.access$getStreams$cp().put(streamId, setMutableSetOf);
                }
            }
        }

        public final void removeSink(Discord discord, VideoStreamRenderer sink, String streamId) {
            Intrinsics3.checkNotNullParameter(discord, "discord");
            Intrinsics3.checkNotNullParameter(sink, "sink");
            Intrinsics3.checkNotNullParameter(streamId, "streamId");
            synchronized (VideoStreamRenderer.access$getStreams$cp()) {
                VideoStreamRenderer.access$Muxer();
                Set set = (Set) VideoStreamRenderer.access$getStreams$cp().get(streamId);
                if (set != null) {
                    synchronized (set) {
                        set.remove(sink);
                        if (set.isEmpty()) {
                            discord.setVideoOutputSink(streamId, null);
                            VideoStreamRenderer.access$Muxer();
                            VideoStreamRenderer.access$getStreams$cp().remove(streamId);
                        }
                    }
                }
            }
        }

        public /* synthetic */ Muxer(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoStreamRenderer(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        this.streamIdentifier = "";
    }

    public static final /* synthetic */ Muxer access$Muxer() {
        return Muxer;
    }

    public static final /* synthetic */ Map access$getStreams$cp() {
        return streams;
    }

    public static final /* synthetic */ void access$setStreams$cp(Map map) {
        streams = map;
    }

    public static /* synthetic */ void attachToStream$default(VideoStreamRenderer videoStreamRenderer, Discord discord, String str, RendererCommon.RendererEvents rendererEvents, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToStream");
        }
        if ((i & 4) != 0) {
            rendererEvents = null;
        }
        videoStreamRenderer.attachToStream(discord, str, rendererEvents);
    }

    public final void attachToStream(Discord discord, String streamId, RendererCommon.RendererEvents events) {
        if (discord == null) {
            return;
        }
        if (!(this.streamIdentifier.length() == 0)) {
            super.clearImage();
            super.release();
            Muxer.removeSink(discord, this, this.streamIdentifier);
        }
        if (streamId == null) {
            streamId = "";
        }
        this.streamIdentifier = streamId;
        if (streamId.length() == 0) {
            return;
        }
        super.init(SharedEglBaseContext.getEglContext(), events);
        Muxer.addSink(discord, this, this.streamIdentifier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoStreamRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.streamIdentifier = "";
    }
}
