package com.discord.widgets.guildscheduledevent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "result", "", "onActivityResult", "(Landroidx/activity/result/ActivityResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$Companion$registerForResult$1<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function0 $onFinished;
    public final /* synthetic */ Function0 $onQuit;

    public WidgetGuildScheduledEventSettings$Companion$registerForResult$1(Function0 function0, Function0 function02) {
        this.$onFinished = function0;
        this.$onQuit = function02;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "result");
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            this.$onFinished.invoke();
        } else {
            if (resultCode != 2) {
                return;
            }
            this.$onQuit.invoke();
        }
    }
}
