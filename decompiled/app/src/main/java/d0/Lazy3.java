package d0;

import java.io.Serializable;
import kotlin.Lazy;

/* compiled from: Lazy.kt */
/* renamed from: d0.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Lazy3<T> implements Lazy<T>, Serializable {
    private final T value;

    public Lazy3(T t) {
        this.value = t;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        return this.value;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
