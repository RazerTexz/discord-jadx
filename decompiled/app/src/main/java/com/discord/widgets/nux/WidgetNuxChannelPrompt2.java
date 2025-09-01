package com.discord.widgets.nux;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.discord.R;
import com.discord.databinding.WidgetNuxChannelPromptBinding;
import com.discord.views.LoadingButton;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetNuxChannelPrompt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetNuxChannelPrompt2 extends FunctionReferenceImpl implements Function1<View, WidgetNuxChannelPromptBinding> {
    public static final WidgetNuxChannelPrompt2 INSTANCE = new WidgetNuxChannelPrompt2();

    public WidgetNuxChannelPrompt2() {
        super(1, WidgetNuxChannelPromptBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNuxChannelPromptBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNuxChannelPromptBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.nuf_channel_prompt_cta_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.nuf_channel_prompt_cta_button);
        if (loadingButton != null) {
            i = R.id.nuf_channel_prompt_guild_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.nuf_channel_prompt_guild_icon);
            if (simpleDraweeView != null) {
                i = R.id.nuf_channel_prompt_guild_icon_name;
                TextView textView = (TextView) view.findViewById(R.id.nuf_channel_prompt_guild_icon_name);
                if (textView != null) {
                    i = R.id.nuf_channel_prompt_guild_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.nuf_channel_prompt_guild_name);
                    if (textView2 != null) {
                        i = R.id.nuf_channel_prompt_skip_button;
                        TextView textView3 = (TextView) view.findViewById(R.id.nuf_channel_prompt_skip_button);
                        if (textView3 != null) {
                            i = R.id.nuf_channel_prompt_topic_wrap;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.nuf_channel_prompt_topic_wrap);
                            if (textInputLayout != null) {
                                i = R.id.toolbar;
                                Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
                                if (toolbar != null) {
                                    return new WidgetNuxChannelPromptBinding((RelativeLayout) view, loadingButton, simpleDraweeView, textView, textView2, textView3, textInputLayout, toolbar);
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
