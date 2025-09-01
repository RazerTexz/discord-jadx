package com.discord.widgets.channels;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChannelPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/ChannelPickerAdapterItem;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "<init>", "()V", "ChannelItem", "CreateChannelItem", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem$CreateChannelItem;", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.ChannelPickerAdapterItem, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class WidgetChannelPickerAdapter implements DiffKeyProvider {

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "channel", "isSelected", "copy", "(Lcom/discord/api/channel/Channel;Z)Lcom/discord/widgets/channels/ChannelPickerAdapterItem$ChannelItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Z", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/api/channel/Channel;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.ChannelPickerAdapterItem$ChannelItem */
    public static final /* data */ class ChannelItem extends WidgetChannelPickerAdapter {
        private final Channel channel;
        private final boolean isSelected;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel, boolean z2) {
            super(null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.isSelected = z2;
            this.key = String.valueOf(channel.getId());
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.isSelected;
            }
            return channelItem.copy(channel, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final ChannelItem copy(Channel channel, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return Intrinsics3.areEqual(this.channel, channelItem.channel) && this.isSelected == channelItem.isSelected;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.isSelected;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", isSelected=");
            return outline.O(sbU, this.isSelected, ")");
        }
    }

    /* compiled from: WidgetChannelPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/ChannelPickerAdapterItem$CreateChannelItem;", "Lcom/discord/widgets/channels/ChannelPickerAdapterItem;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.ChannelPickerAdapterItem$CreateChannelItem */
    public static final class CreateChannelItem extends WidgetChannelPickerAdapter {
        public static final CreateChannelItem INSTANCE = new CreateChannelItem();
        private static final String key = "channel-picker-create-channel-item";

        private CreateChannelItem() {
            super(null);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }
    }

    private WidgetChannelPickerAdapter() {
    }

    public /* synthetic */ WidgetChannelPickerAdapter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
