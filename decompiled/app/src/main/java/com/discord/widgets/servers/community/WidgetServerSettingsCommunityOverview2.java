package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsCommunityOverviewBinding;
import com.discord.views.LoadingButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsCommunityOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityOverview2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsCommunityOverviewBinding> {
    public static final WidgetServerSettingsCommunityOverview2 INSTANCE = new WidgetServerSettingsCommunityOverview2();

    public WidgetServerSettingsCommunityOverview2() {
        super(1, WidgetServerSettingsCommunityOverviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsCommunityOverviewBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsCommunityOverviewBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.community_rules_channel;
        CommunitySelectorView communitySelectorView = (CommunitySelectorView) view.findViewById(R.id.community_rules_channel);
        if (communitySelectorView != null) {
            i = R.id.community_updates_channel;
            CommunitySelectorView communitySelectorView2 = (CommunitySelectorView) view.findViewById(R.id.community_updates_channel);
            if (communitySelectorView2 != null) {
                i = R.id.server_settings_community_locale;
                CommunitySelectorView communitySelectorView3 = (CommunitySelectorView) view.findViewById(R.id.server_settings_community_locale);
                if (communitySelectorView3 != null) {
                    i = R.id.server_settings_community_overview_scroll;
                    ScrollView scrollView = (ScrollView) view.findViewById(R.id.server_settings_community_overview_scroll);
                    if (scrollView != null) {
                        i = R.id.server_settings_disable_community_button;
                        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.server_settings_disable_community_button);
                        if (loadingButton != null) {
                            i = R.id.server_settings_disable_community_message;
                            CommunitySelectorView communitySelectorView4 = (CommunitySelectorView) view.findViewById(R.id.server_settings_disable_community_message);
                            if (communitySelectorView4 != null) {
                                return new WidgetServerSettingsCommunityOverviewBinding((LinearLayout) view, communitySelectorView, communitySelectorView2, communitySelectorView3, scrollView, loadingButton, communitySelectorView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
