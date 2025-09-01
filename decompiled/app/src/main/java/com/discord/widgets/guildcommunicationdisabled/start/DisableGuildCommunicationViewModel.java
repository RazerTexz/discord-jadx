package com.discord.widgets.guildcommunicationdisabled.start;

import a0.a.a.b;
import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserCommunicationDisabledUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: DisableGuildCommunicationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003%&'BM\u0012\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016\u0012\n\u0010\u001a\u001a\u00060\u0015j\u0002`\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030!¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0013\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00060\u0015j\u0002`\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00060\u0015j\u0002`\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018¨\u0006("}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;)V", "Lcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;", "duration", "onDurationLengthSelected", "(Lcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;)V", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "context", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "Lkotlin/Function0;", "onFinished", "onDisableCommunicationConfirm", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "", "Lcom/discord/primitives/UserId;", "userId", "J", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lrx/Observable;", "storeStateObservable", "<init>", "(JJLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DisableGuildCommunicationViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long guildId;
    private final long userId;

    /* compiled from: DisableGuildCommunicationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel) {
            super(1, disableGuildCommunicationViewModel, DisableGuildCommunicationViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            DisableGuildCommunicationViewModel.access$handleStoreState((DisableGuildCommunicationViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: DisableGuildCommunicationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JE\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$Companion;", "", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lrx/Observable;", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;", "observeStores", "(JJLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j, long j2, ObservationDeck observationDeck, StoreUser storeUser, StoreGuilds storeGuilds) {
            return companion.observeStores(j, j2, observationDeck, storeUser, storeGuilds);
        }

        private final Observable<StoreState> observeStores(long userId, long guildId, ObservationDeck observationDeck, StoreUser userStore, StoreGuilds guildsStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{userStore, guildsStore}, false, null, null, new DisableGuildCommunicationViewModel2(userStore, userId, guildsStore, guildId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DisableGuildCommunicationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;", "", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "user", "guild", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/User;", "getUser", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final User user;

        public StoreState(User user, Guild guild) {
            this.user = user;
            this.guild = guild;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, User user, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                user = storeState.user;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            return storeState.copy(user, guild);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreState copy(User user, Guild guild) {
            return new StoreState(user, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.guild, storeState.guild);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            Guild guild = this.guild;
            return iHashCode + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: DisableGuildCommunicationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: DisableGuildCommunicationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: DisableGuildCommunicationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\f\b\u0002\u0010\r\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001d\u0010\r\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState$Valid;", "Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "", "Lcom/discord/primitives/GuildId;", "component2", "()J", "Lcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;", "component3", "()Lcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;", "user", "guildId", "selectedDurationOption", "copy", "(Lcom/discord/models/user/User;JLcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;)Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;", "getSelectedDurationOption", "Lcom/discord/models/user/User;", "getUser", "J", "getGuildId", "<init>", "(Lcom/discord/models/user/User;JLcom/discord/widgets/guildcommunicationdisabled/start/TimeDurationDisabledCommunication;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final long guildId;
            private final GuildCommunicationDisabledDateUtils2 selectedDurationOption;
            private final User user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(User user, long j, GuildCommunicationDisabledDateUtils2 guildCommunicationDisabledDateUtils2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildCommunicationDisabledDateUtils2, "selectedDurationOption");
                this.user = user;
                this.guildId = j;
                this.selectedDurationOption = guildCommunicationDisabledDateUtils2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, User user, long j, GuildCommunicationDisabledDateUtils2 guildCommunicationDisabledDateUtils2, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = valid.user;
                }
                if ((i & 2) != 0) {
                    j = valid.guildId;
                }
                if ((i & 4) != 0) {
                    guildCommunicationDisabledDateUtils2 = valid.selectedDurationOption;
                }
                return valid.copy(user, j, guildCommunicationDisabledDateUtils2);
            }

            /* renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildCommunicationDisabledDateUtils2 getSelectedDurationOption() {
                return this.selectedDurationOption;
            }

            public final Valid copy(User user, long guildId, GuildCommunicationDisabledDateUtils2 selectedDurationOption) {
                Intrinsics3.checkNotNullParameter(selectedDurationOption, "selectedDurationOption");
                return new Valid(user, guildId, selectedDurationOption);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.user, valid.user) && this.guildId == valid.guildId && Intrinsics3.areEqual(this.selectedDurationOption, valid.selectedDurationOption);
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final GuildCommunicationDisabledDateUtils2 getSelectedDurationOption() {
                return this.selectedDurationOption;
            }

            public final User getUser() {
                return this.user;
            }

            public int hashCode() {
                User user = this.user;
                int iA = (b.a(this.guildId) + ((user != null ? user.hashCode() : 0) * 31)) * 31;
                GuildCommunicationDisabledDateUtils2 guildCommunicationDisabledDateUtils2 = this.selectedDurationOption;
                return iA + (guildCommunicationDisabledDateUtils2 != null ? guildCommunicationDisabledDateUtils2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(user=");
                sbU.append(this.user);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", selectedDurationOption=");
                sbU.append(this.selectedDurationOption);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DisableGuildCommunicationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Ljava/lang/Void;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel$onDisableCommunicationConfirm$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public final /* synthetic */ long $disabledUntilTimestamp;
        public final /* synthetic */ long $durationS;
        public final /* synthetic */ String $reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, String str) {
            super(1);
            this.$durationS = j;
            this.$disabledUntilTimestamp = j2;
            this.$reason = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Void r1) {
            return invoke2(r1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(Void r7) {
            return new TrackNetworkActionUserCommunicationDisabledUpdate(Long.valueOf(DisableGuildCommunicationViewModel.access$getGuildId$p(DisableGuildCommunicationViewModel.this)), Long.valueOf(DisableGuildCommunicationViewModel.access$getUserId$p(DisableGuildCommunicationViewModel.this)), Float.valueOf(this.$durationS), this.$reason, Long.valueOf(this.$disabledUntilTimestamp));
        }
    }

    /* compiled from: DisableGuildCommunicationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel$onDisableCommunicationConfirm$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onFinished;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0) {
            super(1);
            this.$onFinished = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onFinished.invoke();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DisableGuildCommunicationViewModel(long j, long j2, ObservationDeck observationDeck, StoreUser storeUser, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeck4.get() : observationDeck;
        StoreUser users = (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(j, j2, observationDeck2, users, guilds, (i & 32) != 0 ? Companion.access$observeStores(INSTANCE, j, j2, observationDeck2, users, guilds) : observable);
    }

    public static final /* synthetic */ long access$getGuildId$p(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel) {
        return disableGuildCommunicationViewModel.guildId;
    }

    public static final /* synthetic */ long access$getUserId$p(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel) {
        return disableGuildCommunicationViewModel.userId;
    }

    public static final /* synthetic */ void access$handleStoreState(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel, StoreState storeState) {
        disableGuildCommunicationViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        GuildCommunicationDisabledDateUtils2 selectedDurationOption;
        ViewState valid;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid2 = (ViewState.Valid) viewState;
        if (storeState.getGuild() == null) {
            valid = ViewState.Invalid.INSTANCE;
        } else {
            User user = storeState.getUser();
            long id2 = storeState.getGuild().getId();
            if (valid2 == null || (selectedDurationOption = valid2.getSelectedDurationOption()) == null) {
                selectedDurationOption = GuildCommunicationDisabledDateUtils2.SECONDS_60;
            }
            valid = new ViewState.Valid(user, id2, selectedDurationOption);
        }
        updateViewState(valid);
    }

    public final void onDisableCommunicationConfirm(WeakReference<Context> context, String reason, Function0<Unit> onFinished) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onFinished, "onFinished");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            Tuples2<String, Long> futureTimestamp = GuildCommunicationDisabledDateUtils.INSTANCE.getFutureTimestamp(((ViewState.Valid) viewState).getSelectedDurationOption().getDurationMs());
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().disableGuildCommunication(this.guildId, this.userId, new RestAPIParams.DisableGuildCommunication(futureTimestamp.component1()), reason), false, 1, null), new AnonymousClass1(r0.getSelectedDurationOption().getDurationMs() / 1000, futureTimestamp.component2().longValue(), reason)), this, null, 2, null), DisableGuildCommunicationViewModel.class, context.get(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(onFinished), 60, (Object) null);
        }
    }

    public final void onDurationLengthSelected(GuildCommunicationDisabledDateUtils2 duration) {
        Intrinsics3.checkNotNullParameter(duration, "duration");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            updateViewState(ViewState.Valid.copy$default((ViewState.Valid) viewState, null, 0L, duration, 3, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisableGuildCommunicationViewModel(long j, long j2, ObservationDeck observationDeck, StoreUser storeUser, StoreGuilds storeGuilds, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.userId = j;
        this.guildId = j2;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), DisableGuildCommunicationViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
