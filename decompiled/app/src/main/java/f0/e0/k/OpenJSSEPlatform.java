package f0.e0.k;

import b.d.b.a.outline;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import f0.Protocol2;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;

/* compiled from: OpenJSSEPlatform.kt */
/* renamed from: f0.e0.k.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class OpenJSSEPlatform extends Platform2 {
    public static final boolean d;
    public static final a e;
    public final Provider f = new OpenJSSE();

    /* compiled from: OpenJSSEPlatform.kt */
    /* renamed from: f0.e0.k.g$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        a aVar = new a(null);
        e = aVar;
        boolean z2 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, aVar.getClass().getClassLoader());
            z2 = true;
        } catch (ClassNotFoundException unused) {
        }
        d = z2;
    }

    @Override // f0.e0.k.Platform2
    public void d(SSLSocket sSLSocket, String str, List<Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        if (!(sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            return;
        }
        org.openjsse.javax.net.ssl.SSLSocket sSLSocket2 = (org.openjsse.javax.net.ssl.SSLSocket) sSLSocket;
        SSLParameters sSLParameters = sSLSocket2.getSSLParameters();
        if (sSLParameters instanceof SSLParameters) {
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((Protocol2) next) != Protocol2.HTTP_1_0) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((Protocol2) it2.next()).toString());
            }
            SSLParameters sSLParameters2 = sSLParameters;
            Object[] array = arrayList2.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters2.setApplicationProtocols((String[]) array);
            sSLSocket2.setSSLParameters(sSLParameters);
        }
    }

    @Override // f0.e0.k.Platform2
    public String f(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket) {
            String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sSLSocket).getApplicationProtocol();
            if (applicationProtocol != null && !Intrinsics3.areEqual(applicationProtocol, "")) {
                return applicationProtocol;
            }
        } else {
            super.f(sSLSocket);
        }
        return null;
    }

    @Override // f0.e0.k.Platform2
    public SSLContext l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f);
        Intrinsics3.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // f0.e0.k.Platform2
    public X509TrustManager n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f);
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
}
