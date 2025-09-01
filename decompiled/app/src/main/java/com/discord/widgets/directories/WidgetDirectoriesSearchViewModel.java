package com.discord.widgets.directories;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import d0.LazyJVM;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: WidgetDirectoriesSearchViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/0B7\u0012\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020+¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00042\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u0018\u001a\u00060\u000fj\u0002`\u00172\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00042\n\u0010\u0018\u001a\u00060\u000fj\u0002`\u00172\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010'\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;", "state", "", "handleNewState", "(Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;)V", "", "getHubName", "()Ljava/lang/String;", "", "searchTerm", "", "shouldNotSearch", "(Ljava/lang/CharSequence;)Z", "", "Lcom/discord/primitives/ChannelId;", "channelId", "query", "searchForDirectories", "(JLjava/lang/CharSequence;)V", "Landroid/content/Context;", "context", "Lcom/discord/primitives/GuildId;", ModelAuditLogEntry.CHANGE_KEY_ID, "directoryChannelId", "joinGuild", "(Landroid/content/Context;JJ)V", "removeGuild", "(JJ)V", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "getRestAPI", "()Lcom/discord/utilities/rest/RestAPI;", "J", "getChannelId", "()J", "Lcom/discord/stores/StoreDirectories;", "directoriesStore", "Lcom/discord/stores/StoreDirectories;", "getDirectoriesStore", "()Lcom/discord/stores/StoreDirectories;", "Lrx/Observable;", "storeObservable", "<init>", "(JLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreDirectories;Lrx/Observable;)V", "Companion", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreDirectories directoriesStore;
    private final RestAPI restAPI;

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ViewState, Unit> {
        public AnonymousClass1(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel) {
            super(1, widgetDirectoriesSearchViewModel, WidgetDirectoriesSearchViewModel.class, "handleNewState", "handleNewState(Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetDirectoriesSearchViewModel.access$handleNewState((WidgetDirectoriesSearchViewModel) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JI\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuildSelected;", "guildSelectedStore", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lrx/Observable;", "Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;", "observeStores", "(JLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreGuildSelected;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreChannels storeChannels, StorePermissions storePermissions) {
            return companion.observeStores(j, observationDeck, storeGuilds, storeGuildSelected, storeChannels, storePermissions);
        }

        private final Observable<ViewState> observeStores(long channelId, ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildSelectedStore, StoreChannels channelsStore, StorePermissions permissionsStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildsStore, guildSelectedStore, channelsStore, permissionsStore}, false, null, null, new WidgetDirectoriesSearchViewModel2(permissionsStore, guildsStore, guildSelectedStore, channelId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$joinGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Guild, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
        }
    }

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/utilities/RestCallState;", "", "Lcom/discord/api/directory/DirectoryEntryGuild;", "entriesState", "", "invoke", "(Lcom/discord/stores/utilities/RestCallState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesSearchViewModel$searchForDirectories$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState<? extends List<? extends DirectoryEntryGuild>>, Unit> {
        public final /* synthetic */ CharSequence $query;
        public final /* synthetic */ ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState viewState, CharSequence charSequence) {
            super(1);
            this.$viewState = viewState;
            this.$query = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends List<? extends DirectoryEntryGuild>> restCallState) {
            invoke2((RestCallState<? extends List<DirectoryEntryGuild>>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "entriesState");
            WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel = WidgetDirectoriesSearchViewModel.this;
            ViewState viewState = this.$viewState;
            String string = this.$query.toString();
            List<DirectoryEntryGuild> listInvoke = restCallState.invoke();
            if (listInvoke == null) {
                listInvoke = this.$viewState.getDirectories();
            }
            WidgetDirectoriesSearchViewModel.access$updateViewState(widgetDirectoriesSearchViewModel, ViewState.copy$default(viewState, null, string, listInvoke, null, null, false, restCallState, 57, null));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetDirectoriesSearchViewModel(long j, RestAPI restAPI, StoreDirectories storeDirectories, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreDirectories directories = (i & 4) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStores = Companion.access$observeStores(companion, j, observationDeck, companion2.getGuilds(), companion2.getGuildSelected(), companion2.getChannels(), companion2.getPermissions());
        } else {
            observableAccess$observeStores = observable;
        }
        this(j, api, directories, observableAccess$observeStores);
    }

    public static final /* synthetic */ void access$handleNewState(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel, ViewState viewState) {
        widgetDirectoriesSearchViewModel.handleNewState(viewState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetDirectoriesSearchViewModel widgetDirectoriesSearchViewModel, ViewState viewState) {
        widgetDirectoriesSearchViewModel.updateViewState(viewState);
    }

    private final void handleNewState(ViewState state) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, state.getGuild(), null, null, state.getJoinedGuildIds(), state.getAdminGuildIds(), state.getHasAddGuildPermissions(), null, 70, null));
        }
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final StoreDirectories getDirectoriesStore() {
        return this.directoriesStore;
    }

    public final String getHubName() {
        com.discord.models.guild.Guild guild;
        ViewState viewState = getViewState();
        String name = (viewState == null || (guild = viewState.getGuild()) == null) ? null : guild.getName();
        return name != null ? name : "";
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinGuild(Context context, long id2, long directoryChannelId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        GuildJoinHelper.joinGuild$default(context, id2, false, null, Long.valueOf(directoryChannelId), this.restAPI.jsonObjectOf(Tuples.to("source", DirectoryUtils.JOIN_GUILD_SOURCE)), WidgetDirectoriesSearchViewModel.class, null, null, null, AnonymousClass1.INSTANCE, 896, null);
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        this.directoriesStore.removeServerFromDirectory(directoryChannelId, id2);
    }

    public final void searchForDirectories(long channelId, CharSequence query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        ViewState viewState = getViewState();
        if (viewState == null || shouldNotSearch(query)) {
            return;
        }
        RestCallState5.executeRequest(this.restAPI.searchServers(channelId, query.toString()), new AnonymousClass1(viewState, query));
    }

    public final boolean shouldNotSearch(CharSequence searchTerm) {
        Intrinsics3.checkNotNullParameter(searchTerm, "searchTerm");
        if (!StringsJVM.isBlank(searchTerm)) {
            ViewState viewState = getViewState();
            if (!Intrinsics3.areEqual(viewState != null ? viewState.getCurrentSearchTerm() : null, searchTerm.toString())) {
                return false;
            }
        }
        return true;
    }

    /* compiled from: WidgetDirectoriesSearchViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f\u0012\u0012\b\u0002\u0010\u001c\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0015¢\u0006\u0004\b:\u0010;J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J~\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00052\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0015HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b!\u0010\u0007J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R#\u0010\u001c\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010(\u001a\u0004\b)\u0010\u0010R%\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b+\u0010\u0017R#\u00100\u001a\b\u0012\u0004\u0012\u00020,0\b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u000bR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00103\u001a\u0004\b4\u0010\u0014R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\b6\u0010\u0007R#\u0010\u001b\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b7\u0010\u0010R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00108\u001a\u0004\b9\u0010\u000b¨\u0006<"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "component2", "()Ljava/lang/String;", "", "Lcom/discord/api/directory/DirectoryEntryGuild;", "component3", "()Ljava/util/List;", "", "", "Lcom/discord/primitives/GuildId;", "component4", "()Ljava/util/Set;", "component5", "", "component6", "()Z", "Lcom/discord/stores/utilities/RestCallState;", "component7", "()Lcom/discord/stores/utilities/RestCallState;", "guild", "currentSearchTerm", "directories", "joinedGuildIds", "adminGuildIds", "hasAddGuildPermissions", "directoriesState", "copy", "(Lcom/discord/models/guild/Guild;Ljava/lang/String;Ljava/util/List;Ljava/util/Set;Ljava/util/Set;ZLcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/directories/WidgetDirectoriesSearchViewModel$ViewState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getAdminGuildIds", "Lcom/discord/stores/utilities/RestCallState;", "getDirectoriesState", "Lcom/discord/widgets/directories/DirectoryEntryData;", "directoryEntryData$delegate", "Lkotlin/Lazy;", "getDirectoryEntryData", "directoryEntryData", "Lcom/discord/models/guild/Guild;", "getGuild", "Z", "getHasAddGuildPermissions", "Ljava/lang/String;", "getCurrentSearchTerm", "getJoinedGuildIds", "Ljava/util/List;", "getDirectories", "<init>", "(Lcom/discord/models/guild/Guild;Ljava/lang/String;Ljava/util/List;Ljava/util/Set;Ljava/util/Set;ZLcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final Set<Long> adminGuildIds;
        private final String currentSearchTerm;
        private final List<DirectoryEntryGuild> directories;
        private final RestCallState<List<DirectoryEntryGuild>> directoriesState;

        /* renamed from: directoryEntryData$delegate, reason: from kotlin metadata */
        private final Lazy directoryEntryData;
        private final com.discord.models.guild.Guild guild;
        private final boolean hasAddGuildPermissions;
        private final Set<Long> joinedGuildIds;

        public ViewState() {
            this(null, null, null, null, null, false, null, Opcodes.LAND, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(com.discord.models.guild.Guild guild, String str, List<DirectoryEntryGuild> list, Set<Long> set, Set<Long> set2, boolean z2, RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
            Intrinsics3.checkNotNullParameter(str, "currentSearchTerm");
            Intrinsics3.checkNotNullParameter(list, "directories");
            Intrinsics3.checkNotNullParameter(set, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(set2, "adminGuildIds");
            Intrinsics3.checkNotNullParameter(restCallState, "directoriesState");
            this.guild = guild;
            this.currentSearchTerm = str;
            this.directories = list;
            this.joinedGuildIds = set;
            this.adminGuildIds = set2;
            this.hasAddGuildPermissions = z2;
            this.directoriesState = restCallState;
            this.directoryEntryData = LazyJVM.lazy(new WidgetDirectoriesSearchViewModel3(this));
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, com.discord.models.guild.Guild guild, String str, List list, Set set, Set set2, boolean z2, RestCallState restCallState, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = viewState.guild;
            }
            if ((i & 2) != 0) {
                str = viewState.currentSearchTerm;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                list = viewState.directories;
            }
            List list2 = list;
            if ((i & 8) != 0) {
                set = viewState.joinedGuildIds;
            }
            Set set3 = set;
            if ((i & 16) != 0) {
                set2 = viewState.adminGuildIds;
            }
            Set set4 = set2;
            if ((i & 32) != 0) {
                z2 = viewState.hasAddGuildPermissions;
            }
            boolean z3 = z2;
            if ((i & 64) != 0) {
                restCallState = viewState.directoriesState;
            }
            return viewState.copy(guild, str2, list2, set3, set4, z3, restCallState);
        }

        /* renamed from: component1, reason: from getter */
        public final com.discord.models.guild.Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCurrentSearchTerm() {
            return this.currentSearchTerm;
        }

        public final List<DirectoryEntryGuild> component3() {
            return this.directories;
        }

        public final Set<Long> component4() {
            return this.joinedGuildIds;
        }

        public final Set<Long> component5() {
            return this.adminGuildIds;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getHasAddGuildPermissions() {
            return this.hasAddGuildPermissions;
        }

        public final RestCallState<List<DirectoryEntryGuild>> component7() {
            return this.directoriesState;
        }

        public final ViewState copy(com.discord.models.guild.Guild guild, String currentSearchTerm, List<DirectoryEntryGuild> directories, Set<Long> joinedGuildIds, Set<Long> adminGuildIds, boolean hasAddGuildPermissions, RestCallState<? extends List<DirectoryEntryGuild>> directoriesState) {
            Intrinsics3.checkNotNullParameter(currentSearchTerm, "currentSearchTerm");
            Intrinsics3.checkNotNullParameter(directories, "directories");
            Intrinsics3.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(adminGuildIds, "adminGuildIds");
            Intrinsics3.checkNotNullParameter(directoriesState, "directoriesState");
            return new ViewState(guild, currentSearchTerm, directories, joinedGuildIds, adminGuildIds, hasAddGuildPermissions, directoriesState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.guild, viewState.guild) && Intrinsics3.areEqual(this.currentSearchTerm, viewState.currentSearchTerm) && Intrinsics3.areEqual(this.directories, viewState.directories) && Intrinsics3.areEqual(this.joinedGuildIds, viewState.joinedGuildIds) && Intrinsics3.areEqual(this.adminGuildIds, viewState.adminGuildIds) && this.hasAddGuildPermissions == viewState.hasAddGuildPermissions && Intrinsics3.areEqual(this.directoriesState, viewState.directoriesState);
        }

        public final Set<Long> getAdminGuildIds() {
            return this.adminGuildIds;
        }

        public final String getCurrentSearchTerm() {
            return this.currentSearchTerm;
        }

        public final List<DirectoryEntryGuild> getDirectories() {
            return this.directories;
        }

        public final RestCallState<List<DirectoryEntryGuild>> getDirectoriesState() {
            return this.directoriesState;
        }

        public final List<DirectoryEntryData> getDirectoryEntryData() {
            return (List) this.directoryEntryData.getValue();
        }

        public final com.discord.models.guild.Guild getGuild() {
            return this.guild;
        }

        public final boolean getHasAddGuildPermissions() {
            return this.hasAddGuildPermissions;
        }

        public final Set<Long> getJoinedGuildIds() {
            return this.joinedGuildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            com.discord.models.guild.Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            String str = this.currentSearchTerm;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<DirectoryEntryGuild> list = this.directories;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Set<Long> set = this.joinedGuildIds;
            int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
            Set<Long> set2 = this.adminGuildIds;
            int iHashCode5 = (iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31;
            boolean z2 = this.hasAddGuildPermissions;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode5 + i) * 31;
            RestCallState<List<DirectoryEntryGuild>> restCallState = this.directoriesState;
            return i2 + (restCallState != null ? restCallState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(guild=");
            sbU.append(this.guild);
            sbU.append(", currentSearchTerm=");
            sbU.append(this.currentSearchTerm);
            sbU.append(", directories=");
            sbU.append(this.directories);
            sbU.append(", joinedGuildIds=");
            sbU.append(this.joinedGuildIds);
            sbU.append(", adminGuildIds=");
            sbU.append(this.adminGuildIds);
            sbU.append(", hasAddGuildPermissions=");
            sbU.append(this.hasAddGuildPermissions);
            sbU.append(", directoriesState=");
            sbU.append(this.directoriesState);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(com.discord.models.guild.Guild guild, String str, List list, Set set, Set set2, boolean z2, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guild, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? Collections2.emptyList() : list, (i & 8) != 0 ? Sets5.emptySet() : set, (i & 16) != 0 ? Sets5.emptySet() : set2, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? RestCallState2.INSTANCE : restCallState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearchViewModel(long j, RestAPI restAPI, StoreDirectories storeDirectories, Observable<ViewState> observable) {
        super(new ViewState(null, null, null, null, null, false, null, Opcodes.LAND, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeDirectories, "directoriesStore");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.channelId = j;
        this.restAPI = restAPI;
        this.directoriesStore = storeDirectories;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetDirectoriesSearchViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
