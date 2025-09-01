package b.a.k.g;

import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* compiled from: FormattingParserProvider.kt */
/* renamed from: b.a.k.g.d, reason: use source file name */
/* loaded from: classes.dex */
public final class FormattingParserProvider2 extends FormattingParserProvider {
    public static final Lazy a = LazyJVM.lazy(a.j);

    /* renamed from: b, reason: collision with root package name */
    public static final FormattingParserProvider2 f247b = null;
    public final ThreadLocal<FormattingParser> c = new b();

    /* compiled from: FormattingParserProvider.kt */
    /* renamed from: b.a.k.g.d$a */
    public static final class a extends Lambda implements Function0<FormattingParserProvider2> {
        public static final a j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FormattingParserProvider2 invoke() {
            return new FormattingParserProvider2();
        }
    }

    /* compiled from: FormattingParserProvider.kt */
    /* renamed from: b.a.k.g.d$b */
    public static final class b extends ThreadLocal<FormattingParser> {
        @Override // java.lang.ThreadLocal
        public FormattingParser initialValue() {
            return new FormattingParser();
        }
    }

    @Override // b.a.k.g.FormattingParserProvider
    public FormattingParser a() {
        FormattingParser formattingParser = this.c.get();
        Intrinsics3.checkNotNull(formattingParser);
        return formattingParser;
    }
}
