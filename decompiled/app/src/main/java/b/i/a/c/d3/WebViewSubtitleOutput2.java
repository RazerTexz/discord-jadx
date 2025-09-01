package b.i.a.c.d3;

import android.content.Context;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.SparseArray;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.q.HorizontalTextInVerticalContextSpan;
import b.i.a.c.b3.q.RubySpan;
import b.i.a.c.b3.q.TextEmphasisSpan;
import b.i.a.c.d3.SpannedToHtmlConverter;
import b.i.a.c.f3.Util2;
import b.i.b.a.Charsets;
import b.i.b.b.RegularImmutableMap;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* compiled from: WebViewSubtitleOutput.java */
/* renamed from: b.i.a.c.d3.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class WebViewSubtitleOutput2 extends FrameLayout implements SubtitleView.a {
    public final CanvasSubtitleOutput j;
    public final WebView k;
    public List<Cue> l;
    public CaptionStyleCompat m;
    public float n;
    public int o;
    public float p;

    /* compiled from: WebViewSubtitleOutput.java */
    /* renamed from: b.i.a.c.d3.r$a */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebViewSubtitleOutput2(Context context) {
        super(context, null);
        this.l = Collections.emptyList();
        this.m = CaptionStyleCompat.a;
        this.n = 0.0533f;
        this.o = 0;
        this.p = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, null);
        this.j = canvasSubtitleOutput;
        WebViewSubtitleOutput webViewSubtitleOutput = new WebViewSubtitleOutput(context, null);
        this.k = webViewSubtitleOutput;
        webViewSubtitleOutput.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(webViewSubtitleOutput);
    }

    public static int b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = a.a[alignment.ordinal()];
        return i != 1 ? i != 2 ? "center" : "end" : "start";
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.m = captionStyleCompat;
        this.n = f;
        this.o = i;
        this.p = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cue cue = list.get(i2);
            if (cue.o != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.l.isEmpty() || !arrayList2.isEmpty()) {
            this.l = arrayList2;
            e();
        }
        this.j.a(arrayList, captionStyleCompat, f, i, f2);
        invalidate();
    }

    public final String d(int i, float f) {
        float fU1 = AnimatableValueParser.U1(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fU1 == -3.4028235E38f ? "unset" : Util2.k("%.2fpx", Float.valueOf(fU1 / getContext().getResources().getDisplayMetrics().density));
    }

    /* JADX WARN: Code restructure failed: missing block: B:184:0x0462, code lost:
    
        if (((android.text.style.TypefaceSpan) r9).getFamily() != null) goto L206;
     */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() {
        char c;
        String strK;
        int iB;
        int i;
        String strK2;
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        SpannedToHtmlConverter.b bVar;
        String str11;
        String str12;
        float f;
        String str13;
        String str14;
        int i3;
        String strK3;
        String str15;
        String strK4;
        float f2;
        int i4;
        String strK5;
        Layout.Alignment alignment;
        String str16;
        WebViewSubtitleOutput2 webViewSubtitleOutput2 = this;
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[4];
        char c2 = 0;
        objArr[0] = AnimatableValueParser.f2(webViewSubtitleOutput2.m.f914b);
        int i5 = 1;
        objArr[1] = webViewSubtitleOutput2.d(webViewSubtitleOutput2.o, webViewSubtitleOutput2.n);
        float f3 = 1.2f;
        objArr[2] = Float.valueOf(1.2f);
        CaptionStyleCompat captionStyleCompat = webViewSubtitleOutput2.m;
        int i6 = captionStyleCompat.e;
        objArr[3] = i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? "unset" : Util2.k("-0.05em -0.05em 0.15em %s", AnimatableValueParser.f2(captionStyleCompat.f)) : Util2.k("0.06em 0.08em 0.15em %s", AnimatableValueParser.f2(captionStyleCompat.f)) : Util2.k("0.1em 0.12em 0.15em %s", AnimatableValueParser.f2(captionStyleCompat.f)) : Util2.k("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", AnimatableValueParser.f2(captionStyleCompat.f));
        sb.append(Util2.k("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", objArr));
        HashMap map = new HashMap();
        String str17 = "default_bg";
        String str18 = "background-color:%s;";
        map.put(AnimatableValueParser.W("default_bg"), Util2.k("background-color:%s;", AnimatableValueParser.f2(webViewSubtitleOutput2.m.c)));
        int i7 = 0;
        while (i7 < webViewSubtitleOutput2.l.size()) {
            Cue cue = webViewSubtitleOutput2.l.get(i7);
            float f4 = cue.f838s;
            float f5 = f4 != -3.4028235E38f ? f4 * 100.0f : 50.0f;
            int iB2 = b(cue.t);
            float f6 = cue.p;
            if (f6 == -3.4028235E38f) {
                c = 0;
                Object[] objArr2 = new Object[i5];
                objArr2[0] = Float.valueOf((1.0f - webViewSubtitleOutput2.p) * 100.0f);
                strK = Util2.k("%.2f%%", objArr2);
                c2 = 0;
                iB = -100;
            } else if (cue.q != i5) {
                Object[] objArr3 = new Object[i5];
                objArr3[c2] = Float.valueOf(f6 * 100.0f);
                strK = Util2.k("%.2f%%", objArr3);
                c = 0;
                iB = cue.A == i5 ? -b(cue.r) : b(cue.r);
            } else {
                if (f6 >= 0.0f) {
                    Object[] objArr4 = new Object[i5];
                    Float fValueOf = Float.valueOf(f6 * f3);
                    c = 0;
                    objArr4[0] = fValueOf;
                    strK = Util2.k("%.2fem", objArr4);
                    c2 = 0;
                } else {
                    Object[] objArr5 = new Object[i5];
                    Float fValueOf2 = Float.valueOf(((-f6) - 1.0f) * f3);
                    c = 0;
                    objArr5[0] = fValueOf2;
                    strK = Util2.k("%.2fem", objArr5);
                    c2 = 1;
                }
                iB = 0;
            }
            float f7 = cue.u;
            if (f7 != -3.4028235E38f) {
                i = iB2;
                Object[] objArr6 = new Object[i5];
                objArr6[c] = Float.valueOf(f7 * 100.0f);
                strK2 = Util2.k("%.2f%%", objArr6);
            } else {
                i = iB2;
                strK2 = "fit-content";
            }
            String strC = c(cue.m);
            int i8 = cue.A;
            String str19 = i8 != i5 ? i8 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
            String strD = webViewSubtitleOutput2.d(cue.f840y, cue.f841z);
            String strF2 = AnimatableValueParser.f2(cue.w ? cue.f839x : webViewSubtitleOutput2.m.d);
            int i9 = cue.A;
            String str20 = "right";
            String str21 = "left";
            String str22 = str17;
            if (i9 == 1) {
                if (c2 != 0) {
                }
                i2 = 2;
                str21 = "top";
                str = str20;
            } else if (i9 != 2) {
                str = c2 != 0 ? "bottom" : "top";
                i2 = 2;
            } else {
                if (c2 == 0) {
                    str20 = "left";
                }
                i2 = 2;
                str21 = "top";
                str = str20;
            }
            if (i9 == i2 || i9 == 1) {
                str2 = "height";
            } else {
                str2 = "width";
                int i10 = i;
                i = iB;
                iB = i10;
            }
            CharSequence charSequence = cue.l;
            float f8 = getContext().getResources().getDisplayMetrics().density;
            Pattern pattern = SpannedToHtmlConverter.a;
            StringBuilder sb2 = sb;
            if (charSequence == null) {
                bVar = new SpannedToHtmlConverter.b("", RegularImmutableMap.m, null);
                str3 = "";
            } else if (charSequence instanceof Spanned) {
                str3 = "";
                Spanned spanned = (Spanned) charSequence;
                HashSet hashSet = new HashSet();
                str4 = strF2;
                str5 = strD;
                BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class);
                int length = backgroundColorSpanArr.length;
                int i11 = 0;
                while (i11 < length) {
                    hashSet.add(Integer.valueOf(backgroundColorSpanArr[i11].getBackgroundColor()));
                    i11++;
                    backgroundColorSpanArr = backgroundColorSpanArr;
                }
                HashMap map2 = new HashMap();
                for (Iterator it = hashSet.iterator(); it.hasNext(); it = it) {
                    int iIntValue = ((Integer) it.next()).intValue();
                    StringBuilder sb3 = new StringBuilder(14);
                    sb3.append("bg_");
                    sb3.append(iIntValue);
                    map2.put(AnimatableValueParser.W(sb3.toString()), Util2.k(str18, AnimatableValueParser.f2(iIntValue)));
                }
                SparseArray sparseArray = new SparseArray();
                str6 = str18;
                Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
                int length2 = spans.length;
                int i12 = 0;
                while (i12 < length2) {
                    int i13 = length2;
                    Object obj = spans[i12];
                    Object[] objArr7 = spans;
                    boolean z2 = obj instanceof StrikethroughSpan;
                    if (z2) {
                        str14 = str2;
                        f = f8;
                        str13 = strK2;
                        str12 = strC;
                        str11 = str19;
                        strK3 = "<span style='text-decoration:line-through;'>";
                    } else {
                        str11 = str19;
                        if (obj instanceof ForegroundColorSpan) {
                            str12 = strC;
                            strK3 = Util2.k("<span style='color:%s;'>", AnimatableValueParser.f2(((ForegroundColorSpan) obj).getForegroundColor()));
                        } else {
                            str12 = strC;
                            if (obj instanceof BackgroundColorSpan) {
                                strK3 = Util2.k("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
                            } else if (obj instanceof HorizontalTextInVerticalContextSpan) {
                                strK3 = "<span style='text-combine-upright:all;'>";
                            } else if (obj instanceof AbsoluteSizeSpan) {
                                strK3 = Util2.k("<span style='font-size:%.2fpx;'>", Float.valueOf(((AbsoluteSizeSpan) obj).getDip() ? r6.getSize() : r6.getSize() / f8));
                            } else {
                                if (obj instanceof RelativeSizeSpan) {
                                    strK3 = Util2.k("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
                                } else if (obj instanceof TypefaceSpan) {
                                    String family = ((TypefaceSpan) obj).getFamily();
                                    strK3 = family != null ? Util2.k("<span style='font-family:\"%s\";'>", family) : null;
                                } else if (obj instanceof StyleSpan) {
                                    int style = ((StyleSpan) obj).getStyle();
                                    if (style == 1) {
                                        strK3 = "<b>";
                                    } else if (style != 2) {
                                        if (style == 3) {
                                            strK3 = "<b><i>";
                                        }
                                        str14 = str2;
                                        f = f8;
                                        str13 = strK2;
                                        strK3 = null;
                                    } else {
                                        strK3 = "<i>";
                                    }
                                } else if (obj instanceof RubySpan) {
                                    int i14 = ((RubySpan) obj).f872b;
                                    if (i14 == -1) {
                                        strK3 = "<ruby style='ruby-position:unset;'>";
                                    } else if (i14 != 1) {
                                        if (i14 == 2) {
                                            strK3 = "<ruby style='ruby-position:under;'>";
                                        }
                                        str14 = str2;
                                        f = f8;
                                        str13 = strK2;
                                        strK3 = null;
                                    } else {
                                        strK3 = "<ruby style='ruby-position:over;'>";
                                    }
                                } else if (obj instanceof UnderlineSpan) {
                                    strK3 = "<u>";
                                } else if (obj instanceof TextEmphasisSpan) {
                                    TextEmphasisSpan textEmphasisSpan = (TextEmphasisSpan) obj;
                                    int i15 = textEmphasisSpan.a;
                                    f = f8;
                                    int i16 = textEmphasisSpan.f873b;
                                    str13 = strK2;
                                    StringBuilder sb4 = new StringBuilder();
                                    str14 = str2;
                                    if (i16 != 1) {
                                        i3 = 2;
                                        if (i16 == 2) {
                                            sb4.append("open ");
                                        }
                                    } else {
                                        i3 = 2;
                                        sb4.append("filled ");
                                    }
                                    if (i15 == 0) {
                                        sb4.append("none");
                                    } else if (i15 == 1) {
                                        sb4.append("circle");
                                    } else if (i15 == i3) {
                                        sb4.append("dot");
                                    } else if (i15 != 3) {
                                        sb4.append("unset");
                                    } else {
                                        sb4.append("sesame");
                                    }
                                    strK3 = Util2.k("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", sb4.toString(), textEmphasisSpan.c != 2 ? "over right" : "under left");
                                } else {
                                    str14 = str2;
                                    f = f8;
                                    str13 = strK2;
                                    strK3 = null;
                                }
                                str14 = str2;
                                f = f8;
                                str13 = strK2;
                            }
                        }
                        str14 = str2;
                        f = f8;
                        str13 = strK2;
                    }
                    String str23 = strK3;
                    if (z2 || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof HorizontalTextInVerticalContextSpan) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof TextEmphasisSpan)) {
                        str15 = "</span>";
                    } else {
                        if (!(obj instanceof TypefaceSpan)) {
                            if (obj instanceof StyleSpan) {
                                int style2 = ((StyleSpan) obj).getStyle();
                                if (style2 == 1) {
                                    strK4 = "</b>";
                                } else if (style2 == 2) {
                                    strK4 = "</i>";
                                } else if (style2 == 3) {
                                    strK4 = "</i></b>";
                                }
                                str15 = strK4;
                            } else {
                                if (obj instanceof RubySpan) {
                                    String strA = SpannedToHtmlConverter.a(((RubySpan) obj).a);
                                    strK4 = outline.k(outline.b(strA, 16), "<rt>", strA, "</rt></ruby>");
                                } else if (obj instanceof UnderlineSpan) {
                                    strK4 = "</u>";
                                }
                                str15 = strK4;
                            }
                        }
                        strK4 = null;
                        str15 = strK4;
                    }
                    int spanStart = spanned.getSpanStart(obj);
                    int spanEnd = spanned.getSpanEnd(obj);
                    if (str23 != null) {
                        Objects.requireNonNull(str15);
                        SpannedToHtmlConverter.c cVar = new SpannedToHtmlConverter.c(spanStart, spanEnd, str23, str15, null);
                        SpannedToHtmlConverter.d dVar = (SpannedToHtmlConverter.d) sparseArray.get(spanStart);
                        if (dVar == null) {
                            dVar = new SpannedToHtmlConverter.d();
                            sparseArray.put(spanStart, dVar);
                        }
                        dVar.a.add(cVar);
                        SpannedToHtmlConverter.d dVar2 = (SpannedToHtmlConverter.d) sparseArray.get(spanEnd);
                        if (dVar2 == null) {
                            dVar2 = new SpannedToHtmlConverter.d();
                            sparseArray.put(spanEnd, dVar2);
                        }
                        dVar2.f917b.add(cVar);
                    }
                    i12++;
                    length2 = i13;
                    spans = objArr7;
                    str19 = str11;
                    strC = str12;
                    f8 = f;
                    strK2 = str13;
                    str2 = str14;
                }
                str7 = str2;
                str8 = str19;
                str9 = strK2;
                str10 = strC;
                StringBuilder sb5 = new StringBuilder(spanned.length());
                int i17 = 0;
                int i18 = 0;
                while (i17 < sparseArray.size()) {
                    int iKeyAt = sparseArray.keyAt(i17);
                    sb5.append(SpannedToHtmlConverter.a(spanned.subSequence(i18, iKeyAt)));
                    SpannedToHtmlConverter.d dVar3 = (SpannedToHtmlConverter.d) sparseArray.get(iKeyAt);
                    Collections.sort(dVar3.f917b, f.j);
                    Iterator<SpannedToHtmlConverter.c> it2 = dVar3.f917b.iterator();
                    while (it2.hasNext()) {
                        sb5.append(it2.next().d);
                    }
                    Collections.sort(dVar3.a, e.j);
                    Iterator<SpannedToHtmlConverter.c> it3 = dVar3.a.iterator();
                    while (it3.hasNext()) {
                        sb5.append(it3.next().c);
                    }
                    i17++;
                    i18 = iKeyAt;
                }
                sb5.append(SpannedToHtmlConverter.a(spanned.subSequence(i18, spanned.length())));
                bVar = new SpannedToHtmlConverter.b(sb5.toString(), map2, null);
                for (String str24 : map.keySet()) {
                    String str25 = (String) map.put(str24, (String) map.get(str24));
                    AnimatableValueParser.D(str25 == null || str25.equals(map.get(str24)));
                }
                Object[] objArr8 = new Object[14];
                objArr8[0] = Integer.valueOf(i7);
                objArr8[1] = str21;
                objArr8[2] = Float.valueOf(f5);
                objArr8[3] = str;
                objArr8[4] = strK;
                objArr8[5] = str7;
                objArr8[6] = str9;
                objArr8[7] = str10;
                objArr8[8] = str8;
                objArr8[9] = str5;
                objArr8[10] = str4;
                objArr8[11] = Integer.valueOf(iB);
                objArr8[12] = Integer.valueOf(i);
                f2 = cue.B;
                if (f2 == 0.0f) {
                    int i19 = cue.A;
                    i4 = 1;
                    strK5 = Util2.k("%s(%.2fdeg)", (i19 == 2 || i19 == 1) ? "skewY" : "skewX", Float.valueOf(f2));
                } else {
                    i4 = 1;
                    strK5 = str3;
                }
                objArr8[13] = strK5;
                sb = sb2;
                sb.append(Util2.k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr8));
                Object[] objArr9 = new Object[i4];
                objArr9[0] = str22;
                sb.append(Util2.k("<span class='%s'>", objArr9));
                alignment = cue.n;
                if (alignment == null) {
                    Object[] objArr10 = new Object[i4];
                    objArr10[0] = c(alignment);
                    sb.append(Util2.k("<span style='display:inline-block; text-align:%s;'>", objArr10));
                    sb.append(bVar.a);
                    str16 = "</span>";
                    sb.append(str16);
                } else {
                    str16 = "</span>";
                    sb.append(bVar.a);
                }
                sb.append(str16);
                sb.append("</div>");
                i7++;
                f3 = 1.2f;
                c2 = 0;
                i5 = 1;
                webViewSubtitleOutput2 = this;
                str17 = str22;
                str18 = str6;
            } else {
                str3 = "";
                bVar = new SpannedToHtmlConverter.b(SpannedToHtmlConverter.a(charSequence), RegularImmutableMap.m, null);
            }
            str7 = str2;
            str8 = str19;
            str6 = str18;
            str9 = strK2;
            str10 = strC;
            str5 = strD;
            str4 = strF2;
            while (r0.hasNext()) {
            }
            Object[] objArr82 = new Object[14];
            objArr82[0] = Integer.valueOf(i7);
            objArr82[1] = str21;
            objArr82[2] = Float.valueOf(f5);
            objArr82[3] = str;
            objArr82[4] = strK;
            objArr82[5] = str7;
            objArr82[6] = str9;
            objArr82[7] = str10;
            objArr82[8] = str8;
            objArr82[9] = str5;
            objArr82[10] = str4;
            objArr82[11] = Integer.valueOf(iB);
            objArr82[12] = Integer.valueOf(i);
            f2 = cue.B;
            if (f2 == 0.0f) {
            }
            objArr82[13] = strK5;
            sb = sb2;
            sb.append(Util2.k("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr82));
            Object[] objArr92 = new Object[i4];
            objArr92[0] = str22;
            sb.append(Util2.k("<span class='%s'>", objArr92));
            alignment = cue.n;
            if (alignment == null) {
            }
            sb.append(str16);
            sb.append("</div>");
            i7++;
            f3 = 1.2f;
            c2 = 0;
            i5 = 1;
            webViewSubtitleOutput2 = this;
            str17 = str22;
            str18 = str6;
        }
        sb.append("</div></body></html>");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("<html><head><style>");
        for (String str26 : map.keySet()) {
            sb6.append(str26);
            sb6.append("{");
            sb6.append((String) map.get(str26));
            sb6.append("}");
        }
        sb6.append("</style></head>");
        sb.insert(0, sb6.toString());
        this.k.loadData(Base64.encodeToString(sb.toString().getBytes(Charsets.c), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (!z2 || this.l.isEmpty()) {
            return;
        }
        e();
    }
}
