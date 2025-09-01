package com.discord.utilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.colors.RepresentativeColors;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Tuples;
import d0.f0._Sequences2;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.t._Collections;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: ShareUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b5\u00106J9\u0010\f\u001a\u00020\u000b2\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0014\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0083\u0001\u0010\u0018\u001an\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003 \u0017*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00020\u0002 \u0017*6\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003 \u0017*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00160\u00162\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00132\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 JY\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\n\u0010#\u001a\u00060!j\u0002`\"2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010)J\u001d\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b/\u00100J!\u00103\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000501¢\u0006\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/discord/utilities/ShareUtils;", "", "", "Lkotlin/Pair;", "Lcom/discord/utilities/ChannelShortcutInfo;", "", "channelAndIconUriPairs", "Landroid/content/Context;", "context", "Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "iconBitmaps", "", "updateDynamicShortcuts", "(Ljava/util/List;Landroid/content/Context;Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;)V", "Lcom/discord/api/channel/Channel;", "Landroidx/core/graphics/drawable/IconCompat;", "icon", "", "rank", "Landroidx/core/content/pm/ShortcutInfoCompat;", "toShortcutInfo", "(Lcom/discord/api/channel/Channel;Landroid/content/Context;Landroidx/core/graphics/drawable/IconCompat;I)Landroidx/core/content/pm/ShortcutInfoCompat;", "Lrx/Observable;", "kotlin.jvm.PlatformType", "observeChannelAndIconPairs", "(Landroid/content/Context;)Lrx/Observable;", "updateDirectShareTargets", "(Landroid/content/Context;)V", "shortcutInfo", "Landroidx/core/app/NotificationCompat$Builder;", "notificationBuilder", "addShortcut", "(Landroid/content/Context;Landroidx/core/content/pm/ShortcutInfoCompat;Landroidx/core/app/NotificationCompat$Builder;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "shortLabel", "longLabel", "Landroidx/core/app/Person;", "persons", "(Landroid/content/Context;JLjava/lang/CharSequence;Ljava/lang/CharSequence;Landroidx/core/graphics/drawable/IconCompat;Ljava/util/List;I)Landroidx/core/content/pm/ShortcutInfoCompat;", "Landroid/content/Intent;", "intent", "", "deleteExtras", "Lcom/discord/utilities/ShareUtils$SharedContent;", "getSharedContent", "(Landroid/content/Intent;Z)Lcom/discord/utilities/ShareUtils$SharedContent;", "Lkotlin/sequences/Sequence;", "iconUris", "loadAdaptiveBitmaps", "(Lkotlin/sequences/Sequence;)Lrx/Observable;", "<init>", "()V", "SharedContent", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ShareUtils {
    public static final ShareUtils INSTANCE = new ShareUtils();

    /* compiled from: ShareUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/ShareUtils$SharedContent;", "", "", "component1", "()Ljava/lang/CharSequence;", "", "Landroid/net/Uri;", "component2", "()Ljava/util/List;", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "uris", "copy", "(Ljava/lang/CharSequence;Ljava/util/List;)Lcom/discord/utilities/ShareUtils$SharedContent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getUris", "Ljava/lang/CharSequence;", "getText", "<init>", "(Ljava/lang/CharSequence;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SharedContent {
        private final CharSequence text;
        private final List<Uri> uris;

        /* JADX WARN: Multi-variable type inference failed */
        public SharedContent(CharSequence charSequence, List<? extends Uri> list) {
            this.text = charSequence;
            this.uris = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SharedContent copy$default(SharedContent sharedContent, CharSequence charSequence, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = sharedContent.text;
            }
            if ((i & 2) != 0) {
                list = sharedContent.uris;
            }
            return sharedContent.copy(charSequence, list);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        public final List<Uri> component2() {
            return this.uris;
        }

        public final SharedContent copy(CharSequence text, List<? extends Uri> uris) {
            return new SharedContent(text, uris);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedContent)) {
                return false;
            }
            SharedContent sharedContent = (SharedContent) other;
            return Intrinsics3.areEqual(this.text, sharedContent.text) && Intrinsics3.areEqual(this.uris, sharedContent.uris);
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final List<Uri> getUris() {
            return this.uris;
        }

        public int hashCode() {
            CharSequence charSequence = this.text;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            List<Uri> list = this.uris;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SharedContent(text=");
            sbU.append(this.text);
            sbU.append(", uris=");
            return outline.L(sbU, this.uris, ")");
        }
    }

    /* compiled from: ShareUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "kotlin.jvm.PlatformType", "iconBitmaps", "Lrx/Observable;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<MGImagesBitmap.CloseableBitmaps, Observable<? extends MGImagesBitmap.CloseableBitmaps>> {
        public final /* synthetic */ int $fillMargins;
        public final /* synthetic */ int $fullBitmapSize;
        public final /* synthetic */ int $iconSize;

        /* compiled from: ShareUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001aZ\u0012&\b\u0001\u0012\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00060\u0006 \u0003*,\u0012&\b\u0001\u0012\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lrx/Observable;", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map$Entry;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02031<T, R> implements Func1<Map.Entry<? extends String, ? extends Bitmap>, Observable<? extends Tuples2<? extends String, ? extends Bitmap>>> {
            public final /* synthetic */ RepresentativeColors $representativeColors;

            /* compiled from: ShareUtils.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0001*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "kotlin.jvm.PlatformType", ModelAuditLogEntry.CHANGE_KEY_COLOR, "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02041<T, R> implements Func1<Integer, Tuples2<? extends String, ? extends Bitmap>> {
                public final /* synthetic */ Bitmap $bitmap;
                public final /* synthetic */ String $url;

                public C02041(String str, Bitmap bitmap) {
                    this.$url = str;
                    this.$bitmap = bitmap;
                }

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Tuples2<? extends String, ? extends Bitmap> call(Integer num) {
                    return call2(num);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Tuples2<String, Bitmap> call2(Integer num) {
                    String str = this.$url;
                    MGImages mGImages = MGImages.INSTANCE;
                    Bitmap bitmap = this.$bitmap;
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    int i = anonymousClass1.$iconSize;
                    int i2 = anonymousClass1.$fullBitmapSize;
                    return Tuples.to(str, mGImages.centerBitmapInTransparentBitmap(bitmap, i, i, i2, i2, anonymousClass1.$fillMargins, num != null ? num.intValue() : 0));
                }
            }

            public C02031(RepresentativeColors representativeColors) {
                this.$representativeColors = representativeColors;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends String, ? extends Bitmap>> call(Map.Entry<? extends String, ? extends Bitmap> entry) {
                return call2((Map.Entry<String, Bitmap>) entry);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Tuples2<String, Bitmap>> call2(Map.Entry<String, Bitmap> entry) {
                Observable<R> scalarSynchronousObservable;
                String key = entry.getKey();
                Bitmap value = entry.getValue();
                if (value.getWidth() <= 0 || value.getHeight() <= 0 || value.getPixel(0, 0) != 0) {
                    scalarSynchronousObservable = new ScalarSynchronousObservable(0);
                } else {
                    RepresentativeColors.handleBitmap$default(this.$representativeColors, key, value, null, 4, null);
                    Observable<R> observableG = this.$representativeColors.observeRepresentativeColor(key).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                    Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
                    scalarSynchronousObservable = observableG.z().c0(2L, TimeUnit.SECONDS).M(ShareUtils$loadAdaptiveBitmaps$1$1$representativeColor$1.INSTANCE);
                }
                return scalarSynchronousObservable.G(new C02041(key, value));
            }
        }

        /* compiled from: ShareUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "bitmaps", "Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<Map<String, ? extends Bitmap>, MGImagesBitmap.CloseableBitmaps> {
            public final /* synthetic */ MGImagesBitmap.CloseableBitmaps $iconBitmaps;

            public AnonymousClass2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                this.$iconBitmaps = closeableBitmaps;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ MGImagesBitmap.CloseableBitmaps call(Map<String, ? extends Bitmap> map) {
                return call2((Map<String, Bitmap>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final MGImagesBitmap.CloseableBitmaps call2(Map<String, Bitmap> map) {
                this.$iconBitmaps.close();
                Intrinsics3.checkNotNullExpressionValue(map, "bitmaps");
                return new MGImagesBitmap.CloseableBitmaps(map, false);
            }
        }

        public AnonymousClass1(int i, int i2, int i3) {
            this.$iconSize = i;
            this.$fullBitmapSize = i2;
            this.$fillMargins = i3;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends MGImagesBitmap.CloseableBitmaps> call(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            return call2(closeableBitmaps);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends MGImagesBitmap.CloseableBitmaps> call2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            Observable<R> observableN = Observable.B(closeableBitmaps.entrySet()).n(new C02031(new RepresentativeColors()));
            Intrinsics3.checkNotNullExpressionValue(observableN, "Observable.from(iconBitm…        }\n              }");
            return ObservableExtensionsKt.toMap(observableN).G(new AnonymousClass2(closeableBitmaps));
        }
    }

    /* compiled from: ShareUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0002*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/utilities/ChannelShortcutInfo;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends Channel>, List<? extends ChannelShortcutInfo>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends ChannelShortcutInfo> call(List<? extends Channel> list) {
            return call2((List<Channel>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ChannelShortcutInfo> call2(List<Channel> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                arrayList.add(new ChannelShortcutInfo((Channel) t, i, false));
                i = i2;
            }
            return arrayList;
        }
    }

    /* compiled from: ShareUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends Channel>, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Map<Long, Channel> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "it");
            return Boolean.valueOf(!map.isEmpty());
        }
    }

    /* compiled from: ShareUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\r\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t \u0002*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00000\u00002\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002.\u0010\b\u001a*\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007 \u0002*\u0014\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"", "Lcom/discord/utilities/ChannelShortcutInfo;", "kotlin.jvm.PlatformType", "directShareChannels", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "channelsById", "Lkotlin/Pair;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, R> implements Func2<List<? extends ChannelShortcutInfo>, Map<Long, ? extends Channel>, List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>> {
        public final /* synthetic */ Context $context;

        public AnonymousClass3(Context context) {
            this.$context = context;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>> call(List<? extends ChannelShortcutInfo> list, Map<Long, ? extends Channel> map) {
            return call2((List<ChannelShortcutInfo>) list, (Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Tuples2<ChannelShortcutInfo, String>> call2(List<ChannelShortcutInfo> list, Map<Long, Channel> map) {
            Intrinsics3.checkNotNullExpressionValue(list, "directShareChannels");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((ChannelShortcutInfo) it.next()).getChannel().getId()));
            }
            Set set = _Collections.toSet(arrayList);
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
            Intrinsics3.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            List<ChannelShortcutInfo> listPlus = _Collections.plus((Collection) list, _Sequences2.map(_Sequences2.mapNotNull(_Sequences2.filter(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(dynamicShortcuts), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$1.INSTANCE), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2.INSTANCE), new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$3(set)), new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$4(map)), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5.INSTANCE));
            ArrayList arrayList2 = new ArrayList();
            for (ChannelShortcutInfo channelShortcutInfo : listPlus) {
                String forChannel$default = IconUtils.getForChannel$default(channelShortcutInfo.getChannel(), null, 2, null);
                Tuples2 tuples2 = forChannel$default != null ? Tuples.to(channelShortcutInfo, forChannel$default) : null;
                if (tuples2 != null) {
                    arrayList2.add(tuples2);
                }
            }
            return arrayList2;
        }
    }

    /* compiled from: ShareUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a¯\u0002\u0012\u008f\u0001\b\u0001\u0012\u008a\u0001\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001 \u0004*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*D\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001 \u0004*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00010\u0001 \u0004*\u0096\u0001\u0012\u008f\u0001\b\u0001\u0012\u008a\u0001\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001 \u0004*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*D\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001 \u0004*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00010\u0001\u0018\u00010\u00060\u000622\u0010\u0005\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001 \u0004*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Lkotlin/Pair;", "Lcom/discord/utilities/ChannelShortcutInfo;", "", "kotlin.jvm.PlatformType", "channelAndIconUriPairs", "Lrx/Observable;", "Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, Observable<? extends Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: ShareUtils.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\t\u001a\u008a\u0001\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003 \u0001*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001*D\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003 \u0001*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "kotlin.jvm.PlatformType", "it", "Lkotlin/Pair;", "", "Lcom/discord/utilities/ChannelShortcutInfo;", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02051<T, R> implements Func1<MGImagesBitmap.CloseableBitmaps, Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>> {
            public final /* synthetic */ List $channelAndIconUriPairs;

            public C02051(List list) {
                this.$channelAndIconUriPairs = list;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps> call(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                return call2(closeableBitmaps);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2<List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> call2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                return Tuples.to(this.$channelAndIconUriPairs, closeableBitmaps);
            }
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>> call(List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>> list) {
            return call2((List<Tuples2<ChannelShortcutInfo, String>>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Tuples2<List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>> call2(List<Tuples2<ChannelShortcutInfo, String>> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "channelAndIconUriPairs");
            return ShareUtils.INSTANCE.loadAdaptiveBitmaps(_Sequences2.map(_Collections.asSequence(list), ShareUtils$updateDirectShareTargets$1$uris$1.INSTANCE)).G(new C02051(list));
        }
    }

    /* compiled from: ShareUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u008f\u0001\u0010\u0006\u001a\u008a\u0001\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000 \u0004*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u0005 \u0004*D\u00120\u0012.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000 \u0004*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/Pair;", "", "Lcom/discord/utilities/ChannelShortcutInfo;", "", "kotlin.jvm.PlatformType", "Lcom/discord/utilities/images/MGImagesBitmap$CloseableBitmaps;", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps> tuples2) throws IOException {
            invoke2((Tuples2<? extends List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> tuples2) throws IOException {
            List<Tuples2<ChannelShortcutInfo, String>> listComponent1 = tuples2.component1();
            MGImagesBitmap.CloseableBitmaps closeableBitmapsComponent2 = tuples2.component2();
            try {
                ShareUtils shareUtils = ShareUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(listComponent1, "channelAndIconUriPairs");
                Context context = this.$context;
                Intrinsics3.checkNotNullExpressionValue(closeableBitmapsComponent2, "iconBitmaps");
                ShareUtils.access$updateDynamicShortcuts(shareUtils, listComponent1, context, closeableBitmapsComponent2);
                Closeable.closeFinally(closeableBitmapsComponent2, null);
            } finally {
            }
        }
    }

    /* compiled from: ShareUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Map<Long, ? extends Channel>, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Map<Long, Channel> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "it");
            return Boolean.valueOf(!map.isEmpty());
        }
    }

    /* compiled from: ShareUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channels", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Map<Long, ? extends Channel>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Channel> map) {
            invoke2((Map<Long, Channel>) map);
            return Unit.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2(Map<Long, Channel> map) {
            boolean z2;
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
            ArrayList<ShortcutInfoCompat> arrayListA0 = outline.a0(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            for (Object obj : dynamicShortcuts) {
                ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) obj;
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (shortcutInfoCompat.isPinned()) {
                    String id2 = shortcutInfoCompat.getId();
                    Intrinsics3.checkNotNullExpressionValue(id2, "it.id");
                    z2 = !map.containsKey(Long.valueOf(Long.parseLong(id2)));
                }
                if (z2) {
                    arrayListA0.add(obj);
                }
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayListA0, 10));
            for (ShortcutInfoCompat shortcutInfoCompat2 : arrayListA0) {
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat2, "it");
                arrayList.add(shortcutInfoCompat2.getId());
            }
            ShortcutManagerCompat.disableShortcuts(this.$context, arrayList, "The channels these shortcuts are for no longer exist.");
            ShortcutManagerCompat.removeLongLivedShortcuts(this.$context, arrayList);
        }
    }

    private ShareUtils() {
    }

    public static final /* synthetic */ void access$updateDynamicShortcuts(ShareUtils shareUtils, List list, Context context, MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
        shareUtils.updateDynamicShortcuts(list, context, closeableBitmaps);
    }

    public static /* synthetic */ void addShortcut$default(ShareUtils shareUtils, Context context, ShortcutInfoCompat shortcutInfoCompat, NotificationCompat.Builder builder, int i, Object obj) {
        if ((i & 4) != 0) {
            builder = null;
        }
        shareUtils.addShortcut(context, shortcutInfoCompat, builder);
    }

    private final Observable<List<Tuples2<ChannelShortcutInfo, String>>> observeChannelAndIconPairs(Context context) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableG = ObservableExtensionsKt.takeSingleUntilTimeout$default(companion.getChannels().observeDirectShareCandidates(context), 0L, false, 1, null).G(AnonymousClass1.INSTANCE);
        Observable<Map<Long, Channel>> observableY = companion.getChannels().observeGuildAndPrivateChannels().y(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …ilter { it.isNotEmpty() }");
        return Observable.j(observableG, ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 1, null), new AnonymousClass3(context));
    }

    public static /* synthetic */ ShortcutInfoCompat toShortcutInfo$default(ShareUtils shareUtils, Context context, long j, CharSequence charSequence, CharSequence charSequence2, IconCompat iconCompat, List list, int i, int i2, Object obj) {
        return shareUtils.toShortcutInfo(context, j, charSequence, (i2 & 8) != 0 ? charSequence : charSequence2, (i2 & 16) != 0 ? null : iconCompat, (i2 & 32) != 0 ? Collections2.emptyList() : list, (i2 & 64) != 0 ? 0 : i);
    }

    private final void updateDynamicShortcuts(List<Tuples2<ChannelShortcutInfo, String>> channelAndIconUriPairs, Context context, MGImagesBitmap.CloseableBitmaps iconBitmaps) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = channelAndIconUriPairs.iterator();
        while (it.hasNext()) {
            Tuples2 tuples2 = (Tuples2) it.next();
            Boolean boolValueOf = Boolean.valueOf(((ChannelShortcutInfo) tuples2.component1()).isPinnedOnly());
            Object arrayList = linkedHashMap.get(boolValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(boolValueOf, arrayList);
            }
            List list = (List) arrayList;
            ChannelShortcutInfo channelShortcutInfo = (ChannelShortcutInfo) tuples2.component1();
            String str = (String) tuples2.component2();
            ShareUtils shareUtils = INSTANCE;
            Channel channel = channelShortcutInfo.getChannel();
            Bitmap bitmap = (Bitmap) iconBitmaps.get((Object) str);
            list.add(shareUtils.toShortcutInfo(channel, context, bitmap != null ? IconCompat.createWithAdaptiveBitmap(bitmap) : null, channelShortcutInfo.getRank()));
        }
        Object objEmptyList = linkedHashMap.get(Boolean.FALSE);
        if (objEmptyList == null) {
            objEmptyList = Collections2.emptyList();
        }
        List list2 = (List) objEmptyList;
        Object objEmptyList2 = linkedHashMap.get(Boolean.TRUE);
        if (objEmptyList2 == null) {
            objEmptyList2 = Collections2.emptyList();
        }
        ShortcutManagerCompat.setDynamicShortcuts(context, list2);
        ShortcutManagerCompat.updateShortcuts(context, (List) objEmptyList2);
    }

    public final void addShortcut(Context context, ShortcutInfoCompat shortcutInfo, NotificationCompat.Builder notificationBuilder) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        if (notificationBuilder != null) {
            notificationBuilder.setShortcutId(shortcutInfo.getId());
        }
        if (notificationBuilder != null) {
            notificationBuilder.setLocusId(new LocusIdCompat(shortcutInfo.getId()));
        }
        List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(context);
        Intrinsics3.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
        boolean z2 = false;
        if (!(dynamicShortcuts instanceof Collection) || !dynamicShortcuts.isEmpty()) {
            Iterator<T> it = dynamicShortcuts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) it.next();
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (Intrinsics3.areEqual(shortcutInfoCompat.getId(), shortcutInfo.getId())) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            return;
        }
        ShortcutManagerCompat.pushDynamicShortcut(context, shortcutInfo);
    }

    public final SharedContent getSharedContent(Intent intent, boolean deleteExtras) {
        Uri uri;
        Intrinsics3.checkNotNullParameter(intent, "intent");
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
        ArrayList arrayListArrayListOf = null;
        if (charSequenceExtra == null || StringsJVM.isBlank(charSequenceExtra)) {
            charSequenceExtra = !(stringExtra == null || StringsJVM.isBlank(stringExtra)) ? stringExtra : null;
        }
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1173264947) {
                if (iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE")) {
                    arrayListArrayListOf = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                }
            } else if (action.equals("android.intent.action.SEND") && (uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) != null) {
                arrayListArrayListOf = Collections2.arrayListOf(uri);
            }
        }
        if (deleteExtras) {
            intent.removeExtra("android.intent.extra.TEXT");
            intent.removeExtra("android.intent.extra.SUBJECT");
            intent.removeExtra("android.intent.extra.STREAM");
        }
        return new SharedContent(charSequenceExtra, arrayListArrayListOf);
    }

    public final Observable<MGImagesBitmap.CloseableBitmaps> loadAdaptiveBitmaps(Sequence<String> iconUris) {
        Intrinsics3.checkNotNullParameter(iconUris, "iconUris");
        int iDpToPixels = DimenUtils.dpToPixels(72);
        int iDpToPixels2 = DimenUtils.dpToPixels(108);
        int iDpToPixels3 = DimenUtils.dpToPixels(18);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = iconUris.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(new MGImagesBitmap.ImageRequest(it.next(), false));
        }
        Observable observableA = MGImagesBitmap.getBitmaps(linkedHashSet).A(new AnonymousClass1(iDpToPixels, iDpToPixels2, iDpToPixels3));
        Intrinsics3.checkNotNullExpressionValue(observableA, "MGImagesBitmap\n        .…              }\n        }");
        return observableA;
    }

    public final ShortcutInfoCompat toShortcutInfo(Context context, long channelId, CharSequence shortLabel, CharSequence longLabel, IconCompat icon, List<? extends Person> persons, int rank) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(shortLabel, "shortLabel");
        Intrinsics3.checkNotNullParameter(longLabel, "longLabel");
        Intrinsics3.checkNotNullParameter(persons, "persons");
        ShortcutInfoCompat.Builder categories = new ShortcutInfoCompat.Builder(context, String.valueOf(channelId)).setLocusId(new LocusIdCompat(String.valueOf(channelId))).setShortLabel(shortLabel).setLongLabel(longLabel).setIcon(icon).setIntent(IntentUtils.RouteBuilders.selectChannel$default(channelId, 0L, null, 6, null).setPackage(context.getPackageName())).setRank(rank).setLongLived(true).setCategories(Sets5.setOf((Object[]) new String[]{"com.discord.intent.category.DIRECT_SHARE_TARGET", "android.shortcut.conversation"}));
        Object[] array = persons.toArray(new Person[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ShortcutInfoCompat shortcutInfoCompatBuild = categories.setPersons((Person[]) array).build();
        Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompatBuild, "ShortcutInfoCompat.Build…ray())\n          .build()");
        return shortcutInfoCompatBuild;
    }

    public final void updateDirectShareTargets(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Observable<List<Tuples2<ChannelShortcutInfo, String>>> observableObserveChannelAndIconPairs = observeChannelAndIconPairs(context);
        Intrinsics3.checkNotNullExpressionValue(observableObserveChannelAndIconPairs, "observeChannelAndIconPairs(context)");
        Observable observableA = ObservableExtensionsKt.computationLatest(observableObserveChannelAndIconPairs).A(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableA, "observeChannelAndIconPai…riPairs to it }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableA), ShareUtils.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(context), 60, (Object) null);
        Observable<Map<Long, Channel>> observableY = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels().y(AnonymousClass3.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…ilter { it.isNotEmpty() }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 1, null)), ShareUtils.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(context), 60, (Object) null);
    }

    private final ShortcutInfoCompat toShortcutInfo(Channel channel, Context context, IconCompat iconCompat, int i) {
        long id2 = channel.getId();
        String strC = ChannelUtils.c(channel);
        List<User> listG = ChannelUtils.g(channel);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listG, 10));
        for (User user : listG) {
            Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(user.toString()).setBot(user.getIsBot()).build();
            Intrinsics3.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …\n                .build()");
            arrayList.add(personBuild);
        }
        return toShortcutInfo$default(this, context, id2, strC, null, iconCompat, arrayList, i, 8, null);
    }
}
