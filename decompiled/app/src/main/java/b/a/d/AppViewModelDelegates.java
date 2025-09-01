package b.a.d;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import d0.z.d.Intrinsics3;

/* compiled from: AppViewModelDelegates.kt */
/* renamed from: b.a.d.e0, reason: use source file name */
/* loaded from: classes.dex */
public final class AppViewModelDelegates implements ViewModelProvider.Factory {
    public final /* synthetic */ AppViewModelDelegates2 a;

    public AppViewModelDelegates(AppViewModelDelegates2 appViewModelDelegates2) {
        this.a = appViewModelDelegates2;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics3.checkNotNullParameter(cls, "modelClass");
        return (T) this.a.$viewModelProducer.invoke();
    }
}
