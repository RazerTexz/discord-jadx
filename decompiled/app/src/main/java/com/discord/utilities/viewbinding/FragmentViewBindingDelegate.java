package com.discord.utilities.viewbinding;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import y.c.DefaultLifecycleObserver2;

/* compiled from: FragmentViewBindingDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003B7\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR%\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00028\u00000\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u0017\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "Landroidx/viewbinding/ViewBinding;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/fragment/app/Fragment;", "", "addOnDestroyObserver", "()V", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Landroidx/viewbinding/ViewBinding;", "binding", "Landroidx/viewbinding/ViewBinding;", "Lkotlin/Function1;", "onViewBindingDestroy", "Lkotlin/jvm/functions/Function1;", "getOnViewBindingDestroy", "()Lkotlin/jvm/functions/Function1;", "Landroid/view/View;", "viewBindingFactory", "getViewBindingFactory", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FragmentViewBindingDelegate<T extends ViewBinding> {
    private T binding;
    private final Fragment fragment;
    private final Function1<T, Unit> onViewBindingDestroy;
    private final Function1<View, T> viewBindingFactory;

    /* compiled from: FragmentViewBindingDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/utilities/viewbinding/FragmentViewBindingDelegate$addOnDestroyObserver$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegate$addOnDestroyObserver$1, reason: invalid class name */
    public static final class AnonymousClass1 implements DefaultLifecycleObserver {
        public AnonymousClass1() {
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public void onCreate(LifecycleOwner owner) {
            Intrinsics3.checkNotNullParameter(owner, "owner");
            FragmentViewBindingDelegate.this.getFragment().getViewLifecycleOwnerLiveData().observe(FragmentViewBindingDelegate.this.getFragment(), new FragmentViewBindingDelegate2(this));
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.b(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.c(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.d(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.e(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.f(this, lifecycleOwner);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewBindingDelegate(Fragment fragment, Function1<? super View, ? extends T> function1, Function1<? super T, Unit> function12) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(function1, "viewBindingFactory");
        Intrinsics3.checkNotNullParameter(function12, "onViewBindingDestroy");
        this.fragment = fragment;
        this.viewBindingFactory = function1;
        this.onViewBindingDestroy = function12;
        addOnDestroyObserver();
    }

    public static final /* synthetic */ ViewBinding access$getBinding$p(FragmentViewBindingDelegate fragmentViewBindingDelegate) {
        return fragmentViewBindingDelegate.binding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void access$setBinding$p(FragmentViewBindingDelegate fragmentViewBindingDelegate, ViewBinding viewBinding) {
        fragmentViewBindingDelegate.binding = viewBinding;
    }

    private final void addOnDestroyObserver() {
        this.fragment.getLifecycle().addObserver(new AnonymousClass1());
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final Function1<T, Unit> getOnViewBindingDestroy() {
        return this.onViewBindingDestroy;
    }

    public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
        return getValue((Fragment) obj, (KProperty<?>) kProperty);
    }

    public final Function1<View, T> getViewBindingFactory() {
        return this.viewBindingFactory;
    }

    public T getValue(Fragment thisRef, KProperty<?> property) {
        Intrinsics3.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics3.checkNotNullParameter(property, "property");
        T t = this.binding;
        if (t != null) {
            return t;
        }
        LifecycleOwner viewLifecycleOwner = this.fragment.getViewLifecycleOwner();
        Intrinsics3.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "fragment.viewLifecycleOwner.lifecycle");
        if (!lifecycle.getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw new IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.");
        }
        Function1<View, T> function1 = this.viewBindingFactory;
        View viewRequireView = thisRef.requireView();
        Intrinsics3.checkNotNullExpressionValue(viewRequireView, "thisRef.requireView()");
        T tInvoke = function1.invoke(viewRequireView);
        this.binding = tInvoke;
        return tInvoke;
    }
}
