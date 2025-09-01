package f0.e0.k;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import b.d.b.a.outline;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import f0.OkHttpClient;
import f0.Protocol2;
import f0.e0.k.AndroidPlatform;
import f0.e0.k.BouncyCastlePlatform;
import f0.e0.k.ConscryptPlatform;
import f0.e0.k.Jdk9Platform;
import f0.e0.k.OpenJSSEPlatform;
import f0.e0.k.i.AndroidLog;
import f0.e0.k.i.AndroidLog2;
import f0.e0.m.BasicCertificateChainCleaner;
import f0.e0.m.BasicTrustRootIndex;
import f0.e0.m.CertificateChainCleaner;
import f0.e0.m.TrustRootIndex;
import g0.Buffer3;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Platform.kt */
/* renamed from: f0.e0.k.h, reason: use source file name */
/* loaded from: classes3.dex */
public class Platform2 {
    public static volatile Platform2 a;

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f3650b;
    public static final a c;

    /* compiled from: Platform.kt */
    /* renamed from: f0.e0.k.h$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<String> a(List<? extends Protocol2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol2) obj) != Protocol2.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol2) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] b(List<? extends Protocol2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            Buffer3 buffer3 = new Buffer3();
            Iterator it = ((ArrayList) a(list)).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                buffer3.T(str.length());
                buffer3.b0(str);
            }
            return buffer3.Z(buffer3.k);
        }

        public final boolean c() {
            return Intrinsics3.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe  */
    static {
        Platform2 jdk9Platform;
        a aVar = new a(null);
        c = aVar;
        if (aVar.c()) {
            AndroidLog androidLog = AndroidLog.c;
            for (Map.Entry<String, String> entry : AndroidLog.f3652b.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Logger logger = Logger.getLogger(key);
                if (AndroidLog.a.add(logger)) {
                    Intrinsics3.checkExpressionValueIsNotNull(logger, "logger");
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(value, 3) ? Level.FINE : Log.isLoggable(value, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(AndroidLog2.a);
                }
            }
            Android10Platform android10Platform = Android10Platform.e;
            jdk9Platform = Android10Platform.d ? new Android10Platform() : null;
            if (jdk9Platform == null) {
                AndroidPlatform.a aVar2 = AndroidPlatform.e;
                jdk8WithJettyBootPlatform = AndroidPlatform.d ? new AndroidPlatform() : null;
                if (jdk8WithJettyBootPlatform == null) {
                    Intrinsics3.throwNpe();
                }
            }
        } else {
            Provider provider = Security.getProviders()[0];
            Intrinsics3.checkExpressionValueIsNotNull(provider, "Security.getProviders()[0]");
            if (Intrinsics3.areEqual("Conscrypt", provider.getName())) {
                ConscryptPlatform.a aVar3 = ConscryptPlatform.e;
                jdk9Platform = ConscryptPlatform.d ? new ConscryptPlatform() : null;
                if (jdk9Platform == null) {
                    Provider provider2 = Security.getProviders()[0];
                    Intrinsics3.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                    if (Intrinsics3.areEqual("BC", provider2.getName())) {
                        BouncyCastlePlatform.a aVar4 = BouncyCastlePlatform.e;
                        jdk9Platform = BouncyCastlePlatform.d ? new BouncyCastlePlatform() : null;
                        if (jdk9Platform == null) {
                            Provider provider3 = Security.getProviders()[0];
                            Intrinsics3.checkExpressionValueIsNotNull(provider3, "Security.getProviders()[0]");
                            if (Intrinsics3.areEqual("OpenJSSE", provider3.getName())) {
                                OpenJSSEPlatform.a aVar5 = OpenJSSEPlatform.e;
                                jdk9Platform = OpenJSSEPlatform.d ? new OpenJSSEPlatform() : null;
                                if (jdk9Platform == null) {
                                    Jdk9Platform.a aVar6 = Jdk9Platform.e;
                                    jdk9Platform = Jdk9Platform.d ? new Jdk9Platform() : null;
                                    if (jdk9Platform == null) {
                                        String property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                        try {
                                            Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
                                        } catch (NumberFormatException unused) {
                                        }
                                        if (Integer.parseInt(property) < 9) {
                                            try {
                                                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                                Method method = cls.getMethod("put", SSLSocket.class, cls2);
                                                Method method2 = cls.getMethod("get", SSLSocket.class);
                                                Method method3 = cls.getMethod("remove", SSLSocket.class);
                                                Intrinsics3.checkExpressionValueIsNotNull(method, "putMethod");
                                                Intrinsics3.checkExpressionValueIsNotNull(method2, "getMethod");
                                                Intrinsics3.checkExpressionValueIsNotNull(method3, "removeMethod");
                                                Intrinsics3.checkExpressionValueIsNotNull(cls3, "clientProviderClass");
                                                Intrinsics3.checkExpressionValueIsNotNull(cls4, "serverProviderClass");
                                                jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method, method2, method3, cls3, cls4);
                                            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                                            }
                                        }
                                        jdk9Platform = jdk8WithJettyBootPlatform != null ? jdk8WithJettyBootPlatform : new Platform2();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        a = jdk9Platform;
        f3650b = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static /* synthetic */ void j(Platform2 platform2, String str, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        int i3 = i2 & 4;
        platform2.i(str, i, null);
    }

    public void a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
    }

    public CertificateChainCleaner b(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        return new BasicCertificateChainCleaner(c(x509TrustManager));
    }

    public TrustRootIndex c(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        Intrinsics3.checkExpressionValueIsNotNull(acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List<Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
    }

    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Intrinsics3.checkParameterIsNotNull(socket, "socket");
        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public String f(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return null;
    }

    public Object g(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "closer");
        if (f3650b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean h(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        return true;
    }

    public void i(String str, int i, Throwable th) {
        Intrinsics3.checkParameterIsNotNull(str, "message");
        f3650b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void k(String str, Object obj) {
        Intrinsics3.checkParameterIsNotNull(str, "message");
        if (obj == null) {
            str = outline.w(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(str, 5, (Throwable) obj);
    }

    public SSLContext l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics3.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory m(X509TrustManager x509TrustManager) throws KeyManagementException {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextL = l();
            sSLContextL.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextL.getSocketFactory();
            Intrinsics3.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        Intrinsics3.checkExpressionValueIsNotNull(trustManagerFactory, "factory");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            Intrinsics3.throwNpe();
        }
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sbU = outline.U("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        Intrinsics3.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
        sbU.append(string);
        throw new IllegalStateException(sbU.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics3.checkExpressionValueIsNotNull(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
