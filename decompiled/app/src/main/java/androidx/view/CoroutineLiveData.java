package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.Result3;
import d0.w.CoroutineContextImpl4;
import d0.w.h.Intrinsics2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import s.a.Dispatchers;
import s.a.Job2;
import s.a.Supervisor;
import s.a.a.MainDispatchers;

/* compiled from: CoroutineLiveData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BH\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012(\u0010\u001e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001aø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J!\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/LiveData;", "source", "Ls/a/m0;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSource", "onActive", "()V", "onInactive", "Landroidx/lifecycle/EmittedSource;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "Landroidx/lifecycle/BlockRunner;", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeoutInMs", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "block", "<init>", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private CoroutineLiveData2<T> blockRunner;
    private CoroutineLiveData6 emittedSource;

    /* compiled from: CoroutineLiveData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: androidx.lifecycle.CoroutineLiveData$1, reason: invalid class name */
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
            CoroutineLiveData.access$setBlockRunner$p(CoroutineLiveData.this, null);
        }
    }

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CoroutineContextImpl4.j : coroutineContext, (i & 2) != 0 ? 5000L : j, function2);
    }

    public static final /* synthetic */ CoroutineLiveData2 access$getBlockRunner$p(CoroutineLiveData coroutineLiveData) {
        return coroutineLiveData.blockRunner;
    }

    public static final /* synthetic */ void access$setBlockRunner$p(CoroutineLiveData coroutineLiveData, CoroutineLiveData2 coroutineLiveData2) {
        coroutineLiveData.blockRunner = coroutineLiveData2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> continuation) {
        CoroutineLiveData3 coroutineLiveData3;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData3) {
            coroutineLiveData3 = (CoroutineLiveData3) continuation;
            int i = coroutineLiveData3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData3.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData3 = new CoroutineLiveData3(this, continuation);
            }
        }
        Object obj = coroutineLiveData3.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = coroutineLiveData3.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj);
            CoroutineLiveData6 coroutineLiveData6 = this.emittedSource;
            if (coroutineLiveData6 != null) {
                coroutineLiveData3.L$0 = this;
                coroutineLiveData3.label = 1;
                if (coroutineLiveData6.disposeNow(coroutineLiveData3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            coroutineLiveData = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineLiveData = (CoroutineLiveData) coroutineLiveData3.L$0;
            Result3.throwOnFailure(obj);
        }
        coroutineLiveData.emittedSource = null;
        return Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, Continuation<? super Job2> continuation) {
        CoroutineLiveData4 coroutineLiveData4;
        LiveData<T> liveData2;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData4) {
            coroutineLiveData4 = (CoroutineLiveData4) continuation;
            int i = coroutineLiveData4.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData4.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData4 = new CoroutineLiveData4(this, continuation);
            }
        }
        Object objAddDisposableSource = coroutineLiveData4.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = coroutineLiveData4.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objAddDisposableSource);
            coroutineLiveData4.L$0 = this;
            coroutineLiveData4.L$1 = liveData;
            coroutineLiveData4.label = 1;
            if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData4) == coroutine_suspended) {
                return coroutine_suspended;
            }
            liveData2 = liveData;
            coroutineLiveData = this;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineLiveData = (CoroutineLiveData) coroutineLiveData4.L$0;
                Result3.throwOnFailure(objAddDisposableSource);
                CoroutineLiveData6 coroutineLiveData6 = (CoroutineLiveData6) objAddDisposableSource;
                coroutineLiveData.emittedSource = coroutineLiveData6;
                return coroutineLiveData6;
            }
            LiveData<T> liveData3 = (LiveData) coroutineLiveData4.L$1;
            CoroutineLiveData<T> coroutineLiveData2 = (CoroutineLiveData) coroutineLiveData4.L$0;
            Result3.throwOnFailure(objAddDisposableSource);
            liveData2 = liveData3;
            coroutineLiveData = coroutineLiveData2;
        }
        coroutineLiveData4.L$0 = coroutineLiveData;
        coroutineLiveData4.L$1 = null;
        coroutineLiveData4.label = 2;
        objAddDisposableSource = CoroutineLiveData5.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData4);
        if (objAddDisposableSource == coroutine_suspended) {
            return coroutine_suspended;
        }
        CoroutineLiveData6 coroutineLiveData62 = (CoroutineLiveData6) objAddDisposableSource;
        coroutineLiveData.emittedSource = coroutineLiveData62;
        return coroutineLiveData62;
    }

    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public void onActive() {
        super.onActive();
        CoroutineLiveData2<T> coroutineLiveData2 = this.blockRunner;
        if (coroutineLiveData2 != null) {
            coroutineLiveData2.maybeRun();
        }
    }

    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public void onInactive() {
        super.onInactive();
        CoroutineLiveData2<T> coroutineLiveData2 = this.blockRunner;
        if (coroutineLiveData2 != null) {
            coroutineLiveData2.cancel();
        }
    }

    public CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2<? super CoroutineLiveData7<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(function2, "block");
        Supervisor supervisor = new Supervisor((Job) coroutineContext.get(Job.INSTANCE));
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        this.blockRunner = new CoroutineLiveData2<>(this, function2, j, f.c(MainDispatchers.f3830b.H().plus(coroutineContext).plus(supervisor)), new AnonymousClass1());
    }
}
