package com.discord.widgets.chat.input.autocomplete.adapter;

import android.widget.LinearLayout;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiAutocompleteUpsellViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "sizePx", "", "invoke", "(I)Ljava/lang/String;", "com/discord/widgets/chat/input/autocomplete/adapter/EmojiAutocompleteUpsellViewHolder$bind$items$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.adapter.EmojiAutocompleteUpsellViewHolder$bind$$inlined$map$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiAutocompleteUpsellViewHolder2 extends Lambda implements Function1<Integer, String> {
    public final /* synthetic */ EmojiUpsellPlaceholder $emojiUpsellPlaceholder$inlined;
    public final /* synthetic */ Emoji $it;
    public final /* synthetic */ EmojiAutocompleteUpsellViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiAutocompleteUpsellViewHolder2(Emoji emoji, EmojiAutocompleteUpsellViewHolder emojiAutocompleteUpsellViewHolder, EmojiUpsellPlaceholder emojiUpsellPlaceholder) {
        super(1);
        this.$it = emoji;
        this.this$0 = emojiAutocompleteUpsellViewHolder;
        this.$emojiUpsellPlaceholder$inlined = emojiUpsellPlaceholder;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final String invoke(int i) {
        int mediaProxySize = IconUtils.getMediaProxySize(i);
        Emoji emoji = this.$it;
        boolean allowEmojiToAnimate = this.$emojiUpsellPlaceholder$inlined.getAllowEmojiToAnimate();
        LinearLayout linearLayout = EmojiAutocompleteUpsellViewHolder.access$getBinding$p(this.this$0).a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        return emoji.getImageUri(allowEmojiToAnimate, mediaProxySize, linearLayout.getContext());
    }
}
