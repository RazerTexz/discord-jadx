package b.f.d.m;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;

/* compiled from: WebpBitmapFactory.java */
/* renamed from: b.f.d.m.b, reason: use source file name */
/* loaded from: classes.dex */
public interface WebpBitmapFactory {

    /* compiled from: WebpBitmapFactory.java */
    /* renamed from: b.f.d.m.b$a */
    public interface a {
        void a(String str, String str2);
    }

    Bitmap a(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options);
}
