package com.discord.widgets.settings.connections;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetConnectionsAddXboxBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsUserConnectionsAddXbox2 extends FunctionReferenceImpl implements Function1<View, WidgetConnectionsAddXboxBinding> {
    public static final WidgetSettingsUserConnectionsAddXbox2 INSTANCE = new WidgetSettingsUserConnectionsAddXbox2();

    public WidgetSettingsUserConnectionsAddXbox2() {
        super(1, WidgetConnectionsAddXboxBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetConnectionsAddXboxBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetConnectionsAddXboxBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.connections_xbox_code;
        CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R.id.connections_xbox_code);
        if (codeVerificationView != null) {
            i = R.id.connections_xbox_login;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.connections_xbox_login);
            if (linearLayout != null) {
                i = R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                if (dimmerView != null) {
                    return new WidgetConnectionsAddXboxBinding((CoordinatorLayout) view, codeVerificationView, linearLayout, dimmerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
