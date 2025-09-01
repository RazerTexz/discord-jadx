package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreGifPicker;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: GifSearchViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "query", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifSearchViewModel3<T, R> implements Func1<String, Observable<? extends GifSearchViewModel.StoreState>> {
    public final /* synthetic */ StoreGifPicker $storeGifPicker;
    public final /* synthetic */ List $trendingSearchTerms;

    /* compiled from: GifSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/models/gifpicker/dto/ModelGif;", "kotlin.jvm.PlatformType", "gifResults", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends ModelGif>, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(List<? extends ModelGif> list) {
            return call2((List<ModelGif>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<ModelGif> list) {
            return Boolean.valueOf(list != StoreGifPicker.INSTANCE.getSearchResultsLoadingList());
        }
    }

    /* compiled from: GifSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/models/gifpicker/dto/ModelGif;", "kotlin.jvm.PlatformType", "gifResults", "", "searchTerms", "Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState$SearchResults;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/util/List;)Lcom/discord/widgets/chat/input/gifpicker/GifSearchViewModel$StoreState$SearchResults;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<? extends ModelGif>, List<? extends String>, GifSearchViewModel.StoreState.SearchResults> {
        public final /* synthetic */ String $query;

        public AnonymousClass2(String str) {
            this.$query = str;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ GifSearchViewModel.StoreState.SearchResults call(List<? extends ModelGif> list, List<? extends String> list2) {
            return call2((List<ModelGif>) list, (List<String>) list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GifSearchViewModel.StoreState.SearchResults call2(List<ModelGif> list, List<String> list2) {
            Intrinsics3.checkNotNullExpressionValue(list, "gifResults");
            Intrinsics3.checkNotNullExpressionValue(list2, "searchTerms");
            return new GifSearchViewModel.StoreState.SearchResults(list, list2, GifSearchViewModel3.this.$trendingSearchTerms, this.$query);
        }
    }

    public GifSearchViewModel3(List list, StoreGifPicker storeGifPicker) {
        this.$trendingSearchTerms = list;
        this.$storeGifPicker = storeGifPicker;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends GifSearchViewModel.StoreState> call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GifSearchViewModel.StoreState> call2(String str) {
        Intrinsics3.checkNotNullExpressionValue(str, "query");
        return str.length() == 0 ? new ScalarSynchronousObservable(new GifSearchViewModel.StoreState.TrendingSearchTermsResults(this.$trendingSearchTerms)) : Observable.j(this.$storeGifPicker.observeGifsForSearchQuery(str).y(AnonymousClass1.INSTANCE), this.$storeGifPicker.observeSuggestedSearchTerms(str), new AnonymousClass2(str));
    }
}
