package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBlockedUsersBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsBlockedUsers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsBlockedUsers2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsBlockedUsersBinding> {
    public static final WidgetSettingsBlockedUsers2 INSTANCE = new WidgetSettingsBlockedUsers2();

    public WidgetSettingsBlockedUsers2() {
        super(1, WidgetSettingsBlockedUsersBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsBlockedUsersBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsBlockedUsersBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.blocked_users_flipper;
        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.blocked_users_flipper);
        if (appViewFlipper != null) {
            i = R.id.blocked_users_list_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.blocked_users_list_recycler);
            if (recyclerView != null) {
                i = R.id.friends_list_item_empty_no_blocked;
                ImageView imageView = (ImageView) view.findViewById(R.id.friends_list_item_empty_no_blocked);
                if (imageView != null) {
                    return new WidgetSettingsBlockedUsersBinding((CoordinatorLayout) view, appViewFlipper, recyclerView, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
