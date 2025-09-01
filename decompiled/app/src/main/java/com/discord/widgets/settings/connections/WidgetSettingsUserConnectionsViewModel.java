package com.discord.widgets.settings.connections;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005$%&'(B+\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#J1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013Rj\u0010\u0016\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007 \u0015*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u0005 \u0015**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007 \u0015*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u0005\u0018\u00010\u00140\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006)"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$StoreState;", "storeState", "", "", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus;", "joinMap", "", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ConnectionState;", "combineState", "(Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$StoreState;Ljava/util/Map;)Ljava/util/List;", "state", "", "handleConnectionsState", "(Ljava/util/List;)V", "integrationId", "joinConnectionIntegrationGuild", "(Ljava/lang/String;)V", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "joinStateSubject", "Lrx/subjects/BehaviorSubject;", "", "joinStatusMap", "Ljava/util/Map;", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "Lrx/Observable;", "storeStateObservable", "Lcom/discord/stores/StoreUserConnections;", "storeUserConnections", "<init>", "(Lrx/Observable;Lcom/discord/stores/StoreUserConnections;Lcom/discord/utilities/rest/RestAPI;)V", "Companion", "ConnectionState", "JoinStatus", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BehaviorSubject<Map<String, JoinStatus>> joinStateSubject;
    private final Map<String, JoinStatus> joinStatusMap;
    private final RestAPI restApi;

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\b \u0001*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0001*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus;", "joinMap", "", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ConnectionState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$StoreState;Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<StoreState, Map<String, ? extends JoinStatus>, List<? extends ConnectionState>> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends ConnectionState> call(StoreState storeState, Map<String, ? extends JoinStatus> map) {
            return call2(storeState, map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ConnectionState> call2(StoreState storeState, Map<String, ? extends JoinStatus> map) {
            WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel = WidgetSettingsUserConnectionsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            Intrinsics3.checkNotNullExpressionValue(map, "joinMap");
            return WidgetSettingsUserConnectionsViewModel.access$combineState(widgetSettingsUserConnectionsViewModel, storeState, map);
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ConnectionState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends ConnectionState>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ConnectionState> list) {
            invoke2((List<ConnectionState>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ConnectionState> list) {
            WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel = WidgetSettingsUserConnectionsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(list, "storeState");
            WidgetSettingsUserConnectionsViewModel.access$handleConnectionsState(widgetSettingsUserConnectionsViewModel, list);
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$StoreState;", "observeStores", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion) {
            return companion.observeStores();
        }

        private final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableJ = Observable.j(companion.getUserConnections().observeConnectedAccounts(), companion.getGuilds().observeGuilds(), WidgetSettingsUserConnectionsViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…= \"contacts\" }, guilds) }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ConnectionState;", "", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "component1", "()Lcom/discord/api/connectedaccounts/ConnectedAccount;", "", "", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus;", "component2", "()Ljava/util/Map;", "connection", "integrationGuildJoinStatus", "copy", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;Ljava/util/Map;)Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ConnectionState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "getConnection", "Ljava/util/Map;", "getIntegrationGuildJoinStatus", "<init>", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ConnectionState {
        private final ConnectedAccount connection;
        private final Map<String, JoinStatus> integrationGuildJoinStatus;

        /* JADX WARN: Multi-variable type inference failed */
        public ConnectionState(ConnectedAccount connectedAccount, Map<String, ? extends JoinStatus> map) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "connection");
            Intrinsics3.checkNotNullParameter(map, "integrationGuildJoinStatus");
            this.connection = connectedAccount;
            this.integrationGuildJoinStatus = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConnectionState copy$default(ConnectionState connectionState, ConnectedAccount connectedAccount, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                connectedAccount = connectionState.connection;
            }
            if ((i & 2) != 0) {
                map = connectionState.integrationGuildJoinStatus;
            }
            return connectionState.copy(connectedAccount, map);
        }

        /* renamed from: component1, reason: from getter */
        public final ConnectedAccount getConnection() {
            return this.connection;
        }

        public final Map<String, JoinStatus> component2() {
            return this.integrationGuildJoinStatus;
        }

        public final ConnectionState copy(ConnectedAccount connection, Map<String, ? extends JoinStatus> integrationGuildJoinStatus) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            Intrinsics3.checkNotNullParameter(integrationGuildJoinStatus, "integrationGuildJoinStatus");
            return new ConnectionState(connection, integrationGuildJoinStatus);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectionState)) {
                return false;
            }
            ConnectionState connectionState = (ConnectionState) other;
            return Intrinsics3.areEqual(this.connection, connectionState.connection) && Intrinsics3.areEqual(this.integrationGuildJoinStatus, connectionState.integrationGuildJoinStatus);
        }

        public final ConnectedAccount getConnection() {
            return this.connection;
        }

        public final Map<String, JoinStatus> getIntegrationGuildJoinStatus() {
            return this.integrationGuildJoinStatus;
        }

        public int hashCode() {
            ConnectedAccount connectedAccount = this.connection;
            int iHashCode = (connectedAccount != null ? connectedAccount.hashCode() : 0) * 31;
            Map<String, JoinStatus> map = this.integrationGuildJoinStatus;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ConnectionState(connection=");
            sbU.append(this.connection);
            sbU.append(", integrationGuildJoinStatus=");
            return outline.M(sbU, this.integrationGuildJoinStatus, ")");
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus;", "", "<init>", "()V", "JoinFailed", "Joined", "Joining", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus$Joined;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus$Joining;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus$JoinFailed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class JoinStatus {

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus$JoinFailed;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class JoinFailed extends JoinStatus {
            public static final JoinFailed INSTANCE = new JoinFailed();

            private JoinFailed() {
                super(null);
            }
        }

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus$Joined;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Joined extends JoinStatus {
            public static final Joined INSTANCE = new Joined();

            private Joined() {
                super(null);
            }
        }

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus$Joining;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$JoinStatus;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Joining extends JoinStatus {
            public static final Joining INSTANCE = new Joining();

            private Joining() {
                super(null);
            }
        }

        private JoinStatus() {
        }

        public /* synthetic */ JoinStatus(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0018\b\u0002\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R)\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005¨\u0006 "}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$StoreState;", "", "", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "component1", "()Ljava/util/List;", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "component2", "()Ljava/util/Map;", "connectedAccounts", "guilds", "copy", "(Ljava/util/List;Ljava/util/Map;)Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getGuilds", "Ljava/util/List;", "getConnectedAccounts", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final List<ConnectedAccount> connectedAccounts;
        private final Map<Long, Guild> guilds;

        public StoreState(List<ConnectedAccount> list, Map<Long, Guild> map) {
            Intrinsics3.checkNotNullParameter(list, "connectedAccounts");
            Intrinsics3.checkNotNullParameter(map, "guilds");
            this.connectedAccounts = list;
            this.guilds = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.connectedAccounts;
            }
            if ((i & 2) != 0) {
                map = storeState.guilds;
            }
            return storeState.copy(list, map);
        }

        public final List<ConnectedAccount> component1() {
            return this.connectedAccounts;
        }

        public final Map<Long, Guild> component2() {
            return this.guilds;
        }

        public final StoreState copy(List<ConnectedAccount> connectedAccounts, Map<Long, Guild> guilds) {
            Intrinsics3.checkNotNullParameter(connectedAccounts, "connectedAccounts");
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            return new StoreState(connectedAccounts, guilds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.connectedAccounts, storeState.connectedAccounts) && Intrinsics3.areEqual(this.guilds, storeState.guilds);
        }

        public final List<ConnectedAccount> getConnectedAccounts() {
            return this.connectedAccounts;
        }

        public final Map<Long, Guild> getGuilds() {
            return this.guilds;
        }

        public int hashCode() {
            List<ConnectedAccount> list = this.connectedAccounts;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, Guild> map = this.guilds;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(connectedAccounts=");
            sbU.append(this.connectedAccounts);
            sbU.append(", guilds=");
            return outline.M(sbU, this.guilds, ")");
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState;", "", "<init>", "()V", "Empty", "Loaded", "Uninitialized", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState$Empty;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState$Empty;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends ViewState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState;", "", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ConnectionState;", "component1", "()Ljava/util/List;", "data", "copy", "(Ljava/util/List;)Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getData", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final List<ConnectionState> data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<ConnectionState> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "data");
                this.data = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.data;
                }
                return loaded.copy(list);
            }

            public final List<ConnectionState> component1() {
                return this.data;
            }

            public final Loaded copy(List<ConnectionState> data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final List<ConnectionState> getData() {
                return this.data;
            }

            public int hashCode() {
                List<ConnectionState> list = this.data;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(data="), this.data, ")");
            }
        }

        /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/settings/connections/WidgetSettingsUserConnectionsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$joinConnectionIntegrationGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $integrationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$integrationId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetSettingsUserConnectionsViewModel.access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel.this).put(this.$integrationId, JoinStatus.JoinFailed.INSTANCE);
            WidgetSettingsUserConnectionsViewModel.access$getJoinStateSubject$p(WidgetSettingsUserConnectionsViewModel.this).onNext(WidgetSettingsUserConnectionsViewModel.access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel.this));
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel$joinConnectionIntegrationGuild$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $integrationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$integrationId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            WidgetSettingsUserConnectionsViewModel.access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel.this).put(this.$integrationId, JoinStatus.Joined.INSTANCE);
            WidgetSettingsUserConnectionsViewModel.access$getJoinStateSubject$p(WidgetSettingsUserConnectionsViewModel.this).onNext(WidgetSettingsUserConnectionsViewModel.access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel.this));
        }
    }

    public WidgetSettingsUserConnectionsViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ WidgetSettingsUserConnectionsViewModel(Observable observable, StoreUserConnections storeUserConnections, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.access$observeStores(INSTANCE) : observable, (i & 2) != 0 ? StoreStream.INSTANCE.getUserConnections() : storeUserConnections, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ List access$combineState(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel, StoreState storeState, Map map) {
        return widgetSettingsUserConnectionsViewModel.combineState(storeState, map);
    }

    public static final /* synthetic */ BehaviorSubject access$getJoinStateSubject$p(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel) {
        return widgetSettingsUserConnectionsViewModel.joinStateSubject;
    }

    public static final /* synthetic */ Map access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel) {
        return widgetSettingsUserConnectionsViewModel.joinStatusMap;
    }

    public static final /* synthetic */ void access$handleConnectionsState(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel, List list) {
        widgetSettingsUserConnectionsViewModel.handleConnectionsState(list);
    }

    private final List<ConnectionState> combineState(StoreState storeState, Map<String, ? extends JoinStatus> joinMap) {
        ArrayList arrayList = new ArrayList();
        for (ConnectedAccount connectedAccount : storeState.getConnectedAccounts()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<ConnectedAccountIntegration> listC = connectedAccount.c();
            if (listC != null) {
                for (ConnectedAccountIntegration connectedAccountIntegration : listC) {
                    ConnectedIntegrationGuild guild = connectedAccountIntegration.getGuild();
                    if (guild != null) {
                        if (storeState.getGuilds().containsKey(Long.valueOf(guild.getId()))) {
                            linkedHashMap.put(connectedAccountIntegration.getId(), JoinStatus.Joined.INSTANCE);
                        }
                        JoinStatus joinStatus = joinMap.get(connectedAccountIntegration.getId());
                        if (joinStatus != null) {
                            linkedHashMap.put(connectedAccountIntegration.getId(), joinStatus);
                        }
                    }
                }
            }
            arrayList.add(new ConnectionState(connectedAccount, linkedHashMap));
        }
        return arrayList;
    }

    private final void handleConnectionsState(List<ConnectionState> state) {
        if (state == null || state.isEmpty()) {
            updateViewState(ViewState.Empty.INSTANCE);
        } else {
            updateViewState(new ViewState.Loaded(state));
        }
    }

    public final void joinConnectionIntegrationGuild(String integrationId) {
        Intrinsics3.checkNotNullParameter(integrationId, "integrationId");
        this.joinStatusMap.put(integrationId, JoinStatus.Joining.INSTANCE);
        this.joinStateSubject.onNext(this.joinStatusMap);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.joinGuildFromIntegration(integrationId), false, 1, null), WidgetSettingsUserConnectionsViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(integrationId), (Function0) null, (Function0) null, new AnonymousClass2(integrationId), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsViewModel(Observable<StoreState> observable, StoreUserConnections storeUserConnections, RestAPI restAPI) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(storeUserConnections, "storeUserConnections");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.restApi = restAPI;
        this.joinStatusMap = new LinkedHashMap();
        BehaviorSubject<Map<String, JoinStatus>> behaviorSubjectL0 = BehaviorSubject.l0(Maps6.emptyMap());
        this.joinStateSubject = behaviorSubjectL0;
        storeUserConnections.fetchConnectedAccounts();
        Observable observableJ = Observable.j(observable, behaviorSubjectL0, new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…te(storeState, joinMap) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableJ), this, null, 2, null), WidgetSettingsUserConnectionsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
