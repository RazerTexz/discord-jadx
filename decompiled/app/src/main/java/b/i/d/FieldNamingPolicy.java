package b.i.d;

import b.d.b.a.outline;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* renamed from: b.i.d.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class FieldNamingPolicy implements FieldNamingStrategy {
    public static final FieldNamingPolicy j;
    public static final FieldNamingPolicy k;
    public static final FieldNamingPolicy l;
    public static final FieldNamingPolicy m;
    public static final FieldNamingPolicy n;
    public static final FieldNamingPolicy o;
    public static final /* synthetic */ FieldNamingPolicy[] p;

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$a */
    public enum a extends FieldNamingPolicy {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.FieldNamingStrategy
        public String f(Field field) {
            return field.getName();
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$b */
    public enum b extends FieldNamingPolicy {
        public b(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.FieldNamingStrategy
        public String f(Field field) {
            return FieldNamingPolicy.h(field.getName());
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$c */
    public enum c extends FieldNamingPolicy {
        public c(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.FieldNamingStrategy
        public String f(Field field) {
            return FieldNamingPolicy.h(FieldNamingPolicy.g(field.getName(), " "));
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$d */
    public enum d extends FieldNamingPolicy {
        public d(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.FieldNamingStrategy
        public String f(Field field) {
            return FieldNamingPolicy.g(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$e */
    public enum e extends FieldNamingPolicy {
        public e(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.FieldNamingStrategy
        public String f(Field field) {
            return FieldNamingPolicy.g(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    }

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: b.i.d.c$f */
    public enum f extends FieldNamingPolicy {
        public f(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.FieldNamingStrategy
        public String f(Field field) {
            return FieldNamingPolicy.g(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        j = aVar;
        b bVar = new b("UPPER_CAMEL_CASE", 1);
        k = bVar;
        c cVar = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        l = cVar;
        d dVar = new d("LOWER_CASE_WITH_UNDERSCORES", 3);
        m = dVar;
        e eVar = new e("LOWER_CASE_WITH_DASHES", 4);
        n = eVar;
        f fVar = new f("LOWER_CASE_WITH_DOTS", 5);
        o = fVar;
        p = new FieldNamingPolicy[]{aVar, bVar, cVar, dVar, eVar, fVar};
    }

    public FieldNamingPolicy(String str, int i, a aVar) {
    }

    public static String g(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String h(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char cCharAt = str.charAt(i);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        if (i == 0) {
            StringBuilder sbQ = outline.Q(upperCase);
            sbQ.append(str.substring(1));
            return sbQ.toString();
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) p.clone();
    }
}
