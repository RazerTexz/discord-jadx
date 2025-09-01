package com.discord.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R;
import com.discord.app.AppLogger;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.TextWatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import rx.subscriptions.CompositeSubscription;

/* compiled from: AppBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0011\u0012\b\b\u0002\u0010b\u001a\u00020\u0017¢\u0006\u0004\br\u0010sJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ-\u0010\u0012\u001a\u00020\u00052\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ-\u0010\u0015\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ+\u0010\u0016\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\"\u0010#J-\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b)\u0010*J!\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020(2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0017¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0007J!\u00103\u001a\u00020\u00052\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J!\u00103\u001a\u00020\u001a2\u0006\u00106\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00107J\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010\u0007J\u000f\u00109\u001a\u00020\u0005H\u0016¢\u0006\u0004\b9\u0010\u0007J\u000f\u0010:\u001a\u00020\u0005H\u0016¢\u0006\u0004\b:\u0010\u0007J\u0017\u0010<\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010(¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u001a¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bA\u0010BJ\u0015\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u001a¢\u0006\u0004\bD\u0010@J\u0017\u0010G\u001a\u00020\u00052\u0006\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bG\u0010HJ'\u0010K\u001a\u00020\u0005*\u00020(2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00050IH\u0004¢\u0006\u0004\bK\u0010LJ\u0015\u0010M\u001a\u00020\u00052\u0006\u0010+\u001a\u00020(¢\u0006\u0004\bM\u0010=J\u0019\u0010N\u001a\u00020\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010(¢\u0006\u0004\bN\u0010=J\u0017\u0010O\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u001aH\u0016¢\u0006\u0004\bO\u0010@R\u0015\u0010Q\u001a\u0004\u0018\u00010\t8F@\u0006¢\u0006\u0006\u001a\u0004\bP\u0010\u000bR\u0018\u0010R\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010WR\u001e\u0010[\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010X8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR(\u0010^\u001a\u000e\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020]0\\8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\u001d8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u001d\u0010l\u001a\u00020g8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u001e\u0010n\u001a\u0004\u0018\u00010m8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q¨\u0006t"}, d2 = {"Lcom/discord/app/AppBottomSheet;", "Lcom/discord/app/AppPermissionsRequests;", "Lcom/discord/app/AppComponent;", "Lcom/discord/app/AppLogger$a;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "fixWindowInsetHandling", "()V", "resizeContentForSoftInput", "Lcom/discord/app/AppActivity;", "requireAppActivity", "()Lcom/discord/app/AppActivity;", "Lkotlin/Function0;", "onSuccess", "requestVideoCallPermissions", "(Lkotlin/jvm/functions/Function0;)V", "requestMedia", "onFailure", "requestMicrophone", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "requestMediaDownload", "requestCameraQRScanner", "requestContacts", "", "hasMedia", "()Z", "", "getContentViewResId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroidx/fragment/app/FragmentTransaction;", "transaction", "(Landroidx/fragment/app/FragmentTransaction;Ljava/lang/String;)I", "dismiss", "onResume", "onPause", "targetView", "setPeekHeightBottomView", "(Landroid/view/View;)V", "state", "setBottomSheetState", "(I)V", "setBottomSheetCollapsedStateDisabled", "()Lkotlin/Unit;", "peekHeightPx", "updatePeekHeightPx", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "Lkotlin/Function1;", "onClickListener", "setOnClickAndDismissListener", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "showKeyboard", "hideKeyboard", "onStateChanged", "getAppActivity", "appActivity", "peekBottomView", "Landroid/view/View;", "Landroid/view/View$OnLayoutChangeListener;", "peekLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "Lrx/subscriptions/CompositeSubscription;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getBottomSheetBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "Lrx/subjects/Subject;", "Ljava/lang/Void;", "unsubscribeSignal", "Lrx/subjects/Subject;", "getUnsubscribeSignal", "()Lrx/subjects/Subject;", "shouldAvoidKeyboard", "Z", "getArgumentsOrDefault", "()Landroid/os/Bundle;", "argumentsOrDefault", "Lcom/discord/app/AppLogger;", "appLogger$delegate", "Lkotlin/Lazy;", "getAppLogger", "()Lcom/discord/app/AppLogger;", "appLogger", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class AppBottomSheet extends BottomSheetDialogFragment implements AppPermissions2, AppComponent, AppLogger.a {

    /* renamed from: appLogger$delegate, reason: from kotlin metadata */
    private final Lazy appLogger;
    private CompositeSubscription compositeSubscription;
    private final AppLogger2 loggingConfig;
    private View peekBottomView;
    private final View.OnLayoutChangeListener peekLayoutListener;
    private final boolean shouldAvoidKeyboard;
    private final Subject<Void, Void> unsubscribeSignal;

    /* compiled from: java-style lambda group */
    public static final class a implements OnApplyWindowInsetsListener {
        public static final a a = new a(0);

        /* renamed from: b, reason: collision with root package name */
        public static final a f2078b = new a(1);
        public final /* synthetic */ int c;

        public a(int i) {
            this.c = i;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i = this.c;
            if (i == 0) {
                Intrinsics3.checkNotNullParameter(view, "v");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
                return new WindowInsetsCompat.Builder(windowInsetsCompat).setSystemWindowInsets(Insets.of(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom())).build();
            }
            if (i != 1) {
                throw null;
            }
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: AppBottomSheet.kt */
    public static final class b extends Lambda implements Function0<AppLogger> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppLogger invoke() {
            return new AppLogger(AppBottomSheet.this, null, false, 6);
        }
    }

    /* compiled from: AppBottomSheet.kt */
    public static final class c implements DialogInterface.OnShowListener {
        public final /* synthetic */ Dialog a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppBottomSheet f2079b;

        /* compiled from: AppBottomSheet.kt */
        public static final class a extends Lambda implements Function1<Unit, Unit> {
            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Unit unit) {
                BottomSheetBehavior<FrameLayout> behavior;
                Dialog dialog = c.this.a;
                if (!(dialog instanceof BottomSheetDialog)) {
                    dialog = null;
                }
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
                if (bottomSheetDialog != null && (behavior = bottomSheetDialog.getBehavior()) != null) {
                    behavior.setState(3);
                }
                return Unit.a;
            }
        }

        public c(Dialog dialog, AppBottomSheet appBottomSheet) {
            this.a = dialog;
            this.f2079b = appBottomSheet;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface dialogInterface) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Unit.a);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(Unit)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(scalarSynchronousObservable, this.f2079b, null, 2, null), this.f2079b.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new a(), 62, (Object) null);
        }
    }

    /* compiled from: AppBottomSheet.kt */
    public static final class d extends BottomSheetBehavior.BottomSheetCallback {
        public d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
            Intrinsics3.checkNotNullParameter(view, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            Intrinsics3.checkNotNullParameter(view, "bottomSheet");
            AppBottomSheet.this.onStateChanged(i);
            if (i == 5) {
                AppBottomSheet.this.dismiss();
            }
        }
    }

    /* compiled from: AppBottomSheet.kt */
    public static final class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppBottomSheet.this.updatePeekHeightPx(i4);
        }
    }

    /* compiled from: AppBottomSheet.kt */
    public static final class f implements DialogInterface.OnShowListener {
        public final /* synthetic */ Dialog a;

        public f(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface dialogInterface) {
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(this.a.findViewById(R.id.design_bottom_sheet));
            Intrinsics3.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from(bottomSheet)");
            bottomSheetBehaviorFrom.setSkipCollapsed(true);
            bottomSheetBehaviorFrom.setState(3);
        }
    }

    /* compiled from: AppBottomSheet.kt */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ View k;
        public final /* synthetic */ Function1 l;

        public g(View view, Function1 function1) {
            this.k = view;
            this.l = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppBottomSheet.this.dismiss();
        }
    }

    public AppBottomSheet() {
        this(false, 1, null);
    }

    public /* synthetic */ AppBottomSheet(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2);
    }

    private final void fixWindowInsetHandling() {
        View viewFindViewById;
        View view = getView();
        if (view == null || (viewFindViewById = view.getRootView().findViewById(R.id.container)) == null) {
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, a.a);
        View viewFindViewById2 = view.getRootView().findViewById(R.id.design_bottom_sheet);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById2, "designBottomSheet");
        viewFindViewById2.setFitsSystemWindows(true);
        ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById2, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        ViewCompat.setOnApplyWindowInsetsListener(view, a.f2078b);
    }

    private final AppLogger getAppLogger() {
        return (AppLogger) this.appLogger.getValue();
    }

    private final BottomSheetBehavior<View> getBottomSheetBehavior() {
        View view = getView();
        Object parent = view != null ? view.getParent() : null;
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view2 = (View) parent;
        ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            layoutParams = null;
        }
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        CoordinatorLayout.Behavior behavior = layoutParams2 != null ? layoutParams2.getBehavior() : null;
        return (BottomSheetBehavior) (behavior instanceof BottomSheetBehavior ? behavior : null);
    }

    public static /* synthetic */ void hideKeyboard$default(AppBottomSheet appBottomSheet, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideKeyboard");
        }
        if ((i & 1) != 0) {
            view = null;
        }
        appBottomSheet.hideKeyboard(view);
    }

    private final void resizeContentForSoftInput() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(16);
    }

    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    public final AppActivity getAppActivity() {
        return (AppActivity) getActivity();
    }

    public final Bundle getArgumentsOrDefault() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        Intrinsics3.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
        return arguments;
    }

    @LayoutRes
    public abstract int getContentViewResId();

    @Override // com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // com.discord.app.AppPermissions2
    public boolean hasMedia() {
        return requireAppActivity().appPermissions.hasMedia();
    }

    public final void hideKeyboard(View view) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.hideKeyboard(view);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.shouldAvoidKeyboard) {
            setStyle(0, 2131952533);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.setCanceledOnTouchOutside(true);
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            Intrinsics3.checkNotNullExpressionValue(dialogOnCreateDialog, "dialog");
            Window window = dialogOnCreateDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.FadeInOut);
            }
        }
        if (this.shouldAvoidKeyboard) {
            dialogOnCreateDialog.setOnShowListener(new c(dialogOnCreateDialog, this));
        }
        Intrinsics3.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(sav…      }\n      }\n    }\n  }");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(getContentViewResId(), (ViewGroup) null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        TextWatcher.INSTANCE.reset(this);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        CompositeSubscription compositeSubscription = this.compositeSubscription;
        if (compositeSubscription != null) {
            compositeSubscription.b();
        }
        getUnsubscribeSignal().onNext(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        fixWindowInsetHandling();
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        bindSubscriptions(compositeSubscription);
        this.compositeSubscription = compositeSubscription;
    }

    public void onStateChanged(int state) {
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DisplayUtils.drawUnderSystemBars(view);
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setBottomSheetCallback(new d());
        }
        getAppLogger().b();
    }

    @Override // com.discord.app.AppPermissions2
    public void requestCameraQRScanner(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestContacts(Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        requireAppActivity().appPermissions.requestContacts(onSuccess, onFailure);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMedia(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMedia(onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMediaDownload(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMediaDownload(onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestMicrophone(Function0<Unit> onFailure, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestMicrophone(onFailure, onSuccess);
    }

    @Override // com.discord.app.AppPermissions2
    public void requestVideoCallPermissions(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestVideoCallPermissions(onSuccess);
    }

    public final AppActivity requireAppActivity() {
        AppActivity appActivity = getAppActivity();
        Intrinsics3.checkNotNull(appActivity);
        return appActivity;
    }

    public final Unit setBottomSheetCollapsedStateDisabled() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return null;
        }
        resizeContentForSoftInput();
        dialog.setOnShowListener(new f(dialog));
        return Unit.a;
    }

    public final void setBottomSheetState(int state) {
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(state);
        }
    }

    public final void setOnClickAndDismissListener(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "$this$setOnClickAndDismissListener");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        view.setOnClickListener(new g(view, function1));
    }

    public final void setPeekHeightBottomView(View targetView) {
        if (Intrinsics3.areEqual(this.peekBottomView, targetView)) {
            return;
        }
        View view = this.peekBottomView;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.peekLayoutListener);
        }
        this.peekBottomView = targetView;
        if (targetView == null) {
            setPeekHeightBottomView(getView());
        } else {
            targetView.addOnLayoutChangeListener(this.peekLayoutListener);
            targetView.requestLayout();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        Intrinsics3.checkNotNullParameter(manager, "manager");
        if (manager.findFragmentByTag(tag) != null) {
            return;
        }
        try {
            super.show(manager, tag);
        } catch (Exception unused) {
        }
    }

    public final void showKeyboard(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.showKeyboard(view);
        }
    }

    public final void updatePeekHeightPx(int peekHeightPx) {
        BottomSheetBehavior<View> bottomSheetBehavior = getBottomSheetBehavior();
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(peekHeightPx);
        }
    }

    public AppBottomSheet(boolean z2) {
        this.shouldAvoidKeyboard = z2;
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
        this.peekLayoutListener = new e();
        this.appLogger = LazyJVM.lazy(new b());
    }

    @Override // androidx.fragment.app.DialogFragment
    public int show(FragmentTransaction transaction, String tag) {
        Intrinsics3.checkNotNullParameter(transaction, "transaction");
        try {
            return super.show(transaction, tag);
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.discord.app.AppPermissions2
    public void requestCameraQRScanner(Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        requireAppActivity().appPermissions.requestCameraQRScanner(onSuccess);
    }
}
