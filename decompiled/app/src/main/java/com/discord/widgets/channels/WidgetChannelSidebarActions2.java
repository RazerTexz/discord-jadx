package com.discord.widgets.channels;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.WidgetChannelSidebarActionsBinding;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelSidebarActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSidebarActions2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelSidebarActionsBinding> {
    public static final WidgetChannelSidebarActions2 INSTANCE = new WidgetChannelSidebarActions2();

    public WidgetChannelSidebarActions2() {
        super(1, WidgetChannelSidebarActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSidebarActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSidebarActionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.widget_channel_sidebar_actions_guild_view;
        GuildChannelSideBarActionsView guildChannelSideBarActionsView = (GuildChannelSideBarActionsView) view.findViewById(R.id.widget_channel_sidebar_actions_guild_view);
        if (guildChannelSideBarActionsView != null) {
            i = R.id.widget_channel_sidebar_actions_private_view;
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView = (PrivateChannelSideBarActionsView) view.findViewById(R.id.widget_channel_sidebar_actions_private_view);
            if (privateChannelSideBarActionsView != null) {
                return new WidgetChannelSidebarActionsBinding((FrameLayout) view, guildChannelSideBarActionsView, privateChannelSideBarActionsView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
