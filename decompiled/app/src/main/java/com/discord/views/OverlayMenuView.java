package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.i.ViewOverlayMenuBinding;
import b.a.i.ViewOverlayMenuContentBinding;
import b.a.y.OverlayMenuView3;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceViewUtils;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import defpackage.f;
import defpackage.i;
import defpackage.q;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* compiled from: OverlayMenuView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/discord/views/OverlayMenuView;", "Landroid/widget/LinearLayout;", "Lcom/discord/app/AppComponent;", "", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Lb/a/i/s2;", "k", "Lb/a/i/s2;", "binding", "Lkotlin/Function0;", "m", "Lkotlin/jvm/functions/Function0;", "getOnDismissRequested$app_productionGoogleRelease", "()Lkotlin/jvm/functions/Function0;", "setOnDismissRequested$app_productionGoogleRelease", "(Lkotlin/jvm/functions/Function0;)V", "onDismissRequested", "Lrx/subjects/Subject;", "Ljava/lang/Void;", "l", "Lrx/subjects/Subject;", "getUnsubscribeSignal", "()Lrx/subjects/Subject;", "unsubscribeSignal", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class OverlayMenuView extends LinearLayout implements AppComponent {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewOverlayMenuBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public final Subject<Void, Void> unsubscribeSignal;

    /* renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onDismissRequested;

    /* compiled from: OverlayMenuView.kt */
    public static final class a {
        public final Long a;

        /* renamed from: b, reason: collision with root package name */
        public final Guild f2833b;
        public final CallModel c;
        public final RtcConnection.Quality d;

        public a(Long l, Guild guild, CallModel callModel, RtcConnection.Quality quality) {
            Intrinsics3.checkNotNullParameter(quality, "rtcQuality");
            this.a = l;
            this.f2833b = guild;
            this.c = callModel;
            this.d = quality;
        }
    }

    /* compiled from: OverlayMenuView.kt */
    public static final class b extends Lambda implements Function1<a, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(a aVar) {
            a aVar2 = aVar;
            if (aVar2 != null) {
                OverlayMenuView overlayMenuView = OverlayMenuView.this;
                int i = OverlayMenuView.j;
                Objects.requireNonNull(overlayMenuView);
                if (aVar2.c != null) {
                    overlayMenuView.binding.f197b.d.setOnClickListener(new f(0, overlayMenuView, aVar2));
                    TextView textView = overlayMenuView.binding.f197b.d;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.content.overlayInviteLink");
                    textView.setVisibility(PermissionUtils.can(1L, aVar2.a) ? 0 : 8);
                    overlayMenuView.binding.f197b.g.setOnClickListener(new i(0, overlayMenuView));
                    overlayMenuView.binding.f197b.f.setOnClickListener(new f(1, overlayMenuView, aVar2));
                    ImageView imageView = overlayMenuView.binding.e;
                    Intrinsics3.checkNotNullExpressionValue(imageView, "binding.srcToggle");
                    ColorStateList colorStateListValueOf = aVar2.c.getAudioManagerState().getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.SPEAKERPHONE ? ColorStateList.valueOf(-1) : ColorStateList.valueOf(ColorCompat.getColor(overlayMenuView.getContext(), R.color.primary_dark_400));
                    Intrinsics3.checkNotNullExpressionValue(colorStateListValueOf, "if (selectedOutputDevice…rimary_dark_400))\n      }");
                    imageView.setImageTintList(colorStateListValueOf);
                    overlayMenuView.binding.e.setOnClickListener(new i(1, aVar2));
                    ImageView imageView2 = overlayMenuView.binding.d;
                    Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.muteToggle");
                    imageView2.setActivated(aVar2.c.isMeMutedByAnySource());
                    overlayMenuView.binding.d.setOnClickListener(new i(2, aVar2));
                    overlayMenuView.binding.c.setOnClickListener(new i(3, overlayMenuView));
                    overlayMenuView.binding.f197b.e.setImageResource(VoiceViewUtils.INSTANCE.getQualityIndicator(aVar2.d));
                    TextView textView2 = overlayMenuView.binding.f197b.c;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.content.overlayGuildName");
                    Guild guild = aVar2.f2833b;
                    String name = guild != null ? guild.getName() : null;
                    if (name == null) {
                        name = "";
                    }
                    textView2.setText(name);
                    TextView textView3 = overlayMenuView.binding.f197b.f203b;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.content.overlayChannelName");
                    textView3.setText(ChannelUtils.c(aVar2.c.getChannel()));
                }
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_overlay_menu, this);
        int i = R.id.content;
        View viewFindViewById = findViewById(R.id.content);
        if (viewFindViewById != null) {
            int i2 = R.id.overlay_channel_name;
            TextView textView = (TextView) viewFindViewById.findViewById(R.id.overlay_channel_name);
            if (textView != null) {
                i2 = R.id.overlay_guild_name;
                TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.overlay_guild_name);
                if (textView2 != null) {
                    i2 = R.id.overlay_invite_link;
                    TextView textView3 = (TextView) viewFindViewById.findViewById(R.id.overlay_invite_link);
                    if (textView3 != null) {
                        i2 = R.id.overlay_network_icon;
                        ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.overlay_network_icon);
                        if (imageView != null) {
                            i2 = R.id.overlay_open_app;
                            TextView textView4 = (TextView) viewFindViewById.findViewById(R.id.overlay_open_app);
                            if (textView4 != null) {
                                i2 = R.id.overlay_switch_channels;
                                TextView textView5 = (TextView) viewFindViewById.findViewById(R.id.overlay_switch_channels);
                                if (textView5 != null) {
                                    ViewOverlayMenuContentBinding viewOverlayMenuContentBinding = new ViewOverlayMenuContentBinding((CardView) viewFindViewById, textView, textView2, textView3, imageView, textView4, textView5);
                                    i = R.id.disconnect_btn;
                                    ImageView imageView2 = (ImageView) findViewById(R.id.disconnect_btn);
                                    if (imageView2 != null) {
                                        i = R.id.mute_toggle;
                                        ImageView imageView3 = (ImageView) findViewById(R.id.mute_toggle);
                                        if (imageView3 != null) {
                                            i = R.id.src_toggle;
                                            ImageView imageView4 = (ImageView) findViewById(R.id.src_toggle);
                                            if (imageView4 != null) {
                                                ViewOverlayMenuBinding viewOverlayMenuBinding = new ViewOverlayMenuBinding(this, viewOverlayMenuContentBinding, imageView2, imageView3, imageView4);
                                                Intrinsics3.checkNotNullExpressionValue(viewOverlayMenuBinding, "ViewOverlayMenuBinding.i…ater.from(context), this)");
                                                this.binding = viewOverlayMenuBinding;
                                                PublishSubject publishSubjectK0 = PublishSubject.k0();
                                                Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
                                                this.unsubscribeSignal = publishSubjectK0;
                                                this.onDismissRequested = q.j;
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
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final Function0<Unit> getOnDismissRequested$app_productionGoogleRelease() {
        return this.onDismissRequested;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Observable<R> observableY = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedChannel().Y(OverlayMenuView3.j);
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), OverlayMenuView.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new b(), 62, (Object) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getUnsubscribeSignal().onNext(null);
        super.onDetachedFromWindow();
    }

    public final void setOnDismissRequested$app_productionGoogleRelease(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onDismissRequested = function0;
    }
}
