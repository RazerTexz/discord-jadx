package com.discord.widgets.settings.account.mfa;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaInputBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetEnableMFAInput.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAInput;", "Lcom/discord/app/AppFragment;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "", "menuVisible", "setMenuVisibility", "(Z)V", "Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFAViewModel;", "viewModel", "Lcom/discord/databinding/WidgetSettingsEnableMfaInputBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsEnableMfaInputBinding;", "binding", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEnableMFAInput extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableMFAInput.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaInputBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetEnableMFAInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "verificationCode", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAInput$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(View view) {
            super(1);
            this.$view = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "verificationCode");
            WidgetEnableMFAViewModel widgetEnableMFAViewModelAccess$getViewModel$p = WidgetEnableMFAInput.access$getViewModel$p(WidgetEnableMFAInput.this);
            Context context = this.$view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            widgetEnableMFAViewModelAccess$getViewModel$p.enableMFA(context, str);
        }
    }

    public WidgetEnableMFAInput() {
        super(R.layout.widget_settings_enable_mfa_input);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableMFAInput2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new WidgetEnableMFAInput$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetEnableMFAInput3.INSTANCE));
    }

    public static final /* synthetic */ WidgetEnableMFAViewModel access$getViewModel$p(WidgetEnableMFAInput widgetEnableMFAInput) {
        return widgetEnableMFAInput.getViewModel();
    }

    private final WidgetSettingsEnableMfaInputBinding getBinding() {
        return (WidgetSettingsEnableMfaInputBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2617b.setOnCodeEntered(new AnonymousClass1(view));
    }

    @Override // androidx.fragment.app.Fragment
    public void setMenuVisibility(boolean menuVisible) {
        Context context;
        ClipData primaryClip;
        super.setMenuVisibility(menuVisible);
        if (!menuVisible || (context = getContext()) == null) {
            return;
        }
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
        if (primaryClip.getItemCount() > 0) {
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            Intrinsics3.checkNotNullExpressionValue(itemAt, "clipData.getItemAt(0)");
            CharSequence text = itemAt.getText();
            if (text != null && text.length() == 6 && TextUtils.isDigitsOnly(text)) {
                getBinding().f2617b.setCode(text);
            }
        }
    }
}
