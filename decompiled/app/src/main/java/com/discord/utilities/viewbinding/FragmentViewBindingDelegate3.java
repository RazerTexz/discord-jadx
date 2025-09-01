package com.discord.utilities.viewbinding;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FragmentViewBindingDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/viewbinding/ViewBinding;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "Lkotlin/Function1;", "Landroid/view/View;", "viewBindingFactory", "", "onViewBindingDestroy", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "viewBinding", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class FragmentViewBindingDelegate3 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FragmentViewBindingDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/viewbinding/ViewBinding;", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke", "(Landroidx/viewbinding/ViewBinding;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt$viewBinding$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((ViewBinding) obj);
            return Unit.a;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        public final void invoke(ViewBinding viewBinding) {
            Intrinsics3.checkNotNullParameter(viewBinding, "it");
        }
    }

    public static final <T extends ViewBinding> FragmentViewBindingDelegate<T> viewBinding(Fragment fragment, Function1<? super View, ? extends T> function1, Function1<? super T, Unit> function12) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$viewBinding");
        Intrinsics3.checkNotNullParameter(function1, "viewBindingFactory");
        Intrinsics3.checkNotNullParameter(function12, "onViewBindingDestroy");
        return new FragmentViewBindingDelegate<>(fragment, function1, function12);
    }

    public static /* synthetic */ FragmentViewBindingDelegate viewBinding$default(Fragment fragment, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = AnonymousClass1.INSTANCE;
        }
        return viewBinding(fragment, function1, function12);
    }
}
