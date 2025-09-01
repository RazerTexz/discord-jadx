package b.c.a.a0;

import b.c.a.a0.i0.JsonReader2;
import java.io.IOException;

/* compiled from: IntegerParser.java */
/* renamed from: b.c.a.a0.o, reason: use source file name */
/* loaded from: classes.dex */
public class IntegerParser implements ValueParser<Integer> {
    public static final IntegerParser a = new IntegerParser();

    @Override // b.c.a.a0.ValueParser
    public Integer a(JsonReader2 jsonReader2, float f) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.d(jsonReader2) * f));
    }
}
