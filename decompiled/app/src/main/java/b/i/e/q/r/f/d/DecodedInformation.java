package b.i.e.q.r.f.d;

/* compiled from: DecodedInformation.java */
/* renamed from: b.i.e.q.r.f.d.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class DecodedInformation extends DecodedObject {

    /* renamed from: b, reason: collision with root package name */
    public final String f1871b;
    public final int c;
    public final boolean d;

    public DecodedInformation(int i, String str) {
        super(i);
        this.f1871b = str;
        this.d = false;
        this.c = 0;
    }

    public DecodedInformation(int i, String str, int i2) {
        super(i);
        this.d = true;
        this.c = i2;
        this.f1871b = str;
    }
}
