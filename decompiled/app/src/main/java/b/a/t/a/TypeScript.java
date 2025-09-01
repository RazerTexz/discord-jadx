package b.a.t.a;

import b.a.t.a.TypeScript2;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* compiled from: TypeScript.kt */
/* renamed from: b.a.t.a.q, reason: use source file name */
/* loaded from: classes.dex */
public final class TypeScript<RC, S> extends Rule<RC, Node<RC>, S> {
    public final /* synthetic */ CodeStyleProviders a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeScript(TypeScript2.a.C0021a c0021a, CodeStyleProviders codeStyleProviders, Pattern pattern) {
        super(pattern);
        this.a = codeStyleProviders;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        String strGroup3 = matcher.group(3);
        Intrinsics3.checkNotNull(strGroup);
        Intrinsics3.checkNotNull(strGroup2);
        TypeScript2.a aVar = new TypeScript2.a(strGroup, strGroup2, strGroup3, this.a);
        Intrinsics3.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, s2);
    }
}
