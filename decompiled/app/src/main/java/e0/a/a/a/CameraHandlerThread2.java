package e0.a.a.a;

import android.os.HandlerThread;

/* compiled from: CameraHandlerThread.java */
/* renamed from: e0.a.a.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraHandlerThread2 extends HandlerThread {
    public BarcodeScannerView j;

    public CameraHandlerThread2(BarcodeScannerView barcodeScannerView) {
        super("CameraHandlerThread");
        this.j = barcodeScannerView;
        start();
    }
}
