package b.f.j.k;

import b.f.j.p.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: RequestListener.java */
/* renamed from: b.f.j.k.e, reason: use source file name */
/* loaded from: classes.dex */
public interface RequestListener extends ProducerListener {
    void a(ImageRequest imageRequest, Object obj, String str, boolean z2);

    void c(ImageRequest imageRequest, String str, boolean z2);

    void g(ImageRequest imageRequest, String str, Throwable th, boolean z2);

    void k(String str);
}
