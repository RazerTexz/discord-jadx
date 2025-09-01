package b.i.e.m;

import b.i.e.BarcodeFormat;
import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.Reader;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.ResultPointCallback;
import b.i.e.m.c.Decoder2;
import b.i.e.m.d.Detector;
import b.i.e.n.DecoderResult;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.List;
import java.util.Map;

/* compiled from: AztecReader.java */
/* renamed from: b.i.e.m.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AztecReader implements Reader {
    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a A[LOOP:0: B:33:0x0058->B:34:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0081  */
    @Override // b.i.e.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        ResultPoint[] resultPointArr2;
        FormatException formatException;
        ResultPoint[] resultPointArr3;
        List<byte[]> list;
        String str;
        ResultPointCallback resultPointCallback;
        AztecDetectorResult aztecDetectorResultA;
        Detector detector = new Detector(binaryBitmap.a());
        DecoderResult decoderResultA = null;
        try {
            aztecDetectorResultA = detector.a(false);
            resultPointArr = aztecDetectorResultA.f1836b;
        } catch (FormatException e) {
            e = e;
            resultPointArr = null;
        } catch (NotFoundException e2) {
            e = e2;
            resultPointArr = null;
        }
        try {
            resultPointArr2 = resultPointArr;
            formatException = null;
            decoderResultA = new Decoder2().a(aztecDetectorResultA);
            e = null;
        } catch (FormatException e3) {
            e = e3;
            resultPointArr2 = resultPointArr;
            formatException = e;
            e = null;
            if (decoderResultA == null) {
            }
            resultPointArr3 = resultPointArr2;
            if (map != null) {
                while (i < r0) {
                }
            }
            Result result = new Result(decoderResultA.c, decoderResultA.a, decoderResultA.f1835b, resultPointArr3, BarcodeFormat.AZTEC, System.currentTimeMillis());
            list = decoderResultA.d;
            if (list != null) {
            }
            str = decoderResultA.e;
            if (str != null) {
            }
            return result;
        } catch (NotFoundException e4) {
            e = e4;
            resultPointArr2 = resultPointArr;
            formatException = null;
            if (decoderResultA == null) {
            }
            resultPointArr3 = resultPointArr2;
            if (map != null) {
            }
            Result result2 = new Result(decoderResultA.c, decoderResultA.a, decoderResultA.f1835b, resultPointArr3, BarcodeFormat.AZTEC, System.currentTimeMillis());
            list = decoderResultA.d;
            if (list != null) {
            }
            str = decoderResultA.e;
            if (str != null) {
            }
            return result2;
        }
        if (decoderResultA == null) {
            try {
                AztecDetectorResult aztecDetectorResultA2 = detector.a(true);
                resultPointArr2 = aztecDetectorResultA2.f1836b;
                decoderResultA = new Decoder2().a(aztecDetectorResultA2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        resultPointArr3 = resultPointArr2;
        if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (ResultPoint resultPoint : resultPointArr3) {
                resultPointCallback.a(resultPoint);
            }
        }
        Result result22 = new Result(decoderResultA.c, decoderResultA.a, decoderResultA.f1835b, resultPointArr3, BarcodeFormat.AZTEC, System.currentTimeMillis());
        list = decoderResultA.d;
        if (list != null) {
            result22.b(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        str = decoderResultA.e;
        if (str != null) {
            result22.b(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        return result22;
    }

    @Override // b.i.e.Reader
    public void reset() {
    }
}
