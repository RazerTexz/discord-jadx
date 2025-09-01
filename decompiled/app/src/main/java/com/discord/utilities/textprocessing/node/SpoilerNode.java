package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.SpoilerNode.RenderContext;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import defpackage.SpoilerSpan;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SpoilerNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u0001$B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\"\u0010#J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\r\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "Lcom/discord/utilities/textprocessing/node/SpoilerNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/node/Spoilerable;", "renderContext", "", "", "createStyles", "(Lcom/discord/utilities/textprocessing/node/SpoilerNode$RenderContext;)Ljava/util/List;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "", "isRevealed", "", "updateState", "(IZ)V", "Landroid/text/SpannableStringBuilder;", "builder", "render", "(Landroid/text/SpannableStringBuilder;Lcom/discord/utilities/textprocessing/node/SpoilerNode$RenderContext;)V", "<set-?>", "I", "getId", "()I", "Z", "()Z", "setRevealed", "(Z)V", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "RenderContext", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SpoilerNode<T extends RenderContext> extends Node<T> implements Spoilerable {
    private final String content;
    private int id;
    private boolean isRevealed;

    /* compiled from: SpoilerNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R(\u0010\u000b\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/textprocessing/node/SpoilerNode$RenderContext;", "Lcom/discord/utilities/textprocessing/node/BasicRenderContext;", "", "getSpoilerColorRes", "()I", "spoilerColorRes", "Lkotlin/Function1;", "Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "", "getSpoilerOnClick", "()Lkotlin/jvm/functions/Function1;", "spoilerOnClick", "getSpoilerRevealedColorRes", "spoilerRevealedColorRes", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface RenderContext extends BasicRenderContext {
        int getSpoilerColorRes();

        Function1<SpoilerNode<?>, Unit> getSpoilerOnClick();

        int getSpoilerRevealedColorRes();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpoilerNode(String str) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(str, "content");
        this.content = str;
        this.id = -1;
    }

    private final List<Object> createStyles(T renderContext) {
        Context context = renderContext.getContext();
        SpoilerSpan spoilerSpan = new SpoilerSpan(renderContext.getSpoilerColorRes(), renderContext.getSpoilerRevealedColorRes(), getIsRevealed());
        if (getIsRevealed()) {
            return CollectionsJVM.listOf(spoilerSpan);
        }
        Object[] objArr = new Object[2];
        objArr[0] = spoilerSpan;
        Function1<SpoilerNode<?>, Unit> spoilerOnClick = renderContext.getSpoilerOnClick();
        objArr[1] = spoilerOnClick != null ? new ClickableSpan(Integer.valueOf(ColorCompat.getColor(context, R.color.transparent)), false, null, new SpoilerNode2(spoilerOnClick, this, context), 4, null) : null;
        return Collections2.listOfNotNull(objArr);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getId() {
        return this.id;
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    /* renamed from: isRevealed, reason: from getter */
    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (SpannableStringBuilder) obj);
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    public void setRevealed(boolean z2) {
        this.isRevealed = z2;
    }

    public final void updateState(int id2, boolean isRevealed) {
        this.id = id2;
        setRevealed(isRevealed);
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        int length = builder.length();
        Collection<Node<T>> children = getChildren();
        if (children != null) {
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).render(builder, renderContext);
            }
        }
        if (!getIsRevealed()) {
            Object[] spans = builder.getSpans(length, builder.length(), ClickableSpan.class);
            Intrinsics3.checkNotNullExpressionValue(spans, "builder.getSpans(startIn…lickableSpan::class.java)");
            for (Object obj : spans) {
                builder.removeSpan((ClickableSpan) obj);
            }
        }
        Iterator<T> it2 = createStyles(renderContext).iterator();
        while (it2.hasNext()) {
            builder.setSpan(it2.next(), length, builder.length(), 33);
        }
    }
}
