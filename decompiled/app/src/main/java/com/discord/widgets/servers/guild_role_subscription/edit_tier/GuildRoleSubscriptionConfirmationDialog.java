package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.DialogGuiildRoleSubscriptionConfirmationBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00128B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/GuildRoleSubscriptionConfirmationDialog;", "Lcom/discord/app/AppDialog;", "", "onStart", "()V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lkotlin/Function0;", "callback", "setConfirmCallback", "(Lkotlin/jvm/functions/Function0;)V", "confirmCallback", "Lkotlin/jvm/functions/Function0;", "", "isDestructiveOperation", "()Z", "", "getTitle", "()Ljava/lang/String;", "title", "getSubtitle", "subtitle", "getConfirmationButtonText", "confirmationButtonText", "Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(GuildRoleSubscriptionConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT = "INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT";
    private static final String INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION = "INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION";
    private static final String INTENT_EXTRA_SUBTITLE = "INTENT_EXTRA_SUBTITLE";
    private static final String INTENT_EXTRA_TITLE = "INTENT_EXTRA_TITLE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> confirmCallback;

    /* compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JE\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/GuildRoleSubscriptionConfirmationDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "title", "subtitle", "confirmationButtonText", "", "isDestructiveOperation", "Lkotlin/Function0;", "", "confirmCallback", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT, "Ljava/lang/String;", GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION, GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_SUBTITLE, GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_TITLE, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, String str, String str2, String str3, boolean z2, Function0 function0, int i, Object obj) {
            companion.show(fragmentManager, str, str2, str3, (i & 16) != 0 ? false : z2, function0);
        }

        public final void show(FragmentManager fragmentManager, String title, String subtitle, String confirmationButtonText, boolean isDestructiveOperation, Function0<Unit> confirmCallback) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics3.checkNotNullParameter(confirmationButtonText, "confirmationButtonText");
            Intrinsics3.checkNotNullParameter(confirmCallback, "confirmCallback");
            GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog = new GuildRoleSubscriptionConfirmationDialog();
            guildRoleSubscriptionConfirmationDialog.setConfirmCallback(confirmCallback);
            guildRoleSubscriptionConfirmationDialog.setArguments(Bundle2.bundleOf(Tuples.to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_TITLE, title), Tuples.to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_SUBTITLE, subtitle), Tuples.to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT, confirmationButtonText), Tuples.to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION, Boolean.valueOf(isDestructiveOperation))));
            guildRoleSubscriptionConfirmationDialog.show(fragmentManager, GuildRoleSubscriptionConfirmationDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getConfirmCallback$p = GuildRoleSubscriptionConfirmationDialog.access$getConfirmCallback$p(GuildRoleSubscriptionConfirmationDialog.this);
            if (function0Access$getConfirmCallback$p != null) {
            }
            GuildRoleSubscriptionConfirmationDialog.this.dismiss();
        }
    }

    /* compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildRoleSubscriptionConfirmationDialog.this.dismiss();
        }
    }

    public GuildRoleSubscriptionConfirmationDialog() {
        super(R.layout.dialog_guiild_role_subscription_confirmation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, GuildRoleSubscriptionConfirmationDialog2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ Function0 access$getConfirmCallback$p(GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog) {
        return guildRoleSubscriptionConfirmationDialog.confirmCallback;
    }

    public static final /* synthetic */ void access$setConfirmCallback$p(GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog, Function0 function0) {
        guildRoleSubscriptionConfirmationDialog.confirmCallback = function0;
    }

    private final DialogGuiildRoleSubscriptionConfirmationBinding getBinding() {
        return (DialogGuiildRoleSubscriptionConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getConfirmationButtonText() {
        String string = requireArguments().getString(INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT, "");
        Intrinsics3.checkNotNullExpressionValue(string, "requireArguments().getSt…IRMATION_BUTTON_TEXT, \"\")");
        return string;
    }

    private final String getSubtitle() {
        String string = requireArguments().getString(INTENT_EXTRA_SUBTITLE, "");
        Intrinsics3.checkNotNullExpressionValue(string, "requireArguments().getSt…NTENT_EXTRA_SUBTITLE, \"\")");
        return string;
    }

    private final String getTitle() {
        String string = requireArguments().getString(INTENT_EXTRA_TITLE, "");
        Intrinsics3.checkNotNullExpressionValue(string, "requireArguments().getSt…g(INTENT_EXTRA_TITLE, \"\")");
        return string;
    }

    private final boolean isDestructiveOperation() {
        return requireArguments().getBoolean(INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics3.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (this.confirmCallback == null) {
            dismiss();
            return;
        }
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().f2094b.setOnClickListener(new AnonymousClass2());
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionConfirmationTitle");
        textView.setText(getTitle());
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionConfirmationSubtitle");
        textView2.setText(getSubtitle());
        if (isDestructiveOperation()) {
            MaterialButton materialButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "this");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(materialButton, R.color.uikit_btn_bg_color_selector_red)));
            materialButton.setTextColor(ColorCompat.getColor(materialButton, R.color.primary_100));
        }
        MaterialButton materialButton2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.confirm");
        materialButton2.setText(getConfirmationButtonText());
    }

    public final void setConfirmCallback(Function0<Unit> callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        this.confirmCallback = callback;
    }
}
