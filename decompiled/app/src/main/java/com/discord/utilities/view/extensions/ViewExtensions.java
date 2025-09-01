package com.discord.utilities.view.extensions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleableRes;
import androidx.core.app.NotificationCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.i18n.RenderContext;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions3;
import com.discord.utilities.view.text.TextWatcher4;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.SpreadBuilder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* compiled from: ViewExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a%\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a[\u0010\u0014\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aE\u0010\u0016\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\n2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0006*\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a+\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00060\u001a¢\u0006\u0004\b\u001d\u0010\u001e\u001a+\u0010 \u001a\u00020\u0006*\u00020\u00022\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00060\u001a¢\u0006\u0004\b \u0010\u001e\u001a7\u0010#\u001a\u00020\u0006*\u00020\u00022$\u0010\"\u001a \u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010'\u001a\u00020&*\u00020%¢\u0006\u0004\b'\u0010(\u001a\u0013\u0010)\u001a\u0004\u0018\u00010\u0006*\u00020%¢\u0006\u0004\b)\u0010*\u001a\u0019\u0010,\u001a\u00020\u0006*\u00020%2\u0006\u0010+\u001a\u00020\u001b¢\u0006\u0004\b,\u0010-\u001a\u0019\u0010.\u001a\u00020\u0006*\u00020%2\u0006\u0010+\u001a\u00020\u001b¢\u0006\u0004\b.\u0010-\u001a\u0019\u0010.\u001a\u00020\u0006*\u00020%2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b.\u00101\u001aM\u00109\u001a\u00020\u0006*\u00020%2\b\b\u0001\u00102\u001a\u00020\u001b2\u0016\u00105\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010403\"\u0004\u0018\u0001042\u0018\b\u0002\u00108\u001a\u0012\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`7¢\u0006\u0004\b9\u0010:\u001a\u001b\u0010;\u001a\u0004\u0018\u00010\u0006*\u00020%2\u0006\u0010+\u001a\u00020\u001b¢\u0006\u0004\b;\u0010<\u001a\u001d\u0010;\u001a\u0004\u0018\u00010\u0006*\u00020%2\b\u0010=\u001a\u0004\u0018\u00010/¢\u0006\u0004\b;\u0010>\u001a\u001b\u0010?\u001a\u00020\u0006*\u00020%2\b\u0010=\u001a\u0004\u0018\u00010/¢\u0006\u0004\b?\u00101\u001a\u001b\u0010A\u001a\u0004\u0018\u00010\u0006*\u00020%2\u0006\u0010@\u001a\u00020\u001b¢\u0006\u0004\bA\u0010<\u001a\u0013\u0010B\u001a\u0004\u0018\u00010\u0006*\u00020%¢\u0006\u0004\bB\u0010*\u001a/\u0010G\u001a\u0004\u0018\u00010\u0006*\u00020%2\u0006\u0010D\u001a\u00020C2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\bG\u0010H\u001a5\u0010N\u001a\u0004\u0018\u00010\u0006*\u00020%2 \u0010M\u001a\u001c\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010K\u0012\u0004\u0012\u00020L0I¢\u0006\u0004\bN\u0010O\u001a1\u0010R\u001a\u0004\u0018\u00010\u0006*\u00020%2\b\b\u0002\u0010P\u001a\u00020L2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\bR\u0010S\u001a'\u0010T\u001a\u0004\u0018\u00010\u0006*\u00020%2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\bT\u0010U\u001a\u0019\u0010W\u001a\u00020\u0006*\u00020%2\u0006\u0010M\u001a\u00020V¢\u0006\u0004\bW\u0010X\u001a\u0011\u0010Y\u001a\u00020\u0006*\u00020%¢\u0006\u0004\bY\u0010Z\u001a\u0011\u0010[\u001a\u00020\u0006*\u00020%¢\u0006\u0004\b[\u0010Z\u001a'\u0010]\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\u0006\u0010\\\u001a\u00020L2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007¢\u0006\u0004\b]\u0010^\u001a\u001b\u0010a\u001a\u00020\u0006*\u00020\u00022\b\u0010`\u001a\u0004\u0018\u00010_¢\u0006\u0004\ba\u0010b\u001a\u001b\u0010c\u001a\u00020\u0006*\u00020J2\b\u0010=\u001a\u0004\u0018\u00010/¢\u0006\u0004\bc\u0010d\u001a7\u0010g\u001a\u00020\u0006*\u00020J2\b\b\u0001\u0010e\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020\u001b2\u0012\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u00020403\"\u000204¢\u0006\u0004\bg\u0010h\u001a#\u0010l\u001a\u00020\u0006*\u00020\u00022\u0006\u0010i\u001a\u00020L2\b\b\u0002\u0010k\u001a\u00020j¢\u0006\u0004\bl\u0010m\u001a#\u0010n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010i\u001a\u00020L2\b\b\u0002\u0010k\u001a\u00020j¢\u0006\u0004\bn\u0010m\u001a9\u0010s\u001a\u00020\u0006*\u00020J2\b\b\u0003\u0010o\u001a\u00020\u001b2\b\b\u0003\u0010p\u001a\u00020\u001b2\b\b\u0003\u0010q\u001a\u00020\u001b2\b\b\u0003\u0010r\u001a\u00020\u001b¢\u0006\u0004\bs\u0010t\u001a\u0011\u0010v\u001a\u00020\u0006*\u00020u¢\u0006\u0004\bv\u0010w\u001a\u0011\u0010y\u001a\u00020\u0002*\u00020x¢\u0006\u0004\by\u0010z\u001a\u0011\u0010{\u001a\u00020\u0006*\u00020\u0002¢\u0006\u0004\b{\u0010\u0019\u001a\u0011\u0010|\u001a\u00020\u0006*\u00020\u0002¢\u0006\u0004\b|\u0010\u0019\u001aE\u0010\u0083\u0001\u001a\u00020\u0006*\u00020\u00022\b\u0010~\u001a\u0004\u0018\u00010}2\t\b\u0001\u0010\u0080\u0001\u001a\u00020\u007f2\u0014\u0010\u0082\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a(\u0010\u0089\u0001\u001a\u00020\u0006*\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020L2\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001\"9\u0010\u008e\u0001\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0005\u0012\u00030\u008c\u0001`\u008d\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0019\u0010\u0090\u0001\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0019\u0010\u0092\u0001\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0091\u0001*%\b\u0002\u0010\u0093\u0001\"\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00060\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0094\u0001"}, d2 = {"Landroid/view/ViewParent;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "findParent", "(Landroid/view/View;)Landroid/view/ViewParent;", "Lkotlin/Function1;", "", "onLongClick", "setOnLongClickListenerConsumeClick", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "", "delayMillis", "hintWithRipple", "(Landroid/view/View;J)V", "fadeMillis", "setup", "Landroid/view/ViewPropertyAnimator;", "additionalAnimation", "Lkotlin/Function0;", "onAnimationEnd", "fadeIn", "(Landroid/view/View;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "fadeOut", "(Landroid/view/View;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "cancelFadeAnimations", "(Landroid/view/View;)V", "Lkotlin/Function2;", "", "onHeightChanged", "addOnHeightChangedListener", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "onWidthChanged", "addOnWidthChangedListener", "Lkotlin/Function4;", "onSizeChanged", "addOnSizeChangedListener", "(Landroid/view/View;Lkotlin/jvm/functions/Function4;)V", "Lcom/google/android/material/textfield/TextInputLayout;", "", "getTextOrEmpty", "(Lcom/google/android/material/textfield/TextInputLayout;)Ljava/lang/String;", "clear", "(Lcom/google/android/material/textfield/TextInputLayout;)Lkotlin/Unit;", "resId", "setHint", "(Lcom/google/android/material/textfield/TextInputLayout;I)V", "setSingleLineHint", "", "charSequence", "(Lcom/google/android/material/textfield/TextInputLayout;Ljava/lang/CharSequence;)V", "stringResId", "", "", "formatArgs", "Lcom/discord/i18n/RenderContext;", "Lcom/discord/utilities/view/extensions/Initializer;", "initializer", "i18nSetText", "(Lcom/google/android/material/textfield/TextInputLayout;I[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "setText", "(Lcom/google/android/material/textfield/TextInputLayout;I)Lkotlin/Unit;", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "(Lcom/google/android/material/textfield/TextInputLayout;Ljava/lang/CharSequence;)Lkotlin/Unit;", "setTextIfDifferent", "index", "setSelection", "setSelectionEnd", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/text/Editable;", "onAfterTextChanged", "addBindedTextWatcher", "(Lcom/google/android/material/textfield/TextInputLayout;Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "Lkotlin/Function3;", "Landroid/widget/TextView;", "Landroid/view/KeyEvent;", "", "l", "setOnEditorActionListener", "(Lcom/google/android/material/textfield/TextInputLayout;Lkotlin/jvm/functions/Function3;)Lkotlin/Unit;", "isEventConsumed", "onImeActionDone", "setOnImeActionDone", "(Lcom/google/android/material/textfield/TextInputLayout;ZLkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "setOnEditTextClickListener", "(Lcom/google/android/material/textfield/TextInputLayout;Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "Landroid/view/View$OnFocusChangeListener;", "setOnEditTextFocusChangeListener", "(Lcom/google/android/material/textfield/TextInputLayout;Landroid/view/View$OnFocusChangeListener;)V", "interceptScrollWhenInsideScrollable", "(Lcom/google/android/material/textfield/TextInputLayout;)V", "moveCursorToEnd", "isVisible", "fadeBy", "(Landroid/view/View;ZJ)V", "Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "setBackgroundAndKeepPadding", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V", "setTextAndVisibilityBy", "(Landroid/widget/TextView;Ljava/lang/CharSequence;)V", "pluralResId", "quantity", "setPluralText", "(Landroid/widget/TextView;II[Ljava/lang/Object;)V", "enabled", "", "disabledAlpha", "setEnabledAndAlpha", "(Landroid/view/View;ZF)V", "setEnabledAlpha", "start", "top", "end", "bottom", "setCompoundDrawableWithIntrinsicBounds", "(Landroid/widget/TextView;IIII)V", "Landroid/view/ViewGroup;", "setForwardingWindowInsetsListener", "(Landroid/view/ViewGroup;)V", "Landroidx/core/widget/NestedScrollView;", "getContentView", "(Landroidx/core/widget/NestedScrollView;)Landroid/view/View;", "enable", "disable", "Landroid/util/AttributeSet;", "attrs", "", "styleable", "Landroid/content/res/TypedArray;", "block", "useAttrs", "(Landroid/view/View;Landroid/util/AttributeSet;[ILkotlin/jvm/functions/Function1;)V", "Landroid/widget/CompoundButton;", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "setProgrammaticChecked", "(Landroid/widget/CompoundButton;ZLandroid/widget/CompoundButton$OnCheckedChangeListener;)V", "Ljava/util/HashMap;", "Lcom/discord/utilities/view/extensions/FadeAnimation;", "Lkotlin/collections/HashMap;", "fadeAnimations", "Ljava/util/HashMap;", "DEFAULT_FADE_MILLIS_RES", "J", "HINT_DELAY_MILLIS", "Initializer", "utils_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ViewExtensions {
    private static final long DEFAULT_FADE_MILLIS_RES = 350;
    private static final long HINT_DELAY_MILLIS = 250;
    private static final HashMap<View, ViewExtensions3> fadeAnimations = new HashMap<>();

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u00020\f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "top", "<anonymous parameter 3>", "bottom", "<anonymous parameter 5>", "oldTop", "<anonymous parameter 7>", "oldBottom", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$addOnHeightChangedListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {
        public final /* synthetic */ Function2 $onHeightChanged;

        public AnonymousClass1(Function2 function2) {
            this.$onHeightChanged = function2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i4 - i2;
            int i10 = i8 - i6;
            if (i9 != i10) {
                this.$onHeightChanged.invoke(Integer.valueOf(i9), Integer.valueOf(i10));
            }
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u00020\f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$addOnSizeChangedListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {
        public final /* synthetic */ Function4 $onSizeChanged;

        public AnonymousClass1(Function4 function4) {
            this.$onSizeChanged = function4;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            int i11 = i7 - i5;
            int i12 = i8 - i6;
            if (i9 == i11 && i10 == i12) {
                return;
            }
            this.$onSizeChanged.invoke(Integer.valueOf(i9), Integer.valueOf(i11), Integer.valueOf(i10), Integer.valueOf(i12));
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u00020\f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "left", "<anonymous parameter 2>", "right", "<anonymous parameter 4>", "oldLeft", "<anonymous parameter 6>", "oldRight", "<anonymous parameter 8>", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$addOnWidthChangedListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {
        public final /* synthetic */ Function2 $onWidthChanged;

        public AnonymousClass1(Function2 function2) {
            this.$onWidthChanged = function2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i7 - i5;
            if (i9 != i10) {
                this.$onWidthChanged.invoke(Integer.valueOf(i9), Integer.valueOf(i10));
            }
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeIn$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "", "invoke", "(Landroid/view/ViewPropertyAnimator;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeIn$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeIn$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "", "invoke", "(Landroid/view/ViewPropertyAnimator;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeOut$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeOut$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$hintWithRipple$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ View $this_hintWithRipple;

        public AnonymousClass1(View view) {
            this.$this_hintWithRipple = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.$this_hintWithRipple.setPressed(true);
            this.$this_hintWithRipple.setPressed(false);
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$i18nSetText$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "Landroid/view/MotionEvent;", "<anonymous parameter 1>", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$interceptScrollWhenInsideScrollable$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnTouchListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            if (!view.isFocused()) {
                return false;
            }
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "v", "Landroidx/core/view/WindowInsetsCompat;", "insets", "kotlin.jvm.PlatformType", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$setForwardingWindowInsetsListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "v");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            if (view instanceof ViewGroup) {
                Iterator<View> it = androidx.core.view.ViewGroup.getChildren((ViewGroup) view).iterator();
                while (it.hasNext()) {
                    ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompat);
                }
            }
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/widget/TextView;", "textView", "", "actionId", "Landroid/view/KeyEvent;", "<anonymous parameter 2>", "", "invoke", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$setOnImeActionDone$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public final /* synthetic */ boolean $isEventConsumed;
        public final /* synthetic */ Function1 $onImeActionDone;
        public final /* synthetic */ TextInputLayout $this_setOnImeActionDone;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TextInputLayout textInputLayout, Function1 function1, boolean z2) {
            super(3);
            this.$this_setOnImeActionDone = textInputLayout;
            this.$onImeActionDone = function1;
            this.$isEventConsumed = z2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            if (i == 6) {
                if (ViewExtensions.getTextOrEmpty(this.$this_setOnImeActionDone).length() > 0) {
                    this.$onImeActionDone.invoke(textView);
                }
            }
            return this.$isEventConsumed;
        }
    }

    /* compiled from: ViewExtensions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onLongClick", "(Landroid/view/View;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.extensions.ViewExtensions$setOnLongClickListenerConsumeClick$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLongClickListener {
        public final /* synthetic */ Function1 $onLongClick;

        public AnonymousClass1(Function1 function1) {
            this.$onLongClick = function1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            Function1 function1 = this.$onLongClick;
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            function1.invoke(view);
            ViewParent parent = view.getParent();
            while (true) {
                if (parent == null) {
                    parent = null;
                    break;
                }
                if (parent instanceof RecyclerView) {
                    break;
                }
                parent = parent.getParent();
            }
            RecyclerView recyclerView = (RecyclerView) parent;
            if (recyclerView == null) {
                return true;
            }
            RecyclerViewExtensions.ignoreCurrentTouch(recyclerView);
            return true;
        }
    }

    public static final /* synthetic */ HashMap access$getFadeAnimations$p() {
        return fadeAnimations;
    }

    public static final Unit addBindedTextWatcher(TextInputLayout textInputLayout, Fragment fragment, Function1<? super Editable, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$addBindedTextWatcher");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(function1, "onAfterTextChanged");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        TextWatcher4.addBindedTextWatcher(editText, fragment, function1);
        return Unit.a;
    }

    public static final void addOnHeightChangedListener(View view, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(view, "$this$addOnHeightChangedListener");
        Intrinsics3.checkNotNullParameter(function2, "onHeightChanged");
        view.addOnLayoutChangeListener(new AnonymousClass1(function2));
    }

    public static final void addOnSizeChangedListener(View view, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics3.checkNotNullParameter(view, "$this$addOnSizeChangedListener");
        Intrinsics3.checkNotNullParameter(function4, "onSizeChanged");
        view.addOnLayoutChangeListener(new AnonymousClass1(function4));
    }

    public static final void addOnWidthChangedListener(View view, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(view, "$this$addOnWidthChangedListener");
        Intrinsics3.checkNotNullParameter(function2, "onWidthChanged");
        view.addOnLayoutChangeListener(new AnonymousClass1(function2));
    }

    public static final void cancelFadeAnimations(View view) {
        ViewPropertyAnimator viewPropertyAnimator;
        Intrinsics3.checkNotNullParameter(view, "$this$cancelFadeAnimations");
        ViewExtensions3 viewExtensions3Remove = fadeAnimations.remove(view);
        if (viewExtensions3Remove == null || (viewPropertyAnimator = viewExtensions3Remove.getViewPropertyAnimator()) == null) {
            return;
        }
        viewPropertyAnimator.cancel();
    }

    public static final Unit clear(TextInputLayout textInputLayout) {
        Editable text;
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$clear");
        EditText editText = textInputLayout.getEditText();
        if (editText == null || (text = editText.getText()) == null) {
            return null;
        }
        text.clear();
        return Unit.a;
    }

    public static final void disable(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$disable");
        view.setEnabled(false);
    }

    public static final void enable(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$enable");
        view.setEnabled(true);
    }

    public static final void fadeBy(View view, boolean z2) {
        fadeBy$default(view, z2, 0L, 2, null);
    }

    public static final void fadeBy(View view, boolean z2, long j) {
        if (z2) {
            fadeIn$default(view, j, null, null, null, 14, null);
        } else {
            fadeOut$default(view, j, null, null, 6, null);
        }
    }

    public static /* synthetic */ void fadeBy$default(View view, boolean z2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = DEFAULT_FADE_MILLIS_RES;
        }
        fadeBy(view, z2, j);
    }

    @MainThread
    public static final void fadeIn(View view) {
        fadeIn$default(view, 0L, null, null, null, 15, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j) {
        fadeIn$default(view, j, null, null, null, 14, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j, Function1<? super View, Unit> function1) {
        fadeIn$default(view, j, function1, null, null, 12, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j, Function1<? super View, Unit> function1, Function1<? super ViewPropertyAnimator, Unit> function12) {
        fadeIn$default(view, j, function1, function12, null, 8, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j, Function1<? super View, Unit> function1, Function1<? super ViewPropertyAnimator, Unit> function12, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function1, "setup");
        Intrinsics3.checkNotNullParameter(function12, "additionalAnimation");
        Intrinsics3.checkNotNullParameter(function0, "onAnimationEnd");
        if (view != null) {
            HashMap<View, ViewExtensions3> map = fadeAnimations;
            ViewExtensions3 viewExtensions3 = map.get(view);
            ViewExtensions3.Type type = viewExtensions3 != null ? viewExtensions3.getType() : null;
            ViewExtensions3.Type type2 = ViewExtensions3.Type.FADE_IN;
            if (type == type2) {
                return;
            }
            if (viewExtensions3 != null) {
                map.remove(view);
                viewExtensions3.getViewPropertyAnimator().cancel();
            }
            if (view.getVisibility() == 0) {
                view.setAlpha(1.0f);
                return;
            }
            view.setAlpha(0.0f);
            function1.invoke(view);
            view.setVisibility(0);
            ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().alpha(1.0f);
            function12.invoke(viewPropertyAnimatorAlpha);
            ViewPropertyAnimator listener = viewPropertyAnimatorAlpha.setDuration(j).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new ViewExtensions4(function0)).setListener(new ViewExtensions2(view));
            Intrinsics3.checkNotNullExpressionValue(listener, "viewPropertyAnimator");
            map.put(view, new ViewExtensions3(listener, type2));
            listener.start();
        }
    }

    public static /* synthetic */ void fadeIn$default(View view, long j, Function1 function1, Function1 function12, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = DEFAULT_FADE_MILLIS_RES;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        Function1 function13 = function1;
        if ((i & 4) != 0) {
            function12 = AnonymousClass2.INSTANCE;
        }
        Function1 function14 = function12;
        if ((i & 8) != 0) {
            function0 = AnonymousClass3.INSTANCE;
        }
        fadeIn(view, j2, function13, function14, function0);
    }

    @MainThread
    public static final void fadeOut(View view) {
        fadeOut$default(view, 0L, null, null, 7, null);
    }

    @MainThread
    public static final void fadeOut(View view, long j) {
        fadeOut$default(view, j, null, null, 6, null);
    }

    @MainThread
    public static final void fadeOut(View view, long j, Function1<? super ViewPropertyAnimator, Unit> function1) {
        fadeOut$default(view, j, function1, null, 4, null);
    }

    @MainThread
    public static final void fadeOut(View view, long j, Function1<? super ViewPropertyAnimator, Unit> function1, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function1, "additionalAnimation");
        Intrinsics3.checkNotNullParameter(function0, "onAnimationEnd");
        if (view != null) {
            HashMap<View, ViewExtensions3> map = fadeAnimations;
            ViewExtensions3 viewExtensions3 = map.get(view);
            ViewExtensions3.Type type = viewExtensions3 != null ? viewExtensions3.getType() : null;
            ViewExtensions3.Type type2 = ViewExtensions3.Type.FADE_OUT;
            if (type == type2) {
                return;
            }
            if (viewExtensions3 != null) {
                map.remove(view);
                viewExtensions3.getViewPropertyAnimator().cancel();
            }
            if (view.getVisibility() == 0) {
                ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().alpha(0.0f);
                function1.invoke(viewPropertyAnimatorAlpha);
                ViewPropertyAnimator listener = viewPropertyAnimatorAlpha.setDuration(j).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new ViewExtensions5(view, function0)).setListener(new ViewExtensions2(view));
                Intrinsics3.checkNotNullExpressionValue(listener, "viewPropertyAnimator");
                map.put(view, new ViewExtensions3(listener, type2));
                listener.start();
            }
        }
    }

    public static /* synthetic */ void fadeOut$default(View view, long j, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = DEFAULT_FADE_MILLIS_RES;
        }
        if ((i & 2) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        if ((i & 4) != 0) {
            function0 = AnonymousClass2.INSTANCE;
        }
        fadeOut(view, j, function1, function0);
    }

    public static final /* synthetic */ <T extends ViewParent> T findParent(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$findParent");
        T t = (T) view.getParent();
        if (t == null) {
            return null;
        }
        Intrinsics3.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final View getContentView(NestedScrollView nestedScrollView) {
        Intrinsics3.checkNotNullParameter(nestedScrollView, "$this$getContentView");
        View childAt = nestedScrollView.getChildAt(0);
        Intrinsics3.checkNotNullExpressionValue(childAt, "getChildAt(0)");
        return childAt;
    }

    public static final String getTextOrEmpty(TextInputLayout textInputLayout) {
        Editable text;
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$getTextOrEmpty");
        EditText editText = textInputLayout.getEditText();
        String string = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        return string != null ? string : "";
    }

    public static final void hintWithRipple(View view, long j) {
        Intrinsics3.checkNotNullParameter(view, "$this$hintWithRipple");
        view.setPressed(true);
        view.setPressed(false);
        view.postDelayed(new AnonymousClass1(view), j);
    }

    public static /* synthetic */ void hintWithRipple$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = HINT_DELAY_MILLIS;
        }
        hintWithRipple(view, j);
    }

    public static final void i18nSetText(TextInputLayout textInputLayout, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$i18nSetText");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            FormatUtils.m(editText, i, Arrays.copyOf(objArr, objArr.length), function1);
        }
    }

    public static /* synthetic */ void i18nSetText$default(TextInputLayout textInputLayout, int i, Object[] objArr, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        i18nSetText(textInputLayout, i, objArr, function1);
    }

    public static final void interceptScrollWhenInsideScrollable(TextInputLayout textInputLayout) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$interceptScrollWhenInsideScrollable");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setOnTouchListener(AnonymousClass1.INSTANCE);
        }
    }

    public static final void moveCursorToEnd(TextInputLayout textInputLayout) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$moveCursorToEnd");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setSelection(editText.getText().toString().length());
        }
    }

    public static final void setBackgroundAndKeepPadding(View view, Drawable drawable) {
        Intrinsics3.checkNotNullParameter(view, "$this$setBackgroundAndKeepPadding");
        view.setBackground(drawable);
    }

    public static final void setCompoundDrawableWithIntrinsicBounds(TextView textView, @DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setCompoundDrawableWithIntrinsicBounds");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    public static /* synthetic */ void setCompoundDrawableWithIntrinsicBounds$default(TextView textView, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        setCompoundDrawableWithIntrinsicBounds(textView, i, i2, i3, i4);
    }

    public static final void setEnabledAlpha(View view, boolean z2, float f) {
        Intrinsics3.checkNotNullParameter(view, "$this$setEnabledAlpha");
        if (z2) {
            f = 1.0f;
        }
        view.setAlpha(f);
    }

    public static /* synthetic */ void setEnabledAlpha$default(View view, boolean z2, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.3f;
        }
        setEnabledAlpha(view, z2, f);
    }

    public static final void setEnabledAndAlpha(View view, boolean z2, float f) {
        Intrinsics3.checkNotNullParameter(view, "$this$setEnabledAndAlpha");
        view.setEnabled(z2);
        setEnabledAlpha(view, z2, f);
    }

    public static /* synthetic */ void setEnabledAndAlpha$default(View view, boolean z2, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.3f;
        }
        setEnabledAndAlpha(view, z2, f);
    }

    public static final void setForwardingWindowInsetsListener(ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(viewGroup, "$this$setForwardingWindowInsetsListener");
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, AnonymousClass1.INSTANCE);
    }

    public static final void setHint(TextInputLayout textInputLayout, int i) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setHint");
        textInputLayout.setHint(textInputLayout.getContext().getString(i));
    }

    public static final Unit setOnEditTextClickListener(TextInputLayout textInputLayout, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setOnEditTextClickListener");
        Intrinsics3.checkNotNullParameter(function1, "l");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setOnClickListener(new ViewExtensions6(function1));
        return Unit.a;
    }

    public static final void setOnEditTextFocusChangeListener(TextInputLayout textInputLayout, View.OnFocusChangeListener onFocusChangeListener) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setOnEditTextFocusChangeListener");
        Intrinsics3.checkNotNullParameter(onFocusChangeListener, "l");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public static final Unit setOnEditorActionListener(TextInputLayout textInputLayout, Function3<? super TextView, ? super Integer, ? super KeyEvent, Boolean> function3) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setOnEditorActionListener");
        Intrinsics3.checkNotNullParameter(function3, "l");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setOnEditorActionListener(new ViewExtensions7(function3));
        return Unit.a;
    }

    public static final Unit setOnImeActionDone(TextInputLayout textInputLayout, boolean z2, Function1<? super TextView, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setOnImeActionDone");
        Intrinsics3.checkNotNullParameter(function1, "onImeActionDone");
        return setOnEditorActionListener(textInputLayout, new AnonymousClass1(textInputLayout, function1, z2));
    }

    public static /* synthetic */ Unit setOnImeActionDone$default(TextInputLayout textInputLayout, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return setOnImeActionDone(textInputLayout, z2, function1);
    }

    public static final void setOnLongClickListenerConsumeClick(View view, Function1<? super View, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "$this$setOnLongClickListenerConsumeClick");
        Intrinsics3.checkNotNullParameter(function1, "onLongClick");
        view.setOnLongClickListener(new AnonymousClass1(function1));
    }

    public static final void setPluralText(TextView textView, @PluralsRes int i, int i2, Object... objArr) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setPluralText");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Resources resources = textView.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        Context context = textView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(Integer.valueOf(i2));
        spreadBuilder.addSpread(objArr);
        textView.setText(StringResourceUtils.getQuantityString(resources, context, i, i2, spreadBuilder.toArray(new Object[spreadBuilder.size()])));
    }

    public static final void setProgrammaticChecked(CompoundButton compoundButton, boolean z2, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics3.checkNotNullParameter(compoundButton, "$this$setProgrammaticChecked");
        Intrinsics3.checkNotNullParameter(onCheckedChangeListener, "listener");
        compoundButton.setOnCheckedChangeListener(null);
        compoundButton.setChecked(z2);
        compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public static final Unit setSelection(TextInputLayout textInputLayout, int i) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setSelection");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setSelection(i);
        return Unit.a;
    }

    public static final Unit setSelectionEnd(TextInputLayout textInputLayout) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setSelectionEnd");
        EditText editText = textInputLayout.getEditText();
        return setSelection(textInputLayout, editText != null ? editText.length() : 0);
    }

    public static final void setSingleLineHint(TextInputLayout textInputLayout, int i) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setSingleLineHint");
        String string = textInputLayout.getContext().getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(resId)");
        setSingleLineHint(textInputLayout, string);
    }

    public static final Unit setText(TextInputLayout textInputLayout, int i) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setText");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setText(i);
        return Unit.a;
    }

    public static final void setTextAndVisibilityBy(TextView textView, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(textView, "$this$setTextAndVisibilityBy");
        textView.setText(charSequence);
        textView.setVisibility((charSequence == null || StringsJVM.isBlank(charSequence)) ^ true ? 0 : 8);
    }

    public static final void setTextIfDifferent(TextInputLayout textInputLayout, CharSequence charSequence) {
        EditText editText;
        Editable text;
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setTextIfDifferent");
        EditText editText2 = textInputLayout.getEditText();
        if (!(!Intrinsics3.areEqual((editText2 == null || (text = editText2.getText()) == null) ? null : text.toString(), charSequence)) || (editText = textInputLayout.getEditText()) == null) {
            return;
        }
        editText.setText(charSequence);
    }

    public static final void useAttrs(View view, AttributeSet attributeSet, @StyleableRes int[] iArr, Function1<? super TypedArray, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "$this$useAttrs");
        Intrinsics3.checkNotNullParameter(iArr, "styleable");
        Intrinsics3.checkNotNullParameter(function1, "block");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        function1.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void setSingleLineHint(TextInputLayout textInputLayout, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setSingleLineHint");
        Intrinsics3.checkNotNullParameter(charSequence, "charSequence");
        textInputLayout.setHintEnabled(false);
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setHint(charSequence);
        }
    }

    public static final Unit setText(TextInputLayout textInputLayout, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(textInputLayout, "$this$setText");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setText(charSequence);
        return Unit.a;
    }
}
