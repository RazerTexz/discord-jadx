package com.discord.utilities.textprocessing.node;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.spans.QuoteSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BlockQuoteNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BlockQuoteNode;", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/BasicRenderContext;)V", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BlockQuoteNode<T extends BasicRenderContext> extends Node<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int GAP_WIDTH;
    private static final int STRIPE_WIDTH;
    private static final int TOTAL_LEFT_MARGIN;

    /* compiled from: BlockQuoteNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BlockQuoteNode$Companion;", "", "", "TOTAL_LEFT_MARGIN", "I", "getTOTAL_LEFT_MARGIN", "()I", "GAP_WIDTH", "STRIPE_WIDTH", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final int getTOTAL_LEFT_MARGIN() {
            return BlockQuoteNode.access$getTOTAL_LEFT_MARGIN$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        int iDpToPixels = DimenUtils.dpToPixels(3);
        STRIPE_WIDTH = iDpToPixels;
        int iDpToPixels2 = DimenUtils.dpToPixels(8);
        GAP_WIDTH = iDpToPixels2;
        TOTAL_LEFT_MARGIN = iDpToPixels + iDpToPixels2;
    }

    public BlockQuoteNode() {
        super(null, 1, null);
    }

    public static final /* synthetic */ int access$getTOTAL_LEFT_MARGIN$cp() {
        return TOTAL_LEFT_MARGIN;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        builder.append('\n');
        int iDpToPixels = DimenUtils.dpToPixels(8);
        builder.setSpan(new AbsoluteSizeSpan(iDpToPixels), builder.length() - 1, builder.length(), 33);
        int length = builder.length();
        Collection<Node<T>> children = getChildren();
        if (children != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).render(builder, renderContext);
            }
        }
        if (builder.length() == length) {
            builder.append(' ');
        }
        builder.setSpan(new QuoteSpan(ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_block_quote_divider), STRIPE_WIDTH, GAP_WIDTH), length, builder.length(), 13107233);
        builder.append('\n');
        builder.setSpan(new AbsoluteSizeSpan(iDpToPixels), builder.length() - 1, builder.length(), 13107233);
    }
}
