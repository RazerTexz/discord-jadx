package com.discord.analytics.generated.events;

import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackScreenshareFinished.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001b\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012R\u001c\u0010'\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0005R\u001b\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012R\u001b\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012R\u001b\u0010.\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019R\u001b\u00100\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010\u0012R\u001b\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0017\u001a\u0004\b3\u0010\u0019R\u001b\u00104\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0017\u001a\u0004\b5\u0010\u0019R\u001b\u00106\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0017\u001a\u0004\b7\u0010\u0019R\u001b\u00108\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b9\u0010\u0012R\u001b\u0010:\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0017\u001a\u0004\b;\u0010\u0019R\u001b\u0010<\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0017\u001a\u0004\b=\u0010\u0019R\u001b\u0010>\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0010\u001a\u0004\b?\u0010\u0012R\u001b\u0010@\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0017\u001a\u0004\bA\u0010\u0019R\u001b\u0010B\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0010\u001a\u0004\bC\u0010\u0012R\u001b\u0010D\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u0010\u001a\u0004\bE\u0010\u0012R$\u0010G\u001a\u0004\u0018\u00010F8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001b\u0010M\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010\u0010\u001a\u0004\bN\u0010\u0012R\u001b\u0010O\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010\u0010\u001a\u0004\bP\u0010\u0012R\u001b\u0010Q\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010\u0017\u001a\u0004\bR\u0010\u0019R\u001b\u0010S\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010\u0010\u001a\u0004\bT\u0010\u0012¨\u0006U"}, d2 = {"Lcom/discord/analytics/generated/events/TrackScreenshareFinished;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hybridDxgiFrames", "Ljava/lang/Long;", "getHybridDxgiFrames", "()Ljava/lang/Long;", "hybridVideohookFrames", "getHybridVideohookFrames", "", "cpuVendor", "Ljava/lang/CharSequence;", "getCpuVendor", "()Ljava/lang/CharSequence;", "rtcConnectionId", "getRtcConnectionId", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Ljava/lang/Float;", "getActivity", "()Ljava/lang/Float;", "shareGameName", "getShareGameName", "windows", "getWindows", "screens", "getScreens", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "shareGameId", "getShareGameId", "channelId", "getChannelId", "context", "getContext", "cpuMemory", "getCpuMemory", "mediaSessionId", "getMediaSessionId", "soundshareSession", "getSoundshareSession", "gpuBrand", "getGpuBrand", "screenshareFrames", "getScreenshareFrames", "cpuBrand", "getCpuBrand", "gpu", "getGpu", "quartzFrames", "getQuartzFrames", "desktopCapturerType", "getDesktopCapturerType", "guildId", "getGuildId", "gpuCount", "getGpuCount", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "videohookFrames", "getVideohookFrames", "gpuMemory", "getGpuMemory", "cpu", "getCpu", "hybridGdiFrames", "getHybridGdiFrames", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackScreenshareFinished implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long channelId = null;
    private final CharSequence context = null;
    private final Long screenshareFrames = null;
    private final Long videohookFrames = null;
    private final Long hybridDxgiFrames = null;
    private final Long hybridGdiFrames = null;
    private final Long hybridVideohookFrames = null;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final CharSequence desktopCapturerType = null;
    private final Long screens = null;
    private final Long windows = null;
    private final CharSequence cpu = null;
    private final CharSequence gpu = null;
    private final CharSequence cpuBrand = null;
    private final CharSequence cpuVendor = null;
    private final Long cpuMemory = null;
    private final CharSequence gpuBrand = null;
    private final Long gpuCount = null;
    private final Long gpuMemory = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final Long quartzFrames = null;
    private final Float activity = null;
    private final transient String analyticsSchemaTypeName = "screenshare_finished";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackScreenshareFinished)) {
            return false;
        }
        TrackScreenshareFinished trackScreenshareFinished = (TrackScreenshareFinished) other;
        return Intrinsics3.areEqual(this.guildId, trackScreenshareFinished.guildId) && Intrinsics3.areEqual(this.channelId, trackScreenshareFinished.channelId) && Intrinsics3.areEqual(this.context, trackScreenshareFinished.context) && Intrinsics3.areEqual(this.screenshareFrames, trackScreenshareFinished.screenshareFrames) && Intrinsics3.areEqual(this.videohookFrames, trackScreenshareFinished.videohookFrames) && Intrinsics3.areEqual(this.hybridDxgiFrames, trackScreenshareFinished.hybridDxgiFrames) && Intrinsics3.areEqual(this.hybridGdiFrames, trackScreenshareFinished.hybridGdiFrames) && Intrinsics3.areEqual(this.hybridVideohookFrames, trackScreenshareFinished.hybridVideohookFrames) && Intrinsics3.areEqual(this.soundshareSession, trackScreenshareFinished.soundshareSession) && Intrinsics3.areEqual(this.shareGameName, trackScreenshareFinished.shareGameName) && Intrinsics3.areEqual(this.shareGameId, trackScreenshareFinished.shareGameId) && Intrinsics3.areEqual(this.desktopCapturerType, trackScreenshareFinished.desktopCapturerType) && Intrinsics3.areEqual(this.screens, trackScreenshareFinished.screens) && Intrinsics3.areEqual(this.windows, trackScreenshareFinished.windows) && Intrinsics3.areEqual(this.cpu, trackScreenshareFinished.cpu) && Intrinsics3.areEqual(this.gpu, trackScreenshareFinished.gpu) && Intrinsics3.areEqual(this.cpuBrand, trackScreenshareFinished.cpuBrand) && Intrinsics3.areEqual(this.cpuVendor, trackScreenshareFinished.cpuVendor) && Intrinsics3.areEqual(this.cpuMemory, trackScreenshareFinished.cpuMemory) && Intrinsics3.areEqual(this.gpuBrand, trackScreenshareFinished.gpuBrand) && Intrinsics3.areEqual(this.gpuCount, trackScreenshareFinished.gpuCount) && Intrinsics3.areEqual(this.gpuMemory, trackScreenshareFinished.gpuMemory) && Intrinsics3.areEqual(this.mediaSessionId, trackScreenshareFinished.mediaSessionId) && Intrinsics3.areEqual(this.rtcConnectionId, trackScreenshareFinished.rtcConnectionId) && Intrinsics3.areEqual(this.quartzFrames, trackScreenshareFinished.quartzFrames) && Intrinsics3.areEqual(this.activity, trackScreenshareFinished.activity);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.context;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.screenshareFrames;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.videohookFrames;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.hybridDxgiFrames;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.hybridGdiFrames;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.hybridVideohookFrames;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.soundshareSession;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.shareGameName;
        int iHashCode10 = (iHashCode9 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l8 = this.shareGameId;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.desktopCapturerType;
        int iHashCode12 = (iHashCode11 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l9 = this.screens;
        int iHashCode13 = (iHashCode12 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.windows;
        int iHashCode14 = (iHashCode13 + (l10 != null ? l10.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.cpu;
        int iHashCode15 = (iHashCode14 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.gpu;
        int iHashCode16 = (iHashCode15 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.cpuBrand;
        int iHashCode17 = (iHashCode16 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.cpuVendor;
        int iHashCode18 = (iHashCode17 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Long l11 = this.cpuMemory;
        int iHashCode19 = (iHashCode18 + (l11 != null ? l11.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.gpuBrand;
        int iHashCode20 = (iHashCode19 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        Long l12 = this.gpuCount;
        int iHashCode21 = (iHashCode20 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.gpuMemory;
        int iHashCode22 = (iHashCode21 + (l13 != null ? l13.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.mediaSessionId;
        int iHashCode23 = (iHashCode22 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.rtcConnectionId;
        int iHashCode24 = (iHashCode23 + (charSequence11 != null ? charSequence11.hashCode() : 0)) * 31;
        Long l14 = this.quartzFrames;
        int iHashCode25 = (iHashCode24 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Float f = this.activity;
        return iHashCode25 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackScreenshareFinished(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", context=");
        sbU.append(this.context);
        sbU.append(", screenshareFrames=");
        sbU.append(this.screenshareFrames);
        sbU.append(", videohookFrames=");
        sbU.append(this.videohookFrames);
        sbU.append(", hybridDxgiFrames=");
        sbU.append(this.hybridDxgiFrames);
        sbU.append(", hybridGdiFrames=");
        sbU.append(this.hybridGdiFrames);
        sbU.append(", hybridVideohookFrames=");
        sbU.append(this.hybridVideohookFrames);
        sbU.append(", soundshareSession=");
        sbU.append(this.soundshareSession);
        sbU.append(", shareGameName=");
        sbU.append(this.shareGameName);
        sbU.append(", shareGameId=");
        sbU.append(this.shareGameId);
        sbU.append(", desktopCapturerType=");
        sbU.append(this.desktopCapturerType);
        sbU.append(", screens=");
        sbU.append(this.screens);
        sbU.append(", windows=");
        sbU.append(this.windows);
        sbU.append(", cpu=");
        sbU.append(this.cpu);
        sbU.append(", gpu=");
        sbU.append(this.gpu);
        sbU.append(", cpuBrand=");
        sbU.append(this.cpuBrand);
        sbU.append(", cpuVendor=");
        sbU.append(this.cpuVendor);
        sbU.append(", cpuMemory=");
        sbU.append(this.cpuMemory);
        sbU.append(", gpuBrand=");
        sbU.append(this.gpuBrand);
        sbU.append(", gpuCount=");
        sbU.append(this.gpuCount);
        sbU.append(", gpuMemory=");
        sbU.append(this.gpuMemory);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", quartzFrames=");
        sbU.append(this.quartzFrames);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(")");
        return sbU.toString();
    }
}
