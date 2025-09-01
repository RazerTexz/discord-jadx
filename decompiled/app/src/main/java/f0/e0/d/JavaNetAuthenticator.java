package f0.e0.d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import f0.Address;
import f0.Authenticator2;
import f0.Challenge;
import f0.Dns2;
import f0.HttpUrl;
import f0.Route;
import f0.e0.Util7;
import f0.e0.h.HttpHeaders;
import f0.e0.k.Platform2;
import g0.Buffer3;
import java.io.EOFException;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.ByteString;

/* compiled from: JavaNetAuthenticator.kt */
/* renamed from: f0.e0.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaNetAuthenticator implements Authenticator2 {

    /* renamed from: b, reason: collision with root package name */
    public final Dns2 f3606b;

    public JavaNetAuthenticator(Dns2 dns2, int i) {
        Dns2 dns22 = (i & 1) != 0 ? Dns2.a : null;
        Intrinsics3.checkParameterIsNotNull(dns22, "defaultDns");
        this.f3606b = dns22;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    @Override // f0.Authenticator2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Request a(Route route, Response response) throws IOException {
        String str;
        List<Challenge> listEmptyList;
        Proxy proxy;
        Dns2 dns2;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        Charset charsetForName;
        Address address;
        Intrinsics3.checkParameterIsNotNull(response, "response");
        Headers headers = response.headers;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        boolean z2 = true;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                listEmptyList = Collections2.emptyList();
                Request request = response.request;
                HttpUrl httpUrl = request.url;
                boolean z3 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407;
                if (route != null || (proxy = route.f3603b) == null) {
                    proxy = Proxy.NO_PROXY;
                }
                for (Challenge challenge : listEmptyList) {
                    if (StringsJVM.equals("Basic", challenge.f3671b, z2)) {
                        if (route == null || (address = route.a) == null || (dns2 = address.d) == null) {
                            dns2 = this.f3606b;
                        }
                        if (z3) {
                            SocketAddress socketAddressAddress = proxy.address();
                            if (socketAddressAddress == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                            }
                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                            String hostName = inetSocketAddress.getHostName();
                            Intrinsics3.checkExpressionValueIsNotNull(proxy, "proxy");
                            try {
                                passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, httpUrl, dns2), inetSocketAddress.getPort(), httpUrl.d, challenge.a.get("realm"), challenge.f3671b, new URL(httpUrl.l), Authenticator.RequestorType.PROXY);
                            } catch (MalformedURLException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            String str2 = httpUrl.g;
                            Intrinsics3.checkExpressionValueIsNotNull(proxy, "proxy");
                            try {
                                passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(str2, b(proxy, httpUrl, dns2), httpUrl.h, httpUrl.d, challenge.a.get("realm"), challenge.f3671b, new URL(httpUrl.l), Authenticator.RequestorType.SERVER);
                            } catch (MalformedURLException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                        if (passwordAuthenticationRequestPasswordAuthentication != null) {
                            String str3 = z3 ? "Proxy-Authorization" : "Authorization";
                            String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                            Intrinsics3.checkExpressionValueIsNotNull(userName, "auth.userName");
                            char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                            Intrinsics3.checkExpressionValueIsNotNull(password, "auth.password");
                            String str4 = new String(password);
                            String str5 = challenge.a.get("charset");
                            if (str5 != null) {
                                try {
                                    charsetForName = Charset.forName(str5);
                                    Intrinsics3.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charset)");
                                } catch (Exception unused) {
                                }
                            } else {
                                charsetForName = StandardCharsets.ISO_8859_1;
                                Intrinsics3.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                            }
                            Intrinsics3.checkParameterIsNotNull(userName, "username");
                            Intrinsics3.checkParameterIsNotNull(str4, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                            Intrinsics3.checkParameterIsNotNull(charsetForName, "charset");
                            String strF = ByteString.INSTANCE.b(userName + MentionUtils.EMOJIS_AND_STICKERS_CHAR + str4, charsetForName).f();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Basic ");
                            sb.append(strF);
                            String string = sb.toString();
                            Intrinsics3.checkParameterIsNotNull(request, "request");
                            new LinkedHashMap();
                            HttpUrl httpUrl2 = request.url;
                            String str6 = request.method;
                            RequestBody requestBody = request.body;
                            Map linkedHashMap = request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : Maps6.toMutableMap(request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                            Headers.a aVarE = request.headers.e();
                            Intrinsics3.checkParameterIsNotNull(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
                            Intrinsics3.checkParameterIsNotNull(string, "value");
                            Intrinsics3.checkParameterIsNotNull(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
                            Intrinsics3.checkParameterIsNotNull(string, "value");
                            Headers.Companion companion = Headers.INSTANCE;
                            companion.a(str3);
                            companion.b(string, str3);
                            aVarE.d(str3);
                            aVarE.b(str3, string);
                            if (httpUrl2 != null) {
                                return new Request(httpUrl2, str6, aVarE.c(), requestBody, Util7.A(linkedHashMap));
                            }
                            throw new IllegalStateException("url == null".toString());
                        }
                    }
                    z2 = true;
                }
                return null;
            }
            str = "Proxy-Authenticate";
        }
        String str7 = str;
        ByteString byteString = HttpHeaders.a;
        Intrinsics3.checkParameterIsNotNull(headers, "$this$parseChallenges");
        Intrinsics3.checkParameterIsNotNull(str7, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (StringsJVM.equals(str7, headers.d(i2), true)) {
                Buffer3 buffer3 = new Buffer3();
                buffer3.b0(headers.g(i2));
                try {
                    HttpHeaders.b(buffer3, arrayList);
                } catch (EOFException e3) {
                    Platform2.a aVar = Platform2.c;
                    Platform2.a.i("Unable to parse challenge", 5, e3);
                }
            }
        }
        listEmptyList = arrayList;
        Request request2 = response.request;
        HttpUrl httpUrl3 = request2.url;
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407) {
        }
        if (route != null) {
            proxy = Proxy.NO_PROXY;
        }
        while (r0.hasNext()) {
        }
        return null;
    }

    public final InetAddress b(Proxy proxy, HttpUrl httpUrl, Dns2 dns2) throws IOException {
        Proxy.Type type = proxy.type();
        if (type != null && a.a[type.ordinal()] == 1) {
            return (InetAddress) _Collections.first((List) dns2.a(httpUrl.g));
        }
        SocketAddress socketAddressAddress = proxy.address();
        if (socketAddressAddress == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        Intrinsics3.checkExpressionValueIsNotNull(address, "(address() as InetSocketAddress).address");
        return address;
    }
}
