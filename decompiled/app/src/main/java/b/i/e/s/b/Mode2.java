package b.i.e.s.b;

/* compiled from: Mode.java */
/* renamed from: b.i.e.s.b.h, reason: use source file name */
/* loaded from: classes3.dex */
public enum Mode2 {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);

    private final int bits;
    private final int[] characterCountBitsForVersions;

    Mode2(int[] iArr, int i) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i;
    }

    public int f(Version3 version3) {
        int i = version3.c;
        return this.characterCountBitsForVersions[i <= 9 ? (char) 0 : i <= 26 ? (char) 1 : (char) 2];
    }
}
