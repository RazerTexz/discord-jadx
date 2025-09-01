package b.c.a.z;

/* compiled from: FileExtension.java */
/* renamed from: b.c.a.z.a, reason: use source file name */
/* loaded from: classes.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
