package com.discord.widgets.chat.input.gifpicker;

import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GifSearchViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$ViewState$Loaded$gifCount$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifSearchViewModel5 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ GifSearchViewModel.ViewState.Loaded this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel5(GifSearchViewModel.ViewState.Loaded loaded) {
        super(0);
        this.this$0 = loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        List<GifAdapterItem> adapterItems = this.this$0.getAdapterItems();
        int i = 0;
        if (!(adapterItems instanceof Collection) || !adapterItems.isEmpty()) {
            Iterator<T> it = adapterItems.iterator();
            while (it.hasNext()) {
                if ((((GifAdapterItem) it.next()) instanceof GifAdapterItem.GifItem) && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        return i;
    }
}
