package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetConfirmRemoveCommunityDialogBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetConfirmRemoveCommunityDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetConfirmRemoveCommunityDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetConfirmRemoveCommunityDialogBinding> {
    public static final WidgetConfirmRemoveCommunityDialog2 INSTANCE = new WidgetConfirmRemoveCommunityDialog2();

    public WidgetConfirmRemoveCommunityDialog2() {
        super(1, WidgetConfirmRemoveCommunityDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetConfirmRemoveCommunityDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetConfirmRemoveCommunityDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.confirm_deleting_community_body_text;
        TextView textView = (TextView) view.findViewById(R.id.confirm_deleting_community_body_text);
        if (textView != null) {
            i = R.id.confirm_deleting_community_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.confirm_deleting_community_cancel);
            if (materialButton != null) {
                i = R.id.confirm_deleting_community_header;
                TextView textView2 = (TextView) view.findViewById(R.id.confirm_deleting_community_header);
                if (textView2 != null) {
                    i = R.id.confirm_deleting_community_header_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.confirm_deleting_community_header_container);
                    if (linearLayout != null) {
                        i = R.id.confirm_deleting_community_ok;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.confirm_deleting_community_ok);
                        if (materialButton2 != null) {
                            return new WidgetConfirmRemoveCommunityDialogBinding((LinearLayout) view, textView, materialButton, textView2, linearLayout, materialButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
