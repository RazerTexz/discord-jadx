package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.input.MentionUtils;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: QueryParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/discord/utilities/search/query/parsing/QueryParser;", "Lcom/discord/simpleast/core/parser/Parser;", "Landroid/content/Context;", "Lcom/discord/utilities/search/query/node/QueryNode;", "", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "<init>", "(Lcom/discord/utilities/search/strings/SearchStringProvider;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class QueryParser extends Parser<Context, QueryNode, Object> {
    private static final String ANY_TOKEN_REGEX = "^[\\s]*[\\S]*[\\s]*";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String IN_ANSWER_REGEX = "(?:\\s*#([^ ]+))";
    private static final String USER_REGEX = "(?:\\s*([^@#:]+)#([0-9]{4}))";

    /* compiled from: QueryParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\bJ)\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\bJ)\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\bJ)\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\u0019\u0010\nR\u0016\u0010\u001a\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b¨\u0006 "}, d2 = {"Lcom/discord/utilities/search/query/parsing/QueryParser$Companion;", "", "", "localizedFrom", "Lcom/discord/simpleast/core/parser/Rule;", "Landroid/content/Context;", "Lcom/discord/utilities/search/query/node/QueryNode;", "getFromFilterRule", "(Ljava/lang/CharSequence;)Lcom/discord/simpleast/core/parser/Rule;", "getUserRule", "()Lcom/discord/simpleast/core/parser/Rule;", "getContentRule", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "", "createHasAnswerRegex", "(Lcom/discord/utilities/search/strings/SearchStringProvider;)Ljava/lang/String;", "localizedMentions", "getMentionsFilterRule", "localizedIn", "getInFilterRule", "localizedHas", "getHasFilterRule", "getHasAnswerRule", "(Lcom/discord/utilities/search/strings/SearchStringProvider;)Lcom/discord/simpleast/core/parser/Rule;", "getInAnswerRule", "ANY_TOKEN_REGEX", "Ljava/lang/String;", "IN_ANSWER_REGEX", "USER_REGEX", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Rule access$getContentRule(Companion companion) {
            return companion.getContentRule();
        }

        public static final /* synthetic */ Rule access$getFromFilterRule(Companion companion, CharSequence charSequence) {
            return companion.getFromFilterRule(charSequence);
        }

        public static final /* synthetic */ Rule access$getUserRule(Companion companion) {
            return companion.getUserRule();
        }

        private final String createHasAnswerRegex(SearchStringProvider searchStringProvider) {
            HasNode2.values();
            ArrayList arrayList = new ArrayList(7);
            HasNode2[] hasNode2ArrValues = HasNode2.values();
            for (int i = 0; i < 7; i++) {
                arrayList.add(hasNode2ArrValues[i].getLocalizedInputText(searchStringProvider));
            }
            StringBuilder sb = new StringBuilder("(?:\\s*(");
            int size = arrayList.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((CharSequence) arrayList.get(i2));
                sb.append('|');
            }
            sb.append((CharSequence) arrayList.get(arrayList.size() - 1));
            sb.append("))");
            String string = sb.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        }

        private final Rule<Context, QueryNode, Object> getContentRule() {
            Pattern patternCompile = Pattern.compile(QueryParser.ANY_TOKEN_REGEX, 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "simpleTextPattern");
            return new QueryParser2(patternCompile, patternCompile);
        }

        private final Rule<Context, QueryNode, Object> getFromFilterRule(CharSequence localizedFrom) {
            Pattern patternCompile = Pattern.compile('^' + ("[\\s]*?(" + localizedFrom + "):"), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "fromFilterPattern");
            return new QueryParser3(localizedFrom, patternCompile, patternCompile);
        }

        private final Rule<Context, QueryNode, Object> getUserRule() {
            Pattern patternCompile = Pattern.compile("^(?:\\s*([^@#:]+)#([0-9]{4}))", 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
            return new QueryParser9(patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getHasAnswerRule(SearchStringProvider searchStringProvider) {
            Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            Pattern patternCompile = Pattern.compile('^' + createHasAnswerRegex(searchStringProvider), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "hasAnswerPattern");
            return new QueryParser4(searchStringProvider, patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getHasFilterRule(CharSequence localizedHas) {
            Intrinsics3.checkNotNullParameter(localizedHas, "localizedHas");
            Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedHas + MentionUtils.EMOJIS_AND_STICKERS_CHAR), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "hasFilterPattern");
            return new QueryParser5(localizedHas, patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getInAnswerRule() {
            Pattern patternCompile = Pattern.compile("^(?:\\s*#([^ ]+))", 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "inAnswerPattern");
            return new QueryParser6(patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getInFilterRule(CharSequence localizedIn) {
            Intrinsics3.checkNotNullParameter(localizedIn, "localizedIn");
            Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedIn + MentionUtils.EMOJIS_AND_STICKERS_CHAR), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "fromUserPattern");
            return new QueryParser7(localizedIn, patternCompile, patternCompile);
        }

        public final Rule<Context, QueryNode, Object> getMentionsFilterRule(CharSequence localizedMentions) {
            Intrinsics3.checkNotNullParameter(localizedMentions, "localizedMentions");
            Pattern patternCompile = Pattern.compile('^' + ("^[\\s]*?" + localizedMentions + MentionUtils.EMOJIS_AND_STICKERS_CHAR), 64);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "mentionsFilterPattern");
            return new QueryParser8(localizedMentions, patternCompile, patternCompile);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser(SearchStringProvider searchStringProvider) {
        super(false, 1, null);
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Companion companion = INSTANCE;
        addRule(Companion.access$getUserRule(companion)).addRule(Companion.access$getFromFilterRule(companion, searchStringProvider.getFromFilterString())).addRule(companion.getMentionsFilterRule(searchStringProvider.getMentionsFilterString())).addRule(companion.getHasFilterRule(searchStringProvider.getHasFilterString())).addRule(companion.getHasAnswerRule(searchStringProvider)).addRule(companion.getInFilterRule(searchStringProvider.getInFilterString())).addRule(companion.getInAnswerRule()).addRule(Companion.access$getContentRule(companion));
    }
}
