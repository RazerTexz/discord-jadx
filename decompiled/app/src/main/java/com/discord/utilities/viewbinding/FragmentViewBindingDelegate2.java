package com.discord.utilities.viewbinding;

import androidx.exifinterface.media.ExifInterface;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import y.c.DefaultLifecycleObserver2;

/* compiled from: FragmentViewBindingDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/viewbinding/ViewBinding;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleOwner;", "kotlin.jvm.PlatformType", "viewLifecycleOwner", "", "onChanged", "(Landroidx/lifecycle/LifecycleOwner;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class FragmentViewBindingDelegate2<T> implements Observer<LifecycleOwner> {
    public final /* synthetic */ FragmentViewBindingDelegate.AnonymousClass1 this$0;

    /* compiled from: FragmentViewBindingDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/utilities/viewbinding/FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "onDestroy", "(Landroidx/lifecycle/LifecycleOwner;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements DefaultLifecycleObserver {
        public AnonymousClass1() {
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.a(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public void onDestroy(LifecycleOwner owner) {
            Intrinsics3.checkNotNullParameter(owner, "owner");
            ViewBinding viewBindingAccess$getBinding$p = FragmentViewBindingDelegate.access$getBinding$p(FragmentViewBindingDelegate.this);
            if (viewBindingAccess$getBinding$p != null) {
                FragmentViewBindingDelegate.this.getOnViewBindingDestroy().invoke(viewBindingAccess$getBinding$p);
            }
            FragmentViewBindingDelegate.access$setBinding$p(FragmentViewBindingDelegate.this, null);
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

    public FragmentViewBindingDelegate2(FragmentViewBindingDelegate.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
    }

    @Override // androidx.view.Observer
    public /* bridge */ /* synthetic */ void onChanged(LifecycleOwner lifecycleOwner) {
        onChanged2(lifecycleOwner);
    }

    /* renamed from: onChanged, reason: avoid collision after fix types in other method */
    public final void onChanged2(LifecycleOwner lifecycleOwner) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner, "viewLifecycleOwner");
        lifecycleOwner.getLifecycle().addObserver(new AnonymousClass1());
    }
}
