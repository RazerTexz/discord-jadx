package b.i.c.m.d.r;

import b.i.a.b.Transformer;
import b.i.c.m.d.m.CrashlyticsReport;
import com.adjust.sdk.Constants;
import java.nio.charset.Charset;

/* compiled from: DataTransportCrashlyticsReportSender.java */
/* renamed from: b.i.c.m.d.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class DataTransportCrashlyticsReportSender2 implements Transformer {
    public static final DataTransportCrashlyticsReportSender2 a = new DataTransportCrashlyticsReportSender2();

    @Override // b.i.a.b.Transformer
    public Object apply(Object obj) {
        return DataTransportCrashlyticsReportSender3.a.g((CrashlyticsReport) obj).getBytes(Charset.forName(Constants.ENCODING));
    }
}
