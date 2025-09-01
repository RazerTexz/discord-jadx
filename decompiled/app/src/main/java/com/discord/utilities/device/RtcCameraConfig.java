package com.discord.utilities.device;

import android.content.Context;
import androidx.annotation.AnyThread;
import co.discord.media_engine.CameraEnumeratorProvider;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: RtcCameraConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/device/RtcCameraConfig;", "", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lrx/Observable;", "Lcom/discord/models/experiments/domain/Experiment;", "observeExperiment", "(Lcom/discord/stores/StoreExperiments;)Lrx/Observable;", "", "init", "()V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RtcCameraConfig {
    public static final RtcCameraConfig INSTANCE = new RtcCameraConfig();
    private static final AtomicBoolean initialized = new AtomicBoolean();

    /* compiled from: RtcCameraConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/experiments/domain/Experiment;", "it", "", "invoke", "(Lcom/discord/models/experiments/domain/Experiment;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.device.RtcCameraConfig$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Experiment, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Experiment experiment) {
            invoke2(experiment);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Experiment experiment) {
            Intrinsics3.checkNotNullParameter(experiment, "it");
            CameraEnumeratorProvider.INSTANCE.init(ApplicationProvider.INSTANCE.get(), experiment.getBucket() == 1);
        }
    }

    private RtcCameraConfig() {
    }

    private final Observable<Experiment> observeExperiment(StoreExperiments storeExperiments) {
        Observable<R> observableG = storeExperiments.observeUserExperiment("2021-02_android_webrtc_camera2", true).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "storeExperiments.observe…Null()\n          .take(1)");
        return ObservableExtensionsKt.computationLatest(observableZ);
    }

    @AnyThread
    public final void init() {
        if (initialized.compareAndSet(false, true)) {
            ObservableExtensionsKt.appSubscribe$default(observeExperiment(StoreStream.INSTANCE.getExperiments()), RtcCameraConfig.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
        }
    }
}
