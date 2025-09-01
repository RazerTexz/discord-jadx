package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.BulletSpan;
import com.discord.utilities.spans.VerticalPaddingSpan;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: BulletListNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u0012*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0012B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/textprocessing/node/BulletListNode;", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node;", "Landroid/text/SpannableStringBuilder;", "builder", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/BasicRenderContext;)V", "", "nestedLevel", "I", "", "includesNewline", "Z", "<init>", "(IZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BulletListNode<T extends BasicRenderContext> extends Node<T> {
    private static final int MARKDOWN_BULLET_RADIUS = 8;
    private final boolean includesNewline;
    private final int nestedLevel;

    public BulletListNode(int i, boolean z2) {
        super(null, 1, null);
        this.nestedLevel = i;
        this.includesNewline = z2;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) throws Resources.NotFoundException {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    public void render(SpannableStringBuilder builder, T renderContext) throws Resources.NotFoundException {
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
        ArrayList arrayList = new ArrayList(3);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_gap);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_gap) * this.nestedLevel;
        int themedColor = ColorCompat.getThemedColor(context, R.attr.primary_400);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_vertical_padding);
        Paint.Style style = this.nestedLevel > 1 ? Paint.Style.STROKE : Paint.Style.FILL;
        arrayList.add(new VerticalPaddingSpan(dimensionPixelSize3, dimensionPixelSize3));
        arrayList.add(new LeadingMarginSpan.Standard(dimensionPixelSize2));
        arrayList.add(new BulletSpan(dimensionPixelSize, themedColor, 8, 0.0f, style, 8, null));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            builder.setSpan(it2.next(), length, builder.length(), 33);
        }
        if (this.includesNewline) {
            builder.append("\n");
        }
    }
}
