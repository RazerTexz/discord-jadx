package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.HubAddServerConfirmationDialogBinding;
import com.discord.views.GuildView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubAddServerConfirmationDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAddServerConfirmationDialog3 extends FunctionReferenceImpl implements Function1<View, HubAddServerConfirmationDialogBinding> {
    public static final WidgetHubAddServerConfirmationDialog3 INSTANCE = new WidgetHubAddServerConfirmationDialog3();

    public WidgetHubAddServerConfirmationDialog3() {
        super(1, HubAddServerConfirmationDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ HubAddServerConfirmationDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final HubAddServerConfirmationDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.add_server_confirmation_dialog_description;
        TextView textView = (TextView) view.findViewById(R.id.add_server_confirmation_dialog_description);
        if (textView != null) {
            i = R.id.add_server_confirmation_dialog_image;
            GuildView guildView = (GuildView) view.findViewById(R.id.add_server_confirmation_dialog_image);
            if (guildView != null) {
                i = R.id.add_server_confirmation_dialog_positive;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.add_server_confirmation_dialog_positive);
                if (materialButton != null) {
                    return new HubAddServerConfirmationDialogBinding((LinearLayout) view, textView, guildView, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
