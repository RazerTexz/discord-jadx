package com.discord.chips_view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.f.Chip2;
import b.a.f.Chip3;
import b.a.f.ChipsEditText;
import b.a.f.ChipsVerticalLinearLayout;
import b.a.f.ChipsView2;
import b.a.f.ChipsView3;
import b.a.f.h.ViewChipDefaultBinding;
import com.discord.chips_view.ChipsView.a;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ChipsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0003*\u0004\u0018\u00010\u00022\u00020\u00042\u00020\u0005:\u0003$ \tB\u0019\b\u0016\u0012\u0006\u0010u\u001a\u00020t\u0012\u0006\u0010w\u001a\u00020v¢\u0006\u0004\bx\u0010yJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\b2\u0010\u0010\u000f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010 \u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0001¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020\b2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030&¢\u0006\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R$\u0010.\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00104R2\u0010?\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\b\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00104R\u0016\u0010C\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00104R\u0016\u0010E\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00104R\u0016\u0010G\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u00104R\u0016\u0010I\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00104R\u0016\u0010K\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u00104R\u0016\u0010M\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u00104R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR2\u0010Y\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\b\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010:\u001a\u0004\bW\u0010<\"\u0004\bX\u0010>R\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010VR\u0016\u0010^\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u00104R2\u0010c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010_\u0012\u0004\u0012\u00020\b\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010:\u001a\u0004\ba\u0010<\"\u0004\bb\u0010>R\u0016\u0010e\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010VR\u0016\u0010g\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u00104R.\u0010k\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b0h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u00104R\u0016\u0010o\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u00104R\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006z"}, d2 = {"Lcom/discord/chips_view/ChipsView;", "K", "Lcom/discord/chips_view/ChipsView$a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/widget/ScrollView;", "Lb/a/f/d$a;", "", "moveCursor", "", "c", "(Z)V", "Lb/a/f/a;", "chip", "e", "(Lb/a/f/a;)V", "rootChip", "f", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "onRequestFocusInDescendants", "(ILandroid/graphics/Rect;)Z", "", "displayName", "imageContentDescription", "key", "data", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcom/discord/chips_view/ChipsView$a;)V", "Landroid/view/inputmethod/InputConnection;", "target", "a", "(Landroid/view/inputmethod/InputConnection;)Landroid/view/inputmethod/InputConnection;", "", "pruneData", "d", "(Ljava/util/Collection;)V", "Landroid/widget/RelativeLayout;", "z", "Landroid/widget/RelativeLayout;", "mChipsContainer", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "p", "I", "mChipsColorClicked", "k", "mChipsBgResId", "Lkotlin/Function1;", ExifInterface.LONGITUDE_EAST, "Lkotlin/jvm/functions/Function1;", "getChipAddedListener", "()Lkotlin/jvm/functions/Function1;", "setChipAddedListener", "(Lkotlin/jvm/functions/Function1;)V", "chipAddedListener", "l", "mMaxHeight", "w", "mChipsHintRes", "n", "mChipHeightPx", "r", "mChipsBgColorClicked", "x", "mChipLayout", "m", "mVerticalSpacingPx", "q", "mChipsBgColor", "Lb/a/f/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lb/a/f/d;", "mEditText", "", "D", "Ljava/lang/Object;", "mCurrentEditTextSpan", "F", "getChipDeletedListener", "setChipDeletedListener", "chipDeletedListener", "", "v", "mChipsSearchTextSize", "s", "mChipsTextColor", "", "G", "getTextChangedListener", "setTextChangedListener", "textChangedListener", "y", "mDensity", "u", "mChipsSearchTextColor", "Ljava/util/LinkedHashMap;", "C", "Ljava/util/LinkedHashMap;", "mChipList", "o", "mChipsColor", "t", "mChipsTextColorClicked", "Lb/a/f/e;", "B", "Lb/a/f/e;", "mRootChipsLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "chips_view_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ChipsView<K, V extends a> extends ScrollView implements ChipsEditText.a {
    public static final /* synthetic */ int j = 0;

    /* renamed from: A, reason: from kotlin metadata */
    public final ChipsEditText mEditText;

    /* renamed from: B, reason: from kotlin metadata */
    public ChipsVerticalLinearLayout mRootChipsLayout;

    /* renamed from: C, reason: from kotlin metadata */
    public final LinkedHashMap<K, Chip2<K, V>> mChipList;

    /* renamed from: D, reason: from kotlin metadata */
    public Object mCurrentEditTextSpan;

    /* renamed from: E, reason: from kotlin metadata */
    public Function1<? super V, Unit> chipAddedListener;

    /* renamed from: F, reason: from kotlin metadata */
    public Function1<? super V, Unit> chipDeletedListener;

    /* renamed from: G, reason: from kotlin metadata */
    public Function1<? super CharSequence, Unit> textChangedListener;

    /* renamed from: k, reason: from kotlin metadata */
    public int mChipsBgResId;

    /* renamed from: l, reason: from kotlin metadata */
    public int mMaxHeight;

    /* renamed from: m, reason: from kotlin metadata */
    public int mVerticalSpacingPx;

    /* renamed from: n, reason: from kotlin metadata */
    public int mChipHeightPx;

    /* renamed from: o, reason: from kotlin metadata */
    public int mChipsColor;

    /* renamed from: p, reason: from kotlin metadata */
    public int mChipsColorClicked;

    /* renamed from: q, reason: from kotlin metadata */
    public int mChipsBgColor;

    /* renamed from: r, reason: from kotlin metadata */
    public int mChipsBgColorClicked;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public int mChipsTextColor;

    /* renamed from: t, reason: from kotlin metadata */
    public int mChipsTextColorClicked;

    /* renamed from: u, reason: from kotlin metadata */
    public int mChipsSearchTextColor;

    /* renamed from: v, reason: from kotlin metadata */
    public float mChipsSearchTextSize;

    /* renamed from: w, reason: from kotlin metadata */
    public int mChipsHintRes;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public int mChipLayout;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public float mDensity;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final RelativeLayout mChipsContainer;

    /* compiled from: ChipsView.kt */
    public interface a {
        String getDisplayString();
    }

    /* compiled from: ChipsView.kt */
    public final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "s");
            Function1<CharSequence, Unit> textChangedListener = ChipsView.this.getTextChangedListener();
            if (textChangedListener != null) {
                textChangedListener.invoke(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics3.checkNotNullParameter(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics3.checkNotNullParameter(charSequence, "s");
        }
    }

    /* compiled from: ChipsView.kt */
    public final class c extends InputConnectionWrapper {
        public c(InputConnection inputConnection) {
            super(inputConnection, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence charSequence, int i) {
            Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            return super.commitText(charSequence, i);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            return (ChipsView.this.mEditText.length() == 0 && i == 1 && i2 == 0) ? sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67)) : super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(keyEvent, "event");
            if (ChipsView.this.mEditText.length() != 0 || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                return super.sendKeyEvent(keyEvent);
            }
            ChipsView chipsView = ChipsView.this;
            if (chipsView.mChipList.size() > 0) {
                try {
                    Iterator<Map.Entry<K, Chip2<K, V>>> it = chipsView.mChipList.entrySet().iterator();
                    Chip2<K, V> value = null;
                    while (it.hasNext()) {
                        value = it.next().getValue();
                    }
                    if (value != null) {
                        Intrinsics3.checkNotNullParameter(value, "chip");
                        chipsView.f(value);
                        if (value.k) {
                            chipsView.e(value);
                        } else {
                            value.k = true;
                            chipsView.c(false);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    Log.e("ChipsView", "Out of bounds", e);
                }
            }
            return true;
        }
    }

    /* compiled from: ChipsView.kt */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ChipsView.this.fullScroll(130);
        }
    }

    /* compiled from: ChipsView.kt */
    public static final class e implements Runnable {
        public final /* synthetic */ boolean k;

        public e(boolean z2) {
            this.k = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ChipsView chipsView = ChipsView.this;
            boolean z2 = this.k;
            int i = ChipsView.j;
            chipsView.c(z2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.mChipList = new LinkedHashMap<>();
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.mDensity = resources.getDisplayMetrics().density;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.mChipsContainer = relativeLayout;
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        linearLayout.setFocusable(true);
        linearLayout.setFocusableInTouchMode(true);
        relativeLayout.addView(linearLayout);
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        ChipsEditText chipsEditText = new ChipsEditText(context2, this);
        this.mEditText = chipsEditText;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.c.ChipsView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…tyleable.ChipsView, 0, 0)");
        try {
            this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.ChipsView_cv_max_height, -1);
            this.mVerticalSpacingPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.ChipsView_cv_vertical_spacing, (int) (1 * this.mDensity));
            this.mChipHeightPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.ChipsView_cv_height, (int) (24 * this.mDensity));
            this.mChipsColor = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_color, ContextCompat.getColor(context, android.R.color.darker_gray));
            this.mChipsColorClicked = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_color_clicked, ContextCompat.getColor(context, android.R.color.white));
            this.mChipsBgColor = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_bg_color, ContextCompat.getColor(context, android.R.color.white));
            this.mChipsBgResId = typedArrayObtainStyledAttributes.getResourceId(R.c.ChipsView_cv_chip_bg_res, 0);
            this.mChipsBgColorClicked = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_bg_color_clicked, ContextCompat.getColor(context, android.R.color.holo_blue_dark));
            this.mChipsTextColor = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsTextColorClicked = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_text_color_clicked, -1);
            this.mChipsHintRes = typedArrayObtainStyledAttributes.getResourceId(R.c.ChipsView_cv_hint, 0);
            typedArrayObtainStyledAttributes.getResourceId(R.c.ChipsView_cv_icon_placeholder, 0);
            this.mChipsSearchTextColor = typedArrayObtainStyledAttributes.getColor(R.c.ChipsView_cv_search_text_color, ViewCompat.MEASURED_STATE_MASK);
            this.mChipsSearchTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.c.ChipsView_cv_search_text_size, 49);
            this.mChipLayout = typedArrayObtainStyledAttributes.getResourceId(R.c.ChipsView_cv_chip_layout, R.b.view_chip_default);
            typedArrayObtainStyledAttributes.recycle();
            int i = this.mChipHeightPx + this.mVerticalSpacingPx;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            float f = 4;
            layoutParams.leftMargin = (int) (this.mDensity * f);
            layoutParams.addRule(12, -1);
            chipsEditText.setLayoutParams(layoutParams);
            chipsEditText.setPadding(0, 0, 0, this.mVerticalSpacingPx);
            chipsEditText.setBackgroundColor(Color.argb(0, 0, 0, 0));
            chipsEditText.setImeOptions(268435456);
            chipsEditText.setInputType(1);
            chipsEditText.setTextColor(this.mChipsSearchTextColor);
            chipsEditText.setTextSize(0, this.mChipsSearchTextSize);
            relativeLayout.addView(chipsEditText);
            Context context3 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context3, "context");
            ChipsVerticalLinearLayout chipsVerticalLinearLayout = new ChipsVerticalLinearLayout(context3, i);
            chipsVerticalLinearLayout.setOrientation(1);
            chipsVerticalLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            chipsVerticalLinearLayout.setPadding(0, (int) (f * this.mDensity), 0, 0);
            this.mRootChipsLayout = chipsVerticalLinearLayout;
            relativeLayout.addView(chipsVerticalLinearLayout);
            relativeLayout.setOnClickListener(new ChipsView3(this));
            chipsEditText.addTextChangedListener(new b());
            chipsEditText.setOnFocusChangeListener(new ChipsView2(this));
            c(false);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // b.a.f.ChipsEditText.a
    public InputConnection a(InputConnection target) {
        return new c(target);
    }

    public final void b(String displayName, String imageContentDescription, K key, V data) {
        if (this.mChipList.containsKey(key)) {
            return;
        }
        this.mEditText.setText("");
        Chip2<K, V> chip2 = new Chip2<>(displayName, imageContentDescription, key, data, new Chip2.a(this.mChipsBgColorClicked, this.mDensity, this.mChipsBgResId, this.mChipsBgColor, this.mChipsTextColor, this.mChipsTextColorClicked, this.mChipsColorClicked, this.mChipsColor, this.mChipHeightPx, this.mChipLayout), this);
        Editable text = this.mEditText.getText();
        if (text != null) {
            Object obj = this.mCurrentEditTextSpan;
            if (obj != null) {
                text.removeSpan(obj);
            }
            text.setSpan(this.mCurrentEditTextSpan, 0, 0, 17);
        }
        this.mEditText.setText(text);
        this.mChipList.put(key, chip2);
        Function1<? super V, Unit> function1 = this.chipAddedListener;
        if (function1 != null) {
            function1.invoke((Object) chip2.o);
        }
        c(true);
        post(new d());
    }

    public final void c(boolean moveCursor) {
        TextView textView;
        RelativeLayout relativeLayout;
        Drawable background;
        TextView textView2;
        RelativeLayout relativeLayout2;
        Drawable background2;
        TextView textView3;
        TextView textView4;
        ImageView imageView;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        ChipsVerticalLinearLayout chipsVerticalLinearLayout = this.mRootChipsLayout;
        ChipsVerticalLinearLayout.a aVar = null;
        if (chipsVerticalLinearLayout != null) {
            Collection<Chip2<K, V>> collectionValues = this.mChipList.values();
            Intrinsics3.checkNotNullExpressionValue(collectionValues, "mChipList.values");
            Intrinsics3.checkNotNullParameter(collectionValues, "chips");
            Iterator<LinearLayout> it = chipsVerticalLinearLayout.j.iterator();
            while (it.hasNext()) {
                it.next().removeAllViews();
            }
            chipsVerticalLinearLayout.j.clear();
            chipsVerticalLinearLayout.removeAllViews();
            int width = chipsVerticalLinearLayout.getWidth();
            if (width != 0) {
                LinearLayout linearLayoutA = chipsVerticalLinearLayout.a();
                int i = 0;
                int i2 = 0;
                for (Chip2<K, V> chip2 : collectionValues) {
                    if (chip2.j == null) {
                        View viewInflate = LayoutInflater.from(chip2.q.getContext()).inflate(R.b.view_chip_default, (ViewGroup) null, false);
                        int i3 = R.a.chip_image;
                        ImageView imageView2 = (ImageView) viewInflate.findViewById(i3);
                        if (imageView2 != null) {
                            i3 = R.a.chip_text;
                            TextView textView5 = (TextView) viewInflate.findViewById(i3);
                            if (textView5 != null) {
                                chip2.j = new ViewChipDefaultBinding((RelativeLayout) viewInflate, imageView2, textView5);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, chip2.p.f);
                                ViewChipDefaultBinding viewChipDefaultBinding = chip2.j;
                                if (viewChipDefaultBinding != null && (relativeLayout4 = viewChipDefaultBinding.a) != null) {
                                    relativeLayout4.setLayoutParams(layoutParams);
                                }
                                ViewChipDefaultBinding viewChipDefaultBinding2 = chip2.j;
                                if (viewChipDefaultBinding2 != null && (relativeLayout3 = viewChipDefaultBinding2.a) != null) {
                                    relativeLayout3.setBackgroundResource(chip2.p.f66b);
                                    relativeLayout3.post(new Chip3(relativeLayout3, chip2));
                                    relativeLayout3.setOnClickListener(chip2);
                                }
                                ViewChipDefaultBinding viewChipDefaultBinding3 = chip2.j;
                                if (viewChipDefaultBinding3 != null && (imageView = viewChipDefaultBinding3.f67b) != null) {
                                    imageView.setOnClickListener(chip2);
                                    Intrinsics3.checkNotNullExpressionValue(imageView, "it");
                                    imageView.setContentDescription(chip2.m);
                                }
                                ViewChipDefaultBinding viewChipDefaultBinding4 = chip2.j;
                                if (viewChipDefaultBinding4 != null && (textView4 = viewChipDefaultBinding4.c) != null) {
                                    textView4.setTextColor(chip2.p.d);
                                }
                            }
                        }
                        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i3)));
                    }
                    ViewChipDefaultBinding viewChipDefaultBinding5 = chip2.j;
                    if (viewChipDefaultBinding5 != null && (textView3 = viewChipDefaultBinding5.c) != null) {
                        textView3.setText(chip2.l);
                    }
                    if (chip2.k) {
                        ViewChipDefaultBinding viewChipDefaultBinding6 = chip2.j;
                        if (viewChipDefaultBinding6 != null && (relativeLayout2 = viewChipDefaultBinding6.a) != null && (background2 = relativeLayout2.getBackground()) != null) {
                            background2.setColorFilter(chip2.p.a, PorterDuff.Mode.SRC_ATOP);
                        }
                        ViewChipDefaultBinding viewChipDefaultBinding7 = chip2.j;
                        if (viewChipDefaultBinding7 != null && (textView2 = viewChipDefaultBinding7.c) != null) {
                            textView2.setTextColor(chip2.p.e);
                        }
                    } else {
                        ViewChipDefaultBinding viewChipDefaultBinding8 = chip2.j;
                        if (viewChipDefaultBinding8 != null && (relativeLayout = viewChipDefaultBinding8.a) != null && (background = relativeLayout.getBackground()) != null) {
                            background.setColorFilter(chip2.p.c, PorterDuff.Mode.SRC_ATOP);
                        }
                        ViewChipDefaultBinding viewChipDefaultBinding9 = chip2.j;
                        if (viewChipDefaultBinding9 != null && (textView = viewChipDefaultBinding9.c) != null) {
                            textView.setTextColor(chip2.p.d);
                        }
                    }
                    ViewChipDefaultBinding viewChipDefaultBinding10 = chip2.j;
                    RelativeLayout relativeLayout5 = viewChipDefaultBinding10 != null ? viewChipDefaultBinding10.a : null;
                    Intrinsics3.checkNotNull(relativeLayout5);
                    relativeLayout5.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (relativeLayout5.getMeasuredWidth() + i > width) {
                        i2++;
                        linearLayoutA = chipsVerticalLinearLayout.a();
                        i = 0;
                    }
                    int measuredWidth = relativeLayout5.getMeasuredWidth();
                    ViewGroup.LayoutParams layoutParams2 = relativeLayout5.getLayoutParams();
                    Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    i += measuredWidth + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    linearLayoutA.addView(relativeLayout5);
                }
                if (width - i < width * 0.15f) {
                    i2++;
                    chipsVerticalLinearLayout.a();
                    i = 0;
                }
                aVar = new ChipsVerticalLinearLayout.a(i2, i);
            }
        }
        if (this.mChipList.isEmpty()) {
            int i4 = this.mChipsHintRes;
            if (i4 != 0) {
                this.mEditText.setHint(i4);
            }
        } else {
            this.mEditText.setHint("");
        }
        if (aVar == null) {
            post(new e(moveCursor));
            return;
        }
        int i5 = aVar.a;
        Editable text = this.mEditText.getText();
        Object obj = this.mCurrentEditTextSpan;
        if (obj != null && text != null) {
            text.removeSpan(obj);
        }
        LeadingMarginSpan.Standard standard = new LeadingMarginSpan.Standard(i5, 0);
        this.mCurrentEditTextSpan = standard;
        if (text != null) {
            text.setSpan(standard, 0, 0, 17);
        }
        this.mEditText.setText(text);
        if (moveCursor) {
            ChipsEditText chipsEditText = this.mEditText;
            chipsEditText.setSelection(chipsEditText.length());
        }
    }

    public final void d(Collection<?> pruneData) {
        Intrinsics3.checkNotNullParameter(pruneData, "pruneData");
        Iterator<Map.Entry<K, Chip2<K, V>>> it = this.mChipList.entrySet().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (!_Collections.contains(pruneData, it.next().getKey())) {
                it.remove();
                z2 = true;
            }
        }
        if (z2) {
            c(true);
        }
    }

    public final void e(Chip2<K, V> chip) {
        this.mChipList.remove(chip.n);
        Function1<? super V, Unit> function1 = this.chipDeletedListener;
        if (function1 != null) {
            function1.invoke((Object) chip.o);
        }
        c(true);
    }

    public final void f(Chip2<?, ?> rootChip) {
        for (Chip2<K, V> chip2 : this.mChipList.values()) {
            if (chip2 != rootChip) {
                chip2.k = false;
            }
        }
        c(false);
    }

    public final Function1<V, Unit> getChipAddedListener() {
        return this.chipAddedListener;
    }

    public final Function1<V, Unit> getChipDeletedListener() {
        return this.chipDeletedListener;
    }

    public final String getText() {
        return String.valueOf(this.mEditText.getText());
    }

    public final Function1<CharSequence, Unit> getTextChangedListener() {
        return this.textChangedListener;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, Integer.MIN_VALUE));
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        return true;
    }

    public final void setChipAddedListener(Function1<? super V, Unit> function1) {
        this.chipAddedListener = function1;
    }

    public final void setChipDeletedListener(Function1<? super V, Unit> function1) {
        this.chipDeletedListener = function1;
    }

    public final void setText(String str) {
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.mEditText.setText(str);
    }

    public final void setTextChangedListener(Function1<? super CharSequence, Unit> function1) {
        this.textChangedListener = function1;
    }
}
