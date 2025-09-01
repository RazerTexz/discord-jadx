package b.i.c.r;

import androidx.annotation.NonNull;

/* compiled from: HeartBeatInfo.java */
/* renamed from: b.i.c.r.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface HeartBeatInfo {

    /* compiled from: HeartBeatInfo.java */
    /* renamed from: b.i.c.r.d$a */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        a(int i) {
            this.code = i;
        }

        public int f() {
            return this.code;
        }
    }

    @NonNull
    a a(@NonNull String str);
}
