package com.discord.widgets.guildscheduledevent;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.utilities.intent.IntentUtilsKt;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetPreviewGuildScheduledEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "activityResult", "", "onActivityResult", "(Landroidx/activity/result/ActivityResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent3<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function3 $onEventCreated;
    public final /* synthetic */ Function0 $onQuit;

    public WidgetPreviewGuildScheduledEvent3(Function3 function3, Function0 function0) {
        this.$onEventCreated = function3;
        this.$onQuit = function0;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Function0 function0;
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        int resultCode = activityResult.getResultCode();
        if (resultCode != -1) {
            if (resultCode == 2 && (function0 = this.$onQuit) != null) {
                return;
            }
            return;
        }
        Intent data = activityResult.getData();
        if (data != null) {
            Intrinsics3.checkNotNullExpressionValue(data, "it");
            this.$onEventCreated.invoke(IntentUtilsKt.getLongExtraOrNull(data, "com.discord.intent.extra.EXTRA_CHANNEL_ID"), Long.valueOf(data.getLongExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", 0L)), Boolean.valueOf(data.getBooleanExtra(WidgetPreviewGuildScheduledEvent.EXTRA_EVENT_CREATED, false)));
        }
    }
}
