package b.a.z.a.a;

import com.discord.stores.StoreStream;
import j0.k.Func1;
import java.util.List;
import java.util.Map;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements Func1 {
    public final /* synthetic */ List j;
    public final /* synthetic */ String k;

    public /* synthetic */ i(List list, String str) {
        this.j = list;
        this.k = str;
    }

    @Override // j0.k.Func1
    public final Object call(Object obj) {
        Map map = (Map) obj;
        return StoreStream.getUsers().observeUsers(map.keySet()).Y(new h(this.j, map, this.k));
    }
}
