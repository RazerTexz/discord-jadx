package b.a.z.a.a;

import com.discord.models.user.User;
import j0.k.Func1;
import java.util.Locale;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class k implements Func1 {
    public final /* synthetic */ String j;

    public /* synthetic */ k(String str) {
        this.j = str;
    }

    @Override // j0.k.Func1
    public final Object call(Object obj) {
        return Boolean.valueOf(((User) obj).getUsername().toLowerCase(Locale.ROOT).contains(this.j));
    }
}
