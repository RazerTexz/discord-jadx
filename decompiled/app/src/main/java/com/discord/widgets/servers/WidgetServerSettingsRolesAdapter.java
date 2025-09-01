package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetServerSettingsHelpItemBinding;
import com.discord.databinding.WidgetServerSettingsRoleItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import com.discord.utilities.mg_recycler.DragAndDropHelper;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.roles.RoleIconView;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetServerSettingsRolesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005$%&'(B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJO\u0010\u0013\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0016\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR.\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0004\u0012\u00020\u000e0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001f¨\u0006)"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter;", "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter;", "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", "roles", "Lkotlin/Function1;", "Lcom/discord/api/role/GuildRole;", "", "roleSelectedListener", "", "", "roleDropListener", "configure", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "newPositions", "onNewPositions", "(Ljava/util/Map;)V", "fromPosition", "toPosition", "", "isValidMove", "(II)Z", "computeChangedPositions", "()Ljava/util/Map;", "Lkotlin/jvm/functions/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Companion", "HelpItem", "RoleItem", "RoleListHelpItem", "RoleListItem", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter extends DragAndDropAdapter<DragAndDropAdapter.Payload> {
    public static final int TYPE_HELP = 0;
    public static final int TYPE_ROLE = 1;
    private Function1<? super Map<String, Integer>, Unit> roleDropListener;
    private Function1<? super GuildRole, Unit> roleSelectedListener;

    /* compiled from: WidgetServerSettingsRolesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u0019\u001a\u00020\u000b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter$HelpItem;", "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;", "", "getPosition", "()I", "", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter$HelpItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "J", "getGuildId", "key", "Ljava/lang/String;", "getKey", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class HelpItem implements DragAndDropAdapter.Payload {
        private final long guildId;
        private final String key = "key0";
        private final int type;

        public HelpItem(long j) {
            this.guildId = j;
        }

        public static /* synthetic */ HelpItem copy$default(HelpItem helpItem, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = helpItem.guildId;
            }
            return helpItem.copy(j);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final HelpItem copy(long guildId) {
            return new HelpItem(guildId);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof HelpItem) && this.guildId == ((HelpItem) other).guildId;
            }
            return true;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload
        public int getPosition() {
            return 0;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            return b.a(this.guildId);
        }

        public String toString() {
            return outline.C(outline.U("HelpItem(guildId="), this.guildId, ")");
        }
    }

    /* compiled from: WidgetServerSettingsRolesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter$RoleListHelpItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;", "Lcom/discord/utilities/mg_recycler/DragAndDropHelper$DraggableViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;)V", "", "dragging", "onDragStateChanged", "(Z)V", "canDrag", "()Z", "Lcom/discord/databinding/WidgetServerSettingsHelpItemBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsHelpItemBinding;", "Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class RoleListHelpItem extends MGRecyclerViewHolder<MGRecyclerAdapter<DragAndDropAdapter.Payload>, DragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final WidgetServerSettingsHelpItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleListHelpItem(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter) {
            super(R.layout.widget_server_settings_help_item, widgetServerSettingsRolesAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsRolesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view;
            WidgetServerSettingsHelpItemBinding widgetServerSettingsHelpItemBinding = new WidgetServerSettingsHelpItemBinding(linkifiedTextView, linkifiedTextView);
            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsHelpItemBinding, "WidgetServerSettingsHelpItemBinding.bind(itemView)");
            this.binding = widgetServerSettingsHelpItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        /* renamed from: canDrag */
        public boolean getCanDrag() {
            return false;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, DragAndDropAdapter.Payload payload) {
            onConfigure2(i, payload);
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public void onDragStateChanged(boolean dragging) {
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, DragAndDropAdapter.Payload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            LinkifiedTextView linkifiedTextView = this.binding.f2572b;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.serverSettingsHelpItem");
            FormatUtils.m(linkifiedTextView, R.string.help_roles_description, new Object[0], new WidgetServerSettingsRolesAdapter2(data));
        }
    }

    /* compiled from: WidgetServerSettingsRolesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter$RoleListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapter;", "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;", "Lcom/discord/utilities/mg_recycler/DragAndDropHelper$DraggableViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;)V", "", "dragging", "onDragStateChanged", "(Z)V", "canDrag", "()Z", "Z", "Lcom/discord/databinding/WidgetServerSettingsRoleItemBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsRoleItemBinding;", "Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class RoleListItem extends MGRecyclerViewHolder<MGRecyclerAdapter<DragAndDropAdapter.Payload>, DragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final WidgetServerSettingsRoleItemBinding binding;
        private boolean canDrag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleListItem(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter) {
            super(R.layout.widget_server_settings_role_item, widgetServerSettingsRolesAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsRolesAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.server_settings_role_item_bottom_divider;
            View viewFindViewById = view.findViewById(R.id.server_settings_role_item_bottom_divider);
            if (viewFindViewById != null) {
                i = R.id.server_settings_role_item_divider_targeted;
                View viewFindViewById2 = view.findViewById(R.id.server_settings_role_item_divider_targeted);
                if (viewFindViewById2 != null) {
                    i = R.id.server_settings_role_item_drag_overlay;
                    View viewFindViewById3 = view.findViewById(R.id.server_settings_role_item_drag_overlay);
                    if (viewFindViewById3 != null) {
                        i = R.id.server_settings_role_item_lock_indicator;
                        ImageView imageView = (ImageView) view.findViewById(R.id.server_settings_role_item_lock_indicator);
                        if (imageView != null) {
                            i = R.id.server_settings_role_item_name;
                            TextView textView = (TextView) view.findViewById(R.id.server_settings_role_item_name);
                            if (textView != null) {
                                i = R.id.server_settings_role_item_role_icon;
                                RoleIconView roleIconView = (RoleIconView) view.findViewById(R.id.server_settings_role_item_role_icon);
                                if (roleIconView != null) {
                                    WidgetServerSettingsRoleItemBinding widgetServerSettingsRoleItemBinding = new WidgetServerSettingsRoleItemBinding((RelativeLayout) view, viewFindViewById, viewFindViewById2, viewFindViewById3, imageView, textView, roleIconView);
                                    Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsRoleItemBinding, "WidgetServerSettingsRoleItemBinding.bind(itemView)");
                                    this.binding = widgetServerSettingsRoleItemBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ MGRecyclerAdapter access$getAdapter$p(RoleListItem roleListItem) {
            return roleListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        /* renamed from: canDrag, reason: from getter */
        public boolean getCanDrag() {
            return this.canDrag;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, DragAndDropAdapter.Payload payload) {
            onConfigure2(i, payload);
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public void onDragStateChanged(boolean dragging) {
            View view = this.binding.f2583b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.serverSettingsRoleItemDragOverlay");
            view.setVisibility(dragging ? 0 : 8);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, DragAndDropAdapter.Payload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            RoleItem roleItem = (RoleItem) data;
            this.canDrag = roleItem.canReorder();
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsRoleItemName");
            textView.setText(roleItem.getRole().getName());
            TextView textView2 = this.binding.d;
            GuildRole role = roleItem.getRole();
            RelativeLayout relativeLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.root");
            Context context = relativeLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            textView2.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
            this.binding.a.setOnClickListener(new WidgetServerSettingsRolesAdapter3(this, roleItem));
            if (roleItem.getEveryoneRole()) {
                RelativeLayout relativeLayout2 = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout2, WidgetServerSettingsRolesAdapter4.INSTANCE);
            } else if (!roleItem.getUserAbleToManageRoles()) {
                RelativeLayout relativeLayout3 = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout3, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout3, WidgetServerSettingsRolesAdapter5.INSTANCE);
            } else if (roleItem.getElevated()) {
                this.binding.a.setOnLongClickListener(null);
            } else {
                RelativeLayout relativeLayout4 = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout4, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout4, WidgetServerSettingsRolesAdapter6.INSTANCE);
            }
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.serverSettingsRoleItemLockIndicator");
            imageView.setVisibility(roleItem.getLocked() ? 0 : 8);
            this.binding.e.setRole(roleItem.getRole(), Long.valueOf(roleItem.getGuildId()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.roleSelectedListener = WidgetServerSettingsRolesAdapter8.INSTANCE;
        this.roleDropListener = WidgetServerSettingsRolesAdapter7.INSTANCE;
    }

    public static final /* synthetic */ Function1 access$getRoleSelectedListener$p(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter) {
        return widgetServerSettingsRolesAdapter.roleSelectedListener;
    }

    public static final /* synthetic */ void access$setRoleSelectedListener$p(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter, Function1 function1) {
        widgetServerSettingsRolesAdapter.roleSelectedListener = function1;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public Map<String, Integer> computeChangedPositions() {
        HashMap map = new HashMap();
        int size = getDataCopy().size();
        for (int i = 0; i < size; i++) {
            DragAndDropAdapter.Payload payload = getDataCopy().get(i);
            if (payload.getType() == 1) {
                RoleItem roleItem = (RoleItem) payload;
                if (!roleItem.getEveryoneRole()) {
                    int i2 = (size - 1) - i;
                    Integer num = getOrigPositions().get(roleItem.getKey());
                    if (num == null || i2 != num.intValue()) {
                        map.put(roleItem.getKey(), Integer.valueOf(i2));
                    }
                }
            }
        }
        return map;
    }

    public final void configure(List<? extends DragAndDropAdapter.Payload> roles, Function1<? super GuildRole, Unit> roleSelectedListener, Function1<? super Map<String, Integer>, Unit> roleDropListener) {
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Intrinsics3.checkNotNullParameter(roleSelectedListener, "roleSelectedListener");
        Intrinsics3.checkNotNullParameter(roleDropListener, "roleDropListener");
        this.roleSelectedListener = roleSelectedListener;
        this.roleDropListener = roleDropListener;
        setData(roles);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public boolean isValidMove(int fromPosition, int toPosition) {
        int iCoerceAtMost = _Ranges.coerceAtMost(fromPosition, toPosition);
        int iCoerceAtLeast = _Ranges.coerceAtLeast(fromPosition, toPosition);
        if (iCoerceAtMost <= iCoerceAtLeast) {
            while (true) {
                DragAndDropAdapter.Payload payload = getDataCopy().get(iCoerceAtMost);
                if (payload.getType() != 1 || !((RoleItem) payload).canReorder()) {
                    return false;
                }
                if (iCoerceAtMost == iCoerceAtLeast) {
                    break;
                }
                iCoerceAtMost++;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public void onNewPositions(Map<String, Integer> newPositions) {
        Intrinsics3.checkNotNullParameter(newPositions, "newPositions");
        this.roleDropListener.invoke(newPositions);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, DragAndDropAdapter.Payload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new RoleListHelpItem(this);
        }
        if (viewType == 1) {
            return new RoleListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* compiled from: WidgetServerSettingsRolesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\n\u0010\u0018\u001a\u00060\u000fj\u0002`\u0010¢\u0006\u0004\b2\u00103J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0014\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JP\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\f\b\u0002\u0010\u0018\u001a\u00060\u000fj\u0002`\u0010HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u001a\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b%\u0010\u0007R\u001c\u0010&\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0004R\u001d\u0010\u0018\u001a\u00060\u000fj\u0002`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b*\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b,\u0010\nR\u001c\u0010-\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u001dR\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b0\u0010\u0007R\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b1\u0010\u0007¨\u00064"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter$RoleItem;", "Lcom/discord/utilities/mg_recycler/DragAndDropAdapter$Payload;", "", "getPosition", "()I", "", "canReorder", "()Z", "Lcom/discord/api/role/GuildRole;", "component1", "()Lcom/discord/api/role/GuildRole;", "component2", "component3", "component4", "component5", "", "Lcom/discord/primitives/GuildId;", "component6", "()J", "role", "everyoneRole", ModelAuditLogEntry.CHANGE_KEY_LOCKED, "userAbleToManageRoles", "elevated", "guildId", "copy", "(Lcom/discord/api/role/GuildRole;ZZZZJ)Lcom/discord/widgets/servers/WidgetServerSettingsRolesAdapter$RoleItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getEveryoneRole", "getElevated", "type", "I", "getType", "J", "getGuildId", "Lcom/discord/api/role/GuildRole;", "getRole", "key", "Ljava/lang/String;", "getKey", "getLocked", "getUserAbleToManageRoles", "<init>", "(Lcom/discord/api/role/GuildRole;ZZZZJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class RoleItem implements DragAndDropAdapter.Payload {
        private final boolean elevated;
        private final boolean everyoneRole;
        private final long guildId;
        private final String key;
        private final boolean locked;
        private final GuildRole role;
        private final int type;
        private final boolean userAbleToManageRoles;

        public RoleItem(GuildRole guildRole, boolean z2, boolean z3, boolean z4, boolean z5, long j) {
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.role = guildRole;
            this.everyoneRole = z2;
            this.locked = z3;
            this.userAbleToManageRoles = z4;
            this.elevated = z5;
            this.guildId = j;
            this.key = String.valueOf(guildRole.getId());
            this.type = 1;
        }

        public static /* synthetic */ RoleItem copy$default(RoleItem roleItem, GuildRole guildRole, boolean z2, boolean z3, boolean z4, boolean z5, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRole = roleItem.role;
            }
            if ((i & 2) != 0) {
                z2 = roleItem.everyoneRole;
            }
            boolean z6 = z2;
            if ((i & 4) != 0) {
                z3 = roleItem.locked;
            }
            boolean z7 = z3;
            if ((i & 8) != 0) {
                z4 = roleItem.userAbleToManageRoles;
            }
            boolean z8 = z4;
            if ((i & 16) != 0) {
                z5 = roleItem.elevated;
            }
            boolean z9 = z5;
            if ((i & 32) != 0) {
                j = roleItem.guildId;
            }
            return roleItem.copy(guildRole, z6, z7, z8, z9, j);
        }

        public final boolean canReorder() {
            return !this.everyoneRole && !this.locked && this.userAbleToManageRoles && this.elevated;
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getEveryoneRole() {
            return this.everyoneRole;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getLocked() {
            return this.locked;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getUserAbleToManageRoles() {
            return this.userAbleToManageRoles;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getElevated() {
            return this.elevated;
        }

        /* renamed from: component6, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final RoleItem copy(GuildRole role, boolean everyoneRole, boolean locked, boolean userAbleToManageRoles, boolean elevated, long guildId) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new RoleItem(role, everyoneRole, locked, userAbleToManageRoles, elevated, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoleItem)) {
                return false;
            }
            RoleItem roleItem = (RoleItem) other;
            return Intrinsics3.areEqual(this.role, roleItem.role) && this.everyoneRole == roleItem.everyoneRole && this.locked == roleItem.locked && this.userAbleToManageRoles == roleItem.userAbleToManageRoles && this.elevated == roleItem.elevated && this.guildId == roleItem.guildId;
        }

        public final boolean getElevated() {
            return this.elevated;
        }

        public final boolean getEveryoneRole() {
            return this.everyoneRole;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final boolean getLocked() {
            return this.locked;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload
        public int getPosition() {
            return this.role.getPosition();
        }

        public final GuildRole getRole() {
            return this.role;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final boolean getUserAbleToManageRoles() {
            return this.userAbleToManageRoles;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            GuildRole guildRole = this.role;
            int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
            boolean z2 = this.everyoneRole;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.locked;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.userAbleToManageRoles;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.elevated;
            return b.a(this.guildId) + ((i6 + (z5 ? 1 : z5 ? 1 : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("RoleItem(role=");
            sbU.append(this.role);
            sbU.append(", everyoneRole=");
            sbU.append(this.everyoneRole);
            sbU.append(", locked=");
            sbU.append(this.locked);
            sbU.append(", userAbleToManageRoles=");
            sbU.append(this.userAbleToManageRoles);
            sbU.append(", elevated=");
            sbU.append(this.elevated);
            sbU.append(", guildId=");
            return outline.C(sbU, this.guildId, ")");
        }

        public /* synthetic */ RoleItem(GuildRole guildRole, boolean z2, boolean z3, boolean z4, boolean z5, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(guildRole, z2, (i & 4) != 0 ? false : z3, z4, z5, j);
        }
    }
}
