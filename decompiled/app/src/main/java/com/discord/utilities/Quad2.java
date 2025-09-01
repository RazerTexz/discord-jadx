package com.discord.utilities;

import androidx.exifinterface.media.ExifInterface;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Quad.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a5\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/Quad;", "", "toList", "(Lcom/discord/utilities/Quad;)Ljava/util/List;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.QuadKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class Quad2 {
    public static final <T> List<T> toList(Quad<? extends T, ? extends T, ? extends T, ? extends T> quad) {
        Intrinsics3.checkNotNullParameter(quad, "$this$toList");
        return Collections2.listOf(quad.getFirst(), quad.getSecond(), quad.getThird(), quad.getFourth());
    }
}
