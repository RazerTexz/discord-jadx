package com.discord.utilities.view.layoutparams;

import android.widget.RelativeLayout;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: LayoutParamsExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/widget/RelativeLayout$LayoutParams;", "", "verb", "", "removeRuleCompat", "(Landroid/widget/RelativeLayout$LayoutParams;I)V", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.layoutparams.LayoutParamsExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class LayoutParamsExtensions {
    public static final void removeRuleCompat(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics3.checkNotNullParameter(layoutParams, "$this$removeRuleCompat");
        layoutParams.removeRule(i);
    }
}
