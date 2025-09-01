package com.discord.widgets.chat.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: TextInVoiceFeatureFlag.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/chat/list/TextInVoiceFeatureFlag;", "", "Lcom/discord/models/experiments/domain/Experiment;", "experiment", "Lcom/discord/models/guild/Guild;", "guild", "", "isEnabled", "(Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/guild/Guild;)Z", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "observeEnabled", "(Ljava/lang/Long;)Lrx/Observable;", "(Ljava/lang/Long;)Z", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreExperiments;", "<init>", "(Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuilds;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TextInVoiceFeatureFlag {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(TextInVoiceFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    /* compiled from: TextInVoiceFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/list/TextInVoiceFeatureFlag$Companion;", "", "Lcom/discord/widgets/chat/list/TextInVoiceFeatureFlag;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/widgets/chat/list/TextInVoiceFeatureFlag;", "INSTANCE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final TextInVoiceFeatureFlag getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = TextInVoiceFeatureFlag.access$getINSTANCE$cp();
            Companion companion = TextInVoiceFeatureFlag.INSTANCE;
            return (TextInVoiceFeatureFlag) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TextInVoiceFeatureFlag.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/experiments/domain/Experiment;", "guildExperiment", "Lcom/discord/models/guild/Guild;", "guild", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/experiments/domain/Experiment;Lcom/discord/models/guild/Guild;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.TextInVoiceFeatureFlag$observeEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Experiment, Guild, Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Experiment experiment, Guild guild) {
            return call2(experiment, guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Experiment experiment, Guild guild) {
            return Boolean.valueOf(TextInVoiceFeatureFlag.access$isEnabled(TextInVoiceFeatureFlag.this, experiment, guild));
        }
    }

    public TextInVoiceFeatureFlag() {
        this(null, null, 3, null);
    }

    public TextInVoiceFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ boolean access$isEnabled(TextInVoiceFeatureFlag textInVoiceFeatureFlag, Experiment experiment, Guild guild) {
        return textInVoiceFeatureFlag.isEnabled(experiment, guild);
    }

    public final boolean isEnabled(Long guildId) {
        if (guildId != null) {
            return isEnabled(this.storeExperiments.getGuildExperiment("2022-03_text_in_voice", guildId.longValue(), true), this.storeGuilds.getGuild(guildId.longValue()));
        }
        return false;
    }

    public final Observable<Boolean> observeEnabled(Long guildId) {
        if (guildId == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.FALSE);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(false)");
            return scalarSynchronousObservable;
        }
        Observable<Boolean> observableJ = Observable.j(this.storeExperiments.observeGuildExperiment("2022-03_text_in_voice", guildId.longValue(), true), this.storeGuilds.observeGuild(guildId.longValue()), new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…xperiment, guild)\n      }");
        return observableJ;
    }

    public /* synthetic */ TextInVoiceFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
    }

    private final boolean isEnabled(Experiment experiment, Guild guild) {
        return (experiment != null && experiment.getBucket() == 1) || (guild != null && guild.hasFeature(GuildFeature.TEXT_IN_VOICE_ENABLED));
    }
}
