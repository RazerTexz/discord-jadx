package b.i.a.c.w2;

import android.media.MediaDrm;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.Util2;
import java.util.Objects;

/* compiled from: DrmUtil.java */
@RequiresApi(21)
/* renamed from: b.i.a.c.w2.w, reason: use source file name */
/* loaded from: classes3.dex */
public final class DrmUtil2 {
    @DoNotInline
    public static boolean a(@Nullable Throwable th) {
        return th instanceof MediaDrm.MediaDrmStateException;
    }

    @DoNotInline
    public static int b(Throwable th) throws NumberFormatException {
        String[] strArrSplit;
        int length;
        String diagnosticInfo = ((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo();
        int i = Util2.a;
        int i2 = 0;
        if (diagnosticInfo != null && (length = (strArrSplit = diagnosticInfo.split("_", -1)).length) >= 2) {
            String str = strArrSplit[length - 1];
            boolean z2 = length >= 3 && "neg".equals(strArrSplit[length - 2]);
            try {
                Objects.requireNonNull(str);
                i2 = Integer.parseInt(str);
                if (z2) {
                    i2 = -i2;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return Util2.p(i2);
    }
}
