package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsBehaviorBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetSettingsBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsBehavior;", "Lcom/discord/app/AppFragment;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsBehavior extends AppFragment {
    private static final String API_LINK = "https://discord.com/developers/docs/intro";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsBehavior.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetSettingsBehavior.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/settings/WidgetSettingsBehavior$Companion;", "", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;)V", "", "API_LINK", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsBehavior.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetSettingsBehavior() {
        super(R.layout.widget_settings_behavior);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsBehavior5.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsBehaviorBinding getBinding() {
        return (WidgetSettingsBehaviorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.form_label_mobile_notifications_behavior);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        CheckedSetting checkedSetting = getBinding().f;
        checkedSetting.setChecked(userSettings.getIsShiftEnterToSendEnabled());
        checkedSetting.setOnCheckedListener(new WidgetSettingsBehavior2(userSettings));
        CheckedSetting checkedSetting2 = getBinding().d;
        checkedSetting2.setChecked(userSettings.getIsDeveloperMode());
        Context context = checkedSetting2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        FormatUtils.h(context, R.string.developer_mode_help_text, new Object[]{API_LINK}, null, 4);
        Context context2 = checkedSetting2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        checkedSetting2.h(FormatUtils.h(context2, R.string.developer_mode_help_text, new Object[]{API_LINK}, null, 4), false);
        checkedSetting2.setSubtextOnClickListener(new WidgetSettingsBehavior6(checkedSetting2));
        checkedSetting2.setOnCheckedListener(new WidgetSettingsBehavior3(this, userSettings));
        CheckedSetting checkedSetting3 = getBinding().f2605b;
        checkedSetting3.setChecked(userSettings.getIsChromeCustomTabsEnabled());
        checkedSetting3.setOnCheckedListener(new WidgetSettingsBehavior4(userSettings));
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().e, getBinding().c})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
