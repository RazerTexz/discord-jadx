package b.f.e;

import com.facebook.datasource.DataSource;

/* compiled from: DataSubscriber.java */
/* renamed from: b.f.e.f, reason: use source file name */
/* loaded from: classes.dex */
public interface DataSubscriber<T> {
    void onCancellation(DataSource<T> dataSource);

    void onFailure(DataSource<T> dataSource);

    void onNewResult(DataSource<T> dataSource);

    void onProgressUpdate(DataSource<T> dataSource);
}
