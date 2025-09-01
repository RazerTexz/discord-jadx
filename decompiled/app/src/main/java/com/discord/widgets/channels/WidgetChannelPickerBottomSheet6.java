package com.discord.widgets.channels;

import android.os.Bundle;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment2;
import com.discord.api.channel.ChannelUtils;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.widgets.channels.WidgetChannelPickerAdapter;
import com.discord.widgets.channels.WidgetChannelPickerAdapter3;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheet;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChannelPickerBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/widgets/channels/WidgetChannelPickerBottomSheet$itemClickListener$1", "Lcom/discord/widgets/channels/WidgetchannelPickerAdapter$OnItemClickListener;", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;", "channelItem", "", "onChannelItemClick", "(Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;)V", "onCreateChannelClick", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$itemClickListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet6 implements WidgetChannelPickerAdapter3.OnItemClickListener {
    public final /* synthetic */ WidgetChannelPickerBottomSheet this$0;

    public WidgetChannelPickerBottomSheet6(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        this.this$0 = widgetChannelPickerBottomSheet;
    }

    @Override // com.discord.widgets.channels.WidgetChannelPickerAdapter3.OnItemClickListener
    public void onChannelItemClick(WidgetChannelPickerAdapter.ChannelItem channelItem) {
        Intrinsics3.checkNotNullParameter(channelItem, "channelItem");
        String string = WidgetChannelPickerBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
        WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = this.this$0;
        Intrinsics3.checkNotNullExpressionValue(string, "requestCode");
        Fragment2.setFragmentResult(widgetChannelPickerBottomSheet, string, Bundle2.bundleOf(Tuples.to("RESULT_EXTRA_CHANNEL_ID", Long.valueOf(channelItem.getChannel().getId())), Tuples.to("RESULT_EXTRA_CHANNEL_NAME", ChannelUtils.c(channelItem.getChannel())), Tuples.to("RESULT_EXTRA_CHANNEL_ICON_RES_ID", Integer.valueOf(GuildChannelIconUtils2.guildChannelIcon(channelItem.getChannel()))), Tuples.to("RESULT_EXTRA_SELECTION_TYPE", Integer.valueOf(WidgetChannelPickerBottomSheet.SelectionType.CHANNEL.ordinal()))));
        this.this$0.dismiss();
    }

    @Override // com.discord.widgets.channels.WidgetChannelPickerAdapter3.OnItemClickListener
    public void onCreateChannelClick() {
        String string = WidgetChannelPickerBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
        WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = this.this$0;
        Intrinsics3.checkNotNullExpressionValue(string, "requestCode");
        Bundle bundle = new Bundle();
        bundle.putInt("RESULT_EXTRA_SELECTION_TYPE", WidgetChannelPickerBottomSheet.SelectionType.CREATE_CHANNEL.ordinal());
        Fragment2.setFragmentResult(widgetChannelPickerBottomSheet, string, bundle);
        this.this$0.dismiss();
    }
}
