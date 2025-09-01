package com.discord.models.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationCommand.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B½\u0001\b\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u000f\u0012\n\u0010\t\u001a\u00060\u0007j\u0002`\b\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020100\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\u001e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e\u0012$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\u0004\b6\u00107R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR5\u0010\u0010\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0019\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R!\u0010\u001f\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R'\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001f\u00102\u001a\b\u0012\u0004\u0012\u000201008\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u0082\u0001\u000389:¨\u0006;"}, d2 = {"Lcom/discord/models/commands/ApplicationCommand;", "", "", "builtIn", "Z", "getBuiltIn", "()Z", "", "Lcom/discord/primitives/ApplicationId;", "applicationId", "J", "getApplicationId", "()J", "Lkotlin/Function1;", "", "", "execute", "Lkotlin/jvm/functions/Function1;", "getExecute", "()Lkotlin/jvm/functions/Function1;", "version", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_NAME, "getName", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "getDescription", ModelAuditLogEntry.CHANGE_KEY_ID, "getId", "Lcom/discord/primitives/GuildId;", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "defaultPermissions", "Ljava/lang/Boolean;", "getDefaultPermissions", "()Ljava/lang/Boolean;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Ljava/util/Map;", "getPermissions", "()Ljava/util/Map;", "", "descriptionRes", "Ljava/lang/Integer;", "getDescriptionRes", "()Ljava/lang/Integer;", "", "Lcom/discord/models/commands/ApplicationCommandOption;", "options", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/models/commands/RemoteApplicationCommand;", "Lcom/discord/models/commands/BuiltInCommand;", "Lcom/discord/models/commands/ApplicationSubCommand;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class ApplicationCommand {
    private final long applicationId;
    private final boolean builtIn;
    private final Boolean defaultPermissions;
    private final String description;
    private final Integer descriptionRes;
    private final Function1<Map<String, ? extends Object>, String> execute;
    private final Long guildId;
    private final String id;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final Map<Long, Boolean> permissions;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    private ApplicationCommand(String str, long j, String str2, String str3, Integer num, List<ApplicationCommandOption> list, boolean z2, Long l, String str4, Boolean bool, Map<Long, Boolean> map, Function1<? super Map<String, ? extends Object>, String> function1) {
        this.id = str;
        this.applicationId = j;
        this.name = str2;
        this.description = str3;
        this.descriptionRes = num;
        this.options = list;
        this.builtIn = z2;
        this.guildId = l;
        this.version = str4;
        this.defaultPermissions = bool;
        this.permissions = map;
        this.execute = function1;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final Boolean getDefaultPermissions() {
        return this.defaultPermissions;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getDescriptionRes() {
        return this.descriptionRes;
    }

    public final Function1<Map<String, ? extends Object>, String> getExecute() {
        return this.execute;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandOption> getOptions() {
        return this.options;
    }

    public final Map<Long, Boolean> getPermissions() {
        return this.permissions;
    }

    public final String getVersion() {
        return this.version;
    }

    public /* synthetic */ ApplicationCommand(String str, long j, String str2, String str3, Integer num, List list, boolean z2, Long l, String str4, Boolean bool, Map map, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num, list, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? null : l, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : map, (i & 2048) != 0 ? null : function1);
    }
}
