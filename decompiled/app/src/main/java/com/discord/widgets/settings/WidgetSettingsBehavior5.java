package com.discord.widgets.settings;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsBehaviorBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsBehavior$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsBehavior5 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsBehaviorBinding> {
    public static final WidgetSettingsBehavior5 INSTANCE = new WidgetSettingsBehavior5();

    public WidgetSettingsBehavior5() {
        super(1, WidgetSettingsBehaviorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsBehaviorBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsBehaviorBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.settings_behavior_browser_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_behavior_browser_switch);
        if (checkedSetting != null) {
            i = R.id.settings_behavior_chat_header;
            TextView textView = (TextView) view.findViewById(R.id.settings_behavior_chat_header);
            if (textView != null) {
                i = R.id.settings_behavior_dev_mode_switch;
                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.settings_behavior_dev_mode_switch);
                if (checkedSetting2 != null) {
                    i = R.id.settings_behavior_keyboard_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.settings_behavior_keyboard_header);
                    if (textView2 != null) {
                        i = R.id.settings_behavior_shift_send_toggle;
                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.settings_behavior_shift_send_toggle);
                        if (checkedSetting3 != null) {
                            return new WidgetSettingsBehaviorBinding((CoordinatorLayout) view, checkedSetting, textView, checkedSetting2, textView2, checkedSetting3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
