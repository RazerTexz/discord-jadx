package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetEnableGuildCommunicationBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEnableGuildCommunication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableGuildCommunication2 extends FunctionReferenceImpl implements Function1<View, WidgetEnableGuildCommunicationBinding> {
    public static final WidgetEnableGuildCommunication2 INSTANCE = new WidgetEnableGuildCommunication2();

    public WidgetEnableGuildCommunication2() {
        super(1, WidgetEnableGuildCommunicationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEnableGuildCommunicationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEnableGuildCommunicationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.enable_communication_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.enable_communication_cancel);
        if (materialButton != null) {
            i = R.id.enable_communication_confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.enable_communication_confirm);
            if (materialButton2 != null) {
                i = R.id.enable_guild_communication_body;
                TextView textView = (TextView) view.findViewById(R.id.enable_guild_communication_body);
                if (textView != null) {
                    i = R.id.enable_guild_communication_body_help_text;
                    TextView textView2 = (TextView) view.findViewById(R.id.enable_guild_communication_body_help_text);
                    if (textView2 != null) {
                        i = R.id.end_time_out;
                        TextView textView3 = (TextView) view.findViewById(R.id.end_time_out);
                        if (textView3 != null) {
                            return new WidgetEnableGuildCommunicationBinding((LinearLayout) view, materialButton, materialButton2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
