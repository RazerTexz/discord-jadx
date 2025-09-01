package com.discord.widgets.nux;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildTemplateAnalytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplateAnalytics;", "", "", "fromStep", "toStep", "", "postRegistrationTransition$app_productionGoogleRelease", "(Ljava/lang/String;Ljava/lang/String;)V", "postRegistrationTransition", "postRegistrationSkip$app_productionGoogleRelease", "(Ljava/lang/String;)V", "postRegistrationSkip", "IN_APP_LOCATION_TEMPLATE", "Ljava/lang/String;", "STEP_GUILD_TEMPLATE", "STEP_GUILD_CREATE", "STEP_REGISTRATION", "STEP_CREATION_INTENT", "STEP_GUILD_JOIN", "FLOW_TYPE_POST_REG", "STEP_FRIENDS_LIST", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildTemplateAnalytics {
    private static final String FLOW_TYPE_POST_REG = "Mobile NUX Post Reg";
    public static final GuildTemplateAnalytics INSTANCE = new GuildTemplateAnalytics();
    public static final String IN_APP_LOCATION_TEMPLATE = "Create or Join Guild Modal";
    public static final String STEP_CREATION_INTENT = "Server Intent Discovery";
    private static final String STEP_FRIENDS_LIST = "Friends List";
    public static final String STEP_GUILD_CREATE = "Guild Create";
    public static final String STEP_GUILD_JOIN = "Guild Join";
    public static final String STEP_GUILD_TEMPLATE = "Guild Template";
    public static final String STEP_REGISTRATION = "Registration";

    private GuildTemplateAnalytics() {
    }

    public final void postRegistrationSkip$app_productionGoogleRelease(String fromStep) {
        Intrinsics3.checkNotNullParameter(fromStep, "fromStep");
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, FLOW_TYPE_POST_REG, fromStep, STEP_FRIENDS_LIST, null, true, 8, null);
    }

    public final void postRegistrationTransition$app_productionGoogleRelease(String fromStep, String toStep) {
        Intrinsics3.checkNotNullParameter(fromStep, "fromStep");
        Intrinsics3.checkNotNullParameter(toStep, "toStep");
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, FLOW_TYPE_POST_REG, fromStep, toStep, null, false, 24, null);
    }
}
