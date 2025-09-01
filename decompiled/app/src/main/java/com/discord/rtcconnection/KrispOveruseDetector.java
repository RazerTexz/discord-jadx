package com.discord.rtcconnection;

import co.discord.media_engine.OutboundRtpAudio;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: KrispOveruseDetector.kt */
/* loaded from: classes.dex */
public final class KrispOveruseDetector {
    public OutboundRtpAudio a;

    /* renamed from: b, reason: collision with root package name */
    public OutboundRtpAudio f2770b;
    public int c;
    public final MediaEngineConnection d;

    /* compiled from: KrispOveruseDetector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/rtcconnection/KrispOveruseDetector$Status;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_OVERUSE", "FAILED", "VAD_CPU_OVERUSE", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum Status {
        CPU_OVERUSE,
        FAILED,
        VAD_CPU_OVERUSE
    }

    public KrispOveruseDetector(MediaEngineConnection mediaEngineConnection) {
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        this.d = mediaEngineConnection;
    }

    public final Tuples2<Boolean, Long> a(OutboundRtpAudio outboundRtpAudio, OutboundRtpAudio outboundRtpAudio2, double d) {
        if (outboundRtpAudio == null || outboundRtpAudio2 == null) {
            return new Tuples2<>(Boolean.FALSE, 0L);
        }
        long noiseCancellerProcessTime = outboundRtpAudio2.getNoiseCancellerProcessTime() - outboundRtpAudio.getNoiseCancellerProcessTime();
        long framesCaptured = outboundRtpAudio2.getFramesCaptured() - outboundRtpAudio.getFramesCaptured();
        if (framesCaptured == 0) {
            return new Tuples2<>(Boolean.FALSE, Long.valueOf(noiseCancellerProcessTime));
        }
        return new Tuples2<>(Boolean.valueOf(((double) noiseCancellerProcessTime) / ((double) framesCaptured) > d), Long.valueOf(noiseCancellerProcessTime));
    }
}
