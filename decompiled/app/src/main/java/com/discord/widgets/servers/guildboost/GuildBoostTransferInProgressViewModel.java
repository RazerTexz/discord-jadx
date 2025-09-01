package com.discord.widgets.servers.guildboost;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* compiled from: GuildBoostTransferInProgressViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002-.B[\u0012\n\u0010'\u001a\u00060\u000ej\u0002`&\u0012\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f\u0012\n\u0010\u0018\u001a\u00060\u000ej\u0002`\u0017\u0012\n\u0010$\u001a\u00060\u000ej\u0002`\u0017\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030)¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\tR\u001d\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u00060\u000ej\u0002`\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010 \u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010$\u001a\u00060\u000ej\u0002`\u00178\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u001d\u0010'\u001a\u00060\u000ej\u0002`&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013¨\u0006/"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$StoreState;)V", "handleGuildBoostingStarted", "()V", "handleGuildBoostingCompleted", "handleGuildBoostingError", "onCleared", "transferGuildBoost", "", "Lcom/discord/primitives/AppliedGuildBoostId;", "boostId", "J", "getBoostId", "()J", "Lrx/Subscription;", "guildBoostingSubscription", "Lrx/Subscription;", "Lcom/discord/primitives/GuildId;", "previousGuildId", "getPreviousGuildId", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "getRestAPI", "()Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreGuildBoost;", "storeGuildBoost", "Lcom/discord/stores/StoreGuildBoost;", "getStoreGuildBoost", "()Lcom/discord/stores/StoreGuildBoost;", "targetGuildId", "getTargetGuildId", "Lcom/discord/primitives/GuildBoostSlotId;", "slotId", "getSlotId", "Lrx/Observable;", "storeObservable", "<init>", "(JJJJLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildBoost;Lrx/Observable;)V", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildBoostTransferInProgressViewModel extends AppViewModel<ViewState> {
    private final long boostId;
    private Subscription guildBoostingSubscription;
    private final long previousGuildId;
    private final RestAPI restAPI;
    private final long slotId;
    private final StoreGuildBoost storeGuildBoost;
    private final long targetGuildId;

    /* compiled from: GuildBoostTransferInProgressViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/models/guild/Guild;", "previousGuild", "targetGuild", "Lcom/discord/stores/StoreGuildBoost$State;", "kotlin.jvm.PlatformType", "guildBoostState", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildBoost$State;)Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Guild, Guild, StoreGuildBoost.State, StoreState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ StoreState call(Guild guild, Guild guild2, StoreGuildBoost.State state) {
            return call2(guild, guild2, state);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreState call2(Guild guild, Guild guild2, StoreGuildBoost.State state) {
            Intrinsics3.checkNotNullExpressionValue(state, "guildBoostState");
            return new StoreState(guild, guild2, state);
        }
    }

    /* compiled from: GuildBoostTransferInProgressViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GuildBoostTransferInProgressViewModel.access$handleStoreState(GuildBoostTransferInProgressViewModel.this, storeState);
        }
    }

    /* compiled from: GuildBoostTransferInProgressViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$StoreState;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "component2", "Lcom/discord/stores/StoreGuildBoost$State;", "component3", "()Lcom/discord/stores/StoreGuildBoost$State;", "previousGuild", "targetGuild", "guildBoostState", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildBoost$State;)Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreGuildBoost$State;", "getGuildBoostState", "Lcom/discord/models/guild/Guild;", "getTargetGuild", "getPreviousGuild", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildBoost$State;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final StoreGuildBoost.State guildBoostState;
        private final Guild previousGuild;
        private final Guild targetGuild;

        public StoreState(Guild guild, Guild guild2, StoreGuildBoost.State state) {
            Intrinsics3.checkNotNullParameter(state, "guildBoostState");
            this.previousGuild = guild;
            this.targetGuild = guild2;
            this.guildBoostState = state;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, Guild guild2, StoreGuildBoost.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.previousGuild;
            }
            if ((i & 2) != 0) {
                guild2 = storeState.targetGuild;
            }
            if ((i & 4) != 0) {
                state = storeState.guildBoostState;
            }
            return storeState.copy(guild, guild2, state);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getPreviousGuild() {
            return this.previousGuild;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getTargetGuild() {
            return this.targetGuild;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final StoreState copy(Guild previousGuild, Guild targetGuild, StoreGuildBoost.State guildBoostState) {
            Intrinsics3.checkNotNullParameter(guildBoostState, "guildBoostState");
            return new StoreState(previousGuild, targetGuild, guildBoostState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.previousGuild, storeState.previousGuild) && Intrinsics3.areEqual(this.targetGuild, storeState.targetGuild) && Intrinsics3.areEqual(this.guildBoostState, storeState.guildBoostState);
        }

        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final Guild getPreviousGuild() {
            return this.previousGuild;
        }

        public final Guild getTargetGuild() {
            return this.targetGuild;
        }

        public int hashCode() {
            Guild guild = this.previousGuild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Guild guild2 = this.targetGuild;
            int iHashCode2 = (iHashCode + (guild2 != null ? guild2.hashCode() : 0)) * 31;
            StoreGuildBoost.State state = this.guildBoostState;
            return iHashCode2 + (state != null ? state.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(previousGuild=");
            sbU.append(this.previousGuild);
            sbU.append(", targetGuild=");
            sbU.append(this.targetGuild);
            sbU.append(", guildBoostState=");
            sbU.append(this.guildBoostState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GuildBoostTransferInProgressViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;", "", "<init>", "()V", "ErrorLoading", "ErrorTransfer", "Loading", "PostTransfer", "PreTransfer", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$ErrorTransfer;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$ErrorLoading;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$PreTransfer;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$PostTransfer;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: GuildBoostTransferInProgressViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$ErrorLoading;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ErrorLoading extends ViewState {
            public static final ErrorLoading INSTANCE = new ErrorLoading();

            private ErrorLoading() {
                super(null);
            }
        }

        /* compiled from: GuildBoostTransferInProgressViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$ErrorTransfer;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ErrorTransfer extends ViewState {
            public static final ErrorTransfer INSTANCE = new ErrorTransfer();

            private ErrorTransfer() {
                super(null);
            }
        }

        /* compiled from: GuildBoostTransferInProgressViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: GuildBoostTransferInProgressViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$PostTransfer;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "component2", "()I", "targetGuild", "targetGuildSubscriptionCount", "copy", "(Lcom/discord/models/guild/Guild;I)Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$PostTransfer;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTargetGuildSubscriptionCount", "Lcom/discord/models/guild/Guild;", "getTargetGuild", "<init>", "(Lcom/discord/models/guild/Guild;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class PostTransfer extends ViewState {
            private final Guild targetGuild;
            private final int targetGuildSubscriptionCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PostTransfer(Guild guild, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "targetGuild");
                this.targetGuild = guild;
                this.targetGuildSubscriptionCount = i;
            }

            public static /* synthetic */ PostTransfer copy$default(PostTransfer postTransfer, Guild guild, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    guild = postTransfer.targetGuild;
                }
                if ((i2 & 2) != 0) {
                    i = postTransfer.targetGuildSubscriptionCount;
                }
                return postTransfer.copy(guild, i);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getTargetGuild() {
                return this.targetGuild;
            }

            /* renamed from: component2, reason: from getter */
            public final int getTargetGuildSubscriptionCount() {
                return this.targetGuildSubscriptionCount;
            }

            public final PostTransfer copy(Guild targetGuild, int targetGuildSubscriptionCount) {
                Intrinsics3.checkNotNullParameter(targetGuild, "targetGuild");
                return new PostTransfer(targetGuild, targetGuildSubscriptionCount);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PostTransfer)) {
                    return false;
                }
                PostTransfer postTransfer = (PostTransfer) other;
                return Intrinsics3.areEqual(this.targetGuild, postTransfer.targetGuild) && this.targetGuildSubscriptionCount == postTransfer.targetGuildSubscriptionCount;
            }

            public final Guild getTargetGuild() {
                return this.targetGuild;
            }

            public final int getTargetGuildSubscriptionCount() {
                return this.targetGuildSubscriptionCount;
            }

            public int hashCode() {
                Guild guild = this.targetGuild;
                return ((guild != null ? guild.hashCode() : 0) * 31) + this.targetGuildSubscriptionCount;
            }

            public String toString() {
                StringBuilder sbU = outline.U("PostTransfer(targetGuild=");
                sbU.append(this.targetGuild);
                sbU.append(", targetGuildSubscriptionCount=");
                return outline.B(sbU, this.targetGuildSubscriptionCount, ")");
            }
        }

        /* compiled from: GuildBoostTransferInProgressViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\bJ\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$PreTransfer;", "Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "component2", "", "component3", "()I", "", "component4", "()Z", "previousGuild", "targetGuild", "targetGuildSubscriptionCount", "isTransferInProgress", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/Guild;IZ)Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState$PreTransfer;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getTargetGuildSubscriptionCount", "Z", "Lcom/discord/models/guild/Guild;", "getPreviousGuild", "getTargetGuild", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/models/guild/Guild;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class PreTransfer extends ViewState {
            private final boolean isTransferInProgress;
            private final Guild previousGuild;
            private final Guild targetGuild;
            private final int targetGuildSubscriptionCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PreTransfer(Guild guild, Guild guild2, int i, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "previousGuild");
                Intrinsics3.checkNotNullParameter(guild2, "targetGuild");
                this.previousGuild = guild;
                this.targetGuild = guild2;
                this.targetGuildSubscriptionCount = i;
                this.isTransferInProgress = z2;
            }

            public static /* synthetic */ PreTransfer copy$default(PreTransfer preTransfer, Guild guild, Guild guild2, int i, boolean z2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    guild = preTransfer.previousGuild;
                }
                if ((i2 & 2) != 0) {
                    guild2 = preTransfer.targetGuild;
                }
                if ((i2 & 4) != 0) {
                    i = preTransfer.targetGuildSubscriptionCount;
                }
                if ((i2 & 8) != 0) {
                    z2 = preTransfer.isTransferInProgress;
                }
                return preTransfer.copy(guild, guild2, i, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getPreviousGuild() {
                return this.previousGuild;
            }

            /* renamed from: component2, reason: from getter */
            public final Guild getTargetGuild() {
                return this.targetGuild;
            }

            /* renamed from: component3, reason: from getter */
            public final int getTargetGuildSubscriptionCount() {
                return this.targetGuildSubscriptionCount;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsTransferInProgress() {
                return this.isTransferInProgress;
            }

            public final PreTransfer copy(Guild previousGuild, Guild targetGuild, int targetGuildSubscriptionCount, boolean isTransferInProgress) {
                Intrinsics3.checkNotNullParameter(previousGuild, "previousGuild");
                Intrinsics3.checkNotNullParameter(targetGuild, "targetGuild");
                return new PreTransfer(previousGuild, targetGuild, targetGuildSubscriptionCount, isTransferInProgress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PreTransfer)) {
                    return false;
                }
                PreTransfer preTransfer = (PreTransfer) other;
                return Intrinsics3.areEqual(this.previousGuild, preTransfer.previousGuild) && Intrinsics3.areEqual(this.targetGuild, preTransfer.targetGuild) && this.targetGuildSubscriptionCount == preTransfer.targetGuildSubscriptionCount && this.isTransferInProgress == preTransfer.isTransferInProgress;
            }

            public final Guild getPreviousGuild() {
                return this.previousGuild;
            }

            public final Guild getTargetGuild() {
                return this.targetGuild;
            }

            public final int getTargetGuildSubscriptionCount() {
                return this.targetGuildSubscriptionCount;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.previousGuild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                Guild guild2 = this.targetGuild;
                int iHashCode2 = (((iHashCode + (guild2 != null ? guild2.hashCode() : 0)) * 31) + this.targetGuildSubscriptionCount) * 31;
                boolean z2 = this.isTransferInProgress;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode2 + i;
            }

            public final boolean isTransferInProgress() {
                return this.isTransferInProgress;
            }

            public String toString() {
                StringBuilder sbU = outline.U("PreTransfer(previousGuild=");
                sbU.append(this.previousGuild);
                sbU.append(", targetGuild=");
                sbU.append(this.targetGuild);
                sbU.append(", targetGuildSubscriptionCount=");
                sbU.append(this.targetGuildSubscriptionCount);
                sbU.append(", isTransferInProgress=");
                return outline.O(sbU, this.isTransferInProgress, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildBoostTransferInProgressViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003 \u0005* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljava/lang/Void;", "it", "Lrx/Observable;", "", "Lcom/discord/models/domain/ModelAppliedGuildBoost;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Void;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$transferGuildBoost$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Void, Observable<? extends List<? extends ModelAppliedGuildBoost>>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends List<? extends ModelAppliedGuildBoost>> call(Void r1) {
            return call2(r1);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends List<ModelAppliedGuildBoost>> call2(Void r6) {
            return GuildBoostTransferInProgressViewModel.this.getRestAPI().subscribeToGuild(GuildBoostTransferInProgressViewModel.this.getTargetGuildId(), new RestAPIParams.GuildBoosting(CollectionsJVM.listOf(Long.valueOf(GuildBoostTransferInProgressViewModel.this.getSlotId()))));
        }
    }

    /* compiled from: GuildBoostTransferInProgressViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$transferGuildBoost$2, reason: invalid class name */
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
            GuildBoostTransferInProgressViewModel.access$handleGuildBoostingError(GuildBoostTransferInProgressViewModel.this);
        }
    }

    /* compiled from: GuildBoostTransferInProgressViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/models/domain/ModelAppliedGuildBoost;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel$transferGuildBoost$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends ModelAppliedGuildBoost>, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelAppliedGuildBoost> list) {
            invoke2((List<ModelAppliedGuildBoost>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelAppliedGuildBoost> list) {
            GuildBoostTransferInProgressViewModel.access$handleGuildBoostingCompleted(GuildBoostTransferInProgressViewModel.this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildBoostTransferInProgressViewModel(long j, long j2, long j3, long j4, RestAPI restAPI, StoreGuildBoost storeGuildBoost, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observable2;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuildBoost guildBoosts = (i & 32) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : storeGuildBoost;
        if ((i & 64) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableI = Observable.i(companion.getGuilds().observeGuild(j3), companion.getGuilds().observeGuild(j4), StoreGuildBoost.observeGuildBoostState$default(companion.getGuildBoosts(), null, 1, null), AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…guildBoostState\n    )\n  }");
            observable2 = observableI;
        } else {
            observable2 = observable;
        }
        this(j, j2, j3, j4, api, guildBoosts, observable2);
    }

    public static final /* synthetic */ void access$handleGuildBoostingCompleted(GuildBoostTransferInProgressViewModel guildBoostTransferInProgressViewModel) {
        guildBoostTransferInProgressViewModel.handleGuildBoostingCompleted();
    }

    public static final /* synthetic */ void access$handleGuildBoostingError(GuildBoostTransferInProgressViewModel guildBoostTransferInProgressViewModel) {
        guildBoostTransferInProgressViewModel.handleGuildBoostingError();
    }

    public static final /* synthetic */ void access$handleStoreState(GuildBoostTransferInProgressViewModel guildBoostTransferInProgressViewModel, StoreState storeState) {
        guildBoostTransferInProgressViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleGuildBoostingCompleted() {
        this.storeGuildBoost.fetchUserGuildBoostState();
        ViewState viewStateRequireViewState = requireViewState();
        if (viewStateRequireViewState instanceof ViewState.PreTransfer) {
            ViewState.PreTransfer preTransfer = (ViewState.PreTransfer) viewStateRequireViewState;
            viewStateRequireViewState = new ViewState.PostTransfer(preTransfer.getTargetGuild(), preTransfer.getTargetGuildSubscriptionCount());
        }
        updateViewState(viewStateRequireViewState);
    }

    @MainThread
    private final void handleGuildBoostingError() {
        updateViewState(ViewState.ErrorTransfer.INSTANCE);
    }

    @MainThread
    private final void handleGuildBoostingStarted() {
        Object objCopy$default = (ViewState) requireViewState();
        if (objCopy$default instanceof ViewState.PreTransfer) {
            objCopy$default = ViewState.PreTransfer.copy$default((ViewState.PreTransfer) objCopy$default, null, null, 0, true, 7, null);
        }
        updateViewState(objCopy$default);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        int size;
        if (storeState.getPreviousGuild() == null || storeState.getTargetGuild() == null) {
            updateViewState(ViewState.ErrorLoading.INSTANCE);
            return;
        }
        if (storeState.getGuildBoostState() instanceof StoreGuildBoost.State.Loaded) {
            Collection<ModelGuildBoostSlot> collectionValues = ((StoreGuildBoost.State.Loaded) storeState.getGuildBoostState()).getBoostSlotMap().values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                ModelAppliedGuildBoost premiumGuildSubscription = ((ModelGuildBoostSlot) obj).getPremiumGuildSubscription();
                if (premiumGuildSubscription != null && premiumGuildSubscription.getGuildId() == this.targetGuildId) {
                    arrayList.add(obj);
                }
            }
            size = arrayList.size();
        } else {
            size = 0;
        }
        updateViewState(new ViewState.PreTransfer(storeState.getPreviousGuild(), storeState.getTargetGuild(), size, false));
    }

    public final long getBoostId() {
        return this.boostId;
    }

    public final long getPreviousGuildId() {
        return this.previousGuildId;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final long getSlotId() {
        return this.slotId;
    }

    public final StoreGuildBoost getStoreGuildBoost() {
        return this.storeGuildBoost;
    }

    public final long getTargetGuildId() {
        return this.targetGuildId;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        Subscription subscription = this.guildBoostingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        super.onCleared();
    }

    @MainThread
    public final void transferGuildBoost() {
        handleGuildBoostingStarted();
        Observable<R> observableA = this.restAPI.unsubscribeToGuild(this.previousGuildId, this.boostId).A(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableA, "restAPI\n        .unsubsc…              )\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null), this, null, 2, null), GuildBoostTransferInProgressViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass3(), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostTransferInProgressViewModel(long j, long j2, long j3, long j4, RestAPI restAPI, StoreGuildBoost storeGuildBoost, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.slotId = j;
        this.boostId = j2;
        this.previousGuildId = j3;
        this.targetGuildId = j4;
        this.restAPI = restAPI;
        this.storeGuildBoost = storeGuildBoost;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GuildBoostTransferInProgressViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
