package com.discord.widgets.voice.feedback.call;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: CallFeedbackSheetNavigator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.feedback.call.CallFeedbackSheetNavigator$enqueueNotice$showCallFeedbackSheetNotice$1, reason: use source file name */
/* loaded from: classes.dex */
public final class CallFeedbackSheetNavigator2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ Long $callDurationMs;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ String $mediaSessionId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ long $requestedShowTimestamp;
    public final /* synthetic */ String $rtcConnectionId;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallFeedbackSheetNavigator2(long j, long j2, String str, String str2, Long l, StoreNotices storeNotices, String str3) {
        super(1);
        this.$requestedShowTimestamp = j;
        this.$channelId = j2;
        this.$rtcConnectionId = str;
        this.$mediaSessionId = str2;
        this.$callDurationMs = l;
        this.$storeNotices = storeNotices;
        this.$noticeName = str3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        CallFeedbackSheetNavigator callFeedbackSheetNavigator = CallFeedbackSheetNavigator.INSTANCE;
        if (CallFeedbackSheetNavigator.access$getClock$p(callFeedbackSheetNavigator).currentTimeMillis() - this.$requestedShowTimestamp < 3000) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
            CallFeedbackSheetNavigator.access$show(callFeedbackSheetNavigator, supportFragmentManager, this.$channelId, this.$rtcConnectionId, this.$mediaSessionId, this.$callDurationMs);
        }
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
