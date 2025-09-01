package b.i.a.c.d3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Cue;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: CanvasSubtitleOutput.java */
/* renamed from: b.i.a.c.d3.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class CanvasSubtitleOutput extends View implements SubtitleView.a {
    public final List<SubtitlePainter> j;
    public List<Cue> k;
    public int l;
    public float m;
    public CaptionStyleCompat n;
    public float o;

    public CanvasSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new ArrayList();
        this.k = Collections.emptyList();
        this.l = 0;
        this.m = 0.0533f;
        this.n = CaptionStyleCompat.a;
        this.o = 0.08f;
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.k = list;
        this.n = captionStyleCompat;
        this.m = f;
        this.l = i;
        this.o = f2;
        while (this.j.size() < list.size()) {
            this.j.add(new SubtitlePainter(getContext()));
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04a9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        float f;
        int i8;
        float f2;
        int i9;
        float f3;
        Canvas canvas2;
        boolean z3;
        int i10;
        int iMax;
        int iMin;
        int iRound;
        int i11;
        int i12;
        int i13;
        CanvasSubtitleOutput canvasSubtitleOutput = this;
        Canvas canvas3 = canvas;
        List<Cue> list = canvasSubtitleOutput.k;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i14 = paddingBottom - paddingTop;
        float fU1 = AnimatableValueParser.U1(canvasSubtitleOutput.l, canvasSubtitleOutput.m, height, i14);
        if (fU1 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i15 = 0;
        while (i15 < size) {
            Cue cueA = list.get(i15);
            if (cueA.A != Integer.MIN_VALUE) {
                Cue.b bVarA = cueA.a();
                bVarA.h = -3.4028235E38f;
                bVarA.i = Integer.MIN_VALUE;
                bVarA.c = null;
                if (cueA.q == 0) {
                    bVarA.e = 1.0f - cueA.p;
                    bVarA.f = 0;
                } else {
                    bVarA.e = (-cueA.p) - 1.0f;
                    bVarA.f = 1;
                }
                int i16 = cueA.r;
                if (i16 == 0) {
                    bVarA.g = 2;
                } else if (i16 == 2) {
                    bVarA.g = 0;
                }
                cueA = bVarA.a();
            }
            float fU12 = AnimatableValueParser.U1(cueA.f840y, cueA.f841z, height, i14);
            SubtitlePainter subtitlePainter = canvasSubtitleOutput.j.get(i15);
            CaptionStyleCompat captionStyleCompat = canvasSubtitleOutput.n;
            List<Cue> list2 = list;
            float f4 = canvasSubtitleOutput.o;
            Objects.requireNonNull(subtitlePainter);
            boolean z4 = cueA.o == null;
            int i17 = height;
            if (!z4) {
                i = i14;
                i2 = ViewCompat.MEASURED_STATE_MASK;
            } else if (TextUtils.isEmpty(cueA.l)) {
                canvas2 = canvas3;
                i4 = paddingLeft;
                i5 = paddingTop;
                i6 = width;
                i7 = paddingBottom;
                i = i14;
                f = fU1;
                i3 = size;
                i8 = i15;
                i15 = i8 + 1;
                canvas3 = canvas2;
                list = list2;
                i14 = i;
                height = i17;
                size = i3;
                paddingLeft = i4;
                paddingTop = i5;
                width = i6;
                paddingBottom = i7;
                fU1 = f;
                canvasSubtitleOutput = this;
            } else {
                i2 = cueA.w ? cueA.f839x : captionStyleCompat.d;
                i = i14;
            }
            CharSequence charSequence = subtitlePainter.i;
            i3 = size;
            CharSequence charSequence2 = cueA.l;
            if ((charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2))) && Util2.a(subtitlePainter.j, cueA.m) && subtitlePainter.k == cueA.o && subtitlePainter.l == cueA.p && subtitlePainter.m == cueA.q && Util2.a(Integer.valueOf(subtitlePainter.n), Integer.valueOf(cueA.r)) && subtitlePainter.o == cueA.f838s && Util2.a(Integer.valueOf(subtitlePainter.p), Integer.valueOf(cueA.t)) && subtitlePainter.q == cueA.u && subtitlePainter.r == cueA.v && subtitlePainter.f919s == captionStyleCompat.f914b && subtitlePainter.t == captionStyleCompat.c && subtitlePainter.u == i2 && subtitlePainter.w == captionStyleCompat.e && subtitlePainter.v == captionStyleCompat.f && Util2.a(subtitlePainter.f.getTypeface(), captionStyleCompat.g) && subtitlePainter.f920x == fU1 && subtitlePainter.f921y == fU12 && subtitlePainter.f922z == f4 && subtitlePainter.A == paddingLeft && subtitlePainter.B == paddingTop && subtitlePainter.C == width && subtitlePainter.D == paddingBottom) {
                subtitlePainter.a(canvas3, z4);
                canvas2 = canvas3;
                i4 = paddingLeft;
                i5 = paddingTop;
                i6 = width;
                i7 = paddingBottom;
                f = fU1;
                i8 = i15;
                i15 = i8 + 1;
                canvas3 = canvas2;
                list = list2;
                i14 = i;
                height = i17;
                size = i3;
                paddingLeft = i4;
                paddingTop = i5;
                width = i6;
                paddingBottom = i7;
                fU1 = f;
                canvasSubtitleOutput = this;
            } else {
                subtitlePainter.i = cueA.l;
                subtitlePainter.j = cueA.m;
                subtitlePainter.k = cueA.o;
                subtitlePainter.l = cueA.p;
                subtitlePainter.m = cueA.q;
                subtitlePainter.n = cueA.r;
                subtitlePainter.o = cueA.f838s;
                subtitlePainter.p = cueA.t;
                subtitlePainter.q = cueA.u;
                subtitlePainter.r = cueA.v;
                subtitlePainter.f919s = captionStyleCompat.f914b;
                subtitlePainter.t = captionStyleCompat.c;
                subtitlePainter.u = i2;
                subtitlePainter.w = captionStyleCompat.e;
                subtitlePainter.v = captionStyleCompat.f;
                subtitlePainter.f.setTypeface(captionStyleCompat.g);
                subtitlePainter.f920x = fU1;
                subtitlePainter.f921y = fU12;
                subtitlePainter.f922z = f4;
                subtitlePainter.A = paddingLeft;
                subtitlePainter.B = paddingTop;
                subtitlePainter.C = width;
                subtitlePainter.D = paddingBottom;
                if (z4) {
                    Objects.requireNonNull(subtitlePainter.i);
                    CharSequence charSequence3 = subtitlePainter.i;
                    SpannableStringBuilder spannableStringBuilder = charSequence3 instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence3 : new SpannableStringBuilder(subtitlePainter.i);
                    int i18 = subtitlePainter.C - subtitlePainter.A;
                    int i19 = subtitlePainter.D - subtitlePainter.B;
                    subtitlePainter.f.setTextSize(subtitlePainter.f920x);
                    int i20 = (int) ((subtitlePainter.f920x * 0.125f) + 0.5f);
                    int i21 = i20 * 2;
                    int i22 = i18 - i21;
                    float f5 = subtitlePainter.q;
                    if (f5 != -3.4028235E38f) {
                        i22 = (int) (i22 * f5);
                    }
                    if (i22 <= 0) {
                        Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
                        i4 = paddingLeft;
                        i5 = paddingTop;
                        i6 = width;
                        i7 = paddingBottom;
                        f = fU1;
                        i8 = i15;
                        Canvas canvas4 = canvas3;
                        z3 = z4;
                        canvas2 = canvas4;
                    } else {
                        i4 = paddingLeft;
                        i5 = paddingTop;
                        if (subtitlePainter.f921y > 0.0f) {
                            i6 = width;
                            i7 = paddingBottom;
                            i10 = 0;
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) subtitlePainter.f921y), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                        } else {
                            i6 = width;
                            i7 = paddingBottom;
                            i10 = 0;
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                        if (subtitlePainter.w == 1) {
                            ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannableStringBuilder2.getSpans(i10, spannableStringBuilder2.length(), ForegroundColorSpan.class);
                            int i23 = 0;
                            for (int length = foregroundColorSpanArr.length; i23 < length; length = length) {
                                spannableStringBuilder2.removeSpan(foregroundColorSpanArr[i23]);
                                i23++;
                            }
                        }
                        if (Color.alpha(subtitlePainter.t) > 0) {
                            int i24 = subtitlePainter.w;
                            if (i24 == 0 || i24 == 2) {
                                f = fU1;
                                spannableStringBuilder.setSpan(new BackgroundColorSpan(subtitlePainter.t), 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            } else {
                                f = fU1;
                                spannableStringBuilder2.setSpan(new BackgroundColorSpan(subtitlePainter.t), 0, spannableStringBuilder2.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
                            }
                        } else {
                            f = fU1;
                        }
                        Layout.Alignment alignment = subtitlePainter.j;
                        if (alignment == null) {
                            alignment = Layout.Alignment.ALIGN_CENTER;
                        }
                        i8 = i15;
                        StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, subtitlePainter.f, i22, alignment, subtitlePainter.d, subtitlePainter.e, true);
                        subtitlePainter.E = staticLayout;
                        int height2 = staticLayout.getHeight();
                        int lineCount = subtitlePainter.E.getLineCount();
                        int i25 = 0;
                        int iMax2 = 0;
                        while (i25 < lineCount) {
                            iMax2 = Math.max((int) Math.ceil(subtitlePainter.E.getLineWidth(i25)), iMax2);
                            i25++;
                            lineCount = lineCount;
                            z4 = z4;
                        }
                        z2 = z4;
                        if (subtitlePainter.q == -3.4028235E38f || iMax2 >= i22) {
                            i22 = iMax2;
                        }
                        int i26 = i22 + i21;
                        float f6 = subtitlePainter.o;
                        if (f6 != -3.4028235E38f) {
                            int iRound2 = Math.round(i18 * f6);
                            int i27 = subtitlePainter.A;
                            int i28 = iRound2 + i27;
                            int i29 = subtitlePainter.p;
                            if (i29 == 1) {
                                i28 = ((i28 * 2) - i26) / 2;
                            } else if (i29 == 2) {
                                i28 -= i26;
                            }
                            iMax = Math.max(i28, i27);
                            iMin = Math.min(i26 + iMax, subtitlePainter.C);
                        } else {
                            iMax = subtitlePainter.A + ((i18 - i26) / 2);
                            iMin = iMax + i26;
                        }
                        int i30 = iMin - iMax;
                        if (i30 <= 0) {
                            Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
                            canvas2 = canvas;
                            z3 = z2;
                        } else {
                            float f7 = subtitlePainter.l;
                            if (f7 != -3.4028235E38f) {
                                if (subtitlePainter.m == 0) {
                                    iRound = Math.round(i19 * f7) + subtitlePainter.B;
                                    int i31 = subtitlePainter.n;
                                    if (i31 == 2) {
                                        iRound -= height2;
                                        i12 = iRound + height2;
                                        i13 = subtitlePainter.D;
                                        if (i12 <= i13) {
                                            iRound = i13 - height2;
                                        } else {
                                            i11 = subtitlePainter.B;
                                            if (iRound >= i11) {
                                            }
                                            Layout.Alignment alignment2 = alignment;
                                            subtitlePainter.E = new StaticLayout(spannableStringBuilder, subtitlePainter.f, i30, alignment2, subtitlePainter.d, subtitlePainter.e, true);
                                            subtitlePainter.F = new StaticLayout(spannableStringBuilder2, subtitlePainter.f, i30, alignment2, subtitlePainter.d, subtitlePainter.e, true);
                                            subtitlePainter.G = iMax;
                                            subtitlePainter.H = i11;
                                            subtitlePainter.I = i20;
                                        }
                                    } else {
                                        if (i31 == 1) {
                                            iRound = ((iRound * 2) - height2) / 2;
                                        }
                                        i12 = iRound + height2;
                                        i13 = subtitlePainter.D;
                                        if (i12 <= i13) {
                                        }
                                    }
                                } else {
                                    int lineBottom = subtitlePainter.E.getLineBottom(0) - subtitlePainter.E.getLineTop(0);
                                    float f8 = subtitlePainter.l;
                                    if (f8 >= 0.0f) {
                                        iRound = Math.round(f8 * lineBottom) + subtitlePainter.B;
                                        i12 = iRound + height2;
                                        i13 = subtitlePainter.D;
                                        if (i12 <= i13) {
                                        }
                                    } else {
                                        iRound = Math.round((f8 + 1.0f) * lineBottom) + subtitlePainter.D;
                                        iRound -= height2;
                                        i12 = iRound + height2;
                                        i13 = subtitlePainter.D;
                                        if (i12 <= i13) {
                                        }
                                    }
                                }
                                i15 = i8 + 1;
                                canvas3 = canvas2;
                                list = list2;
                                i14 = i;
                                height = i17;
                                size = i3;
                                paddingLeft = i4;
                                paddingTop = i5;
                                width = i6;
                                paddingBottom = i7;
                                fU1 = f;
                                canvasSubtitleOutput = this;
                            } else {
                                iRound = (subtitlePainter.D - height2) - ((int) (i19 * subtitlePainter.f922z));
                            }
                            i11 = iRound;
                            Layout.Alignment alignment22 = alignment;
                            subtitlePainter.E = new StaticLayout(spannableStringBuilder, subtitlePainter.f, i30, alignment22, subtitlePainter.d, subtitlePainter.e, true);
                            subtitlePainter.F = new StaticLayout(spannableStringBuilder2, subtitlePainter.f, i30, alignment22, subtitlePainter.d, subtitlePainter.e, true);
                            subtitlePainter.G = iMax;
                            subtitlePainter.H = i11;
                            subtitlePainter.I = i20;
                        }
                    }
                    subtitlePainter.a(canvas2, z3);
                    i15 = i8 + 1;
                    canvas3 = canvas2;
                    list = list2;
                    i14 = i;
                    height = i17;
                    size = i3;
                    paddingLeft = i4;
                    paddingTop = i5;
                    width = i6;
                    paddingBottom = i7;
                    fU1 = f;
                    canvasSubtitleOutput = this;
                } else {
                    z2 = z4;
                    i4 = paddingLeft;
                    i5 = paddingTop;
                    i6 = width;
                    i7 = paddingBottom;
                    f = fU1;
                    i8 = i15;
                    Objects.requireNonNull(subtitlePainter.k);
                    Bitmap bitmap = subtitlePainter.k;
                    int i32 = subtitlePainter.C;
                    int i33 = subtitlePainter.A;
                    int i34 = subtitlePainter.D;
                    int i35 = subtitlePainter.B;
                    float f9 = i32 - i33;
                    float f10 = (subtitlePainter.o * f9) + i33;
                    float f11 = i34 - i35;
                    float f12 = (subtitlePainter.l * f11) + i35;
                    int iRound3 = Math.round(f9 * subtitlePainter.q);
                    float f13 = subtitlePainter.r;
                    int iRound4 = f13 != -3.4028235E38f ? Math.round(f11 * f13) : Math.round((bitmap.getHeight() / bitmap.getWidth()) * iRound3);
                    int i36 = subtitlePainter.p;
                    if (i36 == 2) {
                        f2 = iRound3;
                    } else {
                        if (i36 == 1) {
                            f2 = iRound3 / 2;
                        }
                        int iRound5 = Math.round(f10);
                        i9 = subtitlePainter.n;
                        if (i9 != 2) {
                            f3 = iRound4;
                        } else {
                            if (i9 == 1) {
                                f3 = iRound4 / 2;
                            }
                            int iRound6 = Math.round(f12);
                            subtitlePainter.J = new Rect(iRound5, iRound6, iRound3 + iRound5, iRound4 + iRound6);
                        }
                        f12 -= f3;
                        int iRound62 = Math.round(f12);
                        subtitlePainter.J = new Rect(iRound5, iRound62, iRound3 + iRound5, iRound4 + iRound62);
                    }
                    f10 -= f2;
                    int iRound52 = Math.round(f10);
                    i9 = subtitlePainter.n;
                    if (i9 != 2) {
                    }
                    f12 -= f3;
                    int iRound622 = Math.round(f12);
                    subtitlePainter.J = new Rect(iRound52, iRound622, iRound3 + iRound52, iRound4 + iRound622);
                }
                canvas2 = canvas;
                z3 = z2;
                subtitlePainter.a(canvas2, z3);
                i15 = i8 + 1;
                canvas3 = canvas2;
                list = list2;
                i14 = i;
                height = i17;
                size = i3;
                paddingLeft = i4;
                paddingTop = i5;
                width = i6;
                paddingBottom = i7;
                fU1 = f;
                canvasSubtitleOutput = this;
            }
        }
    }
}
