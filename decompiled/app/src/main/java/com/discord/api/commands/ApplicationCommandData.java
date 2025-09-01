package com.discord.api.commands;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ApplicationCommandData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004R!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR!\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a¨\u0006 "}, d2 = {"Lcom/discord/api/commands/ApplicationCommandData;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "a", ModelAuditLogEntry.CHANGE_KEY_ID, "getId", "guildId", "getGuildId", "version", "getVersion", "", "Lcom/discord/api/commands/ApplicationCommandAttachment;", "attachments", "Ljava/util/List;", "getAttachments", "()Ljava/util/List;", "Lcom/discord/api/commands/ApplicationCommandValue;", "options", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandData {
    private final List<ApplicationCommandData2> attachments;
    private final String guildId;
    private final String id;
    private final String name;
    private final List<ApplicationCommandData3> options;
    private final String version;

    public ApplicationCommandData(String str, String str2, String str3, String str4, List<ApplicationCommandData3> list, List<ApplicationCommandData2> list2) {
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.version = str;
        this.guildId = str2;
        this.id = str3;
        this.name = str4;
        this.options = list;
        this.attachments = list2;
    }

    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandData3> b() {
        return this.options;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandData)) {
            return false;
        }
        ApplicationCommandData applicationCommandData = (ApplicationCommandData) other;
        return Intrinsics3.areEqual(this.version, applicationCommandData.version) && Intrinsics3.areEqual(this.guildId, applicationCommandData.guildId) && Intrinsics3.areEqual(this.id, applicationCommandData.id) && Intrinsics3.areEqual(this.name, applicationCommandData.name) && Intrinsics3.areEqual(this.options, applicationCommandData.options) && Intrinsics3.areEqual(this.attachments, applicationCommandData.attachments);
    }

    public int hashCode() {
        String str = this.version;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.guildId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.id;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<ApplicationCommandData3> list = this.options;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<ApplicationCommandData2> list2 = this.attachments;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandData(version=");
        sbU.append(this.version);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", attachments=");
        return outline.L(sbU, this.attachments, ")");
    }
}
