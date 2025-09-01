package com.discord.utilities.coroutines;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import b.i.a.f.e.o.f;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import s.a.Dispatchers;
import s.a.MainCoroutineDispatcher;
import s.a.NonCancellable;
import s.a.a.MainDispatchers;

/* compiled from: CoroutineProgressDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/discord/utilities/coroutines/CoroutineProgressDialog;", "", "Result", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "fn", "withCancellableProgressDialog", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CoroutineProgressDialog {
    public static final CoroutineProgressDialog INSTANCE = new CoroutineProgressDialog();

    /* compiled from: CoroutineProgressDialog.kt */
    @DebugMetadata(c = "com.discord.utilities.coroutines.CoroutineProgressDialog", f = "CoroutineProgressDialog.kt", l = {22, 32, 34, 34}, m = "withCancellableProgressDialog")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\b\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Result", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "fn", "continuation", "withCancellableProgressDialog", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineProgressDialog.this.withCancellableProgressDialog(null, null, this);
        }
    }

    /* compiled from: CoroutineProgressDialog.kt */
    @DebugMetadata(c = "com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$2", f = "CoroutineProgressDialog.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Result", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Ref$ObjectRef $dialog;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
            super(2, continuation);
            this.$dialog = ref$ObjectRef;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass2(this.$dialog, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            ((AlertDialog) this.$dialog.element).dismiss();
            return Unit.a;
        }
    }

    private CoroutineProgressDialog() {
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r14v5, types: [T, androidx.appcompat.app.AlertDialog] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <Result> Object withCancellableProgressDialog(Context context, Function1<? super Continuation<? super Result>, ? extends Object> function1, Continuation<? super Result> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRef;
        Function1<? super Continuation<? super Result>, ? extends Object> function12;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        CoroutineContext coroutineContextPlus;
        AnonymousClass2 anonymousClass2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objC1 = anonymousClass1.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        try {
            if (i2 == 0) {
                Result3.throwOnFailure(objC1);
                CoroutineContext context2 = anonymousClass1.getContext();
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                MainCoroutineDispatcher mainCoroutineDispatcherH = MainDispatchers.f3830b.H();
                CoroutineProgressDialog2 coroutineProgressDialog2 = new CoroutineProgressDialog2(context, context2, null);
                anonymousClass1.L$0 = function1;
                anonymousClass1.L$1 = ref$ObjectRef4;
                anonymousClass1.L$2 = ref$ObjectRef4;
                anonymousClass1.label = 1;
                objC1 = f.C1(mainCoroutineDispatcherH, coroutineProgressDialog2, anonymousClass1);
                if (objC1 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ref$ObjectRef = ref$ObjectRef4;
                function12 = function1;
                ref$ObjectRef2 = ref$ObjectRef;
            } else if (i2 == 1) {
                ref$ObjectRef = (Ref$ObjectRef) anonymousClass1.L$2;
                ref$ObjectRef2 = (Ref$ObjectRef) anonymousClass1.L$1;
                function12 = (Function1) anonymousClass1.L$0;
                Result3.throwOnFailure(objC1);
            } else {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Object obj = anonymousClass1.L$0;
                        Result3.throwOnFailure(objC1);
                        return obj;
                    }
                    if (i2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) anonymousClass1.L$0;
                    Result3.throwOnFailure(objC1);
                    throw th;
                }
                ref$ObjectRef3 = (Ref$ObjectRef) anonymousClass1.L$0;
                try {
                    Result3.throwOnFailure(objC1);
                    CoroutineDispatcher coroutineDispatcher2 = Dispatchers.a;
                    CoroutineContext coroutineContextPlus2 = MainDispatchers.f3830b.H().plus(NonCancellable.j);
                    AnonymousClass2 anonymousClass22 = new AnonymousClass2(ref$ObjectRef3, null);
                    anonymousClass1.L$0 = objC1;
                    anonymousClass1.label = 3;
                    return f.C1(coroutineContextPlus2, anonymousClass22, anonymousClass1) != coroutine_suspended ? coroutine_suspended : objC1;
                } catch (Throwable th2) {
                    ref$ObjectRef2 = ref$ObjectRef3;
                    th = th2;
                    CoroutineDispatcher coroutineDispatcher3 = Dispatchers.a;
                    coroutineContextPlus = MainDispatchers.f3830b.H().plus(NonCancellable.j);
                    anonymousClass2 = new AnonymousClass2(ref$ObjectRef2, null);
                    anonymousClass1.L$0 = th;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.label = 4;
                    if (f.C1(coroutineContextPlus, anonymousClass2, anonymousClass1) != coroutine_suspended) {
                    }
                }
            }
            anonymousClass1.L$0 = ref$ObjectRef2;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 2;
            objC1 = function12.invoke(anonymousClass1);
            if (objC1 == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$ObjectRef3 = ref$ObjectRef2;
            CoroutineDispatcher coroutineDispatcher22 = Dispatchers.a;
            CoroutineContext coroutineContextPlus22 = MainDispatchers.f3830b.H().plus(NonCancellable.j);
            AnonymousClass2 anonymousClass222 = new AnonymousClass2(ref$ObjectRef3, null);
            anonymousClass1.L$0 = objC1;
            anonymousClass1.label = 3;
            if (f.C1(coroutineContextPlus22, anonymousClass222, anonymousClass1) != coroutine_suspended) {
            }
        } catch (Throwable th3) {
            th = th3;
            CoroutineDispatcher coroutineDispatcher32 = Dispatchers.a;
            coroutineContextPlus = MainDispatchers.f3830b.H().plus(NonCancellable.j);
            anonymousClass2 = new AnonymousClass2(ref$ObjectRef2, null);
            anonymousClass1.L$0 = th;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 4;
            if (f.C1(coroutineContextPlus, anonymousClass2, anonymousClass1) != coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th;
        }
        ref$ObjectRef.element = (AlertDialog) objC1;
    }
}
