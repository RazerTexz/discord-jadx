package b.f.e;

import b.c.a.a0.AnimatableValueParser;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DataSources.java */
/* renamed from: b.f.e.e, reason: use source file name */
/* loaded from: classes.dex */
public final class DataSources<T> implements Supplier<DataSource<T>> {
    public final /* synthetic */ Throwable a;

    public DataSources(Throwable th) {
        this.a = th;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return AnimatableValueParser.N0(this.a);
    }
}
