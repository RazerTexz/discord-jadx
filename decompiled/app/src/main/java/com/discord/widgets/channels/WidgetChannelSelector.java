package com.discord.widgets.channels;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelSelectorBinding;
import com.discord.databinding.WidgetChannelSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetChannelSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 %2\u00020\u0001:\t&'%()*+,-B\u0007¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006."}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/api/channel/Channel;", "channel", "", "onChannelSelected", "(Lcom/discord/api/channel/Channel;)V", "", "getContentViewResId", "()I", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/widgets/channels/WidgetChannelSelector$Adapter;", "adapter", "Lcom/discord/widgets/channels/WidgetChannelSelector$Adapter;", "Lcom/discord/databinding/WidgetChannelSelectorBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelSelectorBinding;", "binding", "", "requestCode$delegate", "Lkotlin/Lazy;", "getRequestCode", "()Ljava/lang/String;", "requestCode", "<init>", "()V", "Companion", "Adapter", "BaseFilterFunction", "FilterFunction", "InactiveStageChannelFilterFunction", ExifInterface.TAG_MODEL, "SetFilterFunction", "TypeFilterFunction", "VocalChannelFilterFunction", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelSelector extends AppBottomSheet {
    private static final String ARG_FILTER_FUNCTION = "INTENT_EXTRA_FILTER_FUNCTION";
    private static final String ARG_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String ARG_INCLUDE_NO_CHANNEL = "INTENT_EXTRA_INCLUDE_NO_CHANNEL";
    private static final String ARG_NO_CHANNEL_STRING_ID = "INTENT_EXTRA_NO_CHANNEL_STRING_ID";
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String RESULT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String RESULT_EXTRA_CHANNEL_NAME = "INTENT_EXTRA_CHANNEL_NAME";
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: requestCode$delegate, reason: from kotlin metadata */
    private final Lazy requestCode;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSelectorBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/channels/WidgetChannelSelector$Model$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/channels/WidgetChannelSelector$Adapter$ItemChannel;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/channels/WidgetChannelSelector$Adapter$ItemChannel;", "Lcom/discord/widgets/channels/WidgetChannelSelector;", "dialog", "Lcom/discord/widgets/channels/WidgetChannelSelector;", "noChannelStringId", "I", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/discord/widgets/channels/WidgetChannelSelector;I)V", "ItemChannel", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.Item> {
        private final WidgetChannelSelector dialog;
        private final int noChannelStringId;

        /* compiled from: WidgetChannelSelector.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$Adapter$ItemChannel;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/WidgetChannelSelector$Adapter;", "Lcom/discord/widgets/channels/WidgetChannelSelector$Model$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/WidgetChannelSelector$Model$Item;)V", "Lcom/discord/databinding/WidgetChannelSelectorItemBinding;", "binding", "Lcom/discord/databinding/WidgetChannelSelectorItemBinding;", "noChannelStringId", "I", "getNoChannelStringId", "()I", "layout", "adapter", "<init>", "(ILcom/discord/widgets/channels/WidgetChannelSelector$Adapter;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ItemChannel extends MGRecyclerViewHolder<Adapter, Model.Item> {
            private final WidgetChannelSelectorItemBinding binding;
            private final int noChannelStringId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemChannel(@LayoutRes int i, Adapter adapter, int i2) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                this.noChannelStringId = i2;
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                TextView textView = (TextView) view;
                WidgetChannelSelectorItemBinding widgetChannelSelectorItemBinding = new WidgetChannelSelectorItemBinding(textView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelSelectorItemBinding, "WidgetChannelSelectorItemBinding.bind(itemView)");
                this.binding = widgetChannelSelectorItemBinding;
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(ItemChannel itemChannel) {
                return (Adapter) itemChannel.adapter;
            }

            public final int getNoChannelStringId() {
                return this.noChannelStringId;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Model.Item item) {
                onConfigure2(i, item);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Model.Item data) {
                CharSequence charSequenceJ;
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                this.binding.a.setOnClickListener(new WidgetChannelSelector2(this, data));
                TextView textView = this.binding.f2268b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemName");
                Channel channel = data.getChannel();
                if (channel != null) {
                    charSequenceJ = ChannelUtils.c(channel);
                } else {
                    TextView textView2 = this.binding.f2268b;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemName");
                    charSequenceJ = FormatUtils.j(textView2, this.noChannelStringId, new Object[0], null, 4);
                }
                textView.setText(charSequenceJ);
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Channel channel2 = data.getChannel();
                Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
                int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, (numValueOf != null && numValueOf.intValue() == 2) ? R.attr.ic_volume_up : (numValueOf != null && numValueOf.intValue() == 13) ? R.attr.ic_channel_stage : (numValueOf != null && numValueOf.intValue() == 0) ? R.attr.ic_channel_text : 0, 0, 2, (Object) null);
                TextView textView3 = this.binding.f2268b;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemName");
                DrawableCompat.setCompoundDrawablesCompat$default(textView3, themedDrawableRes$default, 0, 0, 0, 14, (Object) null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, WidgetChannelSelector widgetChannelSelector, int i) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            Intrinsics3.checkNotNullParameter(widgetChannelSelector, "dialog");
            this.dialog = widgetChannelSelector;
            this.noChannelStringId = i;
        }

        public static final /* synthetic */ WidgetChannelSelector access$getDialog$p(Adapter adapter) {
            return adapter.dialog;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ItemChannel onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new ItemChannel(R.layout.widget_channel_selector_item, this, this.noChannelStringId);
        }
    }

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$BaseFilterFunction;", "Lcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class BaseFilterFunction implements FilterFunction {
        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return FilterFunction.DefaultImpls.includeChannel(this, channel);
        }
    }

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&JE\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001c\u0010\f\u001a\u0018\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0010\u001a\u00060\tj\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0010\u001a\u00060\tj\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J=\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0010\u001a\u00060\tj\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0015J=\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0010\u001a\u00060\tj\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0015JI\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0010\u001a\u00060\tj\u0002`\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u001e¨\u0006'"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "requestKey", "", "allowNullChannel", "Lkotlin/Function2;", "", "Lcom/discord/primitives/ChannelId;", "", "onChannelSelected", "registerForResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)V", "Lcom/discord/primitives/GuildId;", "guildId", "includeNoChannel", "", "noChannelStringId", "launchForVocal", "(Landroidx/fragment/app/Fragment;JLjava/lang/String;ZI)V", "launchForInactiveStages", "launchForVoice", "launchForText", "Lcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;", "filterFunction", "launch", "(Landroidx/fragment/app/Fragment;JLjava/lang/String;ZILcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;)V", "ARG_FILTER_FUNCTION", "Ljava/lang/String;", "ARG_GUILD_ID", "ARG_INCLUDE_NO_CHANNEL", "ARG_NO_CHANNEL_STRING_ID", "ARG_REQUEST_KEY", "RESULT_EXTRA_CHANNEL_ID", "RESULT_EXTRA_CHANNEL_NAME", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Fragment fragment, long j, String str, boolean z2, int i, FilterFunction filterFunction, int i2, Object obj) {
            companion.launch(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? R.string.none : i, (i2 & 32) != 0 ? null : filterFunction);
        }

        public static /* synthetic */ void launchForInactiveStages$default(Companion companion, Fragment fragment, long j, String str, boolean z2, int i, int i2, Object obj) {
            companion.launchForInactiveStages(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? R.string.none : i);
        }

        public static /* synthetic */ void launchForText$default(Companion companion, Fragment fragment, long j, String str, boolean z2, int i, int i2, Object obj) {
            companion.launchForText(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? R.string.none : i);
        }

        public static /* synthetic */ void launchForVocal$default(Companion companion, Fragment fragment, long j, String str, boolean z2, int i, int i2, Object obj) {
            companion.launchForVocal(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? R.string.none : i);
        }

        public static /* synthetic */ void launchForVoice$default(Companion companion, Fragment fragment, long j, String str, boolean z2, int i, int i2, Object obj) {
            companion.launchForVoice(fragment, j, str, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? R.string.none : i);
        }

        public static /* synthetic */ void registerForResult$default(Companion companion, Fragment fragment, String str, boolean z2, Function2 function2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.registerForResult(fragment, str, z2, function2);
        }

        public final void launch(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId, FilterFunction filterFunction) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetChannelSelector widgetChannelSelector = new WidgetChannelSelector();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetChannelSelector.ARG_REQUEST_KEY, requestKey);
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            bundle.putBoolean(WidgetChannelSelector.ARG_INCLUDE_NO_CHANNEL, includeNoChannel);
            bundle.putInt(WidgetChannelSelector.ARG_NO_CHANNEL_STRING_ID, noChannelStringId);
            bundle.putSerializable(WidgetChannelSelector.ARG_FILTER_FUNCTION, filterFunction);
            widgetChannelSelector.setArguments(bundle);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetChannelSelector.show(parentFragmentManager, WidgetChannelSelector.class.getName());
        }

        public final void launchForInactiveStages(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, InactiveStageChannelFilterFunction.INSTANCE);
        }

        public final void launchForText(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, new TypeFilterFunction(0));
        }

        public final void launchForVocal(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, VocalChannelFilterFunction.INSTANCE);
        }

        public final void launchForVoice(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, new TypeFilterFunction(2));
        }

        public final void registerForResult(Fragment fragment, String requestKey, boolean allowNullChannel, Function2<? super Long, ? super String, Unit> onChannelSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onChannelSelected, "onChannelSelected");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetChannelSelector3(requestKey, allowNullChannel, onChannelSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;", "Ljava/io/Serializable;", "Lcom/discord/api/channel/Channel;", "channel", "", "includeChannel", "(Lcom/discord/api/channel/Channel;)Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface FilterFunction extends Serializable {

        /* compiled from: WidgetChannelSelector.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static boolean includeChannel(FilterFunction filterFunction, Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return true;
            }
        }

        boolean includeChannel(Channel channel);
    }

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$InactiveStageChannelFilterFunction;", "Lcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;", "Lcom/discord/api/channel/Channel;", "channel", "", "includeChannel", "(Lcom/discord/api/channel/Channel;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class InactiveStageChannelFilterFunction implements FilterFunction {
        public static final InactiveStageChannelFilterFunction INSTANCE = new InactiveStageChannelFilterFunction();

        private InactiveStageChannelFilterFunction() {
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return ChannelUtils.D(channel) && StoreStream.INSTANCE.getStageInstances().getStageInstanceForChannel(channel.getId()) == null;
        }
    }

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$Model;", "", "<init>", "()V", "Companion", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: WidgetChannelSelector.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$Model$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "includeNoChannel", "Lcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;", "filterFunction", "Lrx/Observable;", "", "Lcom/discord/widgets/channels/WidgetChannelSelector$Model$Item;", "get", "(JZLcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<List<Item>> get(long guildId, boolean includeNoChannel, FilterFunction filterFunction) {
                Intrinsics3.checkNotNullParameter(filterFunction, "filterFunction");
                Observable observableG = StoreChannels.observeChannelsForGuild$default(StoreStream.INSTANCE.getChannels(), guildId, null, 2, null).G(new WidgetChannelSelector4(filterFunction, includeNoChannel));
                Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream.getChannels(… { Item(it) }\n          }");
                Observable<List<Item>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream.getChannels(…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetChannelSelector.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$Model$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()I", "", "component3", "()Ljava/lang/String;", "channel", "type", "key", "copy", "(Lcom/discord/api/channel/Channel;ILjava/lang/String;)Lcom/discord/widgets/channels/WidgetChannelSelector$Model$Item;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "I", "getType", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/api/channel/Channel;ILjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Item implements MGRecyclerDataPayload {
            private final Channel channel;
            private final String key;
            private final int type;

            public Item(Channel channel, int i, String str) {
                Intrinsics3.checkNotNullParameter(str, "key");
                this.channel = channel;
                this.type = i;
                this.key = str;
            }

            public static /* synthetic */ Item copy$default(Item item, Channel channel, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    channel = item.channel;
                }
                if ((i2 & 2) != 0) {
                    i = item.getType();
                }
                if ((i2 & 4) != 0) {
                    str = item.getKey();
                }
                return item.copy(channel, i, str);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final int component2() {
                return getType();
            }

            public final String component3() {
                return getKey();
            }

            public final Item copy(Channel channel, int type, String key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return new Item(channel, type, key);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                return Intrinsics3.areEqual(this.channel, item.channel) && getType() == item.getType() && Intrinsics3.areEqual(getKey(), item.getKey());
            }

            public final Channel getChannel() {
                return this.channel;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int type = (getType() + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
                String key = getKey();
                return type + (key != null ? key.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Item(channel=");
                sbU.append(this.channel);
                sbU.append(", type=");
                sbU.append(getType());
                sbU.append(", key=");
                sbU.append(getKey());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public /* synthetic */ Item(Channel channel, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                i = (i2 & 2) != 0 ? channel != null ? channel.getType() : -1 : i;
                if ((i2 & 4) != 0 && (channel == null || (str = String.valueOf(channel.getId())) == null)) {
                    str = "";
                }
                this(channel, i, str);
            }
        }
    }

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÂ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$SetFilterFunction;", "Lcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()Ljava/util/Set;", "Lcom/discord/api/channel/Channel;", "channel", "", "includeChannel", "(Lcom/discord/api/channel/Channel;)Z", "channelIds", "copy", "(Ljava/util/Set;)Lcom/discord/widgets/channels/WidgetChannelSelector$SetFilterFunction;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "<init>", "(Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SetFilterFunction implements FilterFunction {
        private final Set<Long> channelIds;

        public SetFilterFunction(Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "channelIds");
            this.channelIds = set;
        }

        private final Set<Long> component1() {
            return this.channelIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SetFilterFunction copy$default(SetFilterFunction setFilterFunction, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = setFilterFunction.channelIds;
            }
            return setFilterFunction.copy(set);
        }

        public final SetFilterFunction copy(Set<Long> channelIds) {
            Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
            return new SetFilterFunction(channelIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof SetFilterFunction) && Intrinsics3.areEqual(this.channelIds, ((SetFilterFunction) other).channelIds);
            }
            return true;
        }

        public int hashCode() {
            Set<Long> set = this.channelIds;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return this.channelIds.contains(Long.valueOf(channel.getId()));
        }

        public String toString() {
            return outline.N(outline.U("SetFilterFunction(channelIds="), this.channelIds, ")");
        }
    }

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$TypeFilterFunction;", "Lcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;", "", "component1", "()I", "Lcom/discord/api/channel/Channel;", "channel", "", "includeChannel", "(Lcom/discord/api/channel/Channel;)Z", "type", "copy", "(I)Lcom/discord/widgets/channels/WidgetChannelSelector$TypeFilterFunction;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class TypeFilterFunction implements FilterFunction {
        private final int type;

        public TypeFilterFunction(int i) {
            this.type = i;
        }

        /* renamed from: component1, reason: from getter */
        private final int getType() {
            return this.type;
        }

        public static /* synthetic */ TypeFilterFunction copy$default(TypeFilterFunction typeFilterFunction, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = typeFilterFunction.type;
            }
            return typeFilterFunction.copy(i);
        }

        public final TypeFilterFunction copy(int type) {
            return new TypeFilterFunction(type);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof TypeFilterFunction) && this.type == ((TypeFilterFunction) other).type;
            }
            return true;
        }

        public int hashCode() {
            return this.type;
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return this.type == channel.getType();
        }

        public String toString() {
            return outline.B(outline.U("TypeFilterFunction(type="), this.type, ")");
        }
    }

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSelector$VocalChannelFilterFunction;", "Lcom/discord/widgets/channels/WidgetChannelSelector$FilterFunction;", "Lcom/discord/api/channel/Channel;", "channel", "", "includeChannel", "(Lcom/discord/api/channel/Channel;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class VocalChannelFilterFunction implements FilterFunction {
        public static final VocalChannelFilterFunction INSTANCE = new VocalChannelFilterFunction();

        private VocalChannelFilterFunction() {
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return ChannelUtils.w(channel);
        }
    }

    /* compiled from: WidgetChannelSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/channels/WidgetChannelSelector$Model$Item;", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSelector$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Model.Item>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Model.Item> list) {
            invoke2((List<Model.Item>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Model.Item> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            WidgetChannelSelector.access$getAdapter$p(WidgetChannelSelector.this).setData(list);
        }
    }

    public WidgetChannelSelector() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSelector5.INSTANCE, null, 2, null);
        this.requestCode = LazyJVM.lazy(new WidgetChannelSelector6(this));
    }

    public static final /* synthetic */ Adapter access$getAdapter$p(WidgetChannelSelector widgetChannelSelector) {
        Adapter adapter = widgetChannelSelector.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter;
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetChannelSelector widgetChannelSelector) {
        return widgetChannelSelector.getArgumentsOrDefault();
    }

    public static final /* synthetic */ void access$onChannelSelected(WidgetChannelSelector widgetChannelSelector, Channel channel) {
        widgetChannelSelector.onChannelSelected(channel);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetChannelSelector widgetChannelSelector, Adapter adapter) {
        widgetChannelSelector.adapter = adapter;
    }

    private final WidgetChannelSelectorBinding getBinding() {
        return (WidgetChannelSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getRequestCode() {
        return (String) this.requestCode.getValue();
    }

    private final void onChannelSelected(Channel channel) {
        String requestCode = getRequestCode();
        Bundle bundle = new Bundle();
        bundle.putLong(RESULT_EXTRA_CHANNEL_ID, channel != null ? channel.getId() : -1L);
        bundle.putString(RESULT_EXTRA_CHANNEL_NAME, channel != null ? ChannelUtils.c(channel) : null);
        Fragment2.setFragmentResult(this, requestCode, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        Model.Companion companion = Model.INSTANCE;
        long j = getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L);
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_INCLUDE_NO_CHANNEL, false);
        Serializable serializable = getArgumentsOrDefault().getSerializable(ARG_FILTER_FUNCTION);
        if (!(serializable instanceof FilterFunction)) {
            serializable = null;
        }
        FilterFunction baseFilterFunction = (FilterFunction) serializable;
        if (baseFilterFunction == null) {
            baseFilterFunction = new BaseFilterFunction();
        }
        Observable<List<Model.Item>> observable = companion.get(j, z2, baseFilterFunction);
        Adapter adapter = this.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observable, this, adapter), WidgetChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channel_selector;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2267b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.channelSelectorList");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView, this, getArgumentsOrDefault().getInt(ARG_NO_CHANNEL_STRING_ID)));
    }
}
