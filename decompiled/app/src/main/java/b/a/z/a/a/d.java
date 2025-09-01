package b.a.z.a.a;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.widgets.channels.SimpleMembersAdapter;
import j0.k.Func1;
import java.util.Map;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class d implements Func1 {
    public final /* synthetic */ Map j;

    public /* synthetic */ d(Map map) {
        this.j = map;
    }

    @Override // j0.k.Func1
    public final Object call(Object obj) {
        User user = (User) obj;
        return new SimpleMembersAdapter.MemberItem(user, (GuildMember) outline.f(user, this.j));
    }
}
