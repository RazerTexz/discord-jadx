package b.i.a.c.w2;

import android.media.UnsupportedSchemeException;
import android.util.Log;
import b.i.a.c.w2.ExoMediaDrm;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import java.util.UUID;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class n implements ExoMediaDrm.c {
    public static final /* synthetic */ n a = new n();

    @Override // b.i.a.c.w2.ExoMediaDrm.c
    public final ExoMediaDrm a(UUID uuid) throws UnsupportedDrmException {
        int i = FrameworkMediaDrm.a;
        try {
            try {
                return new FrameworkMediaDrm(uuid);
            } catch (UnsupportedDrmException unused) {
                String strValueOf = String.valueOf(uuid);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 53);
                sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
                sb.append(strValueOf);
                sb.append(".");
                Log.e("FrameworkMediaDrm", sb.toString());
                return new DummyExoMediaDrm();
            }
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }
}
