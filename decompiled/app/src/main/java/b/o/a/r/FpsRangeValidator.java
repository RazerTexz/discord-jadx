package b.o.a.r;

import android.util.Range;
import androidx.annotation.RequiresApi;
import b.o.a.CameraLogger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: FpsRangeValidator.java */
@RequiresApi(21)
/* renamed from: b.o.a.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public class FpsRangeValidator {
    public static final CameraLogger a = new CameraLogger("FpsRangeValidator");

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, List<Range<Integer>>> f1949b;

    static {
        HashMap map = new HashMap();
        f1949b = map;
        map.put("Google Pixel 4", Arrays.asList(new Range(15, 60)));
        map.put("Google Pixel 4a", Arrays.asList(new Range(15, 60)));
    }
}
