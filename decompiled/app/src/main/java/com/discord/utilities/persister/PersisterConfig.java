package com.discord.utilities.persister;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppLog2;
import b.a.d.AppState;
import b.a.d.AppState2;
import b.a.e.Backgrounded4;
import com.discord.app.AppLog;
import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.kryo.LeastRecentlyAddedSetSerializer;
import com.discord.utilities.kryo.SnowflakePartitionMapSerializer;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import h0.b.b.StdInstantiatorStrategy;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: PersisterConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR:\u0010\f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010\t0\t8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/persister/PersisterConfig;", "", "Landroid/content/Context;", "context", "Lcom/discord/utilities/time/Clock;", "clock", "", "init", "(Landroid/content/Context;Lcom/discord/utilities/time/Clock;)V", "Lrx/Observable;", "", "kotlin.jvm.PlatformType", "isNotActive", "()Lrx/Observable;", "getPersistenceStrategy", "persistenceStrategy", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PersisterConfig {
    public static final PersisterConfig INSTANCE = new PersisterConfig();

    /* compiled from: PersisterConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/esotericsoftware/kryo/Kryo;", "it", "", "invoke", "(Lcom/esotericsoftware/kryo/Kryo;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.persister.PersisterConfig$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Kryo, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Kryo kryo) {
            invoke2(kryo);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Kryo kryo) {
            Intrinsics3.checkNotNullParameter(kryo, "it");
            kryo.setInstantiatorStrategy(new Kryo.DefaultInstantiatorStrategy(new StdInstantiatorStrategy()));
            FieldSerializerConfig fieldSerializerConfig = kryo.getFieldSerializerConfig();
            Intrinsics3.checkNotNullExpressionValue(fieldSerializerConfig, "it.fieldSerializerConfig");
            fieldSerializerConfig.setOptimizedGenerics(true);
            kryo.register(LeastRecentlyAddedSet.class, new LeastRecentlyAddedSetSerializer());
            kryo.register(SnowflakePartitionMap.class, new SnowflakePartitionMapSerializer());
        }
    }

    /* compiled from: PersisterConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isBackgrounded", "isServiceRunning", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.persister.PersisterConfig$isNotActive$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
            return call2(bool, bool2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Boolean bool, Boolean bool2) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isBackgrounded");
            return Boolean.valueOf(bool.booleanValue() && !bool2.booleanValue());
        }
    }

    private PersisterConfig() {
    }

    private final Observable<Boolean> getPersistenceStrategy() {
        Observable<Boolean> observableI = Observable.I(isNotActive(), Observable.d0(1L, TimeUnit.MINUTES).G(PersisterConfig2.INSTANCE));
        Intrinsics3.checkNotNullExpressionValue(observableI, "Observable\n        .merg…  .map { true }\n        )");
        return observableI;
    }

    private final Observable<Boolean> isNotActive() {
        Observable<Boolean> observableS = Backgrounded4.d.a().S(1);
        AppState2 appState2 = AppState2.c;
        Observable observableR = AppState2.f59b.G(AppState.j).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "numGatewayConnectionCons…  .distinctUntilChanged()");
        return Observable.j(observableS, observableR, AnonymousClass1.INSTANCE).r();
    }

    public final void init(Context context, Clock clock) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Persister.Companion companion = Persister.INSTANCE;
        companion.setKryoConfig(AnonymousClass1.INSTANCE);
        Objects.requireNonNull(AppLog.g);
        Intrinsics3.checkNotNullParameter("[Persister]", "tag");
        companion.setLogger(new AppLog2("[Persister]"));
        companion.init(context, clock, getPersistenceStrategy());
    }
}
