package com.discord.api.interaction;

import b.d.b.a.outline;
import com.discord.api.botuikit.Component;
import com.discord.api.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* compiled from: InteractionModalCreate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010 \u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/discord/api/interaction/InteractionModalCreate;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/botuikit/Component;", "components", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/discord/api/commands/Application;", "application", "Lcom/discord/api/commands/Application;", "a", "()Lcom/discord/api/commands/Application;", "customId", "Ljava/lang/String;", "c", "nonce", "d", "title", "e", "", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "()J", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class InteractionModalCreate implements Serializable {
    private final Application application;
    private final List<Component> components;
    private final String customId;
    private final long id;
    private final String nonce;
    private final String title;

    /* renamed from: a, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final List<Component> b() {
        return this.components;
    }

    /* renamed from: c, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* renamed from: d, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionModalCreate)) {
            return false;
        }
        InteractionModalCreate interactionModalCreate = (InteractionModalCreate) other;
        return this.id == interactionModalCreate.id && Intrinsics3.areEqual(this.customId, interactionModalCreate.customId) && Intrinsics3.areEqual(this.application, interactionModalCreate.application) && Intrinsics3.areEqual(this.title, interactionModalCreate.title) && Intrinsics3.areEqual(this.components, interactionModalCreate.components) && Intrinsics3.areEqual(this.nonce, interactionModalCreate.nonce);
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.customId;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode2 = (iHashCode + (application != null ? application.hashCode() : 0)) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Component> list = this.components;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.nonce;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InteractionModalCreate(id=");
        sbU.append(this.id);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", title=");
        sbU.append(this.title);
        sbU.append(", components=");
        sbU.append(this.components);
        sbU.append(", nonce=");
        return outline.J(sbU, this.nonce, ")");
    }
}
