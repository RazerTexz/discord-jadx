package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetDisableDeleteAccountDialogBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetDisableDeleteAccountDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetDisableDeleteAccountDialog;", "Lcom/discord/app/AppDialog;", "Lcom/discord/models/user/MeUser;", "meUser", "", "configureUI", "(Lcom/discord/models/user/MeUser;)V", "Lcom/discord/widgets/settings/account/WidgetDisableDeleteAccountDialog$Mode;", "mode", "onDisableClicked", "(Lcom/discord/widgets/settings/account/WidgetDisableDeleteAccountDialog$Mode;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onResume", "()V", "Lcom/discord/databinding/WidgetDisableDeleteAccountDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetDisableDeleteAccountDialogBinding;", "binding", "<init>", "Companion", "Mode", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetDisableDeleteAccountDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDisableDeleteAccountDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDisableDeleteAccountDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_MODE = "extra_mode";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetDisableDeleteAccountDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetDisableDeleteAccountDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/settings/account/WidgetDisableDeleteAccountDialog$Mode;", "mode", "", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/settings/account/WidgetDisableDeleteAccountDialog$Mode;)V", "", "EXTRA_MODE", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Mode mode) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog = new WidgetDisableDeleteAccountDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(WidgetDisableDeleteAccountDialog.EXTRA_MODE, mode.ordinal());
            widgetDisableDeleteAccountDialog.setArguments(bundle);
            String tag = widgetDisableDeleteAccountDialog.getTag();
            if (tag == null) {
                tag = "";
            }
            widgetDisableDeleteAccountDialog.show(fragmentManager, tag);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDisableDeleteAccountDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006j\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetDisableDeleteAccountDialog$Mode;", "", "", "headerStringId", "I", "getHeaderStringId", "()I", "confirmStringId", "getConfirmStringId", "bodyStringId", "getBodyStringId", "<init>", "(Ljava/lang/String;IIII)V", "DISABLE", "DELETE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum Mode {
        DISABLE(R.string.disable_account, R.string.disable_account_body, R.string.disable),
        DELETE(R.string.delete_account, R.string.delete_account_body, R.string.delete);

        private final int bodyStringId;
        private final int confirmStringId;
        private final int headerStringId;

        Mode(@StringRes int i, @StringRes int i2, @StringRes int i3) {
            this.headerStringId = i;
            this.bodyStringId = i2;
            this.confirmStringId = i3;
        }

        public final int getBodyStringId() {
            return this.bodyStringId;
        }

        public final int getConfirmStringId() {
            return this.confirmStringId;
        }

        public final int getHeaderStringId() {
            return this.headerStringId;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Mode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[Mode.DISABLE.ordinal()] = 1;
            iArr[Mode.DELETE.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetDisableDeleteAccountDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onDisableClicked$1, reason: invalid class name */
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
            WidgetDisableDeleteAccountDialog.access$getBinding$p(WidgetDisableDeleteAccountDialog.this).e.setIsLoading(false);
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
            int code = response.getCode();
            if (code == 50018) {
                TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.access$getBinding$p(WidgetDisableDeleteAccountDialog.this).g;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeletePasswordWrap");
                Error.Response response2 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response2, "it.response");
                textInputLayout.setError(response2.getMessage());
                return;
            }
            if (code != 60008) {
                Context context = WidgetDisableDeleteAccountDialog.this.getContext();
                Error.Response response3 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response3, "it.response");
                AppToast.h(context, response3.getMessage(), 0, null, 12);
                return;
            }
            TextInputLayout textInputLayout2 = WidgetDisableDeleteAccountDialog.access$getBinding$p(WidgetDisableDeleteAccountDialog.this).d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeleteCodeWrap");
            Error.Response response4 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response4, "it.response");
            textInputLayout2.setError(response4.getMessage());
        }
    }

    /* compiled from: WidgetDisableDeleteAccountDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onDisableClicked$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    /* compiled from: WidgetDisableDeleteAccountDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/user/MeUser;", "p1", "", "invoke", "(Lcom/discord/models/user/MeUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<MeUser, Unit> {
        public AnonymousClass1(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog) {
            super(1, widgetDisableDeleteAccountDialog, WidgetDisableDeleteAccountDialog.class, "configureUI", "configureUI(Lcom/discord/models/user/MeUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "p1");
            WidgetDisableDeleteAccountDialog.access$configureUI((WidgetDisableDeleteAccountDialog) this.receiver, meUser);
        }
    }

    /* compiled from: WidgetDisableDeleteAccountDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetDisableDeleteAccountDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetDisableDeleteAccountDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.access$getBinding$p(WidgetDisableDeleteAccountDialog.this).d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetDisableDeleteAccountDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "it", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.access$getBinding$p(WidgetDisableDeleteAccountDialog.this).g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeletePasswordWrap");
            textInputLayout.setError(null);
        }
    }

    /* compiled from: WidgetDisableDeleteAccountDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Mode $mode;

        public AnonymousClass4(Mode mode) {
            this.$mode = mode;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetDisableDeleteAccountDialog.access$onDisableClicked(WidgetDisableDeleteAccountDialog.this, this.$mode);
        }
    }

    public WidgetDisableDeleteAccountDialog() {
        super(R.layout.widget_disable_delete_account_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetDisableDeleteAccountDialog2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog, MeUser meUser) {
        widgetDisableDeleteAccountDialog.configureUI(meUser);
    }

    public static final /* synthetic */ WidgetDisableDeleteAccountDialogBinding access$getBinding$p(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog) {
        return widgetDisableDeleteAccountDialog.getBinding();
    }

    public static final /* synthetic */ void access$onDisableClicked(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog, Mode mode) {
        widgetDisableDeleteAccountDialog.onDisableClicked(mode);
    }

    private final void configureUI(MeUser meUser) {
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        textInputLayout.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
    }

    private final WidgetDisableDeleteAccountDialogBinding getBinding() {
        return (WidgetDisableDeleteAccountDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onDisableClicked(Mode mode) {
        String textOrEmpty;
        Observable<Void> observableDisableAccount;
        getBinding().e.setIsLoading(true);
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        if (textInputLayout.getVisibility() == 0) {
            TextInputLayout textInputLayout2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeleteCodeWrap");
            textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        } else {
            textOrEmpty = null;
        }
        TextInputLayout textInputLayout3 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.disableDeletePasswordWrap");
        RestAPIParams.DisableAccount disableAccount = new RestAPIParams.DisableAccount(ViewExtensions.getTextOrEmpty(textInputLayout3), textOrEmpty);
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            observableDisableAccount = RestAPI.INSTANCE.getApi().disableAccount(disableAccount);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            observableDisableAccount = RestAPI.INSTANCE.getApi().deleteAccount(disableAccount);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableDisableAccount, false, 1, null), this, null, 2, null), WidgetDisableDeleteAccountDialog.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, AnonymousClass2.INSTANCE, 54, (Object) null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), WidgetDisableDeleteAccountDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Mode mode;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mode = Mode.values()[arguments.getInt(EXTRA_MODE)];
        } else {
            mode = null;
        }
        if (mode == null) {
            Logger.e$default(AppLog.g, "Disable/Delete Dialog shown with null mode", null, null, 6, null);
            dismiss();
            return;
        }
        getBinding().e.setIsLoading(false);
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.disableDeleteHeader");
        textView.setText(getString(mode.getHeaderStringId()));
        TextView textView2 = getBinding().f2366b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.disableDeleteBody");
        textView2.setText(getString(mode.getBodyStringId()));
        getBinding().e.setText(getString(mode.getConfirmStringId()));
        getBinding().c.setOnClickListener(new AnonymousClass1());
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        TextInputLayout textInputLayout2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeletePasswordWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass3());
        getBinding().e.setOnClickListener(new AnonymousClass4(mode));
    }
}
