package com.discord.views.sticker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.a.i.StickerViewBinding;
import b.a.k.FormatUtils;
import b.a.y.q0.StickerView2;
import b.a.y.q0.StickerView3;
import b.a.y.q0.StickerView5;
import b.a.y.q0.StickerView6;
import b.a.y.q0.StickerView7;
import b.a.y.q0.StickerView9;
import b.f.g.e.v;
import com.discord.R;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerFormatType;
import com.discord.api.sticker.StickerPartial;
import com.discord.app.AppLog;
import com.discord.rlottie.RLottieImageView;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.apng.ApngUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;

/* compiled from: StickerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/discord/views/sticker/StickerView;", "Landroid/widget/FrameLayout;", "", "onDetachedFromWindow", "()V", "Lcom/discord/api/sticker/BaseSticker;", "sticker", "", "stickerAnimationSettings", "d", "(Lcom/discord/api/sticker/BaseSticker;Ljava/lang/Integer;)V", "b", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "Landroid/view/View$OnClickListener;", "onClickListener", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "", "c", "(Lcom/discord/api/sticker/BaseSticker;)Ljava/lang/CharSequence;", "Lkotlinx/coroutines/Job;", "m", "Lkotlinx/coroutines/Job;", "apngLoadingJob", "Lb/a/i/r1;", "j", "Lb/a/i/r1;", "binding", "l", "Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "k", "Lcom/discord/api/sticker/BaseSticker;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StickerView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final StickerViewBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public BaseSticker sticker;

    /* renamed from: l, reason: from kotlin metadata */
    public Subscription subscription;

    /* renamed from: m, reason: from kotlin metadata */
    public Job apngLoadingJob;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.sticker_view, this);
        int i = R.id.sticker_view_imageview;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.sticker_view_imageview);
        if (simpleDraweeView != null) {
            i = R.id.sticker_view_lottie;
            RLottieImageView rLottieImageView = (RLottieImageView) findViewById(R.id.sticker_view_lottie);
            if (rLottieImageView != null) {
                i = R.id.sticker_view_placeholder;
                ImageView imageView = (ImageView) findViewById(R.id.sticker_view_placeholder);
                if (imageView != null) {
                    StickerViewBinding stickerViewBinding = new StickerViewBinding(this, simpleDraweeView, rLottieImageView, imageView);
                    Intrinsics3.checkNotNullExpressionValue(stickerViewBinding, "StickerViewBinding.infla…ater.from(context), this)");
                    this.binding = stickerViewBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public static final Job a(StickerView stickerView, File file, boolean z2) {
        Objects.requireNonNull(stickerView);
        ApngUtils apngUtils = ApngUtils.INSTANCE;
        SimpleDraweeView simpleDraweeView = stickerView.binding.f191b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        return apngUtils.renderApngFromFile(file, simpleDraweeView, Integer.valueOf(stickerUtils.getDEFAULT_STICKER_SIZE_PX()), Integer.valueOf(stickerUtils.getDEFAULT_STICKER_SIZE_PX()), z2);
    }

    public static /* synthetic */ void e(StickerView stickerView, BaseSticker baseSticker, Integer num, int i) {
        int i2 = i & 2;
        stickerView.d(baseSticker, null);
    }

    public final void b() {
        SimpleDraweeView simpleDraweeView = this.binding.f191b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        simpleDraweeView.setBackground(null);
        RLottieImageView rLottieImageView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
        rLottieImageView.setBackground(null);
    }

    public final CharSequence c(BaseSticker sticker) {
        if (!(sticker instanceof Sticker)) {
            if (!(sticker instanceof StickerPartial)) {
                return null;
            }
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return FormatUtils.h(context, R.string.sticker_a11y_label, new Object[]{((StickerPartial) sticker).getName()}, null, 4);
        }
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        StringBuilder sb = new StringBuilder();
        Sticker sticker2 = (Sticker) sticker;
        sb.append(sticker2.getName());
        sb.append(", ");
        sb.append(sticker2.getDescription());
        return FormatUtils.h(context2, R.string.sticker_a11y_label, new Object[]{sb.toString()}, null, 4);
    }

    public final void d(BaseSticker sticker, Integer stickerAnimationSettings) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        BaseSticker baseSticker = this.sticker;
        if (baseSticker != null && baseSticker.getId() == sticker.getId()) {
            if (this.subscription != null) {
                return;
            }
        }
        BaseSticker baseSticker2 = this.sticker;
        if (baseSticker2 != null && (baseSticker2 == null || baseSticker2.getId() != sticker.getId())) {
            Subscription subscription = this.subscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.subscription = null;
        }
        this.sticker = sticker;
        int iOrdinal = sticker.getFormatType().ordinal();
        if (iOrdinal == 1) {
            SimpleDraweeView simpleDraweeView = this.binding.f191b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
            simpleDraweeView.setVisibility(0);
            ImageView imageView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setVisibility(8);
            RLottieImageView rLottieImageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
            rLottieImageView.setVisibility(8);
            SimpleDraweeView simpleDraweeView2 = this.binding.f191b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.stickerViewImageview");
            simpleDraweeView2.setContentDescription(c(sticker));
            SimpleDraweeView simpleDraweeView3 = this.binding.f191b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.stickerViewImageview");
            MGImages.setImage$default(simpleDraweeView3, StickerUtils.getCDNAssetUrl$default(StickerUtils.INSTANCE, sticker, null, false, 6, null), 0, 0, false, null, null, 124, null);
            SimpleDraweeView simpleDraweeView4 = this.binding.f191b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.stickerViewImageview");
            GenericDraweeHierarchy hierarchy = simpleDraweeView4.getHierarchy();
            Intrinsics3.checkNotNullExpressionValue(hierarchy, "binding.stickerViewImageview.hierarchy");
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
            hierarchy.n(v.l);
            return;
        }
        if (iOrdinal == 2) {
            SimpleDraweeView simpleDraweeView5 = this.binding.f191b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.stickerViewImageview");
            simpleDraweeView5.setVisibility(0);
            ImageView imageView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.stickerViewPlaceholder");
            imageView2.setVisibility(0);
            RLottieImageView rLottieImageView2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(rLottieImageView2, "binding.stickerViewLottie");
            rLottieImageView2.setVisibility(8);
            this.binding.f191b.setImageDrawable(null);
            SimpleDraweeView simpleDraweeView6 = this.binding.f191b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.stickerViewImageview");
            GenericDraweeHierarchy hierarchy2 = simpleDraweeView6.getHierarchy();
            Intrinsics3.checkNotNullExpressionValue(hierarchy2, "binding.stickerViewImageview.hierarchy");
            ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.a;
            hierarchy2.n(v.l);
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            Observable observableJ = Observable.j(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils.fetchSticker(context, sticker), false, 1, null), StoreUserSettings.observeStickerAnimationSettings$default(StoreStream.INSTANCE.getUserSettings(), false, 1, null), StickerView2.j);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…lobalAnimationSettings) }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableJ), StickerView.class, (Context) null, new StickerView3(this), (Function1) null, (Function0) null, (Function0) null, new StickerView5(this, stickerAnimationSettings, sticker), 58, (Object) null);
            return;
        }
        if (iOrdinal != 3) {
            Logger.e$default(AppLog.g, "Invalid Sticker Format passed to " + StickerView.class + ", type: " + sticker.getFormatType(), null, null, 6, null);
            return;
        }
        SimpleDraweeView simpleDraweeView7 = this.binding.f191b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView7, "binding.stickerViewImageview");
        simpleDraweeView7.setVisibility(8);
        ImageView imageView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.stickerViewPlaceholder");
        imageView3.setVisibility(0);
        RLottieImageView rLottieImageView3 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(rLottieImageView3, "binding.stickerViewLottie");
        rLottieImageView3.setVisibility(0);
        this.binding.c.setImageDrawable(null);
        this.binding.c.clearAnimation();
        StickerUtils stickerUtils2 = StickerUtils.INSTANCE;
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        Observable observableJ2 = Observable.j(ObservableExtensionsKt.restSubscribeOn$default(stickerUtils2.fetchSticker(context2, sticker), false, 1, null), StoreUserSettings.observeStickerAnimationSettings$default(StoreStream.INSTANCE.getUserSettings(), false, 1, null), StickerView6.j);
        Intrinsics3.checkNotNullExpressionValue(observableJ2, "Observable.combineLatest…lobalAnimationSettings) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableJ2), StickerView.class, (Context) null, new StickerView7(this), (Function1) null, (Function0) null, (Function0) null, new StickerView9(this, stickerAnimationSettings, sticker), 58, (Object) null);
    }

    public final Subscription getSubscription() {
        return this.subscription;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscription = null;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        BaseSticker baseSticker = this.sticker;
        StickerFormatType formatType = baseSticker != null ? baseSticker.getFormatType() : null;
        if (formatType == null) {
            return;
        }
        int iOrdinal = formatType.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            this.binding.f191b.setOnClickListener(onClickListener);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.binding.c.setOnClickListener(onClickListener);
        }
    }
}
