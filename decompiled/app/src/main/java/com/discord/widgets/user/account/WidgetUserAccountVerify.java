package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserAccountVerifyBinding;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import d0.z.d.Intrinsics3;
import d0.z.d.PropertyReference0Impl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetUserAccountVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/user/account/WidgetUserAccountVerify;", "Lcom/discord/widgets/user/account/WidgetUserAccountVerifyBase;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserAccountVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserAccountVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetUserAccountVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/user/account/WidgetUserAccountVerify$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/models/requiredaction/RequiredAction;", "action", "", "launch", "(Landroid/content/Context;Lcom/discord/models/requiredaction/RequiredAction;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, RequiredAction action) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(action, "action");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(WidgetUserAccountVerifyBase.Mode.FORCED, action == RequiredAction.REQUIRE_VERIFIED_PHONE || action == RequiredAction.REQUIRE_VERIFIED_EMAIL || action == RequiredAction.REQUIRE_CAPTCHA, action == RequiredAction.REQUIRE_VERIFIED_EMAIL);
            AnalyticsTracker.openModal$default("Suspicious Activity", "", null, 4, null);
            AppScreen2.d(context, WidgetUserAccountVerify.class, launchIntent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserAccountVerify.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerify$onViewBound$1, reason: invalid class name */
    public final /* synthetic */ class AnonymousClass1 extends PropertyReference0Impl {
        public AnonymousClass1(WidgetUserAccountVerify widgetUserAccountVerify) {
            super(widgetUserAccountVerify, WidgetUserAccountVerify.class, "isForced", "isForced()Z", 0);
        }

        @Override // d0.z.d.PropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return Boolean.valueOf(((WidgetUserAccountVerify) this.receiver).isForced());
        }
    }

    public WidgetUserAccountVerify() {
        super(R.layout.widget_user_account_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserAccountVerify4.INSTANCE, null, 2, null);
    }

    private final WidgetUserAccountVerifyBinding getBinding() {
        return (WidgetUserAccountVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setOnBackPressed$default(this, new WidgetUserAccountVerify5(new AnonymousClass1(this)), 0, 2, null);
        WidgetUserAccountVerifyBinding binding = getBinding();
        TextView textView = binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "verifyAccountTextBody");
        textView.setText(FormatUtils.k(this, R.string.verification_body, new Object[0], null, 4));
        LinkifiedTextView linkifiedTextView = binding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "verifyAccountSupport");
        linkifiedTextView.setText(FormatUtils.k(this, R.string.verification_footer_support, new Object[]{AppHelpDesk.c()}, null, 4));
        RelativeLayout relativeLayout = binding.f2679b;
        relativeLayout.setVisibility(getIsEmailAllowed() ? 0 : 8);
        relativeLayout.setOnClickListener(new WidgetUserAccountVerify2(this));
        RelativeLayout relativeLayout2 = binding.c;
        relativeLayout2.setVisibility(getIsPhoneAllowed() ? 0 : 8);
        relativeLayout2.setOnClickListener(new WidgetUserAccountVerify3(this));
    }
}
