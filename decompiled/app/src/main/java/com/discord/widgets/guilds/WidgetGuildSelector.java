package com.discord.widgets.guilds;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildSelectorBinding;
import com.discord.databinding.WidgetGuildSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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

/* compiled from: WidgetGuildSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 /2\u00020\u0001:\u000601/234B\u0007¢\u0006\u0004\b-\u0010.J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R%\u0010,\u001a\n '*\u0004\u0018\u00010&0&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u00065"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildSelector;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/models/guild/Guild;", "guild", "", "onGuildSelected", "(Lcom/discord/models/guild/Guild;)V", "", "includeNoGuild", "Lcom/discord/widgets/guilds/WidgetGuildSelector$FilterFunction;", "filterFunction", "Lrx/Observable;", "", "Lcom/discord/widgets/guilds/WidgetGuildSelector$Item;", "get", "(ZLcom/discord/widgets/guilds/WidgetGuildSelector$FilterFunction;)Lrx/Observable;", "", "getContentViewResId", "()I", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/widgets/guilds/WidgetGuildSelector$Adapter;", "adapter", "Lcom/discord/widgets/guilds/WidgetGuildSelector$Adapter;", "Lcom/discord/databinding/WidgetGuildSelectorBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildSelectorBinding;", "binding", "", "kotlin.jvm.PlatformType", "requestKey$delegate", "Lkotlin/Lazy;", "getRequestKey", "()Ljava/lang/String;", "requestKey", "<init>", "()V", "Companion", "Adapter", "BaseFilterFunction", "FilterFunction", "GuildFilterFunction", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildSelector extends AppBottomSheet {
    private static final String ARG_FILTER_FUNCTION = "INTENT_EXTRA_FILTER_FUNCTION";
    private static final String ARG_INCLUDE_NO_GUILD = "INTENT_EXTRA_INCLUDE_NO_GUILD";
    private static final String ARG_NO_GUILD_STRING_ID = "INTENT_EXTRA_NO_GUILD_STRING_ID";
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String REQUEST_KEY_DEFAULT = "GUILD_SELECTOR_DEFAULT_REQUEST_KEY";
    private static final String RESULT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String RESULT_EXTRA_GUILD_NAME = "INTENT_EXTRA_GUILD_NAME";
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildSelectorBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetGuildSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildSelector$Adapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/guilds/WidgetGuildSelector$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/guilds/WidgetGuildSelector$Adapter$ItemGuild;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/guilds/WidgetGuildSelector$Adapter$ItemGuild;", "noGuildStringId", "I", "Lcom/discord/widgets/guilds/WidgetGuildSelector;", "dialog", "Lcom/discord/widgets/guilds/WidgetGuildSelector;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/discord/widgets/guilds/WidgetGuildSelector;I)V", "ItemGuild", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends MGRecyclerAdapterSimple<Item> {
        private final WidgetGuildSelector dialog;
        private final int noGuildStringId;

        /* compiled from: WidgetGuildSelector.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildSelector$Adapter$ItemGuild;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/guilds/WidgetGuildSelector$Adapter;", "Lcom/discord/widgets/guilds/WidgetGuildSelector$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/guilds/WidgetGuildSelector$Item;)V", "Lcom/discord/databinding/WidgetGuildSelectorItemBinding;", "binding", "Lcom/discord/databinding/WidgetGuildSelectorItemBinding;", "noGuildStringId", "I", "getNoGuildStringId", "()I", "layout", "adapter", "<init>", "(ILcom/discord/widgets/guilds/WidgetGuildSelector$Adapter;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ItemGuild extends MGRecyclerViewHolder<Adapter, Item> {
            private final WidgetGuildSelectorItemBinding binding;
            private final int noGuildStringId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemGuild(@LayoutRes int i, Adapter adapter, int i2) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                this.noGuildStringId = i2;
                View view = this.itemView;
                int i3 = R.id.item_avatar_wrap;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.item_avatar_wrap);
                if (frameLayout != null) {
                    i3 = R.id.item_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.item_icon);
                    if (simpleDraweeView != null) {
                        i3 = R.id.item_name;
                        TextView textView = (TextView) view.findViewById(R.id.item_name);
                        if (textView != null) {
                            i3 = R.id.item_text;
                            TextView textView2 = (TextView) view.findViewById(R.id.item_text);
                            if (textView2 != null) {
                                WidgetGuildSelectorItemBinding widgetGuildSelectorItemBinding = new WidgetGuildSelectorItemBinding((LinearLayout) view, frameLayout, simpleDraweeView, textView, textView2);
                                Intrinsics3.checkNotNullExpressionValue(widgetGuildSelectorItemBinding, "WidgetGuildSelectorItemBinding.bind(itemView)");
                                this.binding = widgetGuildSelectorItemBinding;
                                return;
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(ItemGuild itemGuild) {
                return (Adapter) itemGuild.adapter;
            }

            public final int getNoGuildStringId() {
                return this.noGuildStringId;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
                onConfigure2(i, item);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Item data) {
                CharSequence charSequenceJ;
                Guild guild;
                String icon;
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                this.binding.a.setOnClickListener(new WidgetGuildSelector2(this, data));
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemName");
                Guild guild2 = data.getGuild();
                boolean z2 = false;
                String shortName = null;
                if (guild2 == null || (charSequenceJ = guild2.getName()) == null) {
                    TextView textView2 = this.binding.d;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemName");
                    charSequenceJ = FormatUtils.j(textView2, this.noGuildStringId, new Object[0], null, 4);
                }
                textView.setText(charSequenceJ);
                Guild guild3 = data.getGuild();
                if (guild3 != null && (icon = guild3.getIcon()) != null) {
                    if (icon.length() > 0) {
                        z2 = true;
                    }
                }
                SimpleDraweeView simpleDraweeView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIcon");
                Guild guild4 = data.getGuild();
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Integer numValueOf = Integer.valueOf(ColorCompat.getThemedColor(view, R.attr.colorBackgroundPrimary));
                Intrinsics3.checkNotNullExpressionValue(this.binding.c, "binding.itemIcon");
                SimpleDraweeViewExtensions.setGuildIcon$default(simpleDraweeView, false, guild4, r4.getResources().getDimensionPixelSize(R.dimen.guild_icon_radius), null, numValueOf, null, null, true, null, 360, null);
                FrameLayout frameLayout = this.binding.f2452b;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.itemAvatarWrap");
                frameLayout.setClipToOutline(true);
                TextView textView3 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemText");
                if (!z2 && (guild = data.getGuild()) != null) {
                    shortName = guild.getShortName();
                }
                textView3.setText(shortName);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, WidgetGuildSelector widgetGuildSelector, int i) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            Intrinsics3.checkNotNullParameter(widgetGuildSelector, "dialog");
            this.dialog = widgetGuildSelector;
            this.noGuildStringId = i;
        }

        public static final /* synthetic */ WidgetGuildSelector access$getDialog$p(Adapter adapter) {
            return adapter.dialog;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ItemGuild onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new ItemGuild(R.layout.widget_guild_selector_item, this, this.noGuildStringId);
        }
    }

    /* compiled from: WidgetGuildSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildSelector$BaseFilterFunction;", "Lcom/discord/widgets/guilds/WidgetGuildSelector$FilterFunction;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class BaseFilterFunction implements FilterFunction {
        @Override // com.discord.widgets.guilds.WidgetGuildSelector.FilterFunction
        public boolean includeGuild(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return FilterFunction.DefaultImpls.includeGuild(this, guild);
        }
    }

    /* compiled from: WidgetGuildSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJG\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001c\u0010\f\u001a\u0018\u0012\b\u0012\u00060\tj\u0002`\n\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017¨\u0006 "}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildSelector$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "requestKey", "", "allowNullGuild", "Lkotlin/Function2;", "", "Lcom/discord/primitives/GuildId;", "", "onGuildSelected", "registerForResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)V", "includeNoGuild", "", "noGuildStringId", "Lcom/discord/widgets/guilds/WidgetGuildSelector$FilterFunction;", "filterFunction", "launch", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;ZILcom/discord/widgets/guilds/WidgetGuildSelector$FilterFunction;)V", "ARG_FILTER_FUNCTION", "Ljava/lang/String;", "ARG_INCLUDE_NO_GUILD", "ARG_NO_GUILD_STRING_ID", "ARG_REQUEST_KEY", "REQUEST_KEY_DEFAULT", "RESULT_EXTRA_GUILD_ID", "RESULT_EXTRA_GUILD_NAME", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Fragment fragment, String str, boolean z2, int i, FilterFunction filterFunction, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str = WidgetGuildSelector.REQUEST_KEY_DEFAULT;
            }
            String str2 = str;
            boolean z3 = (i2 & 4) != 0 ? false : z2;
            int i3 = (i2 & 8) != 0 ? R.string.none : i;
            if ((i2 & 16) != 0) {
                filterFunction = null;
            }
            companion.launch(fragment, str2, z3, i3, filterFunction);
        }

        public static /* synthetic */ void registerForResult$default(Companion companion, Fragment fragment, String str, boolean z2, Function2 function2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = WidgetGuildSelector.REQUEST_KEY_DEFAULT;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.registerForResult(fragment, str, z2, function2);
        }

        public final void launch(Fragment fragment, String requestKey, boolean includeNoGuild, int noGuildStringId, FilterFunction filterFunction) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetGuildSelector widgetGuildSelector = new WidgetGuildSelector();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetGuildSelector.ARG_REQUEST_KEY, requestKey);
            bundle.putBoolean(WidgetGuildSelector.ARG_INCLUDE_NO_GUILD, includeNoGuild);
            bundle.putInt(WidgetGuildSelector.ARG_NO_GUILD_STRING_ID, noGuildStringId);
            bundle.putSerializable(WidgetGuildSelector.ARG_FILTER_FUNCTION, filterFunction);
            widgetGuildSelector.setArguments(bundle);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetGuildSelector.show(parentFragmentManager, WidgetGuildSelector.class.getName());
        }

        public final void registerForResult(Fragment fragment, String requestKey, boolean allowNullGuild, Function2<? super Long, ? super String, Unit> onGuildSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onGuildSelected, "onGuildSelected");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetGuildSelector3(requestKey, allowNullGuild, onGuildSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildSelector$FilterFunction;", "Ljava/io/Serializable;", "Lcom/discord/models/guild/Guild;", "guild", "", "includeGuild", "(Lcom/discord/models/guild/Guild;)Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface FilterFunction extends Serializable {

        /* compiled from: WidgetGuildSelector.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static boolean includeGuild(FilterFunction filterFunction, Guild guild) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return true;
            }
        }

        boolean includeGuild(Guild guild);
    }

    /* compiled from: WidgetGuildSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÂ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildSelector$GuildFilterFunction;", "Lcom/discord/widgets/guilds/WidgetGuildSelector$FilterFunction;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/util/Set;", "Lcom/discord/models/guild/Guild;", "guild", "", "includeGuild", "(Lcom/discord/models/guild/Guild;)Z", "guildIds", "copy", "(Ljava/util/Set;)Lcom/discord/widgets/guilds/WidgetGuildSelector$GuildFilterFunction;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "<init>", "(Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildFilterFunction implements FilterFunction {
        private final Set<Long> guildIds;

        public GuildFilterFunction(Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "guildIds");
            this.guildIds = set;
        }

        private final Set<Long> component1() {
            return this.guildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildFilterFunction copy$default(GuildFilterFunction guildFilterFunction, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildFilterFunction.guildIds;
            }
            return guildFilterFunction.copy(set);
        }

        public final GuildFilterFunction copy(Set<Long> guildIds) {
            Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
            return new GuildFilterFunction(guildIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildFilterFunction) && Intrinsics3.areEqual(this.guildIds, ((GuildFilterFunction) other).guildIds);
            }
            return true;
        }

        public int hashCode() {
            Set<Long> set = this.guildIds;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        @Override // com.discord.widgets.guilds.WidgetGuildSelector.FilterFunction
        public boolean includeGuild(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return this.guildIds.contains(Long.valueOf(guild.getId()));
        }

        public String toString() {
            return outline.N(outline.U("GuildFilterFunction(guildIds="), this.guildIds, ")");
        }
    }

    /* compiled from: WidgetGuildSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\nR\u001c\u0010\u0016\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\rR\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildSelector$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "guild", "copy", "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/guilds/WidgetGuildSelector$Item;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Item implements MGRecyclerDataPayload {
        private final Guild guild;
        private final String key;
        private final int type = 1;

        public Item(Guild guild) {
            String strValueOf;
            this.guild = guild;
            this.key = (guild == null || (strValueOf = String.valueOf(guild.getId())) == null) ? "" : strValueOf;
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

    /* compiled from: WidgetGuildSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/guilds/WidgetGuildSelector$Item;", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildSelector$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Item>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Item> list) {
            invoke2((List<Item>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Item> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            WidgetGuildSelector.access$getAdapter$p(WidgetGuildSelector.this).setData(list);
        }
    }

    /* compiled from: WidgetGuildSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\b \u0005*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00072X\u0010\u0006\u001aT\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0005**\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000j\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0000j\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Ljava/util/LinkedHashMap;", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "Lkotlin/collections/LinkedHashMap;", "kotlin.jvm.PlatformType", "guilds", "", "Lcom/discord/widgets/guilds/WidgetGuildSelector$Item;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/LinkedHashMap;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildSelector$get$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<LinkedHashMap<Long, Guild>, List<? extends Item>> {
        public final /* synthetic */ FilterFunction $filterFunction;
        public final /* synthetic */ boolean $includeNoGuild;

        public AnonymousClass1(FilterFunction filterFunction, boolean z2) {
            this.$filterFunction = filterFunction;
            this.$includeNoGuild = z2;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Item> call(LinkedHashMap<Long, Guild> linkedHashMap) {
            return call2(linkedHashMap);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Item> call2(LinkedHashMap<Long, Guild> linkedHashMap) {
            Collection<Guild> collectionValues = linkedHashMap.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "guilds.values");
            FilterFunction filterFunction = this.$filterFunction;
            ArrayList arrayList = new ArrayList();
            for (T t : collectionValues) {
                if (filterFunction.includeGuild((Guild) t)) {
                    arrayList.add(t);
                }
            }
            List listListOf = this.$includeNoGuild ? CollectionsJVM.listOf(new Item(null)) : Collections2.emptyList();
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new Item((Guild) it.next()));
            }
            return _Collections.plus((Collection) listListOf, (Iterable) arrayList2);
        }
    }

    public WidgetGuildSelector() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildSelector4.INSTANCE, null, 2, null);
        this.requestKey = LazyJVM.lazy(new WidgetGuildSelector5(this));
    }

    public static final /* synthetic */ Adapter access$getAdapter$p(WidgetGuildSelector widgetGuildSelector) {
        Adapter adapter = widgetGuildSelector.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter;
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildSelector widgetGuildSelector) {
        return widgetGuildSelector.getArgumentsOrDefault();
    }

    public static final /* synthetic */ void access$onGuildSelected(WidgetGuildSelector widgetGuildSelector, Guild guild) {
        widgetGuildSelector.onGuildSelected(guild);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetGuildSelector widgetGuildSelector, Adapter adapter) {
        widgetGuildSelector.adapter = adapter;
    }

    private final Observable<List<Item>> get(boolean includeNoGuild, FilterFunction filterFunction) {
        Observable<R> observableG = StoreStream.INSTANCE.getGuildsSorted().observeOrderedGuilds().G(new AnonymousClass1(filterFunction, includeNoGuild));
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream.getGuildsSor….map { Item(it) }\n      }");
        Observable<List<Item>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream.getGuildsSor…  .distinctUntilChanged()");
        return observableR;
    }

    private final WidgetGuildSelectorBinding getBinding() {
        return (WidgetGuildSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    private final void onGuildSelected(Guild guild) {
        String requestKey = getRequestKey();
        Intrinsics3.checkNotNullExpressionValue(requestKey, "requestKey");
        Bundle bundle = new Bundle();
        bundle.putLong("INTENT_EXTRA_GUILD_ID", guild != null ? guild.getId() : -1L);
        bundle.putString(RESULT_EXTRA_GUILD_NAME, guild != null ? guild.getName() : null);
        Fragment2.setFragmentResult(this, requestKey, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_INCLUDE_NO_GUILD, false);
        Serializable serializable = getArgumentsOrDefault().getSerializable(ARG_FILTER_FUNCTION);
        if (!(serializable instanceof FilterFunction)) {
            serializable = null;
        }
        FilterFunction baseFilterFunction = (FilterFunction) serializable;
        if (baseFilterFunction == null) {
            baseFilterFunction = new BaseFilterFunction();
        }
        Observable<List<Item>> observable = get(z2, baseFilterFunction);
        Adapter adapter = this.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observable, this, adapter), WidgetGuildSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_selector;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2451b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildSelectorList");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView, this, getArgumentsOrDefault().getInt(ARG_NO_GUILD_STRING_ID)));
    }
}
