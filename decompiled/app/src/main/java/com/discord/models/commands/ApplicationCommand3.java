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
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationCommand.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\t\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u000e\u0010\u0018\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0014\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/discord/models/commands/ApplicationSubCommand;", "Lcom/discord/models/commands/ApplicationCommand;", "", "parentGroupName", "Ljava/lang/String;", "getParentGroupName", "()Ljava/lang/String;", "subCommandName", "getSubCommandName", "rootCommand", "Lcom/discord/models/commands/ApplicationCommand;", "getRootCommand", "()Lcom/discord/models/commands/ApplicationCommand;", "", "Lcom/discord/primitives/ApplicationId;", "applicationId", ModelAuditLogEntry.CHANGE_KEY_NAME, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "", "descriptionRes", "", "Lcom/discord/models/commands/ApplicationCommandOption;", "options", "Lcom/discord/primitives/GuildId;", "guildId", "", "defaultPermissions", "Lcom/discord/api/commands/ApplicationCommandPermission;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "version", "<init>", "(Lcom/discord/models/commands/ApplicationCommand;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.models.commands.ApplicationSubCommand, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommand3 extends ApplicationCommand {
    private final String parentGroupName;
    private final ApplicationCommand rootCommand;
    private final String subCommandName;

    public /* synthetic */ ApplicationCommand3(ApplicationCommand applicationCommand, String str, String str2, long j, String str3, String str4, Integer num, List list, Long l, Boolean bool, List list2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationCommand, str, (i & 4) != 0 ? null : str2, j, str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num, list, l, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : list2, str5);
    }

    public final String getParentGroupName() {
        return this.parentGroupName;
    }

    public final ApplicationCommand getRootCommand() {
        return this.rootCommand;
    }

    public final String getSubCommandName() {
        return this.subCommandName;
    }

    public ApplicationCommand3(ApplicationCommand applicationCommand, String str, String str2, long j, String str3, String str4, Integer num, List<ApplicationCommandOption> list, Long l, Boolean bool, List<ApplicationCommandPermission> list2, String str5) {
        Map map;
        Intrinsics3.checkNotNullParameter(applicationCommand, "rootCommand");
        Intrinsics3.checkNotNullParameter(str, "subCommandName");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "options");
        String str6 = str2 != null ? applicationCommand.getId() + ' ' + str2 + ' ' + str : applicationCommand.getId() + ' ' + str;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
            for (ApplicationCommandPermission applicationCommandPermission : list2) {
                arrayList.add(Tuples.to(Long.valueOf(applicationCommandPermission.getId()), Boolean.valueOf(applicationCommandPermission.getPermission())));
            }
            map = Maps6.toMap(arrayList);
        } else {
            map = null;
        }
        super(str6, j, str3, str4, num, list, false, l, str5, bool, map, null, 2112, null);
        this.rootCommand = applicationCommand;
        this.subCommandName = str;
        this.parentGroupName = str2;
    }
}
