package com.discord.utilities.hubs;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppFragment;
import com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog;
import com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog2;
import com.discord.widgets.hubs.WidgetHubDescription2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: HubUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/app/AppFragment;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getAddServerActivityResultHandler", "(Lcom/discord/app/AppFragment;)Landroidx/activity/result/ActivityResultLauncher;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.hubs.HubUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class HubUtils {

    /* compiled from: HubUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "activityResult", "", "onActivityResult", "(Landroidx/activity/result/ActivityResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.hubs.HubUtilsKt$getAddServerActivityResultHandler$1, reason: invalid class name */
    public static final class AnonymousClass1<O> implements ActivityResultCallback<ActivityResult> {
        public final /* synthetic */ AppFragment $this_getAddServerActivityResultHandler;

        public AnonymousClass1(AppFragment appFragment) {
            this.$this_getAddServerActivityResultHandler = appFragment;
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
                WidgetHubDescription2 widgetHubDescription2 = (WidgetHubDescription2) data.getParcelableExtra("intent_args_key");
                if (widgetHubDescription2 != null) {
                    WidgetHubAddServerConfirmationDialog.Companion companion = WidgetHubAddServerConfirmationDialog.INSTANCE;
                    FragmentManager parentFragmentManager = this.$this_getAddServerActivityResultHandler.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, new WidgetHubAddServerConfirmationDialog2(widgetHubDescription2.getGuildId(), widgetHubDescription2.getHubName()));
                }
            }
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
            onActivityResult2(activityResult);
        }
    }

    public static final ActivityResultLauncher<Intent> getAddServerActivityResultHandler(AppFragment appFragment) {
        Intrinsics3.checkNotNullParameter(appFragment, "$this$getAddServerActivityResultHandler");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = appFragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new AnonymousClass1(appFragment));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…      )\n          }\n    }");
        return activityResultLauncherRegisterForActivityResult;
    }
}
