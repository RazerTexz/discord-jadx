package com.discord.widgets.changelog;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.b.SimpleMarkdownRules5;
import b.a.t.c.MarkdownRules;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.ChangelogSpans;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.Rules;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: ChangeLogParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\t\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJA\u0010\u000b\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\nJI\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2 \u0010\u0013\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/changelog/ChangeLogParser;", "", "RC", ExifInterface.LATITUDE_SOUTH, "Landroid/content/Context;", "context", "", "Lcom/discord/simpleast/core/parser/Rule;", "Lcom/discord/simpleast/core/node/Node;", "createMarkdownRules", "(Landroid/content/Context;)Ljava/util/List;", "createChangelogSpecialMarkdownRules", "", "input", "", "changeLogRules", "Lkotlin/Function3;", "", "", "onClickListener", "Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "parse", "(Landroid/content/Context;Ljava/lang/CharSequence;ZLkotlin/jvm/functions/Function3;)Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChangeLogParser {
    public static final ChangeLogParser INSTANCE = new ChangeLogParser();

    private ChangeLogParser() {
    }

    private final <RC, S> List<Rule<RC, Node<RC>, S>> createChangelogSpecialMarkdownRules(Context context) {
        ChangelogSpans changelogSpans = ChangelogSpans.INSTANCE;
        return Collections2.listOf((Object[]) new Rule.BlockRule[]{new Rules.HeaderLineClassedRule(changelogSpans.createChangelogSpecialHeaderPaddingSpansProvider(context), changelogSpans.createHeaderStyleSpanProvider(context), changelogSpans.createHeaderClassSpanProvider(context)), new Rules.HeaderLineClassedRule(changelogSpans.createHeaderPaddingSpansProvider(context), changelogSpans.createSpecialHeaderStyleSpanProvider(context), changelogSpans.createHeaderClassSpanProvider(context)), new Rules.MarkdownListItemRule(changelogSpans.createMarkdownBulletSpansProvider(context))});
    }

    private final <RC, S> List<Rule<RC, Node<RC>, S>> createMarkdownRules(Context context) {
        ChangelogSpans changelogSpans = ChangelogSpans.INSTANCE;
        return Collections2.listOf((Object[]) new Rule.BlockRule[]{new MarkdownRules.c(changelogSpans.createHeaderStyleSpanProvider(context)), new Rules.HeaderLineClassedRule(changelogSpans.createHeaderPaddingSpansProvider(context), changelogSpans.createHeaderStyleSpanProvider(context), changelogSpans.createHeaderClassSpanProvider(context)), new Rules.MarkdownListItemRule(changelogSpans.createMarkdownBulletSpansProvider(context))});
    }

    public static /* synthetic */ DraweeSpanStringBuilder parse$default(ChangeLogParser changeLogParser, Context context, CharSequence charSequence, boolean z2, Function3 function3, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return changeLogParser.parse(context, charSequence, z2, function3);
    }

    public final DraweeSpanStringBuilder parse(Context context, CharSequence input, boolean changeLogRules, Function3<? super Context, ? super String, ? super String, Unit> onClickListener) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        List listB = SimpleMarkdownRules5.b(false, false, 3);
        List listCreateChangelogSpecialMarkdownRules = changeLogRules ? createChangelogSpecialMarkdownRules(context) : createMarkdownRules(context);
        Parser parser = new Parser(false, 1, null);
        Rules rules = Rules.INSTANCE;
        return AstRenderer.render(Parser.parse$default(parser.addRule(rules.createSoftHyphenRule()).addRule(rules.createBlockQuoteRule()).addRule(rules.createMaskedLinkRule()).addRule(rules.createUrlNoEmbedRule()).addRule(rules.createUrlRule()).addRule(rules.createHookedLinkRule()).addRules(listCreateChangelogSpecialMarkdownRules).addRules(listB), input, MessageParseState.INSTANCE.getInitialState(), null, 4, null), new ChangeLogParser2(onClickListener, context));
    }
}
