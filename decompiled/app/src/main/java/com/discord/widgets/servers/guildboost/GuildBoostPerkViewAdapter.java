package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ViewNitroBoostPerksListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: GuildBoostPerkViewAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter$PerkViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter$PerkViewHolder;", "", "perkItems", "", "configure", "(Ljava/util/List;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "GuildBoostPerkViewListItem", "PerkViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildBoostPerkViewAdapter extends MGRecyclerAdapterSimple<GuildBoostPerkViewListItem> {

    /* compiled from: GuildBoostPerkViewAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001d\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "component1", "()I", "", "component2", "()Ljava/lang/CharSequence;", "iconResId", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "copy", "(ILjava/lang/CharSequence;)Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Ljava/lang/CharSequence;", "getText", "getIconResId", "<init>", "(ILjava/lang/CharSequence;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildBoostPerkViewListItem implements MGRecyclerDataPayload {
        public static final int TYPE_LIST_ITEM = 1;
        private final int iconResId;
        private final String key;
        private final CharSequence text;
        private final int type;

        public GuildBoostPerkViewListItem(@DrawableRes int i, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.iconResId = i;
            this.text = charSequence;
            this.type = 1;
            this.key = charSequence.toString();
        }

        public static /* synthetic */ GuildBoostPerkViewListItem copy$default(GuildBoostPerkViewListItem guildBoostPerkViewListItem, int i, CharSequence charSequence, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = guildBoostPerkViewListItem.iconResId;
            }
            if ((i2 & 2) != 0) {
                charSequence = guildBoostPerkViewListItem.text;
            }
            return guildBoostPerkViewListItem.copy(i, charSequence);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIconResId() {
            return this.iconResId;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        public final GuildBoostPerkViewListItem copy(@DrawableRes int iconResId, CharSequence text) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            return new GuildBoostPerkViewListItem(iconResId, text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildBoostPerkViewListItem)) {
                return false;
            }
            GuildBoostPerkViewListItem guildBoostPerkViewListItem = (GuildBoostPerkViewListItem) other;
            return this.iconResId == guildBoostPerkViewListItem.iconResId && Intrinsics3.areEqual(this.text, guildBoostPerkViewListItem.text);
        }

        public final int getIconResId() {
            return this.iconResId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final CharSequence getText() {
            return this.text;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            int i = this.iconResId * 31;
            CharSequence charSequence = this.text;
            return i + (charSequence != null ? charSequence.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildBoostPerkViewListItem(iconResId=");
            sbU.append(this.iconResId);
            sbU.append(", text=");
            return outline.E(sbU, this.text, ")");
        }
    }

    /* compiled from: GuildBoostPerkViewAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter$PerkViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter;", "Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem;)V", "Lcom/discord/databinding/ViewNitroBoostPerksListItemBinding;", "binding", "Lcom/discord/databinding/ViewNitroBoostPerksListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/guildboost/GuildBoostPerkViewAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PerkViewHolder extends MGRecyclerViewHolder<GuildBoostPerkViewAdapter, GuildBoostPerkViewListItem> {
        private final ViewNitroBoostPerksListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PerkViewHolder(GuildBoostPerkViewAdapter guildBoostPerkViewAdapter) {
            super(R.layout.view_nitro_boost_perks_list_item, guildBoostPerkViewAdapter);
            Intrinsics3.checkNotNullParameter(guildBoostPerkViewAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            ViewNitroBoostPerksListItemBinding viewNitroBoostPerksListItemBinding = new ViewNitroBoostPerksListItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(viewNitroBoostPerksListItemBinding, "ViewNitroBoostPerksListItemBinding.bind(itemView)");
            this.binding = viewNitroBoostPerksListItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, GuildBoostPerkViewListItem guildBoostPerkViewListItem) {
            onConfigure2(i, guildBoostPerkViewListItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, GuildBoostPerkViewListItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.f2205b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.perkViewContentListItem");
            textView.setText(data.getText());
            TextView textView2 = this.binding.f2205b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.perkViewContentListItem");
            DrawableCompat.setCompoundDrawablesCompat$default(textView2, data.getIconResId(), 0, 0, 0, 14, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostPerkViewAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public final void configure(List<GuildBoostPerkViewListItem> perkItems) {
        Intrinsics3.checkNotNullParameter(perkItems, "perkItems");
        setData(perkItems);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PerkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new PerkViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
