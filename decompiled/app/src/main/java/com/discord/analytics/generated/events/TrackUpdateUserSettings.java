package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackUpdateUserSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0005R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 R\u001b\u0010%\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015R!\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 R\u001b\u0010.\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001e\u001a\u0004\b/\u0010 R\u001b\u00100\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 R\u001b\u00102\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u001e\u001a\u0004\b3\u0010 R\u001b\u00104\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0013\u001a\u0004\b5\u0010\u0015R\u001b\u00106\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u001e\u001a\u0004\b7\u0010 R\u001b\u00108\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u001e\u001a\u0004\b9\u0010 R\u001b\u0010:\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u001e\u001a\u0004\b;\u0010 R\u001b\u0010<\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0018\u001a\u0004\b=\u0010\u001aR\u001b\u0010>\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u001e\u001a\u0004\b?\u0010 R\u001b\u0010@\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0013\u001a\u0004\bA\u0010\u0015R\u001b\u0010B\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u001e\u001a\u0004\bC\u0010 R\u001b\u0010D\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u0013\u001a\u0004\bE\u0010\u0015R\u001b\u0010F\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u001e\u001a\u0004\bG\u0010 R\u001b\u0010H\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u001e\u001a\u0004\bI\u0010 R$\u0010K\u001a\u0004\u0018\u00010J8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR!\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010)\u001a\u0004\bR\u0010+R\u001b\u0010S\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010\u001e\u001a\u0004\bT\u0010 R\u001b\u0010U\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u001e\u001a\u0004\bV\u0010 R\u001b\u0010W\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010\u001e\u001a\u0004\bX\u0010 R\u001b\u0010Y\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010\u001e\u001a\u0004\bZ\u0010 R\u001b\u0010[\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b[\u0010\u001e\u001a\u0004\b\\\u0010 R\u001b\u0010]\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010\u001e\u001a\u0004\b^\u0010 R\u001b\u0010_\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010\u0018\u001a\u0004\b`\u0010\u001aR\u001b\u0010a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010\u001e\u001a\u0004\bb\u0010 ¨\u0006c"}, d2 = {"Lcom/discord/analytics/generated/events/TrackUpdateUserSettings;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "numServerFolders", "Ljava/lang/Long;", "getNumServerFolders", "()Ljava/lang/Long;", "", "status", "Ljava/lang/CharSequence;", "getStatus", "()Ljava/lang/CharSequence;", "animateStickers", "getAnimateStickers", "inlineAttachmentMedia", "Ljava/lang/Boolean;", "getInlineAttachmentMedia", "()Ljava/lang/Boolean;", "showCurrentGame", "getShowCurrentGame", "nativePhoneIntegrationEnabled", "getNativePhoneIntegrationEnabled", "explicitContentFilter", "getExplicitContentFilter", "", "restrictedGuilds", "Ljava/util/List;", "getRestrictedGuilds", "()Ljava/util/List;", "defaultGuildsRestricted", "getDefaultGuildsRestricted", "viewNsfwGuilds", "getViewNsfwGuilds", "enableTtsCommand", "getEnableTtsCommand", "gifAutoPlay", "getGifAutoPlay", "afkTimeout", "getAfkTimeout", "hasCustomStatus", "getHasCustomStatus", "detectPlatformAccounts", "getDetectPlatformAccounts", "convertEmoticons", "getConvertEmoticons", "locale", "getLocale", "renderEmbeds", "getRenderEmbeds", "friendSourceFlags", "getFriendSourceFlags", "messageDisplayCompact", "getMessageDisplayCompact", "timezoneOffset", "getTimezoneOffset", "developerMode", "getDeveloperMode", "animateEmoji", "getAnimateEmoji", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "guildPositions", "getGuildPositions", "contactSyncEnabled", "getContactSyncEnabled", "streamNotificationsEnabled", "getStreamNotificationsEnabled", "inlineEmbedMedia", "getInlineEmbedMedia", "passwordless", "getPasswordless", "disableGamesTab", "getDisableGamesTab", "allowAccessibilityDetection", "getAllowAccessibilityDetection", "theme", "getTheme", "renderReactions", "getRenderReactions", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackUpdateUserSettings implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean convertEmoticons = null;
    private final Boolean developerMode = null;
    private final Boolean enableTtsCommand = null;
    private final Long friendSourceFlags = null;
    private final List<Long> guildPositions = null;
    private final Boolean inlineAttachmentMedia = null;
    private final Boolean inlineEmbedMedia = null;
    private final Boolean gifAutoPlay = null;
    private final CharSequence locale = null;
    private final Boolean messageDisplayCompact = null;
    private final Boolean renderEmbeds = null;
    private final Boolean renderReactions = null;
    private final Boolean animateEmoji = null;
    private final List<Long> restrictedGuilds = null;
    private final Boolean showCurrentGame = null;
    private final CharSequence theme = null;
    private final Boolean detectPlatformAccounts = null;
    private final CharSequence status = null;
    private final Boolean defaultGuildsRestricted = null;
    private final Long explicitContentFilter = null;
    private final Long afkTimeout = null;
    private final Long timezoneOffset = null;
    private final Boolean disableGamesTab = null;
    private final Long numServerFolders = null;
    private final Boolean streamNotificationsEnabled = null;
    private final Boolean hasCustomStatus = null;
    private final Boolean allowAccessibilityDetection = null;
    private final Boolean contactSyncEnabled = null;
    private final Boolean nativePhoneIntegrationEnabled = null;
    private final Long animateStickers = null;
    private final Boolean viewNsfwGuilds = null;
    private final Boolean passwordless = null;
    private final transient String analyticsSchemaTypeName = "update_user_settings";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateUserSettings)) {
            return false;
        }
        TrackUpdateUserSettings trackUpdateUserSettings = (TrackUpdateUserSettings) other;
        return Intrinsics3.areEqual(this.convertEmoticons, trackUpdateUserSettings.convertEmoticons) && Intrinsics3.areEqual(this.developerMode, trackUpdateUserSettings.developerMode) && Intrinsics3.areEqual(this.enableTtsCommand, trackUpdateUserSettings.enableTtsCommand) && Intrinsics3.areEqual(this.friendSourceFlags, trackUpdateUserSettings.friendSourceFlags) && Intrinsics3.areEqual(this.guildPositions, trackUpdateUserSettings.guildPositions) && Intrinsics3.areEqual(this.inlineAttachmentMedia, trackUpdateUserSettings.inlineAttachmentMedia) && Intrinsics3.areEqual(this.inlineEmbedMedia, trackUpdateUserSettings.inlineEmbedMedia) && Intrinsics3.areEqual(this.gifAutoPlay, trackUpdateUserSettings.gifAutoPlay) && Intrinsics3.areEqual(this.locale, trackUpdateUserSettings.locale) && Intrinsics3.areEqual(this.messageDisplayCompact, trackUpdateUserSettings.messageDisplayCompact) && Intrinsics3.areEqual(this.renderEmbeds, trackUpdateUserSettings.renderEmbeds) && Intrinsics3.areEqual(this.renderReactions, trackUpdateUserSettings.renderReactions) && Intrinsics3.areEqual(this.animateEmoji, trackUpdateUserSettings.animateEmoji) && Intrinsics3.areEqual(this.restrictedGuilds, trackUpdateUserSettings.restrictedGuilds) && Intrinsics3.areEqual(this.showCurrentGame, trackUpdateUserSettings.showCurrentGame) && Intrinsics3.areEqual(this.theme, trackUpdateUserSettings.theme) && Intrinsics3.areEqual(this.detectPlatformAccounts, trackUpdateUserSettings.detectPlatformAccounts) && Intrinsics3.areEqual(this.status, trackUpdateUserSettings.status) && Intrinsics3.areEqual(this.defaultGuildsRestricted, trackUpdateUserSettings.defaultGuildsRestricted) && Intrinsics3.areEqual(this.explicitContentFilter, trackUpdateUserSettings.explicitContentFilter) && Intrinsics3.areEqual(this.afkTimeout, trackUpdateUserSettings.afkTimeout) && Intrinsics3.areEqual(this.timezoneOffset, trackUpdateUserSettings.timezoneOffset) && Intrinsics3.areEqual(this.disableGamesTab, trackUpdateUserSettings.disableGamesTab) && Intrinsics3.areEqual(this.numServerFolders, trackUpdateUserSettings.numServerFolders) && Intrinsics3.areEqual(this.streamNotificationsEnabled, trackUpdateUserSettings.streamNotificationsEnabled) && Intrinsics3.areEqual(this.hasCustomStatus, trackUpdateUserSettings.hasCustomStatus) && Intrinsics3.areEqual(this.allowAccessibilityDetection, trackUpdateUserSettings.allowAccessibilityDetection) && Intrinsics3.areEqual(this.contactSyncEnabled, trackUpdateUserSettings.contactSyncEnabled) && Intrinsics3.areEqual(this.nativePhoneIntegrationEnabled, trackUpdateUserSettings.nativePhoneIntegrationEnabled) && Intrinsics3.areEqual(this.animateStickers, trackUpdateUserSettings.animateStickers) && Intrinsics3.areEqual(this.viewNsfwGuilds, trackUpdateUserSettings.viewNsfwGuilds) && Intrinsics3.areEqual(this.passwordless, trackUpdateUserSettings.passwordless);
    }

    public int hashCode() {
        Boolean bool = this.convertEmoticons;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.developerMode;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.enableTtsCommand;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l = this.friendSourceFlags;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        List<Long> list = this.guildPositions;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool4 = this.inlineAttachmentMedia;
        int iHashCode6 = (iHashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.inlineEmbedMedia;
        int iHashCode7 = (iHashCode6 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.gifAutoPlay;
        int iHashCode8 = (iHashCode7 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        CharSequence charSequence = this.locale;
        int iHashCode9 = (iHashCode8 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool7 = this.messageDisplayCompact;
        int iHashCode10 = (iHashCode9 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        Boolean bool8 = this.renderEmbeds;
        int iHashCode11 = (iHashCode10 + (bool8 != null ? bool8.hashCode() : 0)) * 31;
        Boolean bool9 = this.renderReactions;
        int iHashCode12 = (iHashCode11 + (bool9 != null ? bool9.hashCode() : 0)) * 31;
        Boolean bool10 = this.animateEmoji;
        int iHashCode13 = (iHashCode12 + (bool10 != null ? bool10.hashCode() : 0)) * 31;
        List<Long> list2 = this.restrictedGuilds;
        int iHashCode14 = (iHashCode13 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Boolean bool11 = this.showCurrentGame;
        int iHashCode15 = (iHashCode14 + (bool11 != null ? bool11.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.theme;
        int iHashCode16 = (iHashCode15 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool12 = this.detectPlatformAccounts;
        int iHashCode17 = (iHashCode16 + (bool12 != null ? bool12.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.status;
        int iHashCode18 = (iHashCode17 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool13 = this.defaultGuildsRestricted;
        int iHashCode19 = (iHashCode18 + (bool13 != null ? bool13.hashCode() : 0)) * 31;
        Long l2 = this.explicitContentFilter;
        int iHashCode20 = (iHashCode19 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.afkTimeout;
        int iHashCode21 = (iHashCode20 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.timezoneOffset;
        int iHashCode22 = (iHashCode21 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool14 = this.disableGamesTab;
        int iHashCode23 = (iHashCode22 + (bool14 != null ? bool14.hashCode() : 0)) * 31;
        Long l5 = this.numServerFolders;
        int iHashCode24 = (iHashCode23 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool15 = this.streamNotificationsEnabled;
        int iHashCode25 = (iHashCode24 + (bool15 != null ? bool15.hashCode() : 0)) * 31;
        Boolean bool16 = this.hasCustomStatus;
        int iHashCode26 = (iHashCode25 + (bool16 != null ? bool16.hashCode() : 0)) * 31;
        Boolean bool17 = this.allowAccessibilityDetection;
        int iHashCode27 = (iHashCode26 + (bool17 != null ? bool17.hashCode() : 0)) * 31;
        Boolean bool18 = this.contactSyncEnabled;
        int iHashCode28 = (iHashCode27 + (bool18 != null ? bool18.hashCode() : 0)) * 31;
        Boolean bool19 = this.nativePhoneIntegrationEnabled;
        int iHashCode29 = (iHashCode28 + (bool19 != null ? bool19.hashCode() : 0)) * 31;
        Long l6 = this.animateStickers;
        int iHashCode30 = (iHashCode29 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool20 = this.viewNsfwGuilds;
        int iHashCode31 = (iHashCode30 + (bool20 != null ? bool20.hashCode() : 0)) * 31;
        Boolean bool21 = this.passwordless;
        return iHashCode31 + (bool21 != null ? bool21.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUpdateUserSettings(convertEmoticons=");
        sbU.append(this.convertEmoticons);
        sbU.append(", developerMode=");
        sbU.append(this.developerMode);
        sbU.append(", enableTtsCommand=");
        sbU.append(this.enableTtsCommand);
        sbU.append(", friendSourceFlags=");
        sbU.append(this.friendSourceFlags);
        sbU.append(", guildPositions=");
        sbU.append(this.guildPositions);
        sbU.append(", inlineAttachmentMedia=");
        sbU.append(this.inlineAttachmentMedia);
        sbU.append(", inlineEmbedMedia=");
        sbU.append(this.inlineEmbedMedia);
        sbU.append(", gifAutoPlay=");
        sbU.append(this.gifAutoPlay);
        sbU.append(", locale=");
        sbU.append(this.locale);
        sbU.append(", messageDisplayCompact=");
        sbU.append(this.messageDisplayCompact);
        sbU.append(", renderEmbeds=");
        sbU.append(this.renderEmbeds);
        sbU.append(", renderReactions=");
        sbU.append(this.renderReactions);
        sbU.append(", animateEmoji=");
        sbU.append(this.animateEmoji);
        sbU.append(", restrictedGuilds=");
        sbU.append(this.restrictedGuilds);
        sbU.append(", showCurrentGame=");
        sbU.append(this.showCurrentGame);
        sbU.append(", theme=");
        sbU.append(this.theme);
        sbU.append(", detectPlatformAccounts=");
        sbU.append(this.detectPlatformAccounts);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(", defaultGuildsRestricted=");
        sbU.append(this.defaultGuildsRestricted);
        sbU.append(", explicitContentFilter=");
        sbU.append(this.explicitContentFilter);
        sbU.append(", afkTimeout=");
        sbU.append(this.afkTimeout);
        sbU.append(", timezoneOffset=");
        sbU.append(this.timezoneOffset);
        sbU.append(", disableGamesTab=");
        sbU.append(this.disableGamesTab);
        sbU.append(", numServerFolders=");
        sbU.append(this.numServerFolders);
        sbU.append(", streamNotificationsEnabled=");
        sbU.append(this.streamNotificationsEnabled);
        sbU.append(", hasCustomStatus=");
        sbU.append(this.hasCustomStatus);
        sbU.append(", allowAccessibilityDetection=");
        sbU.append(this.allowAccessibilityDetection);
        sbU.append(", contactSyncEnabled=");
        sbU.append(this.contactSyncEnabled);
        sbU.append(", nativePhoneIntegrationEnabled=");
        sbU.append(this.nativePhoneIntegrationEnabled);
        sbU.append(", animateStickers=");
        sbU.append(this.animateStickers);
        sbU.append(", viewNsfwGuilds=");
        sbU.append(this.viewNsfwGuilds);
        sbU.append(", passwordless=");
        return outline.D(sbU, this.passwordless, ")");
    }
}
