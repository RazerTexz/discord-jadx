package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsPrivacyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsPrivacy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsPrivacyBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsPrivacyBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsPrivacy$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsPrivacyBinding> {
    public static final WidgetSettingsPrivacy$binding$2 INSTANCE = new WidgetSettingsPrivacy$binding$2();

    public WidgetSettingsPrivacy$binding$2() {
        super(1, WidgetSettingsPrivacyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsPrivacyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsPrivacyBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsPrivacyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.contact_sync_setting_email;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.contact_sync_setting_email);
        if (checkedSetting != null) {
            i = R.id.contact_sync_setting_enabled;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.contact_sync_setting_enabled);
            if (checkedSetting2 != null) {
                i = R.id.contact_sync_setting_info;
                TextView textView = (TextView) view.findViewById(R.id.contact_sync_setting_info);
                if (textView != null) {
                    i = R.id.contact_sync_setting_phone;
                    CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.contact_sync_setting_phone);
                    if (checkedSetting3 != null) {
                        i = R.id.contact_sync_setting_staff_only;
                        CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.contact_sync_setting_staff_only);
                        if (checkedSetting4 != null) {
                            i = R.id.dimmer_view;
                            DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                            if (dimmerView != null) {
                                i = R.id.request_data_link;
                                TextView textView2 = (TextView) view.findViewById(R.id.request_data_link);
                                if (textView2 != null) {
                                    i = R.id.settings_privacy_basic_service;
                                    CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.settings_privacy_basic_service);
                                    if (checkedSetting5 != null) {
                                        i = R.id.settings_privacy_contact_sync;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.settings_privacy_contact_sync);
                                        if (linearLayout != null) {
                                            i = R.id.settings_privacy_contact_sync_title;
                                            TextView textView3 = (TextView) view.findViewById(R.id.settings_privacy_contact_sync_title);
                                            if (textView3 != null) {
                                                i = R.id.settings_privacy_controls;
                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.settings_privacy_controls);
                                                if (linearLayout2 != null) {
                                                    i = R.id.settings_privacy_data_header;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.settings_privacy_data_header);
                                                    if (textView4 != null) {
                                                        i = R.id.settings_privacy_default_restricted_guilds;
                                                        CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R.id.settings_privacy_default_restricted_guilds);
                                                        if (checkedSetting6 != null) {
                                                            i = R.id.settings_privacy_defaults_header;
                                                            TextView textView5 = (TextView) view.findViewById(R.id.settings_privacy_defaults_header);
                                                            if (textView5 != null) {
                                                                i = R.id.settings_privacy_explicit_0;
                                                                CheckedSetting checkedSetting7 = (CheckedSetting) view.findViewById(R.id.settings_privacy_explicit_0);
                                                                if (checkedSetting7 != null) {
                                                                    i = R.id.settings_privacy_explicit_1;
                                                                    CheckedSetting checkedSetting8 = (CheckedSetting) view.findViewById(R.id.settings_privacy_explicit_1);
                                                                    if (checkedSetting8 != null) {
                                                                        i = R.id.settings_privacy_explicit_2;
                                                                        CheckedSetting checkedSetting9 = (CheckedSetting) view.findViewById(R.id.settings_privacy_explicit_2);
                                                                        if (checkedSetting9 != null) {
                                                                            i = R.id.settings_privacy_friend_source_0;
                                                                            CheckedSetting checkedSetting10 = (CheckedSetting) view.findViewById(R.id.settings_privacy_friend_source_0);
                                                                            if (checkedSetting10 != null) {
                                                                                i = R.id.settings_privacy_friend_source_1;
                                                                                CheckedSetting checkedSetting11 = (CheckedSetting) view.findViewById(R.id.settings_privacy_friend_source_1);
                                                                                if (checkedSetting11 != null) {
                                                                                    i = R.id.settings_privacy_friend_source_2;
                                                                                    CheckedSetting checkedSetting12 = (CheckedSetting) view.findViewById(R.id.settings_privacy_friend_source_2);
                                                                                    if (checkedSetting12 != null) {
                                                                                        i = R.id.settings_privacy_friend_source_header;
                                                                                        TextView textView6 = (TextView) view.findViewById(R.id.settings_privacy_friend_source_header);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.settings_privacy_personalization;
                                                                                            CheckedSetting checkedSetting13 = (CheckedSetting) view.findViewById(R.id.settings_privacy_personalization);
                                                                                            if (checkedSetting13 != null) {
                                                                                                i = R.id.settings_privacy_request_data;
                                                                                                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.settings_privacy_request_data);
                                                                                                if (materialButton != null) {
                                                                                                    i = R.id.settings_privacy_safe_messaging_header;
                                                                                                    TextView textView7 = (TextView) view.findViewById(R.id.settings_privacy_safe_messaging_header);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.settings_privacy_screenreader_detection;
                                                                                                        CheckedSetting checkedSetting14 = (CheckedSetting) view.findViewById(R.id.settings_privacy_screenreader_detection);
                                                                                                        if (checkedSetting14 != null) {
                                                                                                            i = R.id.settings_privacy_statistics;
                                                                                                            CheckedSetting checkedSetting15 = (CheckedSetting) view.findViewById(R.id.settings_privacy_statistics);
                                                                                                            if (checkedSetting15 != null) {
                                                                                                                return new WidgetSettingsPrivacyBinding((CoordinatorLayout) view, checkedSetting, checkedSetting2, textView, checkedSetting3, checkedSetting4, dimmerView, textView2, checkedSetting5, linearLayout, textView3, linearLayout2, textView4, checkedSetting6, textView5, checkedSetting7, checkedSetting8, checkedSetting9, checkedSetting10, checkedSetting11, checkedSetting12, textView6, checkedSetting13, materialButton, textView7, checkedSetting14, checkedSetting15);
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
