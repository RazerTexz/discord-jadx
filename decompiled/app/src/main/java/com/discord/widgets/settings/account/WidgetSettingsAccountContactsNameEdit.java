package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserConnectionsUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountContactsNameEditBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u0011J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountContactsNameEdit;", "Lcom/discord/app/AppFragment;", "", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "connections", "", "configureUI", "(Ljava/util/List;)V", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "submitName", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetSettingsAccountContactsNameEditBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsAccountContactsNameEditBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountContactsNameEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccountContactsNameEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountContactsNameEditBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/settings/account/WidgetSettingsAccountContactsNameEdit$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsAccountContactsNameEdit.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountContactsNameEdit.access$submitName(WidgetSettingsAccountContactsNameEdit.this, "");
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit = WidgetSettingsAccountContactsNameEdit.this;
            TextInputLayout textInputLayout = WidgetSettingsAccountContactsNameEdit.access$getBinding$p(widgetSettingsAccountContactsNameEdit).f2597b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Objects.requireNonNull(textOrEmpty, "null cannot be cast to non-null type kotlin.CharSequence");
            WidgetSettingsAccountContactsNameEdit.access$submitName(widgetSettingsAccountContactsNameEdit, Strings4.trim(textOrEmpty).toString());
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit = WidgetSettingsAccountContactsNameEdit.this;
            TextInputLayout textInputLayout = WidgetSettingsAccountContactsNameEdit.access$getBinding$p(widgetSettingsAccountContactsNameEdit).f2597b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Objects.requireNonNull(textOrEmpty, "null cannot be cast to non-null type kotlin.CharSequence");
            WidgetSettingsAccountContactsNameEdit.access$submitName(widgetSettingsAccountContactsNameEdit, Strings4.trim(textOrEmpty).toString());
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreUserConnections$State;", "it", "", "invoke", "(Lcom/discord/stores/StoreUserConnections$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreUserConnections.State, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserConnections.State state) {
            invoke2(state);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserConnections.State state) {
            Intrinsics3.checkNotNullParameter(state, "it");
            WidgetSettingsAccountContactsNameEdit.access$configureUI(WidgetSettingsAccountContactsNameEdit.this, state);
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccount;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$submitName$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ConnectedAccount, TrackNetworkMetadata2> {
        public final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$name = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ConnectedAccount connectedAccount) {
            return invoke2(connectedAccount);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(ConnectedAccount connectedAccount) {
            return new TrackNetworkActionUserConnectionsUpdate(this.$name, null, null, null, 14);
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/connectedaccounts/ConnectedAccount;", "it", "", "invoke", "(Lcom/discord/api/connectedaccounts/ConnectedAccount;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$submitName$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ConnectedAccount, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConnectedAccount connectedAccount) {
            invoke2(connectedAccount);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "it");
            FragmentActivity activity = WidgetSettingsAccountContactsNameEdit.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$submitName$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
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
        }
    }

    public WidgetSettingsAccountContactsNameEdit() {
        super(R.layout.widget_settings_account_contacts_name_edit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountContactsNameEdit2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit, List list) {
        widgetSettingsAccountContactsNameEdit.configureUI(list);
    }

    public static final /* synthetic */ WidgetSettingsAccountContactsNameEditBinding access$getBinding$p(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit) {
        return widgetSettingsAccountContactsNameEdit.getBinding();
    }

    public static final /* synthetic */ void access$submitName(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit, String str) {
        widgetSettingsAccountContactsNameEdit.submitName(str);
    }

    private final void configureUI(List<ConnectedAccount> connections) {
        ConnectedAccount connectedAccountPrevious;
        String name;
        ListIterator<ConnectedAccount> listIterator = connections.listIterator(connections.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            } else {
                connectedAccountPrevious = listIterator.previous();
                if (Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                    break;
                }
            }
        }
        ConnectedAccount connectedAccount = connectedAccountPrevious;
        TextInputLayout textInputLayout = getBinding().f2597b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        if (connectedAccount == null || (name = connectedAccount.getName()) == null) {
            name = "";
        }
        ViewExtensions.setText(textInputLayout, name);
        getBinding().c.setOnClickListener(new AnonymousClass1());
    }

    private final WidgetSettingsAccountContactsNameEditBinding getBinding() {
        return (WidgetSettingsAccountContactsNameEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void submitName(String name) {
        String string;
        AppFragment.hideKeyboard$default(this, null, 1, null);
        boolean z2 = name == null || StringsJVM.isBlank(name);
        if (z2) {
            string = null;
        } else {
            if (z2) {
                throw new NoWhenBranchMatchedException();
            }
            Objects.requireNonNull(name, "null cannot be cast to non-null type kotlin.CharSequence");
            string = Strings4.trim(name).toString();
        }
        AnalyticsTracker.INSTANCE.nameSubmitted(Strings4.split$default((CharSequence) name, new String[]{" "}, false, 0, 6, (Object) null).size(), name.length());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().updateConnectionName("contacts", "@me", new RestAPIParams.ConnectedAccountNameOnly(string)), false, 1, null), new AnonymousClass1(name)), this, null, 2, null), WidgetSettingsAccountContactsNameEdit.class, (Context) null, (Function1) null, AnonymousClass3.INSTANCE, (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.contact_sync_update_name_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f2597b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass1(), 1, null);
        getBinding().d.setOnClickListener(new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getUserConnections().observeConnectedAccounts(), this, null, 2, null), WidgetSettingsAccountContactsNameEdit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
