package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsCommunitySetupThirdStepBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsCommunitySetupThirdStepBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunitySetupThirdStepBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityThirdStep2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsCommunitySetupThirdStepBinding> {
    public static final WidgetServerSettingsCommunityThirdStep2 INSTANCE = new WidgetServerSettingsCommunityThirdStep2();

    public WidgetServerSettingsCommunityThirdStep2() {
        super(1, WidgetServerSettingsCommunitySetupThirdStepBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunitySetupThirdStepBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsCommunitySetupThirdStepBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsCommunitySetupThirdStepBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        ScrollView scrollView = (ScrollView) view;
        int i = R.id.community_get_started_header_image;
        ImageView imageView = (ImageView) view.findViewById(R.id.community_get_started_header_image);
        if (imageView != null) {
            i = R.id.community_setting_community_guidelines_switch;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.community_setting_community_guidelines_switch);
            if (checkedSetting != null) {
                i = R.id.community_setting_guidelines;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.community_setting_guidelines);
                if (linkifiedTextView != null) {
                    i = R.id.community_setting_manage_permissions_switch;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.community_setting_manage_permissions_switch);
                    if (checkedSetting2 != null) {
                        i = R.id.community_setting_notifications_to_mentions_switch;
                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.community_setting_notifications_to_mentions_switch);
                        if (checkedSetting3 != null) {
                            i = R.id.community_step_header;
                            ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.community_step_header);
                            if (screenTitleView != null) {
                                return new WidgetServerSettingsCommunitySetupThirdStepBinding((ScrollView) view, scrollView, imageView, checkedSetting, linkifiedTextView, checkedSetting2, checkedSetting3, screenTitleView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
