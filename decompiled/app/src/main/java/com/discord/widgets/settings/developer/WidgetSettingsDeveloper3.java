package com.discord.widgets.settings.developer;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsDeveloperBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsDeveloper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsDeveloper3 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsDeveloperBinding> {
    public static final WidgetSettingsDeveloper3 INSTANCE = new WidgetSettingsDeveloper3();

    public WidgetSettingsDeveloper3() {
        super(1, WidgetSettingsDeveloperBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsDeveloperBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsDeveloperBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsDeveloperBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.developer_settings_crash_discord_jnibridge;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.developer_settings_crash_discord_jnibridge);
        if (materialButton != null) {
            i = R.id.developer_settings_crash_discord_nonfatal;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.developer_settings_crash_discord_nonfatal);
            if (materialButton2 != null) {
                i = R.id.developer_settings_crash_kotlin;
                MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.developer_settings_crash_kotlin);
                if (materialButton3 != null) {
                    i = R.id.developer_settings_experiments;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.developer_settings_experiments);
                    if (recyclerView != null) {
                        i = R.id.developer_settings_notices;
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.developer_settings_notices);
                        if (recyclerView2 != null) {
                            i = R.id.developer_settings_simulate_gateway_reconnect;
                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(R.id.developer_settings_simulate_gateway_reconnect);
                            if (materialButton4 != null) {
                                i = R.id.settings_developer_screenshot_bug_reporting;
                                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_developer_screenshot_bug_reporting);
                                if (checkedSetting != null) {
                                    i = R.id.textView;
                                    TextView textView = (TextView) view.findViewById(R.id.textView);
                                    if (textView != null) {
                                        return new WidgetSettingsDeveloperBinding((CoordinatorLayout) view, materialButton, materialButton2, materialButton3, recyclerView, recyclerView2, materialButton4, checkedSetting, textView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
