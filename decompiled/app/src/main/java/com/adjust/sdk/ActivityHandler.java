package com.adjust.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.adjust.sdk.scheduler.TimerCycle;
import com.adjust.sdk.scheduler.TimerOnce;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ActivityHandler implements IActivityHandler {
    private static final String ACTIVITY_STATE_NAME = "Activity state";
    private static final String ATTRIBUTION_NAME = "Attribution";
    private static long BACKGROUND_TIMER_INTERVAL = 0;
    private static final String BACKGROUND_TIMER_NAME = "Background timer";
    private static final String DELAY_START_TIMER_NAME = "Delay Start timer";
    private static long FOREGROUND_TIMER_INTERVAL = 0;
    private static final String FOREGROUND_TIMER_NAME = "Foreground timer";
    private static long FOREGROUND_TIMER_START = 0;
    private static final String SESSION_CALLBACK_PARAMETERS_NAME = "Session Callback parameters";
    private static long SESSION_INTERVAL = 0;
    private static final String SESSION_PARAMETERS_NAME = "Session parameters";
    private static final String SESSION_PARTNER_PARAMETERS_NAME = "Session Partner parameters";
    private static long SUBSESSION_INTERVAL = 0;
    private static final String TIME_TRAVEL = "Time travel!";
    private ActivityState activityState;
    private AdjustConfig adjustConfig;
    private AdjustAttribution attribution;
    private IAttributionHandler attributionHandler;
    private TimerOnce backgroundTimer;
    private String basePath;
    private TimerOnce delayStartTimer;
    private DeviceInfo deviceInfo;
    private ThreadExecutor executor;
    private TimerCycle foregroundTimer;
    private String gdprPath;
    private InstallReferrer installReferrer;
    private InstallReferrerHuawei installReferrerHuawei;
    private InternalState internalState;
    private ILogger logger;
    private IPackageHandler packageHandler;
    private ISdkClickHandler sdkClickHandler;
    private SessionParameters sessionParameters;
    private String subscriptionPath;

    /* renamed from: com.adjust.sdk.ActivityHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            ActivityHandler.access$000(ActivityHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$10, reason: invalid class name */
    public class AnonymousClass10 implements Runnable {
        public final /* synthetic */ long val$installBeginTimestampSeconds;
        public final /* synthetic */ String val$installReferrer;
        public final /* synthetic */ String val$referrerApi;
        public final /* synthetic */ long val$referrerClickTimestampSeconds;

        public AnonymousClass10(String str, long j, long j2, String str2) {
            this.val$installReferrer = str;
            this.val$referrerClickTimestampSeconds = j;
            this.val$installBeginTimestampSeconds = j2;
            this.val$referrerApi = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$1600(ActivityHandler.this, this.val$installReferrer, this.val$referrerClickTimestampSeconds, this.val$installBeginTimestampSeconds, this.val$referrerApi);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$11, reason: invalid class name */
    public class AnonymousClass11 implements Runnable {
        public final /* synthetic */ EventResponseData val$eventResponseData;

        public AnonymousClass11(EventResponseData eventResponseData) {
            this.val$eventResponseData = eventResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$1700(ActivityHandler.this, this.val$eventResponseData);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$12, reason: invalid class name */
    public class AnonymousClass12 implements Runnable {
        public final /* synthetic */ SdkClickResponseData val$sdkClickResponseData;

        public AnonymousClass12(SdkClickResponseData sdkClickResponseData) {
            this.val$sdkClickResponseData = sdkClickResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$1800(ActivityHandler.this, this.val$sdkClickResponseData);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$13, reason: invalid class name */
    public class AnonymousClass13 implements Runnable {
        public final /* synthetic */ SessionResponseData val$sessionResponseData;

        public AnonymousClass13(SessionResponseData sessionResponseData) {
            this.val$sessionResponseData = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$1900(ActivityHandler.this, this.val$sessionResponseData);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$14, reason: invalid class name */
    public class AnonymousClass14 implements Runnable {
        public final /* synthetic */ AttributionResponseData val$attributionResponseData;

        public AnonymousClass14(AttributionResponseData attributionResponseData) {
            this.val$attributionResponseData = attributionResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$2000(ActivityHandler.this, this.val$attributionResponseData);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$15, reason: invalid class name */
    public class AnonymousClass15 implements Runnable {
        public AnonymousClass15() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$2100(ActivityHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$16, reason: invalid class name */
    public class AnonymousClass16 implements Runnable {
        public final /* synthetic */ String val$key;
        public final /* synthetic */ String val$value;

        public AnonymousClass16(String str, String str2) {
            this.val$key = str;
            this.val$value = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.this.addSessionCallbackParameterI(this.val$key, this.val$value);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$17, reason: invalid class name */
    public class AnonymousClass17 implements Runnable {
        public final /* synthetic */ String val$key;
        public final /* synthetic */ String val$value;

        public AnonymousClass17(String str, String str2) {
            this.val$key = str;
            this.val$value = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.this.addSessionPartnerParameterI(this.val$key, this.val$value);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$18, reason: invalid class name */
    public class AnonymousClass18 implements Runnable {
        public final /* synthetic */ String val$key;

        public AnonymousClass18(String str) {
            this.val$key = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.this.removeSessionCallbackParameterI(this.val$key);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$19, reason: invalid class name */
    public class AnonymousClass19 implements Runnable {
        public final /* synthetic */ String val$key;

        public AnonymousClass19(String str) {
            this.val$key = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.this.removeSessionPartnerParameterI(this.val$key);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$100(ActivityHandler.this);
            ActivityHandler.access$200(ActivityHandler.this);
            ActivityHandler.access$300(ActivityHandler.this);
            ActivityHandler.access$400(ActivityHandler.this).verbose("Subsession start", new Object[0]);
            ActivityHandler.access$500(ActivityHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$20, reason: invalid class name */
    public class AnonymousClass20 implements Runnable {
        public AnonymousClass20() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.this.resetSessionCallbackParametersI();
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$21, reason: invalid class name */
    public class AnonymousClass21 implements Runnable {
        public AnonymousClass21() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.this.resetSessionPartnerParametersI();
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$22, reason: invalid class name */
    public class AnonymousClass22 implements Runnable {
        public final /* synthetic */ boolean val$preSaved;
        public final /* synthetic */ String val$token;

        public AnonymousClass22(boolean z2, String str) {
            this.val$preSaved = z2;
            this.val$token = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.val$preSaved) {
                new SharedPreferencesManager(ActivityHandler.this.getContext()).savePushToken(this.val$token);
            }
            if (ActivityHandler.access$900(ActivityHandler.this).hasFirstSdkStartNotOcurred()) {
                return;
            }
            ActivityHandler.access$2200(ActivityHandler.this, this.val$token);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$23, reason: invalid class name */
    public class AnonymousClass23 implements Runnable {
        public AnonymousClass23() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$2300(ActivityHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$24, reason: invalid class name */
    public class AnonymousClass24 implements Runnable {
        public AnonymousClass24() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$2400(ActivityHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$25, reason: invalid class name */
    public class AnonymousClass25 implements Runnable {
        public final /* synthetic */ JSONObject val$adRevenueJson;
        public final /* synthetic */ String val$source;

        public AnonymousClass25(String str, JSONObject jSONObject) {
            this.val$source = str;
            this.val$adRevenueJson = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$2500(ActivityHandler.this, this.val$source, this.val$adRevenueJson);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$26, reason: invalid class name */
    public class AnonymousClass26 implements Runnable {
        public final /* synthetic */ AdjustPlayStoreSubscription val$subscription;

        public AnonymousClass26(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
            this.val$subscription = adjustPlayStoreSubscription;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$2600(ActivityHandler.this, this.val$subscription);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$27, reason: invalid class name */
    public class AnonymousClass27 implements Runnable {
        public AnonymousClass27() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$2700(ActivityHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$28, reason: invalid class name */
    public class AnonymousClass28 implements Runnable {
        public AnonymousClass28() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$2800(ActivityHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$29, reason: invalid class name */
    public class AnonymousClass29 implements Runnable {
        public AnonymousClass29() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$2900(ActivityHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$600(ActivityHandler.this);
            ActivityHandler.access$700(ActivityHandler.this);
            ActivityHandler.access$400(ActivityHandler.this).verbose("Subsession end", new Object[0]);
            ActivityHandler.access$800(ActivityHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$30, reason: invalid class name */
    public class AnonymousClass30 implements IRunActivityHandler {
        public AnonymousClass30() {
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public void run(ActivityHandler activityHandler) {
            ActivityHandler.access$1100(activityHandler, ActivityHandler.access$3000(ActivityHandler.this).startEnabled.booleanValue());
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$31, reason: invalid class name */
    public class AnonymousClass31 implements Runnable {
        public AnonymousClass31() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.this.foregroundTimerFired();
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$32, reason: invalid class name */
    public class AnonymousClass32 implements Runnable {
        public AnonymousClass32() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.this.backgroundTimerFired();
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$33, reason: invalid class name */
    public class AnonymousClass33 implements Runnable {
        public AnonymousClass33() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.this.sendFirstPackages();
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$34, reason: invalid class name */
    public class AnonymousClass34 implements InstallReferrerReadListener {
        public AnonymousClass34() {
        }

        @Override // com.adjust.sdk.InstallReferrerReadListener
        public void onInstallReferrerRead(String str, long j, long j2) {
            ActivityHandler.this.sendInstallReferrer(str, j, j2, "google");
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$35, reason: invalid class name */
    public class AnonymousClass35 implements InstallReferrerReadListener {
        public AnonymousClass35() {
        }

        @Override // com.adjust.sdk.InstallReferrerReadListener
        public void onInstallReferrerRead(String str, long j, long j2) {
            ActivityHandler.this.sendInstallReferrer(str, j, j2, Constants.REFERRER_API_HUAWEI);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$36, reason: invalid class name */
    public class AnonymousClass36 implements Runnable {
        public final /* synthetic */ EventResponseData val$eventResponseData;

        public AnonymousClass36(EventResponseData eventResponseData) {
            this.val$eventResponseData = eventResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityHandler.access$3000(ActivityHandler.this) == null || ActivityHandler.access$3000(ActivityHandler.this).onEventTrackingSucceededListener == null) {
                return;
            }
            ActivityHandler.access$3000(ActivityHandler.this).onEventTrackingSucceededListener.onFinishedEventTrackingSucceeded(this.val$eventResponseData.getSuccessResponseData());
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$37, reason: invalid class name */
    public class AnonymousClass37 implements Runnable {
        public final /* synthetic */ EventResponseData val$eventResponseData;

        public AnonymousClass37(EventResponseData eventResponseData) {
            this.val$eventResponseData = eventResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityHandler.access$3000(ActivityHandler.this) == null || ActivityHandler.access$3000(ActivityHandler.this).onEventTrackingFailedListener == null) {
                return;
            }
            ActivityHandler.access$3000(ActivityHandler.this).onEventTrackingFailedListener.onFinishedEventTrackingFailed(this.val$eventResponseData.getFailureResponseData());
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$38, reason: invalid class name */
    public class AnonymousClass38 implements Runnable {
        public final /* synthetic */ SessionResponseData val$sessionResponseData;

        public AnonymousClass38(SessionResponseData sessionResponseData) {
            this.val$sessionResponseData = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityHandler.access$3000(ActivityHandler.this) == null || ActivityHandler.access$3000(ActivityHandler.this).onSessionTrackingSucceededListener == null) {
                return;
            }
            ActivityHandler.access$3000(ActivityHandler.this).onSessionTrackingSucceededListener.onFinishedSessionTrackingSucceeded(this.val$sessionResponseData.getSuccessResponseData());
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$39, reason: invalid class name */
    public class AnonymousClass39 implements Runnable {
        public final /* synthetic */ SessionResponseData val$sessionResponseData;

        public AnonymousClass39(SessionResponseData sessionResponseData) {
            this.val$sessionResponseData = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityHandler.access$3000(ActivityHandler.this) == null || ActivityHandler.access$3000(ActivityHandler.this).onSessionTrackingFailedListener == null) {
                return;
            }
            ActivityHandler.access$3000(ActivityHandler.this).onSessionTrackingFailedListener.onFinishedSessionTrackingFailed(this.val$sessionResponseData.getFailureResponseData());
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {
        public final /* synthetic */ AdjustEvent val$event;

        public AnonymousClass4(AdjustEvent adjustEvent) {
            this.val$event = adjustEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityHandler.access$900(ActivityHandler.this).hasFirstSdkStartNotOcurred()) {
                ActivityHandler.access$400(ActivityHandler.this).warn("Event tracked before first activity resumed.\nIf it was triggered in the Application class, it might timestamp or even send an install long before the user opens the app.\nPlease check https://github.com/adjust/android_sdk#can-i-trigger-an-event-at-application-launch for more information.", new Object[0]);
                ActivityHandler.access$500(ActivityHandler.this);
            }
            ActivityHandler.access$1000(ActivityHandler.this, this.val$event);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$40, reason: invalid class name */
    public class AnonymousClass40 implements Runnable {
        public AnonymousClass40() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityHandler.access$3000(ActivityHandler.this) == null || ActivityHandler.access$3000(ActivityHandler.this).onAttributionChangedListener == null) {
                return;
            }
            ActivityHandler.access$3000(ActivityHandler.this).onAttributionChangedListener.onAttributionChanged(ActivityHandler.access$3100(ActivityHandler.this));
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$41, reason: invalid class name */
    public class AnonymousClass41 implements Runnable {
        public final /* synthetic */ Uri val$deeplink;
        public final /* synthetic */ Intent val$deeplinkIntent;

        public AnonymousClass41(Uri uri, Intent intent) {
            this.val$deeplink = uri;
            this.val$deeplinkIntent = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActivityHandler.access$3000(ActivityHandler.this) == null) {
                return;
            }
            if (ActivityHandler.access$3000(ActivityHandler.this).onDeeplinkResponseListener != null ? ActivityHandler.access$3000(ActivityHandler.this).onDeeplinkResponseListener.launchReceivedDeeplink(this.val$deeplink) : true) {
                ActivityHandler.access$3200(ActivityHandler.this, this.val$deeplinkIntent, this.val$deeplink);
            }
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$5, reason: invalid class name */
    public class AnonymousClass5 implements Runnable {
        public final /* synthetic */ boolean val$enabled;

        public AnonymousClass5(boolean z2) {
            this.val$enabled = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$1100(ActivityHandler.this, this.val$enabled);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$6, reason: invalid class name */
    public class AnonymousClass6 implements Runnable {
        public final /* synthetic */ boolean val$offline;

        public AnonymousClass6(boolean z2) {
            this.val$offline = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$1200(ActivityHandler.this, this.val$offline);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$7, reason: invalid class name */
    public class AnonymousClass7 implements Runnable {
        public final /* synthetic */ long val$clickTime;
        public final /* synthetic */ Uri val$url;

        public AnonymousClass7(Uri uri, long j) {
            this.val$url = uri;
            this.val$clickTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$1300(ActivityHandler.this, this.val$url, this.val$clickTime);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$8, reason: invalid class name */
    public class AnonymousClass8 implements Runnable {
        public final /* synthetic */ boolean val$askingAttribution;

        public AnonymousClass8(boolean z2) {
            this.val$askingAttribution = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$1400(ActivityHandler.this, this.val$askingAttribution);
        }
    }

    /* renamed from: com.adjust.sdk.ActivityHandler$9, reason: invalid class name */
    public class AnonymousClass9 implements Runnable {
        public AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActivityHandler.access$1500(ActivityHandler.this);
        }
    }

    public class InternalState {
        public boolean background;
        public boolean delayStart;
        public boolean enabled;
        public boolean firstLaunch;
        public boolean firstSdkStart;
        public boolean offline;
        public boolean sessionResponseProcessed;
        public boolean updatePackages;

        public InternalState() {
        }

        public boolean hasFirstSdkStartNotOcurred() {
            return !this.firstSdkStart;
        }

        public boolean hasFirstSdkStartOcurred() {
            return this.firstSdkStart;
        }

        public boolean hasSessionResponseNotBeenProcessed() {
            return !this.sessionResponseProcessed;
        }

        public boolean isDisabled() {
            return !this.enabled;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isFirstLaunch() {
            return this.firstLaunch;
        }

        public boolean isInBackground() {
            return this.background;
        }

        public boolean isInDelayedStart() {
            return this.delayStart;
        }

        public boolean isInForeground() {
            return !this.background;
        }

        public boolean isNotFirstLaunch() {
            return !this.firstLaunch;
        }

        public boolean isNotInDelayedStart() {
            return !this.delayStart;
        }

        public boolean isOffline() {
            return this.offline;
        }

        public boolean isOnline() {
            return !this.offline;
        }

        public boolean itHasToUpdatePackages() {
            return this.updatePackages;
        }
    }

    private ActivityHandler(AdjustConfig adjustConfig) {
        init(adjustConfig);
        ILogger logger = AdjustFactory.getLogger();
        this.logger = logger;
        logger.lockLogLevel();
        this.executor = new SingleThreadCachedScheduler("ActivityHandler");
        InternalState internalState = new InternalState();
        this.internalState = internalState;
        Boolean bool = adjustConfig.startEnabled;
        internalState.enabled = bool != null ? bool.booleanValue() : true;
        InternalState internalState2 = this.internalState;
        internalState2.offline = adjustConfig.startOffline;
        internalState2.background = true;
        internalState2.delayStart = false;
        internalState2.updatePackages = false;
        internalState2.sessionResponseProcessed = false;
        internalState2.firstSdkStart = false;
        this.executor.submit(new AnonymousClass1());
    }

    public static /* synthetic */ void access$000(ActivityHandler activityHandler) throws IOException {
        activityHandler.initI();
    }

    public static /* synthetic */ void access$100(ActivityHandler activityHandler) {
        activityHandler.delayStartI();
    }

    public static /* synthetic */ void access$1000(ActivityHandler activityHandler, AdjustEvent adjustEvent) {
        activityHandler.trackEventI(adjustEvent);
    }

    public static /* synthetic */ void access$1100(ActivityHandler activityHandler, boolean z2) {
        activityHandler.setEnabledI(z2);
    }

    public static /* synthetic */ void access$1200(ActivityHandler activityHandler, boolean z2) {
        activityHandler.setOfflineModeI(z2);
    }

    public static /* synthetic */ void access$1300(ActivityHandler activityHandler, Uri uri, long j) {
        activityHandler.readOpenUrlI(uri, j);
    }

    public static /* synthetic */ void access$1400(ActivityHandler activityHandler, boolean z2) {
        activityHandler.setAskingAttributionI(z2);
    }

    public static /* synthetic */ void access$1500(ActivityHandler activityHandler) {
        activityHandler.sendReftagReferrerI();
    }

    public static /* synthetic */ void access$1600(ActivityHandler activityHandler, String str, long j, long j2, String str2) {
        activityHandler.sendInstallReferrerI(str, j, j2, str2);
    }

    public static /* synthetic */ void access$1700(ActivityHandler activityHandler, EventResponseData eventResponseData) {
        activityHandler.launchEventResponseTasksI(eventResponseData);
    }

    public static /* synthetic */ void access$1800(ActivityHandler activityHandler, SdkClickResponseData sdkClickResponseData) {
        activityHandler.launchSdkClickResponseTasksI(sdkClickResponseData);
    }

    public static /* synthetic */ void access$1900(ActivityHandler activityHandler, SessionResponseData sessionResponseData) {
        activityHandler.launchSessionResponseTasksI(sessionResponseData);
    }

    public static /* synthetic */ void access$200(ActivityHandler activityHandler) {
        activityHandler.stopBackgroundTimerI();
    }

    public static /* synthetic */ void access$2000(ActivityHandler activityHandler, AttributionResponseData attributionResponseData) {
        activityHandler.launchAttributionResponseTasksI(attributionResponseData);
    }

    public static /* synthetic */ void access$2100(ActivityHandler activityHandler) {
        activityHandler.sendFirstPackagesI();
    }

    public static /* synthetic */ void access$2200(ActivityHandler activityHandler, String str) {
        activityHandler.setPushTokenI(str);
    }

    public static /* synthetic */ void access$2300(ActivityHandler activityHandler) {
        activityHandler.gdprForgetMeI();
    }

    public static /* synthetic */ void access$2400(ActivityHandler activityHandler) {
        activityHandler.disableThirdPartySharingI();
    }

    public static /* synthetic */ void access$2500(ActivityHandler activityHandler, String str, JSONObject jSONObject) {
        activityHandler.trackAdRevenueI(str, jSONObject);
    }

    public static /* synthetic */ void access$2600(ActivityHandler activityHandler, AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        activityHandler.trackSubscriptionI(adjustPlayStoreSubscription);
    }

    public static /* synthetic */ void access$2700(ActivityHandler activityHandler) {
        activityHandler.gotOptOutResponseI();
    }

    public static /* synthetic */ void access$2800(ActivityHandler activityHandler) {
        activityHandler.foregroundTimerFiredI();
    }

    public static /* synthetic */ void access$2900(ActivityHandler activityHandler) {
        activityHandler.backgroundTimerFiredI();
    }

    public static /* synthetic */ void access$300(ActivityHandler activityHandler) {
        activityHandler.startForegroundTimerI();
    }

    public static /* synthetic */ AdjustConfig access$3000(ActivityHandler activityHandler) {
        return activityHandler.adjustConfig;
    }

    public static /* synthetic */ AdjustAttribution access$3100(ActivityHandler activityHandler) {
        return activityHandler.attribution;
    }

    public static /* synthetic */ void access$3200(ActivityHandler activityHandler, Intent intent, Uri uri) {
        activityHandler.launchDeeplinkMain(intent, uri);
    }

    public static /* synthetic */ ILogger access$400(ActivityHandler activityHandler) {
        return activityHandler.logger;
    }

    public static /* synthetic */ void access$500(ActivityHandler activityHandler) {
        activityHandler.startI();
    }

    public static /* synthetic */ void access$600(ActivityHandler activityHandler) {
        activityHandler.stopForegroundTimerI();
    }

    public static /* synthetic */ void access$700(ActivityHandler activityHandler) {
        activityHandler.startBackgroundTimerI();
    }

    public static /* synthetic */ void access$800(ActivityHandler activityHandler) {
        activityHandler.endI();
    }

    public static /* synthetic */ InternalState access$900(ActivityHandler activityHandler) {
        return activityHandler.internalState;
    }

    private void backgroundTimerFiredI() {
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
    }

    private boolean checkActivityStateI(ActivityState activityState) {
        if (!this.internalState.hasFirstSdkStartNotOcurred()) {
            return true;
        }
        this.logger.error("Sdk did not yet start", new Object[0]);
        return false;
    }

    private void checkAfterNewStartI() {
        checkAfterNewStartI(new SharedPreferencesManager(getContext()));
    }

    private void checkAttributionStateI() {
        if (checkActivityStateI(this.activityState)) {
            if (this.internalState.isFirstLaunch() && this.internalState.hasSessionResponseNotBeenProcessed()) {
                return;
            }
            if (this.attribution == null || this.activityState.askingAttribution) {
                this.attributionHandler.getAttribution();
            }
        }
    }

    private boolean checkEventI(AdjustEvent adjustEvent) {
        if (adjustEvent == null) {
            this.logger.error("Event missing", new Object[0]);
            return false;
        }
        if (adjustEvent.isValid()) {
            return true;
        }
        this.logger.error("Event not initialized correctly", new Object[0]);
        return false;
    }

    private void checkForInstallReferrerInfo(SdkClickResponseData sdkClickResponseData) {
        if (sdkClickResponseData.isInstallReferrer) {
            String str = sdkClickResponseData.referrerApi;
            if (str != null && str.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI)) {
                ActivityState activityState = this.activityState;
                activityState.clickTimeHuawei = sdkClickResponseData.clickTime;
                activityState.installBeginHuawei = sdkClickResponseData.installBegin;
                activityState.installReferrerHuawei = sdkClickResponseData.installReferrer;
            } else {
                ActivityState activityState2 = this.activityState;
                activityState2.clickTime = sdkClickResponseData.clickTime;
                activityState2.installBegin = sdkClickResponseData.installBegin;
                activityState2.installReferrer = sdkClickResponseData.installReferrer;
            }
            writeActivityStateI();
        }
    }

    private boolean checkOrderIdI(String str) {
        if (str != null && !str.isEmpty()) {
            if (this.activityState.findOrderId(str)) {
                this.logger.info("Skipping duplicated order ID '%s'", str);
                return false;
            }
            this.activityState.addOrderId(str);
            this.logger.verbose("Added order ID '%s'", str);
        }
        return true;
    }

    private Intent createDeeplinkIntentI(Uri uri) {
        Intent intent;
        if (this.adjustConfig.deepLinkComponent == null) {
            intent = new Intent("android.intent.action.VIEW", uri);
        } else {
            AdjustConfig adjustConfig = this.adjustConfig;
            intent = new Intent("android.intent.action.VIEW", uri, adjustConfig.context, adjustConfig.deepLinkComponent);
        }
        intent.setFlags(268435456);
        intent.setPackage(this.adjustConfig.context.getPackageName());
        return intent;
    }

    private void delayStartI() {
        if (this.internalState.isNotInDelayedStart() || isToUpdatePackagesI()) {
            return;
        }
        Double d = this.adjustConfig.delayStart;
        double dDoubleValue = d != null ? d.doubleValue() : 0.0d;
        long maxDelayStart = AdjustFactory.getMaxDelayStart();
        long j = (long) (1000.0d * dDoubleValue);
        if (j > maxDelayStart) {
            double d2 = maxDelayStart / 1000;
            DecimalFormat decimalFormat = Util.SecondsDisplayFormat;
            this.logger.warn("Delay start of %s seconds bigger than max allowed value of %s seconds", decimalFormat.format(dDoubleValue), decimalFormat.format(d2));
            dDoubleValue = d2;
        } else {
            maxDelayStart = j;
        }
        this.logger.info("Waiting %s seconds before starting first session", Util.SecondsDisplayFormat.format(dDoubleValue));
        this.delayStartTimer.startIn(maxDelayStart);
        this.internalState.updatePackages = true;
        ActivityState activityState = this.activityState;
        if (activityState != null) {
            activityState.updatePackages = true;
            writeActivityStateI();
        }
    }

    public static boolean deleteActivityState(Context context) {
        return context.deleteFile(Constants.ACTIVITY_STATE_FILENAME);
    }

    public static boolean deleteAttribution(Context context) {
        return context.deleteFile(Constants.ATTRIBUTION_FILENAME);
    }

    public static boolean deleteSessionCallbackParameters(Context context) {
        return context.deleteFile(Constants.SESSION_CALLBACK_PARAMETERS_FILENAME);
    }

    public static boolean deleteSessionPartnerParameters(Context context) {
        return context.deleteFile(Constants.SESSION_PARTNER_PARAMETERS_FILENAME);
    }

    public static void deleteState(Context context) {
        deleteActivityState(context);
        deleteAttribution(context);
        deleteSessionCallbackParameters(context);
        deleteSessionPartnerParameters(context);
        new SharedPreferencesManager(context).clear();
    }

    private void disableThirdPartySharingI() {
        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
        sharedPreferencesManager.setDisableThirdPartySharing();
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState = this.activityState;
            if (activityState.isGdprForgotten || activityState.isThirdPartySharingDisabled) {
                return;
            }
            activityState.isThirdPartySharingDisabled = true;
            writeActivityStateI();
            ActivityPackage activityPackageBuildDisableThirdPartySharingPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildDisableThirdPartySharingPackage();
            this.packageHandler.addPackage(activityPackageBuildDisableThirdPartySharingPackage);
            sharedPreferencesManager.removeDisableThirdPartySharing();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", activityPackageBuildDisableThirdPartySharingPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    private void endI() {
        if (!toSendI()) {
            pauseSendingI();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    private void foregroundTimerFiredI() {
        if (!isEnabledI()) {
            stopForegroundTimerI();
            return;
        }
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    private void gdprForgetMeI() {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState = this.activityState;
            if (activityState.isGdprForgotten) {
                return;
            }
            activityState.isGdprForgotten = true;
            writeActivityStateI();
            ActivityPackage activityPackageBuildGdprPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildGdprPackage();
            this.packageHandler.addPackage(activityPackageBuildGdprPackage);
            new SharedPreferencesManager(getContext()).removeGdprForgetMe();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", activityPackageBuildGdprPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    public static ActivityHandler getInstance(AdjustConfig adjustConfig) {
        if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
            return null;
        }
        if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
            return null;
        }
        if (adjustConfig.processName != null) {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) adjustConfig.context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (activityManager != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        if (!next.processName.equalsIgnoreCase(adjustConfig.processName)) {
                            AdjustFactory.getLogger().info("Skipping initialization in background process (%s)", next.processName);
                            return null;
                        }
                    }
                }
            } else {
                return null;
            }
        }
        return new ActivityHandler(adjustConfig);
    }

    private void gotOptOutResponseI() {
        this.activityState.isGdprForgotten = true;
        writeActivityStateI();
        this.packageHandler.flush();
        setEnabledI(false);
    }

    private boolean hasChangedStateI(boolean z2, boolean z3, String str, String str2) {
        if (z2 != z3) {
            return true;
        }
        if (z2) {
            this.logger.debug(str, new Object[0]);
        } else {
            this.logger.debug(str2, new Object[0]);
        }
        return false;
    }

    private void initI() throws IOException {
        Double d;
        SESSION_INTERVAL = AdjustFactory.getSessionInterval();
        SUBSESSION_INTERVAL = AdjustFactory.getSubsessionInterval();
        FOREGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        FOREGROUND_TIMER_START = AdjustFactory.getTimerStart();
        BACKGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        readAttributionI(this.adjustConfig.context);
        readActivityStateI(this.adjustConfig.context);
        this.sessionParameters = new SessionParameters();
        readSessionCallbackParametersI(this.adjustConfig.context);
        readSessionPartnerParametersI(this.adjustConfig.context);
        AdjustConfig adjustConfig = this.adjustConfig;
        if (adjustConfig.startEnabled != null) {
            if (adjustConfig.preLaunchActionsArray == null) {
                adjustConfig.preLaunchActionsArray = new ArrayList();
            }
            this.adjustConfig.preLaunchActionsArray.add(new AnonymousClass30());
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            InternalState internalState = this.internalState;
            ActivityState activityState = this.activityState;
            internalState.enabled = activityState.enabled;
            internalState.updatePackages = activityState.updatePackages;
            internalState.firstLaunch = false;
        } else {
            this.internalState.firstLaunch = true;
        }
        readConfigFile(this.adjustConfig.context);
        AdjustConfig adjustConfig2 = this.adjustConfig;
        this.deviceInfo = new DeviceInfo(adjustConfig2.context, adjustConfig2.sdkPrefix);
        if (this.adjustConfig.eventBufferingEnabled) {
            this.logger.info("Event buffering is enabled", new Object[0]);
        }
        this.deviceInfo.reloadPlayIds(this.adjustConfig.context);
        if (this.deviceInfo.playAdId == null) {
            this.logger.warn("Unable to get Google Play Services Advertising ID at start time", new Object[0]);
            DeviceInfo deviceInfo = this.deviceInfo;
            if (deviceInfo.macSha1 == null && deviceInfo.macShortMd5 == null && deviceInfo.androidId == null) {
                this.logger.error("Unable to get any device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
            }
        } else {
            this.logger.info("Google Play Services Advertising ID read correctly at start time", new Object[0]);
        }
        String str = this.adjustConfig.defaultTracker;
        if (str != null) {
            this.logger.info("Default tracker: '%s'", str);
        }
        String str2 = this.adjustConfig.pushToken;
        if (str2 != null) {
            this.logger.info("Push token: '%s'", str2);
            if (this.internalState.hasFirstSdkStartOcurred()) {
                setPushToken(this.adjustConfig.pushToken, false);
            } else {
                new SharedPreferencesManager(getContext()).savePushToken(this.adjustConfig.pushToken);
            }
        } else if (this.internalState.hasFirstSdkStartOcurred()) {
            setPushToken(new SharedPreferencesManager(getContext()).getPushToken(), true);
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
            if (sharedPreferencesManager.getGdprForgetMe()) {
                gdprForgetMe();
            } else if (sharedPreferencesManager.getDisableThirdPartySharing()) {
                disableThirdPartySharing();
            }
        }
        this.foregroundTimer = new TimerCycle(new AnonymousClass31(), FOREGROUND_TIMER_START, FOREGROUND_TIMER_INTERVAL, FOREGROUND_TIMER_NAME);
        if (this.adjustConfig.sendInBackground) {
            this.logger.info("Send in background configured", new Object[0]);
            this.backgroundTimer = new TimerOnce(new AnonymousClass32(), BACKGROUND_TIMER_NAME);
        }
        if (this.internalState.hasFirstSdkStartNotOcurred() && (d = this.adjustConfig.delayStart) != null && d.doubleValue() > 0.0d) {
            this.logger.info("Delay start configured", new Object[0]);
            this.internalState.delayStart = true;
            this.delayStartTimer = new TimerOnce(new AnonymousClass33(), DELAY_START_TIMER_NAME);
        }
        UtilNetworking.setUserAgent(this.adjustConfig.userAgent);
        AdjustConfig adjustConfig3 = this.adjustConfig;
        this.basePath = adjustConfig3.basePath;
        this.gdprPath = adjustConfig3.gdprPath;
        this.subscriptionPath = adjustConfig3.subscriptionPath;
        this.packageHandler = AdjustFactory.getPackageHandler(this, adjustConfig3.context, toSendI(false));
        this.attributionHandler = AdjustFactory.getAttributionHandler(this, toSendI(false));
        this.sdkClickHandler = AdjustFactory.getSdkClickHandler(this, toSendI(true));
        if (isToUpdatePackagesI()) {
            updatePackagesI();
        }
        this.installReferrer = new InstallReferrer(this.adjustConfig.context, new AnonymousClass34());
        this.installReferrerHuawei = new InstallReferrerHuawei(this.adjustConfig.context, new AnonymousClass35());
        preLaunchActionsI(this.adjustConfig.preLaunchActionsArray);
        sendReftagReferrerI();
    }

    private boolean isEnabledI() {
        ActivityState activityState = this.activityState;
        return activityState != null ? activityState.enabled : this.internalState.isEnabled();
    }

    private boolean isToUpdatePackagesI() {
        ActivityState activityState = this.activityState;
        return activityState != null ? activityState.updatePackages : this.internalState.itHasToUpdatePackages();
    }

    private void launchAttributionListenerI(Handler handler) {
        if (this.adjustConfig.onAttributionChangedListener == null) {
            return;
        }
        handler.post(new AnonymousClass40());
    }

    private void launchAttributionResponseTasksI(AttributionResponseData attributionResponseData) {
        updateAdidI(attributionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(attributionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        prepareDeeplinkI(attributionResponseData.deeplink, handler);
    }

    private void launchDeeplinkMain(Intent intent, Uri uri) {
        if (!(this.adjustConfig.context.getPackageManager().queryIntentActivities(intent, 0).size() > 0)) {
            this.logger.error("Unable to open deferred deep link (%s)", uri);
        } else {
            this.logger.info("Open deferred deep link (%s)", uri);
            this.adjustConfig.context.startActivity(intent);
        }
    }

    private void launchEventResponseTasksI(EventResponseData eventResponseData) {
        updateAdidI(eventResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        boolean z2 = eventResponseData.success;
        if (z2 && this.adjustConfig.onEventTrackingSucceededListener != null) {
            this.logger.debug("Launching success event tracking listener", new Object[0]);
            handler.post(new AnonymousClass36(eventResponseData));
        } else {
            if (z2 || this.adjustConfig.onEventTrackingFailedListener == null) {
                return;
            }
            this.logger.debug("Launching failed event tracking listener", new Object[0]);
            handler.post(new AnonymousClass37(eventResponseData));
        }
    }

    private void launchSdkClickResponseTasksI(SdkClickResponseData sdkClickResponseData) {
        updateAdidI(sdkClickResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sdkClickResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
    }

    private void launchSessionResponseListenerI(SessionResponseData sessionResponseData, Handler handler) {
        boolean z2 = sessionResponseData.success;
        if (z2 && this.adjustConfig.onSessionTrackingSucceededListener != null) {
            this.logger.debug("Launching success session tracking listener", new Object[0]);
            handler.post(new AnonymousClass38(sessionResponseData));
        } else {
            if (z2 || this.adjustConfig.onSessionTrackingFailedListener == null) {
                return;
            }
            this.logger.debug("Launching failed session tracking listener", new Object[0]);
            handler.post(new AnonymousClass39(sessionResponseData));
        }
    }

    private void launchSessionResponseTasksI(SessionResponseData sessionResponseData) {
        updateAdidI(sessionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sessionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        if (this.attribution == null && !this.activityState.askingAttribution) {
            this.attributionHandler.getAttribution();
        }
        if (sessionResponseData.success) {
            new SharedPreferencesManager(getContext()).setInstallTracked();
        }
        launchSessionResponseListenerI(sessionResponseData, handler);
        this.internalState.sessionResponseProcessed = true;
    }

    private void pauseSendingI() {
        this.attributionHandler.pauseSending();
        this.packageHandler.pauseSending();
        if (toSendI(true)) {
            this.sdkClickHandler.resumeSending();
        } else {
            this.sdkClickHandler.pauseSending();
        }
    }

    private boolean pausedI() {
        return pausedI(false);
    }

    private void preLaunchActionsI(List<IRunActivityHandler> list) {
        if (list == null) {
            return;
        }
        Iterator<IRunActivityHandler> it = list.iterator();
        while (it.hasNext()) {
            it.next().run(this);
        }
    }

    private void prepareDeeplinkI(Uri uri, Handler handler) {
        if (uri == null) {
            return;
        }
        this.logger.info("Deferred deeplink received (%s)", uri);
        handler.post(new AnonymousClass41(uri, createDeeplinkIntentI(uri)));
    }

    private void processCachedDeeplinkI() {
        if (checkActivityStateI(this.activityState)) {
            SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
            String deeplinkUrl = sharedPreferencesManager.getDeeplinkUrl();
            long deeplinkClickTime = sharedPreferencesManager.getDeeplinkClickTime();
            if (deeplinkUrl == null || deeplinkClickTime == -1) {
                return;
            }
            readOpenUrl(Uri.parse(deeplinkUrl), deeplinkClickTime);
            sharedPreferencesManager.removeDeeplink();
        }
    }

    private void processSessionI() {
        if (this.activityState.isGdprForgotten) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ActivityState activityState = this.activityState;
        long j = jCurrentTimeMillis - activityState.lastActivity;
        if (j < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            this.activityState.lastActivity = jCurrentTimeMillis;
            writeActivityStateI();
            return;
        }
        if (j > SESSION_INTERVAL) {
            trackNewSessionI(jCurrentTimeMillis);
            checkAfterNewStartI();
            return;
        }
        if (j <= SUBSESSION_INTERVAL) {
            this.logger.verbose("Time span since last activity too short for a new subsession", new Object[0]);
            return;
        }
        int i = activityState.subsessionCount + 1;
        activityState.subsessionCount = i;
        activityState.sessionLength += j;
        activityState.lastActivity = jCurrentTimeMillis;
        this.logger.verbose("Started subsession %d of session %d", Integer.valueOf(i), Integer.valueOf(this.activityState.sessionCount));
        writeActivityStateI();
        this.installReferrer.startConnection();
        this.installReferrerHuawei.readReferrer();
    }

    private void readActivityStateI(Context context) {
        try {
            this.activityState = (ActivityState) Util.readObject(context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME, ActivityState.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", ACTIVITY_STATE_NAME, e.getMessage());
            this.activityState = null;
        }
        if (this.activityState != null) {
            this.internalState.firstSdkStart = true;
        }
    }

    private void readAttributionI(Context context) {
        try {
            this.attribution = (AdjustAttribution) Util.readObject(context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME, AdjustAttribution.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", ATTRIBUTION_NAME, e.getMessage());
            this.attribution = null;
        }
    }

    private void readConfigFile(Context context) throws IOException {
        try {
            InputStream inputStreamOpen = context.getAssets().open("adjust_config.properties");
            Properties properties = new Properties();
            properties.load(inputStreamOpen);
            this.logger.verbose("adjust_config.properties file read and loaded", new Object[0]);
            String property = properties.getProperty("defaultTracker");
            if (property != null) {
                this.adjustConfig.defaultTracker = property;
            }
        } catch (Exception e) {
            this.logger.debug("%s file not found in this app", e.getMessage());
        }
    }

    private void readOpenUrlI(Uri uri, long j) {
        if (isEnabledI()) {
            if (!Util.isUrlFilteredOut(uri)) {
                ActivityPackage activityPackageBuildDeeplinkSdkClickPackage = PackageFactory.buildDeeplinkSdkClickPackage(uri, j, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters);
                if (activityPackageBuildDeeplinkSdkClickPackage == null) {
                    return;
                }
                this.sdkClickHandler.sendSdkClick(activityPackageBuildDeeplinkSdkClickPackage);
                return;
            }
            ILogger iLogger = this.logger;
            StringBuilder sbU = outline.U("Deep link (");
            sbU.append(uri.toString());
            sbU.append(") processing skipped");
            iLogger.debug(sbU.toString(), new Object[0]);
        }
    }

    private void readSessionCallbackParametersI(Context context) {
        try {
            this.sessionParameters.callbackParameters = (Map) Util.readObject(context, Constants.SESSION_CALLBACK_PARAMETERS_FILENAME, SESSION_CALLBACK_PARAMETERS_NAME, Map.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", SESSION_CALLBACK_PARAMETERS_NAME, e.getMessage());
            this.sessionParameters.callbackParameters = null;
        }
    }

    private void readSessionPartnerParametersI(Context context) {
        try {
            this.sessionParameters.partnerParameters = (Map) Util.readObject(context, Constants.SESSION_PARTNER_PARAMETERS_FILENAME, SESSION_PARTNER_PARAMETERS_NAME, Map.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", SESSION_PARTNER_PARAMETERS_NAME, e.getMessage());
            this.sessionParameters.partnerParameters = null;
        }
    }

    private void resumeSendingI() {
        this.attributionHandler.resumeSending();
        this.packageHandler.resumeSending();
        this.sdkClickHandler.resumeSending();
    }

    private void sendFirstPackagesI() {
        if (this.internalState.isNotInDelayedStart()) {
            this.logger.info("Start delay expired or never configured", new Object[0]);
            return;
        }
        updatePackagesI();
        this.internalState.delayStart = false;
        this.delayStartTimer.cancel();
        this.delayStartTimer = null;
        updateHandlersStatusAndSendI();
    }

    private void sendInstallReferrerI(String str, long j, long j2, String str2) {
        if (isEnabledI() && str != null) {
            if (str2.equals("google")) {
                ActivityState activityState = this.activityState;
                if (j == activityState.clickTime && j2 == activityState.installBegin && str.equals(activityState.installReferrer)) {
                    return;
                }
            } else if (str2.equals(Constants.REFERRER_API_HUAWEI)) {
                ActivityState activityState2 = this.activityState;
                if (j == activityState2.clickTimeHuawei && j2 == activityState2.installBeginHuawei && str.equals(activityState2.installReferrerHuawei)) {
                    return;
                }
            }
            this.sdkClickHandler.sendSdkClick(PackageFactory.buildInstallReferrerSdkClickPackage(str, j, j2, str2, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters));
        }
    }

    private void sendReftagReferrerI() {
        if (isEnabledI() && !this.internalState.hasFirstSdkStartNotOcurred()) {
            this.sdkClickHandler.sendReftagReferrers();
        }
    }

    private void setAskingAttributionI(boolean z2) {
        this.activityState.askingAttribution = z2;
        writeActivityStateI();
    }

    private void setEnabledI(boolean z2) {
        ActivityState activityState;
        if (hasChangedStateI(isEnabledI(), z2, "Adjust already enabled", "Adjust already disabled")) {
            if (z2 && (activityState = this.activityState) != null && activityState.isGdprForgotten) {
                this.logger.error("Re-enabling SDK not possible for forgotten user", new Object[0]);
                return;
            }
            InternalState internalState = this.internalState;
            internalState.enabled = z2;
            if (internalState.hasFirstSdkStartNotOcurred()) {
                updateStatusI(!z2, "Handlers will start as paused due to the SDK being disabled", "Handlers will still start as paused", "Handlers will start as active due to the SDK being enabled");
                return;
            }
            this.activityState.enabled = z2;
            writeActivityStateI();
            if (z2) {
                SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
                if (sharedPreferencesManager.getGdprForgetMe()) {
                    gdprForgetMeI();
                } else if (sharedPreferencesManager.getDisableThirdPartySharing()) {
                    disableThirdPartySharingI();
                }
                if (!sharedPreferencesManager.getInstallTracked()) {
                    trackNewSessionI(System.currentTimeMillis());
                }
                checkAfterNewStartI(sharedPreferencesManager);
            }
            updateStatusI(!z2, "Pausing handlers due to SDK being disabled", "Handlers remain paused", "Resuming handlers due to SDK being enabled");
        }
    }

    private void setOfflineModeI(boolean z2) {
        if (hasChangedStateI(this.internalState.isOffline(), z2, "Adjust already in offline mode", "Adjust already in online mode")) {
            InternalState internalState = this.internalState;
            internalState.offline = z2;
            if (internalState.hasFirstSdkStartNotOcurred()) {
                updateStatusI(z2, "Handlers will start paused due to SDK being offline", "Handlers will still start as paused", "Handlers will start as active due to SDK being online");
            } else {
                updateStatusI(z2, "Pausing handlers to put SDK offline mode", "Handlers remain paused", "Resuming handlers to put SDK in online mode");
            }
        }
    }

    private void setPushTokenI(String str) {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState = this.activityState;
            if (activityState.isGdprForgotten || str == null || str.equals(activityState.pushToken)) {
                return;
            }
            this.activityState.pushToken = str;
            writeActivityStateI();
            ActivityPackage activityPackageBuildInfoPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildInfoPackage(Constants.PUSH);
            this.packageHandler.addPackage(activityPackageBuildInfoPackage);
            new SharedPreferencesManager(getContext()).removePushToken();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", activityPackageBuildInfoPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    private void startBackgroundTimerI() {
        if (this.backgroundTimer != null && toSendI() && this.backgroundTimer.getFireIn() <= 0) {
            this.backgroundTimer.startIn(BACKGROUND_TIMER_INTERVAL);
        }
    }

    private void startFirstSessionI() {
        this.activityState = new ActivityState();
        this.internalState.firstSdkStart = true;
        updateHandlersStatusAndSendI();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(getContext());
        this.activityState.pushToken = sharedPreferencesManager.getPushToken();
        if (this.internalState.isEnabled()) {
            if (sharedPreferencesManager.getGdprForgetMe()) {
                gdprForgetMeI();
            } else {
                if (sharedPreferencesManager.getDisableThirdPartySharing()) {
                    disableThirdPartySharingI();
                }
                this.activityState.sessionCount = 1;
                transferSessionPackageI(jCurrentTimeMillis);
                checkAfterNewStartI(sharedPreferencesManager);
            }
        }
        this.activityState.resetSessionAttributes(jCurrentTimeMillis);
        this.activityState.enabled = this.internalState.isEnabled();
        this.activityState.updatePackages = this.internalState.itHasToUpdatePackages();
        writeActivityStateI();
        sharedPreferencesManager.removePushToken();
        sharedPreferencesManager.removeGdprForgetMe();
        sharedPreferencesManager.removeDisableThirdPartySharing();
        processCachedDeeplinkI();
    }

    private void startForegroundTimerI() {
        if (isEnabledI()) {
            this.foregroundTimer.start();
        }
    }

    private void startI() {
        if (this.internalState.hasFirstSdkStartNotOcurred()) {
            AdjustSigner.onResume(this.adjustConfig.logger);
            startFirstSessionI();
        } else if (this.activityState.enabled) {
            AdjustSigner.onResume(this.adjustConfig.logger);
            updateHandlersStatusAndSendI();
            processSessionI();
            checkAttributionStateI();
            processCachedDeeplinkI();
        }
    }

    private void stopBackgroundTimerI() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce == null) {
            return;
        }
        timerOnce.cancel();
    }

    private void stopForegroundTimerI() {
        this.foregroundTimer.suspend();
    }

    private void teardownActivityStateS() {
        synchronized (ActivityState.class) {
            if (this.activityState == null) {
                return;
            }
            this.activityState = null;
        }
    }

    private void teardownAllSessionParametersS() {
        synchronized (SessionParameters.class) {
            if (this.sessionParameters == null) {
                return;
            }
            this.sessionParameters = null;
        }
    }

    private void teardownAttributionS() {
        synchronized (AdjustAttribution.class) {
            if (this.attribution == null) {
                return;
            }
            this.attribution = null;
        }
    }

    private boolean toSendI() {
        return toSendI(false);
    }

    private void trackAdRevenueI(String str, JSONObject jSONObject) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildAdRevenuePackage(str, jSONObject));
            this.packageHandler.sendFirstPackage();
        }
    }

    private void trackEventI(AdjustEvent adjustEvent) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkEventI(adjustEvent) && checkOrderIdI(adjustEvent.orderId) && !this.activityState.isGdprForgotten) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.activityState.eventCount++;
            updateActivityStateI(jCurrentTimeMillis);
            ActivityPackage activityPackageBuildEventPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, jCurrentTimeMillis).buildEventPackage(adjustEvent, this.internalState.isInDelayedStart());
            this.packageHandler.addPackage(activityPackageBuildEventPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", activityPackageBuildEventPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
            if (this.adjustConfig.sendInBackground && this.internalState.isInBackground()) {
                startBackgroundTimerI();
            }
            writeActivityStateI();
        }
    }

    private void trackNewSessionI(long j) {
        ActivityState activityState = this.activityState;
        long j2 = j - activityState.lastActivity;
        activityState.sessionCount++;
        activityState.lastInterval = j2;
        transferSessionPackageI(j);
        this.activityState.resetSessionAttributes(j);
        writeActivityStateI();
    }

    private void trackSubscriptionI(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildSubscriptionPackage(adjustPlayStoreSubscription, this.internalState.isInDelayedStart()));
            this.packageHandler.sendFirstPackage();
        }
    }

    private void transferSessionPackageI(long j) {
        this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, j).buildSessionPackage(this.internalState.isInDelayedStart()));
        this.packageHandler.sendFirstPackage();
    }

    private boolean updateActivityStateI(long j) {
        if (!checkActivityStateI(this.activityState)) {
            return false;
        }
        ActivityState activityState = this.activityState;
        long j2 = j - activityState.lastActivity;
        if (j2 > SESSION_INTERVAL) {
            return false;
        }
        activityState.lastActivity = j;
        if (j2 < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            return true;
        }
        activityState.sessionLength += j2;
        activityState.timeSpent += j2;
        return true;
    }

    private void updateAdidI(String str) {
        if (str == null || str.equals(this.activityState.adid)) {
            return;
        }
        this.activityState.adid = str;
        writeActivityStateI();
    }

    private void updateHandlersStatusAndSendI() {
        if (!toSendI()) {
            pauseSendingI();
            return;
        }
        resumeSendingI();
        if (!this.adjustConfig.eventBufferingEnabled || (this.internalState.isFirstLaunch() && this.internalState.hasSessionResponseNotBeenProcessed())) {
            this.packageHandler.sendFirstPackage();
        }
    }

    private void updatePackagesI() {
        this.packageHandler.updatePackages(this.sessionParameters);
        this.internalState.updatePackages = false;
        ActivityState activityState = this.activityState;
        if (activityState != null) {
            activityState.updatePackages = false;
            writeActivityStateI();
        }
    }

    private void updateStatusI(boolean z2, String str, String str2, String str3) {
        if (z2) {
            this.logger.info(str, new Object[0]);
        } else if (!pausedI(false)) {
            this.logger.info(str3, new Object[0]);
        } else if (pausedI(true)) {
            this.logger.info(str2, new Object[0]);
        } else {
            this.logger.info(outline.w(str2, ", except the Sdk Click Handler"), new Object[0]);
        }
        updateHandlersStatusAndSendI();
    }

    private void writeActivityStateI() {
        synchronized (ActivityState.class) {
            ActivityState activityState = this.activityState;
            if (activityState == null) {
                return;
            }
            Util.writeObject(activityState, this.adjustConfig.context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME);
        }
    }

    private void writeAttributionI() {
        synchronized (AdjustAttribution.class) {
            AdjustAttribution adjustAttribution = this.attribution;
            if (adjustAttribution == null) {
                return;
            }
            Util.writeObject(adjustAttribution, this.adjustConfig.context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME);
        }
    }

    private void writeSessionCallbackParametersI() {
        synchronized (SessionParameters.class) {
            SessionParameters sessionParameters = this.sessionParameters;
            if (sessionParameters == null) {
                return;
            }
            Util.writeObject(sessionParameters.callbackParameters, this.adjustConfig.context, Constants.SESSION_CALLBACK_PARAMETERS_FILENAME, SESSION_CALLBACK_PARAMETERS_NAME);
        }
    }

    private void writeSessionPartnerParametersI() {
        synchronized (SessionParameters.class) {
            SessionParameters sessionParameters = this.sessionParameters;
            if (sessionParameters == null) {
                return;
            }
            Util.writeObject(sessionParameters.partnerParameters, this.adjustConfig.context, Constants.SESSION_PARTNER_PARAMETERS_FILENAME, SESSION_PARTNER_PARAMETERS_NAME);
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void addSessionCallbackParameter(String str, String str2) {
        this.executor.submit(new AnonymousClass16(str, str2));
    }

    public void addSessionCallbackParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Session Callback") && Util.isValidParameter(str2, "value", "Session Callback")) {
            SessionParameters sessionParameters = this.sessionParameters;
            if (sessionParameters.callbackParameters == null) {
                sessionParameters.callbackParameters = new LinkedHashMap();
            }
            String str3 = this.sessionParameters.callbackParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.sessionParameters.callbackParameters.put(str, str2);
            writeSessionCallbackParametersI();
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void addSessionPartnerParameter(String str, String str2) {
        this.executor.submit(new AnonymousClass17(str, str2));
    }

    public void addSessionPartnerParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Session Partner") && Util.isValidParameter(str2, "value", "Session Partner")) {
            SessionParameters sessionParameters = this.sessionParameters;
            if (sessionParameters.partnerParameters == null) {
                sessionParameters.partnerParameters = new LinkedHashMap();
            }
            String str3 = this.sessionParameters.partnerParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.sessionParameters.partnerParameters.put(str, str2);
            writeSessionPartnerParametersI();
        }
    }

    public void backgroundTimerFired() {
        this.executor.submit(new AnonymousClass29());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void disableThirdPartySharing() {
        this.executor.submit(new AnonymousClass24());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void finishedTrackingActivity(ResponseData responseData) {
        if (responseData instanceof SessionResponseData) {
            this.attributionHandler.checkSessionResponse((SessionResponseData) responseData);
            return;
        }
        if (responseData instanceof SdkClickResponseData) {
            SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) responseData;
            checkForInstallReferrerInfo(sdkClickResponseData);
            this.attributionHandler.checkSdkClickResponse(sdkClickResponseData);
        } else if (responseData instanceof EventResponseData) {
            launchEventResponseTasks((EventResponseData) responseData);
        }
    }

    public void foregroundTimerFired() {
        this.executor.submit(new AnonymousClass28());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void gdprForgetMe() {
        this.executor.submit(new AnonymousClass23());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public ActivityState getActivityState() {
        return this.activityState;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public String getAdid() {
        ActivityState activityState = this.activityState;
        if (activityState == null) {
            return null;
        }
        return activityState.adid;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public AdjustConfig getAdjustConfig() {
        return this.adjustConfig;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public AdjustAttribution getAttribution() {
        return this.attribution;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public String getBasePath() {
        return this.basePath;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public Context getContext() {
        return this.adjustConfig.context;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public String getGdprPath() {
        return this.gdprPath;
    }

    public InternalState getInternalState() {
        return this.internalState;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public SessionParameters getSessionParameters() {
        return this.sessionParameters;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public String getSubscriptionPath() {
        return this.subscriptionPath;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void gotOptOutResponse() {
        this.executor.submit(new AnonymousClass27());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void init(AdjustConfig adjustConfig) {
        this.adjustConfig = adjustConfig;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public boolean isEnabled() {
        return isEnabledI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchAttributionResponseTasks(AttributionResponseData attributionResponseData) {
        this.executor.submit(new AnonymousClass14(attributionResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchEventResponseTasks(EventResponseData eventResponseData) {
        this.executor.submit(new AnonymousClass11(eventResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData) {
        this.executor.submit(new AnonymousClass12(sdkClickResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchSessionResponseTasks(SessionResponseData sessionResponseData) {
        this.executor.submit(new AnonymousClass13(sessionResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void onPause() {
        this.internalState.background = true;
        this.executor.submit(new AnonymousClass3());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void onResume() {
        this.internalState.background = false;
        this.executor.submit(new AnonymousClass2());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void readOpenUrl(Uri uri, long j) {
        this.executor.submit(new AnonymousClass7(uri, j));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeSessionCallbackParameter(String str) {
        this.executor.submit(new AnonymousClass18(str));
    }

    public void removeSessionCallbackParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Callback")) {
            Map<String, String> map = this.sessionParameters.callbackParameters;
            if (map == null) {
                this.logger.warn("Session Callback parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeSessionCallbackParametersI();
            }
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeSessionPartnerParameter(String str) {
        this.executor.submit(new AnonymousClass19(str));
    }

    public void removeSessionPartnerParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Partner")) {
            Map<String, String> map = this.sessionParameters.partnerParameters;
            if (map == null) {
                this.logger.warn("Session Partner parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeSessionPartnerParametersI();
            }
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void resetSessionCallbackParameters() {
        this.executor.submit(new AnonymousClass20());
    }

    public void resetSessionCallbackParametersI() {
        if (this.sessionParameters.callbackParameters == null) {
            this.logger.warn("Session Callback parameters are not set", new Object[0]);
        }
        this.sessionParameters.callbackParameters = null;
        writeSessionCallbackParametersI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void resetSessionPartnerParameters() {
        this.executor.submit(new AnonymousClass21());
    }

    public void resetSessionPartnerParametersI() {
        if (this.sessionParameters.partnerParameters == null) {
            this.logger.warn("Session Partner parameters are not set", new Object[0]);
        }
        this.sessionParameters.partnerParameters = null;
        writeSessionPartnerParametersI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendFirstPackages() {
        this.executor.submit(new AnonymousClass15());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendInstallReferrer(String str, long j, long j2, String str2) {
        this.executor.submit(new AnonymousClass10(str, j, j2, str2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendReftagReferrer() {
        this.executor.submit(new AnonymousClass9());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setAskingAttribution(boolean z2) {
        this.executor.submit(new AnonymousClass8(z2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setEnabled(boolean z2) {
        this.executor.submit(new AnonymousClass5(z2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setOfflineMode(boolean z2) {
        this.executor.submit(new AnonymousClass6(z2));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setPushToken(String str, boolean z2) {
        this.executor.submit(new AnonymousClass22(z2, str));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void teardown() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        TimerCycle timerCycle = this.foregroundTimer;
        if (timerCycle != null) {
            timerCycle.teardown();
        }
        TimerOnce timerOnce2 = this.delayStartTimer;
        if (timerOnce2 != null) {
            timerOnce2.teardown();
        }
        ThreadExecutor threadExecutor = this.executor;
        if (threadExecutor != null) {
            threadExecutor.teardown();
        }
        IPackageHandler iPackageHandler = this.packageHandler;
        if (iPackageHandler != null) {
            iPackageHandler.teardown();
        }
        IAttributionHandler iAttributionHandler = this.attributionHandler;
        if (iAttributionHandler != null) {
            iAttributionHandler.teardown();
        }
        ISdkClickHandler iSdkClickHandler = this.sdkClickHandler;
        if (iSdkClickHandler != null) {
            iSdkClickHandler.teardown();
        }
        SessionParameters sessionParameters = this.sessionParameters;
        if (sessionParameters != null) {
            Map<String, String> map = sessionParameters.callbackParameters;
            if (map != null) {
                map.clear();
            }
            Map<String, String> map2 = this.sessionParameters.partnerParameters;
            if (map2 != null) {
                map2.clear();
            }
        }
        teardownActivityStateS();
        teardownAttributionS();
        teardownAllSessionParametersS();
        this.packageHandler = null;
        this.logger = null;
        this.foregroundTimer = null;
        this.executor = null;
        this.backgroundTimer = null;
        this.delayStartTimer = null;
        this.internalState = null;
        this.deviceInfo = null;
        this.adjustConfig = null;
        this.attributionHandler = null;
        this.sdkClickHandler = null;
        this.sessionParameters = null;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackAdRevenue(String str, JSONObject jSONObject) {
        this.executor.submit(new AnonymousClass25(str, jSONObject));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackEvent(AdjustEvent adjustEvent) {
        this.executor.submit(new AnonymousClass4(adjustEvent));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        this.executor.submit(new AnonymousClass26(adjustPlayStoreSubscription));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public boolean updateAttributionI(AdjustAttribution adjustAttribution) {
        if (adjustAttribution == null || adjustAttribution.equals(this.attribution)) {
            return false;
        }
        this.attribution = adjustAttribution;
        writeAttributionI();
        return true;
    }

    private boolean pausedI(boolean z2) {
        return z2 ? this.internalState.isOffline() || !isEnabledI() : this.internalState.isOffline() || !isEnabledI() || this.internalState.isInDelayedStart();
    }

    private boolean toSendI(boolean z2) {
        if (pausedI(z2)) {
            return false;
        }
        if (this.adjustConfig.sendInBackground) {
            return true;
        }
        return this.internalState.isInForeground();
    }

    private void checkAfterNewStartI(SharedPreferencesManager sharedPreferencesManager) {
        String pushToken = sharedPreferencesManager.getPushToken();
        if (pushToken != null && !pushToken.equals(this.activityState.pushToken)) {
            setPushToken(pushToken, true);
        }
        if (sharedPreferencesManager.getRawReferrerArray() != null) {
            sendReftagReferrer();
        }
        this.installReferrer.startConnection();
        this.installReferrerHuawei.readReferrer();
    }
}
