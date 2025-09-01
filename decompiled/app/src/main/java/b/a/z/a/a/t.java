package b.a.z.a.a;

import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import j0.k.Func1;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class t implements Func1 {
    public final /* synthetic */ Channel j;

    public /* synthetic */ t(Channel channel) {
        this.j = channel;
    }

    @Override // j0.k.Func1
    public final Object call(Object obj) {
        Channel channel = this.j;
        GuildRole guildRole = (GuildRole) obj;
        if (channel.v() == null) {
            return Boolean.TRUE;
        }
        for (int i = 0; i < channel.v().size(); i++) {
            if (channel.v().get(i).e() == guildRole.getId()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
