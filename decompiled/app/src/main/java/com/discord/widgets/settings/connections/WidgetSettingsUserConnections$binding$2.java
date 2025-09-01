package com.discord.widgets.settings.connections;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsConnectionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsUserConnections.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsConnectionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsConnectionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsUserConnections$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsConnectionsBinding> {
    public static final WidgetSettingsUserConnections$binding$2 INSTANCE = new WidgetSettingsUserConnections$binding$2();

    public WidgetSettingsUserConnections$binding$2() {
        super(1, WidgetSettingsConnectionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsConnectionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsConnectionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsConnectionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.connections_empty;
        TextView textView = (TextView) view.findViewById(R.id.connections_empty);
        if (textView != null) {
            i = R.id.connections_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.connections_recycler);
            if (recyclerView != null) {
                return new WidgetSettingsConnectionsBinding((CoordinatorLayout) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
