package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandPermission;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationCommand.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\u0010\r\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t\u0012$\b\u0002\u0010\u0016\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/discord/models/commands/RemoteApplicationCommand;", "Lcom/discord/models/commands/ApplicationCommand;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "", "Lcom/discord/primitives/ApplicationId;", "applicationId", ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "", "Lcom/discord/models/commands/ApplicationCommandOption;", "options", "Lcom/discord/primitives/GuildId;", "guildId", "version", "", "defaultPermissions", "Lcom/discord/api/commands/ApplicationCommandPermission;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lkotlin/Function1;", "", "", "execute", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.commands.RemoteApplicationCommand, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommand5 extends ApplicationCommand {
    public /* synthetic */ ApplicationCommand5(String str, long j, String str2, String str3, List list, Long l, String str4, Boolean bool, List list2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, (i & 8) != 0 ? null : str3, list, l, str4, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : function1);
    }

    public ApplicationCommand5(String str, long j, String str2, String str3, List<ApplicationCommandOption> list, Long l, String str4, Boolean bool, List<ApplicationCommandPermission> list2, Function1<? super Map<String, ? extends Object>, String> function1) {
        Map map;
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "options");
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
            for (ApplicationCommandPermission applicationCommandPermission : list2) {
                arrayList.add(Tuples.to(Long.valueOf(applicationCommandPermission.getId()), Boolean.valueOf(applicationCommandPermission.getPermission())));
            }
            map = Maps6.toMap(arrayList);
        } else {
            map = null;
        }
        super(str, j, str2, str3, null, list, false, l, str4, bool, map, function1, 80, null);
    }
}
