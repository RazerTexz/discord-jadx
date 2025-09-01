package com.discord.widgets.settings.premium;

import com.discord.widgets.settings.premium.WidgetChoosePlan;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChoosePlan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/settings/premium/ChoosePlanViewModel;", "invoke", "()Lcom/discord/widgets/settings/premium/ChoosePlanViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChoosePlan5 extends Lambda implements Function0<ChoosePlanViewModel> {
    public final /* synthetic */ WidgetChoosePlan this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlan5(WidgetChoosePlan widgetChoosePlan) {
        super(0);
        this.this$0 = widgetChoosePlan;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ChoosePlanViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChoosePlanViewModel invoke() {
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra(WidgetChoosePlan.RESULT_EXTRA_OLD_SKU_NAME);
        Serializable serializableExtra = this.this$0.getMostRecentIntent().getSerializableExtra(WidgetChoosePlan.RESULT_VIEW_TYPE);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.settings.premium.WidgetChoosePlan.ViewType");
        return new ChoosePlanViewModel((WidgetChoosePlan.ViewType) serializableExtra, stringExtra, null, 4, null);
    }
}
