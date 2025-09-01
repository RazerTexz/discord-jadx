package com.discord.api.report;

import b.a.w.TypeTokens;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;

/* compiled from: InAppReportsMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/report/ReportNodeElementDataTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/report/ReportNodeElementData;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ReportNodeElementDataTypeAdapter extends TypeAdapter<ReportNodeElementData> {
    @Override // com.google.gson.TypeAdapter
    public ReportNodeElementData read(JsonReader jsonReader) throws JsonSyntaxException, JsonIOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "reader");
        Object objD = new Gson().d(jsonReader, TypeTokens.a);
        Intrinsics3.checkNotNullExpressionValue(objD, "Gson().fromJson(reader, STRING_LIST_TYPE)");
        List list = (List) objD;
        return new ReportNodeElementData((String) list.get(0), (String) list.get(1));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ReportNodeElementData reportNodeElementData) throws IOException {
        ReportNodeElementData reportNodeElementData2 = reportNodeElementData;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (reportNodeElementData2 == null) {
            jsonWriter.s();
        } else {
            jsonWriter.b().H(reportNodeElementData2.getElementKey()).H(reportNodeElementData2.getElementValue()).e();
        }
    }
}
