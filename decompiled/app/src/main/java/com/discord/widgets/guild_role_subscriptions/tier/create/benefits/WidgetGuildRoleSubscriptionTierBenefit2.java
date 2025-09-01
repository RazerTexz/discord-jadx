package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/ActivityResult;", "kotlin.jvm.PlatformType", "activityResult", "", "onActivityResult", "(Landroidx/activity/result/ActivityResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function2 $onBenefitUpdate;

    public WidgetGuildRoleSubscriptionTierBenefit2(Function2 function2) {
        this.$onBenefitUpdate = function2;
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
            Benefit benefit = data != null ? (Benefit) data.getParcelableExtra("RESULT_EXTRA_BENEFIT") : null;
            Intent data2 = activityResult.getData();
            Benefit benefit2 = data2 != null ? (Benefit) data2.getParcelableExtra("RESULT_EXTRA_EXISTING_BENEFIT") : null;
            if (benefit == null && benefit2 == null) {
                return;
            }
            this.$onBenefitUpdate.invoke(benefit2, benefit);
        }
    }
}
