package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: InputAutocompletables.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/sources/EmojiAutocompletableSource;", "invoke", "()Lcom/discord/widgets/chat/input/autocomplete/sources/EmojiAutocompletableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$EMOJI_SOURCE$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputAutocompletables4 extends Lambda implements Function0<EmojiAutocompletableSource> {
    public static final InputAutocompletables4 INSTANCE = new InputAutocompletables4();

    public InputAutocompletables4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EmojiAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiAutocompletableSource invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new EmojiAutocompletableSource(companion.getEmojis(), companion.getUserSettings());
    }
}
