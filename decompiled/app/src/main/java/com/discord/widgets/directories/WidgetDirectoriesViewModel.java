package com.discord.widgets.directories;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Sets5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: WidgetDirectoriesViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%BI\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 ¢\u0006\u0004\b\"\u0010#J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u00020\f2\n\u0010\n\u001a\u00060\bj\u0002`\t2\n\u0010\u000b\u001a\u00060\bj\u0002`\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "", "getHubName", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", ModelAuditLogEntry.CHANGE_KEY_ID, "directoryChannelId", "", "joinGuild", "(Landroid/content/Context;JJ)V", "Lcom/discord/primitives/ChannelId;", "removeGuild", "(JJ)V", "Lcom/discord/stores/StoreDirectories;", "directoriesStore", "Lcom/discord/stores/StoreDirectories;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "getRestAPI", "()Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreChannelsSelected;", "channelsSelectedStore", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreReadStates;", "readStatesStore", "Lrx/Observable;", "storeObservable", "<init>", "(Lcom/discord/stores/StoreDirectories;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreReadStates;Lcom/discord/utilities/rest/RestAPI;Lrx/Observable;)V", "Companion", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreDirectories directoriesStore;
    private final RestAPI restAPI;

    /* compiled from: WidgetDirectoriesViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ViewState, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(ViewState viewState) {
            Channel channel = viewState.getChannel();
            return Boolean.valueOf(channel != null && ChannelUtils.o(channel));
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ViewState, Unit> {
        public AnonymousClass2(WidgetDirectoriesViewModel widgetDirectoriesViewModel) {
            super(1, widgetDirectoriesViewModel, WidgetDirectoriesViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetDirectoriesViewModel.access$updateViewState((WidgetDirectoriesViewModel) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Channel, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Channel channel) {
            return Boolean.valueOf(channel != null && ChannelUtils.o(channel));
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            WidgetDirectoriesViewModel.access$getDirectoriesStore$p(WidgetDirectoriesViewModel.this).fetchDirectoriesForChannel(channel.getId());
            WidgetDirectoriesViewModel.access$getDirectoriesStore$p(WidgetDirectoriesViewModel.this).fetchEntryCountsForChannel(channel.getId());
            WidgetDirectoriesViewModel.access$getDirectoriesStore$p(WidgetDirectoriesViewModel.this).fetchGuildScheduledEventsForChannel(channel.getGuildId(), channel.getId());
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", ModelAuditLogEntry.CHANGE_KEY_ID, "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$5, reason: invalid class name */
    public static final class AnonymousClass5<T, R> implements Func1<Long, Boolean> {
        public final /* synthetic */ StoreChannels $channelsStore;

        public AnonymousClass5(StoreChannels storeChannels) {
            this.$channelsStore = storeChannels;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Long l) {
            StoreChannels storeChannels = this.$channelsStore;
            Intrinsics3.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
            Channel channelFindChannelById = storeChannels.findChannelById(l.longValue());
            return Boolean.valueOf(channelFindChannelById != null && ChannelUtils.o(channelFindChannelById));
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ StoreReadStates $readStatesStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(StoreReadStates storeReadStates) {
            super(1);
            this.$readStatesStore = storeReadStates;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            this.$readStatesStore.markAsRead(l);
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JE\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$Companion;", "", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuildSelected;", "guildSelectedStore", "Lcom/discord/stores/StoreChannelsSelected;", "channelsSelectedStore", "Lcom/discord/stores/StoreDirectories;", "directoriesStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lrx/Observable;", "Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "observeStores", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreGuildSelected;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreDirectories;Lcom/discord/stores/StorePermissions;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreChannelsSelected storeChannelsSelected, StoreDirectories storeDirectories, StorePermissions storePermissions) {
            return companion.observeStores(observationDeck, storeGuilds, storeGuildSelected, storeChannelsSelected, storeDirectories, storePermissions);
        }

        private final Observable<ViewState> observeStores(ObservationDeck observationDeck, StoreGuilds guildsStore, StoreGuildSelected guildSelectedStore, StoreChannelsSelected channelsSelectedStore, StoreDirectories directoriesStore, StorePermissions permissionsStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildsStore, guildSelectedStore, directoriesStore, channelsSelectedStore, permissionsStore}, false, null, null, new WidgetDirectoriesViewModel2(channelsSelectedStore, guildSelectedStore, guildsStore, permissionsStore, directoriesStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$joinGuild$1, reason: invalid class name */
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

    public WidgetDirectoriesViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetDirectoriesViewModel(StoreDirectories storeDirectories, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreReadStates storeReadStates, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        StoreDirectories directories = (i & 1) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories;
        StoreChannelsSelected channelsSelected = (i & 2) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreReadStates readStates = (i & 8) != 0 ? StoreStream.INSTANCE.getReadStates() : storeReadStates;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStores = Companion.access$observeStores(companion, observationDeck, companion2.getGuilds(), companion2.getGuildSelected(), companion2.getChannelsSelected(), companion2.getDirectories(), companion2.getPermissions());
        } else {
            observableAccess$observeStores = observable;
        }
        this(directories, channelsSelected, channels, readStates, api, observableAccess$observeStores);
    }

    public static final /* synthetic */ StoreDirectories access$getDirectoriesStore$p(WidgetDirectoriesViewModel widgetDirectoriesViewModel) {
        return widgetDirectoriesViewModel.directoriesStore;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetDirectoriesViewModel widgetDirectoriesViewModel, ViewState viewState) {
        widgetDirectoriesViewModel.updateViewState(viewState);
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
        GuildJoinHelper.joinGuild$default(context, id2, false, null, Long.valueOf(directoryChannelId), this.restAPI.jsonObjectOf(Tuples.to("source", DirectoryUtils.JOIN_GUILD_SOURCE)), WidgetDirectoriesViewModel.class, null, null, null, AnonymousClass1.INSTANCE, 896, null);
    }

    public final void removeGuild(long id2, long directoryChannelId) {
        this.directoriesStore.removeServerFromDirectory(directoryChannelId, id2);
    }

    /* compiled from: WidgetDirectoriesViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\b\u0012\u0012\b\u0002\u0010\u001c\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011\u0012\u001a\b\u0002\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00160\u0011¢\u0006\u0004\bE\u0010FJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\r\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\bHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00160\u0011HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0015J\u008c\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\b2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\b2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\u001a\b\u0002\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00160\u0011HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)R#\u0010\u001b\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010\fR#\u00101\u001a\b\u0012\u0004\u0012\u00020,0\u00128F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u0010\u0007R/\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u0017040\u00128F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b7\u00100R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00109\u001a\u0004\b:\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010;\u001a\u0004\b<\u0010\u0010R+\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00160\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010=\u001a\u0004\b>\u0010\u0015R/\u0010B\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00120\u00168F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010.\u001a\u0004\b@\u0010AR%\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010=\u001a\u0004\bC\u0010\u0015R#\u0010\u001c\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\bD\u0010\f¨\u0006G"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/primitives/GuildId;", "component3", "()Ljava/util/Set;", "component4", "", "component5", "()Z", "Lcom/discord/stores/utilities/RestCallState;", "", "Lcom/discord/api/directory/DirectoryEntryGuild;", "component6", "()Lcom/discord/stores/utilities/RestCallState;", "", "", "component7", "guild", "channel", "joinedGuildIds", "adminGuildIds", "hasAddGuildPermissions", "directories", "tabs", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Set;Ljava/util/Set;ZLcom/discord/stores/utilities/RestCallState;Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getJoinedGuildIds", "Lcom/discord/widgets/directories/DirectoryEntryData;", "allDirectoryEntryData$delegate", "Lkotlin/Lazy;", "getAllDirectoryEntryData", "()Ljava/util/List;", "allDirectoryEntryData", "Lcom/discord/api/channel/Channel;", "getChannel", "Lkotlin/Pair;", "Lcom/discord/models/hubs/DirectoryEntryCategory;", "mappedTabs$delegate", "getMappedTabs", "mappedTabs", "Lcom/discord/models/guild/Guild;", "getGuild", "Z", "getHasAddGuildPermissions", "Lcom/discord/stores/utilities/RestCallState;", "getTabs", "directoryEntryData$delegate", "getDirectoryEntryData", "()Ljava/util/Map;", "directoryEntryData", "getDirectories", "getAdminGuildIds", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Set;Ljava/util/Set;ZLcom/discord/stores/utilities/RestCallState;Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final Set<Long> adminGuildIds;

        /* renamed from: allDirectoryEntryData$delegate, reason: from kotlin metadata */
        private final Lazy allDirectoryEntryData;
        private final Channel channel;
        private final RestCallState<List<DirectoryEntryGuild>> directories;

        /* renamed from: directoryEntryData$delegate, reason: from kotlin metadata */
        private final Lazy directoryEntryData;
        private final com.discord.models.guild.Guild guild;
        private final boolean hasAddGuildPermissions;
        private final Set<Long> joinedGuildIds;

        /* renamed from: mappedTabs$delegate, reason: from kotlin metadata */
        private final Lazy mappedTabs;
        private final RestCallState<Map<Integer, Integer>> tabs;

        public ViewState() {
            this(null, null, null, null, false, null, null, Opcodes.LAND, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(com.discord.models.guild.Guild guild, Channel channel, Set<Long> set, Set<Long> set2, boolean z2, RestCallState<? extends List<DirectoryEntryGuild>> restCallState, RestCallState<? extends Map<Integer, Integer>> restCallState2) {
            Intrinsics3.checkNotNullParameter(set, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(set2, "adminGuildIds");
            Intrinsics3.checkNotNullParameter(restCallState, "directories");
            Intrinsics3.checkNotNullParameter(restCallState2, "tabs");
            this.guild = guild;
            this.channel = channel;
            this.joinedGuildIds = set;
            this.adminGuildIds = set2;
            this.hasAddGuildPermissions = z2;
            this.directories = restCallState;
            this.tabs = restCallState2;
            this.allDirectoryEntryData = LazyJVM.lazy(new WidgetDirectoriesViewModel3(this));
            this.directoryEntryData = LazyJVM.lazy(new WidgetDirectoriesViewModel4(this));
            this.mappedTabs = LazyJVM.lazy(new WidgetDirectoriesViewModel5(this));
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, com.discord.models.guild.Guild guild, Channel channel, Set set, Set set2, boolean z2, RestCallState restCallState, RestCallState restCallState2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = viewState.guild;
            }
            if ((i & 2) != 0) {
                channel = viewState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                set = viewState.joinedGuildIds;
            }
            Set set3 = set;
            if ((i & 8) != 0) {
                set2 = viewState.adminGuildIds;
            }
            Set set4 = set2;
            if ((i & 16) != 0) {
                z2 = viewState.hasAddGuildPermissions;
            }
            boolean z3 = z2;
            if ((i & 32) != 0) {
                restCallState = viewState.directories;
            }
            RestCallState restCallState3 = restCallState;
            if ((i & 64) != 0) {
                restCallState2 = viewState.tabs;
            }
            return viewState.copy(guild, channel2, set3, set4, z3, restCallState3, restCallState2);
        }

        /* renamed from: component1, reason: from getter */
        public final com.discord.models.guild.Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Set<Long> component3() {
            return this.joinedGuildIds;
        }

        public final Set<Long> component4() {
            return this.adminGuildIds;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getHasAddGuildPermissions() {
            return this.hasAddGuildPermissions;
        }

        public final RestCallState<List<DirectoryEntryGuild>> component6() {
            return this.directories;
        }

        public final RestCallState<Map<Integer, Integer>> component7() {
            return this.tabs;
        }

        public final ViewState copy(com.discord.models.guild.Guild guild, Channel channel, Set<Long> joinedGuildIds, Set<Long> adminGuildIds, boolean hasAddGuildPermissions, RestCallState<? extends List<DirectoryEntryGuild>> directories, RestCallState<? extends Map<Integer, Integer>> tabs) {
            Intrinsics3.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(adminGuildIds, "adminGuildIds");
            Intrinsics3.checkNotNullParameter(directories, "directories");
            Intrinsics3.checkNotNullParameter(tabs, "tabs");
            return new ViewState(guild, channel, joinedGuildIds, adminGuildIds, hasAddGuildPermissions, directories, tabs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.guild, viewState.guild) && Intrinsics3.areEqual(this.channel, viewState.channel) && Intrinsics3.areEqual(this.joinedGuildIds, viewState.joinedGuildIds) && Intrinsics3.areEqual(this.adminGuildIds, viewState.adminGuildIds) && this.hasAddGuildPermissions == viewState.hasAddGuildPermissions && Intrinsics3.areEqual(this.directories, viewState.directories) && Intrinsics3.areEqual(this.tabs, viewState.tabs);
        }

        public final Set<Long> getAdminGuildIds() {
            return this.adminGuildIds;
        }

        public final List<DirectoryEntryData> getAllDirectoryEntryData() {
            return (List) this.allDirectoryEntryData.getValue();
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final RestCallState<List<DirectoryEntryGuild>> getDirectories() {
            return this.directories;
        }

        public final Map<Integer, List<DirectoryEntryData>> getDirectoryEntryData() {
            return (Map) this.directoryEntryData.getValue();
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

        public final List<Tuples2<DirectoryEntryCategory, Integer>> getMappedTabs() {
            return (List) this.mappedTabs.getValue();
        }

        public final RestCallState<Map<Integer, Integer>> getTabs() {
            return this.tabs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            com.discord.models.guild.Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Set<Long> set = this.joinedGuildIds;
            int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
            Set<Long> set2 = this.adminGuildIds;
            int iHashCode4 = (iHashCode3 + (set2 != null ? set2.hashCode() : 0)) * 31;
            boolean z2 = this.hasAddGuildPermissions;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode4 + i) * 31;
            RestCallState<List<DirectoryEntryGuild>> restCallState = this.directories;
            int iHashCode5 = (i2 + (restCallState != null ? restCallState.hashCode() : 0)) * 31;
            RestCallState<Map<Integer, Integer>> restCallState2 = this.tabs;
            return iHashCode5 + (restCallState2 != null ? restCallState2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", joinedGuildIds=");
            sbU.append(this.joinedGuildIds);
            sbU.append(", adminGuildIds=");
            sbU.append(this.adminGuildIds);
            sbU.append(", hasAddGuildPermissions=");
            sbU.append(this.hasAddGuildPermissions);
            sbU.append(", directories=");
            sbU.append(this.directories);
            sbU.append(", tabs=");
            sbU.append(this.tabs);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(com.discord.models.guild.Guild guild, Channel channel, Set set, Set set2, boolean z2, RestCallState restCallState, RestCallState restCallState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guild, (i & 2) == 0 ? channel : null, (i & 4) != 0 ? Sets5.emptySet() : set, (i & 8) != 0 ? Sets5.emptySet() : set2, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? RestCallState2.INSTANCE : restCallState, (i & 64) != 0 ? RestCallState2.INSTANCE : restCallState2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel(StoreDirectories storeDirectories, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreReadStates storeReadStates, RestAPI restAPI, Observable<ViewState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(storeDirectories, "directoriesStore");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "channelsSelectedStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeReadStates, "readStatesStore");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.directoriesStore = storeDirectories;
        this.restAPI = restAPI;
        Observable observableY = ObservableExtensionsKt.computationLatest(observable).y(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "storeObservable\n        …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableY, this, null, 2, null), WidgetDirectoriesViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        Observable<Channel> observableR = storeChannelsSelected.observeSelectedChannel().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "channelsSelectedStore\n  …  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableY2 = observableG.y(AnonymousClass3.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY2, "channelsSelectedStore\n  …?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe$default(observableY2, WidgetDirectoriesViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
        Observable<Long> observableY3 = storeChannelsSelected.observePreviousId().r().y(new AnonymousClass5(storeChannels));
        Intrinsics3.checkNotNullExpressionValue(observableY3, "channelsSelectedStore.ob…?.isDirectory() == true }");
        ObservableExtensionsKt.appSubscribe$default(observableY3, WidgetDirectoriesViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(storeReadStates), 62, (Object) null);
    }
}
