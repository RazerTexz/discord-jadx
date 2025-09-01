package b.o.a.p;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: ImageFrameManager.java */
@RequiresApi(19)
/* renamed from: b.o.a.p.e, reason: use source file name */
/* loaded from: classes3.dex */
public class ImageFrameManager extends FrameManager<Image> {
    public ImageFrameManager(int i) {
        super(i, Image.class);
    }

    @Override // b.o.a.p.FrameManager
    public void c(@NonNull Image image, boolean z2) {
        try {
            image.close();
        } catch (Exception unused) {
        }
    }
}
