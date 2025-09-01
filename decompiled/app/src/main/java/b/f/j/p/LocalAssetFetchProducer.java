package b.f.j.p;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import b.f.d.g.PooledByteBufferFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: LocalAssetFetchProducer.java */
/* renamed from: b.f.j.p.d0, reason: use source file name */
/* loaded from: classes3.dex */
public class LocalAssetFetchProducer extends LocalFetchProducer {
    public final AssetManager c;

    public LocalAssetFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, AssetManager assetManager) {
        super(executor, pooledByteBufferFactory);
        this.c = assetManager;
    }

    @Override // b.f.j.p.LocalFetchProducer
    public EncodedImage2 d(ImageRequest imageRequest) throws IOException {
        int length;
        InputStream inputStreamOpen = this.c.open(imageRequest.c.getPath().substring(1), 2);
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        try {
            assetFileDescriptorOpenFd = this.c.openFd(imageRequest.c.getPath().substring(1));
            length = (int) assetFileDescriptorOpenFd.getLength();
        } catch (IOException unused) {
            length = -1;
            if (assetFileDescriptorOpenFd != null) {
            }
        } catch (Throwable th) {
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
        try {
            assetFileDescriptorOpenFd.close();
        } catch (IOException unused3) {
        }
        return c(inputStreamOpen, length);
    }

    @Override // b.f.j.p.LocalFetchProducer
    public String e() {
        return "LocalAssetFetchProducer";
    }
}
