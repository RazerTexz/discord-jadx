package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetServerSettingsInstantInviteActionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.invite.InviteUtils;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.g0.StringsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0012\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsInstantInvitesActions;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/models/domain/ModelInvite;", "invite", "", "handleInviteRevoked", "(Lcom/discord/models/domain/ModelInvite;)V", "", "getContentViewResId", "()I", "onResume", "()V", "Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions extends AppBottomSheet {
    private static final String ARG_INVITE_CODE = "ARG_INVITE_CODE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsInstantInvitesActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerSettingsInstantInvitesActions$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "inviteCode", "", "create", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", WidgetServerSettingsInstantInvitesActions.ARG_INVITE_CODE, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(FragmentManager fragmentManager, String inviteCode) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
            WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions = new WidgetServerSettingsInstantInvitesActions();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetServerSettingsInstantInvitesActions.ARG_INVITE_CODE, inviteCode);
            widgetServerSettingsInstantInvitesActions.setArguments(bundle);
            widgetServerSettingsInstantInvitesActions.show(fragmentManager, WidgetServerSettingsInstantInvitesActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $inviteCode;

        /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "p1", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$1$1, reason: invalid class name and collision with other inner class name */
        public static final /* synthetic */ class C03101 extends FunctionReferenceImpl implements Function1<ModelInvite, Unit> {
            public C03101(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions) {
                super(1, widgetServerSettingsInstantInvitesActions, WidgetServerSettingsInstantInvitesActions.class, "handleInviteRevoked", "handleInviteRevoked(Lcom/discord/models/domain/ModelInvite;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
                invoke2(modelInvite);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelInvite modelInvite) {
                Intrinsics3.checkNotNullParameter(modelInvite, "p1");
                WidgetServerSettingsInstantInvitesActions.access$handleInviteRevoked((WidgetServerSettingsInstantInvitesActions) this.receiver, modelInvite);
            }
        }

        public AnonymousClass1(String str) {
            this.$inviteCode = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().revokeInvite(this.$inviteCode), false, 1, null), WidgetServerSettingsInstantInvitesActions.this, null, 2, null).k(o.h(new WidgetServerSettingsInstantInvitesActions3(new C03101(WidgetServerSettingsInstantInvitesActions.this)), WidgetServerSettingsInstantInvitesActions.this.getContext(), null));
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ String $inviteUrl;

        public AnonymousClass2(String str) {
            this.$inviteUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppToast.c(outline.x(view, "it", "it.context"), this.$inviteUrl, 0, 4);
            WidgetServerSettingsInstantInvitesActions.this.dismiss();
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ String $inviteUrl;

        public AnonymousClass3(String str) {
            this.$inviteUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextX = outline.x(view, "it", "it.context");
            String str = this.$inviteUrl;
            IntentUtils.performChooserSendIntent(contextX, str, FormatUtils.k(WidgetServerSettingsInstantInvitesActions.this, R.string.share_invite_mobile, new Object[]{str}, null, 4));
            WidgetServerSettingsInstantInvitesActions.this.dismiss();
        }
    }

    public WidgetServerSettingsInstantInvitesActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsInstantInvitesActions2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$handleInviteRevoked(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions, ModelInvite modelInvite) {
        widgetServerSettingsInstantInvitesActions.handleInviteRevoked(modelInvite);
    }

    public static final void create(FragmentManager fragmentManager, String str) {
        INSTANCE.create(fragmentManager, str);
    }

    private final WidgetServerSettingsInstantInviteActionsBinding getBinding() {
        return (WidgetServerSettingsInstantInviteActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleInviteRevoked(ModelInvite invite) {
        StoreStream.INSTANCE.getInstantInvites().onInviteRemoved(invite);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_server_settings_instant_invite_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String string = getArgumentsOrDefault().getString(ARG_INVITE_CODE);
        if (string == null || StringsJVM.isBlank(string)) {
            dismiss();
            return;
        }
        String strCreateLinkFromCode = InviteUtils.INSTANCE.createLinkFromCode(string, null);
        if (string.length() == 0) {
            TextView textView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteActionsTitle");
            textView.setVisibility(8);
        } else {
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteActionsTitle");
            textView2.setText(string);
        }
        getBinding().c.setOnClickListener(new AnonymousClass1(string));
        getBinding().f2573b.setOnClickListener(new AnonymousClass2(strCreateLinkFromCode));
        getBinding().d.setOnClickListener(new AnonymousClass3(strCreateLinkFromCode));
    }
}
