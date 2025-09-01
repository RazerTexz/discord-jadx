package com.discord.widgets.emoji;

import com.discord.utilities.textprocessing.node.EmojiNode;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetEmojiSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "invoke", "()Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.emoji.WidgetEmojiSheet$emojiIdAndType$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEmojiSheet8 extends Lambda implements Function0<EmojiNode.EmojiIdAndType> {
    public final /* synthetic */ WidgetEmojiSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiSheet8(WidgetEmojiSheet widgetEmojiSheet) {
        super(0);
        this.this$0 = widgetEmojiSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EmojiNode.EmojiIdAndType invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiNode.EmojiIdAndType invoke() {
        Serializable serializable = WidgetEmojiSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable("EXTRA_EMOJI_ID_AND_TYPE");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType");
        return (EmojiNode.EmojiIdAndType) serializable;
    }
}
