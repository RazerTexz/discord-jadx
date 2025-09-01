package com.discord.views.calls;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.DisplayCutoutCompat;
import b.a.i.ViewVideoCallParticipantBinding;
import b.a.k.FormatUtils;
import b.a.y.j0.VideoCallParticipantView2;
import b.a.y.j0.VideoCallParticipantView3;
import b.a.y.j0.VideoCallParticipantView4;
import b.a.y.j0.VideoCallParticipantView5;
import b.a.y.j0.VideoCallParticipantView6;
import b.a.y.j0.VideoCallParticipantView7;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.grid.FrameGridLayout;
import com.discord.views.VoiceUserView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import defpackage.r;
import defpackage.t;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.RendererCommon;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: VideoCallParticipantView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u00012\u00020\u0002:\u0003PQRJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJC\u0010\u0015\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001a\u001a\u00020\b2\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0018\u0012\u0004\u0012\u00020\b0\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b \u0010!R&\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0018\u0012\u0004\u0012\u00020\b0\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010(R.\u00106\u001a\u001a\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\b00j\u0002`38\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010(R\u0018\u0010A\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00109R.\u0010C\u001a\u001a\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\b00j\u0002`38\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00105R$\u0010\u0007\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010\u001eR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010,R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010(¨\u0006S"}, d2 = {"Lcom/discord/views/calls/VideoCallParticipantView;", "Lcom/discord/utilities/view/grid/FrameGridLayout$DataView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getDataId", "()Ljava/lang/String;", "Lcom/discord/utilities/view/grid/FrameGridLayout$Data;", "data", "", "onBind", "(Lcom/discord/utilities/view/grid/FrameGridLayout$Data;)V", "onDetachedFromWindow", "()V", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "Landroidx/core/view/DisplayCutoutCompat;", "displayCutout", "", "canOverlapTopCutout", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$CallUiInsets;", "callUiInsets", "controlsVisible", "c", "(Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;Landroidx/core/view/DisplayCutoutCompat;ZLcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$CallUiInsets;Z)V", "Lkotlin/Function1;", "Lcom/discord/primitives/StreamKey;", "onWatchStreamClicked", "setOnWatchStreamClicked", "(Lkotlin/jvm/functions/Function1;)V", "participantData", "a", "(Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;)V", "visible", "b", "(Z)V", "n", "Lkotlin/jvm/functions/Function1;", "m", "Ljava/lang/String;", "userAvatarUrl", "k", "Z", "matchVideoOrientation", "Lrx/Subscription;", "q", "Lrx/Subscription;", "frameRenderedSubscription", "p", "animateLabelFades", "Lkotlin/Function2;", "Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;", "Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;", "Lcom/discord/views/calls/StreamQualityCallback;", "x", "Lkotlin/jvm/functions/Function2;", "onStreamQualityIndicatorClicked", "Landroid/graphics/drawable/Drawable;", "w", "Landroid/graphics/drawable/Drawable;", "liveSplitPillBg", "Lb/a/i/h4;", "j", "Lb/a/i/h4;", "binding", "s", "v", "livePillBg", "y", "onStreamQualityIndicatorShown", "l", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "getData", "()Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "setData", "t", "Lcom/discord/widgets/voice/fullscreen/grid/VideoCallGridAdapter$CallUiInsets;", "r", "Landroidx/core/view/DisplayCutoutCompat;", "o", "representativeColorSubscription", "u", "ParticipantData", "StreamFps", "StreamResolution", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VideoCallParticipantView extends ConstraintLayout implements FrameGridLayout.DataView {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewVideoCallParticipantBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public final boolean matchVideoOrientation;

    /* renamed from: l, reason: from kotlin metadata */
    public ParticipantData data;

    /* renamed from: m, reason: from kotlin metadata */
    public String userAvatarUrl;

    /* renamed from: n, reason: from kotlin metadata */
    public Function1<? super String, Unit> onWatchStreamClicked;

    /* renamed from: o, reason: from kotlin metadata */
    public Subscription representativeColorSubscription;

    /* renamed from: p, reason: from kotlin metadata */
    public boolean animateLabelFades;

    /* renamed from: q, reason: from kotlin metadata */
    public Subscription frameRenderedSubscription;

    /* renamed from: r, reason: from kotlin metadata */
    public DisplayCutoutCompat displayCutout;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean canOverlapTopCutout;

    /* renamed from: t, reason: from kotlin metadata */
    public VideoCallGridAdapter.CallUiInsets callUiInsets;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean controlsVisible;

    /* renamed from: v, reason: from kotlin metadata */
    public Drawable livePillBg;

    /* renamed from: w, reason: from kotlin metadata */
    public Drawable liveSplitPillBg;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public Function2<? super StreamResolution, ? super StreamFps, Unit> onStreamQualityIndicatorClicked;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public Function2<? super StreamResolution, ? super StreamFps, Unit> onStreamQualityIndicatorShown;

    /* compiled from: VideoCallParticipantView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/discord/views/calls/VideoCallParticipantView$StreamFps;", "", "", "a", "()Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getFps", "fps", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StreamFps {

        /* renamed from: a, reason: from kotlin metadata */
        public final int fps;

        public StreamFps(int i) {
            this.fps = i;
        }

        public final boolean a() {
            return this.fps == 60;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StreamFps) && this.fps == ((StreamFps) other).fps;
            }
            return true;
        }

        /* renamed from: hashCode, reason: from getter */
        public int getFps() {
            return this.fps;
        }

        public String toString() {
            return outline.B(outline.U("StreamFps(fps="), this.fps, ")");
        }
    }

    /* compiled from: VideoCallParticipantView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\bB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution;", "", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)Ljava/lang/CharSequence;", "", "b", "()Z", "<init>", "()V", "Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution$b;", "Lcom/discord/views/calls/VideoCallParticipantView$StreamResolution$a;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StreamResolution {

        /* compiled from: VideoCallParticipantView.kt */
        public static final class a extends StreamResolution {
            public final int a;

            public a(int i) {
                super(null);
                this.a = i;
            }

            @Override // com.discord.views.calls.VideoCallParticipantView.StreamResolution
            public CharSequence a(Context context) {
                Intrinsics3.checkNotNullParameter(context, "context");
                return FormatUtils.h(context, R.string.screenshare_resolution_abbreviated, new Object[]{Integer.valueOf(this.a)}, null, 4);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && this.a == ((a) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return this.a;
            }

            public String toString() {
                return outline.B(outline.U("Fixed(heightPx="), this.a, ")");
            }
        }

        /* compiled from: VideoCallParticipantView.kt */
        public static final class b extends StreamResolution {
            public static final b a = new b();

            public b() {
                super(null);
            }

            @Override // com.discord.views.calls.VideoCallParticipantView.StreamResolution
            public CharSequence a(Context context) {
                Intrinsics3.checkNotNullParameter(context, "context");
                return FormatUtils.h(context, R.string.screenshare_source, new Object[0], null, 4);
            }
        }

        public StreamResolution() {
        }

        public abstract CharSequence a(Context context);

        public final boolean b() {
            return (this instanceof b) || ((this instanceof a) && ((a) this).a == 1080);
        }

        public StreamResolution(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: VideoCallParticipantView.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ParticipantData.a k;

        public a(ParticipantData.a aVar) {
            this.k = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function2<? super StreamResolution, ? super StreamFps, Unit> function2 = VideoCallParticipantView.this.onStreamQualityIndicatorClicked;
            ParticipantData.a aVar = this.k;
            function2.invoke(aVar.f2841b, aVar.c);
        }
    }

    public VideoCallParticipantView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VideoCallParticipantView(Context context, AttributeSet attributeSet, int i, int i2) {
        AppVideoStreamRenderer appVideoStreamRenderer;
        boolean z2;
        AttributeSet attributeSet2 = (i2 & 2) != 0 ? null : attributeSet;
        int i3 = (i2 & 4) != 0 ? 0 : i;
        Intrinsics3.checkNotNullParameter(context, "context");
        super(context, attributeSet2, i3);
        LayoutInflater.from(context).inflate(R.layout.view_video_call_participant, this);
        int i4 = R.id.participant_bg_avatar;
        View viewFindViewById = findViewById(R.id.participant_bg_avatar);
        if (viewFindViewById != null) {
            i4 = R.id.participant_bg_letterbox;
            View viewFindViewById2 = findViewById(R.id.participant_bg_letterbox);
            if (viewFindViewById2 != null) {
                i4 = R.id.participant_deafen_status_indicator;
                ImageView imageView = (ImageView) findViewById(R.id.participant_deafen_status_indicator);
                if (imageView != null) {
                    i4 = R.id.participant_fullscreen_streamqual_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.participant_fullscreen_streamqual_container);
                    if (constraintLayout != null) {
                        i4 = R.id.participant_fullscreen_streamqual_divider;
                        Space space = (Space) findViewById(R.id.participant_fullscreen_streamqual_divider);
                        if (space != null) {
                            i4 = R.id.participant_fullscreen_streamqual_icon;
                            ImageView imageView2 = (ImageView) findViewById(R.id.participant_fullscreen_streamqual_icon);
                            if (imageView2 != null) {
                                i4 = R.id.participant_fullscreen_streamqual_info;
                                TextView textView = (TextView) findViewById(R.id.participant_fullscreen_streamqual_info);
                                if (textView != null) {
                                    i4 = R.id.participant_fullscreen_streamqual_info_container;
                                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.participant_fullscreen_streamqual_info_container);
                                    if (linearLayout != null) {
                                        i4 = R.id.participant_fullscreen_streamqual_live_indicator;
                                        TextView textView2 = (TextView) findViewById(R.id.participant_fullscreen_streamqual_live_indicator);
                                        if (textView2 != null) {
                                            i4 = R.id.participant_live_indicator;
                                            TextView textView3 = (TextView) findViewById(R.id.participant_live_indicator);
                                            if (textView3 != null) {
                                                i4 = R.id.participant_mute_status_indicator;
                                                ImageView imageView3 = (ImageView) findViewById(R.id.participant_mute_status_indicator);
                                                if (imageView3 != null) {
                                                    i4 = R.id.participant_stream_ended;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.participant_stream_ended);
                                                    if (constraintLayout2 != null) {
                                                        i4 = R.id.participant_stream_ended_img;
                                                        ImageView imageView4 = (ImageView) findViewById(R.id.participant_stream_ended_img);
                                                        if (imageView4 != null) {
                                                            i4 = R.id.participant_stream_ended_label;
                                                            TextView textView4 = (TextView) findViewById(R.id.participant_stream_ended_label);
                                                            if (textView4 != null) {
                                                                i4 = R.id.participant_stream_paused;
                                                                TextView textView5 = (TextView) findViewById(R.id.participant_stream_paused);
                                                                if (textView5 != null) {
                                                                    i4 = R.id.participant_stream_preview_image;
                                                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.participant_stream_preview_image);
                                                                    if (simpleDraweeView != null) {
                                                                        i4 = R.id.participant_stream_preview_text;
                                                                        TextView textView6 = (TextView) findViewById(R.id.participant_stream_preview_text);
                                                                        if (textView6 != null) {
                                                                            i4 = R.id.participant_video_label;
                                                                            TextView textView7 = (TextView) findViewById(R.id.participant_video_label);
                                                                            if (textView7 != null) {
                                                                                i4 = R.id.participant_video_loading_indicator;
                                                                                ProgressBar progressBar = (ProgressBar) findViewById(R.id.participant_video_loading_indicator);
                                                                                if (progressBar != null) {
                                                                                    i4 = R.id.participant_video_stream_renderer;
                                                                                    AppVideoStreamRenderer appVideoStreamRenderer2 = (AppVideoStreamRenderer) findViewById(R.id.participant_video_stream_renderer);
                                                                                    if (appVideoStreamRenderer2 != null) {
                                                                                        i4 = R.id.participant_voice_indicators;
                                                                                        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.participant_voice_indicators);
                                                                                        if (linearLayout2 != null) {
                                                                                            i4 = R.id.participant_voice_user_view;
                                                                                            VoiceUserView voiceUserView = (VoiceUserView) findViewById(R.id.participant_voice_user_view);
                                                                                            if (voiceUserView != null) {
                                                                                                AttributeSet attributeSet3 = attributeSet2;
                                                                                                ViewVideoCallParticipantBinding viewVideoCallParticipantBinding = new ViewVideoCallParticipantBinding(this, viewFindViewById, viewFindViewById2, imageView, constraintLayout, space, imageView2, textView, linearLayout, textView2, textView3, imageView3, constraintLayout2, imageView4, textView4, textView5, simpleDraweeView, textView6, textView7, progressBar, appVideoStreamRenderer2, linearLayout2, voiceUserView);
                                                                                                Intrinsics3.checkNotNullExpressionValue(viewVideoCallParticipantBinding, "ViewVideoCallParticipant…ater.from(context), this)");
                                                                                                this.binding = viewVideoCallParticipantBinding;
                                                                                                this.onWatchStreamClicked = VideoCallParticipantView2.j;
                                                                                                this.callUiInsets = new VideoCallGridAdapter.CallUiInsets(0, 0, 0, 0);
                                                                                                this.livePillBg = ContextCompat.getDrawable(context, R.drawable.bg_stream_live_indicator);
                                                                                                this.liveSplitPillBg = ContextCompat.getDrawable(context, R.drawable.bg_stream_live_indicator_split_pill);
                                                                                                this.onStreamQualityIndicatorClicked = t.j;
                                                                                                this.onStreamQualityIndicatorShown = t.k;
                                                                                                if (attributeSet3 != null) {
                                                                                                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet3, R.a.VideoCallParticipantView, 0, 0);
                                                                                                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…            0\n          )");
                                                                                                    z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
                                                                                                    this.matchVideoOrientation = typedArrayObtainStyledAttributes.getBoolean(1, false);
                                                                                                    typedArrayObtainStyledAttributes.recycle();
                                                                                                    appVideoStreamRenderer = appVideoStreamRenderer2;
                                                                                                } else {
                                                                                                    this.matchVideoOrientation = false;
                                                                                                    appVideoStreamRenderer = appVideoStreamRenderer2;
                                                                                                    z2 = false;
                                                                                                }
                                                                                                appVideoStreamRenderer.setIsOverlay(z2);
                                                                                                appVideoStreamRenderer.setMatchVideoOrientation(this.matchVideoOrientation);
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i4)));
    }

    public static /* synthetic */ void d(VideoCallParticipantView videoCallParticipantView, ParticipantData participantData, DisplayCutoutCompat displayCutoutCompat, boolean z2, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean z3, int i) {
        DisplayCutoutCompat displayCutoutCompat2 = (i & 2) != 0 ? videoCallParticipantView.displayCutout : null;
        if ((i & 4) != 0) {
            z2 = videoCallParticipantView.canOverlapTopCutout;
        }
        boolean z4 = z2;
        VideoCallGridAdapter.CallUiInsets callUiInsets2 = (i & 8) != 0 ? videoCallParticipantView.callUiInsets : null;
        if ((i & 16) != 0) {
            z3 = videoCallParticipantView.controlsVisible;
        }
        videoCallParticipantView.c(participantData, displayCutoutCompat2, z4, callUiInsets2, z3);
    }

    public final void a(ParticipantData participantData) {
        CharSequence charSequenceH;
        ParticipantData.a aVar = participantData.streamQualityIndicatorData;
        if (!participantData.isFocused || !this.controlsVisible || aVar == null) {
            b(false);
            return;
        }
        ConstraintLayout constraintLayout = this.binding.e;
        constraintLayout.setTranslationX(-this.callUiInsets.getRight());
        constraintLayout.setTranslationY(this.callUiInsets.getTop());
        constraintLayout.setOnClickListener(new a(aVar));
        ImageView imageView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.participantFullscreenStreamqualIcon");
        imageView.setVisibility(aVar.a ? 0 : 8);
        StreamResolution streamResolution = aVar.f2841b;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence charSequenceA = streamResolution.a(context);
        StreamFps streamFps = aVar.c;
        if (streamFps != null) {
            Context context2 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "context");
            Intrinsics3.checkNotNullParameter(context2, "context");
            charSequenceH = FormatUtils.h(context2, R.string.screenshare_fps_abbreviated, new Object[]{Integer.valueOf(streamFps.fps)}, null, 4);
        } else {
            charSequenceH = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequenceA);
        sb.append(' ');
        sb.append(charSequenceH);
        String string = sb.toString();
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        String string2 = Strings4.trim(string).toString();
        Drawable drawable = (!(string2.length() == 0) || aVar.a) ? this.liveSplitPillBg : this.livePillBg;
        TextView textView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.participantFulls…enStreamqualLiveIndicator");
        textView.setBackground(drawable);
        int i = aVar.d ? R.color.primary_300 : R.color.white;
        TextView textView2 = this.binding.g;
        textView2.setText(string2);
        CharSequence text = textView2.getText();
        Intrinsics3.checkNotNullExpressionValue(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        textView2.setVisibility(text.length() > 0 ? 0 : 8);
        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), i));
        textView2.requestLayout();
        this.onStreamQualityIndicatorShown.invoke(aVar.f2841b, aVar.c);
        b(true);
    }

    public final void b(boolean visible) {
        ViewExtensions.fadeBy(this.binding.e, visible, 200L);
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x047e  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(ParticipantData data, DisplayCutoutCompat displayCutout, boolean canOverlapTopCutout, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean controlsVisible) {
        ParticipantData.Type type;
        boolean z2;
        Integer num;
        boolean z3;
        int i;
        Intrinsics3.checkNotNullParameter(callUiInsets, "callUiInsets");
        this.displayCutout = displayCutout;
        this.canOverlapTopCutout = canOverlapTopCutout;
        this.callUiInsets = callUiInsets;
        this.controlsVisible = controlsVisible;
        StoreVoiceParticipants.VoiceUser voiceUser = data != null ? data.voiceParticipant : null;
        if (voiceUser != null) {
            String colorId = RepresentativeColors2.getColorId(voiceUser.getUser());
            this.binding.f128s.setOnBitmapLoadedListener(new VideoCallParticipantView3(colorId));
            this.binding.f128s.a(voiceUser, R.dimen.avatar_size_hero);
            Subscription subscription = this.representativeColorSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Integer> observableB0 = RepresentativeColors2.getUserRepresentativeColors().observeRepresentativeColor(colorId).b0(VideoCallParticipantView4.j);
            Intrinsics3.checkNotNullExpressionValue(observableB0, "UserRepresentativeColors….takeUntil { it != null }");
            ObservableExtensionsKt.appSubscribe$default(observableB0, VideoCallParticipantView.class, (Context) null, new r(1, this), (Function1) null, (Function0) null, (Function0) null, new VideoCallParticipantView5(this), 58, (Object) null);
        }
        String forUser$default = IconUtils.getForUser$default(voiceUser != null ? voiceUser.getUser() : null, false, null, 6, null);
        if (!Intrinsics3.areEqual(forUser$default, this.userAvatarUrl)) {
            this.userAvatarUrl = forUser$default;
        }
        ParticipantData participantData = this.data;
        if (participantData == null || (type = participantData.type) == null) {
            type = ParticipantData.Type.DEFAULT;
        }
        boolean z4 = participantData != null && participantData.isFocused;
        Integer numB = participantData != null ? participantData.b() : null;
        this.data = data;
        Integer numB2 = data != null ? data.b() : null;
        Integer numB3 = data != null ? data.b() : null;
        if (!Intrinsics3.areEqual(numB3, numB)) {
            if (numB3 != null) {
                AppVideoStreamRenderer appVideoStreamRenderer = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer.setVisibility(8);
                View view = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(view, "binding.participantBgLetterbox");
                SimpleDraweeView simpleDraweeView = this.binding.m;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.participantStreamPreviewImage");
                view.setVisibility((simpleDraweeView.getVisibility() == 0) ^ true ? 0 : 8);
                ProgressBar progressBar = this.binding.p;
                Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.participantVideoLoadingIndicator");
                progressBar.setVisibility(0);
            } else {
                AppVideoStreamRenderer appVideoStreamRenderer2 = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer2, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer2.setVisibility(8);
                View view2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(view2, "binding.participantBgLetterbox");
                view2.setVisibility(8);
                ProgressBar progressBar2 = this.binding.p;
                Intrinsics3.checkNotNullExpressionValue(progressBar2, "binding.participantVideoLoadingIndicator");
                progressBar2.setVisibility(8);
            }
        }
        boolean z5 = z4;
        ParticipantData.Type type2 = type;
        Integer num2 = numB2;
        if ((data != null ? data.type : null) == ParticipantData.Type.APPLICATION_STREAMING) {
            View view3 = this.binding.f127b;
            Intrinsics3.checkNotNullExpressionValue(view3, "binding.participantBgAvatar");
            view3.setVisibility(8);
            VoiceUserView voiceUserView = this.binding.f128s;
            Intrinsics3.checkNotNullExpressionValue(voiceUserView, "binding.participantVoiceUserView");
            voiceUserView.setVisibility(8);
            ImageView imageView = this.binding.j;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.participantMuteStatusIndicator");
            imageView.setVisibility(8);
            ImageView imageView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.participantDeafenStatusIndicator");
            imageView2.setVisibility(8);
            ParticipantData.ApplicationStreamState applicationStreamState = data.applicationStreamState;
            if (applicationStreamState != null) {
                int iOrdinal = applicationStreamState.ordinal();
                if (iOrdinal == 0) {
                    ProgressBar progressBar3 = this.binding.p;
                    Intrinsics3.checkNotNullExpressionValue(progressBar3, "binding.participantVideoLoadingIndicator");
                    progressBar3.setVisibility(0);
                    TextView textView = this.binding.l;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.participantStreamPaused");
                    textView.setVisibility(8);
                    ConstraintLayout constraintLayout = this.binding.k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.participantStreamEnded");
                    constraintLayout.setVisibility(8);
                    SimpleDraweeView simpleDraweeView2 = this.binding.m;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.participantStreamPreviewImage");
                    simpleDraweeView2.setVisibility(0);
                    TextView textView2 = this.binding.n;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.participantStreamPreviewText");
                    textView2.setVisibility(8);
                    TextView textView3 = this.binding.i;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.participantLiveIndicator");
                    textView3.setVisibility(data.isFocused ^ true ? 0 : 8);
                    b(false);
                } else if (iOrdinal == 1) {
                    TextView textView4 = this.binding.n;
                    Intrinsics3.checkNotNullExpressionValue(textView4, "binding.participantStreamPreviewText");
                    textView4.setVisibility(8);
                    TextView textView5 = this.binding.l;
                    Intrinsics3.checkNotNullExpressionValue(textView5, "binding.participantStreamPaused");
                    textView5.setVisibility(8);
                    ConstraintLayout constraintLayout2 = this.binding.k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.participantStreamEnded");
                    constraintLayout2.setVisibility(8);
                    TextView textView6 = this.binding.i;
                    Intrinsics3.checkNotNullExpressionValue(textView6, "binding.participantLiveIndicator");
                    textView6.setVisibility(data.isFocused ^ true ? 0 : 8);
                    a(data);
                } else if (iOrdinal == 2) {
                    ProgressBar progressBar4 = this.binding.p;
                    Intrinsics3.checkNotNullExpressionValue(progressBar4, "binding.participantVideoLoadingIndicator");
                    progressBar4.setVisibility(8);
                    SimpleDraweeView simpleDraweeView3 = this.binding.m;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.participantStreamPreviewImage");
                    simpleDraweeView3.setVisibility(0);
                    TextView textView7 = this.binding.n;
                    Intrinsics3.checkNotNullExpressionValue(textView7, "binding.participantStreamPreviewText");
                    textView7.setVisibility(0);
                    TextView textView8 = this.binding.l;
                    Intrinsics3.checkNotNullExpressionValue(textView8, "binding.participantStreamPaused");
                    textView8.setVisibility(8);
                    ConstraintLayout constraintLayout3 = this.binding.k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.participantStreamEnded");
                    constraintLayout3.setVisibility(8);
                    TextView textView9 = this.binding.i;
                    Intrinsics3.checkNotNullExpressionValue(textView9, "binding.participantLiveIndicator");
                    textView9.setVisibility(8);
                    this.binding.n.setOnClickListener(new VideoCallParticipantView6(this, data));
                    StreamContext streamContext = data.voiceParticipant.getStreamContext();
                    StoreApplicationStreamPreviews.StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
                    if (preview instanceof StoreApplicationStreamPreviews.StreamPreview.Resolved) {
                        this.binding.m.setImageURI(((StoreApplicationStreamPreviews.StreamPreview.Resolved) preview).getUrl());
                        SimpleDraweeView simpleDraweeView4 = this.binding.m;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.participantStreamPreviewImage");
                        ViewGroup.LayoutParams layoutParams = simpleDraweeView4.getLayoutParams();
                        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        layoutParams2.dimensionRatio = "16:9";
                        simpleDraweeView4.setLayoutParams(layoutParams2);
                    } else {
                        this.binding.m.setImageURI((String) null);
                        SimpleDraweeView simpleDraweeView5 = this.binding.m;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.participantStreamPreviewImage");
                        ViewGroup.LayoutParams layoutParams3 = simpleDraweeView5.getLayoutParams();
                        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                        layoutParams4.dimensionRatio = null;
                        simpleDraweeView5.setLayoutParams(layoutParams4);
                    }
                    b(false);
                } else if (iOrdinal == 3) {
                    ProgressBar progressBar5 = this.binding.p;
                    Intrinsics3.checkNotNullExpressionValue(progressBar5, "binding.participantVideoLoadingIndicator");
                    progressBar5.setVisibility(8);
                    SimpleDraweeView simpleDraweeView6 = this.binding.m;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.participantStreamPreviewImage");
                    simpleDraweeView6.setVisibility(0);
                    TextView textView10 = this.binding.n;
                    Intrinsics3.checkNotNullExpressionValue(textView10, "binding.participantStreamPreviewText");
                    textView10.setVisibility(8);
                    TextView textView11 = this.binding.l;
                    Intrinsics3.checkNotNullExpressionValue(textView11, "binding.participantStreamPaused");
                    textView11.setVisibility(0);
                    ConstraintLayout constraintLayout4 = this.binding.k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout4, "binding.participantStreamEnded");
                    constraintLayout4.setVisibility(8);
                    TextView textView12 = this.binding.i;
                    Intrinsics3.checkNotNullExpressionValue(textView12, "binding.participantLiveIndicator");
                    textView12.setVisibility(data.isFocused ^ true ? 0 : 8);
                    a(data);
                } else if (iOrdinal == 4) {
                    ProgressBar progressBar6 = this.binding.p;
                    Intrinsics3.checkNotNullExpressionValue(progressBar6, "binding.participantVideoLoadingIndicator");
                    progressBar6.setVisibility(8);
                    TextView textView13 = this.binding.n;
                    Intrinsics3.checkNotNullExpressionValue(textView13, "binding.participantStreamPreviewText");
                    textView13.setVisibility(8);
                    TextView textView14 = this.binding.l;
                    Intrinsics3.checkNotNullExpressionValue(textView14, "binding.participantStreamPaused");
                    textView14.setVisibility(8);
                    ConstraintLayout constraintLayout5 = this.binding.k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout5, "binding.participantStreamEnded");
                    constraintLayout5.setVisibility(0);
                    TextView textView15 = this.binding.i;
                    Intrinsics3.checkNotNullExpressionValue(textView15, "binding.participantLiveIndicator");
                    textView15.setVisibility(8);
                    b(false);
                }
            }
        } else {
            SimpleDraweeView simpleDraweeView7 = this.binding.m;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView7, "binding.participantStreamPreviewImage");
            simpleDraweeView7.setVisibility(8);
            TextView textView16 = this.binding.n;
            Intrinsics3.checkNotNullExpressionValue(textView16, "binding.participantStreamPreviewText");
            textView16.setVisibility(8);
            TextView textView17 = this.binding.l;
            Intrinsics3.checkNotNullExpressionValue(textView17, "binding.participantStreamPaused");
            textView17.setVisibility(8);
            ConstraintLayout constraintLayout6 = this.binding.k;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout6, "binding.participantStreamEnded");
            constraintLayout6.setVisibility(8);
            b(false);
            ImageView imageView3 = this.binding.j;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.participantMuteStatusIndicator");
            imageView3.setVisibility(voiceUser != null ? voiceUser.getIsMuted() : false ? 0 : 8);
            ImageView imageView4 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.participantDeafenStatusIndicator");
            imageView4.setVisibility(voiceUser != null ? voiceUser.getIsDeafened() : false ? 0 : 8);
            if (num2 != null) {
                View view4 = this.binding.f127b;
                Intrinsics3.checkNotNullExpressionValue(view4, "binding.participantBgAvatar");
                view4.setVisibility(8);
                VoiceUserView voiceUserView2 = this.binding.f128s;
                Intrinsics3.checkNotNullExpressionValue(voiceUserView2, "binding.participantVoiceUserView");
                voiceUserView2.setVisibility(8);
            } else {
                View view5 = this.binding.f127b;
                Intrinsics3.checkNotNullExpressionValue(view5, "binding.participantBgAvatar");
                view5.setVisibility(0);
                VoiceUserView voiceUserView3 = this.binding.f128s;
                Intrinsics3.checkNotNullExpressionValue(voiceUserView3, "binding.participantVoiceUserView");
                voiceUserView3.setVisibility(0);
            }
            TextView textView18 = this.binding.i;
            Intrinsics3.checkNotNullExpressionValue(textView18, "binding.participantLiveIndicator");
            textView18.setVisibility(8);
        }
        LinearLayout linearLayout = this.binding.r;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.participantVoiceIndicators");
        LinearLayout linearLayout2 = this.binding.r;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.participantVoiceIndicators");
        Iterator<View> it = androidx.core.view.ViewGroup.getChildren(linearLayout2).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            } else {
                if (it.next().getVisibility() == 0) {
                    z2 = true;
                    break;
                }
            }
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        DisplayCutoutCompat displayCutoutCompat = this.displayCutout;
        if ((displayCutoutCompat != null ? displayCutoutCompat.getSafeInsetTop() : 0) <= 0 || !this.canOverlapTopCutout) {
            TextView textView19 = this.binding.i;
            Intrinsics3.checkNotNullExpressionValue(textView19, "binding.participantLiveIndicator");
            constraintSet.connect(textView19.getId(), 2, 0, 2, DimenUtils.dpToPixels(8));
            TextView textView20 = this.binding.i;
            Intrinsics3.checkNotNullExpressionValue(textView20, "binding.participantLiveIndicator");
            constraintSet.connect(textView20.getId(), 3, 0, 3, DimenUtils.dpToPixels(8));
            TextView textView21 = this.binding.i;
            Intrinsics3.checkNotNullExpressionValue(textView21, "binding.participantLiveIndicator");
            constraintSet.clear(textView21.getId(), 4);
        } else {
            LinearLayout linearLayout3 = this.binding.r;
            Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.participantVoiceIndicators");
            if (!(linearLayout3.getVisibility() == 0)) {
                TextView textView22 = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(textView22, "binding.participantLiveIndicator");
                constraintSet.connect(textView22.getId(), 2, 0, 2, DimenUtils.dpToPixels(8));
                TextView textView23 = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(textView23, "binding.participantLiveIndicator");
                constraintSet.connect(textView23.getId(), 4, 0, 4, DimenUtils.dpToPixels(8));
                TextView textView24 = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(textView24, "binding.participantLiveIndicator");
                constraintSet.clear(textView24.getId(), 3);
            }
        }
        AppVideoStreamRenderer appVideoStreamRenderer3 = this.binding.q;
        RendererCommon.ScalingType scalingType = data != null ? data.scalingType : null;
        RendererCommon.ScalingType scalingType2 = data != null ? data.scalingTypeMismatchOrientation : null;
        if (data != null) {
            z3 = data.mirrorVideo;
            num = num2;
        } else {
            num = num2;
            z3 = false;
        }
        appVideoStreamRenderer3.c(num, scalingType, scalingType2, z3);
        Subscription subscription2 = this.frameRenderedSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        if (num != null) {
            BehaviorSubject<Point> behaviorSubject = this.binding.q.currentFrameResolutionSubject;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "currentFrameResolutionSubject");
            Observable<R> observableG = behaviorSubject.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            ObservableExtensionsKt.appSubscribe$default(observableG, VideoCallParticipantView.class, (Context) null, new r(0, this), (Function1) null, (Function0) null, (Function0) null, new VideoCallParticipantView7(this), 58, (Object) null);
        }
        ParticipantData participantData2 = this.data;
        ParticipantData.Type type3 = participantData2 != null ? participantData2.type : null;
        boolean z6 = data != null && data.isFocused;
        if (type3 != null && (type3 != type2 || z6 != z5)) {
            if (type3 != ParticipantData.Type.DEFAULT || z6) {
                ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                AppVideoStreamRenderer appVideoStreamRenderer4 = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer4, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer4.setLayoutParams(layoutParams5);
                AppVideoStreamRenderer appVideoStreamRenderer5 = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer5, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultHeight(appVideoStreamRenderer5.getId(), 1);
                AppVideoStreamRenderer appVideoStreamRenderer6 = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer6, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultWidth(appVideoStreamRenderer6.getId(), 1);
            } else {
                ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(0, 0);
                AppVideoStreamRenderer appVideoStreamRenderer7 = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer7, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer7.setLayoutParams(layoutParams6);
                AppVideoStreamRenderer appVideoStreamRenderer8 = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer8, "binding.participantVideoStreamRenderer");
                constraintSet.constrainHeight(appVideoStreamRenderer8.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer9 = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer9, "binding.participantVideoStreamRenderer");
                constraintSet.constrainWidth(appVideoStreamRenderer9.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer10 = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer10, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultHeight(appVideoStreamRenderer10.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer11 = this.binding.q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer11, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultWidth(appVideoStreamRenderer11.getId(), 0);
            }
        }
        constraintSet.applyTo(this);
        if (voiceUser != null) {
            TextView textView25 = this.binding.o;
            Intrinsics3.checkNotNullExpressionValue(textView25, "binding.participantVideoLabel");
            textView25.setText(voiceUser.getDisplayName());
            if (data.type == ParticipantData.Type.APPLICATION_STREAMING) {
                Context context = getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                i = 0;
                setContentDescription(FormatUtils.h(context, R.string.go_live_tile_screen, new Object[]{voiceUser.getDisplayName()}, null, 4));
                this.binding.o.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_screen_14dp, 0, 0, 0);
            } else {
                i = 0;
                setContentDescription(voiceUser.getDisplayName());
                this.binding.o.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (this.animateLabelFades) {
                ViewExtensions.fadeBy(this.binding.o, data.showLabel, 200L);
                return;
            }
            TextView textView26 = this.binding.o;
            Intrinsics3.checkNotNullExpressionValue(textView26, "binding.participantVideoLabel");
            if (!data.showLabel) {
                i = 8;
            }
            textView26.setVisibility(i);
            this.animateLabelFades = true;
        }
    }

    public final ParticipantData getData() {
        return this.data;
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout.DataView
    public String getDataId() {
        ParticipantData participantData = this.data;
        if (participantData != null) {
            return participantData.id;
        }
        return null;
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout.DataView
    public void onBind(FrameGridLayout.Data data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        d(this, (ParticipantData) data, null, false, null, false, 30);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Subscription subscription = this.representativeColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.animateLabelFades = false;
        this.binding.q.c(null, null, null, false);
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout.DataView
    public void onRemove() {
        FrameGridLayout.DataView.DefaultImpls.onRemove(this);
    }

    public final void setData(ParticipantData participantData) {
        this.data = participantData;
    }

    public final void setOnWatchStreamClicked(Function1<? super String, Unit> onWatchStreamClicked) {
        Intrinsics3.checkNotNullParameter(onWatchStreamClicked, "onWatchStreamClicked");
        this.onWatchStreamClicked = onWatchStreamClicked;
    }

    /* compiled from: VideoCallParticipantView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0003E$FBg\u0012\u0006\u0010B\u001a\u00020>\u0012\b\b\u0002\u00107\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u00102\u001a\u00020-\u0012\b\b\u0002\u0010,\u001a\u00020\u0012\u0012\b\b\u0002\u00104\u001a\u00020\u0012\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u000108¢\u0006\u0004\bC\u0010DJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010'\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\rR\u0019\u0010,\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u00102\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0019\u00104\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010)\u001a\u0004\b4\u0010+R\u0019\u00107\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u0010+R\u001b\u0010=\u001a\u0004\u0018\u0001088\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010B\u001a\u00020>8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010?\u001a\u0004\b@\u0010A¨\u0006G"}, d2 = {"Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "Lcom/discord/utilities/view/grid/FrameGridLayout$Data;", "Landroid/content/Context;", "context", "Landroid/view/View;", "createView", "(Landroid/content/Context;)Landroid/view/View;", "", "Lcom/discord/primitives/StreamId;", "b", "()Ljava/lang/Integer;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lorg/webrtc/RendererCommon$ScalingType;", "e", "Lorg/webrtc/RendererCommon$ScalingType;", "getScalingTypeMismatchOrientation", "()Lorg/webrtc/RendererCommon$ScalingType;", "scalingTypeMismatchOrientation", "d", "getScalingType", "scalingType", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$ApplicationStreamState;", "f", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$ApplicationStreamState;", "getApplicationStreamState", "()Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$ApplicationStreamState;", "applicationStreamState", "a", "Ljava/lang/String;", "getId", ModelAuditLogEntry.CHANGE_KEY_ID, "h", "Z", "getShowLabel", "()Z", "showLabel", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$Type;", "g", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$Type;", "getType", "()Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$Type;", "type", "i", "isFocused", "c", "getMirrorVideo", "mirrorVideo", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$a;", "j", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$a;", "getStreamQualityIndicatorData", "()Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$a;", "streamQualityIndicatorData", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "getVoiceParticipant", "()Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceParticipant", "<init>", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;ZLorg/webrtc/RendererCommon$ScalingType;Lorg/webrtc/RendererCommon$ScalingType;Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$ApplicationStreamState;Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$Type;ZZLcom/discord/views/calls/VideoCallParticipantView$ParticipantData$a;)V", "ApplicationStreamState", "Type", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ParticipantData implements FrameGridLayout.Data {

        /* renamed from: a, reason: from kotlin metadata */
        public final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final StoreVoiceParticipants.VoiceUser voiceParticipant;

        /* renamed from: c, reason: from kotlin metadata */
        public final boolean mirrorVideo;

        /* renamed from: d, reason: from kotlin metadata */
        public final RendererCommon.ScalingType scalingType;

        /* renamed from: e, reason: from kotlin metadata */
        public final RendererCommon.ScalingType scalingTypeMismatchOrientation;

        /* renamed from: f, reason: from kotlin metadata */
        public final ApplicationStreamState applicationStreamState;

        /* renamed from: g, reason: from kotlin metadata */
        public final Type type;

        /* renamed from: h, reason: from kotlin metadata */
        public final boolean showLabel;

        /* renamed from: i, reason: from kotlin metadata */
        public final boolean isFocused;

        /* renamed from: j, reason: from kotlin metadata */
        public final a streamQualityIndicatorData;

        /* compiled from: VideoCallParticipantView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$ApplicationStreamState;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTING", "ACTIVE", "INACTIVE", "PAUSED", "ENDED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum ApplicationStreamState {
            CONNECTING,
            ACTIVE,
            INACTIVE,
            PAUSED,
            ENDED
        }

        /* compiled from: VideoCallParticipantView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData$Type;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "APPLICATION_STREAMING", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            DEFAULT,
            APPLICATION_STREAMING
        }

        /* compiled from: VideoCallParticipantView.kt */
        public static final class a {
            public final boolean a;

            /* renamed from: b, reason: collision with root package name */
            public final StreamResolution f2841b;
            public final StreamFps c;
            public final boolean d;

            public a(boolean z2, StreamResolution streamResolution, StreamFps streamFps, boolean z3) {
                Intrinsics3.checkNotNullParameter(streamResolution, "resolution");
                this.a = z2;
                this.f2841b = streamResolution;
                this.c = streamFps;
                this.d = z3;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.a == aVar.a && Intrinsics3.areEqual(this.f2841b, aVar.f2841b) && Intrinsics3.areEqual(this.c, aVar.c) && this.d == aVar.d;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            public int hashCode() {
                boolean z2 = this.a;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                StreamResolution streamResolution = this.f2841b;
                int iHashCode = (i + (streamResolution != null ? streamResolution.hashCode() : 0)) * 31;
                StreamFps streamFps = this.c;
                int fps = (iHashCode + (streamFps != null ? streamFps.getFps() : 0)) * 31;
                boolean z3 = this.d;
                return fps + (z3 ? 1 : z3 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("StreamQualityIndicatorData(showPremiumIcon=");
                sbU.append(this.a);
                sbU.append(", resolution=");
                sbU.append(this.f2841b);
                sbU.append(", fps=");
                sbU.append(this.c);
                sbU.append(", isBadQuality=");
                return outline.O(sbU, this.d, ")");
            }
        }

        public ParticipantData(StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2, ApplicationStreamState applicationStreamState, Type type, boolean z3, boolean z4, a aVar) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceParticipant");
            Intrinsics3.checkNotNullParameter(type, "type");
            this.voiceParticipant = voiceUser;
            this.mirrorVideo = z2;
            this.scalingType = scalingType;
            this.scalingTypeMismatchOrientation = scalingType2;
            this.applicationStreamState = applicationStreamState;
            this.type = type;
            this.showLabel = z3;
            this.isFocused = z4;
            this.streamQualityIndicatorData = aVar;
            StringBuilder sb = new StringBuilder();
            sb.append(voiceUser.getUser().getId());
            sb.append(type);
            this.id = sb.toString();
        }

        public static ParticipantData a(ParticipantData participantData, StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2, ApplicationStreamState applicationStreamState, Type type, boolean z3, boolean z4, a aVar, int i) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = (i & 1) != 0 ? participantData.voiceParticipant : null;
            boolean z5 = (i & 2) != 0 ? participantData.mirrorVideo : z2;
            RendererCommon.ScalingType scalingType3 = (i & 4) != 0 ? participantData.scalingType : scalingType;
            RendererCommon.ScalingType scalingType4 = (i & 8) != 0 ? participantData.scalingTypeMismatchOrientation : scalingType2;
            ApplicationStreamState applicationStreamState2 = (i & 16) != 0 ? participantData.applicationStreamState : null;
            Type type2 = (i & 32) != 0 ? participantData.type : null;
            boolean z6 = (i & 64) != 0 ? participantData.showLabel : z3;
            boolean z7 = (i & 128) != 0 ? participantData.isFocused : z4;
            a aVar2 = (i & 256) != 0 ? participantData.streamQualityIndicatorData : aVar;
            Objects.requireNonNull(participantData);
            Intrinsics3.checkNotNullParameter(voiceUser2, "voiceParticipant");
            Intrinsics3.checkNotNullParameter(type2, "type");
            return new ParticipantData(voiceUser2, z5, scalingType3, scalingType4, applicationStreamState2, type2, z6, z7, aVar2);
        }

        public final Integer b() {
            VoiceState voiceState;
            int iOrdinal = this.type.ordinal();
            if (iOrdinal == 0) {
                VoiceState voiceState2 = this.voiceParticipant.getVoiceState();
                if (voiceState2 == null || !voiceState2.getSelfVideo()) {
                    return null;
                }
                return this.voiceParticipant.getCallStreamId();
            }
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            ApplicationStreamState applicationStreamState = this.applicationStreamState;
            if ((applicationStreamState == ApplicationStreamState.CONNECTING || applicationStreamState == ApplicationStreamState.ACTIVE || applicationStreamState == ApplicationStreamState.PAUSED) && (voiceState = this.voiceParticipant.getVoiceState()) != null && voiceState.getSelfStream()) {
                return this.voiceParticipant.getApplicationStreamId();
            }
            return null;
        }

        @Override // com.discord.utilities.view.grid.FrameGridLayout.Data
        public View createView(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return new VideoCallParticipantView(context, null, 0, 6);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParticipantData)) {
                return false;
            }
            ParticipantData participantData = (ParticipantData) other;
            return Intrinsics3.areEqual(this.voiceParticipant, participantData.voiceParticipant) && this.mirrorVideo == participantData.mirrorVideo && Intrinsics3.areEqual(this.scalingType, participantData.scalingType) && Intrinsics3.areEqual(this.scalingTypeMismatchOrientation, participantData.scalingTypeMismatchOrientation) && Intrinsics3.areEqual(this.applicationStreamState, participantData.applicationStreamState) && Intrinsics3.areEqual(this.type, participantData.type) && this.showLabel == participantData.showLabel && this.isFocused == participantData.isFocused && Intrinsics3.areEqual(this.streamQualityIndicatorData, participantData.streamQualityIndicatorData);
        }

        @Override // com.discord.utilities.view.grid.FrameGridLayout.Data
        public String getId() {
            return this.id;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            StoreVoiceParticipants.VoiceUser voiceUser = this.voiceParticipant;
            int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
            boolean z2 = this.mirrorVideo;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            RendererCommon.ScalingType scalingType = this.scalingType;
            int iHashCode2 = (i2 + (scalingType != null ? scalingType.hashCode() : 0)) * 31;
            RendererCommon.ScalingType scalingType2 = this.scalingTypeMismatchOrientation;
            int iHashCode3 = (iHashCode2 + (scalingType2 != null ? scalingType2.hashCode() : 0)) * 31;
            ApplicationStreamState applicationStreamState = this.applicationStreamState;
            int iHashCode4 = (iHashCode3 + (applicationStreamState != null ? applicationStreamState.hashCode() : 0)) * 31;
            Type type = this.type;
            int iHashCode5 = (iHashCode4 + (type != null ? type.hashCode() : 0)) * 31;
            boolean z3 = this.showLabel;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode5 + i3) * 31;
            boolean z4 = this.isFocused;
            int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
            a aVar = this.streamQualityIndicatorData;
            return i5 + (aVar != null ? aVar.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ParticipantData(voiceParticipant=");
            sbU.append(this.voiceParticipant);
            sbU.append(", mirrorVideo=");
            sbU.append(this.mirrorVideo);
            sbU.append(", scalingType=");
            sbU.append(this.scalingType);
            sbU.append(", scalingTypeMismatchOrientation=");
            sbU.append(this.scalingTypeMismatchOrientation);
            sbU.append(", applicationStreamState=");
            sbU.append(this.applicationStreamState);
            sbU.append(", type=");
            sbU.append(this.type);
            sbU.append(", showLabel=");
            sbU.append(this.showLabel);
            sbU.append(", isFocused=");
            sbU.append(this.isFocused);
            sbU.append(", streamQualityIndicatorData=");
            sbU.append(this.streamQualityIndicatorData);
            sbU.append(")");
            return sbU.toString();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ParticipantData(StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2, ApplicationStreamState applicationStreamState, Type type, boolean z3, boolean z4, a aVar, int i) {
            this(voiceUser, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? RendererCommon.ScalingType.SCALE_ASPECT_BALANCED : scalingType, (i & 8) != 0 ? RendererCommon.ScalingType.SCALE_ASPECT_FIT : scalingType2, (i & 16) != 0 ? null : applicationStreamState, (i & 32) != 0 ? Type.DEFAULT : type, (i & 64) != 0 ? false : z3, (i & 128) != 0 ? false : z4, null);
            int i2 = i & 256;
        }
    }
}
