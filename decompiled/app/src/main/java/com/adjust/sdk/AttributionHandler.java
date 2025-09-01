package com.adjust.sdk;

import android.net.Uri;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import com.adjust.sdk.scheduler.TimerOnce;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AttributionHandler implements IAttributionHandler {
    private static final String ATTRIBUTION_TIMER_NAME = "Attribution timer";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private String basePath;
    private String clientSdk;
    private String lastInitiatedBy;
    private boolean paused;
    private ILogger logger = AdjustFactory.getLogger();
    private ThreadScheduler scheduler = new SingleThreadCachedScheduler("AttributionHandler");
    private TimerOnce timer = new TimerOnce(new AnonymousClass1(), ATTRIBUTION_TIMER_NAME);

    /* renamed from: com.adjust.sdk.AttributionHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttributionHandler.access$000(AttributionHandler.this);
        }
    }

    /* renamed from: com.adjust.sdk.AttributionHandler$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttributionHandler.access$102(AttributionHandler.this, "sdk");
            AttributionHandler.access$200(AttributionHandler.this, 0L);
        }
    }

    /* renamed from: com.adjust.sdk.AttributionHandler$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public final /* synthetic */ SessionResponseData val$sessionResponseData;

        public AnonymousClass3(SessionResponseData sessionResponseData) {
            this.val$sessionResponseData = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.access$300(AttributionHandler.this).get();
            if (iActivityHandler == null) {
                return;
            }
            AttributionHandler.access$400(AttributionHandler.this, iActivityHandler, this.val$sessionResponseData);
        }
    }

    /* renamed from: com.adjust.sdk.AttributionHandler$4, reason: invalid class name */
    public class AnonymousClass4 implements Runnable {
        public final /* synthetic */ SdkClickResponseData val$sdkClickResponseData;

        public AnonymousClass4(SdkClickResponseData sdkClickResponseData) {
            this.val$sdkClickResponseData = sdkClickResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.access$300(AttributionHandler.this).get();
            if (iActivityHandler == null) {
                return;
            }
            AttributionHandler.access$500(AttributionHandler.this, iActivityHandler, this.val$sdkClickResponseData);
        }
    }

    /* renamed from: com.adjust.sdk.AttributionHandler$5, reason: invalid class name */
    public class AnonymousClass5 implements Runnable {
        public final /* synthetic */ AttributionResponseData val$attributionResponseData;

        public AnonymousClass5(AttributionResponseData attributionResponseData) {
            this.val$attributionResponseData = attributionResponseData;
        }

        @Override // java.lang.Runnable
        public void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.access$300(AttributionHandler.this).get();
            if (iActivityHandler == null) {
                return;
            }
            AttributionHandler.access$600(AttributionHandler.this, iActivityHandler, this.val$attributionResponseData);
        }
    }

    /* renamed from: com.adjust.sdk.AttributionHandler$6, reason: invalid class name */
    public class AnonymousClass6 implements Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttributionHandler.access$700(AttributionHandler.this);
        }
    }

    public AttributionHandler(IActivityHandler iActivityHandler, boolean z2) {
        this.basePath = iActivityHandler.getBasePath();
        this.clientSdk = iActivityHandler.getDeviceInfo().clientSdk;
        init(iActivityHandler, z2);
    }

    public static /* synthetic */ void access$000(AttributionHandler attributionHandler) {
        attributionHandler.sendAttributionRequest();
    }

    public static /* synthetic */ String access$102(AttributionHandler attributionHandler, String str) {
        attributionHandler.lastInitiatedBy = str;
        return str;
    }

    public static /* synthetic */ void access$200(AttributionHandler attributionHandler, long j) {
        attributionHandler.getAttributionI(j);
    }

    public static /* synthetic */ WeakReference access$300(AttributionHandler attributionHandler) {
        return attributionHandler.activityHandlerWeakRef;
    }

    public static /* synthetic */ void access$400(AttributionHandler attributionHandler, IActivityHandler iActivityHandler, SessionResponseData sessionResponseData) {
        attributionHandler.checkSessionResponseI(iActivityHandler, sessionResponseData);
    }

    public static /* synthetic */ void access$500(AttributionHandler attributionHandler, IActivityHandler iActivityHandler, SdkClickResponseData sdkClickResponseData) {
        attributionHandler.checkSdkClickResponseI(iActivityHandler, sdkClickResponseData);
    }

    public static /* synthetic */ void access$600(AttributionHandler attributionHandler, IActivityHandler iActivityHandler, AttributionResponseData attributionResponseData) {
        attributionHandler.checkAttributionResponseI(iActivityHandler, attributionResponseData);
    }

    public static /* synthetic */ void access$700(AttributionHandler attributionHandler) {
        attributionHandler.sendAttributionRequestI();
    }

    private ActivityPackage buildAndGetAttributionPackage() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        ActivityPackage activityPackageBuildAttributionPackage = new PackageBuilder(iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getActivityState(), iActivityHandler.getSessionParameters(), jCurrentTimeMillis).buildAttributionPackage(this.lastInitiatedBy);
        this.lastInitiatedBy = null;
        return activityPackageBuildAttributionPackage;
    }

    private void checkAttributionI(IActivityHandler iActivityHandler, ResponseData responseData) {
        JSONObject jSONObject = responseData.jsonResponse;
        if (jSONObject == null) {
            return;
        }
        long jOptLong = jSONObject.optLong("ask_in", -1L);
        if (jOptLong < 0) {
            iActivityHandler.setAskingAttribution(false);
            responseData.attribution = AdjustAttribution.fromJson(responseData.jsonResponse.optJSONObject("attribution"), responseData.adid, Util.getSdkPrefixPlatform(this.clientSdk));
        } else {
            iActivityHandler.setAskingAttribution(true);
            this.lastInitiatedBy = "backend";
            getAttributionI(jOptLong);
        }
    }

    private void checkAttributionResponseI(IActivityHandler iActivityHandler, AttributionResponseData attributionResponseData) {
        checkAttributionI(iActivityHandler, attributionResponseData);
        checkDeeplinkI(attributionResponseData);
        iActivityHandler.launchAttributionResponseTasks(attributionResponseData);
    }

    private void checkDeeplinkI(AttributionResponseData attributionResponseData) {
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
        JSONObject jSONObject = attributionResponseData.jsonResponse;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution")) == null || (strOptString = jSONObjectOptJSONObject.optString(Constants.DEEPLINK, null)) == null) {
            return;
        }
        attributionResponseData.deeplink = Uri.parse(strOptString);
    }

    private void checkSdkClickResponseI(IActivityHandler iActivityHandler, SdkClickResponseData sdkClickResponseData) {
        checkAttributionI(iActivityHandler, sdkClickResponseData);
        iActivityHandler.launchSdkClickResponseTasks(sdkClickResponseData);
    }

    private void checkSessionResponseI(IActivityHandler iActivityHandler, SessionResponseData sessionResponseData) {
        checkAttributionI(iActivityHandler, sessionResponseData);
        iActivityHandler.launchSessionResponseTasks(sessionResponseData);
    }

    private void getAttributionI(long j) {
        if (this.timer.getFireIn() > j) {
            return;
        }
        if (j != 0) {
            this.logger.debug("Waiting to query attribution in %s seconds", Util.SecondsDisplayFormat.format(j / 1000.0d));
        }
        this.timer.startIn(j);
    }

    private void sendAttributionRequest() {
        this.scheduler.submit(new AnonymousClass6());
    }

    private void sendAttributionRequestI() {
        if (this.activityHandlerWeakRef.get().getActivityState().isGdprForgotten) {
            return;
        }
        if (this.paused) {
            this.logger.debug("Attribution handler is paused", new Object[0]);
            return;
        }
        ActivityPackage activityPackageBuildAndGetAttributionPackage = buildAndGetAttributionPackage();
        this.logger.verbose("%s", activityPackageBuildAndGetAttributionPackage.getExtendedString());
        try {
            ResponseData responseDataCreateGETHttpsURLConnection = UtilNetworking.createGETHttpsURLConnection(activityPackageBuildAndGetAttributionPackage, this.basePath);
            if (responseDataCreateGETHttpsURLConnection instanceof AttributionResponseData) {
                if (responseDataCreateGETHttpsURLConnection.trackingState == TrackingState.OPTED_OUT) {
                    this.activityHandlerWeakRef.get().gotOptOutResponse();
                } else {
                    checkAttributionResponse((AttributionResponseData) responseDataCreateGETHttpsURLConnection);
                }
            }
        } catch (Exception e) {
            this.logger.error("Failed to get attribution (%s)", e.getMessage());
        }
    }

    public void checkAttributionResponse(AttributionResponseData attributionResponseData) {
        this.scheduler.submit(new AnonymousClass5(attributionResponseData));
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void checkSdkClickResponse(SdkClickResponseData sdkClickResponseData) {
        this.scheduler.submit(new AnonymousClass4(sdkClickResponseData));
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void checkSessionResponse(SessionResponseData sessionResponseData) {
        this.scheduler.submit(new AnonymousClass3(sessionResponseData));
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void getAttribution() {
        this.scheduler.submit(new AnonymousClass2());
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void init(IActivityHandler iActivityHandler, boolean z2) {
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.paused = !z2;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void resumeSending() {
        this.paused = false;
    }

    @Override // com.adjust.sdk.IAttributionHandler
    public void teardown() {
        this.logger.verbose("AttributionHandler teardown", new Object[0]);
        TimerOnce timerOnce = this.timer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.timer = null;
        this.logger = null;
        this.scheduler = null;
        this.activityHandlerWeakRef = null;
    }
}
