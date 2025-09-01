package b.a.z.a.a;

import b.d.b.a.outline;
import com.discord.models.user.User;
import j0.k.Func1;
import java.util.Map;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class m implements Func1 {
    public final /* synthetic */ Map j;

    public /* synthetic */ m(Map map) {
        this.j = map;
    }

    @Override // j0.k.Func1
    public final Object call(Object obj) {
        return Boolean.valueOf(outline.f((User) obj, this.j) != null);
    }
}
