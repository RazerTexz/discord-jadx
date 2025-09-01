package com.discord.utilities.images;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import b.f.g.f.GenericDraweeHierarchyBuilder;
import b.f.g.f.RoundingParams;
import b.f.j.d.ResizeOptions;
import b.q.a.UCrop;
import com.discord.R;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.media_picker.MediaPicker;
import com.discord.media_picker.RequestType;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.yalantis.ucrop.UCropActivity;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import rx.functions.Action1;

/* compiled from: MGImages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003^_`B\t\b\u0002¢\u0006\u0004\b\\\u0010]JG\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0015\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJK\u0010#\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b#\u0010$Ja\u0010.\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u001e2\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r\u0018\u00010)2\b\b\u0002\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b.\u0010/Jw\u0010.\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0011002\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u001e2\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\r\u0018\u00010)2\b\b\u0002\u0010-\u001a\u00020,2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102H\u0007¢\u0006\u0004\b.\u00105J/\u00106\u001a\u00020*2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u001eH\u0007¢\u0006\u0004\b6\u00107JG\u0010=\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00109\u001a\u0002082\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00132\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b=\u0010>J\u001b\u0010A\u001a\u0006\u0012\u0002\b\u00030@2\u0006\u0010?\u001a\u00020\u0017H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020C2\u0006\u0010?\u001a\u00020\u0017H\u0002¢\u0006\u0004\bD\u0010EJ'\u0010.\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010FJ)\u0010.\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010G\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010HJ1\u0010.\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010G\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010IJ'\u0010.\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010K\u001a\u00020J2\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010LJ\u0015\u0010M\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\bM\u0010NJI\u0010W\u001a\u00020O2\u0006\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000b2\b\b\u0002\u0010U\u001a\u00020\u000b2\b\b\u0003\u0010V\u001a\u00020\u000b¢\u0006\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006a"}, d2 = {"Lcom/discord/utilities/images/MGImages;", "", "Landroid/content/Context;", "context", "Lcom/discord/media_picker/MediaPicker$Provider;", "provider", "Landroid/net/Uri;", "inputUri", "", "aspectRatioX", "aspectRatioY", "", "maxOutputDimensionPx", "", "requestImageCrop", "(Landroid/content/Context;Lcom/discord/media_picker/MediaPicker$Provider;Landroid/net/Uri;FFI)V", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "mimeType", "Lrx/functions/Action1;", "resultCallback", "requestDataUrl", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Lrx/functions/Action1;)V", "Landroid/widget/ImageView;", "view", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setScaleType", "(Landroid/widget/ImageView;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "cornerRadius", "", "circle", "overlayColor", "borderColor", "borderWidth", "setRoundingParams", "(Landroid/widget/ImageView;FZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)V", "url", "width", "height", "useSmallCache", "Lkotlin/Function1;", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "transform", "Lcom/discord/utilities/images/MGImages$ChangeDetector;", "changeDetector", "setImage", "(Landroid/widget/ImageView;Ljava/lang/String;IIZLkotlin/jvm/functions/Function1;Lcom/discord/utilities/images/MGImages$ChangeDetector;)V", "", "urls", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "controllerListener", "(Landroid/widget/ImageView;Ljava/util/List;IIZLkotlin/jvm/functions/Function1;Lcom/discord/utilities/images/MGImages$ChangeDetector;Lcom/facebook/drawee/controller/ControllerListener;)V", "getImageRequest", "(Ljava/lang/String;IIZ)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "cropResultCallback", "Lcom/discord/dialogs/ImageUploadDialog$PreviewType;", "previewType", "prepareImageUpload", "(Landroid/net/Uri;Ljava/lang/String;Landroidx/fragment/app/FragmentManager;Lcom/discord/media_picker/MediaPicker$Provider;Lrx/functions/Action1;Lcom/discord/dialogs/ImageUploadDialog$PreviewType;)V", "imageView", "Lcom/facebook/drawee/view/DraweeView;", "getDrawee", "(Landroid/widget/ImageView;)Lcom/facebook/drawee/view/DraweeView;", "Lcom/facebook/drawee/generic/GenericDraweeHierarchy;", "getHierarchy", "(Landroid/widget/ImageView;)Lcom/facebook/drawee/generic/GenericDraweeHierarchy;", "(Landroid/widget/ImageView;Landroid/net/Uri;Lcom/discord/utilities/images/MGImages$ChangeDetector;)V", "resourceId", "(Landroid/widget/ImageView;ILcom/discord/utilities/images/MGImages$ChangeDetector;)V", "(Landroid/widget/ImageView;ILcom/facebook/drawee/drawable/ScalingUtils$ScaleType;Lcom/discord/utilities/images/MGImages$ChangeDetector;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Lcom/discord/utilities/images/MGImages$ChangeDetector;)V", "cancelImageRequests", "(Landroid/widget/ImageView;)V", "Landroid/graphics/Bitmap;", "src", "innerHeight", "innerWidth", "outerHeight", "outerWidth", "fillMargins", "fillColor", "centerBitmapInTransparentBitmap", "(Landroid/graphics/Bitmap;IIIIII)Landroid/graphics/Bitmap;", "Lcom/discord/utilities/images/ImageEncoder;", "imageEncoder", "Lcom/discord/utilities/images/ImageEncoder;", "<init>", "()V", "AlwaysUpdateChangeDetector", "ChangeDetector", "DistinctChangeDetector", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MGImages {
    public static final MGImages INSTANCE = new MGImages();
    private static final ImageEncoder imageEncoder = new ImageEncoder();

    /* compiled from: MGImages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/utilities/images/MGImages$AlwaysUpdateChangeDetector;", "Lcom/discord/utilities/images/MGImages$ChangeDetector;", "", "key", "value", "", "track", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class AlwaysUpdateChangeDetector implements ChangeDetector {
        public static final AlwaysUpdateChangeDetector INSTANCE = new AlwaysUpdateChangeDetector();

        private AlwaysUpdateChangeDetector() {
        }

        @Override // com.discord.utilities.images.MGImages.ChangeDetector
        public boolean track(Object key, Object value) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return true;
        }
    }

    /* compiled from: MGImages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/images/MGImages$ChangeDetector;", "", "key", "value", "", "track", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface ChangeDetector {
        boolean track(Object key, Object value);
    }

    /* compiled from: MGImages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R6\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "Lcom/discord/utilities/images/MGImages$ChangeDetector;", "", "key", "value", "", "track", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Ljava/util/HashMap;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DistinctChangeDetector implements ChangeDetector {
        private final HashMap<Object, Object> dataMap = new HashMap<>();

        @Override // com.discord.utilities.images.MGImages.ChangeDetector
        public boolean track(Object key, Object value) {
            Intrinsics3.checkNotNullParameter(key, "key");
            if (this.dataMap.containsKey(key) && Intrinsics3.areEqual(this.dataMap.get(key), value)) {
                return false;
            }
            this.dataMap.put(key, value);
            return true;
        }
    }

    /* compiled from: MGImages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "invoke", "(Ljava/lang/Exception;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.images.MGImages$requestImageCrop$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
            invoke2(exc);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Exception exc) {
            Intrinsics3.checkNotNullParameter(exc, "e");
            Context context = this.$context;
            AppToast.h(context, context != null ? FormatUtils.h(context, R.string.unable_to_open_media_chooser, new Object[]{exc.getMessage()}, null, 4) : null, 0, null, 12);
        }
    }

    private MGImages() {
    }

    public static /* synthetic */ Bitmap centerBitmapInTransparentBitmap$default(MGImages mGImages, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        return mGImages.centerBitmapInTransparentBitmap(bitmap, i, i2, i3, i4, (i7 & 32) != 0 ? 0 : i5, (i7 & 64) != 0 ? 0 : i6);
    }

    private final DraweeView<?> getDrawee(ImageView imageView) {
        Objects.requireNonNull(imageView, "null cannot be cast to non-null type com.facebook.drawee.view.DraweeView<*>");
        return (DraweeView) imageView;
    }

    private final GenericDraweeHierarchy getHierarchy(ImageView imageView) {
        DraweeView<?> drawee = getDrawee(imageView);
        if (!drawee.hasHierarchy()) {
            drawee.setHierarchy(new GenericDraweeHierarchyBuilder(imageView.getResources()).a());
        }
        DraweeHierarchy hierarchy = drawee.getHierarchy();
        Objects.requireNonNull(hierarchy, "null cannot be cast to non-null type com.facebook.drawee.generic.GenericDraweeHierarchy");
        return (GenericDraweeHierarchy) hierarchy;
    }

    public static final ImageRequestBuilder getImageRequest(String url, int width, int height, boolean useSmallCache) {
        Intrinsics3.checkNotNullParameter(url, "url");
        ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(Uri.parse(url));
        imageRequestBuilderB.f2904b = ImageRequest.c.FULL_FETCH;
        Intrinsics3.checkNotNullExpressionValue(imageRequestBuilderB, "requestBuilder");
        boolean z2 = false;
        imageRequestBuilderB.g = (useSmallCache || !Strings4.contains$default((CharSequence) url, (CharSequence) IconUtils.ANIMATED_IMAGE_EXTENSION, false, 2, (Object) null)) ? ImageRequest.b.SMALL : ImageRequest.b.DEFAULT;
        if (width > 0 && height > 0) {
            z2 = true;
        }
        if (z2) {
            imageRequestBuilderB.d = new ResizeOptions(width, height);
        }
        return imageRequestBuilderB;
    }

    public static final void prepareImageUpload(Uri uri, String mimeType, FragmentManager fragmentManager, MediaPicker.Provider provider, Action1<String> cropResultCallback, ImageUploadDialog.PreviewType previewType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(provider, "provider");
        Intrinsics3.checkNotNullParameter(previewType, "previewType");
        Objects.requireNonNull(ImageUploadDialog.INSTANCE);
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(provider, "provider");
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics3.checkNotNullParameter(previewType, "previewType");
        ImageUploadDialog imageUploadDialog = new ImageUploadDialog();
        Intrinsics3.checkNotNullParameter(uri, "<set-?>");
        imageUploadDialog.uri = uri;
        Intrinsics3.checkNotNullParameter(provider, "<set-?>");
        imageUploadDialog.provider = provider;
        imageUploadDialog.mimeType = mimeType;
        imageUploadDialog.cropResultCallBack = cropResultCallback;
        imageUploadDialog.previewType = previewType;
        imageUploadDialog.show(fragmentManager, ImageUploadDialog.class.getName());
    }

    public static final void requestDataUrl(Context context, Uri uri, String mimeType, Action1<String> resultCallback) {
        InputStream inputStreamOpenInputStream;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        if (context != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver == null || (inputStreamOpenInputStream = contentResolver.openInputStream(uri)) == null) {
                    return;
                }
                if (resultCallback != null) {
                    try {
                        ImageEncoder imageEncoder2 = imageEncoder;
                        Intrinsics3.checkNotNullExpressionValue(inputStreamOpenInputStream, "it");
                        resultCallback.call(imageEncoder2.getDataUrl(mimeType, inputStreamOpenInputStream));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            Closeable.closeFinally(inputStreamOpenInputStream, th);
                            throw th2;
                        }
                    }
                }
                Closeable.closeFinally(inputStreamOpenInputStream, null);
            } catch (IOException e) {
                AppToast.h(context, FormatUtils.h(context, R.string.avatar_convert_failure_mobile, new Object[]{e.getMessage()}, null, 4), 0, null, 12);
            } catch (IllegalStateException e2) {
                AppToast.h(context, FormatUtils.h(context, R.string.avatar_convert_failure_mobile, new Object[]{e2.getMessage()}, null, 4), 0, null, 12);
            } catch (NullPointerException e3) {
                AppToast.h(context, FormatUtils.h(context, R.string.avatar_convert_failure_mobile, new Object[]{e3.getMessage()}, null, 4), 0, null, 12);
            }
        }
    }

    public static final void requestImageCrop(Context context, MediaPicker.Provider provider, Uri inputUri, float aspectRatioX, float aspectRatioY, int maxOutputDimensionPx) throws IOException {
        Intrinsics3.checkNotNullParameter(provider, "provider");
        Intrinsics3.checkNotNullParameter(inputUri, "inputUri");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(context);
        int themedColor = ColorCompat.getThemedColor(context, R.attr.color_brand_500);
        int color = ColorCompat.getColor(context, R.color.white);
        int themedColor2 = ColorCompat.getThemedColor(context, R.attr.color_brand_630);
        int themedColor3 = ColorCompat.getThemedColor(context, R.attr.color_brand_500);
        Intrinsics3.checkNotNullParameter(provider, "provider");
        Intrinsics3.checkNotNullParameter(inputUri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(anonymousClass1, "onError");
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("com.yalantis.ucrop.ToolbarColor", themedColor);
            bundle.putInt("com.yalantis.ucrop.StatusBarColor", themedColor2);
            bundle.putInt("com.yalantis.ucrop.UcropToolbarWidgetColor", color);
            bundle.putInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", themedColor3);
            bundle.putInt("com.yalantis.ucrop.CropFrameColor", themedColor3);
            bundle.putInt("com.yalantis.ucrop.CropGridColor", themedColor3);
            if (bundle.getString("com.yalantis.ucrop.CompressionFormatName") == null) {
                bundle.putString("com.yalantis.ucrop.CompressionFormatName", Bitmap.CompressFormat.PNG.name());
            }
            Context contextRequireContext = provider.requireContext();
            Uri uriFromFile = Uri.fromFile(provider.getImageFile());
            Intrinsics3.checkNotNullExpressionValue(uriFromFile, "Uri.fromFile(provider.getImageFile())");
            UCrop uCrop = new UCrop(inputUri, uriFromFile);
            Intrinsics3.checkNotNullExpressionValue(uCrop, "UCrop.of(uri, destUri)");
            uCrop.f1977b.putAll(bundle);
            int i = maxOutputDimensionPx < 10 ? 10 : maxOutputDimensionPx;
            if (maxOutputDimensionPx < 10) {
                maxOutputDimensionPx = 10;
            }
            uCrop.f1977b.putInt("com.yalantis.ucrop.MaxSizeX", i);
            uCrop.f1977b.putInt("com.yalantis.ucrop.MaxSizeY", maxOutputDimensionPx);
            uCrop.f1977b.putFloat("com.yalantis.ucrop.AspectRatioX", aspectRatioX);
            uCrop.f1977b.putFloat("com.yalantis.ucrop.AspectRatioY", aspectRatioY);
            uCrop.a.setClass(contextRequireContext, UCropActivity.class);
            uCrop.a.putExtras(uCrop.f1977b);
            Intent intent = uCrop.a;
            Intrinsics3.checkNotNullExpressionValue(intent, "uCrop.getIntent(context)");
            List<ResolveInfo> listQueryIntentActivities = contextRequireContext.getPackageManager().queryIntentActivities(intent, 65536);
            Intrinsics3.checkNotNullExpressionValue(listQueryIntentActivities, "context\n        .package…nager.MATCH_DEFAULT_ONLY)");
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                contextRequireContext.grantUriPermission(it.next().activityInfo.packageName, uriFromFile, 3);
            }
            try {
                provider.startActivityForResult(intent, RequestType.CROP.getCode$media_picker_release());
            } catch (ActivityNotFoundException unused) {
                throw new IOException("No application available for media picker.");
            }
        } catch (IOException e) {
            anonymousClass1.invoke((AnonymousClass1) e);
        }
    }

    public static /* synthetic */ void requestImageCrop$default(Context context, MediaPicker.Provider provider, Uri uri, float f, float f2, int i, int i2, Object obj) throws IOException {
        requestImageCrop(context, provider, uri, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? 1.0f : f2, (i2 & 32) != 0 ? 1024 : i);
    }

    public static final void setImage(ImageView imageView, String str) {
        setImage$default(imageView, str, 0, 0, false, null, null, 124, null);
    }

    public static final void setImage(ImageView imageView, String str, int i) {
        setImage$default(imageView, str, i, 0, false, null, null, 120, null);
    }

    public static final void setImage(ImageView imageView, String str, int i, int i2) {
        setImage$default(imageView, str, i, i2, false, null, null, 112, null);
    }

    public static final void setImage(ImageView imageView, String str, int i, int i2, boolean z2) {
        setImage$default(imageView, str, i, i2, z2, null, null, 96, null);
    }

    public static final void setImage(ImageView imageView, String str, int i, int i2, boolean z2, Function1<? super ImageRequestBuilder, Unit> function1) {
        setImage$default(imageView, str, i, i2, z2, function1, null, 64, null);
    }

    public static final void setImage(ImageView imageView, List<String> list) {
        setImage$default(imageView, list, 0, 0, false, null, null, null, 252, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i) {
        setImage$default(imageView, list, i, 0, false, null, null, null, 248, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i, int i2) {
        setImage$default(imageView, list, i, i2, false, null, null, null, 240, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i, int i2, boolean z2) {
        setImage$default(imageView, list, i, i2, z2, null, null, null, 224, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i, int i2, boolean z2, Function1<? super ImageRequestBuilder, Unit> function1) {
        setImage$default(imageView, list, i, i2, z2, function1, null, null, Opcodes.CHECKCAST, null);
    }

    public static final void setImage(ImageView imageView, List<String> list, int i, int i2, boolean z2, Function1<? super ImageRequestBuilder, Unit> function1, ChangeDetector changeDetector) {
        setImage$default(imageView, list, i, i2, z2, function1, changeDetector, null, 128, null);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, Uri uri, ChangeDetector changeDetector, int i, Object obj) {
        if ((i & 4) != 0) {
            changeDetector = AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, uri, changeDetector);
    }

    public static final void setRoundingParams(ImageView view, float cornerRadius, boolean circle, @ColorInt Integer overlayColor, @ColorInt Integer borderColor, Float borderWidth) {
        RoundingParams roundingParamsA;
        Intrinsics3.checkNotNullParameter(view, "view");
        if (circle) {
            roundingParamsA = new RoundingParams();
            roundingParamsA.f523b = true;
            roundingParamsA.a = 1;
        } else {
            roundingParamsA = RoundingParams.a(cornerRadius);
        }
        if (Build.VERSION.SDK_INT == 28) {
            Intrinsics3.checkNotNullExpressionValue(roundingParamsA, "roundingParams");
            roundingParamsA.h = true;
        }
        if (overlayColor != null) {
            overlayColor.intValue();
            Intrinsics3.checkNotNullExpressionValue(roundingParamsA, "roundingParams");
            roundingParamsA.b(overlayColor.intValue());
        }
        if (borderColor != null) {
            borderColor.intValue();
            Intrinsics3.checkNotNullExpressionValue(roundingParamsA, "roundingParams");
            roundingParamsA.f = borderColor.intValue();
        }
        if (borderWidth != null) {
            borderWidth.floatValue();
            Intrinsics3.checkNotNullExpressionValue(roundingParamsA, "roundingParams");
            float fFloatValue = borderWidth.floatValue();
            AnimatableValueParser.k(fFloatValue >= 0.0f, "the border width cannot be < 0");
            roundingParamsA.e = fFloatValue;
        }
        INSTANCE.getHierarchy(view).s(roundingParamsA);
    }

    public static /* synthetic */ void setRoundingParams$default(ImageView imageView, float f, boolean z2, Integer num, Integer num2, Float f2, int i, Object obj) {
        setRoundingParams(imageView, f, z2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : f2);
    }

    public static final void setScaleType(ImageView view, ScalingUtils$ScaleType scaleType) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(scaleType, "scaleType");
        INSTANCE.getHierarchy(view).n(scaleType);
    }

    public final void cancelImageRequests(ImageView view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        getDrawee(view).setController(null);
    }

    public final Bitmap centerBitmapInTransparentBitmap(Bitmap src, int innerHeight, int innerWidth, int outerHeight, int outerWidth, int fillMargins, @ColorInt int fillColor) {
        Intrinsics3.checkNotNullParameter(src, "src");
        if (outerWidth <= innerWidth || outerHeight <= innerHeight) {
            StringBuilder sbW = outline.W("Cannot fit bitmap of size ", innerWidth, " x ", innerHeight, " inside ");
            sbW.append("bitmap of size ");
            sbW.append(outerWidth);
            sbW.append(" x ");
            sbW.append(outerHeight);
            throw new IllegalArgumentException(sbW.toString());
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(outerWidth, outerHeight, src.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f = (outerWidth - innerWidth) / 2.0f;
        float f2 = (outerHeight - innerHeight) / 2.0f;
        RectF rectF = new RectF(f, f2, innerWidth + f, innerHeight + f2);
        if (fillColor != 0) {
            int iSave = canvas.save();
            try {
                canvas.clipRect(fillMargins, fillMargins, outerWidth - fillMargins, outerHeight - fillMargins);
                canvas.drawColor(fillColor);
            } finally {
                canvas.restoreToCount(iSave);
            }
        }
        canvas.drawBitmap(src, (Rect) null, rectF, (Paint) null);
        Intrinsics3.checkNotNullExpressionValue(bitmapCreateBitmap, "dest");
        return bitmapCreateBitmap;
    }

    public final void setImage(ImageView view, Uri uri, ChangeDetector changeDetector) {
        Integer intOrNull;
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        if (Intrinsics3.areEqual(uri.getScheme(), "android.resource")) {
            String host = uri.getHost();
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            if (Intrinsics3.areEqual(host, context.getPackageName())) {
                String lastPathSegment = uri.getLastPathSegment();
                setImage(view, (lastPathSegment == null || (intOrNull = StringNumberConversions.toIntOrNull(lastPathSegment)) == null) ? 0 : intOrNull.intValue(), changeDetector);
                return;
            }
        }
        setImage$default(view, uri.toString(), 0, 0, false, null, changeDetector, 60, null);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, int i, ChangeDetector changeDetector, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            changeDetector = AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, i, changeDetector);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, int i, ScalingUtils$ScaleType scalingUtils$ScaleType, ChangeDetector changeDetector, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            changeDetector = AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, i, scalingUtils$ScaleType, changeDetector);
    }

    public static /* synthetic */ void setImage$default(MGImages mGImages, ImageView imageView, Drawable drawable, ChangeDetector changeDetector, int i, Object obj) {
        if ((i & 4) != 0) {
            changeDetector = AlwaysUpdateChangeDetector.INSTANCE;
        }
        mGImages.setImage(imageView, drawable, changeDetector);
    }

    public static /* synthetic */ void setImage$default(ImageView imageView, String str, int i, int i2, boolean z2, Function1 function1, ChangeDetector changeDetector, int i3, Object obj) {
        setImage(imageView, str, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) == 0 ? z2 : false, (Function1<? super ImageRequestBuilder, Unit>) ((i3 & 32) != 0 ? null : function1), (i3 & 64) != 0 ? AlwaysUpdateChangeDetector.INSTANCE : changeDetector);
    }

    public final void setImage(ImageView view, @DrawableRes int resourceId, ChangeDetector changeDetector) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, Integer.valueOf(resourceId))) {
            GenericDraweeHierarchy hierarchy = getHierarchy(view);
            hierarchy.o(1, hierarchy.f2890b.getDrawable(resourceId));
        }
    }

    public static /* synthetic */ void setImage$default(ImageView imageView, List list, int i, int i2, boolean z2, Function1 function1, ChangeDetector changeDetector, ControllerListener controllerListener, int i3, Object obj) {
        setImage(imageView, list, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) == 0 ? z2 : false, (i3 & 32) != 0 ? null : function1, (i3 & 64) != 0 ? AlwaysUpdateChangeDetector.INSTANCE : changeDetector, (i3 & 128) == 0 ? controllerListener : null);
    }

    public final void setImage(ImageView view, @DrawableRes int resourceId, ScalingUtils$ScaleType scaleType, ChangeDetector changeDetector) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, Integer.valueOf(resourceId))) {
            GenericDraweeHierarchy hierarchy = getHierarchy(view);
            hierarchy.q(hierarchy.f2890b.getDrawable(resourceId), scaleType);
        }
    }

    public final void setImage(ImageView view, Drawable drawable, ChangeDetector changeDetector) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(drawable, "drawable");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, drawable)) {
            getHierarchy(view).o(1, drawable);
        }
    }

    public static final void setImage(ImageView view, String url, int width, int height, boolean useSmallCache, Function1<? super ImageRequestBuilder, Unit> transform, ChangeDetector changeDetector) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        setImage$default(view, (url == null || StringsJVM.isBlank(url)) ? Collections2.emptyList() : CollectionsJVM.listOf(url), width, height, useSmallCache, transform, changeDetector, null, 128, null);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [REQUEST[], com.facebook.imagepipeline.request.ImageRequest[]] */
    public static final void setImage(ImageView view, List<String> urls, int width, int height, boolean useSmallCache, Function1<? super ImageRequestBuilder, Unit> transform, ChangeDetector changeDetector, ControllerListener<ImageInfo> controllerListener) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(urls, "urls");
        Intrinsics3.checkNotNullParameter(changeDetector, "changeDetector");
        if (changeDetector.track(view, urls)) {
            if (urls.isEmpty()) {
                INSTANCE.getDrawee(view).setController(null);
                return;
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(urls, 10));
            Iterator<T> it = urls.iterator();
            while (it.hasNext()) {
                ImageRequestBuilder imageRequest = getImageRequest((String) it.next(), width, height, useSmallCache);
                if (transform != null) {
                    transform.invoke(imageRequest);
                }
                arrayList.add(imageRequest.a());
            }
            Object[] array = arrayList.toArray(new ImageRequest[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ?? r4 = (ImageRequest[]) array;
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
            MGImages mGImages = INSTANCE;
            pipelineDraweeControllerBuilderA.n = mGImages.getDrawee(view).getController();
            pipelineDraweeControllerBuilderA.k = controllerListener;
            pipelineDraweeControllerBuilderA.m = true;
            AnimatableValueParser.k(r4.length > 0, "No requests specified!");
            pipelineDraweeControllerBuilderA.i = r4;
            pipelineDraweeControllerBuilderA.j = true;
            mGImages.getDrawee(view).setController(pipelineDraweeControllerBuilderA.a());
        }
    }
}
