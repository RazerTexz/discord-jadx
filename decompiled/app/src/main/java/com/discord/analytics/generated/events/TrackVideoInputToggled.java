package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackVideoInputToggled.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012R\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012R\u001b\u0010)\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017R\u001b\u0010+\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017R\u001b\u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017R\u001b\u0010/\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017R\u001b\u00101\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00105\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0005R\u001b\u00108\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00102\u001a\u0004\b9\u00104R!\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010?\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0010\u001a\u0004\b@\u0010\u0012R\u001b\u0010A\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\bB\u0010\u0012R\u001b\u0010C\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u0015\u001a\u0004\bD\u0010\u0017R\u001b\u0010E\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0015\u001a\u0004\bF\u0010\u0017R\u001b\u0010G\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0015\u001a\u0004\bH\u0010\u0017R\u001b\u0010I\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\u0015\u001a\u0004\bJ\u0010\u0017R\u001b\u0010K\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010\u0015\u001a\u0004\bL\u0010\u0017R\u001b\u0010M\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010\u0010\u001a\u0004\bN\u0010\u0012¨\u0006O"}, d2 = {"Lcom/discord/analytics/generated/events/TrackVideoInputToggled;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "", "source", "Ljava/lang/CharSequence;", "getSource", "()Ljava/lang/CharSequence;", "shareGameId", "getShareGameId", "videoStreamCount", "getVideoStreamCount", "channelType", "getChannelType", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "gameId", "getGameId", "videoInputFrameRate", "getVideoInputFrameRate", "shareGameName", "getShareGameName", "mediaSessionId", "getMediaSessionId", "videoInputType", "getVideoInputType", "nonce", "getNonce", "videoEnabled", "Ljava/lang/Boolean;", "getVideoEnabled", "()Ljava/lang/Boolean;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "previewEnabled", "getPreviewEnabled", "", "enabledInputs", "Ljava/util/List;", "getEnabledInputs", "()Ljava/util/List;", "channelId", "getChannelId", "voiceStateCount", "getVoiceStateCount", "gameName", "getGameName", "soundshareSession", "getSoundshareSession", "gamePlatform", "getGamePlatform", "gameExeName", "getGameExeName", "videoToggleSource", "getVideoToggleSource", "videoInputResolution", "getVideoInputResolution", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackVideoInputToggled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final CharSequence nonce = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence gameName = null;
    private final CharSequence gameExeName = null;
    private final Long gameId = null;
    private final CharSequence videoInputType = null;
    private final Long videoInputResolution = null;
    private final Long videoInputFrameRate = null;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final CharSequence gamePlatform = null;
    private final CharSequence source = null;
    private final CharSequence videoToggleSource = null;
    private final CharSequence mediaSessionId = null;
    private final List<CharSequence> enabledInputs = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "video_input_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoInputToggled)) {
            return false;
        }
        TrackVideoInputToggled trackVideoInputToggled = (TrackVideoInputToggled) other;
        return Intrinsics3.areEqual(this.channelId, trackVideoInputToggled.channelId) && Intrinsics3.areEqual(this.channelType, trackVideoInputToggled.channelType) && Intrinsics3.areEqual(this.guildId, trackVideoInputToggled.guildId) && Intrinsics3.areEqual(this.nonce, trackVideoInputToggled.nonce) && Intrinsics3.areEqual(this.voiceStateCount, trackVideoInputToggled.voiceStateCount) && Intrinsics3.areEqual(this.videoStreamCount, trackVideoInputToggled.videoStreamCount) && Intrinsics3.areEqual(this.videoEnabled, trackVideoInputToggled.videoEnabled) && Intrinsics3.areEqual(this.gameName, trackVideoInputToggled.gameName) && Intrinsics3.areEqual(this.gameExeName, trackVideoInputToggled.gameExeName) && Intrinsics3.areEqual(this.gameId, trackVideoInputToggled.gameId) && Intrinsics3.areEqual(this.videoInputType, trackVideoInputToggled.videoInputType) && Intrinsics3.areEqual(this.videoInputResolution, trackVideoInputToggled.videoInputResolution) && Intrinsics3.areEqual(this.videoInputFrameRate, trackVideoInputToggled.videoInputFrameRate) && Intrinsics3.areEqual(this.soundshareSession, trackVideoInputToggled.soundshareSession) && Intrinsics3.areEqual(this.shareGameName, trackVideoInputToggled.shareGameName) && Intrinsics3.areEqual(this.shareGameId, trackVideoInputToggled.shareGameId) && Intrinsics3.areEqual(this.gamePlatform, trackVideoInputToggled.gamePlatform) && Intrinsics3.areEqual(this.source, trackVideoInputToggled.source) && Intrinsics3.areEqual(this.videoToggleSource, trackVideoInputToggled.videoToggleSource) && Intrinsics3.areEqual(this.mediaSessionId, trackVideoInputToggled.mediaSessionId) && Intrinsics3.areEqual(this.enabledInputs, trackVideoInputToggled.enabledInputs) && Intrinsics3.areEqual(this.previewEnabled, trackVideoInputToggled.previewEnabled);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.nonce;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.voiceStateCount;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.videoStreamCount;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gameName;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gameExeName;
        int iHashCode9 = (iHashCode8 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l6 = this.gameId;
        int iHashCode10 = (iHashCode9 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.videoInputType;
        int iHashCode11 = (iHashCode10 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l7 = this.videoInputResolution;
        int iHashCode12 = (iHashCode11 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.videoInputFrameRate;
        int iHashCode13 = (iHashCode12 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.soundshareSession;
        int iHashCode14 = (iHashCode13 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.shareGameName;
        int iHashCode15 = (iHashCode14 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l9 = this.shareGameId;
        int iHashCode16 = (iHashCode15 + (l9 != null ? l9.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.gamePlatform;
        int iHashCode17 = (iHashCode16 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.source;
        int iHashCode18 = (iHashCode17 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.videoToggleSource;
        int iHashCode19 = (iHashCode18 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.mediaSessionId;
        int iHashCode20 = (iHashCode19 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        List<CharSequence> list = this.enabledInputs;
        int iHashCode21 = (iHashCode20 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool2 = this.previewEnabled;
        return iHashCode21 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoInputToggled(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", nonce=");
        sbU.append(this.nonce);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameExeName=");
        sbU.append(this.gameExeName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", videoInputType=");
        sbU.append(this.videoInputType);
        sbU.append(", videoInputResolution=");
        sbU.append(this.videoInputResolution);
        sbU.append(", videoInputFrameRate=");
        sbU.append(this.videoInputFrameRate);
        sbU.append(", soundshareSession=");
        sbU.append(this.soundshareSession);
        sbU.append(", shareGameName=");
        sbU.append(this.shareGameName);
        sbU.append(", shareGameId=");
        sbU.append(this.shareGameId);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", videoToggleSource=");
        sbU.append(this.videoToggleSource);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", enabledInputs=");
        sbU.append(this.enabledInputs);
        sbU.append(", previewEnabled=");
        return outline.D(sbU, this.previewEnabled, ")");
    }
}
