package b.m.a.g.d;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* compiled from: DatagramFactory.kt */
/* renamed from: b.m.a.g.d.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface DatagramFactory {
    DatagramPacket a(byte[] bArr);

    DatagramPacket b(byte[] bArr, InetAddress inetAddress, int i);

    DatagramSocket c() throws SocketException;
}
