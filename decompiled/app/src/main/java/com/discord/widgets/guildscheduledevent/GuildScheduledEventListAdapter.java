package com.discord.widgets.guildscheduledevent;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.GuildScheduledEventListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dBs\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R%\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R%\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R%\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function1;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "", "onRsvpClicked", "Lkotlin/jvm/functions/Function1;", "getOnRsvpClicked", "()Lkotlin/jvm/functions/Function1;", "onEventStartClicked", "getOnEventStartClicked", "onShareClicked", "getOnShareClicked", "onCardClicked", "getOnCardClicked", "onJoinClicked", "getOnJoinClicked", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "EventViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventListAdapter extends MGRecyclerAdapterSimple<GuildScheduledEventListItem> {
    private final Function1<GuildScheduledEventListItem.Event, Unit> onCardClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onEventStartClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onJoinClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onRsvpClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onShareClicked;

    /* compiled from: GuildScheduledEventListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListAdapter$EventViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListAdapter;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem;)V", "Lcom/discord/databinding/GuildScheduledEventListItemBinding;", "binding", "Lcom/discord/databinding/GuildScheduledEventListItemBinding;", "getBinding", "()Lcom/discord/databinding/GuildScheduledEventListItemBinding;", "<init>", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class EventViewHolder extends MGRecyclerViewHolder<GuildScheduledEventListAdapter, GuildScheduledEventListItem> {
        private final GuildScheduledEventListItemBinding binding;

        public EventViewHolder() {
            super(R.layout.guild_scheduled_event_list_item, GuildScheduledEventListAdapter.this);
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view;
            GuildScheduledEventListItemBinding guildScheduledEventListItemBinding = new GuildScheduledEventListItemBinding(guildScheduledEventItemView, guildScheduledEventItemView);
            Intrinsics3.checkNotNullExpressionValue(guildScheduledEventListItemBinding, "GuildScheduledEventListItemBinding.bind(itemView)");
            this.binding = guildScheduledEventListItemBinding;
        }

        public static final /* synthetic */ GuildScheduledEventListAdapter access$getAdapter$p(EventViewHolder eventViewHolder) {
            return (GuildScheduledEventListAdapter) eventViewHolder.adapter;
        }

        public final GuildScheduledEventListItemBinding getBinding() {
            return this.binding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, GuildScheduledEventListItem guildScheduledEventListItem) throws Resources.NotFoundException {
            onConfigure2(i, guildScheduledEventListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, GuildScheduledEventListItem data) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            GuildScheduledEventListItem.Event event = (GuildScheduledEventListItem.Event) data;
            this.binding.f2121b.configureInEventList(event, new GuildScheduledEventListAdapter2(this, event), new GuildScheduledEventListAdapter3(this, event), new GuildScheduledEventListAdapter4(this, event), new GuildScheduledEventListAdapter5(this, event), new GuildScheduledEventListAdapter6(this, event));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildScheduledEventListAdapter(RecyclerView recyclerView, Function1<? super GuildScheduledEventListItem.Event, Unit> function1, Function1<? super GuildScheduledEventListItem.Event, Unit> function12, Function1<? super GuildScheduledEventListItem.Event, Unit> function13, Function1<? super GuildScheduledEventListItem.Event, Unit> function14, Function1<? super GuildScheduledEventListItem.Event, Unit> function15) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(function1, "onRsvpClicked");
        Intrinsics3.checkNotNullParameter(function12, "onEventStartClicked");
        Intrinsics3.checkNotNullParameter(function13, "onCardClicked");
        Intrinsics3.checkNotNullParameter(function14, "onJoinClicked");
        Intrinsics3.checkNotNullParameter(function15, "onShareClicked");
        this.onRsvpClicked = function1;
        this.onEventStartClicked = function12;
        this.onCardClicked = function13;
        this.onJoinClicked = function14;
        this.onShareClicked = function15;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnCardClicked() {
        return this.onCardClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnEventStartClicked() {
        return this.onEventStartClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnJoinClicked() {
        return this.onJoinClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnRsvpClicked() {
        return this.onRsvpClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnShareClicked() {
        return this.onShareClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, GuildScheduledEventListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new EventViewHolder();
        }
        throw invalidViewTypeException(viewType);
    }
}
