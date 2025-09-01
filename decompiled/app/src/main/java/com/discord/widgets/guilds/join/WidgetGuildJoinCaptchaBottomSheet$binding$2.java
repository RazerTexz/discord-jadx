package com.discord.widgets.guilds.join;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetGuildJoinCaptchaBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildJoinCaptchaBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildJoinCaptchaBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildJoinCaptchaBottomSheet$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildJoinCaptchaBottomSheetBinding> {
    public static final WidgetGuildJoinCaptchaBottomSheet$binding$2 INSTANCE = new WidgetGuildJoinCaptchaBottomSheet$binding$2();

    public WidgetGuildJoinCaptchaBottomSheet$binding$2() {
        super(1, WidgetGuildJoinCaptchaBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildJoinCaptchaBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildJoinCaptchaBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildJoinCaptchaBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_join_captcha_body;
        TextView textView = (TextView) view.findViewById(R.id.guild_join_captcha_body);
        if (textView != null) {
            i = R.id.guild_join_captcha_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_join_captcha_button);
            if (materialButton != null) {
                i = R.id.guild_join_captcha_image;
                ImageView imageView = (ImageView) view.findViewById(R.id.guild_join_captcha_image);
                if (imageView != null) {
                    i = R.id.guild_join_captcha_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.guild_join_captcha_title);
                    if (textView2 != null) {
                        return new WidgetGuildJoinCaptchaBottomSheetBinding((NestedScrollView) view, textView, materialButton, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
