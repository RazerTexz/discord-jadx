package com.discord.widgets.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubAddServer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "activityResult", "", "onActivityResult", "(Landroidx/activity/result/ActivityResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$launcher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddServer6<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ WidgetHubAddServer this$0;

    public WidgetHubAddServer6(WidgetHubAddServer widgetHubAddServer) {
        this.this$0 = widgetHubAddServer;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        WidgetGuildCreate.Result result;
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        Intent data = activityResult.getData();
        if (data != null) {
            if (!(activityResult.getResultCode() == -1)) {
                data = null;
            }
            if (data == null || (result = (WidgetGuildCreate.Result) data.getParcelableExtra("intent_args_key")) == null) {
                return;
            }
            WidgetHubAddServer.access$onServerClickListener(this.this$0, result.getGuildId(), true);
        }
    }
}
