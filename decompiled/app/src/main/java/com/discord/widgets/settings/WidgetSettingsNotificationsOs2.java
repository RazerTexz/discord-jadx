package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsNotificationOsBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsNotificationsOs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsNotificationsOs2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsNotificationOsBinding> {
    public static final WidgetSettingsNotificationsOs2 INSTANCE = new WidgetSettingsNotificationsOs2();

    public WidgetSettingsNotificationsOs2() {
        super(1, WidgetSettingsNotificationOsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsNotificationOsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsNotificationOsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.settings_inapp_notifs_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_inapp_notifs_switch);
        if (checkedSetting != null) {
            i = R.id.settings_notification_os;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.settings_notification_os);
            if (relativeLayout != null) {
                i = R.id.settings_notification_os_label;
                TextView textView = (TextView) view.findViewById(R.id.settings_notification_os_label);
                if (textView != null) {
                    i = R.id.settings_notification_switch;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.settings_notification_switch);
                    if (checkedSetting2 != null) {
                        return new WidgetSettingsNotificationOsBinding((LinearLayout) view, checkedSetting, relativeLayout, textView, checkedSetting2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
