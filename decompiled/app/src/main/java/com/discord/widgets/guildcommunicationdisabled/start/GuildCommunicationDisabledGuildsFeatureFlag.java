package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/GuildCommunicationDisabledGuildsFeatureFlag;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "canGuildAccessCommunicationDisabled", "(J)Z", "canUserAccessDisableCommunication", "()Z", "Lrx/Observable;", "observeCanGuildAccessCommunicationDisabled", "(J)Lrx/Observable;", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreExperiments;", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildCommunicationDisabledGuildsFeatureFlag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(GuildCommunicationDisabledGuildsFeatureFlag2.INSTANCE);
    private final StoreGuilds guildsStore;
    private final ObservationDeck observationDeck;
    private final StoreExperiments storeExperiments;

    /* compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/GuildCommunicationDisabledGuildsFeatureFlag$Companion;", "", "Lcom/discord/widgets/guildcommunicationdisabled/start/GuildCommunicationDisabledGuildsFeatureFlag;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/widgets/guildcommunicationdisabled/start/GuildCommunicationDisabledGuildsFeatureFlag;", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final GuildCommunicationDisabledGuildsFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = GuildCommunicationDisabledGuildsFeatureFlag.access$getINSTANCE$cp();
            Companion companion = GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE;
            return (GuildCommunicationDisabledGuildsFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag$observeCanGuildAccessCommunicationDisabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildCommunicationDisabledGuildsFeatureFlag.this.canGuildAccessCommunicationDisabled(this.$guildId) && GuildCommunicationDisabledGuildsFeatureFlag.this.canUserAccessDisableCommunication();
        }
    }

    public GuildCommunicationDisabledGuildsFeatureFlag() {
        this(null, null, null, 7, null);
    }

    public GuildCommunicationDisabledGuildsFeatureFlag(StoreGuilds storeGuilds, StoreExperiments storeExperiments, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.guildsStore = storeGuilds;
        this.storeExperiments = storeExperiments;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean canGuildAccessCommunicationDisabled(long guildId) {
        Experiment guildExperiment;
        return (this.guildsStore.getGuild(guildId) == null || (guildExperiment = this.storeExperiments.getGuildExperiment("2021-11_guild_communication_disabled_guilds", guildId, true)) == null || guildExperiment.getBucket() != 1) ? false : true;
    }

    public final boolean canUserAccessDisableCommunication() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-11_guild_communication_disabled_users", true);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public final Observable<Boolean> observeCanGuildAccessCommunicationDisabled(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.guildsStore, this.storeExperiments}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ GuildCommunicationDisabledGuildsFeatureFlag(StoreGuilds storeGuilds, StoreExperiments storeExperiments, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 2) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}
