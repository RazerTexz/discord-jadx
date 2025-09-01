package b.i.c.m.d.m.x;

import android.util.Base64;
import android.util.JsonReader;
import b.d.b.a.outline;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_FilesPayload_File;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import b.i.c.p.DataEncoder;
import java.io.IOException;
import java.util.Objects;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* renamed from: b.i.c.m.d.m.x.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform2 implements CrashlyticsReportJsonTransform8.a {
    public static final CrashlyticsReportJsonTransform2 a = new CrashlyticsReportJsonTransform2();

    @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
    public Object a(JsonReader jsonReader) throws IOException {
        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.a;
        jsonReader.beginObject();
        String strNextString = null;
        byte[] bArrDecode = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("filename")) {
                strNextString = jsonReader.nextString();
                Objects.requireNonNull(strNextString, "Null filename");
            } else if (strNextName.equals("contents")) {
                bArrDecode = Base64.decode(jsonReader.nextString(), 2);
                Objects.requireNonNull(bArrDecode, "Null contents");
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        String strW = strNextString == null ? " filename" : "";
        if (bArrDecode == null) {
            strW = outline.w(strW, " contents");
        }
        if (strW.isEmpty()) {
            return new AutoValue_CrashlyticsReport_FilesPayload_File(strNextString, bArrDecode, null);
        }
        throw new IllegalStateException(outline.w("Missing required properties:", strW));
    }
}
