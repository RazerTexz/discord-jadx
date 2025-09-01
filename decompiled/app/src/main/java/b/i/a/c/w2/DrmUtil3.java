package b.i.a.c.w2;

import android.media.MediaDrmResetException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: DrmUtil.java */
@RequiresApi(23)
/* renamed from: b.i.a.c.w2.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class DrmUtil3 {
    @DoNotInline
    public static boolean a(@Nullable Throwable th) {
        return th instanceof MediaDrmResetException;
    }
}
