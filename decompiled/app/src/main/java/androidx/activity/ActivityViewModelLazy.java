package androidx.activity;

import androidx.annotation.MainThread;
import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelProvider2;
import androidx.view.ViewModelStore;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ActivityViewModelLazy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/activity/ComponentActivity;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lkotlin/Lazy;", "viewModels", "(Landroidx/activity/ComponentActivity;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: androidx.activity.ActivityViewModelLazyKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ActivityViewModelLazy {

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelStore;", "invoke", "()Landroidx/lifecycle/ViewModelStore;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: androidx.activity.ActivityViewModelLazyKt$viewModels$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            Intrinsics3.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            return viewModelStore;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ViewModelStore invoke() {
            return invoke();
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(ComponentActivity componentActivity, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics3.checkNotNullParameter(componentActivity, "$this$viewModels");
        if (function0 == null) {
            function0 = new ActivityViewModelLazy2(componentActivity);
        }
        Intrinsics3.reifiedOperationMarker(4, "VM");
        return new ViewModelProvider2(Reflection2.getOrCreateKotlinClass(ViewModel.class), new AnonymousClass1(componentActivity), function0);
    }

    public static /* synthetic */ Lazy viewModels$default(ComponentActivity componentActivity, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics3.checkNotNullParameter(componentActivity, "$this$viewModels");
        if (function0 == null) {
            function0 = new ActivityViewModelLazy2(componentActivity);
        }
        Intrinsics3.reifiedOperationMarker(4, "VM");
        return new ViewModelProvider2(Reflection2.getOrCreateKotlinClass(ViewModel.class), new AnonymousClass1(componentActivity), function0);
    }
}
