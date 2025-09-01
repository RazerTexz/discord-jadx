package b.a.w;

import com.google.gson.reflect.TypeToken;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: TypeTokens.kt */
/* renamed from: b.a.w.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class TypeTokens {
    public static final Type a;

    /* compiled from: TypeTokens.kt */
    /* renamed from: b.a.w.a$a */
    public static final class a extends TypeToken<List<? extends String>> {
    }

    static {
        Type type = new a().getType();
        Intrinsics3.checkNotNullExpressionValue(type, "object : TypeToken<List<String>>() {}.type");
        a = type;
    }
}
