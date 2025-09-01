package b.i.a.c.b3.s;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.ViewCompat;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.SimpleSubtitleDecoder2;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.f3.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SubripDecoder.java */
/* renamed from: b.i.a.c.b3.s.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class SubripDecoder extends SimpleSubtitleDecoder2 {
    public static final Pattern n = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    public static final Pattern o = Pattern.compile("\\{\\\\.*?\\}");
    public final StringBuilder p;
    public final ArrayList<String> q;

    public SubripDecoder() {
        super("SubripDecoder");
        this.p = new StringBuilder();
        this.q = new ArrayList<>();
    }

    public static float k(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    public static long l(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = strGroup != null ? Long.parseLong(strGroup) * 60 * 60 * 1000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        Objects.requireNonNull(strGroup2);
        long j2 = (Long.parseLong(strGroup2) * 60 * 1000) + j;
        String strGroup3 = matcher.group(i + 3);
        Objects.requireNonNull(strGroup3);
        long j3 = (Long.parseLong(strGroup3) * 1000) + j2;
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j3 += Long.parseLong(strGroup4);
        }
        return j3 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019f  */
    @Override // b.i.a.c.b3.SimpleSubtitleDecoder2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Subtitle j(byte[] bArr, int i, boolean z2) throws NumberFormatException {
        ParsableByteArray parsableByteArray;
        String strG;
        long[] jArr;
        ParsableByteArray parsableByteArray2;
        char c;
        int i2;
        char c2;
        Cue cue;
        SubripDecoder subripDecoder = this;
        ArrayList arrayList = new ArrayList();
        long[] jArrCopyOf = new long[32];
        ParsableByteArray parsableByteArray3 = new ParsableByteArray(bArr, i);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            String strG2 = parsableByteArray3.g();
            if (strG2 != null) {
                if (strG2.length() != 0) {
                    try {
                        Integer.parseInt(strG2);
                        strG = parsableByteArray3.g();
                    } catch (NumberFormatException unused) {
                        parsableByteArray = parsableByteArray3;
                        Log.w("SubripDecoder", strG2.length() != 0 ? "Skipping invalid index: ".concat(strG2) : new String("Skipping invalid index: "));
                    }
                    if (strG == null) {
                        Log.w("SubripDecoder", "Unexpected end");
                    } else {
                        Matcher matcher = n.matcher(strG);
                        if (matcher.matches()) {
                            long jL = l(matcher, 1);
                            if (i4 == jArrCopyOf.length) {
                                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4 * 2);
                            }
                            int i5 = i4 + 1;
                            jArrCopyOf[i4] = jL;
                            long jL2 = l(matcher, 6);
                            if (i5 == jArrCopyOf.length) {
                                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i5 * 2);
                            }
                            int i6 = i5 + 1;
                            jArrCopyOf[i5] = jL2;
                            subripDecoder.p.setLength(i3);
                            subripDecoder.q.clear();
                            for (String strG3 = parsableByteArray3.g(); !TextUtils.isEmpty(strG3); strG3 = parsableByteArray3.g()) {
                                if (subripDecoder.p.length() > 0) {
                                    subripDecoder.p.append("<br>");
                                }
                                StringBuilder sb = subripDecoder.p;
                                ArrayList<String> arrayList2 = subripDecoder.q;
                                String strTrim = strG3.trim();
                                StringBuilder sb2 = new StringBuilder(strTrim);
                                Matcher matcher2 = o.matcher(strTrim);
                                int i7 = 0;
                                while (matcher2.find()) {
                                    String strGroup = matcher2.group();
                                    arrayList2.add(strGroup);
                                    int iStart = matcher2.start() - i7;
                                    int length = strGroup.length();
                                    sb2.replace(iStart, iStart + length, "");
                                    i7 += length;
                                }
                                sb.append(sb2.toString());
                            }
                            Spanned spannedFromHtml = Html.fromHtml(subripDecoder.p.toString());
                            String str = null;
                            int i8 = 0;
                            while (true) {
                                if (i8 < subripDecoder.q.size()) {
                                    String str2 = subripDecoder.q.get(i8);
                                    if (str2.matches("\\{\\\\an[1-9]\\}")) {
                                        str = str2;
                                    } else {
                                        i8++;
                                    }
                                }
                            }
                            if (str == null) {
                                cue = new Cue(spannedFromHtml, null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                                jArr = jArrCopyOf;
                                parsableByteArray2 = parsableByteArray3;
                                i2 = i6;
                            } else {
                                jArr = jArrCopyOf;
                                parsableByteArray2 = parsableByteArray3;
                                switch (str.hashCode()) {
                                    case -685620710:
                                        if (str.equals("{\\an1}")) {
                                            c = 0;
                                            break;
                                        } else {
                                            c = 65535;
                                            break;
                                        }
                                    case -685620679:
                                        if (str.equals("{\\an2}")) {
                                            c = 6;
                                            break;
                                        }
                                        break;
                                    case -685620648:
                                        if (str.equals("{\\an3}")) {
                                            c = 3;
                                            break;
                                        }
                                        break;
                                    case -685620617:
                                        if (str.equals("{\\an4}")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                    case -685620586:
                                        if (str.equals("{\\an5}")) {
                                            c = 7;
                                            break;
                                        }
                                        break;
                                    case -685620555:
                                        if (str.equals("{\\an6}")) {
                                            c = 4;
                                            break;
                                        }
                                        break;
                                    case -685620524:
                                        if (str.equals("{\\an7}")) {
                                            c = 2;
                                            break;
                                        }
                                        break;
                                    case -685620493:
                                        if (str.equals("{\\an8}")) {
                                            c = '\b';
                                            break;
                                        }
                                        break;
                                    case -685620462:
                                        if (str.equals("{\\an9}")) {
                                            c = 5;
                                            break;
                                        }
                                        break;
                                }
                                i2 = i6;
                                int i9 = (c == 0 || c == 1 || c == 2) ? 0 : (c == 3 || c == 4 || c == 5) ? 2 : 1;
                                switch (str.hashCode()) {
                                    case -685620710:
                                        if (str.equals("{\\an1}")) {
                                            c2 = 0;
                                            break;
                                        } else {
                                            c2 = 65535;
                                            break;
                                        }
                                    case -685620679:
                                        if (str.equals("{\\an2}")) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                    case -685620648:
                                        if (str.equals("{\\an3}")) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                    case -685620617:
                                        if (str.equals("{\\an4}")) {
                                            c2 = 6;
                                            break;
                                        }
                                        break;
                                    case -685620586:
                                        if (str.equals("{\\an5}")) {
                                            c2 = 7;
                                            break;
                                        }
                                        break;
                                    case -685620555:
                                        if (str.equals("{\\an6}")) {
                                            c2 = '\b';
                                            break;
                                        }
                                        break;
                                    case -685620524:
                                        if (str.equals("{\\an7}")) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                    case -685620493:
                                        if (str.equals("{\\an8}")) {
                                            c2 = 4;
                                            break;
                                        }
                                        break;
                                    case -685620462:
                                        if (str.equals("{\\an9}")) {
                                            c2 = 5;
                                            break;
                                        }
                                        break;
                                }
                                int i10 = (c2 == 0 || c2 == 1 || c2 == 2) ? 2 : (c2 == 3 || c2 == 4 || c2 == 5) ? 0 : 1;
                                cue = new Cue(spannedFromHtml, null, null, null, k(i10), 0, i10, k(i9), i9, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
                            }
                            arrayList.add(cue);
                            arrayList.add(Cue.j);
                            subripDecoder = this;
                            jArrCopyOf = jArr;
                            parsableByteArray3 = parsableByteArray2;
                            i4 = i2;
                            i3 = 0;
                        } else {
                            parsableByteArray = parsableByteArray3;
                            Log.w("SubripDecoder", strG.length() != 0 ? "Skipping invalid timing: ".concat(strG) : new String("Skipping invalid timing: "));
                            subripDecoder = this;
                            parsableByteArray3 = parsableByteArray;
                            i3 = 0;
                        }
                    }
                }
            }
        }
        return new SubripSubtitle((Cue[]) arrayList.toArray(new Cue[0]), Arrays.copyOf(jArrCopyOf, i4));
    }
}
