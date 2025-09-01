package com.discord.widgets.servers.role_members;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.permissions.PermissionOwner;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* compiled from: ServerSettingsRoleMembersViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004<=>?Bq\u0012\n\u0010,\u001a\u00060\fj\u0002`+\u0012\n\u0010&\u001a\u00060\fj\u0002`%\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a00\u0012\b\b\u0002\u0010.\u001a\u00020-\u0012\b\b\u0002\u00104\u001a\u000203\u0012\b\b\u0002\u00106\u001a\u000205\u0012\b\b\u0002\u00108\u001a\u000207\u0012\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J;\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 R:\u0010#\u001a&\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00130\u0013 \"*\u0012\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00130\u0013\u0018\u00010!0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\u00060\fj\u0002`%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010,\u001a\u00060\fj\u0002`+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010'R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u0006@"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$ViewState;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;)V", "", "Lcom/discord/models/member/GuildMember;", "guildMembers", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "users", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMemberAdapterItem;", "generateGuildMemberList", "(Ljava/util/List;Ljava/util/Map;)Ljava/util/List;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$Event;", "event", "emitEvent", "(Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$Event;)V", "Lrx/Observable;", "observeEvents", "()Lrx/Observable;", "", "query", "updateSearchQuery", "(Ljava/lang/String;)V", "guildMember", "removeRoleFromMember", "(Lcom/discord/models/member/GuildMember;)V", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/primitives/RoleId;", "guildRoleId", "J", "Lcom/discord/stores/StoreGatewayConnection;", "storeGatewayConnection", "Lcom/discord/stores/StoreGatewayConnection;", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "Lrx/subjects/BehaviorSubject;", "searchQuerySubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreUser;", "storeUsers", "storeStateObservable", "<init>", "(JJLcom/discord/stores/StoreGatewayConnection;Lrx/subjects/BehaviorSubject;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreUser;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final long guildRoleId;
    private final RestAPI restApi;
    private final BehaviorSubject<String> searchQuerySubject;
    private final StoreGatewayConnection storeGatewayConnection;

    /* compiled from: ServerSettingsRoleMembersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$1, reason: invalid class name */
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
            ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel = ServerSettingsRoleMembersViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            ServerSettingsRoleMembersViewModel.access$handleStoreState(serverSettingsRoleMembersViewModel, storeState);
        }
    }

    /* compiled from: ServerSettingsRoleMembersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "query", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            StoreGatewayConnection.requestGuildMembers$default(ServerSettingsRoleMembersViewModel.access$getStoreGatewayConnection$p(ServerSettingsRoleMembersViewModel.this), ServerSettingsRoleMembersViewModel.access$getGuildId$p(ServerSettingsRoleMembersViewModel.this), str, null, null, 12, null);
        }
    }

    /* compiled from: ServerSettingsRoleMembersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017JE\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010JQ\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/RoleId;", "guildRoleId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;", "observeGuildRoleMembers", "(JJLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/updates/ObservationDeck;)Lrx/Observable;", "Lrx/subjects/BehaviorSubject;", "", "searchFilterSubject", "observeStoreState", "(JJLrx/subjects/BehaviorSubject;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/updates/ObservationDeck;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeGuildRoleMembers(long guildId, long guildRoleId, StoreGuilds storeGuilds, StoreUser storeUser, ObservationDeck observationDeck) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuilds, storeUser}, false, null, null, new ServerSettingsRoleMembersViewModel2(storeGuilds, guildId, guildRoleId, storeUser), 14, null);
        }

        public final Observable<StoreState> observeStoreState(long guildId, long guildRoleId, BehaviorSubject<String> searchFilterSubject, StoreGuilds storeGuilds, StoreUser storeUser, ObservationDeck observationDeck) {
            Intrinsics3.checkNotNullParameter(searchFilterSubject, "searchFilterSubject");
            Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            Observable<StoreState> observableJ = Observable.j(searchFilterSubject.r(), observeGuildRoleMembers(guildId, guildRoleId, storeGuilds, storeUser, observationDeck), ServerSettingsRoleMembersViewModel4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…eredGuildMembers)\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsRoleMembersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$Event;", "", "<init>", "()V", "RemoveMemberFailure", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: ServerSettingsRoleMembersViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$Event;", "Lcom/discord/utilities/error/Error;", "component1", "()Lcom/discord/utilities/error/Error;", "error", "copy", "(Lcom/discord/utilities/error/Error;)Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/error/Error;", "getError", "<init>", "(Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class RemoveMemberFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RemoveMemberFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ RemoveMemberFailure copy$default(RemoveMemberFailure removeMemberFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = removeMemberFailure.error;
                }
                return removeMemberFailure.copy(error);
            }

            /* renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final RemoveMemberFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new RemoveMemberFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof RemoveMemberFailure) && Intrinsics3.areEqual(this.error, ((RemoveMemberFailure) other).error);
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
                StringBuilder sbU = outline.U("RemoveMemberFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsRoleMembersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b$\u0010%J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJF\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0005R)\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u000b¨\u0006&"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;", "", "", "Lcom/discord/models/member/GuildMember;", "component1", "()Ljava/util/List;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "component2", "()Ljava/util/Map;", "Lcom/discord/api/role/GuildRole;", "component3", "()Lcom/discord/api/role/GuildRole;", "guildMembers", "users", "role", "copy", "(Ljava/util/List;Ljava/util/Map;Lcom/discord/api/role/GuildRole;)Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/role/GuildRole;", "getRole", "Ljava/util/List;", "getGuildMembers", "Ljava/util/Map;", "getUsers", "<init>", "(Ljava/util/List;Ljava/util/Map;Lcom/discord/api/role/GuildRole;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final List<GuildMember> guildMembers;
        private final GuildRole role;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(List<GuildMember> list, Map<Long, ? extends User> map, GuildRole guildRole) {
            Intrinsics3.checkNotNullParameter(list, "guildMembers");
            Intrinsics3.checkNotNullParameter(map, "users");
            this.guildMembers = list;
            this.users = map;
            this.role = guildRole;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, Map map, GuildRole guildRole, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.guildMembers;
            }
            if ((i & 2) != 0) {
                map = storeState.users;
            }
            if ((i & 4) != 0) {
                guildRole = storeState.role;
            }
            return storeState.copy(list, map, guildRole);
        }

        public final List<GuildMember> component1() {
            return this.guildMembers;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final StoreState copy(List<GuildMember> guildMembers, Map<Long, ? extends User> users, GuildRole role) {
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(users, "users");
            return new StoreState(guildMembers, users, role);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.users, storeState.users) && Intrinsics3.areEqual(this.role, storeState.role);
        }

        public final List<GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            List<GuildMember> list = this.guildMembers;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            GuildRole guildRole = this.role;
            return iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", role=");
            sbU.append(this.role);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ServerSettingsRoleMembersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Loading", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: ServerSettingsRoleMembersViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b\f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$ViewState;", "", "component1", "()Z", "", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMemberAdapterItem;", "component2", "()Ljava/util/List;", "Lcom/discord/api/role/GuildRole;", "component3", "()Lcom/discord/api/role/GuildRole;", "isUpdating", "memberList", "role", "copy", "(ZLjava/util/List;Lcom/discord/api/role/GuildRole;)Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMemberList", "Lcom/discord/api/role/GuildRole;", "getRole", "Z", "<init>", "(ZLjava/util/List;Lcom/discord/api/role/GuildRole;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean isUpdating;
            private final List<ServerSettingsRoleMemberAdapterItem> memberList;
            private final GuildRole role;

            public /* synthetic */ Loaded(boolean z2, List list, GuildRole guildRole, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z2, list, guildRole);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, List list, GuildRole guildRole, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.isUpdating;
                }
                if ((i & 2) != 0) {
                    list = loaded.memberList;
                }
                if ((i & 4) != 0) {
                    guildRole = loaded.role;
                }
                return loaded.copy(z2, list, guildRole);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsUpdating() {
                return this.isUpdating;
            }

            public final List<ServerSettingsRoleMemberAdapterItem> component2() {
                return this.memberList;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildRole getRole() {
                return this.role;
            }

            public final Loaded copy(boolean isUpdating, List<ServerSettingsRoleMemberAdapterItem> memberList, GuildRole role) {
                Intrinsics3.checkNotNullParameter(memberList, "memberList");
                Intrinsics3.checkNotNullParameter(role, "role");
                return new Loaded(isUpdating, memberList, role);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.isUpdating == loaded.isUpdating && Intrinsics3.areEqual(this.memberList, loaded.memberList) && Intrinsics3.areEqual(this.role, loaded.role);
            }

            public final List<ServerSettingsRoleMemberAdapterItem> getMemberList() {
                return this.memberList;
            }

            public final GuildRole getRole() {
                return this.role;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6 */
            /* JADX WARN: Type inference failed for: r0v7 */
            public int hashCode() {
                boolean z2 = this.isUpdating;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                List<ServerSettingsRoleMemberAdapterItem> list = this.memberList;
                int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
                GuildRole guildRole = this.role;
                return iHashCode + (guildRole != null ? guildRole.hashCode() : 0);
            }

            public final boolean isUpdating() {
                return this.isUpdating;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(isUpdating=");
                sbU.append(this.isUpdating);
                sbU.append(", memberList=");
                sbU.append(this.memberList);
                sbU.append(", role=");
                sbU.append(this.role);
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(boolean z2, List<ServerSettingsRoleMemberAdapterItem> list, GuildRole guildRole) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "memberList");
                Intrinsics3.checkNotNullParameter(guildRole, "role");
                this.isUpdating = z2;
                this.memberList = list;
                this.role = guildRole;
            }
        }

        /* compiled from: ServerSettingsRoleMembersViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: ServerSettingsRoleMembersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$removeRoleFromMember$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            ServerSettingsRoleMembersViewModel.access$updateViewState(ServerSettingsRoleMembersViewModel.this, ViewState.Loaded.copy$default(this.$viewState, false, null, null, 6, null));
        }
    }

    /* compiled from: ServerSettingsRoleMembersViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$removeRoleFromMember$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
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
            ServerSettingsRoleMembersViewModel.access$emitEvent(ServerSettingsRoleMembersViewModel.this, new Event.RemoveMemberFailure(error));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ServerSettingsRoleMembersViewModel(long j, long j2, StoreGatewayConnection storeGatewayConnection, BehaviorSubject behaviorSubject, RestAPI restAPI, StoreGuilds storeGuilds, ObservationDeck observationDeck, StoreUser storeUser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubject2;
        StoreGatewayConnection gatewaySocket = (i & 4) != 0 ? StoreStream.INSTANCE.getGatewaySocket() : storeGatewayConnection;
        if ((i & 8) != 0) {
            BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0("");
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
            behaviorSubject2 = behaviorSubjectL0;
        } else {
            behaviorSubject2 = behaviorSubject;
        }
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuilds guilds = (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        ObservationDeck observationDeck2 = (i & 64) != 0 ? ObservationDeck4.get() : observationDeck;
        StoreUser users = (i & 128) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(j, j2, gatewaySocket, behaviorSubject2, api, guilds, observationDeck2, users, (i & 256) != 0 ? INSTANCE.observeStoreState(j, j2, behaviorSubject2, guilds, users, observationDeck2) : observable);
    }

    public static final /* synthetic */ void access$emitEvent(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel, Event event) {
        serverSettingsRoleMembersViewModel.emitEvent(event);
    }

    public static final /* synthetic */ long access$getGuildId$p(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel) {
        return serverSettingsRoleMembersViewModel.guildId;
    }

    public static final /* synthetic */ StoreGatewayConnection access$getStoreGatewayConnection$p(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel) {
        return serverSettingsRoleMembersViewModel.storeGatewayConnection;
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel, StoreState storeState) {
        serverSettingsRoleMembersViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsRoleMembersViewModel serverSettingsRoleMembersViewModel, ViewState viewState) {
        serverSettingsRoleMembersViewModel.updateViewState(viewState);
    }

    private final void emitEvent(Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final List<ServerSettingsRoleMemberAdapterItem> generateGuildMemberList(List<GuildMember> guildMembers, Map<Long, ? extends User> users) {
        ArrayList arrayList = new ArrayList();
        for (GuildMember guildMember : guildMembers) {
            User user = users.get(Long.valueOf(guildMember.getUserId()));
            if (user != null) {
                Object nick = guildMember.getNick();
                if (nick == null) {
                    nick = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
                }
                arrayList.add(new ServerSettingsRoleMemberAdapterItem(guildMember, new PermissionOwner.Member(user, nick.toString(), false)));
            }
        }
        return arrayList;
    }

    private final void handleStoreState(StoreState storeState) {
        if (storeState.getRole() == null) {
            return;
        }
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        updateViewState(new ViewState.Loaded(loaded != null ? loaded.isUpdating() : false, generateGuildMemberList(storeState.getGuildMembers(), storeState.getUsers()), storeState.getRole()));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void removeRoleFromMember(GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, true, null, null, 6, null));
            List<Long> mutableList = _Collections.toMutableList((Collection) guildMember.getRoles());
            mutableList.remove(Long.valueOf(this.guildRoleId));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.changeGuildMember(this.guildId, guildMember.getUserId(), RestAPIParams.GuildMember.INSTANCE.createWithRoles(mutableList)), false, 1, null), this, null, 2, null), ServerSettingsRoleMembersViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(loaded), 54, (Object) null);
        }
    }

    public final void updateSearchQuery(String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.searchQuerySubject.onNext(query);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel(long j, long j2, StoreGatewayConnection storeGatewayConnection, BehaviorSubject<String> behaviorSubject, RestAPI restAPI, StoreGuilds storeGuilds, ObservationDeck observationDeck, StoreUser storeUser, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
        Intrinsics3.checkNotNullParameter(behaviorSubject, "searchQuerySubject");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.guildRoleId = j2;
        this.storeGatewayConnection = storeGatewayConnection;
        this.searchQuerySubject = behaviorSubject;
        this.restApi = restAPI;
        this.eventSubject = PublishSubject.k0();
        StoreGuilds.Actions.requestRoleMembers(j, j2, this, restAPI, storeGatewayConnection);
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), ServerSettingsRoleMembersViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable<String> observableP = behaviorSubject.P(750L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "searchQuerySubject\n     …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableP), this, null, 2, null), ServerSettingsRoleMembersViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
