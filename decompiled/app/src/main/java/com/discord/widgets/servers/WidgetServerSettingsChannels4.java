package com.discord.widgets.servers;

import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsChannelsBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsChannels4 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsChannelsBinding> {
    public static final WidgetServerSettingsChannels4 INSTANCE = new WidgetServerSettingsChannels4();

    public WidgetServerSettingsChannels4() {
        super(1, WidgetServerSettingsChannelsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsChannelsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsChannelsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.server_settings_channels_create_channel;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.server_settings_channels_create_channel);
            if (floatingActionButton != null) {
                i = R.id.server_settings_channels_text_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_channels_text_recycler);
                if (recyclerView != null) {
                    i = R.id.widget_server_settings_channels_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.widget_server_settings_channels_container);
                    if (frameLayout != null) {
                        return new WidgetServerSettingsChannelsBinding((CoordinatorLayout) view, dimmerView, floatingActionButton, recyclerView, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
