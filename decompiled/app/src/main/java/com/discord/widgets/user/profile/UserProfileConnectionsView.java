package com.discord.widgets.user.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.databinding.UserProfileConnectionsViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* compiled from: UserProfileConnectionsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004JS\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileConnectionsView;", "Landroid/widget/LinearLayout;", "", "onAttachedToWindow", "()V", "Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ViewState;", "viewState", "Lkotlin/Function3;", "", "", "onConnectedAccountClick", "Lkotlin/Function0;", "onMutualGuildsItemClick", "onMutualFriendsItemClick", "updateViewState", "(Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ViewState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountsAdapter;", "connectedAccountsAdapter", "Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountsAdapter;", "Lcom/discord/databinding/UserProfileConnectionsViewBinding;", "binding", "Lcom/discord/databinding/UserProfileConnectionsViewBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ConnectedAccountItem", "ConnectedAccountsAdapter", "ViewHolder", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class UserProfileConnectionsView extends LinearLayout {
    private final UserProfileConnectionsViewBinding binding;
    private final ConnectedAccountsAdapter connectedAccountsAdapter;

    /* compiled from: UserProfileConnectionsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\nR\u001c\u0010\u0016\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "component1", "()Lcom/discord/api/connectedaccounts/ConnectedAccount;", "connectedAccount", "copy", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "getConnectedAccount", "<init>", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ConnectedAccountItem implements MGRecyclerDataPayload {
        private final ConnectedAccount connectedAccount;
        private final String key;
        private final int type;

        public ConnectedAccountItem(ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "connectedAccount");
            this.connectedAccount = connectedAccount;
            this.key = connectedAccount.getId();
        }

        public static /* synthetic */ ConnectedAccountItem copy$default(ConnectedAccountItem connectedAccountItem, ConnectedAccount connectedAccount, int i, Object obj) {
            if ((i & 1) != 0) {
                connectedAccount = connectedAccountItem.connectedAccount;
            }
            return connectedAccountItem.copy(connectedAccount);
        }

        /* renamed from: component1, reason: from getter */
        public final ConnectedAccount getConnectedAccount() {
            return this.connectedAccount;
        }

        public final ConnectedAccountItem copy(ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "connectedAccount");
            return new ConnectedAccountItem(connectedAccount);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ConnectedAccountItem) && Intrinsics3.areEqual(this.connectedAccount, ((ConnectedAccountItem) other).connectedAccount);
            }
            return true;
        }

        public final ConnectedAccount getConnectedAccount() {
            return this.connectedAccount;
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
            ConnectedAccount connectedAccount = this.connectedAccount;
            if (connectedAccount != null) {
                return connectedAccount.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ConnectedAccountItem(connectedAccount=");
            sbU.append(this.connectedAccount);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: UserProfileConnectionsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR<\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountsAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function3;", "", "", "onConnectedAccountClick", "Lkotlin/jvm/functions/Function3;", "getOnConnectedAccountClick", "()Lkotlin/jvm/functions/Function3;", "setOnConnectedAccountClick", "(Lkotlin/jvm/functions/Function3;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ConnectedAccountsAdapter extends MGRecyclerAdapterSimple<ConnectedAccountItem> {
        private Function3<? super String, ? super Integer, ? super String, Unit> onConnectedAccountClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConnectedAccountsAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            this.onConnectedAccountClick = UserProfileConnectionsView2.INSTANCE;
        }

        public final Function3<String, Integer, String, Unit> getOnConnectedAccountClick() {
            return this.onConnectedAccountClick;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setOnConnectedAccountClick(Function3<? super String, ? super Integer, ? super String, Unit> function3) {
            Intrinsics3.checkNotNullParameter(function3, "<set-?>");
            this.onConnectedAccountClick = function3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<ConnectedAccountsAdapter, ConnectedAccountItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new ViewHolder(R.layout.icon_list_item_text_view, this);
        }
    }

    /* compiled from: UserProfileConnectionsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountsAdapter;", "Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountItem;)V", "Landroid/widget/TextView;", "listItemTextView", "Landroid/widget/TextView;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountsAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends MGRecyclerViewHolder<ConnectedAccountsAdapter, ConnectedAccountItem> {
        private final TextView listItemTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@LayoutRes int i, ConnectedAccountsAdapter connectedAccountsAdapter) {
            super(i, connectedAccountsAdapter);
            Intrinsics3.checkNotNullParameter(connectedAccountsAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.listItemTextView = (TextView) view;
        }

        public static final /* synthetic */ ConnectedAccountsAdapter access$getAdapter$p(ViewHolder viewHolder) {
            return (ConnectedAccountsAdapter) viewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ConnectedAccountItem connectedAccountItem) {
            onConfigure2(i, connectedAccountItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ConnectedAccountItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ConnectedAccount connectedAccount = data.getConnectedAccount();
            String name = connectedAccount.getName();
            Platform platformFrom = Platform.INSTANCE.from(connectedAccount);
            Integer themedPlatformImage = platformFrom.getThemedPlatformImage();
            int iIntValue = themedPlatformImage != null ? themedPlatformImage.intValue() : 0;
            String profileUrl = platformFrom.getProfileUrl(connectedAccount);
            TextView textView = this.listItemTextView;
            Integer themedPlatformImage2 = platformFrom.getThemedPlatformImage();
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView, DrawableCompat.getThemedDrawableRes$default(textView, themedPlatformImage2 != null ? themedPlatformImage2.intValue() : 0, 0, 2, (Object) null), 0, 0, 0, 14, null);
            this.listItemTextView.setText(connectedAccount.getName());
            TextView textView2 = this.listItemTextView;
            String str = String.format("%s, %s", Arrays.copyOf(new Object[]{connectedAccount.getType(), connectedAccount.getName()}, 2));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            textView2.setContentDescription(str);
            this.itemView.setOnClickListener(new UserProfileConnectionsView3(this, platformFrom, name, iIntValue, profileUrl));
        }
    }

    /* compiled from: UserProfileConnectionsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ViewState;", "", "", "component1", "()Z", "component2", "", "Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ConnectedAccountItem;", "component3", "()Ljava/util/List;", "showConnectionsSection", "showMutualGuildsAndFriends", "connectedAccountItems", "copy", "(ZZLjava/util/List;)Lcom/discord/widgets/user/profile/UserProfileConnectionsView$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getConnectedAccountItems", "Z", "getShowConnectionsSection", "getShowMutualGuildsAndFriends", "<init>", "(ZZLjava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final List<ConnectedAccountItem> connectedAccountItems;
        private final boolean showConnectionsSection;
        private final boolean showMutualGuildsAndFriends;

        public ViewState(boolean z2, boolean z3, List<ConnectedAccountItem> list) {
            Intrinsics3.checkNotNullParameter(list, "connectedAccountItems");
            this.showConnectionsSection = z2;
            this.showMutualGuildsAndFriends = z3;
            this.connectedAccountItems = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, boolean z3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.showConnectionsSection;
            }
            if ((i & 2) != 0) {
                z3 = viewState.showMutualGuildsAndFriends;
            }
            if ((i & 4) != 0) {
                list = viewState.connectedAccountItems;
            }
            return viewState.copy(z2, z3, list);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShowConnectionsSection() {
            return this.showConnectionsSection;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowMutualGuildsAndFriends() {
            return this.showMutualGuildsAndFriends;
        }

        public final List<ConnectedAccountItem> component3() {
            return this.connectedAccountItems;
        }

        public final ViewState copy(boolean showConnectionsSection, boolean showMutualGuildsAndFriends, List<ConnectedAccountItem> connectedAccountItems) {
            Intrinsics3.checkNotNullParameter(connectedAccountItems, "connectedAccountItems");
            return new ViewState(showConnectionsSection, showMutualGuildsAndFriends, connectedAccountItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.showConnectionsSection == viewState.showConnectionsSection && this.showMutualGuildsAndFriends == viewState.showMutualGuildsAndFriends && Intrinsics3.areEqual(this.connectedAccountItems, viewState.connectedAccountItems);
        }

        public final List<ConnectedAccountItem> getConnectedAccountItems() {
            return this.connectedAccountItems;
        }

        public final boolean getShowConnectionsSection() {
            return this.showConnectionsSection;
        }

        public final boolean getShowMutualGuildsAndFriends() {
            return this.showMutualGuildsAndFriends;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.showConnectionsSection;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.showMutualGuildsAndFriends;
            int i2 = (i + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            List<ConnectedAccountItem> list = this.connectedAccountItems;
            return i2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(showConnectionsSection=");
            sbU.append(this.showConnectionsSection);
            sbU.append(", showMutualGuildsAndFriends=");
            sbU.append(this.showMutualGuildsAndFriends);
            sbU.append(", connectedAccountItems=");
            return outline.L(sbU, this.connectedAccountItems, ")");
        }
    }

    /* compiled from: UserProfileConnectionsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "username", "", "themedPlatformImageRes", "profileUrl", "", "invoke", "(Ljava/lang/String;ILjava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileConnectionsView$updateViewState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<String, Integer, String, Unit> {
        public final /* synthetic */ Function3 $onConnectedAccountClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function3 function3) {
            super(3);
            this.$onConnectedAccountClick = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
            invoke(str, num.intValue(), str2);
            return Unit.a;
        }

        public final void invoke(String str, int i, String str2) {
            Intrinsics3.checkNotNullParameter(str, "username");
            this.$onConnectedAccountClick.invoke(str, Integer.valueOf(i), str2);
        }
    }

    /* compiled from: UserProfileConnectionsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileConnectionsView$updateViewState$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onMutualGuildsItemClick;

        public AnonymousClass2(Function0 function0) {
            this.$onMutualGuildsItemClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onMutualGuildsItemClick.invoke();
        }
    }

    /* compiled from: UserProfileConnectionsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileConnectionsView$updateViewState$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onMutualFriendsItemClick;

        public AnonymousClass3(Function0 function0) {
            this.$onMutualFriendsItemClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onMutualFriendsItemClick.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileConnectionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.user_profile_connections_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.user_profile_connections_mutual_friends_item;
        TextView textView = (TextView) viewInflate.findViewById(R.id.user_profile_connections_mutual_friends_item);
        if (textView != null) {
            i = R.id.user_profile_connections_mutual_guilds_item;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.user_profile_connections_mutual_guilds_item);
            if (textView2 != null) {
                i = R.id.user_profile_connections_view_recycler;
                RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.user_profile_connections_view_recycler);
                if (recyclerView != null) {
                    UserProfileConnectionsViewBinding userProfileConnectionsViewBinding = new UserProfileConnectionsViewBinding((LinearLayout) viewInflate, textView, textView2, recyclerView);
                    Intrinsics3.checkNotNullExpressionValue(userProfileConnectionsViewBinding, "UserProfileConnectionsVi…rom(context), this, true)");
                    this.binding = userProfileConnectionsViewBinding;
                    MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.userProfileConnectionsViewRecycler");
                    this.connectedAccountsAdapter = (ConnectedAccountsAdapter) companion.configure(new ConnectedAccountsAdapter(recyclerView));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.binding.d.setHasFixedSize(false);
        ViewCompat.setNestedScrollingEnabled(this.binding.d, false);
    }

    public final void updateViewState(ViewState viewState, Function3<? super String, ? super Integer, ? super String, Unit> onConnectedAccountClick, Function0<Unit> onMutualGuildsItemClick, Function0<Unit> onMutualFriendsItemClick) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        Intrinsics3.checkNotNullParameter(onConnectedAccountClick, "onConnectedAccountClick");
        Intrinsics3.checkNotNullParameter(onMutualGuildsItemClick, "onMutualGuildsItemClick");
        Intrinsics3.checkNotNullParameter(onMutualFriendsItemClick, "onMutualFriendsItemClick");
        this.connectedAccountsAdapter.setOnConnectedAccountClick(new AnonymousClass1(onConnectedAccountClick));
        this.connectedAccountsAdapter.setData(viewState.getConnectedAccountItems());
        this.binding.c.setOnClickListener(new AnonymousClass2(onMutualGuildsItemClick));
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userProfileConnectionsMutualGuildsItem");
        textView.setVisibility(viewState.getShowMutualGuildsAndFriends() ? 0 : 8);
        this.binding.f2164b.setOnClickListener(new AnonymousClass3(onMutualFriendsItemClick));
        TextView textView2 = this.binding.f2164b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.userProfileConnectionsMutualFriendsItem");
        textView2.setVisibility(viewState.getShowMutualGuildsAndFriends() ? 0 : 8);
    }
}
