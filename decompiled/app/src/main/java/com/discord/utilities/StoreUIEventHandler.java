package com.discord.utilities;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreUIEventHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/utilities/StoreUIEventHandler;", "", "", "subscribeToStoreEvents", "()V", "Lcom/discord/rtcconnection/KrispOveruseDetector$Status;", "krispStatusEvent", "handleKrispStatusEvent", "(Lcom/discord/rtcconnection/KrispOveruseDetector$Status;)V", "Lcom/discord/stores/StoreUserGuildSettings$Event;", "userGuildSettingsEvent", "handleUserGuildSettingsEvent", "(Lcom/discord/stores/StoreUserGuildSettings$Event;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "Lcom/discord/stores/StoreMediaEngine;", "mediaEngineStore", "Lcom/discord/stores/StoreMediaEngine;", "Lcom/discord/stores/StoreUserGuildSettings;", "storeUserGuildSettings", "Lcom/discord/stores/StoreUserGuildSettings;", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreStageChannels;", "stageChannelsStore", "Lcom/discord/stores/StoreStageChannels;", "<init>", "(Landroid/content/Context;Lcom/discord/stores/StoreMediaEngine;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreStageChannels;Lcom/discord/stores/StoreUserGuildSettings;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreUIEventHandler {
    private final StoreChannels channelsStore;
    private final Context context;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreStageChannels stageChannelsStore;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            KrispOveruseDetector.Status.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[KrispOveruseDetector.Status.CPU_OVERUSE.ordinal()] = 1;
            iArr[KrispOveruseDetector.Status.VAD_CPU_OVERUSE.ordinal()] = 2;
            iArr[KrispOveruseDetector.Status.FAILED.ordinal()] = 3;
            StoreUserGuildSettings.SettingsUpdateType.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.GUILD.ordinal()] = 1;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.CHANNEL.ordinal()] = 2;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.THREAD.ordinal()] = 3;
            iArr2[StoreUserGuildSettings.SettingsUpdateType.CATEGORY.ordinal()] = 4;
        }
    }

    /* compiled from: StoreUIEventHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/rtcconnection/KrispOveruseDetector$Status;", "it", "", "invoke", "(Lcom/discord/rtcconnection/KrispOveruseDetector$Status;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<KrispOveruseDetector.Status, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KrispOveruseDetector.Status status) {
            invoke2(status);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KrispOveruseDetector.Status status) {
            Intrinsics3.checkNotNullParameter(status, "it");
            StoreUIEventHandler.access$handleKrispStatusEvent(StoreUIEventHandler.this, status);
        }
    }

    /* compiled from: StoreUIEventHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreUserGuildSettings$Event;", "event", "", "invoke", "(Lcom/discord/stores/StoreUserGuildSettings$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.StoreUIEventHandler$subscribeToStoreEvents$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreUserGuildSettings.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserGuildSettings.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserGuildSettings.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            StoreUIEventHandler.access$handleUserGuildSettingsEvent(StoreUIEventHandler.this, event);
        }
    }

    public StoreUIEventHandler(Context context, StoreMediaEngine storeMediaEngine, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageChannels storeStageChannels, StoreUserGuildSettings storeUserGuildSettings) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        this.context = context;
        this.mediaEngineStore = storeMediaEngine;
        this.channelsStore = storeChannels;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.stageChannelsStore = storeStageChannels;
        this.storeUserGuildSettings = storeUserGuildSettings;
        subscribeToStoreEvents();
    }

    public static final /* synthetic */ void access$handleKrispStatusEvent(StoreUIEventHandler storeUIEventHandler, KrispOveruseDetector.Status status) {
        storeUIEventHandler.handleKrispStatusEvent(status);
    }

    public static final /* synthetic */ void access$handleUserGuildSettingsEvent(StoreUIEventHandler storeUIEventHandler, StoreUserGuildSettings.Event event) {
        storeUIEventHandler.handleUserGuildSettingsEvent(event);
    }

    @MainThread
    private final void handleKrispStatusEvent(KrispOveruseDetector.Status krispStatusEvent) {
        int i;
        Channel channel;
        StageRoles stageRolesM15getMyRolesvisDeB4;
        if (krispStatusEvent == KrispOveruseDetector.Status.FAILED && (channel = this.channelsStore.getChannel(this.voiceChannelSelectedStore.getSelectedVoiceChannelId())) != null && ChannelUtils.D(channel) && (stageRolesM15getMyRolesvisDeB4 = this.stageChannelsStore.m15getMyRolesvisDeB4(channel.getId())) != null && StageRoles.m30isAudienceimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
            return;
        }
        int iOrdinal = krispStatusEvent.ordinal();
        if (iOrdinal == 0) {
            i = R.string.mobile_noise_cancellation_cpu_overuse;
        } else if (iOrdinal == 1) {
            i = R.string.mobile_noise_cancellation_failed;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.mobile_advanced_voice_activity_cpu_overuse;
        }
        AppToast.g(this.context, i, 0, null, 12);
    }

    @MainThread
    private final void handleUserGuildSettingsEvent(StoreUserGuildSettings.Event userGuildSettingsEvent) {
        int i;
        if (!(userGuildSettingsEvent instanceof StoreUserGuildSettings.Event.SettingsUpdated)) {
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal = ((StoreUserGuildSettings.Event.SettingsUpdated) userGuildSettingsEvent).getType().ordinal();
        if (iOrdinal == 0) {
            i = R.string.server_settings_updated;
        } else if (iOrdinal == 1) {
            i = R.string.channel_settings_have_been_updated;
        } else if (iOrdinal == 2) {
            i = R.string.thread_settings_updated;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.category_settings_have_been_updated;
        }
        AppToast.g(this.context, i, 0, null, 12);
        KotlinExtensions.getExhaustive(Unit.a);
    }

    private final void subscribeToStoreEvents() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(this.mediaEngineStore.onKrispStatusEvent()), StoreUIEventHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(this.storeUserGuildSettings.observeEvents()), StoreUIEventHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
