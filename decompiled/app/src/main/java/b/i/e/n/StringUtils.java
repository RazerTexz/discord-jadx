package b.i.e.n;

import java.nio.charset.Charset;

/* compiled from: StringUtils.java */
/* renamed from: b.i.e.n.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class StringUtils {
    public static final String a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f1839b;

    static {
        String strName = Charset.defaultCharset().name();
        a = strName;
        f1839b = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }
}
