package com.discord.utilities.search.query.node.content;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.search.query.node.QueryNode;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ContentNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fB\u0019\b\u0016\u0012\u0006\u0010 \u001a\u00020\u0000\u0012\u0006\u0010!\u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u000f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000b¨\u0006#"}, d2 = {"Lcom/discord/utilities/search/query/node/content/ContentNode;", "Lcom/discord/utilities/search/query/node/QueryNode;", "Landroid/text/SpannableStringBuilder;", "builder", "Landroid/content/Context;", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Landroid/content/Context;)V", "", "component1", "()Ljava/lang/CharSequence;", "content", "copy", "(Ljava/lang/CharSequence;)Lcom/discord/utilities/search/query/node/content/ContentNode;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getText", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Ljava/lang/CharSequence;", "getContent", "<init>", "(Ljava/lang/CharSequence;)V", "node1", "node2", "(Lcom/discord/utilities/search/query/node/content/ContentNode;Lcom/discord/utilities/search/query/node/content/ContentNode;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ContentNode extends QueryNode {
    private final CharSequence content;

    public ContentNode(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "content");
        this.content = charSequence;
    }

    public static /* synthetic */ ContentNode copy$default(ContentNode contentNode, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = contentNode.content;
        }
        return contentNode.copy(charSequence);
    }

    /* renamed from: component1, reason: from getter */
    public final CharSequence getContent() {
        return this.content;
    }

    public final ContentNode copy(CharSequence content) {
        Intrinsics3.checkNotNullParameter(content, "content");
        return new ContentNode(content);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ContentNode) && Intrinsics3.areEqual(this.content, ((ContentNode) other).content);
        }
        return true;
    }

    public final CharSequence getContent() {
        return this.content;
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    public int hashCode() {
        CharSequence charSequence = this.content;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Context context) {
        render2(spannableStringBuilder, context);
    }

    public String toString() {
        return outline.E(outline.U("ContentNode(content="), this.content, ")");
    }

    public ContentNode(ContentNode contentNode, ContentNode contentNode2) {
        Intrinsics3.checkNotNullParameter(contentNode, "node1");
        Intrinsics3.checkNotNullParameter(contentNode2, "node2");
        StringBuilder sb = new StringBuilder();
        sb.append(contentNode.content);
        sb.append(' ');
        sb.append(contentNode2.content);
        this(sb.toString());
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public String getText() {
        return this.content.toString();
    }

    /* renamed from: render, reason: avoid collision after fix types in other method */
    public void render2(SpannableStringBuilder builder, Context renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        builder.append(this.content).append(' ');
    }
}
