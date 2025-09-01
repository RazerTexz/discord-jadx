package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: GifSearchViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "kotlin.jvm.PlatformType", "terms", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifSearchViewModel4<T, R> implements Func1<List<? extends String>, Observable<? extends GifSearchViewModel.StoreState>> {
    public final /* synthetic */ BehaviorSubject $searchSubject;
    public final /* synthetic */ StoreAnalytics $storeAnalytics;
    public final /* synthetic */ StoreGifPicker $storeGifPicker;

    public GifSearchViewModel4(BehaviorSubject behaviorSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker) {
        this.$searchSubject = behaviorSubject;
        this.$storeAnalytics = storeAnalytics;
        this.$storeGifPicker = storeGifPicker;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends GifSearchViewModel.StoreState> call(List<? extends String> list) {
        return call2((List<String>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GifSearchViewModel.StoreState> call2(List<String> list) {
        GifSearchViewModel.Companion companion = GifSearchViewModel.INSTANCE;
        BehaviorSubject behaviorSubject = this.$searchSubject;
        StoreAnalytics storeAnalytics = this.$storeAnalytics;
        StoreGifPicker storeGifPicker = this.$storeGifPicker;
        Intrinsics3.checkNotNullExpressionValue(list, "terms");
        return GifSearchViewModel.Companion.access$observeQueryState(companion, behaviorSubject, storeAnalytics, storeGifPicker, list);
    }
}
