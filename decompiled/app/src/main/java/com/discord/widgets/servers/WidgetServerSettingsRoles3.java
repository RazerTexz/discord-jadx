package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsRolesBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsRoles.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsRoles3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsRolesBinding> {
    public static final WidgetServerSettingsRoles3 INSTANCE = new WidgetServerSettingsRoles3();

    public WidgetServerSettingsRoles3() {
        super(1, WidgetServerSettingsRolesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsRolesBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsRolesBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.roles_list_add_role_fab;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.roles_list_add_role_fab);
            if (floatingActionButton != null) {
                i = R.id.server_settings_roles_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_roles_recycler);
                if (recyclerView != null) {
                    return new WidgetServerSettingsRolesBinding((CoordinatorLayout) view, dimmerView, floatingActionButton, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
