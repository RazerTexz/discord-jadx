package com.fasterxml.jackson.core.exc;

import b.d.b.a.outline;
import b.g.a.b.JsonParser;
import b.g.a.b.t.RequestPayload;
import com.fasterxml.jackson.core.JsonProcessingException;

/* loaded from: classes3.dex */
public abstract class StreamReadException extends JsonProcessingException {
    public static final long serialVersionUID = 1;
    public RequestPayload _requestPayload;

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    public /* bridge */ /* synthetic */ Object c() {
        return d();
    }

    public JsonParser d() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this._requestPayload == null) {
            return message;
        }
        StringBuilder sbX = outline.X(message, "\nRequest payload : ");
        sbX.append(this._requestPayload.toString());
        return sbX.toString();
    }
}
