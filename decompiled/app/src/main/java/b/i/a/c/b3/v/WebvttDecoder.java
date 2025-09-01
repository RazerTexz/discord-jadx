package b.i.a.c.b3.v;

import android.text.TextUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.b3.SimpleSubtitleDecoder2;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.f3.ColorParser2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttDecoder.java */
/* renamed from: b.i.a.c.b3.v.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class WebvttDecoder extends SimpleSubtitleDecoder2 {
    public final ParsableByteArray n;
    public final WebvttCssParser o;

    public WebvttDecoder() {
        super("WebvttDecoder");
        this.n = new ParsableByteArray();
        this.o = new WebvttCssParser();
    }

    /* JADX WARN: Code restructure failed: missing block: B:210:0x0395, code lost:
    
        r0.addAll(r5);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    @Override // b.i.a.c.b3.SimpleSubtitleDecoder2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Subtitle j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        WebvttCueInfo webvttCueInfoD;
        String strSubstring;
        String str;
        WebvttCssParser webvttCssParser;
        String string;
        char c;
        int i2;
        ParsableByteArray parsableByteArray = this.n;
        parsableByteArray.a = bArr;
        parsableByteArray.c = i;
        int i3 = 0;
        parsableByteArray.f984b = 0;
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.c(this.n);
            while (!TextUtils.isEmpty(this.n.g())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                ParsableByteArray parsableByteArray2 = this.n;
                int i4 = -1;
                ?? r7 = 1;
                char c2 = 65535;
                int i5 = 0;
                while (c2 == 65535) {
                    i5 = parsableByteArray2.f984b;
                    String strG = parsableByteArray2.g();
                    c2 = strG == null ? (char) 0 : "STYLE".equals(strG) ? (char) 2 : strG.startsWith("NOTE") ? (char) 1 : (char) 3;
                }
                parsableByteArray2.E(i5);
                if (c2 == 0) {
                    return new WebvttSubtitle(arrayList2);
                }
                if (c2 == 1) {
                    while (!TextUtils.isEmpty(this.n.g())) {
                    }
                } else {
                    if (c2 == 2) {
                        if (!arrayList2.isEmpty()) {
                            throw new SubtitleDecoderException("A style block was found after the first cue.");
                        }
                        this.n.g();
                        WebvttCssParser webvttCssParser2 = this.o;
                        ParsableByteArray parsableByteArray3 = this.n;
                        webvttCssParser2.d.setLength(i3);
                        int i6 = parsableByteArray3.f984b;
                        while (!TextUtils.isEmpty(parsableByteArray3.g())) {
                        }
                        webvttCssParser2.c.C(parsableByteArray3.a, parsableByteArray3.f984b);
                        webvttCssParser2.c.E(i6);
                        ArrayList arrayList3 = new ArrayList();
                        while (true) {
                            ParsableByteArray parsableByteArray4 = webvttCssParser2.c;
                            StringBuilder sb = webvttCssParser2.d;
                            WebvttCssParser.c(parsableByteArray4);
                            if (parsableByteArray4.a() >= 5 && "::cue".equals(parsableByteArray4.q(5))) {
                                int i7 = parsableByteArray4.f984b;
                                String strB = WebvttCssParser.b(parsableByteArray4, sb);
                                if (strB != null) {
                                    if ("{".equals(strB)) {
                                        parsableByteArray4.E(i7);
                                        strSubstring = "";
                                    } else {
                                        if ("(".equals(strB)) {
                                            int i8 = parsableByteArray4.f984b;
                                            int i9 = parsableByteArray4.c;
                                            boolean z3 = false;
                                            while (i8 < i9 && !z3) {
                                                int i10 = i8 + 1;
                                                z3 = ((char) parsableByteArray4.a[i8]) == ')';
                                                i8 = i10;
                                            }
                                            strSubstring = parsableByteArray4.q((i8 - 1) - parsableByteArray4.f984b).trim();
                                        } else {
                                            strSubstring = null;
                                        }
                                        if (!")".equals(WebvttCssParser.b(parsableByteArray4, sb))) {
                                            strSubstring = null;
                                        }
                                    }
                                    if (strSubstring == null || !"{".equals(WebvttCssParser.b(webvttCssParser2.c, webvttCssParser2.d))) {
                                        break;
                                    }
                                    WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
                                    if (!"".equals(strSubstring)) {
                                        int iIndexOf = strSubstring.indexOf(91);
                                        if (iIndexOf != i4) {
                                            Matcher matcher = WebvttCssParser.a.matcher(strSubstring.substring(iIndexOf));
                                            if (matcher.matches()) {
                                                String strGroup = matcher.group((int) r7);
                                                Objects.requireNonNull(strGroup);
                                                webvttCssStyle.d = strGroup;
                                            }
                                            strSubstring = strSubstring.substring(i3, iIndexOf);
                                        }
                                        String[] strArrH = Util2.H(strSubstring, "\\.");
                                        String str2 = strArrH[i3];
                                        int iIndexOf2 = str2.indexOf(35);
                                        if (iIndexOf2 != i4) {
                                            webvttCssStyle.f889b = str2.substring(i3, iIndexOf2);
                                            webvttCssStyle.a = str2.substring(iIndexOf2 + 1);
                                        } else {
                                            webvttCssStyle.f889b = str2;
                                        }
                                        if (strArrH.length > r7) {
                                            int length = strArrH.length;
                                            AnimatableValueParser.j(r7);
                                            AnimatableValueParser.j(length <= strArrH.length);
                                            webvttCssStyle.c = new HashSet(Arrays.asList((String[]) Arrays.copyOfRange(strArrH, (int) r7, length)));
                                        }
                                    }
                                    boolean z4 = false;
                                    String str3 = null;
                                    while (!z4) {
                                        ParsableByteArray parsableByteArray5 = webvttCssParser2.c;
                                        int i11 = parsableByteArray5.f984b;
                                        String strB2 = WebvttCssParser.b(parsableByteArray5, webvttCssParser2.d);
                                        boolean z5 = strB2 == null || "}".equals(strB2);
                                        if (!z5) {
                                            webvttCssParser2.c.E(i11);
                                            ParsableByteArray parsableByteArray6 = webvttCssParser2.c;
                                            StringBuilder sb2 = webvttCssParser2.d;
                                            WebvttCssParser.c(parsableByteArray6);
                                            String strA = WebvttCssParser.a(parsableByteArray6, sb2);
                                            if (!"".equals(strA) && ":".equals(WebvttCssParser.b(parsableByteArray6, sb2))) {
                                                WebvttCssParser.c(parsableByteArray6);
                                                StringBuilder sb3 = new StringBuilder();
                                                boolean z6 = false;
                                                while (true) {
                                                    if (z6) {
                                                        str = strB2;
                                                        webvttCssParser = webvttCssParser2;
                                                        string = sb3.toString();
                                                        break;
                                                    }
                                                    str = strB2;
                                                    int i12 = parsableByteArray6.f984b;
                                                    webvttCssParser = webvttCssParser2;
                                                    String strB3 = WebvttCssParser.b(parsableByteArray6, sb2);
                                                    if (strB3 == null) {
                                                        string = null;
                                                        break;
                                                    }
                                                    if ("}".equals(strB3) || ";".equals(strB3)) {
                                                        parsableByteArray6.E(i12);
                                                        z6 = true;
                                                    } else {
                                                        sb3.append(strB3);
                                                    }
                                                    strB2 = str;
                                                    webvttCssParser2 = webvttCssParser;
                                                }
                                                if (string != null && !"".equals(string)) {
                                                    int i13 = parsableByteArray6.f984b;
                                                    String strB4 = WebvttCssParser.b(parsableByteArray6, sb2);
                                                    if (";".equals(strB4)) {
                                                        if (!ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strA)) {
                                                        }
                                                    } else if ("}".equals(strB4)) {
                                                        parsableByteArray6.E(i13);
                                                        if (!ModelAuditLogEntry.CHANGE_KEY_COLOR.equals(strA)) {
                                                            webvttCssStyle.f = ColorParser2.a(string, true);
                                                            webvttCssStyle.g = true;
                                                        } else if ("background-color".equals(strA)) {
                                                            webvttCssStyle.h = ColorParser2.a(string, true);
                                                            webvttCssStyle.i = true;
                                                        } else if ("ruby-position".equals(strA)) {
                                                            if ("over".equals(string)) {
                                                                webvttCssStyle.p = 1;
                                                            } else if ("under".equals(string)) {
                                                                webvttCssStyle.p = 2;
                                                            }
                                                        } else if ("text-combine-upright".equals(strA)) {
                                                            webvttCssStyle.q = "all".equals(string) || string.startsWith("digits");
                                                        } else if ("text-decoration".equals(strA)) {
                                                            if ("underline".equals(string)) {
                                                                webvttCssStyle.k = 1;
                                                            }
                                                        } else if ("font-family".equals(strA)) {
                                                            webvttCssStyle.e = b.i.a.f.e.o.f.u1(string);
                                                        } else if ("font-weight".equals(strA)) {
                                                            if ("bold".equals(string)) {
                                                                webvttCssStyle.l = 1;
                                                            }
                                                        } else if ("font-style".equals(strA)) {
                                                            if ("italic".equals(string)) {
                                                                webvttCssStyle.m = 1;
                                                            }
                                                        } else if ("font-size".equals(strA)) {
                                                            Matcher matcher2 = WebvttCssParser.f888b.matcher(b.i.a.f.e.o.f.u1(string));
                                                            if (matcher2.matches()) {
                                                                String strGroup2 = matcher2.group(2);
                                                                Objects.requireNonNull(strGroup2);
                                                                int iHashCode = strGroup2.hashCode();
                                                                if (iHashCode == 37) {
                                                                    if (strGroup2.equals("%")) {
                                                                        c = 0;
                                                                    }
                                                                    if (c != 0) {
                                                                    }
                                                                    String strGroup3 = matcher2.group(i2);
                                                                    Objects.requireNonNull(strGroup3);
                                                                    webvttCssStyle.o = Float.parseFloat(strGroup3);
                                                                } else if (iHashCode != 3240) {
                                                                    c = (iHashCode == 3592 && strGroup2.equals("px")) ? (char) 2 : (char) 65535;
                                                                    if (c != 0) {
                                                                        i2 = 1;
                                                                        if (c == 1) {
                                                                            webvttCssStyle.n = 2;
                                                                        } else {
                                                                            if (c != 2) {
                                                                                throw new IllegalStateException();
                                                                            }
                                                                            webvttCssStyle.n = 1;
                                                                        }
                                                                    } else {
                                                                        i2 = 1;
                                                                        webvttCssStyle.n = 3;
                                                                    }
                                                                    String strGroup32 = matcher2.group(i2);
                                                                    Objects.requireNonNull(strGroup32);
                                                                    webvttCssStyle.o = Float.parseFloat(strGroup32);
                                                                } else {
                                                                    if (strGroup2.equals("em")) {
                                                                        c = 1;
                                                                    }
                                                                    if (c != 0) {
                                                                    }
                                                                    String strGroup322 = matcher2.group(i2);
                                                                    Objects.requireNonNull(strGroup322);
                                                                    webvttCssStyle.o = Float.parseFloat(strGroup322);
                                                                }
                                                            } else {
                                                                outline.i0(string.length() + 22, "Invalid font-size: '", string, "'.", "WebvttCssParser");
                                                            }
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            } else {
                                                str = strB2;
                                                webvttCssParser = webvttCssParser2;
                                            }
                                        }
                                        str3 = str;
                                        webvttCssParser2 = webvttCssParser;
                                        z4 = z5;
                                    }
                                    WebvttCssParser webvttCssParser3 = webvttCssParser2;
                                    if ("}".equals(str3)) {
                                        arrayList3.add(webvttCssStyle);
                                    }
                                    i3 = 0;
                                    i4 = -1;
                                    r7 = 1;
                                    webvttCssParser2 = webvttCssParser3;
                                }
                            }
                        }
                    } else if (c2 == 3) {
                        ParsableByteArray parsableByteArray7 = this.n;
                        Pattern pattern = WebvttCueParser.a;
                        String strG2 = parsableByteArray7.g();
                        if (strG2 == null) {
                            webvttCueInfoD = null;
                        } else {
                            Pattern pattern2 = WebvttCueParser.a;
                            Matcher matcher3 = pattern2.matcher(strG2);
                            if (matcher3.matches()) {
                                webvttCueInfoD = WebvttCueParser.d(null, matcher3, parsableByteArray7, arrayList);
                            } else {
                                String strG3 = parsableByteArray7.g();
                                if (strG3 == null) {
                                    webvttCueInfoD = null;
                                } else {
                                    Matcher matcher4 = pattern2.matcher(strG3);
                                    if (matcher4.matches()) {
                                        webvttCueInfoD = WebvttCueParser.d(strG2.trim(), matcher4, parsableByteArray7, arrayList);
                                    }
                                }
                            }
                        }
                        if (webvttCueInfoD != null) {
                            arrayList2.add(webvttCueInfoD);
                        }
                    }
                    i3 = 0;
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }
}
