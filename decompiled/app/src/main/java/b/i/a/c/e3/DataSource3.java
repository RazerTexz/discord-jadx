package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: DataSource.java */
/* renamed from: b.i.a.c.e3.l, reason: use source file name */
/* loaded from: classes3.dex */
public interface DataSource3 extends DataReader {

    /* compiled from: DataSource.java */
    /* renamed from: b.i.a.c.e3.l$a */
    public interface a {
        DataSource3 a();
    }

    long a(DataSpec dataSpec) throws IOException;

    void close() throws IOException;

    void d(TransferListener transferListener);

    Map<String, List<String>> j();

    @Nullable
    Uri n();
}
