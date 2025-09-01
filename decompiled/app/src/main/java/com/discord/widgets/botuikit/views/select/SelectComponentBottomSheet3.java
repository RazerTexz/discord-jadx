package com.discord.widgets.botuikit.views.select;

import com.discord.api.botuikit.SelectComponent2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: SelectComponentBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/botuikit/SelectItem;", "p1", "", "p2", "", "invoke", "(Lcom/discord/api/botuikit/SelectItem;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$adapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class SelectComponentBottomSheet3 extends FunctionReferenceImpl implements Function2<SelectComponent2, Boolean, Unit> {
    public SelectComponentBottomSheet3(SelectComponentBottomSheet selectComponentBottomSheet) {
        super(2, selectComponentBottomSheet, SelectComponentBottomSheet.class, "onItemSelected", "onItemSelected(Lcom/discord/api/botuikit/SelectItem;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SelectComponent2 selectComponent2, Boolean bool) {
        invoke(selectComponent2, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(SelectComponent2 selectComponent2, boolean z2) {
        Intrinsics3.checkNotNullParameter(selectComponent2, "p1");
        ((SelectComponentBottomSheet) this.receiver).onItemSelected(selectComponent2, z2);
    }
}
