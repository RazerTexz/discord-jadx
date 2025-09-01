package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import b.a.d.AppScreen2;
import com.discord.api.channel.Channel;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetDirectoryChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/directories/WidgetDirectoryChannel$configureUi$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannel2 implements View.OnClickListener {
    public final /* synthetic */ WidgetDirectoriesViewModel.ViewState $state$inlined;
    public final /* synthetic */ ServerDiscoveryHeader $this_apply;

    public WidgetDirectoryChannel2(ServerDiscoveryHeader serverDiscoveryHeader, WidgetDirectoriesViewModel.ViewState viewState) {
        this.$this_apply = serverDiscoveryHeader;
        this.$state$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Channel channel = this.$state$inlined.getChannel();
        if (channel != null) {
            long id2 = channel.getId();
            Context context = this.$this_apply.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            AppScreen2.d(context, WidgetDirectoriesSearch.class, new WidgetDirectoriesSearch2(id2));
        }
    }
}
