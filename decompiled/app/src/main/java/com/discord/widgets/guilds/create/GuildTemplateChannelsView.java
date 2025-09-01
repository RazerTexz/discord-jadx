package com.discord.widgets.guilds.create;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.GuildTemplateChannelsItemViewBinding;
import com.discord.databinding.GuildTemplateChannelsViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: GuildTemplateChannelsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView;", "Landroid/widget/LinearLayout;", "", "Lcom/discord/api/channel/Channel;", "channels", "", "updateView", "(Ljava/util/List;)V", "Lcom/discord/databinding/GuildTemplateChannelsViewBinding;", "binding", "Lcom/discord/databinding/GuildTemplateChannelsViewBinding;", "Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelsAdapter;", "channelsAdapter", "Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelsAdapter;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ChannelDataPayload", "ChannelViewHolder", "ChannelsAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildTemplateChannelsView extends LinearLayout {
    private final GuildTemplateChannelsViewBinding binding;
    private final ChannelsAdapter channelsAdapter;

    /* compiled from: GuildTemplateChannelsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\nR\u001c\u0010\u0016\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelDataPayload;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "channel", "copy", "(Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelDataPayload;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelDataPayload implements MGRecyclerDataPayload {
        private final Channel channel;
        private final String key;
        private final int type;

        public ChannelDataPayload(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.key = String.valueOf(hashCode());
        }

        public static /* synthetic */ ChannelDataPayload copy$default(ChannelDataPayload channelDataPayload, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelDataPayload.channel;
            }
            return channelDataPayload.copy(channel);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final ChannelDataPayload copy(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ChannelDataPayload(channel);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ChannelDataPayload) && Intrinsics3.areEqual(this.channel, ((ChannelDataPayload) other).channel);
            }
            return true;
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
            if (channel != null) {
                return channel.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelDataPayload(channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildTemplateChannelsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelsAdapter;", "Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelDataPayload;)V", "Lcom/discord/databinding/GuildTemplateChannelsItemViewBinding;", "binding", "Lcom/discord/databinding/GuildTemplateChannelsItemViewBinding;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelViewHolder extends MGRecyclerViewHolder<ChannelsAdapter, ChannelDataPayload> {
        private final GuildTemplateChannelsItemViewBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelViewHolder(@LayoutRes int i, ChannelsAdapter channelsAdapter) {
            super(i, channelsAdapter);
            Intrinsics3.checkNotNullParameter(channelsAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.guild_template_channels_item_image;
            ImageView imageView = (ImageView) view.findViewById(R.id.guild_template_channels_item_image);
            if (imageView != null) {
                i2 = R.id.guild_template_channels_item_name;
                TextView textView = (TextView) view.findViewById(R.id.guild_template_channels_item_name);
                if (textView != null) {
                    GuildTemplateChannelsItemViewBinding guildTemplateChannelsItemViewBinding = new GuildTemplateChannelsItemViewBinding((LinearLayout) view, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(guildTemplateChannelsItemViewBinding, "GuildTemplateChannelsIte…iewBinding.bind(itemView)");
                    this.binding = guildTemplateChannelsItemViewBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ChannelDataPayload channelDataPayload) {
            onConfigure2(i, channelDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ChannelDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildTemplateChannelsItemName");
            textView.setText(ChannelUtils.c(data.getChannel()));
            if (ChannelUtils.k(data.getChannel())) {
                this.binding.f2123b.setImageResource(R.drawable.ic_chevron_down_grey_12dp);
            } else if (ChannelUtils.J(data.getChannel())) {
                this.binding.f2123b.setImageResource(R.drawable.ic_channel_voice_16dp);
            } else {
                this.binding.f2123b.setImageResource(R.drawable.ic_channel_text_16dp);
            }
            if (data.getChannel().getParentId() > 0) {
                ImageView imageView = this.binding.f2123b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildTemplateChannelsItemImage");
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                Resources resources = ((ChannelsAdapter) this.adapter).getContext().getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "adapter.context.resources");
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics());
            }
        }
    }

    /* compiled from: GuildTemplateChannelsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/guilds/create/GuildTemplateChannelsView$ChannelDataPayload;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelsAdapter extends MGRecyclerAdapterSimple<ChannelDataPayload> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelsAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<ChannelsAdapter, ChannelDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new ChannelViewHolder(R.layout.guild_template_channels_item_view, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateChannelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.guild_template_channels_view, (ViewGroup) this, false);
        addView(viewInflate);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.guild_template_channels_recycler_view);
        if (recyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.guild_template_channels_recycler_view)));
        }
        GuildTemplateChannelsViewBinding guildTemplateChannelsViewBinding = new GuildTemplateChannelsViewBinding((LinearLayout) viewInflate, recyclerView);
        Intrinsics3.checkNotNullExpressionValue(guildTemplateChannelsViewBinding, "GuildTemplateChannelsVie…rom(context), this, true)");
        this.binding = guildTemplateChannelsViewBinding;
        LinearLayout.inflate(context, R.layout.guild_template_channels_view, this);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildTemplateChannelsRecyclerView");
        this.channelsAdapter = (ChannelsAdapter) companion.configure(new ChannelsAdapter(recyclerView));
        recyclerView.setHasFixedSize(false);
    }

    public final void updateView(List<Channel> channels) {
        Intrinsics3.checkNotNullParameter(channels, "channels");
        ChannelsAdapter channelsAdapter = this.channelsAdapter;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(channels, 10));
        Iterator<T> it = channels.iterator();
        while (it.hasNext()) {
            arrayList.add(new ChannelDataPayload((Channel) it.next()));
        }
        channelsAdapter.setData(arrayList);
    }
}
