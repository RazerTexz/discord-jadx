package com.discord.widgets.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentActivity;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetHubEmailFlow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "activityResult", "", "onActivityResult", "(Landroidx/activity/result/ActivityResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$activityResultHandler$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEmailFlow2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    public WidgetHubEmailFlow2(WidgetHubEmailFlow widgetHubEmailFlow) {
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intent data;
        if (activityResult == null || (data = activityResult.getData()) == null) {
            return;
        }
        if (!(activityResult.getResultCode() == -1)) {
            data = null;
        }
        if (data != null) {
            Intrinsics3.checkNotNullParameter(data, "$this$getArgsFromIntent");
            WidgetHubDomains5 widgetHubDomains5 = (WidgetHubDomains5) data.getParcelableExtra("intent_args_key");
            if (widgetHubDomains5 != null) {
                if (widgetHubDomains5 instanceof WidgetHubWaitlist2) {
                    WidgetHubEmailFlow.access$getViewModel$p(this.this$0).setHubWaitlistResult((WidgetHubWaitlist2) widgetHubDomains5);
                    return;
                }
                if (!(widgetHubDomains5 instanceof WidgetHubAuthenticationlViewModel)) {
                    FragmentActivity activity = this.this$0.getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                StoreStream.INSTANCE.getGuildSelected().set(((WidgetHubAuthenticationlViewModel) widgetHubDomains5).getGuildId());
                FragmentActivity activity2 = this.this$0.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
    }
}
