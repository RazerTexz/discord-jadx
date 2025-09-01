package com.discord.widgets.home;

import android.view.View;
import com.discord.api.channel.Channel;
import com.discord.databinding.WidgetHomeBinding;
import kotlin.Metadata;

/* compiled from: WidgetHomeHeaderManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/home/WidgetHomeHeaderManager$configure$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$configure$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomeHeaderManager3 implements View.OnClickListener {
    public final /* synthetic */ WidgetHomeBinding $binding$inlined;
    public final /* synthetic */ WidgetHomeModel $model$inlined;
    public final /* synthetic */ WidgetHomeModel $this_apply;
    public final /* synthetic */ WidgetHome $widgetHome$inlined;

    public WidgetHomeHeaderManager3(WidgetHomeModel widgetHomeModel, WidgetHome widgetHome, WidgetHomeModel widgetHomeModel2, WidgetHomeBinding widgetHomeBinding) {
        this.$this_apply = widgetHomeModel;
        this.$widgetHome$inlined = widgetHome;
        this.$model$inlined = widgetHomeModel2;
        this.$binding$inlined = widgetHomeBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Channel channel = this.$this_apply.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 1) || ((numValueOf != null && numValueOf.intValue() == 3) || ((numValueOf != null && numValueOf.intValue() == 5) || ((numValueOf != null && numValueOf.intValue() == 15) || (numValueOf != null && numValueOf.intValue() == 0))))) {
            this.$widgetHome$inlined.getPanelLayout().openEndPanel();
        }
    }
}
