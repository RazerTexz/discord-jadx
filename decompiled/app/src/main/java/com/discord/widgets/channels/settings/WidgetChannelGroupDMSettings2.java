package com.discord.widgets.channels.settings;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetChannelGroupDmSettingsBinding;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelGroupDMSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.settings.WidgetChannelGroupDMSettings$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelGroupDMSettings2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelGroupDmSettingsBinding> {
    public static final WidgetChannelGroupDMSettings2 INSTANCE = new WidgetChannelGroupDMSettings2();

    public WidgetChannelGroupDMSettings2() {
        super(1, WidgetChannelGroupDmSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelGroupDmSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelGroupDmSettingsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelGroupDmSettingsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_settings_edit_name;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.channel_settings_edit_name);
        if (textInputLayout != null) {
            i = R.id.channel_settings_save;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.channel_settings_save);
            if (floatingActionButton != null) {
                i = R.id.group_dm_notifications_mute_settings_view;
                NotificationMuteSettingsView notificationMuteSettingsView = (NotificationMuteSettingsView) view.findViewById(R.id.group_dm_notifications_mute_settings_view);
                if (notificationMuteSettingsView != null) {
                    i = R.id.group_dm_settings_scroll_view;
                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.group_dm_settings_scroll_view);
                    if (nestedScrollView != null) {
                        i = R.id.settings_group_icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.settings_group_icon);
                        if (simpleDraweeView != null) {
                            i = R.id.settings_group_icon_label;
                            TextView textView = (TextView) view.findViewById(R.id.settings_group_icon_label);
                            if (textView != null) {
                                i = R.id.settings_group_icon_remove;
                                TextView textView2 = (TextView) view.findViewById(R.id.settings_group_icon_remove);
                                if (textView2 != null) {
                                    return new WidgetChannelGroupDmSettingsBinding((CoordinatorLayout) view, textInputLayout, floatingActionButton, notificationMuteSettingsView, nestedScrollView, simpleDraweeView, textView, textView2);
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
