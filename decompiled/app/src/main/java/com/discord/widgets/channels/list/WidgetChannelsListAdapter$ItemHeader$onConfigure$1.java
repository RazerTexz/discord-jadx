package com.discord.widgets.channels.list;

import android.view.View;
import b.d.b.a.outline;
import com.discord.widgets.channels.WidgetCreateChannel;
import kotlin.Metadata;

/* compiled from: WidgetChannelsListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemHeader$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ long $selectedGuildId;

    public WidgetChannelsListAdapter$ItemHeader$onConfigure$1(long j) {
        this.$selectedGuildId = j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel.Companion.show$default(WidgetCreateChannel.INSTANCE, outline.x(view, "v", "v.context"), this.$selectedGuildId, 0, null, 8, null);
    }
}
