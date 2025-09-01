package b.c.a.a0;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.os.Trace;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import b.a.t.b.c.NodeProcessor;
import b.c.a.LottieComposition;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.b0.Utils;
import b.c.a.c0.Keyframe;
import b.c.a.y.k.AnimatableColorValue;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableIntegerValue;
import b.c.a.y.k.AnimatablePointValue;
import b.d.b.a.outline;
import b.f.b.a.MultiCacheKey;
import b.f.d.c.FileTreeVisitor;
import b.f.d.d.Objects2;
import b.f.d.e.FLog;
import b.f.e.SimpleDataSource;
import b.f.g.e.ArrayDrawable2;
import b.f.g.e.AutoRotateDrawable;
import b.f.g.e.DrawableParent;
import b.f.g.e.DrawableProperties;
import b.f.g.e.ScaleTypeDrawable;
import b.f.g.e.TransformAwareDrawable;
import b.f.g.e.TransformCallback;
import b.f.g.f.GenericDraweeHierarchyBuilder;
import b.f.g.f.RoundingParams;
import b.f.i.DefaultImageFormats;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import b.f.j.j.EncodedImage2;
import b.f.j.t.BitmapTransformation;
import b.f.m.MinElf;
import b.f.m.n.NativeLoader;
import b.g.a.a.JsonInclude;
import b.g.a.c.JavaType;
import b.g.a.c.c0.TypeResolutionContext;
import b.g.a.c.h0.TypeBindings;
import b.g.a.c.i0.ClassUtil;
import b.i.a.b.i.CctTransportBackend;
import b.i.a.b.i.CctTransportBackend3;
import b.i.a.b.j.s.RetryStrategy;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.t.TtmlStyle;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.z.Projection;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.FlacStreamMetadata;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.VorbisUtil3;
import b.i.a.c.x2.i0.PsshAtomUtil;
import b.i.a.c.x2.l0.WavHeaderReader;
import b.i.a.c.z2.k.Id3Decoder;
import b.i.b.a.Predicate3;
import com.adjust.sdk.Constants;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppPermissions2;
import com.discord.i18n.RenderContext;
import com.discord.player.MediaSource;
import com.discord.player.MediaType;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$FileDeleteException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.R;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.soloader.SysUtil$LollipopSysdeps;
import com.facebook.soloader.SysUtil$MarshmallowSysdeps;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.Inflater;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;
import org.objectweb.asm.Opcodes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatableValueParser.java */
/* renamed from: b.c.a.a0.d, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableValueParser {
    public static boolean a;

    /* renamed from: b, reason: collision with root package name */
    public static ScheduledExecutorService f329b;

    @Nullable
    public static Boolean c;

    @Nullable
    public static Boolean d;

    @Nullable
    public static Boolean e;

    @Nullable
    public static Boolean f;

    /* compiled from: ArrayBuilders.java */
    /* renamed from: b.c.a.a0.d$a */
    /* loaded from: classes3.dex */
    public static class a {
        public final /* synthetic */ Class a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f330b;
        public final /* synthetic */ Object c;

        public a(Class cls, int i, Object obj) {
            this.a = cls;
            this.f330b = i;
            this.c = obj;
        }

        public boolean equals(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
            if (obj == this) {
                return true;
            }
            if (!ClassUtil.o(obj, this.a) || Array.getLength(obj) != this.f330b) {
                return false;
            }
            for (int i = 0; i < this.f330b; i++) {
                Object obj2 = Array.get(this.c, i);
                Object obj3 = Array.get(obj, i);
                if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        }
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    public static <T> T A(@Nullable T t) {
        Objects.requireNonNull(t, "null reference");
        return t;
    }

    public static ScalingUtils$ScaleType A0(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
                return b.f.g.e.z.l;
            case 1:
                ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.a;
                return b.f.g.e.x.l;
            case 2:
                ScalingUtils$ScaleType scalingUtils$ScaleType3 = ScalingUtils$ScaleType.a;
                return b.f.g.e.v.l;
            case 3:
                ScalingUtils$ScaleType scalingUtils$ScaleType4 = ScalingUtils$ScaleType.a;
                return b.f.g.e.w.l;
            case 4:
                ScalingUtils$ScaleType scalingUtils$ScaleType5 = ScalingUtils$ScaleType.a;
                return b.f.g.e.r.l;
            case 5:
                ScalingUtils$ScaleType scalingUtils$ScaleType6 = ScalingUtils$ScaleType.a;
                return b.f.g.e.t.l;
            case 6:
                ScalingUtils$ScaleType scalingUtils$ScaleType7 = ScalingUtils$ScaleType.a;
                return b.f.g.e.s.l;
            case 7:
                ScalingUtils$ScaleType scalingUtils$ScaleType8 = ScalingUtils$ScaleType.a;
                return b.f.g.e.b0.l;
            case 8:
                ScalingUtils$ScaleType scalingUtils$ScaleType9 = ScalingUtils$ScaleType.a;
                return b.f.g.e.u.l;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    public static boolean A1(TypeResolutionContext typeResolutionContext, JavaType javaType, Type type) {
        if (!javaType.B(typeResolutionContext.a(type)._class)) {
            return false;
        }
        ParameterizedType parameterizedTypeH1 = h1(type);
        if (parameterizedTypeH1 == null || !Objects.equals(javaType._class, parameterizedTypeH1.getRawType())) {
            return true;
        }
        Type[] actualTypeArguments = parameterizedTypeH1.getActualTypeArguments();
        TypeBindings typeBindingsJ = javaType.j();
        if (typeBindingsJ.j() != actualTypeArguments.length) {
            return false;
        }
        for (int i = 0; i < typeBindingsJ.j(); i++) {
            if (!A1(typeResolutionContext, typeBindingsJ.f(i), actualTypeArguments[i])) {
                return false;
            }
        }
        return true;
    }

    public static void A2(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void B(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    @NonNull
    public static String B0(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                return outline.g(32, "unknown status code: ", i);
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }

    public static int B1(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static <T extends Parcelable> void B2(Parcel parcel, T t, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static void C(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static String[] C0() {
        return Build.VERSION.SDK_INT >= 23 ? SysUtil$MarshmallowSysdeps.getSupportedAbis() : SysUtil$LollipopSysdeps.getSupportedAbis();
    }

    public static void C1(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int i2;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (i2 = fileChannel.read(byteBuffer, j)) != -1) {
            j += i2;
        }
        if (byteBuffer.remaining() > 0) {
            throw new MinElf("ELF file truncated");
        }
        byteBuffer.position(0);
    }

    @Pure
    public static void D(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static String D0(String str) {
        return outline.w("TransportRuntime.", str);
    }

    public static int D1(InputStream inputStream) throws IOException {
        byte b2 = (byte) (inputStream.read() & 255);
        return ((((byte) (inputStream.read() & 255)) << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((((byte) (inputStream.read() & 255)) << 8) & 65280) | (b2 & 255);
    }

    @Pure
    public static void E(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static Pair<Integer, Integer> E0(InputStream inputStream) throws IOException {
        inputStream.skip(7L);
        short s2 = (short) (inputStream.read() & 255);
        short s3 = (short) (inputStream.read() & 255);
        short s4 = (short) (inputStream.read() & 255);
        if (s2 == 157 && s3 == 1 && s4 == 42) {
            return new Pair<>(Integer.valueOf(n0(inputStream)), Integer.valueOf(n0(inputStream)));
        }
        return null;
    }

    public static boolean E1(@RecentlyNonNull Parcel parcel, int i) {
        x2(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static void F(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static Pair<Integer, Integer> F0(InputStream inputStream) throws IOException {
        w0(inputStream);
        if (((byte) (inputStream.read() & 255)) != 47) {
            return null;
        }
        int i = ((byte) inputStream.read()) & 255;
        int i2 = ((byte) inputStream.read()) & 255;
        return new Pair<>(Integer.valueOf((i | ((i2 & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((i2 & Opcodes.CHECKCAST) >> 6)) + 1));
    }

    @RecentlyNonNull
    public static IBinder F1(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iM1);
        return strongBinder;
    }

    public static void G(boolean z2, @RecentlyNonNull Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static long G0(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        C1(fileChannel, byteBuffer, 4, j);
        return byteBuffer.getInt() & 4294967295L;
    }

    public static int G1(@RecentlyNonNull Parcel parcel, int i) {
        x2(parcel, i, 4);
        return parcel.readInt();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T H(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    public static final boolean H0(Long l, long j) {
        return l != null && (l.longValue() & j) == j;
    }

    public static long H1(@RecentlyNonNull Parcel parcel, int i) {
        x2(parcel, i, 8);
        return parcel.readLong();
    }

    public static boolean I(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (str.charAt(i) != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean I0(byte[] bArr, byte[] bArr2, int i) {
        Objects.requireNonNull(bArr);
        Objects.requireNonNull(bArr2);
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int I1(ParsableByteArray parsableByteArray) {
        int i = 0;
        while (parsableByteArray.a() != 0) {
            int iT = parsableByteArray.t();
            i += iT;
            if (iT != 255) {
                return i;
            }
        }
        return -1;
    }

    public static void J(long j, ParsableByteArray parsableByteArray, TrackOutput2[] trackOutput2Arr) {
        while (true) {
            if (parsableByteArray.a() <= 1) {
                return;
            }
            int iI1 = I1(parsableByteArray);
            int iI12 = I1(parsableByteArray);
            int i = parsableByteArray.f984b + iI12;
            if (iI12 == -1 || iI12 > parsableByteArray.a()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                i = parsableByteArray.c;
            } else if (iI1 == 4 && iI12 >= 8) {
                int iT = parsableByteArray.t();
                int iY = parsableByteArray.y();
                int iF = iY == 49 ? parsableByteArray.f() : 0;
                int iT2 = parsableByteArray.t();
                if (iY == 47) {
                    parsableByteArray.F(1);
                }
                boolean z2 = iT == 181 && (iY == 49 || iY == 47) && iT2 == 3;
                if (iY == 49) {
                    z2 &= iF == 1195456820;
                }
                if (z2) {
                    K(j, parsableByteArray, trackOutput2Arr);
                }
            }
            parsableByteArray.E(i);
        }
    }

    public static int J0(int i, int i2) {
        return ((i + 31) * 31) + i2;
    }

    public static int J1(InputStream inputStream, int i, boolean z2) throws IOException {
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw new IOException("no more bytes");
            }
            if (z2) {
                i2 = (i5 & 255) << (i4 * 8);
            } else {
                i3 <<= 8;
                i2 = i5 & 255;
            }
            i3 |= i2;
        }
        return i3;
    }

    public static void K(long j, ParsableByteArray parsableByteArray, TrackOutput2[] trackOutput2Arr) {
        int iT = parsableByteArray.t();
        if ((iT & 64) != 0) {
            parsableByteArray.F(1);
            int i = (iT & 31) * 3;
            int i2 = parsableByteArray.f984b;
            for (TrackOutput2 trackOutput2 : trackOutput2Arr) {
                parsableByteArray.E(i2);
                trackOutput2.c(parsableByteArray, i);
                if (j != -9223372036854775807L) {
                    trackOutput2.d(j, 1, i, 0, null);
                }
            }
        }
    }

    public static int K0(Object obj, Object obj2) {
        return J0(obj == null ? 0 : obj.hashCode(), obj2 != null ? obj2.hashCode() : 0);
    }

    public static long K1(ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.E(i);
        if (parsableByteArray.a() < 5) {
            return -9223372036854775807L;
        }
        int iF = parsableByteArray.f();
        if ((8388608 & iF) != 0 || ((2096896 & iF) >> 8) != i2) {
            return -9223372036854775807L;
        }
        if (((iF & 32) != 0) && parsableByteArray.t() >= 7 && parsableByteArray.a() >= 7) {
            if ((parsableByteArray.t() & 16) == 16) {
                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, new byte[6], 0, 6);
                parsableByteArray.f984b += 6;
                return ((r0[0] & 255) << 25) | ((r0[1] & 255) << 17) | ((r0[2] & 255) << 9) | ((r0[3] & 255) << 1) | ((r0[4] & 255) >> 7);
            }
        }
        return -9223372036854775807L;
    }

    public static void L(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    public static void L0(String str, String str2) {
        Log.i(D0(str), str2);
    }

    public static FlacStreamMetadata.a L1(ParsableByteArray parsableByteArray) {
        parsableByteArray.F(1);
        int iV = parsableByteArray.v();
        long j = parsableByteArray.f984b + iV;
        int i = iV / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long jM = parsableByteArray.m();
            if (jM == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jM;
            jArrCopyOf2[i2] = parsableByteArray.m();
            parsableByteArray.F(2);
            i2++;
        }
        parsableByteArray.F((int) (j - parsableByteArray.f984b));
        return new FlacStreamMetadata.a(jArrCopyOf, jArrCopyOf2);
    }

    @RecentlyNonNull
    public static Bundle M(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iM1);
        return bundle;
    }

    public static int M0(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static int M1(@RecentlyNonNull Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    @RecentlyNonNull
    public static byte[] N(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iM1);
        return bArrCreateByteArray;
    }

    public static <T> DataSource<T> N0(Throwable th) {
        SimpleDataSource simpleDataSource = new SimpleDataSource();
        Objects.requireNonNull(th);
        simpleDataSource.k(th, null);
        return simpleDataSource;
    }

    public static VorbisUtil3 N1(ParsableByteArray parsableByteArray, boolean z2, boolean z3) throws ParserException {
        if (z2) {
            n2(3, parsableByteArray, false);
        }
        String strQ = parsableByteArray.q((int) parsableByteArray.j());
        int length = strQ.length() + 11;
        long j = parsableByteArray.j();
        String[] strArr = new String[(int) j];
        int length2 = length + 4;
        for (int i = 0; i < j; i++) {
            strArr[i] = parsableByteArray.q((int) parsableByteArray.j());
            length2 = length2 + 4 + strArr[i].length();
        }
        if (z3 && (parsableByteArray.t() & 1) == 0) {
            throw ParserException.a("framing bit expected to be set", null);
        }
        return new VorbisUtil3(strQ, strArr, length2 + 1);
    }

    @RecentlyNonNull
    public static int[] O(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iM1);
        return iArrCreateIntArray;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c6 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01cc A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ce A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d6 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01db A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01dd A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e3 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int O0(Map<String, List<String>> map) {
        char c2;
        List<String> list = map.get("Content-Type");
        String str = (list == null || list.isEmpty()) ? null : list.get(0);
        if (str != null) {
            ArrayList<MimeTypes.a> arrayList = MimeTypes.a;
            int iHashCode = str.hashCode();
            char c3 = 2;
            if (iHashCode == -1007807498) {
                if (str.equals("audio/x-flac")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                }
                switch (str.hashCode()) {
                    case -2123537834:
                        break;
                    case -1662384011:
                        break;
                    case -1662384007:
                        break;
                    case -1662095187:
                        break;
                    case -1606874997:
                        break;
                    case -1487394660:
                        break;
                    case -1248337486:
                        break;
                    case -1004728940:
                        break;
                    case -387023398:
                        break;
                    case -43467528:
                        break;
                    case 13915911:
                        break;
                    case 187078296:
                        break;
                    case 187078297:
                        break;
                    case 187078669:
                        break;
                    case 187090232:
                        break;
                    case 187091926:
                        break;
                    case 187099443:
                        break;
                    case 1331848029:
                        break;
                    case 1503095341:
                        break;
                    case 1504578661:
                        break;
                    case 1504619009:
                        break;
                    case 1504831518:
                        break;
                    case 1505118770:
                        break;
                    case 2039520277:
                        break;
                }
                switch (c3) {
                }
            } else {
                if (iHashCode != -586683234) {
                    c2 = (iHashCode == 187090231 && str.equals("audio/mp3")) ? (char) 2 : (char) 65535;
                    if (c2 == 0) {
                        str = "audio/flac";
                    } else if (c2 == 1) {
                        str = "audio/wav";
                    } else if (c2 == 2) {
                        str = "audio/mpeg";
                    }
                    switch (str.hashCode()) {
                        case -2123537834:
                            if (!str.equals("audio/eac3-joc")) {
                                c3 = 65535;
                                break;
                            } else {
                                c3 = 0;
                                break;
                            }
                        case -1662384011:
                            if (str.equals("video/mp2p")) {
                                c3 = 1;
                                break;
                            }
                            break;
                        case -1662384007:
                            if (!str.equals("video/mp2t")) {
                            }
                            break;
                        case -1662095187:
                            if (str.equals("video/webm")) {
                                c3 = 3;
                                break;
                            }
                            break;
                        case -1606874997:
                            if (str.equals("audio/amr-wb")) {
                                c3 = 4;
                                break;
                            }
                            break;
                        case -1487394660:
                            if (str.equals("image/jpeg")) {
                                c3 = 5;
                                break;
                            }
                            break;
                        case -1248337486:
                            if (str.equals("application/mp4")) {
                                c3 = 6;
                                break;
                            }
                            break;
                        case -1004728940:
                            if (str.equals("text/vtt")) {
                                c3 = 7;
                                break;
                            }
                            break;
                        case -387023398:
                            if (str.equals("audio/x-matroska")) {
                                c3 = '\b';
                                break;
                            }
                            break;
                        case -43467528:
                            if (str.equals("application/webm")) {
                                c3 = '\t';
                                break;
                            }
                            break;
                        case 13915911:
                            if (str.equals("video/x-flv")) {
                                c3 = '\n';
                                break;
                            }
                            break;
                        case 187078296:
                            if (str.equals("audio/ac3")) {
                                c3 = 11;
                                break;
                            }
                            break;
                        case 187078297:
                            if (str.equals("audio/ac4")) {
                                c3 = '\f';
                                break;
                            }
                            break;
                        case 187078669:
                            if (str.equals("audio/amr")) {
                                c3 = '\r';
                                break;
                            }
                            break;
                        case 187090232:
                            if (str.equals("audio/mp4")) {
                                c3 = 14;
                                break;
                            }
                            break;
                        case 187091926:
                            if (str.equals("audio/ogg")) {
                                c3 = 15;
                                break;
                            }
                            break;
                        case 187099443:
                            if (str.equals("audio/wav")) {
                                c3 = 16;
                                break;
                            }
                            break;
                        case 1331848029:
                            if (str.equals("video/mp4")) {
                                c3 = 17;
                                break;
                            }
                            break;
                        case 1503095341:
                            if (str.equals("audio/3gpp")) {
                                c3 = 18;
                                break;
                            }
                            break;
                        case 1504578661:
                            if (str.equals("audio/eac3")) {
                                c3 = 19;
                                break;
                            }
                            break;
                        case 1504619009:
                            if (str.equals("audio/flac")) {
                                c3 = 20;
                                break;
                            }
                            break;
                        case 1504831518:
                            if (str.equals("audio/mpeg")) {
                                c3 = 21;
                                break;
                            }
                            break;
                        case 1505118770:
                            if (str.equals("audio/webm")) {
                                c3 = 22;
                                break;
                            }
                            break;
                        case 2039520277:
                            if (str.equals("video/x-matroska")) {
                                c3 = 23;
                                break;
                            }
                            break;
                    }
                    switch (c3) {
                        case 0:
                        case 11:
                        case 19:
                            return 0;
                        case 1:
                            return 10;
                        case 2:
                            return 11;
                        case 3:
                        case '\b':
                        case '\t':
                        case 22:
                        case 23:
                            return 6;
                        case 4:
                        case '\r':
                        case 18:
                            return 3;
                        case 5:
                            return 14;
                        case 6:
                        case 14:
                        case 17:
                            return 8;
                        case 7:
                            return 13;
                        case '\n':
                            return 5;
                        case '\f':
                            return 1;
                        case 15:
                            return 9;
                        case 16:
                            return 12;
                        case 20:
                            return 4;
                        case 21:
                            return 7;
                    }
                }
                if (str.equals("audio/x-wav")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                }
                switch (str.hashCode()) {
                    case -2123537834:
                        break;
                    case -1662384011:
                        break;
                    case -1662384007:
                        break;
                    case -1662095187:
                        break;
                    case -1606874997:
                        break;
                    case -1487394660:
                        break;
                    case -1248337486:
                        break;
                    case -1004728940:
                        break;
                    case -387023398:
                        break;
                    case -43467528:
                        break;
                    case 13915911:
                        break;
                    case 187078296:
                        break;
                    case 187078297:
                        break;
                    case 187078669:
                        break;
                    case 187090232:
                        break;
                    case 187091926:
                        break;
                    case 187099443:
                        break;
                    case 1331848029:
                        break;
                    case 1503095341:
                        break;
                    case 1504578661:
                        break;
                    case 1504619009:
                        break;
                    case 1504831518:
                        break;
                    case 1505118770:
                        break;
                    case 2039520277:
                        break;
                }
                switch (c3) {
                }
            }
        }
        return -1;
    }

    public static void O1(Cue.b bVar) {
        bVar.k = -3.4028235E38f;
        bVar.j = Integer.MIN_VALUE;
        CharSequence charSequence = bVar.a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                bVar.a = SpannableString.valueOf(charSequence);
            }
            CharSequence charSequence2 = bVar.a;
            Objects.requireNonNull(charSequence2);
            P1((Spannable) charSequence2, b.i.a.c.d3.h.a);
        }
    }

    public static final MediaSource P(MediaType mediaType, String str, String str2) {
        Intrinsics3.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics3.checkNotNullParameter(str, "progressiveMediaUri");
        Intrinsics3.checkNotNullParameter(str2, "featureTag");
        Uri uri = Uri.parse(str);
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(progressiveMediaUri)");
        return new MediaSource(uri, str2, mediaType);
    }

    public static int P0(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        return (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) ? 14 : -1;
    }

    public static void P1(Spannable spannable, Predicate3<Object> predicate3) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (predicate3.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    @RecentlyNonNull
    public static <T extends Parcelable> T Q(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iM1);
        return tCreateFromParcel;
    }

    public static void Q0(String str) {
        throw new IllegalArgumentException(outline.w("Unknown library: ", str));
    }

    public static void Q1(File file, File file2) throws FileUtils$RenameException {
        Objects.requireNonNull(file);
        file2.delete();
        if (file.renameTo(file2)) {
            return;
        }
        Throwable fileUtils$FileDeleteException = null;
        if (file2.exists()) {
            fileUtils$FileDeleteException = new FileUtils$FileDeleteException(file2.getAbsolutePath());
        } else if (!file.getParentFile().exists()) {
            fileUtils$FileDeleteException = new FileUtils$ParentDirNotFoundException(file.getAbsolutePath());
        } else if (!file.exists()) {
            fileUtils$FileDeleteException = new FileNotFoundException(file.getAbsolutePath());
        }
        StringBuilder sbU = outline.U("Unknown error renaming ");
        sbU.append(file.getAbsolutePath());
        sbU.append(" to ");
        sbU.append(file2.getAbsolutePath());
        throw new FileUtils$RenameException(sbU.toString(), fileUtils$FileDeleteException);
    }

    @RecentlyNonNull
    public static String R(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iM1);
        return string;
    }

    public static boolean R0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 3) && xmlPullParser.getName().equals(str);
    }

    public static final RenderContext R1(Function1<? super RenderContext, Unit> function1, Object... objArr) {
        Intrinsics3.checkNotNullParameter(function1, "init");
        Intrinsics3.checkNotNullParameter(objArr, "orderedArguments");
        RenderContext renderContext = new RenderContext();
        function1.invoke(renderContext);
        if (!(objArr.length == 0)) {
            if (!renderContext.args.isEmpty()) {
                throw new IllegalArgumentException("must provide named arguments OR formatArgs, not both.");
            }
            renderContext.orderedArguments = _Arrays.toList(objArr);
        }
        return renderContext;
    }

    @RecentlyNonNull
    public static String[] S(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iM1);
        return strArrCreateStringArray;
    }

    public static boolean S0(int i, int i2, ResizeOptions resizeOptions) {
        return resizeOptions == null ? ((float) o0(i)) >= 2048.0f && o0(i2) >= 2048 : o0(i) >= resizeOptions.a && o0(i2) >= resizeOptions.f566b;
    }

    public static /* synthetic */ void S1(AppPermissions2 appPermissions2, Function0 function0, Function0 function02, int i, Object obj) {
        int i2 = i & 1;
        appPermissions2.requestMicrophone(null, function02);
    }

    @RecentlyNonNull
    public static ArrayList<String> T(@RecentlyNonNull Parcel parcel, int i) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iM1);
        return arrayListCreateStringArrayList;
    }

    public static boolean T0(EncodedImage2 encodedImage2, ResizeOptions resizeOptions) {
        if (encodedImage2 == null) {
            return false;
        }
        encodedImage2.x();
        int i = encodedImage2.m;
        if (i == 90 || i == 270) {
            encodedImage2.x();
            int i2 = encodedImage2.p;
            encodedImage2.x();
            return S0(i2, encodedImage2.o, resizeOptions);
        }
        encodedImage2.x();
        int i3 = encodedImage2.o;
        encodedImage2.x();
        return S0(i3, encodedImage2.p, resizeOptions);
    }

    @Nullable
    public static TtmlStyle T1(@Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, Map<String, TtmlStyle> map) {
        int i = 0;
        if (ttmlStyle == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                TtmlStyle ttmlStyle2 = new TtmlStyle();
                int length = strArr.length;
                while (i < length) {
                    ttmlStyle2.a(map.get(strArr[i]));
                    i++;
                }
                return ttmlStyle2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                ttmlStyle.a(map.get(strArr[0]));
                return ttmlStyle;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    ttmlStyle.a(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return ttmlStyle;
    }

    @RecentlyNonNull
    public static <T> T[] U(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iM1);
        return tArr;
    }

    public static final boolean U0(Context context) {
        Intrinsics3.checkNotNullParameter(context, "$this$isLtr");
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 0;
    }

    public static float U1(int i, float f2, int i2, int i3) {
        float f3;
        if (f2 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f3 = i3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f2;
            }
            f3 = i2;
        }
        return f2 * f3;
    }

    @RecentlyNonNull
    public static <T> ArrayList<T> V(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM1 == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iM1);
        return arrayListCreateTypedArrayList;
    }

    public static final boolean V0(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "$this$isMutedByAnySource");
        return voiceState.getSelfMute() || voiceState.getMute() || voiceState.getSuppress();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [TResult, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [TInput, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [b.i.a.b.i.b, b.i.a.b.i.b<TInput, TResult, TException extends java.lang.Throwable>] */
    public static <TInput, TResult, TException extends Throwable> TResult V1(int i, TInput tinput, CctTransportBackend<TInput, TResult, TException> cctTransportBackend, RetryStrategy<TInput, TResult> retryStrategy) throws Throwable {
        ?? r0;
        if (i < 1) {
            return (TResult) cctTransportBackend.a(tinput);
        }
        do {
            r0 = (TResult) cctTransportBackend.a(tinput);
            CctTransportBackend3.a aVar = (CctTransportBackend3.a) tinput;
            CctTransportBackend3.b bVar = (CctTransportBackend3.b) r0;
            URL url = bVar.f746b;
            if (url != null) {
                X("CctTransportBackend", "Following redirect to: %s", url);
                tinput = (TInput) new CctTransportBackend3.a(bVar.f746b, aVar.f745b, aVar.c);
            } else {
                tinput = 0;
            }
            if (tinput == 0) {
                break;
            }
            i--;
        } while (i >= 1);
        return r0;
    }

    public static String W(String str) {
        StringBuilder sbS = outline.S(outline.b(str, outline.b(str, 5)), ".", str, ",.", str);
        sbS.append(" *");
        return sbS.toString();
    }

    public static final boolean W0(StageInstance stageInstance) {
        Intrinsics3.checkNotNullParameter(stageInstance, "$this$isPublic");
        return stageInstance.getPrivacyLevel() == StageInstancePrivacyLevel.PUBLIC;
    }

    public static String W1(CacheKey cacheKey) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bytes = cacheKey.b().getBytes(Constants.ENCODING);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
            messageDigest.update(bytes, 0, bytes.length);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void X(String str, String str2, Object obj) {
        Log.d(D0(str), String.format(str2, obj));
    }

    public static final boolean X0(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "$this$isRemoveSignal");
        return voiceState.getChannelId() == null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void X1(Drawable drawable, Drawable.Callback callback, TransformCallback transformCallback) {
        if (drawable != 0) {
            drawable.setCallback(callback);
            if (drawable instanceof TransformAwareDrawable) {
                ((TransformAwareDrawable) drawable).b(transformCallback);
            }
        }
    }

    public static void Y(String str, String str2, Object... objArr) {
        Log.d(D0(str), String.format(str2, objArr));
    }

    public static boolean Y0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return (xmlPullParser.getEventType() == 2) && xmlPullParser.getName().equals(str);
    }

    public static void Y1(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(outline.g(15, "csd-", i), ByteBuffer.wrap(list.get(i)));
        }
    }

    public static boolean Z(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                Z(file2);
            }
        }
        return file.delete();
    }

    @TargetApi(20)
    public static boolean Z0(@RecentlyNonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (c == null) {
            c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return c.booleanValue();
    }

    public static void Z1(Drawable drawable, DrawableProperties drawableProperties) {
        if (drawable == null || drawableProperties == null) {
            return;
        }
        int i = drawableProperties.a;
        if (i != -1) {
            drawable.setAlpha(i);
        }
        if (drawableProperties.f506b) {
            drawable.setColorFilter(drawableProperties.c);
        }
        int i2 = drawableProperties.d;
        if (i2 != -1) {
            drawable.setDither(i2 != 0);
        }
        int i3 = drawableProperties.e;
        if (i3 != -1) {
            drawable.setFilterBitmap(i3 != 0);
        }
    }

    public static float a(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a0(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage2 encodedImage2, int i) {
        float fMax;
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        if (!EncodedImage2.s(encodedImage2)) {
            return 1;
        }
        i(Boolean.valueOf(EncodedImage2.s(encodedImage2)));
        if (resizeOptions == null || resizeOptions.f566b <= 0 || resizeOptions.a <= 0) {
            fMax = 1.0f;
        } else {
            encodedImage2.x();
            if (encodedImage2.o != 0) {
                encodedImage2.x();
                if (encodedImage2.p != 0) {
                    if (rotationOptions.c()) {
                        encodedImage2.x();
                        i2 = encodedImage2.m;
                        i(Boolean.valueOf(i2 == 0 || i2 == 90 || i2 == 180 || i2 == 270));
                    } else {
                        i2 = 0;
                    }
                    boolean z2 = i2 == 90 || i2 == 270;
                    if (z2) {
                        encodedImage2.x();
                        i3 = encodedImage2.p;
                    } else {
                        encodedImage2.x();
                        i3 = encodedImage2.o;
                    }
                    if (z2) {
                        encodedImage2.x();
                        i4 = encodedImage2.o;
                    } else {
                        encodedImage2.x();
                        i4 = encodedImage2.p;
                    }
                    fMax = Math.max(resizeOptions.a / i3, resizeOptions.f566b / i4);
                    int i6 = FLog.a;
                }
            }
        }
        encodedImage2.x();
        int i7 = 2;
        if (encodedImage2.l == DefaultImageFormats.a) {
            if (fMax <= 0.6666667f) {
                i5 = 2;
                while (true) {
                    int i8 = i5 * 2;
                    double d2 = 1.0d / i8;
                    if ((d2 * 0.3333333432674408d) + d2 <= fMax) {
                        break;
                    }
                    i5 = i8;
                }
            }
        } else if (fMax <= 0.6666667f) {
            while (true) {
                double d3 = i7;
                if (((1.0d / (Math.pow(d3, 2.0d) - d3)) * 0.3333333432674408d) + (1.0d / d3) <= fMax) {
                    break;
                }
                i7++;
            }
            i5 = i7 - 1;
        }
        encodedImage2.x();
        int i9 = encodedImage2.p;
        encodedImage2.x();
        int iMax = Math.max(i9, encodedImage2.o);
        float f2 = resizeOptions != null ? resizeOptions.c : i;
        while (iMax / i5 > f2) {
            encodedImage2.x();
            i5 = encodedImage2.l == DefaultImageFormats.a ? i5 * 2 : i5 + 1;
        }
        return i5;
    }

    @TargetApi(26)
    public static boolean a1(@RecentlyNonNull Context context) {
        if (!Z0(context)) {
            return false;
        }
        if (!(Build.VERSION.SDK_INT >= 24)) {
            return true;
        }
        if (d == null) {
            d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return d.booleanValue() && !b.i.a.f.e.o.f.A0();
    }

    public static <TResult> void a2(Status status, @Nullable TResult tresult, TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.w0()) {
            taskCompletionSource.a.s(tresult);
        } else {
            taskCompletionSource.a.t(new ApiException(status));
        }
    }

    public static float b(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow(f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static void b0(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                b0(file2);
            }
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            Log.e("SysUtil", "Enable write permission failed: " + parentFile);
        }
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("Could not delete file " + file);
    }

    public static final void b1(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.d$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    public static boolean b2(Object obj, Collection<String> collection, Collection<String> collection2) {
        if (collection == null && collection2 == null) {
            return false;
        }
        return collection2 == null ? collection.contains(obj) : collection == null ? !collection2.contains(obj) : !collection2.contains(obj) || collection.contains(obj);
    }

    public static void c(Spannable spannable, Object obj, int i, int i2, int i3) {
        for (Object obj2 : spannable.getSpans(i, i2, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i && spannable.getSpanEnd(obj2) == i2 && spannable.getSpanFlags(obj2) == i3) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i, i2, i3);
    }

    public static void c0(String str, String str2, Throwable th) {
        Log.e(D0(str), str2, th);
    }

    public static final void c1(String str, String str2, Throwable th) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.e$default(LoggingProvider.INSTANCE.get(), str, str2, th, null, 8, null);
    }

    public static long c2(InputStream inputStream, long j) throws IOException {
        i(Boolean.valueOf(j >= 0));
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    return j - j2;
                }
                jSkip = 1;
            }
            j2 -= jSkip;
        }
        return j;
    }

    public static int d(int i, int i2, int i3) {
        return Math.min(Math.max(0, i3 - i), i2);
    }

    public static void d0() {
        if (Util2.a >= 18) {
            Trace.endSection();
        }
    }

    public static final void d1(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.i$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    public static void d2(@RecentlyNonNull Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + M1(parcel, i));
    }

    public static byte[] e(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static synchronized void e0() {
        if (!a) {
            NativeLoader.c("native-imagetranscoder");
            a = true;
        }
    }

    public static final void e1(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.v$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    public static final <P extends Parcelable> Bundle e2(P p) {
        Intrinsics3.checkNotNullParameter(p, "$this$toBundle");
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent_args_key", p);
        return bundle;
    }

    public static void f(String str) {
        if (Util2.a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void f0(@RecentlyNonNull Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new SafeParcelReader$ParseException(outline.g(37, "Overread allowed size end=", i), parcel);
        }
    }

    public static final void f1(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logger.w$default(LoggingProvider.INSTANCE.get(), str, str2, null, 4, null);
    }

    public static String f2(@ColorInt int i) {
        return Util2.k("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(Color.alpha(i) / 255.0d));
    }

    public static List<byte[]> g(byte[] bArr) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(h(((((bArr[11] & 255) << 8) | (bArr[10] & 255)) * 1000000000) / 48000));
        arrayList.add(h(80000000L));
        return arrayList;
    }

    public static boolean g0(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean g1(BitmapTransformation bitmapTransformation, CloseableReference<Bitmap> closeableReference) {
        return false;
    }

    public static final <P extends Parcelable> Intent g2(P p) {
        Intrinsics3.checkNotNullParameter(p, "$this$toIntent");
        Intent intentPutExtra = new Intent().putExtra("intent_args_key", p);
        Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_ARGS, this)");
        return intentPutExtra;
    }

    public static byte[] h(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    public static boolean h0(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static ParameterizedType h1(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return h1(upperBounds[0]);
            }
        }
        return null;
    }

    public static Objects2 h2(Object obj) {
        return new Objects2(obj.getClass().getSimpleName(), null);
    }

    public static void i(Boolean bool) {
        if (bool != null && !bool.booleanValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static int i0(float f2, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f3 = ((i >> 24) & 255) / 255.0f;
        float f4 = ((i2 >> 24) & 255) / 255.0f;
        float fA = a(((i >> 16) & 255) / 255.0f);
        float fA2 = a(((i >> 8) & 255) / 255.0f);
        float fA3 = a((i & 255) / 255.0f);
        float fA4 = a(((i2 >> 16) & 255) / 255.0f);
        float fA5 = a(((i2 >> 8) & 255) / 255.0f);
        float fA6 = a((i2 & 255) / 255.0f);
        float fA7 = outline.a(f4, f3, f2, f3);
        float fA8 = outline.a(fA4, fA, f2, fA);
        float fA9 = outline.a(fA5, fA2, f2, fA2);
        float fA10 = outline.a(fA6, fA3, f2, fA3);
        float fB = b(fA8) * 255.0f;
        float fB2 = b(fA9) * 255.0f;
        return Math.round(b(fA10) * 255.0f) | (Math.round(fB) << 16) | (Math.round(fA7 * 255.0f) << 24) | (Math.round(fB2) << 8);
    }

    public static TypeVariable<?> i1(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return i1(upperBounds[0]);
            }
        }
        return null;
    }

    public static void i2(Collection<? extends Node> collection, NodeProcessor nodeProcessor) {
        Iterator<? extends Node> it = collection.iterator();
        while (it.hasNext()) {
            j2(it.next(), nodeProcessor);
        }
    }

    @Pure
    public static void j(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] j0(FileChannel fileChannel) throws IOException {
        long jG0;
        long jG02;
        long jG03;
        long j;
        long jG04;
        long j2;
        long jG05;
        long j3;
        long jG06;
        long j4;
        long jG07;
        long jG08;
        long jG09;
        long jG010;
        int i = 8;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jG011 = G0(fileChannel, byteBufferAllocate, 0L);
        if (jG011 != 1179403647) {
            StringBuilder sbU = outline.U("file is not ELF: 0x");
            sbU.append(Long.toHexString(jG011));
            throw new MinElf(sbU.toString());
        }
        C1(fileChannel, byteBufferAllocate, 1, 4L);
        boolean z2 = ((short) (byteBufferAllocate.get() & 255)) == 1;
        C1(fileChannel, byteBufferAllocate, 1, 5L);
        if (((short) (byteBufferAllocate.get() & 255)) == 2) {
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        }
        if (z2) {
            jG0 = G0(fileChannel, byteBufferAllocate, 28L);
        } else {
            C1(fileChannel, byteBufferAllocate, 8, 32L);
            jG0 = byteBufferAllocate.getLong();
        }
        C1(fileChannel, byteBufferAllocate, 2, z2 ? 44L : 56L);
        long jG012 = byteBufferAllocate.getShort() & 65535;
        C1(fileChannel, byteBufferAllocate, 2, z2 ? 42L : 54L);
        int i2 = 65535 & byteBufferAllocate.getShort();
        if (jG012 == 65535) {
            if (z2) {
                jG010 = G0(fileChannel, byteBufferAllocate, 32L);
            } else {
                C1(fileChannel, byteBufferAllocate, 8, 40L);
                jG010 = byteBufferAllocate.getLong();
            }
            jG012 = z2 ? G0(fileChannel, byteBufferAllocate, jG010 + 28) : G0(fileChannel, byteBufferAllocate, jG010 + 44);
        }
        long j5 = 0;
        long j6 = jG0;
        while (true) {
            if (j5 >= jG012) {
                jG02 = 0;
                break;
            }
            if ((z2 ? G0(fileChannel, byteBufferAllocate, j6 + 0) : G0(fileChannel, byteBufferAllocate, 0 + j6)) != 2) {
                j6 += i2;
                j5++;
            } else if (z2) {
                jG02 = G0(fileChannel, byteBufferAllocate, j6 + 4);
            } else {
                C1(fileChannel, byteBufferAllocate, 8, j6 + 8);
                jG02 = byteBufferAllocate.getLong();
            }
        }
        long j7 = 0;
        if (jG02 == 0) {
            throw new MinElf("ELF file does not contain dynamic linking information");
        }
        int i3 = 0;
        long j8 = jG02;
        long j9 = 0;
        while (true) {
            long j10 = j8 + j7;
            if (z2) {
                jG03 = G0(fileChannel, byteBufferAllocate, j10);
            } else {
                C1(fileChannel, byteBufferAllocate, i, j10);
                jG03 = byteBufferAllocate.getLong();
            }
            if (jG03 == 1) {
                j = jG02;
                if (i3 == Integer.MAX_VALUE) {
                    throw new MinElf("malformed DT_NEEDED section");
                }
                i3++;
            } else {
                j = jG02;
                if (jG03 == 5) {
                    if (z2) {
                        jG04 = G0(fileChannel, byteBufferAllocate, j8 + 4);
                    } else {
                        C1(fileChannel, byteBufferAllocate, 8, j8 + 8);
                        jG04 = byteBufferAllocate.getLong();
                    }
                    j9 = jG04;
                }
            }
            long j11 = 16;
            j8 += z2 ? 8L : 16L;
            long j12 = 0;
            if (jG03 != 0) {
                i = 8;
                jG02 = j;
                j7 = 0;
            } else {
                if (j9 == 0) {
                    throw new MinElf("Dynamic section string-table not found");
                }
                int i4 = 0;
                int i5 = i3;
                while (true) {
                    if (i4 >= jG012) {
                        j2 = 0;
                        break;
                    }
                    if ((z2 ? G0(fileChannel, byteBufferAllocate, jG0 + j12) : G0(fileChannel, byteBufferAllocate, jG0 + j12)) == 1) {
                        if (z2) {
                            jG07 = G0(fileChannel, byteBufferAllocate, jG0 + 8);
                        } else {
                            C1(fileChannel, byteBufferAllocate, 8, j11 + jG0);
                            jG07 = byteBufferAllocate.getLong();
                        }
                        if (z2) {
                            jG08 = G0(fileChannel, byteBufferAllocate, 20 + jG0);
                            j4 = jG012;
                        } else {
                            j4 = jG012;
                            C1(fileChannel, byteBufferAllocate, 8, 40 + jG0);
                            jG08 = byteBufferAllocate.getLong();
                        }
                        if (jG07 <= j9 && j9 < jG08 + jG07) {
                            if (z2) {
                                jG09 = G0(fileChannel, byteBufferAllocate, jG0 + 4);
                            } else {
                                C1(fileChannel, byteBufferAllocate, 8, jG0 + 8);
                                jG09 = byteBufferAllocate.getLong();
                            }
                            j2 = (j9 - jG07) + jG09;
                        }
                    } else {
                        j4 = jG012;
                    }
                    jG0 += i2;
                    i4++;
                    j11 = 16;
                    j12 = 0;
                    jG012 = j4;
                }
                if (j2 == 0) {
                    throw new MinElf("did not find file offset of DT_STRTAB table");
                }
                String[] strArr = new String[i5];
                long j13 = 0;
                long j14 = j;
                int i6 = 0;
                while (true) {
                    long j15 = j13 + j14;
                    if (z2) {
                        jG05 = G0(fileChannel, byteBufferAllocate, j15);
                    } else {
                        C1(fileChannel, byteBufferAllocate, 8, j15);
                        jG05 = byteBufferAllocate.getLong();
                    }
                    if (jG05 == 1) {
                        if (z2) {
                            jG06 = G0(fileChannel, byteBufferAllocate, 4 + j14);
                        } else {
                            C1(fileChannel, byteBufferAllocate, 8, j14 + 8);
                            jG06 = byteBufferAllocate.getLong();
                        }
                        long j16 = jG06 + j2;
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            long j17 = j16 + 1;
                            j3 = j2;
                            C1(fileChannel, byteBufferAllocate, 1, j16);
                            short s2 = (short) (byteBufferAllocate.get() & 255);
                            if (s2 == 0) {
                                break;
                            }
                            sb.append((char) s2);
                            j16 = j17;
                            j2 = j3;
                        }
                        strArr[i6] = sb.toString();
                        if (i6 == Integer.MAX_VALUE) {
                            throw new MinElf("malformed DT_NEEDED section");
                        }
                        i6++;
                    } else {
                        j3 = j2;
                    }
                    j14 += z2 ? 8L : 16L;
                    if (jG05 == 0) {
                        if (i6 == i5) {
                            return strArr;
                        }
                        throw new MinElf("malformed DT_NEEDED section");
                    }
                    j13 = 0;
                    j2 = j3;
                }
            }
        }
    }

    public static void j1(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void j2(Node node, NodeProcessor nodeProcessor) {
        if (node.hasChildren()) {
            Iterator it = node.getChildren().iterator();
            while (it.hasNext()) {
                j2((Node) it.next(), nodeProcessor);
            }
        }
        nodeProcessor.processNode(node);
    }

    public static void k(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static String k0(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i = 0;
        int i2 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i2)) != -1) {
            sb.append(strValueOf.substring(i2, iIndexOf));
            sb.append(objArr[i]);
            i2 = iIndexOf + 2;
            i++;
        }
        sb.append(strValueOf.substring(i2));
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i3 = i + 1; i3 < objArr.length; i3++) {
                sb.append(", ");
                sb.append(objArr[i3]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String k1(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void k2(Node node, NodeProcessor nodeProcessor) {
        nodeProcessor.processNode(node);
        if (node.hasChildren()) {
            Iterator it = node.getChildren().iterator();
            while (it.hasNext()) {
                k2((Node) it.next(), nodeProcessor);
            }
        }
    }

    public static void l(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    @NonNull
    public static ApiException l0(@NonNull Status status) {
        return status.r != null ? new ResolvableApiException(status) : new ApiException(status);
    }

    public static void l1(File file) throws FileUtils$CreateDirectoryException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!file.delete()) {
                throw new FileUtils$CreateDirectoryException(file.getAbsolutePath(), new FileUtils$FileDeleteException(file.getAbsolutePath()));
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new FileUtils$CreateDirectoryException(file.getAbsolutePath());
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0266 A[PHI: r1 r2 r3
      0x0266: PHI (r1v20 boolean) = (r1v15 boolean), (r1v22 boolean) binds: [B:159:0x0264, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0266: PHI (r2v17 boolean) = (r2v12 boolean), (r2v19 boolean) binds: [B:159:0x0264, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0266: PHI (r3v10 boolean) = (r3v6 boolean), (r3v12 boolean) binds: [B:159:0x0264, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0268 A[PHI: r1 r2 r3
      0x0268: PHI (r1v17 boolean) = (r1v15 boolean), (r1v15 boolean), (r1v22 boolean), (r1v22 boolean) binds: [B:158:0x0262, B:159:0x0264, B:143:0x0248, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r2v14 boolean) = (r2v12 boolean), (r2v12 boolean), (r2v19 boolean), (r2v19 boolean) binds: [B:158:0x0262, B:159:0x0264, B:143:0x0248, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]
      0x0268: PHI (r3v8 boolean) = (r3v6 boolean), (r3v6 boolean), (r3v12 boolean), (r3v12 boolean) binds: [B:158:0x0262, B:159:0x0264, B:143:0x0248, B:144:0x024a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static GenericDraweeHierarchyBuilder l2(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int integer;
        boolean z6;
        boolean z7;
        int i2;
        boolean z8;
        boolean z9;
        int i3;
        boolean z10;
        Context context2 = context;
        int i4 = 1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.a.GenericDraweeHierarchy);
            try {
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                int i5 = 0;
                int dimensionPixelSize = 0;
                integer = 0;
                boolean z11 = true;
                boolean z12 = true;
                boolean z13 = true;
                boolean z14 = true;
                boolean z15 = true;
                boolean z16 = true;
                boolean z17 = true;
                boolean z18 = true;
                while (i5 < indexCount) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i5);
                    if (index == R.a.GenericDraweeHierarchy_actualImageScaleType) {
                        genericDraweeHierarchyBuilder.n = A0(typedArrayObtainStyledAttributes, index);
                    } else if (index == R.a.GenericDraweeHierarchy_placeholderImage) {
                        genericDraweeHierarchyBuilder.f = u0(context2, typedArrayObtainStyledAttributes, index);
                    } else {
                        if (index == R.a.GenericDraweeHierarchy_pressedStateOverlayImage) {
                            Drawable drawableU0 = u0(context2, typedArrayObtainStyledAttributes, index);
                            if (drawableU0 == null) {
                                genericDraweeHierarchyBuilder.q = null;
                            } else {
                                StateListDrawable stateListDrawable = new StateListDrawable();
                                i2 = indexCount;
                                int[] iArr = new int[i4];
                                iArr[0] = 16842919;
                                stateListDrawable.addState(iArr, drawableU0);
                                genericDraweeHierarchyBuilder.q = stateListDrawable;
                            }
                        } else {
                            i2 = indexCount;
                            if (index == R.a.GenericDraweeHierarchy_progressBarImage) {
                                genericDraweeHierarchyBuilder.l = u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == R.a.GenericDraweeHierarchy_fadeDuration) {
                                genericDraweeHierarchyBuilder.d = typedArrayObtainStyledAttributes.getInt(index, 0);
                            } else if (index == R.a.GenericDraweeHierarchy_viewAspectRatio) {
                                genericDraweeHierarchyBuilder.e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                            } else if (index == R.a.GenericDraweeHierarchy_placeholderImageScaleType) {
                                genericDraweeHierarchyBuilder.g = A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == R.a.GenericDraweeHierarchy_retryImage) {
                                genericDraweeHierarchyBuilder.h = u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == R.a.GenericDraweeHierarchy_retryImageScaleType) {
                                genericDraweeHierarchyBuilder.i = A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == R.a.GenericDraweeHierarchy_failureImage) {
                                genericDraweeHierarchyBuilder.j = u0(context2, typedArrayObtainStyledAttributes, index);
                            } else if (index == R.a.GenericDraweeHierarchy_failureImageScaleType) {
                                genericDraweeHierarchyBuilder.k = A0(typedArrayObtainStyledAttributes, index);
                            } else if (index == R.a.GenericDraweeHierarchy_progressBarImageScaleType) {
                                genericDraweeHierarchyBuilder.m = A0(typedArrayObtainStyledAttributes, index);
                            } else {
                                if (index == R.a.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                                    integer = typedArrayObtainStyledAttributes.getInteger(index, integer);
                                } else if (index == R.a.GenericDraweeHierarchy_backgroundImage) {
                                    genericDraweeHierarchyBuilder.o = u0(context2, typedArrayObtainStyledAttributes, index);
                                } else if (index == R.a.GenericDraweeHierarchy_overlayImage) {
                                    genericDraweeHierarchyBuilder.b(u0(context2, typedArrayObtainStyledAttributes, index));
                                } else if (index == R.a.GenericDraweeHierarchy_roundAsCircle) {
                                    if (genericDraweeHierarchyBuilder.r == null) {
                                        genericDraweeHierarchyBuilder.r = new RoundingParams();
                                    }
                                    genericDraweeHierarchyBuilder.r.f523b = typedArrayObtainStyledAttributes.getBoolean(index, false);
                                } else if (index == R.a.GenericDraweeHierarchy_roundedCornerRadius) {
                                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                                } else if (index == R.a.GenericDraweeHierarchy_roundTopLeft) {
                                    z11 = typedArrayObtainStyledAttributes.getBoolean(index, z11);
                                } else if (index == R.a.GenericDraweeHierarchy_roundTopRight) {
                                    z14 = typedArrayObtainStyledAttributes.getBoolean(index, z14);
                                } else {
                                    if (index == R.a.GenericDraweeHierarchy_roundBottomLeft) {
                                        z8 = typedArrayObtainStyledAttributes.getBoolean(index, z18);
                                    } else {
                                        z8 = z18;
                                        if (index == R.a.GenericDraweeHierarchy_roundBottomRight) {
                                            z15 = typedArrayObtainStyledAttributes.getBoolean(index, z15);
                                        } else if (index == R.a.GenericDraweeHierarchy_roundTopStart) {
                                            z12 = typedArrayObtainStyledAttributes.getBoolean(index, z12);
                                        } else if (index == R.a.GenericDraweeHierarchy_roundTopEnd) {
                                            z13 = typedArrayObtainStyledAttributes.getBoolean(index, z13);
                                        } else {
                                            if (index == R.a.GenericDraweeHierarchy_roundBottomStart) {
                                                z9 = typedArrayObtainStyledAttributes.getBoolean(index, z17);
                                            } else {
                                                z9 = z17;
                                                if (index == R.a.GenericDraweeHierarchy_roundBottomEnd) {
                                                    z16 = typedArrayObtainStyledAttributes.getBoolean(index, z16);
                                                } else if (index == R.a.GenericDraweeHierarchy_roundWithOverlayColor) {
                                                    if (genericDraweeHierarchyBuilder.r == null) {
                                                        genericDraweeHierarchyBuilder.r = new RoundingParams();
                                                    }
                                                    genericDraweeHierarchyBuilder.r.b(typedArrayObtainStyledAttributes.getColor(index, 0));
                                                } else {
                                                    if (index == R.a.GenericDraweeHierarchy_roundingBorderWidth) {
                                                        if (genericDraweeHierarchyBuilder.r == null) {
                                                            genericDraweeHierarchyBuilder.r = new RoundingParams();
                                                        }
                                                        RoundingParams roundingParams = genericDraweeHierarchyBuilder.r;
                                                        float dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                        Objects.requireNonNull(roundingParams);
                                                        if (dimensionPixelSize2 >= 0.0f) {
                                                            i3 = dimensionPixelSize;
                                                            z10 = true;
                                                        } else {
                                                            i3 = dimensionPixelSize;
                                                            z10 = false;
                                                        }
                                                        k(z10, "the border width cannot be < 0");
                                                        roundingParams.e = dimensionPixelSize2;
                                                    } else {
                                                        i3 = dimensionPixelSize;
                                                        if (index == R.a.GenericDraweeHierarchy_roundingBorderColor) {
                                                            if (genericDraweeHierarchyBuilder.r == null) {
                                                                genericDraweeHierarchyBuilder.r = new RoundingParams();
                                                            }
                                                            genericDraweeHierarchyBuilder.r.f = typedArrayObtainStyledAttributes.getColor(index, 0);
                                                        } else if (index == R.a.GenericDraweeHierarchy_roundingBorderPadding) {
                                                            if (genericDraweeHierarchyBuilder.r == null) {
                                                                genericDraweeHierarchyBuilder.r = new RoundingParams();
                                                            }
                                                            RoundingParams roundingParams2 = genericDraweeHierarchyBuilder.r;
                                                            float dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                                                            Objects.requireNonNull(roundingParams2);
                                                            k(dimensionPixelSize3 >= 0.0f, "the padding cannot be < 0");
                                                            roundingParams2.g = dimensionPixelSize3;
                                                        }
                                                    }
                                                    dimensionPixelSize = i3;
                                                    z18 = z8;
                                                    i5++;
                                                    context2 = context;
                                                    z17 = z9;
                                                    i4 = 1;
                                                    indexCount = i2;
                                                }
                                            }
                                            i3 = dimensionPixelSize;
                                            dimensionPixelSize = i3;
                                            z18 = z8;
                                            i5++;
                                            context2 = context;
                                            z17 = z9;
                                            i4 = 1;
                                            indexCount = i2;
                                        }
                                    }
                                    i3 = dimensionPixelSize;
                                    z9 = z17;
                                    dimensionPixelSize = i3;
                                    z18 = z8;
                                    i5++;
                                    context2 = context;
                                    z17 = z9;
                                    i4 = 1;
                                    indexCount = i2;
                                }
                                z9 = z17;
                                i5++;
                                context2 = context;
                                z17 = z9;
                                i4 = 1;
                                indexCount = i2;
                            }
                        }
                        z9 = z17;
                        z8 = z18;
                        i3 = dimensionPixelSize;
                        dimensionPixelSize = i3;
                        z18 = z8;
                        i5++;
                        context2 = context;
                        z17 = z9;
                        i4 = 1;
                        indexCount = i2;
                    }
                    i2 = indexCount;
                    z9 = z17;
                    z8 = z18;
                    i3 = dimensionPixelSize;
                    dimensionPixelSize = i3;
                    z18 = z8;
                    i5++;
                    context2 = context;
                    z17 = z9;
                    i4 = 1;
                    indexCount = i2;
                }
                boolean z19 = z17;
                boolean z20 = z18;
                int i6 = dimensionPixelSize;
                typedArrayObtainStyledAttributes.recycle();
                if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
                    z6 = z11 && z13;
                    z7 = z14 && z12;
                    z4 = z15 && z19;
                    z5 = z20 && z16;
                } else {
                    z6 = z11 && z12;
                    z7 = z14 && z13;
                    z4 = z15 && z16;
                    if (!z20 || !z19) {
                    }
                }
                i = i6;
                boolean z21 = z7;
                z3 = z6;
                z2 = z21;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                context.getResources().getConfiguration().getLayoutDirection();
                throw th;
            }
        } else {
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            i = 0;
            integer = 0;
        }
        if (genericDraweeHierarchyBuilder.l != null && integer > 0) {
            genericDraweeHierarchyBuilder.l = new AutoRotateDrawable(genericDraweeHierarchyBuilder.l, integer);
        }
        if (i > 0) {
            if (genericDraweeHierarchyBuilder.r == null) {
                genericDraweeHierarchyBuilder.r = new RoundingParams();
            }
            RoundingParams roundingParams3 = genericDraweeHierarchyBuilder.r;
            float f2 = z3 ? i : 0.0f;
            float f3 = z2 ? i : 0.0f;
            float f4 = z4 ? i : 0.0f;
            float f5 = z5 ? i : 0.0f;
            if (roundingParams3.c == null) {
                roundingParams3.c = new float[8];
            }
            float[] fArr = roundingParams3.c;
            fArr[1] = f2;
            fArr[0] = f2;
            fArr[3] = f3;
            fArr[2] = f3;
            fArr[5] = f4;
            fArr[4] = f4;
            fArr[7] = f5;
            fArr[6] = f5;
        }
        return genericDraweeHierarchyBuilder;
    }

    @Pure
    public static void m(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m0(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("cannot list directory " + file);
            }
            for (File file2 : fileArrListFiles) {
                m0(file2);
            }
            return;
        }
        if (file.getPath().endsWith("_lock")) {
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static int m1(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & ViewCompat.MEASURED_SIZE_MASK;
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static int m2(@RecentlyNonNull Parcel parcel) {
        int i = parcel.readInt();
        int iM1 = M1(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (((char) i) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw new SafeParcelReader$ParseException(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = iM1 + iDataPosition;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new SafeParcelReader$ParseException(outline.h(54, "Size read is invalid start=", iDataPosition, " end=", i2), parcel);
        }
        return i2;
    }

    public static void n(boolean z2, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static int n0(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 8) & 65280) | (((byte) inputStream.read()) & 255);
    }

    public static final Integer n1(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "$this$nextIntOrNull");
        if (jsonReader.N() != JsonToken.NULL) {
            return Integer.valueOf(jsonReader.y());
        }
        jsonReader.H();
        return null;
    }

    public static boolean n2(int i, ParsableByteArray parsableByteArray, boolean z2) throws ParserException {
        if (parsableByteArray.a() < 7) {
            if (z2) {
                return false;
            }
            throw outline.w0(29, "too short header: ", parsableByteArray.a(), null);
        }
        if (parsableByteArray.t() != i) {
            if (z2) {
                return false;
            }
            String strValueOf = String.valueOf(Integer.toHexString(i));
            throw ParserException.a(strValueOf.length() != 0 ? "expected header type ".concat(strValueOf) : new String("expected header type "), null);
        }
        if (parsableByteArray.t() == 118 && parsableByteArray.t() == 111 && parsableByteArray.t() == 114 && parsableByteArray.t() == 98 && parsableByteArray.t() == 105 && parsableByteArray.t() == 115) {
            return true;
        }
        if (z2) {
            return false;
        }
        throw ParserException.a("expected characters 'vorbis'", null);
    }

    public static void o(boolean z2, @RecentlyNonNull Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int o0(int i) {
        return (int) (i * 1.3333334f);
    }

    @Nullable
    public static <T> List<Keyframe<T>> o1(JsonReader2 jsonReader2, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.a(jsonReader2, lottieComposition, 1.0f, valueParser);
    }

    public static void o2(File file, FileTreeVisitor fileTreeVisitor) {
        fileTreeVisitor.b(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    o2(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.a(file2);
                }
            }
        }
        fileTreeVisitor.c(file);
    }

    public static void p(int i, int i2, int i3, int i4, int i5) {
        i(Boolean.valueOf(i4 >= 0));
        i(Boolean.valueOf(i >= 0));
        i(Boolean.valueOf(i3 >= 0));
        i(Boolean.valueOf(i + i4 <= i5));
        i(Boolean.valueOf(i3 + i4 <= i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ScaleTypeDrawable p0(Drawable drawable) {
        if (drawable == 0) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return p0(((DrawableParent) drawable).l());
        }
        if (drawable instanceof ArrayDrawable2) {
            ArrayDrawable2 arrayDrawable2 = (ArrayDrawable2) drawable;
            int length = arrayDrawable2.l.length;
            for (int i = 0; i < length; i++) {
                ScaleTypeDrawable scaleTypeDrawableP0 = p0(arrayDrawable2.a(i));
                if (scaleTypeDrawableP0 != null) {
                    return scaleTypeDrawableP0;
                }
            }
        }
        return null;
    }

    public static AnimatableColorValue p1(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(o1(jsonReader2, lottieComposition, ColorParser.a));
    }

    public static void p2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Bundle bundle, boolean z2) {
        if (bundle == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeBundle(bundle);
            A2(parcel, iY2);
        }
    }

    @Pure
    public static void q(boolean z2, @Nullable String str) throws ParserException {
        if (!z2) {
            throw ParserException.a(str, null);
        }
    }

    public static Object q0(Object obj) {
        return new a(obj.getClass(), Array.getLength(obj), obj);
    }

    public static AnimatableFloatValue q1(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        return r1(jsonReader2, lottieComposition, true);
    }

    public static void q2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull byte[] bArr, boolean z2) {
        if (bArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeByteArray(bArr);
            A2(parcel, iY2);
        }
    }

    public static boolean r(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        if (WavHeaderReader.a(extractorInput, parsableByteArray).a != 1380533830) {
            return false;
        }
        extractorInput.o(parsableByteArray.a, 0, 4);
        parsableByteArray.E(0);
        int iF = parsableByteArray.f();
        if (iF == 1463899717) {
            return true;
        }
        StringBuilder sb = new StringBuilder(34);
        sb.append("Unsupported form type: ");
        sb.append(iF);
        Log.e("WavHeaderReader", sb.toString());
        return false;
    }

    @Nullable
    public static String r0(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static AnimatableFloatValue r1(JsonReader2 jsonReader2, LottieComposition lottieComposition, boolean z2) throws IOException {
        return new AnimatableFloatValue(KeyframesParser.a(jsonReader2, lottieComposition, z2 ? Utils.c() : 1.0f, FloatParser.a));
    }

    public static void r2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull IBinder iBinder, boolean z2) {
        if (iBinder == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeStrongBinder(iBinder);
            A2(parcel, iY2);
        }
    }

    public static void s(@RecentlyNonNull Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name2).length() + 36 + String.valueOf(name).length());
            outline.s0(sb, "Must be called on ", name2, " thread, but got ", name);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
    }

    public static int s0(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public static AnimatableIntegerValue s1(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(o1(jsonReader2, lottieComposition, IntegerParser.a));
    }

    public static void s2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable parcelable, int i2, boolean z2) {
        if (parcelable == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            A2(parcel, iY2);
        }
    }

    @Pure
    public static int t(int i, int i2, int i3) {
        if (i < i2 || i >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return i;
    }

    public static Object t0(JavaType javaType) {
        Class<?> cls = javaType._class;
        Class<?> clsV = ClassUtil.v(cls);
        if (clsV == null) {
            if (javaType.v() || javaType.b()) {
                return JsonInclude.a.NON_EMPTY;
            }
            if (cls == String.class) {
                return "";
            }
            if (javaType.B(Date.class)) {
                return new Date(0L);
            }
            if (!javaType.B(Calendar.class)) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0L);
            return gregorianCalendar;
        }
        if (clsV == Integer.TYPE) {
            return 0;
        }
        if (clsV == Long.TYPE) {
            return 0L;
        }
        if (clsV == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (clsV == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (clsV == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (clsV == Byte.TYPE) {
            return (byte) 0;
        }
        if (clsV == Short.TYPE) {
            return (short) 0;
        }
        if (clsV == Character.TYPE) {
            return (char) 0;
        }
        throw new IllegalArgumentException(outline.o(clsV, outline.U("Class "), " is not a primitive type"));
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01bc A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<Projection.a> t1(ParsableByteArray parsableByteArray) {
        ArrayList<Projection.a> arrayList;
        int i;
        ArrayList<Projection.a> arrayList2;
        Projection.a aVar;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        if (parsableByteArray.t() != 0) {
            return null;
        }
        parsableByteArray2.F(7);
        int iF = parsableByteArray.f();
        if (iF == 1684433976) {
            ParsableByteArray parsableByteArray3 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!Util2.x(parsableByteArray2, parsableByteArray3, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray2 = parsableByteArray3;
            } finally {
                inflater.end();
            }
        } else if (iF != 1918990112) {
            return null;
        }
        ArrayList<Projection.a> arrayList3 = new ArrayList<>();
        int i2 = parsableByteArray2.f984b;
        int i3 = parsableByteArray2.c;
        while (i2 < i3) {
            int iF2 = parsableByteArray2.f() + i2;
            if (iF2 > i2 && iF2 <= i3) {
                if (parsableByteArray2.f() == 1835365224) {
                    int iF3 = parsableByteArray2.f();
                    if (iF3 <= 10000) {
                        float[] fArr = new float[iF3];
                        for (int i4 = 0; i4 < iF3; i4++) {
                            fArr[i4] = Float.intBitsToFloat(parsableByteArray2.f());
                        }
                        int iF4 = parsableByteArray2.f();
                        if (iF4 <= 32000) {
                            double dLog = Math.log(2.0d);
                            arrayList2 = arrayList3;
                            int iCeil = (int) Math.ceil(Math.log(iF3 * 2.0d) / dLog);
                            ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray2.a);
                            parsableBitArray.k(parsableByteArray2.f984b * 8);
                            float[] fArr2 = new float[iF4 * 5];
                            int i5 = 5;
                            int[] iArr = new int[5];
                            int i6 = 0;
                            int i7 = 0;
                            while (true) {
                                if (i6 < iF4) {
                                    int i8 = 0;
                                    while (i8 < i5) {
                                        int i9 = iArr[i8];
                                        int iG = parsableBitArray.g(iCeil);
                                        int i10 = i9 + ((-(iG & 1)) ^ (iG >> 1));
                                        if (i10 >= iF3 || i10 < 0) {
                                            break;
                                        }
                                        fArr2[i7] = fArr[i10];
                                        iArr[i8] = i10;
                                        i8++;
                                        i7++;
                                        i5 = 5;
                                    }
                                    i6++;
                                    i5 = 5;
                                } else {
                                    parsableBitArray.k((parsableBitArray.e() + 7) & (-8));
                                    int i11 = 32;
                                    int iG2 = parsableBitArray.g(32);
                                    Projection.b[] bVarArr = new Projection.b[iG2];
                                    int i12 = 0;
                                    while (i12 < iG2) {
                                        int iG3 = parsableBitArray.g(8);
                                        int iG4 = parsableBitArray.g(8);
                                        int iG5 = parsableBitArray.g(i11);
                                        if (iG5 <= 128000) {
                                            i = i3;
                                            int iCeil2 = (int) Math.ceil(Math.log(iF4 * 2.0d) / dLog);
                                            float[] fArr3 = new float[iG5 * 3];
                                            float[] fArr4 = new float[iG5 * 2];
                                            int i13 = 0;
                                            int i14 = 0;
                                            while (i13 < iG5) {
                                                int iG6 = parsableBitArray.g(iCeil2);
                                                int i15 = iG6 >> 1;
                                                ParsableBitArray parsableBitArray2 = parsableBitArray;
                                                int i16 = iG6 & 1;
                                                int i17 = iG2;
                                                float[] fArr5 = fArr4;
                                                int i18 = i14 + ((-i16) ^ i15);
                                                if (i18 >= 0 && i18 < iF4) {
                                                    int i19 = i13 * 3;
                                                    int i20 = i18 * 5;
                                                    fArr3[i19] = fArr2[i20];
                                                    fArr3[i19 + 1] = fArr2[i20 + 1];
                                                    fArr3[i19 + 2] = fArr2[i20 + 2];
                                                    int i21 = i13 * 2;
                                                    fArr5[i21] = fArr2[i20 + 3];
                                                    fArr5[i21 + 1] = fArr2[i20 + 4];
                                                    i13++;
                                                    i14 = i18;
                                                    fArr4 = fArr5;
                                                    iG2 = i17;
                                                    parsableBitArray = parsableBitArray2;
                                                }
                                            }
                                            bVarArr[i12] = new Projection.b(iG3, fArr3, fArr4, iG4);
                                            i12++;
                                            i3 = i;
                                            iG2 = iG2;
                                            i11 = 32;
                                        }
                                    }
                                    i = i3;
                                    aVar = new Projection.a(bVarArr);
                                }
                            }
                        }
                        i = i3;
                        aVar = null;
                        if (aVar == null) {
                            arrayList = arrayList2;
                            arrayList.add(aVar);
                        }
                    }
                    arrayList2 = arrayList3;
                    i = i3;
                    aVar = null;
                    if (aVar == null) {
                    }
                } else {
                    arrayList = arrayList3;
                    i = i3;
                }
                parsableByteArray2.E(iF2);
                arrayList3 = arrayList;
                i2 = iF2;
                i3 = i;
            }
            return null;
        }
        return arrayList3;
    }

    public static void t2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String str, boolean z2) {
        if (str == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeString(str);
            A2(parcel, iY2);
        }
    }

    public static void u(@RecentlyNonNull String str) {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            throw new IllegalStateException(str);
        }
    }

    public static Drawable u0(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    public static AnimatablePointValue u1(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(KeyframesParser.a(jsonReader2, lottieComposition, Utils.c(), PointFParser.a));
    }

    public static void u2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String[] strArr, boolean z2) {
        if (strArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
            }
        } else {
            int iY2 = y2(parcel, i);
            parcel.writeStringArray(strArr);
            A2(parcel, iY2);
        }
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    public static String v(@Nullable String str, @RecentlyNonNull Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    @RecentlyNonNull
    public static String v0(@RecentlyNonNull PowerManager.WakeLock wakeLock, @RecentlyNonNull String str) {
        String strValueOf = String.valueOf(String.valueOf(System.identityHashCode(wakeLock) | (Process.myPid() << 32)));
        String strValueOf2 = String.valueOf(true == TextUtils.isEmpty(null) ? "" : null);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    @Nullable
    public static PsshAtomUtil v1(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.c < 32) {
            return null;
        }
        parsableByteArray.E(0);
        if (parsableByteArray.f() != parsableByteArray.a() + 4 || parsableByteArray.f() != 1886614376) {
            return null;
        }
        int iF = (parsableByteArray.f() >> 24) & 255;
        if (iF > 1) {
            outline.g0(37, "Unsupported pssh version: ", iF, "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(parsableByteArray.m(), parsableByteArray.m());
        if (iF == 1) {
            parsableByteArray.F(parsableByteArray.w() * 16);
        }
        int iW = parsableByteArray.w();
        if (iW != parsableByteArray.a()) {
            return null;
        }
        byte[] bArr2 = new byte[iW];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr2, 0, iW);
        parsableByteArray.f984b += iW;
        return new PsshAtomUtil(uuid, iF, bArr2);
    }

    public static <T extends Parcelable> void v2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull T[] tArr, int i2, boolean z2) {
        if (tArr == null) {
            if (z2) {
                parcel.writeInt(i | 0);
                return;
            }
            return;
        }
        int iY2 = y2(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                B2(parcel, t, i2);
            }
        }
        A2(parcel, iY2);
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    public static String w(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    public static int w0(InputStream inputStream) throws IOException {
        byte b2 = (byte) inputStream.read();
        byte b3 = (byte) inputStream.read();
        return ((((byte) inputStream.read()) << 24) & ViewCompat.MEASURED_STATE_MASK) | ((((byte) inputStream.read()) << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((b3 << 8) & 65280) | (b2 & 255);
    }

    @Nullable
    public static byte[] w1(byte[] bArr, UUID uuid) {
        PsshAtomUtil psshAtomUtilV1 = v1(bArr);
        if (psshAtomUtilV1 == null) {
            return null;
        }
        if (uuid.equals(psshAtomUtilV1.a)) {
            return psshAtomUtilV1.c;
        }
        String strValueOf = String.valueOf(uuid);
        String strValueOf2 = String.valueOf(psshAtomUtilV1.a);
        outline.r0(outline.S(strValueOf2.length() + strValueOf.length() + 33, "UUID mismatch. Expected: ", strValueOf, ", got: ", strValueOf2), ".", "PsshAtomUtil");
        return null;
    }

    public static <T extends Parcelable> void w2(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull List<T> list, boolean z2) {
        if (list == null) {
            if (z2) {
                parcel.writeInt(i | 0);
                return;
            }
            return;
        }
        int iY2 = y2(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                B2(parcel, t, 0);
            }
        }
        A2(parcel, iY2);
    }

    public static void x(@RecentlyNonNull String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static final Integer x0(Intent intent, String str) {
        Intrinsics3.checkNotNullParameter(intent, "$this$getIntExtraOrNull");
        Intrinsics3.checkNotNullParameter(str, "key");
        Integer numValueOf = Integer.valueOf(intent.getIntExtra(str, Integer.MIN_VALUE));
        if (numValueOf.intValue() == Integer.MIN_VALUE) {
            return null;
        }
        return numValueOf;
    }

    public static boolean x1(ExtractorInput extractorInput, byte[] bArr, int i, int i2, boolean z2) throws IOException {
        try {
            return extractorInput.e(bArr, i, i2, z2);
        } catch (EOFException e2) {
            if (z2) {
                return false;
            }
            throw e2;
        }
    }

    public static void x2(Parcel parcel, int i, int i2) {
        int iM1 = M1(parcel, i);
        if (iM1 == i2) {
            return;
        }
        String hexString = Integer.toHexString(iM1);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(iM1);
        throw new SafeParcelReader$ParseException(outline.K(sb, " (0x", hexString, ")"), parcel);
    }

    public static <T> T y(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static final StageRequestToSpeakState y0(VoiceState voiceState) {
        return voiceState == null ? StageRequestToSpeakState.NONE : (!voiceState.getSuppress() || voiceState.getRequestToSpeakTimestamp() == null) ? (voiceState.getSuppress() || voiceState.getRequestToSpeakTimestamp() == null) ? !voiceState.getSuppress() ? StageRequestToSpeakState.ON_STAGE : StageRequestToSpeakState.NONE : StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK : StageRequestToSpeakState.REQUESTED_TO_SPEAK;
    }

    @Nullable
    public static Metadata y1(ExtractorInput extractorInput, boolean z2) throws IOException {
        b.i.a.c.z2.k.a aVar;
        if (z2) {
            aVar = null;
        } else {
            int i = Id3Decoder.a;
            aVar = b.i.a.c.z2.k.a.a;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        Metadata metadataD = null;
        int i2 = 0;
        while (true) {
            try {
                extractorInput.o(parsableByteArray.a, 0, 10);
                parsableByteArray.E(0);
                if (parsableByteArray.v() != 4801587) {
                    break;
                }
                parsableByteArray.F(3);
                int iS = parsableByteArray.s();
                int i3 = iS + 10;
                if (metadataD == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(parsableByteArray.a, 0, bArr, 0, 10);
                    extractorInput.o(bArr, 10, iS);
                    metadataD = new Id3Decoder(aVar).d(bArr, i3);
                } else {
                    extractorInput.g(iS);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        extractorInput.k();
        extractorInput.g(i2);
        if (metadataD == null || metadataD.j.length == 0) {
            return null;
        }
        return metadataD;
    }

    public static int y2(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    @NonNull
    @EnsuresNonNull({"#1"})
    public static <T> T z(@RecentlyNonNull T t, @RecentlyNonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static List<String> z0(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                Objects.requireNonNull((MultiCacheKey) cacheKey);
                throw null;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(cacheKey.a() ? cacheKey.b() : W1(cacheKey));
            return arrayList;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static int z1(ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = extractorInput.i(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void z2(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        throw new SafeParcelReader$ParseException(outline.K(sb, " (0x", hexString, ")"), parcel);
    }
}
