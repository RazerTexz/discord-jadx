package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000201BC\u0012\b\b\u0002\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00052\n\u0010\u000e\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState;", "state", "", "handleStoreState", "(Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "observeStoreState", "(J)Lrx/Observable;", ModelAuditLogEntry.CHANGE_KEY_ID, "setGuildId", "(J)V", "", "trackingSourceLocation", "setTrackingSourceLocation", "(Ljava/lang/String;)V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "hasSubmittedAnalytics", "Z", "Lcom/discord/stores/StoreSubscriptions;", "subscriptionsStore", "Lcom/discord/stores/StoreSubscriptions;", "Lcom/discord/stores/StoreExperiments;", "experimentsStore", "Lcom/discord/stores/StoreExperiments;", "Lrx/Subscription;", "storeObservableSubscription", "Lrx/Subscription;", "Ljava/lang/String;", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreConnectivity;", "connectivityStore", "Lcom/discord/stores/StoreConnectivity;", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "guildRoleSubscriptionsStore", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "<init>", "(Lcom/discord/stores/StoreConnectivity;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreSubscriptions;Lcom/discord/stores/StoreGuildRoleSubscriptions;Lcom/discord/stores/updates/ObservationDeck;)V", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPointViewModel extends AppViewModel<ViewState> {
    private final StoreConnectivity connectivityStore;
    private final StoreExperiments experimentsStore;
    private final StoreGuildRoleSubscriptions guildRoleSubscriptionsStore;
    private final StoreGuilds guildsStore;
    private boolean hasSubmittedAnalytics;
    private final ObservationDeck observationDeck;
    private Subscription storeObservableSubscription;
    private final StoreSubscriptions subscriptionsStore;
    private String trackingSourceLocation;

    /* compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJH\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u000f\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\bR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\rR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u000e\u0010\u0004¨\u0006'"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState;", "", "", "component1", "()Z", "component2", "Lcom/discord/models/guild/Guild;", "component3", "()Lcom/discord/models/guild/Guild;", "component4", "()Ljava/lang/Boolean;", "", "component5", "()Ljava/lang/Long;", "isConnected", "isAccessible", "guild", "hasUserActiveSubscription", "guildRoleSubscriptionGroupListingId", "copy", "(ZZLcom/discord/models/guild/Guild;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Ljava/lang/Long;", "getGuildRoleSubscriptionGroupListingId", "Ljava/lang/Boolean;", "getHasUserActiveSubscription", "<init>", "(ZZLcom/discord/models/guild/Guild;Ljava/lang/Boolean;Ljava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final Long guildRoleSubscriptionGroupListingId;
        private final Boolean hasUserActiveSubscription;
        private final boolean isAccessible;
        private final boolean isConnected;

        public StoreState(boolean z2, boolean z3, Guild guild, Boolean bool, Long l) {
            this.isConnected = z2;
            this.isAccessible = z3;
            this.guild = guild;
            this.hasUserActiveSubscription = bool;
            this.guildRoleSubscriptionGroupListingId = l;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, boolean z3, Guild guild, Boolean bool, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.isConnected;
            }
            if ((i & 2) != 0) {
                z3 = storeState.isAccessible;
            }
            boolean z4 = z3;
            if ((i & 4) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 8) != 0) {
                bool = storeState.hasUserActiveSubscription;
            }
            Boolean bool2 = bool;
            if ((i & 16) != 0) {
                l = storeState.guildRoleSubscriptionGroupListingId;
            }
            return storeState.copy(z2, z4, guild2, bool2, l);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsConnected() {
            return this.isConnected;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsAccessible() {
            return this.isAccessible;
        }

        /* renamed from: component3, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component4, reason: from getter */
        public final Boolean getHasUserActiveSubscription() {
            return this.hasUserActiveSubscription;
        }

        /* renamed from: component5, reason: from getter */
        public final Long getGuildRoleSubscriptionGroupListingId() {
            return this.guildRoleSubscriptionGroupListingId;
        }

        public final StoreState copy(boolean isConnected, boolean isAccessible, Guild guild, Boolean hasUserActiveSubscription, Long guildRoleSubscriptionGroupListingId) {
            return new StoreState(isConnected, isAccessible, guild, hasUserActiveSubscription, guildRoleSubscriptionGroupListingId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.isConnected == storeState.isConnected && this.isAccessible == storeState.isAccessible && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.hasUserActiveSubscription, storeState.hasUserActiveSubscription) && Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListingId, storeState.guildRoleSubscriptionGroupListingId);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getGuildRoleSubscriptionGroupListingId() {
            return this.guildRoleSubscriptionGroupListingId;
        }

        public final Boolean getHasUserActiveSubscription() {
            return this.hasUserActiveSubscription;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public int hashCode() {
            boolean z2 = this.isConnected;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isAccessible;
            int i2 = (i + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode = (i2 + (guild != null ? guild.hashCode() : 0)) * 31;
            Boolean bool = this.hasUserActiveSubscription;
            int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            Long l = this.guildRoleSubscriptionGroupListingId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isAccessible() {
            return this.isAccessible;
        }

        public final boolean isConnected() {
            return this.isConnected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(isConnected=");
            sbU.append(this.isConnected);
            sbU.append(", isAccessible=");
            sbU.append(this.isAccessible);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", hasUserActiveSubscription=");
            sbU.append(this.hasUserActiveSubscription);
            sbU.append(", guildRoleSubscriptionGroupListingId=");
            return outline.G(sbU, this.guildRoleSubscriptionGroupListingId, ")");
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Uninitialized", "Valid", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        /* compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid;", "Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "guild", "copy", "(Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends ViewState {
            private final Guild guild;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                return valid.copy(guild);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Valid copy(Guild guild) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Valid) && Intrinsics3.areEqual(this.guild, ((Valid) other).guild);
                }
                return true;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public int hashCode() {
                Guild guild = this.guild;
                if (guild != null) {
                    return guild.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
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

    /* compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel$observeStoreState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<StoreState> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StoreState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StoreState invoke() {
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionState = WidgetGuildRoleSubscriptionEntryPointViewModel.access$getGuildRoleSubscriptionsStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel.this).getGuildRoleSubscriptionState(this.$guildId);
            Boolean boolValueOf = null;
            if (!(guildRoleSubscriptionState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded)) {
                guildRoleSubscriptionState = null;
            }
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded loaded = (StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) guildRoleSubscriptionState;
            GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = loaded != null ? loaded.getGuildRoleSubscriptionGroupListing() : null;
            StoreSubscriptions.SubscriptionsState subscriptionsStateSnapshot = WidgetGuildRoleSubscriptionEntryPointViewModel.access$getSubscriptionsStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel.this).getSubscriptionsStateSnapshot();
            if (!(subscriptionsStateSnapshot instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
                subscriptionsStateSnapshot = null;
            }
            StoreSubscriptions.SubscriptionsState.Loaded loaded2 = (StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsStateSnapshot;
            List<ModelSubscription> subscriptions = loaded2 != null ? loaded2.getSubscriptions() : null;
            Long lValueOf = guildRoleSubscriptionGroupListing != null ? Long.valueOf(guildRoleSubscriptionGroupListing.getId()) : null;
            if (subscriptions != null && guildRoleSubscriptionGroupListing != null) {
                boolValueOf = Boolean.valueOf(GuildRoleSubscriptionUtils2.hasUserActiveSubscriptionFor(guildRoleSubscriptionGroupListing, subscriptions));
            }
            return new StoreState(WidgetGuildRoleSubscriptionEntryPointViewModel.access$getConnectivityStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel.this).isConnected(), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().canGuildSeePremiumMemberships(this.$guildId), WidgetGuildRoleSubscriptionEntryPointViewModel.access$getGuildsStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel.this).getGuild(this.$guildId), boolValueOf, lValueOf);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetGuildRoleSubscriptionEntryPointViewModel.access$setStoreObservableSubscription$p(WidgetGuildRoleSubscriptionEntryPointViewModel.this, subscription);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel = WidgetGuildRoleSubscriptionEntryPointViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            WidgetGuildRoleSubscriptionEntryPointViewModel.access$handleStoreState(widgetGuildRoleSubscriptionEntryPointViewModel, storeState);
        }
    }

    public WidgetGuildRoleSubscriptionEntryPointViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel(StoreConnectivity storeConnectivity, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreSubscriptions storeSubscriptions, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getConnectivity() : storeConnectivity, (i & 2) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions, (i & 16) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 32) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ StoreConnectivity access$getConnectivityStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.connectivityStore;
    }

    public static final /* synthetic */ StoreGuildRoleSubscriptions access$getGuildRoleSubscriptionsStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.guildRoleSubscriptionsStore;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.guildsStore;
    }

    public static final /* synthetic */ Subscription access$getStoreObservableSubscription$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.storeObservableSubscription;
    }

    public static final /* synthetic */ StoreSubscriptions access$getSubscriptionsStore$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        return widgetGuildRoleSubscriptionEntryPointViewModel.subscriptionsStore;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel, StoreState storeState) {
        widgetGuildRoleSubscriptionEntryPointViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$setStoreObservableSubscription$p(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel, Subscription subscription) {
        widgetGuildRoleSubscriptionEntryPointViewModel.storeObservableSubscription = subscription;
    }

    private final void handleStoreState(StoreState state) {
        if (state.getGuild() != null && state.isAccessible()) {
            updateViewState(new ViewState.Valid(state.getGuild()));
        } else if (state.isConnected()) {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
        String str = this.trackingSourceLocation;
        if (state.getHasUserActiveSubscription() == null || state.getGuildRoleSubscriptionGroupListingId() == null) {
            return;
        }
        if ((str == null || StringsJVM.isBlank(str)) || this.hasSubmittedAnalytics) {
            return;
        }
        AnalyticsTracker.guildRoleSubscriptionUpsellOpened$default(AnalyticsTracker.INSTANCE, state.getGuildRoleSubscriptionGroupListingId().longValue(), null, state.getHasUserActiveSubscription().booleanValue(), str, 2, null);
        this.hasSubmittedAnalytics = true;
    }

    private final Observable<StoreState> observeStoreState(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.connectivityStore, this.experimentsStore, this.guildsStore, this.subscriptionsStore, this.guildRoleSubscriptionsStore}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    public static /* synthetic */ void setTrackingSourceLocation$default(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Role Subscriptions Tab";
        }
        widgetGuildRoleSubscriptionEntryPointViewModel.setTrackingSourceLocation(str);
    }

    public final void setGuildId(long id2) {
        Subscription subscription = this.storeObservableSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.guildRoleSubscriptionsStore.fetchGuildRoleSubscriptionGroupsForGuild(id2);
        Observable<StoreState> observableR = observeStoreState(id2).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState(id)\n  …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetGuildRoleSubscriptionEntryPointViewModel.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }

    public final void setTrackingSourceLocation(String trackingSourceLocation) {
        if (!Intrinsics3.areEqual(this.trackingSourceLocation, trackingSourceLocation)) {
            this.hasSubmittedAnalytics = false;
        }
        this.trackingSourceLocation = trackingSourceLocation;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionEntryPointViewModel(StoreConnectivity storeConnectivity, StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreSubscriptions storeSubscriptions, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeConnectivity, "connectivityStore");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "subscriptionsStore");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "guildRoleSubscriptionsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.connectivityStore = storeConnectivity;
        this.experimentsStore = storeExperiments;
        this.guildsStore = storeGuilds;
        this.subscriptionsStore = storeSubscriptions;
        this.guildRoleSubscriptionsStore = storeGuildRoleSubscriptions;
        this.observationDeck = observationDeck;
        storeSubscriptions.fetchSubscriptions();
    }
}
