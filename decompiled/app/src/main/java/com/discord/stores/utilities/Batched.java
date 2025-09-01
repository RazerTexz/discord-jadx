package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.app.AppLog;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: Batched.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 **\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001*B5\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010$\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\fR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010RJ\u0010\u0014\u001a6\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0013*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00040\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0013*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00040\u00040\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0010R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/discord/stores/utilities/Batched;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lrx/Observable;", "", "observe", "()Lrx/Observable;", "", "flush", "()V", "value", "onNextAny", "(Ljava/lang/Object;)V", "onNext", "", "debounceDelayMs", "J", "queueStartTime", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "subject", "Lrx/subjects/SerializedSubject;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lkotlinx/coroutines/Job;", "debounceJob", "Lkotlinx/coroutines/Job;", "maxDebounceDelayMs", "", "queue", "Ljava/util/List;", "<init>", "(Ljava/lang/String;JJLkotlinx/coroutines/CoroutineScope;Lcom/discord/utilities/time/Clock;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class Batched<T> {
    public static final long DEFAULT_DEBOUNCE_DELAY_MS = 100;
    public static final long DEFAULT_MAX_DEBOUNCE_DELAY_MS = 300;
    private static final long QUEUE_NOT_STARTED = -1;
    private final Clock clock;
    private final long debounceDelayMs;
    private Job debounceJob;
    private final long maxDebounceDelayMs;
    private List<T> queue;
    private long queueStartTime;
    private final CoroutineScope scope;
    private final SerializedSubject<List<T>, List<T>> subject;
    private final String type;

    /* compiled from: Batched.kt */
    @DebugMetadata(c = "com.discord.stores.utilities.Batched$onNext$1", f = "Batched.kt", l = {82}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.utilities.Batched$onNext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                long jAccess$getDebounceDelayMs$p = Batched.access$getDebounceDelayMs$p(Batched.this);
                this.label = 1;
                if (f.P(jAccess$getDebounceDelayMs$p, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            Batched.this.flush();
            return Unit.a;
        }
    }

    public Batched(String str, long j, long j2, CoroutineScope coroutineScope, Clock clock) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.type = str;
        this.debounceDelayMs = j;
        this.maxDebounceDelayMs = j2;
        this.scope = coroutineScope;
        this.clock = clock;
        this.subject = new SerializedSubject<>(BehaviorSubject.k0());
        this.queue = new ArrayList();
        this.queueStartTime = -1L;
    }

    public static final /* synthetic */ long access$getDebounceDelayMs$p(Batched batched) {
        return batched.debounceDelayMs;
    }

    public final synchronized void flush() {
        Job job = this.debounceJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        this.debounceJob = null;
        this.queueStartTime = -1L;
        List<T> list = this.queue;
        this.queue = new ArrayList();
        this.subject.k.onNext(list);
    }

    public final String getType() {
        return this.type;
    }

    public final Observable<List<T>> observe() {
        return this.subject;
    }

    public final synchronized void onNext(T value) {
        if (value == null) {
            AppLog.i("onNext received a NULL value for Batched[" + this.type + ']');
        }
        this.queue.add(value);
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        if (this.queueStartTime == -1) {
            this.queueStartTime = jCurrentTimeMillis;
        }
        if (jCurrentTimeMillis - this.queueStartTime >= this.maxDebounceDelayMs) {
            flush();
        } else {
            Job job = this.debounceJob;
            if (job != null) {
                f.t(job, null, 1, null);
            }
            this.debounceJob = f.H0(this.scope, null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNextAny(Object value) {
        Intrinsics3.checkNotNullParameter(value, "value");
        onNext(value);
    }

    public /* synthetic */ Batched(String str, long j, long j2, CoroutineScope coroutineScope, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 100L : j, (i & 4) != 0 ? 300L : j2, coroutineScope, (i & 16) != 0 ? ClockFactory.get() : clock);
    }
}
