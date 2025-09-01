package com.discord.widgets.hubs.events;

import android.content.Context;
import b.a.d.AppViewModel;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetHubEventsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Be\u0012\n\u0010!\u001a\u00060\u0011j\u0002` \u0012\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b'\u0010(J[\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010\u0019R\u001a\u0010!\u001a\u00060\u0011j\u0002` 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\u0013\u001a\u00060\u0011j\u0002`\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\"R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010&¨\u0006)"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/hubs/events/WidgetHubEventsState;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreDirectories;", "directoriesStore", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "", "Lcom/discord/primitives/ChannelId;", "directoryChannelId", "Lrx/Observable;", "getObservableFromStores", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreDirectories;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StorePermissions;J)Lrx/Observable;", "", "dismissHeader", "()V", "fetchGuildScheduledEvents", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "event", "toggleRsvp", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lcom/discord/stores/StoreGuildScheduledEvents;", "getGuildScheduledEventsStore", "()Lcom/discord/stores/StoreGuildScheduledEvents;", "Lcom/discord/stores/StoreDirectories;", "<init>", "(JJLcom/discord/stores/StoreDirectories;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubEventsViewModel extends AppViewModel<WidgetHubEventsViewModel3> {
    private final StoreDirectories directoriesStore;
    private final long directoryChannelId;
    private final long guildId;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;

    /* compiled from: WidgetHubEventsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsState;", "p1", "", "invoke", "(Lcom/discord/widgets/hubs/events/WidgetHubEventsState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubEventsViewModel3, Unit> {
        public AnonymousClass1(WidgetHubEventsViewModel widgetHubEventsViewModel) {
            super(1, widgetHubEventsViewModel, WidgetHubEventsViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            invoke2(widgetHubEventsViewModel3);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubEventsViewModel3, "p1");
            WidgetHubEventsViewModel.access$updateViewState((WidgetHubEventsViewModel) this.receiver, widgetHubEventsViewModel3);
        }
    }

    /* compiled from: WidgetHubEventsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsState;", "invoke", "()Lcom/discord/widgets/hubs/events/WidgetHubEventsState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsViewModel$getObservableFromStores$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<WidgetHubEventsViewModel3> {
        public final /* synthetic */ StoreChannels $channelsStore;
        public final /* synthetic */ StoreDirectories $directoriesStore;
        public final /* synthetic */ long $directoryChannelId;
        public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
        public final /* synthetic */ StoreGuilds $guildsStore;
        public final /* synthetic */ StorePermissions $permissionsStore;
        public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreDirectories storeDirectories, long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreGuilds storeGuilds) {
            super(0);
            this.$directoriesStore = storeDirectories;
            this.$directoryChannelId = j;
            this.$channelsStore = storeChannels;
            this.$guildScheduledEventsStore = storeGuildScheduledEvents;
            this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
            this.$permissionsStore = storePermissions;
            this.$guildsStore = storeGuilds;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ WidgetHubEventsViewModel3 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WidgetHubEventsViewModel3 invoke() {
            List<WidgetHubEventsViewModel2> listEmptyList;
            boolean z2;
            RestCallState<List<DirectoryEntryGuild2>> guildScheduledEventsForChannel = this.$directoriesStore.getGuildScheduledEventsForChannel(this.$directoryChannelId);
            if (guildScheduledEventsForChannel == null) {
                return WidgetHubEventsViewModel.access$getViewState$p(WidgetHubEventsViewModel.this);
            }
            List<DirectoryEntryGuild2> listInvoke = guildScheduledEventsForChannel.invoke();
            if (listInvoke != null) {
                listEmptyList = new ArrayList<>(Iterables2.collectionSizeOrDefault(listInvoke, 10));
                for (DirectoryEntryGuild2 directoryEntryGuild2 : listInvoke) {
                    long guildId = directoryEntryGuild2.getGuildScheduledEvent().getGuildId();
                    Long channelId = directoryEntryGuild2.getGuildScheduledEvent().getChannelId();
                    long j = this.$directoryChannelId;
                    GuildScheduledEvent guildScheduledEvent = directoryEntryGuild2.getGuildScheduledEvent();
                    Channel channel = channelId != null ? this.$channelsStore.getChannel(channelId.longValue()) : null;
                    boolean zContains = this.$guildScheduledEventsStore.getMeGuildScheduledEventIds(guildId).contains(Long.valueOf(directoryEntryGuild2.getGuildScheduledEvent().getId()));
                    GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
                    boolean zCanStartEvent$default = GuildScheduledEventUtilities.Companion.canStartEvent$default(companion, guildId, channelId, null, null, 12, null);
                    boolean zCanShareEvent$default = GuildScheduledEventUtilities.Companion.canShareEvent$default(companion, channelId, guildId, null, null, null, null, 60, null);
                    Long lValueOf = Long.valueOf(this.$voiceChannelSelectedStore.getSelectedVoiceChannelId());
                    if (!(lValueOf.longValue() != 0)) {
                        lValueOf = null;
                    }
                    if (lValueOf != null) {
                        z2 = channelId != null && lValueOf.longValue() == channelId.longValue();
                    }
                    listEmptyList.add(new WidgetHubEventsViewModel2(j, guildScheduledEvent, channel, zContains, zCanShareEvent$default, zCanStartEvent$default, channelId != null ? PermissionUtils.can(Permission.CONNECT, this.$permissionsStore.getPermissionsByChannel().get(Long.valueOf(channelId.longValue()))) : false, z2, this.$guildsStore.getGuild(guildId) != null));
                }
            } else {
                WidgetHubEventsViewModel3 widgetHubEventsViewModel3Access$getViewState$p = WidgetHubEventsViewModel.access$getViewState$p(WidgetHubEventsViewModel.this);
                List<WidgetHubEventsViewModel2> eventsData = widgetHubEventsViewModel3Access$getViewState$p != null ? widgetHubEventsViewModel3Access$getViewState$p.getEventsData() : null;
                listEmptyList = eventsData != null ? eventsData : Collections2.emptyList();
            }
            return new WidgetHubEventsViewModel3(!this.$directoriesStore.getGuildScheduledEventsHeaderDismissed(), listEmptyList, guildScheduledEventsForChannel);
        }
    }

    public /* synthetic */ WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 128) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 256) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ WidgetHubEventsViewModel3 access$getViewState$p(WidgetHubEventsViewModel widgetHubEventsViewModel) {
        return widgetHubEventsViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubEventsViewModel widgetHubEventsViewModel, WidgetHubEventsViewModel3 widgetHubEventsViewModel3) {
        widgetHubEventsViewModel.updateViewState(widgetHubEventsViewModel3);
    }

    private final Observable<WidgetHubEventsViewModel3> getObservableFromStores(ObservationDeck observationDeck, StoreDirectories directoriesStore, StoreGuilds guildsStore, StoreChannels channelsStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreGuildScheduledEvents guildScheduledEventsStore, StorePermissions permissionsStore, long directoryChannelId) {
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{directoriesStore, guildsStore, channelsStore, voiceChannelSelectedStore, guildScheduledEventsStore, permissionsStore}, false, null, null, new AnonymousClass1(directoriesStore, directoryChannelId, channelsStore, guildScheduledEventsStore, voiceChannelSelectedStore, permissionsStore, guildsStore), 14, null);
    }

    public final void dismissHeader() {
        WidgetHubEventsViewModel3 viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetHubEventsViewModel3.copy$default(viewState, false, null, null, 6, null));
        }
        this.directoriesStore.markGuildScheduledEventsHeaderDismissed();
    }

    public final void fetchGuildScheduledEvents() {
        this.directoriesStore.fetchGuildScheduledEventsForChannel(this.guildId, this.directoryChannelId);
    }

    public final StoreGuildScheduledEvents getGuildScheduledEventsStore() {
        return this.guildScheduledEventsStore;
    }

    public final void reset() {
        WidgetHubEventsViewModel3 viewState = getViewState();
        Intrinsics3.checkNotNull(viewState);
        updateViewState(WidgetHubEventsViewModel3.copy$default(viewState, false, null, RestCallState2.INSTANCE, 3, null));
    }

    public final void toggleRsvp(GuildScheduledEvent event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        this.guildScheduledEventsStore.toggleMeRsvpForEvent(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsViewModel(long j, long j2, StoreDirectories storeDirectories, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, ObservationDeck observationDeck) {
        super(new WidgetHubEventsViewModel3(false, null, null, 7, null));
        Intrinsics3.checkNotNullParameter(storeDirectories, "directoriesStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildId = j;
        this.directoryChannelId = j2;
        this.directoriesStore = storeDirectories;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        Observable observableG = ObservableExtensionsKt.computationLatest(getObservableFromStores(observationDeck, storeDirectories, storeGuilds, storeChannels, storeVoiceChannelSelected, storeGuildScheduledEvents, storePermissions, j2)).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableG, this, null, 2, null), WidgetHubEventsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        fetchGuildScheduledEvents();
    }
}
