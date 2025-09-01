package com.discord.widgets.chat.input.gifpicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.GifCategoryItemViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GifCategoryAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015\u0012\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00020\u001a¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewHolder;", "getItemCount", "()I", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewHolder;I)V", "", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "newItems", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function1;", "onSelectGifCategory", "Lkotlin/jvm/functions/Function1;", "items", "Ljava/util/List;", "Lcom/discord/utilities/recycler/DiffCreator;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "Lcom/discord/app/AppComponent;", "appComponent", "<init>", "(Lcom/discord/app/AppComponent;Lkotlin/jvm/functions/Function1;Lcom/discord/utilities/recycler/DiffCreator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GifCategoryAdapter extends RecyclerView.Adapter<GifCategoryViewHolder> {
    private final DiffCreator<List<GifCategoryItem>, GifCategoryViewHolder> diffCreator;
    private List<? extends GifCategoryItem> items;
    private final Function1<GifCategoryItem, Unit> onSelectGifCategory;

    /* compiled from: GifCategoryAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "items", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GifCategoryItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GifCategoryItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends GifCategoryItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            GifCategoryAdapter.access$setItems$p(GifCategoryAdapter.this, list);
        }
    }

    public /* synthetic */ GifCategoryAdapter(AppComponent appComponent, Function1 function1, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, function1, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(GifCategoryAdapter gifCategoryAdapter) {
        return gifCategoryAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(GifCategoryAdapter gifCategoryAdapter, List list) {
        gifCategoryAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((GifCategoryViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends GifCategoryItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GifCategoryAdapter(AppComponent appComponent, Function1<? super GifCategoryItem, Unit> function1, DiffCreator<List<GifCategoryItem>, GifCategoryViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.onSelectGifCategory = function1;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(GifCategoryViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.configure(this.items.get(position), this.onSelectGifCategory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GifCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gif_category_item_view, parent, false);
        int i = R.id.gif_category_item_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.gif_category_item_icon);
        if (imageView != null) {
            i = R.id.gif_category_item_preview;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.gif_category_item_preview);
            if (simpleDraweeView != null) {
                i = R.id.gif_category_item_title;
                TextView textView = (TextView) viewInflate.findViewById(R.id.gif_category_item_title);
                if (textView != null) {
                    GifCategoryItemViewBinding gifCategoryItemViewBinding = new GifCategoryItemViewBinding((CardView) viewInflate, imageView, simpleDraweeView, textView);
                    Intrinsics3.checkNotNullExpressionValue(gifCategoryItemViewBinding, "GifCategoryItemViewBindi….context), parent, false)");
                    return new GifCategoryViewHolder(gifCategoryItemViewBinding);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
