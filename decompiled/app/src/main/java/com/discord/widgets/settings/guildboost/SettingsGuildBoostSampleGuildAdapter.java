package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ViewSettingsBoostedSampleGuildBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.views.guildboost.GuildBoostProgressView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0011\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0010\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter$GuildListItem;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter$GuildListItem;", "", "guildBoostItems", "Lkotlin/Function1;", "", "Lcom/discord/primitives/GuildId;", "", "onGuildClickedListener", "configure", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "GuildListItem", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SettingsGuildBoostSampleGuildAdapter extends MGRecyclerAdapterSimple<Item> {
    private Function1<? super Long, Unit> onGuildClickedListener;

    /* compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter$GuildListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter;", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter$Item;)V", "Lcom/discord/databinding/ViewSettingsBoostedSampleGuildBinding;", "binding", "Lcom/discord/databinding/ViewSettingsBoostedSampleGuildBinding;", "adapter", "<init>", "(Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class GuildListItem extends MGRecyclerViewHolder<SettingsGuildBoostSampleGuildAdapter, Item> {
        private final ViewSettingsBoostedSampleGuildBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildListItem(SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter) {
            super(R.layout.view_settings_boosted_sample_guild, settingsGuildBoostSampleGuildAdapter);
            Intrinsics3.checkNotNullParameter(settingsGuildBoostSampleGuildAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.boosted_sample_guild_count;
            TextView textView = (TextView) view.findViewById(R.id.boosted_sample_guild_count);
            if (textView != null) {
                i = R.id.boosted_sample_guild_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.boosted_sample_guild_icon);
                if (simpleDraweeView != null) {
                    i = R.id.boosted_sample_guild_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.boosted_sample_guild_name);
                    if (textView2 != null) {
                        i = R.id.boosted_sample_guild_progress;
                        GuildBoostProgressView guildBoostProgressView = (GuildBoostProgressView) view.findViewById(R.id.boosted_sample_guild_progress);
                        if (guildBoostProgressView != null) {
                            ViewSettingsBoostedSampleGuildBinding viewSettingsBoostedSampleGuildBinding = new ViewSettingsBoostedSampleGuildBinding((CardView) view, textView, simpleDraweeView, textView2, guildBoostProgressView);
                            Intrinsics3.checkNotNullExpressionValue(viewSettingsBoostedSampleGuildBinding, "ViewSettingsBoostedSampl…ildBinding.bind(itemView)");
                            this.binding = viewSettingsBoostedSampleGuildBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ SettingsGuildBoostSampleGuildAdapter access$getAdapter$p(GuildListItem guildListItem) {
            return (SettingsGuildBoostSampleGuildAdapter) guildListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            int premiumSubscriptionCount = data.getGuild().getPremiumSubscriptionCount();
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.boostedSampleGuildIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, data.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostedSampleGuildName");
            textView.setText(data.getGuild().getName());
            TextView textView2 = this.binding.f2215b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.boostedSampleGuildCount");
            textView2.setText(StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.premium_guild_subscription_available_numSubscriptions, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
            this.binding.e.a(data.getGuild().getId(), data.getGuild().getPremiumTier(), premiumSubscriptionCount);
            this.itemView.setOnClickListener(new SettingsGuildBoostSampleGuildAdapter2(this, data));
        }
    }

    /* compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "guild", "copy", "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostSampleGuildAdapter$Item;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Item implements MGRecyclerDataPayload {
        public static final int TYPE_GUILD = 1;
        private final Guild guild;
        private final String key;
        private final int type;

        public Item(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.guild = guild;
            this.type = 1;
            this.key = String.valueOf(guild.getId());
        }

        public static /* synthetic */ Item copy$default(Item item, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = item.guild;
            }
            return item.copy(guild);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Item copy(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Item(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Item) && Intrinsics3.areEqual(this.guild, ((Item) other).guild);
            }
            return true;
        }

        public final Guild getGuild() {
            return this.guild;
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
            Guild guild = this.guild;
            if (guild != null) {
                return guild.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Item(guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGuildBoostSampleGuildAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function1 access$getOnGuildClickedListener$p(SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter) {
        return settingsGuildBoostSampleGuildAdapter.onGuildClickedListener;
    }

    public static final /* synthetic */ void access$setOnGuildClickedListener$p(SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter, Function1 function1) {
        settingsGuildBoostSampleGuildAdapter.onGuildClickedListener = function1;
    }

    public final void configure(List<Item> guildBoostItems, Function1<? super Long, Unit> onGuildClickedListener) {
        Intrinsics3.checkNotNullParameter(guildBoostItems, "guildBoostItems");
        Intrinsics3.checkNotNullParameter(onGuildClickedListener, "onGuildClickedListener");
        setData(guildBoostItems);
        this.onGuildClickedListener = onGuildClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GuildListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new GuildListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
