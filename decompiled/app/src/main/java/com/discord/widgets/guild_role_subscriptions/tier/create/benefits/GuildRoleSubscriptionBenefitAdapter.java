package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.databinding.ViewGuildRoleSubscriptionAddBenefitItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionFreeTrialItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u000389:B3\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00105\u001a\u000204\u0012\u001a\b\u0002\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u000201¢\u0006\u0004\b6\u00107J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0019\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010'R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010)R(\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u0006;"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitViewHolder;", "Lcom/discord/utilities/views/StickyHeaderItemDecoration$StickyHeaderAdapter;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitViewHolder;I)V", "getItemViewType", "(I)I", "getItemCount", "()I", "", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "newItems", "setItems", "(Ljava/util/List;)V", "clearItems", "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "itemPosition", "getHeaderPositionForItem", "(I)Ljava/lang/Integer;", "", "isHeader", "(I)Z", "Landroid/view/View;", "getAndBindHeaderView", "(I)Landroid/view/View;", "headerIndices", "Ljava/util/List;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager;", "stickyHeaderManager", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter$Listener;", "listener", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter$Listener;", "items", "Lcom/discord/utilities/recycler/DiffCreator;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "Lcom/discord/app/AppComponent;", "appComponent", "<init>", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter$Listener;Lcom/discord/app/AppComponent;Lcom/discord/utilities/recycler/DiffCreator;)V", "Companion", "Listener", "StickyHeadersManager", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitAdapter extends RecyclerView.Adapter<GuildRoleSubscriptionBenefitViewHolder> implements StickyHeaderItemDecoration.StickyHeaderAdapter {
    private static final int VIEW_TYPE_ADD_ITEM = 3;
    private static final int VIEW_TYPE_BENEFIT = 0;
    private static final int VIEW_TYPE_HEADER = 2;
    private static final int VIEW_TYPE_TRIALS = 4;
    private final DiffCreator<List<GuildRoleSubscriptionBenefitAdapterItem>, GuildRoleSubscriptionBenefitViewHolder> diffCreator;
    private List<Integer> headerIndices;
    private List<? extends GuildRoleSubscriptionBenefitAdapterItem> items;
    private final Listener listener;
    private StickyHeadersManager stickyHeaderManager;

    /* compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter$Listener;", "", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "benefitAdapterItem", "", "onBenefitItemClick", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem;", "onAddBenefitItemClick", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem;)V", "", "isEnabled", "onFreeTrialToggle", "(Z)V", "onActiveTrialUserLimitClick", "()V", "onTrialIntervalClick", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onActiveTrialUserLimitClick();

        void onAddBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem benefitAdapterItem);

        void onBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem);

        void onFreeTrialToggle(boolean isEnabled);

        void onTrialIntervalClick();
    }

    /* compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "layoutViews", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder;", "stickyHeaderHolder", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder;", "getStickyHeaderHolder", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder;", "Landroid/view/View;", "currentStickyHeaderView", "Landroid/view/View;", "getCurrentStickyHeaderView", "()Landroid/view/View;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class StickyHeadersManager {
        private final View currentStickyHeaderView;
        private final GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder stickyHeaderHolder;

        public StickyHeadersManager(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBindingA = ViewGuildRoleSubscriptionSectionHeaderItemBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
            Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionSectionHeaderItemBindingA, "ViewGuildRoleSubscriptio…          false\n        )");
            GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder headerViewHolder = new GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder(viewGuildRoleSubscriptionSectionHeaderItemBindingA);
            this.stickyHeaderHolder = headerViewHolder;
            View view = headerViewHolder.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "stickyHeaderHolder.itemView");
            this.currentStickyHeaderView = view;
        }

        public final View getCurrentStickyHeaderView() {
            return this.currentStickyHeaderView;
        }

        public final GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder getStickyHeaderHolder() {
            return this.stickyHeaderHolder;
        }

        public final void layoutViews(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, this.currentStickyHeaderView);
        }
    }

    /* compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "itemsToDispatch", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GuildRoleSubscriptionBenefitAdapterItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildRoleSubscriptionBenefitAdapterItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends GuildRoleSubscriptionBenefitAdapterItem> list) {
            Intrinsics3.checkNotNullParameter(list, "itemsToDispatch");
            GuildRoleSubscriptionBenefitAdapter.access$setItems$p(GuildRoleSubscriptionBenefitAdapter.this, list);
        }
    }

    public /* synthetic */ GuildRoleSubscriptionBenefitAdapter(Listener listener, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(listener, appComponent, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter) {
        return guildRoleSubscriptionBenefitAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter, List list) {
        guildRoleSubscriptionBenefitAdapter.items = list;
    }

    public final void clearItems() {
        setItems(Collections2.emptyList());
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder stickyHeaderHolder;
        GuildRoleSubscriptionBenefitAdapterItem guildRoleSubscriptionBenefitAdapterItem = this.items.get(position);
        StickyHeadersManager stickyHeadersManager = this.stickyHeaderManager;
        if (stickyHeadersManager != null && (stickyHeaderHolder = stickyHeadersManager.getStickyHeaderHolder()) != null) {
            Objects.requireNonNull(guildRoleSubscriptionBenefitAdapterItem, "null cannot be cast to non-null type com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem.Header");
            stickyHeaderHolder.configure((GuildRoleSubscriptionBenefitAdapterItem.Header) guildRoleSubscriptionBenefitAdapterItem);
        }
        StickyHeadersManager stickyHeadersManager2 = this.stickyHeaderManager;
        if (stickyHeadersManager2 != null) {
            return stickyHeadersManager2.getCurrentStickyHeaderView();
        }
        return null;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        Integer numPrevious;
        List<Integer> list = this.headerIndices;
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                numPrevious = null;
                break;
            }
            numPrevious = listIterator.previous();
            if (itemPosition >= numPrevious.intValue()) {
                break;
            }
        }
        Integer num = numPrevious;
        if (num == null) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("failed to find header position for item in ");
            sbU.append(GuildRoleSubscriptionBenefitAdapter.class.getName());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
        }
        return num;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        GuildRoleSubscriptionBenefitAdapterItem guildRoleSubscriptionBenefitAdapterItem = this.items.get(position);
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem) {
            return 3;
        }
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) {
            return 0;
        }
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.Header) {
            return 2;
        }
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        return this.items.get(position) instanceof GuildRoleSubscriptionBenefitAdapterItem.Header;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        StickyHeadersManager stickyHeadersManager = new StickyHeadersManager(recyclerView);
        recyclerView.addOnLayoutChangeListener(new GuildRoleSubscriptionBenefitAdapter2(stickyHeadersManager, recyclerView));
        this.stickyHeaderManager = stickyHeadersManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((GuildRoleSubscriptionBenefitViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.stickyHeaderManager = null;
    }

    public final void setItems(List<? extends GuildRoleSubscriptionBenefitAdapterItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdates(this, new AnonymousClass1(), this.items, newItems);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : newItems) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            Integer numValueOf = ((GuildRoleSubscriptionBenefitAdapterItem) obj) instanceof GuildRoleSubscriptionBenefitAdapterItem.Header ? Integer.valueOf(i) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
            i = i2;
        }
        this.headerIndices = arrayList;
    }

    public GuildRoleSubscriptionBenefitAdapter(Listener listener, AppComponent appComponent, DiffCreator<List<GuildRoleSubscriptionBenefitAdapterItem>, GuildRoleSubscriptionBenefitViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.listener = listener;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
        this.headerIndices = Collections2.emptyList();
    }

    public void onBindViewHolder(GuildRoleSubscriptionBenefitViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.configure(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GuildRoleSubscriptionBenefitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            Context context = parent.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "parent.context");
            return new GuildRoleSubscriptionBenefitViewHolder.ItemViewHolder(new GuildRoleSubscriptionBenefitItemView(context), this.listener);
        }
        if (viewType == 2) {
            ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBindingA = ViewGuildRoleSubscriptionSectionHeaderItemBinding.a(layoutInflaterFrom, parent, false);
            Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionSectionHeaderItemBindingA, "ViewGuildRoleSubscriptio…(inflater, parent, false)");
            return new GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder(viewGuildRoleSubscriptionSectionHeaderItemBindingA);
        }
        if (viewType == 3) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.view_guild_role_subscription_add_benefit_item, parent, false);
            int i = R.id.guild_role_subscription_add_benefit_image_circle;
            View viewFindViewById = viewInflate.findViewById(R.id.guild_role_subscription_add_benefit_image_circle);
            if (viewFindViewById != null) {
                i = R.id.guild_role_subscription_add_benefit_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_add_benefit_text);
                if (textView != null) {
                    ViewGuildRoleSubscriptionAddBenefitItemBinding viewGuildRoleSubscriptionAddBenefitItemBinding = new ViewGuildRoleSubscriptionAddBenefitItemBinding((ConstraintLayout) viewInflate, viewFindViewById, textView);
                    Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionAddBenefitItemBinding, "ViewGuildRoleSubscriptio…(inflater, parent, false)");
                    return new GuildRoleSubscriptionBenefitViewHolder.AddItemViewHolder(viewGuildRoleSubscriptionAddBenefitItemBinding, this.listener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 4) {
            Context context2 = parent.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "parent.context");
            throw new IllegalArgumentException(FormatUtils.h(context2, R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, null, 4).toString());
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.view_guild_role_subscription_free_trial_item, parent, false);
        int i2 = R.id.guild_role_subscription_active_user_limit_description;
        TextView textView2 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_active_user_limit_description);
        if (textView2 != null) {
            i2 = R.id.guild_role_subscription_active_user_limit_dropdown;
            TextView textView3 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_active_user_limit_dropdown);
            if (textView3 != null) {
                i2 = R.id.guild_role_subscription_active_user_limit_title;
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_active_user_limit_title);
                if (textView4 != null) {
                    i2 = R.id.guild_role_subscription_free_trial_enable_toggle;
                    CheckedSetting checkedSetting = (CheckedSetting) viewInflate2.findViewById(R.id.guild_role_subscription_free_trial_enable_toggle);
                    if (checkedSetting != null) {
                        i2 = R.id.guild_role_subscription_free_trial_subtitle;
                        TextView textView5 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_free_trial_subtitle);
                        if (textView5 != null) {
                            i2 = R.id.guild_role_subscription_time_limit_description;
                            TextView textView6 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_time_limit_description);
                            if (textView6 != null) {
                                i2 = R.id.guild_role_subscription_time_limit_dropdown;
                                TextView textView7 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_time_limit_dropdown);
                                if (textView7 != null) {
                                    i2 = R.id.guild_role_subscription_time_limit_title;
                                    TextView textView8 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_time_limit_title);
                                    if (textView8 != null) {
                                        ViewGuildRoleSubscriptionFreeTrialItemBinding viewGuildRoleSubscriptionFreeTrialItemBinding = new ViewGuildRoleSubscriptionFreeTrialItemBinding((LinearLayout) viewInflate2, textView2, textView3, textView4, checkedSetting, textView5, textView6, textView7, textView8);
                                        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionFreeTrialItemBinding, "ViewGuildRoleSubscriptio…(inflater, parent, false)");
                                        return new GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder(viewGuildRoleSubscriptionFreeTrialItemBinding, this.listener);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
    }
}
