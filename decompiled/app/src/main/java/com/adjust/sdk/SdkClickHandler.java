package com.adjust.sdk;

import b.d.b.a.outline;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SdkClickHandler implements ISdkClickHandler {
    private static final double MILLISECONDS_TO_SECONDS_DIVISOR = 1000.0d;
    private static final String SCHEDULED_EXECUTOR_SOURCE = "SdkClickHandler";
    private static final String SOURCE_INSTALL_REFERRER = "install_referrer";
    private static final String SOURCE_REFTAG = "reftag";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private BackoffStrategy backoffStrategy;
    private String basePath;
    private ILogger logger;
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private ThreadScheduler scheduler;

    /* renamed from: com.adjust.sdk.SdkClickHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ ActivityPackage val$sdkClick;

        public AnonymousClass1(ActivityPackage activityPackage) {
            this.val$sdkClick = activityPackage;
        }

        @Override // java.lang.Runnable
        public void run() {
            SdkClickHandler.access$000(SdkClickHandler.this).add(this.val$sdkClick);
            SdkClickHandler.access$100(SdkClickHandler.this).debug("Added sdk_click %d", Integer.valueOf(SdkClickHandler.access$000(SdkClickHandler.this).size()));
            SdkClickHandler.access$100(SdkClickHandler.this).verbose("%s", this.val$sdkClick.getExtendedString());
            SdkClickHandler.access$200(SdkClickHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.SdkClickHandler$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.access$300(SdkClickHandler.this).get();
            SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(iActivityHandler.getContext());
            try {
                JSONArray rawReferrerArray = sharedPreferencesManager.getRawReferrerArray();
                boolean z2 = false;
                for (int i = 0; i < rawReferrerArray.length(); i++) {
                    JSONArray jSONArray = rawReferrerArray.getJSONArray(i);
                    if (jSONArray.optInt(2, -1) == 0) {
                        String strOptString = jSONArray.optString(0, null);
                        long jOptLong = jSONArray.optLong(1, -1L);
                        jSONArray.put(2, 1);
                        SdkClickHandler.this.sendSdkClick(PackageFactory.buildReftagSdkClickPackage(strOptString, jOptLong, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getSessionParameters()));
                        z2 = true;
                    }
                }
                if (z2) {
                    sharedPreferencesManager.saveRawReferrerArray(rawReferrerArray);
                }
            } catch (JSONException e) {
                SdkClickHandler.access$100(SdkClickHandler.this).error("Send saved raw referrers error (%s)", e.getMessage());
            }
        }
    }

    /* renamed from: com.adjust.sdk.SdkClickHandler$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SdkClickHandler.access$400(SdkClickHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.SdkClickHandler$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {
        public final /* synthetic */ ActivityPackage val$sdkClickPackage;

        public AnonymousClass4(ActivityPackage activityPackage) {
            this.val$sdkClickPackage = activityPackage;
        }

        @Override // java.lang.Runnable
        public void run() {
            SdkClickHandler.access$500(SdkClickHandler.this, this.val$sdkClickPackage);
            SdkClickHandler.access$200(SdkClickHandler.this);
        }
    }

    public SdkClickHandler(IActivityHandler iActivityHandler, boolean z2) {
        init(iActivityHandler, z2);
        this.logger = AdjustFactory.getLogger();
        this.backoffStrategy = AdjustFactory.getSdkClickBackoffStrategy();
        this.scheduler = new SingleThreadCachedScheduler(SCHEDULED_EXECUTOR_SOURCE);
    }

    public static /* synthetic */ List access$000(SdkClickHandler sdkClickHandler) {
        return sdkClickHandler.packageQueue;
    }

    public static /* synthetic */ ILogger access$100(SdkClickHandler sdkClickHandler) {
        return sdkClickHandler.logger;
    }

    public static /* synthetic */ void access$200(SdkClickHandler sdkClickHandler) {
        sdkClickHandler.sendNextSdkClick();
    }

    public static /* synthetic */ WeakReference access$300(SdkClickHandler sdkClickHandler) {
        return sdkClickHandler.activityHandlerWeakRef;
    }

    public static /* synthetic */ void access$400(SdkClickHandler sdkClickHandler) {
        sdkClickHandler.sendNextSdkClickI();
    }

    public static /* synthetic */ void access$500(SdkClickHandler sdkClickHandler, ActivityPackage activityPackage) {
        sdkClickHandler.sendSdkClickI(activityPackage);
    }

    private void logErrorMessageI(ActivityPackage activityPackage, String str, Throwable th) {
        this.logger.error(Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th)), new Object[0]);
    }

    private void retrySendingI(ActivityPackage activityPackage) {
        this.logger.error("Retrying sdk_click package for the %d time", Integer.valueOf(activityPackage.increaseRetries()));
        sendSdkClick(activityPackage);
    }

    private void sendNextSdkClick() {
        this.scheduler.submit(new AnonymousClass3());
    }

    private void sendNextSdkClickI() {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler.getActivityState() == null || iActivityHandler.getActivityState().isGdprForgotten || this.paused || this.packageQueue.isEmpty()) {
            return;
        }
        ActivityPackage activityPackageRemove = this.packageQueue.remove(0);
        int retries = activityPackageRemove.getRetries();
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(activityPackageRemove);
        if (retries <= 0) {
            anonymousClass4.run();
            return;
        }
        long waitingTime = Util.getWaitingTime(retries, this.backoffStrategy);
        this.logger.verbose("Waiting for %s seconds before retrying sdk_click for the %d time", Util.SecondsDisplayFormat.format(waitingTime / MILLISECONDS_TO_SECONDS_DIVISOR), Integer.valueOf(retries));
        this.scheduler.schedule(anonymousClass4, waitingTime);
    }

    private void sendSdkClickI(ActivityPackage activityPackage) {
        String str;
        long installBeginTimeInSeconds;
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        String str2 = activityPackage.getParameters().get("source");
        boolean z2 = false;
        boolean z3 = str2 != null && str2.equals("reftag");
        String str3 = activityPackage.getParameters().get("raw_referrer");
        if (z3 && new SharedPreferencesManager(iActivityHandler.getContext()).getRawReferrer(str3, activityPackage.getClickTimeInMilliseconds()) == null) {
            return;
        }
        if (str2 != null && str2.equals("install_referrer")) {
            z2 = true;
        }
        String str4 = null;
        long clickTimeInSeconds = -1;
        if (z2) {
            clickTimeInSeconds = activityPackage.getClickTimeInSeconds();
            installBeginTimeInSeconds = activityPackage.getInstallBeginTimeInSeconds();
            str4 = activityPackage.getParameters().get(Constants.REFERRER);
            str = activityPackage.getParameters().get("referrer_api");
        } else {
            str = null;
            installBeginTimeInSeconds = -1;
        }
        String baseUrl = AdjustFactory.getBaseUrl();
        if (this.basePath != null) {
            StringBuilder sbU = outline.U(baseUrl);
            sbU.append(this.basePath);
            baseUrl = sbU.toString();
        }
        StringBuilder sbU2 = outline.U(baseUrl);
        sbU2.append(activityPackage.getPath());
        try {
            SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) UtilNetworking.createPOSTHttpsURLConnection(sbU2.toString(), activityPackage, this.packageQueue.size() - 1);
            if (sdkClickResponseData.jsonResponse == null) {
                retrySendingI(activityPackage);
                return;
            }
            if (iActivityHandler == null) {
                return;
            }
            if (sdkClickResponseData.trackingState == TrackingState.OPTED_OUT) {
                iActivityHandler.gotOptOutResponse();
                return;
            }
            if (z3) {
                new SharedPreferencesManager(iActivityHandler.getContext()).removeRawReferrer(str3, activityPackage.getClickTimeInMilliseconds());
            }
            if (z2) {
                sdkClickResponseData.clickTime = clickTimeInSeconds;
                sdkClickResponseData.installBegin = installBeginTimeInSeconds;
                sdkClickResponseData.installReferrer = str4;
                sdkClickResponseData.referrerApi = str;
                sdkClickResponseData.isInstallReferrer = true;
            }
            iActivityHandler.finishedTrackingActivity(sdkClickResponseData);
        } catch (UnsupportedEncodingException e) {
            logErrorMessageI(activityPackage, "Sdk_click failed to encode parameters", e);
        } catch (SocketTimeoutException e2) {
            logErrorMessageI(activityPackage, "Sdk_click request timed out. Will retry later", e2);
            retrySendingI(activityPackage);
        } catch (IOException e3) {
            logErrorMessageI(activityPackage, "Sdk_click request failed. Will retry later", e3);
            retrySendingI(activityPackage);
        } catch (Throwable th) {
            logErrorMessageI(activityPackage, "Sdk_click runtime exception", th);
        }
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void init(IActivityHandler iActivityHandler, boolean z2) {
        this.paused = !z2;
        this.packageQueue = new ArrayList();
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.basePath = iActivityHandler.getBasePath();
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void resumeSending() {
        this.paused = false;
        sendNextSdkClick();
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void sendReftagReferrers() {
        this.scheduler.submit(new AnonymousClass2());
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void sendSdkClick(ActivityPackage activityPackage) {
        this.scheduler.submit(new AnonymousClass1(activityPackage));
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void teardown() {
        this.logger.verbose("SdkClickHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.logger = null;
        this.packageQueue = null;
        this.backoffStrategy = null;
        this.scheduler = null;
    }
}
