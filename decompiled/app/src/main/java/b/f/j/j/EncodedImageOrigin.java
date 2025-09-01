package b.f.j.j;

/* compiled from: EncodedImageOrigin.java */
/* renamed from: b.f.j.j.f, reason: use source file name */
/* loaded from: classes.dex */
public enum EncodedImageOrigin {
    NOT_SET("not_set"),
    NETWORK("network"),
    DISK("disk"),
    ENCODED_MEM_CACHE("encoded_mem_cache");

    private final String mOrigin;

    EncodedImageOrigin(String str) {
        this.mOrigin = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mOrigin;
    }
}
