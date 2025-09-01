package com.discord.widgets.captcha;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetCaptchaBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCaptcha.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetCaptchaBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.captcha.WidgetCaptcha$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetCaptcha3 extends FunctionReferenceImpl implements Function1<View, WidgetCaptchaBinding> {
    public static final WidgetCaptcha3 INSTANCE = new WidgetCaptcha3();

    public WidgetCaptcha3() {
        super(1, WidgetCaptchaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCaptchaBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCaptchaBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.captcha_help;
        TextView textView = (TextView) view.findViewById(R.id.captcha_help);
        if (textView != null) {
            i = R.id.captcha_verify;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.captcha_verify);
            if (materialButton != null) {
                i = R.id.screen_title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.screen_title);
                if (screenTitleView != null) {
                    return new WidgetCaptchaBinding((CoordinatorLayout) view, textView, materialButton, screenTitleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
