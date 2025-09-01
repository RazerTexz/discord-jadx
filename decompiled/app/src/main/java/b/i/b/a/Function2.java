package b.i.b.a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Function.java */
/* renamed from: b.i.b.a.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface Function2<F, T> {
    @CanIgnoreReturnValue
    @NullableDecl
    T apply(@NullableDecl F f);
}
