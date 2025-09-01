package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackCallReportProblem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010\u001c\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001b\u0010%\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010\u0017R\u001b\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u001b\u0010)\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b*\u0010\"R\u001b\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010\u0012R\u001b\u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017R\u001b\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00104\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010 \u001a\u0004\b5\u0010\"R\u001b\u00106\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b7\u0010\u0012R\u001b\u00108\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b9\u0010\u0012R\u001b\u0010:\u001a\u0004\u0018\u00010/8\u0006@\u0006¢\u0006\f\n\u0004\b:\u00101\u001a\u0004\b;\u00103R\u001b\u0010<\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0010\u001a\u0004\b=\u0010\u0012R$\u0010?\u001a\u0004\u0018\u00010>8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001b\u0010E\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bF\u0010\u0012R\u001b\u0010G\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0010\u001a\u0004\bH\u0010\u0012R\u001b\u0010I\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\u0015\u001a\u0004\bJ\u0010\u0017R\u001b\u0010K\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010\u0010\u001a\u0004\bL\u0010\u0012R\u001b\u0010M\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010 \u001a\u0004\bN\u0010\"R\u001b\u0010O\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010 \u001a\u0004\bP\u0010\"R\u001b\u0010Q\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010\u0010\u001a\u0004\bR\u0010\u0012R\u001b\u0010S\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010\u0015\u001a\u0004\bT\u0010\u0017R\u001b\u0010U\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u0015\u001a\u0004\bV\u0010\u0017R\u001b\u0010W\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010 \u001a\u0004\bX\u0010\"¨\u0006Y"}, d2 = {"Lcom/discord/analytics/generated/events/TrackCallReportProblem;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "outputDeviceName", "Ljava/lang/CharSequence;", "getOutputDeviceName", "()Ljava/lang/CharSequence;", "", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "duration", "getDuration", "audioOutputMode", "getAudioOutputMode", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "videoEnabled", "Ljava/lang/Boolean;", "getVideoEnabled", "()Ljava/lang/Boolean;", "inputDeviceName", "getInputDeviceName", "channelType", "getChannelType", "videoHardwareScalingEnabled", "getVideoHardwareScalingEnabled", "noiseSuppressionEnabled", "getNoiseSuppressionEnabled", "mediaSessionId", "getMediaSessionId", "voiceStateCount", "getVoiceStateCount", "", "voiceOutputVolume", "Ljava/lang/Float;", "getVoiceOutputVolume", "()Ljava/lang/Float;", "automaticAudioInputSensitivityEnabled", "getAutomaticAudioInputSensitivityEnabled", "videoDeviceName", "getVideoDeviceName", "rating", "getRating", "audioInputSensitivity", "getAudioInputSensitivity", "audioInputMode", "getAudioInputMode", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "rtcConnectionId", "getRtcConnectionId", "feedback", "getFeedback", "channelId", "getChannelId", "reasonDescription", "getReasonDescription", "echoCancellationEnabled", "getEchoCancellationEnabled", "noiseCancellationEnabled", "getNoiseCancellationEnabled", "audioMode", "getAudioMode", "reasonCode", "getReasonCode", "videoStreamCount", "getVideoStreamCount", "automaticGainControlEnabled", "getAutomaticGainControlEnabled", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackCallReportProblem implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final CharSequence rtcConnectionId = null;
    private final Long duration = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rating = null;
    private final CharSequence feedback = null;
    private final Long reasonCode = null;
    private final CharSequence reasonDescription = null;
    private final CharSequence audioInputMode = null;
    private final Boolean automaticAudioInputSensitivityEnabled = null;
    private final Float audioInputSensitivity = null;
    private final Boolean echoCancellationEnabled = null;
    private final Boolean noiseSuppressionEnabled = null;
    private final Boolean noiseCancellationEnabled = null;
    private final Boolean automaticGainControlEnabled = null;
    private final CharSequence audioOutputMode = null;
    private final Float voiceOutputVolume = null;
    private final Boolean videoHardwareScalingEnabled = null;
    private final CharSequence audioMode = null;
    private final CharSequence inputDeviceName = null;
    private final CharSequence outputDeviceName = null;
    private final CharSequence videoDeviceName = null;
    private final transient String analyticsSchemaTypeName = "call_report_problem";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCallReportProblem)) {
            return false;
        }
        TrackCallReportProblem trackCallReportProblem = (TrackCallReportProblem) other;
        return Intrinsics3.areEqual(this.channelId, trackCallReportProblem.channelId) && Intrinsics3.areEqual(this.channelType, trackCallReportProblem.channelType) && Intrinsics3.areEqual(this.guildId, trackCallReportProblem.guildId) && Intrinsics3.areEqual(this.rtcConnectionId, trackCallReportProblem.rtcConnectionId) && Intrinsics3.areEqual(this.duration, trackCallReportProblem.duration) && Intrinsics3.areEqual(this.voiceStateCount, trackCallReportProblem.voiceStateCount) && Intrinsics3.areEqual(this.videoStreamCount, trackCallReportProblem.videoStreamCount) && Intrinsics3.areEqual(this.videoEnabled, trackCallReportProblem.videoEnabled) && Intrinsics3.areEqual(this.mediaSessionId, trackCallReportProblem.mediaSessionId) && Intrinsics3.areEqual(this.rating, trackCallReportProblem.rating) && Intrinsics3.areEqual(this.feedback, trackCallReportProblem.feedback) && Intrinsics3.areEqual(this.reasonCode, trackCallReportProblem.reasonCode) && Intrinsics3.areEqual(this.reasonDescription, trackCallReportProblem.reasonDescription) && Intrinsics3.areEqual(this.audioInputMode, trackCallReportProblem.audioInputMode) && Intrinsics3.areEqual(this.automaticAudioInputSensitivityEnabled, trackCallReportProblem.automaticAudioInputSensitivityEnabled) && Intrinsics3.areEqual(this.audioInputSensitivity, trackCallReportProblem.audioInputSensitivity) && Intrinsics3.areEqual(this.echoCancellationEnabled, trackCallReportProblem.echoCancellationEnabled) && Intrinsics3.areEqual(this.noiseSuppressionEnabled, trackCallReportProblem.noiseSuppressionEnabled) && Intrinsics3.areEqual(this.noiseCancellationEnabled, trackCallReportProblem.noiseCancellationEnabled) && Intrinsics3.areEqual(this.automaticGainControlEnabled, trackCallReportProblem.automaticGainControlEnabled) && Intrinsics3.areEqual(this.audioOutputMode, trackCallReportProblem.audioOutputMode) && Intrinsics3.areEqual(this.voiceOutputVolume, trackCallReportProblem.voiceOutputVolume) && Intrinsics3.areEqual(this.videoHardwareScalingEnabled, trackCallReportProblem.videoHardwareScalingEnabled) && Intrinsics3.areEqual(this.audioMode, trackCallReportProblem.audioMode) && Intrinsics3.areEqual(this.inputDeviceName, trackCallReportProblem.inputDeviceName) && Intrinsics3.areEqual(this.outputDeviceName, trackCallReportProblem.outputDeviceName) && Intrinsics3.areEqual(this.videoDeviceName, trackCallReportProblem.videoDeviceName);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.rtcConnectionId;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.duration;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.voiceStateCount;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.videoStreamCount;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mediaSessionId;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.rating;
        int iHashCode10 = (iHashCode9 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.feedback;
        int iHashCode11 = (iHashCode10 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l7 = this.reasonCode;
        int iHashCode12 = (iHashCode11 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.reasonDescription;
        int iHashCode13 = (iHashCode12 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.audioInputMode;
        int iHashCode14 = (iHashCode13 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool2 = this.automaticAudioInputSensitivityEnabled;
        int iHashCode15 = (iHashCode14 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Float f = this.audioInputSensitivity;
        int iHashCode16 = (iHashCode15 + (f != null ? f.hashCode() : 0)) * 31;
        Boolean bool3 = this.echoCancellationEnabled;
        int iHashCode17 = (iHashCode16 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.noiseSuppressionEnabled;
        int iHashCode18 = (iHashCode17 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.noiseCancellationEnabled;
        int iHashCode19 = (iHashCode18 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.automaticGainControlEnabled;
        int iHashCode20 = (iHashCode19 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.audioOutputMode;
        int iHashCode21 = (iHashCode20 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Float f2 = this.voiceOutputVolume;
        int iHashCode22 = (iHashCode21 + (f2 != null ? f2.hashCode() : 0)) * 31;
        Boolean bool7 = this.videoHardwareScalingEnabled;
        int iHashCode23 = (iHashCode22 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.audioMode;
        int iHashCode24 = (iHashCode23 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.inputDeviceName;
        int iHashCode25 = (iHashCode24 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.outputDeviceName;
        int iHashCode26 = (iHashCode25 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.videoDeviceName;
        return iHashCode26 + (charSequence11 != null ? charSequence11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCallReportProblem(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rating=");
        sbU.append(this.rating);
        sbU.append(", feedback=");
        sbU.append(this.feedback);
        sbU.append(", reasonCode=");
        sbU.append(this.reasonCode);
        sbU.append(", reasonDescription=");
        sbU.append(this.reasonDescription);
        sbU.append(", audioInputMode=");
        sbU.append(this.audioInputMode);
        sbU.append(", automaticAudioInputSensitivityEnabled=");
        sbU.append(this.automaticAudioInputSensitivityEnabled);
        sbU.append(", audioInputSensitivity=");
        sbU.append(this.audioInputSensitivity);
        sbU.append(", echoCancellationEnabled=");
        sbU.append(this.echoCancellationEnabled);
        sbU.append(", noiseSuppressionEnabled=");
        sbU.append(this.noiseSuppressionEnabled);
        sbU.append(", noiseCancellationEnabled=");
        sbU.append(this.noiseCancellationEnabled);
        sbU.append(", automaticGainControlEnabled=");
        sbU.append(this.automaticGainControlEnabled);
        sbU.append(", audioOutputMode=");
        sbU.append(this.audioOutputMode);
        sbU.append(", voiceOutputVolume=");
        sbU.append(this.voiceOutputVolume);
        sbU.append(", videoHardwareScalingEnabled=");
        sbU.append(this.videoHardwareScalingEnabled);
        sbU.append(", audioMode=");
        sbU.append(this.audioMode);
        sbU.append(", inputDeviceName=");
        sbU.append(this.inputDeviceName);
        sbU.append(", outputDeviceName=");
        sbU.append(this.outputDeviceName);
        sbU.append(", videoDeviceName=");
        return outline.E(sbU, this.videoDeviceName, ")");
    }
}
