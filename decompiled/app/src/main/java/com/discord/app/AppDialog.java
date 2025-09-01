package com.discord.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.widgets.notice.WidgetNoticeDialog;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* compiled from: AppDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b9\u0010\nB\u0013\b\u0016\u0012\b\b\u0001\u0010:\u001a\u00020\u001a¢\u0006\u0004\b9\u0010;J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0011\u0010\nJ!\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0016\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\nJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\nJ\u0015\u0010 \u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b \u0010\u0010J\u001b\u0010!\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b!\u0010\u0010J'\u0010$\u001a\u00020\b*\u00020\u000b2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\"H\u0004¢\u0006\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00038D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R(\u0010.\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0,8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u00103\u001a\u00020&2\u0006\u00102\u001a\u00020&8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b3\u0010(\u001a\u0004\b3\u00104R\u0015\u00108\u001a\u0004\u0018\u0001058F@\u0006¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/discord/app/AppDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/discord/app/AppComponent;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "", "onStart", "()V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroidx/fragment/app/FragmentTransaction;", "transaction", "", "(Landroidx/fragment/app/FragmentTransaction;Ljava/lang/String;)I", "dismiss", "onPause", "onResume", "onDestroyView", "showKeyboard", "hideKeyboard", "Lkotlin/Function1;", "onClickListener", "setOnClickAndDismissListener", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "", "onViewBoundOrOnResumeInvoked", "Z", "getArgumentsOrDefault", "()Landroid/os/Bundle;", "argumentsOrDefault", "Lrx/subjects/Subject;", "Ljava/lang/Void;", "unsubscribeSignal", "Lrx/subjects/Subject;", "getUnsubscribeSignal", "()Lrx/subjects/Subject;", "<set-?>", "isRecreated", "()Z", "Lcom/discord/app/AppActivity;", "getAppActivity", "()Lcom/discord/app/AppActivity;", "appActivity", "<init>", "contentResId", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class AppDialog extends DialogFragment implements AppComponent {
    private boolean isRecreated;
    private boolean onViewBoundOrOnResumeInvoked;
    private final Subject<Void, Void> unsubscribeSignal;

    /* compiled from: AppDialog.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View k;
        public final /* synthetic */ Function1 l;

        public a(View view, Function1 function1) {
            this.k = view;
            this.l = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppDialog.this.dismiss();
        }
    }

    public AppDialog() {
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    public static /* synthetic */ void hideKeyboard$default(AppDialog appDialog, View view, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideKeyboard");
        }
        if ((i & 1) != 0) {
            view = null;
        }
        appDialog.hideKeyboard(view);
    }

    @Override // androidx.fragment.app.DialogFragment
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

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    public final void hideKeyboard() {
        hideKeyboard$default(this, null, 1, null);
    }

    public final void hideKeyboard(View view) {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.hideKeyboard(view);
        }
    }

    /* renamed from: isRecreated, reason: from getter */
    public final boolean getIsRecreated() {
        return this.isRecreated;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Window window;
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics3.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        dialogOnCreateDialog.requestWindowFeature(1);
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled() && (window = dialogOnCreateDialog.getWindow()) != null) {
            window.setWindowAnimations(R.style.FadeInOut);
        }
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TextWatcher.INSTANCE.reset(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getUnsubscribeSignal().onNext(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.onViewBoundOrOnResumeInvoked) {
            this.onViewBoundOrOnResumeInvoked = false;
        } else {
            onViewBoundOrOnResume();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        try {
            super.onStart();
        } catch (Exception e) {
            if (this instanceof WidgetNoticeDialog) {
                ((WidgetNoticeDialog) this).logOnStartError(e);
            } else {
                AppLog appLog = AppLog.g;
                StringBuilder sbU = outline.U("Failed to start AppDialog: ");
                sbU.append(getClass().getName());
                Logger.e$default(appLog, sbU.toString(), e, null, 4, null);
            }
        }
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(R.color.transparent);
    }

    @CallSuper
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
    }

    @CallSuper
    public void onViewBoundOrOnResume() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.isRecreated = savedInstanceState != null;
        DisplayUtils.drawUnderSystemBars(view);
        onViewBound(view);
        onViewBoundOrOnResume();
        this.onViewBoundOrOnResumeInvoked = true;
    }

    public final void setOnClickAndDismissListener(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "$this$setOnClickAndDismissListener");
        Intrinsics3.checkNotNullParameter(function1, "onClickListener");
        view.setOnClickListener(new a(view, function1));
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        Intrinsics3.checkNotNullParameter(manager, "manager");
        if (!isDetached()) {
            try {
                super.show(manager, tag);
            } catch (Exception unused) {
            }
        } else {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("failed to show ");
            sbU.append(manager.getClass().getName());
            Logger.e$default(appLog, "Could not show dialog because of detached FragmentManager", new IllegalStateException(sbU.toString()), null, 4, null);
        }
    }

    public final void showKeyboard(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.showKeyboard(view);
        }
    }

    public AppDialog(@LayoutRes int i) {
        super(i);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
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
}
