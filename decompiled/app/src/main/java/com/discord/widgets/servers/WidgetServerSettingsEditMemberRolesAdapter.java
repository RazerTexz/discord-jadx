package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.ViewCheckableRoleListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CheckedSetting;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0011\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0010\u001a\u0014\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter$RoleItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter$RoleListItem;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter$RoleListItem;", "", "roleItems", "Lkotlin/Function1;", "", "Lcom/discord/primitives/RoleId;", "", "roleClickListener", "configure", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "RoleItem", "RoleListItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditMemberRolesAdapter extends MGRecyclerAdapterSimple<RoleItem> {
    private Function1<? super Long, Unit> roleClickListener;

    /* compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter$RoleListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter;", "Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter$RoleItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter$RoleItem;)V", "Lcom/discord/databinding/ViewCheckableRoleListItemBinding;", "binding", "Lcom/discord/databinding/ViewCheckableRoleListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class RoleListItem extends MGRecyclerViewHolder<WidgetServerSettingsEditMemberRolesAdapter, RoleItem> {
        private final ViewCheckableRoleListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleListItem(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter) {
            super(R.layout.view_checkable_role_list_item, widgetServerSettingsEditMemberRolesAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsEditMemberRolesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            CheckedSetting checkedSetting = (CheckedSetting) view;
            ViewCheckableRoleListItemBinding viewCheckableRoleListItemBinding = new ViewCheckableRoleListItemBinding(checkedSetting, checkedSetting);
            Intrinsics3.checkNotNullExpressionValue(viewCheckableRoleListItemBinding, "ViewCheckableRoleListItemBinding.bind(itemView)");
            this.binding = viewCheckableRoleListItemBinding;
        }

        public static final /* synthetic */ WidgetServerSettingsEditMemberRolesAdapter access$getAdapter$p(RoleListItem roleListItem) {
            return (WidgetServerSettingsEditMemberRolesAdapter) roleListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, RoleItem roleItem) {
            onConfigure2(i, roleItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, RoleItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.binding.f2179b.setText(data.getRole().getName());
            CheckedSetting checkedSetting = this.binding.f2179b;
            GuildRole role = data.getRole();
            CheckedSetting checkedSetting2 = this.binding.f2179b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.roleItemCheckedSetting");
            Context context = checkedSetting2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.roleItemCheckedSetting.context");
            checkedSetting.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
            CheckedSetting checkedSetting3 = this.binding.f2179b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.roleItemCheckedSetting");
            checkedSetting3.setChecked(data.isUserHasRole());
            if (data.isManageable()) {
                this.binding.f2179b.e(new WidgetServerSettingsEditMemberRolesAdapter2(this, data));
            } else if (data.isRoleManaged()) {
                this.binding.f2179b.b(R.string.managed_role_explaination);
            } else {
                CheckedSetting.d(this.binding.f2179b, null, 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditMemberRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function1 access$getRoleClickListener$p(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter) {
        return widgetServerSettingsEditMemberRolesAdapter.roleClickListener;
    }

    public static final /* synthetic */ void access$setRoleClickListener$p(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter, Function1 function1) {
        widgetServerSettingsEditMemberRolesAdapter.roleClickListener = function1;
    }

    public final void configure(List<RoleItem> roleItems, Function1<? super Long, Unit> roleClickListener) {
        Intrinsics3.checkNotNullParameter(roleItems, "roleItems");
        Intrinsics3.checkNotNullParameter(roleClickListener, "roleClickListener");
        this.roleClickListener = roleClickListener;
        setData(roleItems);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RoleListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new RoleListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#B3\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00118\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0013\u0010\u001d\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u001f\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0010R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u000b\u0010\u0007¨\u0006*"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter$RoleItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/api/role/GuildRole;", "component1", "()Lcom/discord/api/role/GuildRole;", "", "component2", "()Z", "component3", "role", "isUserHasRole", "isManageable", "copy", "(Lcom/discord/api/role/GuildRole;ZZ)Lcom/discord/widgets/servers/WidgetServerSettingsEditMemberRolesAdapter$RoleItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "Lcom/discord/api/role/GuildRole;", "getRole", "isRoleManaged", "Z", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/api/role/GuildRole;ZZ)V", "userHasRole", "myHighestRole", "iAmOwner", "canManageRoles", "(Lcom/discord/api/role/GuildRole;ZLcom/discord/api/role/GuildRole;ZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class RoleItem implements MGRecyclerDataPayload {
        public static final int TYPE_ROLE = 1;
        private final boolean isManageable;
        private final boolean isUserHasRole;
        private final String key;
        private final GuildRole role;
        private final int type;

        public RoleItem(GuildRole guildRole, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.role = guildRole;
            this.isUserHasRole = z2;
            this.isManageable = z3;
            this.type = 1;
            this.key = String.valueOf(guildRole.getId());
        }

        public static /* synthetic */ RoleItem copy$default(RoleItem roleItem, GuildRole guildRole, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRole = roleItem.role;
            }
            if ((i & 2) != 0) {
                z2 = roleItem.isUserHasRole;
            }
            if ((i & 4) != 0) {
                z3 = roleItem.isManageable;
            }
            return roleItem.copy(guildRole, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsUserHasRole() {
            return this.isUserHasRole;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsManageable() {
            return this.isManageable;
        }

        public final RoleItem copy(GuildRole role, boolean isUserHasRole, boolean isManageable) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new RoleItem(role, isUserHasRole, isManageable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoleItem)) {
                return false;
            }
            RoleItem roleItem = (RoleItem) other;
            return Intrinsics3.areEqual(this.role, roleItem.role) && this.isUserHasRole == roleItem.isUserHasRole && this.isManageable == roleItem.isManageable;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            GuildRole guildRole = this.role;
            int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
            boolean z2 = this.isUserHasRole;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.isManageable;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isManageable() {
            return this.isManageable;
        }

        public final boolean isRoleManaged() {
            return this.role.getManaged();
        }

        public final boolean isUserHasRole() {
            return this.isUserHasRole;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RoleItem(role=");
            sbU.append(this.role);
            sbU.append(", isUserHasRole=");
            sbU.append(this.isUserHasRole);
            sbU.append(", isManageable=");
            return outline.O(sbU, this.isManageable, ")");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RoleItem(GuildRole guildRole, boolean z2, GuildRole guildRole2, boolean z3, boolean z4) {
            this(guildRole, z2, !guildRole.getManaged() && (z3 || RoleUtils.rankIsHigher(guildRole2, guildRole)) && z4);
            Intrinsics3.checkNotNullParameter(guildRole, "role");
        }
    }
}
