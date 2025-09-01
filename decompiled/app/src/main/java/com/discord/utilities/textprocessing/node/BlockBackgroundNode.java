package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.spans.BlockBackgroundSpan;
import com.discord.utilities.spans.VerticalPaddingSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: BlockBackgroundNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B/\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u001e\u0010\u0016\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\u0014\"\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BlockBackgroundNode;", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "R", "Lcom/discord/simpleast/core/node/Node$a;", "Lcom/discord/utilities/textprocessing/node/Spoilerable;", "Landroid/text/SpannableStringBuilder;", "builder", "", "ensureEndsWithNewline", "(Landroid/text/SpannableStringBuilder;)V", "renderContext", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/BasicRenderContext;)V", "", "isRevealed", "Z", "()Z", "setRevealed", "(Z)V", "inQuote", "", "Lcom/discord/simpleast/core/node/Node;", "children", "<init>", "(Z[Lcom/discord/simpleast/core/node/Node;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BlockBackgroundNode<R extends BasicRenderContext> extends Node.a<R> implements Spoilerable {
    private final boolean inQuote;
    private boolean isRevealed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockBackgroundNode(boolean z2, Node<R>... nodeArr) {
        super((Node[]) Arrays.copyOf(nodeArr, nodeArr.length));
        Intrinsics3.checkNotNullParameter(nodeArr, "children");
        this.inQuote = z2;
        this.isRevealed = true;
    }

    private final void ensureEndsWithNewline(SpannableStringBuilder builder) {
        if (builder.length() > 0) {
            char[] cArr = new char[6];
            builder.getChars(builder.length() - 1, builder.length(), cArr, 0);
            if (cArr[0] != '\n') {
                builder.append('\n');
            }
        }
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    /* renamed from: isRevealed, reason: from getter */
    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    public void setRevealed(boolean z2) {
        this.isRevealed = z2;
    }

    public void render(SpannableStringBuilder builder, R renderContext) {
        int spoilerColorRes;
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        ensureEndsWithNewline(builder);
        int length = builder.length();
        super.render(builder, (SpannableStringBuilder) renderContext);
        ensureEndsWithNewline(builder);
        Context context = renderContext.getContext();
        if (getIsRevealed()) {
            spoilerColorRes = ColorCompat.getThemedColor(context, R.attr.theme_chat_code);
        } else {
            if (!(renderContext instanceof SpoilerNode.RenderContext)) {
                renderContext = null;
            }
            SpoilerNode.RenderContext renderContext2 = (SpoilerNode.RenderContext) renderContext;
            spoilerColorRes = renderContext2 != null ? renderContext2.getSpoilerColorRes() : ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg);
        }
        builder.setSpan(new BlockBackgroundSpan(spoilerColorRes, ColorCompat.getThemedColor(context, R.attr.theme_chat_codeblock_border), DimenUtils.dpToPixels(1), DimenUtils.dpToPixels(4), this.inQuote ? BlockQuoteNode.INSTANCE.getTOTAL_LEFT_MARGIN() : 0), length, builder.length(), 33);
        builder.setSpan(new LeadingMarginSpan.Standard(15), length, builder.length(), 33);
        int iDpToPixels = DimenUtils.dpToPixels(5);
        builder.setSpan(new VerticalPaddingSpan(iDpToPixels, iDpToPixels), length, builder.length(), 33);
    }
}
