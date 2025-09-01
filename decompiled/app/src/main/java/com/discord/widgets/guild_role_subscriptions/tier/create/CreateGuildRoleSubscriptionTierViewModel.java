package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
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

/* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00045678BS\u0012\n\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e\u0012\u0006\u0010!\u001a\u00020\u001d\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\b\b\u0002\u00101\u001a\u000200\u0012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0004\b3\u00104J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R:\u0010'\u001a&\u0012\f\u0012\n &*\u0004\u0018\u00010\b0\b &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010\b0\b\u0018\u00010%0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00069"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$ViewState;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$StoreState;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;", "event", "emitEvent", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;)V", "viewState", "", "computeCanProceedToNextStep", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$ViewState;)Z", "Lrx/Observable;", "observeEvents", "()Lrx/Observable;", "goToPreviousStep", "()V", "goToNextStep", "submit", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "guildRoleSubscriptionTier", "onTierUpdated", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;)V", "updateViewState", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$ViewState;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "groupListingId", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "isFullServerGating", "Ljava/lang/Boolean;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "storeStateObservable", "<init>", "(JJLcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreGuildRoleSubscriptions;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/updates/ObservationDeck;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CreateGuildRoleSubscriptionTierViewModel extends AppViewModel<ViewState> {
    private static final int CHANNEL_BENEFITS_STEP = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DESIGN_STEP = 3;
    private static final int DETAILS_STEP = 0;
    private static final int INTANGIBLE_BENEFITS_STEP = 2;
    private final PublishSubject<Event> eventSubject;
    private final long groupListingId;
    private final long guildId;
    private Boolean isFullServerGating;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel$1, reason: invalid class name */
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
            CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel = CreateGuildRoleSubscriptionTierViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            CreateGuildRoleSubscriptionTierViewModel.access$handleStoreState(createGuildRoleSubscriptionTierViewModel, storeState);
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lrx/Observable;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuildRoleSubscriptions;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "", "CHANNEL_BENEFITS_STEP", "I", "DESIGN_STEP", "DETAILS_STEP", "INTANGIBLE_BENEFITS_STEP", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
            return companion.observeStoreState(j, observationDeck, storeGuildRoleSubscriptions, storeGuilds);
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new CreateGuildRoleSubscriptionTierViewModel2(storeGuildRoleSubscriptions, guildId, storeGuilds), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;", "", "<init>", "()V", "ServerGatingUpdate", "SubmitFailure", "SubmitSuccess", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event$SubmitSuccess;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;", "", "component1", "()Z", "isFullServerGating", "copy", "(Z)Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ServerGatingUpdate extends Event {
            private final boolean isFullServerGating;

            public ServerGatingUpdate(boolean z2) {
                super(null);
                this.isFullServerGating = z2;
            }

            public static /* synthetic */ ServerGatingUpdate copy$default(ServerGatingUpdate serverGatingUpdate, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = serverGatingUpdate.isFullServerGating;
                }
                return serverGatingUpdate.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsFullServerGating() {
                return this.isFullServerGating;
            }

            public final ServerGatingUpdate copy(boolean isFullServerGating) {
                return new ServerGatingUpdate(isFullServerGating);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ServerGatingUpdate) && this.isFullServerGating == ((ServerGatingUpdate) other).isFullServerGating;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isFullServerGating;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isFullServerGating() {
                return this.isFullServerGating;
            }

            public String toString() {
                return outline.O(outline.U("ServerGatingUpdate(isFullServerGating="), this.isFullServerGating, ")");
            }
        }

        /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;", "Lcom/discord/utilities/error/Error;", "component1", "()Lcom/discord/utilities/error/Error;", "error", "copy", "(Lcom/discord/utilities/error/Error;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/error/Error;", "getError", "<init>", "(Lcom/discord/utilities/error/Error;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

        /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event$SubmitSuccess;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$StoreState;", "", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "component1", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "", "component2", "()Ljava/lang/Boolean;", "guildRoleSubscriptionGroupListing", "fullServerGatingOverwrite", "copy", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;Ljava/lang/Boolean;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getFullServerGatingOverwrite", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;", "getGuildRoleSubscriptionGroupListing", "<init>", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionGroupListing;Ljava/lang/Boolean;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Boolean fullServerGatingOverwrite;
        private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

        public StoreState() {
            this(null, null, 3, null);
        }

        public StoreState(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool) {
            this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            this.fullServerGatingOverwrite = bool;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionGroupListing = storeState.guildRoleSubscriptionGroupListing;
            }
            if ((i & 2) != 0) {
                bool = storeState.fullServerGatingOverwrite;
            }
            return storeState.copy(guildRoleSubscriptionGroupListing, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
            return this.guildRoleSubscriptionGroupListing;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getFullServerGatingOverwrite() {
            return this.fullServerGatingOverwrite;
        }

        public final StoreState copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean fullServerGatingOverwrite) {
            return new StoreState(guildRoleSubscriptionGroupListing, fullServerGatingOverwrite);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListing, storeState.guildRoleSubscriptionGroupListing) && Intrinsics3.areEqual(this.fullServerGatingOverwrite, storeState.fullServerGatingOverwrite);
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
            StringBuilder sbU = outline.U("StoreState(guildRoleSubscriptionGroupListing=");
            sbU.append(this.guildRoleSubscriptionGroupListing);
            sbU.append(", fullServerGatingOverwrite=");
            return outline.D(sbU, this.fullServerGatingOverwrite, ")");
        }

        public /* synthetic */ StoreState(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guildRoleSubscriptionGroupListing, (i & 2) != 0 ? null : bool);
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$ViewState;", "", "", "component1", "()I", "", "component2", "()Z", "component3", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "component4", "()Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "currentStep", "canProceed", "isSubmitting", "guildRoleSubscriptionTier", "copy", "(IZZLcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;)Lcom/discord/widgets/guild_role_subscriptions/tier/create/CreateGuildRoleSubscriptionTierViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanProceed", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;", "getGuildRoleSubscriptionTier", "I", "getCurrentStep", "<init>", "(IZZLcom/discord/widgets/guild_role_subscriptions/tier/model/GuildRoleSubscriptionTier;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean canProceed;
        private final int currentStep;
        private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
        private final boolean isSubmitting;

        public ViewState() {
            this(0, false, false, null, 15, null);
        }

        public ViewState(int i, boolean z2, boolean z3, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
            this.currentStep = i;
            this.canProceed = z2;
            this.isSubmitting = z3;
            this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, int i, boolean z2, boolean z3, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = viewState.currentStep;
            }
            if ((i2 & 2) != 0) {
                z2 = viewState.canProceed;
            }
            if ((i2 & 4) != 0) {
                z3 = viewState.isSubmitting;
            }
            if ((i2 & 8) != 0) {
                guildRoleSubscriptionTier = viewState.guildRoleSubscriptionTier;
            }
            return viewState.copy(i, z2, z3, guildRoleSubscriptionTier);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCurrentStep() {
            return this.currentStep;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanProceed() {
            return this.canProceed;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsSubmitting() {
            return this.isSubmitting;
        }

        /* renamed from: component4, reason: from getter */
        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        public final ViewState copy(int currentStep, boolean canProceed, boolean isSubmitting, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
            return new ViewState(currentStep, canProceed, isSubmitting, guildRoleSubscriptionTier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.currentStep == viewState.currentStep && this.canProceed == viewState.canProceed && this.isSubmitting == viewState.isSubmitting && Intrinsics3.areEqual(this.guildRoleSubscriptionTier, viewState.guildRoleSubscriptionTier);
        }

        public final boolean getCanProceed() {
            return this.canProceed;
        }

        public final int getCurrentStep() {
            return this.currentStep;
        }

        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = this.currentStep * 31;
            boolean z2 = this.canProceed;
            int i2 = z2;
            if (z2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.isSubmitting;
            int i4 = (i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
            return i4 + (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0);
        }

        public final boolean isSubmitting() {
            return this.isSubmitting;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(currentStep=");
            sbU.append(this.currentStep);
            sbU.append(", canProceed=");
            sbU.append(this.canProceed);
            sbU.append(", isSubmitting=");
            sbU.append(this.isSubmitting);
            sbU.append(", guildRoleSubscriptionTier=");
            sbU.append(this.guildRoleSubscriptionTier);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(int i, boolean z2, boolean z3, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? null : guildRoleSubscriptionTier);
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "it", "", "invoke", "(Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel$submit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierListing, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            invoke2(guildRoleSubscriptionTierListing);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
            CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel = CreateGuildRoleSubscriptionTierViewModel.this;
            createGuildRoleSubscriptionTierViewModel.updateViewState2(ViewState.copy$default(CreateGuildRoleSubscriptionTierViewModel.access$requireViewState(createGuildRoleSubscriptionTierViewModel), 0, false, false, null, 11, null));
            CreateGuildRoleSubscriptionTierViewModel.access$emitEvent(CreateGuildRoleSubscriptionTierViewModel.this, Event.SubmitSuccess.INSTANCE);
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel$submit$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(error, "error");
            CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel = CreateGuildRoleSubscriptionTierViewModel.this;
            createGuildRoleSubscriptionTierViewModel.updateViewState2(ViewState.copy$default(CreateGuildRoleSubscriptionTierViewModel.access$requireViewState(createGuildRoleSubscriptionTierViewModel), 0, false, false, null, 11, null));
            CreateGuildRoleSubscriptionTierViewModel.access$emitEvent(CreateGuildRoleSubscriptionTierViewModel.this, new Event.SubmitFailure(error));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CreateGuildRoleSubscriptionTierViewModel(long j, long j2, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 8) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        ObservationDeck observationDeck2 = (i & 32) != 0 ? ObservationDeck4.get() : observationDeck;
        this(j, j2, api, guildRoleSubscriptions, guilds, observationDeck2, (i & 64) != 0 ? Companion.access$observeStoreState(INSTANCE, j, observationDeck2, guildRoleSubscriptions, guilds) : observable);
    }

    public static final /* synthetic */ void access$emitEvent(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel, Event event) {
        createGuildRoleSubscriptionTierViewModel.emitEvent(event);
    }

    public static final /* synthetic */ void access$handleStoreState(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel, StoreState storeState) {
        createGuildRoleSubscriptionTierViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ ViewState access$requireViewState(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel) {
        return createGuildRoleSubscriptionTierViewModel.requireViewState();
    }

    private final boolean computeCanProceedToNextStep(ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        int currentStep = viewState.getCurrentStep();
        if (currentStep == 0) {
            String name = guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.getName() : null;
            if (name == null || StringsJVM.isBlank(name)) {
                return false;
            }
            if ((guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.getPriceTier() : null) == null) {
                return false;
            }
            String description = guildRoleSubscriptionTier.getDescription();
            if (description == null || StringsJVM.isBlank(description)) {
                return false;
            }
            String image = guildRoleSubscriptionTier.getImage();
            if (image == null || StringsJVM.isBlank(image)) {
                return false;
            }
        } else if (currentStep != 1 && currentStep != 2) {
            if (currentStep != 3) {
                return false;
            }
            if ((guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.getMemberColor() : null) == null) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final void handleStoreState(StoreState storeState) {
        if (storeState.getGuildRoleSubscriptionGroupListing() != null) {
            Boolean fullServerGatingOverwrite = storeState.getFullServerGatingOverwrite();
            boolean zBooleanValue = fullServerGatingOverwrite != null ? fullServerGatingOverwrite.booleanValue() : storeState.getGuildRoleSubscriptionGroupListing().getFullServerGate();
            this.isFullServerGating = Boolean.valueOf(zBooleanValue);
            emitEvent(new Event.ServerGatingUpdate(zBooleanValue));
        }
    }

    public final void goToNextStep() {
        ViewState viewStateRequireViewState = requireViewState();
        updateViewState2(ViewState.copy$default(viewStateRequireViewState, viewStateRequireViewState.getCurrentStep() + 1, false, false, null, 14, null));
    }

    public final void goToPreviousStep() {
        updateViewState2(ViewState.copy$default(requireViewState(), r1.getCurrentStep() - 1, false, false, null, 14, null));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onTierUpdated(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        updateViewState2(ViewState.copy$default(requireViewState(), 0, false, false, guildRoleSubscriptionTier, 7, null));
    }

    public final void submit() {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        if (guildRoleSubscriptionTier != null) {
            String name = guildRoleSubscriptionTier.getName();
            if ((name == null || StringsJVM.isBlank(name)) || guildRoleSubscriptionTier.getPriceTier() == null || guildRoleSubscriptionTier.getMemberColor() == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionTierListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, this.groupListingId, guildRoleSubscriptionTier.getName(), guildRoleSubscriptionTier.getDescription(), guildRoleSubscriptionTier.getPriceTier().intValue(), guildRoleSubscriptionTier.getImage(), ColorCompat.INSTANCE.removeAlphaComponent(guildRoleSubscriptionTier.getMemberColor().intValue()), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating), guildRoleSubscriptionTier.getChannelBenefits(), guildRoleSubscriptionTier.getIntangibleBenefits()), this, null, 2, null), CreateGuildRoleSubscriptionTierViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
        }
    }

    @Override // b.a.d.AppViewModel
    public /* bridge */ /* synthetic */ void updateViewState(ViewState viewState) {
        updateViewState2(viewState);
    }

    /* renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        super.updateViewState((CreateGuildRoleSubscriptionTierViewModel) ViewState.copy$default(viewState, 0, computeCanProceedToNextStep(viewState), false, null, 13, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGuildRoleSubscriptionTierViewModel(long j, long j2, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable<StoreState> observable) {
        super(new ViewState(0, false, false, null, 15, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.groupListingId = j2;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), CreateGuildRoleSubscriptionTierViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
