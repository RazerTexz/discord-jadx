package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionFreeTrialIntervalTypes;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.premium.PriceTierType;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: StoreGuildRoleSubscriptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0003IJKB\u0019\u0012\u0006\u0010@\u001a\u00020?\u0012\b\b\u0002\u00109\u001a\u000208¢\u0006\u0004\bG\u0010HJ%\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00172\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\n¢\u0006\u0004\b!\u0010\u001fJ\r\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\u0010J\u0019\u0010#\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b(\u0010\tJ)\u0010,\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010)\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b.\u0010/J)\u00101\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010)\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u000b¢\u0006\u0004\b1\u00102J)\u00104\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010)\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0002¢\u0006\u0004\b4\u00105R2\u00106\u001a\u001e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0\u00170\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\"\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00107R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR.\u0010B\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00170\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00107R.\u0010D\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0C0C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u00107R&\u0010E\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00140C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u00107R2\u0010F\u001a\u001e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0C0C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00107¨\u0006L"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "guildRoleSubscriptionGroupListing", "", "handleGuildRoleSubscriptionGroupFetch", "(JLcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;)V", "", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "guildRoleSubscriptionFreeTrialList", "handleGuildRoleSubscriptionFreeTrialListFetch", "(JLjava/util/List;)V", "snapshotData", "()V", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "getPriceTiersState", "()Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "getGuildRoleSubscriptionState", "(J)Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "", "getGuildRoleSubscriptionFreeTrials", "(J)Ljava/util/Map;", "listingId", "getGuildRoleSubscriptionFreeTrialForListing", "(JJ)Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "getGuildRoleSubscriptionFreeTrialIntervalOptions", "()Ljava/util/List;", "", "getGuildRoleSubscriptionFreeTrialActiveUserLimitOptions", "fetchPriceTiersIfNonExisting", "fetchGuildRoleSubscriptionGroupsForGuild", "(J)V", "guildRoleSubscriptionGroupId", "fetchGuildRoleSubscriptionGroup", "(JJ)V", "handleGuildRoleSubscriptionGroupUpdate", "guildRoleSubscriptionGroupListingId", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "guildRoleSubscriptionTierListing", "handleGuildRoleSubscriptionTierListingCreate", "(JJLcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)V", "handleGuildRoleSubscriptionTierListingUpdate", "(JLcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)V", "guildRoleSubscriptionTierFreeTrial", "handleGuildRoleSubscriptionTierTrialUpdate", "(JJLcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;)V", "guildRoleSubscriptionTierListingId", "handleGuildRoleSubscriptionTierListingDelete", "(JJJ)V", "guildRoleSubscriptionTiersSnapshot", "Ljava/util/Map;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "priceTierStateSnapshot", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "priceTierState", "guildRoleSubscriptionGroupsSnapshot", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "guildRoleSubscriptionFreeTrialsSnapshot", "", "guildRoleSubscriptionFreeTrials", "guildRoleSubscriptionGroups", "guildRoleSubscriptionTiers", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;)V", "GuildRoleSubscriptionFreeTrialsState", "GuildRoleSubscriptionGroupState", "PriceTierState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, Map<Long, GuildRoleSubscriptionTierFreeTrial>> guildRoleSubscriptionFreeTrials;
    private Map<Long, ? extends Map<Long, GuildRoleSubscriptionTierFreeTrial>> guildRoleSubscriptionFreeTrialsSnapshot;
    private final Map<Long, GuildRoleSubscriptionGroupState> guildRoleSubscriptionGroups;
    private Map<Long, ? extends GuildRoleSubscriptionGroupState> guildRoleSubscriptionGroupsSnapshot;
    private final Map<Long, Map<Long, GuildRoleSubscriptionTierListing>> guildRoleSubscriptionTiers;
    private Map<Long, ? extends Map<Long, GuildRoleSubscriptionTierListing>> guildRoleSubscriptionTiersSnapshot;
    private PriceTierState priceTierState;
    private PriceTierState priceTierStateSnapshot;
    private final RestAPI restAPI;

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState;", "", "<init>", "()V", "Failed", "Loaded", "Loading", "Uninitialized", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Uninitialized;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loading;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Failed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class GuildRoleSubscriptionFreeTrialsState {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Failed;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends GuildRoleSubscriptionFreeTrialsState {
            private final String errorMessage;

            public Failed() {
                this(null, 1, null);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\b\u001a\u00020\u00002\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R'\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState;", "", "", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "component1", "()Ljava/util/Map;", "freeTrials", "copy", "(Ljava/util/Map;)Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getFreeTrials", "<init>", "(Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends GuildRoleSubscriptionFreeTrialsState {
            private final Map<Long, GuildRoleSubscriptionTierFreeTrial> freeTrials;

            public Loaded() {
                this(null, 1, null);
            }

            public /* synthetic */ Loaded(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : map);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.freeTrials;
                }
                return loaded.copy(map);
            }

            public final Map<Long, GuildRoleSubscriptionTierFreeTrial> component1() {
                return this.freeTrials;
            }

            public final Loaded copy(Map<Long, GuildRoleSubscriptionTierFreeTrial> freeTrials) {
                return new Loaded(freeTrials);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.freeTrials, ((Loaded) other).freeTrials);
                }
                return true;
            }

            public final Map<Long, GuildRoleSubscriptionTierFreeTrial> getFreeTrials() {
                return this.freeTrials;
            }

            public int hashCode() {
                Map<Long, GuildRoleSubscriptionTierFreeTrial> map = this.freeTrials;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.M(outline.U("Loaded(freeTrials="), this.freeTrials, ")");
            }

            public Loaded(Map<Long, GuildRoleSubscriptionTierFreeTrial> map) {
                super(null);
                this.freeTrials = map;
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loading;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends GuildRoleSubscriptionFreeTrialsState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Uninitialized;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends GuildRoleSubscriptionFreeTrialsState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private GuildRoleSubscriptionFreeTrialsState() {
        }

        public /* synthetic */ GuildRoleSubscriptionFreeTrialsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "", "<init>", "()V", "Failed", "Loaded", "Loading", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Failed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class GuildRoleSubscriptionGroupState {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Failed;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends GuildRoleSubscriptionGroupState {
            private final String errorMessage;

            public Failed() {
                this(null, 1, null);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "component1", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "guildRoleSubscriptionGroupListing", "copy", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;)Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "getGuildRoleSubscriptionGroupListing", "<init>", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends GuildRoleSubscriptionGroupState {
            private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

            public Loaded(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                super(null);
                this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildRoleSubscriptionGroupListing = loaded.guildRoleSubscriptionGroupListing;
                }
                return loaded.copy(guildRoleSubscriptionGroupListing);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            public final Loaded copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                return new Loaded(guildRoleSubscriptionGroupListing);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListing, ((Loaded) other).guildRoleSubscriptionGroupListing);
                }
                return true;
            }

            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            public int hashCode() {
                GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
                if (guildRoleSubscriptionGroupListing != null) {
                    return guildRoleSubscriptionGroupListing.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guildRoleSubscriptionGroupListing=");
                sbU.append(this.guildRoleSubscriptionGroupListing);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends GuildRoleSubscriptionGroupState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private GuildRoleSubscriptionGroupState() {
        }

        public /* synthetic */ GuildRoleSubscriptionGroupState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "", "<init>", "()V", "Failed", "Loaded", "Loading", "Uninitialized", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState$Uninitialized;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState$Loading;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState$Loaded;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState$Failed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class PriceTierState {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState$Failed;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends PriceTierState {
            private final String errorMessage;

            public Failed() {
                this(null, 1, null);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState$Loaded;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "", "", "component1", "()Ljava/util/List;", "priceTiers", "copy", "(Ljava/util/List;)Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState$Loaded;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPriceTiers", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends PriceTierState {
            private final List<Integer> priceTiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Integer> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "priceTiers");
                this.priceTiers = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.priceTiers;
                }
                return loaded.copy(list);
            }

            public final List<Integer> component1() {
                return this.priceTiers;
            }

            public final Loaded copy(List<Integer> priceTiers) {
                Intrinsics3.checkNotNullParameter(priceTiers, "priceTiers");
                return new Loaded(priceTiers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.priceTiers, ((Loaded) other).priceTiers);
                }
                return true;
            }

            public final List<Integer> getPriceTiers() {
                return this.priceTiers;
            }

            public int hashCode() {
                List<Integer> list = this.priceTiers;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(priceTiers="), this.priceTiers, ")");
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState$Loading;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends PriceTierState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState$Uninitialized;", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends PriceTierState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private PriceTierState() {
        }

        public /* synthetic */ PriceTierState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), GuildRoleSubscriptionGroupState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062:\u0010\u0005\u001a6\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002 \u0004*\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;
            public final /* synthetic */ List $guildRoleSubscriptionTrials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List list) {
                super(0);
                this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
                this.$guildRoleSubscriptionTrials = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionGroupFetch(StoreGuildRoleSubscriptions.this, anonymousClass2.$guildId, this.$guildRoleSubscriptionGroupListing);
                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionFreeTrialListFetch(StoreGuildRoleSubscriptions.this, anonymousClass22.$guildId, this.$guildRoleSubscriptionTrials);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            invoke2((Tuples2<GuildRoleSubscriptionGroupListing, ? extends List<GuildRoleSubscriptionTierFreeTrial>>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<GuildRoleSubscriptionGroupListing, ? extends List<GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(tuples2.component1(), tuples2.component2()));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map mapAccess$getGuildRoleSubscriptionGroups$p = StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this);
                Long lValueOf = Long.valueOf(AnonymousClass3.this.$guildId);
                Error.Response response = this.$error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                mapAccess$getGuildRoleSubscriptionGroups$p.put(lValueOf, new GuildRoleSubscriptionGroupState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), GuildRoleSubscriptionGroupState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062^\u0010\u0005\u001aZ\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001 \u0003*,\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/Pair;", "", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "kotlin.jvm.PlatformType", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierFreeTrial;", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $guildRoleSubscriptionFreeTrials;
            public final /* synthetic */ List $guildRoleSubscriptionGroupListings;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list, List list2) {
                super(0);
                this.$guildRoleSubscriptionGroupListings = list;
                this.$guildRoleSubscriptionFreeTrials = list2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = StoreGuildRoleSubscriptions.this;
                long j = anonymousClass2.$guildId;
                List list = this.$guildRoleSubscriptionGroupListings;
                Intrinsics3.checkNotNullExpressionValue(list, "guildRoleSubscriptionGroupListings");
                StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionGroupFetch(storeGuildRoleSubscriptions, j, (GuildRoleSubscriptionGroupListing) _Collections.getOrNull(list, 0));
                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                StoreGuildRoleSubscriptions.access$handleGuildRoleSubscriptionFreeTrialListFetch(StoreGuildRoleSubscriptions.this, anonymousClass22.$guildId, this.$guildRoleSubscriptionFreeTrials);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            invoke2((Tuples2<? extends List<GuildRoleSubscriptionGroupListing>, ? extends List<GuildRoleSubscriptionTierFreeTrial>>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends List<GuildRoleSubscriptionGroupListing>, ? extends List<GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(tuples2.component1(), tuples2.component2()));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$it = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map mapAccess$getGuildRoleSubscriptionGroups$p = StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this);
                Long lValueOf = Long.valueOf(AnonymousClass3.this.$guildId);
                Error.Response response = this.$it.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                mapAccess$getGuildRoleSubscriptionGroups$p.put(lValueOf, new GuildRoleSubscriptionGroupState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.access$setPriceTierState$p(StoreGuildRoleSubscriptions.this, PriceTierState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends Integer>, Unit> {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$it = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildRoleSubscriptions.access$setPriceTierState$p(StoreGuildRoleSubscriptions.this, new PriceTierState.Loaded(this.$it));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
            invoke2((List<Integer>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Integer> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {

        /* compiled from: StoreGuildRoleSubscriptions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$it = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = StoreGuildRoleSubscriptions.this;
                Error.Response response = this.$it.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                StoreGuildRoleSubscriptions.access$setPriceTierState$p(storeGuildRoleSubscriptions, new PriceTierState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        public AnonymousClass3() {
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
            StoreGuildRoleSubscriptions.access$getDispatcher$p(StoreGuildRoleSubscriptions.this).schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionFreeTrialListFetch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ List $guildRoleSubscriptionFreeTrialList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, long j) {
            super(0);
            this.$guildRoleSubscriptionFreeTrialList = list;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List list = this.$guildRoleSubscriptionFreeTrialList;
            if (list == null) {
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions.this).remove(Long.valueOf(this.$guildId));
                StoreGuildRoleSubscriptions.this.markChanged();
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(Long.valueOf(((GuildRoleSubscriptionTierFreeTrial) obj).getId()), obj);
            }
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), Maps6.toMutableMap(linkedHashMap));
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupFetch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, long j) {
            super(0);
            this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$guildRoleSubscriptionGroupListing == null) {
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(this.$guildRoleSubscriptionGroupListing));
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).remove(Long.valueOf(this.$guildId));
            } else {
                StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(GuildRoleSubscriptionGroupListing.a(this.$guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, null, false, Opcodes.ATHROW)));
                List<Long> listI = this.$guildRoleSubscriptionGroupListing.i();
                if (listI == null || listI.isEmpty()) {
                    StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).remove(Long.valueOf(this.$guildId));
                } else {
                    Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).get(Long.valueOf(this.$guildId));
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap();
                    }
                    List<GuildRoleSubscriptionTierListing> listH = this.$guildRoleSubscriptionGroupListing.h();
                    if (listH != null) {
                        for (GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing : listH) {
                            linkedHashMap.put(Long.valueOf(guildRoleSubscriptionTierListing.getId()), guildRoleSubscriptionTierListing);
                        }
                    }
                    StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), linkedHashMap);
                }
            }
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(this.$guildRoleSubscriptionGroupListing));
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingDelete$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $guildRoleSubscriptionTierListingId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListingId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).get(Long.valueOf(this.$guildId));
            if (map != null) {
                map.remove(Long.valueOf(this.$guildRoleSubscriptionTierListingId));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).get(Long.valueOf(this.$guildId));
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            linkedHashMap.put(Long.valueOf(this.$guildRoleSubscriptionTierListing.getId()), this.$guildRoleSubscriptionTierListing);
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), linkedHashMap);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* compiled from: StoreGuildRoleSubscriptions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierTrialUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $guildRoleSubscriptionGroupListingId;
        public final /* synthetic */ GuildRoleSubscriptionTierFreeTrial $guildRoleSubscriptionTierFreeTrial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, long j2) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierFreeTrial = guildRoleSubscriptionTierFreeTrial;
            this.$guildRoleSubscriptionGroupListingId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions.this).get(Long.valueOf(this.$guildId));
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            linkedHashMap.put(Long.valueOf(this.$guildRoleSubscriptionGroupListingId), this.$guildRoleSubscriptionTierFreeTrial);
            StoreGuildRoleSubscriptions.access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions.this).put(Long.valueOf(this.$guildId), linkedHashMap);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    public /* synthetic */ StoreGuildRoleSubscriptions(Dispatcher dispatcher, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.dispatcher;
    }

    public static final /* synthetic */ Map access$getGuildRoleSubscriptionFreeTrials$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.guildRoleSubscriptionFreeTrials;
    }

    public static final /* synthetic */ Map access$getGuildRoleSubscriptionGroups$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.guildRoleSubscriptionGroups;
    }

    public static final /* synthetic */ Map access$getGuildRoleSubscriptionTiers$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.guildRoleSubscriptionTiers;
    }

    public static final /* synthetic */ PriceTierState access$getPriceTierState$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return storeGuildRoleSubscriptions.priceTierState;
    }

    public static final /* synthetic */ void access$handleGuildRoleSubscriptionFreeTrialListFetch(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, List list) {
        storeGuildRoleSubscriptions.handleGuildRoleSubscriptionFreeTrialListFetch(j, list);
    }

    public static final /* synthetic */ void access$handleGuildRoleSubscriptionGroupFetch(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupFetch(j, guildRoleSubscriptionGroupListing);
    }

    public static final /* synthetic */ void access$setPriceTierState$p(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, PriceTierState priceTierState) {
        storeGuildRoleSubscriptions.priceTierState = priceTierState;
    }

    private final void handleGuildRoleSubscriptionFreeTrialListFetch(long guildId, List<GuildRoleSubscriptionTierFreeTrial> guildRoleSubscriptionFreeTrialList) {
        this.dispatcher.schedule(new AnonymousClass1(guildRoleSubscriptionFreeTrialList, guildId));
    }

    private final void handleGuildRoleSubscriptionGroupFetch(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        this.dispatcher.schedule(new AnonymousClass1(guildRoleSubscriptionGroupListing, guildId));
    }

    public final void fetchGuildRoleSubscriptionGroup(long guildId, long guildRoleSubscriptionGroupId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof GuildRoleSubscriptionGroupState.Loading) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId));
        Observable observableJ0 = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.j0(this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), StoreGuildRoleSubscriptions2.INSTANCE) : this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId).G(StoreGuildRoleSubscriptions3.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ0, "observable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableJ0, false, 1, null), StoreGuildRoleSubscriptions.class, (Context) null, (Function1) null, new AnonymousClass3(guildId), (Function0) null, (Function0) null, new AnonymousClass2(guildId), 54, (Object) null);
    }

    public final void fetchGuildRoleSubscriptionGroupsForGuild(long guildId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof GuildRoleSubscriptionGroupState.Loading) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId));
        Observable observableJ0 = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.j0(this.restAPI.getGuildRoleSubscriptionGroupListings(guildId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), StoreGuildRoleSubscriptions4.INSTANCE) : this.restAPI.getGuildRoleSubscriptionGroupListings(guildId).G(StoreGuildRoleSubscriptions5.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ0, "observable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableJ0, false, 1, null), StoreGuildRoleSubscriptions.class, (Context) null, (Function1) null, new AnonymousClass3(guildId), (Function0) null, (Function0) null, new AnonymousClass2(guildId), 54, (Object) null);
    }

    public final void fetchPriceTiersIfNonExisting() {
        PriceTierState priceTierState = this.priceTierState;
        if ((priceTierState instanceof PriceTierState.Loading) || (priceTierState instanceof PriceTierState.Loaded)) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getPriceTiers(PriceTierType.GUILD_ROLE_SUBSCRIPTIONS.getApiValue()), false, 1, null), StoreGuildRoleSubscriptions.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final List<Integer> getGuildRoleSubscriptionFreeTrialActiveUserLimitOptions() {
        return Collections2.listOf((Object[]) new Integer[]{null, 10, 25, 50, 100});
    }

    public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrialForListing(long guildId, long listingId) {
        Map<Long, GuildRoleSubscriptionTierFreeTrial> map = this.guildRoleSubscriptionFreeTrialsSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(Long.valueOf(listingId));
        }
        return null;
    }

    public final List<SubscriptionTrialInterval> getGuildRoleSubscriptionFreeTrialIntervalOptions() {
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = GuildRoleSubscriptionFreeTrialIntervalTypes.DAILY;
        return Collections2.listOf((Object[]) new SubscriptionTrialInterval[]{new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 1), new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 7)});
    }

    public final Map<Long, GuildRoleSubscriptionTierFreeTrial> getGuildRoleSubscriptionFreeTrials(long guildId) {
        return this.guildRoleSubscriptionFreeTrialsSnapshot.get(Long.valueOf(guildId));
    }

    public final GuildRoleSubscriptionGroupState getGuildRoleSubscriptionState(long guildId) {
        List listEmptyList;
        List<Long> listI;
        GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId));
        if (guildRoleSubscriptionGroupState == null) {
            return null;
        }
        if (!(guildRoleSubscriptionGroupState instanceof GuildRoleSubscriptionGroupState.Loaded)) {
            return guildRoleSubscriptionGroupState;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((GuildRoleSubscriptionGroupState.Loaded) guildRoleSubscriptionGroupState).getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null || (listI = guildRoleSubscriptionGroupListing.i()) == null) {
            listEmptyList = Collections2.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                Map<Long, GuildRoleSubscriptionTierListing> map = this.guildRoleSubscriptionTiersSnapshot.get(Long.valueOf(guildId));
                GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing = map != null ? map.get(Long.valueOf(jLongValue)) : null;
                if (guildRoleSubscriptionTierListing != null) {
                    arrayList.add(guildRoleSubscriptionTierListing);
                }
            }
            listEmptyList = arrayList;
        }
        return new GuildRoleSubscriptionGroupState.Loaded(guildRoleSubscriptionGroupListing != null ? GuildRoleSubscriptionGroupListing.a(guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, listEmptyList, false, Opcodes.ATHROW) : null);
    }

    /* renamed from: getPriceTiersState, reason: from getter */
    public final PriceTierState getPriceTierStateSnapshot() {
        return this.priceTierStateSnapshot;
    }

    public final void handleGuildRoleSubscriptionGroupUpdate(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
        this.dispatcher.schedule(new AnonymousClass1(guildId, guildRoleSubscriptionGroupListing));
    }

    public final void handleGuildRoleSubscriptionTierListingCreate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        handleGuildRoleSubscriptionTierListingUpdate(guildId, guildRoleSubscriptionTierListing);
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingDelete(long guildId, long guildRoleSubscriptionGroupListingId, long guildRoleSubscriptionTierListingId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, guildRoleSubscriptionTierListingId));
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingUpdate(long guildId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        this.dispatcher.schedule(new AnonymousClass1(guildId, guildRoleSubscriptionTierListing));
    }

    public final void handleGuildRoleSubscriptionTierTrialUpdate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierFreeTrial, "guildRoleSubscriptionTierFreeTrial");
        this.dispatcher.schedule(new AnonymousClass1(guildId, guildRoleSubscriptionTierFreeTrial, guildRoleSubscriptionGroupListingId));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.priceTierStateSnapshot = this.priceTierState;
        this.guildRoleSubscriptionGroupsSnapshot = new HashMap(this.guildRoleSubscriptionGroups);
        this.guildRoleSubscriptionTiersSnapshot = new HashMap(this.guildRoleSubscriptionTiers);
        this.guildRoleSubscriptionFreeTrialsSnapshot = new HashMap(this.guildRoleSubscriptionFreeTrials);
    }

    public StoreGuildRoleSubscriptions(Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        PriceTierState.Uninitialized uninitialized = PriceTierState.Uninitialized.INSTANCE;
        this.priceTierState = uninitialized;
        this.priceTierStateSnapshot = uninitialized;
        this.guildRoleSubscriptionGroups = new LinkedHashMap();
        this.guildRoleSubscriptionGroupsSnapshot = Maps6.emptyMap();
        this.guildRoleSubscriptionTiers = new LinkedHashMap();
        this.guildRoleSubscriptionTiersSnapshot = Maps6.emptyMap();
        this.guildRoleSubscriptionFreeTrials = new LinkedHashMap();
        this.guildRoleSubscriptionFreeTrialsSnapshot = Maps6.emptyMap();
    }
}
