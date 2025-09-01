package com.discord.widgets.home;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetHomeModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 E2\u00020\u0001:\u0001EB_\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u000f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010 \u001a\u00020\f\u0012\u0006\u0010!\u001a\u00020\u000f¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0011J|\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b'\u0010\u000eJ\u001a\u0010)\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0007R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b.\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b2\u0010\u0015R\u0013\u00103\u001a\u00020\u000f8F@\u0006¢\u0006\u0006\u001a\u0004\b3\u0010\u0011R\u0019\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010 \u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b6\u0010\u000eR\u0013\u00107\u001a\u00020\u000f8F@\u0006¢\u0006\u0006\u001a\u0004\b7\u0010\u0011R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\b9\u0010\u000bR\u0019\u0010!\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00104\u001a\u0004\b:\u0010\u0011R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b;\u0010\u0007R\u0019\u0010\u001e\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b\u001e\u0010\u0011R\u001d\u0010>\u001a\u00060<j\u0002`=8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0019\u0010\u001c\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\bB\u0010\u000e¨\u0006F"}, d2 = {"Lcom/discord/widgets/home/WidgetHomeModel;", "", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "component1", "()Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "component3", "Lcom/discord/models/presence/Presence;", "component4", "()Lcom/discord/models/presence/Presence;", "", "component5", "()I", "", "component6", "()Z", "component7", "Lcom/discord/api/user/NsfwAllowance;", "component8", "()Lcom/discord/api/user/NsfwAllowance;", "component9", "component10", "selectedChannel", "selectedVoiceChannel", "parentChannel", "dmPresence", "unreadCount", "isFriend", "isCallConnected", "nsfwAllowed", "threadCount", "threadExperimentEnabled", "copy", "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/presence/Presence;IZZLcom/discord/api/user/NsfwAllowance;IZ)Lcom/discord/widgets/home/WidgetHomeModel;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "channel", "Lcom/discord/api/channel/Channel;", "getChannel", "getSelectedVoiceChannel", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "getSelectedChannel", "Lcom/discord/api/user/NsfwAllowance;", "getNsfwAllowed", "isNsfwUnConsented", "Z", "I", "getThreadCount", "isChannelNsfw", "Lcom/discord/models/presence/Presence;", "getDmPresence", "getThreadExperimentEnabled", "getParentChannel", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "getChannelId", "()J", "getUnreadCount", "<init>", "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/presence/Presence;IZZLcom/discord/api/user/NsfwAllowance;IZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class WidgetHomeModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel channel;
    private final long channelId;
    private final Presence dmPresence;
    private final boolean isCallConnected;
    private final boolean isFriend;
    private final NsfwAllowance nsfwAllowed;
    private final Channel parentChannel;
    private final StoreChannelsSelected.ResolvedSelectedChannel selectedChannel;
    private final Channel selectedVoiceChannel;
    private final int threadCount;
    private final boolean threadExperimentEnabled;
    private final int unreadCount;

    /* compiled from: WidgetHomeModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/home/WidgetHomeModel$Companion;", "", "Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "getParentChannelObservable", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "Lcom/discord/widgets/home/WidgetHomeModel;", "get", "()Lrx/Observable;", "", "getInitialized", "initialized", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<WidgetHomeModel> get() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableY = Observable.j(companion.getGuildSelected().observeSelectedGuildId(), companion.getChannelsSelected().observeResolvedSelectedChannel(), WidgetHomeModel2.INSTANCE).Y(WidgetHomeModel3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            )\n          }");
            Observable<WidgetHomeModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
            return observableR;
        }

        public final Observable<Boolean> getInitialized() {
            Observable<Boolean> observableQ = StoreStream.INSTANCE.isInitializedObservable().q(150L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableQ, "StoreStream\n          .i…0, TimeUnit.MILLISECONDS)");
            return observableQ;
        }

        public final Observable<Channel> getParentChannelObservable(Channel channel) {
            if (channel == null || ChannelUtils.H(channel)) {
                if ((channel != null ? Long.valueOf(channel.getParentId()) : null) != null) {
                    return StoreStream.INSTANCE.getChannels().observeChannel(channel.getParentId());
                }
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
            return scalarSynchronousObservable;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetHomeModel(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Channel channel, Channel channel2, Presence presence, int i, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, int i2, boolean z4) {
        Intrinsics3.checkNotNullParameter(resolvedSelectedChannel, "selectedChannel");
        this.selectedChannel = resolvedSelectedChannel;
        this.selectedVoiceChannel = channel;
        this.parentChannel = channel2;
        this.dmPresence = presence;
        this.unreadCount = i;
        this.isFriend = z2;
        this.isCallConnected = z3;
        this.nsfwAllowed = nsfwAllowance;
        this.threadCount = i2;
        this.threadExperimentEnabled = z4;
        this.channel = resolvedSelectedChannel.getMaybeChannel();
        Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
        this.channelId = maybeChannel != null ? maybeChannel.getId() : 0L;
    }

    public static /* synthetic */ WidgetHomeModel copy$default(WidgetHomeModel widgetHomeModel, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Channel channel, Channel channel2, Presence presence, int i, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, int i2, boolean z4, int i3, Object obj) {
        return widgetHomeModel.copy((i3 & 1) != 0 ? widgetHomeModel.selectedChannel : resolvedSelectedChannel, (i3 & 2) != 0 ? widgetHomeModel.selectedVoiceChannel : channel, (i3 & 4) != 0 ? widgetHomeModel.parentChannel : channel2, (i3 & 8) != 0 ? widgetHomeModel.dmPresence : presence, (i3 & 16) != 0 ? widgetHomeModel.unreadCount : i, (i3 & 32) != 0 ? widgetHomeModel.isFriend : z2, (i3 & 64) != 0 ? widgetHomeModel.isCallConnected : z3, (i3 & 128) != 0 ? widgetHomeModel.nsfwAllowed : nsfwAllowance, (i3 & 256) != 0 ? widgetHomeModel.threadCount : i2, (i3 & 512) != 0 ? widgetHomeModel.threadExperimentEnabled : z4);
    }

    /* renamed from: component1, reason: from getter */
    public final StoreChannelsSelected.ResolvedSelectedChannel getSelectedChannel() {
        return this.selectedChannel;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getThreadExperimentEnabled() {
        return this.threadExperimentEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    /* renamed from: component3, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* renamed from: component4, reason: from getter */
    public final Presence getDmPresence() {
        return this.dmPresence;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsCallConnected() {
        return this.isCallConnected;
    }

    /* renamed from: component8, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* renamed from: component9, reason: from getter */
    public final int getThreadCount() {
        return this.threadCount;
    }

    public final WidgetHomeModel copy(StoreChannelsSelected.ResolvedSelectedChannel selectedChannel, Channel selectedVoiceChannel, Channel parentChannel, Presence dmPresence, int unreadCount, boolean isFriend, boolean isCallConnected, NsfwAllowance nsfwAllowed, int threadCount, boolean threadExperimentEnabled) {
        Intrinsics3.checkNotNullParameter(selectedChannel, "selectedChannel");
        return new WidgetHomeModel(selectedChannel, selectedVoiceChannel, parentChannel, dmPresence, unreadCount, isFriend, isCallConnected, nsfwAllowed, threadCount, threadExperimentEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHomeModel)) {
            return false;
        }
        WidgetHomeModel widgetHomeModel = (WidgetHomeModel) other;
        return Intrinsics3.areEqual(this.selectedChannel, widgetHomeModel.selectedChannel) && Intrinsics3.areEqual(this.selectedVoiceChannel, widgetHomeModel.selectedVoiceChannel) && Intrinsics3.areEqual(this.parentChannel, widgetHomeModel.parentChannel) && Intrinsics3.areEqual(this.dmPresence, widgetHomeModel.dmPresence) && this.unreadCount == widgetHomeModel.unreadCount && this.isFriend == widgetHomeModel.isFriend && this.isCallConnected == widgetHomeModel.isCallConnected && Intrinsics3.areEqual(this.nsfwAllowed, widgetHomeModel.nsfwAllowed) && this.threadCount == widgetHomeModel.threadCount && this.threadExperimentEnabled == widgetHomeModel.threadExperimentEnabled;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Presence getDmPresence() {
        return this.dmPresence;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    public final StoreChannelsSelected.ResolvedSelectedChannel getSelectedChannel() {
        return this.selectedChannel;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final int getThreadCount() {
        return this.threadCount;
    }

    public final boolean getThreadExperimentEnabled() {
        return this.threadExperimentEnabled;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.selectedChannel;
        int iHashCode = (resolvedSelectedChannel != null ? resolvedSelectedChannel.hashCode() : 0) * 31;
        Channel channel = this.selectedVoiceChannel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.parentChannel;
        int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        Presence presence = this.dmPresence;
        int iHashCode4 = (((iHashCode3 + (presence != null ? presence.hashCode() : 0)) * 31) + this.unreadCount) * 31;
        boolean z2 = this.isFriend;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        boolean z3 = this.isCallConnected;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        int iHashCode5 = (((i4 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31) + this.threadCount) * 31;
        boolean z4 = this.threadExperimentEnabled;
        return iHashCode5 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isCallConnected() {
        return this.isCallConnected;
    }

    public final boolean isChannelNsfw() {
        Channel channel = this.channel;
        return channel != null && channel.getNsfw();
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public final boolean isNsfwUnConsented() {
        return (this.channel == null || StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(this.channel.getGuildId())) ? false : true;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetHomeModel(selectedChannel=");
        sbU.append(this.selectedChannel);
        sbU.append(", selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(", parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", dmPresence=");
        sbU.append(this.dmPresence);
        sbU.append(", unreadCount=");
        sbU.append(this.unreadCount);
        sbU.append(", isFriend=");
        sbU.append(this.isFriend);
        sbU.append(", isCallConnected=");
        sbU.append(this.isCallConnected);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", threadCount=");
        sbU.append(this.threadCount);
        sbU.append(", threadExperimentEnabled=");
        return outline.O(sbU, this.threadExperimentEnabled, ")");
    }
}
