package com.discord.utilities.search.query.node.filter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.widgets.chat.input.MentionUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: FilterNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0010\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u000b¨\u0006$"}, d2 = {"Lcom/discord/utilities/search/query/node/filter/FilterNode;", "Lcom/discord/utilities/search/query/node/QueryNode;", "Landroid/text/SpannableStringBuilder;", "builder", "Landroid/content/Context;", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Landroid/content/Context;)V", "Lcom/discord/utilities/search/query/FilterType;", "component1", "()Lcom/discord/utilities/search/query/FilterType;", "", "component2", "()Ljava/lang/CharSequence;", "filterType", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "copy", "(Lcom/discord/utilities/search/query/FilterType;Ljava/lang/CharSequence;)Lcom/discord/utilities/search/query/node/filter/FilterNode;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/CharSequence;", "getText", "Lcom/discord/utilities/search/query/FilterType;", "getFilterType", "<init>", "(Lcom/discord/utilities/search/query/FilterType;Ljava/lang/CharSequence;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class FilterNode extends QueryNode {
    private final FilterType filterType;
    private final CharSequence text;

    public FilterNode(FilterType filterType, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.filterType = filterType;
        this.text = charSequence;
    }

    public static /* synthetic */ FilterNode copy$default(FilterNode filterNode, FilterType filterType, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            filterType = filterNode.filterType;
        }
        if ((i & 2) != 0) {
            charSequence = filterNode.getText();
        }
        return filterNode.copy(filterType, charSequence);
    }

    /* renamed from: component1, reason: from getter */
    public final FilterType getFilterType() {
        return this.filterType;
    }

    public final CharSequence component2() {
        return getText();
    }

    public final FilterNode copy(FilterType filterType, CharSequence text) {
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new FilterNode(filterType, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterNode)) {
            return false;
        }
        FilterNode filterNode = (FilterNode) other;
        return Intrinsics3.areEqual(this.filterType, filterNode.filterType) && Intrinsics3.areEqual(getText(), filterNode.getText());
    }

    public final FilterType getFilterType() {
        return this.filterType;
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public CharSequence getText() {
        return this.text;
    }

    public int hashCode() {
        FilterType filterType = this.filterType;
        int iHashCode = (filterType != null ? filterType.hashCode() : 0) * 31;
        CharSequence text = getText();
        return iHashCode + (text != null ? text.hashCode() : 0);
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Context context) {
        render2(spannableStringBuilder, context);
    }

    public String toString() {
        StringBuilder sbU = outline.U("FilterNode(filterType=");
        sbU.append(this.filterType);
        sbU.append(", text=");
        sbU.append(getText());
        sbU.append(")");
        return sbU.toString();
    }

    /* renamed from: render, reason: avoid collision after fix types in other method */
    public void render2(SpannableStringBuilder builder, Context renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        Typeface themedFont = FontUtils.INSTANCE.getThemedFont(renderContext, R.attr.font_primary_bold);
        TypefaceSpanCompat typefaceSpanCompat = themedFont != null ? new TypefaceSpanCompat(themedFont) : null;
        int length = builder.length();
        StringBuilder sb = new StringBuilder();
        sb.append(getText());
        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        builder.append((CharSequence) sb.toString());
        builder.setSpan(typefaceSpanCompat, length, builder.length(), 33);
    }
}
