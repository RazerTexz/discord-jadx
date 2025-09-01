package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: Data.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a@\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a(\u0010\u000b\u001a\u00020\n\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u0003*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "Lkotlin/Pair;", "", "", "pairs", "Landroidx/work/Data;", "workDataOf", "([Lkotlin/Pair;)Landroidx/work/Data;", ExifInterface.GPS_DIRECTION_TRUE, "key", "", "hasKeyWithValueOfType", "(Landroidx/work/Data;Ljava/lang/String;)Z", "work-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
/* renamed from: androidx.work.DataKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Data2 {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String str) {
        Intrinsics3.checkParameterIsNotNull(data, "$this$hasKeyWithValueOfType");
        Intrinsics3.checkParameterIsNotNull(str, "key");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(str, Object.class);
    }

    public static final Data workDataOf(Tuples2<String, ? extends Object>... tuples2Arr) throws Throwable {
        Intrinsics3.checkParameterIsNotNull(tuples2Arr, "pairs");
        Data.Builder builder = new Data.Builder();
        for (Tuples2<String, ? extends Object> tuples2 : tuples2Arr) {
            builder.put(tuples2.getFirst(), tuples2.getSecond());
        }
        Data dataBuild = builder.build();
        Intrinsics3.checkExpressionValueIsNotNull(dataBuild, "dataBuilder.build()");
        return dataBuild;
    }
}
