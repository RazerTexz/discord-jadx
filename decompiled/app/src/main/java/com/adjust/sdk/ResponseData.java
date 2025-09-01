package com.adjust.sdk;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class ResponseData {
    public ActivityKind activityKind;
    public String adid;
    public AdjustAttribution attribution;
    public JSONObject jsonResponse;
    public String message;
    public boolean success;
    public String timestamp;
    public TrackingState trackingState;
    public boolean willRetry;

    /* renamed from: com.adjust.sdk.ResponseData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$adjust$sdk$ActivityKind;

        static {
            ActivityKind.values();
            int[] iArr = new int[12];
            $SwitchMap$com$adjust$sdk$ActivityKind = iArr;
            try {
                iArr[ActivityKind.SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.ATTRIBUTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static ResponseData buildResponseData(ActivityPackage activityPackage) {
        ResponseData sessionResponseData;
        ResponseData responseData;
        ActivityKind activityKind = activityPackage.getActivityKind();
        int iOrdinal = activityKind.ordinal();
        if (iOrdinal == 1) {
            sessionResponseData = new SessionResponseData(activityPackage);
        } else {
            if (iOrdinal != 2) {
                responseData = iOrdinal != 3 ? iOrdinal != 4 ? new ResponseData() : new AttributionResponseData() : new SdkClickResponseData();
                responseData.activityKind = activityKind;
                return responseData;
            }
            sessionResponseData = new EventResponseData(activityPackage);
        }
        responseData = sessionResponseData;
        responseData.activityKind = activityKind;
        return responseData;
    }

    public String toString() {
        return Util.formatString("message:%s timestamp:%s json:%s", this.message, this.timestamp, this.jsonResponse);
    }
}
