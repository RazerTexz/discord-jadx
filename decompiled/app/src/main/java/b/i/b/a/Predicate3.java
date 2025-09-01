package b.i.b.a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Predicate.java */
/* renamed from: b.i.b.a.h, reason: use source file name */
/* loaded from: classes3.dex */
public interface Predicate3<T> {
    @CanIgnoreReturnValue
    boolean apply(@NullableDecl T t);
}
