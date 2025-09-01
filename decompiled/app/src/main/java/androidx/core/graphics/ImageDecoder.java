package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: ImageDecoder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0007\u001a\u00020\u0006*\u00020\u00002 \b\u0004\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\n\u001a\u00020\t*\u00020\u00002 \b\u0004\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"Landroid/graphics/ImageDecoder$Source;", "Lkotlin/Function3;", "Landroid/graphics/ImageDecoder;", "Landroid/graphics/ImageDecoder$ImageInfo;", "", "action", "Landroid/graphics/Bitmap;", "decodeBitmap", "(Landroid/graphics/ImageDecoder$Source;Lkotlin/jvm/functions/Function3;)Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "decodeDrawable", "(Landroid/graphics/ImageDecoder$Source;Lkotlin/jvm/functions/Function3;)Landroid/graphics/drawable/Drawable;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.ImageDecoderKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ImageDecoder {

    /* compiled from: ImageDecoder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/graphics/ImageDecoder;", "decoder", "Landroid/graphics/ImageDecoder$ImageInfo;", "info", "Landroid/graphics/ImageDecoder$Source;", "source", "", "<anonymous>", "(Landroid/graphics/ImageDecoder;Landroid/graphics/ImageDecoder$ImageInfo;Landroid/graphics/ImageDecoder$Source;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.core.graphics.ImageDecoderKt$decodeBitmap$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ Function3<android.graphics.ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
            this.$action = function3;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public final void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            Intrinsics3.checkNotNullParameter(imageDecoder, "decoder");
            Intrinsics3.checkNotNullParameter(imageInfo, "info");
            Intrinsics3.checkNotNullParameter(source, "source");
            this.$action.invoke(imageDecoder, imageInfo, source);
        }
    }

    /* compiled from: ImageDecoder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/graphics/ImageDecoder;", "decoder", "Landroid/graphics/ImageDecoder$ImageInfo;", "info", "Landroid/graphics/ImageDecoder$Source;", "source", "", "<anonymous>", "(Landroid/graphics/ImageDecoder;Landroid/graphics/ImageDecoder$ImageInfo;Landroid/graphics/ImageDecoder$Source;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.core.graphics.ImageDecoderKt$decodeDrawable$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ Function3<android.graphics.ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
            this.$action = function3;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public final void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            Intrinsics3.checkNotNullParameter(imageDecoder, "decoder");
            Intrinsics3.checkNotNullParameter(imageInfo, "info");
            Intrinsics3.checkNotNullParameter(source, "source");
            this.$action.invoke(imageDecoder, imageInfo, source);
        }
    }

    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) throws IOException {
        Intrinsics3.checkNotNullParameter(source, "<this>");
        Intrinsics3.checkNotNullParameter(function3, "action");
        Bitmap bitmapDecodeBitmap = android.graphics.ImageDecoder.decodeBitmap(source, new AnonymousClass1(function3));
        Intrinsics3.checkNotNullExpressionValue(bitmapDecodeBitmap, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Bitmap {\n    return ImageDecoder.decodeBitmap(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return bitmapDecodeBitmap;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, Function3<? super android.graphics.ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) throws IOException {
        Intrinsics3.checkNotNullParameter(source, "<this>");
        Intrinsics3.checkNotNullParameter(function3, "action");
        Drawable drawableDecodeDrawable = android.graphics.ImageDecoder.decodeDrawable(source, new AnonymousClass1(function3));
        Intrinsics3.checkNotNullExpressionValue(drawableDecodeDrawable, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Drawable {\n    return ImageDecoder.decodeDrawable(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return drawableDecodeDrawable;
    }
}
