package b.o.a.m;

import androidx.annotation.NonNull;

/* compiled from: VideoCodec.java */
/* renamed from: b.o.a.m.l, reason: use source file name */
/* loaded from: classes3.dex */
public enum VideoCodec implements Control {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);

    private int value;

    VideoCodec(int i) {
        this.value = i;
    }

    @NonNull
    public static VideoCodec f(int i) {
        VideoCodec[] videoCodecArrValues = values();
        for (int i2 = 0; i2 < 3; i2++) {
            VideoCodec videoCodec = videoCodecArrValues[i2];
            if (videoCodec.value == i) {
                return videoCodec;
            }
        }
        return DEVICE_DEFAULT;
    }

    public int g() {
        return this.value;
    }
}
