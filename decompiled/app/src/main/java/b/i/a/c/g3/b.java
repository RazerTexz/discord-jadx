package b.i.a.c.g3;

import android.util.Log;
import android.view.Display;
import b.i.a.c.g3.VideoFrameReleaseHelper;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements VideoFrameReleaseHelper.b.a {
    public final /* synthetic */ VideoFrameReleaseHelper a;

    public /* synthetic */ b(VideoFrameReleaseHelper videoFrameReleaseHelper) {
        this.a = videoFrameReleaseHelper;
    }

    public final void a(Display display) {
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.a;
        Objects.requireNonNull(videoFrameReleaseHelper);
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            videoFrameReleaseHelper.k = refreshRate;
            videoFrameReleaseHelper.l = (refreshRate * 80) / 100;
        } else {
            Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            videoFrameReleaseHelper.k = -9223372036854775807L;
            videoFrameReleaseHelper.l = -9223372036854775807L;
        }
    }
}
