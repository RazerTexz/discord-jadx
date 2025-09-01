package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdjustInstance {
    private IActivityHandler activityHandler;
    private String basePath;
    private String gdprPath;
    private List<IRunActivityHandler> preLaunchActionsArray;
    private String pushToken;
    private Boolean startEnabled = null;
    private boolean startOffline = false;
    private String subscriptionPath;

    /* renamed from: com.adjust.sdk.AdjustInstance$1, reason: invalid class name */
    public class AnonymousClass1 implements IRunActivityHandler {
        public final /* synthetic */ String val$key;
        public final /* synthetic */ String val$value;

        public AnonymousClass1(String str, String str2) {
            this.val$key = str;
            this.val$value = str2;
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public void run(ActivityHandler activityHandler) {
            activityHandler.addSessionCallbackParameterI(this.val$key, this.val$value);
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$10, reason: invalid class name */
    public class AnonymousClass10 implements Runnable {
        public final /* synthetic */ Context val$context;

        public AnonymousClass10(Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            new SharedPreferencesManager(this.val$context).setDisableThirdPartySharing();
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$11, reason: invalid class name */
    public class AnonymousClass11 implements Runnable {
        public final /* synthetic */ Context val$context;

        public AnonymousClass11(Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            new SharedPreferencesManager(this.val$context).setSendingReferrersAsNotSent();
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$2, reason: invalid class name */
    public class AnonymousClass2 implements IRunActivityHandler {
        public final /* synthetic */ String val$key;
        public final /* synthetic */ String val$value;

        public AnonymousClass2(String str, String str2) {
            this.val$key = str;
            this.val$value = str2;
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public void run(ActivityHandler activityHandler) {
            activityHandler.addSessionPartnerParameterI(this.val$key, this.val$value);
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$3, reason: invalid class name */
    public class AnonymousClass3 implements IRunActivityHandler {
        public final /* synthetic */ String val$key;

        public AnonymousClass3(String str) {
            this.val$key = str;
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public void run(ActivityHandler activityHandler) {
            activityHandler.removeSessionCallbackParameterI(this.val$key);
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$4, reason: invalid class name */
    public class AnonymousClass4 implements IRunActivityHandler {
        public final /* synthetic */ String val$key;

        public AnonymousClass4(String str) {
            this.val$key = str;
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public void run(ActivityHandler activityHandler) {
            activityHandler.removeSessionPartnerParameterI(this.val$key);
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$5, reason: invalid class name */
    public class AnonymousClass5 implements IRunActivityHandler {
        public AnonymousClass5() {
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public void run(ActivityHandler activityHandler) {
            activityHandler.resetSessionCallbackParametersI();
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$6, reason: invalid class name */
    public class AnonymousClass6 implements IRunActivityHandler {
        public AnonymousClass6() {
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public void run(ActivityHandler activityHandler) {
            activityHandler.resetSessionPartnerParametersI();
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$7, reason: invalid class name */
    public class AnonymousClass7 implements Runnable {
        public final /* synthetic */ long val$clickTime;
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$rawReferrer;

        public AnonymousClass7(Context context, String str, long j) {
            this.val$context = context;
            this.val$rawReferrer = str;
            this.val$clickTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            new SharedPreferencesManager(this.val$context).saveRawReferrer(this.val$rawReferrer, this.val$clickTime);
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$8, reason: invalid class name */
    public class AnonymousClass8 implements Runnable {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$pushToken;

        public AnonymousClass8(Context context, String str) {
            this.val$context = context;
            this.val$pushToken = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            new SharedPreferencesManager(this.val$context).savePushToken(this.val$pushToken);
        }
    }

    /* renamed from: com.adjust.sdk.AdjustInstance$9, reason: invalid class name */
    public class AnonymousClass9 implements Runnable {
        public final /* synthetic */ Context val$context;

        public AnonymousClass9(Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            new SharedPreferencesManager(this.val$context).setGdprForgetMe();
        }
    }

    private boolean checkActivityHandler() {
        return checkActivityHandler(null);
    }

    private boolean isInstanceEnabled() {
        Boolean bool = this.startEnabled;
        return bool == null || bool.booleanValue();
    }

    private void saveDisableThirdPartySharing(Context context) {
        Util.runInBackground(new AnonymousClass10(context));
    }

    private void saveGdprForgetMe(Context context) {
        Util.runInBackground(new AnonymousClass9(context));
    }

    private void savePushToken(String str, Context context) {
        Util.runInBackground(new AnonymousClass8(context, str));
    }

    private void saveRawReferrer(String str, long j, Context context) {
        Util.runInBackground(new AnonymousClass7(context, str, j));
    }

    private void setSendingReferrersAsNotSent(Context context) {
        Util.runInBackground(new AnonymousClass11(context));
    }

    public void addSessionCallbackParameter(String str, String str2) {
        if (checkActivityHandler("adding session callback parameter")) {
            this.activityHandler.addSessionCallbackParameter(str, str2);
            return;
        }
        if (this.preLaunchActionsArray == null) {
            this.preLaunchActionsArray = new ArrayList();
        }
        this.preLaunchActionsArray.add(new AnonymousClass1(str, str2));
    }

    public void addSessionPartnerParameter(String str, String str2) {
        if (checkActivityHandler("adding session partner parameter")) {
            this.activityHandler.addSessionPartnerParameter(str, str2);
            return;
        }
        if (this.preLaunchActionsArray == null) {
            this.preLaunchActionsArray = new ArrayList();
        }
        this.preLaunchActionsArray.add(new AnonymousClass2(str, str2));
    }

    public void appWillOpenUrl(Uri uri) {
        if (checkActivityHandler()) {
            this.activityHandler.readOpenUrl(uri, System.currentTimeMillis());
        }
    }

    public void disableThirdPartySharing(Context context) {
        if (checkActivityHandler("disable third party sharing")) {
            this.activityHandler.disableThirdPartySharing();
        } else {
            saveDisableThirdPartySharing(context);
        }
    }

    public void gdprForgetMe(Context context) {
        saveGdprForgetMe(context);
        if (checkActivityHandler("gdpr") && this.activityHandler.isEnabled()) {
            this.activityHandler.gdprForgetMe();
        }
    }

    public String getAdid() {
        if (checkActivityHandler()) {
            return this.activityHandler.getAdid();
        }
        return null;
    }

    public AdjustAttribution getAttribution() {
        if (checkActivityHandler()) {
            return this.activityHandler.getAttribution();
        }
        return null;
    }

    public String getSdkVersion() {
        return Util.getSdkVersion();
    }

    public boolean isEnabled() {
        return !checkActivityHandler() ? isInstanceEnabled() : this.activityHandler.isEnabled();
    }

    public void onCreate(AdjustConfig adjustConfig) {
        if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
            return;
        }
        if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
            return;
        }
        if (this.activityHandler != null) {
            AdjustFactory.getLogger().error("Adjust already initialized", new Object[0]);
            return;
        }
        adjustConfig.preLaunchActionsArray = this.preLaunchActionsArray;
        adjustConfig.pushToken = this.pushToken;
        adjustConfig.startEnabled = this.startEnabled;
        adjustConfig.startOffline = this.startOffline;
        adjustConfig.basePath = this.basePath;
        adjustConfig.gdprPath = this.gdprPath;
        adjustConfig.subscriptionPath = this.subscriptionPath;
        this.activityHandler = AdjustFactory.getActivityHandler(adjustConfig);
        setSendingReferrersAsNotSent(adjustConfig.context);
    }

    public void onPause() {
        if (checkActivityHandler()) {
            this.activityHandler.onPause();
        }
    }

    public void onResume() {
        if (checkActivityHandler()) {
            this.activityHandler.onResume();
        }
    }

    public void removeSessionCallbackParameter(String str) {
        if (checkActivityHandler("removing session callback parameter")) {
            this.activityHandler.removeSessionCallbackParameter(str);
            return;
        }
        if (this.preLaunchActionsArray == null) {
            this.preLaunchActionsArray = new ArrayList();
        }
        this.preLaunchActionsArray.add(new AnonymousClass3(str));
    }

    public void removeSessionPartnerParameter(String str) {
        if (checkActivityHandler("removing session partner parameter")) {
            this.activityHandler.removeSessionPartnerParameter(str);
            return;
        }
        if (this.preLaunchActionsArray == null) {
            this.preLaunchActionsArray = new ArrayList();
        }
        this.preLaunchActionsArray.add(new AnonymousClass4(str));
    }

    public void resetSessionCallbackParameters() {
        if (checkActivityHandler("resetting session callback parameters")) {
            this.activityHandler.resetSessionCallbackParameters();
            return;
        }
        if (this.preLaunchActionsArray == null) {
            this.preLaunchActionsArray = new ArrayList();
        }
        this.preLaunchActionsArray.add(new AnonymousClass5());
    }

    public void resetSessionPartnerParameters() {
        if (checkActivityHandler("resetting session partner parameters")) {
            this.activityHandler.resetSessionPartnerParameters();
            return;
        }
        if (this.preLaunchActionsArray == null) {
            this.preLaunchActionsArray = new ArrayList();
        }
        this.preLaunchActionsArray.add(new AnonymousClass6());
    }

    public void sendFirstPackages() {
        if (checkActivityHandler()) {
            this.activityHandler.sendFirstPackages();
        }
    }

    public void sendReferrer(String str, Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            return;
        }
        saveRawReferrer(str, jCurrentTimeMillis, context);
        if (checkActivityHandler(Constants.REFERRER) && this.activityHandler.isEnabled()) {
            this.activityHandler.sendReftagReferrer();
        }
    }

    public void setEnabled(boolean z2) {
        this.startEnabled = Boolean.valueOf(z2);
        if (checkActivityHandler(z2, "enabled mode", "disabled mode")) {
            this.activityHandler.setEnabled(z2);
        }
    }

    public void setOfflineMode(boolean z2) {
        if (checkActivityHandler(z2, "offline mode", "online mode")) {
            this.activityHandler.setOfflineMode(z2);
        } else {
            this.startOffline = z2;
        }
    }

    public void setPushToken(String str) {
        if (checkActivityHandler("push token")) {
            this.activityHandler.setPushToken(str, false);
        } else {
            this.pushToken = str;
        }
    }

    public void setTestOptions(AdjustTestOptions adjustTestOptions) {
        String str = adjustTestOptions.basePath;
        if (str != null) {
            this.basePath = str;
        }
        String str2 = adjustTestOptions.gdprPath;
        if (str2 != null) {
            this.gdprPath = str2;
        }
        String str3 = adjustTestOptions.subscriptionPath;
        if (str3 != null) {
            this.subscriptionPath = str3;
        }
        String str4 = adjustTestOptions.baseUrl;
        if (str4 != null) {
            AdjustFactory.setBaseUrl(str4);
        }
        String str5 = adjustTestOptions.gdprUrl;
        if (str5 != null) {
            AdjustFactory.setGdprUrl(str5);
        }
        String str6 = adjustTestOptions.subscriptionUrl;
        if (str6 != null) {
            AdjustFactory.setSubscriptionUrl(str6);
        }
        Boolean bool = adjustTestOptions.useTestConnectionOptions;
        if (bool != null && bool.booleanValue()) {
            AdjustFactory.useTestConnectionOptions();
        }
        Long l = adjustTestOptions.timerIntervalInMilliseconds;
        if (l != null) {
            AdjustFactory.setTimerInterval(l.longValue());
        }
        if (adjustTestOptions.timerStartInMilliseconds != null) {
            AdjustFactory.setTimerStart(adjustTestOptions.timerIntervalInMilliseconds.longValue());
        }
        Long l2 = adjustTestOptions.sessionIntervalInMilliseconds;
        if (l2 != null) {
            AdjustFactory.setSessionInterval(l2.longValue());
        }
        Long l3 = adjustTestOptions.subsessionIntervalInMilliseconds;
        if (l3 != null) {
            AdjustFactory.setSubsessionInterval(l3.longValue());
        }
        Boolean bool2 = adjustTestOptions.tryInstallReferrer;
        if (bool2 != null) {
            AdjustFactory.setTryInstallReferrer(bool2.booleanValue());
        }
        if (adjustTestOptions.noBackoffWait != null) {
            BackoffStrategy backoffStrategy = BackoffStrategy.NO_WAIT;
            AdjustFactory.setPackageHandlerBackoffStrategy(backoffStrategy);
            AdjustFactory.setSdkClickBackoffStrategy(backoffStrategy);
        }
        Boolean bool3 = adjustTestOptions.enableSigning;
        if (bool3 != null && bool3.booleanValue()) {
            AdjustFactory.enableSigning();
        }
        Boolean bool4 = adjustTestOptions.disableSigning;
        if (bool4 == null || !bool4.booleanValue()) {
            return;
        }
        AdjustFactory.disableSigning();
    }

    public void teardown() {
        if (checkActivityHandler()) {
            this.activityHandler.teardown();
            this.activityHandler = null;
        }
    }

    public void trackAdRevenue(String str, JSONObject jSONObject) {
        if (checkActivityHandler()) {
            this.activityHandler.trackAdRevenue(str, jSONObject);
        }
    }

    public void trackEvent(AdjustEvent adjustEvent) {
        if (checkActivityHandler()) {
            this.activityHandler.trackEvent(adjustEvent);
        }
    }

    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityHandler()) {
            this.activityHandler.trackPlayStoreSubscription(adjustPlayStoreSubscription);
        }
    }

    private boolean checkActivityHandler(boolean z2, String str, String str2) {
        return z2 ? checkActivityHandler(str) : checkActivityHandler(str2);
    }

    private boolean checkActivityHandler(String str) {
        if (this.activityHandler != null) {
            return true;
        }
        if (str != null) {
            AdjustFactory.getLogger().warn("Adjust not initialized, but %s saved for launch", str);
        } else {
            AdjustFactory.getLogger().error("Adjust not initialized correctly", new Object[0]);
        }
        return false;
    }

    public void appWillOpenUrl(Uri uri, Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!checkActivityHandler()) {
            new SharedPreferencesManager(context).saveDeeplink(uri, jCurrentTimeMillis);
        } else {
            this.activityHandler.readOpenUrl(uri, jCurrentTimeMillis);
        }
    }

    public void setPushToken(String str, Context context) {
        savePushToken(str, context);
        if (checkActivityHandler("push token") && this.activityHandler.isEnabled()) {
            this.activityHandler.setPushToken(str, true);
        }
    }
}
