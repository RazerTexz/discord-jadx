package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "<anonymous parameter 0>", "<anonymous parameter 1>", "Lcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;", "<anonymous parameter 2>", "", "invoke", "(IILcom/discord/widgets/user/search/WidgetGlobalSearchGuildsModel$Item;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$onLongClickListener$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter5 extends Lambda implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> {
    public static final WidgetGlobalSearchGuildsAdapter5 INSTANCE = new WidgetGlobalSearchGuildsAdapter5();

    public WidgetGlobalSearchGuildsAdapter5() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel.Item item) {
        invoke(num.intValue(), num2.intValue(), item);
        return Unit.a;
    }

    public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel.Item item) {
        Intrinsics3.checkNotNullParameter(item, "<anonymous parameter 2>");
    }
}
