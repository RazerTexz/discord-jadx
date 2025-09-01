package com.discord.widgets.status;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetThreadStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel;", "invoke", "()Lcom/discord/widgets/status/WidgetThreadStatusViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetThreadStatus$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadStatus3 extends Lambda implements Function0<WidgetThreadStatusViewModel> {
    public static final WidgetThreadStatus3 INSTANCE = new WidgetThreadStatus3();

    public WidgetThreadStatus3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetThreadStatusViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadStatusViewModel invoke() {
        return new WidgetThreadStatusViewModel(null, 1, null);
    }
}
