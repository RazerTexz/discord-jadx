package com.discord.utilities.view.recycler;

import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: ViewPager2Extensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt$sam$com_google_android_material_tabs_TabLayoutMediator_TabConfigurationStrategy$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewPager2Extensions2 implements TabLayoutMediator.TabConfigurationStrategy {
    private final /* synthetic */ Function2 function;

    public ViewPager2Extensions2(Function2 function2) {
        this.function = function2;
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
    public final /* synthetic */ void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
        Intrinsics3.checkNotNullParameter(tab, "p0");
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(tab, Integer.valueOf(i)), "invoke(...)");
    }
}
