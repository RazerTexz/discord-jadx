package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetVoiceSettingsBottomSheetBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetVoiceSettingsBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceSettingsBottomSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetVoiceSettingsBottomSheetBinding> {
    public static final WidgetVoiceSettingsBottomSheet3 INSTANCE = new WidgetVoiceSettingsBottomSheet3();

    public WidgetVoiceSettingsBottomSheet3() {
        super(1, WidgetVoiceSettingsBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetVoiceSettingsBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetVoiceSettingsBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.voice_settings_events;
        TextView textView = (TextView) view.findViewById(R.id.voice_settings_events);
        if (textView != null) {
            i = R.id.voice_settings_invite;
            TextView textView2 = (TextView) view.findViewById(R.id.voice_settings_invite);
            if (textView2 != null) {
                i = R.id.voice_settings_noise_suppression;
                SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.voice_settings_noise_suppression);
                if (switchMaterial != null) {
                    i = R.id.voice_settings_notifications;
                    TextView textView3 = (TextView) view.findViewById(R.id.voice_settings_notifications);
                    if (textView3 != null) {
                        i = R.id.voice_settings_report;
                        TextView textView4 = (TextView) view.findViewById(R.id.voice_settings_report);
                        if (textView4 != null) {
                            NestedScrollView nestedScrollView = (NestedScrollView) view;
                            i = R.id.voice_settings_stage_settings;
                            TextView textView5 = (TextView) view.findViewById(R.id.voice_settings_stage_settings);
                            if (textView5 != null) {
                                i = R.id.voice_settings_toggle_video_participants;
                                SwitchMaterial switchMaterial2 = (SwitchMaterial) view.findViewById(R.id.voice_settings_toggle_video_participants);
                                if (switchMaterial2 != null) {
                                    i = R.id.voice_settings_voice_settings;
                                    TextView textView6 = (TextView) view.findViewById(R.id.voice_settings_voice_settings);
                                    if (textView6 != null) {
                                        return new WidgetVoiceSettingsBottomSheetBinding(nestedScrollView, textView, textView2, switchMaterial, textView3, textView4, nestedScrollView, textView5, switchMaterial2, textView6);
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
