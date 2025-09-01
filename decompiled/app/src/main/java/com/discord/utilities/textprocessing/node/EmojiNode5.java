package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.textprocessing.node.EmojiNode;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textprocessing.node.EmojiNode$render$clickableSpan$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiNode5 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ EmojiNode.RenderContext $renderContext;
    public final /* synthetic */ EmojiNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiNode5(EmojiNode emojiNode, EmojiNode.RenderContext renderContext) {
        super(1);
        this.this$0 = emojiNode;
        this.$renderContext = renderContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        this.$renderContext.onEmojiClicked(EmojiNode.access$getEmojiIdAndType$p(this.this$0));
    }
}
