package b.a.a.d;

import b.a.a.d.UserActionsDialogViewModel5;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import rx.functions.Func3;

/* compiled from: UserActionsDialogViewModel.kt */
/* renamed from: b.a.a.d.e, reason: use source file name */
/* loaded from: classes.dex */
public final class UserActionsDialogViewModel4<T1, T2, T3, R> implements Func3<User, Integer, GuildMember, UserActionsDialogViewModel5.c> {
    public static final UserActionsDialogViewModel4 a = new UserActionsDialogViewModel4();

    @Override // rx.functions.Func3
    public UserActionsDialogViewModel5.c call(User user, Integer num, GuildMember guildMember) {
        return new UserActionsDialogViewModel5.c(user, num, guildMember);
    }
}
