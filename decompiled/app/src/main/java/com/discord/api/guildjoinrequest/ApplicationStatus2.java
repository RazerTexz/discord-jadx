package com.discord.api.guildjoinrequest;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: ApplicationStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/guildjoinrequest/ApplicationStatusTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildjoinrequest.ApplicationStatusTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationStatus2 extends TypeAdapter<ApplicationStatus> {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r2.equals("PENDING") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r2.equals("SUBMITTED") != false) goto L19;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.gson.TypeAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApplicationStatus read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        String strJ = jsonReader.J();
        if (strJ != null) {
            switch (strJ.hashCode()) {
                case -1179202463:
                    if (strJ.equals("STARTED")) {
                        return ApplicationStatus.STARTED;
                    }
                    break;
                case -1159694117:
                    break;
                case 35394935:
                    break;
                case 174130302:
                    if (strJ.equals("REJECTED")) {
                        return ApplicationStatus.REJECTED;
                    }
                    break;
                case 1967871671:
                    if (strJ.equals("APPROVED")) {
                        return ApplicationStatus.APPROVED;
                    }
                    break;
            }
            return ApplicationStatus.PENDING;
        }
        return ApplicationStatus.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ApplicationStatus applicationStatus) throws IOException {
        ApplicationStatus applicationStatus2 = applicationStatus;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (applicationStatus2 == null) {
            jsonWriter.s();
            return;
        }
        String strName = applicationStatus2.name();
        Locale locale = Locale.ROOT;
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strName.toUpperCase(locale);
        Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        jsonWriter.H(upperCase);
    }
}
