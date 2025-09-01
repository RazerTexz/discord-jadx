package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Transition.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a-\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a-\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a-\u0010\t\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006\u001a-\u0010\n\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a\u0085\u0001\u0010\u0010\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0006\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0006\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0006\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0006\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u0014\b\u0006\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Landroid/transition/Transition;", "Lkotlin/Function1;", "", "action", "Landroid/transition/Transition$TransitionListener;", "doOnEnd", "(Landroid/transition/Transition;Lkotlin/jvm/functions/Function1;)Landroid/transition/Transition$TransitionListener;", "doOnStart", "doOnCancel", "doOnResume", "doOnPause", "onEnd", "onStart", "onCancel", "onResume", "onPause", "addListener", "(Landroid/transition/Transition;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroid/transition/Transition$TransitionListener;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.transition.TransitionKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Transition2 {

    /* compiled from: Transition.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/transition/Transition;", "it", "", "<anonymous>", "(Landroid/transition/Transition;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/transition/Transition;", "it", "", "<anonymous>", "(Landroid/transition/Transition;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/transition/Transition;", "it", "", "<anonymous>", "(Landroid/transition/Transition;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/transition/Transition;", "it", "", "<anonymous>", "(Landroid/transition/Transition;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/transition/Transition;", "it", "", "<anonymous>", "(Landroid/transition/Transition;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.core.transition.TransitionKt$addListener$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition transition, Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12, Function1<? super Transition, Unit> function13, Function1<? super Transition, Unit> function14, Function1<? super Transition, Unit> function15) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "onEnd");
        Intrinsics3.checkNotNullParameter(function12, "onStart");
        Intrinsics3.checkNotNullParameter(function13, "onCancel");
        Intrinsics3.checkNotNullParameter(function14, "onResume");
        Intrinsics3.checkNotNullParameter(function15, "onPause");
        Transition8 transition8 = new Transition8(function1, function14, function15, function13, function12);
        transition.addListener(transition8);
        return transition8;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = AnonymousClass2.INSTANCE;
        }
        Function1 function16 = function12;
        if ((i & 4) != 0) {
            function13 = AnonymousClass3.INSTANCE;
        }
        Function1 function17 = function13;
        if ((i & 8) != 0) {
            function14 = AnonymousClass4.INSTANCE;
        }
        if ((i & 16) != 0) {
            function15 = AnonymousClass5.INSTANCE;
        }
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "onEnd");
        Intrinsics3.checkNotNullParameter(function16, "onStart");
        Intrinsics3.checkNotNullParameter(function17, "onCancel");
        Intrinsics3.checkNotNullParameter(function14, "onResume");
        Intrinsics3.checkNotNullParameter(function15, "onPause");
        Transition8 transition8 = new Transition8(function1, function14, function15, function17, function16);
        transition.addListener(transition8);
        return transition8;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition3 transition3 = new Transition3(function1);
        transition.addListener(transition3);
        return transition3;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition4 transition4 = new Transition4(function1);
        transition.addListener(transition4);
        return transition4;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition5 transition5 = new Transition5(function1);
        transition.addListener(transition5);
        return transition5;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition6 transition6 = new Transition6(function1);
        transition.addListener(transition6);
        return transition6;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition7 transition7 = new Transition7(function1);
        transition.addListener(transition7);
        return transition7;
    }
}
