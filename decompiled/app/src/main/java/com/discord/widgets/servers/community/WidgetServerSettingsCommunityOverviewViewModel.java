package com.discord.widgets.servers.community;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004./01B#\u0012\n\u0010)\u001a\u00060\u0019j\u0002`(\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001c\u001a\u00020\u00062\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00062\n\u0010\u001b\u001a\u00060\u0019j\u0002`\u001a¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0007¢\u0006\u0004\b#\u0010\u0012R:\u0010&\u001a&\u0012\f\u0012\n %*\u0004\u0018\u00010\u00160\u0016 %*\u0012\u0012\f\u0012\n %*\u0004\u0018\u00010\u00160\u0016\u0018\u00010$0$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010)\u001a\u00060\u0019j\u0002`(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00062"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;", "Lcom/discord/app/AppComponent;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;)V", "", "isLoading", "handleDisableCommunityButtonState", "(Z)V", "Lcom/discord/restapi/RestAPIParams$UpdateGuild;", "updateGuild", "saveCommunityGuildSettings", "(Lcom/discord/restapi/RestAPIParams$UpdateGuild;)V", "handleGuildUpdateError", "()V", "isDisableCommunityTapped", "(Lcom/discord/restapi/RestAPIParams$UpdateGuild;)Z", "Lrx/Observable;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event;", "observeEvents", "()Lrx/Observable;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "saveRulesChannel", "(J)V", "saveCommunityUpdatesChannel", "", "locale", "saveLocale", "(Ljava/lang/String;)V", "disableCommunity", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/primitives/GuildId;", "guildId", "J", "storeStateObservable", "<init>", "(JLrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverviewViewModel extends AppViewModel<ViewState> implements AppComponent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;

    /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel) {
            super(1, widgetServerSettingsCommunityOverviewViewModel, WidgetServerSettingsCommunityOverviewViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            WidgetServerSettingsCommunityOverviewViewModel.access$handleStoreState((WidgetServerSettingsCommunityOverviewViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JI\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StoreUser;", "storeUsers", "Lrx/Observable;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreUser;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, StoreUser storeUsers) {
            Observable observableY = storeGuilds.observeGuild(guildId).Y(new WidgetServerSettingsCommunityOverviewViewModel2(storeUsers, storePermissions, guildId, storeChannels));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeGuilds.observeGuild…      }\n        }\n      }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, StoreUser storeUser, int i, Object obj) {
            if ((i & 2) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            StoreGuilds storeGuilds2 = storeGuilds;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            StorePermissions storePermissions2 = storePermissions;
            if ((i & 16) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            return companion.observeStoreState(j, storeGuilds2, storeChannels2, storePermissions2, storeUser);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event;", "", "<init>", "()V", "DisableCommunitySuccess", "Error", "SaveSuccess", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event$SaveSuccess;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event$DisableCommunitySuccess;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event$Error;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event$DisableCommunitySuccess;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class DisableCommunitySuccess extends Event {
            public static final DisableCommunitySuccess INSTANCE = new DisableCommunitySuccess();

            private DisableCommunitySuccess() {
                super(null);
            }
        }

        /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event$Error;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event$SaveSuccess;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class SaveSuccess extends Event {
            public static final SaveSuccess INSTANCE = new SaveSuccess();

            private SaveSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState$Invalid;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u000e\u0010\u0012\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJN\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\u000eR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b$\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\u0004R!\u0010\u0012\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\u0007¨\u0006-"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/models/user/MeUser;", "component2", "()Lcom/discord/models/user/MeUser;", "", "Lcom/discord/api/permission/PermissionBit;", "component3", "()Ljava/lang/Long;", "Lcom/discord/api/channel/Channel;", "component4", "()Lcom/discord/api/channel/Channel;", "component5", "guild", "me", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "rulesChannel", "updatesChannel", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Ljava/lang/Long;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getRulesChannel", "getUpdatesChannel", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/lang/Long;", "getPermissions", "Lcom/discord/models/user/MeUser;", "getMe", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Ljava/lang/Long;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final MeUser me;
            private final Long permissions;
            private final Channel rulesChannel;
            private final Channel updatesChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, MeUser meUser, Long l, Channel channel, Channel channel2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(meUser, "me");
                this.guild = guild;
                this.me = meUser;
                this.permissions = l;
                this.rulesChannel = channel;
                this.updatesChannel = channel2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, MeUser meUser, Long l, Channel channel, Channel channel2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    meUser = valid.me;
                }
                MeUser meUser2 = meUser;
                if ((i & 4) != 0) {
                    l = valid.permissions;
                }
                Long l2 = l;
                if ((i & 8) != 0) {
                    channel = valid.rulesChannel;
                }
                Channel channel3 = channel;
                if ((i & 16) != 0) {
                    channel2 = valid.updatesChannel;
                }
                return valid.copy(guild, meUser2, l2, channel3, channel2);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final MeUser getMe() {
                return this.me;
            }

            /* renamed from: component3, reason: from getter */
            public final Long getPermissions() {
                return this.permissions;
            }

            /* renamed from: component4, reason: from getter */
            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            /* renamed from: component5, reason: from getter */
            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public final Valid copy(Guild guild, MeUser me2, Long permissions, Channel rulesChannel, Channel updatesChannel) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(me2, "me");
                return new Valid(guild, me2, permissions, rulesChannel, updatesChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && Intrinsics3.areEqual(this.me, valid.me) && Intrinsics3.areEqual(this.permissions, valid.permissions) && Intrinsics3.areEqual(this.rulesChannel, valid.rulesChannel) && Intrinsics3.areEqual(this.updatesChannel, valid.updatesChannel);
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final MeUser getMe() {
                return this.me;
            }

            public final Long getPermissions() {
                return this.permissions;
            }

            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                MeUser meUser = this.me;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                Long l = this.permissions;
                int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
                Channel channel = this.rulesChannel;
                int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
                Channel channel2 = this.updatesChannel;
                return iHashCode4 + (channel2 != null ? channel2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", me=");
                sbU.append(this.me);
                sbU.append(", permissions=");
                sbU.append(this.permissions);
                sbU.append(", rulesChannel=");
                sbU.append(this.rulesChannel);
                sbU.append(", updatesChannel=");
                sbU.append(this.updatesChannel);
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

    /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;", "", "<init>", "()V", "DisableCommunityLoading", "Invalid", "Loaded", "Uninitialized", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;", "", "component1", "()Z", "isLoading", "copy", "(Z)Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class DisableCommunityLoading extends ViewState {
            private final boolean isLoading;

            public DisableCommunityLoading(boolean z2) {
                super(null);
                this.isLoading = z2;
            }

            public static /* synthetic */ DisableCommunityLoading copy$default(DisableCommunityLoading disableCommunityLoading, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = disableCommunityLoading.isLoading;
                }
                return disableCommunityLoading.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsLoading() {
                return this.isLoading;
            }

            public final DisableCommunityLoading copy(boolean isLoading) {
                return new DisableCommunityLoading(isLoading);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof DisableCommunityLoading) && this.isLoading == ((DisableCommunityLoading) other).isLoading;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isLoading;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isLoading() {
                return this.isLoading;
            }

            public String toString() {
                return outline.O(outline.U("DisableCommunityLoading(isLoading="), this.isLoading, ")");
            }
        }

        /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$Invalid;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "component3", "guild", "rulesChannel", "updatesChannel", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getRulesChannel", "getUpdatesChannel", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final Guild guild;
            private final Channel rulesChannel;
            private final Channel updatesChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Guild guild, Channel channel, Channel channel2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.rulesChannel = channel;
                this.updatesChannel = channel2;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Guild guild, Channel channel, Channel channel2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = loaded.guild;
                }
                if ((i & 2) != 0) {
                    channel = loaded.rulesChannel;
                }
                if ((i & 4) != 0) {
                    channel2 = loaded.updatesChannel;
                }
                return loaded.copy(guild, channel, channel2);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            /* renamed from: component3, reason: from getter */
            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public final Loaded copy(Guild guild, Channel rulesChannel, Channel updatesChannel) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Loaded(guild, rulesChannel, updatesChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.guild, loaded.guild) && Intrinsics3.areEqual(this.rulesChannel, loaded.rulesChannel) && Intrinsics3.areEqual(this.updatesChannel, loaded.updatesChannel);
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                Channel channel = this.rulesChannel;
                int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
                Channel channel2 = this.updatesChannel;
                return iHashCode2 + (channel2 != null ? channel2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guild=");
                sbU.append(this.guild);
                sbU.append(", rulesChannel=");
                sbU.append(this.rulesChannel);
                sbU.append(", updatesChannel=");
                sbU.append(this.updatesChannel);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$saveCommunityGuildSettings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
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
            WidgetServerSettingsCommunityOverviewViewModel.access$handleGuildUpdateError(WidgetServerSettingsCommunityOverviewViewModel.this);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "it", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel$saveCommunityGuildSettings$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public final /* synthetic */ RestAPIParams.UpdateGuild $updateGuild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RestAPIParams.UpdateGuild updateGuild) {
            super(1);
            this.$updateGuild = updateGuild;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            if (!WidgetServerSettingsCommunityOverviewViewModel.access$isDisableCommunityTapped(WidgetServerSettingsCommunityOverviewViewModel.this, this.$updateGuild)) {
                PublishSubject publishSubjectAccess$getEventSubject$p = WidgetServerSettingsCommunityOverviewViewModel.access$getEventSubject$p(WidgetServerSettingsCommunityOverviewViewModel.this);
                publishSubjectAccess$getEventSubject$p.k.onNext(Event.SaveSuccess.INSTANCE);
            } else {
                WidgetServerSettingsCommunityOverviewViewModel.access$handleDisableCommunityButtonState(WidgetServerSettingsCommunityOverviewViewModel.this, false);
                PublishSubject publishSubjectAccess$getEventSubject$p2 = WidgetServerSettingsCommunityOverviewViewModel.access$getEventSubject$p(WidgetServerSettingsCommunityOverviewViewModel.this);
                publishSubjectAccess$getEventSubject$p2.k.onNext(Event.DisableCommunitySuccess.INSTANCE);
            }
        }
    }

    public /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? Companion.observeStoreState$default(INSTANCE, j, null, null, null, null, 30, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel) {
        return widgetServerSettingsCommunityOverviewViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleDisableCommunityButtonState(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel, boolean z2) {
        widgetServerSettingsCommunityOverviewViewModel.handleDisableCommunityButtonState(z2);
    }

    public static final /* synthetic */ void access$handleGuildUpdateError(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel) {
        widgetServerSettingsCommunityOverviewViewModel.handleGuildUpdateError();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel, StoreState storeState) {
        widgetServerSettingsCommunityOverviewViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ boolean access$isDisableCommunityTapped(WidgetServerSettingsCommunityOverviewViewModel widgetServerSettingsCommunityOverviewViewModel, RestAPIParams.UpdateGuild updateGuild) {
        return widgetServerSettingsCommunityOverviewViewModel.isDisableCommunityTapped(updateGuild);
    }

    private final void handleDisableCommunityButtonState(boolean isLoading) {
        updateViewState(new ViewState.DisableCommunityLoading(isLoading));
    }

    private final void handleGuildUpdateError() {
        handleDisableCommunityButtonState(false);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Error.INSTANCE);
    }

    private final void handleStoreState(StoreState storeState) {
        if (!(storeState instanceof StoreState.Valid)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        Guild guild = valid.getGuild();
        MeUser me2 = valid.getMe();
        Long permissions = valid.getPermissions();
        Channel rulesChannel = valid.getRulesChannel();
        Channel updatesChannel = valid.getUpdatesChannel();
        if (guild.isOwner(me2.getId()) || PermissionUtils.canAndIsElevated(32L, permissions, me2.getMfaEnabled(), guild.getMfaLevel())) {
            updateViewState(new ViewState.Loaded(guild, rulesChannel, updatesChannel));
        } else {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    private final boolean isDisableCommunityTapped(RestAPIParams.UpdateGuild updateGuild) {
        List<GuildFeature> features = updateGuild.getFeatures();
        return (features == null || features.contains(GuildFeature.COMMUNITY)) ? false : true;
    }

    private final void saveCommunityGuildSettings(RestAPIParams.UpdateGuild updateGuild) {
        handleDisableCommunityButtonState(isDisableCommunityTapped(updateGuild));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuild(this.guildId, updateGuild), false, 1, null), this, null, 2, null), WidgetServerSettingsCommunityOverviewViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(updateGuild), 54, (Object) null);
    }

    @MainThread
    public final void disableCommunity() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            saveCommunityGuildSettings(new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, _Collections.toList(_Sets.minus(loaded.getGuild().getFeatures(), GuildFeature.COMMUNITY)), null, null, null, 30719, null));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void saveCommunityUpdatesChannel(long channelId) {
        saveCommunityGuildSettings(new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(channelId), null, 24575, null));
    }

    public final void saveLocale(String locale) {
        Intrinsics3.checkNotNullParameter(locale, "locale");
        saveCommunityGuildSettings(new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, null, null, locale, 16383, null));
    }

    public final void saveRulesChannel(long channelId) {
        saveCommunityGuildSettings(new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(channelId), null, null, 28671, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityOverviewViewModel(long j, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetServerSettingsCommunityOverviewViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
