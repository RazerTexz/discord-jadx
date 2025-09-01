package com.discord.widgets.servers;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ViewAddOverrideItemBinding;
import com.discord.R;
import com.discord.databinding.WidgetServerNotificationsBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerNotificationsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerNotificationsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerNotifications$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerNotifications5 extends FunctionReferenceImpl implements Function1<View, WidgetServerNotificationsBinding> {
    public static final WidgetServerNotifications5 INSTANCE = new WidgetServerNotifications5();

    public WidgetServerNotifications5() {
        super(1, WidgetServerNotificationsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerNotificationsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerNotificationsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerNotificationsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.add_override;
        View viewFindViewById = view.findViewById(R.id.add_override);
        if (viewFindViewById != null) {
            int i2 = R.id.category_overview_name;
            TextView textView = (TextView) viewFindViewById.findViewById(R.id.category_overview_name);
            if (textView != null) {
                i2 = R.id.guideline;
                Guideline guideline = (Guideline) viewFindViewById.findViewById(R.id.guideline);
                if (guideline != null) {
                    i2 = R.id.navigation_indicator;
                    ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.navigation_indicator);
                    if (imageView != null) {
                        ViewAddOverrideItemBinding viewAddOverrideItemBinding = new ViewAddOverrideItemBinding((ConstraintLayout) viewFindViewById, textView, guideline, imageView);
                        i = R.id.guild_notifications_override_list;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.guild_notifications_override_list);
                        if (recyclerView != null) {
                            i = R.id.server_notifications_everyone_switch;
                            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.server_notifications_everyone_switch);
                            if (checkedSetting != null) {
                                i = R.id.server_notifications_frequency_0_radio;
                                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.server_notifications_frequency_0_radio);
                                if (checkedSetting2 != null) {
                                    i = R.id.server_notifications_frequency_1_radio;
                                    CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.server_notifications_frequency_1_radio);
                                    if (checkedSetting3 != null) {
                                        i = R.id.server_notifications_frequency_2_radio;
                                        CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.server_notifications_frequency_2_radio);
                                        if (checkedSetting4 != null) {
                                            i = R.id.server_notifications_frequency_divider;
                                            View viewFindViewById2 = view.findViewById(R.id.server_notifications_frequency_divider);
                                            if (viewFindViewById2 != null) {
                                                i = R.id.server_notifications_frequency_wrap;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.server_notifications_frequency_wrap);
                                                if (linearLayout != null) {
                                                    i = R.id.server_notifications_highlights;
                                                    NotificationHighlightsSettingsView notificationHighlightsSettingsView = (NotificationHighlightsSettingsView) view.findViewById(R.id.server_notifications_highlights);
                                                    if (notificationHighlightsSettingsView != null) {
                                                        i = R.id.server_notifications_highlights_divider;
                                                        View viewFindViewById3 = view.findViewById(R.id.server_notifications_highlights_divider);
                                                        if (viewFindViewById3 != null) {
                                                            i = R.id.server_notifications_mute_settings_view;
                                                            NotificationMuteSettingsView notificationMuteSettingsView = (NotificationMuteSettingsView) view.findViewById(R.id.server_notifications_mute_settings_view);
                                                            if (notificationMuteSettingsView != null) {
                                                                i = R.id.server_notifications_override_divider;
                                                                View viewFindViewById4 = view.findViewById(R.id.server_notifications_override_divider);
                                                                if (viewFindViewById4 != null) {
                                                                    i = R.id.server_notifications_override_title;
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.server_notifications_override_title);
                                                                    if (textView2 != null) {
                                                                        i = R.id.server_notifications_push_switch;
                                                                        CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.server_notifications_push_switch);
                                                                        if (checkedSetting5 != null) {
                                                                            i = R.id.server_notifications_roles_divider;
                                                                            View viewFindViewById5 = view.findViewById(R.id.server_notifications_roles_divider);
                                                                            if (viewFindViewById5 != null) {
                                                                                i = R.id.server_notifications_roles_switch;
                                                                                CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R.id.server_notifications_roles_switch);
                                                                                if (checkedSetting6 != null) {
                                                                                    return new WidgetServerNotificationsBinding((CoordinatorLayout) view, viewAddOverrideItemBinding, recyclerView, checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, viewFindViewById2, linearLayout, notificationHighlightsSettingsView, viewFindViewById3, notificationMuteSettingsView, viewFindViewById4, textView2, checkedSetting5, viewFindViewById5, checkedSetting6);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
