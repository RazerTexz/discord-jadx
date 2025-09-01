package com.discord.widgets.settings;

import android.widget.TextView;
import com.discord.R;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetMuteSettingsSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet3 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMuteSettingsSheet3(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(1);
        this.this$0 = widgetMuteSettingsSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        TextView textView = WidgetMuteSettingsSheet.access$getBinding$p(this.this$0).q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.unmuteButtonLabel");
        renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(textView, R.attr.colorHeaderPrimary));
    }
}
