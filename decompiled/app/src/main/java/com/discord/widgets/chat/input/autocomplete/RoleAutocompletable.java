package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\rR\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\n¨\u0006&"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/RoleAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "leadingIdentifier", "()Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "Lcom/discord/api/role/GuildRole;", "component1", "()Lcom/discord/api/role/GuildRole;", "", "component2", "()Z", "role", "canMention", "copy", "(Lcom/discord/api/role/GuildRole;Z)Lcom/discord/widgets/chat/input/autocomplete/RoleAutocompletable;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanMention", "Lcom/discord/api/role/GuildRole;", "getRole", "textMatchers", "Ljava/util/List;", "getTextMatchers", "<init>", "(Lcom/discord/api/role/GuildRole;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class RoleAutocompletable extends Autocompletable {
    private final boolean canMention;
    private final GuildRole role;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleAutocompletable(GuildRole guildRole, boolean z2) {
        super(null);
        Intrinsics3.checkNotNullParameter(guildRole, "role");
        this.role = guildRole;
        this.canMention = z2;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + guildRole.getName());
    }

    public static /* synthetic */ RoleAutocompletable copy$default(RoleAutocompletable roleAutocompletable, GuildRole guildRole, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRole = roleAutocompletable.role;
        }
        if ((i & 2) != 0) {
            z2 = roleAutocompletable.canMention;
        }
        return roleAutocompletable.copy(guildRole, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanMention() {
        return this.canMention;
    }

    public final RoleAutocompletable copy(GuildRole role, boolean canMention) {
        Intrinsics3.checkNotNullParameter(role, "role");
        return new RoleAutocompletable(role, canMention);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleAutocompletable)) {
            return false;
        }
        RoleAutocompletable roleAutocompletable = (RoleAutocompletable) other;
        return Intrinsics3.areEqual(this.role, roleAutocompletable.role) && this.canMention == roleAutocompletable.canMention;
    }

    public final boolean getCanMention() {
        return this.canMention;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        StringBuilder sbQ = outline.Q('<');
        sbQ.append(leadingIdentifier().getIdentifier());
        sbQ.append('&');
        sbQ.append(this.role.getId());
        sbQ.append('>');
        return sbQ.toString();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        GuildRole guildRole = this.role;
        int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
        boolean z2 = this.canMention;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.MENTION;
    }

    public String toString() {
        StringBuilder sbU = outline.U("RoleAutocompletable(role=");
        sbU.append(this.role);
        sbU.append(", canMention=");
        return outline.O(sbU, this.canMention, ")");
    }
}
