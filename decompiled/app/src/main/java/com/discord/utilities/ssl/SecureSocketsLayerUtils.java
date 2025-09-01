package com.discord.utilities.ssl;

import android.content.res.AssetManager;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import kotlin.Metadata;

/* compiled from: SecureSocketsLayerUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/ssl/SecureSocketsLayerUtils;", "", "Landroid/content/res/AssetManager;", "assetManager", "", "certificatePath", "Ljavax/net/ssl/TrustManagerFactory;", "getTrustManagerFactory", "(Landroid/content/res/AssetManager;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;", "trustManagerFactory", "Ljavax/net/ssl/SSLSocketFactory;", "createSocketFactory", "(Ljavax/net/ssl/TrustManagerFactory;)Ljavax/net/ssl/SSLSocketFactory;", "protocol", "Ljavax/net/ssl/SSLContext;", "getContext", "(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SecureSocketsLayerUtils {
    public static final SecureSocketsLayerUtils INSTANCE = new SecureSocketsLayerUtils();

    private SecureSocketsLayerUtils() {
    }

    public static final SSLSocketFactory createSocketFactory() {
        return createSocketFactory$default(null, 1, null);
    }

    public static final SSLSocketFactory createSocketFactory(TrustManagerFactory trustManagerFactory) throws KeyManagementException {
        TrustManager[] trustManagers;
        SSLContext context$default = getContext$default(INSTANCE, null, 1, null);
        if (trustManagerFactory != null) {
            try {
                trustManagers = trustManagerFactory.getTrustManagers();
            } catch (KeyManagementException e) {
                throw e;
            }
        } else {
            trustManagers = null;
        }
        context$default.init(null, trustManagers, null);
        SSLSocketFactory socketFactory = context$default.getSocketFactory();
        Intrinsics3.checkNotNullExpressionValue(socketFactory, "sslContext.socketFactory");
        return socketFactory;
    }

    public static /* synthetic */ SSLSocketFactory createSocketFactory$default(TrustManagerFactory trustManagerFactory, int i, Object obj) {
        if ((i & 1) != 0) {
            trustManagerFactory = null;
        }
        return createSocketFactory(trustManagerFactory);
    }

    private final SSLContext getContext(String protocol) throws NoSuchAlgorithmException {
        try {
            SSLContext sSLContext = SSLContext.getInstance(protocol);
            Intrinsics3.checkNotNullExpressionValue(sSLContext, "SSLContext.getInstance(protocol)");
            return sSLContext;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
    }

    public static /* synthetic */ SSLContext getContext$default(SecureSocketsLayerUtils secureSocketsLayerUtils, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "TLS";
        }
        return secureSocketsLayerUtils.getContext(str);
    }

    public static final TrustManagerFactory getTrustManagerFactory(AssetManager assetManager, String certificatePath) throws NoSuchAlgorithmException, IOException {
        Intrinsics3.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics3.checkNotNullParameter(certificatePath, "certificatePath");
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        InputStream inputStreamOpen = assetManager.open(certificatePath);
        try {
            Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStreamOpen);
            if (certificateGenerateCertificate == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            keyStore.setCertificateEntry("caCert", (X509Certificate) certificateGenerateCertificate);
            trustManagerFactory.init(keyStore);
            Intrinsics3.checkNotNullExpressionValue(trustManagerFactory, "tmf");
            Closeable.closeFinally(inputStreamOpen, null);
            return trustManagerFactory;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                Closeable.closeFinally(inputStreamOpen, th);
                throw th2;
            }
        }
    }
}
