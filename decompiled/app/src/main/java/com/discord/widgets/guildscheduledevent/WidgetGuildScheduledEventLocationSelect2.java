package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetGuildScheduledEventLocationSelectBinding;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventLocationSelect2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildScheduledEventLocationSelectBinding> {
    public static final WidgetGuildScheduledEventLocationSelect2 INSTANCE = new WidgetGuildScheduledEventLocationSelect2();

    public WidgetGuildScheduledEventLocationSelect2() {
        super(1, WidgetGuildScheduledEventLocationSelectBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventLocationSelectBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildScheduledEventLocationSelectBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_location_input;
        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.channel_location_input);
        if (textInputEditText != null) {
            i = R.id.channel_location_layout;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.channel_location_layout);
            if (textInputLayout != null) {
                i = R.id.close_button;
                ImageView imageView = (ImageView) view.findViewById(R.id.close_button);
                if (imageView != null) {
                    i = R.id.external_divider;
                    View viewFindViewById = view.findViewById(R.id.external_divider);
                    if (viewFindViewById != null) {
                        i = R.id.external_location_input;
                        TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(R.id.external_location_input);
                        if (textInputEditText2 != null) {
                            i = R.id.external_location_layout;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.external_location_layout);
                            if (textInputLayout2 != null) {
                                i = R.id.external_option;
                                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.external_option);
                                if (checkedSetting != null) {
                                    i = R.id.guild_scheduled_event_settings_scroll_view;
                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.guild_scheduled_event_settings_scroll_view);
                                    if (nestedScrollView != null) {
                                        i = R.id.location_header;
                                        TextView textView = (TextView) view.findViewById(R.id.location_header);
                                        if (textView != null) {
                                            i = R.id.location_options;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.location_options);
                                            if (linearLayout != null) {
                                                i = R.id.next_button;
                                                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.next_button);
                                                if (materialButton != null) {
                                                    i = R.id.stage_channel_option;
                                                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.stage_channel_option);
                                                    if (checkedSetting2 != null) {
                                                        i = R.id.step_text;
                                                        TextView textView2 = (TextView) view.findViewById(R.id.step_text);
                                                        if (textView2 != null) {
                                                            i = R.id.title_view;
                                                            ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.title_view);
                                                            if (screenTitleView != null) {
                                                                i = R.id.toolbar;
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.toolbar);
                                                                if (constraintLayout != null) {
                                                                    i = R.id.voice_channel_divider;
                                                                    View viewFindViewById2 = view.findViewById(R.id.voice_channel_divider);
                                                                    if (viewFindViewById2 != null) {
                                                                        i = R.id.voice_channel_option;
                                                                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.voice_channel_option);
                                                                        if (checkedSetting3 != null) {
                                                                            return new WidgetGuildScheduledEventLocationSelectBinding((ConstraintLayout) view, textInputEditText, textInputLayout, imageView, viewFindViewById, textInputEditText2, textInputLayout2, checkedSetting, nestedScrollView, textView, linearLayout, materialButton, checkedSetting2, textView2, screenTitleView, constraintLayout, viewFindViewById2, checkedSetting3);
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
