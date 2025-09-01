package com.discord.utilities.view.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import b.i.a.f.e.o.f;
import com.discord.utilities.logging.Logger;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Maps6;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges2;
import kotlinx.coroutines.Job;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.h1;

/* compiled from: LinkifiedTextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0012\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/discord/utilities/view/text/LinkifiedTextView;", "Lcom/discord/utilities/view/text/SimpleDraweeSpanTextView;", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "Landroid/widget/TextView$BufferType;", "type", "", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attrs", "", "defAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "ClickableSpanOnTouchListener", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class LinkifiedTextView extends SimpleDraweeSpanTextView {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy logger$delegate = LazyJVM.lazy(LinkifiedTextView5.INSTANCE);
    private static Function2<? super View, ? super String, Unit> onURLSpanClicked;

    /* compiled from: LinkifiedTextView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR*\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/view/text/LinkifiedTextView$Companion;", "", "Lkotlin/Function2;", "Landroid/view/View;", "", "", "onURLSpanClicked", "init", "(Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;", "Lcom/discord/utilities/logging/Logger;", "logger$delegate", "Lkotlin/Lazy;", "getLogger", "()Lcom/discord/utilities/logging/Logger;", "logger", "Lkotlin/jvm/functions/Function2;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Logger access$getLogger$p(Companion companion) {
            return companion.getLogger();
        }

        private final Logger getLogger() {
            Lazy lazyAccess$getLogger$cp = LinkifiedTextView.access$getLogger$cp();
            Companion companion = LinkifiedTextView.INSTANCE;
            return (Logger) lazyAccess$getLogger$cp.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Unit init$default(Companion companion, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                function2 = null;
            }
            return companion.init(function2);
        }

        public final Unit init(Function2<? super View, ? super String, Unit> onURLSpanClicked) {
            if (onURLSpanClicked == null) {
                return null;
            }
            LinkifiedTextView.access$setOnURLSpanClicked$cp(onURLSpanClicked);
            return Unit.a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LinkifiedTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public LinkifiedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LinkifiedTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ Lazy access$getLogger$cp() {
        return logger$delegate;
    }

    public static final /* synthetic */ Function2 access$getOnURLSpanClicked$cp() {
        return onURLSpanClicked;
    }

    public static final /* synthetic */ void access$setOnURLSpanClicked$cp(Function2 function2) {
        onURLSpanClicked = function2;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        try {
            super.setText(text, type);
        } catch (AndroidRuntimeException e) {
            if (e instanceof PackageManager.NameNotFoundException) {
                setAutoLinkMask(0);
                super.setText(text, type);
            } else {
                Log.w(LinkifiedTextView.class.toString(), "could not setText()", e);
                setText((CharSequence) null);
            }
        } catch (Exception e2) {
            if (new Ranges2(24, 25).contains(Build.VERSION.SDK_INT)) {
                Logger.e$default(Companion.access$getLogger$p(INSTANCE), "Unable to linkify text", e2, null, 4, null);
            } else {
                super.setText((CharSequence) null, type);
            }
        }
        setMovementMethod(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        setOnTouchListener(new ClickableSpanOnTouchListener(0L, onURLSpanClicked, 1, null));
    }

    /* compiled from: LinkifiedTextView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R*\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/view/text/LinkifiedTextView$ClickableSpanOnTouchListener;", "Landroid/view/View$OnTouchListener;", "Landroid/widget/TextView;", "Landroid/view/MotionEvent;", "event", "", "Landroid/text/style/ClickableSpan;", "getTouchedClickableSpans", "(Landroid/widget/TextView;Landroid/view/MotionEvent;)[Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "view", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "job", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlin/Function2;", "", "", "onURLSpanClicked", "Lkotlin/jvm/functions/Function2;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClickHandled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "longPressDelayInMs", "J", "<init>", "(JLkotlin/jvm/functions/Function2;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class ClickableSpanOnTouchListener implements View.OnTouchListener {
        private AtomicBoolean isClickHandled;
        private AtomicReference<Job> job;
        private final long longPressDelayInMs;
        private final Function2<View, String, Unit> onURLSpanClicked;

        /* JADX WARN: Multi-variable type inference failed */
        public ClickableSpanOnTouchListener(long j, Function2<? super View, ? super String, Unit> function2) {
            this.longPressDelayInMs = j;
            this.onURLSpanClicked = function2;
            this.isClickHandled = new AtomicBoolean(false);
            this.job = new AtomicReference<>();
        }

        public static final /* synthetic */ AtomicReference access$getJob$p(ClickableSpanOnTouchListener clickableSpanOnTouchListener) {
            return clickableSpanOnTouchListener.job;
        }

        public static final /* synthetic */ long access$getLongPressDelayInMs$p(ClickableSpanOnTouchListener clickableSpanOnTouchListener) {
            return clickableSpanOnTouchListener.longPressDelayInMs;
        }

        public static final /* synthetic */ AtomicBoolean access$isClickHandled$p(ClickableSpanOnTouchListener clickableSpanOnTouchListener) {
            return clickableSpanOnTouchListener.isClickHandled;
        }

        public static final /* synthetic */ void access$setClickHandled$p(ClickableSpanOnTouchListener clickableSpanOnTouchListener, AtomicBoolean atomicBoolean) {
            clickableSpanOnTouchListener.isClickHandled = atomicBoolean;
        }

        public static final /* synthetic */ void access$setJob$p(ClickableSpanOnTouchListener clickableSpanOnTouchListener, AtomicReference atomicReference) {
            clickableSpanOnTouchListener.job = atomicReference;
        }

        private final ClickableSpan[] getTouchedClickableSpans(TextView textView, MotionEvent motionEvent) {
            CharSequence text = textView.getText();
            if (!(text instanceof Spanned)) {
                text = null;
            }
            Spanned spanned = (Spanned) text;
            if (spanned == null) {
                return new ClickableSpan[0];
            }
            int scrollX = textView.getScrollX() + (((int) motionEvent.getX()) - textView.getTotalPaddingLeft());
            int scrollY = textView.getScrollY() + (((int) motionEvent.getY()) - textView.getTotalPaddingTop());
            Layout layout = textView.getLayout();
            if (layout == null) {
                return new ClickableSpan[0];
            }
            int lineForVertical = layout.getLineForVertical(scrollY);
            Layout layout2 = textView.getLayout();
            if (layout2 == null) {
                return new ClickableSpan[0];
            }
            float f = scrollX;
            int offsetForHorizontal = layout2.getOffsetForHorizontal(lineForVertical, f);
            float lineRight = textView.getLayout().getLineRight(lineForVertical);
            float lineLeft = textView.getLayout().getLineLeft(lineForVertical);
            if (f > lineRight || (scrollX >= 0 && f < lineLeft)) {
                return new ClickableSpan[0];
            }
            Object[] spans = spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            Intrinsics3.checkNotNullExpressionValue(spans, "spanned.getSpans(off, of…lickableSpan::class.java)");
            return (ClickableSpan[]) spans;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0168  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent event) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(event, "event");
            TextView textView = (TextView) (!(view instanceof TextView) ? null : view);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            if (textView != null) {
                try {
                    ClickableSpan[] touchedClickableSpans = getTouchedClickableSpans(textView, event);
                    T t = touchedClickableSpans != null ? (ClickableSpan) _Arrays.firstOrNull(touchedClickableSpans) : 0;
                    ref$ObjectRef.element = t;
                } catch (IndexOutOfBoundsException e) {
                    Tuples2[] tuples2Arr = new Tuples2[8];
                    tuples2Arr[0] = Tuples.to(NotificationCompat.MessagingStyle.Message.KEY_TEXT, String.valueOf(textView != null ? textView.getText() : null));
                    tuples2Arr[1] = Tuples.to("view_x", String.valueOf(textView != null ? Float.valueOf(textView.getX()) : null));
                    tuples2Arr[2] = Tuples.to("view_y", String.valueOf(textView != null ? Float.valueOf(textView.getY()) : null));
                    tuples2Arr[3] = Tuples.to("event_x", String.valueOf(event.getX()));
                    tuples2Arr[4] = Tuples.to("event_y", String.valueOf(event.getY()));
                    tuples2Arr[5] = Tuples.to("event_action", String.valueOf(event.getAction()));
                    tuples2Arr[6] = Tuples.to("width", String.valueOf(textView != null ? Integer.valueOf(textView.getWidth()) : null));
                    tuples2Arr[7] = Tuples.to("height", String.valueOf(textView != null ? Integer.valueOf(textView.getHeight()) : null));
                    Map<String, String> mapMapOf = Maps6.mapOf(tuples2Arr);
                    Logger loggerAccess$getLogger$p = Companion.access$getLogger$p(LinkifiedTextView.INSTANCE);
                    String name = ClickableSpanOnTouchListener.class.getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
                    loggerAccess$getLogger$p.e(name, "failed to get touched clickable spans", e, mapMapOf);
                }
            }
            if (((ClickableSpan) ref$ObjectRef.element) == null) {
                Job job = this.job.get();
                if (job != null) {
                    f.t(job, null, 1, null);
                }
                return false;
            }
            int action = event.getAction();
            if (action == 0) {
                this.isClickHandled.set(false);
                Job job2 = this.job.get();
                if (job2 != null) {
                    f.t(job2, null, 1, null);
                }
                if (((ClickableSpan) ref$ObjectRef.element) instanceof com.discord.utilities.spans.ClickableSpan) {
                    Job jobH0 = f.H0(CoroutineScope2.j, Dispatchers.a, null, new LinkifiedTextView4(this, new WeakReference(view), ref$ObjectRef, null), 2, null);
                    ((h1) jobH0).n(false, true, new LinkifiedTextView2(jobH0, this));
                    Job andSet = this.job.getAndSet(jobH0);
                    if (andSet != null) {
                        f.t(andSet, null, 1, null);
                    }
                }
            } else if (action == 1) {
                Job job3 = this.job.get();
                if (job3 != null) {
                    f.t(job3, null, 1, null);
                }
                if (!this.isClickHandled.getAndSet(true)) {
                    T t2 = ref$ObjectRef.element;
                    if (((ClickableSpan) t2) instanceof URLSpan) {
                        Function2<View, String, Unit> function2 = this.onURLSpanClicked;
                        if (function2 != null) {
                            String url = ((URLSpan) ((ClickableSpan) t2)).getURL();
                            Intrinsics3.checkNotNullExpressionValue(url, "clickableSpan.url");
                            if (function2.invoke(view, url) == null) {
                                ((ClickableSpan) ref$ObjectRef.element).onClick(view);
                            }
                        }
                    } else {
                        ((ClickableSpan) t2).onClick(view);
                    }
                }
            } else {
                if (action != 3) {
                    return false;
                }
                Job job4 = this.job.get();
                if (job4 != null) {
                    f.t(job4, null, 1, null);
                }
            }
            return true;
        }

        public /* synthetic */ ClickableSpanOnTouchListener(long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 500L : j, function2);
        }
    }
}
