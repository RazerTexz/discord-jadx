package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.SearchType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.LazyJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GifCategoryViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001e\u001f BE\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$ViewState;", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$StoreState;)V", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;", "gifItem", "selectGif", "(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;)V", "Lcom/discord/stores/StoreGifPicker;", "storeGifPicker", "Lcom/discord/stores/StoreGifPicker;", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "gifCategoryItem", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "Lcom/discord/widgets/chat/MessageManager;", "messageManager", "Lcom/discord/widgets/chat/MessageManager;", "Landroid/content/Context;", "context", "Lrx/Observable;", "storeStateObservable", "<init>", "(Landroid/content/Context;Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;Lcom/discord/widgets/chat/MessageManager;Lcom/discord/stores/StoreGifPicker;Lcom/discord/stores/StoreAnalytics;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GifCategoryViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GifCategoryItem gifCategoryItem;
    private final MessageManager messageManager;
    private final StoreAnalytics storeAnalytics;
    private final StoreGifPicker storeGifPicker;

    /* compiled from: GifCategoryViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
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
            GifCategoryViewModel.access$handleStoreState(GifCategoryViewModel.this, storeState);
        }
    }

    /* compiled from: GifCategoryViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$Companion;", "", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "gifCategoryItem", "Lcom/discord/stores/StoreGifPicker;", "storeGifPicker", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$StoreState;", "observeStoreState", "(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;Lcom/discord/stores/StoreGifPicker;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, GifCategoryItem gifCategoryItem, StoreGifPicker storeGifPicker) {
            return companion.observeStoreState(gifCategoryItem, storeGifPicker);
        }

        private final Observable<StoreState> observeStoreState(GifCategoryItem gifCategoryItem, StoreGifPicker storeGifPicker) {
            Observable<List<ModelGif>> observableObserveTrendingCategoryGifs;
            if (gifCategoryItem instanceof GifCategoryItem.Standard) {
                observableObserveTrendingCategoryGifs = storeGifPicker.observeGifsForSearchQuery(((GifCategoryItem.Standard) gifCategoryItem).getGifCategory().getCategoryName());
            } else {
                if (!(gifCategoryItem instanceof GifCategoryItem.Trending)) {
                    throw new NoWhenBranchMatchedException();
                }
                observableObserveTrendingCategoryGifs = storeGifPicker.observeTrendingCategoryGifs();
            }
            Observable observableG = observableObserveTrendingCategoryGifs.G(GifCategoryViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "gifsObservable.map { gifs -> StoreState(gifs) }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GifCategoryViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$StoreState;", "", "", "Lcom/discord/models/gifpicker/dto/ModelGif;", "component1", "()Ljava/util/List;", "gifs", "copy", "(Ljava/util/List;)Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getGifs", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final List<ModelGif> gifs;

        public StoreState(List<ModelGif> list) {
            Intrinsics3.checkNotNullParameter(list, "gifs");
            this.gifs = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.gifs;
            }
            return storeState.copy(list);
        }

        public final List<ModelGif> component1() {
            return this.gifs;
        }

        public final StoreState copy(List<ModelGif> gifs) {
            Intrinsics3.checkNotNullParameter(gifs, "gifs");
            return new StoreState(gifs);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && Intrinsics3.areEqual(this.gifs, ((StoreState) other).gifs);
            }
            return true;
        }

        public final List<ModelGif> getGifs() {
            return this.gifs;
        }

        public int hashCode() {
            List<ModelGif> list = this.gifs;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.L(outline.U("StoreState(gifs="), this.gifs, ")");
        }
    }

    /* compiled from: GifCategoryViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005R#\u0010\u001a\u001a\u00020\f8F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$ViewState;", "", "", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;", "component1", "()Ljava/util/List;", "gifItems", "copy", "(Ljava/util/List;)Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getGifItems", "gifCount$delegate", "Lkotlin/Lazy;", "getGifCount", "getGifCount$annotations", "()V", "gifCount", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {

        /* renamed from: gifCount$delegate, reason: from kotlin metadata */
        private final Lazy gifCount;
        private final List<GifAdapterItem.GifItem> gifItems;

        public ViewState(List<GifAdapterItem.GifItem> list) {
            Intrinsics3.checkNotNullParameter(list, "gifItems");
            this.gifItems = list;
            this.gifCount = LazyJVM.lazy(new GifCategoryViewModel3(this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.gifItems;
            }
            return viewState.copy(list);
        }

        public static /* synthetic */ void getGifCount$annotations() {
        }

        public final List<GifAdapterItem.GifItem> component1() {
            return this.gifItems;
        }

        public final ViewState copy(List<GifAdapterItem.GifItem> gifItems) {
            Intrinsics3.checkNotNullParameter(gifItems, "gifItems");
            return new ViewState(gifItems);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ViewState) && Intrinsics3.areEqual(this.gifItems, ((ViewState) other).gifItems);
            }
            return true;
        }

        public final int getGifCount() {
            return ((Number) this.gifCount.getValue()).intValue();
        }

        public final List<GifAdapterItem.GifItem> getGifItems() {
            return this.gifItems;
        }

        public int hashCode() {
            List<GifAdapterItem.GifItem> list = this.gifItems;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.L(outline.U("ViewState(gifItems="), this.gifItems, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifCategoryViewModel(Context context, GifCategoryItem gifCategoryItem, MessageManager messageManager, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        MessageManager messageManager2 = (i & 4) != 0 ? new MessageManager(context, null, null, null, null, null, null, null, null, 510, null) : messageManager;
        StoreGifPicker gifPicker = (i & 8) != 0 ? StoreStream.INSTANCE.getGifPicker() : storeGifPicker;
        this(context, gifCategoryItem, messageManager2, gifPicker, (i & 16) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, gifCategoryItem, gifPicker) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GifCategoryViewModel gifCategoryViewModel, StoreState storeState) {
        gifCategoryViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        List<ModelGif> gifs = storeState.getGifs();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(gifs, 10));
        Iterator<T> it = gifs.iterator();
        while (it.hasNext()) {
            arrayList.add(new GifAdapterItem.GifItem((ModelGif) it.next(), null, 2, null));
        }
        ViewState viewState = new ViewState(arrayList);
        StoreAnalytics.trackSearchResultViewed$default(this.storeAnalytics, SearchType.GIF, viewState.getGifCount(), null, null, false, 28, null);
        updateViewState(viewState);
    }

    public final void selectGif(GifAdapterItem.GifItem gifItem) {
        Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
        ViewState viewState = getViewState();
        if (viewState != null) {
            StoreAnalytics.trackSearchResultSelected$default(this.storeAnalytics, SearchType.GIF, viewState.getGifCount(), null, new Traits.Source(null, null, Traits.Source.Obj.GIF_PICKER, null, null, 27, null), 4, null);
        }
        MessageManager.sendMessage$default(this.messageManager, gifItem.getGif().getTenorGifUrl(), null, null, null, null, false, null, null, null, 510, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryViewModel(Context context, GifCategoryItem gifCategoryItem, MessageManager messageManager, StoreGifPicker storeGifPicker, StoreAnalytics storeAnalytics, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(storeGifPicker, "storeGifPicker");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.gifCategoryItem = gifCategoryItem;
        this.messageManager = messageManager;
        this.storeGifPicker = storeGifPicker;
        this.storeAnalytics = storeAnalytics;
        StoreAnalytics.trackSearchStarted$default(storeAnalytics, SearchType.GIF, null, false, 6, null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), this, null, 2, null), GifCategoryViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
