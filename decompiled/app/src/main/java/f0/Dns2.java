package f0;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* compiled from: Dns.kt */
/* renamed from: f0.s, reason: use source file name */
/* loaded from: classes3.dex */
public interface Dns2 {
    public static final Dns2 a = new Dns();

    List<InetAddress> a(String str) throws UnknownHostException;
}
