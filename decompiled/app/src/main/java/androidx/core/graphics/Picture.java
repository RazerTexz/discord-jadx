package androidx.core.graphics;

import android.graphics.Canvas;
import d0.z.d.InlineMarker;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Picture.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a;\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"Landroid/graphics/Picture;", "", "width", "height", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "block", "record", "(Landroid/graphics/Picture;IILkotlin/jvm/functions/Function1;)Landroid/graphics/Picture;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.PictureKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Picture {
    public static final android.graphics.Picture record(android.graphics.Picture picture, int i, int i2, Function1<? super Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(picture, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        Intrinsics3.checkNotNullExpressionValue(canvasBeginRecording, "beginRecording(width, height)");
        try {
            function1.invoke(canvasBeginRecording);
            return picture;
        } finally {
            InlineMarker.finallyStart(1);
            picture.endRecording();
            InlineMarker.finallyEnd(1);
        }
    }
}
