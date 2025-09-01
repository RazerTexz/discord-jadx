package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetStickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u00017B_\u0012\u0006\u00104\u001a\u000203\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$\u0012\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020&\u0018\u00010$\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012\u0012\u0006\u0010/\u001a\u00020.\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b5\u00106J+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u00020\u00178\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00048\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R%\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R'\u0010,\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020&\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u0019\u0010/\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00068"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/WidgetStickerAdapter;", "Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "isHeader", "(I)Z", "adapter", "Lcom/discord/widgets/chat/input/sticker/OwnedHeaderViewHolder;", "createStickyHeaderViewHolder", "(Lcom/discord/widgets/chat/input/expression/WidgetExpressionPickerAdapter;)Lcom/discord/widgets/chat/input/sticker/OwnedHeaderViewHolder;", "Lrx/subjects/BehaviorSubject;", "recyclerScrollingWithinThresholdSubject", "Lrx/subjects/BehaviorSubject;", "getRecyclerScrollingWithinThresholdSubject", "()Lrx/subjects/BehaviorSubject;", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "showStickerPackDescriptions", "Z", "getShowStickerPackDescriptions", "()Z", "numColumns", "I", "getNumColumns", "()I", "Lkotlin/Function1;", "Lcom/discord/widgets/chat/input/sticker/StickerItem;", "", "onStickerItemSelected", "Lkotlin/jvm/functions/Function1;", "getOnStickerItemSelected", "()Lkotlin/jvm/functions/Function1;", "Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;", "onStickerHeaderItemsClicked", "getOnStickerHeaderItemsClicked", "Lcom/discord/app/AppComponent;", "appComponent", "Lcom/discord/app/AppComponent;", "getAppComponent", "()Lcom/discord/app/AppComponent;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lrx/subjects/BehaviorSubject;Lcom/discord/app/AppComponent;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStickerAdapter extends WidgetExpressionPickerAdapter {
    public static final int DEFAULT_NUM_COLUMNS = 4;
    public static final int ITEM_TYPE_OWNED_HEADER = 0;
    public static final int ITEM_TYPE_STICKER = 1;
    public static final int ITEM_TYPE_STORE_HEADER = 2;
    private final AppComponent appComponent;
    private final GridLayoutManager layoutManager;
    private final int numColumns;
    private final Function1<StickerAdapterItems4, Unit> onStickerHeaderItemsClicked;
    private final Function1<StickerAdapterItems3, Unit> onStickerItemSelected;
    private final BehaviorSubject<Boolean> recyclerScrollingWithinThresholdSubject;
    private final boolean showStickerPackDescriptions;

    /* compiled from: WidgetStickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"com/discord/widgets/chat/input/sticker/WidgetStickerAdapter$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getSpanSize", "(I)I", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends GridLayoutManager.SpanSizeLookup {
        public AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            int itemViewType = WidgetStickerAdapter.this.getItemViewType(position);
            if (itemViewType == 0 || itemViewType == 2) {
                return WidgetStickerAdapter.this.getNumColumns();
            }
            return 1;
        }
    }

    public /* synthetic */ WidgetStickerAdapter(RecyclerView recyclerView, Function1 function1, Function1 function12, BehaviorSubject behaviorSubject, AppComponent appComponent, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, function1, (i & 4) != 0 ? null : function12, (i & 8) != 0 ? null : behaviorSubject, appComponent, (i & 32) != 0 ? false : z2);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public /* bridge */ /* synthetic */ WidgetExpressionPickerAdapter.StickyHeaderViewHolder createStickyHeaderViewHolder(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
        return createStickyHeaderViewHolder(widgetExpressionPickerAdapter);
    }

    public final AppComponent getAppComponent() {
        return this.appComponent;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public GridLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public int getNumColumns() {
        return this.numColumns;
    }

    public final Function1<StickerAdapterItems4, Unit> getOnStickerHeaderItemsClicked() {
        return this.onStickerHeaderItemsClicked;
    }

    public final Function1<StickerAdapterItems3, Unit> getOnStickerItemSelected() {
        return this.onStickerItemSelected;
    }

    public final BehaviorSubject<Boolean> getRecyclerScrollingWithinThresholdSubject() {
        return this.recyclerScrollingWithinThresholdSubject;
    }

    public final boolean getShowStickerPackDescriptions() {
        return this.showStickerPackDescriptions;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        return ((MGRecyclerDataPayload) _Collections.getOrNull(getInternalData(), position)) instanceof StickerAdapterItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetStickerAdapter(RecyclerView recyclerView, Function1<? super StickerAdapterItems3, Unit> function1, Function1<? super StickerAdapterItems4, Unit> function12, BehaviorSubject<Boolean> behaviorSubject, AppComponent appComponent, boolean z2) {
        super(recyclerView, SetsJVM.setOf(0));
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function1, "onStickerItemSelected");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        this.onStickerItemSelected = function1;
        this.onStickerHeaderItemsClicked = function12;
        this.recyclerScrollingWithinThresholdSubject = behaviorSubject;
        this.appComponent = appComponent;
        this.showStickerPackDescriptions = z2;
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        this.numColumns = WidgetExpressionPickerAdapter.INSTANCE.calculateNumOfColumns(recyclerView, context.getResources().getDimension(R.dimen.chat_input_sticker_size), 4);
        this.layoutManager = new GridLayoutManager(recyclerView.getContext(), getNumColumns());
        getLayoutManager().setSpanSizeLookup(new AnonymousClass1());
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(this);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter
    public StickerAdapterViewHolders createStickyHeaderViewHolder(WidgetExpressionPickerAdapter adapter) {
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        return new StickerAdapterViewHolders((WidgetStickerAdapter) adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new StickerAdapterViewHolders(this);
        }
        if (viewType == 1) {
            return new StickerAdapterViewHolders2(viewType, this, this.recyclerScrollingWithinThresholdSubject, this.appComponent);
        }
        if (viewType == 2) {
            return new StickerAdapterViewHolders3(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
