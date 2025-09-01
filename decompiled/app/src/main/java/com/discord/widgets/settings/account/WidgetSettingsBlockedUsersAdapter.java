package com.discord.widgets.settings.account;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsItemBlockedUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsBlockedUsersAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function1;", "Lcom/discord/models/user/User;", "", "onClickUnblock", "Lkotlin/jvm/functions/Function1;", "getOnClickUnblock", "()Lkotlin/jvm/functions/Function1;", "setOnClickUnblock", "(Lkotlin/jvm/functions/Function1;)V", "onClickUserProfile", "getOnClickUserProfile", "setOnClickUserProfile", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "BlockedUserViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter extends MGRecyclerAdapterSimple<WidgetSettingsBlockedUsersViewModel.Item> {
    private Function1<? super User, Unit> onClickUnblock;
    private Function1<? super User, Unit> onClickUserProfile;

    /* compiled from: WidgetSettingsBlockedUsersAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\b\b\u0001\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersAdapter;", "Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Item;)V", "Lcom/discord/databinding/WidgetSettingsItemBlockedUserBinding;", "binding", "Lcom/discord/databinding/WidgetSettingsItemBlockedUserBinding;", "layout", "adapter", "<init>", "(ILcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class BlockedUserViewHolder extends MGRecyclerViewHolder<WidgetSettingsBlockedUsersAdapter, WidgetSettingsBlockedUsersViewModel.Item> {
        private final WidgetSettingsItemBlockedUserBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BlockedUserViewHolder(@LayoutRes int i, WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter) {
            super(i, widgetSettingsBlockedUsersAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsBlockedUsersAdapter, "adapter");
            View view = this.itemView;
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i2 = R.id.blocked_user_item_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.blocked_user_item_avatar);
            if (simpleDraweeView != null) {
                i2 = R.id.blocked_user_item_name;
                TextView textView = (TextView) view.findViewById(R.id.blocked_user_item_name);
                if (textView != null) {
                    i2 = R.id.unblock_user_button;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.unblock_user_button);
                    if (materialButton != null) {
                        WidgetSettingsItemBlockedUserBinding widgetSettingsItemBlockedUserBinding = new WidgetSettingsItemBlockedUserBinding((RelativeLayout) view, relativeLayout, simpleDraweeView, textView, materialButton);
                        Intrinsics3.checkNotNullExpressionValue(widgetSettingsItemBlockedUserBinding, "WidgetSettingsItemBlocke…serBinding.bind(itemView)");
                        this.binding = widgetSettingsItemBlockedUserBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ WidgetSettingsBlockedUsersAdapter access$getAdapter$p(BlockedUserViewHolder blockedUserViewHolder) {
            return (WidgetSettingsBlockedUsersAdapter) blockedUserViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsBlockedUsersViewModel.Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetSettingsBlockedUsersViewModel.Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.binding.a.setOnClickListener(new WidgetSettingsBlockedUsersAdapter2(this, data));
            SimpleDraweeView simpleDraweeView = this.binding.f2625b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.blockedUserItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getUser(), R.dimen.avatar_size_standard, null, null, null, 56, null);
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.blockedUserItemName");
            textView.setText(data.getUser().getUsername());
            this.binding.d.setOnClickListener(new WidgetSettingsBlockedUsersAdapter3(this, data));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsBlockedUsersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClickUnblock = WidgetSettingsBlockedUsersAdapter4.INSTANCE;
        this.onClickUserProfile = WidgetSettingsBlockedUsersAdapter5.INSTANCE;
    }

    public final Function1<User, Unit> getOnClickUnblock() {
        return this.onClickUnblock;
    }

    public final Function1<User, Unit> getOnClickUserProfile() {
        return this.onClickUserProfile;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickUnblock(Function1<? super User, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickUnblock = function1;
    }

    public final void setOnClickUserProfile(Function1<? super User, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickUserProfile = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetSettingsBlockedUsersAdapter, WidgetSettingsBlockedUsersViewModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new BlockedUserViewHolder(R.layout.widget_settings_item_blocked_user, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
