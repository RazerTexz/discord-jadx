package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/report/ReportNodeChildTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/report/ReportNodeChild;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ReportNodeChildTypeAdapter extends TypeAdapter<ReportNodeChild> {
    @Override // com.google.gson.TypeAdapter
    public ReportNodeChild read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "reader");
        jsonReader.a();
        String strJ = jsonReader.J();
        int iY = jsonReader.y();
        jsonReader.e();
        Intrinsics3.checkNotNullExpressionValue(strJ, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ReportNodeChild(strJ, iY);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ReportNodeChild reportNodeChild) throws IOException {
        ReportNodeChild reportNodeChild2 = reportNodeChild;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        Intrinsics3.checkNotNullParameter(reportNodeChild2, "child");
        jsonWriter.b().H(reportNodeChild2.getName()).D(Integer.valueOf(reportNodeChild2.getRef())).e();
    }
}
