package com.discord.widgets.auth;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.i.WidgetAuthMfaInfoBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthMfaBackupCodesBinding;
import com.discord.databinding.WidgetAuthMfaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CodeVerificationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetAuthMfa.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004R\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthMfa;", "Lcom/discord/app/AppFragment;", "", "tryPasteCodeFromClipboard", "()V", "showBackupCodesDialog", "showInfoDialog", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "evaluateCode", "(Ljava/lang/String;)V", "Landroidx/appcompat/app/AlertDialog;", "dialog", "evaluateBackupCode", "(Landroidx/appcompat/app/AlertDialog;Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Landroid/view/ContextMenu;", "menu", "v", "Landroid/view/ContextMenu$ContextMenuInfo;", "menuInfo", "onCreateContextMenu", "(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V", "Landroid/view/MenuItem;", "item", "", "onContextItemSelected", "(Landroid/view/MenuItem;)Z", "onResume", "Lcom/discord/databinding/WidgetAuthMfaBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetAuthMfaBinding;", "binding", "ticket", "Ljava/lang/String;", "ignoreAutopaste", "Z", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetAuthMfa extends AppFragment {
    private static final int BACKUP_CODE_DIGITS = 8;
    private static final String INTENT_TICKET = "INTENT_TICKET";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean ignoreAutopaste;
    private String ticket;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthMfa.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthMfaBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthMfa$Companion;", "", "Landroid/content/Context;", "context", "", "ticket", "", "start", "(Landroid/content/Context;Ljava/lang/String;)V", "", "BACKUP_CODE_DIGITS", "I", WidgetAuthMfa.INTENT_TICKET, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void start(Context context, String ticket) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(ticket, "ticket");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthMfa.INTENT_TICKET, ticket);
            AppScreen2.d(context, WidgetAuthMfa.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/domain/auth/ModelLoginResult;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/models/domain/auth/ModelLoginResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$evaluateCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelLoginResult, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
            invoke2(modelLoginResult);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLoginResult modelLoginResult) {
            AnalyticsTracker.INSTANCE.loginAttempt(true);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$evaluateCode$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetAuthMfa.access$getBinding$p(WidgetAuthMfa.this).f2234b.b();
            AnalyticsTracker.INSTANCE.loginAttempt(false);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthMfa.access$tryPasteCodeFromClipboard(WidgetAuthMfa.this);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case R.id.menu_auth_mfa_backup_codes /* 2131364363 */:
                    WidgetAuthMfa.access$showBackupCodesDialog(WidgetAuthMfa.this);
                    break;
                case R.id.menu_auth_mfa_info /* 2131364364 */:
                    WidgetAuthMfa.access$showInfoDialog(WidgetAuthMfa.this);
                    break;
            }
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$onViewBound$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(WidgetAuthMfa widgetAuthMfa) {
            super(1, widgetAuthMfa, WidgetAuthMfa.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            WidgetAuthMfa.access$evaluateCode((WidgetAuthMfa) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$showBackupCodesDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetAuthMfaBackupCodesBinding $binding;
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass1(AlertDialog alertDialog, WidgetAuthMfaBackupCodesBinding widgetAuthMfaBackupCodesBinding) {
            this.$dialog = alertDialog;
            this.$binding = widgetAuthMfaBackupCodesBinding;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthMfa widgetAuthMfa = WidgetAuthMfa.this;
            AlertDialog alertDialog = this.$dialog;
            Intrinsics3.checkNotNullExpressionValue(alertDialog, "dialog");
            TextInputLayout textInputLayout = this.$binding.c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetAuthMfaBackupCodesEdittext");
            WidgetAuthMfa.access$evaluateBackupCode(widgetAuthMfa, alertDialog, ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$showBackupCodesDialog$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass2(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.hide();
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$showInfoDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass1(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(WidgetAuthMfa widgetAuthMfa) {
            super(1, widgetAuthMfa, WidgetAuthMfa.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            WidgetAuthMfa.access$evaluateCode((WidgetAuthMfa) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthMfa widgetAuthMfa = WidgetAuthMfa.this;
            WidgetAuthMfa.access$evaluateCode(widgetAuthMfa, WidgetAuthMfa.access$getBinding$p(widgetAuthMfa).f2234b.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
        }
    }

    public WidgetAuthMfa() {
        super(R.layout.widget_auth_mfa);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthMfa2.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    public static final /* synthetic */ void access$evaluateBackupCode(WidgetAuthMfa widgetAuthMfa, AlertDialog alertDialog, String str) {
        widgetAuthMfa.evaluateBackupCode(alertDialog, str);
    }

    public static final /* synthetic */ void access$evaluateCode(WidgetAuthMfa widgetAuthMfa, String str) {
        widgetAuthMfa.evaluateCode(str);
    }

    public static final /* synthetic */ WidgetAuthMfaBinding access$getBinding$p(WidgetAuthMfa widgetAuthMfa) {
        return widgetAuthMfa.getBinding();
    }

    public static final /* synthetic */ void access$showBackupCodesDialog(WidgetAuthMfa widgetAuthMfa) {
        widgetAuthMfa.showBackupCodesDialog();
    }

    public static final /* synthetic */ void access$showInfoDialog(WidgetAuthMfa widgetAuthMfa) {
        widgetAuthMfa.showInfoDialog();
    }

    public static final /* synthetic */ void access$tryPasteCodeFromClipboard(WidgetAuthMfa widgetAuthMfa) {
        widgetAuthMfa.tryPasteCodeFromClipboard();
    }

    private final void evaluateBackupCode(AlertDialog dialog, String code) {
        if (code.length() < 8) {
            AppToast.i(this, R.string.two_fa_backup_code_enter_wrong, 0, 4);
        } else {
            dialog.hide();
            evaluateCode(code);
        }
    }

    private final void evaluateCode(String code) {
        if (TextUtils.isEmpty(code)) {
            AppToast.i(this, R.string.two_fa_token_required, 0, 4);
            return;
        }
        StoreAuthentication authentication = StoreStream.INSTANCE.getAuthentication();
        String str = this.ticket;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("ticket");
        }
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(authentication.authMFA(code, str), this, null, 2, null), getBinding().c, 0L).k(o.a.g(getContext(), AnonymousClass1.INSTANCE, new AnonymousClass2()));
    }

    private final WidgetAuthMfaBinding getBinding() {
        return (WidgetAuthMfaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @MainThread
    private final void showBackupCodesDialog() {
        View viewInflate = getLayoutInflater().inflate(R.layout.widget_auth_mfa_backup_codes, (ViewGroup) null, false);
        int i = R.id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(R.id.server_settings_delete_server_header);
        if (textView != null) {
            i = R.id.widget_auth_mfa_backup_codes_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.widget_auth_mfa_backup_codes_cancel);
            if (materialButton != null) {
                i = R.id.widget_auth_mfa_backup_codes_edittext;
                TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.widget_auth_mfa_backup_codes_edittext);
                if (textInputLayout != null) {
                    i = R.id.widget_auth_mfa_backup_codes_send;
                    MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.widget_auth_mfa_backup_codes_send);
                    if (materialButton2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        WidgetAuthMfaBackupCodesBinding widgetAuthMfaBackupCodesBinding = new WidgetAuthMfaBackupCodesBinding(linearLayout, textView, materialButton, textInputLayout, materialButton2);
                        Intrinsics3.checkNotNullExpressionValue(widgetAuthMfaBackupCodesBinding, "WidgetAuthMfaBackupCodes…outInflater, null, false)");
                        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                        AlertDialog alertDialogShow = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).show();
                        materialButton2.setOnClickListener(new AnonymousClass1(alertDialogShow, widgetAuthMfaBackupCodesBinding));
                        materialButton.setOnClickListener(new AnonymousClass2(alertDialogShow));
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @MainThread
    private final void showInfoDialog() {
        View viewInflate = getLayoutInflater().inflate(R.layout.widget_auth_mfa_info, (ViewGroup) null, false);
        int i = R.id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(R.id.server_settings_delete_server_header);
        if (textView != null) {
            i = R.id.widget_auth_mfa_info_okay;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.widget_auth_mfa_info_okay);
            if (materialButton != null) {
                i = R.id.widget_auth_mfa_info_text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.widget_auth_mfa_info_text);
                if (linkifiedTextView != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new WidgetAuthMfaInfoBinding(linearLayout, textView, materialButton, linkifiedTextView), "WidgetAuthMfaInfoBinding…outInflater, null, false)");
                    Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                    AlertDialog alertDialogShow = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).show();
                    Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.widgetAuthMfaInfoText");
                    FormatUtils.n(linkifiedTextView, R.string.two_fa_download_app_body, new Object[]{AuthUtils.URL_AUTHY, AuthUtils.URL_GOOGLE_AUTHENTICATOR}, null, 4);
                    materialButton.setOnClickListener(new AnonymousClass1(alertDialogShow));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void tryPasteCodeFromClipboard() {
        ClipData primaryClip;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                if (charSequenceCoerceToText.length() == 6 && TextUtils.isDigitsOnly(charSequenceCoerceToText)) {
                    getBinding().f2234b.setOnCodeEntered(AnonymousClass1.INSTANCE);
                    CodeVerificationView codeVerificationView = getBinding().f2234b;
                    Intrinsics3.checkNotNullExpressionValue(charSequenceCoerceToText, "clipboardText");
                    codeVerificationView.setCode(charSequenceCoerceToText);
                    getBinding().f2234b.setOnCodeEntered(new AnonymousClass2(this));
                    Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
                    Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n            .…L, TimeUnit.MILLISECONDS)");
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetAuthMfa.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.menu_code_verification_paste) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Intrinsics3.checkNotNullParameter(menu, "menu");
        Intrinsics3.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(R.menu.menu_code_verification, menu);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ignoreAutopaste) {
            this.ignoreAutopaste = false;
            return;
        }
        Observable<Long> observableD0 = Observable.d0(250L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…L, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetAuthMfa.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        AppActivity appActivity;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_auth_mfa, new AnonymousClass1(), null, 4, null);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_TICKET);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.ticket = stringExtra;
        if (stringExtra == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("ticket");
        }
        if ((stringExtra.length() == 0) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        getBinding().f2234b.setOnCodeEntered(new AnonymousClass2(this));
        registerForContextMenu(getBinding().f2234b);
    }
}
