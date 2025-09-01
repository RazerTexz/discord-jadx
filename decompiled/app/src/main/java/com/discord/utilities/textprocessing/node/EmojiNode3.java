package com.discord.utilities.textprocessing.node;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* compiled from: EmojiNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "", "isAnimationEnabled", "", "size", "Landroid/content/Context;", "<anonymous parameter 2>", "", "invoke", "(ZILandroid/content/Context;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textprocessing.node.EmojiNode$Companion$from$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiNode3 extends Lambda implements Function3<Boolean, Integer, Context, String> {
    public final /* synthetic */ long $emojiId;
    public final /* synthetic */ boolean $isAnimated;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiNode3(long j, boolean z2) {
        super(3);
        this.$emojiId = j;
        this.$isAnimated = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
        return invoke(bool.booleanValue(), num.intValue(), context);
    }

    public final String invoke(boolean z2, int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "<anonymous parameter 2>");
        String imageUri = ModelEmojiCustom.getImageUri(this.$emojiId, this.$isAnimated && z2, i);
        Intrinsics3.checkNotNullExpressionValue(imageUri, "ModelEmojiCustom.getImag…isAnimationEnabled, size)");
        return imageUri;
    }
}
