package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelMembersListViewHolderRoleHeader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListViewHolderRoleHeader;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$RoleHeader;", "data", "", "bind", "(Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$RoleHeader;)V", "Lcom/discord/databinding/WidgetChannelMembersListItemHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetChannelMembersListItemHeaderBinding;", "<init>", "(Lcom/discord/databinding/WidgetChannelMembersListItemHeaderBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelMembersListViewHolderRoleHeader extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemHeaderBinding binding;

    /* compiled from: ChannelMembersListViewHolderRoleHeader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/widgets/channels/memberlist/adapter/ChannelMembersListViewHolderRoleHeader$bind$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View;", "host", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "", "onInitializeAccessibilityNodeInfo", "(Landroid/view/View;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderRoleHeader$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics3.checkNotNullParameter(host, "host");
            Intrinsics3.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setHeading(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderRoleHeader(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding) {
        super(widgetChannelMembersListItemHeaderBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "binding");
        this.binding = widgetChannelMembersListItemHeaderBinding;
    }

    public final void bind(ChannelMembersListAdapter.Item.RoleHeader data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelMembersListItemHeaderText");
        textView.setText(data.getRoleName() + " — " + data.getMemberCount());
        this.binding.f2259b.setRole(Long.valueOf(data.getRoleId()), data.getGuildId());
        ViewCompat.setAccessibilityDelegate(this.binding.c, new AnonymousClass1());
    }
}
