package b.i.c.m.d.m.x;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.c.m.d.m.AutoCrashlyticsReportEncoder;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_FilesPayload;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Application;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Device;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Device;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_Event_Log;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import b.i.c.m.d.m.AutoValue_CrashlyticsReport_Session_User;
import b.i.c.m.d.m.CrashlyticsReport;
import b.i.c.m.d.m.ImmutableList3;
import b.i.c.p.DataEncoder;
import b.i.c.p.h.JsonDataEncoderBuilder4;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: CrashlyticsReportJsonTransform.java */
/* renamed from: b.i.c.m.d.m.x.h, reason: use source file name */
/* loaded from: classes3.dex */
public class CrashlyticsReportJsonTransform8 {
    public static final DataEncoder a;

    /* compiled from: CrashlyticsReportJsonTransform.java */
    /* renamed from: b.i.c.m.d.m.x.h$a */
    public interface a<T> {
        T a(@NonNull JsonReader jsonReader) throws IOException;
    }

    static {
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = new JsonDataEncoderBuilder5();
        ((AutoCrashlyticsReportEncoder) AutoCrashlyticsReportEncoder.a).a(jsonDataEncoderBuilder5);
        jsonDataEncoderBuilder5.e = true;
        a = new JsonDataEncoderBuilder4(jsonDataEncoderBuilder5);
    }

    @NonNull
    public static <T> ImmutableList3<T> a(@NonNull JsonReader jsonReader, @NonNull a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return new ImmutableList3<>(arrayList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0113  */
    /* JADX WARN: Type inference failed for: r2v1, types: [b.i.c.m.d.m.s$a] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CrashlyticsReport.d.AbstractC0049d b(@NonNull JsonReader jsonReader) throws IOException {
        String strW;
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        jsonReader.beginObject();
        Long lValueOf = null;
        Integer numValueOf = 0;
        String str = null;
        AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = null;
        CrashlyticsReport.d.AbstractC0049d.b bVarA = null;
        AutoValue_CrashlyticsReport_Session_Event_Log autoValue_CrashlyticsReport_Session_Event_Log = null;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                strW = lValueOf == null ? " timestamp" : "";
                if (str == null) {
                    strW = outline.w(strW, " type");
                }
                if (autoValue_CrashlyticsReport_Session_Event_Application == null) {
                    strW = outline.w(strW, " app");
                }
                if (bVarA == null) {
                    strW = outline.w(strW, " device");
                }
                if (strW.isEmpty()) {
                    return new AutoValue_CrashlyticsReport_Session_Event(lValueOf.longValue(), str, autoValue_CrashlyticsReport_Session_Event_Application, bVarA, autoValue_CrashlyticsReport_Session_Event_Log, null);
                }
                throw new IllegalStateException(outline.w("Missing required properties:", strW));
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName.hashCode()) {
                case -1335157162:
                    if (!strNextName.equals("device")) {
                        c = 65535;
                        break;
                    } else {
                        c = 0;
                        break;
                    }
                case 96801:
                    if (strNextName.equals("app")) {
                        c = 1;
                        break;
                    }
                    break;
                case 107332:
                    if (strNextName.equals("log")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3575610:
                    if (strNextName.equals("type")) {
                        c = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (strNextName.equals("timestamp")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                AutoValue_CrashlyticsReport_Session_Event_Device.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Device.b();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    switch (strNextName2.hashCode()) {
                        case -1708606089:
                            if (!strNextName2.equals("batteryLevel")) {
                                c2 = 65535;
                                break;
                            } else {
                                c2 = 0;
                                break;
                            }
                        case -1455558134:
                            if (strNextName2.equals("batteryVelocity")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -1439500848:
                            if (strNextName2.equals("orientation")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 279795450:
                            if (strNextName2.equals("diskUsed")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 976541947:
                            if (strNextName2.equals("ramUsed")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 1516795582:
                            if (strNextName2.equals("proximityOn")) {
                                c2 = 5;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0) {
                        bVar.a = Double.valueOf(jsonReader.nextDouble());
                    } else if (c2 == 1) {
                        bVar.f1734b = Integer.valueOf(jsonReader.nextInt());
                    } else if (c2 == 2) {
                        bVar.d = Integer.valueOf(jsonReader.nextInt());
                    } else if (c2 == 3) {
                        bVar.f = Long.valueOf(jsonReader.nextLong());
                    } else if (c2 == 4) {
                        bVar.e = Long.valueOf(jsonReader.nextLong());
                    } else if (c2 != 5) {
                        jsonReader.skipValue();
                    } else {
                        bVar.c = Boolean.valueOf(jsonReader.nextBoolean());
                    }
                }
                jsonReader.endObject();
                bVarA = bVar.a();
            } else if (c == 1) {
                jsonReader.beginObject();
                AutoValue_CrashlyticsReport_Session_Event_Application_Execution autoValue_CrashlyticsReport_Session_Event_Application_Execution = numValueOf;
                ImmutableList3 immutableList3A = autoValue_CrashlyticsReport_Session_Event_Application_Execution;
                Boolean boolValueOf = immutableList3A;
                while (true) {
                    char c6 = 3;
                    if (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        switch (strNextName3.hashCode()) {
                            case -1332194002:
                                if (!strNextName3.equals("background")) {
                                    c3 = 65535;
                                    break;
                                } else {
                                    c3 = 0;
                                    break;
                                }
                            case -1090974952:
                                if (strNextName3.equals("execution")) {
                                    c3 = 1;
                                    break;
                                }
                                break;
                            case 555169704:
                                if (strNextName3.equals("customAttributes")) {
                                    c3 = 2;
                                    break;
                                }
                                break;
                            case 928737948:
                                if (strNextName3.equals("uiOrientation")) {
                                    c3 = 3;
                                    break;
                                }
                                break;
                        }
                        if (c3 == 0) {
                            boolValueOf = Boolean.valueOf(jsonReader.nextBoolean());
                        } else if (c3 == 1) {
                            jsonReader.beginObject();
                            CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052bC = null;
                            AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = null;
                            ImmutableList3 immutableList3A2 = null;
                            ImmutableList3 immutableList3A3 = null;
                            while (jsonReader.hasNext()) {
                                String strNextName4 = jsonReader.nextName();
                                strNextName4.hashCode();
                                switch (strNextName4.hashCode()) {
                                    case -1337936983:
                                        if (!strNextName4.equals("threads")) {
                                            c4 = 65535;
                                            break;
                                        } else {
                                            c4 = 0;
                                            break;
                                        }
                                    case -902467928:
                                        if (strNextName4.equals("signal")) {
                                            c4 = 1;
                                            break;
                                        }
                                        break;
                                    case 937615455:
                                        if (strNextName4.equals("binaries")) {
                                            c4 = 2;
                                            break;
                                        }
                                        break;
                                    case 1481625679:
                                        if (strNextName4.equals("exception")) {
                                            c4 = 3;
                                            break;
                                        }
                                        break;
                                }
                                if (c4 == 0) {
                                    immutableList3A3 = a(jsonReader, CrashlyticsReportJsonTransform4.a);
                                } else if (c4 == 1) {
                                    jsonReader.beginObject();
                                    Long lValueOf2 = null;
                                    String str2 = null;
                                    String str3 = null;
                                    while (jsonReader.hasNext()) {
                                        String strNextName5 = jsonReader.nextName();
                                        strNextName5.hashCode();
                                        int iHashCode = strNextName5.hashCode();
                                        if (iHashCode != -1147692044) {
                                            if (iHashCode != 3059181) {
                                                c5 = (iHashCode == 3373707 && strNextName5.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) ? (char) 2 : (char) 65535;
                                            } else if (strNextName5.equals(ModelAuditLogEntry.CHANGE_KEY_CODE)) {
                                                c5 = 1;
                                            }
                                        } else if (strNextName5.equals("address")) {
                                            c5 = 0;
                                        }
                                        if (c5 == 0) {
                                            lValueOf2 = Long.valueOf(jsonReader.nextLong());
                                        } else if (c5 == 1) {
                                            String strNextString = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString, "Null code");
                                            str3 = strNextString;
                                        } else if (c5 != 2) {
                                            jsonReader.skipValue();
                                        } else {
                                            String strNextString2 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString2, "Null name");
                                            str2 = strNextString2;
                                        }
                                    }
                                    jsonReader.endObject();
                                    String strW2 = str2 == null ? " name" : "";
                                    if (str3 == null) {
                                        strW2 = outline.w(strW2, " code");
                                    }
                                    if (lValueOf2 == null) {
                                        strW2 = outline.w(strW2, " address");
                                    }
                                    if (!strW2.isEmpty()) {
                                        throw new IllegalStateException(outline.w("Missing required properties:", strW2));
                                    }
                                    autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(str2, str3, lValueOf2.longValue(), null);
                                } else if (c4 == 2) {
                                    immutableList3A2 = a(jsonReader, CrashlyticsReportJsonTransform5.a);
                                } else if (c4 != c6) {
                                    jsonReader.skipValue();
                                } else {
                                    abstractC0052bC = c(jsonReader);
                                }
                                c6 = 3;
                            }
                            jsonReader.endObject();
                            String strW3 = immutableList3A3 == null ? " threads" : "";
                            if (abstractC0052bC == null) {
                                strW3 = outline.w(strW3, " exception");
                            }
                            if (autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal == null) {
                                strW3 = outline.w(strW3, " signal");
                            }
                            if (immutableList3A2 == null) {
                                strW3 = outline.w(strW3, " binaries");
                            }
                            if (!strW3.isEmpty()) {
                                throw new IllegalStateException(outline.w("Missing required properties:", strW3));
                            }
                            autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(immutableList3A3, abstractC0052bC, autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal, immutableList3A2, null);
                        } else if (c3 == 2) {
                            immutableList3A = a(jsonReader, CrashlyticsReportJsonTransform3.a);
                        } else if (c3 != 3) {
                            jsonReader.skipValue();
                        } else {
                            numValueOf = Integer.valueOf(jsonReader.nextInt());
                        }
                    } else {
                        jsonReader.endObject();
                        strW = autoValue_CrashlyticsReport_Session_Event_Application_Execution == null ? " execution" : "";
                        if (numValueOf == 0) {
                            strW = outline.w(strW, " uiOrientation");
                        }
                        if (!strW.isEmpty()) {
                            throw new IllegalStateException(outline.w("Missing required properties:", strW));
                        }
                        autoValue_CrashlyticsReport_Session_Event_Application = new AutoValue_CrashlyticsReport_Session_Event_Application(autoValue_CrashlyticsReport_Session_Event_Application_Execution, immutableList3A, boolValueOf, numValueOf.intValue(), null);
                    }
                }
            } else if (c == 2) {
                jsonReader.beginObject();
                String strNextString3 = numValueOf;
                while (jsonReader.hasNext()) {
                    String strNextName6 = jsonReader.nextName();
                    strNextName6.hashCode();
                    if (strNextName6.equals("content")) {
                        strNextString3 = jsonReader.nextString();
                        Objects.requireNonNull(strNextString3, "Null content");
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                strW = strNextString3 == null ? " content" : "";
                if (!strW.isEmpty()) {
                    throw new IllegalStateException(outline.w("Missing required properties:", strW));
                }
                autoValue_CrashlyticsReport_Session_Event_Log = new AutoValue_CrashlyticsReport_Session_Event_Log(strNextString3, numValueOf);
            } else if (c == 3) {
                String strNextString4 = jsonReader.nextString();
                Objects.requireNonNull(strNextString4, "Null type");
                str = strNextString4;
            } else if (c != 4) {
                jsonReader.skipValue();
            } else {
                lValueOf = Long.valueOf(jsonReader.nextLong());
            }
            numValueOf = 0;
        }
    }

    @NonNull
    public static CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b c(@NonNull JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        Integer numValueOf = null;
        String strNextString = null;
        String strNextString2 = null;
        ImmutableList3 immutableList3A = null;
        CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0052b abstractC0052bC = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    immutableList3A = a(jsonReader, CrashlyticsReportJsonTransform6.a);
                    break;
                case "reason":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "type":
                    strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null type");
                    break;
                case "causedBy":
                    abstractC0052bC = c(jsonReader);
                    break;
                case "overflowCount":
                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        String strW = strNextString == null ? " type" : "";
        if (immutableList3A == null) {
            strW = outline.w(strW, " frames");
        }
        if (numValueOf == null) {
            strW = outline.w(strW, " overflowCount");
        }
        if (strW.isEmpty()) {
            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(strNextString, strNextString2, immutableList3A, abstractC0052bC, numValueOf.intValue(), null);
        }
        throw new IllegalStateException(outline.w("Missing required properties:", strW));
    }

    @NonNull
    public static CrashlyticsReport.d.AbstractC0049d.a.b.AbstractC0053d.AbstractC0054a d(@NonNull JsonReader jsonReader) throws IOException {
        AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b bVar = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "offset":
                    bVar.d = Long.valueOf(jsonReader.nextLong());
                    break;
                case "symbol":
                    String strNextString = jsonReader.nextString();
                    Objects.requireNonNull(strNextString, "Null symbol");
                    bVar.f1732b = strNextString;
                    break;
                case "pc":
                    bVar.a = Long.valueOf(jsonReader.nextLong());
                    break;
                case "file":
                    bVar.c = jsonReader.nextString();
                    break;
                case "importance":
                    bVar.e = Integer.valueOf(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVar.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:149:0x021a A[PHI: r17
      0x021a: PHI (r17v15 java.lang.String) = (r17v10 java.lang.String), (r17v11 java.lang.String), (r17v12 java.lang.String), (r17v16 java.lang.String) binds: [B:146:0x0215, B:142:0x020a, B:138:0x01fd, B:123:0x01d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012b  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CrashlyticsReport e(@NonNull JsonReader jsonReader) throws IOException {
        char c;
        String str;
        char c2;
        String str2;
        char c3;
        Charset charset = CrashlyticsReport.a;
        AutoValue_CrashlyticsReport.b bVar = new AutoValue_CrashlyticsReport.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName.hashCode()) {
                case -2118372775:
                    if (!strNextName.equals("ndkPayload")) {
                        c = 65535;
                        break;
                    } else {
                        c = 0;
                        break;
                    }
                case -1962630338:
                    if (strNextName.equals("sdkVersion")) {
                        c = 1;
                        break;
                    }
                    break;
                case -911706486:
                    if (strNextName.equals("buildVersion")) {
                        c = 2;
                        break;
                    }
                    break;
                case 344431858:
                    if (strNextName.equals("gmpAppId")) {
                        c = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (strNextName.equals("installationUuid")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1874684019:
                    if (strNextName.equals("platform")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1975623094:
                    if (strNextName.equals("displayVersion")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1984987798:
                    if (strNextName.equals("session")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            String str3 = "";
            switch (c) {
                case 0:
                    jsonReader.beginObject();
                    String strNextString = null;
                    ImmutableList3 immutableList3A = null;
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(ChatInputComponentTypes.FILES)) {
                            immutableList3A = a(jsonReader, CrashlyticsReportJsonTransform2.a);
                        } else if (strNextName2.equals("orgId")) {
                            strNextString = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    String str4 = immutableList3A == null ? " files" : "";
                    if (!str4.isEmpty()) {
                        throw new IllegalStateException(outline.w("Missing required properties:", str4));
                    }
                    bVar.h = new AutoValue_CrashlyticsReport_FilesPayload(immutableList3A, strNextString, null);
                    break;
                case 1:
                    String strNextString2 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString2, "Null sdkVersion");
                    bVar.a = strNextString2;
                    break;
                case 2:
                    String strNextString3 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString3, "Null buildVersion");
                    bVar.e = strNextString3;
                    break;
                case 3:
                    String strNextString4 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString4, "Null gmpAppId");
                    bVar.f1714b = strNextString4;
                    break;
                case 4:
                    String strNextString5 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString5, "Null installationUuid");
                    bVar.d = strNextString5;
                    break;
                case 5:
                    bVar.c = Integer.valueOf(jsonReader.nextInt());
                    break;
                case 6:
                    String strNextString6 = jsonReader.nextString();
                    Objects.requireNonNull(strNextString6, "Null displayVersion");
                    bVar.f = strNextString6;
                    break;
                case 7:
                    AutoValue_CrashlyticsReport_Session.b bVar2 = new AutoValue_CrashlyticsReport_Session.b();
                    bVar2.b(false);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        switch (strNextName3) {
                            case "startedAt":
                                str = str3;
                                bVar2.c = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                            case "identifier":
                                str = str3;
                                bVar2.f1719b = new String(Base64.decode(jsonReader.nextString(), 2), CrashlyticsReport.a);
                                str3 = str;
                            case "endedAt":
                                str = str3;
                                bVar2.d = Long.valueOf(jsonReader.nextLong());
                                str3 = str;
                            case "device":
                                str = str3;
                                AutoValue_CrashlyticsReport_Session_Device.b bVar3 = new AutoValue_CrashlyticsReport_Session_Device.b();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String strNextName4 = jsonReader.nextName();
                                    strNextName4.hashCode();
                                    switch (strNextName4) {
                                        case "simulator":
                                            bVar3.f = Boolean.valueOf(jsonReader.nextBoolean());
                                            break;
                                        case "manufacturer":
                                            String strNextString7 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString7, "Null manufacturer");
                                            bVar3.h = strNextString7;
                                            break;
                                        case "ram":
                                            bVar3.d = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "arch":
                                            bVar3.a = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "diskSpace":
                                            bVar3.e = Long.valueOf(jsonReader.nextLong());
                                            break;
                                        case "cores":
                                            bVar3.c = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "model":
                                            String strNextString8 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString8, "Null model");
                                            bVar3.f1722b = strNextString8;
                                            break;
                                        case "state":
                                            bVar3.g = Integer.valueOf(jsonReader.nextInt());
                                            break;
                                        case "modelClass":
                                            String strNextString9 = jsonReader.nextString();
                                            Objects.requireNonNull(strNextString9, "Null modelClass");
                                            bVar3.i = strNextString9;
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                bVar2.i = bVar3.a();
                                str3 = str;
                            case "events":
                                str = str3;
                                bVar2.j = a(jsonReader, CrashlyticsReportJsonTransform.a);
                                str3 = str;
                            case "os":
                                str = str3;
                                jsonReader.beginObject();
                                Boolean boolValueOf = null;
                                Integer numValueOf = null;
                                String str5 = null;
                                String str6 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName5 = jsonReader.nextName();
                                    strNextName5.hashCode();
                                    switch (strNextName5.hashCode()) {
                                        case -911706486:
                                            if (!strNextName5.equals("buildVersion")) {
                                                c2 = 65535;
                                                break;
                                            } else {
                                                c2 = 0;
                                                break;
                                            }
                                        case -293026577:
                                            if (strNextName5.equals("jailbroken")) {
                                                c2 = 1;
                                                break;
                                            }
                                            break;
                                        case 351608024:
                                            if (strNextName5.equals("version")) {
                                                c2 = 2;
                                                break;
                                            }
                                            break;
                                        case 1874684019:
                                            if (strNextName5.equals("platform")) {
                                                c2 = 3;
                                                break;
                                            }
                                            break;
                                    }
                                    if (c2 == 0) {
                                        String strNextString10 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString10, "Null buildVersion");
                                        str6 = strNextString10;
                                    } else if (c2 == 1) {
                                        boolValueOf = Boolean.valueOf(jsonReader.nextBoolean());
                                    } else if (c2 == 2) {
                                        String strNextString11 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString11, "Null version");
                                        str5 = strNextString11;
                                    } else if (c2 != 3) {
                                        jsonReader.skipValue();
                                    } else {
                                        numValueOf = Integer.valueOf(jsonReader.nextInt());
                                    }
                                }
                                jsonReader.endObject();
                                String strW = numValueOf == null ? " platform" : str;
                                if (str5 == null) {
                                    strW = outline.w(strW, " version");
                                }
                                if (str6 == null) {
                                    strW = outline.w(strW, " buildVersion");
                                }
                                if (boolValueOf == null) {
                                    strW = outline.w(strW, " jailbroken");
                                }
                                if (!strW.isEmpty()) {
                                    throw new IllegalStateException(outline.w("Missing required properties:", strW));
                                }
                                bVar2.h = new AutoValue_CrashlyticsReport_Session_OperatingSystem(numValueOf.intValue(), str5, str6, boolValueOf.booleanValue(), null);
                                str3 = str;
                            case "app":
                                jsonReader.beginObject();
                                String str7 = null;
                                String str8 = null;
                                String strNextString12 = null;
                                String strNextString13 = null;
                                String strNextString14 = null;
                                String strNextString15 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName6 = jsonReader.nextName();
                                    strNextName6.hashCode();
                                    switch (strNextName6.hashCode()) {
                                        case -1618432855:
                                            str2 = str3;
                                            if (!strNextName6.equals("identifier")) {
                                                c3 = 65535;
                                                break;
                                            } else {
                                                c3 = 0;
                                                break;
                                            }
                                        case -519438642:
                                            str2 = str3;
                                            if (strNextName6.equals("developmentPlatform")) {
                                                c3 = 1;
                                                break;
                                            }
                                            break;
                                        case 213652010:
                                            str2 = str3;
                                            if (strNextName6.equals("developmentPlatformVersion")) {
                                                c3 = 2;
                                                break;
                                            }
                                            break;
                                        case 351608024:
                                            if (strNextName6.equals("version")) {
                                                c3 = 3;
                                                str2 = str3;
                                                break;
                                            }
                                            str2 = str3;
                                            c3 = 65535;
                                            break;
                                        case 719853845:
                                            if (strNextName6.equals("installationUuid")) {
                                                c3 = 4;
                                                str2 = str3;
                                                break;
                                            }
                                            str2 = str3;
                                            c3 = 65535;
                                            break;
                                        case 1975623094:
                                            if (strNextName6.equals("displayVersion")) {
                                                c3 = 5;
                                                str2 = str3;
                                                break;
                                            }
                                            str2 = str3;
                                            c3 = 65535;
                                            break;
                                        default:
                                            str2 = str3;
                                            c3 = 65535;
                                            break;
                                    }
                                    if (c3 == 0) {
                                        String strNextString16 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString16, "Null identifier");
                                        str7 = strNextString16;
                                    } else if (c3 == 1) {
                                        strNextString14 = jsonReader.nextString();
                                    } else if (c3 == 2) {
                                        strNextString15 = jsonReader.nextString();
                                    } else if (c3 == 3) {
                                        String strNextString17 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString17, "Null version");
                                        str8 = strNextString17;
                                    } else if (c3 == 4) {
                                        strNextString13 = jsonReader.nextString();
                                    } else if (c3 != 5) {
                                        jsonReader.skipValue();
                                    } else {
                                        strNextString12 = jsonReader.nextString();
                                    }
                                    str3 = str2;
                                }
                                str = str3;
                                jsonReader.endObject();
                                String strW2 = str7 == null ? " identifier" : str;
                                if (str8 == null) {
                                    strW2 = outline.w(strW2, " version");
                                }
                                if (!strW2.isEmpty()) {
                                    throw new IllegalStateException(outline.w("Missing required properties:", strW2));
                                }
                                bVar2.f = new AutoValue_CrashlyticsReport_Session_Application(str7, str8, strNextString12, null, strNextString13, strNextString14, strNextString15, null);
                                str3 = str;
                            case "user":
                                jsonReader.beginObject();
                                String strNextString18 = null;
                                while (jsonReader.hasNext()) {
                                    String strNextName7 = jsonReader.nextName();
                                    strNextName7.hashCode();
                                    if (strNextName7.equals("identifier")) {
                                        strNextString18 = jsonReader.nextString();
                                        Objects.requireNonNull(strNextString18, "Null identifier");
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                }
                                jsonReader.endObject();
                                String str9 = strNextString18 == null ? " identifier" : str3;
                                if (!str9.isEmpty()) {
                                    throw new IllegalStateException(outline.w("Missing required properties:", str9));
                                }
                                bVar2.g = new AutoValue_CrashlyticsReport_Session_User(strNextString18, null);
                                str = str3;
                                str3 = str;
                            case "generator":
                                String strNextString19 = jsonReader.nextString();
                                Objects.requireNonNull(strNextString19, "Null generator");
                                bVar2.a = strNextString19;
                                str = str3;
                                str3 = str;
                            case "crashed":
                                bVar2.b(jsonReader.nextBoolean());
                                str = str3;
                                str3 = str;
                            case "generatorType":
                                bVar2.k = Integer.valueOf(jsonReader.nextInt());
                                str = str3;
                                str3 = str;
                            default:
                                str = str3;
                                jsonReader.skipValue();
                                str3 = str;
                        }
                    }
                    jsonReader.endObject();
                    bVar.g = bVar2.a();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVar.a();
    }

    @NonNull
    public CrashlyticsReport f(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport crashlyticsReportE = e(jsonReader);
                jsonReader.close();
                return crashlyticsReportE;
            } catch (Throwable th) {
                try {
                    jsonReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }

    @NonNull
    public String g(@NonNull CrashlyticsReport crashlyticsReport) {
        return ((JsonDataEncoderBuilder4) a).a(crashlyticsReport);
    }
}
