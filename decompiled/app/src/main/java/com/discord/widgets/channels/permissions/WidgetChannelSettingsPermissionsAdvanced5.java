package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSettingsPermissionsAdvancedBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$viewBinding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsPermissionsAdvanced5 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSettingsPermissionsAdvancedBinding> {
    public static final WidgetChannelSettingsPermissionsAdvanced5 INSTANCE = new WidgetChannelSettingsPermissionsAdvanced5();

    public WidgetChannelSettingsPermissionsAdvanced5() {
        super(1, WidgetChannelSettingsPermissionsAdvancedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsPermissionsAdvancedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsAdvancedBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsPermissionsAdvancedBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.add_member;
        TextView textView = (TextView) view.findViewById(R.id.add_member);
        if (textView != null) {
            i = R.id.add_role;
            TextView textView2 = (TextView) view.findViewById(R.id.add_role);
            if (textView2 != null) {
                i = R.id.members_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.members_container);
                if (linearLayout != null) {
                    i = R.id.members_recycler;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.members_recycler);
                    if (recyclerView != null) {
                        i = R.id.roles_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.roles_container);
                        if (linearLayout2 != null) {
                            i = R.id.roles_recycler;
                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.roles_recycler);
                            if (recyclerView2 != null) {
                                return new WidgetChannelSettingsPermissionsAdvancedBinding((CoordinatorLayout) view, textView, textView2, linearLayout, recyclerView, linearLayout2, recyclerView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
