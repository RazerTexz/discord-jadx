package b.a.z.a.a;

import com.discord.api.channel.Channel;
import j0.k.Func1;
import j0.l.a.OnSubscribeFromIterable;
import java.util.List;
import rx.Observable;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class s implements Func1 {
    public final /* synthetic */ Channel j;

    public /* synthetic */ s(Channel channel) {
        this.j = channel;
    }

    @Override // j0.k.Func1
    public final Object call(Object obj) {
        return Observable.h0(new OnSubscribeFromIterable((List) obj)).y(new t(this.j)).G(v.j).f0();
    }
}
