package com.discord.widgets.servers;

import a0.a.a.b;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppLog;
import com.discord.databinding.SettingsChannelListCategoryItemBinding;
import com.discord.databinding.SettingsChannelListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter;
import com.discord.utilities.mg_recycler.DragAndDropHelper;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action1;

/* compiled from: SettingsChannelListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006/012.3B\u0019\u0012\u0006\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010+\u001a\u00020\u001e¢\u0006\u0004\b,\u0010-J7\u0010\t\u001a\u00020\b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\b2\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u00030\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010 R4\u0010#\u001a\u0014\u0012\b\u0012\u00060\u0004j\u0002`\"\u0012\u0004\u0012\u00020\b\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u0010\u0013\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010$¨\u00064"}, d2 = {"Lcom/discord/widgets/servers/SettingsChannelListAdapter;", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter;", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "", "", "", "changedPositions", "changedParentIds", "", "handleChangedPositions", "(Ljava/util/Map;Ljava/util/Map;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lrx/functions/Action1;", "Lcom/discord/widgets/servers/SettingsChannelListAdapter$UpdatedPosition;", "onPositionUpdateListener", "setPositionUpdateListener", "(Lrx/functions/Action1;)V", "", "computeChangedPositions", "()Ljava/util/Map;", "newPositions", "onNewPositions", "(Ljava/util/Map;)V", "fromPosition", "toPosition", "", "isValidMove", "(II)Z", "Lkotlin/Function1;", "Lcom/discord/primitives/ChannelId;", "onClickListener", "Lkotlin/jvm/functions/Function1;", "getOnClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "isDraggable", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Z)V", "Companion", "CategoryItem", "CategoryListItem", "ChannelItem", "ChannelListItem", "UpdatedPosition", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SettingsChannelListAdapter extends CategoricalDragAndDropAdapter<CategoricalDragAndDropAdapter.Payload> {
    public static final int TYPE_CATEGORY = 1;
    public static final int TYPE_CHANNEL = 0;
    private Function1<? super Long, Unit> onClickListener;
    private Function1<? super Map<Long, UpdatedPosition>, Unit> onPositionUpdateListener;

    /* compiled from: SettingsChannelListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJN\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001a\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u001a\u0010\u001e\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010!\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\"R\u001c\u0010$\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\bR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b'\u0010\bR\u0019\u0010\u0016\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b(\u0010\u000fR\u0019\u0010\u0017\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010 \u001a\u0004\b)\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010\f¨\u0006."}, d2 = {"Lcom/discord/widgets/servers/SettingsChannelListAdapter$CategoryItem;", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "", "component3", "()I", "getPosition", "", "getCategory", "()Ljava/lang/String;", "component1", "", "component2", "()J", "", "component4", "()Z", "component5", "component6", ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_ID, "pos", "isDraggable", "canManageCategory", "canManageChannelsOfCategory", "copy", "(Ljava/lang/String;JIZZZ)Lcom/discord/widgets/servers/SettingsChannelListAdapter$CategoryItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "getName", "getCanManageCategory", "getCanManageChannelsOfCategory", "J", "getId", "<init>", "(Ljava/lang/String;JIZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CategoryItem implements CategoricalDragAndDropAdapter.Payload {
        private final boolean canManageCategory;
        private final boolean canManageChannelsOfCategory;
        private final long id;
        private final boolean isDraggable;
        private final String key;
        private final String name;
        private final int pos;
        private final int type = 1;

        public CategoryItem(String str, long j, int i, boolean z2, boolean z3, boolean z4) {
            this.name = str;
            this.id = j;
            this.pos = i;
            this.isDraggable = z2;
            this.canManageCategory = z3;
            this.canManageChannelsOfCategory = z4;
            this.key = String.valueOf(j);
        }

        /* renamed from: component3, reason: from getter */
        private final int getPos() {
            return this.pos;
        }

        public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, String str, long j, int i, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = categoryItem.name;
            }
            if ((i2 & 2) != 0) {
                j = categoryItem.id;
            }
            long j2 = j;
            if ((i2 & 4) != 0) {
                i = categoryItem.pos;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                z2 = categoryItem.isDraggable;
            }
            boolean z5 = z2;
            if ((i2 & 16) != 0) {
                z3 = categoryItem.canManageCategory;
            }
            boolean z6 = z3;
            if ((i2 & 32) != 0) {
                z4 = categoryItem.canManageChannelsOfCategory;
            }
            return categoryItem.copy(str, j2, i3, z5, z6, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsDraggable() {
            return this.isDraggable;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCanManageCategory() {
            return this.canManageCategory;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getCanManageChannelsOfCategory() {
            return this.canManageChannelsOfCategory;
        }

        public final CategoryItem copy(String name, long id2, int pos, boolean isDraggable, boolean canManageCategory, boolean canManageChannelsOfCategory) {
            return new CategoryItem(name, id2, pos, isDraggable, canManageCategory, canManageChannelsOfCategory);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CategoryItem)) {
                return false;
            }
            CategoryItem categoryItem = (CategoryItem) other;
            return Intrinsics3.areEqual(this.name, categoryItem.name) && this.id == categoryItem.id && this.pos == categoryItem.pos && this.isDraggable == categoryItem.isDraggable && this.canManageCategory == categoryItem.canManageCategory && this.canManageChannelsOfCategory == categoryItem.canManageChannelsOfCategory;
        }

        public final boolean getCanManageCategory() {
            return this.canManageCategory;
        }

        public final boolean getCanManageChannelsOfCategory() {
            return this.canManageChannelsOfCategory;
        }

        @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter.Payload
        public String getCategory() {
            return String.valueOf(getType());
        }

        public final long getId() {
            return this.id;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getName() {
            return this.name;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload
        public int getPosition() {
            return this.pos;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.name;
            int iA = (((b.a(this.id) + ((str != null ? str.hashCode() : 0) * 31)) * 31) + this.pos) * 31;
            boolean z2 = this.isDraggable;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iA + i) * 31;
            boolean z3 = this.canManageCategory;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.canManageChannelsOfCategory;
            return i4 + (z4 ? 1 : z4 ? 1 : 0);
        }

        public final boolean isDraggable() {
            return this.isDraggable;
        }

        public String toString() {
            StringBuilder sbU = outline.U("CategoryItem(name=");
            sbU.append(this.name);
            sbU.append(", id=");
            sbU.append(this.id);
            sbU.append(", pos=");
            sbU.append(this.pos);
            sbU.append(", isDraggable=");
            sbU.append(this.isDraggable);
            sbU.append(", canManageCategory=");
            sbU.append(this.canManageCategory);
            sbU.append(", canManageChannelsOfCategory=");
            return outline.O(sbU, this.canManageChannelsOfCategory, ")");
        }
    }

    /* compiled from: SettingsChannelListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/servers/SettingsChannelListAdapter$CategoryListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/SettingsChannelListAdapter;", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "Lcom/discord/utilities/mg_recycler/DragAndDropHelper$DraggableViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;)V", "", "dragging", "onDragStateChanged", "(Z)V", "canDrag", "()Z", "Lcom/discord/databinding/SettingsChannelListCategoryItemBinding;", "binding", "Lcom/discord/databinding/SettingsChannelListCategoryItemBinding;", "Lcom/discord/widgets/servers/SettingsChannelListAdapter$CategoryItem;", "categoryItem", "Lcom/discord/widgets/servers/SettingsChannelListAdapter$CategoryItem;", "adapter", "<init>", "(Lcom/discord/widgets/servers/SettingsChannelListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class CategoryListItem extends MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final SettingsChannelListCategoryItemBinding binding;
        private CategoryItem categoryItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryListItem(SettingsChannelListAdapter settingsChannelListAdapter) {
            super(R.layout.settings_channel_list_category_item, settingsChannelListAdapter);
            Intrinsics3.checkNotNullParameter(settingsChannelListAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.settings_channel_list_category_item_drag;
            ImageView imageView = (ImageView) view.findViewById(R.id.settings_channel_list_category_item_drag);
            if (imageView != null) {
                i = R.id.settings_channel_list_category_item_text;
                TextView textView = (TextView) view.findViewById(R.id.settings_channel_list_category_item_text);
                if (textView != null) {
                    SettingsChannelListCategoryItemBinding settingsChannelListCategoryItemBinding = new SettingsChannelListCategoryItemBinding((RelativeLayout) view, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(settingsChannelListCategoryItemBinding, "SettingsChannelListCateg…temBinding.bind(itemView)");
                    this.binding = settingsChannelListCategoryItemBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public boolean canDrag() {
            CategoryItem categoryItem = this.categoryItem;
            return categoryItem != null && categoryItem.isDraggable() && categoryItem.getCanManageCategory();
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, CategoricalDragAndDropAdapter.Payload payload) {
            onConfigure2(i, payload);
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public void onDragStateChanged(boolean dragging) {
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, CategoricalDragAndDropAdapter.Payload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            CategoryItem categoryItem = (CategoryItem) data;
            this.categoryItem = categoryItem;
            if (categoryItem != null) {
                Function1<Long, Unit> onClickListener = ((SettingsChannelListAdapter) this.adapter).getOnClickListener();
                if (onClickListener != null) {
                    this.itemView.setOnClickListener(new SettingsChannelListAdapter2(onClickListener, categoryItem, this));
                }
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsChannelListCategoryItemText");
                String name = categoryItem.getName();
                if (name == null) {
                    View view = this.itemView;
                    Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                    name = view.getContext().getString(R.string.uncategorized);
                }
                textView.setText(name);
                ImageView imageView = this.binding.f2140b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.settingsChannelListCategoryItemDrag");
                imageView.setVisibility(canDrag() ? 0 : 8);
            }
        }
    }

    /* compiled from: SettingsChannelListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ8\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010\rR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\u0013\u0010\rR\u001c\u0010#\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0010¨\u0006,"}, d2 = {"Lcom/discord/widgets/servers/SettingsChannelListAdapter$ChannelItem;", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "", "getPosition", "()I", "", "getCategory", "()Ljava/lang/String;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "", "component3", "()J", "component4", "channel", "isDraggable", "parentId", "canManageCategoryOfChannel", "copy", "(Lcom/discord/api/channel/Channel;ZJZ)Lcom/discord/widgets/servers/SettingsChannelListAdapter$ChannelItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "Z", "getCanManageCategoryOfChannel", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/api/channel/Channel;", "getChannel", "J", "getParentId", "<init>", "(Lcom/discord/api/channel/Channel;ZJZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelItem implements CategoricalDragAndDropAdapter.Payload {
        private final boolean canManageCategoryOfChannel;
        private final Channel channel;
        private final boolean isDraggable;
        private final String key;
        private final long parentId;
        private final int type;

        public ChannelItem(Channel channel, boolean z2, long j, boolean z3) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.isDraggable = z2;
            this.parentId = j;
            this.canManageCategoryOfChannel = z3;
            this.key = String.valueOf(channel.getId());
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, long j, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.isDraggable;
            }
            boolean z4 = z2;
            if ((i & 4) != 0) {
                j = channelItem.parentId;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                z3 = channelItem.canManageCategoryOfChannel;
            }
            return channelItem.copy(channel, z4, j2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsDraggable() {
            return this.isDraggable;
        }

        /* renamed from: component3, reason: from getter */
        public final long getParentId() {
            return this.parentId;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCanManageCategoryOfChannel() {
            return this.canManageCategoryOfChannel;
        }

        public final ChannelItem copy(Channel channel, boolean isDraggable, long parentId, boolean canManageCategoryOfChannel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel, isDraggable, parentId, canManageCategoryOfChannel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return Intrinsics3.areEqual(this.channel, channelItem.channel) && this.isDraggable == channelItem.isDraggable && this.parentId == channelItem.parentId && this.canManageCategoryOfChannel == channelItem.canManageCategoryOfChannel;
        }

        public final boolean getCanManageCategoryOfChannel() {
            return this.canManageCategoryOfChannel;
        }

        @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter.Payload
        public String getCategory() {
            return String.valueOf(getType());
        }

        public final Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final long getParentId() {
            return this.parentId;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload
        public int getPosition() {
            return this.channel.getPosition();
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.isDraggable;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int iA = (b.a(this.parentId) + ((iHashCode + i) * 31)) * 31;
            boolean z3 = this.canManageCategoryOfChannel;
            return iA + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isDraggable() {
            return this.isDraggable;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", isDraggable=");
            sbU.append(this.isDraggable);
            sbU.append(", parentId=");
            sbU.append(this.parentId);
            sbU.append(", canManageCategoryOfChannel=");
            return outline.O(sbU, this.canManageCategoryOfChannel, ")");
        }
    }

    /* compiled from: SettingsChannelListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/servers/SettingsChannelListAdapter$ChannelListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/SettingsChannelListAdapter;", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "Lcom/discord/utilities/mg_recycler/DragAndDropHelper$DraggableViewHolder;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;)V", "", "dragging", "onDragStateChanged", "(Z)V", "canDrag", "()Z", "Lcom/discord/widgets/servers/SettingsChannelListAdapter$ChannelItem;", "channelItem", "Lcom/discord/widgets/servers/SettingsChannelListAdapter$ChannelItem;", "Lcom/discord/databinding/SettingsChannelListItemBinding;", "binding", "Lcom/discord/databinding/SettingsChannelListItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/servers/SettingsChannelListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelListItem extends MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final SettingsChannelListItemBinding binding;
        private ChannelItem channelItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelListItem(SettingsChannelListAdapter settingsChannelListAdapter) {
            super(R.layout.settings_channel_list_item, settingsChannelListAdapter);
            Intrinsics3.checkNotNullParameter(settingsChannelListAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.settings_channel_list_item_drag;
            ImageView imageView = (ImageView) view.findViewById(R.id.settings_channel_list_item_drag);
            if (imageView != null) {
                i = R.id.settings_channel_list_item_hash;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.settings_channel_list_item_hash);
                if (imageView2 != null) {
                    i = R.id.settings_channel_list_item_name;
                    TextView textView = (TextView) view.findViewById(R.id.settings_channel_list_item_name);
                    if (textView != null) {
                        i = R.id.settings_channel_list_item_selected_overlay;
                        View viewFindViewById = view.findViewById(R.id.settings_channel_list_item_selected_overlay);
                        if (viewFindViewById != null) {
                            SettingsChannelListItemBinding settingsChannelListItemBinding = new SettingsChannelListItemBinding((RelativeLayout) view, imageView, imageView2, textView, viewFindViewById);
                            Intrinsics3.checkNotNullExpressionValue(settingsChannelListItemBinding, "SettingsChannelListItemBinding.bind(itemView)");
                            this.binding = settingsChannelListItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public boolean canDrag() {
            ChannelItem channelItem = this.channelItem;
            return channelItem != null && channelItem.isDraggable() && channelItem.getCanManageCategoryOfChannel();
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, CategoricalDragAndDropAdapter.Payload payload) {
            onConfigure2(i, payload);
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public void onDragStateChanged(boolean dragging) {
            View view = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.settingsChannelListItemSelectedOverlay");
            view.setVisibility(dragging ? 0 : 8);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, CategoricalDragAndDropAdapter.Payload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ChannelItem channelItem = (ChannelItem) data;
            this.channelItem = channelItem;
            if (channelItem != null) {
                this.itemView.setOnClickListener(null);
                Function1<Long, Unit> onClickListener = ((SettingsChannelListAdapter) this.adapter).getOnClickListener();
                if (onClickListener != null) {
                    this.itemView.setOnClickListener(new SettingsChannelListAdapter3(onClickListener, channelItem, this));
                }
                ImageView imageView = this.binding.c;
                int type = channelItem.getChannel().getType();
                imageView.setImageResource(type != 2 ? type != 5 ? type != 13 ? R.drawable.ic_channel_text : R.drawable.ic_channel_stage_24dp : R.drawable.ic_channel_announcements : R.drawable.ic_channel_voice);
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsChannelListItemName");
                textView.setText(ChannelUtils.c(channelItem.getChannel()));
                ImageView imageView2 = this.binding.f2141b;
                Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.settingsChannelListItemDrag");
                imageView2.setVisibility(canDrag() ? 0 : 8);
            }
        }
    }

    /* compiled from: SettingsChannelListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/servers/SettingsChannelListAdapter$UpdatedPosition;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/Long;", ModelAuditLogEntry.CHANGE_KEY_POSITION, "parentId", "copy", "(ILjava/lang/Long;)Lcom/discord/widgets/servers/SettingsChannelListAdapter$UpdatedPosition;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getParentId", "I", "getPosition", "<init>", "(ILjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UpdatedPosition {
        private final Long parentId;
        private final int position;

        public UpdatedPosition(int i, Long l) {
            this.position = i;
            this.parentId = l;
        }

        public static /* synthetic */ UpdatedPosition copy$default(UpdatedPosition updatedPosition, int i, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = updatedPosition.position;
            }
            if ((i2 & 2) != 0) {
                l = updatedPosition.parentId;
            }
            return updatedPosition.copy(i, l);
        }

        /* renamed from: component1, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getParentId() {
            return this.parentId;
        }

        public final UpdatedPosition copy(int position, Long parentId) {
            return new UpdatedPosition(position, parentId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedPosition)) {
                return false;
            }
            UpdatedPosition updatedPosition = (UpdatedPosition) other;
            return this.position == updatedPosition.position && Intrinsics3.areEqual(this.parentId, updatedPosition.parentId);
        }

        public final Long getParentId() {
            return this.parentId;
        }

        public final int getPosition() {
            return this.position;
        }

        public int hashCode() {
            int i = this.position * 31;
            Long l = this.parentId;
            return i + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("UpdatedPosition(position=");
            sbU.append(this.position);
            sbU.append(", parentId=");
            return outline.G(sbU, this.parentId, ")");
        }
    }

    /* compiled from: SettingsChannelListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "item", "", "invoke", "(Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;)Ljava/lang/Long;", "getChannelId"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$computeChangedPositions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<CategoricalDragAndDropAdapter.Payload, Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(CategoricalDragAndDropAdapter.Payload payload) {
            return invoke2(payload);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Long invoke2(CategoricalDragAndDropAdapter.Payload payload) {
            Intrinsics3.checkNotNullParameter(payload, "item");
            int type = payload.getType();
            if (type == 0) {
                return Long.valueOf(((ChannelItem) payload).getChannel().getId());
            }
            if (type == 1) {
                return Long.valueOf(((CategoryItem) payload).getId());
            }
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Invalid type: ");
            sbU.append(payload.getType());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
            return null;
        }
    }

    /* compiled from: SettingsChannelListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "(J)Ljava/lang/Long;", "positiveOrNull"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$computeChangedPositions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Long invoke(long j) {
            if (j > 0) {
                return Long.valueOf(j);
            }
            return null;
        }
    }

    /* compiled from: SettingsChannelListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "item", "", "invoke", "(Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;)Z", "getCanManageCategory"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$computeChangedPositions$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<CategoricalDragAndDropAdapter.Payload, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CategoricalDragAndDropAdapter.Payload payload) {
            return Boolean.valueOf(invoke2(payload));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CategoricalDragAndDropAdapter.Payload payload) {
            Intrinsics3.checkNotNullParameter(payload, "item");
            int type = payload.getType();
            if (type == 0) {
                return ((ChannelItem) payload).getCanManageCategoryOfChannel();
            }
            if (type != 1) {
                return false;
            }
            return ((CategoryItem) payload).getCanManageCategory();
        }
    }

    /* compiled from: SettingsChannelListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/widgets/servers/SettingsChannelListAdapter$UpdatedPosition;", "map", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.SettingsChannelListAdapter$setPositionUpdateListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map<Long, ? extends UpdatedPosition>, Unit> {
        public final /* synthetic */ Action1 $onPositionUpdateListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Action1 action1) {
            super(1);
            this.$onPositionUpdateListener = action1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends UpdatedPosition> map) {
            invoke2((Map<Long, UpdatedPosition>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, UpdatedPosition> map) {
            Intrinsics3.checkNotNullParameter(map, "map");
            this.$onPositionUpdateListener.call(map);
        }
    }

    public /* synthetic */ SettingsChannelListAdapter(RecyclerView recyclerView, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? true : z2);
    }

    private final void handleChangedPositions(Map<Long, Integer> changedPositions, Map<Long, Long> changedParentIds) {
        HashMap map = new HashMap();
        for (Map.Entry<Long, Integer> entry : changedPositions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            map.put(Long.valueOf(jLongValue), new UpdatedPosition(entry.getValue().intValue(), changedParentIds.get(Long.valueOf(jLongValue))));
        }
        Function1<? super Map<Long, UpdatedPosition>, Unit> function1 = this.onPositionUpdateListener;
        if (function1 != null) {
            function1.invoke(map);
        }
    }

    @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter, com.discord.utilities.mg_recycler.DragAndDropAdapter
    public Map<String, Integer> computeChangedPositions() {
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        AnonymousClass3 anonymousClass3 = AnonymousClass3.INSTANCE;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int i = 0;
        Long lInvoke = null;
        for (Object obj : getDataCopy()) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            CategoricalDragAndDropAdapter.Payload payload = (CategoricalDragAndDropAdapter.Payload) obj;
            Long lInvoke2 = AnonymousClass1.INSTANCE.invoke2(payload);
            long jLongValue = lInvoke2 != null ? lInvoke2.longValue() : 0L;
            if (payload.getType() == 1) {
                lInvoke = AnonymousClass2.INSTANCE.invoke(jLongValue);
            }
            Long lInvoke3 = payload.getType() != 0 ? null : AnonymousClass2.INSTANCE.invoke(((ChannelItem) payload).getParentId());
            Integer num = getOrigPositions().get(payload.getKey());
            if ((num == null || num.intValue() != i) && AnonymousClass3.INSTANCE.invoke2(payload)) {
                map.put(Long.valueOf(jLongValue), Integer.valueOf(i));
                if ((!Intrinsics3.areEqual(lInvoke3, lInvoke)) && payload.getType() == 0) {
                    map2.put(Long.valueOf(jLongValue), Long.valueOf(lInvoke != null ? lInvoke.longValue() : -1L));
                }
            }
            i = i2;
        }
        handleChangedPositions(map, map2);
        return Maps6.emptyMap();
    }

    public final Function1<Long, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter, com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public boolean isValidMove(int fromPosition, int toPosition) {
        if (toPosition <= 0) {
            return false;
        }
        CategoricalDragAndDropAdapter.Payload payload = (CategoricalDragAndDropAdapter.Payload) getItem(toPosition - 1);
        int type = payload.getType();
        if (type == 0) {
            return ((ChannelItem) payload).getCanManageCategoryOfChannel();
        }
        if (type != 1) {
            return false;
        }
        return ((CategoryItem) payload).getCanManageChannelsOfCategory();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public void onNewPositions(Map<String, Integer> newPositions) {
        Intrinsics3.checkNotNullParameter(newPositions, "newPositions");
    }

    public final void setOnClickListener(Function1<? super Long, Unit> function1) {
        this.onClickListener = function1;
    }

    public final void setPositionUpdateListener(Action1<Map<Long, UpdatedPosition>> onPositionUpdateListener) {
        Intrinsics3.checkNotNullParameter(onPositionUpdateListener, "onPositionUpdateListener");
        this.onPositionUpdateListener = new AnonymousClass1(onPositionUpdateListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsChannelListAdapter(RecyclerView recyclerView, boolean z2) {
        super(recyclerView);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        if (z2) {
            new ItemTouchHelper(new DragAndDropHelper(this, 0, 2, null)).attachToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter.Payload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ChannelListItem(this);
        }
        if (viewType == 1) {
            return new CategoryListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
