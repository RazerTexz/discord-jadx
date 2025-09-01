package com.discord.widgets.servers;

import android.view.View;
import com.discord.models.domain.ModelBan;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsBans.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Adapter$BanListItem$onConfigure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsBans2 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsBans.Model.BanItem $data;
    public final /* synthetic */ WidgetServerSettingsBans.Adapter.BanListItem this$0;

    public WidgetServerSettingsBans2(WidgetServerSettingsBans.Adapter.BanListItem banListItem, WidgetServerSettingsBans.Model.BanItem banItem) {
        this.this$0 = banListItem;
        this.$data = banItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<ModelBan, Unit> onBanSelectedListener;
        ModelBan ban = this.$data.getBan();
        if (ban == null || (onBanSelectedListener = WidgetServerSettingsBans.Adapter.BanListItem.access$getAdapter$p(this.this$0).getOnBanSelectedListener()) == null) {
            return;
        }
        onBanSelectedListener.invoke(ban);
    }
}
