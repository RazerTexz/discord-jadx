package com.discord.widgets.channels;

import a0.a.a.b;
import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetChannelSidebarActionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\f\r\u000eB\u0017\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;)V", "Lrx/Observable;", "storeStateObservable", "<init>", "(Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetChannelSidebarActionsViewModel.access$handleStoreState(WidgetChannelSidebarActionsViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$Companion;", "", "Lcom/discord/stores/StoreNavigation;", "storeNavigation", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreUserGuildSettings;", "storeUserGuildSettings", "Lcom/discord/stores/StoreGuildsNsfw;", "storeGuildNSFW", "Lcom/discord/stores/StoreUser;", "storeUser", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreNavigation;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreUserGuildSettings;Lcom/discord/stores/StoreGuildsNsfw;Lcom/discord/stores/StoreUser;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreNavigation storeNavigation, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreGuildsNsfw storeGuildNSFW, StoreUser storeUser) {
            Observable observableY = storeNavigation.observeRightPanelState().Y(new WidgetChannelSidebarActionsViewModel2(storeChannelsSelected, storeUserGuildSettings, storeUser, storeChannels, storeGuildNSFW));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeNavigation\n        …          }\n            }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreNavigation storeNavigation, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, int i, Object obj) {
            if ((i & 1) != 0) {
                storeNavigation = StoreStream.INSTANCE.getNavigation();
            }
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 4) != 0) {
                storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
            }
            StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
            if ((i & 8) != 0) {
                storeUserGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            }
            StoreUserGuildSettings storeUserGuildSettings2 = storeUserGuildSettings;
            if ((i & 16) != 0) {
                storeGuildsNsfw = StoreStream.INSTANCE.getGuildsNsfw();
            }
            StoreGuildsNsfw storeGuildsNsfw2 = storeGuildsNsfw;
            if ((i & 32) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            return companion.observeStoreState(storeNavigation, storeChannels2, storeChannelsSelected2, storeUserGuildSettings2, storeGuildsNsfw2, storeUser);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;", "", "<init>", "()V", "ChannelFound", "ChannelNotFound", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState$ChannelNotFound;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "component2", "Lcom/discord/models/domain/ModelNotificationSettings;", "component3", "()Lcom/discord/models/domain/ModelNotificationSettings;", "", "component4", "()Z", "channel", "parentChannel", "guildNotificationSettings", "disablePins", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings;Z)Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelNotificationSettings;", "getGuildNotificationSettings", "Lcom/discord/api/channel/Channel;", "getChannel", "Z", "getDisablePins", "getParentChannel", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ChannelFound extends StoreState {
            private final Channel channel;
            private final boolean disablePins;
            private final ModelNotificationSettings guildNotificationSettings;
            private final Channel parentChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChannelFound(Channel channel, Channel channel2, ModelNotificationSettings modelNotificationSettings, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.parentChannel = channel2;
                this.guildNotificationSettings = modelNotificationSettings;
                this.disablePins = z2;
            }

            public static /* synthetic */ ChannelFound copy$default(ChannelFound channelFound, Channel channel, Channel channel2, ModelNotificationSettings modelNotificationSettings, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = channelFound.channel;
                }
                if ((i & 2) != 0) {
                    channel2 = channelFound.parentChannel;
                }
                if ((i & 4) != 0) {
                    modelNotificationSettings = channelFound.guildNotificationSettings;
                }
                if ((i & 8) != 0) {
                    z2 = channelFound.disablePins;
                }
                return channelFound.copy(channel, channel2, modelNotificationSettings, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            /* renamed from: component3, reason: from getter */
            public final ModelNotificationSettings getGuildNotificationSettings() {
                return this.guildNotificationSettings;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getDisablePins() {
                return this.disablePins;
            }

            public final ChannelFound copy(Channel channel, Channel parentChannel, ModelNotificationSettings guildNotificationSettings, boolean disablePins) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new ChannelFound(channel, parentChannel, guildNotificationSettings, disablePins);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ChannelFound)) {
                    return false;
                }
                ChannelFound channelFound = (ChannelFound) other;
                return Intrinsics3.areEqual(this.channel, channelFound.channel) && Intrinsics3.areEqual(this.parentChannel, channelFound.parentChannel) && Intrinsics3.areEqual(this.guildNotificationSettings, channelFound.guildNotificationSettings) && this.disablePins == channelFound.disablePins;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final boolean getDisablePins() {
                return this.disablePins;
            }

            public final ModelNotificationSettings getGuildNotificationSettings() {
                return this.guildNotificationSettings;
            }

            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.parentChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                ModelNotificationSettings modelNotificationSettings = this.guildNotificationSettings;
                int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
                boolean z2 = this.disablePins;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode3 + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ChannelFound(channel=");
                sbU.append(this.channel);
                sbU.append(", parentChannel=");
                sbU.append(this.parentChannel);
                sbU.append(", guildNotificationSettings=");
                sbU.append(this.guildNotificationSettings);
                sbU.append(", disablePins=");
                return outline.O(sbU, this.disablePins, ")");
            }
        }

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState$ChannelNotFound;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ChannelNotFound extends StoreState {
            public static final ChannelNotFound INSTANCE = new ChannelNotFound();

            private ChannelNotFound() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState;", "", "<init>", "()V", "Guild", "Private", "Uninitialized", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState$Private;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState$Guild;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b-\u0010.J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJ\u0010\u0010\u0010\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJr\u0010\u001a\u001a\u00020\u00002\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0012\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010\u0018\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\u0019\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b(\u0010\nR\u001d\u0010\u0011\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\u0005R\u001d\u0010\u0012\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b+\u0010\u0005R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b,\u0010\nR\u0019\u0010\u0017\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b\u0017\u0010\n¨\u0006/"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState$Guild;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/GuildId;", "component2", "", "component3", "()Z", "component4", "component5", "component6", "component7", "component8", "component9", "channelId", "guildId", "isMuted", "hasUnreadPins", "disablePins", "isThread", "isGuildForumPost", "isGuildForumChannel", "shouldHideChannelSidebar", "copy", "(JJZZZZZZZ)Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState$Guild;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getDisablePins", "getShouldHideChannelSidebar", "J", "getChannelId", "getGuildId", "getHasUnreadPins", "<init>", "(JJZZZZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Guild extends ViewState {
            private final long channelId;
            private final boolean disablePins;
            private final long guildId;
            private final boolean hasUnreadPins;
            private final boolean isGuildForumChannel;
            private final boolean isGuildForumPost;
            private final boolean isMuted;
            private final boolean isThread;
            private final boolean shouldHideChannelSidebar;

            public Guild(long j, long j2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
                super(null);
                this.channelId = j;
                this.guildId = j2;
                this.isMuted = z2;
                this.hasUnreadPins = z3;
                this.disablePins = z4;
                this.isThread = z5;
                this.isGuildForumPost = z6;
                this.isGuildForumChannel = z7;
                this.shouldHideChannelSidebar = z8;
            }

            public static /* synthetic */ Guild copy$default(Guild guild, long j, long j2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, Object obj) {
                return guild.copy((i & 1) != 0 ? guild.channelId : j, (i & 2) != 0 ? guild.guildId : j2, (i & 4) != 0 ? guild.isMuted : z2, (i & 8) != 0 ? guild.hasUnreadPins : z3, (i & 16) != 0 ? guild.disablePins : z4, (i & 32) != 0 ? guild.isThread : z5, (i & 64) != 0 ? guild.isGuildForumPost : z6, (i & 128) != 0 ? guild.isGuildForumChannel : z7, (i & 256) != 0 ? guild.shouldHideChannelSidebar : z8);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsMuted() {
                return this.isMuted;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getHasUnreadPins() {
                return this.hasUnreadPins;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getDisablePins() {
                return this.disablePins;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsThread() {
                return this.isThread;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getIsGuildForumPost() {
                return this.isGuildForumPost;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsGuildForumChannel() {
                return this.isGuildForumChannel;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getShouldHideChannelSidebar() {
                return this.shouldHideChannelSidebar;
            }

            public final Guild copy(long channelId, long guildId, boolean isMuted, boolean hasUnreadPins, boolean disablePins, boolean isThread, boolean isGuildForumPost, boolean isGuildForumChannel, boolean shouldHideChannelSidebar) {
                return new Guild(channelId, guildId, isMuted, hasUnreadPins, disablePins, isThread, isGuildForumPost, isGuildForumChannel, shouldHideChannelSidebar);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Guild)) {
                    return false;
                }
                Guild guild = (Guild) other;
                return this.channelId == guild.channelId && this.guildId == guild.guildId && this.isMuted == guild.isMuted && this.hasUnreadPins == guild.hasUnreadPins && this.disablePins == guild.disablePins && this.isThread == guild.isThread && this.isGuildForumPost == guild.isGuildForumPost && this.isGuildForumChannel == guild.isGuildForumChannel && this.shouldHideChannelSidebar == guild.shouldHideChannelSidebar;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getDisablePins() {
                return this.disablePins;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final boolean getHasUnreadPins() {
                return this.hasUnreadPins;
            }

            public final boolean getShouldHideChannelSidebar() {
                return this.shouldHideChannelSidebar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iA = (b.a(this.guildId) + (b.a(this.channelId) * 31)) * 31;
                boolean z2 = this.isMuted;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iA + i) * 31;
                boolean z3 = this.hasUnreadPins;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.disablePins;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.isThread;
                int i7 = z5;
                if (z5 != 0) {
                    i7 = 1;
                }
                int i8 = (i6 + i7) * 31;
                boolean z6 = this.isGuildForumPost;
                int i9 = z6;
                if (z6 != 0) {
                    i9 = 1;
                }
                int i10 = (i8 + i9) * 31;
                boolean z7 = this.isGuildForumChannel;
                int i11 = z7;
                if (z7 != 0) {
                    i11 = 1;
                }
                int i12 = (i10 + i11) * 31;
                boolean z8 = this.shouldHideChannelSidebar;
                return i12 + (z8 ? 1 : z8 ? 1 : 0);
            }

            public final boolean isGuildForumChannel() {
                return this.isGuildForumChannel;
            }

            public final boolean isGuildForumPost() {
                return this.isGuildForumPost;
            }

            public final boolean isMuted() {
                return this.isMuted;
            }

            public final boolean isThread() {
                return this.isThread;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Guild(channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", isMuted=");
                sbU.append(this.isMuted);
                sbU.append(", hasUnreadPins=");
                sbU.append(this.hasUnreadPins);
                sbU.append(", disablePins=");
                sbU.append(this.disablePins);
                sbU.append(", isThread=");
                sbU.append(this.isThread);
                sbU.append(", isGuildForumPost=");
                sbU.append(this.isGuildForumPost);
                sbU.append(", isGuildForumChannel=");
                sbU.append(this.isGuildForumChannel);
                sbU.append(", shouldHideChannelSidebar=");
                return outline.O(sbU, this.shouldHideChannelSidebar, ")");
            }
        }

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\n\u0010\bR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState$Private;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "component2", "()Z", "channelId", "isMuted", "copy", "(JZ)Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState$Private;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "J", "getChannelId", "<init>", "(JZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Private extends ViewState {
            private final long channelId;
            private final boolean isMuted;

            public Private(long j, boolean z2) {
                super(null);
                this.channelId = j;
                this.isMuted = z2;
            }

            public static /* synthetic */ Private copy$default(Private r0, long j, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = r0.channelId;
                }
                if ((i & 2) != 0) {
                    z2 = r0.isMuted;
                }
                return r0.copy(j, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsMuted() {
                return this.isMuted;
            }

            public final Private copy(long channelId, boolean isMuted) {
                return new Private(channelId, isMuted);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Private)) {
                    return false;
                }
                Private r6 = (Private) other;
                return this.channelId == r6.channelId && this.isMuted == r6.isMuted;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                boolean z2 = this.isMuted;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iA + i;
            }

            public final boolean isMuted() {
                return this.isMuted;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Private(channelId=");
                sbU.append(this.channelId);
                sbU.append(", isMuted=");
                return outline.O(sbU, this.isMuted, ")");
            }
        }

        /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetChannelSidebarActionsViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetChannelSidebarActionsViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, null, null, null, null, 63, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelSidebarActionsViewModel widgetChannelSidebarActionsViewModel, StoreState storeState) {
        widgetChannelSidebarActionsViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        ModelNotificationSettings.ChannelOverride channelOverride;
        List<ModelNotificationSettings.ChannelOverride> channelOverrides;
        Object next;
        if (Intrinsics3.areEqual(storeState, StoreState.ChannelNotFound.INSTANCE)) {
            updateViewState(ViewState.Uninitialized.INSTANCE);
            return;
        }
        if (!(storeState instanceof StoreState.ChannelFound)) {
            throw new NoWhenBranchMatchedException();
        }
        StoreState.ChannelFound channelFound = (StoreState.ChannelFound) storeState;
        boolean z2 = false;
        if (!ChannelUtils.B(channelFound.getChannel())) {
            long id2 = channelFound.getChannel().getId();
            long guildId = channelFound.getChannel().getGuildId();
            ModelNotificationSettings guildNotificationSettings = channelFound.getGuildNotificationSettings();
            boolean z3 = (guildNotificationSettings == null || (channelOverride = guildNotificationSettings.getChannelOverride(id2)) == null || !channelOverride.isMuted()) ? false : true;
            boolean disablePins = channelFound.getDisablePins();
            boolean zH = ChannelUtils.H(channelFound.getChannel());
            Channel parentChannel = channelFound.getParentChannel();
            updateViewState(new ViewState.Guild(id2, guildId, z3, false, disablePins, zH, parentChannel != null && ChannelUtils.q(parentChannel), ChannelUtils.q(channelFound.getChannel()), ChannelUtils.o(channelFound.getChannel())));
            return;
        }
        ModelNotificationSettings guildNotificationSettings2 = channelFound.getGuildNotificationSettings();
        long id3 = channelFound.getChannel().getId();
        if (guildNotificationSettings2 != null && (channelOverrides = guildNotificationSettings2.getChannelOverrides()) != null) {
            Iterator<T> it = channelOverrides.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ModelNotificationSettings.ChannelOverride channelOverride2 = (ModelNotificationSettings.ChannelOverride) next;
                Intrinsics3.checkNotNullExpressionValue(channelOverride2, "channelOverride");
                if (channelOverride2.getChannelId() == id3) {
                    break;
                }
            }
            ModelNotificationSettings.ChannelOverride channelOverride3 = (ModelNotificationSettings.ChannelOverride) next;
            if (channelOverride3 != null && channelOverride3.isMuted()) {
                z2 = true;
            }
        }
        updateViewState(new ViewState.Private(channelFound.getChannel().getId(), z2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActionsViewModel(Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetChannelSidebarActionsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
