package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*BE\u0012\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000eR:\u0010\u0011\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000b0\u000b \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$ViewState;", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;)V", "Lrx/Observable;", "observeStoreState", "()Lrx/Observable;", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$Event;", "observeEvents", "onConnectPressed", "()V", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreVoiceStates;", "voiceStatesStore", "Lcom/discord/stores/StoreVoiceStates;", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreVoiceChannelSelected;", "selectedVoiceChannelStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "<init>", "(JLcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreVoiceStates;)V", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheetViewModel extends AppViewModel<ViewState> {
    private final long channelId;
    private final StoreChannels channelsStore;
    private final PublishSubject<Event> eventSubject;
    private final StoreGuilds guildsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceStates voiceStatesStore;

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetGuildCallOnboardingSheetViewModel widgetGuildCallOnboardingSheetViewModel) {
            super(1, widgetGuildCallOnboardingSheetViewModel, WidgetGuildCallOnboardingSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            WidgetGuildCallOnboardingSheetViewModel.access$handleStoreState((WidgetGuildCallOnboardingSheetViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$Event;", "", "<init>", "()V", "LaunchGuildCallScreen", "ShowGuildVideoCapacityDialog", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$Event$ShowGuildVideoCapacityDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R!\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen;", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$Event;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", "channelId", "guildId", "copy", "(JLjava/lang/Long;)Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "Ljava/lang/Long;", "getGuildId", "<init>", "(JLjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LaunchGuildCallScreen extends Event {
            private final long channelId;
            private final Long guildId;

            public LaunchGuildCallScreen(long j, Long l) {
                super(null);
                this.channelId = j;
                this.guildId = l;
            }

            public static /* synthetic */ LaunchGuildCallScreen copy$default(LaunchGuildCallScreen launchGuildCallScreen, long j, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchGuildCallScreen.channelId;
                }
                if ((i & 2) != 0) {
                    l = launchGuildCallScreen.guildId;
                }
                return launchGuildCallScreen.copy(j, l);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            public final LaunchGuildCallScreen copy(long channelId, Long guildId) {
                return new LaunchGuildCallScreen(channelId, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchGuildCallScreen)) {
                    return false;
                }
                LaunchGuildCallScreen launchGuildCallScreen = (LaunchGuildCallScreen) other;
                return this.channelId == launchGuildCallScreen.channelId && Intrinsics3.areEqual(this.guildId, launchGuildCallScreen.guildId);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                Long l = this.guildId;
                return iA + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchGuildCallScreen(channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                return outline.G(sbU, this.guildId, ")");
            }
        }

        /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$Event$ShowGuildVideoCapacityDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowGuildVideoCapacityDialog extends Event {
            public static final ShowGuildVideoCapacityDialog INSTANCE = new ShowGuildVideoCapacityDialog();

            private ShowGuildVideoCapacityDialog() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/lang/Long;", "Lcom/discord/utilities/voice/VoiceChannelJoinability;", "component2", "()Lcom/discord/utilities/voice/VoiceChannelJoinability;", "guildId", "voiceChannelJoinability", "copy", "(Ljava/lang/Long;Lcom/discord/utilities/voice/VoiceChannelJoinability;)Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getGuildId", "Lcom/discord/utilities/voice/VoiceChannelJoinability;", "getVoiceChannelJoinability", "<init>", "(Ljava/lang/Long;Lcom/discord/utilities/voice/VoiceChannelJoinability;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Long guildId;
        private final VoiceChannelJoinabilityUtils2 voiceChannelJoinability;

        public StoreState(Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
            Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "voiceChannelJoinability");
            this.guildId = l;
            this.voiceChannelJoinability = voiceChannelJoinabilityUtils2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = storeState.guildId;
            }
            if ((i & 2) != 0) {
                voiceChannelJoinabilityUtils2 = storeState.voiceChannelJoinability;
            }
            return storeState.copy(l, voiceChannelJoinabilityUtils2);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public final StoreState copy(Long guildId, VoiceChannelJoinabilityUtils2 voiceChannelJoinability) {
            Intrinsics3.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
            return new StoreState(guildId, voiceChannelJoinability);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildId, storeState.guildId) && Intrinsics3.areEqual(this.voiceChannelJoinability, storeState.voiceChannelJoinability);
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final VoiceChannelJoinabilityUtils2 getVoiceChannelJoinability() {
            return this.voiceChannelJoinability;
        }

        public int hashCode() {
            Long l = this.guildId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2 = this.voiceChannelJoinability;
            return iHashCode + (voiceChannelJoinabilityUtils2 != null ? voiceChannelJoinabilityUtils2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildId=");
            sbU.append(this.guildId);
            sbU.append(", voiceChannelJoinability=");
            sbU.append(this.voiceChannelJoinability);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R!\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$ViewState;", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/lang/Long;", "Lcom/discord/utilities/voice/VoiceChannelJoinability;", "component2", "()Lcom/discord/utilities/voice/VoiceChannelJoinability;", "guildId", "joinability", "copy", "(Ljava/lang/Long;Lcom/discord/utilities/voice/VoiceChannelJoinability;)Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getGuildId", "Lcom/discord/utilities/voice/VoiceChannelJoinability;", "getJoinability", "<init>", "(Ljava/lang/Long;Lcom/discord/utilities/voice/VoiceChannelJoinability;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Long guildId;
            private final VoiceChannelJoinabilityUtils2 joinability;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
                super(null);
                Intrinsics3.checkNotNullParameter(voiceChannelJoinabilityUtils2, "joinability");
                this.guildId = l;
                this.joinability = voiceChannelJoinabilityUtils2;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Long l, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = loaded.guildId;
                }
                if ((i & 2) != 0) {
                    voiceChannelJoinabilityUtils2 = loaded.joinability;
                }
                return loaded.copy(l, voiceChannelJoinabilityUtils2);
            }

            /* renamed from: component1, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component2, reason: from getter */
            public final VoiceChannelJoinabilityUtils2 getJoinability() {
                return this.joinability;
            }

            public final Loaded copy(Long guildId, VoiceChannelJoinabilityUtils2 joinability) {
                Intrinsics3.checkNotNullParameter(joinability, "joinability");
                return new Loaded(guildId, joinability);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.guildId, loaded.guildId) && Intrinsics3.areEqual(this.joinability, loaded.joinability);
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final VoiceChannelJoinabilityUtils2 getJoinability() {
                return this.joinability;
            }

            public int hashCode() {
                Long l = this.guildId;
                int iHashCode = (l != null ? l.hashCode() : 0) * 31;
                VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2 = this.joinability;
                return iHashCode + (voiceChannelJoinabilityUtils2 != null ? voiceChannelJoinabilityUtils2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guildId=");
                sbU.append(this.guildId);
                sbU.append(", joinability=");
                sbU.append(this.joinability);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VoiceChannelJoinabilityUtils2.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoiceChannelJoinabilityUtils2.CAN_JOIN.ordinal()] = 1;
            iArr[VoiceChannelJoinabilityUtils2.GUILD_VIDEO_AT_CAPACITY.ordinal()] = 2;
            iArr[VoiceChannelJoinabilityUtils2.PERMISSIONS_MISSING.ordinal()] = 3;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_FULL.ordinal()] = 4;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_DOES_NOT_EXIST.ordinal()] = 5;
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/utilities/voice/VoiceChannelJoinability;", "kotlin.jvm.PlatformType", "joinability", "Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;Lcom/discord/utilities/voice/VoiceChannelJoinability;)Lcom/discord/widgets/voice/fullscreen/WidgetGuildCallOnboardingSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel$observeStoreState$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Channel, VoiceChannelJoinabilityUtils2, StoreState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ StoreState call(Channel channel, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
            return call2(channel, voiceChannelJoinabilityUtils2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreState call2(Channel channel, VoiceChannelJoinabilityUtils2 voiceChannelJoinabilityUtils2) {
            Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
            Intrinsics3.checkNotNullExpressionValue(voiceChannelJoinabilityUtils2, "joinability");
            return new StoreState(lValueOf, voiceChannelJoinabilityUtils2);
        }
    }

    public /* synthetic */ WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 4) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildCallOnboardingSheetViewModel widgetGuildCallOnboardingSheetViewModel, StoreState storeState) {
        widgetGuildCallOnboardingSheetViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        updateViewState(new ViewState.Loaded(storeState.getGuildId(), storeState.getVoiceChannelJoinability()));
    }

    private final Observable<StoreState> observeStoreState() {
        Observable<StoreState> observableJ = Observable.j(this.channelsStore.observeChannel(this.channelId), VoiceChannelJoinabilityUtils.observeJoinability$default(VoiceChannelJoinabilityUtils.INSTANCE, this.channelId, this.channelsStore, this.guildsStore, this.permissionsStore, this.voiceStatesStore, null, null, 96, null), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…dId, joinability)\n      }");
        return observableJ;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onConnectPressed() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            int iOrdinal = loaded.getJoinability().ordinal();
            if (iOrdinal == 0) {
                this.selectedVoiceChannelStore.selectVoiceChannel(this.channelId);
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(new Event.LaunchGuildCallScreen(this.channelId, loaded.getGuildId()));
                return;
            }
            if (iOrdinal != 2) {
                return;
            }
            PublishSubject<Event> publishSubject2 = this.eventSubject;
            publishSubject2.k.onNext(Event.ShowGuildVideoCapacityDialog.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheetViewModel(long j, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreVoiceStates storeVoiceStates) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
        this.channelId = j;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.voiceStatesStore = storeVoiceStates;
        this.eventSubject = PublishSubject.k0();
        Observable<StoreState> observableR = observeStoreState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetGuildCallOnboardingSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
