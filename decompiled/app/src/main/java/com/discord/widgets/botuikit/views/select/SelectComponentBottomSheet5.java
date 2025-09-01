package com.discord.widgets.botuikit.views.select;

import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: SelectComponentBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel;", "invoke", "()Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectComponentBottomSheet5 extends Lambda implements Function0<SelectComponentBottomSheetViewModel> {
    public final /* synthetic */ SelectComponentBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentBottomSheet5(SelectComponentBottomSheet selectComponentBottomSheet) {
        super(0);
        this.this$0 = selectComponentBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SelectComponentBottomSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SelectComponentBottomSheetViewModel invoke() {
        Serializable serializable = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable(SelectComponentBottomSheet.EXTRA_COMPONENT_CONTEXT);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.botuikit.views.select.ComponentContext");
        SelectComponentBottomSheet2 selectComponentBottomSheet2 = (SelectComponentBottomSheet2) serializable;
        int i = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getInt(SelectComponentBottomSheet.EXTRA_COMPONENT_INDEX);
        String string = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString(SelectComponentBottomSheet.EXTRA_CUSTOM_ID, "");
        String string2 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString(SelectComponentBottomSheet.EXTRA_PLACEHOLDER);
        int i2 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getInt(SelectComponentBottomSheet.EXTRA_MIN);
        int i3 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getInt(SelectComponentBottomSheet.EXTRA_MAX);
        Serializable serializable2 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable(SelectComponentBottomSheet.EXTRA_OPTIONS);
        if (!(serializable2 instanceof List)) {
            serializable2 = null;
        }
        List listEmptyList = (List) serializable2;
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        List list = listEmptyList;
        Serializable serializable3 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable(SelectComponentBottomSheet.EXTRA_SELECTED);
        List list2 = (List) (serializable3 instanceof List ? serializable3 : null);
        List listEmptyList2 = list2 != null ? list2 : Collections2.emptyList();
        boolean z2 = SelectComponentBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getBoolean(SelectComponentBottomSheet.EXTRA_EMOJI_ANIMATIONS_ENABLED);
        Intrinsics3.checkNotNullExpressionValue(string, "customId");
        return new SelectComponentBottomSheetViewModel(selectComponentBottomSheet2, i, string, string2, list, i2, i3, listEmptyList2, z2);
    }
}
