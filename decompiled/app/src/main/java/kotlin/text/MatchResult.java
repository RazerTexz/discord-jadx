package kotlin.text;

import d0.g0.MatchResult2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.Ranges2;

/* compiled from: MatchResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lkotlin/text/MatchResult;", "", "next", "()Lkotlin/text/MatchResult;", "Ld0/g0/f;", "getGroups", "()Ld0/g0/f;", "groups", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "range", "Lkotlin/text/MatchResult$b;", "getDestructured", "()Lkotlin/text/MatchResult$b;", "destructured", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues", "getValue", "()Ljava/lang/String;", "value", "b", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public interface MatchResult {

    /* compiled from: MatchResult.kt */
    public static final class a {
        public static b getDestructured(MatchResult matchResult) {
            return new b(matchResult);
        }
    }

    /* compiled from: MatchResult.kt */
    public static final class b {
        public final MatchResult a;

        public b(MatchResult matchResult) {
            Intrinsics3.checkNotNullParameter(matchResult, "match");
            this.a = matchResult;
        }

        public final MatchResult getMatch() {
            return this.a;
        }
    }

    b getDestructured();

    List<String> getGroupValues();

    MatchResult2 getGroups();

    Ranges2 getRange();

    String getValue();

    MatchResult next();
}
