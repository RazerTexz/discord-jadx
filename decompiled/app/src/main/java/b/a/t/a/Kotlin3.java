package b.a.t.a;

import b.a.t.a.Kotlin2;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* compiled from: Kotlin.kt */
/* renamed from: b.a.t.a.p, reason: use source file name */
/* loaded from: classes.dex */
public final class Kotlin3<RC, S> extends Rule<RC, Node<RC>, S> {
    public final /* synthetic */ CodeStyleProviders a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kotlin3(Kotlin2.b.a aVar, CodeStyleProviders codeStyleProviders, Pattern pattern) {
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
        String strGroup4 = matcher.group(4);
        Intrinsics3.checkNotNull(strGroup);
        Intrinsics3.checkNotNull(strGroup3);
        Intrinsics3.checkNotNull(strGroup4);
        Kotlin2.b bVar = new Kotlin2.b(strGroup, strGroup2, strGroup3, strGroup4, this.a);
        Intrinsics3.checkNotNullParameter(bVar, "node");
        return new ParseSpec<>(bVar, s2);
    }
}
