package com.discord.utilities.features;

import com.discord.app.AppLog;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import kotlin.Metadata;

/* compiled from: GrowthTeamFeatures.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J'\u0010\u0007\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\f\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000f\u001a\u00020\u0005*\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0012J\r\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0012J\r\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0012J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0012J\r\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0012J\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u0012J\r\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u0012J\r\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u0012J\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0012J\r\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u0012J!\u0010\u001e\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0005¢\u0006\u0004\b \u0010\u0012J\r\u0010!\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\u0012¨\u0006$"}, d2 = {"Lcom/discord/utilities/features/GrowthTeamFeatures;", "", "", "", "bucket", "", "trackExposure", "isUserExperimentEnabled", "(Ljava/lang/String;IZ)Z", "", "Lcom/discord/primitives/GuildId;", "guildId", "isGuildExperimentEnabled", "(Ljava/lang/String;IJZ)Z", "experiment", "isBucketEnabled", "(Ljava/lang/Integer;Ljava/lang/String;IZ)Z", "isHubEmailConnectionEnabled", "()Z", "isHubEnabled", "isImpressionLoggingEnabled", "isMultiDomainEnabled", "isNetworkActionLoggingEnabled", "isHubDiscoverySparkleEnabled", "isHubDiscoveryEnabled", "isHubOnboardingEnabled", "isAndroidSmsAutofillEnabled", "isHubNameKillSwitchEnabled", "imbalancedAndroidSplashNoop", "hubStudyGroupEnabled", "hubEventsEnabled", "(JZ)Z", "isPhoneVerifyCaptchaEnabled", "isHighlightsSettingsEnabled", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GrowthTeamFeatures {
    public static final GrowthTeamFeatures INSTANCE = new GrowthTeamFeatures();

    private GrowthTeamFeatures() {
    }

    private final boolean isBucketEnabled(Integer num, String str, int i, boolean z2) {
        AppLog.i("Experiment triggered: " + str + " | Track Exposure: " + z2 + " | Assigned Bucket: " + num);
        return num != null && num.intValue() == i;
    }

    public static /* synthetic */ boolean isBucketEnabled$default(GrowthTeamFeatures growthTeamFeatures, Integer num, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return growthTeamFeatures.isBucketEnabled(num, str, i, z2);
    }

    private final boolean isGuildExperimentEnabled(String str, int i, long j, boolean z2) {
        Experiment guildExperiment = StoreStream.INSTANCE.getExperiments().getGuildExperiment(str, j, z2);
        return isBucketEnabled(guildExperiment != null ? Integer.valueOf(guildExperiment.getBucket()) : null, str, i, z2);
    }

    public static /* synthetic */ boolean isGuildExperimentEnabled$default(GrowthTeamFeatures growthTeamFeatures, String str, int i, long j, boolean z2, int i2, Object obj) {
        return growthTeamFeatures.isGuildExperimentEnabled(str, (i2 & 1) != 0 ? 1 : i, j, (i2 & 4) != 0 ? true : z2);
    }

    private final boolean isUserExperimentEnabled(String str, int i, boolean z2) {
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment(str, z2);
        return isBucketEnabled(userExperiment != null ? Integer.valueOf(userExperiment.getBucket()) : null, str, i, z2);
    }

    public static /* synthetic */ boolean isUserExperimentEnabled$default(GrowthTeamFeatures growthTeamFeatures, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return growthTeamFeatures.isUserExperimentEnabled(str, i, z2);
    }

    public final boolean hubEventsEnabled(long guildId, boolean trackExposure) {
        return isGuildExperimentEnabled("2021-11_hub_events", 1, guildId, trackExposure);
    }

    public final boolean hubStudyGroupEnabled() {
        return isUserExperimentEnabled$default(this, "2021-10_study_group", 0, false, 3, null);
    }

    public final boolean imbalancedAndroidSplashNoop() {
        return isUserExperimentEnabled$default(this, "2021-09_imbalanced_android_splash_noop", 0, false, 3, null);
    }

    public final boolean isAndroidSmsAutofillEnabled() {
        return isUserExperimentEnabled$default(this, "2021-09_android_sms_autofill", 0, false, 3, null);
    }

    public final boolean isHighlightsSettingsEnabled() {
        return isUserExperimentEnabled$default(this, "2022-03_highlights_settings", 0, false, 3, null);
    }

    public final boolean isHubDiscoveryEnabled() {
        return isUserExperimentEnabled$default(this, "2021-06_hub_discovery", 1, false, 2, null) || isUserExperimentEnabled$default(this, "2021-06_hub_discovery", 2, false, 2, null);
    }

    public final boolean isHubDiscoverySparkleEnabled() {
        return isUserExperimentEnabled$default(this, "2021-06_hub_discovery", 1, false, 2, null);
    }

    public final boolean isHubEmailConnectionEnabled() {
        return isUserExperimentEnabled$default(this, "2021-06_hub_email_connection", 0, false, 3, null);
    }

    public final boolean isHubEnabled() {
        return isUserExperimentEnabled$default(this, "2021-06_desktop_school_hubs", 0, false, 3, null);
    }

    public final boolean isHubNameKillSwitchEnabled() {
        return isUserExperimentEnabled$default(this, "2021-09_hub_name_popup_kill_switch", 0, false, 3, null);
    }

    public final boolean isHubOnboardingEnabled() {
        return isUserExperimentEnabled$default(this, "2021-08_hubs_in_organic_onboarding", 0, false, 3, null);
    }

    public final boolean isImpressionLoggingEnabled() {
        return isUserExperimentEnabled$default(this, "2021-08_impression_logging_enabled_android", 0, false, 3, null);
    }

    public final boolean isMultiDomainEnabled() {
        return isUserExperimentEnabled$default(this, "2021-08_hub_multi_domain_mobile", 0, false, 3, null);
    }

    public final boolean isNetworkActionLoggingEnabled() {
        return isUserExperimentEnabled$default(this, "2021-07_network_action_logging_android", 0, false, 3, null);
    }

    public final boolean isPhoneVerifyCaptchaEnabled() {
        return isUserExperimentEnabled$default(this, "2021-11_phone_verify_captcha", 0, false, 3, null);
    }
}
