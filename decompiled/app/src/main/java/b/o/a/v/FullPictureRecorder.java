package b.o.a.v;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.CameraLogger;
import b.o.a.PictureResult;
import b.o.a.v.PictureRecorder;

/* compiled from: FullPictureRecorder.java */
/* renamed from: b.o.a.v.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class FullPictureRecorder extends PictureRecorder {
    public static final CameraLogger m = new CameraLogger(FullPictureRecorder.class.getSimpleName());

    public FullPictureRecorder(@NonNull PictureResult.a aVar, @Nullable PictureRecorder.a aVar2) {
        super(aVar, aVar2);
    }
}
