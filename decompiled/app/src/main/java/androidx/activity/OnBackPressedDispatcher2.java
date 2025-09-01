package androidx.activity;

import androidx.view.LifecycleOwner;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: OnBackPressedDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a;\u0010\t\u001a\u00020\u0006*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "enabled", "Lkotlin/Function1;", "Landroidx/activity/OnBackPressedCallback;", "", "onBackPressed", "addCallback", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/LifecycleOwner;ZLkotlin/jvm/functions/Function1;)Landroidx/activity/OnBackPressedCallback;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: androidx.activity.OnBackPressedDispatcherKt, reason: use source file name */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher2 {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z2, Function1<? super OnBackPressedCallback, Unit> function1) {
        Intrinsics3.checkNotNullParameter(onBackPressedDispatcher, "$this$addCallback");
        Intrinsics3.checkNotNullParameter(function1, "onBackPressed");
        OnBackPressedDispatcher3 onBackPressedDispatcher3 = new OnBackPressedDispatcher3(function1, z2, z2);
        if (lifecycleOwner != null) {
            onBackPressedDispatcher.addCallback(lifecycleOwner, onBackPressedDispatcher3);
        } else {
            onBackPressedDispatcher.addCallback(onBackPressedDispatcher3);
        }
        return onBackPressedDispatcher3;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z2, function1);
    }
}
