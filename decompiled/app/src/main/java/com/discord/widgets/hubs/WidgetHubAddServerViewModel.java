package com.discord.widgets.hubs;

import android.content.Context;
import b.a.d.AppViewModel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetHubAddServerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\u00042\n\u0010\u0013\u001a\u00060\u000bj\u0002`\u00122\n\u0010\u0014\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubAddServerViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/hubs/HubAddServerState;", "state", "", "handleStoreUpdate", "(Lcom/discord/widgets/hubs/HubAddServerState;)V", "", "index", "setIndex", "(I)V", "", "Lcom/discord/primitives/ChannelId;", "getChannelId", "()Ljava/lang/Long;", "", "getHubName", "()Ljava/lang/String;", "Lcom/discord/primitives/GuildId;", ModelAuditLogEntry.CHANGE_KEY_ID, "directoryChannelId", "removeGuild", "(JJ)V", "Lrx/Observable;", "storeObservable", "<init>", "(Lrx/Observable;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubAddServerViewModel extends AppViewModel<WidgetHubAddServerViewModel2> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetHubAddServerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/hubs/HubAddServerState;", "p1", "", "invoke", "(Lcom/discord/widgets/hubs/HubAddServerState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddServerViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubAddServerViewModel2, Unit> {
        public AnonymousClass1(WidgetHubAddServerViewModel widgetHubAddServerViewModel) {
            super(1, widgetHubAddServerViewModel, WidgetHubAddServerViewModel.class, "handleStoreUpdate", "handleStoreUpdate(Lcom/discord/widgets/hubs/HubAddServerState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
            invoke2(widgetHubAddServerViewModel2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
            Intrinsics3.checkNotNullParameter(widgetHubAddServerViewModel2, "p1");
            WidgetHubAddServerViewModel.access$handleStoreUpdate((WidgetHubAddServerViewModel) this.receiver, widgetHubAddServerViewModel2);
        }
    }

    /* compiled from: WidgetHubAddServerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JM\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubAddServerViewModel$Companion;", "", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuildSelected;", "guildsSelected", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannelsSelected;", "channelsSelectedStore", "Lcom/discord/stores/StoreDirectories;", "directoriesStore", "Lrx/Observable;", "Lcom/discord/widgets/hubs/HubAddServerState;", "observeStores", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreGuildSelected;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreDirectories;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StorePermissions storePermissions, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreDirectories storeDirectories) {
            return companion.observeStores(observationDeck, storeGuilds, storeGuildSelected, storePermissions, storeChannels, storeChannelsSelected, storeDirectories);
        }

        private final Observable<WidgetHubAddServerViewModel2> observeStores(ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildsSelected, StorePermissions permissionsStore, StoreChannels channelsStore, StoreChannelsSelected channelsSelectedStore, StoreDirectories directoriesStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildsStore, guildsSelected, permissionsStore, channelsStore, channelsSelectedStore, directoriesStore}, false, null, null, new WidgetHubAddServerViewModel3(guildsStore, guildsSelected, permissionsStore, channelsSelectedStore, channelsStore, directoriesStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetHubAddServerViewModel() {
        this(null, 1, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHubAddServerViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStores(companion, observationDeck, companion2.getGuilds(), companion2.getGuildSelected(), companion2.getPermissions(), companion2.getChannels(), companion2.getChannelsSelected(), companion2.getDirectories());
        }
        this(observable);
    }

    public static final /* synthetic */ void access$handleStoreUpdate(WidgetHubAddServerViewModel widgetHubAddServerViewModel, WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
        widgetHubAddServerViewModel.handleStoreUpdate(widgetHubAddServerViewModel2);
    }

    private final void handleStoreUpdate(WidgetHubAddServerViewModel2 state) {
        updateViewState(WidgetHubAddServerViewModel2.copy$default(requireViewState(), state.getHubName(), state.getDirectoryChannelId(), 0, state.getSelectableGuilds(), state.getAddedGuilds(), state.getAddedDirectories(), 4, null));
    }

    public final Long getChannelId() {
        WidgetHubAddServerViewModel2 viewState = getViewState();
        if (viewState != null) {
            return viewState.getDirectoryChannelId();
        }
        return null;
    }

    public final String getHubName() {
        WidgetHubAddServerViewModel2 viewState = getViewState();
        String hubName = viewState != null ? viewState.getHubName() : null;
        return hubName != null ? hubName : "";
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        StoreStream.INSTANCE.getDirectories().removeServerFromDirectory(directoryChannelId, id2);
    }

    public final void setIndex(int index) {
        updateViewState(WidgetHubAddServerViewModel2.copy$default(requireViewState(), null, null, index, null, null, null, 59, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServerViewModel(Observable<WidgetHubAddServerViewModel2> observable) {
        super(new WidgetHubAddServerViewModel2(null, null, 0, null, null, null, 63, null));
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetHubAddServerViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
