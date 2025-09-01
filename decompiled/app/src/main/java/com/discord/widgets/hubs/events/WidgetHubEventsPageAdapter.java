package com.discord.widgets.hubs.events;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetHubEventBinding;
import com.discord.databinding.WidgetHubEventsFooterBinding;
import com.discord.databinding.WidgetHubEventsHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.LoadingButton;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.discord.widgets.hubs.events.WidgetHubEventsPageAdapter2;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: WidgetHubEventsPageAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R6\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/hubs/events/WidgetHubEventsPageViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/hubs/events/WidgetHubEventsPageViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/hubs/events/WidgetHubEventsPageViewHolder;I)V", "getItemViewType", "(I)I", "getItemCount", "()I", "Landroid/content/Context;", "context", "Landroid/content/Context;", "", "Lcom/discord/widgets/hubs/events/HubEventsPage;", "value", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "eventListener", "Lcom/discord/widgets/hubs/events/HubEventsEventListener;", "<init>", "(Landroid/content/Context;Lcom/discord/widgets/hubs/events/HubEventsEventListener;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubEventsPageAdapter extends RecyclerView.Adapter<WidgetHubEventsPageViewHolder> {
    private final Context context;
    private final WidgetHubEventsPage3 eventListener;
    private List<? extends WidgetHubEventsPageAdapter2> items;

    public WidgetHubEventsPageAdapter(Context context, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "eventListener");
        this.context = context;
        this.eventListener = widgetHubEventsPage3;
        this.items = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getViewType();
    }

    public final List<WidgetHubEventsPageAdapter2> getItems() {
        return this.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
        onBindViewHolder((WidgetHubEventsPageViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setItems(List<? extends WidgetHubEventsPageAdapter2> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(WidgetHubEventsPageViewHolder holder, int position) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (holder instanceof WidgetHubEventsPageViewHolder5) {
            ((WidgetHubEventsPageViewHolder5) holder).bind();
            return;
        }
        if (holder instanceof WidgetHubEventsPageViewHolder3) {
            WidgetHubEventsPageAdapter2 widgetHubEventsPageAdapter2 = this.items.get(position);
            Objects.requireNonNull(widgetHubEventsPageAdapter2, "null cannot be cast to non-null type com.discord.widgets.hubs.events.HubEventsPage.Footer");
            ((WidgetHubEventsPageViewHolder3) holder).bind((WidgetHubEventsPageAdapter2.Footer) widgetHubEventsPageAdapter2);
        } else if (holder instanceof WidgetHubEventsPageViewHolder2) {
            WidgetHubEventsPageAdapter2 widgetHubEventsPageAdapter22 = this.items.get(position);
            Objects.requireNonNull(widgetHubEventsPageAdapter22, "null cannot be cast to non-null type com.discord.widgets.hubs.events.HubEventsPage.Event");
            ((WidgetHubEventsPageViewHolder2) holder).bind(((WidgetHubEventsPageAdapter2.Event) widgetHubEventsPageAdapter22).getGuildScheduledEventData());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetHubEventsPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.context);
        if (viewType != 0) {
            if (viewType == 1) {
                View viewInflate = layoutInflaterFrom.inflate(R.layout.widget_hub_events_footer, parent, false);
                LoadingButton loadingButton = (LoadingButton) viewInflate.findViewById(R.id.button);
                if (loadingButton == null) {
                    throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.button)));
                }
                WidgetHubEventsFooterBinding widgetHubEventsFooterBinding = new WidgetHubEventsFooterBinding((LinearLayout) viewInflate, loadingButton);
                Intrinsics3.checkNotNullExpressionValue(widgetHubEventsFooterBinding, "WidgetHubEventsFooterBin…(inflater, parent, false)");
                return new WidgetHubEventsPageViewHolder3(widgetHubEventsFooterBinding, this.eventListener);
            }
            if (viewType != 2) {
                throw new IllegalStateException(outline.q("Invalid view type: ", viewType));
            }
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.widget_hub_event, parent, false);
            Objects.requireNonNull(viewInflate2, "rootView");
            GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) viewInflate2;
            WidgetHubEventBinding widgetHubEventBinding = new WidgetHubEventBinding(guildScheduledEventItemView, guildScheduledEventItemView);
            Intrinsics3.checkNotNullExpressionValue(widgetHubEventBinding, "WidgetHubEventBinding.in…(inflater, parent, false)");
            return new WidgetHubEventsPageViewHolder2(widgetHubEventBinding, this.eventListener);
        }
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.widget_hub_events_header, parent, false);
        int i = R.id.close;
        ImageView imageView = (ImageView) viewInflate3.findViewById(R.id.close);
        if (imageView != null) {
            i = R.id.description;
            TextView textView = (TextView) viewInflate3.findViewById(R.id.description);
            if (textView != null) {
                i = R.id.image;
                ImageView imageView2 = (ImageView) viewInflate3.findViewById(R.id.image);
                if (imageView2 != null) {
                    i = R.id.title;
                    TextView textView2 = (TextView) viewInflate3.findViewById(R.id.title);
                    if (textView2 != null) {
                        WidgetHubEventsHeaderBinding widgetHubEventsHeaderBinding = new WidgetHubEventsHeaderBinding((ConstraintLayout) viewInflate3, imageView, textView, imageView2, textView2);
                        Intrinsics3.checkNotNullExpressionValue(widgetHubEventsHeaderBinding, "WidgetHubEventsHeaderBin…(inflater, parent, false)");
                        return new WidgetHubEventsPageViewHolder5(widgetHubEventsHeaderBinding, this.eventListener);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i)));
    }
}
