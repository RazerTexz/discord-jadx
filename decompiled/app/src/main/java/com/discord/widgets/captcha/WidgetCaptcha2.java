package com.discord.widgets.captcha;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCaptcha.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "activityResult", "", "onActivityResult", "(Landroidx/activity/result/ActivityResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.captcha.WidgetCaptcha$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCaptcha2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function1 $callback;

    public WidgetCaptcha2(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            String stringExtra = data != null ? data.getStringExtra("RESULT_EXTRA_TOKEN") : null;
            Intent data2 = activityResult.getData();
            String stringExtra2 = data2 != null ? data2.getStringExtra("RESULT_EXTRA_RQTOKEN") : null;
            if (stringExtra != null) {
                this.$callback.invoke(new CaptchaHelper.CaptchaPayload(stringExtra, stringExtra2));
            }
        }
    }
}
