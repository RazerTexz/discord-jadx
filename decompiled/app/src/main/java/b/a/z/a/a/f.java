package b.a.z.a.a;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import java.util.Map;
import rx.functions.Func2;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements Func2 {
    public final /* synthetic */ Map j;

    public /* synthetic */ f(Map map) {
        this.j = map;
    }

    @Override // rx.functions.Func2
    public final Object call(Object obj, Object obj2) {
        Map map = this.j;
        User user = (User) obj;
        User user2 = (User) obj2;
        return Integer.valueOf(GuildMember.compareUserNames(user, user2, (GuildMember) outline.f(user, map), (GuildMember) outline.f(user2, map)));
    }
}
