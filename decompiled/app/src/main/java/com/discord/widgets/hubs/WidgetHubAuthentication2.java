package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CodeVerificationView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubAuthentication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetHubAuthenticationBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetHubAuthenticationBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAuthentication2 extends FunctionReferenceImpl implements Function1<View, WidgetHubAuthenticationBinding> {
    public static final WidgetHubAuthentication2 INSTANCE = new WidgetHubAuthentication2();

    public WidgetHubAuthentication2() {
        super(1, WidgetHubAuthenticationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubAuthenticationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubAuthenticationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.contact_sync_permissions_subtitle;
        TextView textView = (TextView) view.findViewById(R.id.contact_sync_permissions_subtitle);
        if (textView != null) {
            i = R.id.description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.description);
            if (linkifiedTextView != null) {
                i = R.id.title;
                TextView textView2 = (TextView) view.findViewById(R.id.title);
                if (textView2 != null) {
                    i = R.id.verification;
                    CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R.id.verification);
                    if (codeVerificationView != null) {
                        return new WidgetHubAuthenticationBinding((LinearLayout) view, textView, linkifiedTextView, textView2, codeVerificationView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
