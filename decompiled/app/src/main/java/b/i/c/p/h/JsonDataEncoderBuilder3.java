package b.i.c.p.h;

import b.i.c.p.ValueEncoder;
import b.i.c.p.ValueEncoderContext;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import java.io.IOException;

/* compiled from: JsonDataEncoderBuilder.java */
/* renamed from: b.i.c.p.h.c, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class JsonDataEncoderBuilder3 implements ValueEncoder {
    public static final JsonDataEncoderBuilder3 a = new JsonDataEncoderBuilder3();

    @Override // b.i.c.p.Encoder
    public void a(Object obj, ValueEncoderContext valueEncoderContext) throws IOException {
        JsonDataEncoderBuilder5.a aVar = JsonDataEncoderBuilder5.a;
        valueEncoderContext.e(((Boolean) obj).booleanValue());
    }
}
