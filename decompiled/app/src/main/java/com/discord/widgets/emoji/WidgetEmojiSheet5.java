package com.discord.widgets.emoji;

import android.view.View;
import kotlin.Metadata;

/* compiled from: WidgetEmojiSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/emoji/WidgetEmojiSheet$configureFavorite$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.emoji.WidgetEmojiSheet$configureFavorite$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEmojiSheet5 implements View.OnClickListener {
    public final /* synthetic */ boolean $isFavorite$inlined;
    public final /* synthetic */ WidgetEmojiSheet this$0;

    public WidgetEmojiSheet5(WidgetEmojiSheet widgetEmojiSheet, boolean z2) {
        this.this$0 = widgetEmojiSheet;
        this.$isFavorite$inlined = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetEmojiSheet.access$getViewModel$p(this.this$0).setFavorite(false);
    }
}
