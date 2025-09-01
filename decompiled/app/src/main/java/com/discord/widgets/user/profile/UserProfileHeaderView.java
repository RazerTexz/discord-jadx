package com.discord.widgets.user.profile;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import b.f.j.q.BasePostprocessor;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.user.UserProfile;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.databinding.UserProfileHeaderBadgeBinding;
import com.discord.databinding.UserProfileHeaderViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.viewcontroller.ViewDetachedFromWindowObservable;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.UsernameView;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.widgets.channels.UserAkaView;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.UserNameFormatter;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import rx.Observable;
import rx.Subscription;

/* compiled from: UserProfileHeaderView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u0001:\u0002SRB\u0017\u0012\u0006\u0010M\u001a\u00020L\u0012\u0006\u0010O\u001a\u00020N¢\u0006\u0004\bP\u0010QJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J!\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0014¢\u0006\u0004\b$\u0010\u000fJ\u0015\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b%\u0010\u0006J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b&\u0010\u0006R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R(\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010+\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u0018\u00109\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00102R.\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR.\u0010E\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00040:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010<\u001a\u0004\bF\u0010>\"\u0004\bG\u0010@R&\u0010J\u001a\u0012\u0012\u0004\u0012\u00020D\u0012\b\u0012\u00060IR\u00020\u00000H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006T"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;", "viewState", "", "configureBanner", "(Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;)V", "Lrx/Observable;", "", "observeRepresentativeColor", "(Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;)Lrx/Observable;", "updateBannerBackgroundColorAsync", "notifyAvatarColorListenerAsync", "editAvatar", "onTapBanner", "()V", "configurePrimaryName", "configureAka", "configureSecondaryName", "Lcom/discord/models/user/User;", "user", "Lcom/discord/models/member/GuildMember;", "guildMember", "Landroid/text/SpannableStringBuilder;", "getPrimaryNameTextForUser", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)Landroid/text/SpannableStringBuilder;", "", "getSecondaryNameTextForUser", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)Ljava/lang/CharSequence;", "Lcom/discord/api/activity/Activity;", "customStatusActivity", "", "shouldAnimate", "Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "getCustomStatusDraweeSpanStringBuilder", "(Lcom/discord/api/activity/Activity;Z)Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "onFinishInflate", "updateViewState", "updateBannerColor", "userProfileHeaderBackgroundColor", "I", "Lkotlin/Function0;", "onBannerPress", "Lkotlin/jvm/functions/Function0;", "getOnBannerPress", "()Lkotlin/jvm/functions/Function0;", "setOnBannerPress", "(Lkotlin/jvm/functions/Function0;)V", "Lrx/Subscription;", "setBannerBackgroundColorSubscription", "Lrx/Subscription;", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "bannerChangeDetector", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "onAvatarEdit", "getOnAvatarEdit", "setOnAvatarEdit", "syncAvatarRepresentativeColorSubscription", "Lkotlin/Function1;", "onAvatarRepresentativeColorUpdated", "Lkotlin/jvm/functions/Function1;", "getOnAvatarRepresentativeColorUpdated", "()Lkotlin/jvm/functions/Function1;", "setOnAvatarRepresentativeColorUpdated", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/UserProfileHeaderViewBinding;", "binding", "Lcom/discord/databinding/UserProfileHeaderViewBinding;", "Lcom/discord/widgets/user/Badge;", "onBadgeClick", "getOnBadgeClick", "setOnBadgeClick", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Lcom/discord/widgets/user/profile/UserProfileHeaderView$BadgeViewHolder;", "badgesAdapter", "Lcom/discord/utilities/views/SimpleRecyclerAdapter;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "BadgeViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class UserProfileHeaderView extends ConstraintLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SimpleRecyclerAdapter<Badge, BadgeViewHolder> badgesAdapter;
    private MGImages.DistinctChangeDetector bannerChangeDetector;
    private final UserProfileHeaderViewBinding binding;
    private Function0<Unit> onAvatarEdit;
    private Function1<? super Integer, Unit> onAvatarRepresentativeColorUpdated;
    private Function1<? super Badge, Unit> onBadgeClick;
    private Function0<Unit> onBannerPress;
    private Subscription setBannerBackgroundColorSubscription;
    private Subscription syncAvatarRepresentativeColorSubscription;
    private int userProfileHeaderBackgroundColor;

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderView$BadgeViewHolder;", "Lcom/discord/utilities/views/SimpleRecyclerAdapter$ViewHolder;", "Lcom/discord/widgets/user/Badge;", "data", "", "bind", "(Lcom/discord/widgets/user/Badge;)V", "Lcom/discord/databinding/UserProfileHeaderBadgeBinding;", "binding", "Lcom/discord/databinding/UserProfileHeaderBadgeBinding;", "<init>", "(Lcom/discord/widgets/user/profile/UserProfileHeaderView;Lcom/discord/databinding/UserProfileHeaderBadgeBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class BadgeViewHolder extends SimpleRecyclerAdapter.ViewHolder<Badge> {
        private final UserProfileHeaderBadgeBinding binding;
        public final /* synthetic */ UserProfileHeaderView this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public BadgeViewHolder(UserProfileHeaderView userProfileHeaderView, UserProfileHeaderBadgeBinding userProfileHeaderBadgeBinding) {
            Intrinsics3.checkNotNullParameter(userProfileHeaderBadgeBinding, "binding");
            this.this$0 = userProfileHeaderView;
            ImageView imageView = userProfileHeaderBadgeBinding.a;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.root");
            super(imageView);
            this.binding = userProfileHeaderBadgeBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(Badge badge) {
            bind2(badge);
        }

        /* renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(Badge data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.binding.f2165b.setImageResource(data.getIcon());
            ImageView imageView = this.binding.f2165b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.userSheetBadgeImage");
            CharSequence text = data.getText();
            if (text == null) {
                text = data.getTooltip();
            }
            imageView.setContentDescription(text);
            this.binding.f2165b.setOnClickListener(new UserProfileHeaderView2(this, data));
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/user/profile/UserProfileHeaderView$Companion;", "", "Lcom/discord/widgets/user/profile/UserProfileHeaderView;", "Lcom/discord/app/AppComponent;", "appComponent", "Lrx/Observable;", "Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState;", "observable", "", "bind", "(Lcom/discord/widgets/user/profile/UserProfileHeaderView;Lcom/discord/app/AppComponent;Lrx/Observable;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void bind(UserProfileHeaderView userProfileHeaderView, AppComponent appComponent, Observable<UserProfileHeaderViewModel.ViewState> observable) {
            Intrinsics3.checkNotNullParameter(userProfileHeaderView, "$this$bind");
            Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
            Intrinsics3.checkNotNullParameter(observable, "observable");
            Observable<R> observableG = observable.y(UserProfileHeaderView$Companion$bind$$inlined$filterIs$1.INSTANCE).G(UserProfileHeaderView$Companion$bind$$inlined$filterIs$2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, appComponent, null, 2, null), appComponent.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new UserProfileHeaderView3(userProfileHeaderView), 62, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "imageRequestBuilder", "", "invoke", "(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ Ref$BooleanRef $bannerColorUpdatedFromViewState;
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        /* compiled from: UserProfileHeaderView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/user/profile/UserProfileHeaderView$configureBanner$1$1", "Lb/f/j/q/a;", "Landroid/graphics/Bitmap;", "bitmap", "", "process", "(Landroid/graphics/Bitmap;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03521 extends BasePostprocessor {
            public C03521() {
            }

            @Override // b.f.j.q.BasePostprocessor
            public void process(Bitmap bitmap) {
                if (bitmap != null) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (anonymousClass1.$bannerColorUpdatedFromViewState.element) {
                        return;
                    }
                    UserProfileHeaderView.this.updateBannerColor(anonymousClass1.$viewState);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$BooleanRef ref$BooleanRef, UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            super(1);
            this.$bannerColorUpdatedFromViewState = ref$BooleanRef;
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            invoke2(imageRequestBuilder);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
            Intrinsics3.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            imageRequestBuilder.l = new C03521();
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$onTapBanner(UserProfileHeaderView.this);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$onTapBanner(UserProfileHeaderView.this);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"com/discord/widgets/user/profile/UserProfileHeaderView$getCustomStatusDraweeSpanStringBuilder$1", "Lcom/discord/utilities/textprocessing/node/EmojiNode$RenderContext;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "isAnimationEnabled", "Z", "()Z", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$getCustomStatusDraweeSpanStringBuilder$1, reason: invalid class name */
    public static final class AnonymousClass1 implements EmojiNode.RenderContext {
        public final /* synthetic */ boolean $shouldAnimate;
        private final Context context;
        private final boolean isAnimationEnabled;

        public AnonymousClass1(boolean z2) {
            this.$shouldAnimate = z2;
            this.context = UserProfileHeaderView.this.getContext();
            this.isAnimationEnabled = z2;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        public Context getContext() {
            return this.context;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        /* renamed from: isAnimationEnabled, reason: from getter */
        public boolean getIsAnimationEnabled() {
            return this.isAnimationEnabled;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$notifyAvatarColorListenerAsync$1, reason: invalid class name */
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
            UserProfileHeaderView.access$setSyncAvatarRepresentativeColorSubscription$p(UserProfileHeaderView.this, subscription);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "bannerBackgroundColor", "", "invoke", "(Ljava/lang/Integer;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$notifyAvatarColorListenerAsync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            if (num != null) {
                UserProfileHeaderView.this.getOnAvatarRepresentativeColorUpdated().invoke(num);
            }
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "it", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$observeRepresentativeColor$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Integer, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Integer num) {
            return Boolean.valueOf(num != null);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateBannerBackgroundColorAsync$1, reason: invalid class name */
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
            UserProfileHeaderView.access$setSetBannerBackgroundColorSubscription$p(UserProfileHeaderView.this, subscription);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "bannerBackgroundColor", "", "invoke", "(Ljava/lang/Integer;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateBannerBackgroundColorAsync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            if (num != null) {
                UserProfileHeaderView.access$getBinding$p(UserProfileHeaderView.this).c.setBackgroundColor(num.intValue());
            }
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/graphics/Bitmap;", "bitmap", "", "url", "", "invoke", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateViewState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Bitmap, String, Unit> {
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            super(2);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, String str) {
            invoke2(bitmap, str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Bitmap bitmap, String str) {
            Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
            GuildMember guildMember = this.$viewState.getGuildMember();
            if (guildMember == null || !guildMember.hasAvatar()) {
                RepresentativeColors2.getUserRepresentativeColors().handleBitmap(this.$viewState.getAvatarColorId(), bitmap, str);
            } else {
                RepresentativeColors2.getGuildMemberRepresentativeColors().handleBitmap(this.$viewState.getGuildMemberColorId(), bitmap, str);
            }
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateViewState$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        public AnonymousClass2(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$editAvatar(UserProfileHeaderView.this, this.$viewState);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateViewState$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        public AnonymousClass3(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$editAvatar(UserProfileHeaderView.this, this.$viewState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.user_profile_header_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.avatar_edit;
        CardView cardView = (CardView) viewInflate.findViewById(R.id.avatar_edit);
        if (cardView != null) {
            i = R.id.banner;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.banner);
            if (simpleDraweeView != null) {
                i = R.id.banner_edit;
                CardView cardView2 = (CardView) viewInflate.findViewById(R.id.banner_edit);
                if (cardView2 != null) {
                    i = R.id.gif_tag;
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.gif_tag);
                    if (imageView != null) {
                        i = R.id.large_avatar;
                        UserAvatarPresenceView userAvatarPresenceView = (UserAvatarPresenceView) viewInflate.findViewById(R.id.large_avatar);
                        if (userAvatarPresenceView != null) {
                            i = R.id.large_avatar_barrier;
                            Barrier barrier = (Barrier) viewInflate.findViewById(R.id.large_avatar_barrier);
                            if (barrier != null) {
                                i = R.id.user_aka;
                                UserAkaView userAkaView = (UserAkaView) viewInflate.findViewById(R.id.user_aka);
                                if (userAkaView != null) {
                                    i = R.id.user_profile_header_badges_recycler;
                                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.user_profile_header_badges_recycler);
                                    if (recyclerView != null) {
                                        i = R.id.user_profile_header_custom_status;
                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) viewInflate.findViewById(R.id.user_profile_header_custom_status);
                                        if (simpleDraweeSpanTextView != null) {
                                            i = R.id.user_profile_header_name_wrap;
                                            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.user_profile_header_name_wrap);
                                            if (linearLayout != null) {
                                                i = R.id.user_profile_header_primary_name;
                                                UsernameView usernameView = (UsernameView) viewInflate.findViewById(R.id.user_profile_header_primary_name);
                                                if (usernameView != null) {
                                                    i = R.id.user_profile_header_secondary_name;
                                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = (SimpleDraweeSpanTextView) viewInflate.findViewById(R.id.user_profile_header_secondary_name);
                                                    if (simpleDraweeSpanTextView2 != null) {
                                                        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                                        UserProfileHeaderViewBinding userProfileHeaderViewBinding = new UserProfileHeaderViewBinding(constraintLayout, cardView, simpleDraweeView, cardView2, imageView, userAvatarPresenceView, barrier, userAkaView, recyclerView, simpleDraweeSpanTextView, linearLayout, usernameView, simpleDraweeSpanTextView2, constraintLayout);
                                                        Intrinsics3.checkNotNullExpressionValue(userProfileHeaderViewBinding, "UserProfileHeaderViewBin…rom(context), this, true)");
                                                        this.binding = userProfileHeaderViewBinding;
                                                        this.bannerChangeDetector = new MGImages.DistinctChangeDetector();
                                                        this.onBadgeClick = UserProfileHeaderView6.INSTANCE;
                                                        this.onAvatarEdit = UserProfileHeaderView4.INSTANCE;
                                                        this.onBannerPress = UserProfileHeaderView7.INSTANCE;
                                                        this.onAvatarRepresentativeColorUpdated = UserProfileHeaderView5.INSTANCE;
                                                        RightToLeftGridLayoutManager rightToLeftGridLayoutManager = new RightToLeftGridLayoutManager(context, 3, 1, true);
                                                        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.userProfileHeaderBadgesRecycler");
                                                        recyclerView.setLayoutManager(rightToLeftGridLayoutManager);
                                                        SimpleRecyclerAdapter<Badge, BadgeViewHolder> simpleRecyclerAdapter = new SimpleRecyclerAdapter<>(null, new AnonymousClass1(), 1, null);
                                                        this.badgesAdapter = simpleRecyclerAdapter;
                                                        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.userProfileHeaderBadgesRecycler");
                                                        recyclerView.setAdapter(simpleRecyclerAdapter);
                                                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.UserProfileHeaderView);
                                                        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.UserProfileHeaderView)");
                                                        this.userProfileHeaderBackgroundColor = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, R.attr.primary_700));
                                                        typedArrayObtainStyledAttributes.recycle();
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
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$editAvatar(UserProfileHeaderView userProfileHeaderView, UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        userProfileHeaderView.editAvatar(loaded);
    }

    public static final /* synthetic */ UserProfileHeaderViewBinding access$getBinding$p(UserProfileHeaderView userProfileHeaderView) {
        return userProfileHeaderView.binding;
    }

    public static final /* synthetic */ Subscription access$getSetBannerBackgroundColorSubscription$p(UserProfileHeaderView userProfileHeaderView) {
        return userProfileHeaderView.setBannerBackgroundColorSubscription;
    }

    public static final /* synthetic */ Subscription access$getSyncAvatarRepresentativeColorSubscription$p(UserProfileHeaderView userProfileHeaderView) {
        return userProfileHeaderView.syncAvatarRepresentativeColorSubscription;
    }

    public static final /* synthetic */ void access$onTapBanner(UserProfileHeaderView userProfileHeaderView) {
        userProfileHeaderView.onTapBanner();
    }

    public static final /* synthetic */ void access$setSetBannerBackgroundColorSubscription$p(UserProfileHeaderView userProfileHeaderView, Subscription subscription) {
        userProfileHeaderView.setBannerBackgroundColorSubscription = subscription;
    }

    public static final /* synthetic */ void access$setSyncAvatarRepresentativeColorSubscription$p(UserProfileHeaderView userProfileHeaderView, Subscription subscription) {
        userProfileHeaderView.syncAvatarRepresentativeColorSubscription = subscription;
    }

    private final void configureAka(UserProfileHeaderViewModel.ViewState.Loaded viewState) throws Resources.NotFoundException {
        UserAkaView userAkaView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(userAkaView, "binding.userAka");
        userAkaView.setVisibility(viewState.getShowAkas() ? 0 : 8);
        this.binding.g.configure(viewState.getGuildMembersForAka());
    }

    private final void configureBanner(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        String banner;
        String forUserBanner;
        String str;
        GuildMember guildMember = viewState.getGuildMember();
        if (guildMember == null || (banner = guildMember.getBannerHash()) == null) {
            banner = viewState.getBanner();
        }
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        int iMax = Math.max(i, resources2.getDisplayMetrics().heightPixels);
        if (banner == null || !StringsJVM.startsWith$default(banner, "data:", false, 2, null)) {
            GuildMember guildMember2 = viewState.getGuildMember();
            if (guildMember2 == null || !guildMember2.hasBanner()) {
                forUserBanner = IconUtils.INSTANCE.getForUserBanner(viewState.getUser().getId(), banner, Integer.valueOf(iMax), viewState.getShouldAnimateBanner());
            } else {
                IconUtils iconUtils = IconUtils.INSTANCE;
                GuildMember guildMember3 = viewState.getGuildMember();
                forUserBanner = iconUtils.getForGuildMemberBanner(banner, (guildMember3 != null ? Long.valueOf(guildMember3.getGuildId()) : null).longValue(), viewState.getUser().getId(), Integer.valueOf(iMax), viewState.getShouldAnimateBanner());
            }
            str = forUserBanner;
        } else {
            str = banner;
        }
        boolean z2 = !(str == null || StringsJVM.isBlank(str));
        boolean z3 = (banner != null && IconUtils.INSTANCE.isDataUrlForGif(banner)) || (banner != null && !StringsJVM.startsWith$default(banner, "data:", false, 2, null) && IconUtils.INSTANCE.isImageHashAnimated(banner));
        SimpleDraweeView simpleDraweeView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.banner");
        simpleDraweeView.setAspectRatio(!z2 ? 5.0f : 2.5f);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        notifyAvatarColorListenerAsync(viewState);
        if ((!z2 || z3) && viewState.getIsProfileLoaded()) {
            updateBannerColor(viewState);
            ref$BooleanRef.element = true;
        } else if (!viewState.getIsProfileLoaded()) {
            this.binding.c.setBackgroundColor(this.userProfileHeaderBackgroundColor);
        }
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.banner");
        MGImages.setImage$default(simpleDraweeView2, str, 0, 0, false, new AnonymousClass1(ref$BooleanRef, viewState), this.bannerChangeDetector, 28, null);
        this.binding.c.setOnClickListener(new AnonymousClass2());
        this.binding.d.setOnClickListener(new AnonymousClass3());
        ImageView imageView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.gifTag");
        imageView.setVisibility(viewState.getShouldShowGIFTag() ? 0 : 8);
    }

    private final void configurePrimaryName(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        User user = viewState.getUser();
        GuildMember guildMember = viewState.getGuildMember();
        int dimension = (int) getResources().getDimension(R.dimen.avatar_size_medium);
        this.binding.j.b(getPrimaryNameTextForUser(user, guildMember), viewState.getShowMediumAvatar() ? IconUtils.getForUser(viewState.getUser(), false, Integer.valueOf(dimension)) : null, false, Integer.valueOf(dimension), Integer.valueOf(this.userProfileHeaderBackgroundColor));
        this.binding.j.a(user.getIsBot(), user.getIsSystemUser() ? R.string.system_dm_tag_system : R.string.bot_tag, UserUtils.INSTANCE.isVerifiedBot(user));
    }

    private final void configureSecondaryName(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        User user = viewState.getUser();
        GuildMember guildMember = viewState.getGuildMember();
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        if (viewState.getShowSmallAvatar()) {
            int dimension = (int) getResources().getDimension(R.dimen.avatar_size_profile_small);
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilderExtensions.setAvatar$default(draweeSpanStringBuilder, context, IconUtils.getForUser(viewState.getUser(), false, Integer.valueOf(dimension)), false, Integer.valueOf(dimension), Integer.valueOf(this.userProfileHeaderBackgroundColor), null, 32, null);
        }
        CharSequence secondaryNameTextForUser = getSecondaryNameTextForUser(user, guildMember);
        boolean z2 = ((secondaryNameTextForUser == null || StringsJVM.isBlank(secondaryNameTextForUser)) || viewState.getShowAkas()) ? false : true;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.userProfileHeaderSecondaryName");
        simpleDraweeSpanTextView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            draweeSpanStringBuilder.append(secondaryNameTextForUser);
            this.binding.k.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        }
    }

    private final void editAvatar(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        if (viewState.getEditable()) {
            this.onAvatarEdit.invoke();
        }
    }

    private final DraweeSpanStringBuilder getCustomStatusDraweeSpanStringBuilder(Activity customStatusActivity, boolean shouldAnimate) {
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        ActivityEmoji emoji = customStatusActivity.getEmoji();
        EmojiNode emojiNodeFrom$default = null;
        if (emoji != null) {
            EmojiNode.Companion companion = EmojiNode.INSTANCE;
            emojiNodeFrom$default = EmojiNode.Companion.from$default(companion, 0, companion.generateEmojiIdAndType(emoji), 1, (Object) null);
        }
        if (emojiNodeFrom$default != null) {
            emojiNodeFrom$default.render((SpannableStringBuilder) draweeSpanStringBuilder, (DraweeSpanStringBuilder) new AnonymousClass1(shouldAnimate));
        }
        String state = customStatusActivity.getState();
        if (state != null) {
            if (emojiNodeFrom$default != null) {
                draweeSpanStringBuilder.append((char) 8194);
            }
            draweeSpanStringBuilder.append((CharSequence) state);
        }
        return draweeSpanStringBuilder;
    }

    private final SpannableStringBuilder getPrimaryNameTextForUser(User user, GuildMember guildMember) {
        String nick = guildMember != null ? guildMember.getNick() : null;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        return UserNameFormatter.getSpannableForUserNameWithDiscrim(user, nick, context, R.attr.colorHeaderPrimary, R.attr.font_display_bold, R.integer.uikit_textsize_xxlarge_sp, R.attr.colorHeaderSecondary, R.attr.font_primary_semibold, R.integer.uikit_textsize_xxlarge_sp);
    }

    private final CharSequence getSecondaryNameTextForUser(User user, GuildMember guildMember) {
        if (guildMember == null || guildMember.getNick() == null) {
            return null;
        }
        return UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
    }

    private final void notifyAvatarColorListenerAsync(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Subscription subscription = this.syncAvatarRepresentativeColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(observeRepresentativeColor(viewState), UserProfileHeaderView.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }

    private final Observable<Integer> observeRepresentativeColor(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        GuildMember guildMember = viewState.getGuildMember();
        Observable<Integer> observableB0 = ObservableExtensionsKt.ui((guildMember == null || !guildMember.hasAvatar()) ? RepresentativeColors2.getUserRepresentativeColors().observeRepresentativeColor(viewState.getAvatarColorId()) : RepresentativeColors2.getGuildMemberRepresentativeColors().observeRepresentativeColor(viewState.getGuildMemberColorId())).a0(new ViewDetachedFromWindowObservable(this).observe()).b0(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableB0, "representativeColorObser….takeUntil { it != null }");
        return observableB0;
    }

    private final void onTapBanner() {
        this.onBannerPress.invoke();
    }

    private final void updateBannerBackgroundColorAsync(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Subscription subscription = this.setBannerBackgroundColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(observeRepresentativeColor(viewState), UserProfileHeaderView.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }

    public final Function0<Unit> getOnAvatarEdit() {
        return this.onAvatarEdit;
    }

    public final Function1<Integer, Unit> getOnAvatarRepresentativeColorUpdated() {
        return this.onAvatarRepresentativeColorUpdated;
    }

    public final Function1<Badge, Unit> getOnBadgeClick() {
        return this.onBadgeClick;
    }

    public final Function0<Unit> getOnBannerPress() {
        return this.onBannerPress;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.userProfileHeaderBackgroundColor;
        if (i != 0) {
            setBackgroundColor(i);
            this.binding.f.setAvatarBackgroundColor(this.userProfileHeaderBackgroundColor);
            this.binding.c.setBackgroundColor(this.userProfileHeaderBackgroundColor);
        }
    }

    public final void setOnAvatarEdit(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onAvatarEdit = function0;
    }

    public final void setOnAvatarRepresentativeColorUpdated(Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onAvatarRepresentativeColorUpdated = function1;
    }

    public final void setOnBadgeClick(Function1<? super Badge, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onBadgeClick = function1;
    }

    public final void setOnBannerPress(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onBannerPress = function0;
    }

    public final void updateBannerColor(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Integer numValueOf;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        String bannerColorHex = viewState.getBannerColorHex();
        if (bannerColorHex != null) {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(bannerColorHex));
            } catch (IllegalArgumentException e) {
                Logger.e$default(AppLog.g, outline.w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            this.binding.c.setBackgroundColor(numValueOf.intValue());
        }
        if (numValueOf == null) {
            updateBannerBackgroundColorAsync(viewState);
        }
    }

    public final void updateViewState(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        this.binding.f.setOnAvatarBitmapLoadedListener(new AnonymousClass1(viewState));
        this.binding.f.setOnClickListener(new AnonymousClass2(viewState));
        this.binding.f2166b.setOnClickListener(new AnonymousClass3(viewState));
        configureBanner(viewState);
        this.binding.f.a(new UserAvatarPresenceView.a(viewState.getUser(), viewState.getPresence(), viewState.getStreamContext(), viewState.getShowPresence(), viewState.getGuildMember()));
        configurePrimaryName(viewState);
        configureAka(viewState);
        configureSecondaryName(viewState);
        Badge.Companion companion = Badge.INSTANCE;
        User user = viewState.getUser();
        UserProfile userProfile = viewState.getUserProfile();
        boolean zIsMeUserPremium = viewState.isMeUserPremium();
        boolean zIsMeUserVerified = viewState.isMeUserVerified();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        this.badgesAdapter.setData(companion.getBadgesForUser(user, userProfile, zIsMeUserPremium, zIsMeUserVerified, context));
        Presence presence = viewState.getPresence();
        Activity customStatusActivity = presence != null ? PresenceUtils.INSTANCE.getCustomStatusActivity(presence) : null;
        if (customStatusActivity != null) {
            this.binding.i.setDraweeSpanStringBuilder(getCustomStatusDraweeSpanStringBuilder(customStatusActivity, viewState.getAllowAnimatedEmojis()));
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.userProfileHeaderCustomStatus");
        simpleDraweeSpanTextView.setVisibility(customStatusActivity != null ? 0 : 8);
        CardView cardView = this.binding.f2166b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.avatarEdit");
        cardView.setVisibility(viewState.getEditable() ? 0 : 8);
        CardView cardView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.bannerEdit");
        cardView2.setVisibility(viewState.getEditable() ? 0 : 8);
    }

    /* compiled from: UserProfileHeaderView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00060\u0004R\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Lcom/discord/widgets/user/profile/UserProfileHeaderView$BadgeViewHolder;", "Lcom/discord/widgets/user/profile/UserProfileHeaderView;", "invoke", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/discord/widgets/user/profile/UserProfileHeaderView$BadgeViewHolder;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<LayoutInflater, ViewGroup, BadgeViewHolder> {
        public AnonymousClass1() {
            super(2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final BadgeViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Intrinsics3.checkNotNullParameter(layoutInflater, "inflater");
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            View viewInflate = layoutInflater.inflate(R.layout.user_profile_header_badge, viewGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            ImageView imageView = (ImageView) viewInflate;
            UserProfileHeaderBadgeBinding userProfileHeaderBadgeBinding = new UserProfileHeaderBadgeBinding(imageView, imageView);
            Intrinsics3.checkNotNullExpressionValue(userProfileHeaderBadgeBinding, "UserProfileHeaderBadgeBi…(inflater, parent, false)");
            return new BadgeViewHolder(UserProfileHeaderView.this, userProfileHeaderBadgeBinding);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ BadgeViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return invoke2(layoutInflater, viewGroup);
        }
    }
}
