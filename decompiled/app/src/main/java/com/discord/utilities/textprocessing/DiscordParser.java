package com.discord.utilities.textprocessing;

import android.content.Context;
import b.a.t.b.b.SimpleMarkdownRules2;
import b.a.t.b.b.SimpleMarkdownRules5;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.node.EditedMessageNode;
import com.discord.utilities.textprocessing.node.ZeroSpaceWidthNode;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: DiscordParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b \u0010!JA\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JU\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0019\u0010\u001aR.\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0017\u0012\u0004\u0012\u00020\u00180\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR.\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0017\u0012\u0004\u0012\u00020\u00180\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR.\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0017\u0012\u0004\u0012\u00020\u00180\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR.\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0017\u0012\u0004\u0012\u00020\u00180\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001c¨\u0006#"}, d2 = {"Lcom/discord/utilities/textprocessing/DiscordParser;", "", "Landroid/content/Context;", "context", "", "messageText", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "messageRenderContext", "Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "preprocessor", "Lcom/discord/utilities/textprocessing/DiscordParser$ParserOptions;", "parserOptions", "", "isEdited", "Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "parseChannelMessage", "(Landroid/content/Context;Ljava/lang/String;Lcom/discord/utilities/textprocessing/MessageRenderContext;Lcom/discord/utilities/textprocessing/MessagePreprocessor;Lcom/discord/utilities/textprocessing/DiscordParser$ParserOptions;Z)Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "allowMaskedLinks", "supportEntityMentions", "renderBlockQuotes", "renderHeaders", "renderLists", "Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageParseState;", "createParser", "(ZZZZZ)Lcom/discord/simpleast/core/parser/Parser;", "SAFE_LINK_PARSER", "Lcom/discord/simpleast/core/parser/Parser;", "REPLY_PARSER", "MASKED_LINK_PARSER", "FORUM_POST_FIRST_MESSAGE", "<init>", "()V", "ParserOptions", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DiscordParser {
    public static final DiscordParser INSTANCE = new DiscordParser();
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> SAFE_LINK_PARSER = createParser$default(false, true, false, false, false, 28, null);
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> MASKED_LINK_PARSER = createParser$default(true, true, false, false, false, 28, null);
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> REPLY_PARSER = createParser$default(false, true, false, false, false, 24, null);
    private static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> FORUM_POST_FIRST_MESSAGE = createParser$default(false, true, false, true, true, 4, null);

    /* compiled from: DiscordParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/utilities/textprocessing/DiscordParser$ParserOptions;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "ALLOW_MASKED_LINKS", "REPLY", "FORUM_POST_FIRST_MESSAGE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum ParserOptions {
        DEFAULT,
        ALLOW_MASKED_LINKS,
        REPLY,
        FORUM_POST_FIRST_MESSAGE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ParserOptions.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[ParserOptions.DEFAULT.ordinal()] = 1;
            iArr[ParserOptions.ALLOW_MASKED_LINKS.ordinal()] = 2;
            iArr[ParserOptions.REPLY.ordinal()] = 3;
            iArr[ParserOptions.FORUM_POST_FIRST_MESSAGE.ordinal()] = 4;
        }
    }

    private DiscordParser() {
    }

    public static final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> createParser(boolean allowMaskedLinks, boolean supportEntityMentions, boolean renderBlockQuotes, boolean renderHeaders, boolean renderLists) {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser = new Parser<>(false, 1, null);
        Rules rules = Rules.INSTANCE;
        parser.addRule(rules.createSoftHyphenRule());
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.h;
        Pattern pattern = SimpleMarkdownRules5.f;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_ESCAPE");
        parser.addRule(new SimpleMarkdownRules2(simpleMarkdownRules5, pattern));
        if (renderBlockQuotes) {
            parser.addRule(rules.createBlockQuoteRule());
        }
        parser.addRule(rules.createCodeBlockRule());
        parser.addRule(rules.createInlineCodeRule());
        parser.addRule(rules.createSpoilerRule());
        if (allowMaskedLinks) {
            parser.addRule(rules.createMaskedLinkRule());
        }
        parser.addRule(rules.createUrlNoEmbedRule());
        parser.addRule(rules.createUrlRule());
        parser.addRule(rules.createCustomEmojiRule());
        parser.addRule(rules.createNamedEmojiRule());
        parser.addRule(rules.createUnescapeEmoticonRule());
        if (supportEntityMentions) {
            parser.addRule(rules.createChannelMentionRule());
            parser.addRule(rules.createRoleMentionRule());
            parser.addRule(rules.createUserMentionRule());
        }
        parser.addRule(rules.createUnicodeEmojiRule());
        parser.addRule(rules.createTimestampRule());
        if (renderHeaders) {
            parser.addRule(rules.createHeaderItemRule());
        }
        if (renderLists) {
            parser.addRule(rules.createListItemRule());
        }
        parser.addRules(SimpleMarkdownRules5.a(false, false));
        parser.addRule(rules.createTextReplacementRule());
        return parser;
    }

    public static /* synthetic */ Parser createParser$default(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 4) != 0) {
            z4 = true;
        }
        if ((i & 8) != 0) {
            z5 = false;
        }
        if ((i & 16) != 0) {
            z6 = false;
        }
        return createParser(z2, z3, z4, z5, z6);
    }

    public static final DraweeSpanStringBuilder parseChannelMessage(Context context, String messageText, MessageRenderContext messageRenderContext, MessagePreprocessor preprocessor, ParserOptions parserOptions, boolean isEdited) {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(messageRenderContext, "messageRenderContext");
        Intrinsics3.checkNotNullParameter(preprocessor, "preprocessor");
        Intrinsics3.checkNotNullParameter(parserOptions, "parserOptions");
        int iOrdinal = parserOptions.ordinal();
        if (iOrdinal == 0) {
            parser = SAFE_LINK_PARSER;
        } else if (iOrdinal == 1) {
            parser = MASKED_LINK_PARSER;
        } else if (iOrdinal == 2) {
            parser = REPLY_PARSER;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            parser = FORUM_POST_FIRST_MESSAGE;
        }
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser2 = parser;
        if (messageText == null) {
            messageText = "";
        }
        List list = Parser.parse$default(parser2, messageText, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
        preprocessor.process(list);
        if (isEdited) {
            list.add(new EditedMessageNode(context));
        }
        list.add(new ZeroSpaceWidthNode());
        return AstRenderer.render(list, messageRenderContext);
    }
}
