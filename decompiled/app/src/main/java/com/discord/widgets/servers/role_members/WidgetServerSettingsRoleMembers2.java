package com.discord.widgets.servers.role_members;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppComponent;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.recycler.DiffCreator;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetServerSettingsRoleMembers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\"\u001a\u00020!\u0012\u001a\b\u0002\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00020\u001e¢\u0006\u0004\b#\u0010$J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u00020\u000b2\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\u0015¢\u0006\u0004\b\u0019\u0010\u001aR(\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onBindViewHolder", "(Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewHolder;I)V", "getItemCount", "()I", "", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMemberAdapterItem;", "newItems", "setItems", "(Ljava/util/List;)V", "Lkotlin/Function2;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/models/user/User;", "removeMemberClickListener", "setRemoveMemberClickListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "items", "Ljava/util/List;", "Lcom/discord/utilities/recycler/DiffCreator;", "diffCreator", "Lcom/discord/utilities/recycler/DiffCreator;", "Lcom/discord/app/AppComponent;", "appComponent", "<init>", "(Lcom/discord/app/AppComponent;Lcom/discord/utilities/recycler/DiffCreator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersAdapter, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers2 extends RecyclerView.Adapter<WidgetServerSettingsRoleMembers3> {
    private final DiffCreator<List<ServerSettingsRoleMemberAdapterItem>, WidgetServerSettingsRoleMembers3> diffCreator;
    private List<ServerSettingsRoleMemberAdapterItem> items;
    private Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener;

    /* compiled from: WidgetServerSettingsRoleMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMemberAdapterItem;", "items", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersAdapter$setItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ServerSettingsRoleMemberAdapterItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ServerSettingsRoleMemberAdapterItem> list) {
            invoke2((List<ServerSettingsRoleMemberAdapterItem>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ServerSettingsRoleMemberAdapterItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            WidgetServerSettingsRoleMembers2.access$setItems$p(WidgetServerSettingsRoleMembers2.this, list);
        }
    }

    public /* synthetic */ WidgetServerSettingsRoleMembers2(AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(WidgetServerSettingsRoleMembers2 widgetServerSettingsRoleMembers2) {
        return widgetServerSettingsRoleMembers2.items;
    }

    public static final /* synthetic */ void access$setItems$p(WidgetServerSettingsRoleMembers2 widgetServerSettingsRoleMembers2, List list) {
        widgetServerSettingsRoleMembers2.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((WidgetServerSettingsRoleMembers3) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<ServerSettingsRoleMemberAdapterItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    public final void setRemoveMemberClickListener(Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        Intrinsics3.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.removeMemberClickListener = removeMemberClickListener;
    }

    public WidgetServerSettingsRoleMembers2(AppComponent appComponent, DiffCreator<List<ServerSettingsRoleMemberAdapterItem>, WidgetServerSettingsRoleMembers3> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    public void onBindViewHolder(WidgetServerSettingsRoleMembers3 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem = this.items.get(position);
        Function2<? super GuildMember, ? super User, Unit> function2 = this.removeMemberClickListener;
        if (function2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("removeMemberClickListener");
        }
        holder.configureUI(serverSettingsRoleMemberAdapterItem, function2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetServerSettingsRoleMembers3 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBindingA = RemovablePermissionOwnerViewBinding.a(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics3.checkNotNullExpressionValue(removablePermissionOwnerViewBindingA, "RemovablePermissionOwner…rent,\n        false\n    )");
        return new WidgetServerSettingsRoleMembers3(removablePermissionOwnerViewBindingA);
    }
}
