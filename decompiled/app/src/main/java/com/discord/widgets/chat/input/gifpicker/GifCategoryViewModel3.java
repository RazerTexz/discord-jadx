package com.discord.widgets.chat.input.gifpicker;

import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GifCategoryViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryViewModel$ViewState$gifCount$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifCategoryViewModel3 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ GifCategoryViewModel.ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryViewModel3(GifCategoryViewModel.ViewState viewState) {
        super(0);
        this.this$0 = viewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        List<GifAdapterItem.GifItem> gifItems = this.this$0.getGifItems();
        int i = 0;
        if (!(gifItems instanceof Collection) || !gifItems.isEmpty()) {
            Iterator<T> it = gifItems.iterator();
            while (it.hasNext()) {
                if ((((GifAdapterItem.GifItem) it.next()) instanceof GifAdapterItem.GifItem) && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        return i;
    }
}
