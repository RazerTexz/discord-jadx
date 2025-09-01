package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.spans.VerticalPaddingSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: HeaderNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/textprocessing/node/HeaderNode;", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/BasicRenderContext;)V", "", "numHeaderIndicators", "I", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class HeaderNode<T extends BasicRenderContext> extends Node<T> {
    private final int numHeaderIndicators;

    public HeaderNode(int i) {
        super(null, 1, null);
        this.numHeaderIndicators = i;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        Context context = renderContext.getContext();
        int length = builder.length();
        Collection<Node<T>> children = getChildren();
        if (children != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).render(builder, renderContext);
            }
        }
        int i = this.numHeaderIndicators;
        int i2 = i != 1 ? i != 2 ? R.dimen.markdown_messages_header_3_top_padding : R.dimen.markdown_messages_header_2_top_padding : R.dimen.markdown_messages_header_1_top_padding;
        int i3 = i != 1 ? i != 2 ? R.dimen.markdown_messages_header_3_bottom_padding : R.dimen.markdown_messages_header_2_bottom_padding : R.dimen.markdown_messages_header_1_bottom_padding;
        TextAppearanceSpan textAppearanceSpan = i != 1 ? i != 2 ? new TextAppearanceSpan(context, 2131952044) : new TextAppearanceSpan(context, 2131952043) : new TextAppearanceSpan(context, 2131952042);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(textAppearanceSpan);
        arrayList.add(new VerticalPaddingSpan(context.getResources().getDimensionPixelSize(i2), context.getResources().getDimensionPixelSize(i3)));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            builder.setSpan(it2.next(), length, builder.length(), 33);
        }
    }
}
