package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheetViewModel;
import d0.t._Collections;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheetViewModel2 extends Lambda implements Function0<WidgetChannelPickerBottomSheetViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ boolean $hideAnnouncementChannels;
    public final /* synthetic */ StoreChannels $storeChannels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheetViewModel2(StoreChannels storeChannels, long j, boolean z2) {
        super(0);
        this.$storeChannels = storeChannels;
        this.$guildId = j;
        this.$hideAnnouncementChannels = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelPickerBottomSheetViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelPickerBottomSheetViewModel.StoreState invoke() {
        Map<Long, Channel> channelsForGuild = this.$storeChannels.getChannelsForGuild(this.$guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Channel> entry : channelsForGuild.entrySet()) {
            Channel value = entry.getValue();
            boolean z2 = false;
            if (!ChannelUtils.k(value) && (!this.$hideAnnouncementChannels || !ChannelUtils.i(value))) {
                z2 = true;
            }
            if (z2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new WidgetChannelPickerBottomSheetViewModel.StoreState.Loaded(_Collections.toList(linkedHashMap.values()));
    }
}
