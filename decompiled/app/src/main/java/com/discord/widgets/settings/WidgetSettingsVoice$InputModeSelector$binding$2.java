package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsVoiceInputModeBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsVoice.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsVoiceInputModeBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsVoiceInputModeBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsVoice$InputModeSelector$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsVoiceInputModeBinding> {
    public static final WidgetSettingsVoice$InputModeSelector$binding$2 INSTANCE = new WidgetSettingsVoice$InputModeSelector$binding$2();

    public WidgetSettingsVoice$InputModeSelector$binding$2() {
        super(1, WidgetSettingsVoiceInputModeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsVoiceInputModeBinding;", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsVoiceInputModeBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = R.id.settings_voice_input_mode_ptt;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.settings_voice_input_mode_ptt);
            if (linearLayout != null) {
                i = R.id.settings_voice_input_mode_vad;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.settings_voice_input_mode_vad);
                if (linearLayout2 != null) {
                    return new WidgetSettingsVoiceInputModeBinding((NestedScrollView) view, textView, linearLayout, linearLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsVoiceInputModeBinding invoke(View view) {
        return invoke2(view);
    }
}
