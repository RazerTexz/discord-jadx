package androidx.view;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class ViewModel {

    @Nullable
    private final Map<String, Object> mBagOfTags = new HashMap();
    private volatile boolean mCleared = false;

    private static void closeWithRuntimeException(Object obj) throws IOException {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @MainThread
    public final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.mBagOfTags.values().iterator();
                while (it.hasNext()) {
                    closeWithRuntimeException(it.next());
                }
            }
        }
        onCleared();
    }

    public <T> T getTag(String str) {
        T t;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.mBagOfTags.get(str);
        }
        return t;
    }

    public void onCleared() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T setTagIfAbsent(String str, T t) throws IOException {
        Object obj;
        synchronized (this.mBagOfTags) {
            obj = this.mBagOfTags.get(str);
            if (obj == 0) {
                this.mBagOfTags.put(str, t);
            }
        }
        if (obj != 0) {
            t = obj;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t);
        }
        return t;
    }
}
