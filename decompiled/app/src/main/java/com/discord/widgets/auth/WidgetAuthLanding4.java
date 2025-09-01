package com.discord.widgets.auth;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetAuthLanding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/auth/WidgetAuthLandingViewModel;", "invoke", "()Lcom/discord/widgets/auth/WidgetAuthLandingViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthLanding$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLanding4 extends Lambda implements Function0<WidgetAuthLandingViewModel> {
    public final /* synthetic */ WidgetAuthLanding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLanding4(WidgetAuthLanding widgetAuthLanding) {
        super(0);
        this.this$0 = widgetAuthLanding;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetAuthLandingViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetAuthLandingViewModel invoke() {
        return new WidgetAuthLandingViewModel(this.this$0.requireContext(), null, null, null, null, null, 62, null);
    }
}
