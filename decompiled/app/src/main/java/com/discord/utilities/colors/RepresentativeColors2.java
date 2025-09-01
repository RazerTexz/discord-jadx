package com.discord.utilities.colors;

import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: RepresentativeColors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"#\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n\"\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/discord/models/user/User;", "", "getColorId", "(Lcom/discord/models/user/User;)Ljava/lang/String;", "Lcom/discord/utilities/colors/RepresentativeColors;", "", "Lcom/discord/primitives/GuildId;", "GuildRepresentativeColors", "Lcom/discord/utilities/colors/RepresentativeColors;", "getGuildRepresentativeColors", "()Lcom/discord/utilities/colors/RepresentativeColors;", "GuildMemberRepresentativeColors", "getGuildMemberRepresentativeColors", "UserRepresentativeColors", "getUserRepresentativeColors", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.colors.RepresentativeColorsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class RepresentativeColors2 {
    private static final RepresentativeColors<String> UserRepresentativeColors = new RepresentativeColors<>();
    private static final RepresentativeColors<String> GuildMemberRepresentativeColors = new RepresentativeColors<>();
    private static final RepresentativeColors<Long> GuildRepresentativeColors = new RepresentativeColors<>();

    public static final String getColorId(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$getColorId");
        String avatar = user.getAvatar();
        return avatar != null ? avatar : String.valueOf(user.getDiscriminator());
    }

    public static final RepresentativeColors<String> getGuildMemberRepresentativeColors() {
        return GuildMemberRepresentativeColors;
    }

    public static final RepresentativeColors<Long> getGuildRepresentativeColors() {
        return GuildRepresentativeColors;
    }

    public static final RepresentativeColors<String> getUserRepresentativeColors() {
        return UserRepresentativeColors;
    }
}
