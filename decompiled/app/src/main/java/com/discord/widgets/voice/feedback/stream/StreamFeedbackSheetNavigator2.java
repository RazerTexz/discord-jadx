package com.discord.widgets.voice.feedback.stream;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StreamFeedbackSheetNavigator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetNavigator$enqueueNotice$showStreamFeedbackSheetNotice$1, reason: use source file name */
/* loaded from: classes.dex */
public final class StreamFeedbackSheetNavigator2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $mediaSessionId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ long $requestedShowTimestamp;
    public final /* synthetic */ StoreNotices $storeNotices;
    public final /* synthetic */ String $streamKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamFeedbackSheetNavigator2(long j, String str, String str2, StoreNotices storeNotices, String str3) {
        super(1);
        this.$requestedShowTimestamp = j;
        this.$streamKey = str;
        this.$mediaSessionId = str2;
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
        StreamFeedbackSheetNavigator streamFeedbackSheetNavigator = StreamFeedbackSheetNavigator.INSTANCE;
        if (StreamFeedbackSheetNavigator.access$getClock$p(streamFeedbackSheetNavigator).currentTimeMillis() - this.$requestedShowTimestamp < 3000) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
            StreamFeedbackSheetNavigator.access$show(streamFeedbackSheetNavigator, supportFragmentManager, this.$streamKey, this.$mediaSessionId);
        }
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
