package b.a.d;

import androidx.view.ViewModelProvider;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: AppViewModelDelegates.kt */
/* renamed from: b.a.d.f0, reason: use source file name */
/* loaded from: classes.dex */
public final class AppViewModelDelegates2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Function0 $viewModelProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppViewModelDelegates2(Function0 function0) {
        super(0);
        this.$viewModelProducer = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public ViewModelProvider.Factory invoke() {
        return new AppViewModelDelegates(this);
    }
}
