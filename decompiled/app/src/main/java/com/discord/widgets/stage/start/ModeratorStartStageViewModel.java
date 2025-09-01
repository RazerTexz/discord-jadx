package com.discord.widgets.stage.start;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.start.ModeratorStartStageItem;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ModeratorStartStageViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#BU\u0012\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00060\u0010j\u0002`\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;", "Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;)V", "disconnectFromStage", "()V", "Lcom/discord/stores/StoreVoiceParticipants;", "voiceParticipants", "Lcom/discord/stores/StoreVoiceParticipants;", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lcom/discord/stores/StoreVoiceChannelSelected;", "selectedVoiceChannelStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "Lrx/Observable;", "storeStateObservable", "<init>", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreVoiceParticipants;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ModeratorStartStageViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_DISPLAY_WAITING_USERS = 3;
    private final long channelId;
    private final StoreChannels channelsStore;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceParticipants voiceParticipants;

    /* compiled from: ModeratorStartStageViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.start.ModeratorStartStageViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(ModeratorStartStageViewModel moderatorStartStageViewModel) {
            super(1, moderatorStartStageViewModel, ModeratorStartStageViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ModeratorStartStageViewModel.access$handleStoreState((ModeratorStartStageViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: ModeratorStartStageViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JA\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StoreVoiceParticipants;", "voiceParticipantsStore", "Lrx/Observable;", "Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;", "observeStores", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreVoiceParticipants;)Lrx/Observable;", "", "MAX_DISPLAY_WAITING_USERS", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants) {
            return companion.observeStores(j, storeChannels, storeGuildScheduledEvents, storePermissions, storeVoiceParticipants);
        }

        private final Observable<StoreState> observeStores(long channelId, StoreChannels channelStore, StoreGuildScheduledEvents guildScheduledEventsStore, StorePermissions permissionsStore, StoreVoiceParticipants voiceParticipantsStore) {
            Observable<R> observableG = channelStore.observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableY = observableG.Y(new ModeratorStartStageViewModel2(voiceParticipantsStore, guildScheduledEventsStore, permissionsStore, channelId));
            Intrinsics3.checkNotNullExpressionValue(observableY, "channelStore.observeChan…  )\n          }\n        }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ModeratorStartStageViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0005¨\u0006 "}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;", "", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Ljava/util/List;", "Lcom/discord/models/guild/UserGuildMember;", "component2", "", "component3", "()Z", "channelEvents", "voiceParticipants", "canStartEvent", "copy", "(Ljava/util/List;Ljava/util/List;Z)Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getChannelEvents", "Z", "getCanStartEvent", "getVoiceParticipants", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final boolean canStartEvent;
        private final List<GuildScheduledEvent> channelEvents;
        private final List<UserGuildMember> voiceParticipants;

        public StoreState(List<GuildScheduledEvent> list, List<UserGuildMember> list2, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "channelEvents");
            Intrinsics3.checkNotNullParameter(list2, "voiceParticipants");
            this.channelEvents = list;
            this.voiceParticipants = list2;
            this.canStartEvent = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, List list2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.channelEvents;
            }
            if ((i & 2) != 0) {
                list2 = storeState.voiceParticipants;
            }
            if ((i & 4) != 0) {
                z2 = storeState.canStartEvent;
            }
            return storeState.copy(list, list2, z2);
        }

        public final List<GuildScheduledEvent> component1() {
            return this.channelEvents;
        }

        public final List<UserGuildMember> component2() {
            return this.voiceParticipants;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        public final StoreState copy(List<GuildScheduledEvent> channelEvents, List<UserGuildMember> voiceParticipants, boolean canStartEvent) {
            Intrinsics3.checkNotNullParameter(channelEvents, "channelEvents");
            Intrinsics3.checkNotNullParameter(voiceParticipants, "voiceParticipants");
            return new StoreState(channelEvents, voiceParticipants, canStartEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.channelEvents, storeState.channelEvents) && Intrinsics3.areEqual(this.voiceParticipants, storeState.voiceParticipants) && this.canStartEvent == storeState.canStartEvent;
        }

        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        public final List<GuildScheduledEvent> getChannelEvents() {
            return this.channelEvents;
        }

        public final List<UserGuildMember> getVoiceParticipants() {
            return this.voiceParticipants;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<GuildScheduledEvent> list = this.channelEvents;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<UserGuildMember> list2 = this.voiceParticipants;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            boolean z2 = this.canStartEvent;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(channelEvents=");
            sbU.append(this.channelEvents);
            sbU.append(", voiceParticipants=");
            sbU.append(this.voiceParticipants);
            sbU.append(", canStartEvent=");
            return outline.O(sbU, this.canStartEvent, ")");
        }
    }

    /* compiled from: ModeratorStartStageViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0005R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\n¨\u0006 "}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;", "", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Ljava/util/List;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem;", "component2", "", "component3", "()Z", "channelEvents", "items", "channelEventActive", "copy", "(Ljava/util/List;Ljava/util/List;Z)Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "getChannelEvents", "Z", "getChannelEventActive", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean channelEventActive;
        private final List<GuildScheduledEvent> channelEvents;
        private final List<ModeratorStartStageItem> items;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<GuildScheduledEvent> list, List<? extends ModeratorStartStageItem> list2, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "channelEvents");
            Intrinsics3.checkNotNullParameter(list2, "items");
            this.channelEvents = list;
            this.items = list2;
            this.channelEventActive = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, List list2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.channelEvents;
            }
            if ((i & 2) != 0) {
                list2 = viewState.items;
            }
            if ((i & 4) != 0) {
                z2 = viewState.channelEventActive;
            }
            return viewState.copy(list, list2, z2);
        }

        public final List<GuildScheduledEvent> component1() {
            return this.channelEvents;
        }

        public final List<ModeratorStartStageItem> component2() {
            return this.items;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getChannelEventActive() {
            return this.channelEventActive;
        }

        public final ViewState copy(List<GuildScheduledEvent> channelEvents, List<? extends ModeratorStartStageItem> items, boolean channelEventActive) {
            Intrinsics3.checkNotNullParameter(channelEvents, "channelEvents");
            Intrinsics3.checkNotNullParameter(items, "items");
            return new ViewState(channelEvents, items, channelEventActive);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.channelEvents, viewState.channelEvents) && Intrinsics3.areEqual(this.items, viewState.items) && this.channelEventActive == viewState.channelEventActive;
        }

        public final boolean getChannelEventActive() {
            return this.channelEventActive;
        }

        public final List<GuildScheduledEvent> getChannelEvents() {
            return this.channelEvents;
        }

        public final List<ModeratorStartStageItem> getItems() {
            return this.items;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            List<GuildScheduledEvent> list = this.channelEvents;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            List<ModeratorStartStageItem> list2 = this.items;
            int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            boolean z2 = this.channelEventActive;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(channelEvents=");
            sbU.append(this.channelEvents);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", channelEventActive=");
            return outline.O(sbU, this.channelEventActive, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ModeratorStartStageViewModel(long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuildScheduledEvents guildScheduledEvents = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreVoiceParticipants voiceParticipants = (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceParticipants() : storeVoiceParticipants;
        this(j, channels, guildScheduledEvents, voiceChannelSelected, permissions, voiceParticipants, (i & 64) != 0 ? Companion.access$observeStores(INSTANCE, j, channels, guildScheduledEvents, permissions, voiceParticipants) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(ModeratorStartStageViewModel moderatorStartStageViewModel, StoreState storeState) {
        moderatorStartStageViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        Object next;
        Object obj = null;
        List listMutableListOf = Collections2.mutableListOf(new ModeratorStartStageItem.Header(0, null, 3, null));
        if (storeState.getCanStartEvent()) {
            Iterator<T> it = storeState.getChannelEvents().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (GuildScheduledEventUtilities5.getEventTiming((GuildScheduledEvent) next).isStartable()) {
                        break;
                    }
                }
            }
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
            if (guildScheduledEvent != null) {
                listMutableListOf.add(new ModeratorStartStageItem.ListItem.Event(guildScheduledEvent));
            }
        }
        listMutableListOf.add(new ModeratorStartStageItem.ListItem.StaticOption.StartStage(null, 1, null));
        if (storeState.getCanStartEvent()) {
            listMutableListOf.add(new ModeratorStartStageItem.ListItem.StaticOption.ScheduleEvent(null, 1, null));
        }
        listMutableListOf.add(new ModeratorStartStageItem.Continue(0, null, 3, null));
        if (!storeState.getVoiceParticipants().isEmpty()) {
            listMutableListOf.add(new ModeratorStartStageItem.Waiting(0, null, _Collections.take(storeState.getVoiceParticipants(), 3), 3, null));
        }
        List<GuildScheduledEvent> channelEvents = storeState.getChannelEvents();
        Iterator<T> it2 = storeState.getChannelEvents().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (((GuildScheduledEvent) next2).getStatus() == GuildScheduledEventStatus.ACTIVE) {
                obj = next2;
                break;
            }
        }
        updateViewState(new ViewState(channelEvents, listMutableListOf, obj != null));
    }

    public final void disconnectFromStage() {
        this.selectedVoiceChannelStore.clear();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageViewModel(long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceParticipants, "voiceParticipants");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.channelsStore = storeChannels;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.voiceParticipants = storeVoiceParticipants;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ModeratorStartStageViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
