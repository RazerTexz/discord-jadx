package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetEnableSmsBackupDialogBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetEnableSMSBackupDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u001d\u0010\u000f\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetEnableSMSBackupDialog;", "Lcom/discord/app/AppDialog;", "", "enable", "", "enableSMSBackup", "(Z)V", "onResume", "()V", "onDestroyView", "Lcom/discord/databinding/WidgetEnableSmsBackupDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetEnableSmsBackupDialogBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEnableSMSBackupDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableSMSBackupDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableSmsBackupDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ENABLE = "extra_enable";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetEnableSMSBackupDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "enable", "", "show", "(Landroidx/fragment/app/FragmentManager;Z)V", "", "EXTRA_ENABLE", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, boolean enable) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog = new WidgetEnableSMSBackupDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(WidgetEnableSMSBackupDialog.EXTRA_ENABLE, enable);
            widgetEnableSMSBackupDialog.setArguments(bundle);
            String tag = widgetEnableSMSBackupDialog.getTag();
            if (tag == null) {
                tag = "";
            }
            widgetEnableSMSBackupDialog.show(fragmentManager, tag);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$enableSMSBackup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetEnableSMSBackupDialog.access$getBinding$p(WidgetEnableSMSBackupDialog.this).d.setIsLoading(false);
            View view = WidgetEnableSMSBackupDialog.this.getView();
            Context context = view != null ? view.getContext() : null;
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
            AppToast.h(context, response.getMessage(), 0, null, 12);
        }
    }

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$enableSMSBackup$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreStream.INSTANCE.getMFA().togglingSMSBackup();
            WidgetEnableSMSBackupDialog.access$getBinding$p(WidgetEnableSMSBackupDialog.this).d.setIsLoading(false);
            WidgetEnableSMSBackupDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableSMSBackupDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Boolean $enable;

        public AnonymousClass2(Boolean bool) {
            this.$enable = bool;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableSMSBackupDialog.access$enableSMSBackup(WidgetEnableSMSBackupDialog.this, this.$enable.booleanValue());
        }
    }

    public WidgetEnableSMSBackupDialog() {
        super(R.layout.widget_enable_sms_backup_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableSMSBackupDialog2.INSTANCE, null, 2, null);
        setCancelable(false);
    }

    public static final /* synthetic */ void access$enableSMSBackup(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog, boolean z2) {
        widgetEnableSMSBackupDialog.enableSMSBackup(z2);
    }

    public static final /* synthetic */ WidgetEnableSmsBackupDialogBinding access$getBinding$p(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog) {
        return widgetEnableSMSBackupDialog.getBinding();
    }

    private final void enableSMSBackup(boolean enable) {
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.enableSmsBackupPasswordWrap");
        RestAPIParams.ActivateMfaSMS activateMfaSMS = new RestAPIParams.ActivateMfaSMS(ViewExtensions.getTextOrEmpty(textInputLayout));
        Observable<Void> observableEnableMfaSMS = enable ? RestAPI.INSTANCE.getApi().enableMfaSMS(activateMfaSMS) : RestAPI.INSTANCE.getApi().disableMfaSMS(activateMfaSMS);
        getBinding().d.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableEnableMfaSMS, false, 1, null), this, null, 2, null), WidgetEnableSMSBackupDialog.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    private final WidgetEnableSmsBackupDialogBinding getBinding() {
        return (WidgetEnableSmsBackupDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        AppDialog.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        Boolean boolValueOf = arguments != null ? Boolean.valueOf(arguments.getBoolean(EXTRA_ENABLE)) : null;
        if (boolValueOf == null) {
            dismiss();
            return;
        }
        if (boolValueOf.booleanValue()) {
            TextView textView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableSmsBackupHeader");
            textView.setText(getString(R.string.mfa_sms_enable));
            TextView textView2 = getBinding().f2381b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.enableSmsBackupBody");
            textView2.setText(getString(R.string.mfa_sms_auth_sales_pitch));
            getBinding().d.setText(getString(R.string.enable));
        } else {
            TextView textView3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.enableSmsBackupHeader");
            textView3.setText(getString(R.string.mfa_sms_remove));
            TextView textView4 = getBinding().f2381b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.enableSmsBackupBody");
            textView4.setText(getString(R.string.mfa_sms_confirm_remove_body));
            getBinding().d.setText(getString(R.string.disable));
        }
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().d.setIsLoading(false);
        getBinding().d.setOnClickListener(new AnonymousClass2(boolValueOf));
    }
}
