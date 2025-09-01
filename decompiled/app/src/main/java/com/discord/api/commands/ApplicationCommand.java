package com.discord.api.commands;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ApplicationCommand.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u0004R\u0019\u0010\"\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R!\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001aR\u001b\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u0004¨\u0006)"}, d2 = {"Lcom/discord/api/commands/ApplicationCommand;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "defaultPermissions", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "e", "()J", "", "Lcom/discord/api/commands/ApplicationCommandPermission;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Ljava/util/List;", "h", "()Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "Ljava/lang/String;", "c", "version", "i", ModelAuditLogEntry.CHANGE_KEY_NAME, "f", "applicationId", "a", "Lcom/discord/api/commands/ApplicationCommandOption;", "options", "g", "guildId", "d", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommand {
    private final long applicationId;
    private final Boolean defaultPermissions;
    private final String description;
    private final String guildId;
    private final long id;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final List<ApplicationCommandPermission> permissions;
    private final String version;

    /* renamed from: a, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getDefaultPermissions() {
        return this.defaultPermissions;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: d, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: e, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommand)) {
            return false;
        }
        ApplicationCommand applicationCommand = (ApplicationCommand) other;
        return this.id == applicationCommand.id && this.applicationId == applicationCommand.applicationId && Intrinsics3.areEqual(this.name, applicationCommand.name) && Intrinsics3.areEqual(this.description, applicationCommand.description) && Intrinsics3.areEqual(this.options, applicationCommand.options) && Intrinsics3.areEqual(this.version, applicationCommand.version) && Intrinsics3.areEqual(this.guildId, applicationCommand.guildId) && Intrinsics3.areEqual(this.defaultPermissions, applicationCommand.defaultPermissions) && Intrinsics3.areEqual(this.permissions, applicationCommand.permissions);
    }

    /* renamed from: f, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandOption> g() {
        return this.options;
    }

    public final List<ApplicationCommandPermission> h() {
        return this.permissions;
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.applicationId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ApplicationCommandOption> list = this.options;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.version;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.guildId;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.defaultPermissions;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        List<ApplicationCommandPermission> list2 = this.permissions;
        return iHashCode6 + (list2 != null ? list2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommand(id=");
        sbU.append(this.id);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", version=");
        sbU.append(this.version);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", defaultPermissions=");
        sbU.append(this.defaultPermissions);
        sbU.append(", permissions=");
        return outline.L(sbU, this.permissions, ")");
    }
}
