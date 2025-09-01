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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes3.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory2 a = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public final DateFormat f3124b = new SimpleDateFormat("MMM d, yyyy");

    /* renamed from: com.google.gson.internal.bind.SqlDateTypeAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements TypeAdapterFactory2 {
        @Override // b.i.d.TypeAdapterFactory2
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        Date date;
        synchronized (this) {
            if (jsonReader.N() == JsonToken.NULL) {
                jsonReader.H();
                date = null;
            } else {
                try {
                    date = new Date(this.f3124b.parse(jsonReader.J()).getTime());
                } catch (ParseException e) {
                    throw new JsonSyntaxException(e);
                }
            }
        }
        return date;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        Date date2 = date;
        synchronized (this) {
            jsonWriter.H(date2 == null ? null : this.f3124b.format((java.util.Date) date2));
        }
    }
}
