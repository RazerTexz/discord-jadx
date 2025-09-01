package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.utilities.notices.NoticeBuilders;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreNotices.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreNotices$Dialog$Type$buildPassiveNotice$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreNotices2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ StoreNotices.Dialog.Type this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotices2(StoreNotices.Dialog.Type type) {
        super(1);
        this.this$0 = type;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        StoreNotices.Dialog dialog = new StoreNotices.Dialog(this.this$0, null, 2, null);
        NoticeBuilders noticeBuilders = NoticeBuilders.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        noticeBuilders.showNotice(fragmentActivity, supportFragmentManager, dialog);
        return true;
    }
}
