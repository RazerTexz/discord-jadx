package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: QueryParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001JM\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0006\u0010\u0006\u001a\u00020\u00052\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/discord/utilities/search/query/parsing/QueryParser$Companion$getFromFilterRule$1", "Lcom/discord/simpleast/core/parser/Rule;", "Landroid/content/Context;", "Lcom/discord/utilities/search/query/node/QueryNode;", "", "Ljava/util/regex/Matcher;", "matcher", "Lcom/discord/simpleast/core/parser/Parser;", "parser", "state", "Lcom/discord/simpleast/core/parser/ParseSpec;", "parse", "(Ljava/util/regex/Matcher;Lcom/discord/simpleast/core/parser/Parser;Ljava/lang/Object;)Lcom/discord/simpleast/core/parser/ParseSpec;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.search.query.parsing.QueryParser$Companion$getFromFilterRule$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class QueryParser3 extends Rule<Context, QueryNode, Object> {
    public final /* synthetic */ Pattern $fromFilterPattern;
    public final /* synthetic */ CharSequence $localizedFrom;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser3(CharSequence charSequence, Pattern pattern, Pattern pattern2) {
        super(pattern2);
        this.$localizedFrom = charSequence;
        this.$fromFilterPattern = pattern;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        FilterNode filterNode = new FilterNode(FilterType.FROM, this.$localizedFrom);
        Intrinsics3.checkNotNullParameter(filterNode, "node");
        return new ParseSpec<>(filterNode, state);
    }
}
