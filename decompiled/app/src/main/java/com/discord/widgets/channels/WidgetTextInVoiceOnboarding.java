package com.discord.widgets.channels;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetTextInVoiceOnboarding.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/channels/WidgetTextInVoiceOnboarding;", "Lcom/discord/app/AppBottomSheet;", "", "videoUrl", "", "configureMedia", "(Ljava/lang/String;)V", "showVideoOverlay", "()V", "hideVideoOverlay", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", "binding", "Lkotlin/Function0;", "onCtaClicked", "Lkotlin/jvm/functions/Function0;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTextInVoiceOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String VIDEO_URL = "https://cdn.discordapp.com/attachments/727325253608538113/942859496601043024/Text_in_Voice_NUX_Mobile_In-App.mp4";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onCtaClicked;

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/channels/WidgetTextInVoiceOnboarding$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function0;", "", "onCtaClicked", "show", "(Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function0;)V", "", "VIDEO_URL", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Function0<Unit> onCtaClicked) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(onCtaClicked, "onCtaClicked");
            WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding = new WidgetTextInVoiceOnboarding();
            WidgetTextInVoiceOnboarding.access$setOnCtaClicked$p(widgetTextInVoiceOnboarding, onCtaClicked);
            widgetTextInVoiceOnboarding.show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = WidgetTextInVoiceOnboarding.this.getView();
            Integer numValueOf = view != null ? Integer.valueOf(view.getMeasuredHeight()) : null;
            Dialog dialog = WidgetTextInVoiceOnboarding.this.getDialog();
            View viewFindViewById = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
            ViewGroup.LayoutParams layoutParams = viewFindViewById != null ? viewFindViewById.getLayoutParams() : null;
            if (numValueOf == null || numValueOf.intValue() <= 0) {
                return;
            }
            if (layoutParams != null) {
                layoutParams.height = numValueOf.intValue() + 1;
            }
            if (viewFindViewById != null) {
                viewFindViewById.setLayoutParams(layoutParams);
            }
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d;
            Intrinsics3.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
            if (videoView.isPlaying()) {
                WidgetTextInVoiceOnboarding.access$showVideoOverlay(WidgetTextInVoiceOnboarding.this);
                WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d.pause();
            } else {
                WidgetTextInVoiceOnboarding.access$hideVideoOverlay(WidgetTextInVoiceOnboarding.this);
                WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d.start();
            }
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/media/MediaPlayer;", "mp", "", "onPrepared", "(Landroid/media/MediaPlayer;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$3, reason: invalid class name */
    public static final class AnonymousClass3 implements MediaPlayer.OnPreparedListener {
        public AnonymousClass3() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            Intrinsics3.checkNotNullParameter(mediaPlayer, "mp");
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d;
            Intrinsics3.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
            videoView.getLayoutParams().height = -2;
            WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d.requestLayout();
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "i", "<anonymous parameter 2>", "", "onInfo", "(Landroid/media/MediaPlayer;II)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$4, reason: invalid class name */
    public static final class AnonymousClass4 implements MediaPlayer.OnInfoListener {
        public AnonymousClass4() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i != 3) {
                return false;
            }
            ImageView imageView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).g;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.textInVoiceOnboardingVideoPlaceholder");
            imageView.setVisibility(4);
            VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d;
            Intrinsics3.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
            videoView.getLayoutParams().height = -2;
            WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d.requestLayout();
            return false;
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "", "invoke", "(Landroid/view/ViewPropertyAnimator;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$hideVideoOverlay$1, reason: invalid class name */
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
            viewPropertyAnimator.scaleX(2.0f);
            viewPropertyAnimator.scaleY(2.0f);
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextInVoiceOnboarding.this.dismiss();
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnCtaClicked$p = WidgetTextInVoiceOnboarding.access$getOnCtaClicked$p(WidgetTextInVoiceOnboarding.this);
            if (function0Access$getOnCtaClicked$p != null) {
            }
            WidgetTextInVoiceOnboarding.this.dismiss();
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$1, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(view, "view");
            view.setScaleX(2.0f);
            view.setScaleY(2.0f);
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "", "invoke", "(Landroid/view/ViewPropertyAnimator;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$2, reason: invalid class name */
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
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    public WidgetTextInVoiceOnboarding() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTextInVoiceOnboarding2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetTextInVoiceOnboardingBinding access$getBinding$p(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        return widgetTextInVoiceOnboarding.getBinding();
    }

    public static final /* synthetic */ Function0 access$getOnCtaClicked$p(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        return widgetTextInVoiceOnboarding.onCtaClicked;
    }

    public static final /* synthetic */ void access$hideVideoOverlay(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        widgetTextInVoiceOnboarding.hideVideoOverlay();
    }

    public static final /* synthetic */ void access$setOnCtaClicked$p(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding, Function0 function0) {
        widgetTextInVoiceOnboarding.onCtaClicked = function0;
    }

    public static final /* synthetic */ void access$showVideoOverlay(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        widgetTextInVoiceOnboarding.showVideoOverlay();
    }

    private final void configureMedia(String videoUrl) {
        View view = getView();
        if (view != null) {
            view.post(new AnonymousClass1());
        }
        FrameLayout frameLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.textInVoiceOnboardingVideoContainer");
        frameLayout.setClipToOutline(true);
        getBinding().d.setVideoPath(videoUrl);
        hideVideoOverlay();
        getBinding().d.setOnClickListener(new AnonymousClass2());
        getBinding().d.setOnPreparedListener(new AnonymousClass3());
        getBinding().d.setOnInfoListener(new AnonymousClass4());
    }

    private final WidgetTextInVoiceOnboardingBinding getBinding() {
        return (WidgetTextInVoiceOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().f, 200L, AnonymousClass1.INSTANCE, null, 4, null);
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().f, 200L, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, null, 8, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_text_in_voice_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        new TextInVoiceOnboardingManager().markSeen();
        getBinding().f2666b.setOnClickListener(new AnonymousClass1());
        getBinding().c.setOnClickListener(new AnonymousClass2());
        configureMedia(VIDEO_URL);
    }
}
