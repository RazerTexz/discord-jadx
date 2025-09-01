package d0.g0;

import d0.d0._Ranges;
import java.util.regex.Matcher;
import kotlin.ranges.Ranges2;
import kotlin.text.MatchResult;

/* compiled from: Regex.kt */
/* renamed from: d0.g0.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class Regex4 {
    public static final MatchResult access$findNext(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new Regex3(matcher, charSequence);
        }
        return null;
    }

    public static final MatchResult access$matchEntire(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new Regex3(matcher, charSequence);
        }
        return null;
    }

    public static final Ranges2 access$range(java.util.regex.MatchResult matchResult) {
        return _Ranges.until(matchResult.start(), matchResult.end());
    }

    public static final Ranges2 access$range(java.util.regex.MatchResult matchResult, int i) {
        return _Ranges.until(matchResult.start(i), matchResult.end(i));
    }
}
