package com.discord.widgets.chat.input.sticker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ExpressionPickerCategorySelectionOverlineViewBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.StickerCategoryItemGuildBinding;
import com.discord.databinding.StickerCategoryItemPackBinding;
import com.discord.databinding.StickerCategoryItemRecentBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.emoji.GuildIcon;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerCategoryAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bu\u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r0\u001a\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0!\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0010*\u001a\u00020)\u0012\u001a\b\u0002\u0010%\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00020$¢\u0006\u0004\b+\u0010,J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R(\u0010%\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\r0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001c¨\u0006-"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder;", "getItemCount", "()I", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/chat/input/sticker/StickerCategoryViewHolder;I)V", "", "getItemId", "(I)J", "getItemViewType", "(I)I", "", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem;", "newItems", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function1;", "onSelectedItemAdapterPositionUpdated", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$PackItem;", "onPackClicked", "items", "Ljava/util/List;", "Lkotlin/Function0;", "onRecentClicked", "Lkotlin/jvm/functions/Function0;", "Lcom/discord/utilities/recycler/DiffCreator;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem$GuildItem;", "onGuildClicked", "Lcom/discord/app/AppComponent;", "appComponent", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/discord/app/AppComponent;Lcom/discord/utilities/recycler/DiffCreator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StickerCategoryAdapter extends RecyclerView.Adapter<StickerCategoryViewHolder> {
    private final DiffCreator<List<StickerCategoryItem>, StickerCategoryViewHolder> diffCreator;
    private List<? extends StickerCategoryItem> items;
    private final Function1<StickerCategoryItem.GuildItem, Unit> onGuildClicked;
    private final Function1<StickerCategoryItem.PackItem, Unit> onPackClicked;
    private final Function0<Unit> onRecentClicked;
    private final Function1<Integer, Unit> onSelectedItemAdapterPositionUpdated;

    /* compiled from: StickerCategoryAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/chat/input/sticker/StickerCategoryItem;", "items", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerCategoryAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends StickerCategoryItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends StickerCategoryItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends StickerCategoryItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            StickerCategoryAdapter.access$setItems$p(StickerCategoryAdapter.this, list);
            Iterator<? extends StickerCategoryItem> it = list.iterator();
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
                StickerCategoryAdapter.access$getOnSelectedItemAdapterPositionUpdated$p(StickerCategoryAdapter.this).invoke(Integer.valueOf(i));
            }
        }
    }

    public /* synthetic */ StickerCategoryAdapter(Function1 function1, Function1 function12, Function0 function0, Function1 function13, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function0, function13, appComponent, (i & 32) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(StickerCategoryAdapter stickerCategoryAdapter) {
        return stickerCategoryAdapter.items;
    }

    public static final /* synthetic */ Function1 access$getOnSelectedItemAdapterPositionUpdated$p(StickerCategoryAdapter stickerCategoryAdapter) {
        return stickerCategoryAdapter.onSelectedItemAdapterPositionUpdated;
    }

    public static final /* synthetic */ void access$setItems$p(StickerCategoryAdapter stickerCategoryAdapter, List list) {
        stickerCategoryAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem.RecentItem) {
            return -1L;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.PackItem) {
            return ((StickerCategoryItem.PackItem) stickerCategoryItem).getPack().getId();
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.GuildItem) {
            return ((StickerCategoryItem.GuildItem) stickerCategoryItem).getGuild().getId();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem.RecentItem) {
            return 0;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.PackItem) {
            return 1;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.GuildItem) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((StickerCategoryViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends StickerCategoryItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerCategoryAdapter(Function1<? super StickerCategoryItem.GuildItem, Unit> function1, Function1<? super StickerCategoryItem.PackItem, Unit> function12, Function0<Unit> function0, Function1<? super Integer, Unit> function13, AppComponent appComponent, DiffCreator<List<StickerCategoryItem>, StickerCategoryViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(function1, "onGuildClicked");
        Intrinsics3.checkNotNullParameter(function12, "onPackClicked");
        Intrinsics3.checkNotNullParameter(function0, "onRecentClicked");
        Intrinsics3.checkNotNullParameter(function13, "onSelectedItemAdapterPositionUpdated");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.onGuildClicked = function1;
        this.onPackClicked = function12;
        this.onRecentClicked = function0;
        this.onSelectedItemAdapterPositionUpdated = function13;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(StickerCategoryViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem.RecentItem) {
            ((StickerCategoryViewHolder.Recent) holder).configure((StickerCategoryItem.RecentItem) stickerCategoryItem, this.onRecentClicked);
        } else if (stickerCategoryItem instanceof StickerCategoryItem.PackItem) {
            ((StickerCategoryViewHolder.Pack) holder).configure((StickerCategoryItem.PackItem) stickerCategoryItem, this.onPackClicked);
        } else if (stickerCategoryItem instanceof StickerCategoryItem.GuildItem) {
            ((StickerCategoryViewHolder.Guild) holder).configure((StickerCategoryItem.GuildItem) stickerCategoryItem, this.onGuildClicked);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StickerCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int i = R.id.overline;
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.sticker_category_item_recent, parent, false);
            View viewFindViewById = viewInflate.findViewById(R.id.overline);
            if (viewFindViewById == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.overline)));
            }
            StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding = new StickerCategoryItemRecentBinding((FrameLayout) viewInflate, new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById, viewFindViewById));
            Intrinsics3.checkNotNullExpressionValue(stickerCategoryItemRecentBinding, "StickerCategoryItemRecen…(inflater, parent, false)");
            return new StickerCategoryViewHolder.Recent(stickerCategoryItemRecentBinding);
        }
        if (viewType == 1) {
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.sticker_category_item_pack, parent, false);
            View viewFindViewById2 = viewInflate2.findViewById(R.id.overline);
            if (viewFindViewById2 != null) {
                ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding = new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById2, viewFindViewById2);
                StickerView stickerView = (StickerView) viewInflate2.findViewById(R.id.sticker_category_item_pack_avatar);
                if (stickerView != null) {
                    StickerCategoryItemPackBinding stickerCategoryItemPackBinding = new StickerCategoryItemPackBinding((FrameLayout) viewInflate2, expressionPickerCategorySelectionOverlineViewBinding, stickerView);
                    Intrinsics3.checkNotNullExpressionValue(stickerCategoryItemPackBinding, "StickerCategoryItemPackB…(inflater, parent, false)");
                    return new StickerCategoryViewHolder.Pack(stickerCategoryItemPackBinding);
                }
                i = R.id.sticker_category_item_pack_avatar;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
        }
        if (viewType != 2) {
            throw new IllegalStateException(outline.q("Invalid Sticker Category Type: ", viewType));
        }
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.sticker_category_item_guild, parent, false);
        View viewFindViewById3 = viewInflate3.findViewById(R.id.overline);
        if (viewFindViewById3 != null) {
            ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding2 = new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById3, viewFindViewById3);
            GuildIcon guildIcon = (GuildIcon) viewInflate3.findViewById(R.id.sticker_category_item_guild_icon);
            if (guildIcon != null) {
                StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding = new StickerCategoryItemGuildBinding((FrameLayout) viewInflate3, expressionPickerCategorySelectionOverlineViewBinding2, guildIcon);
                Intrinsics3.checkNotNullExpressionValue(stickerCategoryItemGuildBinding, "StickerCategoryItemGuild…(inflater, parent, false)");
                return new StickerCategoryViewHolder.Guild(stickerCategoryItemGuildBinding);
            }
            i = R.id.sticker_category_item_guild_icon;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i)));
    }
}
