package com.discord.widgets.channels.memberlist.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ChannelMembersListViewHolderHeader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListViewHolderHeader;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$Header;", "data", "", "bind", "(Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$Header;)V", "Lcom/discord/databinding/WidgetChannelMembersListItemHeaderBinding;", "binding", "Lcom/discord/databinding/WidgetChannelMembersListItemHeaderBinding;", "<init>", "(Lcom/discord/databinding/WidgetChannelMembersListItemHeaderBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelMembersListViewHolderHeader extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemHeaderBinding binding;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ChannelMembersListAdapter.Item.Header.Type.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ChannelMembersListAdapter.Item.Header.Type.ONLINE.ordinal()] = 1;
            iArr[ChannelMembersListAdapter.Item.Header.Type.OFFLINE.ordinal()] = 2;
            iArr[ChannelMembersListAdapter.Item.Header.Type.GROUP_DM.ordinal()] = 3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderHeader(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding) {
        super(widgetChannelMembersListItemHeaderBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "binding");
        this.binding = widgetChannelMembersListItemHeaderBinding;
    }

    public final void bind(ChannelMembersListAdapter.Item.Header data) {
        int i;
        Intrinsics3.checkNotNullParameter(data, "data");
        int iOrdinal = data.getHeaderType().ordinal();
        if (iOrdinal == 0) {
            i = R.string.status_online;
        } else if (iOrdinal == 1) {
            i = R.string.status_offline;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.members;
        }
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelMembersListItemHeaderText");
        CharSequence text = textView.getContext().getText(i);
        Intrinsics3.checkNotNullExpressionValue(text, "binding.channelMembersLi….getText(statusTextResId)");
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelMembersListItemHeaderText");
        textView2.setText(text + " — " + data.getMemberCount());
    }
}
