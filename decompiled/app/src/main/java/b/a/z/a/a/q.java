package b.a.z.a.a;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class q implements Func1 {
    public final /* synthetic */ long j;

    public /* synthetic */ q(long j) {
        this.j = j;
    }

    @Override // j0.k.Func1
    public final Object call(Object obj) {
        Channel channel = (Channel) obj;
        return channel == null ? new ScalarSynchronousObservable(null) : Observable.h(StoreStream.getGuilds().observeGuild(channel.getGuildId()), StoreStream.getUsers().observeMe(), StoreStream.getPermissions().observePermissionsForChannel(this.j), StoreStream.getGuilds().observeSortedRoles(channel.getGuildId()).Y(new s(channel)), new r(channel));
    }
}
