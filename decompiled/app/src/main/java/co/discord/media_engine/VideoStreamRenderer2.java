package co.discord.media_engine;

import com.hammerandchisel.libdiscord.Discord;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;
import org.webrtc.VideoFrame;

/* compiled from: VideoStreamRenderer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lorg/webrtc/VideoFrame;", "frame", "", "onFrame", "(Lorg/webrtc/VideoFrame;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.VideoStreamRenderer$Muxer$addSink$1$2, reason: use source file name */
/* loaded from: classes.dex */
public final class VideoStreamRenderer2 implements Discord.VideoFrameCallback {
    public final /* synthetic */ Set $sinks;

    public VideoStreamRenderer2(Set set) {
        this.$sinks = set;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.VideoFrameCallback
    public final boolean onFrame(VideoFrame videoFrame) {
        Intrinsics3.checkNotNullParameter(videoFrame, "frame");
        synchronized (this.$sinks) {
            VideoStreamRenderer videoStreamRenderer = (VideoStreamRenderer) _Collections.firstOrNull(this.$sinks);
            if (videoStreamRenderer != null) {
                videoStreamRenderer.onFrame(videoFrame);
            }
            videoFrame.release();
        }
        return true;
    }
}
