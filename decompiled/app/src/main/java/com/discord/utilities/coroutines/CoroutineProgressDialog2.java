package com.discord.utilities.coroutines;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import b.a.i.ViewGenericLoadingBinding;
import b.i.a.f.e.o.f;
import com.discord.R;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineProgressDialog.kt */
@DebugMetadata(c = "com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1", f = "CoroutineProgressDialog.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Result", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/appcompat/app/AlertDialog;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class CoroutineProgressDialog2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super AlertDialog>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineContext $myCoroutineContext;
    public int label;

    /* compiled from: CoroutineProgressDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Result", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "it", "", "onCancel", "(Landroid/content/DialogInterface;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements DialogInterface.OnCancelListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            f.s(CoroutineProgressDialog2.this.$myCoroutineContext, null, 1, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineProgressDialog2(Context context, CoroutineContext coroutineContext, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$myCoroutineContext = coroutineContext;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new CoroutineProgressDialog2(this.$context, this.$myCoroutineContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AlertDialog> continuation) {
        return ((CoroutineProgressDialog2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        View viewInflate = LayoutInflater.from(this.$context).inflate(R.layout.view_generic_loading, (ViewGroup) null, false);
        Objects.requireNonNull(viewInflate, "rootView");
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        Intrinsics3.checkNotNullExpressionValue(new ViewGenericLoadingBinding(frameLayout), "ViewGenericLoadingBindin…utInflater.from(context))");
        return new AlertDialog.Builder(this.$context, 2131951632).setView(frameLayout).setCancelable(true).setOnCancelListener(new AnonymousClass1()).show();
    }
}
