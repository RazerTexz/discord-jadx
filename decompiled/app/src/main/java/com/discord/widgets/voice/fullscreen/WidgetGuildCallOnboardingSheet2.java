package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildCallOnboardingBinding;
import com.discord.views.JoinVoiceChannelButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildCallOnboardingSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildCallOnboardingBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCallOnboardingBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetGuildCallOnboardingSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildCallOnboardingBinding> {
    public static final WidgetGuildCallOnboardingSheet2 INSTANCE = new WidgetGuildCallOnboardingSheet2();

    public WidgetGuildCallOnboardingSheet2() {
        super(1, WidgetGuildCallOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCallOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildCallOnboardingBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildCallOnboardingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        JoinVoiceChannelButton joinVoiceChannelButton = (JoinVoiceChannelButton) view.findViewById(R.id.guild_call_onboarding_connect);
        if (joinVoiceChannelButton != null) {
            return new WidgetGuildCallOnboardingBinding((LinearLayout) view, joinVoiceChannelButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.guild_call_onboarding_connect)));
    }
}
