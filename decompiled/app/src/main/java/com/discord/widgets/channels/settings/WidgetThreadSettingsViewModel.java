package com.discord.widgets.channels.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetThreadSettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003#$%B\u0013\u0012\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\"\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00052\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aR:\u0010\u001d\u001a&\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\t0\t \u001c*\u0012\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\t0\t\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$StoreState;)V", "Lrx/Observable;", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;", "observeEvents", "()Lrx/Observable;", "", "value", "onChannelNameInputChanged", "(Ljava/lang/String;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "onThreadDeleted", "(J)V", "", "cooldown", "onSlowModeInputChanged", "(I)V", "saveThread", "()V", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "J", "getChannelId", "()J", "<init>", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadSettingsViewModel extends AppViewModel<ViewState> {
    private final long channelId;
    private final PublishSubject<Event> eventSubject;

    /* compiled from: WidgetThreadSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<StoreState> {
        public final /* synthetic */ StoreChannels $channelStore;
        public final /* synthetic */ StorePermissions $permissionStore;
        public final /* synthetic */ StoreUser $userStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreChannels storeChannels, StoreUser storeUser, StorePermissions storePermissions) {
            super(0);
            this.$channelStore = storeChannels;
            this.$userStore = storeUser;
            this.$permissionStore = storePermissions;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StoreState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StoreState invoke() {
            Channel channel = this.$channelStore.getChannel(WidgetThreadSettingsViewModel.this.getChannelId());
            return new StoreState(channel, channel != null ? ThreadUtils.INSTANCE.canManageThread(this.$userStore.getMeSnapshot(), channel, (Long) outline.d(channel, this.$permissionStore.getPermissionsByChannel())) : false);
        }
    }

    /* compiled from: WidgetThreadSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetThreadSettingsViewModel widgetThreadSettingsViewModel = WidgetThreadSettingsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            WidgetThreadSettingsViewModel.access$handleStoreState(widgetThreadSettingsViewModel, storeState);
        }
    }

    /* compiled from: WidgetThreadSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;", "", "<init>", "()V", "ShowToast", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event$ShowToast;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetThreadSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event$ShowToast;", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;", "", "component1", "()I", "messageStringRes", "copy", "(I)Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event$ShowToast;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getMessageStringRes", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowToast extends Event {
            private final int messageStringRes;

            public ShowToast(@StringRes int i) {
                super(null);
                this.messageStringRes = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.messageStringRes;
                }
                return showToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getMessageStringRes() {
                return this.messageStringRes;
            }

            public final ShowToast copy(@StringRes int messageStringRes) {
                return new ShowToast(messageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.messageStringRes == ((ShowToast) other).messageStringRes;
                }
                return true;
            }

            public final int getMessageStringRes() {
                return this.messageStringRes;
            }

            public int hashCode() {
                return this.messageStringRes;
            }

            public String toString() {
                return outline.B(outline.U("ShowToast(messageStringRes="), this.messageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$StoreState;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "channel", "canManageThread", "copy", "(Lcom/discord/api/channel/Channel;Z)Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanManageThread", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final boolean canManageThread;
        private final Channel channel;

        public StoreState(Channel channel, boolean z2) {
            this.channel = channel;
            this.canManageThread = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i & 2) != 0) {
                z2 = storeState.canManageThread;
            }
            return storeState.copy(channel, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final StoreState copy(Channel channel, boolean canManageThread) {
            return new StoreState(channel, canManageThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channel, storeState.channel) && this.canManageThread == storeState.canManageThread;
        }

        public final boolean getCanManageThread() {
            return this.canManageThread;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.canManageThread;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channel=");
            sbU.append(this.channel);
            sbU.append(", canManageThread=");
            return outline.O(sbU, this.canManageThread, ")");
        }
    }

    /* compiled from: WidgetThreadSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetThreadSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetThreadSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJN\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b%\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b&\u0010\r¨\u0006)"}, d2 = {"Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState$Valid;", "Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "", "component4", "()Z", "component5", "component6", "channel", "channelNameDraft", "slowModeCooldownDraft", "hasUnsavedChanges", "canManageThread", "isPinsEnabled", "copy", "(Lcom/discord/api/channel/Channel;Ljava/lang/String;IZZZ)Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState$Valid;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getSlowModeCooldownDraft", "Ljava/lang/String;", "getChannelNameDraft", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "getHasUnsavedChanges", "getCanManageThread", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/lang/String;IZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final boolean canManageThread;
            private final Channel channel;
            private final String channelNameDraft;
            private final boolean hasUnsavedChanges;
            private final boolean isPinsEnabled;
            private final int slowModeCooldownDraft;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Channel channel, String str, int i, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.channelNameDraft = str;
                this.slowModeCooldownDraft = i;
                this.hasUnsavedChanges = z2;
                this.canManageThread = z3;
                this.isPinsEnabled = z4;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Channel channel, String str, int i, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    channel = valid.channel;
                }
                if ((i2 & 2) != 0) {
                    str = valid.channelNameDraft;
                }
                String str2 = str;
                if ((i2 & 4) != 0) {
                    i = valid.slowModeCooldownDraft;
                }
                int i3 = i;
                if ((i2 & 8) != 0) {
                    z2 = valid.hasUnsavedChanges;
                }
                boolean z5 = z2;
                if ((i2 & 16) != 0) {
                    z3 = valid.canManageThread;
                }
                boolean z6 = z3;
                if ((i2 & 32) != 0) {
                    z4 = valid.isPinsEnabled;
                }
                return valid.copy(channel, str2, i3, z5, z6, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final String getChannelNameDraft() {
                return this.channelNameDraft;
            }

            /* renamed from: component3, reason: from getter */
            public final int getSlowModeCooldownDraft() {
                return this.slowModeCooldownDraft;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getHasUnsavedChanges() {
                return this.hasUnsavedChanges;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getCanManageThread() {
                return this.canManageThread;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsPinsEnabled() {
                return this.isPinsEnabled;
            }

            public final Valid copy(Channel channel, String channelNameDraft, int slowModeCooldownDraft, boolean hasUnsavedChanges, boolean canManageThread, boolean isPinsEnabled) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new Valid(channel, channelNameDraft, slowModeCooldownDraft, hasUnsavedChanges, canManageThread, isPinsEnabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.channel, valid.channel) && Intrinsics3.areEqual(this.channelNameDraft, valid.channelNameDraft) && this.slowModeCooldownDraft == valid.slowModeCooldownDraft && this.hasUnsavedChanges == valid.hasUnsavedChanges && this.canManageThread == valid.canManageThread && this.isPinsEnabled == valid.isPinsEnabled;
            }

            public final boolean getCanManageThread() {
                return this.canManageThread;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final String getChannelNameDraft() {
                return this.channelNameDraft;
            }

            public final boolean getHasUnsavedChanges() {
                return this.hasUnsavedChanges;
            }

            public final int getSlowModeCooldownDraft() {
                return this.slowModeCooldownDraft;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                String str = this.channelNameDraft;
                int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.slowModeCooldownDraft) * 31;
                boolean z2 = this.hasUnsavedChanges;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean z3 = this.canManageThread;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isPinsEnabled;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isPinsEnabled() {
                return this.isPinsEnabled;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(channel=");
                sbU.append(this.channel);
                sbU.append(", channelNameDraft=");
                sbU.append(this.channelNameDraft);
                sbU.append(", slowModeCooldownDraft=");
                sbU.append(this.slowModeCooldownDraft);
                sbU.append(", hasUnsavedChanges=");
                sbU.append(this.hasUnsavedChanges);
                sbU.append(", canManageThread=");
                sbU.append(this.canManageThread);
                sbU.append(", isPinsEnabled=");
                return outline.O(sbU, this.isPinsEnabled, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$onThreadDeleted$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Integer numB = ChannelUtils.b(channel);
            if (numB != null) {
                PublishSubject publishSubjectAccess$getEventSubject$p = WidgetThreadSettingsViewModel.access$getEventSubject$p(WidgetThreadSettingsViewModel.this);
                publishSubjectAccess$getEventSubject$p.k.onNext(new Event.ShowToast(numB.intValue()));
            }
        }
    }

    /* compiled from: WidgetThreadSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$onThreadDeleted$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetThreadSettingsViewModel.access$getEventSubject$p(WidgetThreadSettingsViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.ShowToast(R.string.default_failure_to_perform_action_message));
        }
    }

    /* compiled from: WidgetThreadSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$saveThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetThreadSettingsViewModel.access$getEventSubject$p(WidgetThreadSettingsViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.ShowToast(R.string.thread_settings_updated));
        }
    }

    /* compiled from: WidgetThreadSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel$saveThread$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetThreadSettingsViewModel.access$getEventSubject$p(WidgetThreadSettingsViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.ShowToast(R.string.default_failure_to_perform_action_message));
        }
    }

    public WidgetThreadSettingsViewModel(long j) {
        super(null, 1, null);
        this.channelId = j;
        this.eventSubject = PublishSubject.k0();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreChannels channels = companion.getChannels();
        StorePermissions permissions = companion.getPermissions();
        StoreUser users = companion.getUsers();
        Observable observableR = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channels, permissions, users}, false, null, null, new AnonymousClass1(channels, users, permissions), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetThreadSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetThreadSettingsViewModel widgetThreadSettingsViewModel) {
        return widgetThreadSettingsViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadSettingsViewModel widgetThreadSettingsViewModel, StoreState storeState) {
        widgetThreadSettingsViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        Channel channel = storeState.getChannel();
        if ((channel != null ? channel.getName() : null) == null || !ChannelUtils.H(channel)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        boolean z2 = !channel.getNsfw() || StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(channel.getGuildId());
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if ((valid != null ? valid.getChannelNameDraft() : null) != null) {
            updateViewState(ViewState.Valid.copy$default(valid, channel, null, 0, false, false, false, 62, null));
        } else {
            updateViewState(new ViewState.Valid(channel, channel.getName(), channel.getRateLimitPerUser(), false, storeState.getCanManageThread(), z2));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onChannelNameInputChanged(String value) {
        Intrinsics3.checkNotNullParameter(value, "value");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, value, 0, true, false, false, 53, null));
        }
    }

    @MainThread
    public final void onSlowModeInputChanged(int cooldown) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, null, cooldown, true, false, false, 51, null));
        }
    }

    public final void onThreadDeleted(long channelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(channelId), false, 1, null), this, null, 2, null), WidgetThreadSettingsViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    public final void saveThread() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestAPI.editTextChannel$default(RestAPI.INSTANCE.getApi(), this.channelId, Intrinsics3.areEqual(valid.getChannel().getName(), valid.getChannelNameDraft()) ^ true ? valid.getChannelNameDraft() : null, null, null, null, valid.getChannel().getRateLimitPerUser() != valid.getSlowModeCooldownDraft() ? Integer.valueOf(valid.getSlowModeCooldownDraft()) : null, null, 92, null), this, null, 2, null), WidgetThreadSettingsViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
        }
    }
}
