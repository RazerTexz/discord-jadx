package com.discord.widgets.hubs;

import android.content.Context;
import b.a.d.AppViewModel;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionDirectoryGuildEntryCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.AdaptedFunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetHubDescriptionViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)BK\u0012\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f\u0012\n\u0010\u0012\u001a\u00060\u000ej\u0002`\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010$\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020%¢\u0006\u0004\b'\u0010(J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0015\u001a\u00020\u00042\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0012\u001a\u00060\u000ej\u0002`\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0019\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\u0012\u001a\u00060\u000ej\u0002`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b#\u0010\u0019¨\u0006*"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubDescriptionViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/hubs/HubDescriptionState;", "state", "", "handleStoreUpdate", "(Lcom/discord/widgets/hubs/HubDescriptionState;)Lkotlin/Unit;", "Lcom/discord/models/hubs/DirectoryEntryCategory;", "getCategory", "()Lcom/discord/models/hubs/DirectoryEntryCategory;", "", "key", "setCategory", "(I)Lkotlin/Unit;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "addServer", "(JJLjava/lang/String;)V", "J", "getChannelId", "()J", "", "isEditing", "Z", "()Z", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "getRestAPI", "()Lcom/discord/utilities/rest/RestAPI;", "getGuildId", "primaryCategoryId", "Lrx/Observable;", "storeObservable", "<init>", "(JJZLjava/lang/Integer;Lcom/discord/utilities/rest/RestAPI;Lrx/Observable;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel extends AppViewModel<WidgetHubDescriptionViewModel3> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long guildId;
    private final boolean isEditing;
    private final RestAPI restAPI;

    /* compiled from: WidgetHubDescriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/hubs/HubDescriptionState;", "p1", "", "invoke", "(Lcom/discord/widgets/hubs/HubDescriptionState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<WidgetHubDescriptionViewModel3, Unit> {
        public AnonymousClass1(WidgetHubDescriptionViewModel widgetHubDescriptionViewModel) {
            super(1, widgetHubDescriptionViewModel, WidgetHubDescriptionViewModel.class, "handleStoreUpdate", "handleStoreUpdate(Lcom/discord/widgets/hubs/HubDescriptionState;)Lkotlin/Unit;", 8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            invoke2(widgetHubDescriptionViewModel3);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubDescriptionViewModel3, "p1");
            WidgetHubDescriptionViewModel.access$handleStoreUpdate((WidgetHubDescriptionViewModel) this.receiver, widgetHubDescriptionViewModel3);
        }
    }

    /* compiled from: WidgetHubDescriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubDescriptionViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lrx/Observable;", "Lcom/discord/widgets/hubs/HubDescriptionState;", "observeStores", "(JJLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<WidgetHubDescriptionViewModel3> observeStores(long channelId, long guildId, ObservationDeck observationDeck, StoreChannels channelStore, StoreGuilds guildStore) {
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            Intrinsics3.checkNotNullParameter(channelStore, "channelStore");
            Intrinsics3.checkNotNullParameter(guildStore, "guildStore");
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{channelStore, guildStore}, false, null, null, new WidgetHubDescriptionViewModel4(channelStore, channelId, guildStore, guildId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHubDescriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/directory/DirectoryEntryGuild;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/directory/DirectoryEntryGuild;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$addServer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<DirectoryEntryGuild, TrackNetworkMetadata2> {
        public final /* synthetic */ DirectoryEntryCategory $category;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, DirectoryEntryCategory directoryEntryCategory) {
            super(1);
            this.$channelId = j;
            this.$guildId = j2;
            this.$category = directoryEntryCategory;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(DirectoryEntryGuild directoryEntryGuild) {
            return invoke2(directoryEntryGuild);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(DirectoryEntryGuild directoryEntryGuild) {
            return new TrackNetworkActionDirectoryGuildEntryCreate(Long.valueOf(this.$channelId), Long.valueOf(this.$guildId), Long.valueOf(this.$category.getKey()));
        }
    }

    /* compiled from: WidgetHubDescriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/directory/DirectoryEntryGuild;", "it", "", "invoke", "(Lcom/discord/stores/utilities/RestCallState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$addServer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState<? extends DirectoryEntryGuild>, Unit> {
        public final /* synthetic */ WidgetHubDescriptionViewModel3 $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
            super(1);
            this.$state = widgetHubDescriptionViewModel3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends DirectoryEntryGuild> restCallState) {
            invoke2((RestCallState<DirectoryEntryGuild>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<DirectoryEntryGuild> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "it");
            WidgetHubDescriptionViewModel.access$updateViewState(WidgetHubDescriptionViewModel.this, WidgetHubDescriptionViewModel3.copy$default(this.$state, null, null, null, restCallState, 7, null));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetHubDescriptionViewModel(long j, long j2, boolean z2, Integer num, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStores;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStores = companion.observeStores(j, j2, observationDeck, companion2.getChannels(), companion2.getGuilds());
        } else {
            observableObserveStores = observable;
        }
        this(j, j2, z2, num, api, observableObserveStores);
    }

    public static final /* synthetic */ Unit access$handleStoreUpdate(WidgetHubDescriptionViewModel widgetHubDescriptionViewModel, WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        return widgetHubDescriptionViewModel.handleStoreUpdate(widgetHubDescriptionViewModel3);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubDescriptionViewModel widgetHubDescriptionViewModel, WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        widgetHubDescriptionViewModel.updateViewState(widgetHubDescriptionViewModel3);
    }

    private final Unit handleStoreUpdate(WidgetHubDescriptionViewModel3 state) {
        WidgetHubDescriptionViewModel3 viewState = getViewState();
        if (viewState == null) {
            return null;
        }
        updateViewState(WidgetHubDescriptionViewModel3.copy$default(viewState, state.getChannel(), null, state.getGuildName(), null, 10, null));
        return Unit.a;
    }

    public final void addServer(long channelId, long guildId, String description) {
        DirectoryEntryCategory selectedCategory;
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        WidgetHubDescriptionViewModel3 viewState = getViewState();
        if (viewState == null || (selectedCategory = viewState.getSelectedCategory()) == null) {
            return;
        }
        RestCallState5.executeRequest(this.isEditing ? this.restAPI.modifyServerInHub(channelId, guildId, new RestAPIParams.AddServerBody(description, selectedCategory.getKey())) : RestCallState5.logNetworkAction(this.restAPI.addServerToHub(channelId, guildId, new RestAPIParams.AddServerBody(description, selectedCategory.getKey())), new AnonymousClass1(channelId, guildId, selectedCategory)), new AnonymousClass2(viewState));
    }

    public final DirectoryEntryCategory getCategory() {
        WidgetHubDescriptionViewModel3 viewState = getViewState();
        if (viewState != null) {
            return viewState.getSelectedCategory();
        }
        return null;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    /* renamed from: isEditing, reason: from getter */
    public final boolean getIsEditing() {
        return this.isEditing;
    }

    public final Unit setCategory(int key) {
        WidgetHubDescriptionViewModel3 viewState = getViewState();
        if (viewState == null) {
            return null;
        }
        updateViewState(WidgetHubDescriptionViewModel3.copy$default(viewState, null, Integer.valueOf(key), null, null, 13, null));
        return Unit.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescriptionViewModel(long j, long j2, boolean z2, Integer num, RestAPI restAPI, Observable<WidgetHubDescriptionViewModel3> observable) {
        super(new WidgetHubDescriptionViewModel3(null, num, null, null, 13, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.channelId = j;
        this.guildId = j2;
        this.isEditing = z2;
        this.restAPI = restAPI;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetHubDescriptionViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
