package com.discord.api.commands;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: ApplicationCommandPermission.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/api/commands/ApplicationCommandPermissionTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/discord/api/commands/ApplicationCommandPermissionType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.commands.ApplicationCommandPermissionTypeTypeAdapter, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommandPermission3 extends TypeAdapter<ApplicationCommandPermission2> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.api.commands.ApplicationCommandPermissionTypeTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationCommandPermission2.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationCommandPermission2.ROLE.ordinal()] = 1;
            iArr[ApplicationCommandPermission2.USER.ordinal()] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ApplicationCommandPermission2 read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        return iY != 1 ? iY != 2 ? ApplicationCommandPermission2.UNKNOWN : ApplicationCommandPermission2.USER : ApplicationCommandPermission2.ROLE;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // com.google.gson.TypeAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(JsonWriter jsonWriter, ApplicationCommandPermission2 applicationCommandPermission2) throws IOException {
        ApplicationCommandPermission2 applicationCommandPermission22 = applicationCommandPermission2;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        int i = 2;
        if (applicationCommandPermission22 != null) {
            int iOrdinal = applicationCommandPermission22.ordinal();
            if (iOrdinal == 1) {
                i = 1;
            } else if (iOrdinal != 2) {
                i = 0;
            }
        }
        jsonWriter.D(Integer.valueOf(i));
    }
}
