package com.discord.utilities.textprocessing.node;

import android.content.Context;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: EmojiNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"com/discord/utilities/textprocessing/node/EmojiNode$Companion$renderEmoji$1", "Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "isAnimationEnabled", "Z", "()Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textprocessing.node.EmojiNode$Companion$renderEmoji$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiNode4 implements EmojiNode.RenderContext {
    public final /* synthetic */ boolean $isAnimationEnabled;
    public final /* synthetic */ SimpleDraweeSpanTextView $this_renderEmoji;
    private final Context context;
    private final boolean isAnimationEnabled;

    public EmojiNode4(SimpleDraweeSpanTextView simpleDraweeSpanTextView, boolean z2) {
        this.$this_renderEmoji = simpleDraweeSpanTextView;
        this.$isAnimationEnabled = z2;
        this.context = simpleDraweeSpanTextView.getContext();
        this.isAnimationEnabled = z2;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    /* renamed from: isAnimationEnabled, reason: from getter */
    public boolean getIsAnimationEnabled() {
        return this.isAnimationEnabled;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
        Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
    }
}
