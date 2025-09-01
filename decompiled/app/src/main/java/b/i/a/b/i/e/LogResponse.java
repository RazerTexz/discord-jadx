package b.i.a.b.i.e;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.io.IOException;
import java.io.Reader;

/* compiled from: LogResponse.java */
@AutoValue
/* renamed from: b.i.a.b.i.e.n, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class LogResponse {
    @NonNull
    public static LogResponse a(@NonNull Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    return jsonReader.peek() == JsonToken.STRING ? new AutoValue_LogResponse(Long.parseLong(jsonReader.nextString())) : new AutoValue_LogResponse(jsonReader.nextLong());
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    public abstract long b();
}
