package com.discord.utilities.views.viewstub;

import android.view.View;
import android.view.ViewStub;
import d0.Lazy5;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LazyViewStubDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tR$\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R%\u0010\u0016\u001a\n \u0012*\u0004\u0018\u00010\u00070\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\tR$\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00070\u00070\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/views/viewstub/LazyViewStubDelegate;", "", "Landroid/view/View$OnClickListener;", "listener", "", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View;", "getMaybeView", "()Landroid/view/View;", "getForceInitializedView", "", "value", "isVisible", "()Z", "setVisible", "(Z)V", "Landroid/view/View$OnClickListener;", "kotlin.jvm.PlatformType", "view$delegate", "Lkotlin/Lazy;", "getView", "view", "Lkotlin/Lazy;", "viewField", "Landroid/view/ViewStub;", "stub", "<init>", "(Landroid/view/ViewStub;)V", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class LazyViewStubDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View.OnClickListener listener;

    /* renamed from: view$delegate, reason: from kotlin metadata */
    private final Lazy view;
    private final Lazy<View> viewField;

    /* compiled from: LazyViewStubDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/views/viewstub/LazyViewStubDelegate$Companion;", "", "Lkotlin/Function0;", "Landroid/view/ViewStub;", "getViewStub", "Lkotlin/Lazy;", "Lcom/discord/utilities/views/viewstub/LazyViewStubDelegate;", "lazyViewStub", "(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Lazy<LazyViewStubDelegate> lazyViewStub(Function0<ViewStub> getViewStub) {
            Intrinsics3.checkNotNullParameter(getViewStub, "getViewStub");
            return LazyJVM.lazy(Lazy5.NONE, new LazyViewStubDelegate2(getViewStub));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private LazyViewStubDelegate(ViewStub viewStub) {
        Lazy<View> lazy = LazyJVM.lazy(Lazy5.NONE, new LazyViewStubDelegate3(this, viewStub));
        this.viewField = lazy;
        this.view = lazy;
    }

    public static final /* synthetic */ View.OnClickListener access$getListener$p(LazyViewStubDelegate lazyViewStubDelegate) {
        return lazyViewStubDelegate.listener;
    }

    public static final /* synthetic */ void access$setListener$p(LazyViewStubDelegate lazyViewStubDelegate, View.OnClickListener onClickListener) {
        lazyViewStubDelegate.listener = onClickListener;
    }

    private final View getView() {
        return (View) this.view.getValue();
    }

    public final View getForceInitializedView() {
        View view = getView();
        Intrinsics3.checkNotNullExpressionValue(view, "view");
        return view;
    }

    public final View getMaybeView() {
        if (this.viewField.isInitialized()) {
            return getView();
        }
        return null;
    }

    public final boolean isVisible() {
        if (this.viewField.isInitialized()) {
            View view = getView();
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            if (view.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void setOnClickListener(View.OnClickListener listener) {
        if (this.viewField.isInitialized()) {
            getView().setOnClickListener(listener);
        } else {
            this.listener = listener;
        }
    }

    public final void setVisible(boolean z2) {
        if (z2 || this.viewField.isInitialized()) {
            View view = getView();
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public /* synthetic */ LazyViewStubDelegate(ViewStub viewStub, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewStub);
    }
}
