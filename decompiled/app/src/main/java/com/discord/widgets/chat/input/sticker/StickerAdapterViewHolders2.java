package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.databinding.StickerPickerStickerItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rlottie.RLottieImageView;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: StickerAdapterViewHolders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B1\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/input/sticker/WidgetStickerAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "data", "", "configureSticker", "(Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "cancelLoading", "()V", "type", "I", "getType", "()I", "Lrx/subjects/BehaviorSubject;", "", "recyclerScrollingWithinThresholdSubject", "Lrx/subjects/BehaviorSubject;", "getRecyclerScrollingWithinThresholdSubject", "()Lrx/subjects/BehaviorSubject;", "Lcom/discord/app/AppComponent;", "appComponent", "Lcom/discord/app/AppComponent;", "getAppComponent", "()Lcom/discord/app/AppComponent;", "Lcom/discord/databinding/StickerPickerStickerItemBinding;", "binding", "Lcom/discord/databinding/StickerPickerStickerItemBinding;", "scrollingSpeedSubscription", "Lrx/Subscription;", "adapter", "<init>", "(ILcom/discord/widgets/chat/input/sticker/WidgetStickerAdapter;Lrx/subjects/BehaviorSubject;Lcom/discord/app/AppComponent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerAdapterViewHolders2 extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> {
    private final AppComponent appComponent;
    private final StickerPickerStickerItemBinding binding;
    private final BehaviorSubject<Boolean> recyclerScrollingWithinThresholdSubject;
    private Subscription scrollingSpeedSubscription;
    private final int type;

    /* compiled from: StickerAdapterViewHolders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$configureSticker$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ MGRecyclerDataPayload $data;

        public AnonymousClass1(MGRecyclerDataPayload mGRecyclerDataPayload) {
            this.$data = mGRecyclerDataPayload;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StickerAdapterViewHolders2.access$getAdapter$p(StickerAdapterViewHolders2.this).getOnStickerItemSelected().invoke(this.$data);
            try {
                StickerAdapterViewHolders2.access$getBinding$p(StickerAdapterViewHolders2.this).f2153b.performHapticFeedback(3);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: StickerAdapterViewHolders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "scrollingWithinThreshold", "", "invoke", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MGRecyclerDataPayload $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MGRecyclerDataPayload mGRecyclerDataPayload) {
            super(1);
            this.$data = mGRecyclerDataPayload;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "scrollingWithinThreshold");
            if (bool.booleanValue()) {
                StickerAdapterViewHolders2.access$configureSticker(StickerAdapterViewHolders2.this, this.$data);
                Subscription subscriptionAccess$getScrollingSpeedSubscription$p = StickerAdapterViewHolders2.access$getScrollingSpeedSubscription$p(StickerAdapterViewHolders2.this);
                if (subscriptionAccess$getScrollingSpeedSubscription$p != null) {
                    subscriptionAccess$getScrollingSpeedSubscription$p.unsubscribe();
                }
                StickerAdapterViewHolders2.access$setScrollingSpeedSubscription$p(StickerAdapterViewHolders2.this, null);
            }
        }
    }

    /* compiled from: StickerAdapterViewHolders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StickerAdapterViewHolders2.access$setScrollingSpeedSubscription$p(StickerAdapterViewHolders2.this, subscription);
        }
    }

    public /* synthetic */ StickerAdapterViewHolders2(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject behaviorSubject, AppComponent appComponent, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, widgetStickerAdapter, (i2 & 4) != 0 ? null : behaviorSubject, appComponent);
    }

    public static final /* synthetic */ void access$configureSticker(StickerAdapterViewHolders2 stickerAdapterViewHolders2, MGRecyclerDataPayload mGRecyclerDataPayload) {
        stickerAdapterViewHolders2.configureSticker(mGRecyclerDataPayload);
    }

    public static final /* synthetic */ WidgetStickerAdapter access$getAdapter$p(StickerAdapterViewHolders2 stickerAdapterViewHolders2) {
        return (WidgetStickerAdapter) stickerAdapterViewHolders2.adapter;
    }

    public static final /* synthetic */ StickerPickerStickerItemBinding access$getBinding$p(StickerAdapterViewHolders2 stickerAdapterViewHolders2) {
        return stickerAdapterViewHolders2.binding;
    }

    public static final /* synthetic */ Subscription access$getScrollingSpeedSubscription$p(StickerAdapterViewHolders2 stickerAdapterViewHolders2) {
        return stickerAdapterViewHolders2.scrollingSpeedSubscription;
    }

    public static final /* synthetic */ void access$setScrollingSpeedSubscription$p(StickerAdapterViewHolders2 stickerAdapterViewHolders2, Subscription subscription) {
        stickerAdapterViewHolders2.scrollingSpeedSubscription = subscription;
    }

    private final void configureSticker(MGRecyclerDataPayload data) {
        Sticker sticker;
        StickerAdapterItems3 stickerAdapterItems3 = (StickerAdapterItems3) (!(data instanceof StickerAdapterItems3) ? null : data);
        if (stickerAdapterItems3 == null || (sticker = stickerAdapterItems3.getSticker()) == null) {
            return;
        }
        this.binding.f2153b.d(sticker, 0);
        StickerView stickerView = this.binding.f2153b;
        Intrinsics3.checkNotNullExpressionValue(stickerView, "binding.stickerPickerSticker");
        stickerView.setAlpha(((StickerAdapterItems3) data).getSendability() == StickerUtils.StickerSendability.SENDABLE ? 1.0f : 0.25f);
        this.binding.f2153b.setOnClickListener(new AnonymousClass1(data));
    }

    public final void cancelLoading() {
        StickerView stickerView = this.binding.f2153b;
        Job job = stickerView.apngLoadingJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        stickerView.binding.c.clearAnimation();
        Subscription subscription = this.scrollingSpeedSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.scrollingSpeedSubscription = null;
    }

    public final AppComponent getAppComponent() {
        return this.appComponent;
    }

    public final BehaviorSubject<Boolean> getRecyclerScrollingWithinThresholdSubject() {
        return this.recyclerScrollingWithinThresholdSubject;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f2153b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAdapterViewHolders2(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject<Boolean> behaviorSubject, AppComponent appComponent) {
        super(R.layout.sticker_picker_sticker_item, widgetStickerAdapter);
        Intrinsics3.checkNotNullParameter(widgetStickerAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        this.type = i;
        this.recyclerScrollingWithinThresholdSubject = behaviorSubject;
        this.appComponent = appComponent;
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(R.id.sticker_picker_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.sticker_picker_sticker)));
        }
        StickerPickerStickerItemBinding stickerPickerStickerItemBinding = new StickerPickerStickerItemBinding((FrameLayout) view, stickerView);
        Intrinsics3.checkNotNullExpressionValue(stickerPickerStickerItemBinding, "StickerPickerStickerItemBinding.bind(itemView)");
        this.binding = stickerPickerStickerItemBinding;
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        if (this.recyclerScrollingWithinThresholdSubject == null) {
            configureSticker(data);
            return;
        }
        StickerView stickerView = this.binding.f2153b;
        RLottieImageView rLottieImageView = stickerView.binding.c;
        Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
        rLottieImageView.setVisibility(8);
        SimpleDraweeView simpleDraweeView = stickerView.binding.f191b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        simpleDraweeView.setVisibility(8);
        stickerView.binding.f191b.setImageDrawable(null);
        ImageView imageView = stickerView.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
        imageView.setVisibility(0);
        Observable<Boolean> observableR = this.recyclerScrollingWithinThresholdSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "recyclerScrollingWithinT…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this.appComponent, null, 2, null), StickerAdapterViewHolders2.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(data), 58, (Object) null);
    }
}
