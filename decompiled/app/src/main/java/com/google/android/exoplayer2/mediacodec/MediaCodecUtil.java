package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.ColorInfo;
import b.i.a.c.y2.MediaCodecInfo;
import b.i.a.c.y2.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
/* loaded from: classes3.dex */
public final class MediaCodecUtil {
    public static final Pattern a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("MediaCodecUtil.class")
    public static final HashMap<b, List<MediaCodecInfo>> f2947b = new HashMap<>();
    public static int c = -1;

    public static class DecoderQueryException extends Exception {
        public DecoderQueryException(Throwable th, a aVar) {
            super("Failed to query underlying media codecs", th);
        }
    }

    public static final class b {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f2948b;
        public final boolean c;

        public b(String str, boolean z2, boolean z3) {
            this.a = str;
            this.f2948b = z2;
            this.c = z3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.a, bVar.a) && this.f2948b == bVar.f2948b && this.c == bVar.c;
        }

        public int hashCode() {
            return ((outline.m(this.a, 31, 31) + (this.f2948b ? 1231 : 1237)) * 31) + (this.c ? 1231 : 1237);
        }
    }

    public interface c {
        android.media.MediaCodecInfo a(int i);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    public static final class d implements c {
        public d(a aVar) {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public android.media.MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int d() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean e() {
            return false;
        }
    }

    @RequiresApi(21)
    public static final class e implements c {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public android.media.MediaCodecInfo[] f2949b;

        public e(boolean z2, boolean z3) {
            this.a = (z2 || z3) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public android.media.MediaCodecInfo a(int i) {
            if (this.f2949b == null) {
                this.f2949b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.f2949b[i];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int d() {
            if (this.f2949b == null) {
                this.f2949b = new MediaCodecList(this.a).getCodecInfos();
            }
            return this.f2949b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean e() {
            return true;
        }
    }

    public interface f<T> {
        int a(T t);
    }

    public static void a(String str, List<b.i.a.c.y2.MediaCodecInfo> list) {
        if ("audio/raw".equals(str)) {
            if (Util2.a < 26 && Util2.f968b.equals("R9") && list.size() == 1 && list.get(0).a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(b.i.a.c.y2.MediaCodecInfo.i("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            j(list, b.i.a.c.y2.e.a);
        }
        int i = Util2.a;
        if (i < 21 && list.size() > 1) {
            String str2 = list.get(0).a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                j(list, b.i.a.c.y2.f.a);
            }
        }
        if (i >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).a)) {
            return;
        }
        list.add(list.remove(0));
    }

    @Nullable
    public static String b(android.media.MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0158, code lost:
    
        switch(r0) {
            case 1567: goto L142;
            case 1568: goto L138;
            case 1569: goto L134;
            case 1570: goto L130;
            default: goto L146;
        };
     */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x042f A[Catch: NumberFormatException -> 0x043f, TRY_LEAVE, TryCatch #3 {NumberFormatException -> 0x043f, blocks: (B:280:0x03c4, B:282:0x03d8, B:294:0x03f7, B:310:0x042f), top: B:637:0x03c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:585:0x08a6  */
    /* JADX WARN: Removed duplicated region for block: B:586:0x08a8  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x08bd  */
    /* JADX WARN: Removed duplicated region for block: B:597:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x08c2  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x08c5  */
    /* JADX WARN: Removed duplicated region for block: B:600:0x08c8  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x08ce  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x08d1  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x08d4  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x08d7  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x08db  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x08de  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x08e1  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x08e7  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x08ea  */
    /* JADX WARN: Removed duplicated region for block: B:612:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:614:0x08f3  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x08f9  */
    /* JADX WARN: Removed duplicated region for block: B:617:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x08ff  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0901  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0907  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:646:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014a  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> c(Format2 format2) throws NumberFormatException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Integer num;
        int i8;
        int i9;
        int i10;
        int i11;
        Integer num2;
        Integer num3;
        String str = format2.t;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(format2.w)) {
            String str2 = format2.t;
            if (strArrSplit.length < 3) {
                String strValueOf = String.valueOf(str2);
                Log.w("MediaCodecUtil", strValueOf.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(strValueOf) : new String("Ignoring malformed Dolby Vision codec string: "));
            } else {
                Matcher matcher = a.matcher(strArrSplit[1]);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    if (strGroup == null) {
                        num2 = null;
                        if (num2 != null) {
                            String strValueOf2 = String.valueOf(strGroup);
                            Log.w("MediaCodecUtil", strValueOf2.length() != 0 ? "Unknown Dolby Vision profile string: ".concat(strValueOf2) : new String("Unknown Dolby Vision profile string: "));
                        } else {
                            String str3 = strArrSplit[2];
                            if (str3 == null) {
                                num3 = null;
                                if (num3 == null) {
                                    return new Pair<>(num2, num3);
                                }
                                String strValueOf3 = String.valueOf(str3);
                                Log.w("MediaCodecUtil", strValueOf3.length() != 0 ? "Unknown Dolby Vision level string: ".concat(strValueOf3) : new String("Unknown Dolby Vision level string: "));
                            } else {
                                int iHashCode = str3.hashCode();
                                switch (str3) {
                                    case "01":
                                        num3 = 1;
                                        break;
                                    case "02":
                                        num3 = 2;
                                        break;
                                    case "03":
                                        num3 = 4;
                                        break;
                                    case "04":
                                        num3 = 8;
                                        break;
                                    case "05":
                                        num3 = 16;
                                        break;
                                    case "06":
                                        num3 = 32;
                                        break;
                                    case "07":
                                        num3 = 64;
                                        break;
                                    case "08":
                                        num3 = 128;
                                        break;
                                    case "09":
                                        num3 = 256;
                                        break;
                                    case "10":
                                        num3 = 512;
                                        break;
                                    case "11":
                                        num3 = 1024;
                                        break;
                                    case "12":
                                        num3 = 2048;
                                        break;
                                    case "13":
                                        num3 = 4096;
                                        break;
                                }
                                if (num3 == null) {
                                }
                            }
                        }
                    } else {
                        switch (strGroup) {
                            case "00":
                                num2 = 1;
                                break;
                            case "01":
                                num2 = 2;
                                break;
                            case "02":
                                num2 = 4;
                                break;
                            case "03":
                                num2 = 8;
                                break;
                            case "04":
                                num2 = 16;
                                break;
                            case "05":
                                num2 = 32;
                                break;
                            case "06":
                                num2 = 64;
                                break;
                            case "07":
                                num2 = 128;
                                break;
                            case "08":
                                num2 = 256;
                                break;
                            case "09":
                                num2 = 512;
                                break;
                        }
                        if (num2 != null) {
                        }
                    }
                } else {
                    String strValueOf4 = String.valueOf(str2);
                    Log.w("MediaCodecUtil", strValueOf4.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(strValueOf4) : new String("Ignoring malformed Dolby Vision codec string: "));
                }
            }
            return null;
        }
        String str4 = strArrSplit[0];
        str4.hashCode();
        switch (str4) {
            case "av01":
                String str5 = format2.t;
                ColorInfo colorInfo = format2.I;
                if (strArrSplit.length < 4) {
                    String strValueOf5 = String.valueOf(str5);
                    Log.w("MediaCodecUtil", strValueOf5.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(strValueOf5) : new String("Ignoring malformed AV1 codec string: "));
                    return null;
                }
                try {
                    int i12 = Integer.parseInt(strArrSplit[1]);
                    int i13 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                    int i14 = Integer.parseInt(strArrSplit[3]);
                    if (i12 != 0) {
                        outline.g0(32, "Unknown AV1 profile: ", i12, "MediaCodecUtil");
                    } else {
                        int i15 = 8;
                        if (i14 == 8) {
                            int i16 = i14 != i15 ? 1 : (colorInfo == null || !(colorInfo.n != null || (i = colorInfo.m) == 7 || i == 6)) ? 2 : 4096;
                            switch (i13) {
                                case 0:
                                    i2 = 1;
                                    break;
                                case 1:
                                    i2 = 2;
                                    break;
                                case 2:
                                    i2 = 4;
                                    break;
                                case 3:
                                    i2 = 8;
                                    break;
                                case 4:
                                    i2 = 16;
                                    break;
                                case 5:
                                    i2 = 32;
                                    break;
                                case 6:
                                    i2 = 64;
                                    break;
                                case 7:
                                    i2 = 128;
                                    break;
                                case 8:
                                    i2 = 256;
                                    break;
                                case 9:
                                    i2 = 512;
                                    break;
                                case 10:
                                    i2 = 1024;
                                    break;
                                case 11:
                                    i2 = 2048;
                                    break;
                                case 12:
                                    i2 = 4096;
                                    break;
                                case 13:
                                    i2 = 8192;
                                    break;
                                case 14:
                                    i2 = 16384;
                                    break;
                                case 15:
                                    i2 = 32768;
                                    break;
                                case 16:
                                    i2 = 65536;
                                    break;
                                case 17:
                                    i2 = 131072;
                                    break;
                                case 18:
                                    i2 = 262144;
                                    break;
                                case 19:
                                    i2 = 524288;
                                    break;
                                case 20:
                                    i2 = 1048576;
                                    break;
                                case 21:
                                    i2 = 2097152;
                                    break;
                                case 22:
                                    i2 = 4194304;
                                    break;
                                case 23:
                                    i2 = 8388608;
                                    break;
                                default:
                                    i2 = -1;
                                    break;
                            }
                            if (i2 == -1) {
                                return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i2));
                            }
                            outline.g0(30, "Unknown AV1 level: ", i13, "MediaCodecUtil");
                        } else if (i14 != 10) {
                            outline.g0(34, "Unknown AV1 bit depth: ", i14, "MediaCodecUtil");
                        } else {
                            i15 = 8;
                            if (i14 != i15) {
                            }
                            switch (i13) {
                            }
                            if (i2 == -1) {
                            }
                        }
                    }
                } catch (NumberFormatException unused) {
                    String strValueOf6 = String.valueOf(str5);
                    Log.w("MediaCodecUtil", strValueOf6.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(strValueOf6) : new String("Ignoring malformed AV1 codec string: "));
                }
                return null;
            case "avc1":
            case "avc2":
                int i17 = 2048;
                String str6 = format2.t;
                if (strArrSplit.length < 2) {
                    String strValueOf7 = String.valueOf(str6);
                    Log.w("MediaCodecUtil", strValueOf7.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf7) : new String("Ignoring malformed AVC codec string: "));
                    return null;
                }
                try {
                    if (strArrSplit[1].length() == 6) {
                        i3 = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                        i4 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                    } else {
                        if (strArrSplit.length < 3) {
                            String strValueOf8 = String.valueOf(str6);
                            Log.w("MediaCodecUtil", strValueOf8.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf8) : new String("Ignoring malformed AVC codec string: "));
                            return null;
                        }
                        i3 = Integer.parseInt(strArrSplit[1]);
                        i4 = Integer.parseInt(strArrSplit[2]);
                    }
                    int i18 = i3 != 66 ? i3 != 77 ? i3 != 88 ? i3 != 100 ? i3 != 110 ? i3 != 122 ? i3 != 244 ? -1 : 64 : 32 : 16 : 8 : 4 : 2 : 1;
                    if (i18 == -1) {
                        outline.g0(32, "Unknown AVC profile: ", i3, "MediaCodecUtil");
                        return null;
                    }
                    switch (i4) {
                        case 10:
                            i5 = -1;
                            i6 = 1;
                            break;
                        case 11:
                            i5 = -1;
                            i6 = 4;
                            break;
                        case 12:
                            i5 = -1;
                            i6 = 8;
                            break;
                        case 13:
                            i5 = -1;
                            i6 = 16;
                            break;
                        default:
                            switch (i4) {
                                case 20:
                                    i5 = -1;
                                    i6 = 32;
                                    break;
                                case 21:
                                    i5 = -1;
                                    i6 = 64;
                                    break;
                                case 22:
                                    i5 = -1;
                                    i6 = 128;
                                    break;
                                default:
                                    switch (i4) {
                                        case 30:
                                            i5 = -1;
                                            i6 = 256;
                                            break;
                                        case 31:
                                            i5 = -1;
                                            i6 = 512;
                                            break;
                                        case 32:
                                            i5 = -1;
                                            i6 = 1024;
                                            break;
                                        default:
                                            switch (i4) {
                                                case 40:
                                                    i6 = i17;
                                                    i5 = -1;
                                                    break;
                                                case 41:
                                                    i5 = -1;
                                                    i6 = 4096;
                                                    break;
                                                case 42:
                                                    i17 = 8192;
                                                    i6 = i17;
                                                    i5 = -1;
                                                    break;
                                                default:
                                                    switch (i4) {
                                                        case 50:
                                                            i17 = 16384;
                                                            i6 = i17;
                                                            i5 = -1;
                                                            break;
                                                        case 51:
                                                            i17 = 32768;
                                                            i6 = i17;
                                                            i5 = -1;
                                                            break;
                                                        case 52:
                                                            i17 = 65536;
                                                            i6 = i17;
                                                            i5 = -1;
                                                            break;
                                                        default:
                                                            i5 = -1;
                                                            i6 = -1;
                                                            break;
                                                    }
                                            }
                                    }
                            }
                    }
                    if (i6 != i5) {
                        return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i6));
                    }
                    outline.g0(30, "Unknown AVC level: ", i4, "MediaCodecUtil");
                    return null;
                } catch (NumberFormatException unused2) {
                    String strValueOf9 = String.valueOf(str6);
                    Log.w("MediaCodecUtil", strValueOf9.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf9) : new String("Ignoring malformed AVC codec string: "));
                    return null;
                }
            case "hev1":
            case "hvc1":
                String str7 = format2.t;
                if (strArrSplit.length < 4) {
                    String strValueOf10 = String.valueOf(str7);
                    Log.w("MediaCodecUtil", strValueOf10.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(strValueOf10) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                Matcher matcher2 = a.matcher(strArrSplit[1]);
                if (!matcher2.matches()) {
                    String strValueOf11 = String.valueOf(str7);
                    Log.w("MediaCodecUtil", strValueOf11.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(strValueOf11) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                String strGroup2 = matcher2.group(1);
                if ("1".equals(strGroup2)) {
                    i7 = 1;
                } else {
                    if (!ExifInterface.GPS_MEASUREMENT_2D.equals(strGroup2)) {
                        String strValueOf12 = String.valueOf(strGroup2);
                        Log.w("MediaCodecUtil", strValueOf12.length() != 0 ? "Unknown HEVC profile string: ".concat(strValueOf12) : new String("Unknown HEVC profile string: "));
                        return null;
                    }
                    i7 = 2;
                }
                String str8 = strArrSplit[3];
                if (str8 != null) {
                    switch (str8) {
                        case "H30":
                            num = 2;
                            break;
                        case "H60":
                            num = 8;
                            break;
                        case "H63":
                            num = 32;
                            break;
                        case "H90":
                            num = 128;
                            break;
                        case "H93":
                            num = 512;
                            break;
                        case "L30":
                            num = 1;
                            break;
                        case "L60":
                            num = 4;
                            break;
                        case "L63":
                            num = 16;
                            break;
                        case "L90":
                            num = 64;
                            break;
                        case "L93":
                            num = 256;
                            break;
                        case "H120":
                            num = 2048;
                            break;
                        case "H123":
                            num = 8192;
                            break;
                        case "H150":
                            num = 32768;
                            break;
                        case "H153":
                            num = 131072;
                            break;
                        case "H156":
                            num = 524288;
                            break;
                        case "H180":
                            num = 2097152;
                            break;
                        case "H183":
                            num = 8388608;
                            break;
                        case "H186":
                            num = 33554432;
                            break;
                        case "L120":
                            num = 1024;
                            break;
                        case "L123":
                            num = 4096;
                            break;
                        case "L150":
                            num = 16384;
                            break;
                        case "L153":
                            num = 65536;
                            break;
                        case "L156":
                            num = 262144;
                            break;
                        case "L180":
                            num = 1048576;
                            break;
                        case "L183":
                            num = 4194304;
                            break;
                        case "L186":
                            num = 16777216;
                            break;
                    }
                } else {
                    num = null;
                }
                if (num != null) {
                    return new Pair<>(Integer.valueOf(i7), num);
                }
                String strValueOf13 = String.valueOf(str8);
                Log.w("MediaCodecUtil", strValueOf13.length() != 0 ? "Unknown HEVC level string: ".concat(strValueOf13) : new String("Unknown HEVC level string: "));
                return null;
            case "mp4a":
                String str9 = format2.t;
                if (strArrSplit.length != 3) {
                    String strValueOf14 = String.valueOf(str9);
                    Log.w("MediaCodecUtil", strValueOf14.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(strValueOf14) : new String("Ignoring malformed MP4A codec string: "));
                    return null;
                }
                try {
                    if (!"audio/mp4a-latm".equals(MimeTypes.d(Integer.parseInt(strArrSplit[1], 16)))) {
                        return null;
                    }
                    int i19 = Integer.parseInt(strArrSplit[2]);
                    if (i19 == 17) {
                        i8 = 17;
                    } else if (i19 == 20) {
                        i8 = 20;
                    } else if (i19 == 23) {
                        i8 = 23;
                    } else if (i19 == 29) {
                        i8 = 29;
                    } else if (i19 == 39) {
                        i8 = 39;
                    } else {
                        if (i19 != 42) {
                            switch (i19) {
                                case 1:
                                    i9 = -1;
                                    i8 = 1;
                                    break;
                                case 2:
                                    i9 = -1;
                                    i8 = 2;
                                    break;
                                case 3:
                                    i9 = -1;
                                    i8 = 3;
                                    break;
                                case 4:
                                    i9 = -1;
                                    i8 = 4;
                                    break;
                                case 5:
                                    i9 = -1;
                                    i8 = 5;
                                    break;
                                case 6:
                                    i9 = -1;
                                    i8 = 6;
                                    break;
                                default:
                                    i9 = -1;
                                    i8 = -1;
                                    break;
                            }
                            if (i8 == i9) {
                                return new Pair<>(Integer.valueOf(i8), 0);
                            }
                            return null;
                        }
                        i8 = 42;
                    }
                    i9 = -1;
                    if (i8 == i9) {
                    }
                } catch (NumberFormatException unused3) {
                    String strValueOf15 = String.valueOf(str9);
                    Log.w("MediaCodecUtil", strValueOf15.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(strValueOf15) : new String("Ignoring malformed MP4A codec string: "));
                    return null;
                }
            case "vp09":
                String str10 = format2.t;
                if (strArrSplit.length < 3) {
                    String strValueOf16 = String.valueOf(str10);
                    Log.w("MediaCodecUtil", strValueOf16.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(strValueOf16) : new String("Ignoring malformed VP9 codec string: "));
                    return null;
                }
                try {
                    int i20 = Integer.parseInt(strArrSplit[1]);
                    int i21 = Integer.parseInt(strArrSplit[2]);
                    int i22 = i20 != 0 ? i20 != 1 ? i20 != 2 ? i20 != 3 ? -1 : 8 : 4 : 2 : 1;
                    if (i22 == -1) {
                        outline.g0(32, "Unknown VP9 profile: ", i20, "MediaCodecUtil");
                        return null;
                    }
                    if (i21 == 10) {
                        i10 = -1;
                        i11 = 1;
                    } else if (i21 == 11) {
                        i10 = -1;
                        i11 = 2;
                    } else if (i21 == 20) {
                        i10 = -1;
                        i11 = 4;
                    } else if (i21 == 21) {
                        i10 = -1;
                        i11 = 8;
                    } else if (i21 == 30) {
                        i10 = -1;
                        i11 = 16;
                    } else if (i21 == 31) {
                        i10 = -1;
                        i11 = 32;
                    } else if (i21 == 40) {
                        i10 = -1;
                        i11 = 64;
                    } else if (i21 == 41) {
                        i10 = -1;
                        i11 = 128;
                    } else if (i21 == 50) {
                        i10 = -1;
                        i11 = 256;
                    } else if (i21 != 51) {
                        switch (i21) {
                            case 60:
                                i10 = -1;
                                i11 = 2048;
                                break;
                            case 61:
                                i10 = -1;
                                i11 = 4096;
                                break;
                            case 62:
                                i11 = 8192;
                                i10 = -1;
                                break;
                            default:
                                i10 = -1;
                                i11 = -1;
                                break;
                        }
                    } else {
                        i10 = -1;
                        i11 = 512;
                    }
                    if (i11 != i10) {
                        return new Pair<>(Integer.valueOf(i22), Integer.valueOf(i11));
                    }
                    outline.g0(30, "Unknown VP9 level: ", i21, "MediaCodecUtil");
                    return null;
                } catch (NumberFormatException unused4) {
                    String strValueOf17 = String.valueOf(str10);
                    Log.w("MediaCodecUtil", strValueOf17.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(strValueOf17) : new String("Ignoring malformed VP9 codec string: "));
                    return null;
                }
            default:
                return null;
        }
    }

    @Nullable
    public static b.i.a.c.y2.MediaCodecInfo d(String str, boolean z2, boolean z3) throws DecoderQueryException {
        List<b.i.a.c.y2.MediaCodecInfo> listE = e(str, z2, z3);
        if (listE.isEmpty()) {
            return null;
        }
        return listE.get(0);
    }

    public static synchronized List<b.i.a.c.y2.MediaCodecInfo> e(String str, boolean z2, boolean z3) throws DecoderQueryException {
        b bVar = new b(str, z2, z3);
        HashMap<b, List<b.i.a.c.y2.MediaCodecInfo>> map = f2947b;
        List<b.i.a.c.y2.MediaCodecInfo> list = map.get(bVar);
        if (list != null) {
            return list;
        }
        int i = Util2.a;
        ArrayList<b.i.a.c.y2.MediaCodecInfo> arrayListF = f(bVar, i >= 21 ? new e(z2, z3) : new d(null));
        if (z2 && arrayListF.isEmpty() && 21 <= i && i <= 23) {
            arrayListF = f(bVar, new d(null));
            if (!arrayListF.isEmpty()) {
                String str2 = arrayListF.get(0).a;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                sb.append("MediaCodecList API didn't list secure decoder for: ");
                sb.append(str);
                sb.append(". Assuming: ");
                sb.append(str2);
                Log.w("MediaCodecUtil", sb.toString());
            }
        }
        a(str, arrayListF);
        List<b.i.a.c.y2.MediaCodecInfo> listUnmodifiableList = Collections.unmodifiableList(arrayListF);
        map.put(bVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static ArrayList<b.i.a.c.y2.MediaCodecInfo> f(b bVar, c cVar) throws Exception {
        String strB;
        String str;
        String str2;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        boolean zIsHardwareAccelerated;
        boolean zIsVendor;
        try {
            ArrayList<b.i.a.c.y2.MediaCodecInfo> arrayList = new ArrayList<>();
            String str3 = bVar.a;
            int iD = cVar.d();
            boolean zE = cVar.e();
            int i3 = 0;
            while (i3 < iD) {
                android.media.MediaCodecInfo mediaCodecInfoA = cVar.a(i3);
                int i4 = Util2.a;
                if (!(i4 >= 29 && mediaCodecInfoA.isAlias())) {
                    String name = mediaCodecInfoA.getName();
                    if (g(mediaCodecInfoA, name, zE, str3) && (strB = b(mediaCodecInfoA, name, str3)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(strB);
                            boolean zB = cVar.b("tunneled-playback", strB, capabilitiesForType);
                            boolean zC = cVar.c("tunneled-playback", strB, capabilitiesForType);
                            boolean z4 = bVar.c;
                            if ((z4 || !zC) && (!z4 || zB)) {
                                boolean zB2 = cVar.b("secure-playback", strB, capabilitiesForType);
                                boolean zC2 = cVar.c("secure-playback", strB, capabilitiesForType);
                                boolean z5 = bVar.f2948b;
                                if ((z5 || !zC2) && (!z5 || zB2)) {
                                    if (i4 >= 29) {
                                        zIsHardwareAccelerated = mediaCodecInfoA.isHardwareAccelerated();
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                        zIsHardwareAccelerated = !h(mediaCodecInfoA);
                                    }
                                    boolean zH = h(mediaCodecInfoA);
                                    if (i4 >= 29) {
                                        zIsVendor = mediaCodecInfoA.isVendor();
                                    } else {
                                        String strU1 = b.i.a.f.e.o.f.u1(mediaCodecInfoA.getName());
                                        if (strU1.startsWith("omx.google.") || strU1.startsWith("c2.android.") || strU1.startsWith("c2.google.")) {
                                            z3 = false;
                                        }
                                        zIsVendor = z3;
                                    }
                                    if (!(zE && bVar.f2948b == zB2) && (zE || bVar.f2948b)) {
                                        str = strB;
                                        str2 = name;
                                        i = i3;
                                        z2 = zE;
                                        i2 = iD;
                                        if (!z2 && zB2) {
                                            arrayList.add(b.i.a.c.y2.MediaCodecInfo.i(String.valueOf(str2).concat(".secure"), str3, str, capabilitiesForType, zIsHardwareAccelerated, zH, zIsVendor, false, true));
                                            return arrayList;
                                        }
                                    } else {
                                        str = strB;
                                        str2 = name;
                                        i = i3;
                                        z2 = zE;
                                        i2 = iD;
                                        try {
                                            arrayList.add(b.i.a.c.y2.MediaCodecInfo.i(name, str3, strB, capabilitiesForType, zIsHardwareAccelerated, zH, zIsVendor, false, false));
                                        } catch (Exception e2) {
                                            e = e2;
                                            if (Util2.a > 23 || arrayList.isEmpty()) {
                                                String str4 = str2;
                                                StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 25 + str.length());
                                                sb.append("Failed to query codec ");
                                                sb.append(str4);
                                                sb.append(" (");
                                                sb.append(str);
                                                sb.append(")");
                                                Log.e("MediaCodecUtil", sb.toString());
                                                throw e;
                                            }
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 46);
                                            sb2.append("Skipping codec ");
                                            sb2.append(str2);
                                            sb2.append(" (failed to query capabilities)");
                                            Log.e("MediaCodecUtil", sb2.toString());
                                            i3 = i + 1;
                                            iD = i2;
                                            zE = z2;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = strB;
                            str2 = name;
                            i = i3;
                            z2 = zE;
                            i2 = iD;
                        }
                    }
                    i3 = i + 1;
                    iD = i2;
                    zE = z2;
                }
                i = i3;
                z2 = zE;
                i2 = iD;
                i3 = i + 1;
                iD = i2;
                zE = z2;
            }
            return arrayList;
        } catch (Exception e4) {
            throw new DecoderQueryException(e4, null);
        }
    }

    public static boolean g(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z2 && str.endsWith(".secure"))) {
            return false;
        }
        int i = Util2.a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util2.f968b;
            if ("a70".equals(str3) || ("Xiaomi".equals(Util2.c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util2.f968b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util2.f968b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util2.c))) {
            String str6 = Util2.f968b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util2.c)) {
            String str7 = Util2.f968b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && Util2.f968b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean h(android.media.MediaCodecInfo mediaCodecInfo) {
        if (Util2.a >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        String strU1 = b.i.a.f.e.o.f.u1(mediaCodecInfo.getName());
        if (strU1.startsWith("arc.")) {
            return false;
        }
        return strU1.startsWith("omx.google.") || strU1.startsWith("omx.ffmpeg.") || (strU1.startsWith("omx.sec.") && strU1.contains(".sw.")) || strU1.equals("omx.qcom.video.decoder.hevcswvdec") || strU1.startsWith("c2.android.") || strU1.startsWith("c2.google.") || !(strU1.startsWith("omx.") || strU1.startsWith("c2."));
    }

    public static int i() throws DecoderQueryException {
        int i;
        if (c == -1) {
            int iMax = 0;
            b.i.a.c.y2.MediaCodecInfo mediaCodecInfoD = d("video/avc", false, false);
            if (mediaCodecInfoD != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrD = mediaCodecInfoD.d();
                int length = codecProfileLevelArrD.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i2 = codecProfileLevelArrD[iMax].level;
                    if (i2 != 1 && i2 != 2) {
                        switch (i2) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i = 35651584;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    iMax2 = Math.max(i, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, Util2.a >= 21 ? 345600 : 172800);
            }
            c = iMax;
        }
        return c;
    }

    public static <T> void j(List<T> list, f<T> fVar) {
        Collections.sort(list, new h(fVar));
    }
}
