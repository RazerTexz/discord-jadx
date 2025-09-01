package com.discord.widgets.servers.settings.members;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetServerSettingsMemberListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.roles.RolesListView;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsMembersAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2&\u0010\u0012\u001a\"\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\rj\u0002`\u00100\u000f\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0004\b\u0013\u0010\u0014R6\u0010\u0012\u001a\"\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u000e\u0012\f\u0012\b\u0012\u00060\rj\u0002`\u00100\u000f\u0012\u0004\u0012\u00020\u00110\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersAdapter$MemberListItem;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersAdapter$MemberListItem;", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;", "model", "Lkotlin/Function2;", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RoleId;", "", "memberSelectedListener", "configure", "(Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "MemberListItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersAdapter extends MGRecyclerAdapterSimple<WidgetServerSettingsMembersModel.MemberItem> {
    private Function2<? super Long, ? super List<Long>, Unit> memberSelectedListener;

    /* compiled from: WidgetServerSettingsMembersAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersAdapter$MemberListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersAdapter;", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel$MemberItem;)V", "Lcom/discord/databinding/WidgetServerSettingsMemberListItemBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsMemberListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MemberListItem extends MGRecyclerViewHolder<WidgetServerSettingsMembersAdapter, WidgetServerSettingsMembersModel.MemberItem> {
        private final WidgetServerSettingsMemberListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberListItem(WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter) {
            super(R.layout.widget_server_settings_member_list_item, widgetServerSettingsMembersAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsMembersAdapter, "adapter");
            View view = this.itemView;
            FrameLayout frameLayout = (FrameLayout) view;
            int i = R.id.member_list_item_lock;
            ImageView imageView = (ImageView) view.findViewById(R.id.member_list_item_lock);
            if (imageView != null) {
                i = R.id.member_list_item_overflow;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.member_list_item_overflow);
                if (imageView2 != null) {
                    i = R.id.member_list_item_roles_list;
                    RolesListView rolesListView = (RolesListView) view.findViewById(R.id.member_list_item_roles_list);
                    if (rolesListView != null) {
                        i = R.id.settings_member_view;
                        SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R.id.settings_member_view);
                        if (settingsMemberView != null) {
                            WidgetServerSettingsMemberListItemBinding widgetServerSettingsMemberListItemBinding = new WidgetServerSettingsMemberListItemBinding((FrameLayout) view, frameLayout, imageView, imageView2, rolesListView, settingsMemberView);
                            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsMemberListItemBinding, "WidgetServerSettingsMemb…temBinding.bind(itemView)");
                            this.binding = widgetServerSettingsMemberListItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetServerSettingsMembersAdapter access$getAdapter$p(MemberListItem memberListItem) {
            return (WidgetServerSettingsMembersAdapter) memberListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsMembersModel.MemberItem memberItem) {
            onConfigure2(i, memberItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetServerSettingsMembersModel.MemberItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.binding.f.a(data.getUser(), data.getGuildMember());
            RolesListView rolesListView = this.binding.e;
            List<GuildRole> roles = data.getRoles();
            RolesListView rolesListView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(rolesListView2, "binding.memberListItemRolesList");
            rolesListView.updateView(roles, ColorCompat.getColor(rolesListView2, R.color.status_grey_500), data.getGuildMember().getGuildId());
            RolesListView rolesListView3 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(rolesListView3, "binding.memberListItemRolesList");
            rolesListView3.setVisibility(data.getRoles().isEmpty() ^ true ? 0 : 8);
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.memberListItemLock");
            imageView.setVisibility(data.isManagable() ^ true ? 0 : 8);
            ImageView imageView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.memberListItemOverflow");
            imageView2.setVisibility(data.isManagable() ? 0 : 8);
            this.binding.f2578b.setOnClickListener(new WidgetServerSettingsMembersAdapter2(this, data));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsMembersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.memberSelectedListener = WidgetServerSettingsMembersAdapter3.INSTANCE;
    }

    public static final /* synthetic */ Function2 access$getMemberSelectedListener$p(WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter) {
        return widgetServerSettingsMembersAdapter.memberSelectedListener;
    }

    public static final /* synthetic */ void access$setMemberSelectedListener$p(WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter, Function2 function2) {
        widgetServerSettingsMembersAdapter.memberSelectedListener = function2;
    }

    public final void configure(WidgetServerSettingsMembersModel model, Function2<? super Long, ? super List<Long>, Unit> memberSelectedListener) {
        Intrinsics3.checkNotNullParameter(model, "model");
        Intrinsics3.checkNotNullParameter(memberSelectedListener, "memberSelectedListener");
        this.memberSelectedListener = memberSelectedListener;
        setData(model.getMemberItems());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MemberListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new MemberListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
