package com.discord.widgets.servers.role_members;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsRoleMembers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMemberAdapterItem;", "adapterItem", "Lkotlin/Function2;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/models/user/User;", "", "removeMemberClickListener", "configureUI", "(Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMemberAdapterItem;Lkotlin/jvm/functions/Function2;)V", "Lcom/discord/databinding/RemovablePermissionOwnerViewBinding;", "binding", "Lcom/discord/databinding/RemovablePermissionOwnerViewBinding;", "<init>", "(Lcom/discord/databinding/RemovablePermissionOwnerViewBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers3 extends RecyclerView.ViewHolder {
    private final RemovablePermissionOwnerViewBinding binding;

    /* compiled from: WidgetServerSettingsRoleMembers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewHolder$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ServerSettingsRoleMemberAdapterItem $adapterItem;
        public final /* synthetic */ Function2 $removeMemberClickListener;

        public AnonymousClass1(Function2 function2, ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem) {
            this.$removeMemberClickListener = function2;
            this.$adapterItem = serverSettingsRoleMemberAdapterItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$removeMemberClickListener.invoke(this.$adapterItem.getGuildMember(), this.$adapterItem.getPermissionOwner().getUser());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers3(RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBinding) {
        super(removablePermissionOwnerViewBinding.a);
        Intrinsics3.checkNotNullParameter(removablePermissionOwnerViewBinding, "binding");
        this.binding = removablePermissionOwnerViewBinding;
    }

    public final void configureUI(ServerSettingsRoleMemberAdapterItem adapterItem, Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        Intrinsics3.checkNotNullParameter(adapterItem, "adapterItem");
        Intrinsics3.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.binding.f2138b.a(adapterItem.getPermissionOwner());
        this.binding.c.setOnClickListener(new AnonymousClass1(removeMemberClickListener, adapterItem));
    }
}
