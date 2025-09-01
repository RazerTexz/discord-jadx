package b.i.c.m.d.m.x;

import android.util.JsonReader;
import b.d.b.a.outline;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import b.i.c.m.d.m.ImmutableList3;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import b.i.c.p.DataEncoder;
import java.io.IOException;
import java.util.Objects;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* renamed from: b.i.c.m.d.m.x.d, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform4 implements CrashlyticsReportJsonTransform8.a {
    public static final CrashlyticsReportJsonTransform4 a = new CrashlyticsReportJsonTransform4();

    @Override // b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8.a
    public Object a(JsonReader jsonReader) throws IOException {
        DataEncoder dataEncoder = CrashlyticsReportJsonTransform8.a;
        jsonReader.beginObject();
        String strNextString = null;
        Integer numValueOf = null;
        ImmutableList3 immutableList3A = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    immutableList3A = CrashlyticsReportJsonTransform8.a(jsonReader, CrashlyticsReportJsonTransform7.a);
                    break;
                case "name":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null name");
                    break;
                case "importance":
                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        String strW = strNextString == null ? " name" : "";
        if (numValueOf == null) {
            strW = outline.w(strW, " importance");
        }
        if (immutableList3A == null) {
            strW = outline.w(strW, " frames");
        }
        if (strW.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(strNextString, numValueOf.intValue(), immutableList3A, null);
        }
        throw new IllegalStateException(outline.w("Missing required properties:", strW));
    }
}
