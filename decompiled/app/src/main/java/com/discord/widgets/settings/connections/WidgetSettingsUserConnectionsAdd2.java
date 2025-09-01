package com.discord.widgets.settings.connections;

import android.content.Context;
import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.Traits;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAdd;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetSettingsUserConnectionsAdd.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd2 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsUserConnectionsAdd.PlatformItem $data;
    public final /* synthetic */ WidgetSettingsUserConnectionsAdd.Adapter.ViewHolder this$0;

    public WidgetSettingsUserConnectionsAdd2(WidgetSettingsUserConnectionsAdd.Adapter.ViewHolder viewHolder, WidgetSettingsUserConnectionsAdd.PlatformItem platformItem) {
        this.this$0 = viewHolder;
        this.$data = platformItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.getDialogDismissCallback().invoke();
        if (this.$data.getPlatform().ordinal() == 12) {
            WidgetSettingsUserConnectionsAddXbox.Companion companion = WidgetSettingsUserConnectionsAddXbox.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "v.context");
            companion.launch(context);
            return;
        }
        StoreUserConnections userConnections = StoreStream.INSTANCE.getUserConnections();
        String platformId = this.$data.getPlatform().getPlatformId();
        Intrinsics3.checkNotNullExpressionValue(view, "v");
        Context context2 = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "v.context");
        userConnections.authorizeConnection(platformId, context2, Traits.Location.Page.USER_SETTINGS);
    }
}
