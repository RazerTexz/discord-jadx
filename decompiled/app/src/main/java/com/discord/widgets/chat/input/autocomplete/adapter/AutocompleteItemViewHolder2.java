package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* compiled from: AutocompleteItemViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "isAnimated", "", "<anonymous parameter 1>", "Landroid/content/Context;", "context", "", "invoke", "(ZILandroid/content/Context;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.adapter.AutocompleteItemViewHolder$bindEmoji$emojiNode$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AutocompleteItemViewHolder2 extends Lambda implements Function3<Boolean, Integer, Context, String> {
    public final /* synthetic */ Emoji $emoji;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutocompleteItemViewHolder2(Emoji emoji) {
        super(3);
        this.$emoji = emoji;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
        return invoke(bool.booleanValue(), num.intValue(), context);
    }

    public final String invoke(boolean z2, int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String imageUri = this.$emoji.getImageUri(z2, 32, context);
        Intrinsics3.checkNotNullExpressionValue(imageUri, "emoji.getImageUri(isAnimated, 32, context)");
        return imageUri;
    }
}
