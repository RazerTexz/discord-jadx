package com.discord.widgets.guilds.create;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.a.i.LayoutIconUploaderBinding;
import com.discord.R;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildCreate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetGuildCreateBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCreateBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildCreate2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildCreateBinding> {
    public static final WidgetGuildCreate2 INSTANCE = new WidgetGuildCreate2();

    public WidgetGuildCreate2() {
        super(1, WidgetGuildCreateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCreateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildCreateBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildCreateBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_create_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.guild_create_button);
        if (loadingButton != null) {
            i = R.id.guild_create_guidelines;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.guild_create_guidelines);
            if (linkifiedTextView != null) {
                i = R.id.guild_create_icon_uploader;
                View viewFindViewById = view.findViewById(R.id.guild_create_icon_uploader);
                if (viewFindViewById != null) {
                    LayoutIconUploaderBinding layoutIconUploaderBindingA = LayoutIconUploaderBinding.a(viewFindViewById);
                    i = R.id.guild_create_name;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_create_name);
                    if (textInputLayout != null) {
                        i = R.id.guild_create_screen_title;
                        ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.guild_create_screen_title);
                        if (screenTitleView != null) {
                            return new WidgetGuildCreateBinding((CoordinatorLayout) view, loadingButton, linkifiedTextView, layoutIconUploaderBindingA, textInputLayout, screenTitleView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
