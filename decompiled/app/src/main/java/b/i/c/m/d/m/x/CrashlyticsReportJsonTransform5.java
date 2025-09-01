package b.i.c.m.d.m.x;

import android.util.Base64;
import android.util.JsonReader;
import b.d.b.a.outline;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import b.i.c.m.d.m.CrashlyticsReport;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import b.i.c.p.DataEncoder;
import java.io.IOException;
import java.util.Objects;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* renamed from: b.i.c.m.d.m.x.e, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform5 implements CrashlyticsReportJsonTransform8.a {
    public static final CrashlyticsReportJsonTransform5 a = new CrashlyticsReportJsonTransform5();

    @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
    public Object a(JsonReader jsonReader) throws IOException {
        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.a;
        jsonReader.beginObject();
        Long lValueOf = null;
        Long lValueOf2 = null;
        String strNextString = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "name":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null name");
                    break;
                case "size":
                    lValueOf2 = Long.valueOf(jsonReader.nextLong());
                    break;
                case "uuid":
                    str = new String(Base64.decode(jsonReader.nextString(), 2), CrashlyticsReport.a);
                    break;
                case "baseAddress":
                    lValueOf = Long.valueOf(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        String strW = lValueOf == null ? " baseAddress" : "";
        if (lValueOf2 == null) {
            strW = outline.w(strW, " size");
        }
        if (strNextString == null) {
            strW = outline.w(strW, " name");
        }
        if (strW.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(lValueOf.longValue(), lValueOf2.longValue(), strNextString, str, null);
        }
        throw new IllegalStateException(outline.w("Missing required properties:", strW));
    }
}
