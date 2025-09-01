package com.discord.widgets.botuikit.views;

import com.discord.R;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreStream;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringNumberConversions;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ComponentViewUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\b\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/botuikit/views/ComponentViewUtils;", "", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/discord/api/botuikit/ComponentEmoji;", "componentEmoji", "", "emojiAnimationsEnabled", "", "setEmojiOrHide", "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/discord/api/botuikit/ComponentEmoji;Z)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ComponentViewUtils {
    public static final ComponentViewUtils INSTANCE = new ComponentViewUtils();

    private ComponentViewUtils() {
    }

    public final void setEmojiOrHide(SimpleDraweeView simpleDraweeView, ComponentEmoji componentEmoji, boolean z2) {
        String imageUri;
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "$this$setEmojiOrHide");
        if (componentEmoji == null) {
            simpleDraweeView.setVisibility(8);
            return;
        }
        boolean z3 = false;
        simpleDraweeView.setVisibility(0);
        String id2 = componentEmoji.getId();
        Long longOrNull = id2 != null ? StringNumberConversions.toLongOrNull(id2) : null;
        if (longOrNull != null) {
            long jLongValue = longOrNull.longValue();
            if (z2 && Intrinsics3.areEqual(componentEmoji.getAnimated(), Boolean.TRUE)) {
                z3 = true;
            }
            imageUri = ModelEmojiCustom.getImageUri(jLongValue, z3, 64);
        } else {
            ModelEmojiUnicode modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(componentEmoji.getName());
            imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode != null ? modelEmojiUnicode.getCodePoints() : null, simpleDraweeView.getContext());
        }
        if (!Intrinsics3.areEqual(simpleDraweeView.getTag(R.string.tag_emoji_url), imageUri)) {
            simpleDraweeView.setTag(R.string.tag_emoji_url, imageUri);
            MGImages.setImage$default(simpleDraweeView, imageUri, R.dimen.emoji_size, R.dimen.emoji_size, true, null, null, 96, null);
        }
    }
}
