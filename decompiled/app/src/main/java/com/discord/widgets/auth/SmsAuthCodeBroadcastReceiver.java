package com.discord.widgets.auth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.google.android.gms.common.api.Status;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SmsAuthCodeBroadcastReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/auth/SmsAuthCodeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "", "message", "extractCode", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/os/Bundle;", "bundle", "", "extractSecurityCode", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lkotlin/Function1;", "onReceiveCallback", "Lkotlin/jvm/functions/Function1;", "getOnReceiveCallback", "()Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SmsAuthCodeBroadcastReceiver extends BroadcastReceiver {
    private final Function1<String, Unit> onReceiveCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public SmsAuthCodeBroadcastReceiver(Function1<? super String, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "onReceiveCallback");
        this.onReceiveCallback = function1;
    }

    private final String extractCode(String message) throws IOException {
        String strSubstringBefore$default = Strings4.substringBefore$default(message, "\n\n", (String) null, 2, (Object) null);
        StringBuilder sb = new StringBuilder();
        int length = strSubstringBefore$default.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = strSubstringBefore$default.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "filterTo(StringBuilder(), predicate).toString()");
        return string;
    }

    private final void extractSecurityCode(Bundle bundle) throws IOException {
        Object obj = bundle.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
        if (obj == null) {
            AppLog appLog = AppLog.g;
            String simpleName = SmsAuthCodeBroadcastReceiver.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            Logger.d$default(appLog, simpleName, "Failed to extract code due to empty message.", null, 4, null);
            return;
        }
        String strExtractCode = extractCode((String) obj);
        if (strExtractCode.length() == 0) {
            AppLog appLog2 = AppLog.g;
            String simpleName2 = SmsAuthCodeBroadcastReceiver.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
            Logger.d$default(appLog2, simpleName2, "Failed to extract code from SMS.", null, 4, null);
            return;
        }
        AppLog appLog3 = AppLog.g;
        String simpleName3 = SmsAuthCodeBroadcastReceiver.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
        Logger.d$default(appLog3, simpleName3, "Successfully extracted code from SMS: " + strExtractCode, null, 4, null);
        this.onReceiveCallback.invoke(strExtractCode);
    }

    public final Function1<String, Unit> getOnReceiveCallback() {
        return this.onReceiveCallback;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws IOException {
        Bundle extras;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null && action.hashCode() == -1845060944 && action.equals("com.google.android.gms.auth.api.phone.SMS_RETRIEVED") && (extras = intent.getExtras()) != null) {
            Object obj = extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
            Status status = (Status) obj;
            int i = status.p;
            if (i == 0) {
                AppLog appLog = AppLog.g;
                String simpleName = SmsAuthCodeBroadcastReceiver.class.getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
                Logger.d$default(appLog, simpleName, "Successfully caught SMS code.", null, 4, null);
                Intrinsics3.checkNotNullExpressionValue(extras, "bundle");
                extractSecurityCode(extras);
                return;
            }
            if (i != 15) {
                AppLog appLog2 = AppLog.g;
                String simpleName2 = SmsAuthCodeBroadcastReceiver.class.getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
                Logger.d$default(appLog2, simpleName2, "Unexpected status code while waiting for SMS code: " + status.p, null, 4, null);
            } else {
                AppLog appLog3 = AppLog.g;
                String simpleName3 = SmsAuthCodeBroadcastReceiver.class.getSimpleName();
                Intrinsics3.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
                Logger.d$default(appLog3, simpleName3, "Timeout waiting for SMS code.", null, 4, null);
            }
        }
    }
}
