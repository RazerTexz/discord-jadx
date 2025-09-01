package d0.g0;

import d0.f0._Sequences2;
import d0.t.AbstractCollection;
import d0.t.AbstractList;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;
import kotlin.text.MatchResult;

/* compiled from: Regex.kt */
/* renamed from: d0.g0.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class Regex3 implements MatchResult {
    public final MatchResult2 a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f3582b;
    public final Matcher c;
    public final CharSequence d;

    /* compiled from: Regex.kt */
    /* renamed from: d0.g0.g$a */
    public static final class a extends AbstractList<String> {
        public a() {
        }

        @Override // d0.t.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return contains((String) obj);
            }
            return false;
        }

        @Override // d0.t.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return get(i);
        }

        @Override // d0.t.AbstractCollection
        public int getSize() {
            return Regex3.access$getMatchResult$p(Regex3.this).groupCount() + 1;
        }

        @Override // d0.t.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return indexOf((String) obj);
            }
            return -1;
        }

        @Override // d0.t.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return lastIndexOf((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains((Object) str);
        }

        @Override // d0.t.AbstractList, java.util.List
        public String get(int i) {
            String strGroup = Regex3.access$getMatchResult$p(Regex3.this).group(i);
            return strGroup != null ? strGroup : "";
        }

        public /* bridge */ int indexOf(String str) {
            return super.indexOf((Object) str);
        }

        public /* bridge */ int lastIndexOf(String str) {
            return super.lastIndexOf((Object) str);
        }
    }

    /* compiled from: Regex.kt */
    /* renamed from: d0.g0.g$b */
    public static final class b extends AbstractCollection<Regex2> implements MatchResult2 {

        /* compiled from: Regex.kt */
        /* renamed from: d0.g0.g$b$a */
        public static final class a extends Lambda implements Function1<Integer, Regex2> {
            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Regex2 invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Regex2 invoke(int i) {
                return b.this.get(i);
            }
        }

        public b() {
        }

        @Override // d0.t.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj != null ? obj instanceof Regex2 : true) {
                return contains((Regex2) obj);
            }
            return false;
        }

        public Regex2 get(int i) {
            Ranges2 ranges2Access$range = Regex4.access$range(Regex3.access$getMatchResult$p(Regex3.this), i);
            if (ranges2Access$range.getStart().intValue() < 0) {
                return null;
            }
            String strGroup = Regex3.access$getMatchResult$p(Regex3.this).group(i);
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matchResult.group(index)");
            return new Regex2(strGroup, ranges2Access$range);
        }

        @Override // d0.t.AbstractCollection
        public int getSize() {
            return Regex3.access$getMatchResult$p(Regex3.this).groupCount() + 1;
        }

        @Override // d0.t.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<Regex2> iterator() {
            return _Sequences2.map(_Collections.asSequence(Collections2.getIndices(this)), new a()).iterator();
        }

        public /* bridge */ boolean contains(Regex2 regex2) {
            return super.contains((Object) regex2);
        }
    }

    public Regex3(Matcher matcher, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(charSequence, "input");
        this.c = matcher;
        this.d = charSequence;
        this.a = new b();
    }

    public static final java.util.regex.MatchResult access$getMatchResult$p(Regex3 regex3) {
        return regex3.c;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult.b getDestructured() {
        return MatchResult.a.getDestructured(this);
    }

    @Override // kotlin.text.MatchResult
    public List<String> getGroupValues() {
        if (this.f3582b == null) {
            this.f3582b = new a();
        }
        List<String> list = this.f3582b;
        Intrinsics3.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult2 getGroups() {
        return this.a;
    }

    @Override // kotlin.text.MatchResult
    public Ranges2 getRange() {
        return Regex4.access$range(this.c);
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String strGroup = this.c.group();
        Intrinsics3.checkNotNullExpressionValue(strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int iEnd = this.c.end() + (this.c.end() == this.c.start() ? 1 : 0);
        if (iEnd > this.d.length()) {
            return null;
        }
        Matcher matcher = this.c.pattern().matcher(this.d);
        Intrinsics3.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        return Regex4.access$findNext(matcher, iEnd, this.d);
    }
}
