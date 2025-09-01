package com.discord.widgets.settings.account.mfa;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaDownloadBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* compiled from: WidgetEnableMFADownload.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/settings/account/mfa/WidgetEnableMFADownload;", "Lcom/discord/app/AppFragment;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetSettingsEnableMfaDownloadBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsEnableMfaDownloadBinding;", "binding", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEnableMFADownload extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableMFADownload.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaDownloadBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetEnableMFADownload() {
        super(R.layout.widget_settings_enable_mfa_download);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableMFADownload2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsEnableMfaDownloadBinding getBinding() {
        return (WidgetSettingsEnableMfaDownloadBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f2616b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mfaDownloadBody");
        FormatUtils.n(textView, R.string.two_fa_download_app_body, new Object[]{AuthUtils.URL_AUTHY, AuthUtils.URL_GOOGLE_AUTHENTICATOR}, null, 4);
        TextView textView2 = getBinding().f2616b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.mfaDownloadBody");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
