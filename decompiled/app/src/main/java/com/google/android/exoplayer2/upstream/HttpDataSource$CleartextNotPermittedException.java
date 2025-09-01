package com.google.android.exoplayer2.upstream;

import b.i.a.c.e3.DataSpec;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class HttpDataSource$CleartextNotPermittedException extends HttpDataSource$HttpDataSourceException {
    public HttpDataSource$CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
        super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, dataSpec, 2007, 1);
    }
}
