package com.discord.widgets.notice;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetNoticeDialogBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetNoticeDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetNoticeDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetNoticeDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetNoticeDialog$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetNoticeDialogBinding> {
    public static final WidgetNoticeDialog$binding$2 INSTANCE = new WidgetNoticeDialog$binding$2();

    public WidgetNoticeDialog$binding$2() {
        super(1, WidgetNoticeDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNoticeDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNoticeDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNoticeDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.notice_body_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.notice_body_container);
        if (linearLayout != null) {
            i = R.id.notice_body_text;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.notice_body_text);
            if (linkifiedTextView != null) {
                i = R.id.notice_cancel;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.notice_cancel);
                if (materialButton != null) {
                    i = R.id.notice_header;
                    TextView textView = (TextView) view.findViewById(R.id.notice_header);
                    if (textView != null) {
                        i = R.id.notice_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.notice_header_container);
                        if (linearLayout2 != null) {
                            i = R.id.notice_ok;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.notice_ok);
                            if (materialButton2 != null) {
                                return new WidgetNoticeDialogBinding((LinearLayout) view, linearLayout, linkifiedTextView, materialButton, textView, linearLayout2, materialButton2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
