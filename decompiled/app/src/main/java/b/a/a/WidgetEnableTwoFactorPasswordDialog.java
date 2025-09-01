package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.i.WidgetEnableTwoFactorPasswordDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.app.AppDialog;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lb/a/a/s;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lb/a/i/h5;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/h5;", "binding", "Lkotlin/Function1;", "", "m", "Lkotlin/jvm/functions/Function1;", "onValidPasswordEntered", "<init>", "()V", "k", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.s, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetEnableTwoFactorPasswordDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(WidgetEnableTwoFactorPasswordDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public Function1<? super String, Unit> onValidPasswordEntered;

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetEnableTwoFactorPasswordDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, WidgetEnableTwoFactorPasswordDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetEnableTwoFactorPasswordDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.enable_two_factor_password_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.enable_two_factor_password_body_container);
            if (linearLayout != null) {
                i = R.id.enable_two_factor_password_body_text;
                TextView textView = (TextView) view2.findViewById(R.id.enable_two_factor_password_body_text);
                if (textView != null) {
                    i = R.id.enable_two_factor_password_cancel;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.enable_two_factor_password_cancel);
                    if (materialButton != null) {
                        i = R.id.enable_two_factor_password_header;
                        TextView textView2 = (TextView) view2.findViewById(R.id.enable_two_factor_password_header);
                        if (textView2 != null) {
                            i = R.id.enable_two_factor_password_header_container;
                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.enable_two_factor_password_header_container);
                            if (linearLayout2 != null) {
                                i = R.id.enable_two_factor_password_ok;
                                LoadingButton loadingButton = (LoadingButton) view2.findViewById(R.id.enable_two_factor_password_ok);
                                if (loadingButton != null) {
                                    i = R.id.enable_two_factor_password_view_input;
                                    TextInputLayout textInputLayout = (TextInputLayout) view2.findViewById(R.id.enable_two_factor_password_view_input);
                                    if (textInputLayout != null) {
                                        return new WidgetEnableTwoFactorPasswordDialogBinding((LinearLayout) view2, linearLayout, textView, materialButton, textView2, linearLayout2, loadingButton, textInputLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$c */
    public static final class c extends Lambda implements Function1<String, Unit> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return Unit.a;
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$d */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ View k;

        /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        /* renamed from: b.a.a.s$d$a */
        public static final class a extends Lambda implements Function1<EnableMfaResponse, Unit> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(EnableMfaResponse enableMfaResponse) {
                Intrinsics3.checkNotNullParameter(enableMfaResponse, "it");
                return Unit.a;
            }
        }

        /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        /* renamed from: b.a.a.s$d$b */
        public static final class b extends Lambda implements Function1<Error, Unit> {
            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Error error) {
                Error error2 = error;
                Intrinsics3.checkNotNullParameter(error2, "error");
                WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog = WidgetEnableTwoFactorPasswordDialog.this;
                KProperty[] kPropertyArr = WidgetEnableTwoFactorPasswordDialog.j;
                widgetEnableTwoFactorPasswordDialog.g().c.setIsLoading(false);
                Error.Response response = error2.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 60005) {
                    error2.setShowErrorToasts(false);
                    WidgetEnableTwoFactorPasswordDialog.this.dismiss();
                    WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog2 = WidgetEnableTwoFactorPasswordDialog.this;
                    Function1<? super String, Unit> function1 = widgetEnableTwoFactorPasswordDialog2.onValidPasswordEntered;
                    TextInputLayout textInputLayout = widgetEnableTwoFactorPasswordDialog2.g().d;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
                    function1.invoke(ViewExtensions.getTextOrEmpty(textInputLayout));
                }
                return Unit.a;
            }
        }

        public d(View view) {
            this.k = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog = WidgetEnableTwoFactorPasswordDialog.this;
            KProperty[] kPropertyArr = WidgetEnableTwoFactorPasswordDialog.j;
            TextInputLayout textInputLayout = widgetEnableTwoFactorPasswordDialog.g().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            WidgetEnableTwoFactorPasswordDialog.this.g().c.setIsLoading(true);
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().enableMFA(new RestAPIParams.EnableMFA("random code", "random secret", textOrEmpty)), false, 1, null), WidgetEnableTwoFactorPasswordDialog.this, null, 2, null);
            a aVar = a.j;
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, WidgetEnableTwoFactorPasswordDialog.this.getClass(), this.k.getContext(), (Function1) null, new b(), (Function0) null, (Function0) null, aVar, 52, (Object) null);
        }
    }

    /* compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    /* renamed from: b.a.a.s$e */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetEnableTwoFactorPasswordDialog.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public WidgetEnableTwoFactorPasswordDialog() {
        super(R.layout.widget_enable_two_factor_password_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
        this.onValidPasswordEntered = c.j;
    }

    public final WidgetEnableTwoFactorPasswordDialogBinding g() {
        return (WidgetEnableTwoFactorPasswordDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        g().c.setIsLoading(false);
        g().c.setOnClickListener(new d(view));
        g().f129b.setOnClickListener(new e());
    }
}
