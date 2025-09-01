package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsOverviewAfkTimeoutBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$AfkBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsOverview4 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsOverviewAfkTimeoutBinding> {
    public static final WidgetServerSettingsOverview4 INSTANCE = new WidgetServerSettingsOverview4();

    public WidgetServerSettingsOverview4() {
        super(1, WidgetServerSettingsOverviewAfkTimeoutBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsOverviewAfkTimeoutBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = R.id.server_settings_overview_afk_timeout_01;
            TextView textView2 = (TextView) view.findViewById(R.id.server_settings_overview_afk_timeout_01);
            if (textView2 != null) {
                i = R.id.server_settings_overview_afk_timeout_05;
                TextView textView3 = (TextView) view.findViewById(R.id.server_settings_overview_afk_timeout_05);
                if (textView3 != null) {
                    i = R.id.server_settings_overview_afk_timeout_15;
                    TextView textView4 = (TextView) view.findViewById(R.id.server_settings_overview_afk_timeout_15);
                    if (textView4 != null) {
                        i = R.id.server_settings_overview_afk_timeout_30;
                        TextView textView5 = (TextView) view.findViewById(R.id.server_settings_overview_afk_timeout_30);
                        if (textView5 != null) {
                            i = R.id.server_settings_overview_afk_timeout_60;
                            TextView textView6 = (TextView) view.findViewById(R.id.server_settings_overview_afk_timeout_60);
                            if (textView6 != null) {
                                return new WidgetServerSettingsOverviewAfkTimeoutBinding((NestedScrollView) view, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsOverviewAfkTimeoutBinding invoke(View view) {
        return invoke2(view);
    }
}
