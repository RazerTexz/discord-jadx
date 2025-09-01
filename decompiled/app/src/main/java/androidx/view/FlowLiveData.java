package androidx.view;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.Result3;
import d0.w.CoroutineContextImpl4;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.MainCoroutineDispatcher;
import s.a.a.MainDispatchers;
import s.a.c2.Channel4;
import s.a.c2.Channel5;
import s.a.d2.Builders3;
import s.a.d2.Flow3;
import s.a.d2.FlowCollector;

/* compiled from: FlowLiveData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ls/a/d2/d;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeoutInMs", "Landroidx/lifecycle/LiveData;", "asLiveData", "(Ls/a/d2/d;Lkotlin/coroutines/CoroutineContext;J)Landroidx/lifecycle/LiveData;", "asFlow", "(Landroidx/lifecycle/LiveData;)Ls/a/d2/d;", "Ljava/time/Duration;", "timeout", "(Ls/a/d2/d;Lkotlin/coroutines/CoroutineContext;Ljava/time/Duration;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: androidx.lifecycle.FlowLiveDataConversions, reason: use source file name */
/* loaded from: classes.dex */
public final class FlowLiveData {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowLiveData.kt */
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {96, 100, 101}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ls/a/d2/e;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl6 implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ LiveData $this_asFlow;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* compiled from: FlowLiveData.kt */
        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00021 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Observer $observer;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00021(Observer observer, Continuation continuation) {
                super(2, continuation);
                this.$observer = observer;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return new C00021(this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00021) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Intrinsics2.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                AnonymousClass1.this.$this_asFlow.observeForever(this.$observer);
                return Unit.a;
            }
        }

        /* compiled from: FlowLiveData.kt */
        @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Observer $observer;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Observer observer, Continuation continuation) {
                super(2, continuation);
                this.$observer = observer;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return new AnonymousClass2(this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Intrinsics2.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                AnonymousClass1.this.$this_asFlow.removeObserver(this.$observer);
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0097 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a5 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:29:0x009d, B:31:0x00a5), top: B:45:0x009d }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v22 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4, types: [androidx.lifecycle.Observer] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object, s.a.d2.e] */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b8 -> B:47:0x0089). Please report as a decompilation issue!!! */
        @Override // d0.w.i.a.ContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Observer flowLiveData2;
            Channel4 channel4;
            Throwable th;
            AnonymousClass1<T> anonymousClass1;
            ?? r7;
            Observer observer;
            Channel5 channel5;
            Channel5 it;
            Object objA;
            Observer observer2;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            ?? r4 = 1;
            try {
                try {
                    if (i == 0) {
                        Result3.throwOnFailure(obj);
                        flowCollector = (FlowCollector) this.L$0;
                        Channel4 channel4B = f.b(-1, null, null, 6);
                        flowLiveData2 = new FlowLiveData2(channel4B);
                        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                        MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
                        C00021 c00021 = new C00021(flowLiveData2, null);
                        this.L$0 = flowCollector;
                        this.L$1 = channel4B;
                        this.L$2 = flowLiveData2;
                        this.label = 1;
                        if (f.C1(mainCoroutineDispatcherH, c00021, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channel4 = channel4B;
                    } else if (i != 1) {
                        try {
                            if (i == 2) {
                                Channel5 channel52 = (Channel5) this.L$2;
                                Observer observer3 = (Observer) this.L$1;
                                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                                Result3.throwOnFailure(obj);
                                r7 = flowCollector2;
                                observer = observer3;
                                channel5 = channel52;
                                anonymousClass1 = this;
                                if (((Boolean) obj).booleanValue()) {
                                }
                            } else {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                Channel5 channel53 = (Channel5) this.L$2;
                                Observer observer4 = (Observer) this.L$1;
                                flowCollector = (FlowCollector) this.L$0;
                                Result3.throwOnFailure(obj);
                                it = channel53;
                                observer2 = observer4;
                                anonymousClass1 = this;
                                r4 = observer2;
                                anonymousClass1.L$0 = flowCollector;
                                anonymousClass1.L$1 = r4;
                                anonymousClass1.L$2 = it;
                                anonymousClass1.label = 2;
                                objA = it.a(anonymousClass1);
                                if (objA == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Observer observer5 = r4;
                                channel5 = it;
                                obj = objA;
                                r7 = flowCollector;
                                observer = observer5;
                                try {
                                    if (((Boolean) obj).booleanValue()) {
                                        CoroutineScope2 coroutineScope2 = CoroutineScope2.j;
                                        CoroutineDispatcher coroutineDispatcher2 = Dispatchers.a;
                                        f.H0(coroutineScope2, MainDispatchers.f3830b.H(), null, anonymousClass1.new AnonymousClass2(observer, null), 2, null);
                                        return Unit.a;
                                    }
                                    Object next = channel5.next();
                                    anonymousClass1.L$0 = r7;
                                    anonymousClass1.L$1 = observer;
                                    anonymousClass1.L$2 = channel5;
                                    anonymousClass1.label = 3;
                                    if (r7.emit(next, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    it = channel5;
                                    r4 = observer;
                                    flowCollector = r7;
                                    anonymousClass1.L$0 = flowCollector;
                                    anonymousClass1.L$1 = r4;
                                    anonymousClass1.L$2 = it;
                                    anonymousClass1.label = 2;
                                    objA = it.a(anonymousClass1);
                                    if (objA == coroutine_suspended) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    r4 = observer;
                                    CoroutineScope2 coroutineScope22 = CoroutineScope2.j;
                                    CoroutineDispatcher coroutineDispatcher3 = Dispatchers.a;
                                    f.H0(coroutineScope22, MainDispatchers.f3830b.H(), null, anonymousClass1.new AnonymousClass2(r4, null), 2, null);
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            anonymousClass1 = this;
                            CoroutineScope2 coroutineScope222 = CoroutineScope2.j;
                            CoroutineDispatcher coroutineDispatcher32 = Dispatchers.a;
                            f.H0(coroutineScope222, MainDispatchers.f3830b.H(), null, anonymousClass1.new AnonymousClass2(r4, null), 2, null);
                            throw th;
                        }
                    } else {
                        flowLiveData2 = (Observer) this.L$2;
                        channel4 = (Channel4) this.L$1;
                        flowCollector = (FlowCollector) this.L$0;
                        Result3.throwOnFailure(obj);
                    }
                    anonymousClass1.L$0 = flowCollector;
                    anonymousClass1.L$1 = r4;
                    anonymousClass1.L$2 = it;
                    anonymousClass1.label = 2;
                    objA = it.a(anonymousClass1);
                    if (objA == coroutine_suspended) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    CoroutineScope2 coroutineScope2222 = CoroutineScope2.j;
                    CoroutineDispatcher coroutineDispatcher322 = Dispatchers.a;
                    f.H0(coroutineScope2222, MainDispatchers.f3830b.H(), null, anonymousClass1.new AnonymousClass2(r4, null), 2, null);
                    throw th;
                }
                it = channel4.iterator();
                observer2 = flowLiveData2;
                anonymousClass1 = this;
                r4 = observer2;
            } catch (Throwable th5) {
                th = th5;
                r4 = flowLiveData2;
                anonymousClass1 = this;
                CoroutineScope2 coroutineScope22222 = CoroutineScope2.j;
                CoroutineDispatcher coroutineDispatcher3222 = Dispatchers.a;
                f.H0(coroutineScope22222, MainDispatchers.f3830b.H(), null, anonymousClass1.new AnonymousClass2(r4, null), 2, null);
                throw th;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowLiveData.kt */
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {Opcodes.FCMPL}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveDataScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl6 implements Function2<CoroutineLiveData7<T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Flow3 $this_asLiveData;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Flow3 flow3, Continuation continuation) {
            super(2, continuation);
            this.$this_asLiveData = flow3;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asLiveData, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(obj, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CoroutineLiveData7 coroutineLiveData7 = (CoroutineLiveData7) this.L$0;
                Flow3 flow3 = this.$this_asLiveData;
                Collect collect = new Collect(coroutineLiveData7);
                this.label = 1;
                if (flow3.a(collect, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    public static final <T> Flow3<T> asFlow(LiveData<T> liveData) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$asFlow");
        return new Builders3(new AnonymousClass1(liveData, null));
    }

    public static final <T> LiveData<T> asLiveData(Flow3<? extends T> flow3) {
        return asLiveData$default(flow3, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow3<? extends T> flow3, CoroutineContext coroutineContext) {
        return asLiveData$default(flow3, coroutineContext, 0L, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow3<? extends T> flow3, CoroutineContext coroutineContext, long j) {
        Intrinsics3.checkNotNullParameter(flow3, "$this$asLiveData");
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        return CoroutineLiveData5.liveData(coroutineContext, j, new AnonymousClass1(flow3, null));
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow3 flow3, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextImpl4.j;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(flow3, coroutineContext, j);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(Flow3<? extends T> flow3, CoroutineContext coroutineContext, Duration duration) {
        Intrinsics3.checkNotNullParameter(flow3, "$this$asLiveData");
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(duration, "timeout");
        return asLiveData(flow3, coroutineContext, duration.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow3 flow3, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextImpl4.j;
        }
        return asLiveData(flow3, coroutineContext, duration);
    }
}
