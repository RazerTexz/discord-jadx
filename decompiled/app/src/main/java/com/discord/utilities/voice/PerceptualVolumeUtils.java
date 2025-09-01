package com.discord.utilities.voice;

import kotlin.Metadata;

/* compiled from: PerceptualVolumeUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/voice/PerceptualVolumeUtils;", "", "", "perceptual", "normalizedMax", "perceptualToAmplitude", "(FF)F", "amplitude", "amplitudeToPerceptual", "VOLUME_BOOST_DYNAMIC_RANGE_DB", "F", "VOLUME_DYNAMIC_RANGE_DB", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PerceptualVolumeUtils {
    public static final PerceptualVolumeUtils INSTANCE = new PerceptualVolumeUtils();
    private static final float VOLUME_BOOST_DYNAMIC_RANGE_DB = 6.0f;
    private static final float VOLUME_DYNAMIC_RANGE_DB = 50.0f;

    private PerceptualVolumeUtils() {
    }

    public static /* synthetic */ float amplitudeToPerceptual$default(PerceptualVolumeUtils perceptualVolumeUtils, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 100.0f;
        }
        return perceptualVolumeUtils.amplitudeToPerceptual(f, f2);
    }

    public static /* synthetic */ float perceptualToAmplitude$default(PerceptualVolumeUtils perceptualVolumeUtils, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 100.0f;
        }
        return perceptualVolumeUtils.perceptualToAmplitude(f, f2);
    }

    public final float amplitudeToPerceptual(float amplitude, float normalizedMax) {
        if (amplitude <= 0.0f) {
            return 0.0f;
        }
        float fLog10 = ((float) Math.log10(amplitude / normalizedMax)) * 20.0f;
        return normalizedMax * (fLog10 > 0.0f ? (fLog10 / VOLUME_BOOST_DYNAMIC_RANGE_DB) + 1.0f : (fLog10 + 50.0f) / 50.0f);
    }

    public final float perceptualToAmplitude(float perceptual, float normalizedMax) {
        if (perceptual <= 0.0f) {
            return 0.0f;
        }
        return normalizedMax * ((float) Math.pow(10.0f, (perceptual > normalizedMax ? ((perceptual - normalizedMax) / normalizedMax) * VOLUME_BOOST_DYNAMIC_RANGE_DB : ((perceptual / normalizedMax) * 50.0f) - 50.0f) / 20.0f));
    }
}
