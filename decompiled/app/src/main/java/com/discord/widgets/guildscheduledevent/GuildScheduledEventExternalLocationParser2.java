package com.discord.widgets.guildscheduledevent;

import b.a.t.b.b.SimpleMarkdownRules5;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.Rules;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GuildScheduledEventExternalLocationParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageParseState;", "invoke", "()Lcom/discord/simpleast/core/parser/Parser;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventExternalLocationParser$Companion$PARSER$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventExternalLocationParser2 extends Lambda implements Function0<Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState>> {
    public static final GuildScheduledEventExternalLocationParser2 INSTANCE = new GuildScheduledEventExternalLocationParser2();

    public GuildScheduledEventExternalLocationParser2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser = new Parser<>(false, 1, null);
        parser.addRule(Rules.INSTANCE.createUrlRule());
        parser.addRule(SimpleMarkdownRules5.h.d());
        return parser;
    }
}
