package com.discord.api.utcdatetime;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;

/* compiled from: UtcDateTime.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/discord/api/utcdatetime/UtcDateTimeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/utcdatetime/UtcDateTime;", "<init>", "()V", "Companion", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.utcdatetime.UtcDateTimeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class UtcDateTime2 extends TypeAdapter<UtcDateTime> {
    private static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    @Override // com.google.gson.TypeAdapter
    public UtcDateTime read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        String strJ = jsonReader.J();
        long time = 0;
        if (strJ != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date = simpleDateFormat.parse(strJ);
                if (date != null) {
                    time = date.getTime();
                }
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException | ParseException unused) {
            }
        }
        return new UtcDateTime(time);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, UtcDateTime utcDateTime) throws IOException {
        UtcDateTime utcDateTime2 = utcDateTime;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (utcDateTime2 == null) {
            jsonWriter.s();
            return;
        }
        long dateTimeMillis = utcDateTime2.getDateTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        jsonWriter.H(simpleDateFormat.format(new Date(dateTimeMillis)));
    }
}
