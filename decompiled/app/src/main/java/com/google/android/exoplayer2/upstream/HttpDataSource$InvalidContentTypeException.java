package com.google.android.exoplayer2.upstream;

import b.i.a.c.e3.DataSpec;

/* loaded from: classes3.dex */
public final class HttpDataSource$InvalidContentTypeException extends HttpDataSource$HttpDataSourceException {
    public final String contentType;

    /* JADX WARN: Illegal instructions before constructor call */
    public HttpDataSource$InvalidContentTypeException(String str, DataSpec dataSpec) {
        String strValueOf = String.valueOf(str);
        super(strValueOf.length() != 0 ? "Invalid content type: ".concat(strValueOf) : new String("Invalid content type: "), dataSpec, 2003, 1);
        this.contentType = str;
    }
}
