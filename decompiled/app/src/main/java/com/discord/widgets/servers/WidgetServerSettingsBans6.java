package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsBansBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsBans.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsBansBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsBansBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsBans6 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsBansBinding> {
    public static final WidgetServerSettingsBans6 INSTANCE = new WidgetServerSettingsBans6();

    public WidgetServerSettingsBans6() {
        super(1, WidgetServerSettingsBansBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsBansBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsBansBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsBansBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.no_bans_body;
        TextView textView = (TextView) view.findViewById(R.id.no_bans_body);
        if (textView != null) {
            i = R.id.no_results_text;
            TextView textView2 = (TextView) view.findViewById(R.id.no_results_text);
            if (textView2 != null) {
                i = R.id.server_settings_bans_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_bans_recycler);
                if (recyclerView != null) {
                    i = R.id.server_settings_bans_search;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.server_settings_bans_search);
                    if (textInputLayout != null) {
                        i = R.id.server_settings_bans_view_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_bans_view_flipper);
                        if (appViewFlipper != null) {
                            return new WidgetServerSettingsBansBinding((CoordinatorLayout) view, textView, textView2, recyclerView, textInputLayout, appViewFlipper);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
