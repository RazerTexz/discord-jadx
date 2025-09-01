package com.discord.widgets.channels.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: ChannelGroupDMSettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004,-./B7\u0012\n\u0010'\u001a\u00060\u000ej\u0002`\u000f\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0013\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0018\u0010\rJ\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R:\u0010%\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\t0\t $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\t0\t\u0018\u00010#0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010'\u001a\u00060\u000ej\u0002`\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u00060"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState;)V", "Lrx/Observable;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event;", "observeEvents", "()Lrx/Observable;", "leaveGroup", "()V", "", "Lcom/discord/primitives/ChannelId;", "groupId", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "editGroup", "(JLjava/lang/String;)V", "iconUrl", "onIconEdited", "(Ljava/lang/String;)V", "removeEditedIcon", "Landroid/content/Context;", "context", "unmute", "(Landroid/content/Context;)V", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreUserGuildSettings;", "storeUserGuildSettings", "Lcom/discord/stores/StoreUserGuildSettings;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "channelId", "J", "storeStateObservable", "<init>", "(JLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreUserGuildSettings;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final PublishSubject<Event> eventSubject;
    private final RestAPI restApi;
    private final StoreUserGuildSettings storeUserGuildSettings;

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$1, reason: invalid class name */
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
            ChannelGroupDMSettingsViewModel.access$handleStoreState(ChannelGroupDMSettingsViewModel.this, storeState);
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreUserGuildSettings;", "storeUserGuildSettings", "Lrx/Observable;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreUserGuildSettings;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings) {
            Observable observableY = storeChannels.observeChannel(channelId).Y(new ChannelGroupDMSettingsViewModel2(storeUserGuildSettings));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannels\n          …            }\n          }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            if ((i & 4) != 0) {
                storeUserGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            }
            return companion.observeStoreState(j, storeChannels, storeUserGuildSettings);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event;", "", "<init>", "()V", "LeaveGroupSuccess", "SettingsSaved", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event$LeaveGroupSuccess;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event$SettingsSaved;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event$LeaveGroupSuccess;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class LeaveGroupSuccess extends Event {
            public static final LeaveGroupSuccess INSTANCE = new LeaveGroupSuccess();

            private LeaveGroupSuccess() {
                super(null);
            }
        }

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event$SettingsSaved;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class SettingsSaved extends Event {
            public static final SettingsSaved INSTANCE = new SettingsSaved();

            private SettingsSaved() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState$Invalid;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState$Invalid;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState$Valid;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/domain/ModelNotificationSettings;", "component2", "()Lcom/discord/models/domain/ModelNotificationSettings;", "channel", "notificationSettings", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings;)Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$StoreState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/domain/ModelNotificationSettings;", "getNotificationSettings", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelNotificationSettings;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final Channel channel;
            private final ModelNotificationSettings notificationSettings;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Channel channel, ModelNotificationSettings modelNotificationSettings) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(modelNotificationSettings, "notificationSettings");
                this.channel = channel;
                this.notificationSettings = modelNotificationSettings;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Channel channel, ModelNotificationSettings modelNotificationSettings, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = valid.channel;
                }
                if ((i & 2) != 0) {
                    modelNotificationSettings = valid.notificationSettings;
                }
                return valid.copy(channel, modelNotificationSettings);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component2, reason: from getter */
            public final ModelNotificationSettings getNotificationSettings() {
                return this.notificationSettings;
            }

            public final Valid copy(Channel channel, ModelNotificationSettings notificationSettings) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(notificationSettings, "notificationSettings");
                return new Valid(channel, notificationSettings);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.channel, valid.channel) && Intrinsics3.areEqual(this.notificationSettings, valid.notificationSettings);
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final ModelNotificationSettings getNotificationSettings() {
                return this.notificationSettings;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                ModelNotificationSettings modelNotificationSettings = this.notificationSettings;
                return iHashCode + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(channel=");
                sbU.append(this.channel);
                sbU.append(", notificationSettings=");
                sbU.append(this.notificationSettings);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: ChannelGroupDMSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J2\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001e\u001a\u00020\u00158F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001bR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState$Valid;", "Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState;", "", "getCurrentIconUrl", "()Ljava/lang/String;", "Lcom/discord/widgets/channels/settings/ChannelSettings;", "component1", "()Lcom/discord/widgets/channels/settings/ChannelSettings;", "component2", "component3", "channelSettings", "originalIconUrl", "editedIconUrl", "copy", "(Lcom/discord/widgets/channels/settings/ChannelSettings;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/channels/settings/ChannelGroupDMSettingsViewModel$ViewState$Valid;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hasUnsavedIconChange", "Z", "getHasUnsavedIconChange", "()Z", "isDefaultPhoto$delegate", "Lkotlin/Lazy;", "isDefaultPhoto", "Ljava/lang/String;", "getOriginalIconUrl", "getEditedIconUrl", "Lcom/discord/widgets/channels/settings/ChannelSettings;", "getChannelSettings", "<init>", "(Lcom/discord/widgets/channels/settings/ChannelSettings;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final ChannelSettings channelSettings;
            private final String editedIconUrl;
            private final boolean hasUnsavedIconChange;

            /* renamed from: isDefaultPhoto$delegate, reason: from kotlin metadata */
            private final Lazy isDefaultPhoto;
            private final String originalIconUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(ChannelSettings channelSettings, String str, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(channelSettings, "channelSettings");
                this.channelSettings = channelSettings;
                this.originalIconUrl = str;
                this.editedIconUrl = str2;
                this.hasUnsavedIconChange = !Intrinsics3.areEqual(str, str2);
                this.isDefaultPhoto = LazyJVM.lazy(new ChannelGroupDMSettingsViewModel3(this));
            }

            public static /* synthetic */ Valid copy$default(Valid valid, ChannelSettings channelSettings, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    channelSettings = valid.channelSettings;
                }
                if ((i & 2) != 0) {
                    str = valid.originalIconUrl;
                }
                if ((i & 4) != 0) {
                    str2 = valid.editedIconUrl;
                }
                return valid.copy(channelSettings, str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final ChannelSettings getChannelSettings() {
                return this.channelSettings;
            }

            /* renamed from: component2, reason: from getter */
            public final String getOriginalIconUrl() {
                return this.originalIconUrl;
            }

            /* renamed from: component3, reason: from getter */
            public final String getEditedIconUrl() {
                return this.editedIconUrl;
            }

            public final Valid copy(ChannelSettings channelSettings, String originalIconUrl, String editedIconUrl) {
                Intrinsics3.checkNotNullParameter(channelSettings, "channelSettings");
                return new Valid(channelSettings, originalIconUrl, editedIconUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.channelSettings, valid.channelSettings) && Intrinsics3.areEqual(this.originalIconUrl, valid.originalIconUrl) && Intrinsics3.areEqual(this.editedIconUrl, valid.editedIconUrl);
            }

            public final ChannelSettings getChannelSettings() {
                return this.channelSettings;
            }

            public final String getCurrentIconUrl() {
                if (!this.hasUnsavedIconChange) {
                    return IconUtils.getForChannel(this.channelSettings.getChannel(), null);
                }
                String str = this.editedIconUrl;
                return str != null ? str : IconUtils.INSTANCE.getDefaultForGroupDM(this.channelSettings.getChannel().getId());
            }

            public final String getEditedIconUrl() {
                return this.editedIconUrl;
            }

            public final boolean getHasUnsavedIconChange() {
                return this.hasUnsavedIconChange;
            }

            public final String getOriginalIconUrl() {
                return this.originalIconUrl;
            }

            public int hashCode() {
                ChannelSettings channelSettings = this.channelSettings;
                int iHashCode = (channelSettings != null ? channelSettings.hashCode() : 0) * 31;
                String str = this.originalIconUrl;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.editedIconUrl;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public final boolean isDefaultPhoto() {
                return ((Boolean) this.isDefaultPhoto.getValue()).booleanValue();
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(channelSettings=");
                sbU.append(this.channelSettings);
                sbU.append(", originalIconUrl=");
                sbU.append(this.originalIconUrl);
                sbU.append(", editedIconUrl=");
                return outline.J(sbU, this.editedIconUrl, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$editGroup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ ViewState.Valid $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Valid valid) {
            super(1);
            this.$viewState = valid;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = ChannelGroupDMSettingsViewModel.access$getEventSubject$p(ChannelGroupDMSettingsViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.SettingsSaved.INSTANCE);
            ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel = ChannelGroupDMSettingsViewModel.this;
            ViewState.Valid valid = this.$viewState;
            ChannelGroupDMSettingsViewModel.access$updateViewState(channelGroupDMSettingsViewModel, valid.copy(ChannelSettings.copy$default(valid.getChannelSettings(), channel, false, null, 6, null), IconUtils.getForChannel(channel, null), IconUtils.getForChannel(channel, null)));
        }
    }

    /* compiled from: ChannelGroupDMSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.ChannelGroupDMSettingsViewModel$leaveGroup$1, reason: invalid class name */
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
            PublishSubject publishSubjectAccess$getEventSubject$p = ChannelGroupDMSettingsViewModel.access$getEventSubject$p(ChannelGroupDMSettingsViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.LeaveGroupSuccess.INSTANCE);
        }
    }

    public /* synthetic */ ChannelGroupDMSettingsViewModel(long j, RestAPI restAPI, StoreUserGuildSettings storeUserGuildSettings, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? StoreStream.INSTANCE.getUserGuildSettings() : storeUserGuildSettings, (i & 8) != 0 ? Companion.observeStoreState$default(INSTANCE, j, null, null, 6, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel) {
        return channelGroupDMSettingsViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel, StoreState storeState) {
        channelGroupDMSettingsViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(ChannelGroupDMSettingsViewModel channelGroupDMSettingsViewModel, ViewState viewState) {
        channelGroupDMSettingsViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            Channel channel = valid.getChannel();
            ChannelSettings channelSettingsCreateFromNotificationSettings = ChannelSettings.INSTANCE.createFromNotificationSettings(channel, valid.getNotificationSettings());
            ViewState viewState = getViewState();
            updateViewState(viewState instanceof ViewState.Valid ? ViewState.Valid.copy$default((ViewState.Valid) viewState, channelSettingsCreateFromNotificationSettings, null, null, 6, null) : new ViewState.Valid(channelSettingsCreateFromNotificationSettings, IconUtils.getForChannel(channel, null), IconUtils.getForChannel(channel, null)));
        }
    }

    @MainThread
    public final void editGroup(long groupId, String name) {
        String originalIconUrl;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            if (valid.getHasUnsavedIconChange()) {
                originalIconUrl = valid.getEditedIconUrl();
                if (originalIconUrl == null) {
                    originalIconUrl = "";
                }
            } else {
                originalIconUrl = valid.getOriginalIconUrl();
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.editGroupDM(groupId, new RestAPIParams.GroupDM(name, originalIconUrl)), false, 1, null), this, null, 2, null), ChannelGroupDMSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(valid), 62, (Object) null);
        }
    }

    @MainThread
    public final void leaveGroup() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.deleteChannel(valid.getChannelSettings().getChannel().getId()), false, 1, null), this, null, 2, null), ChannelGroupDMSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        }
    }

    @MainThread
    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onIconEdited(String iconUrl) {
        Intrinsics3.checkNotNullParameter(iconUrl, "iconUrl");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, null, iconUrl, 3, null));
        }
    }

    @MainThread
    public final void removeEditedIcon() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, null, null, 3, null));
        }
    }

    public final void unmute(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.storeUserGuildSettings.setChannelMuted(context, this.channelId, false, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel(long j, RestAPI restAPI, StoreUserGuildSettings storeUserGuildSettings, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.restApi = restAPI;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ChannelGroupDMSettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
