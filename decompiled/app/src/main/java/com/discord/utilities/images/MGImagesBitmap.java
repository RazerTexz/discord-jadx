package com.discord.utilities.images;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.j.e.ImagePipeline2;
import b.f.j.e.ImagePipelineFactory;
import b.f.j.f.BaseBitmapDataSubscriber;
import b.f.j.j.CloseableImage;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.Tuples;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import j0.k.Func1;
import j0.l.a.OnSubscribeFromIterable;
import j0.p.Schedulers2;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscriber;

/* compiled from: MGImagesBitmap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0014\u0015\u0016\u0017\u0018B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap;", "", "", "Lcom/discord/utilities/images/MGImagesBitmap$ImageRequest;", "imageRequests", "Lrx/Observable;", "Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "getBitmaps", "(Ljava/util/Set;)Lrx/Observable;", "", "imageUri", "", "isValidUri", "(Ljava/lang/String;)Z", "imageIsCircle", "Landroid/graphics/Bitmap;", "getBitmap", "(Ljava/lang/String;Z)Lrx/Observable;", "<init>", "()V", "CloseableBitmaps", "DecodeException", "ImageNotFoundException", "ImageRequest", "MissingBitmapException", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MGImagesBitmap {
    public static final MGImagesBitmap INSTANCE = new MGImagesBitmap();

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B%\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0012\b\b\u0002\u0010'\u001a\u00020\f¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"R(\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030$0\u001c8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010\u001eR\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "", "", "Landroid/graphics/Bitmap;", "Ljava/io/Closeable;", "", "close", "()V", "other", "plus", "(Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;)Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "key", "", "containsKey", "(Ljava/lang/String;)Z", "value", "containsValue", "(Landroid/graphics/Bitmap;)Z", "get", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "isEmpty", "()Z", "underlyingMap", "Ljava/util/Map;", "", "getSize", "()I", "size", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getValues", "()Ljava/util/Collection;", "values", "", "getEntries", "entries", "recycleBitmaps", "Z", "<init>", "(Ljava/util/Map;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class CloseableBitmaps implements Map<String, Bitmap>, Closeable, KMarkers {
        private final boolean recycleBitmaps;
        private final Map<String, Bitmap> underlyingMap;

        public CloseableBitmaps(Map<String, Bitmap> map, boolean z2) {
            Intrinsics3.checkNotNullParameter(map, "underlyingMap");
            this.underlyingMap = map;
            this.recycleBitmaps = z2;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.recycleBitmaps) {
                Iterator<Map.Entry<String, Bitmap>> it = this.underlyingMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().recycle();
                }
            }
        }

        /* renamed from: compute, reason: avoid collision after fix types in other method */
        public Bitmap compute2(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap compute(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: computeIfAbsent, reason: avoid collision after fix types in other method */
        public Bitmap computeIfAbsent2(String str, Function<? super String, ? extends Bitmap> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap computeIfAbsent(String str, Function<? super String, ? extends Bitmap> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: computeIfPresent, reason: avoid collision after fix types in other method */
        public Bitmap computeIfPresent2(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap computeIfPresent(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public boolean containsKey(String key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return this.underlyingMap.containsKey(key);
        }

        public boolean containsValue(Bitmap value) {
            Intrinsics3.checkNotNullParameter(value, "value");
            return this.underlyingMap.containsValue(value);
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Bitmap) {
                return containsValue((Bitmap) obj);
            }
            return false;
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Bitmap>> entrySet() {
            return getEntries();
        }

        public Bitmap get(String key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return this.underlyingMap.get(key);
        }

        @Override // java.util.Map
        public final /* bridge */ Bitmap get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public Set<Map.Entry<String, Bitmap>> getEntries() {
            return this.underlyingMap.entrySet();
        }

        public Set<String> getKeys() {
            return this.underlyingMap.keySet();
        }

        public int getSize() {
            return this.underlyingMap.size();
        }

        public Collection<Bitmap> getValues() {
            return this.underlyingMap.values();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.underlyingMap.isEmpty();
        }

        @Override // java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        /* renamed from: merge, reason: avoid collision after fix types in other method */
        public Bitmap merge2(String str, Bitmap bitmap, BiFunction<? super Bitmap, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap merge(String str, Bitmap bitmap, BiFunction<? super Bitmap, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final CloseableBitmaps plus(CloseableBitmaps other) {
            Intrinsics3.checkNotNullParameter(other, "other");
            return new CloseableBitmaps(Maps6.plus(this.underlyingMap, other.underlyingMap), this.recycleBitmaps && other.recycleBitmaps);
        }

        /* renamed from: put, reason: avoid collision after fix types in other method */
        public Bitmap put2(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap put(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends String, ? extends Bitmap> map) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: putIfAbsent, reason: avoid collision after fix types in other method */
        public Bitmap putIfAbsent2(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap putIfAbsent(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public Bitmap remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: replace, reason: avoid collision after fix types in other method */
        public Bitmap replace2(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap replace(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ boolean replace(String str, Bitmap bitmap, Bitmap bitmap2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: replace, reason: avoid collision after fix types in other method */
        public boolean replace2(String str, Bitmap bitmap, Bitmap bitmap2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Map
        public final /* bridge */ Collection<Bitmap> values() {
            return getValues();
        }

        public /* synthetic */ CloseableBitmaps(Map map, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, (i & 2) != 0 ? true : z2);
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap$DecodeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "imageUri", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DecodeException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecodeException(String str) {
            super("Unable to decode image: " + str + '.');
            Intrinsics3.checkNotNullParameter(str, "imageUri");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap$ImageNotFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "imageUri", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ImageNotFoundException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageNotFoundException(String str) {
            super("404 image not found: " + str);
            Intrinsics3.checkNotNullParameter(str, "imageUri");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap$ImageRequest;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "imageUri", "roundAsCircle", "copy", "(Ljava/lang/String;Z)Lcom/discord/utilities/images/MGImagesBitmap$ImageRequest;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getImageUri", "Z", "getRoundAsCircle", "<init>", "(Ljava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ImageRequest {
        private final String imageUri;
        private final boolean roundAsCircle;

        public ImageRequest(String str, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, "imageUri");
            this.imageUri = str;
            this.roundAsCircle = z2;
        }

        public static /* synthetic */ ImageRequest copy$default(ImageRequest imageRequest, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imageRequest.imageUri;
            }
            if ((i & 2) != 0) {
                z2 = imageRequest.roundAsCircle;
            }
            return imageRequest.copy(str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getImageUri() {
            return this.imageUri;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getRoundAsCircle() {
            return this.roundAsCircle;
        }

        public final ImageRequest copy(String imageUri, boolean roundAsCircle) {
            Intrinsics3.checkNotNullParameter(imageUri, "imageUri");
            return new ImageRequest(imageUri, roundAsCircle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageRequest)) {
                return false;
            }
            ImageRequest imageRequest = (ImageRequest) other;
            return Intrinsics3.areEqual(this.imageUri, imageRequest.imageUri) && this.roundAsCircle == imageRequest.roundAsCircle;
        }

        public final String getImageUri() {
            return this.imageUri;
        }

        public final boolean getRoundAsCircle() {
            return this.roundAsCircle;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.imageUri;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.roundAsCircle;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ImageRequest(imageUri=");
            sbU.append(this.imageUri);
            sbU.append(", roundAsCircle=");
            return outline.O(sbU, this.roundAsCircle, ")");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap$MissingBitmapException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "imageUri", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class MissingBitmapException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingBitmapException(String str) {
            super("Unable to decode image as bitmap: " + str);
            Intrinsics3.checkNotNullParameter(str, "imageUri");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042.\u0010\u0003\u001a*\u0012\u000e\b\u0000\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0000\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lrx/Subscriber;", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "emitter", "", NotificationCompat.CATEGORY_CALL, "(Lrx/Subscriber;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmap$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Observable.a<Bitmap> {
        public final /* synthetic */ DataSource $dataSource;
        public final /* synthetic */ String $imageUri;

        /* compiled from: MGImagesBitmap.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/discord/utilities/images/MGImagesBitmap$getBitmap$1$1", "Lb/f/j/f/c;", "Landroid/graphics/Bitmap;", "bitmap", "", "onNewResultImpl", "(Landroid/graphics/Bitmap;)V", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lb/f/j/j/c;", "dataSource", "onFailureImpl", "(Lcom/facebook/datasource/DataSource;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmap$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02141 extends BaseBitmapDataSubscriber {
            public final /* synthetic */ Subscriber $emitter;

            public C02141(Subscriber subscriber) {
                this.$emitter = subscriber;
            }

            @Override // b.f.e.BaseDataSubscriber
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                String message;
                Intrinsics3.checkNotNullParameter(dataSource, "dataSource");
                Throwable thD = dataSource.d();
                if (thD != null && (message = thD.getMessage()) != null && Strings4.contains$default((CharSequence) message, (CharSequence) "404", false, 2, (Object) null)) {
                    this.$emitter.onError(new ImageNotFoundException(AnonymousClass1.this.$imageUri));
                    return;
                }
                Subscriber subscriber = this.$emitter;
                Throwable thD2 = dataSource.d();
                if (thD2 == null) {
                    thD2 = new DecodeException(AnonymousClass1.this.$imageUri);
                }
                subscriber.onError(thD2);
            }

            @Override // b.f.j.f.BaseBitmapDataSubscriber
            public void onNewResultImpl(Bitmap bitmap) {
                if (bitmap == null) {
                    this.$emitter.onError(new MissingBitmapException(AnonymousClass1.this.$imageUri));
                } else {
                    this.$emitter.onNext(Bitmap.createBitmap(bitmap));
                    this.$emitter.onCompleted();
                }
            }
        }

        /* compiled from: MGImagesBitmap.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "runnable", "", "execute", "(Ljava/lang/Runnable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmap$1$2, reason: invalid class name */
        public static final class AnonymousClass2 implements Executor {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        }

        public AnonymousClass1(DataSource dataSource, String str) {
            this.$dataSource = dataSource;
            this.$imageUri = str;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber<? super Bitmap>) obj);
        }

        public final void call(Subscriber<? super Bitmap> subscriber) {
            this.$dataSource.f(new C02141(subscriber), AnonymousClass2.INSTANCE);
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001az\u00126\b\u0001\u00122\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00060\u0006 \u0001*\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00040\u0004 \u0001*<\u00126\b\u0001\u00122\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00060\u0006 \u0001*\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap$ImageRequest;", "kotlin.jvm.PlatformType", "imageRequest", "Lrx/Observable;", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/images/MGImagesBitmap$ImageRequest;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ImageRequest, Observable<? extends Tuples2<? extends String, ? extends Bitmap>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: MGImagesBitmap.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0007\u001a2\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "bitmap", "Lkotlin/Pair;", "", NotificationCompat.CATEGORY_CALL, "(Landroid/graphics/Bitmap;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02151<T, R> implements Func1<Bitmap, Tuples2<? extends String, ? extends Bitmap>> {
            public final /* synthetic */ ImageRequest $imageRequest;

            public C02151(ImageRequest imageRequest) {
                this.$imageRequest = imageRequest;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Tuples2<? extends String, ? extends Bitmap> call(Bitmap bitmap) {
                return call2(bitmap);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2<String, Bitmap> call2(Bitmap bitmap) {
                return Tuples.to(this.$imageRequest.getImageUri(), bitmap);
            }
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends String, ? extends Bitmap>> call(ImageRequest imageRequest) {
            return call2(imageRequest);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Tuples2<String, Bitmap>> call2(ImageRequest imageRequest) {
            return MGImagesBitmap.INSTANCE.getBitmap(imageRequest.getImageUri(), imageRequest.getRoundAsCircle()).G(new C02151(imageRequest));
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00010\u000126\u0010\u0004\u001a2\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0018\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Tuples2<? extends String, ? extends Bitmap>, String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ String call(Tuples2<? extends String, ? extends Bitmap> tuples2) {
            return call2((Tuples2<String, Bitmap>) tuples2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(Tuples2<String, Bitmap> tuples2) {
            return tuples2.getFirst();
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00020\u000226\u0010\u0004\u001a2\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0018\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Landroid/graphics/Bitmap;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Tuples2<? extends String, ? extends Bitmap>, Bitmap> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Bitmap call(Tuples2<? extends String, ? extends Bitmap> tuples2) {
            return call2((Tuples2<String, Bitmap>) tuples2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Bitmap call2(Tuples2<String, Bitmap> tuples2) {
            return tuples2.getSecond();
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062F\u0010\u0005\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00040\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "kotlin.jvm.PlatformType", "Landroid/graphics/Bitmap;", "", "it", "Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Map<String, Bitmap>, CloseableBitmaps> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ CloseableBitmaps call(Map<String, Bitmap> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final CloseableBitmaps call2(Map<String, Bitmap> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "it");
            return new CloseableBitmaps(map, false, 2, null);
        }
    }

    private MGImagesBitmap() {
    }

    public static final Observable<CloseableBitmaps> getBitmaps(Set<ImageRequest> imageRequests) {
        Intrinsics3.checkNotNullParameter(imageRequests, "imageRequests");
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageRequests) {
            if (!StringsJVM.isBlank(((ImageRequest) obj).getImageUri())) {
                arrayList.add(obj);
            }
        }
        Observable<CloseableBitmaps> observableX = Observable.h0(new OnSubscribeFromIterable(arrayList)).A(AnonymousClass1.INSTANCE).g0(AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE).G(AnonymousClass4.INSTANCE).X(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableX, "Observable\n        .from…Schedulers.computation())");
        return observableX;
    }

    private final boolean isValidUri(String imageUri) {
        Uri uri = Uri.parse(imageUri);
        Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        String scheme = uri.getScheme();
        if (scheme == null || StringsJVM.isBlank(scheme)) {
            return false;
        }
        String host = uri.getHost();
        if (host == null || StringsJVM.isBlank(host)) {
            return false;
        }
        String path = uri.getPath();
        return !(path == null || StringsJVM.isBlank(path));
    }

    public final Observable<Bitmap> getBitmap(String imageUri, boolean imageIsCircle) {
        Intrinsics3.checkNotNullParameter(imageUri, "imageUri");
        if (!isValidUri(imageUri)) {
            Observable<Bitmap> observableX = Observable.x(new IllegalArgumentException(outline.w("invalid uri: ", imageUri)));
            Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…invalid uri: $imageUri\"))");
            return observableX;
        }
        ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.a;
        AnimatableValueParser.y(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
        if (imagePipelineFactory.l == null) {
            imagePipelineFactory.l = imagePipelineFactory.a();
        }
        ImagePipeline2 imagePipeline2 = imagePipelineFactory.l;
        ImageRequestBuilder imageRequest = MGImages.getImageRequest(imageUri, 0, 0, false);
        if (imageIsCircle) {
            imageRequest.l = new RoundAsCirclePostProcessor2(imageUri);
        }
        Observable<Bitmap> observableH0 = Observable.h0(new AnonymousClass1(imagePipeline2.a(imageRequest.a(), null, ImageRequest.c.FULL_FETCH, null, null), imageUri));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "Observable.unsafeCreate …y emits the bitmap.\n    }");
        return observableH0;
    }
}
