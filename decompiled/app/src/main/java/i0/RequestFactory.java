package i0;

import f0.HttpUrl;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.MediaType;

/* compiled from: RequestFactory.java */
/* renamed from: i0.w, reason: use source file name */
/* loaded from: classes3.dex */
public final class RequestFactory {
    public final Method a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpUrl f3761b;
    public final String c;
    public final String d;
    public final Headers e;
    public final MediaType f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final ParameterHandler3<?>[] j;
    public final boolean k;

    /* compiled from: RequestFactory.java */
    /* renamed from: i0.w$a */
    public static final class a {
        public static final Pattern a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: b, reason: collision with root package name */
        public static final Pattern f3762b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        public final Retrofit2 c;
        public final Method d;
        public final Annotation[] e;
        public final Annotation[][] f;
        public final Type[] g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public String p;
        public boolean q;
        public boolean r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f3763s;
        public String t;
        public Headers u;
        public MediaType v;
        public Set<String> w;

        /* renamed from: x, reason: collision with root package name */
        public ParameterHandler3<?>[] f3764x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f3765y;

        public a(Retrofit2 retrofit22, Method method) {
            this.c = retrofit22;
            this.d = method;
            this.e = method.getAnnotations();
            this.g = method.getGenericParameterTypes();
            this.f = method.getParameterAnnotations();
        }

        public static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        public final void b(String str, String str2, boolean z2) {
            String str3 = this.p;
            if (str3 != null) {
                throw Utils8.j(this.d, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.p = str;
            this.q = z2;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (a.matcher(strSubstring).find()) {
                    throw Utils8.j(this.d, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.t = str2;
            Matcher matcher = a.matcher(str2);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            this.w = linkedHashSet;
        }

        public final void c(int i, Type type) {
            if (Utils8.h(type)) {
                throw Utils8.l(this.d, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    public RequestFactory(a aVar) {
        this.a = aVar.d;
        this.f3761b = aVar.c.c;
        this.c = aVar.p;
        this.d = aVar.t;
        this.e = aVar.u;
        this.f = aVar.v;
        this.g = aVar.q;
        this.h = aVar.r;
        this.i = aVar.f3763s;
        this.j = aVar.f3764x;
        this.k = aVar.f3765y;
    }
}
