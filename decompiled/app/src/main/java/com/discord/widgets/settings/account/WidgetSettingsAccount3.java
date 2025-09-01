package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.LottieAnimationView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsAccountBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsAccount.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsAccountBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccount3 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountBinding> {
    public static final WidgetSettingsAccount3 INSTANCE = new WidgetSettingsAccount3();

    public WidgetSettingsAccount3() {
        super(1, WidgetSettingsAccountBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.settings_account_2fa_header;
            TextView textView = (TextView) view.findViewById(R.id.settings_account_2fa_header);
            if (textView != null) {
                i = R.id.settings_account_change_password;
                TextView textView2 = (TextView) view.findViewById(R.id.settings_account_change_password);
                if (textView2 != null) {
                    i = R.id.settings_account_email_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.settings_account_email_container);
                    if (linearLayout != null) {
                        i = R.id.settings_account_email_label;
                        TextView textView3 = (TextView) view.findViewById(R.id.settings_account_email_label);
                        if (textView3 != null) {
                            i = R.id.settings_account_email_text;
                            TextView textView4 = (TextView) view.findViewById(R.id.settings_account_email_text);
                            if (textView4 != null) {
                                i = R.id.settings_account_information_data_wrap;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.settings_account_information_data_wrap);
                                if (linearLayout2 != null) {
                                    i = R.id.settings_account_information_header;
                                    TextView textView5 = (TextView) view.findViewById(R.id.settings_account_information_header);
                                    if (textView5 != null) {
                                        i = R.id.settings_account_management_header;
                                        TextView textView6 = (TextView) view.findViewById(R.id.settings_account_management_header);
                                        if (textView6 != null) {
                                            i = R.id.settings_account_mfa_container;
                                            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.settings_account_mfa_container);
                                            if (linearLayout3 != null) {
                                                i = R.id.settings_account_mfa_disabled_container;
                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.settings_account_mfa_disabled_container);
                                                if (linearLayout4 != null) {
                                                    i = R.id.settings_account_mfa_enable;
                                                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.settings_account_mfa_enable);
                                                    if (materialButton != null) {
                                                        i = R.id.settings_account_mfa_enabled_container;
                                                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.settings_account_mfa_enabled_container);
                                                        if (linearLayout5 != null) {
                                                            i = R.id.settings_account_mfa_enabled_header;
                                                            TextView textView7 = (TextView) view.findViewById(R.id.settings_account_mfa_enabled_header);
                                                            if (textView7 != null) {
                                                                i = R.id.settings_account_mfa_flipper;
                                                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.settings_account_mfa_flipper);
                                                                if (appViewFlipper != null) {
                                                                    i = R.id.settings_account_mfa_lottie;
                                                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.settings_account_mfa_lottie);
                                                                    if (lottieAnimationView != null) {
                                                                        i = R.id.settings_account_mfa_sales_pitch;
                                                                        TextView textView8 = (TextView) view.findViewById(R.id.settings_account_mfa_sales_pitch);
                                                                        if (textView8 != null) {
                                                                            i = R.id.settings_account_name_container;
                                                                            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.settings_account_name_container);
                                                                            if (linearLayout6 != null) {
                                                                                i = R.id.settings_account_name_label;
                                                                                TextView textView9 = (TextView) view.findViewById(R.id.settings_account_name_label);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.settings_account_name_text;
                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.settings_account_name_text);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.settings_account_phone_container;
                                                                                        LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.settings_account_phone_container);
                                                                                        if (linearLayout7 != null) {
                                                                                            i = R.id.settings_account_phone_label;
                                                                                            TextView textView11 = (TextView) view.findViewById(R.id.settings_account_phone_label);
                                                                                            if (textView11 != null) {
                                                                                                i = R.id.settings_account_phone_text;
                                                                                                TextView textView12 = (TextView) view.findViewById(R.id.settings_account_phone_text);
                                                                                                if (textView12 != null) {
                                                                                                    i = R.id.settings_account_private_data_delete;
                                                                                                    TextView textView13 = (TextView) view.findViewById(R.id.settings_account_private_data_delete);
                                                                                                    if (textView13 != null) {
                                                                                                        i = R.id.settings_account_private_data_disable;
                                                                                                        TextView textView14 = (TextView) view.findViewById(R.id.settings_account_private_data_disable);
                                                                                                        if (textView14 != null) {
                                                                                                            i = R.id.settings_account_private_data_wrap;
                                                                                                            LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.settings_account_private_data_wrap);
                                                                                                            if (linearLayout8 != null) {
                                                                                                                i = R.id.settings_account_remove_two_fa;
                                                                                                                TextView textView15 = (TextView) view.findViewById(R.id.settings_account_remove_two_fa);
                                                                                                                if (textView15 != null) {
                                                                                                                    i = R.id.settings_account_scroll;
                                                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.settings_account_scroll);
                                                                                                                    if (nestedScrollView != null) {
                                                                                                                        i = R.id.settings_account_sms_backup;
                                                                                                                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_account_sms_backup);
                                                                                                                        if (checkedSetting != null) {
                                                                                                                            i = R.id.settings_account_sms_phone;
                                                                                                                            TextView textView16 = (TextView) view.findViewById(R.id.settings_account_sms_phone);
                                                                                                                            if (textView16 != null) {
                                                                                                                                i = R.id.settings_account_tag_container;
                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) view.findViewById(R.id.settings_account_tag_container);
                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                    i = R.id.settings_account_tag_label;
                                                                                                                                    TextView textView17 = (TextView) view.findViewById(R.id.settings_account_tag_label);
                                                                                                                                    if (textView17 != null) {
                                                                                                                                        i = R.id.settings_account_tag_text;
                                                                                                                                        TextView textView18 = (TextView) view.findViewById(R.id.settings_account_tag_text);
                                                                                                                                        if (textView18 != null) {
                                                                                                                                            i = R.id.settings_account_verification;
                                                                                                                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.settings_account_verification);
                                                                                                                                            if (relativeLayout != null) {
                                                                                                                                                i = R.id.settings_account_verification_button;
                                                                                                                                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.settings_account_verification_button);
                                                                                                                                                if (materialButton2 != null) {
                                                                                                                                                    i = R.id.settings_account_verification_title;
                                                                                                                                                    TextView textView19 = (TextView) view.findViewById(R.id.settings_account_verification_title);
                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                        i = R.id.settings_account_view_backup_codes;
                                                                                                                                                        TextView textView20 = (TextView) view.findViewById(R.id.settings_account_view_backup_codes);
                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                            i = R.id.settings_blocked_users;
                                                                                                                                                            TextView textView21 = (TextView) view.findViewById(R.id.settings_blocked_users);
                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                return new WidgetSettingsAccountBinding((CoordinatorLayout) view, dimmerView, textView, textView2, linearLayout, textView3, textView4, linearLayout2, textView5, textView6, linearLayout3, linearLayout4, materialButton, linearLayout5, textView7, appViewFlipper, lottieAnimationView, textView8, linearLayout6, textView9, textView10, linearLayout7, textView11, textView12, textView13, textView14, linearLayout8, textView15, nestedScrollView, checkedSetting, textView16, linearLayout9, textView17, textView18, relativeLayout, materialButton2, textView19, textView20, textView21);
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
