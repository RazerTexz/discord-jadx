package co.discord.media_engine.internal;

import b.i.a.f.e.o.f;
import co.discord.media_engine.OutboundRtpAudio;
import co.discord.media_engine.OutboundRtpVideo;
import co.discord.media_engine.PlayoutMetric;
import co.discord.media_engine.Resolution;
import co.discord.media_engine.Stats;
import co.discord.media_engine.StatsCodec;
import com.google.gson.Gson;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.webrtc.MediaStreamTrack;

/* compiled from: TransformStats.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lco/discord/media_engine/internal/TransformStats;", "", "Lco/discord/media_engine/internal/RtpStats;", "rtpStats", "", "sumBytes", "(Lco/discord/media_engine/internal/RtpStats;)J", "sumPackets", "Lco/discord/media_engine/PlayoutMetric;", "metric", "convertPlayoutMetricToMs", "(Lco/discord/media_engine/PlayoutMetric;)Lco/discord/media_engine/PlayoutMetric;", "Lco/discord/media_engine/internal/InboundPlayout;", "playout", "transformPlayoutStats", "(Lco/discord/media_engine/internal/InboundPlayout;)Lco/discord/media_engine/internal/InboundPlayout;", "", "stats", "Lco/discord/media_engine/Stats;", "transform", "(Ljava/lang/String;)Lco/discord/media_engine/Stats;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TransformStats {
    public static final TransformStats INSTANCE = new TransformStats();
    private static final Gson gson = new Gson();

    private TransformStats() {
    }

    private final PlayoutMetric convertPlayoutMetricToMs(PlayoutMetric metric) {
        double d = 1000;
        return new PlayoutMetric(Math.rint(metric.getLast() * d), Math.rint(metric.getMean() * d), Math.rint(metric.getP75() * d), Math.rint(metric.getP95() * d), Math.rint(metric.getP99() * d), Math.rint(metric.getMax() * d));
    }

    private final long sumBytes(RtpStats rtpStats) {
        return rtpStats.getTransmitted().getPaddingBytes() + rtpStats.getTransmitted().getPayloadBytes() + rtpStats.getTransmitted().getHeaderBytes() + rtpStats.getRetransmitted().getPaddingBytes() + rtpStats.getRetransmitted().getPayloadBytes() + rtpStats.getRetransmitted().getHeaderBytes() + rtpStats.getFec().getPaddingBytes() + rtpStats.getFec().getPayloadBytes() + rtpStats.getFec().getHeaderBytes();
    }

    private final long sumPackets(RtpStats rtpStats) {
        return rtpStats.getTransmitted().getPackets() + rtpStats.getRetransmitted().getPackets() + rtpStats.getFec().getPackets();
    }

    public static final Stats transform(String stats) {
        long bytesSent;
        OutboundRtpAudio outboundRtpAudio;
        Substream substream;
        long j;
        OutboundRtpVideo outboundRtpVideo;
        long j2;
        Substream[] substreams;
        OutboundVideo[] videos;
        OutboundAudio audio;
        Intrinsics3.checkNotNullParameter(stats, "stats");
        NativeStats nativeStats = (NativeStats) f.E1(NativeStats.class).cast(gson.g(stats, NativeStats.class));
        Outbound outbound = nativeStats.getOutbound();
        if (outbound == null || (audio = outbound.getAudio()) == null) {
            bytesSent = 0;
            outboundRtpAudio = null;
        } else {
            bytesSent = audio.getBytesSent() + 0;
            long ssrc = audio.getSsrc();
            StatsCodec statsCodec = new StatsCodec(audio.getCodecPayloadType(), audio.getCodecName());
            long packetsSent = audio.getPacketsSent();
            int iMax = Math.max(0, audio.getPacketsLost());
            float fractionLost = audio.getFractionLost() * 100;
            float audioLevel = audio.getAudioLevel() / 32768.0f;
            boolean z2 = audio.getSpeaking() > 0;
            long framesCaptured = audio.getFramesCaptured();
            long framesRendered = audio.getFramesRendered();
            Boolean noiseCancellerIsEnabled = audio.getNoiseCancellerIsEnabled();
            boolean zBooleanValue = noiseCancellerIsEnabled != null ? noiseCancellerIsEnabled.booleanValue() : false;
            Long noiseCancellerProcessTime = audio.getNoiseCancellerProcessTime();
            long jLongValue = noiseCancellerProcessTime != null ? noiseCancellerProcessTime.longValue() : 0L;
            Boolean voiceActivityDetectorIsEnabled = audio.getVoiceActivityDetectorIsEnabled();
            boolean zBooleanValue2 = voiceActivityDetectorIsEnabled != null ? voiceActivityDetectorIsEnabled.booleanValue() : false;
            Long voiceActivityDetectorProcessTime = audio.getVoiceActivityDetectorProcessTime();
            outboundRtpAudio = new OutboundRtpAudio(MediaStreamTrack.AUDIO_TRACK_KIND, ssrc, statsCodec, bytesSent, packetsSent, iMax, fractionLost, audioLevel, z2, framesCaptured, framesRendered, zBooleanValue, jLongValue, zBooleanValue2, voiceActivityDetectorProcessTime != null ? voiceActivityDetectorProcessTime.longValue() : 0L);
        }
        Outbound outbound2 = nativeStats.getOutbound();
        OutboundVideo outboundVideo = (outbound2 == null || (videos = outbound2.getVideos()) == null) ? null : (OutboundVideo) _Arrays.firstOrNull(videos);
        if (outboundVideo == null || (substreams = outboundVideo.getSubstreams()) == null) {
            substream = null;
        } else {
            int length = substreams.length;
            for (int i = 0; i < length; i++) {
                substream = substreams[i];
                if ((substream.isFlexFEC() || substream.isRTX()) ? false : true) {
                    break;
                }
            }
            substream = null;
        }
        if (substream != null) {
            long jSumBytes = 0;
            for (Substream substream2 : outboundVideo.getSubstreams()) {
                jSumBytes += INSTANCE.sumBytes(substream2.getRtpStats());
            }
            long j3 = bytesSent + jSumBytes;
            long ssrc2 = substream.getSsrc();
            StatsCodec statsCodec2 = new StatsCodec(outboundVideo.getCodecPayloadType(), outboundVideo.getCodecName());
            long jSumPackets = 0;
            for (Substream substream3 : outboundVideo.getSubstreams()) {
                jSumPackets += INSTANCE.sumPackets(substream3.getRtpStats());
            }
            outboundRtpVideo = new OutboundRtpVideo(MediaStreamTrack.VIDEO_TRACK_KIND, ssrc2, statsCodec2, jSumBytes, jSumPackets, substream.getRtcpStats().getPacketsLost(), substream.getRtcpStats().getFractionLost(), outboundVideo.getMediaBitrate(), outboundVideo.getTargetMediaBitrate(), outboundVideo.getEncodeUsage(), outboundVideo.getEncoderImplementationName(), outboundVideo.getAvgEncodeTime(), new Resolution(substream.getWidth(), substream.getHeight()), substream.getFrameCounts().getKeyFrames() + substream.getFrameCounts().getDeltaFrames(), outboundVideo.getFramesEncoded(), outboundVideo.getInputFrameRate(), outboundVideo.getEncodeFrameRate(), substream.getRtcpStats().getFirPackets(), substream.getRtcpStats().getNackPackets(), substream.getRtcpStats().getPliPackets(), outboundVideo.getQpSum(), outboundVideo.getBwLimitedResolution(), outboundVideo.getCpuLimitedResolution());
            j = j3;
        } else {
            j = bytesSent;
            outboundRtpVideo = null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Inbound[] inbound = nativeStats.getInbound();
        if (inbound != null) {
            long j4 = 0;
            for (Inbound inbound2 : inbound) {
                String id2 = inbound2.getId();
                long bytesReceived = inbound2.getAudio().getBytesReceived() + j4;
                InboundAudio audio2 = inbound2.getAudio();
                InboundPlayout inboundPlayoutTransformPlayoutStats = inbound2.getPlayout() != null ? INSTANCE.transformPlayoutStats(inbound2.getPlayout()) : null;
                if (inbound2.getVideo() != null) {
                    InboundVideo video = inbound2.getVideo();
                    long payloadBytes = video.getRtpStats().getPayloadBytes() + video.getRtpStats().getPaddingBytes() + video.getRtpStats().getHeaderBytes();
                    bytesReceived += payloadBytes;
                }
                j4 = bytesReceived;
            }
            j2 = j4;
        } else {
            j2 = 0;
        }
        Transport transport = nativeStats.getTransport();
        return new Stats(transport != null ? new co.discord.media_engine.Transport(transport.getSendBandwidth(), j2, j, transport.getRtt(), Integer.valueOf((int) transport.getDecryptionFailures()), transport.getLocalAddress(), transport.getReceiverReports()) : new co.discord.media_engine.Transport(0, j2, j, 0, 0, "", null), outboundRtpAudio, outboundRtpVideo, linkedHashMap, linkedHashMap2);
    }

    private final InboundPlayout transformPlayoutStats(InboundPlayout playout) {
        return new InboundPlayout(convertPlayoutMetricToMs(playout.getAudioJitterBuffer()), convertPlayoutMetricToMs(playout.getAudioJitterDelay()), convertPlayoutMetricToMs(playout.getAudioJitterTarget()), convertPlayoutMetricToMs(playout.getAudioPlayoutUnderruns()), convertPlayoutMetricToMs(playout.getAudioCaptureOverruns()), convertPlayoutMetricToMs(playout.getVideoJitterBuffer()), convertPlayoutMetricToMs(playout.getVideoJitterDelay()), convertPlayoutMetricToMs(playout.getVideoJitterTarget()), convertPlayoutMetricToMs(playout.getRelativeReceptionDelay()), convertPlayoutMetricToMs(playout.getRelativePlayoutDelay()));
    }
}
