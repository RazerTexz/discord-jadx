package f0.e0.j;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import f0.e0.f.Task2;
import f0.e0.f.TaskQueue2;
import f0.e0.f.TaskRunner;
import f0.e0.j.Http2Reader;
import f0.e0.j.Http2Stream;
import f0.e0.k.Platform2;
import g0.Buffer3;
import g0.BufferedSource;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.BufferedSink;
import okio.ByteString;

/* compiled from: Http2Connection.kt */
/* renamed from: f0.e0.j.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Http2Connection implements Closeable {
    public static final Settings3 j;
    public static final Http2Connection k = null;
    public long A;
    public long B;
    public long C;
    public final Settings3 D;
    public Settings3 E;
    public long F;
    public long G;
    public long H;
    public long I;
    public final Socket J;
    public final Http2Writer K;
    public final d L;
    public final Set<Integer> M;
    public final boolean l;
    public final c m;
    public final Map<Integer, Http2Stream> n;
    public final String o;
    public int p;
    public int q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final TaskRunner f3638s;
    public final TaskQueue2 t;
    public final TaskQueue2 u;
    public final TaskQueue2 v;
    public final PushObserver2 w;

    /* renamed from: x, reason: collision with root package name */
    public long f3639x;

    /* renamed from: y, reason: collision with root package name */
    public long f3640y;

    /* renamed from: z, reason: collision with root package name */
    public long f3641z;

    /* compiled from: TaskQueue.kt */
    /* renamed from: f0.e0.j.e$a */
    public static final class a extends Task2 {
        public final /* synthetic */ Http2Connection e;
        public final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Http2Connection http2Connection, long j) {
            super(str2, true);
            this.e = http2Connection;
            this.f = j;
        }

        @Override // f0.e0.f.Task2
        public long a() throws IOException {
            Http2Connection http2Connection;
            boolean z2;
            synchronized (this.e) {
                http2Connection = this.e;
                long j = http2Connection.f3640y;
                long j2 = http2Connection.f3639x;
                if (j < j2) {
                    z2 = true;
                } else {
                    http2Connection.f3639x = j2 + 1;
                    z2 = false;
                }
            }
            if (!z2) {
                http2Connection.q(false, 1, 0);
                return this.f;
            }
            ErrorCode2 errorCode2 = ErrorCode2.PROTOCOL_ERROR;
            http2Connection.a(errorCode2, errorCode2, null);
            return -1L;
        }
    }

    /* compiled from: Http2Connection.kt */
    /* renamed from: f0.e0.j.e$b */
    public static final class b {
        public Socket a;

        /* renamed from: b, reason: collision with root package name */
        public String f3642b;
        public BufferedSource c;
        public BufferedSink d;
        public c e;
        public PushObserver2 f;
        public int g;
        public boolean h;
        public final TaskRunner i;

        public b(boolean z2, TaskRunner taskRunner) {
            Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
            this.h = z2;
            this.i = taskRunner;
            this.e = c.a;
            this.f = PushObserver2.a;
        }
    }

    /* compiled from: Http2Connection.kt */
    /* renamed from: f0.e0.j.e$c */
    public static abstract class c {
        public static final c a = new a();

        /* compiled from: Http2Connection.kt */
        /* renamed from: f0.e0.j.e$c$a */
        public static final class a extends c {
            @Override // f0.e0.j.Http2Connection.c
            public void b(Http2Stream http2Stream) throws IOException {
                Intrinsics3.checkParameterIsNotNull(http2Stream, "stream");
                http2Stream.c(ErrorCode2.REFUSED_STREAM, null);
            }
        }

        public void a(Http2Connection http2Connection, Settings3 settings3) {
            Intrinsics3.checkParameterIsNotNull(http2Connection, "connection");
            Intrinsics3.checkParameterIsNotNull(settings3, "settings");
        }

        public abstract void b(Http2Stream http2Stream) throws IOException;
    }

    /* compiled from: Http2Connection.kt */
    /* renamed from: f0.e0.j.e$d */
    public final class d implements Http2Reader.b, Function0<Unit> {
        public final Http2Reader j;
        public final /* synthetic */ Http2Connection k;

        /* compiled from: TaskQueue.kt */
        /* renamed from: f0.e0.j.e$d$a */
        public static final class a extends Task2 {
            public final /* synthetic */ Http2Stream e;
            public final /* synthetic */ d f;
            public final /* synthetic */ List g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z2, String str2, boolean z3, Http2Stream http2Stream, d dVar, Http2Stream http2Stream2, int i, List list, boolean z4) {
                super(str2, z3);
                this.e = http2Stream;
                this.f = dVar;
                this.g = list;
            }

            @Override // f0.e0.f.Task2
            public long a() {
                try {
                    this.f.k.m.b(this.e);
                    return -1L;
                } catch (IOException e) {
                    Platform2.a aVar = Platform2.c;
                    Platform2 platform2 = Platform2.a;
                    StringBuilder sbU = outline.U("Http2Connection.Listener failure for ");
                    sbU.append(this.f.k.o);
                    platform2.i(sbU.toString(), 4, e);
                    try {
                        this.e.c(ErrorCode2.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* compiled from: TaskQueue.kt */
        /* renamed from: f0.e0.j.e$d$b */
        public static final class b extends Task2 {
            public final /* synthetic */ d e;
            public final /* synthetic */ int f;
            public final /* synthetic */ int g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z2, String str2, boolean z3, d dVar, int i, int i2) {
                super(str2, z3);
                this.e = dVar;
                this.f = i;
                this.g = i2;
            }

            @Override // f0.e0.f.Task2
            public long a() throws IOException {
                this.e.k.q(true, this.f, this.g);
                return -1L;
            }
        }

        /* compiled from: TaskQueue.kt */
        /* renamed from: f0.e0.j.e$d$c */
        public static final class c extends Task2 {
            public final /* synthetic */ d e;
            public final /* synthetic */ boolean f;
            public final /* synthetic */ Settings3 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z2, String str2, boolean z3, d dVar, boolean z4, Settings3 settings3) {
                super(str2, z3);
                this.e = dVar;
                this.f = z4;
                this.g = settings3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v0, types: [T, f0.e0.j.s, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r3v0, types: [T, f0.e0.j.s] */
            @Override // f0.e0.f.Task2
            public long a() throws Throwable {
                Http2Writer http2Writer;
                Http2Connection http2Connection;
                T t;
                TaskQueue2 taskQueue2;
                String str;
                d dVar = this.e;
                boolean z2 = this.f;
                ?? r10 = this.g;
                Objects.requireNonNull(dVar);
                Intrinsics3.checkParameterIsNotNull(r10, "settings");
                Ref$LongRef ref$LongRef = new Ref$LongRef();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                Http2Writer http2Writer2 = dVar.k.K;
                synchronized (http2Writer2) {
                    try {
                        Http2Connection http2Connection2 = dVar.k;
                        try {
                            synchronized (http2Connection2) {
                                try {
                                    Settings3 settings3 = dVar.k.E;
                                    if (z2) {
                                        ref$ObjectRef2.element = r10;
                                    } else {
                                        ?? settings32 = new Settings3();
                                        settings32.b(settings3);
                                        settings32.b(r10);
                                        ref$ObjectRef2.element = settings32;
                                    }
                                    long jA = ((Settings3) ref$ObjectRef2.element).a() - settings3.a();
                                    ref$LongRef.element = jA;
                                    if (jA == 0 || dVar.k.n.isEmpty()) {
                                        t = 0;
                                    } else {
                                        Object[] array = dVar.k.n.values().toArray(new Http2Stream[0]);
                                        if (array == null) {
                                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                        t = (Http2Stream[]) array;
                                    }
                                    ref$ObjectRef.element = t;
                                    Http2Connection http2Connection3 = dVar.k;
                                    Settings3 settings33 = (Settings3) ref$ObjectRef2.element;
                                    Objects.requireNonNull(http2Connection3);
                                    Intrinsics3.checkParameterIsNotNull(settings33, "<set-?>");
                                    http2Connection3.E = settings33;
                                    taskQueue2 = dVar.k.v;
                                    str = dVar.k.o + " onSettings";
                                    http2Connection = http2Connection2;
                                    http2Writer = http2Writer2;
                                } catch (Throwable th) {
                                    th = th;
                                    http2Connection = http2Connection2;
                                }
                                try {
                                    taskQueue2.c(new TaskQueue3(str, true, str, true, dVar, z2, ref$ObjectRef2, r10, ref$LongRef, ref$ObjectRef), 0L);
                                    try {
                                        dVar.k.K.a((Settings3) ref$ObjectRef2.element);
                                    } catch (IOException e) {
                                        Http2Connection http2Connection4 = dVar.k;
                                        ErrorCode2 errorCode2 = ErrorCode2.PROTOCOL_ERROR;
                                        http2Connection4.a(errorCode2, errorCode2, e);
                                    }
                                    Http2Stream[] http2StreamArr = (Http2Stream[]) ref$ObjectRef.element;
                                    if (http2StreamArr == null) {
                                        return -1L;
                                    }
                                    if (http2StreamArr == null) {
                                        Intrinsics3.throwNpe();
                                    }
                                    for (Http2Stream http2Stream : http2StreamArr) {
                                        synchronized (http2Stream) {
                                            long j = ref$LongRef.element;
                                            http2Stream.d += j;
                                            if (j > 0) {
                                                http2Stream.notifyAll();
                                            }
                                        }
                                    }
                                    return -1L;
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        http2Writer = http2Writer2;
                    }
                }
            }
        }

        public d(Http2Connection http2Connection, Http2Reader http2Reader) {
            Intrinsics3.checkParameterIsNotNull(http2Reader, "reader");
            this.k = http2Connection;
            this.j = http2Reader;
        }

        @Override // f0.e0.j.Http2Reader.b
        public void a() {
        }

        @Override // f0.e0.j.Http2Reader.b
        public void b(boolean z2, Settings3 settings3) {
            Intrinsics3.checkParameterIsNotNull(settings3, "settings");
            TaskQueue2 taskQueue2 = this.k.t;
            String strJ = outline.J(new StringBuilder(), this.k.o, " applyAndAckSettings");
            taskQueue2.c(new c(strJ, true, strJ, true, this, z2, settings3), 0L);
        }

        @Override // f0.e0.j.Http2Reader.b
        public void c(boolean z2, int i, int i2, List<Header2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "headerBlock");
            if (this.k.c(i)) {
                Http2Connection http2Connection = this.k;
                Objects.requireNonNull(http2Connection);
                Intrinsics3.checkParameterIsNotNull(list, "requestHeaders");
                TaskQueue2 taskQueue2 = http2Connection.u;
                String str = http2Connection.o + '[' + i + "] onHeaders";
                taskQueue2.c(new TaskQueue5(str, true, str, true, http2Connection, i, list, z2), 0L);
                return;
            }
            synchronized (this.k) {
                Http2Stream http2StreamB = this.k.b(i);
                if (http2StreamB != null) {
                    http2StreamB.j(Util7.w(list), z2);
                    return;
                }
                Http2Connection http2Connection2 = this.k;
                if (http2Connection2.r) {
                    return;
                }
                if (i <= http2Connection2.p) {
                    return;
                }
                if (i % 2 == http2Connection2.q % 2) {
                    return;
                }
                Http2Stream http2Stream = new Http2Stream(i, this.k, false, z2, Util7.w(list));
                Http2Connection http2Connection3 = this.k;
                http2Connection3.p = i;
                http2Connection3.n.put(Integer.valueOf(i), http2Stream);
                TaskQueue2 taskQueue2F = this.k.f3638s.f();
                String str2 = this.k.o + '[' + i + "] onStream";
                taskQueue2F.c(new a(str2, true, str2, true, http2Stream, this, http2StreamB, i, list, z2), 0L);
            }
        }

        @Override // f0.e0.j.Http2Reader.b
        public void d(int i, long j) {
            if (i == 0) {
                synchronized (this.k) {
                    Http2Connection http2Connection = this.k;
                    http2Connection.I += j;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream http2StreamB = this.k.b(i);
            if (http2StreamB != null) {
                synchronized (http2StreamB) {
                    http2StreamB.d += j;
                    if (j > 0) {
                        http2StreamB.notifyAll();
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00f1, code lost:
        
            throw new kotlin.TypeCastException("null cannot be cast to non-null type java.lang.Object");
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0108, code lost:
        
            if (r18 == false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x010a, code lost:
        
            r3.j(f0.e0.Util7.f3605b, true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x010f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        
            return;
         */
        @Override // f0.e0.j.Http2Reader.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void e(boolean z2, int i, BufferedSource bufferedSource, int i2) throws IOException {
            boolean z3;
            boolean z4;
            long j;
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            if (!this.k.c(i)) {
                Http2Stream http2StreamB = this.k.b(i);
                if (http2StreamB != null) {
                    Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
                    byte[] bArr = Util7.a;
                    Http2Stream.b bVar = http2StreamB.g;
                    long j2 = i2;
                    Objects.requireNonNull(bVar);
                    Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
                    while (true) {
                        boolean z5 = true;
                        if (j2 <= 0) {
                            break;
                        }
                        synchronized (Http2Stream.this) {
                            z3 = bVar.n;
                            z4 = bVar.k.k + j2 > bVar.m;
                        }
                        if (z4) {
                            bufferedSource.skip(j2);
                            Http2Stream.this.e(ErrorCode2.FLOW_CONTROL_ERROR);
                            break;
                        }
                        if (z3) {
                            bufferedSource.skip(j2);
                            break;
                        }
                        long jI0 = bufferedSource.i0(bVar.j, j2);
                        if (jI0 == -1) {
                            throw new EOFException();
                        }
                        j2 -= jI0;
                        synchronized (Http2Stream.this) {
                            if (bVar.l) {
                                Buffer3 buffer3 = bVar.j;
                                j = buffer3.k;
                                buffer3.skip(j);
                            } else {
                                Buffer3 buffer32 = bVar.k;
                                if (buffer32.k != 0) {
                                    z5 = false;
                                }
                                buffer32.P(bVar.j);
                                if (z5) {
                                    Http2Stream http2Stream = Http2Stream.this;
                                    if (http2Stream == null) {
                                        break;
                                    } else {
                                        http2Stream.notifyAll();
                                    }
                                }
                                j = 0;
                            }
                        }
                        if (j > 0) {
                            bVar.a(j);
                        }
                    }
                } else {
                    this.k.s(i, ErrorCode2.PROTOCOL_ERROR);
                    long j3 = i2;
                    this.k.f(j3);
                    bufferedSource.skip(j3);
                }
            } else {
                Http2Connection http2Connection = this.k;
                Objects.requireNonNull(http2Connection);
                Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
                Buffer3 buffer33 = new Buffer3();
                long j4 = i2;
                bufferedSource.p0(j4);
                bufferedSource.i0(buffer33, j4);
                TaskQueue2 taskQueue2 = http2Connection.u;
                String str = http2Connection.o + '[' + i + "] onData";
                taskQueue2.c(new TaskQueue4(str, true, str, true, http2Connection, i, buffer33, i2, z2), 0L);
            }
        }

        @Override // f0.e0.j.Http2Reader.b
        public void f(boolean z2, int i, int i2) {
            if (!z2) {
                TaskQueue2 taskQueue2 = this.k.t;
                String strJ = outline.J(new StringBuilder(), this.k.o, " ping");
                taskQueue2.c(new b(strJ, true, strJ, true, this, i, i2), 0L);
                return;
            }
            synchronized (this.k) {
                if (i == 1) {
                    this.k.f3640y++;
                } else if (i == 2) {
                    this.k.A++;
                } else if (i == 3) {
                    Http2Connection http2Connection = this.k;
                    http2Connection.B++;
                    http2Connection.notifyAll();
                }
            }
        }

        @Override // f0.e0.j.Http2Reader.b
        public void g(int i, int i2, int i3, boolean z2) {
        }

        @Override // f0.e0.j.Http2Reader.b
        public void h(int i, ErrorCode2 errorCode2) {
            Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
            if (!this.k.c(i)) {
                Http2Stream http2StreamD = this.k.d(i);
                if (http2StreamD != null) {
                    http2StreamD.k(errorCode2);
                    return;
                }
                return;
            }
            Http2Connection http2Connection = this.k;
            Objects.requireNonNull(http2Connection);
            Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
            TaskQueue2 taskQueue2 = http2Connection.u;
            String str = http2Connection.o + '[' + i + "] onReset";
            taskQueue2.c(new TaskQueue7(str, true, str, true, http2Connection, i, errorCode2), 0L);
        }

        @Override // f0.e0.j.Http2Reader.b
        public void i(int i, int i2, List<Header2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "requestHeaders");
            Http2Connection http2Connection = this.k;
            Objects.requireNonNull(http2Connection);
            Intrinsics3.checkParameterIsNotNull(list, "requestHeaders");
            synchronized (http2Connection) {
                if (http2Connection.M.contains(Integer.valueOf(i2))) {
                    http2Connection.s(i2, ErrorCode2.PROTOCOL_ERROR);
                    return;
                }
                http2Connection.M.add(Integer.valueOf(i2));
                TaskQueue2 taskQueue2 = http2Connection.u;
                String str = http2Connection.o + '[' + i2 + "] onRequest";
                taskQueue2.c(new TaskQueue6(str, true, str, true, http2Connection, i2, list), 0L);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [f0.e0.j.a] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.Unit] */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() throws Throwable {
            Throwable th;
            ErrorCode2 errorCode2;
            ErrorCode2 errorCode22 = ErrorCode2.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.j.b(this);
                    while (this.j.a(false, this)) {
                    }
                    ErrorCode2 errorCode23 = ErrorCode2.NO_ERROR;
                    try {
                        this.k.a(errorCode23, ErrorCode2.CANCEL, null);
                        errorCode2 = errorCode23;
                    } catch (IOException e2) {
                        e = e2;
                        ErrorCode2 errorCode24 = ErrorCode2.PROTOCOL_ERROR;
                        Http2Connection http2Connection = this.k;
                        http2Connection.a(errorCode24, errorCode24, e);
                        errorCode2 = http2Connection;
                        Util7.d(this.j);
                        errorCode22 = Unit.a;
                        return errorCode22;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.k.a(errorCode2, errorCode22, e);
                    Util7.d(this.j);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                errorCode2 = errorCode22;
                this.k.a(errorCode2, errorCode22, e);
                Util7.d(this.j);
                throw th;
            }
            Util7.d(this.j);
            errorCode22 = Unit.a;
            return errorCode22;
        }

        @Override // f0.e0.j.Http2Reader.b
        public void j(int i, ErrorCode2 errorCode2, ByteString byteString) {
            int i2;
            Http2Stream[] http2StreamArr;
            Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
            Intrinsics3.checkParameterIsNotNull(byteString, "debugData");
            byteString.j();
            synchronized (this.k) {
                Object[] array = this.k.n.values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                http2StreamArr = (Http2Stream[]) array;
                this.k.r = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.m > i && http2Stream.h()) {
                    http2Stream.k(ErrorCode2.REFUSED_STREAM);
                    this.k.d(http2Stream.m);
                }
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: f0.e0.j.e$e */
    public static final class e extends Task2 {
        public final /* synthetic */ Http2Connection e;
        public final /* synthetic */ int f;
        public final /* synthetic */ ErrorCode2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, ErrorCode2 errorCode2) {
            super(str2, z3);
            this.e = http2Connection;
            this.f = i;
            this.g = errorCode2;
        }

        @Override // f0.e0.f.Task2
        public long a() throws IOException {
            try {
                Http2Connection http2Connection = this.e;
                int i = this.f;
                ErrorCode2 errorCode2 = this.g;
                Objects.requireNonNull(http2Connection);
                Intrinsics3.checkParameterIsNotNull(errorCode2, "statusCode");
                http2Connection.K.n(i, errorCode2);
                return -1L;
            } catch (IOException e) {
                Http2Connection http2Connection2 = this.e;
                ErrorCode2 errorCode22 = ErrorCode2.PROTOCOL_ERROR;
                http2Connection2.a(errorCode22, errorCode22, e);
                return -1L;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* renamed from: f0.e0.j.e$f */
    public static final class f extends Task2 {
        public final /* synthetic */ Http2Connection e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, long j) {
            super(str2, z3);
            this.e = http2Connection;
            this.f = i;
            this.g = j;
        }

        @Override // f0.e0.f.Task2
        public long a() throws IOException {
            try {
                this.e.K.q(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                Http2Connection http2Connection = this.e;
                ErrorCode2 errorCode2 = ErrorCode2.PROTOCOL_ERROR;
                http2Connection.a(errorCode2, errorCode2, e);
                return -1L;
            }
        }
    }

    static {
        Settings3 settings3 = new Settings3();
        settings3.c(7, 65535);
        settings3.c(5, 16384);
        j = settings3;
    }

    public Http2Connection(b bVar) {
        Intrinsics3.checkParameterIsNotNull(bVar, "builder");
        boolean z2 = bVar.h;
        this.l = z2;
        this.m = bVar.e;
        this.n = new LinkedHashMap();
        String str = bVar.f3642b;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("connectionName");
        }
        this.o = str;
        this.q = bVar.h ? 3 : 2;
        TaskRunner taskRunner = bVar.i;
        this.f3638s = taskRunner;
        TaskQueue2 taskQueue2F = taskRunner.f();
        this.t = taskQueue2F;
        this.u = taskRunner.f();
        this.v = taskRunner.f();
        this.w = bVar.f;
        Settings3 settings3 = new Settings3();
        if (bVar.h) {
            settings3.c(7, 16777216);
        }
        this.D = settings3;
        this.E = j;
        this.I = r2.a();
        Socket socket = bVar.a;
        if (socket == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("socket");
        }
        this.J = socket;
        BufferedSink bufferedSink = bVar.d;
        if (bufferedSink == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("sink");
        }
        this.K = new Http2Writer(bufferedSink, z2);
        BufferedSource bufferedSource = bVar.c;
        if (bufferedSource == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("source");
        }
        this.L = new d(this, new Http2Reader(bufferedSource, z2));
        this.M = new LinkedHashSet();
        int i = bVar.g;
        if (i != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            String strW = outline.w(str, " ping");
            taskQueue2F.c(new a(strW, strW, this, nanos), nanos);
        }
    }

    public final void a(ErrorCode2 errorCode2, ErrorCode2 errorCode22, IOException iOException) throws IOException {
        int i;
        Intrinsics3.checkParameterIsNotNull(errorCode2, "connectionCode");
        Intrinsics3.checkParameterIsNotNull(errorCode22, "streamCode");
        byte[] bArr = Util7.a;
        try {
            e(errorCode2);
        } catch (IOException unused) {
        }
        Http2Stream[] http2StreamArr = null;
        synchronized (this) {
            if (!this.n.isEmpty()) {
                Object[] array = this.n.values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                http2StreamArr = (Http2Stream[]) array;
                this.n.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.c(errorCode22, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.K.close();
        } catch (IOException unused3) {
        }
        try {
            this.J.close();
        } catch (IOException unused4) {
        }
        this.t.f();
        this.u.f();
        this.v.f();
    }

    public final synchronized Http2Stream b(int i) {
        return this.n.get(Integer.valueOf(i));
    }

    public final boolean c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(ErrorCode2.NO_ERROR, ErrorCode2.CANCEL, null);
    }

    public final synchronized Http2Stream d(int i) {
        Http2Stream http2StreamRemove;
        http2StreamRemove = this.n.remove(Integer.valueOf(i));
        notifyAll();
        return http2StreamRemove;
    }

    public final void e(ErrorCode2 errorCode2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "statusCode");
        synchronized (this.K) {
            synchronized (this) {
                if (this.r) {
                    return;
                }
                this.r = true;
                this.K.d(this.p, errorCode2, Util7.a);
            }
        }
    }

    public final synchronized void f(long j2) {
        long j3 = this.F + j2;
        this.F = j3;
        long j4 = j3 - this.G;
        if (j4 >= this.D.a() / 2) {
            t(0, j4);
            this.G += j4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r5 = (int) java.lang.Math.min(r13, r6 - r4);
        r3.element = r5;
        r4 = java.lang.Math.min(r5, r9.K.l);
        r3.element = r4;
        r9.H += r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, boolean z2, Buffer3 buffer3, long j2) throws IOException {
        int iMin;
        if (j2 == 0) {
            this.K.b(z2, i, buffer3, 0);
            return;
        }
        while (j2 > 0) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                while (true) {
                    try {
                        long j3 = this.H;
                        long j4 = this.I;
                        if (j3 < j4) {
                            break;
                        } else {
                            if (!this.n.containsKey(Integer.valueOf(i))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
            }
            j2 -= iMin;
            this.K.b(z2 && j2 == 0, i, buffer3, iMin);
        }
    }

    public final void q(boolean z2, int i, int i2) throws IOException {
        try {
            this.K.f(z2, i, i2);
        } catch (IOException e2) {
            ErrorCode2 errorCode2 = ErrorCode2.PROTOCOL_ERROR;
            a(errorCode2, errorCode2, e2);
        }
    }

    public final void s(int i, ErrorCode2 errorCode2) {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        TaskQueue2 taskQueue2 = this.t;
        String str = this.o + '[' + i + "] writeSynReset";
        taskQueue2.c(new e(str, true, str, true, this, i, errorCode2), 0L);
    }

    public final void t(int i, long j2) {
        TaskQueue2 taskQueue2 = this.t;
        String str = this.o + '[' + i + "] windowUpdate";
        taskQueue2.c(new f(str, true, str, true, this, i, j2), 0L);
    }
}
