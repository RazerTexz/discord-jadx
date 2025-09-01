package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import b.i.a.c.e3.BaseDataSource;
import b.i.a.c.e3.DataSpec;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class UdpDataSource extends BaseDataSource {
    public final int e;
    public final byte[] f;
    public final DatagramPacket g;

    @Nullable
    public Uri h;

    @Nullable
    public DatagramSocket i;

    @Nullable
    public MulticastSocket j;

    @Nullable
    public InetAddress k;
    public boolean l;
    public int m;

    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th, int i) {
            super(th, i);
        }
    }

    public UdpDataSource() {
        super(true);
        this.e = 8000;
        byte[] bArr = new byte[2000];
        this.f = bArr;
        this.g = new DatagramPacket(bArr, 0, 2000);
    }

    @Override // b.i.a.c.e3.DataSource3
    public long a(DataSpec dataSpec) throws IOException {
        Uri uri = dataSpec.a;
        this.h = uri;
        String host = uri.getHost();
        Objects.requireNonNull(host);
        int port = this.h.getPort();
        r(dataSpec);
        try {
            this.k = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.k, port);
            if (this.k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.j = multicastSocket;
                multicastSocket.joinGroup(this.k);
                this.i = this.j;
            } else {
                this.i = new DatagramSocket(inetSocketAddress);
            }
            this.i.setSoTimeout(this.e);
            this.l = true;
            s(dataSpec);
            return -1L;
        } catch (IOException e) {
            throw new UdpDataSourceException(e, 2001);
        } catch (SecurityException e2) {
            throw new UdpDataSourceException(e2, 2006);
        }
    }

    @Override // b.i.a.c.e3.DataSource3
    public void close() throws IOException {
        this.h = null;
        MulticastSocket multicastSocket = this.j;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.k;
                Objects.requireNonNull(inetAddress);
                multicastSocket.leaveGroup(inetAddress);
            } catch (IOException unused) {
            }
            this.j = null;
        }
        DatagramSocket datagramSocket = this.i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.i = null;
        }
        this.k = null;
        this.m = 0;
        if (this.l) {
            this.l = false;
            q();
        }
    }

    @Override // b.i.a.c.e3.DataSource3
    @Nullable
    public Uri n() {
        return this.h;
    }

    @Override // b.i.a.c.e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.m == 0) {
            try {
                DatagramSocket datagramSocket = this.i;
                Objects.requireNonNull(datagramSocket);
                datagramSocket.receive(this.g);
                int length = this.g.getLength();
                this.m = length;
                p(length);
            } catch (SocketTimeoutException e) {
                throw new UdpDataSourceException(e, 2002);
            } catch (IOException e2) {
                throw new UdpDataSourceException(e2, 2001);
            }
        }
        int length2 = this.g.getLength();
        int i3 = this.m;
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.f, length2 - i3, bArr, i, iMin);
        this.m -= iMin;
        return iMin;
    }
}
