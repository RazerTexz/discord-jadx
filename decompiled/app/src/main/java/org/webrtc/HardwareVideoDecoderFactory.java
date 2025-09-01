package org.webrtc;

import android.media.MediaCodecInfo;
import androidx.annotation.Nullable;
import org.webrtc.EglBase;
import org.webrtc.Predicate;

/* loaded from: classes3.dex */
public class HardwareVideoDecoderFactory extends MediaCodecVideoDecoderFactory {
    private static final Predicate<MediaCodecInfo> defaultAllowedPredicate = new AnonymousClass1();

    /* renamed from: org.webrtc.HardwareVideoDecoderFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements Predicate<MediaCodecInfo> {
        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> and(Predicate<? super MediaCodecInfo> predicate) {
            return Predicate.CC.a(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> negate() {
            return Predicate.CC.b(this);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate<MediaCodecInfo> or(Predicate<? super MediaCodecInfo> predicate) {
            return Predicate.CC.c(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* bridge */ /* synthetic */ boolean test(MediaCodecInfo mediaCodecInfo) {
            return test2(mediaCodecInfo);
        }

        /* renamed from: test, reason: avoid collision after fix types in other method */
        public boolean test2(MediaCodecInfo mediaCodecInfo) {
            return MediaCodecUtils.isHardwareAccelerated(mediaCodecInfo);
        }
    }

    @Deprecated
    public HardwareVideoDecoderFactory() {
        this(null);
    }

    @Override // org.webrtc.MediaCodecVideoDecoderFactory, org.webrtc.VideoDecoderFactory
    @Nullable
    public /* bridge */ /* synthetic */ VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        return super.createDecoder(videoCodecInfo);
    }

    @Override // org.webrtc.MediaCodecVideoDecoderFactory, org.webrtc.VideoDecoderFactory
    public /* bridge */ /* synthetic */ VideoCodecInfo[] getSupportedCodecs() {
        return super.getSupportedCodecs();
    }

    public HardwareVideoDecoderFactory(@Nullable EglBase.Context context) {
        this(context, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HardwareVideoDecoderFactory(@Nullable EglBase.Context context, @Nullable Predicate<MediaCodecInfo> predicate) {
        Predicate<MediaCodecInfo> predicateAnd;
        if (predicate == null) {
            predicateAnd = defaultAllowedPredicate;
        } else {
            predicateAnd = predicate.and(defaultAllowedPredicate);
        }
        super(context, predicateAnd);
    }
}
