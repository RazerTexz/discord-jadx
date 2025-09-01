package b.o.a.v;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.CameraLogger;
import b.o.a.PictureResult;
import b.o.a.v.PictureRecorder;

/* compiled from: SnapshotPictureRecorder.java */
/* renamed from: b.o.a.v.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SnapshotPictureRecorder extends PictureRecorder {
    public static final CameraLogger m = new CameraLogger(SnapshotPictureRecorder.class.getSimpleName());

    public SnapshotPictureRecorder(@NonNull PictureResult.a aVar, @Nullable PictureRecorder.a aVar2) {
        super(aVar, aVar2);
    }
}
