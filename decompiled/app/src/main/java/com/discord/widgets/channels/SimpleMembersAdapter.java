package com.discord.widgets.channels;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.SimpleMemberListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.user.SettingsMemberView;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SimpleMembersAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0010\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/channels/SimpleMembersAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/channels/SimpleMembersAdapter$MemberItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/widgets/channels/SimpleMembersAdapter$MemberAdapterItem;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/channels/SimpleMembersAdapter$MemberAdapterItem;", "", "data", "Lkotlin/Function1;", "Lcom/discord/models/user/User;", "", "onUserClickedListener", "setData", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "MemberAdapterItem", "MemberItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SimpleMembersAdapter extends MGRecyclerAdapterSimple<MemberItem> {
    private Function1<? super User, Unit> onUserClickedListener;

    /* compiled from: SimpleMembersAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/SimpleMembersAdapter$MemberAdapterItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/SimpleMembersAdapter;", "Lcom/discord/widgets/channels/SimpleMembersAdapter$MemberItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/SimpleMembersAdapter$MemberItem;)V", "Lcom/discord/databinding/SimpleMemberListItemBinding;", "binding", "Lcom/discord/databinding/SimpleMemberListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/channels/SimpleMembersAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MemberAdapterItem extends MGRecyclerViewHolder<SimpleMembersAdapter, MemberItem> {
        private final SimpleMemberListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberAdapterItem(SimpleMembersAdapter simpleMembersAdapter) {
            super(R.layout.simple_member_list_item, simpleMembersAdapter);
            Intrinsics3.checkNotNullParameter(simpleMembersAdapter, "adapter");
            View view = this.itemView;
            SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R.id.member_view);
            if (settingsMemberView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.member_view)));
            }
            SimpleMemberListItemBinding simpleMemberListItemBinding = new SimpleMemberListItemBinding((FrameLayout) view, settingsMemberView);
            Intrinsics3.checkNotNullExpressionValue(simpleMemberListItemBinding, "SimpleMemberListItemBinding.bind(itemView)");
            this.binding = simpleMemberListItemBinding;
        }

        public static final /* synthetic */ SimpleMembersAdapter access$getAdapter$p(MemberAdapterItem memberAdapterItem) {
            return (SimpleMembersAdapter) memberAdapterItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MemberItem memberItem) {
            onConfigure2(i, memberItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MemberItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            User user = data.getUser();
            this.binding.f2142b.a(user, data.getGuildMember());
            this.binding.a.setOnClickListener(new SimpleMembersAdapter2(this, user));
        }
    }

    /* compiled from: SimpleMembersAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u001e\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0011¨\u0006$"}, d2 = {"Lcom/discord/widgets/channels/SimpleMembersAdapter$MemberItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component2", "()Lcom/discord/models/member/GuildMember;", "user", "guildMember", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)Lcom/discord/widgets/channels/SimpleMembersAdapter$MemberItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/user/User;", "getUser", "type", "I", "getType", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MemberItem implements MGRecyclerDataPayload {
        public static final int TYPE_MEMBER = 0;
        private final GuildMember guildMember;
        private final String key;
        private final int type;
        private final User user;

        public MemberItem(User user, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.guildMember = guildMember;
            this.key = String.valueOf(user.getId());
        }

        public static /* synthetic */ MemberItem copy$default(MemberItem memberItem, User user, GuildMember guildMember, int i, Object obj) {
            if ((i & 1) != 0) {
                user = memberItem.user;
            }
            if ((i & 2) != 0) {
                guildMember = memberItem.guildMember;
            }
            return memberItem.copy(user, guildMember);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final MemberItem copy(User user, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new MemberItem(user, guildMember);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberItem)) {
                return false;
            }
            MemberItem memberItem = (MemberItem) other;
            return Intrinsics3.areEqual(this.user, memberItem.user) && Intrinsics3.areEqual(this.guildMember, memberItem.guildMember);
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            GuildMember guildMember = this.guildMember;
            return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MemberItem(user=");
            sbU.append(this.user);
            sbU.append(", guildMember=");
            sbU.append(this.guildMember);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleMembersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function1 access$getOnUserClickedListener$p(SimpleMembersAdapter simpleMembersAdapter) {
        return simpleMembersAdapter.onUserClickedListener;
    }

    public static final /* synthetic */ void access$setOnUserClickedListener$p(SimpleMembersAdapter simpleMembersAdapter, Function1 function1) {
        simpleMembersAdapter.onUserClickedListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<MemberItem> data, Function1<? super User, Unit> onUserClickedListener) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(onUserClickedListener, "onUserClickedListener");
        super.setData(data);
        this.onUserClickedListener = onUserClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MemberAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new MemberAdapterItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
