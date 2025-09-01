package com.discord.widgets.servers.member_verification;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: MemberVerificationSuccessDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "appActivity", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog$Companion$enqueue$memberVerificationSuccessDialogNotice$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MemberVerificationSuccessDialog2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationSuccessDialog2(long j, StoreNotices storeNotices, String str) {
        super(1);
        this.$guildId = j;
        this.$storeNotices = storeNotices;
        this.$noticeName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "appActivity");
        MemberVerificationSuccessDialog memberVerificationSuccessDialog = new MemberVerificationSuccessDialog();
        Bundle bundle = new Bundle();
        bundle.putLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, this.$guildId);
        memberVerificationSuccessDialog.setArguments(bundle);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        memberVerificationSuccessDialog.show(supportFragmentManager, Reflection2.getOrCreateKotlinClass(MemberVerificationSuccessDialog.class).toString());
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
