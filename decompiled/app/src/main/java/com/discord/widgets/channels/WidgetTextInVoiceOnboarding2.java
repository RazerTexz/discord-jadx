package com.discord.widgets.channels;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetTextInVoiceOnboarding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetTextInVoiceOnboarding2 extends FunctionReferenceImpl implements Function1<View, WidgetTextInVoiceOnboardingBinding> {
    public static final WidgetTextInVoiceOnboarding2 INSTANCE = new WidgetTextInVoiceOnboarding2();

    public WidgetTextInVoiceOnboarding2() {
        super(1, WidgetTextInVoiceOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetTextInVoiceOnboardingBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetTextInVoiceOnboardingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.text_in_voice_onboarding_close;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.text_in_voice_onboarding_close);
        if (materialButton != null) {
            i = R.id.text_in_voice_onboarding_cta;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.text_in_voice_onboarding_cta);
            if (materialButton2 != null) {
                i = R.id.text_in_voice_onboarding_video;
                VideoView videoView = (VideoView) view.findViewById(R.id.text_in_voice_onboarding_video);
                if (videoView != null) {
                    i = R.id.text_in_voice_onboarding_video_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.text_in_voice_onboarding_video_container);
                    if (frameLayout != null) {
                        i = R.id.text_in_voice_onboarding_video_overlay;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.text_in_voice_onboarding_video_overlay);
                        if (simpleDraweeView != null) {
                            i = R.id.text_in_voice_onboarding_video_placeholder;
                            ImageView imageView = (ImageView) view.findViewById(R.id.text_in_voice_onboarding_video_placeholder);
                            if (imageView != null) {
                                return new WidgetTextInVoiceOnboardingBinding((ConstraintLayout) view, materialButton, materialButton2, videoView, frameLayout, simpleDraweeView, imageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
