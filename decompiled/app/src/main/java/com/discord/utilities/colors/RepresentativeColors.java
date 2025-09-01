package com.discord.utilities.colors;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import b.a.g.ColorCutQuantizer;
import b.a.g.ColorHistogram;
import b.a.g.Swatch;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Result3;
import d0.Tuples;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* compiled from: RepresentativeColors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003&'(B\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aRj\u0010\u001e\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b \u001d*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c0\u001c \u001d**\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b \u001d*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u001c0\u001c\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR2\u0010\"\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0 j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b`!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/discord/utilities/colors/RepresentativeColors;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/graphics/Bitmap;", "bitmap", "Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult;", "getRepresentativeColor", "(Landroid/graphics/Bitmap;)Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult;", "", "c1", "c2", "getColorDistance", "(II)I", "", "getPrimaryColorsForBitmap", "(Landroid/graphics/Bitmap;)Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_ID, "Lrx/Observable;", "observeRepresentativeColor", "(Ljava/lang/Object;)Lrx/Observable;", "", "url", "", "handleBitmap", "(Ljava/lang/Object;Landroid/graphics/Bitmap;Ljava/lang/String;)V", "getRepresentativeColorAsync", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "representativeColorsSubject", "Lrx/subjects/BehaviorSubject;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "representativeColors", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "NoSwatchesFoundException", "RepresentativeColorResult", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RepresentativeColors<T> {
    private final HashMap<T, Integer> representativeColors = new HashMap<>();
    private final BehaviorSubject<Map<T, Integer>> representativeColorsSubject = BehaviorSubject.k0();
    private static final int BLURPLE = Color.parseColor("#5865f2");

    /* compiled from: RepresentativeColors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/colors/RepresentativeColors$NoSwatchesFoundException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class NoSwatchesFoundException extends RuntimeException {
    }

    /* compiled from: RepresentativeColors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult;", "", "<init>", "()V", "Failure", "Success", "Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult$Success;", "Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult$Failure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class RepresentativeColorResult {

        /* compiled from: RepresentativeColors.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult$Failure;", "Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "component1", "()Ljava/lang/Exception;", "exception", "copy", "(Ljava/lang/Exception;)Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult$Failure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Exception;", "getException", "<init>", "(Ljava/lang/Exception;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Failure extends RepresentativeColorResult {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(Exception exc) {
                super(null);
                Intrinsics3.checkNotNullParameter(exc, "exception");
                this.exception = exc;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, Exception exc, int i, Object obj) {
                if ((i & 1) != 0) {
                    exc = failure.exception;
                }
                return failure.copy(exc);
            }

            /* renamed from: component1, reason: from getter */
            public final Exception getException() {
                return this.exception;
            }

            public final Failure copy(Exception exception) {
                Intrinsics3.checkNotNullParameter(exception, "exception");
                return new Failure(exception);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Failure) && Intrinsics3.areEqual(this.exception, ((Failure) other).exception);
                }
                return true;
            }

            public final Exception getException() {
                return this.exception;
            }

            public int hashCode() {
                Exception exc = this.exception;
                if (exc != null) {
                    return exc.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Failure(exception=");
                sbU.append(this.exception);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: RepresentativeColors.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult$Success;", "Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult;", "", "component1", "()I", ModelAuditLogEntry.CHANGE_KEY_COLOR, "copy", "(I)Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult$Success;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getColor", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Success extends RepresentativeColorResult {
            private final int color;

            public Success(@ColorInt int i) {
                super(null);
                this.color = i;
            }

            public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = success.color;
                }
                return success.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getColor() {
                return this.color;
            }

            public final Success copy(@ColorInt int color) {
                return new Success(color);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && this.color == ((Success) other).color;
                }
                return true;
            }

            public final int getColor() {
                return this.color;
            }

            public int hashCode() {
                return this.color;
            }

            public String toString() {
                return outline.B(outline.U("Success(color="), this.color, ")");
            }
        }

        private RepresentativeColorResult() {
        }

        public /* synthetic */ RepresentativeColorResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RepresentativeColors.kt */
    @DebugMetadata(c = "com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2", f = "RepresentativeColors.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "Lcom/discord/utilities/colors/RepresentativeColors$RepresentativeColorResult;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super RepresentativeColorResult>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Bitmap bitmap, Continuation continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass2(this.$bitmap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RepresentativeColorResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return RepresentativeColors.access$getRepresentativeColor(RepresentativeColors.this, this.$bitmap);
        }
    }

    /* compiled from: RepresentativeColors.kt */
    @DebugMetadata(c = "com.discord.utilities.colors.RepresentativeColors$handleBitmap$1", f = "RepresentativeColors.kt", l = {59}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.colors.RepresentativeColors$handleBitmap$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public final /* synthetic */ Object $id;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Object obj, Bitmap bitmap, String str, Continuation continuation) {
            super(2, continuation);
            this.$id = obj;
            this.$bitmap = bitmap;
            this.$url = str;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$id, this.$bitmap, this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iAccess$getBLURPLE$cp;
            int iAccess$getBLURPLE$cp2;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                if (RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this).containsKey(this.$id)) {
                    return Unit.a;
                }
                if (this.$bitmap.isRecycled()) {
                    iAccess$getBLURPLE$cp = RepresentativeColors.access$getBLURPLE$cp();
                    RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this).put(this.$id, boxing.boxInt(iAccess$getBLURPLE$cp));
                    RepresentativeColors.access$getRepresentativeColorsSubject$p(RepresentativeColors.this).onNext(RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this));
                    return Unit.a;
                }
                Bitmap bitmapCopy = this.$bitmap.copy(Bitmap.Config.ARGB_8888, false);
                RepresentativeColors representativeColors = RepresentativeColors.this;
                Intrinsics3.checkNotNullExpressionValue(bitmapCopy, "copiedBitmap");
                this.label = 1;
                obj = representativeColors.getRepresentativeColorAsync(bitmapCopy, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            RepresentativeColorResult representativeColorResult = (RepresentativeColorResult) obj;
            if (representativeColorResult instanceof RepresentativeColorResult.Success) {
                iAccess$getBLURPLE$cp2 = ((RepresentativeColorResult.Success) representativeColorResult).getColor();
            } else {
                if (!(representativeColorResult instanceof RepresentativeColorResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                iAccess$getBLURPLE$cp2 = RepresentativeColors.access$getBLURPLE$cp();
            }
            if (representativeColorResult instanceof RepresentativeColorResult.Failure) {
                AppLog appLog = AppLog.g;
                Exception exception = ((RepresentativeColorResult.Failure) representativeColorResult).getException();
                Tuples2[] tuples2Arr = new Tuples2[4];
                tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_ID, String.valueOf(this.$id));
                tuples2Arr[1] = Tuples.to("bitmapWidth", String.valueOf(this.$bitmap.getWidth()));
                tuples2Arr[2] = Tuples.to("bitmapHeight", String.valueOf(this.$bitmap.getHeight()));
                String str = this.$url;
                if (str == null) {
                    str = "not provided";
                }
                tuples2Arr[3] = Tuples.to("url", str);
                appLog.e("Failed to get representative color for entity", exception, Maps6.mapOf(tuples2Arr));
            }
            iAccess$getBLURPLE$cp = iAccess$getBLURPLE$cp2;
            RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this).put(this.$id, boxing.boxInt(iAccess$getBLURPLE$cp));
            RepresentativeColors.access$getRepresentativeColorsSubject$p(RepresentativeColors.this).onNext(RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this));
            return Unit.a;
        }
    }

    /* compiled from: RepresentativeColors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\u0010\u0007\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u00002&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.colors.RepresentativeColors$observeRepresentativeColor$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<T, ? extends Integer>, Integer> {
        public final /* synthetic */ Object $id;

        public AnonymousClass1(Object obj) {
            this.$id = obj;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Integer call(Object obj) {
            return call((Map) obj);
        }

        public final Integer call(Map<T, Integer> map) {
            return map.get(this.$id);
        }
    }

    public static final /* synthetic */ int access$getBLURPLE$cp() {
        return BLURPLE;
    }

    public static final /* synthetic */ RepresentativeColorResult access$getRepresentativeColor(RepresentativeColors representativeColors, Bitmap bitmap) {
        return representativeColors.getRepresentativeColor(bitmap);
    }

    public static final /* synthetic */ HashMap access$getRepresentativeColors$p(RepresentativeColors representativeColors) {
        return representativeColors.representativeColors;
    }

    public static final /* synthetic */ BehaviorSubject access$getRepresentativeColorsSubject$p(RepresentativeColors representativeColors) {
        return representativeColors.representativeColorsSubject;
    }

    private final int getColorDistance(int c1, int c2) {
        int i = ((c1 >> 16) & 255) - ((c2 >> 16) & 255);
        int i2 = ((c1 >> 8) & 255) - ((c2 >> 8) & 255);
        int i3 = (c1 & 255) - (c2 & 255);
        return Math.abs((i3 * i3) + (i2 * i2) + (i * i));
    }

    private final List<Integer> getPrimaryColorsForBitmap(Bitmap bitmap) {
        ColorCutQuantizer.b bVar = ColorCutQuantizer.a;
        Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        List<Swatch> list = new ColorCutQuantizer(new ColorHistogram(iArr), 2, null).e;
        if (!list.isEmpty()) {
            return CollectionsJVM.listOf(Integer.valueOf(list.get(0).d));
        }
        throw new NoSwatchesFoundException();
    }

    private final RepresentativeColorResult getRepresentativeColor(Bitmap bitmap) {
        try {
            int alphaComponent = ColorUtils.setAlphaComponent(getPrimaryColorsForBitmap(bitmap).get(0).intValue(), 255);
            int i = Integer.MAX_VALUE;
            int width = bitmap.getWidth();
            int i2 = alphaComponent;
            for (int i3 = 0; i3 < width; i3++) {
                int height = bitmap.getHeight();
                for (int i4 = 0; i4 < height; i4++) {
                    int alphaComponent2 = ColorUtils.setAlphaComponent(bitmap.getPixel(i3, i4), 255);
                    int colorDistance = getColorDistance(alphaComponent, alphaComponent2);
                    if (colorDistance < i) {
                        i2 = alphaComponent2;
                        i = colorDistance;
                    }
                }
            }
            return new RepresentativeColorResult.Success(i2);
        } catch (Exception e) {
            return new RepresentativeColorResult.Failure(e);
        }
    }

    public static /* synthetic */ void handleBitmap$default(RepresentativeColors representativeColors, Object obj, Bitmap bitmap, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            str = null;
        }
        representativeColors.handleBitmap(obj, bitmap, str);
    }

    public final Object getRepresentativeColorAsync(Bitmap bitmap, Continuation<? super RepresentativeColorResult> continuation) {
        return f.C1(Dispatchers.a, new AnonymousClass2(bitmap, null), continuation);
    }

    public final void handleBitmap(T id2, Bitmap bitmap, String url) {
        Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
        CoroutineScope2 coroutineScope2 = CoroutineScope2.j;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        f.H0(coroutineScope2, MainDispatchers.f3830b, null, new AnonymousClass1(id2, bitmap, url, null), 2, null);
    }

    public final Observable<Integer> observeRepresentativeColor(T id2) {
        Observable<Integer> observableR = this.representativeColorsSubject.G(new AnonymousClass1(id2)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "representativeColorsSubj…  .distinctUntilChanged()");
        return observableR;
    }
}
