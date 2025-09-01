package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetServerNotificationOverrideSelectorBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerNotificationsOverrideSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerNotificationsOverrideSelector3 extends FunctionReferenceImpl implements Function1<View, WidgetServerNotificationOverrideSelectorBinding> {
    public static final WidgetServerNotificationsOverrideSelector3 INSTANCE = new WidgetServerNotificationsOverrideSelector3();

    public WidgetServerNotificationsOverrideSelector3() {
        super(1, WidgetServerNotificationOverrideSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerNotificationOverrideSelectorBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerNotificationOverrideSelectorBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_notifications_channel_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.guild_notifications_channel_list);
        if (recyclerView != null) {
            i = R.id.guild_notifications_channel_search;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_notifications_channel_search);
            if (textInputLayout != null) {
                return new WidgetServerNotificationOverrideSelectorBinding((CoordinatorLayout) view, recyclerView, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
