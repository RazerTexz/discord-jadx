package com.discord.widgets.friends;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.WidgetFriendsListAdapterItemFriendBinding;
import com.discord.databinding.WidgetFriendsListAdapterItemHeaderBinding;
import com.discord.databinding.WidgetFriendsListAdapterItemPendingBinding;
import com.discord.databinding.WidgetFriendsListAdapterSuggestedFriendBinding;
import com.discord.databinding.WidgetFriendsListContactSyncUpsellBinding;
import com.discord.databinding.WidgetFriendsListExpandableHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.widgets.friends.FriendsListViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetFriendsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\bABCDEFGHB\u000f\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R4\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R.\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R.\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R2\u0010*\u001a\u0012\u0012\b\u0012\u00060(j\u0002`)\u0012\u0004\u0012\u00020\u000b0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R.\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010 \u001a\u0004\b.\u0010\"\"\u0004\b/\u0010$R.\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010 \u001a\u0004\b1\u0010\"\"\u0004\b2\u0010$R8\u00104\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u00060\u0005j\u0002`3\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0016\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR(\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\r\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011R.\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010 \u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$¨\u0006I"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function0;", "", "onClickContactSyncUpsell", "Lkotlin/jvm/functions/Function0;", "getOnClickContactSyncUpsell", "()Lkotlin/jvm/functions/Function0;", "setOnClickContactSyncUpsell", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/discord/models/user/User;", "onClickUserProfile", "Lkotlin/jvm/functions/Function2;", "getOnClickUserProfile", "()Lkotlin/jvm/functions/Function2;", "setOnClickUserProfile", "(Lkotlin/jvm/functions/Function2;)V", "onClickSuggestedHeaderExpandCollapse", "getOnClickSuggestedHeaderExpandCollapse", "setOnClickSuggestedHeaderExpandCollapse", "Lkotlin/Function1;", "onClickContactSyncUpsellLongClick", "Lkotlin/jvm/functions/Function1;", "getOnClickContactSyncUpsellLongClick", "()Lkotlin/jvm/functions/Function1;", "setOnClickContactSyncUpsellLongClick", "(Lkotlin/jvm/functions/Function1;)V", "onClickAcceptFriend", "getOnClickAcceptFriend", "setOnClickAcceptFriend", "", "Lcom/discord/primitives/UserId;", "onClickRemoveSuggestion", "getOnClickRemoveSuggestion", "setOnClickRemoveSuggestion", "onClickCall", "getOnClickCall", "setOnClickCall", "onClickChat", "getOnClickChat", "setOnClickChat", "Lcom/discord/primitives/RelationshipType;", "onClickDeclineFriend", "getOnClickDeclineFriend", "setOnClickDeclineFriend", "onClickPendingHeaderExpand", "getOnClickPendingHeaderExpand", "setOnClickPendingHeaderExpand", "onClickApproveSuggestion", "getOnClickApproveSuggestion", "setOnClickApproveSuggestion", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Item", "ItemContactSyncUpsell", "ItemHeader", "ItemPendingHeader", "ItemPendingUser", "ItemSuggestedFriend", "ItemSuggestedFriendHeader", "ItemUser", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter extends MGRecyclerAdapterSimple<FriendsListViewModel.Item> {
    private Function1<? super User, Unit> onClickAcceptFriend;
    private Function1<? super User, Unit> onClickApproveSuggestion;
    private Function1<? super User, Unit> onClickCall;
    private Function1<? super User, Unit> onClickChat;
    private Function0<Unit> onClickContactSyncUpsell;
    private Function1<? super View, Unit> onClickContactSyncUpsellLongClick;
    private Function2<? super User, ? super Integer, Unit> onClickDeclineFriend;
    private Function0<Unit> onClickPendingHeaderExpand;
    private Function1<? super Long, Unit> onClickRemoveSuggestion;
    private Function0<Unit> onClickSuggestedHeaderExpandCollapse;
    private Function2<? super View, ? super User, Unit> onClickUserProfile;

    /* compiled from: WidgetFriendsListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0016\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "", "layoutResId", "adapter", "<init>", "(ILcom/discord/widgets/friends/WidgetFriendsListAdapter;)V", "Landroid/view/View;", "view", "(Landroid/view/View;Lcom/discord/widgets/friends/WidgetFriendsListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Item extends MGRecyclerViewHolder<WidgetFriendsListAdapter, FriendsListViewModel.Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(@LayoutRes int i, WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(i, widgetFriendsListAdapter);
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(View view, WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(view, widgetFriendsListAdapter);
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        }
    }

    /* compiled from: WidgetFriendsListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListAdapter$ItemContactSyncUpsell;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "data", "", "onConfigure", "(ILcom/discord/widgets/friends/FriendsListViewModel$Item;)V", "Lcom/discord/databinding/WidgetFriendsListContactSyncUpsellBinding;", "binding", "Lcom/discord/databinding/WidgetFriendsListContactSyncUpsellBinding;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/friends/WidgetFriendsListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemContactSyncUpsell extends Item {
        private final WidgetFriendsListContactSyncUpsellBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemContactSyncUpsell(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(R.layout.widget_friends_list_contact_sync_upsell, widgetFriendsListAdapter);
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.friends_list_contact_sync_upsell_arrow;
            ImageView imageView = (ImageView) view.findViewById(R.id.friends_list_contact_sync_upsell_arrow);
            if (imageView != null) {
                MaterialCardView materialCardView = (MaterialCardView) view;
                i = R.id.friends_list_contact_sync_upsell_icon;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.friends_list_contact_sync_upsell_icon);
                if (imageView2 != null) {
                    i = R.id.friends_list_contact_sync_upsell_subtitle;
                    TextView textView = (TextView) view.findViewById(R.id.friends_list_contact_sync_upsell_subtitle);
                    if (textView != null) {
                        i = R.id.friends_list_contact_sync_upsell_title;
                        TextView textView2 = (TextView) view.findViewById(R.id.friends_list_contact_sync_upsell_title);
                        if (textView2 != null) {
                            WidgetFriendsListContactSyncUpsellBinding widgetFriendsListContactSyncUpsellBinding = new WidgetFriendsListContactSyncUpsellBinding(materialCardView, imageView, materialCardView, imageView2, textView, textView2);
                            Intrinsics3.checkNotNullExpressionValue(widgetFriendsListContactSyncUpsellBinding, "WidgetFriendsListContact…ellBinding.bind(itemView)");
                            this.binding = widgetFriendsListContactSyncUpsellBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemContactSyncUpsell itemContactSyncUpsell) {
            return (WidgetFriendsListAdapter) itemContactSyncUpsell.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, FriendsListViewModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.binding.f2397b.setOnClickListener(new WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$1(this));
            this.binding.f2397b.setOnLongClickListener(new WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$2(this));
        }
    }

    /* compiled from: WidgetFriendsListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListAdapter$ItemHeader;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "data", "", "onConfigure", "(ILcom/discord/widgets/friends/FriendsListViewModel$Item;)V", "Lcom/discord/databinding/WidgetFriendsListAdapterItemHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetFriendsListAdapterItemHeaderBinding;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/friends/WidgetFriendsListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemHeader extends Item {
        private final WidgetFriendsListAdapterItemHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHeader(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(R.layout.widget_friends_list_adapter_item_header, widgetFriendsListAdapter);
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.friends_list_item_header_text);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.friends_list_item_header_text)));
            }
            WidgetFriendsListAdapterItemHeaderBinding widgetFriendsListAdapterItemHeaderBinding = new WidgetFriendsListAdapterItemHeaderBinding((FrameLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetFriendsListAdapterItemHeaderBinding, "WidgetFriendsListAdapter…derBinding.bind(itemView)");
            this.binding = widgetFriendsListAdapterItemHeaderBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, FriendsListViewModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            FriendsListViewModel.Item.Header header = (FriendsListViewModel.Item.Header) data;
            TextView textView = this.binding.f2393b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendsListItemHeaderText");
            FormatUtils.n(textView, header.getTitleStringResId(), new Object[]{Integer.valueOf(header.getCount())}, null, 4);
        }
    }

    /* compiled from: WidgetFriendsListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListAdapter$ItemPendingHeader;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "data", "", "onConfigure", "(ILcom/discord/widgets/friends/FriendsListViewModel$Item;)V", "Lcom/discord/databinding/WidgetFriendsListExpandableHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetFriendsListExpandableHeaderBinding;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/friends/WidgetFriendsListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemPendingHeader extends Item {
        private final WidgetFriendsListExpandableHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemPendingHeader(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(R.layout.widget_friends_list_expandable_header, widgetFriendsListAdapter);
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            WidgetFriendsListExpandableHeaderBinding widgetFriendsListExpandableHeaderBindingA = WidgetFriendsListExpandableHeaderBinding.a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetFriendsListExpandableHeaderBindingA, "WidgetFriendsListExpanda…derBinding.bind(itemView)");
            this.binding = widgetFriendsListExpandableHeaderBindingA;
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemPendingHeader itemPendingHeader) {
            return (WidgetFriendsListAdapter) itemPendingHeader.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, FriendsListViewModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            FriendsListViewModel.Item.PendingHeader pendingHeader = (FriendsListViewModel.Item.PendingHeader) data;
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendsListPendingItemHeaderText");
            FormatUtils.n(textView, pendingHeader.getTitleStringResId(), new Object[]{Integer.valueOf(pendingHeader.getCount())}, null, 4);
            if (!pendingHeader.getShowExpandButton()) {
                TextView textView2 = this.binding.f2398b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.friendsListExpandableHeaderButton");
                textView2.setVisibility(8);
                return;
            }
            TextView textView3 = this.binding.f2398b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.friendsListExpandableHeaderButton");
            textView3.setVisibility(0);
            int i = pendingHeader.isPendingSectionExpanded() ? R.string.friends_pending_request_expand_collapse : R.string.friends_pending_request_expand;
            TextView textView4 = this.binding.f2398b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.friendsListExpandableHeaderButton");
            FormatUtils.n(textView4, i, new Object[0], null, 4);
            int i2 = pendingHeader.isPendingSectionExpanded() ? R.drawable.ic_arrow_up_24dp : R.drawable.ic_arrow_right_24dp;
            TextView textView5 = this.binding.f2398b;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.friendsListExpandableHeaderButton");
            Drawable drawable = ContextCompat.getDrawable(textView5.getContext(), i2);
            TextView textView6 = this.binding.f2398b;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.friendsListExpandableHeaderButton");
            DrawableCompat.setCompoundDrawablesCompat$default(textView6, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
            this.binding.f2398b.setOnClickListener(new WidgetFriendsListAdapter$ItemPendingHeader$onConfigure$1(this));
        }
    }

    /* compiled from: WidgetFriendsListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListAdapter$ItemPendingUser;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "data", "", "onConfigure", "(ILcom/discord/widgets/friends/FriendsListViewModel$Item;)V", "Lcom/discord/databinding/WidgetFriendsListAdapterItemPendingBinding;", "binding", "Lcom/discord/databinding/WidgetFriendsListAdapterItemPendingBinding;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/friends/WidgetFriendsListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemPendingUser extends Item {
        private final WidgetFriendsListAdapterItemPendingBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemPendingUser(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(R.layout.widget_friends_list_adapter_item_pending, widgetFriendsListAdapter);
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.friends_list_item_accept_button;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.friends_list_item_accept_button);
            if (appCompatImageView != null) {
                i = R.id.friends_list_item_activity;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.friends_list_item_activity);
                if (simpleDraweeSpanTextView != null) {
                    i = R.id.friends_list_item_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.friends_list_item_avatar);
                    if (simpleDraweeView != null) {
                        i = R.id.friends_list_item_buttons_wrap;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.friends_list_item_buttons_wrap);
                        if (linearLayout != null) {
                            i = R.id.friends_list_item_decline_button;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.friends_list_item_decline_button);
                            if (appCompatImageView2 != null) {
                                i = R.id.friends_list_item_name;
                                TextView textView = (TextView) view.findViewById(R.id.friends_list_item_name);
                                if (textView != null) {
                                    i = R.id.friends_list_item_status;
                                    StatusView statusView = (StatusView) view.findViewById(R.id.friends_list_item_status);
                                    if (statusView != null) {
                                        i = R.id.friends_list_item_text;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.friends_list_item_text);
                                        if (linearLayout2 != null) {
                                            WidgetFriendsListAdapterItemPendingBinding widgetFriendsListAdapterItemPendingBinding = new WidgetFriendsListAdapterItemPendingBinding((RelativeLayout) view, appCompatImageView, simpleDraweeSpanTextView, simpleDraweeView, linearLayout, appCompatImageView2, textView, statusView, linearLayout2);
                                            Intrinsics3.checkNotNullExpressionValue(widgetFriendsListAdapterItemPendingBinding, "WidgetFriendsListAdapter…ingBinding.bind(itemView)");
                                            this.binding = widgetFriendsListAdapterItemPendingBinding;
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemPendingUser itemPendingUser) {
            return (WidgetFriendsListAdapter) itemPendingUser.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, FriendsListViewModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest = (FriendsListViewModel.Item.PendingFriendRequest) data;
            this.binding.a.setOnClickListener(new WidgetFriendsListAdapter$ItemPendingUser$onConfigure$1(this, data));
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
            textView.setText(pendingFriendRequest.getUser().getUsername());
            this.binding.g.setPresence(pendingFriendRequest.getPresence());
            int relationshipType = pendingFriendRequest.getRelationshipType();
            if (relationshipType == 3) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.friendsListItemActivity");
                SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.friendsListItemActivity");
                ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView, FormatUtils.j(simpleDraweeSpanTextView2, R.string.incoming_friend_request, new Object[0], null, 4));
                AppCompatImageView appCompatImageView = this.binding.f2394b;
                Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.friendsListItemAcceptButton");
                appCompatImageView.setVisibility(0);
            } else if (relationshipType == 4) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView3 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView3, "binding.friendsListItemActivity");
                SimpleDraweeSpanTextView simpleDraweeSpanTextView4 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView4, "binding.friendsListItemActivity");
                ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView3, FormatUtils.j(simpleDraweeSpanTextView4, R.string.outgoing_friend_request, new Object[0], null, 4));
                AppCompatImageView appCompatImageView2 = this.binding.f2394b;
                Intrinsics3.checkNotNullExpressionValue(appCompatImageView2, "binding.friendsListItemAcceptButton");
                appCompatImageView2.setVisibility(8);
            }
            SimpleDraweeView simpleDraweeView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, pendingFriendRequest.getUser(), R.dimen.avatar_size_standard, null, null, null, 56, null);
            this.binding.f2394b.setOnClickListener(new WidgetFriendsListAdapter$ItemPendingUser$onConfigure$2(this, pendingFriendRequest));
            this.binding.e.setOnClickListener(new WidgetFriendsListAdapter$ItemPendingUser$onConfigure$3(this, pendingFriendRequest));
        }
    }

    /* compiled from: WidgetFriendsListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListAdapter$ItemSuggestedFriend;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "data", "", "onConfigure", "(ILcom/discord/widgets/friends/FriendsListViewModel$Item;)V", "Lcom/discord/databinding/WidgetFriendsListAdapterSuggestedFriendBinding;", "viewBinding", "Lcom/discord/databinding/WidgetFriendsListAdapterSuggestedFriendBinding;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "adapter", "<init>", "(Lcom/discord/databinding/WidgetFriendsListAdapterSuggestedFriendBinding;Lcom/discord/widgets/friends/WidgetFriendsListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemSuggestedFriend extends Item {
        private final WidgetFriendsListAdapterSuggestedFriendBinding viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        public ItemSuggestedFriend(WidgetFriendsListAdapterSuggestedFriendBinding widgetFriendsListAdapterSuggestedFriendBinding, WidgetFriendsListAdapter widgetFriendsListAdapter) {
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapterSuggestedFriendBinding, "viewBinding");
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            SuggestedFriendView suggestedFriendView = widgetFriendsListAdapterSuggestedFriendBinding.a;
            Intrinsics3.checkNotNullExpressionValue(suggestedFriendView, "viewBinding.root");
            super(suggestedFriendView, widgetFriendsListAdapter);
            this.viewBinding = widgetFriendsListAdapterSuggestedFriendBinding;
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemSuggestedFriend itemSuggestedFriend) {
            return (WidgetFriendsListAdapter) itemSuggestedFriend.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, FriendsListViewModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            FriendsListViewModel.Item.SuggestedFriend suggestedFriend = (FriendsListViewModel.Item.SuggestedFriend) data;
            this.viewBinding.a.setOnClickListener(new WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$1(this, data));
            this.viewBinding.f2395b.setAvatarUrl(suggestedFriend.getSuggestion().getUser().getId(), Integer.valueOf(suggestedFriend.getSuggestion().getUser().getDiscriminator()), suggestedFriend.getSuggestion().getUser().getAvatar());
            this.viewBinding.f2395b.setUsername(suggestedFriend.getSuggestion().getUser().getUsername());
            this.viewBinding.f2395b.setPublicName(suggestedFriend.getSuggestion().getPublicName());
            this.viewBinding.f2395b.setOnSendClicked(new WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$2(this, data));
            this.viewBinding.f2395b.setOnDeclineClicked(new WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$3(this, data));
        }
    }

    /* compiled from: WidgetFriendsListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListAdapter$ItemSuggestedFriendHeader;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "data", "", "onConfigure", "(ILcom/discord/widgets/friends/FriendsListViewModel$Item;)V", "Lcom/discord/databinding/WidgetFriendsListExpandableHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetFriendsListExpandableHeaderBinding;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/friends/WidgetFriendsListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemSuggestedFriendHeader extends Item {
        private final WidgetFriendsListExpandableHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemSuggestedFriendHeader(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(R.layout.widget_friends_list_expandable_header, widgetFriendsListAdapter);
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            WidgetFriendsListExpandableHeaderBinding widgetFriendsListExpandableHeaderBindingA = WidgetFriendsListExpandableHeaderBinding.a(this.itemView);
            Intrinsics3.checkNotNullExpressionValue(widgetFriendsListExpandableHeaderBindingA, "WidgetFriendsListExpanda…derBinding.bind(itemView)");
            this.binding = widgetFriendsListExpandableHeaderBindingA;
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemSuggestedFriendHeader itemSuggestedFriendHeader) {
            return (WidgetFriendsListAdapter) itemSuggestedFriendHeader.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, FriendsListViewModel.Item data) {
            CharSequence charSequenceJ;
            Intrinsics3.checkNotNullParameter(data, "data");
            FriendsListViewModel.Item.SuggestedFriendsHeader suggestedFriendsHeader = (FriendsListViewModel.Item.SuggestedFriendsHeader) data;
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendsListPendingItemHeaderText");
            FormatUtils.m(textView, R.string.friends_friend_suggestions_header, new Object[0], new WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$1(data));
            if (!suggestedFriendsHeader.getShowExpandButton()) {
                TextView textView2 = this.binding.f2398b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.friendsListExpandableHeaderButton");
                textView2.setVisibility(8);
                return;
            }
            TextView textView3 = this.binding.f2398b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.friendsListExpandableHeaderButton");
            textView3.setVisibility(0);
            TextView textView4 = this.binding.f2398b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.friendsListExpandableHeaderButton");
            if (suggestedFriendsHeader.isExpanded()) {
                TextView textView5 = this.binding.f2398b;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.friendsListExpandableHeaderButton");
                charSequenceJ = FormatUtils.j(textView5, R.string.friends_pending_request_expand_collapse, new Object[0], null, 4);
            } else {
                TextView textView6 = this.binding.f2398b;
                Intrinsics3.checkNotNullExpressionValue(textView6, "binding.friendsListExpandableHeaderButton");
                charSequenceJ = FormatUtils.j(textView6, R.string.friends_pending_request_expand, new Object[0], null, 4);
            }
            textView4.setText(charSequenceJ);
            int i = suggestedFriendsHeader.isExpanded() ? R.drawable.ic_arrow_up_24dp : R.drawable.ic_arrow_right_24dp;
            TextView textView7 = this.binding.f2398b;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.friendsListExpandableHeaderButton");
            Drawable drawable = ContextCompat.getDrawable(textView7.getContext(), i);
            TextView textView8 = this.binding.f2398b;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.friendsListExpandableHeaderButton");
            DrawableCompat.setCompoundDrawablesCompat$default(textView8, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
            this.binding.f2398b.setOnClickListener(new WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$2(this));
        }
    }

    /* compiled from: WidgetFriendsListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/friends/WidgetFriendsListAdapter$ItemUser;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/friends/FriendsListViewModel$Item;", "data", "", "onConfigure", "(ILcom/discord/widgets/friends/FriendsListViewModel$Item;)V", "Lcom/discord/databinding/WidgetFriendsListAdapterItemFriendBinding;", "binding", "Lcom/discord/databinding/WidgetFriendsListAdapterItemFriendBinding;", "Lcom/discord/widgets/friends/WidgetFriendsListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/friends/WidgetFriendsListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ItemUser extends Item {
        private final WidgetFriendsListAdapterItemFriendBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemUser(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(R.layout.widget_friends_list_adapter_item_friend, widgetFriendsListAdapter);
            Intrinsics3.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.friends_list_item_activity;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.friends_list_item_activity);
            if (simpleDraweeSpanTextView != null) {
                i = R.id.friends_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.friends_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = R.id.friends_list_item_buttons_wrap;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.friends_list_item_buttons_wrap);
                    if (linearLayout != null) {
                        i = R.id.friends_list_item_call_button;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.friends_list_item_call_button);
                        if (appCompatImageView != null) {
                            i = R.id.friends_list_item_chat_button;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.friends_list_item_chat_button);
                            if (appCompatImageView2 != null) {
                                i = R.id.friends_list_item_name;
                                TextView textView = (TextView) view.findViewById(R.id.friends_list_item_name);
                                if (textView != null) {
                                    i = R.id.friends_list_item_status;
                                    StatusView statusView = (StatusView) view.findViewById(R.id.friends_list_item_status);
                                    if (statusView != null) {
                                        i = R.id.friends_list_item_text;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.friends_list_item_text);
                                        if (linearLayout2 != null) {
                                            WidgetFriendsListAdapterItemFriendBinding widgetFriendsListAdapterItemFriendBinding = new WidgetFriendsListAdapterItemFriendBinding((RelativeLayout) view, simpleDraweeSpanTextView, simpleDraweeView, linearLayout, appCompatImageView, appCompatImageView2, textView, statusView, linearLayout2);
                                            Intrinsics3.checkNotNullExpressionValue(widgetFriendsListAdapterItemFriendBinding, "WidgetFriendsListAdapter…endBinding.bind(itemView)");
                                            this.binding = widgetFriendsListAdapterItemFriendBinding;
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemUser itemUser) {
            return (WidgetFriendsListAdapter) itemUser.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, FriendsListViewModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, FriendsListViewModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            FriendsListViewModel.Item.Friend friend = (FriendsListViewModel.Item.Friend) data;
            this.binding.a.setOnClickListener(new WidgetFriendsListAdapter$ItemUser$onConfigure$1(this, data));
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
            textView.setText(friend.getUser().getUsername());
            this.binding.g.setPresence(friend.getPresence());
            Presence presence = friend.getPresence();
            boolean zIsApplicationStreaming = friend.isApplicationStreaming();
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f2392b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.friendsListItemActivity");
            PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, true, false, 16, null);
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, friend.getUser(), R.dimen.avatar_size_standard, null, null, null, 56, null);
            this.binding.d.setOnClickListener(new WidgetFriendsListAdapter$ItemUser$onConfigure$2(this, friend));
            this.binding.e.setOnClickListener(new WidgetFriendsListAdapter$ItemUser$onConfigure$3(this, friend));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClickSuggestedHeaderExpandCollapse = WidgetFriendsListAdapter$onClickSuggestedHeaderExpandCollapse$1.INSTANCE;
        this.onClickPendingHeaderExpand = WidgetFriendsListAdapter$onClickPendingHeaderExpand$1.INSTANCE;
        this.onClickUserProfile = WidgetFriendsListAdapter$onClickUserProfile$1.INSTANCE;
        this.onClickCall = WidgetFriendsListAdapter$onClickCall$1.INSTANCE;
        this.onClickChat = WidgetFriendsListAdapter$onClickChat$1.INSTANCE;
        this.onClickAcceptFriend = WidgetFriendsListAdapter$onClickAcceptFriend$1.INSTANCE;
        this.onClickDeclineFriend = WidgetFriendsListAdapter$onClickDeclineFriend$1.INSTANCE;
        this.onClickApproveSuggestion = WidgetFriendsListAdapter$onClickApproveSuggestion$1.INSTANCE;
        this.onClickRemoveSuggestion = WidgetFriendsListAdapter$onClickRemoveSuggestion$1.INSTANCE;
        this.onClickContactSyncUpsell = WidgetFriendsListAdapter$onClickContactSyncUpsell$1.INSTANCE;
        this.onClickContactSyncUpsellLongClick = WidgetFriendsListAdapter$onClickContactSyncUpsellLongClick$1.INSTANCE;
    }

    public final Function1<User, Unit> getOnClickAcceptFriend() {
        return this.onClickAcceptFriend;
    }

    public final Function1<User, Unit> getOnClickApproveSuggestion() {
        return this.onClickApproveSuggestion;
    }

    public final Function1<User, Unit> getOnClickCall() {
        return this.onClickCall;
    }

    public final Function1<User, Unit> getOnClickChat() {
        return this.onClickChat;
    }

    public final Function0<Unit> getOnClickContactSyncUpsell() {
        return this.onClickContactSyncUpsell;
    }

    public final Function1<View, Unit> getOnClickContactSyncUpsellLongClick() {
        return this.onClickContactSyncUpsellLongClick;
    }

    public final Function2<User, Integer, Unit> getOnClickDeclineFriend() {
        return this.onClickDeclineFriend;
    }

    public final Function0<Unit> getOnClickPendingHeaderExpand() {
        return this.onClickPendingHeaderExpand;
    }

    public final Function1<Long, Unit> getOnClickRemoveSuggestion() {
        return this.onClickRemoveSuggestion;
    }

    public final Function0<Unit> getOnClickSuggestedHeaderExpandCollapse() {
        return this.onClickSuggestedHeaderExpandCollapse;
    }

    public final Function2<View, User, Unit> getOnClickUserProfile() {
        return this.onClickUserProfile;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickAcceptFriend(Function1<? super User, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickAcceptFriend = function1;
    }

    public final void setOnClickApproveSuggestion(Function1<? super User, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickApproveSuggestion = function1;
    }

    public final void setOnClickCall(Function1<? super User, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickCall = function1;
    }

    public final void setOnClickChat(Function1<? super User, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickChat = function1;
    }

    public final void setOnClickContactSyncUpsell(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClickContactSyncUpsell = function0;
    }

    public final void setOnClickContactSyncUpsellLongClick(Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickContactSyncUpsellLongClick = function1;
    }

    public final void setOnClickDeclineFriend(Function2<? super User, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onClickDeclineFriend = function2;
    }

    public final void setOnClickPendingHeaderExpand(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClickPendingHeaderExpand = function0;
    }

    public final void setOnClickRemoveSuggestion(Function1<? super Long, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickRemoveSuggestion = function1;
    }

    public final void setOnClickSuggestedHeaderExpandCollapse(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClickSuggestedHeaderExpandCollapse = function0;
    }

    public final void setOnClickUserProfile(Function2<? super View, ? super User, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onClickUserProfile = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, FriendsListViewModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new ItemUser(this);
            case 1:
                return new ItemPendingUser(this);
            case 2:
                return new ItemPendingHeader(this);
            case 3:
                return new ItemHeader(this);
            case 4:
                return new ItemSuggestedFriendHeader(this);
            case 5:
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_friends_list_adapter_suggested_friend, parent, false);
                Objects.requireNonNull(viewInflate, "rootView");
                SuggestedFriendView suggestedFriendView = (SuggestedFriendView) viewInflate;
                WidgetFriendsListAdapterSuggestedFriendBinding widgetFriendsListAdapterSuggestedFriendBinding = new WidgetFriendsListAdapterSuggestedFriendBinding(suggestedFriendView, suggestedFriendView);
                Intrinsics3.checkNotNullExpressionValue(widgetFriendsListAdapterSuggestedFriendBinding, "WidgetFriendsListAdapter…          false\n        )");
                return new ItemSuggestedFriend(widgetFriendsListAdapterSuggestedFriendBinding, this);
            case 6:
                return new ItemContactSyncUpsell(this);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}
