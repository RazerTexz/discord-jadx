package b.i.c.p.h;

import b.i.c.p.ValueEncoder;
import b.i.c.p.ValueEncoderContext;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import java.io.IOException;

/* compiled from: JsonDataEncoderBuilder.java */
/* renamed from: b.i.c.p.h.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class JsonDataEncoderBuilder2 implements ValueEncoder {
    public static final JsonDataEncoderBuilder2 a = new JsonDataEncoderBuilder2();

    @Override // b.i.c.p.Encoder
    public void a(Object obj, ValueEncoderContext valueEncoderContext) throws IOException {
        JsonDataEncoderBuilder5.a aVar = JsonDataEncoderBuilder5.a;
        valueEncoderContext.d((String) obj);
    }
}
