package b.i.a.f.e.o;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.WorkerThread;
import androidx.media.AudioAttributesCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.h.l.a3;
import b.i.a.f.h.l.b5;
import b.i.a.f.h.l.b7;
import b.i.a.f.h.l.c3;
import b.i.a.f.h.l.c6;
import b.i.a.f.h.l.c7;
import b.i.a.f.h.l.d2;
import b.i.a.f.h.l.e6;
import b.i.a.f.h.l.k7;
import b.i.a.f.h.l.q6;
import b.i.a.f.h.l.s3;
import b.i.a.f.h.l.t3;
import b.i.a.f.h.l.u4;
import b.i.a.f.h.l.w4;
import b.i.a.f.h.l.x4;
import b.i.a.f.h.l.z2;
import b.i.a.f.h.l.z3;
import b.i.a.f.i.b.ga;
import b.i.a.f.i.b.q3;
import b.i.a.f.n.c0;
import b.i.a.f.n.d0;
import b.i.a.f.n.j;
import b.i.a.g.d.TimeSource;
import b.i.a.g.d.UtcDates;
import b.i.b.b.Collections2;
import b.i.b.b.Sets2;
import b.i.b.c.Ints;
import b.i.c.l.Component3;
import b.i.c.l.Component4;
import b.i.c.l.Dependency2;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.k.ExecutorUtils;
import b.i.c.m.d.k.ExecutorUtils2;
import b.i.c.x.AutoValue_LibraryVersion;
import b.i.c.x.LibraryVersion;
import b.i.c.x.LibraryVersionComponent;
import b.i.c.x.LibraryVersionComponent2;
import b.i.d.JsonNull;
import b.o.a.n.o.BaseAction;
import b.o.a.n.o.TogetherAction;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import b.o.a.x.SizeSelector;
import b.o.a.x.SizeSelectors6;
import b.o.a.x.SizeSelectors7;
import b.o.a.x.SizeSelectors8;
import b.o.a.x.SizeSelectors9;
import b.p.a.Alert2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.appindexing.FirebaseAppIndexingException;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.FirebaseAppIndexingTooManyArgumentsException;
import com.google.firebase.appindexing.zza;
import com.google.firebase.appindexing.zzb;
import com.google.firebase.appindexing.zzc;
import com.google.firebase.appindexing.zzd;
import com.google.firebase.appindexing.zze;
import com.google.firebase.appindexing.zzf;
import com.google.firebase.appindexing.zzg;
import com.google.firebase.appindexing.zzh;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.Exceptions;
import d0.Result2;
import d0.Result3;
import d0.d0._Ranges;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.w.ContinuationInterceptor;
import d0.w.CoroutineContextImpl4;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import d0.z.d.TypeIntrinsics;
import f0.e0.Util7;
import f0.e0.f.Task2;
import f0.e0.f.TaskQueue2;
import f0.e0.f.TaskRunner;
import g0.AsyncTimeout2;
import g0.AsyncTimeout3;
import g0.Buffer3;
import g0.JvmOkio;
import g0.JvmOkio2;
import g0.JvmOkio3;
import g0.SegmentedByteString;
import g0.Sink;
import g0.Source2;
import g0.z.ByteString4;
import h0.a.a.ByteVector2;
import j0.Observer2;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.objectweb.asm.Opcodes;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.OnErrorThrowable;
import s.a.AbstractCoroutine;
import s.a.Await;
import s.a.CancellableContinuationImpl2;
import s.a.CancellableContinuationImpl5;
import s.a.CancellableContinuationImpl8;
import s.a.CompletableJob;
import s.a.CompletionState2;
import s.a.CompletionState3;
import s.a.CoroutineContext2;
import s.a.CoroutineExceptionHandlerImpl;
import s.a.DefaultExecutor2;
import s.a.Deferred;
import s.a.Delay;
import s.a.DispatchedTask;
import s.a.Dispatchers;
import s.a.Job2;
import s.a.Supervisor;
import s.a.a.DispatchedContinuation;
import s.a.a.DispatchedContinuation2;
import s.a.a.Scopes;
import s.a.a.Scopes2;
import s.a.a.SystemProps;
import s.a.a.ThreadContext;
import s.a.c2.ArrayChannel;
import s.a.c2.BufferOverflow;
import s.a.c2.Channel4;
import s.a.c2.Channel6;
import s.a.c2.Channel7;
import s.a.c2.Channel8;
import s.a.c2.ConflatedChannel;
import s.a.c2.LinkedListChannel;
import s.a.c2.RendezvousChannel;
import s.a.d2.FlowCollector;
import s.a.f1;
import s.a.g0;
import s.a.i0;
import s.a.i1;
import s.a.j1;
import s.a.k1;
import s.a.t1;
import s.a.z1;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public final class f {
    public static Context a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Boolean f1397b;
    public static ga c;

    /* compiled from: SizeSelectors.java */
    public class a implements SizeSelectors7 {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // b.o.a.x.SizeSelectors7
        public boolean a(@NonNull Size3 size3) {
            return size3.j <= this.a;
        }
    }

    /* compiled from: SizeSelectors.java */
    public class b implements SizeSelectors7 {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // b.o.a.x.SizeSelectors7
        public boolean a(@NonNull Size3 size3) {
            return size3.j >= this.a;
        }
    }

    /* compiled from: SizeSelectors.java */
    public class c implements SizeSelectors7 {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // b.o.a.x.SizeSelectors7
        public boolean a(@NonNull Size3 size3) {
            return size3.k <= this.a;
        }
    }

    /* compiled from: SizeSelectors.java */
    public class d implements SizeSelectors7 {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // b.o.a.x.SizeSelectors7
        public boolean a(@NonNull Size3 size3) {
            return size3.k >= this.a;
        }
    }

    /* compiled from: Await.kt */
    @DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {26}, m = "awaitAll")
    public static final class e extends ContinuationImpl3 {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public e(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.l(null, this);
        }
    }

    /* compiled from: Channels.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {50, 61}, m = "emitAllImpl$FlowKt__ChannelsKt")
    /* renamed from: b.i.a.f.e.o.f$f, reason: collision with other inner class name */
    public static final class C0039f extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C0039f(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.U(null, null, false, this);
        }
    }

    /* compiled from: KotlinExtensions.kt */
    public static final class g implements Runnable {
        public final /* synthetic */ Continuation j;
        public final /* synthetic */ Exception k;

        public g(Continuation continuation, Exception exc) {
            this.j = continuation;
            this.k = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Continuation continuationIntercepted = IntrinsicsJvm.intercepted(this.j);
            Exception exc = this.k;
            Result2.a aVar = Result2.j;
            continuationIntercepted.resumeWith(Result2.m97constructorimpl(Result3.createFailure(exc)));
        }
    }

    /* compiled from: KotlinExtensions.kt */
    @DebugMetadata(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
    public static final class h extends ContinuationImpl3 {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public h(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.i1(null, this);
        }
    }

    @CanIgnoreReturnValue
    public static int A(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static boolean A0() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean A1(long j) {
        if (j >= 0) {
            return j != 0;
        }
        throw new IllegalArgumentException(outline.t("n >= 0 required but it was ", j));
    }

    public static final void B(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final boolean B0(int i) {
        return i == 1 || i == 2;
    }

    @NonNull
    public static Task<Void> B1(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return Z(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next(), "null tasks are not accepted");
        }
        c0 c0Var = new c0();
        j jVar = new j(collection.size(), c0Var);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            p2(it2.next(), jVar);
        }
        return c0Var;
    }

    @CanIgnoreReturnValue
    public static int C(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m(i, i2, "index"));
        }
        return i;
    }

    public static boolean C0(Camera camera) {
        List<String> supportedFlashModes;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && !supportedFlashModes.isEmpty() && (supportedFlashModes.size() != 1 || !supportedFlashModes.get(0).equals("off"))) {
                return true;
            }
        }
        return false;
    }

    public static final <T> Object C1(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        boolean z2;
        Object objA;
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContextPlus = context.plus(coroutineContext);
        Job job = (Job) coroutineContextPlus.get(Job.INSTANCE);
        if (job != null && !job.a()) {
            throw job.q();
        }
        if (coroutineContextPlus == context) {
            Scopes2 scopes2 = new Scopes2(coroutineContextPlus, continuation);
            objA = g1(scopes2, scopes2, function2);
        } else {
            int i = ContinuationInterceptor.e;
            ContinuationInterceptor.b bVar = ContinuationInterceptor.b.a;
            if (Intrinsics3.areEqual((ContinuationInterceptor) coroutineContextPlus.get(bVar), (ContinuationInterceptor) context.get(bVar))) {
                z1 z1Var = new z1(coroutineContextPlus, continuation);
                Object objB = ThreadContext.b(coroutineContextPlus, null);
                try {
                    Object objG1 = g1(z1Var, z1Var, function2);
                    ThreadContext.a(coroutineContextPlus, objB);
                    objA = objG1;
                } catch (Throwable th) {
                    ThreadContext.a(coroutineContextPlus, objB);
                    throw th;
                }
            } else {
                i0 i0Var = new i0(coroutineContextPlus, continuation);
                i0Var.f0();
                f1(function2, i0Var, i0Var, null, 4);
                while (true) {
                    int i2 = i0Var._decision;
                    z2 = false;
                    if (i2 != 0) {
                        if (i2 != 2) {
                            throw new IllegalStateException("Already suspended".toString());
                        }
                    } else if (i0.n.compareAndSet(i0Var, 0, 1)) {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    objA = Intrinsics2.getCOROUTINE_SUSPENDED();
                } else {
                    objA = i1.a(i0Var.M());
                    if (objA instanceof CompletionState2) {
                        throw ((CompletionState2) objA).f3846b;
                    }
                }
            }
        }
        if (objA == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objA;
    }

    public static void D(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? m(i, i3, "start index") : (i2 < 0 || i2 > i3) ? m(i2, i3, "end index") : I0("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static boolean D0(@RecentlyNonNull Context context, int i) throws PackageManager.NameNotFoundException {
        if (!z1(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
            b.i.a.f.e.f fVarA = b.i.a.f.e.f.a(context);
            Objects.requireNonNull(fVarA);
            if (packageInfo == null) {
                return false;
            }
            if (!b.i.a.f.e.f.d(packageInfo, false)) {
                if (!b.i.a.f.e.f.d(packageInfo, true)) {
                    return false;
                }
                if (!b.i.a.f.e.e.a(fVarA.f1348b)) {
                    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @NonNull
    public static SizeSelector D1(@NonNull SizeSelectors7 sizeSelectors7) {
        return new SizeSelectors8(sizeSelectors7, null);
    }

    public static void E(boolean z2) {
        if (!z2) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    public static synchronized boolean E0(@RecentlyNonNull Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = a;
        if (context2 != null && (bool = f1397b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f1397b = null;
        if (A0()) {
            f1397b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f1397b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f1397b = Boolean.FALSE;
            }
        }
        a = applicationContext;
        return f1397b.booleanValue();
    }

    public static <T> Class<T> E1(Class<T> cls) {
        return cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Byte.TYPE ? Byte.class : cls == Double.TYPE ? Double.class : cls == Long.TYPE ? Long.class : cls == Character.TYPE ? Character.class : cls == Boolean.TYPE ? Boolean.class : cls == Short.TYPE ? Short.class : cls == Void.TYPE ? Void.class : cls;
    }

    public static void F(boolean z2, @NullableDecl String str, int i) {
        if (!z2) {
            throw new IllegalStateException(I0(str, Integer.valueOf(i)));
        }
    }

    public static final boolean F0(Buffer3 buffer3) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "$this$isProbablyUtf8");
        try {
            Buffer3 buffer32 = new Buffer3();
            buffer3.n(buffer32, 0L, _Ranges.coerceAtMost(buffer3.k, 64L));
            for (int i = 0; i < 16; i++) {
                if (buffer32.w()) {
                    return true;
                }
                int I = buffer32.I();
                if (Character.isISOControl(I) && !Character.isWhitespace(I)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static int F1(int i, int i2, @NullableDecl String str) {
        String strL2;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strL2 = l2("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException(outline.g(26, "negative size: ", i2));
            }
            strL2 = l2("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strL2);
    }

    public static void G(boolean z2, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(I0(str, obj));
        }
    }

    public static final Job G0(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        CoroutineContext coroutineContextA = CoroutineContext2.a(coroutineScope, coroutineContext);
        Objects.requireNonNull(coroutineStart);
        AbstractCoroutine k1Var = coroutineStart == CoroutineStart.LAZY ? new k1(coroutineContextA, function2) : new t1(coroutineContextA, true);
        k1Var.j0(coroutineStart, k1Var, function2);
        return k1Var;
    }

    public static int G1(int i, byte[] bArr, int i2, int i3, s3 s3Var) throws zzij {
        if ((i >>> 3) == 0) {
            throw zzij.c();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return n2(bArr, i2, s3Var);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return O1(bArr, i2, s3Var) + s3Var.a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzij.c();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = O1(bArr, i2, s3Var);
            i6 = s3Var.a;
            if (i6 == i5) {
                break;
            }
            i2 = G1(i6, bArr, i2, i3, s3Var);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzij.d();
        }
        return i2;
    }

    public static int H(long j) {
        int i = (int) j;
        if (((long) i) == j) {
            return i;
        }
        throw new IllegalArgumentException(I0("Out of range: %s", Long.valueOf(j)));
    }

    public static /* synthetic */ Job H0(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextImpl4.j;
        }
        return G0(coroutineScope, coroutineContext, (i & 2) != 0 ? CoroutineStart.DEFAULT : null, function2);
    }

    public static int H1(int i, byte[] bArr, int i2, int i3, b5<?> b5Var, s3 s3Var) {
        x4 x4Var = (x4) b5Var;
        int iO1 = O1(bArr, i2, s3Var);
        x4Var.g(s3Var.a);
        while (iO1 < i3) {
            int iO12 = O1(bArr, iO1, s3Var);
            if (i != s3Var.a) {
                break;
            }
            iO1 = O1(bArr, iO12, s3Var);
            x4Var.g(s3Var.a);
        }
        return iO1;
    }

    public static /* synthetic */ boolean I(Channel7 channel7, Throwable th, int i, Object obj) {
        int i2 = i & 1;
        return channel7.j(null);
    }

    public static String I0(@NullableDecl String str, @NullableDecl Object... objArr) {
        int iIndexOf;
        String strValueOf;
        String strValueOf2 = String.valueOf(str);
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            try {
                strValueOf = String.valueOf(obj);
            } catch (Exception e2) {
                String str2 = obj.getClass().getName() + MentionUtils.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(obj));
                Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e2);
                strValueOf = "<" + str2 + " threw " + e2.getClass().getName() + ">";
            }
            objArr[i2] = strValueOf;
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf2.length());
        int i3 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf2.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) strValueOf2, i3, iIndexOf);
            sb.append(objArr[i]);
            i3 = iIndexOf + 2;
            i++;
        }
        sb.append((CharSequence) strValueOf2, i3, strValueOf2.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static int I1(int i, byte[] bArr, int i2, int i3, c7 c7Var, s3 s3Var) throws zzij {
        if ((i >>> 3) == 0) {
            throw zzij.c();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iN2 = n2(bArr, i2, s3Var);
            c7Var.a(i, Long.valueOf(s3Var.f1493b));
            return iN2;
        }
        if (i4 == 1) {
            c7Var.a(i, Long.valueOf(o2(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iO1 = O1(bArr, i2, s3Var);
            int i5 = s3Var.a;
            if (i5 < 0) {
                throw zzij.b();
            }
            if (i5 > bArr.length - iO1) {
                throw zzij.a();
            }
            if (i5 == 0) {
                c7Var.a(i, t3.j);
            } else {
                c7Var.a(i, t3.h(bArr, iO1, i5));
            }
            return iO1 + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzij.c();
            }
            c7Var.a(i, Integer.valueOf(N1(bArr, i2)));
            return i2 + 4;
        }
        c7 c7VarC = c7.c();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iO12 = O1(bArr, i2, s3Var);
            int i8 = s3Var.a;
            if (i8 == i6) {
                i7 = i8;
                i2 = iO12;
                break;
            }
            i7 = i8;
            i2 = I1(i8, bArr, iO12, i3, c7VarC, s3Var);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzij.d();
        }
        c7Var.a(i, c7VarC);
        return i2;
    }

    public static int J(int i, int i2) {
        int i3 = i - i2;
        if (i3 > i2) {
            i3 = i2;
            i2 = i3;
        }
        int i4 = 1;
        int i5 = 1;
        while (i > i2) {
            i4 *= i;
            if (i5 <= i3) {
                i4 /= i5;
                i5++;
            }
            i--;
        }
        while (i5 <= i3) {
            i4 /= i5;
            i5++;
        }
        return i4;
    }

    public static final float[] J0(float[] fArr) {
        Intrinsics3.checkNotNullParameter(fArr, "matrix");
        return (float[]) fArr.clone();
    }

    public static int J1(int i, byte[] bArr, int i2, s3 s3Var) {
        int i3 = i & Opcodes.LAND;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            s3Var.a = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & 127) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            s3Var.a = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            s3Var.a = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            s3Var.a = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                s3Var.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static final byte[] K(String str) {
        int i;
        int i2;
        char cCharAt;
        Intrinsics3.checkParameterIsNotNull(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 >= 128) {
                int length2 = str.length();
                int i4 = i3;
                while (i3 < length2) {
                    char cCharAt3 = str.charAt(i3);
                    if (cCharAt3 < 128) {
                        int i5 = i4 + 1;
                        bArr[i4] = (byte) cCharAt3;
                        i3++;
                        while (i3 < length2 && str.charAt(i3) < 128) {
                            bArr[i5] = (byte) str.charAt(i3);
                            i3++;
                            i5++;
                        }
                        i4 = i5;
                    } else {
                        if (cCharAt3 < 2048) {
                            int i6 = i4 + 1;
                            bArr[i4] = (byte) ((cCharAt3 >> 6) | Opcodes.CHECKCAST);
                            byte b2 = (byte) ((cCharAt3 & '?') | 128);
                            i = i6 + 1;
                            bArr[i6] = b2;
                        } else if (55296 > cCharAt3 || 57343 < cCharAt3) {
                            int i7 = i4 + 1;
                            bArr[i4] = (byte) ((cCharAt3 >> '\f') | 224);
                            int i8 = i7 + 1;
                            bArr[i7] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            byte b3 = (byte) ((cCharAt3 & '?') | 128);
                            i = i8 + 1;
                            bArr[i8] = b3;
                        } else if (cCharAt3 > 56319 || length2 <= (i2 = i3 + 1) || 56320 > (cCharAt = str.charAt(i2)) || 57343 < cCharAt) {
                            i = i4 + 1;
                            bArr[i4] = 63;
                        } else {
                            int iCharAt = (str.charAt(i2) + (cCharAt3 << '\n')) - 56613888;
                            int i9 = i4 + 1;
                            bArr[i4] = (byte) ((iCharAt >> 18) | 240);
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((iCharAt >> 12) & 63) | 128);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i = i11 + 1;
                            bArr[i11] = (byte) ((iCharAt & 63) | 128);
                            i3 += 2;
                            i4 = i;
                        }
                        i3++;
                        i4 = i;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i4);
                Intrinsics3.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i3] = (byte) cCharAt2;
            i3++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics3.checkExpressionValueIsNotNull(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    @NonNull
    public static SizeSelector K0(int i) {
        return D1(new c(i));
    }

    public static int K1(q6<?> q6Var, int i, byte[] bArr, int i2, int i3, b5<?> b5Var, s3 s3Var) throws IOException {
        int iM1 = M1(q6Var, bArr, i2, i3, s3Var);
        b5Var.add(s3Var.c);
        while (iM1 < i3) {
            int iO1 = O1(bArr, iM1, s3Var);
            if (i != s3Var.a) {
                break;
            }
            iM1 = M1(q6Var, bArr, iO1, i3, s3Var);
            b5Var.add(s3Var.c);
        }
        return iM1;
    }

    @NonNull
    public static Rect L(@NonNull Size3 size3, @NonNull AspectRatio2 aspectRatio2) {
        int iRound;
        int i = size3.j;
        int i2 = size3.k;
        int i3 = 0;
        if (Math.abs(aspectRatio2.i() - AspectRatio2.f(size3.j, size3.k).i()) <= 5.0E-4f) {
            return new Rect(0, 0, i, i2);
        }
        if (AspectRatio2.f(i, i2).i() > aspectRatio2.i()) {
            int iRound2 = Math.round(aspectRatio2.i() * i2);
            int iRound3 = Math.round((i - iRound2) / 2.0f);
            i = iRound2;
            i3 = iRound3;
            iRound = 0;
        } else {
            int iRound4 = Math.round(i / aspectRatio2.i());
            iRound = Math.round((i2 - iRound4) / 2.0f);
            i2 = iRound4;
        }
        return new Rect(i3, iRound, i + i3, i2 + iRound);
    }

    @NonNull
    public static SizeSelector L0(int i) {
        return D1(new a(i));
    }

    public static int L1(q6 q6Var, byte[] bArr, int i, int i2, int i3, s3 s3Var) throws IOException {
        e6 e6Var = (e6) q6Var;
        Object objB = e6Var.m.b(e6Var.g);
        int iM = e6Var.m(objB, bArr, i, i2, i3, s3Var);
        e6Var.d(objB);
        s3Var.c = objB;
        return iM;
    }

    public static final <R> Object M(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws Throwable {
        Scopes2 scopes2 = new Scopes2(continuation.getContext(), continuation);
        Object objG1 = g1(scopes2, scopes2, function2);
        if (objG1 == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objG1;
    }

    @NonNull
    public static SizeSelector M0(int i) {
        return D1(new d(i));
    }

    public static int M1(q6 q6Var, byte[] bArr, int i, int i2, s3 s3Var) throws IOException {
        int iJ1 = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iJ1 = J1(i3, bArr, iJ1, s3Var);
            i3 = s3Var.a;
        }
        int i4 = iJ1;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzij.a();
        }
        Object objA = q6Var.a();
        int i5 = i3 + i4;
        q6Var.h(objA, bArr, i4, i5, s3Var);
        q6Var.d(objA);
        s3Var.c = objA;
        return i5;
    }

    public static Component4<?> N(String str, String str2) {
        AutoValue_LibraryVersion autoValue_LibraryVersion = new AutoValue_LibraryVersion(str, str2);
        Component4.b bVarA = Component4.a(LibraryVersion.class);
        bVarA.d = 1;
        bVarA.c(new Component3(autoValue_LibraryVersion));
        return bVarA.b();
    }

    @NonNull
    public static SizeSelector N0(int i) {
        return D1(new b(i));
    }

    public static int N1(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ea, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3 A[LOOP:2: B:24:0x006a->B:49:0x00a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b1 A[EDGE_INSN: B:89:0x00b1->B:53:0x00b1 BREAK  A[LOOP:2: B:24:0x006a->B:49:0x00a3], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final InetAddress O(String str, int i, int i2) {
        boolean z2;
        int i3;
        int i4;
        byte[] bArr = new byte[16];
        int i5 = i;
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (true) {
            if (i5 < i2) {
                if (i6 != 16) {
                    int i9 = i5 + 2;
                    if (i9 <= i2 && StringsJVM.startsWith$default(str, "::", i5, false, 4, null)) {
                        if (i7 == -1) {
                            i6 += 2;
                            if (i9 != i2) {
                                i8 = i9;
                                i7 = i6;
                                i5 = i8;
                                int i10 = 0;
                                while (i5 < i2) {
                                }
                                i4 = i5 - i8;
                                if (i4 == 0) {
                                    break;
                                }
                                break;
                                break;
                            }
                            i7 = i6;
                            break;
                        }
                        return null;
                    }
                    if (i6 != 0) {
                        if (StringsJVM.startsWith$default(str, ":", i5, false, 4, null)) {
                            i5++;
                        } else {
                            if (!StringsJVM.startsWith$default(str, ".", i5, false, 4, null)) {
                                return null;
                            }
                            int i11 = i6 - 2;
                            int i12 = i11;
                            loop2: while (true) {
                                if (i8 >= i2) {
                                    z2 = i12 == i11 + 4;
                                } else {
                                    if (i12 == 16) {
                                        break;
                                    }
                                    if (i12 == i11) {
                                        i3 = i8;
                                        int i13 = 0;
                                        while (i3 < i2) {
                                            char cCharAt = str.charAt(i3);
                                            if (cCharAt >= '0' && cCharAt <= '9') {
                                                if ((i13 == 0 && i8 != i3) || (i13 = ((i13 * 10) + cCharAt) - 48) > 255) {
                                                    break loop2;
                                                }
                                                i3++;
                                            } else {
                                                break;
                                            }
                                        }
                                        if (i3 - i8 != 0) {
                                            break;
                                        }
                                        bArr[i12] = (byte) i13;
                                        i8 = i3;
                                        i12++;
                                    } else {
                                        if (str.charAt(i8) != '.') {
                                            break;
                                        }
                                        i8++;
                                        i3 = i8;
                                        int i132 = 0;
                                        while (i3 < i2) {
                                        }
                                        if (i3 - i8 != 0) {
                                        }
                                    }
                                }
                            }
                            if (!z2) {
                                return null;
                            }
                            i6 += 2;
                        }
                    }
                    i8 = i5;
                    i5 = i8;
                    int i102 = 0;
                    while (i5 < i2) {
                        int iR = Util7.r(str.charAt(i5));
                        if (iR == -1) {
                            break;
                        }
                        i102 = (i102 << 4) + iR;
                        i5++;
                    }
                    i4 = i5 - i8;
                    if (i4 == 0 || i4 > 4) {
                        break;
                    }
                    int i14 = i6 + 1;
                    bArr[i6] = (byte) ((i102 >>> 8) & 255);
                    i6 = i14 + 1;
                    bArr[i14] = (byte) (i102 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        if (i6 != 16) {
            if (i7 == -1) {
                return null;
            }
            int i15 = i6 - i7;
            System.arraycopy(bArr, i7, bArr, 16 - i15, i15);
            Arrays.fill(bArr, i7, (16 - i6) + i7, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static /* synthetic */ void O0(FlexInputViewModel flexInputViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        flexInputViewModel.onContentDialogDismissed(z2);
    }

    public static int O1(byte[] bArr, int i, s3 s3Var) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return J1(b2, bArr, i2, s3Var);
        }
        s3Var.a = b2;
        return i2;
    }

    public static final Object P(long j, Continuation<? super Unit> continuation) {
        if (j <= 0) {
            return Unit.a;
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        if (j < RecyclerView.FOREVER_NS) {
            i0(cancellableContinuationImpl5.o).c(j, cancellableContinuationImpl5);
        }
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public static /* synthetic */ void P0(FlexInputViewModel flexInputViewModel, String str, Boolean bool, int i, Object obj) {
        int i2 = i & 2;
        flexInputViewModel.onInputTextChanged(str, null);
    }

    public static int P1(byte[] bArr, int i, b5<?> b5Var, s3 s3Var) throws IOException {
        x4 x4Var = (x4) b5Var;
        int iO1 = O1(bArr, i, s3Var);
        int i2 = s3Var.a + iO1;
        while (iO1 < i2) {
            iO1 = O1(bArr, iO1, s3Var);
            x4Var.g(s3Var.a);
        }
        if (iO1 == i2) {
            return iO1;
        }
        throw zzij.a();
    }

    public static float Q(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (float) Math.sqrt((f6 * f6) + (f5 * f5));
    }

    @NonNull
    public static SizeSelector Q0(SizeSelector... sizeSelectorArr) {
        return new SizeSelectors9(sizeSelectorArr, null);
    }

    public static <T> z2<T> Q1(z2<T> z2Var) {
        return ((z2Var instanceof c3) || (z2Var instanceof a3)) ? z2Var : z2Var instanceof Serializable ? new a3(z2Var) : new c3(z2Var);
    }

    public static float R(int i, int i2, int i3, int i4) {
        int i5 = i - i3;
        int i6 = i2 - i4;
        return (float) Math.sqrt((i6 * i6) + (i5 * i5));
    }

    public static int R0(int i) {
        if (i >= 200 && i <= 299) {
            return 0;
        }
        if (i >= 300 && i <= 399) {
            return 1;
        }
        if (i >= 400 && i <= 499) {
            return 0;
        }
        if (i >= 500) {
        }
        return 1;
    }

    public static FirebaseAppIndexingException R1(@NonNull Status status, String str) {
        String str2 = status.q;
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        int i = status.p;
        if (i == 17510) {
            return new FirebaseAppIndexingInvalidArgumentException(str);
        }
        if (i == 17511) {
            return new FirebaseAppIndexingTooManyArgumentsException(str);
        }
        if (i == 17602) {
            return new zzh(str);
        }
        switch (i) {
            case 17513:
                return new zzb(str);
            case 17514:
                return new zza(str);
            case 17515:
                return new zzg(str);
            case 17516:
                return new zze(str);
            case 17517:
                return new zzf(str);
            case 17518:
                return new zzd(str);
            case 17519:
                return new zzc(str);
            default:
                return new FirebaseAppIndexingException(str);
        }
    }

    public static int S(Context context, float f) {
        float fApplyDimension = TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        int i = (int) (fApplyDimension + 0.5d);
        if (i != 0 || fApplyDimension <= 0.0f) {
            return i;
        }
        return 1;
    }

    public static JsonElement S0(JsonReader jsonReader) throws JsonParseException {
        boolean z2;
        try {
            try {
                jsonReader.N();
                z2 = false;
            } catch (EOFException e2) {
                e = e2;
                z2 = true;
            }
            try {
                return TypeAdapters.X.read(jsonReader);
            } catch (EOFException e3) {
                e = e3;
                if (z2) {
                    return JsonNull.a;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e4) {
            throw new JsonSyntaxException(e4);
        } catch (IOException e5) {
            throw new JsonIOException(e5);
        } catch (NumberFormatException e6) {
            throw new JsonSyntaxException(e6);
        }
    }

    public static <T> T S1(@NonNull Bundle bundle, String str, Class<T> cls, T t) {
        T t2 = (T) bundle.get(str);
        if (t2 == null) {
            return t;
        }
        if (cls.isAssignableFrom(t2.getClass())) {
            return t2;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", str, cls.getCanonicalName(), t2.getClass().getCanonicalName()));
    }

    public static float T(float f, float f2, float f3, float f4) {
        float f5 = f / (f4 / 2.0f);
        float f6 = f3 / 2.0f;
        if (f5 < 1.0f) {
            return (f6 * f5 * f5 * f5) + f2;
        }
        float f7 = f5 - 2.0f;
        return (((f7 * f7 * f7) + 2.0f) * f6) + f2;
    }

    public static final Object T0(Object obj, E e2) {
        if (obj == null) {
            return e2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e2);
        return arrayList;
    }

    public static <V> V T1(d2<V> d2Var) {
        try {
            return d2Var.a();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return d2Var.a();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007e, B:29:0x0082, B:31:0x0086, B:37:0x0094, B:38:0x0095, B:39:0x00a0, B:40:0x00a1, B:42:0x00a5, B:45:0x00b8, B:46:0x00c3, B:18:0x0059), top: B:58:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:13:0x0036, B:27:0x007e, B:29:0x0082, B:31:0x0086, B:37:0x0094, B:38:0x0095, B:39:0x00a0, B:40:0x00a1, B:42:0x00a5, B:45:0x00b8, B:46:0x00c3, B:18:0x0059), top: B:58:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1, types: [s.a.c2.o] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, s.a.d2.e] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b5 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object U(FlowCollector<? super T> flowCollector, Channel6<? extends T> channel6, boolean z2, Continuation<? super Unit> continuation) {
        C0039f c0039f;
        Throwable th;
        Channel6<? extends T> channel62;
        boolean z3;
        Throwable th2;
        ?? r2;
        boolean z4;
        Object objM;
        if (continuation instanceof C0039f) {
            c0039f = (C0039f) continuation;
            int i = c0039f.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c0039f.label = i - Integer.MIN_VALUE;
            } else {
                c0039f = new C0039f(continuation);
            }
        }
        Object obj = c0039f.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = c0039f.label;
        try {
            if (i2 == 0) {
                Result3.throwOnFailure(obj);
                th = null;
                z4 = z2;
                c0039f.L$0 = flowCollector;
                c0039f.L$1 = channel6;
                c0039f.Z$0 = z4;
                c0039f.L$2 = th;
                c0039f.L$3 = flowCollector;
                c0039f.label = 1;
                objM = channel6.m(c0039f);
                if (objM == coroutine_suspended) {
                }
            } else if (i2 == 1) {
                th2 = (Throwable) c0039f.L$2;
                z3 = c0039f.Z$0;
                channel62 = (Channel6) c0039f.L$1;
                FlowCollector flowCollector2 = (FlowCollector) c0039f.L$0;
                Result3.throwOnFailure(obj);
                r2 = flowCollector2;
                if (obj instanceof Channel8.a) {
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th2 = (Throwable) c0039f.L$2;
                z3 = c0039f.Z$0;
                channel62 = (Channel6) c0039f.L$1;
                FlowCollector<? super T> flowCollector3 = (FlowCollector) c0039f.L$0;
                Result3.throwOnFailure(obj);
                FlowCollector<? super T> flowCollector4 = flowCollector3;
                th = th2;
                flowCollector = flowCollector4;
                Channel6<? extends T> channel63 = channel62;
                z4 = z3;
                channel6 = channel63;
                try {
                    c0039f.L$0 = flowCollector;
                    c0039f.L$1 = channel6;
                    c0039f.Z$0 = z4;
                    c0039f.L$2 = th;
                    c0039f.L$3 = flowCollector;
                    c0039f.label = 1;
                    objM = channel6.m(c0039f);
                    if (objM == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    r2 = flowCollector;
                    th2 = th;
                    obj = objM;
                    boolean z5 = z4;
                    channel62 = channel6;
                    z3 = z5;
                    if (obj instanceof Channel8.a) {
                        if (!(obj instanceof Channel8.a)) {
                            throw new IllegalStateException("Channel was not closed".toString());
                        }
                        Throwable th3 = ((Channel8.a) obj).a;
                        if (th3 == null) {
                            return Unit.a;
                        }
                        throw th3;
                    }
                    if (obj instanceof Channel8.a) {
                        throw new IllegalStateException("Channel was closed".toString());
                    }
                    c0039f.L$0 = r2;
                    c0039f.L$1 = channel62;
                    c0039f.Z$0 = z3;
                    c0039f.L$2 = th2;
                    c0039f.L$3 = obj;
                    c0039f.label = 2;
                    Object objEmit = r2.emit(obj, c0039f);
                    flowCollector4 = r2;
                    if (objEmit == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th = th2;
                    flowCollector = flowCollector4;
                    Channel6<? extends T> channel632 = channel62;
                    z4 = z3;
                    channel6 = channel632;
                    c0039f.L$0 = flowCollector;
                    c0039f.L$1 = channel6;
                    c0039f.Z$0 = z4;
                    c0039f.L$2 = th;
                    c0039f.L$3 = flowCollector;
                    c0039f.label = 1;
                    objM = channel6.m(c0039f);
                    if (objM == coroutine_suspended) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    boolean z6 = z4;
                    z2 = channel6;
                    channel6 = z6;
                    try {
                        throw th;
                    } finally {
                        if (channel6 != null) {
                            u(z2, th);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static long U0(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == RecyclerView.FOREVER_NS) {
                return RecyclerView.FOREVER_NS;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                throw new IllegalStateException(outline.t("More produced than requested: ", j3));
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }

    public static <TResult> TResult U1(@NonNull Task<TResult> task) throws ExecutionException {
        if (task.p()) {
            return task.l();
        }
        if (task.n()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.k());
    }

    public static boolean V(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static RuntimeException V0(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new RuntimeException(th);
    }

    public static String V1(Context context, String str) {
        Resources resources;
        int identifier;
        try {
            Objects.requireNonNull(context, "null reference");
            resources = context.getResources();
            identifier = resources.getIdentifier(str, "string", resources.getResourcePackageName(R.a.common_google_play_services_unknown_issue));
        } catch (Resources.NotFoundException unused) {
        }
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }

    public static <T> T W(@NullableDecl T t, @NullableDecl T t2) {
        if (t != null) {
            return t;
        }
        Objects.requireNonNull(t2, "Both parameters are null");
        return t2;
    }

    public static void W0(int i, ByteVector2 byteVector2) {
        int i2 = i >>> 24;
        if (i2 != 0 && i2 != 1) {
            switch (i2) {
                case 16:
                case 17:
                case 18:
                case 23:
                    break;
                case 19:
                case 20:
                case 21:
                    byteVector2.g(i2);
                    return;
                case 22:
                    break;
                default:
                    switch (i2) {
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            byteVector2.i(i);
                            return;
                        default:
                            throw new IllegalArgumentException();
                    }
            }
            byteVector2.e(i2, (i & 16776960) >> 8);
            return;
        }
        byteVector2.j(i >>> 16);
    }

    public static String W1(t3 t3Var) {
        b7 b7Var = new b7(t3Var);
        StringBuilder sb = new StringBuilder(t3Var.d());
        for (int i = 0; i < b7Var.a.d(); i++) {
            byte bC = b7Var.a.c(i);
            if (bC == 34) {
                sb.append("\\\"");
            } else if (bC == 39) {
                sb.append("\\'");
            } else if (bC != 92) {
                switch (bC) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bC < 32 || bC > 126) {
                            sb.append('\\');
                            sb.append((char) (((bC >>> 6) & 3) + 48));
                            sb.append((char) (((bC >>> 3) & 7) + 48));
                            sb.append((char) ((bC & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bC);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static final FloatBuffer X(int i) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i * 4 * 1).order(ByteOrder.nativeOrder());
        byteBufferOrder.limit(byteBufferOrder.capacity());
        Intrinsics3.checkNotNullExpressionValue(byteBufferOrder, "allocateDirect(size * Egloo.SIZE_OF_BYTE)\n        .order(ByteOrder.nativeOrder())\n        .also { it.limit(it.capacity()) }");
        FloatBuffer floatBufferAsFloatBuffer = byteBufferOrder.asFloatBuffer();
        Intrinsics3.checkNotNullExpressionValue(floatBufferAsFloatBuffer, "byteBuffer(size * Egloo.SIZE_OF_FLOAT).asFloatBuffer()");
        return floatBufferAsFloatBuffer;
    }

    public static final <T> Object X0(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof CompletionState2) {
            Result2.a aVar = Result2.j;
            return Result2.m97constructorimpl(Result3.createFailure(((CompletionState2) obj).f3846b));
        }
        Result2.a aVar2 = Result2.j;
        return Result2.m97constructorimpl(obj);
    }

    public static final String X1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    @NonNull
    public static <TResult> Task<TResult> Y(@RecentlyNonNull Exception exc) {
        c0 c0Var = new c0();
        c0Var.t(exc);
        return c0Var;
    }

    public static final <T> void Y0(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z2) {
        Object objJ;
        Object objM = dispatchedTask.m();
        Throwable thE = dispatchedTask.e(objM);
        if (thE != null) {
            Result2.a aVar = Result2.j;
            objJ = Result3.createFailure(thE);
        } else {
            Result2.a aVar2 = Result2.j;
            objJ = dispatchedTask.j(objM);
        }
        Object objM97constructorimpl = Result2.m97constructorimpl(objJ);
        if (!z2) {
            continuation.resumeWith(objM97constructorimpl);
            return;
        }
        Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        CoroutineContext context = dispatchedContinuation.getContext();
        Object objB = ThreadContext.b(context, dispatchedContinuation.p);
        try {
            dispatchedContinuation.r.resumeWith(objM97constructorimpl);
        } finally {
            ThreadContext.a(context, objB);
        }
    }

    @Nullable
    public static String Y1(String str, String[] strArr, String[] strArr2) {
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < iMin; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i];
            }
        }
        return null;
    }

    @NonNull
    public static <TResult> Task<TResult> Z(@RecentlyNonNull TResult tresult) {
        c0 c0Var = new c0();
        c0Var.s(tresult);
        return c0Var;
    }

    public static int Z0(float f) {
        return (int) (f + (f < 0.0f ? -0.5f : 0.5f));
    }

    @WorkerThread
    public static Set<String> Z1(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(outline.k(outline.b(str, 22), "SELECT * FROM ", str, " LIMIT 0"), null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static final String a0(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - 500000000) / 1000000000) + " s ";
        } else if (j <= -999500) {
            str = ((j - 500000) / 1000000) + " ms";
        } else if (j <= 0) {
            str = ((j - 500) / 1000) + " µs";
        } else if (j < 999500) {
            str = ((j + 500) / 1000) + " µs";
        } else if (j < 999500000) {
            str = ((j + 500000) / 1000000) + " ms";
        } else {
            str = ((j + 500000000) / 1000000000) + " s ";
        }
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics3.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
        return str2;
    }

    public static final int a1(SegmentedByteString segmentedByteString, int i) {
        int i2;
        Intrinsics3.checkParameterIsNotNull(segmentedByteString, "$this$segment");
        int[] iArr = segmentedByteString.o;
        int i3 = i + 1;
        int length = segmentedByteString.n.length;
        Intrinsics3.checkParameterIsNotNull(iArr, "$this$binarySearch");
        int i4 = length - 1;
        int i5 = 0;
        while (true) {
            if (i5 <= i4) {
                i2 = (i5 + i4) >>> 1;
                int i6 = iArr[i2];
                if (i6 >= i3) {
                    if (i6 <= i3) {
                        break;
                    }
                    i4 = i2 - 1;
                } else {
                    i5 = i2 + 1;
                }
            } else {
                i2 = (-i5) - 1;
                break;
            }
        }
        return i2 >= 0 ? i2 : ~i2;
    }

    public static void a2(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzij {
        if (!w2(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !w2(b4) && !w2(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & AudioAttributesCompat.FLAG_ALL) + 56320);
                return;
            }
        }
        throw zzij.e();
    }

    public static Channel4 b(int i, BufferOverflow bufferOverflow, Function1 function1, int i2) {
        BufferOverflow bufferOverflow2 = BufferOverflow.SUSPEND;
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = bufferOverflow2;
        }
        int i3 = i2 & 4;
        int i4 = 1;
        if (i == -2) {
            if (bufferOverflow == bufferOverflow2) {
                Objects.requireNonNull(Channel4.i);
                i4 = Channel4.a.a;
            }
            return new ArrayChannel(i4, bufferOverflow, null);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? (i == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) ? new ConflatedChannel(null) : new ArrayChannel(i, bufferOverflow, null) : new LinkedListChannel(null) : bufferOverflow == bufferOverflow2 ? new RendezvousChannel(null) : new ArrayChannel(1, bufferOverflow, null);
        }
        if (bufferOverflow == bufferOverflow2) {
            return new ConflatedChannel(null);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    }

    public static Component4<?> b0(String str, LibraryVersionComponent2<Context> libraryVersionComponent2) {
        Component4.b bVarA = Component4.a(LibraryVersion.class);
        bVarA.d = 1;
        bVarA.a(new Dependency2(Context.class, 1, 0));
        bVarA.c(new LibraryVersionComponent(str, libraryVersionComponent2));
        return bVarA.b();
    }

    public static final Sink b1(Socket socket) throws IOException {
        Intrinsics3.checkParameterIsNotNull(socket, "$this$sink");
        JvmOkio3 jvmOkio3 = new JvmOkio3(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics3.checkExpressionValueIsNotNull(outputStream, "getOutputStream()");
        JvmOkio2 jvmOkio2 = new JvmOkio2(outputStream, jvmOkio3);
        Intrinsics3.checkParameterIsNotNull(jvmOkio2, "sink");
        return new AsyncTimeout2(jvmOkio3, jvmOkio2);
    }

    public static void b2(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzij {
        if (w2(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || w2(b4)))) {
            throw zzij.e();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static final CoroutineScope c(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.INSTANCE) == null) {
            coroutineContext = coroutineContext.plus(new f1(null));
        }
        return new Scopes(coroutineContext);
    }

    public static long c0(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, f(j2, j)));
        return j2;
    }

    public static int c1(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static void c2(byte b2, byte b3, char[] cArr, int i) throws zzij {
        if (b2 < -62 || w2(b3)) {
            throw zzij.e();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static CompletableJob d(Job job, int i) {
        int i2 = i & 1;
        return new Supervisor(null);
    }

    public static float[] d0(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static final Source2 d1(Socket socket) throws IOException {
        Intrinsics3.checkParameterIsNotNull(socket, "$this$source");
        JvmOkio3 jvmOkio3 = new JvmOkio3(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics3.checkExpressionValueIsNotNull(inputStream, "getInputStream()");
        JvmOkio jvmOkio = new JvmOkio(inputStream, jvmOkio3);
        Intrinsics3.checkParameterIsNotNull(jvmOkio, "source");
        return new AsyncTimeout3(jvmOkio3, jvmOkio);
    }

    public static void d2(@NonNull Bundle bundle, @NonNull Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble("value", ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong("value", ((Long) obj).longValue());
        } else {
            bundle.putString("value", obj.toString());
        }
    }

    public static final void e(Task2 task2, TaskQueue2 taskQueue2, String str) {
        TaskRunner.b bVar = TaskRunner.c;
        Logger logger = TaskRunner.f3611b;
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue2.f);
        sb.append(' ');
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics3.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(task2.c);
        logger.fine(sb.toString());
    }

    public static final String e0(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final void e1(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation continuationIntercepted = IntrinsicsJvm.intercepted(continuation);
            Result2.a aVar = Result2.j;
            DispatchedContinuation2.b(continuationIntercepted, Result2.m97constructorimpl(Unit.a), null, 2);
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.j;
            ((AbstractCoroutine) continuation2).resumeWith(Result2.m97constructorimpl(Result3.createFailure(th)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e2(c6 c6Var, StringBuilder sb, int i) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (Method method : c6Var.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            boolean zBooleanValue = true;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String strValueOf = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf2 = String.valueOf(strSubstring.substring(1, strSubstring.length() - 4));
                String strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    h2(sb, i, X1(strConcat), u4.q(method2, c6Var, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String strValueOf3 = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf4 = String.valueOf(strSubstring.substring(1, strSubstring.length() - 3));
                String strConcat2 = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    h2(sb, i, X1(strConcat2), u4.q(method3, c6Var, new Object[0]));
                }
            }
            if (((Method) map2.get(strSubstring.length() != 0 ? "set".concat(strSubstring) : new String("set"))) != null) {
                if (strSubstring.endsWith("Bytes")) {
                    String strValueOf5 = String.valueOf(strSubstring.substring(0, strSubstring.length() - 5));
                    if (!map.containsKey(strValueOf5.length() != 0 ? "get".concat(strValueOf5) : new String("get"))) {
                    }
                }
                String strValueOf6 = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf7 = String.valueOf(strSubstring.substring(1));
                String strConcat3 = strValueOf7.length() != 0 ? strValueOf6.concat(strValueOf7) : new String(strValueOf6);
                Method method4 = (Method) map.get(strSubstring.length() != 0 ? "get".concat(strSubstring) : new String("get"));
                Method method5 = (Method) map.get(strSubstring.length() != 0 ? "has".concat(strSubstring) : new String("has"));
                if (method4 != null) {
                    Object objQ = u4.q(method4, c6Var, new Object[0]);
                    if (method5 == null) {
                        if (objQ instanceof Boolean) {
                            zEquals = !((Boolean) objQ).booleanValue();
                        } else if (objQ instanceof Integer) {
                            if (((Integer) objQ).intValue() == 0) {
                            }
                        } else if (objQ instanceof Float) {
                            if (((Float) objQ).floatValue() == 0.0f) {
                            }
                        } else if (objQ instanceof Double) {
                            if (((Double) objQ).doubleValue() == 0.0d) {
                            }
                        } else if (objQ instanceof String) {
                            zEquals = objQ.equals("");
                        } else if (objQ instanceof t3) {
                            zEquals = objQ.equals(t3.j);
                        } else if (!(objQ instanceof c6) ? !(objQ instanceof Enum) || ((Enum) objQ).ordinal() != 0 : objQ != ((c6) objQ).k()) {
                        }
                        if (zEquals) {
                            zBooleanValue = false;
                        }
                    } else {
                        zBooleanValue = ((Boolean) u4.q(method5, c6Var, new Object[0])).booleanValue();
                    }
                    if (zBooleanValue) {
                        h2(sb, i, X1(strConcat3), objQ);
                    }
                }
            }
        }
        if (c6Var instanceof u4.d) {
            Iterator<Map.Entry<T, Object>> itL = ((u4.d) c6Var).zzc.l();
            if (itL.hasNext()) {
                throw new NoSuchMethodError();
            }
        }
        c7 c7Var = ((u4) c6Var).zzb;
        if (c7Var != null) {
            for (int i2 = 0; i2 < c7Var.f1438b; i2++) {
                h2(sb, i, String.valueOf(c7Var.c[i2] >>> 3), c7Var.d[i2]);
            }
        }
    }

    public static long f(long j, long j2) {
        long j3 = j + j2;
        return j3 < 0 ? RecyclerView.FOREVER_NS : j3;
    }

    public static float[] f0(RectF rectF) {
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        return new float[]{f, f2, f3, f2, f3, f4, f, f4};
    }

    public static void f1(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i) {
        int i2 = i & 4;
        try {
            Continuation continuationIntercepted = IntrinsicsJvm.intercepted(IntrinsicsJvm.createCoroutineUnintercepted(function2, obj, continuation));
            Result2.a aVar = Result2.j;
            DispatchedContinuation2.a(continuationIntercepted, Result2.m97constructorimpl(Unit.a), null);
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.j;
            continuation.resumeWith(Result2.m97constructorimpl(Result3.createFailure(th)));
        }
    }

    public static void f2(q3 q3Var, SQLiteDatabase sQLiteDatabase) {
        if (q3Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            q3Var.i.a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            q3Var.i.a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            q3Var.i.a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        q3Var.i.a("Failed to turn on database write permission for owner");
    }

    @NonNull
    public static SizeSelector g(SizeSelector... sizeSelectorArr) {
        return new SizeSelectors6(sizeSelectorArr, null);
    }

    public static String g0(long j) {
        return h0(j, null);
    }

    public static final <T, R> Object g1(Scopes2<? super T> scopes2, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) throws Throwable {
        Object completionState2;
        Object objR;
        scopes2.f0();
        try {
        } catch (Throwable th) {
            completionState2 = new CompletionState2(th, false, 2);
        }
        if (function2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        completionState2 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, scopes2);
        if (completionState2 != Intrinsics2.getCOROUTINE_SUSPENDED() && (objR = scopes2.R(completionState2)) != i1.f3841b) {
            if (objR instanceof CompletionState2) {
                throw ((CompletionState2) objR).f3846b;
            }
            return i1.a(objR);
        }
        return Intrinsics2.getCOROUTINE_SUSPENDED();
    }

    @WorkerThread
    public static void g2(q3 q3Var, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLException {
        boolean zMoveToFirst;
        if (q3Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{ModelAuditLogEntry.CHANGE_KEY_NAME}, "name=?", new String[]{str}, null, null, null);
                zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            q3Var.i.c("Error querying for table", str, e2);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            zMoveToFirst = false;
        }
        if (!zMoveToFirst) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            Set<String> setZ1 = Z1(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!((HashSet) setZ1).remove(str4)) {
                    StringBuilder sb = new StringBuilder(str.length() + 35 + String.valueOf(str4).length());
                    sb.append("Table ");
                    sb.append(str);
                    sb.append(" is missing required column: ");
                    sb.append(str4);
                    throw new SQLiteException(sb.toString());
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!((HashSet) setZ1).remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (((HashSet) setZ1).isEmpty()) {
                return;
            }
            q3Var.i.c("Table has extra columns. table, columns", str, TextUtils.join(", ", setZ1));
        } catch (SQLiteException e3) {
            q3Var.f.b("Failed to verify columns on table that was just created", str);
            throw e3;
        }
    }

    public static final boolean h(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        Intrinsics3.checkParameterIsNotNull(bArr, "a");
        Intrinsics3.checkParameterIsNotNull(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static String h0(long j, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar calendarH = UtcDates.h();
        Calendar calendarI = UtcDates.i();
        calendarI.setTimeInMillis(j);
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j)) : calendarH.get(1) == calendarI.get(1) ? n0(j, Locale.getDefault()) : s0(j, Locale.getDefault());
    }

    public static int h1(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static final void h2(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                h2(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                h2(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            t3 t3Var = t3.j;
            sb.append(W1(new z3(((String) obj).getBytes(w4.a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof t3) {
            sb.append(": \"");
            sb.append(W1((t3) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof u4) {
            sb.append(" {");
            e2((u4) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj.toString());
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        h2(sb, i4, "key", entry.getKey());
        h2(sb, i4, "value", entry.getValue());
        sb.append("\n");
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }

    public static Deferred i(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        CoroutineContextImpl4 coroutineContextImpl4 = (i & 1) != 0 ? CoroutineContextImpl4.j : null;
        CoroutineStart coroutineStart2 = (i & 2) != 0 ? CoroutineStart.DEFAULT : null;
        CoroutineContext coroutineContextA = CoroutineContext2.a(coroutineScope, coroutineContextImpl4);
        Objects.requireNonNull(coroutineStart2);
        g0 j1Var = coroutineStart2 == CoroutineStart.LAZY ? new j1(coroutineContextA, function2) : new g0(coroutineContextA, true);
        j1Var.j0(coroutineStart2, j1Var, function2);
        return j1Var;
    }

    public static final Delay i0(CoroutineContext coroutineContext) {
        int i = ContinuationInterceptor.e;
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.b.a);
        if (!(element instanceof Delay)) {
            element = null;
        }
        Delay delay = (Delay) element;
        return delay != null ? delay : DefaultExecutor2.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object i1(Exception exc, Continuation<?> continuation) {
        h hVar;
        if (continuation instanceof h) {
            hVar = (h) continuation;
            int i = hVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                hVar.label = i - Integer.MIN_VALUE;
            } else {
                hVar = new h(continuation);
            }
        }
        Object obj = hVar.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = hVar.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj);
            hVar.L$0 = exc;
            hVar.label = 1;
            Dispatchers.a.dispatch(hVar.getContext(), new g(hVar, exc));
            Object coroutine_suspended2 = Intrinsics2.getCOROUTINE_SUSPENDED();
            if (coroutine_suspended2 == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(hVar);
            }
            if (coroutine_suspended2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
        }
        return Unit.a;
    }

    public static boolean i2(byte b2) {
        return b2 >= 0;
    }

    @RecentlyNonNull
    public static <TResult> TResult j(@RecentlyNonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        AnimatableValueParser.x("Must not be called on the main application thread");
        AnimatableValueParser.z(task, "Task must not be null");
        if (task.o()) {
            return (TResult) U1(task);
        }
        b.i.a.f.n.h hVar = new b.i.a.f.n.h(null);
        p2(task, hVar);
        hVar.a.await();
        return (TResult) U1(task);
    }

    public static final int j0(Alert2 alert2, @DimenRes int i) {
        Intrinsics3.checkNotNullParameter(alert2, "$this$getDimenPixelSize");
        return alert2.getResources().getDimensionPixelSize(i);
    }

    public static final long j1(String str, long j, long j2, long j3) {
        String strK1 = k1(str);
        if (strK1 == null) {
            return j;
        }
        Long longOrNull = StringNumberConversions.toLongOrNull(strK1);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strK1 + '\'').toString());
        }
        long jLongValue = longOrNull.longValue();
        if (j2 <= jLongValue && j3 >= jLongValue) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }

    public static boolean j2(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @RecentlyNonNull
    public static <TResult> TResult k(@RecentlyNonNull Task<TResult> task, long j, @RecentlyNonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AnimatableValueParser.x("Must not be called on the main application thread");
        AnimatableValueParser.z(task, "Task must not be null");
        AnimatableValueParser.z(timeUnit, "TimeUnit must not be null");
        if (task.o()) {
            return (TResult) U1(task);
        }
        b.i.a.f.n.h hVar = new b.i.a.f.n.h(null);
        p2(task, hVar);
        if (hVar.a.await(j, timeUnit)) {
            return (TResult) U1(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NullableDecl
    public static <T> T k0(Iterable<? extends T> iterable, @NullableDecl T t) {
        Sets2 sets2 = new Sets2((Collections2.a) iterable);
        return sets2.hasNext() ? (T) sets2.next() : t;
    }

    public static final String k1(String str) {
        int i = SystemProps.a;
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static int k2(int i) {
        int[] iArr = {1, 2, 3, 4, 5};
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            if (i4 == i) {
                return i3;
            }
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object l(Deferred<? extends T>[] deferredArr, Continuation<? super List<? extends T>> continuation) {
        e eVar;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i = eVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.label = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        }
        Object objU = eVar.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = eVar.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objU);
            if (deferredArr.length == 0) {
                return d0.t.Collections2.emptyList();
            }
            Await await = new Await(deferredArr);
            eVar.L$0 = deferredArr;
            eVar.label = 1;
            CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(eVar), 1);
            cancellableContinuationImpl5.A();
            int length = deferredArr.length;
            Await.a[] aVarArr = new Await.a[length];
            for (int i3 = 0; i3 < length; i3++) {
                Deferred<T> deferred = await.f3836b[boxing.boxInt(i3).intValue()];
                deferred.start();
                Await.a aVar = new Await.a(cancellableContinuationImpl5, deferred);
                aVar.n = deferred.u(aVar);
                aVarArr[i3] = aVar;
            }
            Await.b bVar = new Await.b(await, aVarArr);
            for (int i4 = 0; i4 < length; i4++) {
                aVarArr[i4]._disposer = bVar;
            }
            if (cancellableContinuationImpl5.v()) {
                bVar.b();
            } else {
                cancellableContinuationImpl5.f(bVar);
            }
            objU = cancellableContinuationImpl5.u();
            if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(eVar);
            }
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(objU);
        }
        return (List) objU;
    }

    public static final String l0(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static int l1(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return (int) j1(str, i, i2, i3);
    }

    public static String l2(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e2) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb.append(name);
                    sb.append(MentionUtils.MENTIONS_CHAR);
                    sb.append(hexString);
                    String string2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String strValueOf = String.valueOf(string2);
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", strValueOf.length() != 0 ? "Exception during lenientFormat for ".concat(strValueOf) : new String("Exception during lenientFormat for "), (Throwable) e2);
                    String name2 = e2.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(string2).length() + 9 + name2.length());
                    outline.s0(sb2, "<", string2, " threw ", name2);
                    sb2.append(">");
                    string = sb2.toString();
                }
            }
            objArr[i2] = string;
            i2++;
        }
        StringBuilder sb3 = new StringBuilder((length * 16) + str.length());
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (iIndexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb3.append((CharSequence) str, i3, iIndexOf);
            sb3.append(objArr[i]);
            i3 = iIndexOf + 2;
            i++;
        }
        sb3.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb3.append(" [");
            sb3.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb3.append(", ");
                sb3.append(objArr[i4]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }

    public static String m(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return I0("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return I0("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(outline.q("negative size: ", i2));
    }

    @TargetApi(17)
    public static int m0() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        int[] iArr = new int[2];
        EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (iArr2[0] == 0) {
            return 0;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344}, 0);
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext);
        int[] iArr3 = new int[1];
        GLES20.glGetIntegerv(3379, iArr3, 0);
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface);
        EGL14.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
        EGL14.eglTerminate(eGLDisplayEglGetDisplay);
        return iArr3[0];
    }

    public static /* synthetic */ long m1(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = RecyclerView.FOREVER_NS;
        }
        return j1(str, j, j4, j3);
    }

    public static boolean m2(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static ExecutorService n(String str) {
        ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ExecutorUtils(str, new AtomicLong(1L)), new ThreadPoolExecutor.DiscardPolicy()));
        Runtime.getRuntime().addShutdownHook(new Thread(new ExecutorUtils2(str, executorServiceUnconfigurableExecutorService, 2L, TimeUnit.SECONDS), outline.w("Crashlytics Shutdown Hook for ", str)));
        return executorServiceUnconfigurableExecutorService;
    }

    public static String n0(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.c("MMMd", locale).format(new Date(j));
        }
        AtomicReference<TimeSource> atomicReference = UtcDates.a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(UtcDates.g());
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) dateInstance;
        String pattern = simpleDateFormat.toPattern();
        int iB = UtcDates.b(pattern, "yY", 1, 0);
        if (iB < pattern.length()) {
            int iB2 = UtcDates.b(pattern, "EMd", 1, iB);
            pattern = pattern.replace(pattern.substring(UtcDates.b(pattern, iB2 < pattern.length() ? "EMd," : "EMd", -1, iB) + 1, iB2), " ").trim();
        }
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(new Date(j));
    }

    public static void n1(List<? extends Throwable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() != 1) {
            throw new CompositeException(list);
        }
        Throwable th = list.get(0);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new RuntimeException(th);
        }
        throw ((Error) th);
    }

    public static int n2(byte[] bArr, int i, s3 s3Var) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            s3Var.f1493b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | ((b2 & 127) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & 127) << i4;
            b2 = bArr[i3];
            i3 = i5;
        }
        s3Var.f1493b = j2;
        return i3;
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> o(@RecentlyNonNull Executor executor, @RecentlyNonNull Callable<TResult> callable) {
        AnimatableValueParser.z(executor, "Executor must not be null");
        AnimatableValueParser.z(callable, "Callback must not be null");
        c0 c0Var = new c0();
        executor.execute(new d0(c0Var, callable));
        return c0Var;
    }

    public static final <T> CancellableContinuationImpl5<T> o0(Continuation<? super T> continuation) {
        CancellableContinuationImpl5<T> cancellableContinuationImpl5;
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl5<>(continuation, 2);
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        while (true) {
            Object obj = dispatchedContinuation._reusableCancellableContinuation;
            if (obj == null) {
                dispatchedContinuation._reusableCancellableContinuation = DispatchedContinuation2.f3827b;
                cancellableContinuationImpl5 = null;
                break;
            }
            if (!(obj instanceof CancellableContinuationImpl5)) {
                throw new IllegalStateException(outline.v("Inconsistent state ", obj).toString());
            }
            if (DispatchedContinuation.m.compareAndSet(dispatchedContinuation, obj, DispatchedContinuation2.f3827b)) {
                cancellableContinuationImpl5 = (CancellableContinuationImpl5) obj;
                break;
            }
        }
        if (cancellableContinuationImpl5 != null) {
            Object obj2 = cancellableContinuationImpl5._state;
            boolean z2 = false;
            if (!(obj2 instanceof CancellableContinuationImpl8) || ((CancellableContinuationImpl8) obj2).d == null) {
                cancellableContinuationImpl5._decision = 0;
                cancellableContinuationImpl5._state = CancellableContinuationImpl2.j;
                z2 = true;
            } else {
                cancellableContinuationImpl5.q();
            }
            CancellableContinuationImpl5<T> cancellableContinuationImpl52 = z2 ? cancellableContinuationImpl5 : null;
            if (cancellableContinuationImpl52 != null) {
                return cancellableContinuationImpl52;
            }
        }
        return new CancellableContinuationImpl5<>(continuation, 2);
    }

    public static void o1(Throwable th) {
        if (th instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th);
        }
        if (th instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) th);
        }
        if (th instanceof OnCompletedFailedException) {
            throw ((OnCompletedFailedException) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static long o2(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> OnUndeliveredElement p(Function1<? super E, Unit> function1, E e2, OnUndeliveredElement onUndeliveredElement) {
        try {
            function1.invoke(e2);
        } catch (Throwable th) {
            if (onUndeliveredElement == null || onUndeliveredElement.getCause() == th) {
                return new OnUndeliveredElement(outline.v("Exception in undelivered element handler for ", e2), th);
            }
            Exceptions.addSuppressed(onUndeliveredElement, th);
        }
        return onUndeliveredElement;
    }

    public static int p0(int[] iArr, int i, boolean z2) {
        int[] iArr2 = iArr;
        int i2 = 0;
        for (int i3 : iArr2) {
            i2 += i3;
        }
        int length = iArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = length - 1;
            if (i4 >= i7) {
                return i5;
            }
            int i8 = 1 << i4;
            i6 |= i8;
            int i9 = 1;
            while (i9 < iArr2[i4]) {
                int i10 = i2 - i9;
                int i11 = length - i4;
                int i12 = i11 - 2;
                int iJ = J(i10 - 1, i12);
                if (z2 && i6 == 0) {
                    int i13 = i11 - 1;
                    if (i10 - i13 >= i13) {
                        iJ -= J(i10 - i11, i12);
                    }
                }
                if (i11 - 1 > 1) {
                    int iJ2 = 0;
                    for (int i14 = i10 - i12; i14 > i; i14--) {
                        iJ2 += J((i10 - i14) - 1, i11 - 3);
                    }
                    iJ -= (i7 - i4) * iJ2;
                } else if (i10 > i) {
                    iJ--;
                }
                i5 += iJ;
                i9++;
                i6 &= ~i8;
                iArr2 = iArr;
            }
            i2 -= i9;
            i4++;
            iArr2 = iArr;
        }
    }

    public static void p1(Throwable th, Observer2<?> observer2, Object obj) {
        o1(th);
        observer2.onError(OnErrorThrowable.a(th, obj));
    }

    public static <T> void p2(Task<T> task, b.i.a.f.n.i<? super T> iVar) {
        Executor executor = b.i.a.f.n.g.f1593b;
        task.g(executor, iVar);
        task.e(executor, iVar);
        task.a(executor, iVar);
    }

    public static /* synthetic */ OnUndeliveredElement q(Function1 function1, Object obj, OnUndeliveredElement onUndeliveredElement, int i) {
        int i2 = i & 2;
        return p(function1, obj, null);
    }

    public static int q0(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
            return 3;
        }
        return defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 2;
    }

    public static int[] q1(Collection<? extends Number> collection) {
        if (collection instanceof Ints) {
            Ints ints = (Ints) collection;
            return Arrays.copyOfRange(ints.array, ints.start, ints.end);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            Objects.requireNonNull(obj);
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static void q2(boolean z2, @NullableDecl Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static final void r(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE);
        if (job != null) {
            job.b(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    public static DateFormat r0(int i, int i2) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            str = "EEEE, MMMM d, yyyy";
        } else if (i == 1) {
            str = "MMMM d, yyyy";
        } else if (i == 2) {
            str = "MMM d, yyyy";
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(outline.q("Unknown DateFormat style: ", i));
            }
            str = "M/d/yy";
        }
        sb.append(str);
        sb.append(" ");
        if (i2 == 0 || i2 == 1) {
            str2 = "h:mm:ss a z";
        } else if (i2 == 2) {
            str2 = "h:mm:ss a";
        } else {
            if (i2 != 3) {
                throw new IllegalArgumentException(outline.q("Unknown DateFormat style: ", i2));
            }
            str2 = "h:mm a";
        }
        sb.append(str2);
        return new SimpleDateFormat(sb.toString(), Locale.US);
    }

    public static final String r1(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "$this$toCanonicalHost");
        int i = 0;
        int i2 = -1;
        if (!Strings4.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            try {
                String ascii = IDN.toASCII(str);
                Intrinsics3.checkExpressionValueIsNotNull(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
                if (ascii == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i3 = 0; i3 < length; i3++) {
                    char cCharAt = lowerCase.charAt(i3);
                    if (cCharAt > 31 && cCharAt < 127 && Strings4.indexOf$default((CharSequence) " #%/:?@[\\]", cCharAt, 0, false, 6, (Object) null) == -1) {
                    }
                    i = 1;
                    break;
                }
                if (i != 0) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressO = (StringsJVM.startsWith$default(str, "[", false, 2, null) && StringsJVM.endsWith$default(str, "]", false, 2, null)) ? O(str, 1, str.length() - 1) : O(str, 0, str.length());
        if (inetAddressO == null) {
            return null;
        }
        byte[] address = inetAddressO.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressO.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        Intrinsics3.checkExpressionValueIsNotNull(address, "address");
        int i4 = 0;
        int i5 = 0;
        while (i4 < address.length) {
            int i6 = i4;
            while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        Buffer3 buffer3 = new Buffer3();
        while (i < address.length) {
            if (i == i2) {
                buffer3.T(58);
                i += i5;
                if (i == 16) {
                    buffer3.T(58);
                }
            } else {
                if (i > 0) {
                    buffer3.T(58);
                }
                byte b2 = address[i];
                byte[] bArr = Util7.a;
                buffer3.V(((b2 & 255) << 8) | (address[i + 1] & 255));
                i += 2;
            }
        }
        return buffer3.D();
    }

    public static int r2(byte[] bArr, int i, s3 s3Var) throws zzij {
        int iO1 = O1(bArr, i, s3Var);
        int i2 = s3Var.a;
        if (i2 < 0) {
            throw zzij.b();
        }
        if (i2 == 0) {
            s3Var.c = "";
            return iO1;
        }
        s3Var.c = new String(bArr, iO1, i2, w4.a);
        return iO1 + i2;
    }

    public static void s(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            job.b(null);
        }
    }

    public static String s0(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.c("yMMMd", locale).format(new Date(j));
        }
        AtomicReference<TimeSource> atomicReference = UtcDates.a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(UtcDates.g());
        return dateInstance.format(new Date(j));
    }

    public static final String s1(Continuation<?> continuation) {
        Object objM97constructorimpl;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result2.a aVar = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(continuation + MentionUtils.MENTIONS_CHAR + l0(continuation));
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
        }
        if (Result2.m99exceptionOrNullimpl(objM97constructorimpl) != null) {
            objM97constructorimpl = continuation.getClass().getName() + MentionUtils.MENTIONS_CHAR + l0(continuation);
        }
        return (String) objM97constructorimpl;
    }

    public static void s2(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? u2(i, i3, "start index") : (i2 < 0 || i2 > i3) ? u2(i2, i3, "end index") : l2("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static /* synthetic */ void t(Job job, CancellationException cancellationException, int i, Object obj) {
        int i2 = i & 1;
        job.b(null);
    }

    public static void t0(@Nullable InputStream inputStream, @NonNull File file) throws Throwable {
        byte[] bArr = new byte[8192];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        gZIPOutputStream2.finish();
                        CommonUtils.d(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, i);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    CommonUtils.d(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final String t1(byte b2) {
        char[] cArr = ByteString4.a;
        return new String(new char[]{cArr[(b2 >> 4) & 15], cArr[b2 & 15]});
    }

    public static int t2(byte[] bArr, int i, s3 s3Var) throws zzij {
        int iO1 = O1(bArr, i, s3Var);
        int i2 = s3Var.a;
        if (i2 < 0) {
            throw zzij.b();
        }
        if (i2 == 0) {
            s3Var.c = "";
            return iO1;
        }
        s3Var.c = k7.a.c(bArr, iO1, i2);
        return iO1 + i2;
    }

    public static final void u(Channel6<?> channel6, Throwable th) {
        CancellationException cancellationExceptionA = null;
        if (th != null) {
            cancellationExceptionA = (CancellationException) (th instanceof CancellationException ? th : null);
            if (cancellationExceptionA == null) {
                cancellationExceptionA = a("Channel was consumed, consumer had failed", th);
            }
        }
        channel6.b(cancellationExceptionA);
    }

    public static final void u0(CoroutineContext coroutineContext, Throwable th) {
        try {
            int i = CoroutineExceptionHandler.g;
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.a.a);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                CoroutineExceptionHandlerImpl.a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                Exceptions.addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            CoroutineExceptionHandlerImpl.a(coroutineContext, th);
        }
    }

    public static String u1(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (c2 >= 'A' && c2 <= 'Z') {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String u2(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return l2("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return l2("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(outline.g(26, "negative size: ", i2));
    }

    public static void v(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static int v0(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static final <T> Object v1(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable thM99exceptionOrNullimpl = Result2.m99exceptionOrNullimpl(obj);
        return thM99exceptionOrNullimpl == null ? function1 != null ? new CompletionState3(obj, function1) : obj : new CompletionState2(thM99exceptionOrNullimpl, false, 2);
    }

    public static int v2(byte[] bArr, int i, s3 s3Var) throws zzij {
        int iO1 = O1(bArr, i, s3Var);
        int i2 = s3Var.a;
        if (i2 < 0) {
            throw zzij.b();
        }
        if (i2 > bArr.length - iO1) {
            throw zzij.a();
        }
        if (i2 == 0) {
            s3Var.c = t3.j;
            return iO1;
        }
        s3Var.c = t3.h(bArr, iO1, i2);
        return iO1 + i2;
    }

    public static void w(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static /* synthetic */ Job2 w0(Job job, boolean z2, boolean z3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return job.n(z2, z3, function1);
    }

    public static String w1(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (c2 >= 'a' && c2 <= 'z') {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static boolean w2(byte b2) {
        return b2 > -65;
    }

    @CanIgnoreReturnValue
    public static int x(int i, int i2) {
        String strI0;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strI0 = I0("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException(outline.q("negative size: ", i2));
            }
            strI0 = I0("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strI0);
    }

    public static Job2 x0(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return DefaultExecutor2.a.x(j, runnable, coroutineContext);
    }

    @NonNull
    public static BaseAction x1(@NonNull BaseAction... baseActionArr) {
        return new TogetherAction(Arrays.asList(baseActionArr));
    }

    public static int x2(String str) {
        if (Log.isLoggable("FirebaseAppIndex", 3) ? true : Log.isLoggable("FirebaseAppIndex", 3)) {
            return Log.d("FirebaseAppIndex", str);
        }
        return 0;
    }

    @CanIgnoreReturnValue
    public static Object y(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(outline.q("at index ", i));
    }

    public static final boolean y0(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE);
        if (job != null) {
            return job.a();
        }
        return true;
    }

    public static RectF y1(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i = 1; i < fArr.length; i += 2) {
            float fRound = Math.round(fArr[i - 1] * 10.0f) / 10.0f;
            float fRound2 = Math.round(fArr[i] * 10.0f) / 10.0f;
            float f = rectF.left;
            if (fRound < f) {
                f = fRound;
            }
            rectF.left = f;
            float f2 = rectF.top;
            if (fRound2 < f2) {
                f2 = fRound2;
            }
            rectF.top = f2;
            float f3 = rectF.right;
            if (fRound <= f3) {
                fRound = f3;
            }
            rectF.right = fRound;
            float f4 = rectF.bottom;
            if (fRound2 <= f4) {
                fRound2 = f4;
            }
            rectF.bottom = fRound2;
        }
        rectF.sort();
        return rectF;
    }

    public static void z(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(outline.v("null key in entry: null=", obj2));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static final boolean z0(AssertionError assertionError) {
        Intrinsics3.checkParameterIsNotNull(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? Strings4.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }

    @TargetApi(19)
    public static boolean z1(@RecentlyNonNull Context context, int i, @RecentlyNonNull String str) {
        b.i.a.f.e.p.a aVarA = b.i.a.f.e.p.b.a(context);
        Objects.requireNonNull(aVarA);
        try {
            AppOpsManager appOpsManager = (AppOpsManager) aVarA.a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
