package com.discord.widgets.servers.guild_role_subscription;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00046789BK\u0012\n\u0010%\u001a\u00060#j\u0002`$\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u00100\u001a\u00020/\u0012\b\b\u0002\u00102\u001a\u000201\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b4\u00105J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u001a\u0010%\u001a\u00060#j\u0002`$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001cR\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R:\u0010-\u001a&\u0012\f\u0012\n ,*\u0004\u0018\u00010\b0\b ,*\u0012\u0012\f\u0012\n ,*\u0004\u0018\u00010\b0\b\u0018\u00010+0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006:"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$StoreState;)V", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;", "event", "emitEvent", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;)V", "Lrx/Observable;", "observeEvents", "()Lrx/Observable;", "", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "coverImage", "", "isFullServerGating", "onGuildRoleSubscriptionGroupUpdated", "(Ljava/lang/String;Ljava/lang/String;Z)V", "submitChanges", "()V", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "guildRoleSubscriptionGroupListing", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "editedGroupCoverImage", "Ljava/lang/String;", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "fullServerGatingOverwrite", "Ljava/lang/Boolean;", "editedIsFullServerGating", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "editedGroupDescription", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "storeObservable", "<init>", "(JLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/updates/ObservationDeck;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String editedGroupCoverImage;
    private String editedGroupDescription;
    private Boolean editedIsFullServerGating;
    private final PublishSubject<Event> eventSubject;
    private Boolean fullServerGatingOverwrite;
    private final long guildId;
    private GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel$1, reason: invalid class name */
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
            ServerSettingsGuildRoleSubscriptionViewModel.access$handleStoreState(ServerSettingsGuildRoleSubscriptionViewModel.this, storeState);
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lrx/Observable;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuildRoleSubscriptions;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
            return companion.observeStoreState(j, observationDeck, storeGuildRoleSubscriptions, storeGuilds);
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new ServerSettingsGuildRoleSubscriptionViewModel2(storeGuildRoleSubscriptions, guildId, storeGuilds), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;", "", "<init>", "()V", "StoreStateUpdate", "SubmitFailure", "SubmitSuccess", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event$SubmitSuccess;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event$SubmitFailure;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "component1", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "", "component2", "()Ljava/lang/Boolean;", "guildRoleSubscriptionGroupListing", "fullServerGatingOverwrite", "copy", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;Ljava/lang/Boolean;)Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getFullServerGatingOverwrite", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "getGuildRoleSubscriptionGroupListing", "<init>", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;Ljava/lang/Boolean;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class StoreStateUpdate extends Event {
            private final Boolean fullServerGatingOverwrite;
            private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

            public /* synthetic */ StoreStateUpdate(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(guildRoleSubscriptionGroupListing, (i & 2) != 0 ? null : bool);
            }

            public static /* synthetic */ StoreStateUpdate copy$default(StoreStateUpdate storeStateUpdate, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildRoleSubscriptionGroupListing = storeStateUpdate.guildRoleSubscriptionGroupListing;
                }
                if ((i & 2) != 0) {
                    bool = storeStateUpdate.fullServerGatingOverwrite;
                }
                return storeStateUpdate.copy(guildRoleSubscriptionGroupListing, bool);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            /* renamed from: component2, reason: from getter */
            public final Boolean getFullServerGatingOverwrite() {
                return this.fullServerGatingOverwrite;
            }

            public final StoreStateUpdate copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean fullServerGatingOverwrite) {
                Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
                return new StoreStateUpdate(guildRoleSubscriptionGroupListing, fullServerGatingOverwrite);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StoreStateUpdate)) {
                    return false;
                }
                StoreStateUpdate storeStateUpdate = (StoreStateUpdate) other;
                return Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListing, storeStateUpdate.guildRoleSubscriptionGroupListing) && Intrinsics3.areEqual(this.fullServerGatingOverwrite, storeStateUpdate.fullServerGatingOverwrite);
            }

            public final Boolean getFullServerGatingOverwrite() {
                return this.fullServerGatingOverwrite;
            }

            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            public int hashCode() {
                GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
                int iHashCode = (guildRoleSubscriptionGroupListing != null ? guildRoleSubscriptionGroupListing.hashCode() : 0) * 31;
                Boolean bool = this.fullServerGatingOverwrite;
                return iHashCode + (bool != null ? bool.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("StoreStateUpdate(guildRoleSubscriptionGroupListing=");
                sbU.append(this.guildRoleSubscriptionGroupListing);
                sbU.append(", fullServerGatingOverwrite=");
                return outline.D(sbU, this.fullServerGatingOverwrite, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StoreStateUpdate(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
                this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
                this.fullServerGatingOverwrite = bool;
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event$SubmitFailure;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;", "Lcom/discord/utilities/error/Error;", "component1", "()Lcom/discord/utilities/error/Error;", "error", "copy", "(Lcom/discord/utilities/error/Error;)Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event$SubmitFailure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/error/Error;", "getError", "<init>", "(Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SubmitFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ SubmitFailure copy$default(SubmitFailure submitFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = submitFailure.error;
                }
                return submitFailure.copy(error);
            }

            /* renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final SubmitFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new SubmitFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SubmitFailure) && Intrinsics3.areEqual(this.error, ((SubmitFailure) other).error);
                }
                return true;
            }

            public final Error getError() {
                return this.error;
            }

            public int hashCode() {
                Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SubmitFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event$SubmitSuccess;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class SubmitSuccess extends Event {
            public static final SubmitSuccess INSTANCE = new SubmitSuccess();

            private SubmitSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$StoreState;", "", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "component1", "()Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "", "component2", "()Ljava/lang/Boolean;", "guildRoleSubscriptionGroupState", "fullServerGatingOverwrite", "copy", "(Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;Ljava/lang/Boolean;)Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getFullServerGatingOverwrite", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "getGuildRoleSubscriptionGroupState", "<init>", "(Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;Ljava/lang/Boolean;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Boolean fullServerGatingOverwrite;
        private final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState;

        public StoreState(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Boolean bool) {
            this.guildRoleSubscriptionGroupState = guildRoleSubscriptionGroupState;
            this.fullServerGatingOverwrite = bool;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionGroupState = storeState.guildRoleSubscriptionGroupState;
            }
            if ((i & 2) != 0) {
                bool = storeState.fullServerGatingOverwrite;
            }
            return storeState.copy(guildRoleSubscriptionGroupState, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
            return this.guildRoleSubscriptionGroupState;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getFullServerGatingOverwrite() {
            return this.fullServerGatingOverwrite;
        }

        public final StoreState copy(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Boolean fullServerGatingOverwrite) {
            return new StoreState(guildRoleSubscriptionGroupState, fullServerGatingOverwrite);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildRoleSubscriptionGroupState, storeState.guildRoleSubscriptionGroupState) && Intrinsics3.areEqual(this.fullServerGatingOverwrite, storeState.fullServerGatingOverwrite);
        }

        public final Boolean getFullServerGatingOverwrite() {
            return this.fullServerGatingOverwrite;
        }

        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
            return this.guildRoleSubscriptionGroupState;
        }

        public int hashCode() {
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupState;
            int iHashCode = (guildRoleSubscriptionGroupState != null ? guildRoleSubscriptionGroupState.hashCode() : 0) * 31;
            Boolean bool = this.fullServerGatingOverwrite;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildRoleSubscriptionGroupState=");
            sbU.append(this.guildRoleSubscriptionGroupState);
            sbU.append(", fullServerGatingOverwrite=");
            return outline.D(sbU, this.fullServerGatingOverwrite, ")");
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;", "", "<init>", "()V", "Empty", "Failed", "Loaded", "Loading", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Empty;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Failed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Empty;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends ViewState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Failed;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\n\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;", "", "component1", "()Z", "component2", "", "component3", "()J", "hasChanges", "isSubmitting", "groupListingId", "copy", "(ZZJ)Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getGroupListingId", "Z", "getHasChanges", "<init>", "(ZZJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final long groupListingId;
            private final boolean hasChanges;
            private final boolean isSubmitting;

            public /* synthetic */ Loaded(boolean z2, boolean z3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, j);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, boolean z3, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.hasChanges;
                }
                if ((i & 2) != 0) {
                    z3 = loaded.isSubmitting;
                }
                if ((i & 4) != 0) {
                    j = loaded.groupListingId;
                }
                return loaded.copy(z2, z3, j);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getHasChanges() {
                return this.hasChanges;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsSubmitting() {
                return this.isSubmitting;
            }

            /* renamed from: component3, reason: from getter */
            public final long getGroupListingId() {
                return this.groupListingId;
            }

            public final Loaded copy(boolean hasChanges, boolean isSubmitting, long groupListingId) {
                return new Loaded(hasChanges, isSubmitting, groupListingId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.hasChanges == loaded.hasChanges && this.isSubmitting == loaded.isSubmitting && this.groupListingId == loaded.groupListingId;
            }

            public final long getGroupListingId() {
                return this.groupListingId;
            }

            public final boolean getHasChanges() {
                return this.hasChanges;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r0v6 */
            public int hashCode() {
                boolean z2 = this.hasChanges;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.isSubmitting;
                return b.a(this.groupListingId) + ((i + (z3 ? 1 : z3 ? 1 : 0)) * 31);
            }

            public final boolean isSubmitting() {
                return this.isSubmitting;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(hasChanges=");
                sbU.append(this.hasChanges);
                sbU.append(", isSubmitting=");
                sbU.append(this.isSubmitting);
                sbU.append(", groupListingId=");
                return outline.C(sbU, this.groupListingId, ")");
            }

            public Loaded(boolean z2, boolean z3, long j) {
                super(null);
                this.hasChanges = z2;
                this.isSubmitting = z3;
                this.groupListingId = j;
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "it", "", "invoke", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionGroupListing, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            invoke2(guildRoleSubscriptionGroupListing);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "it");
            ServerSettingsGuildRoleSubscriptionViewModel.access$updateViewState(ServerSettingsGuildRoleSubscriptionViewModel.this, ViewState.Loaded.copy$default(this.$viewState, false, false, 0L, 4, null));
            ServerSettingsGuildRoleSubscriptionViewModel.access$emitEvent(ServerSettingsGuildRoleSubscriptionViewModel.this, Event.SubmitSuccess.INSTANCE);
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ServerSettingsGuildRoleSubscriptionViewModel.access$updateViewState(ServerSettingsGuildRoleSubscriptionViewModel.this, ViewState.Loaded.copy$default(this.$viewState, false, false, 0L, 5, null));
            ServerSettingsGuildRoleSubscriptionViewModel.access$emitEvent(ServerSettingsGuildRoleSubscriptionViewModel.this, new Event.SubmitFailure(error));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        ObservationDeck observationDeck2 = (i & 16) != 0 ? ObservationDeck4.get() : observationDeck;
        this(j, api, guildRoleSubscriptions, guilds, observationDeck2, (i & 32) != 0 ? Companion.access$observeStoreState(INSTANCE, j, observationDeck2, guildRoleSubscriptions, guilds) : observable);
    }

    public static final /* synthetic */ void access$emitEvent(ServerSettingsGuildRoleSubscriptionViewModel serverSettingsGuildRoleSubscriptionViewModel, Event event) {
        serverSettingsGuildRoleSubscriptionViewModel.emitEvent(event);
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsGuildRoleSubscriptionViewModel serverSettingsGuildRoleSubscriptionViewModel, StoreState storeState) {
        serverSettingsGuildRoleSubscriptionViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsGuildRoleSubscriptionViewModel serverSettingsGuildRoleSubscriptionViewModel, ViewState viewState) {
        serverSettingsGuildRoleSubscriptionViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final void handleStoreState(StoreState storeState) {
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = storeState.getGuildRoleSubscriptionGroupState();
        if ((guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loading) || guildRoleSubscriptionGroupState == null) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (!(guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded)) {
            if (guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Failed) {
                updateViewState(ViewState.Failed.INSTANCE);
                return;
            }
            return;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) storeState.getGuildRoleSubscriptionGroupState()).getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null) {
            updateViewState(ViewState.Empty.INSTANCE);
            return;
        }
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        boolean hasChanges = loaded != null ? loaded.getHasChanges() : false;
        if (!hasChanges) {
            this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            emitEvent(new Event.StoreStateUpdate(guildRoleSubscriptionGroupListing, storeState.getFullServerGatingOverwrite()));
        }
        updateViewState(new ViewState.Loaded(hasChanges, loaded != null ? loaded.isSubmitting() : false, guildRoleSubscriptionGroupListing.getId()));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onGuildRoleSubscriptionGroupUpdated(String description, String coverImage, boolean isFullServerGating) {
        boolean z2;
        boolean z3;
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            if (!Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListing != null ? r0.getDescription() : null, description)) {
                if (!(description == null || StringsJVM.isBlank(description))) {
                    this.editedGroupDescription = description;
                    z2 = true;
                }
            } else {
                this.editedGroupDescription = null;
                z2 = false;
            }
            if (coverImage == null || StringsJVM.isBlank(coverImage)) {
                this.editedGroupCoverImage = null;
            } else {
                this.editedGroupCoverImage = coverImage;
                z2 = true;
            }
            Boolean boolValueOf = this.fullServerGatingOverwrite;
            if (boolValueOf == null) {
                GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
                boolValueOf = guildRoleSubscriptionGroupListing != null ? Boolean.valueOf(guildRoleSubscriptionGroupListing.getFullServerGate()) : null;
            }
            if (!Intrinsics3.areEqual(boolValueOf, Boolean.valueOf(isFullServerGating))) {
                this.editedIsFullServerGating = Boolean.valueOf(isFullServerGating);
                z3 = true;
            } else {
                this.editedIsFullServerGating = null;
                z3 = z2;
            }
            updateViewState(ViewState.Loaded.copy$default(loaded, z3, false, 0L, 6, null));
        }
    }

    public final void submitChanges() {
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
        if (guildRoleSubscriptionGroupListing != null) {
            long id2 = guildRoleSubscriptionGroupListing.getId();
            ViewState viewStateRequireViewState = requireViewState();
            if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
                viewStateRequireViewState = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
            if (loaded != null) {
                updateViewState(ViewState.Loaded.copy$default(loaded, false, true, 0L, 5, null));
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.updateGuildRoleSubscriptionGroupListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, id2, this.editedGroupCoverImage, this.editedGroupDescription, this.editedIsFullServerGating), this, null, 2, null), ServerSettingsGuildRoleSubscriptionViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(loaded), (Function0) null, (Function0) null, new AnonymousClass1(loaded), 54, (Object) null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
        storeGuildRoleSubscriptions.fetchGuildRoleSubscriptionGroupsForGuild(j);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ServerSettingsGuildRoleSubscriptionViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
