package com.discord.widgets.settings.guildboost;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ViewSettingsBoostedBoostListitemBinding;
import com.discord.databinding.ViewSettingsBoostedGuildListitemBinding;
import com.discord.databinding.ViewSettingsBoostedHeaderListitemBinding;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.guild.Guild;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.guildboost.GuildBoostProgressView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\"#$%B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u007f\u0010\u0019\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f2\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u00060\rj\u0002`\u0013\u0012\u0004\u0012\u00020\u000f0\u00112\u001c\u0010\u0016\u001a\u0018\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aR,\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u00060\rj\u0002`\u0013\u0012\u0004\u0012\u00020\u000f0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR,\u0010\u0016\u001a\u0018\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001cR&\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001d¨\u0006&"}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", "guildBoostItems", "Lkotlin/Function1;", "", "Lcom/discord/primitives/GuildBoostSlotId;", "", "subscribeListener", "Lkotlin/Function2;", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "Lcom/discord/primitives/GuildId;", "transferListener", "", "cancelListener", "canCancelBoosts", "canUncancelBoosts", "configure", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZ)V", "Lkotlin/jvm/functions/Function2;", "Z", "Lkotlin/jvm/functions/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "GuildBoostListItem", "GuildListItem", "HeaderListItem", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter extends MGRecyclerAdapterSimple<Item> {
    private boolean canCancelBoosts;
    private boolean canUncancelBoosts;
    private Function2<? super Long, ? super Boolean, Unit> cancelListener;
    private Function1<? super Long, Unit> subscribeListener;
    private Function2<? super ModelGuildBoostSlot, ? super Long, Unit> transferListener;

    /* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "Landroid/view/View;", "sourceView", "", "hasCooldown", "canBeCancelled", "canBeUncancelled", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem;", "data", "", "showGuildBoostPopup", "(Landroid/view/View;ZZZLcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onConfigure", "(ILcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;)V", "Lcom/discord/databinding/ViewSettingsBoostedBoostListitemBinding;", "binding", "Lcom/discord/databinding/ViewSettingsBoostedBoostListitemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class GuildBoostListItem extends MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, Item> {
        private final ViewSettingsBoostedBoostListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildBoostListItem(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
            super(R.layout.view_settings_boosted_boost_listitem, widgetSettingsGuildBoostSubscriptionAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsGuildBoostSubscriptionAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.boosted_boost_action;
            TextView textView = (TextView) view.findViewById(R.id.boosted_boost_action);
            if (textView != null) {
                i = R.id.boosted_boost_cancelled;
                ImageView imageView = (ImageView) view.findViewById(R.id.boosted_boost_cancelled);
                if (imageView != null) {
                    i = R.id.boosted_boost_cooldown;
                    TextView textView2 = (TextView) view.findViewById(R.id.boosted_boost_cooldown);
                    if (textView2 != null) {
                        i = R.id.boosted_boost_date;
                        TextView textView3 = (TextView) view.findViewById(R.id.boosted_boost_date);
                        if (textView3 != null) {
                            ViewSettingsBoostedBoostListitemBinding viewSettingsBoostedBoostListitemBinding = new ViewSettingsBoostedBoostListitemBinding((RelativeLayout) view, textView, imageView, textView2, textView3);
                            Intrinsics3.checkNotNullExpressionValue(viewSettingsBoostedBoostListitemBinding, "ViewSettingsBoostedBoost…temBinding.bind(itemView)");
                            this.binding = viewSettingsBoostedBoostListitemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter access$getAdapter$p(GuildBoostListItem guildBoostListItem) {
            return (WidgetSettingsGuildBoostSubscriptionAdapter) guildBoostListItem.adapter;
        }

        public static final /* synthetic */ void access$showGuildBoostPopup(GuildBoostListItem guildBoostListItem, View view, boolean z2, boolean z3, boolean z4, Item.GuildBoostItem guildBoostItem) {
            guildBoostListItem.showGuildBoostPopup(view, z2, z3, z4, guildBoostItem);
        }

        private final void showGuildBoostPopup(View sourceView, boolean hasCooldown, boolean canBeCancelled, boolean canBeUncancelled, Item.GuildBoostItem data) {
            PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(sourceView.getContext(), 2131951663), sourceView);
            popupMenu.getMenuInflater().inflate(R.menu.menu_settings_premium_guild_sub, popupMenu.getMenu());
            MenuItem menuItemFindItem = popupMenu.getMenu().findItem(R.id.menu_settings_premium_guild_sub_transfer);
            MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(R.id.menu_settings_premium_guild_sub_cancel);
            MenuItem menuItemFindItem3 = popupMenu.getMenu().findItem(R.id.menu_settings_premium_guild_sub_uncancel);
            boolean canceled = data.getBoostSlot().getCanceled();
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "transfer");
            menuItemFindItem.setVisible(!hasCooldown);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "cancel");
            menuItemFindItem2.setVisible(!canceled && canBeCancelled);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem3, "uncancel");
            menuItemFindItem3.setVisible(canceled && canBeUncancelled);
            menuItemFindItem.setOnMenuItemClickListener(new WidgetSettingsGuildBoostSubscriptionAdapter3(this, data));
            menuItemFindItem2.setOnMenuItemClickListener(new WidgetSettingsGuildBoostSubscriptionAdapter4(this, data));
            menuItemFindItem3.setOnMenuItemClickListener(new WidgetSettingsGuildBoostSubscriptionAdapter5(this, data));
            popupMenu.show();
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) throws Exception {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) throws Exception {
            CharSequence string;
            String str;
            int i;
            char c;
            String strReplace$default;
            String str2;
            CharSequence charSequenceH;
            int themedDrawableRes$default;
            String boostEndsAt;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (!(data instanceof Item.GuildBoostItem)) {
                throw new Exception("Incorrect List Item Type or null data");
            }
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
            Item.GuildBoostItem guildBoostItem = (Item.GuildBoostItem) data;
            ModelGuildBoostSlot boostSlot = guildBoostItem.getBoostSlot();
            ModelAppliedGuildBoost premiumGuildSubscription = boostSlot.getPremiumGuildSubscription();
            boolean z2 = (premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null) != null;
            boolean z3 = boostSlot.getCooldownExpiresAtTimestamp() > jCurrentTimeMillis;
            ModelAppliedGuildBoost premiumGuildSubscription2 = boostSlot.getPremiumGuildSubscription();
            Long lValueOf = premiumGuildSubscription2 != null ? Long.valueOf((premiumGuildSubscription2.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH) : null;
            boolean canceled = boostSlot.getCanceled();
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.boostedBoostCancelled");
            imageView.setVisibility(canceled ? 0 : 8);
            TextView textView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostedBoostDate");
            if (lValueOf == null || (string = DateFormat.format("MMMM dd, yyy", lValueOf.longValue())) == null) {
                string = context.getString(R.string.premium_guild_subscription_unused_slot_description);
            }
            textView.setText(string);
            if (!canceled || (boostEndsAt = guildBoostItem.getBoostEndsAt()) == null) {
                str = "context";
                i = 0;
                c = 1;
                strReplace$default = null;
            } else {
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                str = "context";
                i = 0;
                c = 1;
                strReplace$default = StringsJVM.replace$default(FormatUtils.h(context, R.string.premium_guild_subscription_pending_cancelation, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, boostEndsAt, context, (String) null, (java.text.DateFormat) null, 0, 28, (Object) null)}, null, 4).toString(), "*", "", false, 4, (Object) null);
            }
            if (z3) {
                long jMax = Math.max(boostSlot.getCooldownExpiresAtTimestamp() - jCurrentTimeMillis, 0L);
                long j = jMax / 86400000;
                long j2 = jMax - (86400000 * j);
                long j3 = j2 / 3600000;
                str2 = str;
                Intrinsics3.checkNotNullExpressionValue(context, str2);
                Object[] objArr = new Object[3];
                objArr[i] = String.valueOf(j);
                objArr[c] = String.valueOf(j3);
                objArr[2] = String.valueOf((j2 - (3600000 * j3)) / 60000);
                charSequenceH = FormatUtils.h(context, R.string.premium_guild_cooldown_available_countdown, objArr, null, 4);
            } else {
                str2 = str;
                charSequenceH = null;
            }
            if (strReplace$default == null && charSequenceH == null) {
                TextView textView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.boostedBoostCooldown");
                textView2.setVisibility(8);
            } else if (strReplace$default != null && charSequenceH != null) {
                TextView textView3 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.boostedBoostCooldown");
                ViewExtensions.setTextAndVisibilityBy(textView3, charSequenceH + " - " + strReplace$default);
            } else if (strReplace$default != null && charSequenceH == null) {
                TextView textView4 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.boostedBoostCooldown");
                ViewExtensions.setTextAndVisibilityBy(textView4, strReplace$default);
            } else if (strReplace$default == null && charSequenceH != null) {
                TextView textView5 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.boostedBoostCooldown");
                ViewExtensions.setTextAndVisibilityBy(textView5, charSequenceH);
            }
            TextView textView6 = this.binding.f2212b;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.boostedBoostAction");
            textView6.setText((z2 || z3) ? "" : context.getString(R.string.premium_guild_subscription_select_server_button));
            if (!z3 || (!canceled && WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanCancelBoosts$p((WidgetSettingsGuildBoostSubscriptionAdapter) this.adapter)) || (canceled && WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanUncancelBoosts$p((WidgetSettingsGuildBoostSubscriptionAdapter) this.adapter))) {
                Intrinsics3.checkNotNullExpressionValue(context, str2);
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_overflow, i, 2, (Object) null);
            } else {
                themedDrawableRes$default = 0;
            }
            this.binding.f2212b.setCompoundDrawablesWithIntrinsicBounds(i, i, themedDrawableRes$default, i);
            this.binding.f2212b.setOnClickListener(new WidgetSettingsGuildBoostSubscriptionAdapter2(this, z2, z3, data, boostSlot));
        }
    }

    /* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$GuildListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;)V", "Lcom/discord/databinding/ViewSettingsBoostedGuildListitemBinding;", "binding", "Lcom/discord/databinding/ViewSettingsBoostedGuildListitemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class GuildListItem extends MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, Item> {
        private final ViewSettingsBoostedGuildListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildListItem(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
            super(R.layout.view_settings_boosted_guild_listitem, widgetSettingsGuildBoostSubscriptionAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsGuildBoostSubscriptionAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.boosted_guild_banner;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.boosted_guild_banner);
            if (simpleDraweeView != null) {
                i = R.id.boosted_guild_gradient;
                View viewFindViewById = view.findViewById(R.id.boosted_guild_gradient);
                if (viewFindViewById != null) {
                    i = R.id.boosted_guild_progress_view;
                    GuildBoostProgressView guildBoostProgressView = (GuildBoostProgressView) view.findViewById(R.id.boosted_guild_progress_view);
                    if (guildBoostProgressView != null) {
                        i = R.id.boosted_sample_guild_count;
                        TextView textView = (TextView) view.findViewById(R.id.boosted_sample_guild_count);
                        if (textView != null) {
                            i = R.id.boosted_sample_guild_icon;
                            SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R.id.boosted_sample_guild_icon);
                            if (simpleDraweeView2 != null) {
                                i = R.id.boosted_sample_guild_name;
                                TextView textView2 = (TextView) view.findViewById(R.id.boosted_sample_guild_name);
                                if (textView2 != null) {
                                    ViewSettingsBoostedGuildListitemBinding viewSettingsBoostedGuildListitemBinding = new ViewSettingsBoostedGuildListitemBinding((LinearLayout) view, simpleDraweeView, viewFindViewById, guildBoostProgressView, textView, simpleDraweeView2, textView2);
                                    Intrinsics3.checkNotNullExpressionValue(viewSettingsBoostedGuildListitemBinding, "ViewSettingsBoostedGuild…temBinding.bind(itemView)");
                                    this.binding = viewSettingsBoostedGuildListitemBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) throws Exception {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) throws Exception {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (data instanceof Item.GuildItem) {
                Item.GuildItem guildItem = (Item.GuildItem) data;
                if (guildItem.getGuild() != null) {
                    View view = this.itemView;
                    Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                    Context context = view.getContext();
                    if (guildItem.getGuild().getBanner() != null) {
                        SimpleDraweeView simpleDraweeView = this.binding.f2213b;
                        IconUtils iconUtils = IconUtils.INSTANCE;
                        Guild guild = guildItem.getGuild();
                        Intrinsics3.checkNotNullExpressionValue(context, "context");
                        simpleDraweeView.setImageURI(IconUtils.getBannerForGuild$default(iconUtils, guild, Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.nav_panel_width)), false, 4, null));
                        View view2 = this.binding.c;
                        Intrinsics3.checkNotNullExpressionValue(view2, "binding.boostedGuildGradient");
                        view2.setVisibility(0);
                    } else {
                        SimpleDraweeView simpleDraweeView2 = this.binding.f2213b;
                        Intrinsics3.checkNotNullExpressionValue(context, "context");
                        simpleDraweeView2.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.bg_subscription_placeholder_pattern, 0, 2, (Object) null));
                        View view3 = this.binding.c;
                        Intrinsics3.checkNotNullExpressionValue(view3, "binding.boostedGuildGradient");
                        view3.setVisibility(8);
                    }
                    SimpleDraweeView simpleDraweeView3 = this.binding.f;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.boostedSampleGuildIcon");
                    IconUtils.setIcon$default(simpleDraweeView3, IconUtils.getForGuild$default(guildItem.getGuild(), null, false, null, 14, null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
                    TextView textView = this.binding.g;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostedSampleGuildName");
                    textView.setText(guildItem.getGuild().getName());
                    CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(context, R.plurals.premium_guild_subscription_guild_subsription_subtitle_numSubscriptions, guildItem.getBoostCount(), Integer.valueOf(guildItem.getBoostCount()));
                    TextView textView2 = this.binding.e;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.boostedSampleGuildCount");
                    textView2.setText(FormatUtils.h(context, R.string.premium_guild_subscription_guild_subsription_subtitle, new Object[]{i18nPluralString}, null, 4));
                    this.binding.d.a(guildItem.getGuild().getId(), guildItem.getGuild().getPremiumTier(), guildItem.getGuild().getPremiumSubscriptionCount());
                    return;
                }
            }
            throw new Exception("Incorrect List Item Type or null data");
        }
    }

    /* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$HeaderListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;)V", "Lcom/discord/databinding/ViewSettingsBoostedHeaderListitemBinding;", "binding", "Lcom/discord/databinding/ViewSettingsBoostedHeaderListitemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HeaderListItem extends MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, Item> {
        private final ViewSettingsBoostedHeaderListitemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderListItem(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
            super(R.layout.view_settings_boosted_header_listitem, widgetSettingsGuildBoostSubscriptionAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsGuildBoostSubscriptionAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            ViewSettingsBoostedHeaderListitemBinding viewSettingsBoostedHeaderListitemBinding = new ViewSettingsBoostedHeaderListitemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(viewSettingsBoostedHeaderListitemBinding, "ViewSettingsBoostedHeade…temBinding.bind(itemView)");
            this.binding = viewSettingsBoostedHeaderListitemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) throws Exception {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) throws Exception {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (!(data instanceof Item.HeaderItem)) {
                throw new Exception("Incorrect List Item Type or null data");
            }
            TextView textView = this.binding.f2214b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostedHeader");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            textView.setText(view.getContext().getString(((Item.HeaderItem) data).getHeaderStringId()));
        }
    }

    /* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "<init>", "()V", "Companion", "GuildBoostItem", "GuildItem", "HeaderItem", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_GUILD = 0;
        public static final int TYPE_GUILD_BOOST = 1;
        public static final int TYPE_HEADER = 2;

        /* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\u001b\u001a\u00020\r8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000f¨\u0006 "}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "component1", "()Lcom/discord/models/domain/ModelGuildBoostSlot;", "", "component2", "()Ljava/lang/String;", "boostSlot", "boostEndsAt", "copy", "(Lcom/discord/models/domain/ModelGuildBoostSlot;Ljava/lang/String;)Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBoostEndsAt", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "getBoostSlot", "key", "getKey", "type", "I", "getType", "<init>", "(Lcom/discord/models/domain/ModelGuildBoostSlot;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class GuildBoostItem extends Item {
            private final String boostEndsAt;
            private final ModelGuildBoostSlot boostSlot;
            private final String key;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuildBoostItem(ModelGuildBoostSlot modelGuildBoostSlot, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildBoostSlot, "boostSlot");
                this.boostSlot = modelGuildBoostSlot;
                this.boostEndsAt = str;
                this.type = 1;
                this.key = String.valueOf(modelGuildBoostSlot.getId());
            }

            public static /* synthetic */ GuildBoostItem copy$default(GuildBoostItem guildBoostItem, ModelGuildBoostSlot modelGuildBoostSlot, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildBoostSlot = guildBoostItem.boostSlot;
                }
                if ((i & 2) != 0) {
                    str = guildBoostItem.boostEndsAt;
                }
                return guildBoostItem.copy(modelGuildBoostSlot, str);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildBoostSlot getBoostSlot() {
                return this.boostSlot;
            }

            /* renamed from: component2, reason: from getter */
            public final String getBoostEndsAt() {
                return this.boostEndsAt;
            }

            public final GuildBoostItem copy(ModelGuildBoostSlot boostSlot, String boostEndsAt) {
                Intrinsics3.checkNotNullParameter(boostSlot, "boostSlot");
                return new GuildBoostItem(boostSlot, boostEndsAt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GuildBoostItem)) {
                    return false;
                }
                GuildBoostItem guildBoostItem = (GuildBoostItem) other;
                return Intrinsics3.areEqual(this.boostSlot, guildBoostItem.boostSlot) && Intrinsics3.areEqual(this.boostEndsAt, guildBoostItem.boostEndsAt);
            }

            public final String getBoostEndsAt() {
                return this.boostEndsAt;
            }

            public final ModelGuildBoostSlot getBoostSlot() {
                return this.boostSlot;
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
                ModelGuildBoostSlot modelGuildBoostSlot = this.boostSlot;
                int iHashCode = (modelGuildBoostSlot != null ? modelGuildBoostSlot.hashCode() : 0) * 31;
                String str = this.boostEndsAt;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("GuildBoostItem(boostSlot=");
                sbU.append(this.boostSlot);
                sbU.append(", boostEndsAt=");
                return outline.J(sbU, this.boostEndsAt, ")");
            }
        }

        /* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\u001b\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000e¨\u0006 "}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "component2", "()I", "guild", "boostCount", "copy", "(Lcom/discord/models/guild/Guild;I)Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "Lcom/discord/models/guild/Guild;", "getGuild", "getBoostCount", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/models/guild/Guild;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class GuildItem extends Item {
            private final int boostCount;
            private final Guild guild;
            private final String key;
            private final int type;

            public GuildItem(Guild guild, int i) {
                super(null);
                this.guild = guild;
                this.boostCount = i;
                this.key = String.valueOf(guild != null ? Long.valueOf(guild.getId()) : null);
            }

            public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    guild = guildItem.guild;
                }
                if ((i2 & 2) != 0) {
                    i = guildItem.boostCount;
                }
                return guildItem.copy(guild, i);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final int getBoostCount() {
                return this.boostCount;
            }

            public final GuildItem copy(Guild guild, int boostCount) {
                return new GuildItem(guild, boostCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GuildItem)) {
                    return false;
                }
                GuildItem guildItem = (GuildItem) other;
                return Intrinsics3.areEqual(this.guild, guildItem.guild) && this.boostCount == guildItem.boostCount;
            }

            public final int getBoostCount() {
                return this.boostCount;
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
                return ((guild != null ? guild.hashCode() : 0) * 31) + this.boostCount;
            }

            public String toString() {
                StringBuilder sbU = outline.U("GuildItem(guild=");
                sbU.append(this.guild);
                sbU.append(", boostCount=");
                return outline.B(sbU, this.boostCount, ")");
            }
        }

        /* compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem;", "Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item;", "", "component1", "()I", "headerStringId", "copy", "(I)Lcom/discord/widgets/settings/guildboost/WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "I", "getHeaderStringId", "type", "getType", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class HeaderItem extends Item {
            private final int headerStringId;
            private final String key;
            private final int type;

            public HeaderItem(@StringRes int i) {
                super(null);
                this.headerStringId = i;
                this.type = 2;
                this.key = String.valueOf(i);
            }

            public static /* synthetic */ HeaderItem copy$default(HeaderItem headerItem, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = headerItem.headerStringId;
                }
                return headerItem.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getHeaderStringId() {
                return this.headerStringId;
            }

            public final HeaderItem copy(@StringRes int headerStringId) {
                return new HeaderItem(headerStringId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof HeaderItem) && this.headerStringId == ((HeaderItem) other).headerStringId;
                }
                return true;
            }

            public final int getHeaderStringId() {
                return this.headerStringId;
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
                return this.headerStringId;
            }

            public String toString() {
                return outline.B(outline.U("HeaderItem(headerStringId="), this.headerStringId, ")");
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoostSubscriptionAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.subscribeListener = WidgetSettingsGuildBoostSubscriptionAdapter7.INSTANCE;
        this.transferListener = WidgetSettingsGuildBoostSubscriptionAdapter8.INSTANCE;
        this.cancelListener = WidgetSettingsGuildBoostSubscriptionAdapter6.INSTANCE;
    }

    public static final /* synthetic */ boolean access$getCanCancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.canCancelBoosts;
    }

    public static final /* synthetic */ boolean access$getCanUncancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.canUncancelBoosts;
    }

    public static final /* synthetic */ Function2 access$getCancelListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.cancelListener;
    }

    public static final /* synthetic */ Function1 access$getSubscribeListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.subscribeListener;
    }

    public static final /* synthetic */ Function2 access$getTransferListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.transferListener;
    }

    public static final /* synthetic */ void access$setCanCancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, boolean z2) {
        widgetSettingsGuildBoostSubscriptionAdapter.canCancelBoosts = z2;
    }

    public static final /* synthetic */ void access$setCanUncancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, boolean z2) {
        widgetSettingsGuildBoostSubscriptionAdapter.canUncancelBoosts = z2;
    }

    public static final /* synthetic */ void access$setCancelListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, Function2 function2) {
        widgetSettingsGuildBoostSubscriptionAdapter.cancelListener = function2;
    }

    public static final /* synthetic */ void access$setSubscribeListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, Function1 function1) {
        widgetSettingsGuildBoostSubscriptionAdapter.subscribeListener = function1;
    }

    public static final /* synthetic */ void access$setTransferListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, Function2 function2) {
        widgetSettingsGuildBoostSubscriptionAdapter.transferListener = function2;
    }

    public final void configure(List<? extends Item> guildBoostItems, Function1<? super Long, Unit> subscribeListener, Function2<? super ModelGuildBoostSlot, ? super Long, Unit> transferListener, Function2<? super Long, ? super Boolean, Unit> cancelListener, boolean canCancelBoosts, boolean canUncancelBoosts) {
        Intrinsics3.checkNotNullParameter(guildBoostItems, "guildBoostItems");
        Intrinsics3.checkNotNullParameter(subscribeListener, "subscribeListener");
        Intrinsics3.checkNotNullParameter(transferListener, "transferListener");
        Intrinsics3.checkNotNullParameter(cancelListener, "cancelListener");
        setData(guildBoostItems);
        this.subscribeListener = subscribeListener;
        this.transferListener = transferListener;
        this.cancelListener = cancelListener;
        this.canCancelBoosts = canCancelBoosts;
        this.canUncancelBoosts = canUncancelBoosts;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new GuildListItem(this);
        }
        if (viewType == 1) {
            return new GuildBoostListItem(this);
        }
        if (viewType == 2) {
            return new HeaderListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
