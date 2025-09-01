package com.discord.widgets.user.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetUserAccountVerifyBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserAccountVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerify$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserAccountVerify4 extends FunctionReferenceImpl implements Function1<View, WidgetUserAccountVerifyBinding> {
    public static final WidgetUserAccountVerify4 INSTANCE = new WidgetUserAccountVerify4();

    public WidgetUserAccountVerify4() {
        super(1, WidgetUserAccountVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserAccountVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserAccountVerifyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.verify_account_by_email;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.verify_account_by_email);
        if (relativeLayout != null) {
            i = R.id.verify_account_by_phone;
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.verify_account_by_phone);
            if (relativeLayout2 != null) {
                i = R.id.verify_account_support;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.verify_account_support);
                if (linkifiedTextView != null) {
                    i = R.id.verify_account_text_body;
                    TextView textView = (TextView) view.findViewById(R.id.verify_account_text_body);
                    if (textView != null) {
                        return new WidgetUserAccountVerifyBinding((RelativeLayout) view, relativeLayout, relativeLayout2, linkifiedTextView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
