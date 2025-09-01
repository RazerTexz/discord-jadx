package com.fasterxml.jackson.core;

import b.g.a.b.JsonParser;
import com.fasterxml.jackson.core.exc.StreamReadException;

/* loaded from: classes3.dex */
public class JsonParseException extends StreamReadException {
    private static final long serialVersionUID = 2;

    @Override // com.fasterxml.jackson.core.exc.StreamReadException, com.fasterxml.jackson.core.JsonProcessingException
    public /* bridge */ /* synthetic */ Object c() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    public JsonParser d() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException, com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }
}
