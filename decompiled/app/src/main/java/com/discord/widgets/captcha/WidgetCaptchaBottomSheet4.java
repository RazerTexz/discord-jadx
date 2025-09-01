package com.discord.widgets.captcha;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetCaptchaBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCaptchaBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetCaptchaBottomSheet4 extends FunctionReferenceImpl implements Function1<View, WidgetCaptchaBottomSheetBinding> {
    public static final WidgetCaptchaBottomSheet4 INSTANCE = new WidgetCaptchaBottomSheet4();

    public WidgetCaptchaBottomSheet4() {
        super(1, WidgetCaptchaBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCaptchaBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCaptchaBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.captcha_body;
        TextView textView = (TextView) view.findViewById(R.id.captcha_body);
        if (textView != null) {
            i = R.id.captcha_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.captcha_button);
            if (materialButton != null) {
                i = R.id.captcha_title;
                TextView textView2 = (TextView) view.findViewById(R.id.captcha_title);
                if (textView2 != null) {
                    i = R.id.guild_join_captcha_image;
                    ImageView imageView = (ImageView) view.findViewById(R.id.guild_join_captcha_image);
                    if (imageView != null) {
                        return new WidgetCaptchaBottomSheetBinding((NestedScrollView) view, textView, materialButton, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
