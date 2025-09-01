package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016¢\u0006\u0004\b7\u00108J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JH\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b \u0010\u0007J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b+\u0010\u000eR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b-\u0010\u0015R\u0019\u0010\u001d\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b/\u0010\u0018R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b1\u0010\u0011R\u001f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\nR!\u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00103\u001a\u0004\b6\u0010\n¨\u00069"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/UserAutocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "leadingIdentifier", "()Lcom/discord/widgets/chat/input/autocomplete/LeadingIdentifier;", "", "getInputReplacement", "()Ljava/lang/String;", "", "getInputTextMatchers", "()Ljava/util/List;", "getAutocompleteTextMatchers", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component2", "()Lcom/discord/models/member/GuildMember;", "component3", "Lcom/discord/models/presence/Presence;", "component4", "()Lcom/discord/models/presence/Presence;", "", "component5", "()Z", "user", "guildMember", "nickname", "presence", "canUserReadChannel", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Ljava/lang/String;Lcom/discord/models/presence/Presence;Z)Lcom/discord/widgets/chat/input/autocomplete/UserAutocompletable;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNickname", "Lcom/discord/models/user/User;", "getUser", "Lcom/discord/models/presence/Presence;", "getPresence", "Z", "getCanUserReadChannel", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "textMatchers", "Ljava/util/List;", "getTextMatchers", "autoTextMatchers", "getAutoTextMatchers", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Ljava/lang/String;Lcom/discord/models/presence/Presence;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class UserAutocompletable extends Autocompletable {
    private final List<String> autoTextMatchers;
    private final boolean canUserReadChannel;
    private final GuildMember guildMember;
    private final String nickname;
    private final Presence presence;
    private final List<String> textMatchers;
    private final User user;

    public /* synthetic */ UserAutocompletable(User user, GuildMember guildMember, String str, Presence presence, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i & 2) != 0 ? null : guildMember, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : presence, (i & 16) != 0 ? true : z2);
    }

    public static /* synthetic */ UserAutocompletable copy$default(UserAutocompletable userAutocompletable, User user, GuildMember guildMember, String str, Presence presence, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userAutocompletable.user;
        }
        if ((i & 2) != 0) {
            guildMember = userAutocompletable.guildMember;
        }
        GuildMember guildMember2 = guildMember;
        if ((i & 4) != 0) {
            str = userAutocompletable.nickname;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            presence = userAutocompletable.presence;
        }
        Presence presence2 = presence;
        if ((i & 16) != 0) {
            z2 = userAutocompletable.canUserReadChannel;
        }
        return userAutocompletable.copy(user, guildMember2, str2, presence2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component4, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanUserReadChannel() {
        return this.canUserReadChannel;
    }

    public final UserAutocompletable copy(User user, GuildMember guildMember, String nickname, Presence presence, boolean canUserReadChannel) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new UserAutocompletable(user, guildMember, nickname, presence, canUserReadChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAutocompletable)) {
            return false;
        }
        UserAutocompletable userAutocompletable = (UserAutocompletable) other;
        return Intrinsics3.areEqual(this.user, userAutocompletable.user) && Intrinsics3.areEqual(this.guildMember, userAutocompletable.guildMember) && Intrinsics3.areEqual(this.nickname, userAutocompletable.nickname) && Intrinsics3.areEqual(this.presence, userAutocompletable.presence) && this.canUserReadChannel == userAutocompletable.canUserReadChannel;
    }

    public final List<String> getAutoTextMatchers() {
        return this.autoTextMatchers;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getAutocompleteTextMatchers() {
        return this.autoTextMatchers;
    }

    public final boolean getCanUserReadChannel() {
        return this.canUserReadChannel;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        StringBuilder sbQ = outline.Q('<');
        sbQ.append(leadingIdentifier().getIdentifier());
        sbQ.append(this.user.getId());
        sbQ.append('>');
        return sbQ.toString();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        String str = this.nickname;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Presence presence = this.presence;
        int iHashCode4 = (iHashCode3 + (presence != null ? presence.hashCode() : 0)) * 31;
        boolean z2 = this.canUserReadChannel;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode4 + i;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.MENTION;
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserAutocompletable(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", nickname=");
        sbU.append(this.nickname);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", canUserReadChannel=");
        return outline.O(sbU, this.canUserReadChannel, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAutocompletable(User user, GuildMember guildMember, String str, Presence presence, boolean z2) {
        super(null);
        Intrinsics3.checkNotNullParameter(user, "user");
        List<String> listListOf = null;
        this.user = user;
        this.guildMember = guildMember;
        this.nickname = str;
        this.presence = presence;
        this.canUserReadChannel = z2;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + user.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
        if (str != null) {
            listListOf = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + str);
        }
        this.autoTextMatchers = listListOf;
    }
}
