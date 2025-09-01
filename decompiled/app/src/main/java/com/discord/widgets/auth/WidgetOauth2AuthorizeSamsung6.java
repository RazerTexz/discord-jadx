package com.discord.widgets.auth;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetOauth2AuthorizeSamsung.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "activityResult", "", "onActivityResult", "(Landroidx/activity/result/ActivityResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungDisclaimerLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung6<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    public WidgetOauth2AuthorizeSamsung6(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Bundle extras;
        Bundle extras2;
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            SamsungConnectActivity.b(this.this$0.requireContext(), WidgetOauth2AuthorizeSamsung.access$getSamsungConnectLauncher$p(this.this$0), 5459);
            return;
        }
        Intent data = activityResult.getData();
        Object obj = (data == null || (extras2 = data.getExtras()) == null) ? null : extras2.get("error_message");
        Intent data2 = activityResult.getData();
        Object obj2 = (data2 == null || (extras = data2.getExtras()) == null) ? null : extras.get("error_code");
        WidgetOauth2AuthorizeSamsung.Companion.logW$default(WidgetOauth2AuthorizeSamsung.INSTANCE, "Connection requires disclaimer acceptance. [" + obj2 + "] " + obj, null, 2, null);
        AppToast.i(this.this$0, R.string.failed, 0, 4);
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }
}
