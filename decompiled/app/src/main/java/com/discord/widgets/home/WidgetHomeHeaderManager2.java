package com.discord.widgets.home;

import android.view.View;
import com.discord.databinding.WidgetHomeBinding;
import kotlin.Metadata;

/* compiled from: WidgetHomeHeaderManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/home/WidgetHomeHeaderManager$$special$$inlined$let$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$configure$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomeHeaderManager2 implements View.OnClickListener {
    public final /* synthetic */ WidgetHomeBinding $binding$inlined;
    public final /* synthetic */ WidgetHomeModel $model$inlined;
    public final /* synthetic */ WidgetHomeModel $this_apply$inlined;
    public final /* synthetic */ WidgetHome $widgetHome$inlined;

    public WidgetHomeHeaderManager2(WidgetHomeModel widgetHomeModel, WidgetHome widgetHome, WidgetHomeModel widgetHomeModel2, WidgetHomeBinding widgetHomeBinding) {
        this.$this_apply$inlined = widgetHomeModel;
        this.$widgetHome$inlined = widgetHome;
        this.$model$inlined = widgetHomeModel2;
        this.$binding$inlined = widgetHomeBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$widgetHome$inlined.handleCenterPanelBack$app_productionGoogleRelease();
    }
}
