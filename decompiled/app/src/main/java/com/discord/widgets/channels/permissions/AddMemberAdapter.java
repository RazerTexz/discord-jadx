package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.databinding.WidgetChannelSettingsAddMemberCategoryBinding;
import com.discord.databinding.WidgetChannelSettingsAddMemberItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.permissions.ChannelPermissionOwnerView;
import com.discord.widgets.channels.permissions.PermissionOwner;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AddMemberAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0010\u001a\u00020\r2 \u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e¢\u0006\u0004\b\u0010\u0010\u0011R0\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/channels/permissions/AddMemberAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function2;", "", "Lcom/discord/api/permission/PermissionOverwrite$Type;", "", "Lcom/discord/widgets/channels/permissions/OnClickListener;", "onClickListener", "setOnClickListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "AddMemberAdapterCategoryItem", "AddMemberAdapterItemItem", "Item", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AddMemberAdapter extends MGRecyclerAdapterSimple<Item> {
    private Function2<? super Long, ? super PermissionOverwrite.Type, Unit> onClickListener;

    /* compiled from: AddMemberAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/channels/permissions/AddMemberAdapter$AddMemberAdapterCategoryItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;)V", "Lcom/discord/databinding/WidgetChannelSettingsAddMemberCategoryBinding;", "binding", "Lcom/discord/databinding/WidgetChannelSettingsAddMemberCategoryBinding;", "adapter", "<init>", "(Lcom/discord/widgets/channels/permissions/AddMemberAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AddMemberAdapterCategoryItem extends MGRecyclerViewHolder<AddMemberAdapter, Item> {
        private final WidgetChannelSettingsAddMemberCategoryBinding binding;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                Item.CategoryItem.Companion.CategoryType.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[Item.CategoryItem.Companion.CategoryType.ROLE.ordinal()] = 1;
                iArr[Item.CategoryItem.Companion.CategoryType.MEMBER.ordinal()] = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddMemberAdapterCategoryItem(AddMemberAdapter addMemberAdapter) {
            super(R.layout.widget_channel_settings_add_member_category, addMemberAdapter);
            Intrinsics3.checkNotNullParameter(addMemberAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.label);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.label)));
            }
            WidgetChannelSettingsAddMemberCategoryBinding widgetChannelSettingsAddMemberCategoryBinding = new WidgetChannelSettingsAddMemberCategoryBinding((LinearLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsAddMemberCategoryBinding, "WidgetChannelSettingsAdd…oryBinding.bind(itemView)");
            this.binding = widgetChannelSettingsAddMemberCategoryBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            String string;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            TextView textView = this.binding.f2270b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.label");
            int iOrdinal = ((Item.CategoryItem) data).getCategoryType().ordinal();
            if (iOrdinal == 0) {
                string = ((AddMemberAdapter) this.adapter).getRecycler().getContext().getString(R.string.roles);
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                string = ((AddMemberAdapter) this.adapter).getRecycler().getContext().getString(R.string.members);
            }
            textView.setText(string);
        }
    }

    /* compiled from: AddMemberAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/channels/permissions/AddMemberAdapter$AddMemberAdapterItemItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem;", "item", "", "handleClick", "(Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem;)V", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "permissionOwner", "handleOnClickForPermissionOwner", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "onConfigure", "(ILcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;)V", "Lcom/discord/databinding/WidgetChannelSettingsAddMemberItemBinding;", "binding", "Lcom/discord/databinding/WidgetChannelSettingsAddMemberItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/channels/permissions/AddMemberAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AddMemberAdapterItemItem extends MGRecyclerViewHolder<AddMemberAdapter, Item> {
        private final WidgetChannelSettingsAddMemberItemBinding binding;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd.Reason.values();
                int[] iArr = new int[1];
                $EnumSwitchMapping$0 = iArr;
                iArr[Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd.Reason.HAS_GUILD_PERMISSIONS.ordinal()] = 1;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddMemberAdapterItemItem(AddMemberAdapter addMemberAdapter) {
            super(R.layout.widget_channel_settings_add_member_item, addMemberAdapter);
            Intrinsics3.checkNotNullParameter(addMemberAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.channel_permission_owner_view;
            ChannelPermissionOwnerView channelPermissionOwnerView = (ChannelPermissionOwnerView) view.findViewById(R.id.channel_permission_owner_view);
            if (channelPermissionOwnerView != null) {
                i = R.id.checkbox;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.checkbox);
                if (materialCheckBox != null) {
                    i = R.id.container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.container);
                    if (constraintLayout != null) {
                        WidgetChannelSettingsAddMemberItemBinding widgetChannelSettingsAddMemberItemBinding = new WidgetChannelSettingsAddMemberItemBinding((FrameLayout) view, channelPermissionOwnerView, materialCheckBox, constraintLayout);
                        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsAddMemberItemBinding, "WidgetChannelSettingsAdd…temBinding.bind(itemView)");
                        this.binding = widgetChannelSettingsAddMemberItemBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ void access$handleClick(AddMemberAdapterItemItem addMemberAdapterItemItem, Item.PermissionOwnerItem permissionOwnerItem) {
            addMemberAdapterItemItem.handleClick(permissionOwnerItem);
        }

        private final void handleClick(Item.PermissionOwnerItem item) {
            PermissionOwner permissionOwner = item.getPermissionOwner();
            Item.PermissionOwnerItem.Companion.AddStatus addStatus = item.getAddStatus();
            if (Intrinsics3.areEqual(addStatus, Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE)) {
                handleOnClickForPermissionOwner(permissionOwner);
            } else if ((addStatus instanceof Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd) && ((Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd) item.getAddStatus()).getReason().ordinal() == 0) {
                FrameLayout frameLayout = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
                Toast.makeText(frameLayout.getContext(), R.string.channel_permissions_add_has_guild_permissions, 0).show();
            }
        }

        private final void handleOnClickForPermissionOwner(PermissionOwner permissionOwner) {
            Function2 function2Access$getOnClickListener$p = AddMemberAdapter.access$getOnClickListener$p((AddMemberAdapter) this.adapter);
            if (function2Access$getOnClickListener$p != null) {
                if (permissionOwner instanceof PermissionOwner.Member) {
                    function2Access$getOnClickListener$p.invoke(Long.valueOf(((PermissionOwner.Member) permissionOwner).getUser().getId()), PermissionOverwrite.Type.MEMBER);
                } else if (permissionOwner instanceof PermissionOwner.Role) {
                    function2Access$getOnClickListener$p.invoke(Long.valueOf(((PermissionOwner.Role) permissionOwner).getRole().getId()), PermissionOverwrite.Type.ROLE);
                }
            }
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, Item item) {
            onConfigure2(i, item);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            Item.PermissionOwnerItem permissionOwnerItem = (Item.PermissionOwnerItem) data;
            this.binding.f2271b.a(permissionOwnerItem.getPermissionOwner());
            MaterialCheckBox materialCheckBox = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.checkbox");
            materialCheckBox.setChecked(permissionOwnerItem.getChecked());
            this.binding.c.setOnClickListener(new AddMemberAdapter2(this, permissionOwnerItem));
            this.binding.d.setOnClickListener(new AddMemberAdapter3(this, permissionOwnerItem));
            ConstraintLayout constraintLayout = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.container");
            ViewExtensions.setEnabledAlpha$default(constraintLayout, Intrinsics3.areEqual(permissionOwnerItem.getAddStatus(), Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE), 0.0f, 2, null);
        }
    }

    /* compiled from: AddMemberAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0005\u0004\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "<init>", "()V", "Companion", "CategoryItem", "PermissionOwnerItem", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$CategoryItem;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_CATEGORY = 0;
        public static final int TYPE_PERMISSION_OWNER = 1;

        /* compiled from: AddMemberAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0018\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$CategoryItem;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$CategoryItem$Companion$CategoryType;", "component1", "()Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$CategoryItem$Companion$CategoryType;", "categoryType", "copy", "(Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$CategoryItem$Companion$CategoryType;)Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$CategoryItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$CategoryItem$Companion$CategoryType;", "getCategoryType", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$CategoryItem$Companion$CategoryType;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class CategoryItem extends Item {
            private final Companion.CategoryType categoryType;
            private final String key;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CategoryItem(Companion.CategoryType categoryType) {
                super(null);
                Intrinsics3.checkNotNullParameter(categoryType, "categoryType");
                this.categoryType = categoryType;
                this.key = categoryType.toString();
            }

            public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, Companion.CategoryType categoryType, int i, Object obj) {
                if ((i & 1) != 0) {
                    categoryType = categoryItem.categoryType;
                }
                return categoryItem.copy(categoryType);
            }

            /* renamed from: component1, reason: from getter */
            public final Companion.CategoryType getCategoryType() {
                return this.categoryType;
            }

            public final CategoryItem copy(Companion.CategoryType categoryType) {
                Intrinsics3.checkNotNullParameter(categoryType, "categoryType");
                return new CategoryItem(categoryType);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CategoryItem) && Intrinsics3.areEqual(this.categoryType, ((CategoryItem) other).categoryType);
                }
                return true;
            }

            public final Companion.CategoryType getCategoryType() {
                return this.categoryType;
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
                Companion.CategoryType categoryType = this.categoryType;
                if (categoryType != null) {
                    return categoryType.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("CategoryItem(categoryType=");
                sbU.append(this.categoryType);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: AddMemberAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\u001e\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0012R\u001c\u0010!\u001a\u00020\u00138\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0015R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\n¨\u0006)"}, d2 = {"Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem;", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item;", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "component1", "()Lcom/discord/widgets/channels/permissions/PermissionOwner;", "", "component2", "()Z", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus;", "component3", "()Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus;", "permissionOwner", "checked", "addStatus", "copy", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;ZLcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus;)Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/channels/permissions/PermissionOwner;", "getPermissionOwner", "Z", "getChecked", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus;", "getAddStatus", "<init>", "(Lcom/discord/widgets/channels/permissions/PermissionOwner;ZLcom/discord/widgets/channels/permissions/AddMemberAdapter$Item$PermissionOwnerItem$Companion$AddStatus;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class PermissionOwnerItem extends Item {
            private final Companion.AddStatus addStatus;
            private final boolean checked;
            private final String key;
            private final PermissionOwner permissionOwner;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PermissionOwnerItem(PermissionOwner permissionOwner, boolean z2, Companion.AddStatus addStatus) {
                String strValueOf;
                super(null);
                Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
                Intrinsics3.checkNotNullParameter(addStatus, "addStatus");
                this.permissionOwner = permissionOwner;
                this.checked = z2;
                this.addStatus = addStatus;
                this.type = 1;
                if (permissionOwner instanceof PermissionOwner.Member) {
                    strValueOf = String.valueOf(((PermissionOwner.Member) permissionOwner).getUser().getId());
                } else {
                    if (!(permissionOwner instanceof PermissionOwner.Role)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strValueOf = String.valueOf(((PermissionOwner.Role) permissionOwner).getRole().getId());
                }
                this.key = strValueOf;
            }

            public static /* synthetic */ PermissionOwnerItem copy$default(PermissionOwnerItem permissionOwnerItem, PermissionOwner permissionOwner, boolean z2, Companion.AddStatus addStatus, int i, Object obj) {
                if ((i & 1) != 0) {
                    permissionOwner = permissionOwnerItem.permissionOwner;
                }
                if ((i & 2) != 0) {
                    z2 = permissionOwnerItem.checked;
                }
                if ((i & 4) != 0) {
                    addStatus = permissionOwnerItem.addStatus;
                }
                return permissionOwnerItem.copy(permissionOwner, z2, addStatus);
            }

            /* renamed from: component1, reason: from getter */
            public final PermissionOwner getPermissionOwner() {
                return this.permissionOwner;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getChecked() {
                return this.checked;
            }

            /* renamed from: component3, reason: from getter */
            public final Companion.AddStatus getAddStatus() {
                return this.addStatus;
            }

            public final PermissionOwnerItem copy(PermissionOwner permissionOwner, boolean checked, Companion.AddStatus addStatus) {
                Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
                Intrinsics3.checkNotNullParameter(addStatus, "addStatus");
                return new PermissionOwnerItem(permissionOwner, checked, addStatus);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PermissionOwnerItem)) {
                    return false;
                }
                PermissionOwnerItem permissionOwnerItem = (PermissionOwnerItem) other;
                return Intrinsics3.areEqual(this.permissionOwner, permissionOwnerItem.permissionOwner) && this.checked == permissionOwnerItem.checked && Intrinsics3.areEqual(this.addStatus, permissionOwnerItem.addStatus);
            }

            public final Companion.AddStatus getAddStatus() {
                return this.addStatus;
            }

            public final boolean getChecked() {
                return this.checked;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final PermissionOwner getPermissionOwner() {
                return this.permissionOwner;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                PermissionOwner permissionOwner = this.permissionOwner;
                int iHashCode = (permissionOwner != null ? permissionOwner.hashCode() : 0) * 31;
                boolean z2 = this.checked;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                Companion.AddStatus addStatus = this.addStatus;
                return i2 + (addStatus != null ? addStatus.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("PermissionOwnerItem(permissionOwner=");
                sbU.append(this.permissionOwner);
                sbU.append(", checked=");
                sbU.append(this.checked);
                sbU.append(", addStatus=");
                sbU.append(this.addStatus);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMemberAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public static final /* synthetic */ Function2 access$getOnClickListener$p(AddMemberAdapter addMemberAdapter) {
        return addMemberAdapter.onClickListener;
    }

    public static final /* synthetic */ void access$setOnClickListener$p(AddMemberAdapter addMemberAdapter, Function2 function2) {
        addMemberAdapter.onClickListener = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickListener(Function2<? super Long, ? super PermissionOverwrite.Type, Unit> onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<AddMemberAdapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new AddMemberAdapterCategoryItem(this);
        }
        if (viewType == 1) {
            return new AddMemberAdapterItemItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
