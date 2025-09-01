package com.discord.widgets.channels;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.SimpleRoleListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SimpleRolesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0010\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0010\u0010\u0011R&\u0010\u000f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/channels/SimpleRolesAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/channels/SimpleRolesAdapter$RoleItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/channels/SimpleRolesAdapter$RoleAdapterItem;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/channels/SimpleRolesAdapter$RoleAdapterItem;", "", "data", "Lkotlin/Function1;", "Lcom/discord/api/role/GuildRole;", "", "onRoleClickedListener", "setData", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "RoleAdapterItem", "RoleItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SimpleRolesAdapter extends MGRecyclerAdapterSimple<RoleItem> {
    private Function1<? super GuildRole, Unit> onRoleClickedListener;

    /* compiled from: SimpleRolesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/SimpleRolesAdapter$RoleAdapterItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/SimpleRolesAdapter;", "Lcom/discord/widgets/channels/SimpleRolesAdapter$RoleItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/SimpleRolesAdapter$RoleItem;)V", "Lcom/discord/databinding/SimpleRoleListItemBinding;", "binding", "Lcom/discord/databinding/SimpleRoleListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/channels/SimpleRolesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class RoleAdapterItem extends MGRecyclerViewHolder<SimpleRolesAdapter, RoleItem> {
        private final SimpleRoleListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleAdapterItem(SimpleRolesAdapter simpleRolesAdapter) {
            super(R.layout.simple_role_list_item, simpleRolesAdapter);
            Intrinsics3.checkNotNullParameter(simpleRolesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            SimpleRoleListItemBinding simpleRoleListItemBinding = new SimpleRoleListItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(simpleRoleListItemBinding, "SimpleRoleListItemBinding.bind(itemView)");
            this.binding = simpleRoleListItemBinding;
        }

        public static final /* synthetic */ SimpleRolesAdapter access$getAdapter$p(RoleAdapterItem roleAdapterItem) {
            return (SimpleRolesAdapter) roleAdapterItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, RoleItem roleItem) {
            onConfigure2(i, roleItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, RoleItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.f2143b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsRoleItemName");
            textView.setText(data.getRole().getName());
            this.binding.a.setOnClickListener(new SimpleRolesAdapter2(this, data));
            TextView textView2 = this.binding.f2143b;
            GuildRole role = data.getRole();
            TextView textView3 = this.binding.f2143b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsRoleItemName");
            Context context = textView3.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.serverSettingsRoleItemName.context");
            textView2.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
        }
    }

    /* compiled from: SimpleRolesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000  2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001 B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u001c\u0010\u0018\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001b\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000f¨\u0006!"}, d2 = {"Lcom/discord/widgets/channels/SimpleRolesAdapter$RoleItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", "other", "", "compareTo", "(Lcom/discord/widgets/channels/SimpleRolesAdapter$RoleItem;)I", "Lcom/discord/api/role/GuildRole;", "component1", "()Lcom/discord/api/role/GuildRole;", "role", "copy", "(Lcom/discord/api/role/GuildRole;)Lcom/discord/widgets/channels/SimpleRolesAdapter$RoleItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/role/GuildRole;", "getRole", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/api/role/GuildRole;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class RoleItem implements MGRecyclerDataPayload, Comparable<RoleItem> {
        public static final int TYPE_ROLE = 0;
        private final String key;
        private final GuildRole role;
        private final int type;

        public RoleItem(GuildRole guildRole) {
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.role = guildRole;
            this.key = String.valueOf(guildRole.getId());
        }

        public static /* synthetic */ RoleItem copy$default(RoleItem roleItem, GuildRole guildRole, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRole = roleItem.role;
            }
            return roleItem.copy(guildRole);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(RoleItem roleItem) {
            return compareTo2(roleItem);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final RoleItem copy(GuildRole role) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new RoleItem(role);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof RoleItem) && Intrinsics3.areEqual(this.role, ((RoleItem) other).role);
            }
            return true;
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

        public int hashCode() {
            GuildRole guildRole = this.role;
            if (guildRole != null) {
                return guildRole.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RoleItem(role=");
            sbU.append(this.role);
            sbU.append(")");
            return sbU.toString();
        }

        /* renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(RoleItem other) {
            Intrinsics3.checkNotNullParameter(other, "other");
            return RoleUtils.getROLE_COMPARATOR().compare(this.role, other.role);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function1 access$getOnRoleClickedListener$p(SimpleRolesAdapter simpleRolesAdapter) {
        return simpleRolesAdapter.onRoleClickedListener;
    }

    public static final /* synthetic */ void access$setOnRoleClickedListener$p(SimpleRolesAdapter simpleRolesAdapter, Function1 function1) {
        simpleRolesAdapter.onRoleClickedListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<RoleItem> data, Function1<? super GuildRole, Unit> onRoleClickedListener) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(onRoleClickedListener, "onRoleClickedListener");
        super.setData(data);
        this.onRoleClickedListener = onRoleClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RoleAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new RoleAdapterItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
