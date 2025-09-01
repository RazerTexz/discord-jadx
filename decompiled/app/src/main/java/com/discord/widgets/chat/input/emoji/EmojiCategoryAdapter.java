package com.discord.widgets.chat.input.emoji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ExpressionPickerCategorySelectionOverlineViewBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.EmojiCategoryItemGuildBinding;
import com.discord.databinding.EmojiCategoryItemStandardBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiCategoryViewHolder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmojiCategoryAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BS\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0!\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0!\u0012\u0006\u0010&\u001a\u00020%\u0012\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0018\u0012\u0004\u0012\u00020\u00020\u001c¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0004\b\u001a\u0010\u001bR(\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0018\u0012\u0004\u0012\u00020\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#¨\u0006)"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder;", "getItemCount", "()I", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/chat/input/emoji/EmojiCategoryViewHolder;I)V", "", "getItemId", "(I)J", "getItemViewType", "(I)I", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;", "getItemAtPosition", "(I)Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;", "", "newItems", "setItems", "(Ljava/util/List;)V", "Lcom/discord/utilities/recycler/DiffCreator;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "items", "Ljava/util/List;", "Lkotlin/Function1;", "onCategoryClicked", "Lkotlin/jvm/functions/Function1;", "onSelectedItemAdapterPositionUpdated", "Lcom/discord/app/AppComponent;", "appComponent", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/discord/app/AppComponent;Lcom/discord/utilities/recycler/DiffCreator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiCategoryAdapter extends RecyclerView.Adapter<EmojiCategoryViewHolder> {
    private final DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator;
    private List<? extends EmojiCategoryItem> items;
    private final Function1<EmojiCategoryItem, Unit> onCategoryClicked;
    private final Function1<Integer, Unit> onSelectedItemAdapterPositionUpdated;

    /* compiled from: EmojiCategoryAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem;", "items", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.emoji.EmojiCategoryAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends EmojiCategoryItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends EmojiCategoryItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends EmojiCategoryItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            EmojiCategoryAdapter.access$setItems$p(EmojiCategoryAdapter.this, list);
            Iterator<? extends EmojiCategoryItem> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (it.next().getIsSelected()) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                EmojiCategoryAdapter.access$getOnSelectedItemAdapterPositionUpdated$p(EmojiCategoryAdapter.this).invoke(Integer.valueOf(i));
            }
        }
    }

    public /* synthetic */ EmojiCategoryAdapter(Function1 function1, Function1 function12, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, appComponent, (i & 8) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(EmojiCategoryAdapter emojiCategoryAdapter) {
        return emojiCategoryAdapter.items;
    }

    public static final /* synthetic */ Function1 access$getOnSelectedItemAdapterPositionUpdated$p(EmojiCategoryAdapter emojiCategoryAdapter) {
        return emojiCategoryAdapter.onSelectedItemAdapterPositionUpdated;
    }

    public static final /* synthetic */ void access$setItems$p(EmojiCategoryAdapter emojiCategoryAdapter, List list) {
        emojiCategoryAdapter.items = list;
    }

    public final EmojiCategoryItem getItemAtPosition(int position) {
        return this.items.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.items.get(position).getStableId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        EmojiCategoryItem emojiCategoryItem = this.items.get(position);
        if (emojiCategoryItem instanceof EmojiCategoryItem.StandardItem) {
            return 0;
        }
        if (emojiCategoryItem instanceof EmojiCategoryItem.GuildItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((EmojiCategoryViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends EmojiCategoryItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiCategoryAdapter(Function1<? super EmojiCategoryItem, Unit> function1, Function1<? super Integer, Unit> function12, AppComponent appComponent, DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(function1, "onCategoryClicked");
        Intrinsics3.checkNotNullParameter(function12, "onSelectedItemAdapterPositionUpdated");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.onCategoryClicked = function1;
        this.onSelectedItemAdapterPositionUpdated = function12;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(EmojiCategoryViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (holder instanceof EmojiCategoryViewHolder.Standard) {
            EmojiCategoryItem emojiCategoryItem = this.items.get(position);
            Objects.requireNonNull(emojiCategoryItem, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiCategoryItem.StandardItem");
            ((EmojiCategoryViewHolder.Standard) holder).configure((EmojiCategoryItem.StandardItem) emojiCategoryItem, this.onCategoryClicked);
        } else if (holder instanceof EmojiCategoryViewHolder.Guild) {
            EmojiCategoryItem emojiCategoryItem2 = this.items.get(position);
            Objects.requireNonNull(emojiCategoryItem2, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiCategoryItem.GuildItem");
            ((EmojiCategoryViewHolder.Guild) holder).configure((EmojiCategoryItem.GuildItem) emojiCategoryItem2, this.onCategoryClicked);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmojiCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int i = R.id.overline;
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.emoji_category_item_standard, parent, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.emoji_category_item_standard_icon);
            if (imageView != null) {
                View viewFindViewById = viewInflate.findViewById(R.id.overline);
                if (viewFindViewById != null) {
                    EmojiCategoryItemStandardBinding emojiCategoryItemStandardBinding = new EmojiCategoryItemStandardBinding((FrameLayout) viewInflate, imageView, new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById, viewFindViewById));
                    Intrinsics3.checkNotNullExpressionValue(emojiCategoryItemStandardBinding, "EmojiCategoryItemStandar…(inflater, parent, false)");
                    return new EmojiCategoryViewHolder.Standard(emojiCategoryItemStandardBinding);
                }
            } else {
                i = R.id.emoji_category_item_standard_icon;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 1) {
            StringBuilder sbV = outline.V("invalid viewType ", viewType, " for ");
            sbV.append(EmojiCategoryAdapter.class.getSimpleName());
            throw new IllegalArgumentException(sbV.toString());
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.emoji_category_item_guild, parent, false);
        GuildIcon guildIcon = (GuildIcon) viewInflate2.findViewById(R.id.emoji_category_item_guild_icon);
        if (guildIcon != null) {
            View viewFindViewById2 = viewInflate2.findViewById(R.id.overline);
            if (viewFindViewById2 != null) {
                EmojiCategoryItemGuildBinding emojiCategoryItemGuildBinding = new EmojiCategoryItemGuildBinding((FrameLayout) viewInflate2, guildIcon, new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById2, viewFindViewById2));
                Intrinsics3.checkNotNullExpressionValue(emojiCategoryItemGuildBinding, "EmojiCategoryItemGuildBi…(inflater, parent, false)");
                return new EmojiCategoryViewHolder.Guild(emojiCategoryItemGuildBinding);
            }
        } else {
            i = R.id.emoji_category_item_guild_icon;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
