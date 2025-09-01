package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.e3.DataSpec;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class HttpDataSource$InvalidResponseCodeException extends HttpDataSource$HttpDataSourceException {
    public final Map<String, List<String>> headerFields;
    public final byte[] responseBody;
    public final int responseCode;

    @Nullable
    public final String responseMessage;

    public HttpDataSource$InvalidResponseCodeException(int i, @Nullable String str, @Nullable IOException iOException, Map<String, List<String>> map, DataSpec dataSpec, byte[] bArr) {
        super(outline.g(26, "Response code: ", i), iOException, dataSpec, 2004, 1);
        this.responseCode = i;
        this.responseMessage = str;
        this.headerFields = map;
        this.responseBody = bArr;
    }
}
