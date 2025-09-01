package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: GifPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\f\rB\u0017\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$ViewState;", "Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$StoreState;)V", "Lrx/Observable;", "storeStateObservable", "<init>", "(Lrx/Observable;)V", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GifPickerViewModel extends AppViewModel<ViewState> {

    /* compiled from: GifPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/models/gifpicker/domain/ModelGifCategory;", "kotlin.jvm.PlatformType", "gifCategories", "", "trendingGifCategoryPreviewUrl", "Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/lang/String;)Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifPickerViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<List<? extends ModelGifCategory>, String, StoreState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ StoreState call(List<? extends ModelGifCategory> list, String str) {
            return call2((List<ModelGifCategory>) list, str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreState call2(List<ModelGifCategory> list, String str) {
            Intrinsics3.checkNotNullExpressionValue(list, "gifCategories");
            Intrinsics3.checkNotNullExpressionValue(str, "trendingGifCategoryPreviewUrl");
            return new StoreState(list, str);
        }
    }

    /* compiled from: GifPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifPickerViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GifPickerViewModel.access$handleStoreState(GifPickerViewModel.this, storeState);
        }
    }

    /* compiled from: GifPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$StoreState;", "", "", "Lcom/discord/models/gifpicker/domain/ModelGifCategory;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "gifCategories", "trendingGifCategoryPreviewUrl", "copy", "(Ljava/util/List;Ljava/lang/String;)Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$StoreState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getGifCategories", "Ljava/lang/String;", "getTrendingGifCategoryPreviewUrl", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final List<ModelGifCategory> gifCategories;
        private final String trendingGifCategoryPreviewUrl;

        public StoreState(List<ModelGifCategory> list, String str) {
            Intrinsics3.checkNotNullParameter(list, "gifCategories");
            Intrinsics3.checkNotNullParameter(str, "trendingGifCategoryPreviewUrl");
            this.gifCategories = list;
            this.trendingGifCategoryPreviewUrl = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.gifCategories;
            }
            if ((i & 2) != 0) {
                str = storeState.trendingGifCategoryPreviewUrl;
            }
            return storeState.copy(list, str);
        }

        public final List<ModelGifCategory> component1() {
            return this.gifCategories;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTrendingGifCategoryPreviewUrl() {
            return this.trendingGifCategoryPreviewUrl;
        }

        public final StoreState copy(List<ModelGifCategory> gifCategories, String trendingGifCategoryPreviewUrl) {
            Intrinsics3.checkNotNullParameter(gifCategories, "gifCategories");
            Intrinsics3.checkNotNullParameter(trendingGifCategoryPreviewUrl, "trendingGifCategoryPreviewUrl");
            return new StoreState(gifCategories, trendingGifCategoryPreviewUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.gifCategories, storeState.gifCategories) && Intrinsics3.areEqual(this.trendingGifCategoryPreviewUrl, storeState.trendingGifCategoryPreviewUrl);
        }

        public final List<ModelGifCategory> getGifCategories() {
            return this.gifCategories;
        }

        public final String getTrendingGifCategoryPreviewUrl() {
            return this.trendingGifCategoryPreviewUrl;
        }

        public int hashCode() {
            List<ModelGifCategory> list = this.gifCategories;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.trendingGifCategoryPreviewUrl;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(gifCategories=");
            sbU.append(this.gifCategories);
            sbU.append(", trendingGifCategoryPreviewUrl=");
            return outline.J(sbU, this.trendingGifCategoryPreviewUrl, ")");
        }
    }

    /* compiled from: GifPickerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005R\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$ViewState;", "", "", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "component1", "()Ljava/util/List;", "gifCategoryItems", "copy", "(Ljava/util/List;)Lcom/discord/widgets/chat/input/gifpicker/GifPickerViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getGifCategoryItems", "isLoaded", "Z", "()Z", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final List<GifCategoryItem> gifCategoryItems;
        private final boolean isLoaded;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<? extends GifCategoryItem> list) {
            Intrinsics3.checkNotNullParameter(list, "gifCategoryItems");
            this.gifCategoryItems = list;
            this.isLoaded = !list.isEmpty();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.gifCategoryItems;
            }
            return viewState.copy(list);
        }

        public final List<GifCategoryItem> component1() {
            return this.gifCategoryItems;
        }

        public final ViewState copy(List<? extends GifCategoryItem> gifCategoryItems) {
            Intrinsics3.checkNotNullParameter(gifCategoryItems, "gifCategoryItems");
            return new ViewState(gifCategoryItems);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ViewState) && Intrinsics3.areEqual(this.gifCategoryItems, ((ViewState) other).gifCategoryItems);
            }
            return true;
        }

        public final List<GifCategoryItem> getGifCategoryItems() {
            return this.gifCategoryItems;
        }

        public int hashCode() {
            List<GifCategoryItem> list = this.gifCategoryItems;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        /* renamed from: isLoaded, reason: from getter */
        public final boolean getIsLoaded() {
            return this.isLoaded;
        }

        public String toString() {
            return outline.L(outline.U("ViewState(gifCategoryItems="), this.gifCategoryItems, ")");
        }
    }

    public GifPickerViewModel() {
        this(null, 1, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifPickerViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            observable = Observable.j(companion.getGifPicker().observeGifCategories(), companion.getGifPicker().observeTrendingGifCategoryPreviewUrl(), AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observable, "Observable.combineLatest…egoryPreviewUrl\n    )\n  }");
        }
        this(observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GifPickerViewModel gifPickerViewModel, StoreState storeState) {
        gifPickerViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        ArrayList arrayList = new ArrayList();
        if (storeState.getTrendingGifCategoryPreviewUrl().length() > 0) {
            arrayList.add(new GifCategoryItem.Trending(storeState.getTrendingGifCategoryPreviewUrl()));
        }
        List<ModelGifCategory> gifCategories = storeState.getGifCategories();
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(gifCategories, 10));
        Iterator<T> it = gifCategories.iterator();
        while (it.hasNext()) {
            arrayList2.add(new GifCategoryItem.Standard((ModelGifCategory) it.next()));
        }
        arrayList.addAll(arrayList2);
        updateViewState(new ViewState(arrayList));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifPickerViewModel(Observable<StoreState> observable) {
        super(new ViewState(Collections2.emptyList()));
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GifPickerViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
