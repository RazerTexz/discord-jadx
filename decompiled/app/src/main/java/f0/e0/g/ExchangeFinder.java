package f0.e0.g;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import f0.Address;
import f0.Call2;
import f0.EventListener;
import f0.HttpUrl;
import f0.Route;
import f0.e0.Util7;
import f0.e0.f.TaskQueue2;
import f0.e0.g.RouteSelector;
import f0.e0.j.ErrorCode2;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;

/* compiled from: ExchangeFinder.kt */
/* renamed from: f0.e0.g.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExchangeFinder {
    public RouteSelector.a a;

    /* renamed from: b, reason: collision with root package name */
    public RouteSelector f3615b;
    public int c;
    public int d;
    public int e;
    public Route f;
    public final RealConnectionPool g;
    public final Address h;
    public final RealCall i;
    public final EventListener j;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address, RealCall realCall, EventListener eventListener) {
        Intrinsics3.checkParameterIsNotNull(realConnectionPool, "connectionPool");
        Intrinsics3.checkParameterIsNotNull(address, "address");
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
        this.g = realConnectionPool;
        this.h = address;
        this.i = realCall;
        this.j = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x02b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RealConnection4 a(int i, int i2, int i3, int i4, boolean z2, boolean z3) throws IOException {
        List<Route> list;
        String hostName;
        int port;
        boolean zContains;
        RouteDatabase routeDatabase;
        boolean z4;
        Socket socketM;
        while (!this.i.v) {
            RealConnection4 realConnection4 = this.i.p;
            if (realConnection4 != null) {
                synchronized (realConnection4) {
                    socketM = (realConnection4.i || !b(realConnection4.q.a.a)) ? this.i.m() : null;
                }
                if (this.i.p != null) {
                    if (!(socketM == null)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    z4 = z3;
                } else {
                    if (socketM != null) {
                        Util7.e(socketM);
                    }
                    EventListener eventListener = this.j;
                    RealCall realCall = this.i;
                    Objects.requireNonNull(eventListener);
                    Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
                    Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
                    this.c = 0;
                    this.d = 0;
                    this.e = 0;
                    if (this.g.a(this.h, this.i, null, false)) {
                        Route routeB = this.f;
                        try {
                            if (routeB != null) {
                                this.f = null;
                            } else {
                                RouteSelector.a aVar = this.a;
                                if (aVar == null || !aVar.a()) {
                                    RouteSelector routeSelector = this.f3615b;
                                    if (routeSelector == null) {
                                        Address address = this.h;
                                        RealCall realCall2 = this.i;
                                        routeSelector = new RouteSelector(address, realCall2.f3618y.O, realCall2, this.j);
                                        this.f3615b = routeSelector;
                                    }
                                    if (!routeSelector.a()) {
                                        throw new NoSuchElementException();
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    while (routeSelector.b()) {
                                        if (!routeSelector.b()) {
                                            StringBuilder sbU = outline.U("No route to ");
                                            sbU.append(routeSelector.e.a.g);
                                            sbU.append("; exhausted proxy configurations: ");
                                            sbU.append(routeSelector.a);
                                            throw new SocketException(sbU.toString());
                                        }
                                        List<? extends Proxy> list2 = routeSelector.a;
                                        int i5 = routeSelector.f3622b;
                                        routeSelector.f3622b = i5 + 1;
                                        Proxy proxy = list2.get(i5);
                                        ArrayList arrayList2 = new ArrayList();
                                        routeSelector.c = arrayList2;
                                        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                            HttpUrl httpUrl = routeSelector.e.a;
                                            hostName = httpUrl.g;
                                            port = httpUrl.h;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                StringBuilder sbU2 = outline.U("Proxy.address() is not an InetSocketAddress: ");
                                                sbU2.append(socketAddressAddress.getClass());
                                                throw new IllegalArgumentException(sbU2.toString().toString());
                                            }
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "$this$socketHost");
                                            InetAddress address2 = inetSocketAddress.getAddress();
                                            if (address2 != null) {
                                                hostName = address2.getHostAddress();
                                                Intrinsics3.checkExpressionValueIsNotNull(hostName, "address.hostAddress");
                                            } else {
                                                hostName = inetSocketAddress.getHostName();
                                                Intrinsics3.checkExpressionValueIsNotNull(hostName, "hostName");
                                            }
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 > port || 65535 < port) {
                                            throw new SocketException("No route to " + hostName + MentionUtils.EMOJIS_AND_STICKERS_CHAR + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy.Type.SOCKS) {
                                            arrayList2.add(InetSocketAddress.createUnresolved(hostName, port));
                                        } else {
                                            EventListener eventListener2 = routeSelector.h;
                                            Call2 call2 = routeSelector.g;
                                            Objects.requireNonNull(eventListener2);
                                            Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                                            Intrinsics3.checkParameterIsNotNull(hostName, "domainName");
                                            List<InetAddress> listA = routeSelector.e.d.a(hostName);
                                            if (listA.isEmpty()) {
                                                throw new UnknownHostException(routeSelector.e.d + " returned no addresses for " + hostName);
                                            }
                                            EventListener eventListener3 = routeSelector.h;
                                            Call2 call22 = routeSelector.g;
                                            Objects.requireNonNull(eventListener3);
                                            Intrinsics3.checkParameterIsNotNull(call22, NotificationCompat.CATEGORY_CALL);
                                            Intrinsics3.checkParameterIsNotNull(hostName, "domainName");
                                            Intrinsics3.checkParameterIsNotNull(listA, "inetAddressList");
                                            Iterator<InetAddress> it = listA.iterator();
                                            while (it.hasNext()) {
                                                arrayList2.add(new InetSocketAddress(it.next(), port));
                                            }
                                        }
                                        Iterator<? extends InetSocketAddress> it2 = routeSelector.c.iterator();
                                        while (it2.hasNext()) {
                                            Route route = new Route(routeSelector.e, proxy, it2.next());
                                            RouteDatabase routeDatabase2 = routeSelector.f;
                                            synchronized (routeDatabase2) {
                                                Intrinsics3.checkParameterIsNotNull(route, "route");
                                                zContains = routeDatabase2.a.contains(route);
                                            }
                                            if (zContains) {
                                                routeSelector.d.add(route);
                                            } else {
                                                arrayList.add(route);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        MutableCollections.addAll(arrayList, routeSelector.d);
                                        routeSelector.d.clear();
                                    }
                                    RouteSelector.a aVar2 = new RouteSelector.a(arrayList);
                                    this.a = aVar2;
                                    list = aVar2.f3623b;
                                    if (this.i.v) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.g.a(this.h, this.i, list, false)) {
                                        realConnection4 = this.i.p;
                                        if (realConnection4 == null) {
                                            Intrinsics3.throwNpe();
                                        }
                                        this.j.a(this.i, realConnection4);
                                    } else {
                                        routeB = aVar2.b();
                                        RealConnection4 realConnection42 = new RealConnection4(this.g, routeB);
                                        this.i.f3617x = realConnection42;
                                        realConnection42.c(i, i2, i3, i4, z2, this.i, this.j);
                                        this.i.f3617x = null;
                                        routeDatabase = this.i.f3618y.O;
                                        Route route2 = realConnection42.q;
                                        synchronized (routeDatabase) {
                                            Intrinsics3.checkParameterIsNotNull(route2, "route");
                                            routeDatabase.a.remove(route2);
                                        }
                                        if (this.g.a(this.h, this.i, list, true)) {
                                            RealConnection4 realConnection43 = this.i.p;
                                            if (realConnection43 == null) {
                                                Intrinsics3.throwNpe();
                                            }
                                            this.f = routeB;
                                            Util7.e(realConnection42.n());
                                            this.j.a(this.i, realConnection43);
                                            realConnection4 = realConnection43;
                                        } else {
                                            synchronized (realConnection42) {
                                                RealConnectionPool realConnectionPool = this.g;
                                                Objects.requireNonNull(realConnectionPool);
                                                Intrinsics3.checkParameterIsNotNull(realConnection42, "connection");
                                                byte[] bArr = Util7.a;
                                                realConnectionPool.d.add(realConnection42);
                                                TaskQueue2.d(realConnectionPool.f3621b, realConnectionPool.c, 0L, 2);
                                                this.i.f(realConnection42);
                                            }
                                            EventListener eventListener4 = this.j;
                                            RealCall realCall3 = this.i;
                                            Objects.requireNonNull(eventListener4);
                                            Intrinsics3.checkParameterIsNotNull(realCall3, NotificationCompat.CATEGORY_CALL);
                                            Intrinsics3.checkParameterIsNotNull(realConnection42, "connection");
                                            z4 = z3;
                                            realConnection4 = realConnection42;
                                        }
                                    }
                                } else {
                                    RouteSelector.a aVar3 = this.a;
                                    if (aVar3 == null) {
                                        Intrinsics3.throwNpe();
                                    }
                                    routeB = aVar3.b();
                                }
                            }
                            realConnection42.c(i, i2, i3, i4, z2, this.i, this.j);
                            this.i.f3617x = null;
                            routeDatabase = this.i.f3618y.O;
                            Route route22 = realConnection42.q;
                            synchronized (routeDatabase) {
                            }
                        } catch (Throwable th) {
                            this.i.f3617x = null;
                            throw th;
                        }
                        list = null;
                        RealConnection4 realConnection422 = new RealConnection4(this.g, routeB);
                        this.i.f3617x = realConnection422;
                    } else {
                        realConnection4 = this.i.p;
                        if (realConnection4 == null) {
                            Intrinsics3.throwNpe();
                        }
                        this.j.a(this.i, realConnection4);
                    }
                    z4 = z3;
                }
            } else {
                this.c = 0;
                this.d = 0;
                this.e = 0;
                if (this.g.a(this.h, this.i, null, false)) {
                }
                z4 = z3;
            }
            if (realConnection4.i(z4)) {
                return realConnection4;
            }
            realConnection4.l();
            if (this.f == null) {
                RouteSelector.a aVar4 = this.a;
                if (aVar4 != null ? aVar4.a() : true) {
                    continue;
                } else {
                    RouteSelector routeSelector2 = this.f3615b;
                    if (!(routeSelector2 != null ? routeSelector2.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final boolean b(HttpUrl httpUrl) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        HttpUrl httpUrl2 = this.h.a;
        return httpUrl.h == httpUrl2.h && Intrinsics3.areEqual(httpUrl.g, httpUrl2.g);
    }

    public final void c(IOException iOException) {
        Intrinsics3.checkParameterIsNotNull(iOException, "e");
        this.f = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode2.REFUSED_STREAM) {
            this.c++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.d++;
        } else {
            this.e++;
        }
    }
}
