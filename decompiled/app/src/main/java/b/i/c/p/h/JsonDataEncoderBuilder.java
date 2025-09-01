package b.i.c.p.h;

import b.d.b.a.outline;
import b.i.c.p.ObjectEncoder;
import b.i.c.p.ObjectEncoderContext;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import com.google.firebase.encoders.EncodingException;

/* compiled from: JsonDataEncoderBuilder.java */
/* renamed from: b.i.c.p.h.a, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class JsonDataEncoderBuilder implements ObjectEncoder {
    public static final JsonDataEncoderBuilder a = new JsonDataEncoderBuilder();

    @Override // b.i.c.p.Encoder
    public void a(Object obj, ObjectEncoderContext objectEncoderContext) {
        JsonDataEncoderBuilder5.a aVar = JsonDataEncoderBuilder5.a;
        StringBuilder sbU = outline.U("Couldn't find encoder for type ");
        sbU.append(obj.getClass().getCanonicalName());
        throw new EncodingException(sbU.toString());
    }
}
