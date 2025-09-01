package com.discord.widgets.changelog;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChangeLogSpecialBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.Tuples;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.webrtc.MediaStreamTrack;

/* compiled from: WidgetChangeLogSpecial.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006*\u0001.\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0015J\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0015R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u0010\u0018\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/discord/widgets/changelog/WidgetChangeLogSpecial;", "Lcom/discord/app/AppFragment;", "", "videoUrl", "", "configureMedia", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "", "getDateString", "(Landroid/content/Context;)Ljava/lang/CharSequence;", "event", "", "", "properties", "", "includeStats", "track", "(Ljava/lang/String;Ljava/util/Map;Z)V", "showVideoOverlay", "()V", "hideVideoOverlay", "Lcom/discord/databinding/WidgetChangeLogSpecialBinding;", "binding", "onViewBindingDestroy", "(Lcom/discord/databinding/WidgetChangeLogSpecialBinding;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onPause", "onDestroy", "", "openedTimestamp", "J", "", "maxScrolledPercent", "I", "Lcom/facebook/drawee/controller/AbstractDraweeController;", "thumbnailDraweeController", "Lcom/facebook/drawee/controller/AbstractDraweeController;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChangeLogSpecialBinding;", "com/discord/widgets/changelog/WidgetChangeLogSpecial$thumbnailControllerListener$1", "thumbnailControllerListener", "Lcom/discord/widgets/changelog/WidgetChangeLogSpecial$thumbnailControllerListener$1;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChangeLogSpecial extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChangeLogSpecial.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeLogSpecialBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_BODY = "INTENT_EXTRA_BODY";
    private static final String INTENT_EXTRA_EXIT_STYLE = "INTENT_EXTRA_EXIT_STYLE";
    private static final String INTENT_EXTRA_HIDE_VIDEO = "INTENT_EXTRA_HIDE_VIDEO";
    private static final String INTENT_EXTRA_REVISION = "INTENT_EXTRA_REVISION";
    private static final String INTENT_EXTRA_VERSION = "INTENT_EXTRA_VERSION";
    private static final String INTENT_EXTRA_VIDEO = "INTENT_EXTRA_VIDEO";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private int maxScrolledPercent;
    private long openedTimestamp;
    private final WidgetChangeLogSpecial4 thumbnailControllerListener;
    private AbstractDraweeController<Object, Object> thumbnailDraweeController;

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JK\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/changelog/WidgetChangeLogSpecial$Companion;", "", "Landroid/content/Context;", "context", "", "version", "revision", MediaStreamTrack.VIDEO_TRACK_KIND, "body", "Lcom/discord/widgets/changelog/WidgetChangeLogSpecial$Companion$ExitStyle;", "exitStyle", "", "hideVideo", "", "launch", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/discord/widgets/changelog/WidgetChangeLogSpecial$Companion$ExitStyle;Z)V", WidgetChangeLogSpecial.INTENT_EXTRA_BODY, "Ljava/lang/String;", WidgetChangeLogSpecial.INTENT_EXTRA_EXIT_STYLE, WidgetChangeLogSpecial.INTENT_EXTRA_HIDE_VIDEO, WidgetChangeLogSpecial.INTENT_EXTRA_REVISION, WidgetChangeLogSpecial.INTENT_EXTRA_VERSION, WidgetChangeLogSpecial.INTENT_EXTRA_VIDEO, "<init>", "()V", "ExitStyle", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetChangeLogSpecial.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/changelog/WidgetChangeLogSpecial$Companion$ExitStyle;", "", "<init>", "(Ljava/lang/String;I)V", "BACK", "CLOSE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum ExitStyle {
            BACK,
            CLOSE
        }

        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, String str, String str2, String str3, String str4, ExitStyle exitStyle, boolean z2, int i, Object obj) {
            companion.launch(context, str, str2, str3, str4, (i & 32) != 0 ? ExitStyle.CLOSE : exitStyle, (i & 64) != 0 ? false : z2);
        }

        public final void launch(Context context, String version, String revision, String video, String body, ExitStyle exitStyle, boolean hideVideo) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(version, "version");
            Intrinsics3.checkNotNullParameter(revision, "revision");
            Intrinsics3.checkNotNullParameter(video, MediaStreamTrack.VIDEO_TRACK_KIND);
            Intrinsics3.checkNotNullParameter(body, "body");
            Intrinsics3.checkNotNullParameter(exitStyle, "exitStyle");
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetChangeLogSpecial.INTENT_EXTRA_EXIT_STYLE, exitStyle);
            bundle.putString(WidgetChangeLogSpecial.INTENT_EXTRA_VERSION, version);
            bundle.putString(WidgetChangeLogSpecial.INTENT_EXTRA_REVISION, revision);
            bundle.putString(WidgetChangeLogSpecial.INTENT_EXTRA_VIDEO, video);
            bundle.putString(WidgetChangeLogSpecial.INTENT_EXTRA_BODY, body);
            bundle.putBoolean(WidgetChangeLogSpecial.INTENT_EXTRA_HIDE_VIDEO, hideVideo);
            AppScreen2.d(context, WidgetChangeLogSpecial.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "it", "", "onCompletion", "(Landroid/media/MediaPlayer;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$configureMedia$1, reason: invalid class name */
    public static final class AnonymousClass1 implements MediaPlayer.OnCompletionListener {
        public AnonymousClass1() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            WidgetChangeLogSpecial.access$showVideoOverlay(WidgetChangeLogSpecial.this);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$configureMedia$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VideoView videoView = WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i;
            Intrinsics3.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
            if (videoView.isPlaying()) {
                WidgetChangeLogSpecial.access$showVideoOverlay(WidgetChangeLogSpecial.this);
                WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i.pause();
            } else {
                WidgetChangeLogSpecial.access$hideVideoOverlay(WidgetChangeLogSpecial.this);
                WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i.start();
            }
            WidgetChangeLogSpecial.track$default(WidgetChangeLogSpecial.this, "change_log_video_interacted", null, false, 2, null);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/media/MediaPlayer;", "mp", "", "onPrepared", "(Landroid/media/MediaPlayer;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$configureMedia$3, reason: invalid class name */
    public static final class AnonymousClass3 implements MediaPlayer.OnPreparedListener {
        public AnonymousClass3() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            Intrinsics3.checkNotNullParameter(mediaPlayer, "mp");
            mediaPlayer.start();
            mediaPlayer.pause();
            VideoView videoView = WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i;
            Intrinsics3.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
            videoView.getLayoutParams().height = -2;
            WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).i.requestLayout();
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "", "invoke", "(Landroid/view/ViewPropertyAnimator;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$hideVideoOverlay$1, reason: invalid class name */
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

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "url", "<anonymous parameter 2>", "", "invoke", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<Context, String, String, Unit> {
        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(str, "url");
            WidgetChangeLogSpecial.track$default(WidgetChangeLogSpecial.this, "change_log_cta_clicked", MapsJVM.mapOf(Tuples.to("cta_type", "inline_link")), false, 4, null);
            UriHandler.handle$default(UriHandler.INSTANCE, context, str, false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChangeLogSpecial.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChangeLogSpecial.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, WidgetChangeLogSpecial.this.requireContext(), AppHelpDesk.a.a(360056891113L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/core/widget/NestedScrollView;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "scrollY", "<anonymous parameter 3>", "<anonymous parameter 4>", "", "onScrollChange", "(Landroidx/core/widget/NestedScrollView;IIII)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements NestedScrollView.OnScrollChangeListener {
        public AnonymousClass5() {
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            WidgetChangeLogSpecial widgetChangeLogSpecial = WidgetChangeLogSpecial.this;
            int iAccess$getMaxScrolledPercent$p = WidgetChangeLogSpecial.access$getMaxScrolledPercent$p(widgetChangeLogSpecial);
            NestedScrollView nestedScrollView2 = WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).g;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView2, "binding.changeLogSpecialScrollview");
            int height = ViewExtensions.getContentView(nestedScrollView2).getHeight();
            NestedScrollView nestedScrollView3 = WidgetChangeLogSpecial.access$getBinding$p(WidgetChangeLogSpecial.this).g;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView3, "binding.changeLogSpecialScrollview");
            WidgetChangeLogSpecial.access$setMaxScrolledPercent$p(widgetChangeLogSpecial, _Ranges.coerceAtLeast(iAccess$getMaxScrolledPercent$p, (i2 * 100) / _Ranges.coerceAtLeast(height - nestedScrollView3.getHeight(), 1)));
        }
    }

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$showVideoOverlay$1, reason: invalid class name */
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

    /* compiled from: WidgetChangeLogSpecial.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "", "invoke", "(Landroid/view/ViewPropertyAnimator;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$showVideoOverlay$2, reason: invalid class name */
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

    public WidgetChangeLogSpecial() {
        super(R.layout.widget_change_log_special);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetChangeLogSpecial2.INSTANCE, new WidgetChangeLogSpecial3(this));
        this.thumbnailControllerListener = new WidgetChangeLogSpecial4(this);
    }

    public static final /* synthetic */ WidgetChangeLogSpecialBinding access$getBinding$p(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        return widgetChangeLogSpecial.getBinding();
    }

    public static final /* synthetic */ int access$getMaxScrolledPercent$p(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        return widgetChangeLogSpecial.maxScrolledPercent;
    }

    public static final /* synthetic */ void access$hideVideoOverlay(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        widgetChangeLogSpecial.hideVideoOverlay();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetChangeLogSpecial widgetChangeLogSpecial, WidgetChangeLogSpecialBinding widgetChangeLogSpecialBinding) {
        widgetChangeLogSpecial.onViewBindingDestroy(widgetChangeLogSpecialBinding);
    }

    public static final /* synthetic */ void access$setMaxScrolledPercent$p(WidgetChangeLogSpecial widgetChangeLogSpecial, int i) {
        widgetChangeLogSpecial.maxScrolledPercent = i;
    }

    public static final /* synthetic */ void access$showVideoOverlay(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        widgetChangeLogSpecial.showVideoOverlay();
    }

    private final void configureMedia(String videoUrl) throws NumberFormatException {
        boolean zEndsWith$default = StringsJVM.endsWith$default(videoUrl, ".mp4", false, 2, null);
        VideoView videoView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        videoView.setVisibility(zEndsWith$default ? 0 : 8);
        SimpleDraweeView simpleDraweeView = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
        simpleDraweeView.setVisibility(zEndsWith$default ? 0 : 8);
        if (zEndsWith$default) {
            getBinding().i.setVideoPath(videoUrl);
            getBinding().i.setOnCompletionListener(new AnonymousClass1());
            getBinding().i.setOnClickListener(new AnonymousClass2());
            getBinding().i.setOnPreparedListener(new AnonymousClass3());
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.changeLogThumbnail");
        simpleDraweeView2.setVisibility(0);
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
        SimpleDraweeView simpleDraweeView3 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.changeLogThumbnail");
        pipelineDraweeControllerBuilderA.n = simpleDraweeView3.getController();
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderG = pipelineDraweeControllerBuilderA.g(videoUrl);
        pipelineDraweeControllerBuilderG.m = false;
        pipelineDraweeControllerBuilderG.k = this.thumbnailControllerListener;
        this.thumbnailDraweeController = pipelineDraweeControllerBuilderG.a();
        SimpleDraweeView simpleDraweeView4 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.changeLogThumbnail");
        simpleDraweeView4.setController(this.thumbnailDraweeController);
        getBinding().h.requestLayout();
    }

    private final WidgetChangeLogSpecialBinding getBinding() {
        return (WidgetChangeLogSpecialBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getDateString(Context context) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_date);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        try {
            Date date = new SimpleDateFormat(TimeUtils.UTCFormat.SHORT).parse(stringExtra);
            if (date == null) {
                date = new Date();
            }
            return " " + DateFormat.getMediumDateFormat(context).format(date) + " ";
        } catch (ParseException unused) {
            return stringExtra;
        }
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().j, 200L, AnonymousClass1.INSTANCE, null, 4, null);
    }

    public static final void launch(Context context, String str, String str2, String str3, String str4, Companion.ExitStyle exitStyle, boolean z2) {
        INSTANCE.launch(context, str, str2, str3, str4, exitStyle, z2);
    }

    private final void onViewBindingDestroy(WidgetChangeLogSpecialBinding binding) {
        binding.i.setOnPreparedListener(null);
        binding.i.setOnCompletionListener(null);
        AbstractDraweeController<Object, Object> abstractDraweeController = this.thumbnailDraweeController;
        if (abstractDraweeController != null) {
            abstractDraweeController.A(this.thumbnailControllerListener);
        }
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().j, 200L, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, null, 8, null);
    }

    private final void track(String event, Map<String, ? extends Object> properties, boolean includeStats) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_date);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_REVISION);
        if (stringExtra2 == null) {
            stringExtra2 = getString(R.string.change_log_md_revision);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…g.change_log_md_revision)");
        HashMap map = new HashMap();
        if (includeStats) {
            map.put("seconds_open", Long.valueOf((ClockFactory.get().currentTimeMillis() - this.openedTimestamp) / 1000));
            map.put("max_scrolled_percentage", Integer.valueOf(this.maxScrolledPercent));
        }
        AnalyticsTracker.INSTANCE.changeLogEvent(event, stringExtra, stringExtra2, Maps6.plus(properties, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void track$default(WidgetChangeLogSpecial widgetChangeLogSpecial, String str, Map map, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        widgetChangeLogSpecial.track(str, map, z2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VERSION);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_date);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_date)");
        StoreStream.INSTANCE.getChangeLog().markSeen(stringExtra);
        track$default(this, "change_log_closed", null, false, 6, null);
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        VideoView videoView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
        if (videoView.isPlaying()) {
            getBinding().i.pause();
        }
        super.onPause();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) throws NumberFormatException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.openedTimestamp = ClockFactory.get().currentTimeMillis();
        track$default(this, "change_log_opened", null, false, 2, null);
        setActionBarSubtitle(getDateString(requireContext()));
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_BODY);
        if (stringExtra == null) {
            stringExtra = getString(R.string.change_log_md_body);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…tring.change_log_md_body)");
        if (getMostRecentIntent().getSerializableExtra(INTENT_EXTRA_EXIT_STYLE) == Companion.ExitStyle.BACK) {
            ImageButton imageButton = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(imageButton, "binding.changeLogSpecialClose");
            imageButton.setVisibility(8);
            ImageButton imageButton2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(imageButton2, "binding.changeLogSpecialBack");
            imageButton2.setVisibility(0);
        }
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.changeLogSpecialDate");
        textView.setText(getDateString(requireContext()));
        getBinding().f2254b.setDraweeSpanStringBuilder(ChangeLogParser.INSTANCE.parse(requireContext(), stringExtra, true, new AnonymousClass1()));
        String stringExtra2 = getMostRecentIntent().getStringExtra(INTENT_EXTRA_VIDEO);
        if (stringExtra2 == null) {
            stringExtra2 = getString(R.string.change_log_md_video);
        }
        Intrinsics3.checkNotNullExpressionValue(stringExtra2, "mostRecentIntent.getStri…ring.change_log_md_video)");
        configureMedia(stringExtra2);
        getBinding().c.setOnClickListener(new AnonymousClass2());
        getBinding().e.setOnClickListener(new AnonymousClass3());
        LinkifiedTextView linkifiedTextView = getBinding().f2254b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.changeLogBody");
        FormatUtils.n(linkifiedTextView, R.string.changelog_stickers_cta_body, new Object[0], null, 4);
        LinkifiedTextView linkifiedTextView2 = getBinding().f2254b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.changeLogBody");
        linkifiedTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().d.setOnClickListener(new AnonymousClass4());
        if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_HIDE_VIDEO, false)) {
            VideoView videoView = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(videoView, "binding.changeLogVideo");
            videoView.setVisibility(8);
            CardView cardView = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(cardView, "binding.changelogSpecialHeaderContainer");
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, DimenUtils.dpToPixels(16));
        }
        getBinding().g.setOnScrollChangeListener(new AnonymousClass5());
    }
}
