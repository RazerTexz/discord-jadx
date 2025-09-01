package com.discord.widgets.settings;

import com.discord.views.CheckedSetting;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetSettingsPrivacy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lcom/discord/views/CheckedSetting;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$explicitContentRadios$2 extends Lambda implements Function0<List<? extends CheckedSetting>> {
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$explicitContentRadios$2(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        super(0);
        this.this$0 = widgetSettingsPrivacy;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends CheckedSetting> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends CheckedSetting> invoke2() {
        return Collections2.listOf((Object[]) new CheckedSetting[]{WidgetSettingsPrivacy.access$getBinding$p(this.this$0).o, WidgetSettingsPrivacy.access$getBinding$p(this.this$0).p, WidgetSettingsPrivacy.access$getBinding$p(this.this$0).q});
    }
}
