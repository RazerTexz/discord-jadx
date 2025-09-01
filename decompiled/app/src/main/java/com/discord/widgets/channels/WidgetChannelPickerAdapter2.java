package com.discord.widgets.channels;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.widgets.channels.WidgetChannelPickerAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChannelPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/channels/ChannelPickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "ChannelItemViewHolder", "CreateChannelViewHolder", "Lcom/discord/widgets/channels/ChannelPickerViewHolder$CreateChannelViewHolder;", "Lcom/discord/widgets/channels/ChannelPickerViewHolder$ChannelItemViewHolder;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class WidgetChannelPickerAdapter2 extends RecyclerView.ViewHolder {

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/channels/ChannelPickerViewHolder$ChannelItemViewHolder;", "Lcom/discord/widgets/channels/ChannelPickerViewHolder;", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem;", "adapterItem", "", "configure", "(Lcom/discord/widgets/channels/ChannelPickerAdapterItem;)V", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;", "item", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;", "Lcom/discord/databinding/ViewGuildRoleSubscriptionChannelItemBinding;", "binding", "Lcom/discord/databinding/ViewGuildRoleSubscriptionChannelItemBinding;", "Lkotlin/Function1;", "onItemClickListener", "<init>", "(Lcom/discord/databinding/ViewGuildRoleSubscriptionChannelItemBinding;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$ChannelItemViewHolder */
    public static final class ChannelItemViewHolder extends WidgetChannelPickerAdapter2 {
        private final ViewGuildRoleSubscriptionChannelItemBinding binding;
        private WidgetChannelPickerAdapter.ChannelItem item;

        /* compiled from: WidgetChannelPickerAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$ChannelItemViewHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ Function1 $onItemClickListener;

            public AnonymousClass1(Function1 function1) {
                this.$onItemClickListener = function1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelPickerAdapter.ChannelItem channelItemAccess$getItem$p = ChannelItemViewHolder.access$getItem$p(ChannelItemViewHolder.this);
                if (channelItemAccess$getItem$p != null) {
                    this.$onItemClickListener.invoke(channelItemAccess$getItem$p);
                }
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ChannelItemViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, Function1<? super WidgetChannelPickerAdapter.ChannelItem, Unit> function1) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(function1, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionChannelItemBinding;
            this.itemView.setOnClickListener(new AnonymousClass1(function1));
        }

        public static final /* synthetic */ WidgetChannelPickerAdapter.ChannelItem access$getItem$p(ChannelItemViewHolder channelItemViewHolder) {
            return channelItemViewHolder.item;
        }

        public static final /* synthetic */ void access$setItem$p(ChannelItemViewHolder channelItemViewHolder, WidgetChannelPickerAdapter.ChannelItem channelItem) {
            channelItemViewHolder.item = channelItem;
        }

        public final void configure(WidgetChannelPickerAdapter adapterItem) {
            Intrinsics3.checkNotNullParameter(adapterItem, "adapterItem");
            WidgetChannelPickerAdapter.ChannelItem channelItem = (WidgetChannelPickerAdapter.ChannelItem) adapterItem;
            this.item = channelItem;
            if (channelItem != null) {
                TextView textView = this.binding.f2193b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelItemName");
                textView.setText(ChannelUtils.c(channelItem.getChannel()));
                this.binding.d.setImageResource(GuildChannelIconUtils2.guildChannelIcon(channelItem.getChannel()));
                ImageView imageView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
                imageView.setVisibility(channelItem.isSelected() ? 0 : 8);
            }
        }
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/ChannelPickerViewHolder$CreateChannelViewHolder;", "Lcom/discord/widgets/channels/ChannelPickerViewHolder;", "Lcom/discord/databinding/ViewGuildRoleSubscriptionChannelItemBinding;", "binding", "Lkotlin/Function0;", "", "onItemClickListener", "<init>", "(Lcom/discord/databinding/ViewGuildRoleSubscriptionChannelItemBinding;Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    @SuppressLint({"SetTextI18n"})
    /* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$CreateChannelViewHolder */
    public static final class CreateChannelViewHolder extends WidgetChannelPickerAdapter2 {

        /* compiled from: WidgetChannelPickerAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$CreateChannelViewHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ Function0 $onItemClickListener;

            public AnonymousClass1(Function0 function0) {
                this.$onItemClickListener = function0;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.$onItemClickListener.invoke();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public CreateChannelViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(function0, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            Drawable drawable = null;
            super(linearLayout, null);
            viewGuildRoleSubscriptionChannelItemBinding.f2193b.setText(R.string.guild_role_subscription_tier_benefits_create_a_channel_label);
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            int themedColor = ColorCompat.getThemedColor(view, R.attr.colorTextLink);
            viewGuildRoleSubscriptionChannelItemBinding.f2193b.setTextColor(themedColor);
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            Drawable drawable2 = ContextCompat.getDrawable(view2.getContext(), R.drawable.ic_add_24dp);
            if (drawable2 != null) {
                Intrinsics3.checkNotNullExpressionValue(drawable2, "drawable");
                ColorCompat2.setTint(drawable2, themedColor, false);
                drawable = drawable2;
            }
            viewGuildRoleSubscriptionChannelItemBinding.d.setImageDrawable(drawable);
            ImageView imageView = viewGuildRoleSubscriptionChannelItemBinding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
            imageView.setVisibility(8);
            this.itemView.setOnClickListener(new AnonymousClass1(function0));
        }
    }

    private WidgetChannelPickerAdapter2(View view) {
        super(view);
    }

    public /* synthetic */ WidgetChannelPickerAdapter2(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
