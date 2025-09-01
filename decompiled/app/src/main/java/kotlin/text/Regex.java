package kotlin.text;

import b.d.b.a.outline;
import d0.f0.n;
import d0.g0.Regex4;
import d0.g0.Regex5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* compiled from: Regex.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002/0B\u0011\b\u0001\u0012\u0006\u0010&\u001a\u00020\u001f¢\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0016¢\u0006\u0004\b(\u0010+B\u0019\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0016\u0012\u0006\u0010,\u001a\u00020#¢\u0006\u0004\b(\u0010-J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u001a¢\u0006\u0004\b\u0018\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u00061"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "", "input", "", "matches", "(Ljava/lang/CharSequence;)Z", "containsMatchIn", "", "startIndex", "Lkotlin/text/MatchResult;", "find", "(Ljava/lang/CharSequence;I)Lkotlin/text/MatchResult;", "Lkotlin/sequences/Sequence;", "findAll", "(Ljava/lang/CharSequence;I)Lkotlin/sequences/Sequence;", "matchEntire", "(Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;", "", "replacement", "replace", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Function1;", "transform", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "Ljava/util/regex/Pattern;", "toPattern", "()Ljava/util/regex/Pattern;", "", "Ld0/g0/i;", "_options", "Ljava/util/Set;", "nativePattern", "Ljava/util/regex/Pattern;", "<init>", "(Ljava/util/regex/Pattern;)V", "pattern", "(Ljava/lang/String;)V", "option", "(Ljava/lang/String;Ld0/g0/i;)V", "j", "a", "b", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class Regex implements Serializable {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<? extends Regex5> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* renamed from: kotlin.text.Regex$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$ensureUnicodeCase(Companion companion, int i) {
            Objects.requireNonNull(companion);
            return (i & 2) != 0 ? i | 64 : i;
        }

        public final String escape(String str) {
            Intrinsics3.checkNotNullParameter(str, "literal");
            String strQuote = Pattern.quote(str);
            Intrinsics3.checkNotNullExpressionValue(strQuote, "Pattern.quote(literal)");
            return strQuote;
        }
    }

    /* compiled from: Regex.kt */
    public static final class b implements Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* compiled from: Regex.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        static {
            new a(null);
        }

        public b(String str, int i) {
            Intrinsics3.checkNotNullParameter(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern, flags)");
            return new Regex(patternCompile);
        }
    }

    /* compiled from: Regex.kt */
    public static final class c extends Lambda implements Function0<MatchResult> {
        public final /* synthetic */ CharSequence $input;
        public final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence, int i) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MatchResult invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2() {
            return Regex.this.find(this.$input, this.$startIndex);
        }
    }

    /* compiled from: Regex.kt */
    public static final /* synthetic */ class d extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final d j = new d();

        public d() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MatchResult invoke(MatchResult matchResult) {
            return invoke2(matchResult);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2(MatchResult matchResult) {
            Intrinsics3.checkNotNullParameter(matchResult, "p1");
            return matchResult.next();
        }
    }

    public Regex(Pattern pattern) {
        Intrinsics3.checkNotNullParameter(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        Intrinsics3.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return new b(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics3.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return Regex4.access$findNext(matcher, startIndex, input);
    }

    public final Sequence<MatchResult> findAll(CharSequence input, int startIndex) {
        Intrinsics3.checkNotNullParameter(input, "input");
        if (startIndex >= 0 && startIndex <= input.length()) {
            return n.generateSequence((Function0) new c(input, startIndex), (Function1) d.j);
        }
        StringBuilder sbV = outline.V("Start index out of bounds: ", startIndex, ", input length: ");
        sbV.append(input.length());
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final MatchResult matchEntire(CharSequence input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics3.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return Regex4.access$matchEntire(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics3.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    /* renamed from: toPattern, reason: from getter */
    public final Pattern getNativePattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str) {
        Intrinsics3.checkNotNullParameter(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(transform, "transform");
        int iIntValue = 0;
        MatchResult matchResultFind$default = find$default(this, input, 0, 2, null);
        if (matchResultFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            Intrinsics3.checkNotNull(matchResultFind$default);
            sb.append(input, iIntValue, matchResultFind$default.getRange().getStart().intValue());
            sb.append(transform.invoke(matchResultFind$default));
            iIntValue = matchResultFind$default.getRange().getEndInclusive().intValue() + 1;
            matchResultFind$default = matchResultFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (matchResultFind$default != null);
        if (iIntValue < length) {
            sb.append(input, iIntValue, length);
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str, Regex5 regex5) {
        Intrinsics3.checkNotNullParameter(str, "pattern");
        Intrinsics3.checkNotNullParameter(regex5, "option");
        Pattern patternCompile = Pattern.compile(str, Companion.access$ensureUnicodeCase(INSTANCE, regex5.getValue()));
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(patternCompile);
    }
}
