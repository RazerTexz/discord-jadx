package b.i.c.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: ObjectEncoderContext.java */
/* renamed from: b.i.c.p.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext a(@NonNull String str, boolean z2) throws IOException;

    @NonNull
    ObjectEncoderContext b(@NonNull String str, long j) throws IOException;

    @NonNull
    ObjectEncoderContext c(@NonNull String str, int i) throws IOException;

    @NonNull
    ObjectEncoderContext f(@NonNull String str, @Nullable Object obj) throws IOException;
}
