package com.discord.widgets.chat.input.emoji;

import com.discord.models.domain.emoji.Emoji;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/emoji/Emoji;", "emoji", "", "invoke", "(Lcom/discord/models/domain/emoji/Emoji;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$buildEmojiListItems$items$1 extends Lambda implements Function1<Emoji, Boolean> {
    public final /* synthetic */ boolean $includeUnavailable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$Companion$buildEmojiListItems$items$1(boolean z2) {
        super(1);
        this.$includeUnavailable = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Emoji emoji) {
        return Boolean.valueOf(invoke2(emoji));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        if (this.$includeUnavailable) {
            return true;
        }
        return emoji.isAvailable();
    }
}
