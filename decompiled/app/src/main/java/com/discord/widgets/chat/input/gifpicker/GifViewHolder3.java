package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: GifViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifViewHolder$SuggestedTerms$configureSearchTerms$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifViewHolder3 implements View.OnClickListener {
    public final /* synthetic */ Function1 $onTermSelected;
    public final /* synthetic */ String $suggestion;

    public GifViewHolder3(Function1 function1, String str) {
        this.$onTermSelected = function1;
        this.$suggestion = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.$onTermSelected;
        if (function1 != null) {
        }
    }
}
