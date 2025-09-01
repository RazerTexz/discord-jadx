package com.discord.widgets.channels;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetCreateChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "activityResult", "", "onActivityResult", "(Landroidx/activity/result/ActivityResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCreateChannel$Companion$registerForResult$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function3 $callback;

    public WidgetCreateChannel$Companion$registerForResult$1(Function3 function3) {
        this.$callback = function3;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intent data;
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null) {
            return;
        }
        long longExtra = data.getLongExtra("RESULT_EXTRA_CHANNEL_ID", -1L);
        String stringExtra = data.getStringExtra("RESULT_EXTRA_CHANNEL_NAME");
        int intExtra = data.getIntExtra("RESULT_EXTRA_CHANNEL_ICON_RES_ID", -1);
        if (longExtra != -1) {
            if ((stringExtra == null || StringsJVM.isBlank(stringExtra)) || intExtra == -1) {
                return;
            }
            this.$callback.invoke(Long.valueOf(longExtra), stringExtra, Integer.valueOf(intExtra));
        }
    }
}
