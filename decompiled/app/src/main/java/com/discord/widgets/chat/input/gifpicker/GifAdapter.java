package com.discord.widgets.chat.input.gifpicker;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.GifItemViewBinding;
import com.discord.databinding.GifSuggestedTermViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GifAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*Bc\u0012\u0006\u0010'\u001a\u00020&\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\r\u0018\u00010\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\r\u0018\u00010\u001b\u0012\u001a\b\u0002\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020#¢\u0006\u0004\b(\u0010)J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\r\u0018\u00010\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\r\u0018\u00010\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001eR(\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewTypeInt", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder;", "getItemCount", "()I", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/chat/input/gifpicker/GifViewHolder;I)V", "getItemViewType", "(I)I", "", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem;", "newItems", "setItems", "(Ljava/util/List;)V", "clearItems", "()V", "items", "Ljava/util/List;", "Lkotlin/Function1;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;", "onSelectGif", "Lkotlin/jvm/functions/Function1;", "columnWidthPx", "I", "", "onSelectSuggestedTerm", "Lcom/discord/utilities/recycler/DiffCreator;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "Lcom/discord/app/AppComponent;", "appComponent", "<init>", "(Lcom/discord/app/AppComponent;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function1;Lcom/discord/utilities/recycler/DiffCreator;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GifAdapter extends RecyclerView.Adapter<GifViewHolder> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_COLUMN_COUNT = 2;
    private static final int MIN_COLUMN_WIDTH_DP = 164;
    private final int columnWidthPx;
    private final DiffCreator<List<GifAdapterItem>, GifViewHolder> diffCreator;
    private List<? extends GifAdapterItem> items;
    private final Function1<GifAdapterItem.GifItem, Unit> onSelectGif;
    private final Function1<String, Unit> onSelectSuggestedTerm;

    /* compiled from: GifAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapter$Companion;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "numColumns", "columnSpacePx", "calculateColumnWidth", "(Landroidx/recyclerview/widget/RecyclerView;II)I", "calculateColumnCount", "(Landroidx/recyclerview/widget/RecyclerView;)I", "DEFAULT_COLUMN_COUNT", "I", "MIN_COLUMN_WIDTH_DP", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final int calculateColumnCount(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Resources resources = recyclerView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "recyclerView.resources");
            return Math.max(2, Math.max(resources.getDisplayMetrics().widthPixels, 1) / DimenUtils.dpToPixels(164));
        }

        public final int calculateColumnWidth(RecyclerView recyclerView, int numColumns, int columnSpacePx) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Resources resources = recyclerView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            int i = resources.getDisplayMetrics().widthPixels;
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            int marginStart = i - (layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams) : 0);
            return (int) (((((marginStart - (recyclerView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r1) : 0)) - recyclerView.getPaddingStart()) - recyclerView.getPaddingEnd()) - ((numColumns - 1) * columnSpacePx)) / numColumns);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GifAdapterItem.ViewType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GifAdapterItem.ViewType.VIEW_TYPE_GIF_ITEM.ordinal()] = 1;
            iArr[GifAdapterItem.ViewType.VIEW_TYPE_GIF_SEARCH_TERMS_EMPTY_RESULTS.ordinal()] = 2;
            iArr[GifAdapterItem.ViewType.VIEW_TYPE_GIF_SEARCH_TERMS_NON_EMPTY_RESULTS.ordinal()] = 3;
        }
    }

    /* compiled from: GifAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem;", "items", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GifAdapterItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GifAdapterItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends GifAdapterItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            GifAdapter.access$setItems$p(GifAdapter.this, list);
        }
    }

    public /* synthetic */ GifAdapter(AppComponent appComponent, Function1 function1, int i, Function1 function12, DiffCreator diffCreator, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i2 & 2) != 0 ? null : function1, i, (i2 & 8) != 0 ? null : function12, (i2 & 16) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(GifAdapter gifAdapter) {
        return gifAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(GifAdapter gifAdapter, List list) {
        gifAdapter.items = list;
    }

    public final void clearItems() {
        setItems(Collections2.emptyList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((GifViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends GifAdapterItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GifAdapter(AppComponent appComponent, Function1<? super GifAdapterItem.GifItem, Unit> function1, int i, Function1<? super String, Unit> function12, DiffCreator<List<GifAdapterItem>, GifViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.onSelectGif = function1;
        this.columnWidthPx = i;
        this.onSelectSuggestedTerm = function12;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(GifViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        GifAdapterItem gifAdapterItem = this.items.get(position);
        if (gifAdapterItem instanceof GifAdapterItem.GifItem) {
            ((GifViewHolder.Gif) holder).configure((GifAdapterItem.GifItem) gifAdapterItem, this.columnWidthPx, this.onSelectGif);
        } else if (gifAdapterItem instanceof GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults) {
            ((GifViewHolder.SuggestedTerms) holder).configure((GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults) gifAdapterItem, this.onSelectSuggestedTerm);
        } else if (gifAdapterItem instanceof GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults) {
            ((GifViewHolder.SuggestedTerms) holder).configure((GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults) gifAdapterItem, this.onSelectSuggestedTerm);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GifViewHolder onCreateViewHolder(ViewGroup parent, int viewTypeInt) {
        GifViewHolder gif;
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int iOrdinal = GifAdapterItem.ViewType.INSTANCE.fromInt(viewTypeInt).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1 && iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            View viewInflate = layoutInflaterFrom.inflate(R.layout.gif_suggested_term_view, parent, false);
            LinearLayout linearLayout = (LinearLayout) viewInflate;
            int i = R.id.gif_search_suggested_terms_flex_box;
            FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate.findViewById(R.id.gif_search_suggested_terms_flex_box);
            if (flexboxLayout != null) {
                i = R.id.gif_search_suggested_terms_icon_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.gif_search_suggested_terms_icon_text);
                if (textView != null) {
                    GifSuggestedTermViewBinding gifSuggestedTermViewBinding = new GifSuggestedTermViewBinding((LinearLayout) viewInflate, linearLayout, flexboxLayout, textView);
                    Intrinsics3.checkNotNullExpressionValue(gifSuggestedTermViewBinding, "GifSuggestedTermViewBind…(inflater, parent, false)");
                    gif = new GifViewHolder.SuggestedTerms(gifSuggestedTermViewBinding);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.gif_item_view, parent, false);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(R.id.gif_item_image);
        if (simpleDraweeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(R.id.gif_item_image)));
        }
        GifItemViewBinding gifItemViewBinding = new GifItemViewBinding((CardView) viewInflate2, simpleDraweeView);
        Intrinsics3.checkNotNullExpressionValue(gifItemViewBinding, "GifItemViewBinding.infla…(inflater, parent, false)");
        gif = new GifViewHolder.Gif(gifItemViewBinding);
        return gif;
    }
}
