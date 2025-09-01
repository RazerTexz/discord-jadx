package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreAnalytics;
import com.discord.utilities.analytics.SearchType;
import kotlin.Metadata;
import rx.functions.Action1;

/* compiled from: GifSearchViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifSearchViewModel2<T> implements Action1<String> {
    public final /* synthetic */ StoreAnalytics $storeAnalytics;

    public GifSearchViewModel2(StoreAnalytics storeAnalytics) {
        this.$storeAnalytics = storeAnalytics;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        StoreAnalytics.trackSearchStarted$default(this.$storeAnalytics, SearchType.GIF, null, false, 6, null);
    }
}
