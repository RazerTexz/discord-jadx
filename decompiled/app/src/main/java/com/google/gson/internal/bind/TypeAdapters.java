package com.google.gson.internal.bind;

import b.d.b.a.outline;
import b.i.d.JsonArray;
import b.i.d.JsonNull;
import b.i.d.JsonPrimitive;
import b.i.d.TypeAdapterFactory2;
import b.i.d.p.SerializedName;
import b.i.d.q.LazilyParsedNumber;
import com.google.android.material.badge.BadgeDrawable;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes3.dex */
public final class TypeAdapters {
    public static final TypeAdapter<String> A;
    public static final TypeAdapter<BigDecimal> B;
    public static final TypeAdapter<BigInteger> C;
    public static final TypeAdapterFactory2 D;
    public static final TypeAdapter<StringBuilder> E;
    public static final TypeAdapterFactory2 F;
    public static final TypeAdapter<StringBuffer> G;
    public static final TypeAdapterFactory2 H;
    public static final TypeAdapter<URL> I;
    public static final TypeAdapterFactory2 J;
    public static final TypeAdapter<URI> K;
    public static final TypeAdapterFactory2 L;
    public static final TypeAdapter<InetAddress> M;
    public static final TypeAdapterFactory2 N;
    public static final TypeAdapter<UUID> O;
    public static final TypeAdapterFactory2 P;
    public static final TypeAdapter<Currency> Q;
    public static final TypeAdapterFactory2 R;
    public static final TypeAdapterFactory2 S;
    public static final TypeAdapter<Calendar> T;
    public static final TypeAdapterFactory2 U;
    public static final TypeAdapter<Locale> V;
    public static final TypeAdapterFactory2 W;
    public static final TypeAdapter<JsonElement> X;
    public static final TypeAdapterFactory2 Y;
    public static final TypeAdapterFactory2 Z;
    public static final TypeAdapter<Class> a;

    /* renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory2 f3128b;
    public static final TypeAdapter<BitSet> c;
    public static final TypeAdapterFactory2 d;
    public static final TypeAdapter<Boolean> e;
    public static final TypeAdapter<Boolean> f;
    public static final TypeAdapterFactory2 g;
    public static final TypeAdapter<Number> h;
    public static final TypeAdapterFactory2 i;
    public static final TypeAdapter<Number> j;
    public static final TypeAdapterFactory2 k;
    public static final TypeAdapter<Number> l;
    public static final TypeAdapterFactory2 m;
    public static final TypeAdapter<AtomicInteger> n;
    public static final TypeAdapterFactory2 o;
    public static final TypeAdapter<AtomicBoolean> p;
    public static final TypeAdapterFactory2 q;
    public static final TypeAdapter<AtomicIntegerArray> r;

    /* renamed from: s, reason: collision with root package name */
    public static final TypeAdapterFactory2 f3129s;
    public static final TypeAdapter<Number> t;
    public static final TypeAdapter<Number> u;
    public static final TypeAdapter<Number> v;
    public static final TypeAdapter<Number> w;

    /* renamed from: x, reason: collision with root package name */
    public static final TypeAdapterFactory2 f3130x;

    /* renamed from: y, reason: collision with root package name */
    public static final TypeAdapter<Character> f3131y;

    /* renamed from: z, reason: collision with root package name */
    public static final TypeAdapterFactory2 f3132z;

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$1, reason: invalid class name */
    public class AnonymousClass1 extends TypeAdapter<Class> {
        public Class a() throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        public void b(Class cls) throws IOException {
            throw new UnsupportedOperationException(outline.o(cls, outline.U("Attempted to serialize java.lang.Class: "), ". Forgot to register a type adapter?"));
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Class read(JsonReader jsonReader) throws IOException {
            return a();
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Class cls) throws IOException {
            b(cls);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$10, reason: invalid class name */
    public class AnonymousClass10 extends TypeAdapter<AtomicIntegerArray> {
        @Override // com.google.gson.TypeAdapter
        public AtomicIntegerArray read(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.a();
            while (jsonReader.q()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.y()));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }
            jsonReader.e();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
            jsonWriter.b();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.A(r6.get(i));
            }
            jsonWriter.e();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$11, reason: invalid class name */
    public class AnonymousClass11 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.A());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.D(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$12, reason: invalid class name */
    public class AnonymousClass12 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.x());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.D(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$13, reason: invalid class name */
    public class AnonymousClass13 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.x());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.D(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$14, reason: invalid class name */
    public class AnonymousClass14 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenN = jsonReader.N();
            int iOrdinal = jsonTokenN.ordinal();
            if (iOrdinal == 5 || iOrdinal == 6) {
                return new LazilyParsedNumber(jsonReader.J());
            }
            if (iOrdinal == 8) {
                jsonReader.H();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + jsonTokenN);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.D(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$15, reason: invalid class name */
    public class AnonymousClass15 extends TypeAdapter<Character> {
        @Override // com.google.gson.TypeAdapter
        public Character read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            String strJ = jsonReader.J();
            if (strJ.length() == 1) {
                return Character.valueOf(strJ.charAt(0));
            }
            throw new JsonSyntaxException(outline.w("Expecting character, got: ", strJ));
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Character ch) throws IOException {
            Character ch2 = ch;
            jsonWriter.H(ch2 == null ? null : String.valueOf(ch2));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$16, reason: invalid class name */
    public class AnonymousClass16 extends TypeAdapter<String> {
        @Override // com.google.gson.TypeAdapter
        public String read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenN = jsonReader.N();
            if (jsonTokenN != JsonToken.NULL) {
                return jsonTokenN == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.u()) : jsonReader.J();
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.H(str);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$17, reason: invalid class name */
    public class AnonymousClass17 extends TypeAdapter<BigDecimal> {
        @Override // com.google.gson.TypeAdapter
        public BigDecimal read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.J());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.D(bigDecimal);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$18, reason: invalid class name */
    public class AnonymousClass18 extends TypeAdapter<BigInteger> {
        @Override // com.google.gson.TypeAdapter
        public BigInteger read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            try {
                return new BigInteger(jsonReader.J());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.D(bigInteger);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$19, reason: invalid class name */
    public class AnonymousClass19 extends TypeAdapter<StringBuilder> {
        @Override // com.google.gson.TypeAdapter
        public StringBuilder read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.J());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
            StringBuilder sb2 = sb;
            jsonWriter.H(sb2 == null ? null : sb2.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$2, reason: invalid class name */
    public class AnonymousClass2 extends TypeAdapter<BitSet> {
        /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
        @Override // com.google.gson.TypeAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BitSet read(JsonReader jsonReader) throws IOException {
            boolean zU;
            BitSet bitSet = new BitSet();
            jsonReader.a();
            JsonToken jsonTokenN = jsonReader.N();
            int i = 0;
            while (jsonTokenN != JsonToken.END_ARRAY) {
                int iOrdinal = jsonTokenN.ordinal();
                if (iOrdinal == 5) {
                    String strJ = jsonReader.J();
                    try {
                        if (Integer.parseInt(strJ) != 0) {
                        }
                    } catch (NumberFormatException unused) {
                        throw new JsonSyntaxException(outline.w("Error: Expecting: bitset number value (1, 0), Found: ", strJ));
                    }
                } else if (iOrdinal == 6) {
                    zU = jsonReader.y() != 0;
                } else {
                    if (iOrdinal != 7) {
                        throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenN);
                    }
                    zU = jsonReader.u();
                }
                if (zU) {
                    bitSet.set(i);
                }
                i++;
                jsonTokenN = jsonReader.N();
            }
            jsonReader.e();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            BitSet bitSet2 = bitSet;
            jsonWriter.b();
            int length = bitSet2.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.A(bitSet2.get(i) ? 1L : 0L);
            }
            jsonWriter.e();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$20, reason: invalid class name */
    public class AnonymousClass20 extends TypeAdapter<StringBuffer> {
        @Override // com.google.gson.TypeAdapter
        public StringBuffer read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.J());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            StringBuffer stringBuffer2 = stringBuffer;
            jsonWriter.H(stringBuffer2 == null ? null : stringBuffer2.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$21, reason: invalid class name */
    public class AnonymousClass21 extends TypeAdapter<URL> {
        @Override // com.google.gson.TypeAdapter
        public URL read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            String strJ = jsonReader.J();
            if ("null".equals(strJ)) {
                return null;
            }
            return new URL(strJ);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URL url) throws IOException {
            URL url2 = url;
            jsonWriter.H(url2 == null ? null : url2.toExternalForm());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$22, reason: invalid class name */
    public class AnonymousClass22 extends TypeAdapter<URI> {
        @Override // com.google.gson.TypeAdapter
        public URI read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            try {
                String strJ = jsonReader.J();
                if ("null".equals(strJ)) {
                    return null;
                }
                return new URI(strJ);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, URI uri) throws IOException {
            URI uri2 = uri;
            jsonWriter.H(uri2 == null ? null : uri2.toASCIIString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$23, reason: invalid class name */
    public class AnonymousClass23 extends TypeAdapter<InetAddress> {
        @Override // com.google.gson.TypeAdapter
        public InetAddress read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.J());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            InetAddress inetAddress2 = inetAddress;
            jsonWriter.H(inetAddress2 == null ? null : inetAddress2.getHostAddress());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$24, reason: invalid class name */
    public class AnonymousClass24 extends TypeAdapter<UUID> {
        @Override // com.google.gson.TypeAdapter
        public UUID read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() != JsonToken.NULL) {
                return UUID.fromString(jsonReader.J());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
            UUID uuid2 = uuid;
            jsonWriter.H(uuid2 == null ? null : uuid2.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$25, reason: invalid class name */
    public class AnonymousClass25 extends TypeAdapter<Currency> {
        @Override // com.google.gson.TypeAdapter
        public Currency read(JsonReader jsonReader) throws IOException {
            return Currency.getInstance(jsonReader.J());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
            jsonWriter.H(currency.getCurrencyCode());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$26, reason: invalid class name */
    public class AnonymousClass26 implements TypeAdapterFactory2 {

        /* renamed from: com.google.gson.internal.bind.TypeAdapters$26$1, reason: invalid class name */
        public class AnonymousClass1 extends TypeAdapter<Timestamp> {
            public final /* synthetic */ TypeAdapter a;

            public AnonymousClass1(AnonymousClass26 anonymousClass26, TypeAdapter typeAdapter) {
                this.a = typeAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            public Timestamp read(JsonReader jsonReader) throws IOException {
                Date date = (Date) this.a.read(jsonReader);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                this.a.write(jsonWriter, timestamp);
            }
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            return new AnonymousClass1(this, gson.i(Date.class));
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$27, reason: invalid class name */
    public class AnonymousClass27 extends TypeAdapter<Calendar> {
        @Override // com.google.gson.TypeAdapter
        public Calendar read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            jsonReader.b();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.N() != JsonToken.END_OBJECT) {
                String strC = jsonReader.C();
                int iY = jsonReader.y();
                if ("year".equals(strC)) {
                    i = iY;
                } else if ("month".equals(strC)) {
                    i2 = iY;
                } else if ("dayOfMonth".equals(strC)) {
                    i3 = iY;
                } else if ("hourOfDay".equals(strC)) {
                    i4 = iY;
                } else if ("minute".equals(strC)) {
                    i5 = iY;
                } else if ("second".equals(strC)) {
                    i6 = iY;
                }
            }
            jsonReader.f();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            if (calendar == null) {
                jsonWriter.s();
                return;
            }
            jsonWriter.c();
            jsonWriter.n("year");
            jsonWriter.A(r4.get(1));
            jsonWriter.n("month");
            jsonWriter.A(r4.get(2));
            jsonWriter.n("dayOfMonth");
            jsonWriter.A(r4.get(5));
            jsonWriter.n("hourOfDay");
            jsonWriter.A(r4.get(11));
            jsonWriter.n("minute");
            jsonWriter.A(r4.get(12));
            jsonWriter.n("second");
            jsonWriter.A(r4.get(13));
            jsonWriter.f();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$28, reason: invalid class name */
    public class AnonymousClass28 extends TypeAdapter<Locale> {
        @Override // com.google.gson.TypeAdapter
        public Locale read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.J(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            Locale locale2 = locale;
            jsonWriter.H(locale2 == null ? null : locale2.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$29, reason: invalid class name */
    public class AnonymousClass29 extends TypeAdapter<JsonElement> {
        public JsonElement a(JsonReader jsonReader) throws IOException {
            int iOrdinal = jsonReader.N().ordinal();
            if (iOrdinal == 0) {
                JsonArray jsonArray = new JsonArray();
                jsonReader.a();
                while (jsonReader.q()) {
                    jsonArray.j.add(a(jsonReader));
                }
                jsonReader.e();
                return jsonArray;
            }
            if (iOrdinal == 2) {
                JsonObject jsonObject = new JsonObject();
                jsonReader.b();
                while (jsonReader.q()) {
                    jsonObject.a.put(jsonReader.C(), a(jsonReader));
                }
                jsonReader.f();
                return jsonObject;
            }
            if (iOrdinal == 5) {
                return new JsonPrimitive(jsonReader.J());
            }
            if (iOrdinal == 6) {
                return new JsonPrimitive(new LazilyParsedNumber(jsonReader.J()));
            }
            if (iOrdinal == 7) {
                return new JsonPrimitive(Boolean.valueOf(jsonReader.u()));
            }
            if (iOrdinal != 8) {
                throw new IllegalArgumentException();
            }
            jsonReader.H();
            return JsonNull.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || (jsonElement instanceof JsonNull)) {
                jsonWriter.s();
                return;
            }
            if (jsonElement instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitiveE = jsonElement.e();
                Object obj = jsonPrimitiveE.a;
                if (obj instanceof Number) {
                    jsonWriter.D(jsonPrimitiveE.i());
                    return;
                } else if (obj instanceof Boolean) {
                    jsonWriter.I(jsonPrimitiveE.h());
                    return;
                } else {
                    jsonWriter.H(jsonPrimitiveE.g());
                    return;
                }
            }
            boolean z2 = jsonElement instanceof JsonArray;
            if (z2) {
                jsonWriter.b();
                if (!z2) {
                    throw new IllegalStateException("Not a JSON Array: " + jsonElement);
                }
                Iterator<JsonElement> it = ((JsonArray) jsonElement).iterator();
                while (it.hasNext()) {
                    b(jsonWriter, it.next());
                }
                jsonWriter.e();
                return;
            }
            if (!(jsonElement instanceof JsonObject)) {
                StringBuilder sbU = outline.U("Couldn't write ");
                sbU.append(jsonElement.getClass());
                throw new IllegalArgumentException(sbU.toString());
            }
            jsonWriter.c();
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            LinkedTreeMap.e eVar = linkedTreeMap.header.m;
            int i = linkedTreeMap.modCount;
            while (true) {
                if (!(eVar != linkedTreeMap.header)) {
                    jsonWriter.f();
                    return;
                }
                if (eVar == linkedTreeMap.header) {
                    throw new NoSuchElementException();
                }
                if (linkedTreeMap.modCount != i) {
                    throw new ConcurrentModificationException();
                }
                LinkedTreeMap.e eVar2 = eVar.m;
                jsonWriter.n((String) eVar.getKey());
                b(jsonWriter, (JsonElement) eVar.getValue());
                eVar = eVar2;
            }
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ JsonElement read(JsonReader jsonReader) throws IOException {
            return a(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            b(jsonWriter, jsonElement);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$3, reason: invalid class name */
    public class AnonymousClass3 extends TypeAdapter<Boolean> {
        @Override // com.google.gson.TypeAdapter
        public Boolean read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenN = jsonReader.N();
            if (jsonTokenN != JsonToken.NULL) {
                return jsonTokenN == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.J())) : Boolean.valueOf(jsonReader.u());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.C(bool);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30, reason: invalid class name */
    public class AnonymousClass30 implements TypeAdapterFactory2 {
        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new EnumTypeAdapter(rawType);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31, reason: invalid class name */
    public class AnonymousClass31 implements TypeAdapterFactory2 {
        public final /* synthetic */ TypeToken j;
        public final /* synthetic */ TypeAdapter k;

        public AnonymousClass31(TypeToken typeToken, TypeAdapter typeAdapter) {
            this.j = typeToken;
            this.k = typeAdapter;
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.equals(this.j)) {
                return this.k;
            }
            return null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$32, reason: invalid class name */
    public class AnonymousClass32 implements TypeAdapterFactory2 {
        public final /* synthetic */ Class j;
        public final /* synthetic */ TypeAdapter k;

        public AnonymousClass32(Class cls, TypeAdapter typeAdapter) {
            this.j = cls;
            this.k = typeAdapter;
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == this.j) {
                return this.k;
            }
            return null;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Factory[type=");
            outline.k0(this.j, sbU, ",adapter=");
            sbU.append(this.k);
            sbU.append("]");
            return sbU.toString();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$33, reason: invalid class name */
    public class AnonymousClass33 implements TypeAdapterFactory2 {
        public final /* synthetic */ Class j;
        public final /* synthetic */ Class k;
        public final /* synthetic */ TypeAdapter l;

        public AnonymousClass33(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.j = cls;
            this.k = cls2;
            this.l = typeAdapter;
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.j || rawType == this.k) {
                return this.l;
            }
            return null;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Factory[type=");
            outline.k0(this.k, sbU, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
            outline.k0(this.j, sbU, ",adapter=");
            sbU.append(this.l);
            sbU.append("]");
            return sbU.toString();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$34, reason: invalid class name */
    public class AnonymousClass34 implements TypeAdapterFactory2 {
        public final /* synthetic */ Class j;
        public final /* synthetic */ Class k;
        public final /* synthetic */ TypeAdapter l;

        public AnonymousClass34(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.j = cls;
            this.k = cls2;
            this.l = typeAdapter;
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.j || rawType == this.k) {
                return this.l;
            }
            return null;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Factory[type=");
            outline.k0(this.j, sbU, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
            outline.k0(this.k, sbU, ",adapter=");
            sbU.append(this.l);
            sbU.append("]");
            return sbU.toString();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$35, reason: invalid class name */
    public class AnonymousClass35 implements TypeAdapterFactory2 {
        public final /* synthetic */ Class j;
        public final /* synthetic */ TypeAdapter k;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* renamed from: com.google.gson.internal.bind.TypeAdapters$35$1, reason: invalid class name */
        public class AnonymousClass1<T1> extends TypeAdapter<T1> {
            public final /* synthetic */ Class a;

            public AnonymousClass1(Class cls) {
                this.a = cls;
            }

            @Override // com.google.gson.TypeAdapter
            public T1 read(JsonReader jsonReader) throws IOException {
                T1 t1 = (T1) AnonymousClass35.this.k.read(jsonReader);
                if (t1 == null || this.a.isInstance(t1)) {
                    return t1;
                }
                StringBuilder sbU = outline.U("Expected a ");
                sbU.append(this.a.getName());
                sbU.append(" but was ");
                sbU.append(t1.getClass().getName());
                throw new JsonSyntaxException(sbU.toString());
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, T1 t1) throws IOException {
                AnonymousClass35.this.k.write(jsonWriter, t1);
            }
        }

        public AnonymousClass35(Class cls, TypeAdapter typeAdapter) {
            this.j = cls;
            this.k = typeAdapter;
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
            Class<? super T2> rawType = typeToken.getRawType();
            if (this.j.isAssignableFrom(rawType)) {
                return new AnonymousClass1(rawType);
            }
            return null;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Factory[typeHierarchy=");
            outline.k0(this.j, sbU, ",adapter=");
            sbU.append(this.k);
            sbU.append("]");
            return sbU.toString();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$4, reason: invalid class name */
    public class AnonymousClass4 extends TypeAdapter<Boolean> {
        @Override // com.google.gson.TypeAdapter
        public Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.J());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            Boolean bool2 = bool;
            jsonWriter.H(bool2 == null ? "null" : bool2.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$5, reason: invalid class name */
    public class AnonymousClass5 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.y());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.D(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$6, reason: invalid class name */
    public class AnonymousClass6 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.y());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.D(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$7, reason: invalid class name */
    public class AnonymousClass7 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.y());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.D(number);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$8, reason: invalid class name */
    public class AnonymousClass8 extends TypeAdapter<AtomicInteger> {
        @Override // com.google.gson.TypeAdapter
        public AtomicInteger read(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.y());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
            jsonWriter.A(atomicInteger.get());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$9, reason: invalid class name */
    public class AnonymousClass9 extends TypeAdapter<AtomicBoolean> {
        @Override // com.google.gson.TypeAdapter
        public AtomicBoolean read(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.u());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
            jsonWriter.I(atomicBoolean.get());
        }
    }

    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        public final Map<String, T> a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map<T, String> f3134b = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    SerializedName serializedName = (SerializedName) cls.getField(strName).getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        strName = serializedName.value();
                        for (String str : serializedName.alternate()) {
                            this.a.put(str, t);
                        }
                    }
                    this.a.put(strName, t);
                    this.f3134b.put(t, strName);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.N() != JsonToken.NULL) {
                return this.a.get(jsonReader.J());
            }
            jsonReader.H();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            Enum r3 = (Enum) obj;
            jsonWriter.H(r3 == null ? null : this.f3134b.get(r3));
        }
    }

    static {
        TypeAdapter<Class> typeAdapterNullSafe = new AnonymousClass1().nullSafe();
        a = typeAdapterNullSafe;
        f3128b = new AnonymousClass32(Class.class, typeAdapterNullSafe);
        TypeAdapter<BitSet> typeAdapterNullSafe2 = new AnonymousClass2().nullSafe();
        c = typeAdapterNullSafe2;
        d = new AnonymousClass32(BitSet.class, typeAdapterNullSafe2);
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        e = anonymousClass3;
        f = new AnonymousClass4();
        g = new AnonymousClass33(Boolean.TYPE, Boolean.class, anonymousClass3);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5();
        h = anonymousClass5;
        i = new AnonymousClass33(Byte.TYPE, Byte.class, anonymousClass5);
        AnonymousClass6 anonymousClass6 = new AnonymousClass6();
        j = anonymousClass6;
        k = new AnonymousClass33(Short.TYPE, Short.class, anonymousClass6);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7();
        l = anonymousClass7;
        m = new AnonymousClass33(Integer.TYPE, Integer.class, anonymousClass7);
        TypeAdapter<AtomicInteger> typeAdapterNullSafe3 = new AnonymousClass8().nullSafe();
        n = typeAdapterNullSafe3;
        o = new AnonymousClass32(AtomicInteger.class, typeAdapterNullSafe3);
        TypeAdapter<AtomicBoolean> typeAdapterNullSafe4 = new AnonymousClass9().nullSafe();
        p = typeAdapterNullSafe4;
        q = new AnonymousClass32(AtomicBoolean.class, typeAdapterNullSafe4);
        TypeAdapter<AtomicIntegerArray> typeAdapterNullSafe5 = new AnonymousClass10().nullSafe();
        r = typeAdapterNullSafe5;
        f3129s = new AnonymousClass32(AtomicIntegerArray.class, typeAdapterNullSafe5);
        t = new AnonymousClass11();
        u = new AnonymousClass12();
        v = new AnonymousClass13();
        AnonymousClass14 anonymousClass14 = new AnonymousClass14();
        w = anonymousClass14;
        f3130x = new AnonymousClass32(Number.class, anonymousClass14);
        AnonymousClass15 anonymousClass15 = new AnonymousClass15();
        f3131y = anonymousClass15;
        f3132z = new AnonymousClass33(Character.TYPE, Character.class, anonymousClass15);
        AnonymousClass16 anonymousClass16 = new AnonymousClass16();
        A = anonymousClass16;
        B = new AnonymousClass17();
        C = new AnonymousClass18();
        D = new AnonymousClass32(String.class, anonymousClass16);
        AnonymousClass19 anonymousClass19 = new AnonymousClass19();
        E = anonymousClass19;
        F = new AnonymousClass32(StringBuilder.class, anonymousClass19);
        AnonymousClass20 anonymousClass20 = new AnonymousClass20();
        G = anonymousClass20;
        H = new AnonymousClass32(StringBuffer.class, anonymousClass20);
        AnonymousClass21 anonymousClass21 = new AnonymousClass21();
        I = anonymousClass21;
        J = new AnonymousClass32(URL.class, anonymousClass21);
        AnonymousClass22 anonymousClass22 = new AnonymousClass22();
        K = anonymousClass22;
        L = new AnonymousClass32(URI.class, anonymousClass22);
        AnonymousClass23 anonymousClass23 = new AnonymousClass23();
        M = anonymousClass23;
        N = new AnonymousClass35(InetAddress.class, anonymousClass23);
        AnonymousClass24 anonymousClass24 = new AnonymousClass24();
        O = anonymousClass24;
        P = new AnonymousClass32(UUID.class, anonymousClass24);
        TypeAdapter<Currency> typeAdapterNullSafe6 = new AnonymousClass25().nullSafe();
        Q = typeAdapterNullSafe6;
        R = new AnonymousClass32(Currency.class, typeAdapterNullSafe6);
        S = new AnonymousClass26();
        AnonymousClass27 anonymousClass27 = new AnonymousClass27();
        T = anonymousClass27;
        U = new AnonymousClass34(Calendar.class, GregorianCalendar.class, anonymousClass27);
        AnonymousClass28 anonymousClass28 = new AnonymousClass28();
        V = anonymousClass28;
        W = new AnonymousClass32(Locale.class, anonymousClass28);
        AnonymousClass29 anonymousClass29 = new AnonymousClass29();
        X = anonymousClass29;
        Y = new AnonymousClass35(JsonElement.class, anonymousClass29);
        Z = new AnonymousClass30();
    }
}
