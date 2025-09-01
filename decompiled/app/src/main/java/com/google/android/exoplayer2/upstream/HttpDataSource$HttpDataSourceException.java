package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import b.i.a.c.e3.DataSpec;
import b.i.a.f.e.o.f;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* loaded from: classes3.dex */
public class HttpDataSource$HttpDataSourceException extends DataSourceException {
    public final DataSpec dataSpec;
    public final int type;

    public HttpDataSource$HttpDataSourceException(DataSpec dataSpec, int i, int i2) {
        super(a(i, i2));
        this.dataSpec = dataSpec;
        this.type = i2;
    }

    public static int a(int i, int i2) {
        if (i == 2000 && i2 == 1) {
            return 2001;
        }
        return i;
    }

    public static HttpDataSource$HttpDataSourceException b(IOException iOException, DataSpec dataSpec, int i) {
        String message = iOException.getMessage();
        int i2 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? PointerIconCompat.TYPE_WAIT : (message == null || !f.u1(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i2 == 2007 ? new HttpDataSource$CleartextNotPermittedException(iOException, dataSpec) : new HttpDataSource$HttpDataSourceException(iOException, dataSpec, i2, i);
    }

    public HttpDataSource$HttpDataSourceException(String str, DataSpec dataSpec, int i, int i2) {
        super(str, a(i, i2));
        this.dataSpec = dataSpec;
        this.type = i2;
    }

    public HttpDataSource$HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i, int i2) {
        super(iOException, a(i, i2));
        this.dataSpec = dataSpec;
        this.type = i2;
    }

    public HttpDataSource$HttpDataSourceException(String str, @Nullable IOException iOException, DataSpec dataSpec, int i, int i2) {
        super(str, iOException, a(i, i2));
        this.dataSpec = dataSpec;
        this.type = i2;
    }
}
