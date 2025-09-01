package b.i.c.p.h;

import androidx.annotation.NonNull;
import b.i.c.p.ObjectEncoder;
import b.i.c.p.ValueEncoder;
import b.i.c.p.ValueEncoderContext;
import b.i.c.p.g.EncoderConfig;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: JsonDataEncoderBuilder.java */
/* renamed from: b.i.c.p.h.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class JsonDataEncoderBuilder5 implements EncoderConfig<JsonDataEncoderBuilder5> {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, ObjectEncoder<?>> f1761b;
    public final Map<Class<?>, ValueEncoder<?>> c;
    public ObjectEncoder<Object> d;
    public boolean e;

    /* compiled from: JsonDataEncoderBuilder.java */
    /* renamed from: b.i.c.p.h.e$a */
    public static final class a implements ValueEncoder<Date> {
        public static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public a(JsonDataEncoderBuilder4 jsonDataEncoderBuilder4) {
        }

        @Override // b.i.c.p.Encoder
        public void a(@NonNull Object obj, @NonNull ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.d(a.format((Date) obj));
        }
    }

    public JsonDataEncoderBuilder5() {
        HashMap map = new HashMap();
        this.f1761b = map;
        HashMap map2 = new HashMap();
        this.c = map2;
        this.d = JsonDataEncoderBuilder.a;
        this.e = false;
        map2.put(String.class, JsonDataEncoderBuilder2.a);
        map.remove(String.class);
        map2.put(Boolean.class, JsonDataEncoderBuilder3.a);
        map.remove(Boolean.class);
        map2.put(Date.class, a);
        map.remove(Date.class);
    }
}
