package com.discord.utilities.view.recycler;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: ViewPager2Extensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a5\u0010\b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/android/material/tabs/TabLayout;", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Lkotlin/Function2;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "", "", "configureTab", "setUpWithViewPager2", "(Lcom/google/android/material/tabs/TabLayout;Landroidx/viewpager2/widget/ViewPager2;Lkotlin/jvm/functions/Function2;)V", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewPager2Extensions {

    /* compiled from: ViewPager2Extensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$Tab;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "invoke", "(Lcom/google/android/material/tabs/TabLayout$Tab;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt$setUpWithViewPager2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<TabLayout.Tab, Integer, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.a;
        }

        public final void invoke(TabLayout.Tab tab, int i) {
            Intrinsics3.checkNotNullParameter(tab, "<anonymous parameter 0>");
        }
    }

    public static final void setUpWithViewPager2(TabLayout tabLayout, ViewPager2 viewPager2, Function2<? super TabLayout.Tab, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(tabLayout, "$this$setUpWithViewPager2");
        Intrinsics3.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics3.checkNotNullParameter(function2, "configureTab");
        new TabLayoutMediator(tabLayout, viewPager2, new ViewPager2Extensions2(function2)).attach();
    }

    public static /* synthetic */ void setUpWithViewPager2$default(TabLayout tabLayout, ViewPager2 viewPager2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = AnonymousClass1.INSTANCE;
        }
        setUpWithViewPager2(tabLayout, viewPager2, function2);
    }
}
