package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsChannelsSortActionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsChannelsSortActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsChannelsSortActionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsSortActionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsSortActions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannelsSortActions2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsChannelsSortActionsBinding> {
    public static final WidgetServerSettingsChannelsSortActions2 INSTANCE = new WidgetServerSettingsChannelsSortActions2();

    public WidgetServerSettingsChannelsSortActions2() {
        super(1, WidgetServerSettingsChannelsSortActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsSortActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsChannelsSortActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsChannelsSortActionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = R.id.server_settings_channels_sort_actions_category;
            TextView textView2 = (TextView) view.findViewById(R.id.server_settings_channels_sort_actions_category);
            if (textView2 != null) {
                i = R.id.server_settings_channels_sort_actions_text;
                TextView textView3 = (TextView) view.findViewById(R.id.server_settings_channels_sort_actions_text);
                if (textView3 != null) {
                    i = R.id.server_settings_channels_sort_actions_voice;
                    TextView textView4 = (TextView) view.findViewById(R.id.server_settings_channels_sort_actions_voice);
                    if (textView4 != null) {
                        return new WidgetServerSettingsChannelsSortActionsBinding((NestedScrollView) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
