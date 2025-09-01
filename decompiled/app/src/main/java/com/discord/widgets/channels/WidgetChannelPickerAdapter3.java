package com.discord.widgets.channels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.channels.WidgetChannelPickerAdapter;
import com.discord.widgets.channels.WidgetChannelPickerAdapter2;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChannelPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B3\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020\u001a¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/discord/widgets/channels/WidgetchannelPickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/channels/ChannelPickerViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/channels/ChannelPickerViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/channels/ChannelPickerViewHolder;I)V", "getItemViewType", "(I)I", "getItemCount", "()I", "", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem;", "newItems", "setItems", "(Ljava/util/List;)V", "Lcom/discord/widgets/channels/WidgetchannelPickerAdapter$OnItemClickListener;", "listener", "Lcom/discord/widgets/channels/WidgetchannelPickerAdapter$OnItemClickListener;", "Lcom/discord/utilities/recycler/DiffCreator;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "items", "Ljava/util/List;", "Lcom/discord/app/AppComponent;", "appComponent", "<init>", "(Lcom/discord/widgets/channels/WidgetchannelPickerAdapter$OnItemClickListener;Lcom/discord/app/AppComponent;Lcom/discord/utilities/recycler/DiffCreator;)V", "Companion", "OnItemClickListener", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelPickerAdapter3 extends RecyclerView.Adapter<WidgetChannelPickerAdapter2> {
    private static final int VIEW_TYPE_CHANNEL_ITEM = 1;
    private static final int VIEW_TYPE_CREATE_CHANNEL = 0;
    private final DiffCreator<List<WidgetChannelPickerAdapter>, WidgetChannelPickerAdapter2> diffCreator;
    private List<? extends WidgetChannelPickerAdapter> items;
    private final OnItemClickListener listener;

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/WidgetchannelPickerAdapter$OnItemClickListener;", "", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;", "channelItem", "", "onChannelItemClick", "(Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;)V", "onCreateChannelClick", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$OnItemClickListener */
    public interface OnItemClickListener {
        void onChannelItemClick(WidgetChannelPickerAdapter.ChannelItem channelItem);

        void onCreateChannelClick();
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$onCreateViewHolder$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(OnItemClickListener onItemClickListener) {
            super(0, onItemClickListener, OnItemClickListener.class, "onCreateChannelClick", "onCreateChannelClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((OnItemClickListener) this.receiver).onCreateChannelClick();
        }
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;", "p1", "", "invoke", "(Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$onCreateViewHolder$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetChannelPickerAdapter.ChannelItem, Unit> {
        public AnonymousClass2(OnItemClickListener onItemClickListener) {
            super(1, onItemClickListener, OnItemClickListener.class, "onChannelItemClick", "onChannelItemClick(Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelPickerAdapter.ChannelItem channelItem) {
            invoke2(channelItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelPickerAdapter.ChannelItem channelItem) {
            Intrinsics3.checkNotNullParameter(channelItem, "p1");
            ((OnItemClickListener) this.receiver).onChannelItemClick(channelItem);
        }
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem;", "items", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetchannelPickerAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends WidgetChannelPickerAdapter>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetChannelPickerAdapter> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends WidgetChannelPickerAdapter> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            WidgetChannelPickerAdapter3.access$setItems$p(WidgetChannelPickerAdapter3.this, list);
        }
    }

    public /* synthetic */ WidgetChannelPickerAdapter3(OnItemClickListener onItemClickListener, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(onItemClickListener, appComponent, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(WidgetChannelPickerAdapter3 widgetChannelPickerAdapter3) {
        return widgetChannelPickerAdapter3.items;
    }

    public static final /* synthetic */ void access$setItems$p(WidgetChannelPickerAdapter3 widgetChannelPickerAdapter3, List list) {
        widgetChannelPickerAdapter3.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        WidgetChannelPickerAdapter widgetChannelPickerAdapter = this.items.get(position);
        if (widgetChannelPickerAdapter instanceof WidgetChannelPickerAdapter.CreateChannelItem) {
            return 0;
        }
        if (widgetChannelPickerAdapter instanceof WidgetChannelPickerAdapter.ChannelItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((WidgetChannelPickerAdapter2) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends WidgetChannelPickerAdapter> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    public WidgetChannelPickerAdapter3(OnItemClickListener onItemClickListener, AppComponent appComponent, DiffCreator<List<WidgetChannelPickerAdapter>, WidgetChannelPickerAdapter2> diffCreator) {
        Intrinsics3.checkNotNullParameter(onItemClickListener, "listener");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.listener = onItemClickListener;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(WidgetChannelPickerAdapter2 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (holder instanceof WidgetChannelPickerAdapter2.ChannelItemViewHolder) {
            ((WidgetChannelPickerAdapter2.ChannelItemViewHolder) holder).configure(this.items.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetChannelPickerAdapter2 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_guild_role_subscription_channel_item, parent, false);
        int i = R.id.channel_item_name;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channel_item_name);
        if (textView != null) {
            i = R.id.channel_item_selected;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.channel_item_selected);
            if (imageView != null) {
                i = R.id.channel_item_type_icon;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.channel_item_type_icon);
                if (imageView2 != null) {
                    ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding = new ViewGuildRoleSubscriptionChannelItemBinding((LinearLayout) viewInflate, textView, imageView, imageView2);
                    Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionChannelItemBinding, "ViewGuildRoleSubscriptio…rent,\n        false\n    )");
                    if (viewType == 0) {
                        return new WidgetChannelPickerAdapter2.CreateChannelViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new AnonymousClass1(this.listener));
                    }
                    if (viewType == 1) {
                        return new WidgetChannelPickerAdapter2.ChannelItemViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new AnonymousClass2(this.listener));
                    }
                    Context context = parent.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "parent.context");
                    throw new IllegalArgumentException(FormatUtils.h(context, R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, null, 4).toString());
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
