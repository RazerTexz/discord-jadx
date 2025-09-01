package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PermissionOwnerListView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B'\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0010\u0010\u0017J/\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwnerListView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Item;", "permissionOwners", "Lkotlin/Function1;", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "", "onRemoveClicked", "setData", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Adapter;", "adapter", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Adapter;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Adapter", "Item", "PermissionOwnerViewHolder", "RemoveStatus", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PermissionOwnerListView extends RecyclerView {
    private final Adapter adapter;

    /* compiled from: PermissionOwnerListView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R.\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001d¨\u0006 "}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$PermissionOwnerViewHolder;", "", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Item;", "data", "", "setData", "(Ljava/util/List;)V", "", "getItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$PermissionOwnerViewHolder;", "holder", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onBindViewHolder", "(Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$PermissionOwnerViewHolder;I)V", "Lkotlin/Function1;", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "onRemoveClicked", "Lkotlin/jvm/functions/Function1;", "getOnRemoveClicked", "()Lkotlin/jvm/functions/Function1;", "setOnRemoveClicked", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/List;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Adapter extends RecyclerView.Adapter<PermissionOwnerViewHolder> {
        private Function1<? super PermissionOwner, Unit> onRemoveClicked = PermissionOwnerListView3.INSTANCE;
        private List<Item> data = Collections2.emptyList();

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.data.size();
        }

        public final Function1<PermissionOwner, Unit> getOnRemoveClicked() {
            return this.onRemoveClicked;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            onBindViewHolder((PermissionOwnerViewHolder) viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void setData(List<Item> data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.data = data;
            notifyDataSetChanged();
        }

        public final void setOnRemoveClicked(Function1<? super PermissionOwner, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "<set-?>");
            this.onRemoveClicked = function1;
        }

        public void onBindViewHolder(PermissionOwnerViewHolder holder, int position) {
            Intrinsics3.checkNotNullParameter(holder, "holder");
            holder.configure(this.data.get(position), new PermissionOwnerListView2(this, this.data.get(position)));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public PermissionOwnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBindingA = RemovablePermissionOwnerViewBinding.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics3.checkNotNullExpressionValue(removablePermissionOwnerViewBindingA, "RemovablePermissionOwner…,\n          false\n      )");
            return new PermissionOwnerViewHolder(removablePermissionOwnerViewBindingA);
        }
    }

    /* compiled from: PermissionOwnerListView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Item;", "", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "component1", "()Lcom/discord/widgets/channels/permissions/PermissionOwner;", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "component2", "()Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "permissionOwner", "removeStatus", "copy", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;)Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Item;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "getPermissionOwner", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "getRemoveStatus", "<init>", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Item {
        private final PermissionOwner permissionOwner;
        private final RemoveStatus removeStatus;

        public Item(PermissionOwner permissionOwner, RemoveStatus removeStatus) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
            Intrinsics3.checkNotNullParameter(removeStatus, "removeStatus");
            this.permissionOwner = permissionOwner;
            this.removeStatus = removeStatus;
        }

        public static /* synthetic */ Item copy$default(Item item, PermissionOwner permissionOwner, RemoveStatus removeStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                permissionOwner = item.permissionOwner;
            }
            if ((i & 2) != 0) {
                removeStatus = item.removeStatus;
            }
            return item.copy(permissionOwner, removeStatus);
        }

        /* renamed from: component1, reason: from getter */
        public final PermissionOwner getPermissionOwner() {
            return this.permissionOwner;
        }

        /* renamed from: component2, reason: from getter */
        public final RemoveStatus getRemoveStatus() {
            return this.removeStatus;
        }

        public final Item copy(PermissionOwner permissionOwner, RemoveStatus removeStatus) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
            Intrinsics3.checkNotNullParameter(removeStatus, "removeStatus");
            return new Item(permissionOwner, removeStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return Intrinsics3.areEqual(this.permissionOwner, item.permissionOwner) && Intrinsics3.areEqual(this.removeStatus, item.removeStatus);
        }

        public final PermissionOwner getPermissionOwner() {
            return this.permissionOwner;
        }

        public final RemoveStatus getRemoveStatus() {
            return this.removeStatus;
        }

        public int hashCode() {
            PermissionOwner permissionOwner = this.permissionOwner;
            int iHashCode = (permissionOwner != null ? permissionOwner.hashCode() : 0) * 31;
            RemoveStatus removeStatus = this.removeStatus;
            return iHashCode + (removeStatus != null ? removeStatus.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Item(permissionOwner=");
            sbU.append(this.permissionOwner);
            sbU.append(", removeStatus=");
            sbU.append(this.removeStatus);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: PermissionOwnerListView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$PermissionOwnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Item;", "item", "Lkotlin/Function0;", "", "onRemoveClicked", "configure", "(Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$Item;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/databinding/RemovablePermissionOwnerViewBinding;", "binding", "Lcom/discord/databinding/RemovablePermissionOwnerViewBinding;", "<init>", "(Lcom/discord/databinding/RemovablePermissionOwnerViewBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PermissionOwnerViewHolder extends RecyclerView.ViewHolder {
        private final RemovablePermissionOwnerViewBinding binding;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                RemoveStatus.CannotRemove.Reason.values();
                int[] iArr = new int[4];
                $EnumSwitchMapping$0 = iArr;
                iArr[RemoveStatus.CannotRemove.Reason.IS_NOT_OVERRIDE.ordinal()] = 1;
                iArr[RemoveStatus.CannotRemove.Reason.HAS_NO_PERMISSION.ordinal()] = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionOwnerViewHolder(RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBinding) {
            super(removablePermissionOwnerViewBinding.a);
            Intrinsics3.checkNotNullParameter(removablePermissionOwnerViewBinding, "binding");
            this.binding = removablePermissionOwnerViewBinding;
        }

        public static final /* synthetic */ RemovablePermissionOwnerViewBinding access$getBinding$p(PermissionOwnerViewHolder permissionOwnerViewHolder) {
            return permissionOwnerViewHolder.binding;
        }

        public final void configure(Item item, Function0<Unit> onRemoveClicked) {
            Intrinsics3.checkNotNullParameter(item, "item");
            Intrinsics3.checkNotNullParameter(onRemoveClicked, "onRemoveClicked");
            this.binding.f2138b.a(item.getPermissionOwner());
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.remove");
            ViewExtensions.setEnabledAlpha$default(imageView, item.getRemoveStatus() instanceof RemoveStatus.CanRemove, 0.0f, 2, null);
            this.binding.c.setOnClickListener(new PermissionOwnerListView4(this, item, onRemoveClicked));
        }
    }

    /* compiled from: PermissionOwnerListView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "", "<init>", "()V", "CanRemove", "CannotRemove", "IsRemoving", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CanRemove;", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$IsRemoving;", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CannotRemove;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class RemoveStatus {

        /* compiled from: PermissionOwnerListView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CanRemove;", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class CanRemove extends RemoveStatus {
            public static final CanRemove INSTANCE = new CanRemove();

            private CanRemove() {
                super(null);
            }
        }

        /* compiled from: PermissionOwnerListView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CannotRemove;", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CannotRemove$Reason;", "component1", "()Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CannotRemove$Reason;", ModelAuditLogEntry.CHANGE_KEY_REASON, "copy", "(Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CannotRemove$Reason;)Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CannotRemove;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CannotRemove$Reason;", "getReason", "<init>", "(Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CannotRemove$Reason;)V", "Reason", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class CannotRemove extends RemoveStatus {
            private final Reason reason;

            /* compiled from: PermissionOwnerListView.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$CannotRemove$Reason;", "", "<init>", "(Ljava/lang/String;I)V", "IS_GUILD_OWNER", "IS_ADMINISTRATOR", "IS_NOT_OVERRIDE", "HAS_NO_PERMISSION", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public enum Reason {
                IS_GUILD_OWNER,
                IS_ADMINISTRATOR,
                IS_NOT_OVERRIDE,
                HAS_NO_PERMISSION
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CannotRemove(Reason reason) {
                super(null);
                Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
                this.reason = reason;
            }

            public static /* synthetic */ CannotRemove copy$default(CannotRemove cannotRemove, Reason reason, int i, Object obj) {
                if ((i & 1) != 0) {
                    reason = cannotRemove.reason;
                }
                return cannotRemove.copy(reason);
            }

            /* renamed from: component1, reason: from getter */
            public final Reason getReason() {
                return this.reason;
            }

            public final CannotRemove copy(Reason reason) {
                Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
                return new CannotRemove(reason);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CannotRemove) && Intrinsics3.areEqual(this.reason, ((CannotRemove) other).reason);
                }
                return true;
            }

            public final Reason getReason() {
                return this.reason;
            }

            public int hashCode() {
                Reason reason = this.reason;
                if (reason != null) {
                    return reason.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("CannotRemove(reason=");
                sbU.append(this.reason);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: PermissionOwnerListView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus$IsRemoving;", "Lcom/discord/widgets/channels/permissions/PermissionOwnerListView$RemoveStatus;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class IsRemoving extends RemoveStatus {
            public static final IsRemoving INSTANCE = new IsRemoving();

            private IsRemoving() {
                super(null);
            }
        }

        private RemoveStatus() {
        }

        public /* synthetic */ RemoveStatus(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        Adapter adapter = new Adapter();
        this.adapter = adapter;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setAdapter(adapter);
    }

    public final void setData(List<Item> permissionOwners, Function1<? super PermissionOwner, Unit> onRemoveClicked) {
        Intrinsics3.checkNotNullParameter(permissionOwners, "permissionOwners");
        Intrinsics3.checkNotNullParameter(onRemoveClicked, "onRemoveClicked");
        this.adapter.setOnRemoveClicked(onRemoveClicked);
        this.adapter.setData(permissionOwners);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Adapter adapter = new Adapter();
        this.adapter = adapter;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setAdapter(adapter);
    }

    public /* synthetic */ PermissionOwnerListView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwnerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Adapter adapter = new Adapter();
        this.adapter = adapter;
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        setAdapter(adapter);
    }

    public /* synthetic */ PermissionOwnerListView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
