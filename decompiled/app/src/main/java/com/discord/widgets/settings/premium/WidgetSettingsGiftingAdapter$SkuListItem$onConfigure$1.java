package com.discord.widgets.settings.premium;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.i18n.RenderContext;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsGiftingAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetSettingsGiftingAdapter.GiftItem $data;
    public final /* synthetic */ int $numMonthsOrYears;
    public final /* synthetic */ int $quantityString;
    public final /* synthetic */ WidgetSettingsGiftingAdapter.SkuListItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1(WidgetSettingsGiftingAdapter.SkuListItem skuListItem, WidgetSettingsGiftingAdapter.GiftItem giftItem, int i, int i2) {
        super(1);
        this.this$0 = skuListItem;
        this.$data = giftItem;
        this.$quantityString = i;
        this.$numMonthsOrYears = i2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("skuName", this.$data.getSku().getName());
        Map<String, String> map = renderContext.args;
        Context contextX = outline.x(this.this$0.itemView, "itemView", "itemView.context");
        int i = this.$quantityString;
        int i2 = this.$numMonthsOrYears;
        map.put("intervalCount", StringResourceUtils.getI18nPluralString(contextX, i, i2, Integer.valueOf(i2)).toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
