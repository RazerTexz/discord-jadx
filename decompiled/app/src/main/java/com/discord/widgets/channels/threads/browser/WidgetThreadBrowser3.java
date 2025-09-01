package com.discord.widgets.channels.threads.browser;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetThreadBrowserBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetThreadBrowser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetThreadBrowserBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowser3 extends FunctionReferenceImpl implements Function1<View, WidgetThreadBrowserBinding> {
    public static final WidgetThreadBrowser3 INSTANCE = new WidgetThreadBrowser3();

    public WidgetThreadBrowser3() {
        super(1, WidgetThreadBrowserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadBrowserBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_tabs;
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.action_bar_tabs);
        if (tabLayout != null) {
            i = R.id.thread_browser_toolbar;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.thread_browser_toolbar);
            if (appBarLayout != null) {
                i = R.id.thread_browser_view_pager;
                SimplePager simplePager = (SimplePager) view.findViewById(R.id.thread_browser_view_pager);
                if (simplePager != null) {
                    return new WidgetThreadBrowserBinding((ConstraintLayout) view, tabLayout, appBarLayout, simplePager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
