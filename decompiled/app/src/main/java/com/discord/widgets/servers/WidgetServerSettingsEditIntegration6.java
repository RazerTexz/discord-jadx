package com.discord.widgets.servers;

import com.discord.views.CheckedSetting;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsEditIntegration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/views/CheckedSetting;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$gracePeriodRadios$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration6 extends Lambda implements Function0<List<? extends CheckedSetting>> {
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditIntegration6(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        super(0);
        this.this$0 = widgetServerSettingsEditIntegration;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends CheckedSetting> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends CheckedSetting> invoke2() {
        return Collections2.listOf((Object[]) new CheckedSetting[]{WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).h, WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).j, WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).k, WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).g, WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).i});
    }
}
