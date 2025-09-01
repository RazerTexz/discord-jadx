package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGifCategory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel;", "invoke", "()Lcom/discord/widgets/chat/input/gifpicker/GifCategoryViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$gifCategoryViewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGifCategory4 extends Lambda implements Function0<GifCategoryViewModel> {
    public final /* synthetic */ WidgetGifCategory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGifCategory4(WidgetGifCategory widgetGifCategory) {
        super(0);
        this.this$0 = widgetGifCategory;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GifCategoryViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GifCategoryViewModel invoke() {
        return new GifCategoryViewModel(this.this$0.requireContext(), WidgetGifCategory.access$getGifCategory(this.this$0), null, null, null, null, 60, null);
    }
}
