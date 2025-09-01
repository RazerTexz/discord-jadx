package com.discord.widgets.chat.input.emoji;

import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import d0.z.d.Lambda;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: EmojiPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$StandardItem;", "invoke", "()Lcom/discord/widgets/chat/input/emoji/EmojiCategoryItem$StandardItem;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiPickerViewModel$ViewState$Results$firstUnicodeEmojiCategoryItem$2 extends Lambda implements Function0<EmojiCategoryItem.StandardItem> {
    public final /* synthetic */ EmojiPickerViewModel.ViewState.Results this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$ViewState$Results$firstUnicodeEmojiCategoryItem$2(EmojiPickerViewModel.ViewState.Results results) {
        super(0);
        this.this$0 = results;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EmojiCategoryItem.StandardItem invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiCategoryItem.StandardItem invoke() {
        Object next;
        Iterator<T> it = this.this$0.getCategoryItems().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((EmojiCategoryItem) next).containsOnlyUnicodeEmoji()) {
                break;
            }
        }
        return (EmojiCategoryItem.StandardItem) (next instanceof EmojiCategoryItem.StandardItem ? next : null);
    }
}
