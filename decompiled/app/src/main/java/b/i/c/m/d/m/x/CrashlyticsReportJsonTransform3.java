package b.i.c.m.d.m.x;

import android.util.JsonReader;
import b.d.b.a.outline;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_CustomAttribute;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import b.i.c.p.DataEncoder;
import java.io.IOException;
import java.util.Objects;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* renamed from: b.i.c.m.d.m.x.c, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform3 implements CrashlyticsReportJsonTransform8.a {
    public static final CrashlyticsReportJsonTransform3 a = new CrashlyticsReportJsonTransform3();

    @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
    public Object a(JsonReader jsonReader) throws IOException {
        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.a;
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("key")) {
                strNextString = jsonReader.nextString();
                Objects.requireNonNull(strNextString, "Null key");
            } else if (strNextName.equals("value")) {
                strNextString2 = jsonReader.nextString();
                Objects.requireNonNull(strNextString2, "Null value");
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        String strW = strNextString == null ? " key" : "";
        if (strNextString2 == null) {
            strW = outline.w(strW, " value");
        }
        if (strW.isEmpty()) {
            return new AutoValue_CrashlyticsReport_CustomAttribute(strNextString, strNextString2, null);
        }
        throw new IllegalStateException(outline.w("Missing required properties:", strW));
    }
}
