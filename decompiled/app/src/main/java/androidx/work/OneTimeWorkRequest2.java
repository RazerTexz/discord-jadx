package androidx.work;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.OneTimeWorkRequest;
import d0.e0.KClass;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: OneTimeWorkRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a&\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0086\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/work/ListenableWorker;", ExifInterface.LONGITUDE_WEST, "Landroidx/work/OneTimeWorkRequest$Builder;", "OneTimeWorkRequestBuilder", "()Landroidx/work/OneTimeWorkRequest$Builder;", "Ld0/e0/c;", "Landroidx/work/InputMerger;", "inputMerger", "setInputMerger", "(Landroidx/work/OneTimeWorkRequest$Builder;Ld0/e0/c;)Landroidx/work/OneTimeWorkRequest$Builder;", "work-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
/* renamed from: androidx.work.OneTimeWorkRequestKt, reason: use source file name */
/* loaded from: classes.dex */
public final class OneTimeWorkRequest2 {
    public static final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new OneTimeWorkRequest.Builder(ListenableWorker.class);
    }

    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull KClass<? extends InputMerger> kClass) {
        Intrinsics3.checkParameterIsNotNull(builder, "$this$setInputMerger");
        Intrinsics3.checkParameterIsNotNull(kClass, "inputMerger");
        OneTimeWorkRequest.Builder inputMerger = builder.setInputMerger(JvmClassMapping.getJavaClass(kClass));
        Intrinsics3.checkExpressionValueIsNotNull(inputMerger, "setInputMerger(inputMerger.java)");
        return inputMerger;
    }
}
