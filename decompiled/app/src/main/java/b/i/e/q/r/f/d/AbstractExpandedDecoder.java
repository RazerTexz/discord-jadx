package b.i.e.q.r.f.d;

import b.i.e.n.BitArray;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* compiled from: AbstractExpandedDecoder.java */
/* renamed from: b.i.e.q.r.f.d.j, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractExpandedDecoder {
    public final BitArray a;

    /* renamed from: b, reason: collision with root package name */
    public final GeneralAppIdDecoder f1867b;

    public AbstractExpandedDecoder(BitArray bitArray) {
        this.a = bitArray;
        this.f1867b = new GeneralAppIdDecoder(bitArray);
    }

    public abstract String a() throws NotFoundException, FormatException;
}
