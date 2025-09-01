package b.c.a.a0;

import b.c.a.a0.i0.JsonReader2;
import java.io.IOException;

/* compiled from: FloatParser.java */
/* renamed from: b.c.a.a0.i, reason: use source file name */
/* loaded from: classes.dex */
public class FloatParser implements ValueParser<Float> {
    public static final FloatParser a = new FloatParser();

    @Override // b.c.a.a0.ValueParser
    public Float a(JsonReader2 jsonReader2, float f) throws IOException {
        return Float.valueOf(JsonUtils.d(jsonReader2) * f);
    }
}
