package com.discord.widgets.nux;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetNuxGuildTemplateBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildTemplates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.WidgetGuildTemplates$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildTemplates5 extends FunctionReferenceImpl implements Function1<View, WidgetNuxGuildTemplateBinding> {
    public static final WidgetGuildTemplates5 INSTANCE = new WidgetGuildTemplates5();

    public WidgetGuildTemplates5() {
        super(1, WidgetNuxGuildTemplateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNuxGuildTemplateBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNuxGuildTemplateBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.nux_guild_template_action_join;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.nux_guild_template_action_join);
        if (materialButton != null) {
            i = R.id.nux_guild_template_section_bottom;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.nux_guild_template_section_bottom);
            if (linearLayout != null) {
                i = R.id.nux_guild_template_section_custom_label;
                TextView textView = (TextView) view.findViewById(R.id.nux_guild_template_section_custom_label);
                if (textView != null) {
                    i = R.id.nux_guild_template_section_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.nux_guild_template_section_title);
                    if (textView2 != null) {
                        i = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                        if (recyclerView != null) {
                            return new WidgetNuxGuildTemplateBinding((LinearLayout) view, materialButton, linearLayout, textView, textView2, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
