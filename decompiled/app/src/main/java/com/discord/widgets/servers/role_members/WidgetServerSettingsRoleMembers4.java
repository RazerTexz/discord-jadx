package com.discord.widgets.servers.role_members;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsRoleMembersBinding;
import com.discord.views.SearchInputView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsRoleMembers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsRoleMembersBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsRoleMembersBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsRoleMembers4 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsRoleMembersBinding> {
    public static final WidgetServerSettingsRoleMembers4 INSTANCE = new WidgetServerSettingsRoleMembers4();

    public WidgetServerSettingsRoleMembers4() {
        super(1, WidgetServerSettingsRoleMembersBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsRoleMembersBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsRoleMembersBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsRoleMembersBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.role_members_app_view_flipper;
        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.role_members_app_view_flipper);
        if (appViewFlipper != null) {
            i = R.id.server_settings_role_members_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_role_members_list);
            if (recyclerView != null) {
                i = R.id.server_settings_role_members_search_input;
                SearchInputView searchInputView = (SearchInputView) view.findViewById(R.id.server_settings_role_members_search_input);
                if (searchInputView != null) {
                    return new WidgetServerSettingsRoleMembersBinding((LinearLayout) view, appViewFlipper, recyclerView, searchInputView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
