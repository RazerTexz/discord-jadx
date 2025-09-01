package com.discord.widgets.guilds.leave;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.LeaveGuildDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetLeaveGuildDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/LeaveGuildDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/LeaveGuildDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetLeaveGuildDialog2 extends FunctionReferenceImpl implements Function1<View, LeaveGuildDialogBinding> {
    public static final WidgetLeaveGuildDialog2 INSTANCE = new WidgetLeaveGuildDialog2();

    public WidgetLeaveGuildDialog2() {
        super(1, LeaveGuildDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/LeaveGuildDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LeaveGuildDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LeaveGuildDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.leave_guild_cancel_btn;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.leave_guild_cancel_btn);
        if (materialButton != null) {
            i = R.id.leave_guild_confirm_btn;
            LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.leave_guild_confirm_btn);
            if (loadingButton != null) {
                i = R.id.leave_guild_dialog_body;
                TextView textView = (TextView) view.findViewById(R.id.leave_guild_dialog_body);
                if (textView != null) {
                    i = R.id.leave_guild_dialog_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.leave_guild_dialog_header);
                    if (textView2 != null) {
                        i = R.id.notice_header_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.notice_header_container);
                        if (linearLayout != null) {
                            return new LeaveGuildDialogBinding((LinearLayout) view, materialButton, loadingButton, textView, textView2, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
