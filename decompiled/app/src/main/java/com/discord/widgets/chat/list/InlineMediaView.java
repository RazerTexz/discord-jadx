package com.discord.widgets.chat.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import b.a.k.FormatUtils;
import b.a.p.AppMediaPlayerFactory;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedVideo;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.app.AppComponent;
import com.discord.databinding.InlineMediaViewBinding;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.panels.PanelState;
import com.discord.player.AppMediaPlayer;
import com.discord.player.MediaSource;
import com.discord.player.MediaType;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.RxCoroutineUtils;
import com.discord.utilities.views.ViewCoroutineScope;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.ui.PlayerView;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import rx.subscriptions.CompositeSubscription;
import s.a.d2.Flow3;

/* compiled from: InlineMediaView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001RB\u0011\b\u0016\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LB\u001d\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M¢\u0006\u0004\bK\u0010OB'\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010P\u001a\u00020\n¢\u0006\u0004\bK\u0010QJU\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012JM\u0010\u0013\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#J\u001f\u0010'\u001a\u00020\u00102\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\nH\u0014¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0010¢\u0006\u0004\b)\u0010\u001aJ\r\u0010*\u001a\u00020\u0010¢\u0006\u0004\b*\u0010\u001aJ5\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020+2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b-\u0010.J5\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020/2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R(\u0010?\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020>0=8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006S"}, d2 = {"Lcom/discord/widgets/chat/list/InlineMediaView;", "Landroidx/cardview/widget/CardView;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/discord/app/AppComponent;", "Lcom/discord/embed/RenderableEmbedMedia;", "previewImage", "", "progressiveMediaUri", "Lcom/discord/api/message/embed/EmbedType;", "embedType", "", "targetWidth", "targetHeight", "featureTag", "", "autoPlayGifs", "", "diffViewParamsAndUpdateEmbed", "(Lcom/discord/embed/RenderableEmbedMedia;Ljava/lang/String;Lcom/discord/api/message/embed/EmbedType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Z)V", "updateUI", "(Lcom/discord/embed/RenderableEmbedMedia;Ljava/lang/String;Lcom/discord/api/message/embed/EmbedType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "Lcom/discord/player/AppMediaPlayer$Event;", "event", "handlePlayerEvent", "(Lcom/discord/player/AppMediaPlayer$Event;)V", "resetCurrentEmbed", "()V", "releasePlayer", "clearPlayerAndSubscriptions", "resetViews", "shouldAutoPlay", "()Z", "Landroid/view/View;", "view", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "onResume", "onPause", "Lcom/discord/api/message/attachment/MessageAttachment;", "attachment", "updateUIWithAttachment", "(Lcom/discord/api/message/attachment/MessageAttachment;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "Lcom/discord/api/message/embed/MessageEmbed;", "embed", "updateUIWithEmbed", "(Lcom/discord/api/message/embed/MessageEmbed;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/stores/StoreUserSettings;", "Ljava/lang/String;", "Lcom/discord/widgets/chat/list/InlineMediaView$ViewParams;", "viewParams", "Lcom/discord/widgets/chat/list/InlineMediaView$ViewParams;", "Lcom/discord/databinding/InlineMediaViewBinding;", "binding", "Lcom/discord/databinding/InlineMediaViewBinding;", "Lrx/subjects/Subject;", "Ljava/lang/Void;", "unsubscribeSignal", "Lrx/subjects/Subject;", "getUnsubscribeSignal", "()Lrx/subjects/Subject;", "Lcom/discord/player/AppMediaPlayer;", "appMediaPlayer", "Lcom/discord/player/AppMediaPlayer;", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "Lrx/subscriptions/CompositeSubscription;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ViewParams", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class InlineMediaView extends CardView implements View.OnAttachStateChangeListener, AppComponent {
    private AppMediaPlayer appMediaPlayer;
    private final InlineMediaViewBinding binding;
    private CompositeSubscription compositeSubscription;
    private String featureTag;
    private final StoreUserSettings storeUserSettings;
    private final Subject<Void, Void> unsubscribeSignal;
    private ViewParams viewParams;

    /* compiled from: InlineMediaView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JV\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\u0007R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\nR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010\rR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b(\u0010\rR\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010\u0011¨\u0006-"}, d2 = {"Lcom/discord/widgets/chat/list/InlineMediaView$ViewParams;", "", "Lcom/discord/embed/RenderableEmbedMedia;", "component1", "()Lcom/discord/embed/RenderableEmbedMedia;", "", "component2", "()Ljava/lang/String;", "Lcom/discord/api/message/embed/EmbedType;", "component3", "()Lcom/discord/api/message/embed/EmbedType;", "", "component4", "()Ljava/lang/Integer;", "component5", "", "component6", "()Z", "previewImage", "progressiveMediaUri", "embedType", "targetWidth", "targetHeight", "autoPlayGifs", "copy", "(Lcom/discord/embed/RenderableEmbedMedia;Ljava/lang/String;Lcom/discord/api/message/embed/EmbedType;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/discord/widgets/chat/list/InlineMediaView$ViewParams;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getProgressiveMediaUri", "Lcom/discord/api/message/embed/EmbedType;", "getEmbedType", "Ljava/lang/Integer;", "getTargetHeight", "Lcom/discord/embed/RenderableEmbedMedia;", "getPreviewImage", "getTargetWidth", "Z", "getAutoPlayGifs", "<init>", "(Lcom/discord/embed/RenderableEmbedMedia;Ljava/lang/String;Lcom/discord/api/message/embed/EmbedType;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewParams {
        private final boolean autoPlayGifs;
        private final EmbedType embedType;
        private final RenderableEmbedMedia previewImage;
        private final String progressiveMediaUri;
        private final Integer targetHeight;
        private final Integer targetWidth;

        public ViewParams(RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, boolean z2) {
            this.previewImage = renderableEmbedMedia;
            this.progressiveMediaUri = str;
            this.embedType = embedType;
            this.targetWidth = num;
            this.targetHeight = num2;
            this.autoPlayGifs = z2;
        }

        public static /* synthetic */ ViewParams copy$default(ViewParams viewParams, RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                renderableEmbedMedia = viewParams.previewImage;
            }
            if ((i & 2) != 0) {
                str = viewParams.progressiveMediaUri;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                embedType = viewParams.embedType;
            }
            EmbedType embedType2 = embedType;
            if ((i & 8) != 0) {
                num = viewParams.targetWidth;
            }
            Integer num3 = num;
            if ((i & 16) != 0) {
                num2 = viewParams.targetHeight;
            }
            Integer num4 = num2;
            if ((i & 32) != 0) {
                z2 = viewParams.autoPlayGifs;
            }
            return viewParams.copy(renderableEmbedMedia, str2, embedType2, num3, num4, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final RenderableEmbedMedia getPreviewImage() {
            return this.previewImage;
        }

        /* renamed from: component2, reason: from getter */
        public final String getProgressiveMediaUri() {
            return this.progressiveMediaUri;
        }

        /* renamed from: component3, reason: from getter */
        public final EmbedType getEmbedType() {
            return this.embedType;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getTargetWidth() {
            return this.targetWidth;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getTargetHeight() {
            return this.targetHeight;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        public final ViewParams copy(RenderableEmbedMedia previewImage, String progressiveMediaUri, EmbedType embedType, Integer targetWidth, Integer targetHeight, boolean autoPlayGifs) {
            return new ViewParams(previewImage, progressiveMediaUri, embedType, targetWidth, targetHeight, autoPlayGifs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewParams)) {
                return false;
            }
            ViewParams viewParams = (ViewParams) other;
            return Intrinsics3.areEqual(this.previewImage, viewParams.previewImage) && Intrinsics3.areEqual(this.progressiveMediaUri, viewParams.progressiveMediaUri) && Intrinsics3.areEqual(this.embedType, viewParams.embedType) && Intrinsics3.areEqual(this.targetWidth, viewParams.targetWidth) && Intrinsics3.areEqual(this.targetHeight, viewParams.targetHeight) && this.autoPlayGifs == viewParams.autoPlayGifs;
        }

        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        public final EmbedType getEmbedType() {
            return this.embedType;
        }

        public final RenderableEmbedMedia getPreviewImage() {
            return this.previewImage;
        }

        public final String getProgressiveMediaUri() {
            return this.progressiveMediaUri;
        }

        public final Integer getTargetHeight() {
            return this.targetHeight;
        }

        public final Integer getTargetWidth() {
            return this.targetWidth;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            RenderableEmbedMedia renderableEmbedMedia = this.previewImage;
            int iHashCode = (renderableEmbedMedia != null ? renderableEmbedMedia.hashCode() : 0) * 31;
            String str = this.progressiveMediaUri;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            EmbedType embedType = this.embedType;
            int iHashCode3 = (iHashCode2 + (embedType != null ? embedType.hashCode() : 0)) * 31;
            Integer num = this.targetWidth;
            int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.targetHeight;
            int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
            boolean z2 = this.autoPlayGifs;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode5 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewParams(previewImage=");
            sbU.append(this.previewImage);
            sbU.append(", progressiveMediaUri=");
            sbU.append(this.progressiveMediaUri);
            sbU.append(", embedType=");
            sbU.append(this.embedType);
            sbU.append(", targetWidth=");
            sbU.append(this.targetWidth);
            sbU.append(", targetHeight=");
            sbU.append(this.targetHeight);
            sbU.append(", autoPlayGifs=");
            return outline.O(sbU, this.autoPlayGifs, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MessageAttachmentType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[MessageAttachmentType.VIDEO.ordinal()] = 1;
            iArr[MessageAttachmentType.IMAGE.ordinal()] = 2;
            iArr[MessageAttachmentType.FILE.ordinal()] = 3;
        }
    }

    /* compiled from: InlineMediaView.kt */
    @DebugMetadata(c = "com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1", f = "InlineMediaView.kt", l = {89, 416}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: InlineMediaView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/panels/PanelState;", "kotlin.jvm.PlatformType", "left", "right", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/panels/PanelState;Lcom/discord/panels/PanelState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02601<T1, T2, R> implements Func2<PanelState, PanelState, Boolean> {
            public static final C02601 INSTANCE = new C02601();

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(PanelState panelState, PanelState panelState2) {
                return call2(panelState, panelState2);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(PanelState panelState, PanelState panelState2) {
                PanelState.c cVar = PanelState.c.a;
                return Boolean.valueOf(Intrinsics3.areEqual(panelState, cVar) || Intrinsics3.areEqual(panelState2, cVar));
            }
        }

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return InlineMediaView.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableR = Observable.j(companion.getNavigation().observeLeftPanelState(), companion.getNavigation().observeRightPanelState(), C02601.INSTANCE).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                this.label = 1;
                obj = RxCoroutineUtils.toFlow(observableR, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                    return Unit.a;
                }
                Result3.throwOnFailure(obj);
            }
            Collect2 collect2 = new Collect2(this);
            this.label = 2;
            if (((Flow3) obj).a(collect2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.a;
        }
    }

    /* compiled from: InlineMediaView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            InlineMediaView.access$getCompositeSubscription$p(InlineMediaView.this).a(subscription);
        }
    }

    /* compiled from: InlineMediaView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "volume", "", "invoke", "(F)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Float, Unit> {
        public final /* synthetic */ AppMediaPlayer $player;

        /* compiled from: InlineMediaView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ boolean $isVolumeOn;

            public AnonymousClass1(boolean z2) {
                this.$isVolumeOn = z2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnonymousClass2.this.$player.d(this.$isVolumeOn ? 0.0f : 1.0f);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AppMediaPlayer appMediaPlayer) {
            super(1);
            this.$player = appMediaPlayer;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
            invoke(f.floatValue());
            return Unit.a;
        }

        public final void invoke(float f) {
            boolean z2 = f > ((float) 0);
            InlineMediaView.access$getBinding$p(InlineMediaView.this).g.setImageDrawable(ContextCompat.getDrawable(InlineMediaView.this.getContext(), z2 ? R.drawable.ic_volume_up_white_24dp : R.drawable.ic_volume_off_24dp));
            InlineMediaView.access$getBinding$p(InlineMediaView.this).g.setOnClickListener(new AnonymousClass1(z2));
            int i = z2 ? R.string.video_playback_mute_accessibility_label : R.string.video_playback_unmute_accessibility_label;
            ImageView imageView = InlineMediaView.access$getBinding$p(InlineMediaView.this).g;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inlineMediaVolumeToggle");
            imageView.setContentDescription(FormatUtils.j(InlineMediaView.this, i, new Object[0], null, 4));
        }
    }

    /* compiled from: InlineMediaView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            InlineMediaView.access$getCompositeSubscription$p(InlineMediaView.this).a(subscription);
        }
    }

    /* compiled from: InlineMediaView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/player/AppMediaPlayer$Event;", "event", "", "invoke", "(Lcom/discord/player/AppMediaPlayer$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<AppMediaPlayer.Event, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppMediaPlayer.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppMediaPlayer.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            InlineMediaView.access$handlePlayerEvent(InlineMediaView.this, event);
        }
    }

    /* compiled from: InlineMediaView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ MediaSource $mediaSource;

        public AnonymousClass5(MediaSource mediaSource) {
            this.$mediaSource = mediaSource;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PlayerView playerView = InlineMediaView.access$getBinding$p(InlineMediaView.this).f;
            Intrinsics3.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
            playerView.setVisibility(0);
            AppMediaPlayer appMediaPlayerAccess$getAppMediaPlayer$p = InlineMediaView.access$getAppMediaPlayer$p(InlineMediaView.this);
            if (appMediaPlayerAccess$getAppMediaPlayer$p != null) {
                MediaSource mediaSource = this.$mediaSource;
                PlayerView playerView2 = InlineMediaView.access$getBinding$p(InlineMediaView.this).f;
                Intrinsics3.checkNotNullExpressionValue(playerView2, "binding.inlineMediaPlayerView");
                AppMediaPlayer.b(appMediaPlayerAccess$getAppMediaPlayer$p, mediaSource, true, false, 0L, playerView2, null, 40);
            }
            ImageView imageView = InlineMediaView.access$getBinding$p(InlineMediaView.this).e;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inlineMediaPlayButton");
            imageView.setVisibility(8);
            ProgressBar progressBar = InlineMediaView.access$getBinding$p(InlineMediaView.this).d;
            Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
            progressBar.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingA = InlineMediaViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(inlineMediaViewBindingA, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingA;
        this.storeUserSettings = StoreStream.INSTANCE.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    public static final /* synthetic */ AppMediaPlayer access$getAppMediaPlayer$p(InlineMediaView inlineMediaView) {
        return inlineMediaView.appMediaPlayer;
    }

    public static final /* synthetic */ InlineMediaViewBinding access$getBinding$p(InlineMediaView inlineMediaView) {
        return inlineMediaView.binding;
    }

    public static final /* synthetic */ CompositeSubscription access$getCompositeSubscription$p(InlineMediaView inlineMediaView) {
        return inlineMediaView.compositeSubscription;
    }

    public static final /* synthetic */ void access$handlePlayerEvent(InlineMediaView inlineMediaView, AppMediaPlayer.Event event) {
        inlineMediaView.handlePlayerEvent(event);
    }

    public static final /* synthetic */ void access$setAppMediaPlayer$p(InlineMediaView inlineMediaView, AppMediaPlayer appMediaPlayer) {
        inlineMediaView.appMediaPlayer = appMediaPlayer;
    }

    public static final /* synthetic */ void access$setCompositeSubscription$p(InlineMediaView inlineMediaView, CompositeSubscription compositeSubscription) {
        inlineMediaView.compositeSubscription = compositeSubscription;
    }

    private final void clearPlayerAndSubscriptions() {
        releasePlayer();
        getUnsubscribeSignal().onNext(null);
    }

    private final void diffViewParamsAndUpdateEmbed(RenderableEmbedMedia previewImage, String progressiveMediaUri, EmbedType embedType, Integer targetWidth, Integer targetHeight, String featureTag, boolean autoPlayGifs) {
        Integer targetWidth2;
        Integer targetHeight2;
        if (targetWidth != null) {
            targetWidth2 = targetWidth;
        } else {
            ViewParams viewParams = this.viewParams;
            targetWidth2 = viewParams != null ? viewParams.getTargetWidth() : null;
        }
        if (targetHeight != null) {
            targetHeight2 = targetHeight;
        } else {
            ViewParams viewParams2 = this.viewParams;
            targetHeight2 = viewParams2 != null ? viewParams2.getTargetHeight() : null;
        }
        ViewParams viewParams3 = new ViewParams(previewImage, progressiveMediaUri, embedType, targetWidth2, targetHeight2, autoPlayGifs);
        if (Intrinsics3.areEqual(viewParams3, this.viewParams)) {
            return;
        }
        this.viewParams = viewParams3;
        updateUI(previewImage, progressiveMediaUri, embedType, targetWidth, targetHeight, featureTag);
    }

    public static /* synthetic */ void diffViewParamsAndUpdateEmbed$default(InlineMediaView inlineMediaView, RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, String str2, boolean z2, int i, Object obj) {
        inlineMediaView.diffViewParamsAndUpdateEmbed(renderableEmbedMedia, str, embedType, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, str2, z2);
    }

    private final void handlePlayerEvent(AppMediaPlayer.Event event) {
        boolean z2 = true;
        if (Intrinsics3.areEqual(event, AppMediaPlayer.Event.a.a)) {
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
            simpleDraweeView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
            ProgressBar progressBar = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
            progressBar.setVisibility(8);
            return;
        }
        if (!Intrinsics3.areEqual(event, AppMediaPlayer.Event.f.a)) {
            if (Intrinsics3.areEqual(event, AppMediaPlayer.Event.e.a)) {
                resetCurrentEmbed();
                return;
            }
            return;
        }
        ViewParams viewParams = this.viewParams;
        EmbedType embedType = viewParams != null ? viewParams.getEmbedType() : null;
        ImageView imageView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inlineMediaVolumeToggle");
        if (embedType != EmbedType.VIDEO && embedType != null) {
            z2 = false;
        }
        imageView.setVisibility(z2 ? 0 : 8);
    }

    private final void releasePlayer() {
        AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
        if (appMediaPlayer != null) {
            appMediaPlayer.c();
        }
        this.appMediaPlayer = null;
    }

    private final void resetCurrentEmbed() {
        ViewParams viewParams = this.viewParams;
        if (viewParams != null) {
            updateUI(viewParams.getPreviewImage(), viewParams.getProgressiveMediaUri(), viewParams.getEmbedType(), viewParams.getTargetWidth(), viewParams.getTargetHeight(), this.featureTag);
        }
    }

    private final void resetViews() {
        ViewParams viewParams = this.viewParams;
        if (viewParams != null) {
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
            simpleDraweeView.setVisibility(0);
            ImageView imageView = this.binding.f2126b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inlineMediaGifIndicator");
            imageView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
            PlayerView playerView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
            playerView.setVisibility(8);
            ImageView imageView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.inlineMediaVolumeToggle");
            imageView2.setVisibility(8);
            ImageView imageView3 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.inlineMediaPlayButton");
            imageView3.setVisibility(viewParams.getEmbedType() == EmbedType.VIDEO ? 0 : 8);
            ProgressBar progressBar = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
            progressBar.setVisibility(8);
            ImageView imageView4 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.inlineMediaVolumeToggle");
            imageView4.setVisibility(8);
        }
    }

    private final boolean shouldAutoPlay() {
        RenderableEmbedMedia previewImage;
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        ViewParams viewParams = this.viewParams;
        String str = null;
        EmbedType embedType = viewParams != null ? viewParams.getEmbedType() : null;
        ViewParams viewParams2 = this.viewParams;
        if (viewParams2 != null && (previewImage = viewParams2.getPreviewImage()) != null) {
            str = previewImage.url;
        }
        if (!embedResourceUtils.isAnimated(embedType, str)) {
            return true;
        }
        ViewParams viewParams3 = this.viewParams;
        return viewParams3 != null ? viewParams3.getAutoPlayGifs() : this.storeUserSettings.getIsAutoPlayGifsEnabled();
    }

    private final void updateUI(RenderableEmbedMedia previewImage, String progressiveMediaUri, EmbedType embedType, Integer targetWidth, Integer targetHeight, String featureTag) {
        resetViews();
        this.compositeSubscription.unsubscribe();
        if (targetWidth != null && targetHeight != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.width != targetWidth.intValue() || layoutParams.height != targetHeight.intValue()) {
                layoutParams.width = targetWidth.intValue();
                layoutParams.height = targetHeight.intValue();
                requestLayout();
            }
            if ((previewImage != null ? previewImage.url : null) != null) {
                SimpleDraweeView simpleDraweeView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
                MGImages.setImage$default(simpleDraweeView, EmbedResourceUtils.INSTANCE.getPreviewUrls(previewImage.url, targetWidth.intValue(), targetHeight.intValue(), shouldAutoPlay()), 0, 0, false, null, null, null, 252, null);
            }
        }
        if (progressiveMediaUri == null) {
            return;
        }
        AppMediaPlayer appMediaPlayerA = this.appMediaPlayer;
        if (appMediaPlayerA == null) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            appMediaPlayerA = AppMediaPlayerFactory.a(context);
        }
        this.appMediaPlayer = appMediaPlayerA;
        PlayerView playerView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
        playerView.setVisibility(shouldAutoPlay() ? 0 : 8);
        ImageView imageView = this.binding.f2126b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inlineMediaGifIndicator");
        imageView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
        Intrinsics3.checkNotNullParameter(progressiveMediaUri, "progressiveMediaUri");
        Intrinsics3.checkNotNullParameter(featureTag, "featureTag");
        EmbedType embedType2 = EmbedType.GIFV;
        MediaSource mediaSourceP = AnimatableValueParser.P(embedType == embedType2 ? MediaType.GIFV : MediaType.VIDEO, progressiveMediaUri, featureTag);
        this.compositeSubscription = new CompositeSubscription();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(appMediaPlayerA.volumeSubject, this, null, 2, null), InlineMediaView.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(appMediaPlayerA), 58, (Object) null);
        Observable<AppMediaPlayer.Event> observableK = appMediaPlayerA.eventSubject.K();
        Intrinsics3.checkNotNullExpressionValue(observableK, "eventSubject.onBackpressureBuffer()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableK, this, null, 2, null), InlineMediaView.class, (Context) null, new AnonymousClass3(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 58, (Object) null);
        if (embedType == embedType2) {
            boolean zShouldAutoPlay = shouldAutoPlay();
            PlayerView playerView2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(playerView2, "binding.inlineMediaPlayerView");
            AppMediaPlayer.b(appMediaPlayerA, mediaSourceP, zShouldAutoPlay, true, 0L, playerView2, null, 40);
            appMediaPlayerA.d(0.0f);
        } else {
            appMediaPlayerA.d(1.0f);
        }
        this.binding.e.setOnClickListener(new AnonymousClass5(mediaSourceP));
    }

    public static /* synthetic */ void updateUI$default(InlineMediaView inlineMediaView, RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, String str2, int i, Object obj) {
        inlineMediaView.updateUI(renderableEmbedMedia, str, embedType, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, str2);
    }

    public static /* synthetic */ void updateUIWithAttachment$default(InlineMediaView inlineMediaView, MessageAttachment messageAttachment, Integer num, Integer num2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        inlineMediaView.updateUIWithAttachment(messageAttachment, num, num2, z2);
    }

    public static /* synthetic */ void updateUIWithEmbed$default(InlineMediaView inlineMediaView, MessageEmbed messageEmbed, Integer num, Integer num2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        inlineMediaView.updateUIWithEmbed(messageEmbed, num, num2, z2);
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    public final void onPause() {
        clearPlayerAndSubscriptions();
    }

    public final void onResume() {
        resetCurrentEmbed();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        CoroutineScope coroutineScope;
        Intrinsics3.checkNotNullParameter(view, "view");
        resetCurrentEmbed();
        PlayerView playerView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
        if (!(playerView.getVideoSurfaceView() instanceof SurfaceView) || (coroutineScope = ViewCoroutineScope.getCoroutineScope(this)) == null) {
            return;
        }
        f.H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        clearPlayerAndSubscriptions();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics3.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            resetCurrentEmbed();
        } else {
            clearPlayerAndSubscriptions();
        }
    }

    public final void updateUIWithAttachment(MessageAttachment attachment, Integer targetWidth, Integer targetHeight, boolean autoPlayGifs) {
        EmbedType embedType;
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        MessageAttachmentType messageAttachmentTypeE = attachment.e();
        if ((messageAttachmentTypeE == MessageAttachmentType.IMAGE || messageAttachmentTypeE == MessageAttachmentType.VIDEO) && this.storeUserSettings.getIsAttachmentMediaInline()) {
            RenderableEmbedMedia renderableEmbedMediaCreateRenderableEmbedMediaFromAttachment = EmbedResourceUtils.INSTANCE.createRenderableEmbedMediaFromAttachment(attachment);
            this.featureTag = InlineMediaView.class.getSimpleName() + ": attachment";
            String proxyUrl = attachment.e() == MessageAttachmentType.VIDEO ? attachment.getProxyUrl() : null;
            int iOrdinal = messageAttachmentTypeE.ordinal();
            if (iOrdinal == 0) {
                embedType = EmbedType.VIDEO;
            } else if (iOrdinal == 1) {
                embedType = EmbedType.IMAGE;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                embedType = EmbedType.FILE;
            }
            diffViewParamsAndUpdateEmbed(renderableEmbedMediaCreateRenderableEmbedMediaFromAttachment, proxyUrl, embedType, targetWidth, targetHeight, this.featureTag, autoPlayGifs);
        }
    }

    public final void updateUIWithEmbed(MessageEmbed embed, Integer targetWidth, Integer targetHeight, boolean autoPlayGifs) {
        String url;
        Intrinsics3.checkNotNullParameter(embed, "embed");
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        if ((embedResourceUtils.getPreviewImage(embed) != null) && this.storeUserSettings.getIsEmbedMediaInlined() && this.storeUserSettings.getIsRenderEmbedsEnabled()) {
            this.featureTag = InlineMediaView.class.getSimpleName() + ": embed";
            EmbedVideo video = embed.getVideo();
            if (video == null || (url = video.getProxyUrl()) == null) {
                EmbedVideo video2 = embed.getVideo();
                url = video2 != null ? video2.getUrl() : null;
            }
            diffViewParamsAndUpdateEmbed(embedResourceUtils.getPreviewImage(embed), url, embed.getType(), targetWidth, targetHeight, this.featureTag, autoPlayGifs);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingA = InlineMediaViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(inlineMediaViewBindingA, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingA;
        this.storeUserSettings = StoreStream.INSTANCE.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    public /* synthetic */ InlineMediaView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingA = InlineMediaViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(inlineMediaViewBindingA, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingA;
        this.storeUserSettings = StoreStream.INSTANCE.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    public /* synthetic */ InlineMediaView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
