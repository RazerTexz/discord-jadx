package com.discord.widgets.chat.list;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: CreateThreadsFeatureFlag.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/chat/list/CreateThreadsFeatureFlag;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "", "observeEnabled", "(J)Lrx/Observable;", "isEnabled", "(J)Z", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreExperiments;", "<init>", "(Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuilds;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CreateThreadsFeatureFlag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(CreateThreadsFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    /* compiled from: CreateThreadsFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u00020\n8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/list/CreateThreadsFeatureFlag$Companion;", "", "Lcom/discord/models/experiments/domain/Experiment;", "createExperiment", "rolloutExperiment", "Lcom/discord/models/guild/Guild;", "guild", "", "computeIsEnabled", "(Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/guild/Guild;)Z", "Lcom/discord/widgets/chat/list/CreateThreadsFeatureFlag;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/widgets/chat/list/CreateThreadsFeatureFlag;", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final boolean computeIsEnabled(Experiment createExperiment, Experiment rolloutExperiment, Guild guild) {
            if (guild == null) {
                return false;
            }
            if (guild.hasFeature(GuildFeature.THREADS_ENABLED)) {
                return true;
            }
            return ((rolloutExperiment != null && rolloutExperiment.getBucket() == 2) || !guild.hasFeature(GuildFeature.COMMUNITY)) && createExperiment != null && createExperiment.getBucket() == 1;
        }

        public final CreateThreadsFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = CreateThreadsFeatureFlag.access$getINSTANCE$cp();
            Companion companion = CreateThreadsFeatureFlag.INSTANCE;
            return (CreateThreadsFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CreateThreadsFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/experiments/domain/Experiment;", "p1", "p2", "Lcom/discord/models/guild/Guild;", "p3", "", "invoke", "(Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/guild/Guild;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.CreateThreadsFeatureFlag$observeEnabled$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Experiment, Experiment, Guild, Boolean> {
        public AnonymousClass1(Companion companion) {
            super(3, companion, Companion.class, "computeIsEnabled", "computeIsEnabled(Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/guild/Guild;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(Experiment experiment, Experiment experiment2, Guild guild) {
            return Boolean.valueOf(invoke2(experiment, experiment2, guild));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Experiment experiment, Experiment experiment2, Guild guild) {
            return ((Companion) this.receiver).computeIsEnabled(experiment, experiment2, guild);
        }
    }

    public CreateThreadsFeatureFlag() {
        this(null, null, 3, null);
    }

    public CreateThreadsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final boolean isEnabled(long guildId) {
        return INSTANCE.computeIsEnabled(this.storeExperiments.getGuildExperiment("2020-09_threads", guildId, true), this.storeExperiments.getGuildExperiment("2021-06_threads_rollout", guildId, false), this.storeGuilds.getGuild(guildId));
    }

    public final Observable<Boolean> observeEnabled(long guildId) {
        Observable<Boolean> observableI = Observable.i(this.storeExperiments.observeGuildExperiment("2020-09_threads", guildId, true), this.storeExperiments.observeGuildExperiment("2021-06_threads_rollout", guildId, false), this.storeGuilds.observeGuild(guildId), new CreateThreadsFeatureFlag3(new AnonymousClass1(INSTANCE)));
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest… ::computeIsEnabled\n    )");
        return observableI;
    }

    public /* synthetic */ CreateThreadsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
    }
}
