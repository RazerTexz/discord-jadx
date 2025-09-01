package b.i.d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* renamed from: b.i.d.n, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class LongSerializationPolicy {
    public static final LongSerializationPolicy j;
    public static final LongSerializationPolicy k;
    public static final /* synthetic */ LongSerializationPolicy[] l;

    /* compiled from: LongSerializationPolicy.java */
    /* renamed from: b.i.d.n$a */
    public enum a extends LongSerializationPolicy {
        public a(String str, int i) {
            super(str, i, null);
        }
    }

    /* compiled from: LongSerializationPolicy.java */
    /* renamed from: b.i.d.n$b */
    public enum b extends LongSerializationPolicy {
        public b(String str, int i) {
            super(str, i, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        j = aVar;
        b bVar = new b("STRING", 1);
        k = bVar;
        l = new LongSerializationPolicy[]{aVar, bVar};
    }

    public LongSerializationPolicy(String str, int i, a aVar) {
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) l.clone();
    }
}
