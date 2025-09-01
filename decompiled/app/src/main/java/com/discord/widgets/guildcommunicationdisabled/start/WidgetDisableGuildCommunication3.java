package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetDisableGuildCommunicationBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetDisableGuildCommunication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetDisableGuildCommunication3 extends FunctionReferenceImpl implements Function1<View, WidgetDisableGuildCommunicationBinding> {
    public static final WidgetDisableGuildCommunication3 INSTANCE = new WidgetDisableGuildCommunication3();

    public WidgetDisableGuildCommunication3() {
        super(1, WidgetDisableGuildCommunicationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDisableGuildCommunicationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDisableGuildCommunicationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.disable_confirm;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.disable_confirm);
        if (materialButton != null) {
            i = R.id.disable_guild_communication_body;
            TextView textView = (TextView) view.findViewById(R.id.disable_guild_communication_body);
            if (textView != null) {
                i = R.id.disable_guild_communication_options;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.disable_guild_communication_options);
                if (linearLayout != null) {
                    i = R.id.disable_guild_communication_reason;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.disable_guild_communication_reason);
                    if (textInputLayout != null) {
                        i = R.id.disable_guild_communication_reason_header;
                        TextView textView2 = (TextView) view.findViewById(R.id.disable_guild_communication_reason_header);
                        if (textView2 != null) {
                            i = R.id.disable_guild_communication_subtitle;
                            TextView textView3 = (TextView) view.findViewById(R.id.disable_guild_communication_subtitle);
                            if (textView3 != null) {
                                i = R.id.disable_guild_communication_title;
                                TextView textView4 = (TextView) view.findViewById(R.id.disable_guild_communication_title);
                                if (textView4 != null) {
                                    i = R.id.divider;
                                    View viewFindViewById = view.findViewById(R.id.divider);
                                    if (viewFindViewById != null) {
                                        i = R.id.label_duration;
                                        TextView textView5 = (TextView) view.findViewById(R.id.label_duration);
                                        if (textView5 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i = R.id.time_unit_10_minutes;
                                            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.time_unit_10_minutes);
                                            if (checkedSetting != null) {
                                                i = R.id.time_unit_1_day;
                                                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.time_unit_1_day);
                                                if (checkedSetting2 != null) {
                                                    i = R.id.time_unit_1_hour;
                                                    CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.time_unit_1_hour);
                                                    if (checkedSetting3 != null) {
                                                        i = R.id.time_unit_1_week;
                                                        CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.time_unit_1_week);
                                                        if (checkedSetting4 != null) {
                                                            i = R.id.time_unit_5_minutes;
                                                            CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.time_unit_5_minutes);
                                                            if (checkedSetting5 != null) {
                                                                i = R.id.time_unit_60_seconds;
                                                                CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R.id.time_unit_60_seconds);
                                                                if (checkedSetting6 != null) {
                                                                    return new WidgetDisableGuildCommunicationBinding(constraintLayout, materialButton, textView, linearLayout, textInputLayout, textView2, textView3, textView4, viewFindViewById, textView5, constraintLayout, checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5, checkedSetting6);
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
