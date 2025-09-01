package b.i.e;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;

/* compiled from: Reader.java */
/* renamed from: b.i.e.i, reason: use source file name */
/* loaded from: classes3.dex */
public interface Reader {
    Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
