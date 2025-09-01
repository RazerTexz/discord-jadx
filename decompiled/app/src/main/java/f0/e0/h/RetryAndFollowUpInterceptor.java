package f0.e0.h;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import f0.Address;
import f0.CertificatePinner;
import f0.EventListener;
import f0.Handshake;
import f0.HttpUrl;
import f0.OkHttpClient;
import f0.Protocol2;
import f0.Route;
import f0.e0.Util7;
import f0.e0.g.Exchange;
import f0.e0.g.ExchangeFinder;
import f0.e0.g.RealCall;
import f0.e0.g.RealConnection4;
import f0.e0.g.RealConnectionPool;
import f0.e0.g.RouteSelector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.text.Regex;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

/* compiled from: RetryAndFollowUpInterceptor.kt */
/* renamed from: f0.e0.h.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public final OkHttpClient f3629b;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        this.f3629b = okHttpClient;
    }

    public final Request a(Response response, Exchange exchange) throws IOException {
        String strA;
        RealConnection4 realConnection4;
        Route route = (exchange == null || (realConnection4 = exchange.f3614b) == null) ? null : realConnection4.q;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        Request request = response.request;
        String str = request.method;
        if (i != 307 && i != 308) {
            if (i == 401) {
                return this.f3629b.f3683s.a(route, response);
            }
            if (i == 421) {
                RequestBody requestBody = request.body;
                if ((requestBody != null && requestBody.isOneShot()) || exchange == null || !(!Intrinsics3.areEqual(exchange.e.h.a.g, exchange.f3614b.q.a.a.g))) {
                    return null;
                }
                RealConnection4 realConnection42 = exchange.f3614b;
                synchronized (realConnection42) {
                    realConnection42.j = true;
                }
                return response.request;
            }
            if (i == 503) {
                Response response2 = response.priorResponse;
                if ((response2 == null || response2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 503) && c(response, Integer.MAX_VALUE) == 0) {
                    return response.request;
                }
                return null;
            }
            if (i == 407) {
                if (route == null) {
                    Intrinsics3.throwNpe();
                }
                if (route.f3603b.type() == Proxy.Type.HTTP) {
                    return this.f3629b.f3686z.a(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (i == 408) {
                if (!this.f3629b.r) {
                    return null;
                }
                RequestBody requestBody2 = request.body;
                if (requestBody2 != null && requestBody2.isOneShot()) {
                    return null;
                }
                Response response3 = response.priorResponse;
                if ((response3 == null || response3.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 408) && c(response, 0) <= 0) {
                    return response.request;
                }
                return null;
            }
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f3629b.t || (strA = Response.a(response, "Location", null, 2)) == null) {
            return null;
        }
        HttpUrl httpUrl = response.request.url;
        Objects.requireNonNull(httpUrl);
        Intrinsics3.checkParameterIsNotNull(strA, "link");
        HttpUrl.a aVarG = httpUrl.g(strA);
        HttpUrl httpUrlB = aVarG != null ? aVarG.b() : null;
        if (httpUrlB == null) {
            return null;
        }
        if (!Intrinsics3.areEqual(httpUrlB.d, response.request.url.d) && !this.f3629b.u) {
            return null;
        }
        Request.a aVar = new Request.a(response.request);
        if (HttpMethod.a(str)) {
            int i2 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            Intrinsics3.checkParameterIsNotNull(str, "method");
            boolean z2 = Intrinsics3.areEqual(str, "PROPFIND") || i2 == 308 || i2 == 307;
            Intrinsics3.checkParameterIsNotNull(str, "method");
            if (!(!Intrinsics3.areEqual(str, "PROPFIND")) || i2 == 308 || i2 == 307) {
                aVar.c(str, z2 ? response.request.body : null);
            } else {
                aVar.c(ShareTarget.METHOD_GET, null);
            }
            if (!z2) {
                aVar.d("Transfer-Encoding");
                aVar.d("Content-Length");
                aVar.d("Content-Type");
            }
        }
        if (!Util7.a(response.request.url, httpUrlB)) {
            aVar.d("Authorization");
        }
        aVar.g(httpUrlB);
        return aVar.a();
    }

    public final boolean b(IOException iOException, RealCall realCall, Request request, boolean z2) {
        boolean zA;
        RouteSelector routeSelector;
        RealConnection4 realConnection4;
        if (!this.f3629b.r) {
            return false;
        }
        if (z2) {
            RequestBody requestBody = request.body;
            if ((requestBody != null && requestBody.isOneShot()) || (iOException instanceof FileNotFoundException)) {
                return false;
            }
        }
        if (!(!(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) : !((iOException instanceof SocketTimeoutException) && !z2)))) {
            return false;
        }
        ExchangeFinder exchangeFinder = realCall.o;
        if (exchangeFinder == null) {
            Intrinsics3.throwNpe();
        }
        int i = exchangeFinder.c;
        if (i == 0 && exchangeFinder.d == 0 && exchangeFinder.e == 0) {
            zA = false;
        } else if (exchangeFinder.f != null) {
            zA = true;
        } else {
            Route route = null;
            if (i <= 1 && exchangeFinder.d <= 1 && exchangeFinder.e <= 0 && (realConnection4 = exchangeFinder.i.p) != null) {
                synchronized (realConnection4) {
                    if (realConnection4.k == 0 && Util7.a(realConnection4.q.a.a, exchangeFinder.h.a)) {
                        route = realConnection4.q;
                    }
                }
            }
            if (route != null) {
                exchangeFinder.f = route;
            } else {
                RouteSelector.a aVar = exchangeFinder.a;
                if ((aVar == null || !aVar.a()) && (routeSelector = exchangeFinder.f3615b) != null) {
                    zA = routeSelector.a();
                }
            }
            zA = true;
        }
        return zA;
    }

    public final int c(Response response, int i) throws NumberFormatException {
        String strA = Response.a(response, "Retry-After", null, 2);
        if (strA == null) {
            return i;
        }
        if (!new Regex("\\d+").matches(strA)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        Intrinsics3.checkExpressionValueIsNotNull(numValueOf, "Integer.valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Throwable {
        List list;
        Response response;
        int i;
        RealCall realCall;
        RealInterceptorChain realInterceptorChain;
        Response response2;
        List listPlus;
        boolean z2;
        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
        RealCall realCall2;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor2 = this;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain2 = (RealInterceptorChain) chain;
        Request request = realInterceptorChain2.f;
        RealCall realCall3 = realInterceptorChain2.f3628b;
        boolean z3 = true;
        List listEmptyList = Collections2.emptyList();
        Response response3 = null;
        int i2 = 0;
        Request request2 = request;
        boolean z4 = true;
        while (true) {
            Objects.requireNonNull(realCall3);
            Intrinsics3.checkParameterIsNotNull(request2, "request");
            if (!(realCall3.r == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            synchronized (realCall3) {
                try {
                    try {
                        if (!(realCall3.t ^ z3)) {
                            throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                        }
                        if (!(realCall3.f3616s ^ z3)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    retryAndFollowUpInterceptor2 = realCall3;
                }
            }
            if (z4) {
                RealConnectionPool realConnectionPool = realCall3.j;
                HttpUrl httpUrl = request2.url;
                if (httpUrl.c) {
                    OkHttpClient okHttpClient = realCall3.f3618y;
                    SSLSocketFactory sSLSocketFactory2 = okHttpClient.B;
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("CLEARTEXT-only client");
                    }
                    HostnameVerifier hostnameVerifier2 = okHttpClient.F;
                    certificatePinner = okHttpClient.G;
                    sSLSocketFactory = sSLSocketFactory2;
                    hostnameVerifier = hostnameVerifier2;
                } else {
                    sSLSocketFactory = null;
                    hostnameVerifier = null;
                    certificatePinner = null;
                }
                String str = httpUrl.g;
                int i3 = httpUrl.h;
                OkHttpClient okHttpClient2 = realCall3.f3618y;
                list = listEmptyList;
                i = i2;
                response = response3;
                Address address = new Address(str, i3, okHttpClient2.w, okHttpClient2.A, sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient2.f3686z, okHttpClient2.f3684x, okHttpClient2.E, okHttpClient2.D, okHttpClient2.f3685y);
                EventListener eventListener = realCall3.k;
                realCall3.o = new ExchangeFinder(realConnectionPool, address, realCall3, eventListener);
                realCall = eventListener;
            } else {
                list = listEmptyList;
                response = response3;
                i = i2;
                realCall = retryAndFollowUpInterceptor2;
            }
            try {
                if (realCall3.v) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        Response responseA = realInterceptorChain2.a(request2);
                        if (response != null) {
                            try {
                                Intrinsics3.checkParameterIsNotNull(responseA, "response");
                                Request request3 = responseA.request;
                                Protocol2 protocol2 = responseA.protocol;
                                int i4 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                String str2 = responseA.message;
                                Handshake handshake = responseA.handshake;
                                Headers.a aVarE = responseA.headers.e();
                                ResponseBody responseBody = responseA.body;
                                Response response4 = responseA.networkResponse;
                                Response response5 = responseA.cacheResponse;
                                long j = responseA.sentRequestAtMillis;
                                realInterceptorChain = realInterceptorChain2;
                                realCall2 = realCall3;
                                try {
                                    long j2 = responseA.receivedResponseAtMillis;
                                    Exchange exchange = responseA.exchange;
                                    Response response6 = response;
                                    Intrinsics3.checkParameterIsNotNull(response6, "response");
                                    Request request4 = response6.request;
                                    Protocol2 protocol22 = response6.protocol;
                                    int i5 = response6.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                    String str3 = response6.message;
                                    Handshake handshake2 = response6.handshake;
                                    Headers.a aVarE2 = response6.headers.e();
                                    Response response7 = response6.networkResponse;
                                    Response response8 = response6.cacheResponse;
                                    Response response9 = response6.priorResponse;
                                    long j3 = response6.sentRequestAtMillis;
                                    long j4 = response6.receivedResponseAtMillis;
                                    Exchange exchange2 = response6.exchange;
                                    if (!(i5 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i5).toString());
                                    }
                                    if (request4 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (protocol22 == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str3 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    Response response10 = new Response(request4, protocol22, str3, i5, handshake2, aVarE2.c(), null, response7, response8, response9, j3, j4, exchange2);
                                    if (!(response10.body == null)) {
                                        throw new IllegalArgumentException("priorResponse.body != null".toString());
                                    }
                                    if (!(i4 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i4).toString());
                                    }
                                    if (request3 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (protocol2 == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str2 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    responseA = new Response(request3, protocol2, str2, i4, handshake, aVarE.c(), responseBody, response4, response5, response10, j, j2, exchange);
                                } catch (Throwable th3) {
                                    th = th3;
                                    realCall = realCall2;
                                    realCall.i(true);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                realCall2 = realCall3;
                            }
                        } else {
                            realInterceptorChain = realInterceptorChain2;
                            realCall2 = realCall3;
                        }
                        response3 = responseA;
                        realCall = realCall2;
                    } catch (IOException e) {
                        realInterceptorChain = realInterceptorChain2;
                        RealCall realCall4 = realCall3;
                        response2 = response;
                        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor3 = this;
                        if (!retryAndFollowUpInterceptor3.b(e, realCall4, request2, !(e instanceof ConnectionShutdownException))) {
                            Util7.D(e, list);
                            throw e;
                        }
                        listPlus = _Collections.plus((Collection<? extends IOException>) list, e);
                        z2 = true;
                        realCall = realCall4;
                        retryAndFollowUpInterceptor = retryAndFollowUpInterceptor3;
                        realCall.i(z2);
                        listEmptyList = listPlus;
                        response3 = response2;
                        i2 = i;
                        z4 = false;
                        realCall3 = realCall;
                        retryAndFollowUpInterceptor2 = retryAndFollowUpInterceptor;
                        realInterceptorChain2 = realInterceptorChain;
                        z3 = true;
                    }
                } catch (RouteException e2) {
                    realInterceptorChain = realInterceptorChain2;
                    RealCall realCall5 = realCall3;
                    List list2 = list;
                    response2 = response;
                    RetryAndFollowUpInterceptor retryAndFollowUpInterceptor4 = this;
                    if (!retryAndFollowUpInterceptor4.b(e2.getLastConnectException(), realCall5, request2, false)) {
                        IOException firstConnectException = e2.getFirstConnectException();
                        Util7.D(firstConnectException, list2);
                        throw firstConnectException;
                    }
                    listPlus = _Collections.plus((Collection<? extends IOException>) list2, e2.getFirstConnectException());
                    z2 = true;
                    realCall = realCall5;
                    retryAndFollowUpInterceptor = retryAndFollowUpInterceptor4;
                    realCall.i(z2);
                    listEmptyList = listPlus;
                    response3 = response2;
                    i2 = i;
                    z4 = false;
                    realCall3 = realCall;
                    retryAndFollowUpInterceptor2 = retryAndFollowUpInterceptor;
                    realInterceptorChain2 = realInterceptorChain;
                    z3 = true;
                }
                try {
                    Exchange exchange3 = realCall.r;
                    retryAndFollowUpInterceptor = this;
                    try {
                        Request requestA = retryAndFollowUpInterceptor.a(response3, exchange3);
                        if (requestA == null) {
                            if (exchange3 != null && exchange3.a) {
                                realCall.n();
                            }
                            realCall.i(false);
                            return response3;
                        }
                        RequestBody requestBody = requestA.body;
                        if (requestBody != null && requestBody.isOneShot()) {
                            realCall.i(false);
                            return response3;
                        }
                        ResponseBody responseBody2 = response3.body;
                        if (responseBody2 != null) {
                            byte[] bArr = Util7.a;
                            Intrinsics3.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
                            try {
                                responseBody2.close();
                            } catch (RuntimeException e3) {
                                throw e3;
                            } catch (Exception unused) {
                            }
                        }
                        i2 = i + 1;
                        if (i2 > 20) {
                            throw new ProtocolException("Too many follow-up requests: " + i2);
                        }
                        realCall.i(true);
                        request2 = requestA;
                        listEmptyList = list;
                        z4 = true;
                        realCall3 = realCall;
                        retryAndFollowUpInterceptor2 = retryAndFollowUpInterceptor;
                        realInterceptorChain2 = realInterceptorChain;
                        z3 = true;
                    } catch (Throwable th5) {
                        th = th5;
                        realCall.i(true);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    realCall.i(true);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                realCall = realCall3;
            }
        }
    }
}
