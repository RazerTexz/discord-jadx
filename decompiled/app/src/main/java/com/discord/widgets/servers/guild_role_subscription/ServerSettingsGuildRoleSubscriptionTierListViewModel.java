package com.discord.widgets.servers.guild_role_subscription;

import a0.a.a.b;
import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0015\u0016\u0017B7\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00060\bj\u0002`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "storeObservable", "<init>", "(JLcom/discord/stores/StoreGuildRoleSubscriptions;Lcom/discord/stores/updates/ObservationDeck;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierListViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_TIER_ITEMS = 3;
    private final long guildId;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierListViewModel$1, reason: invalid class name */
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
            ServerSettingsGuildRoleSubscriptionTierListViewModel.access$handleStoreState(ServerSettingsGuildRoleSubscriptionTierListViewModel.this, storeState);
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lrx/Observable;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuildRoleSubscriptions;)Lrx/Observable;", "", "MAX_TIER_ITEMS", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
            return companion.observeStoreState(j, observationDeck, storeGuildRoleSubscriptions);
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new ServerSettingsGuildRoleSubscriptionTierListViewModel2(storeGuildRoleSubscriptions, guildId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState;", "", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "component1", "()Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "guildRoleSubscriptionGroupState", "copy", "(Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;)Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "getGuildRoleSubscriptionGroupState", "<init>", "(Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState;

        public StoreState(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState) {
            this.guildRoleSubscriptionGroupState = guildRoleSubscriptionGroupState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionGroupState = storeState.guildRoleSubscriptionGroupState;
            }
            return storeState.copy(guildRoleSubscriptionGroupState);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
            return this.guildRoleSubscriptionGroupState;
        }

        public final StoreState copy(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState) {
            return new StoreState(guildRoleSubscriptionGroupState);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && Intrinsics3.areEqual(this.guildRoleSubscriptionGroupState, ((StoreState) other).guildRoleSubscriptionGroupState);
            }
            return true;
        }

        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
            return this.guildRoleSubscriptionGroupState;
        }

        public int hashCode() {
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupState;
            if (guildRoleSubscriptionGroupState != null) {
                return guildRoleSubscriptionGroupState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildRoleSubscriptionGroupState=");
            sbU.append(this.guildRoleSubscriptionGroupState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState;", "", "<init>", "()V", "Failed", "Loaded", "Loading", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Failed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Failed;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState;", "", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem;", "component1", "()Ljava/util/List;", "", "component2", "()J", "adapterItems", "groupListingId", "copy", "(Ljava/util/List;J)Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAdapterItems", "J", "getGroupListingId", "<init>", "(Ljava/util/List;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final List<ServerSettingsGuildRoleSubscriptionTierAdapter2> adapterItems;
            private final long groupListingId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> list, long j) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
                this.groupListingId = j;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.adapterItems;
                }
                if ((i & 2) != 0) {
                    j = loaded.groupListingId;
                }
                return loaded.copy(list, j);
            }

            public final List<ServerSettingsGuildRoleSubscriptionTierAdapter2> component1() {
                return this.adapterItems;
            }

            /* renamed from: component2, reason: from getter */
            public final long getGroupListingId() {
                return this.groupListingId;
            }

            public final Loaded copy(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> adapterItems, long groupListingId) {
                Intrinsics3.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems, groupListingId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.adapterItems, loaded.adapterItems) && this.groupListingId == loaded.groupListingId;
            }

            public final List<ServerSettingsGuildRoleSubscriptionTierAdapter2> getAdapterItems() {
                return this.adapterItems;
            }

            public final long getGroupListingId() {
                return this.groupListingId;
            }

            public int hashCode() {
                List<ServerSettingsGuildRoleSubscriptionTierAdapter2> list = this.adapterItems;
                return b.a(this.groupListingId) + ((list != null ? list.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(adapterItems=");
                sbU.append(this.adapterItems);
                sbU.append(", groupListingId=");
                return outline.C(sbU, this.groupListingId, ")");
            }
        }

        /* compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel(long j, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeck4.get() : observationDeck;
        this(j, guildRoleSubscriptions, observationDeck2, (i & 8) != 0 ? Companion.access$observeStoreState(INSTANCE, j, observationDeck2, guildRoleSubscriptions) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsGuildRoleSubscriptionTierListViewModel serverSettingsGuildRoleSubscriptionTierListViewModel, StoreState storeState) {
        serverSettingsGuildRoleSubscriptionTierListViewModel.handleStoreState(storeState);
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
            }
        } else {
            GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) storeState.getGuildRoleSubscriptionGroupState()).getGuildRoleSubscriptionGroupListing();
            if (guildRoleSubscriptionGroupListing == null) {
                updateViewState(ViewState.Failed.INSTANCE);
            } else {
                updateViewState(new ViewState.Loaded(ServerSettingsGuildRoleSubscriptionTierListItemGenerator.generateServerSettingsGuildRoleSubscriptionTierListItems(guildRoleSubscriptionGroupListing.h(), 3), guildRoleSubscriptionGroupListing.getId()));
            }
        }
    }

    private static final Observable<StoreState> observeStoreState(long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return Companion.access$observeStoreState(INSTANCE, j, observationDeck, storeGuildRoleSubscriptions);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionTierListViewModel(long j, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        storeGuildRoleSubscriptions.fetchGuildRoleSubscriptionGroupsForGuild(j);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ServerSettingsGuildRoleSubscriptionTierListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
