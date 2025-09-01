package com.discord.widgets.notice;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import b.p.a.Alert2;
import b.p.a.Alerter;
import b.p.a.Alerter3;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.widgets.home.WidgetHome;
import d0.e0.KClass;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: NoticePopup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J)\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010JÝ\u0001\u0010(\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\"0!0\u001a2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050$2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050$¢\u0006\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/discord/widgets/notice/NoticePopup;", "", "", "autoDismissPeriodSecs", "Lkotlin/Function0;", "", "onEnd", "Landroid/animation/ValueAnimator;", "getAutoDismissAnimator", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Landroid/animation/ValueAnimator;", "autoDismissAnimator", "cancelCountdown", "(Landroid/animation/ValueAnimator;)V", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "dismiss", "(Ljava/lang/String;)V", "noticeName", "", "noticeTitle", "noticeSubtitle", "noticeBody", "Landroid/graphics/drawable/Drawable;", "noticeBodyBackgroundDrawable", "noticeBodyImageUrl", "noticeBodyImageDrawable", "", "Lcom/discord/api/sticker/Sticker;", "noticeStickers", "noticeIconUrl", "noticeIconResId", "noticeIconTopRight", "noticeAutoDismissPeriodSecs", "Ld0/e0/c;", "Lcom/discord/app/AppComponent;", "validScreens", "Lkotlin/Function1;", "Landroid/view/View;", "onClickTopRightIcon", "onClick", "enqueue", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "DEFAULT_AUTO_DISMISS_PERIOD_SECONDS", "I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NoticePopup {
    private static final int DEFAULT_AUTO_DISMISS_PERIOD_SECONDS = 5;
    public static final NoticePopup INSTANCE = new NoticePopup();

    /* compiled from: NoticePopup.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.notice.NoticePopup$enqueue$1, reason: invalid class name */
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

    private NoticePopup() {
    }

    public static final /* synthetic */ void access$cancelCountdown(NoticePopup noticePopup, ValueAnimator valueAnimator) {
        noticePopup.cancelCountdown(valueAnimator);
    }

    public static final /* synthetic */ void access$dismiss(NoticePopup noticePopup, String str) {
        noticePopup.dismiss(str);
    }

    public static final /* synthetic */ ValueAnimator access$getAutoDismissAnimator(NoticePopup noticePopup, Integer num, Function0 function0) {
        return noticePopup.getAutoDismissAnimator(num, function0);
    }

    private final void cancelCountdown(ValueAnimator autoDismissAnimator) {
        if (autoDismissAnimator != null) {
            autoDismissAnimator.cancel();
        }
        if (autoDismissAnimator != null) {
            autoDismissAnimator.end();
        }
    }

    private final void dismiss(String name) {
        ViewGroup viewGroup;
        Alert2 alert2;
        WeakReference<ViewGroup> weakReference = Alerter3.a;
        if (weakReference != null && (viewGroup = weakReference.get()) != null) {
            Intrinsics3.checkNotNullExpressionValue(viewGroup, "it");
            int childCount = viewGroup.getChildCount();
            if (childCount >= 0) {
                int i = 0;
                while (true) {
                    if (viewGroup.getChildAt(i) instanceof Alert2) {
                        View childAt = viewGroup.getChildAt(i);
                        Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.tapadoo.alerter.Alert");
                        alert2 = (Alert2) childAt;
                    } else {
                        alert2 = null;
                    }
                    if (alert2 != null && alert2.getWindowToken() != null) {
                        ViewCompat.animate(alert2).alpha(0.0f).withEndAction(new Alerter(alert2));
                    }
                    if (i == childCount) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), name, 0L, 2, null);
    }

    public static /* synthetic */ void enqueue$default(NoticePopup noticePopup, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Drawable drawable, String str2, Drawable drawable2, List list, String str3, Integer num, Drawable drawable3, Integer num2, List list2, Function1 function1, Function1 function12, int i, Object obj) {
        noticePopup.enqueue(str, charSequence, (i & 4) != 0 ? null : charSequence2, charSequence3, (i & 16) != 0 ? null : drawable, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : drawable2, (i & 128) != 0 ? null : list, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : num, (i & 1024) != 0 ? null : drawable3, (i & 2048) != 0 ? 5 : num2, (i & 4096) != 0 ? CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)) : list2, (i & 8192) != 0 ? AnonymousClass1.INSTANCE : function1, function12);
    }

    private final ValueAnimator getAutoDismissAnimator(Integer autoDismissPeriodSecs, Function0<Unit> onEnd) {
        if (autoDismissPeriodSecs == null) {
            return null;
        }
        ValueAnimator valueAnimatorOfInt = ObjectAnimator.ofInt(0, 1);
        NoticePopup7 noticePopup7 = new NoticePopup7(onEnd);
        Intrinsics3.checkNotNullExpressionValue(valueAnimatorOfInt, "animator");
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.setDuration(autoDismissPeriodSecs.intValue() * 1000);
        valueAnimatorOfInt.addListener(noticePopup7);
        valueAnimatorOfInt.start();
        return valueAnimatorOfInt;
    }

    public final void enqueue(String noticeName, CharSequence noticeTitle, CharSequence noticeSubtitle, CharSequence noticeBody, Drawable noticeBodyBackgroundDrawable, String noticeBodyImageUrl, Drawable noticeBodyImageDrawable, List<Sticker> noticeStickers, String noticeIconUrl, Integer noticeIconResId, Drawable noticeIconTopRight, Integer noticeAutoDismissPeriodSecs, List<? extends KClass<? extends AppComponent>> validScreens, Function1<? super View, Unit> onClickTopRightIcon, Function1<? super View, Unit> onClick) {
        Intrinsics3.checkNotNullParameter(noticeName, "noticeName");
        Intrinsics3.checkNotNullParameter(validScreens, "validScreens");
        Intrinsics3.checkNotNullParameter(onClickTopRightIcon, "onClickTopRightIcon");
        Intrinsics3.checkNotNullParameter(onClick, "onClick");
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(noticeName, null, 0L, 1, false, validScreens, 1000L, false, 0L, new NoticePopup4(onClick, noticeName, noticeAutoDismissPeriodSecs, noticeIconUrl, noticeIconResId, noticeBodyImageUrl, noticeBodyImageDrawable, noticeBodyBackgroundDrawable, noticeTitle, noticeSubtitle, noticeBody, noticeIconTopRight, noticeStickers, onClickTopRightIcon), 150, null));
    }
}
