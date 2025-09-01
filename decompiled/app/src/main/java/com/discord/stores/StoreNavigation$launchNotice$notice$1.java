package com.discord.stores;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreNavigation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "it", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreNavigation$launchNotice$notice$1 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ Function1 $showAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNavigation$launchNotice$notice$1(String str, Function1 function1) {
        super(1);
        this.$noticeName = str;
        this.$showAction = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "it");
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), this.$noticeName, 0L, 2, null);
        return ((Boolean) this.$showAction.invoke(fragmentActivity)).booleanValue();
    }
}
