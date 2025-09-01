package com.discord.utilities.images;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Suppliers;
import b.f.d.e.FLog;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilderSupplier;
import b.f.j.e.ImagePipeline;
import b.f.j.e.ImagePipeline2;
import b.f.j.e.ImagePipelineConfig2;
import b.f.j.e.ImagePipelineExperiments;
import b.f.j.e.ImagePipelineFactory;
import b.f.j.e.NativeCodeSetup;
import b.f.j.r.FrescoSystrace;
import b.f.m.n.NativeLoader;
import b.f.m.n.SystemDelegate;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import d0.z.d.Intrinsics3;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: MGImagesConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\b*\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/images/MGImagesConfig;", "", "Landroid/content/Context;", "", "directoryName", "Lcom/facebook/cache/disk/DiskCacheConfig;", "newDiskCacheConfig", "(Landroid/content/Context;Ljava/lang/String;)Lcom/facebook/cache/disk/DiskCacheConfig;", "Lcom/facebook/imagepipeline/cache/DefaultBitmapMemoryCacheParamsSupplier;", "getAppBitmapMemoryCacheParamsSupplier", "(Landroid/content/Context;)Lcom/facebook/imagepipeline/cache/DefaultBitmapMemoryCacheParamsSupplier;", "Landroid/app/Application;", "context", "", "init", "(Landroid/app/Application;)V", "", "level", "onTrimMemory", "(I)V", "CACHE_DIR_SMALL", "Ljava/lang/String;", "", "MAX_DISK_CACHE_SIZE", "J", "MAX_BITMAP_MEM_CACHE_SIZE_RATIO", "I", "CACHE_DIR", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MGImagesConfig {
    private static final String CACHE_DIR = "app_images_cache";
    private static final String CACHE_DIR_SMALL = "app_images_cache_small";
    public static final MGImagesConfig INSTANCE = new MGImagesConfig();
    private static final int MAX_BITMAP_MEM_CACHE_SIZE_RATIO = 3;
    private static final long MAX_DISK_CACHE_SIZE = 41943040;

    /* compiled from: MGImagesConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/discord/utilities/images/MGImagesConfig$getAppBitmapMemoryCacheParamsSupplier$1", "Lcom/facebook/imagepipeline/cache/DefaultBitmapMemoryCacheParamsSupplier;", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "get", "()Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.images.MGImagesConfig$getAppBitmapMemoryCacheParamsSupplier$1, reason: invalid class name */
    public static final class AnonymousClass1 extends DefaultBitmapMemoryCacheParamsSupplier {
        public final /* synthetic */ ActivityManager $activityManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ActivityManager activityManager, ActivityManager activityManager2) {
            super(activityManager2);
            this.$activityManager = activityManager;
        }

        @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
        public /* bridge */ /* synthetic */ MemoryCacheParams get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
        public MemoryCacheParams get() {
            MemoryCacheParams memoryCacheParams = super.get();
            int i = memoryCacheParams.a;
            return new MemoryCacheParams(i, memoryCacheParams.f2895b, memoryCacheParams.c, memoryCacheParams.d, i / 3, TimeUnit.MINUTES.toMillis(5L));
        }
    }

    private MGImagesConfig() {
    }

    private final DefaultBitmapMemoryCacheParamsSupplier getAppBitmapMemoryCacheParamsSupplier(Context context) {
        Object systemService = context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        return new AnonymousClass1(activityManager, activityManager);
    }

    private final DiskCacheConfig newDiskCacheConfig(Context context, String str) {
        DiskCacheConfig.b bVar = new DiskCacheConfig.b(context, null);
        bVar.f2883b = new Suppliers(context.getCacheDir());
        bVar.a = str;
        bVar.c = MAX_DISK_CACHE_SIZE;
        DiskCacheConfig diskCacheConfig = new DiskCacheConfig(bVar);
        Intrinsics3.checkNotNullExpressionValue(diskCacheConfig, "DiskCacheConfig\n        …HE_SIZE)\n        .build()");
        return diskCacheConfig;
    }

    public final void init(Application context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        ImagePipelineConfig2.a aVar = new ImagePipelineConfig2.a(context, null);
        aVar.c = true;
        aVar.d = newDiskCacheConfig(context, CACHE_DIR);
        aVar.e = newDiskCacheConfig(context, CACHE_DIR_SMALL);
        DefaultBitmapMemoryCacheParamsSupplier appBitmapMemoryCacheParamsSupplier = getAppBitmapMemoryCacheParamsSupplier(context);
        Objects.requireNonNull(appBitmapMemoryCacheParamsSupplier);
        aVar.a = appBitmapMemoryCacheParamsSupplier;
        ImagePipelineExperiments.b bVar = aVar.f;
        bVar.f576b = true;
        ImagePipelineConfig2.a aVar2 = bVar.a;
        Objects.requireNonNull(aVar2);
        ImagePipelineConfig2 imagePipelineConfig2 = new ImagePipelineConfig2(aVar2, null);
        FrescoSystrace.b();
        if (Fresco.f477b) {
            FLog.k(Fresco.class, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            Fresco.f477b = true;
        }
        NativeCodeSetup.a = true;
        if (!NativeLoader.b()) {
            FrescoSystrace.b();
            try {
                try {
                    try {
                        Class.forName("com.facebook.imagepipeline.nativecode.NativeCodeInitializer").getMethod("init", Context.class).invoke(null, context);
                    } catch (ClassNotFoundException unused) {
                        NativeLoader.a(new SystemDelegate());
                    } catch (IllegalAccessException unused2) {
                        NativeLoader.a(new SystemDelegate());
                    }
                } catch (NoSuchMethodException unused3) {
                    NativeLoader.a(new SystemDelegate());
                } catch (InvocationTargetException unused4) {
                    NativeLoader.a(new SystemDelegate());
                }
                FrescoSystrace.b();
            } finally {
                FrescoSystrace.b();
            }
        }
        Context applicationContext = context.getApplicationContext();
        ImagePipelineFactory.j(imagePipelineConfig2);
        FrescoSystrace.b();
        PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(applicationContext);
        Fresco.a = pipelineDraweeControllerBuilderSupplier;
        SimpleDraweeView.initialize(pipelineDraweeControllerBuilderSupplier);
        FrescoSystrace.b();
    }

    public final void onTrimMemory(int level) {
        if (level == 5 || level == 10 || level == 15 || level == 40 || level == 60 || level == 80) {
            ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.a;
            AnimatableValueParser.y(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
            if (imagePipelineFactory.l == null) {
                imagePipelineFactory.l = imagePipelineFactory.a();
            }
            ImagePipeline2 imagePipeline2 = imagePipelineFactory.l;
            ImagePipeline imagePipeline = new ImagePipeline(imagePipeline2);
            imagePipeline2.e.d(imagePipeline);
            imagePipeline2.f.d(imagePipeline);
        }
    }
}
