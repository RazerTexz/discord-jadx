package b.i.b.a;

import b.d.b.a.outline;

/* compiled from: CharMatcher.java */
/* renamed from: b.i.b.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CharMatcher implements Predicate3<Character> {

    /* compiled from: CharMatcher.java */
    /* renamed from: b.i.b.a.b$a */
    public static abstract class a extends CharMatcher {
        @Override // b.i.b.a.Predicate3
        @Deprecated
        public boolean apply(Character ch) {
            return b(ch.charValue());
        }
    }

    /* compiled from: CharMatcher.java */
    /* renamed from: b.i.b.a.b$b */
    public static final class b extends a {
        public final char a;

        public b(char c) {
            this.a = c;
        }

        @Override // b.i.b.a.CharMatcher
        public boolean b(char c) {
            return c == this.a;
        }

        public String toString() {
            StringBuilder sbU = outline.U("CharMatcher.is('");
            char c = this.a;
            char[] cArr = {'\\', 'u', 0, 0, 0, 0};
            for (int i = 0; i < 4; i++) {
                cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
                c = (char) (c >> 4);
            }
            sbU.append(String.copyValueOf(cArr));
            sbU.append("')");
            return sbU.toString();
        }
    }

    /* compiled from: CharMatcher.java */
    /* renamed from: b.i.b.a.b$c */
    public static abstract class c extends a {
        public final String a;

        public c(String str) {
            this.a = str;
        }

        public final String toString() {
            return this.a;
        }
    }

    /* compiled from: CharMatcher.java */
    /* renamed from: b.i.b.a.b$d */
    public static final class d extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final d f1641b = new d();

        public d() {
            super("CharMatcher.none()");
        }

        @Override // b.i.b.a.CharMatcher
        public int a(CharSequence charSequence, int i) {
            b.i.a.f.e.o.f.C(i, charSequence.length());
            return -1;
        }

        @Override // b.i.b.a.CharMatcher
        public boolean b(char c) {
            return false;
        }
    }

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        b.i.a.f.e.o.f.C(i, length);
        while (i < length) {
            if (b(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean b(char c2);
}
