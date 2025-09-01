package com.google.gson.internal.bind;

import b.i.d.TypeAdapterFactory2;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes3.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory2 a = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final DateFormat f3125b = new SimpleDateFormat("hh:mm:ss a");

    /* renamed from: com.google.gson.internal.bind.TimeTypeAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements TypeAdapterFactory2 {
        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public Time read(JsonReader jsonReader) throws IOException {
        synchronized (this) {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                return null;
            }
            try {
                return new Time(this.f3125b.parse(jsonReader.J()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Time time) throws IOException {
        Time time2 = time;
        synchronized (this) {
            jsonWriter.H(time2 == null ? null : this.f3125b.format((Date) time2));
        }
    }
}
