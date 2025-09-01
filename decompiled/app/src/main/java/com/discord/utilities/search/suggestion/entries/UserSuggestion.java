package com.discord.utilities.search.suggestion.entries;

import android.annotation.SuppressLint;
import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.AutocompleteUtils2;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UserSuggestion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 ;2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002;<B!\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b9\u0010:J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0017R\u001b\u0010!\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0017R\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\fR\u0019\u0010%\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0019R\u001c\u0010)\u001a\u00020(8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010-\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010\u0017R\u0019\u0010\u0010\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010/\u001a\u0004\b0\u0010\tR\u001d\u00103\u001a\u000601j\u0002`28\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\b8\u0010\u000f¨\u0006="}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/UserSuggestion;", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion;", "", "other", "", "compareTo", "(Lcom/discord/utilities/search/suggestion/entries/UserSuggestion;)I", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/utilities/search/suggestion/entries/UserSuggestion$TargetType;", "component2", "()Lcom/discord/utilities/search/suggestion/entries/UserSuggestion$TargetType;", "Lcom/discord/models/member/GuildMember;", "component3", "()Lcom/discord/models/member/GuildMember;", "user", "targetType", "guildMember", "copy", "(Lcom/discord/models/user/User;Lcom/discord/utilities/search/suggestion/entries/UserSuggestion$TargetType;Lcom/discord/models/member/GuildMember;)Lcom/discord/utilities/search/suggestion/entries/UserSuggestion;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "", "equals", "(Ljava/lang/Object;)Z", "userName", "Ljava/lang/String;", "getUserName", "nickname", "getNickname", "Lcom/discord/utilities/search/suggestion/entries/UserSuggestion$TargetType;", "getTargetType", "discriminator", "I", "getDiscriminator", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "category", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "getCategory", "()Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "usernameWithDiscriminator", "getUsernameWithDiscriminator", "Lcom/discord/models/user/User;", "getUser", "", "Lcom/discord/primitives/UserId;", "userId", "J", "getUserId", "()J", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/utilities/search/suggestion/entries/UserSuggestion$TargetType;Lcom/discord/models/member/GuildMember;)V", "Companion", "TargetType", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class UserSuggestion implements SearchSuggestion, Comparable<UserSuggestion> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final int discriminator;
    private final GuildMember guildMember;
    private final String nickname;
    private final TargetType targetType;
    private final User user;
    private final long userId;
    private final String userName;
    private final String usernameWithDiscriminator;

    /* compiled from: UserSuggestion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/UserSuggestion$Companion;", "", "", "userName", "", "discriminator", "getUsernameWithDiscriminator", "(Ljava/lang/String;I)Ljava/lang/String;", "username", "nickname", "", "currentInput", "", "canComplete", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/CharSequence;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$getUsernameWithDiscriminator(Companion companion, String str, int i) {
            return companion.getUsernameWithDiscriminator(str, i);
        }

        private final String getUsernameWithDiscriminator(String userName, int discriminator) {
            StringBuilder sbU = outline.U(userName);
            sbU.append(UserUtils.INSTANCE.padDiscriminator(discriminator));
            return sbU.toString();
        }

        @SuppressLint({"DefaultLocale"})
        public final boolean canComplete(String username, int discriminator, String nickname, CharSequence currentInput) {
            Intrinsics3.checkNotNullParameter(username, "username");
            Intrinsics3.checkNotNullParameter(currentInput, "currentInput");
            String usernameWithDiscriminator = getUsernameWithDiscriminator(username, discriminator);
            String string = currentInput.toString();
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = string.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (Strings4.contains((CharSequence) usernameWithDiscriminator, (CharSequence) lowerCase, true)) {
                return true;
            }
            return nickname != null ? Strings4.contains((CharSequence) nickname, (CharSequence) lowerCase, true) : false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UserSuggestion.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/UserSuggestion$TargetType;", "", "<init>", "(Ljava/lang/String;I)V", "FROM", AutocompleteUtils2.MENTIONS, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum TargetType {
        FROM,
        MENTIONS
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TargetType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[TargetType.FROM.ordinal()] = 1;
            iArr[TargetType.MENTIONS.ordinal()] = 2;
        }
    }

    public UserSuggestion(User user, TargetType targetType, GuildMember guildMember) {
        SearchSuggestion.Category category;
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(targetType, "targetType");
        this.user = user;
        this.targetType = targetType;
        this.guildMember = guildMember;
        String username = user.getUsername();
        this.userName = username;
        int discriminator = user.getDiscriminator();
        this.discriminator = discriminator;
        this.userId = user.getId();
        this.nickname = guildMember != null ? guildMember.getNick() : null;
        int iOrdinal = targetType.ordinal();
        if (iOrdinal == 0) {
            category = SearchSuggestion.Category.FROM_USER;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            category = SearchSuggestion.Category.MENTIONS_USER;
        }
        this.category = category;
        this.usernameWithDiscriminator = Companion.access$getUsernameWithDiscriminator(INSTANCE, username, discriminator);
    }

    public static /* synthetic */ UserSuggestion copy$default(UserSuggestion userSuggestion, User user, TargetType targetType, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userSuggestion.user;
        }
        if ((i & 2) != 0) {
            targetType = userSuggestion.targetType;
        }
        if ((i & 4) != 0) {
            guildMember = userSuggestion.guildMember;
        }
        return userSuggestion.copy(user, targetType, guildMember);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UserSuggestion userSuggestion) {
        return compareTo2(userSuggestion);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final TargetType getTargetType() {
        return this.targetType;
    }

    /* renamed from: component3, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final UserSuggestion copy(User user, TargetType targetType, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(targetType, "targetType");
        return new UserSuggestion(user, targetType, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserSuggestion)) {
            return false;
        }
        UserSuggestion userSuggestion = (UserSuggestion) other;
        return Intrinsics3.areEqual(this.user, userSuggestion.user) && Intrinsics3.areEqual(this.targetType, userSuggestion.targetType) && Intrinsics3.areEqual(this.guildMember, userSuggestion.guildMember);
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final int getDiscriminator() {
        return this.discriminator;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final TargetType getTargetType() {
        return this.targetType;
    }

    public final User getUser() {
        return this.user;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUsernameWithDiscriminator() {
        return this.usernameWithDiscriminator;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        TargetType targetType = this.targetType;
        int iHashCode2 = (iHashCode + (targetType != null ? targetType.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserSuggestion(user=");
        sbU.append(this.user);
        sbU.append(", targetType=");
        sbU.append(this.targetType);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UserSuggestion other) {
        Intrinsics3.checkNotNullParameter(other, "other");
        String str = this.nickname;
        if (str == null) {
            str = this.usernameWithDiscriminator;
        }
        String str2 = other.nickname;
        if (str2 == null) {
            str2 = other.usernameWithDiscriminator;
        }
        int iCompareTo = str.compareTo(str2);
        return iCompareTo != 0 ? iCompareTo : this.usernameWithDiscriminator.compareTo(other.usernameWithDiscriminator);
    }
}
