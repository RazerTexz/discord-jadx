package d0.g0;

/* compiled from: Regex.kt */
/* renamed from: d0.g0.i, reason: use source file name */
/* loaded from: classes3.dex */
public enum Regex5 {
    IGNORE_CASE(2, 0, 2),
    MULTILINE(8, 0, 2),
    /* JADX INFO: Fake field, exist only in values array */
    LITERAL(16, 0, 2),
    /* JADX INFO: Fake field, exist only in values array */
    UNIX_LINES(1, 0, 2),
    /* JADX INFO: Fake field, exist only in values array */
    COMMENTS(4, 0, 2),
    DOT_MATCHES_ALL(32, 0, 2),
    /* JADX INFO: Fake field, exist only in values array */
    CANON_EQ(128, 0, 2);

    private final int mask;
    private final int value;

    Regex5(int i, int i2, int i3) {
        i2 = (i3 & 2) != 0 ? i : i2;
        this.value = i;
        this.mask = i2;
    }

    public int getValue() {
        return this.value;
    }
}
