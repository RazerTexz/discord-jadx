package com.discord.widgets.settings.profile;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.b.MultiValuePropPremiumUpsellDialog;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.a.y.SelectorBottomSheet;
import b.a.y.SelectorBottomSheet2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetSettingsUserProfileBinding;
import com.discord.simpleast.core.node.Node;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.file.FileUtils2;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.profile.EditUserOrGuildMemberProfileViewModel2;
import com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\bA\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\rJ\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\rJ\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u000fR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u00104\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R%\u0010:\u001a\n\u0018\u000105j\u0004\u0018\u0001`68B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b8\u00109R\"\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010(R\"\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010(R:\u0010?\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00010\u00190\u0019 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00010\u00190\u0019\u0018\u00010=0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/discord/widgets/settings/profile/WidgetEditUserOrGuildMemberProfile;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState;)V", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Event;)V", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState$Loaded;", "configureBio", "(Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState$Loaded;)V", "setCurrentBioFromEditor", "()V", "", "handleBackPressed", "(Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState$Loaded;)Z", "configureNick", "configureAvatarSelect", "configureBannerSelect", "configureFab", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "mimeType", "onImageChosen", "(Landroid/net/Uri;Ljava/lang/String;)V", "onImageCropped", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Ljava/util/concurrent/atomic/AtomicBoolean;", "discardConfirmed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/Function1;", "imageSelectedResult", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/databinding/WidgetSettingsUserProfileBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSettingsUserProfileBinding;", "binding", "Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel;", "viewModel", "", "Lcom/discord/primitives/GuildId;", "guildId$delegate", "getGuildId", "()Ljava/lang/Long;", "guildId", "avatarSelectedResult", "bannerSelectedResult", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "avatarRepresentativeColorHexSubject", "Lrx/subjects/BehaviorSubject;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEditUserOrGuildMemberProfile.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsUserProfileBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_AVATAR_SIZE = 1024;
    public static final int MAX_BANNER_FILE_SIZE_MB = 30;
    public static final int MAX_BANNER_IMAGE_SIZE = 1080;
    private final BehaviorSubject<String> avatarRepresentativeColorHexSubject;
    private Function1<? super String, Unit> avatarSelectedResult;
    private Function1<? super String, Unit> bannerSelectedResult;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicBoolean discardConfirmed;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private Function1<? super String, Unit> imageSelectedResult;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/settings/profile/WidgetEditUserOrGuildMemberProfile$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/app/AppTransitionActivity$Transition;", "transition", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "launch", "(Landroid/content/Context;Lcom/discord/app/AppTransitionActivity$Transition;Ljava/lang/Long;)V", "", "MAX_AVATAR_SIZE", "I", "MAX_BANNER_FILE_SIZE_MB", "MAX_BANNER_IMAGE_SIZE", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, AppTransitionActivity.Transition transition, Long l, int i, Object obj) {
            if ((i & 2) != 0) {
                transition = null;
            }
            if ((i & 4) != 0) {
                l = null;
            }
            companion.launch(context, transition, l);
        }

        public final void launch(Context context, AppTransitionActivity.Transition transition, Long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (transition != null) {
                intent.putExtra("transition", transition);
            }
            if (guildId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            AppScreen2.d(context, WidgetEditUserOrGuildMemberProfile.class, intent);
            StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.INSTANCE.getAnalytics(), "User Profile", null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "dataUrl", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "dataUrl");
            if (this.$viewState.getCanHaveAnimatedAvatars() || !IconUtils.INSTANCE.isDataUrlForGif(str)) {
                WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateAvatar(str);
                return;
            }
            MultiValuePropPremiumUpsellDialog.Companion companion = MultiValuePropPremiumUpsellDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            MultiValuePropPremiumUpsellDialog.Companion.a(companion, parentFragmentManager, 4, WidgetEditUserOrGuildMemberProfile.this.getString(R.string.premium_upsell_animated_avatar_active_mobile), null, Traits.Location.Page.USER_SETTINGS, "User Profile", null, null, false, false, 968);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $avatarSheetOptions;

        /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "selectedItemPosition", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                if (i != 0) {
                    if (i != 1) {
                        return;
                    }
                    WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateAvatar(null);
                } else {
                    WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
                    WidgetEditUserOrGuildMemberProfile.access$setImageSelectedResult$p(widgetEditUserOrGuildMemberProfile, WidgetEditUserOrGuildMemberProfile.access$getAvatarSelectedResult$p(widgetEditUserOrGuildMemberProfile));
                    WidgetEditUserOrGuildMemberProfile.this.openMediaChooser();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list) {
            super(0);
            this.$avatarSheetOptions = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            SelectorBottomSheet.Companion aVar = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            aVar.a(childFragmentManager, "", this.$avatarSheetOptions, false, new AnonymousClass1());
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "dataUrl", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "dataUrl");
            WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateBannerImage(str);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded $viewState;

        /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "avatarRepresentativeColorHex", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {

            /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03391 extends Lambda implements Function0<Unit> {
                public C03391() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
                    WidgetEditUserOrGuildMemberProfile.access$setImageSelectedResult$p(widgetEditUserOrGuildMemberProfile, WidgetEditUserOrGuildMemberProfile.access$getBannerSelectedResult$p(widgetEditUserOrGuildMemberProfile));
                    WidgetEditUserOrGuildMemberProfile.this.openMediaChooser();
                }
            }

            /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$2, reason: invalid class name and collision with other inner class name */
            public static final class C03402 extends Lambda implements Function0<Unit> {
                public C03402() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateBannerImage(null);
                }
            }

            /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "colorInt", "", "invoke", "(Ljava/lang/Integer;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$3, reason: invalid class name */
            public static final class AnonymousClass3 extends Lambda implements Function1<Integer, Unit> {
                public AnonymousClass3() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    String colorHexFromColorInt;
                    if (num != null) {
                        colorHexFromColorInt = ColorCompat.INSTANCE.getColorHexFromColorInt(num.intValue());
                    } else {
                        colorHexFromColorInt = null;
                    }
                    WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateBannerColor(colorHexFromColorInt);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                WidgetEditProfileBannerSheet.Companion companion = WidgetEditProfileBannerSheet.INSTANCE;
                Long lAccess$getGuildId$p = WidgetEditUserOrGuildMemberProfile.access$getGuildId$p(WidgetEditUserOrGuildMemberProfile.this);
                Intrinsics3.checkNotNullExpressionValue(str, "avatarRepresentativeColorHex");
                String nonDefaultColorPreviewHex = AnonymousClass2.this.$viewState.getNonDefaultColorPreviewHex();
                boolean hasBannerImageForDisplay = AnonymousClass2.this.$viewState.getHasBannerImageForDisplay();
                FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(lAccess$getGuildId$p, str, nonDefaultColorPreviewHex, hasBannerImageForDisplay, parentFragmentManager, new C03391(), new C03402(), new AnonymousClass3());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
            super(0);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Observable observableL = WidgetEditUserOrGuildMemberProfile.access$getAvatarRepresentativeColorHexSubject$p(WidgetEditUserOrGuildMemberProfile.this).Z(1).L();
            Intrinsics3.checkNotNullExpressionValue(observableL, "avatarRepresentativeColo…  .onBackpressureLatest()");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableL, WidgetEditUserOrGuildMemberProfile.this, null, 2, null), WidgetEditUserOrGuildMemberProfile.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3<R> implements Func0<Boolean> {
        public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState $viewState;

        public AnonymousClass3(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            return Boolean.valueOf(WidgetEditUserOrGuildMemberProfile.access$handleBackPressed(WidgetEditUserOrGuildMemberProfile.this, (EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded) this.$viewState));
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$handleBackPressed$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass1(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$handleBackPressed$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass2(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditUserOrGuildMemberProfile.access$getDiscardConfirmed$p(WidgetEditUserOrGuildMemberProfile.this).set(true);
            this.$dialog.dismiss();
            FragmentActivity activity = WidgetEditUserOrGuildMemberProfile.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ View $view;

        public AnonymousClass1(View view) {
            this.$view = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2Access$getViewModel$p = WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this);
            Context context = this.$view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            editUserOrGuildMemberProfileViewModel2Access$getViewModel$p.saveChanges(context);
            DimmerView.setDimmed$default(WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).i, true, false, 2, null);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/MotionEvent;", "event", "", "invoke", "(Landroid/view/MotionEvent;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<MotionEvent, Boolean> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(MotionEvent motionEvent) {
            return Boolean.valueOf(invoke2(motionEvent));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1 || actionMasked == 3) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                TextInputLayout textInputLayout = WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).d;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
                int width = textInputLayout.getWidth();
                TextInputLayout textInputLayout2 = WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).d;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
                int height = textInputLayout2.getHeight();
                int[] iArr = new int[2];
                WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).d.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                if (rawX < ((float) i) || rawX > ((float) (i + width)) || rawY < ((float) i2) || rawY > ((float) (i2 + height))) {
                    CardView cardView = WidgetEditUserOrGuildMemberProfile.access$getBinding$p(WidgetEditUserOrGuildMemberProfile.this).f2640b;
                    Intrinsics3.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
                    if (cardView.getVisibility() == 0) {
                        WidgetEditUserOrGuildMemberProfile.access$setCurrentBioFromEditor(WidgetEditUserOrGuildMemberProfile.this);
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(WidgetEditUserOrGuildMemberProfile.this).updateIsEditingBio(true);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "colorInt", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetEditUserOrGuildMemberProfile.access$getAvatarRepresentativeColorHexSubject$p(WidgetEditUserOrGuildMemberProfile.this).onNext(ColorCompat.INSTANCE.getColorHexFromColorInt(i));
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/Badge;", "it", "", "invoke", "(Lcom/discord/widgets/user/Badge;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Badge, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
            invoke2(badge);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Badge badge) {
            Intrinsics3.checkNotNullParameter(badge, "it");
            Badge.Companion companion = Badge.INSTANCE;
            FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.onBadgeClick(parentFragmentManager, WidgetEditUserOrGuildMemberProfile.this.requireContext());
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState;", "kotlin.jvm.PlatformType", "viewState", "", "invoke", "(Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<EditUserOrGuildMemberProfileViewModel2.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
            WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetEditUserOrGuildMemberProfile.access$configureUI(widgetEditUserOrGuildMemberProfile, viewState);
        }
    }

    /* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/settings/profile/SettingsUserProfileViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<EditUserOrGuildMemberProfileViewModel2.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditUserOrGuildMemberProfileViewModel2.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditUserOrGuildMemberProfileViewModel2.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetEditUserOrGuildMemberProfile.access$handleEvent(WidgetEditUserOrGuildMemberProfile.this, event);
        }
    }

    public WidgetEditUserOrGuildMemberProfile() {
        super(R.layout.widget_settings_user_profile);
        this.avatarSelectedResult = WidgetEditUserOrGuildMemberProfile$avatarSelectedResult$1.INSTANCE;
        this.bannerSelectedResult = WidgetEditUserOrGuildMemberProfile$bannerSelectedResult$1.INSTANCE;
        this.imageSelectedResult = WidgetEditUserOrGuildMemberProfile$imageSelectedResult$1.INSTANCE;
        this.guildId = LazyJVM.lazy(new WidgetEditUserOrGuildMemberProfile$guildId$2(this));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEditUserOrGuildMemberProfile$binding$2.INSTANCE, null, 2, null);
        WidgetEditUserOrGuildMemberProfile$viewModel$2 widgetEditUserOrGuildMemberProfile$viewModel$2 = new WidgetEditUserOrGuildMemberProfile$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EditUserOrGuildMemberProfileViewModel2.class), new WidgetEditUserOrGuildMemberProfile$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetEditUserOrGuildMemberProfile$viewModel$2));
        this.discardConfirmed = new AtomicBoolean(false);
        this.avatarRepresentativeColorHexSubject = BehaviorSubject.k0();
    }

    public static final /* synthetic */ void access$configureUI(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
        widgetEditUserOrGuildMemberProfile.configureUI(viewState);
    }

    public static final /* synthetic */ BehaviorSubject access$getAvatarRepresentativeColorHexSubject$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.avatarRepresentativeColorHexSubject;
    }

    public static final /* synthetic */ Function1 access$getAvatarSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.avatarSelectedResult;
    }

    public static final /* synthetic */ Function1 access$getBannerSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.bannerSelectedResult;
    }

    public static final /* synthetic */ WidgetSettingsUserProfileBinding access$getBinding$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.getBinding();
    }

    public static final /* synthetic */ AtomicBoolean access$getDiscardConfirmed$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.discardConfirmed;
    }

    public static final /* synthetic */ Long access$getGuildId$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.getGuildId();
    }

    public static final /* synthetic */ Function1 access$getImageSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.imageSelectedResult;
    }

    public static final /* synthetic */ EditUserOrGuildMemberProfileViewModel2 access$getViewModel$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        return widgetEditUserOrGuildMemberProfile.getViewModel();
    }

    public static final /* synthetic */ boolean access$handleBackPressed(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
        return widgetEditUserOrGuildMemberProfile.handleBackPressed(loaded);
    }

    public static final /* synthetic */ void access$handleEvent(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, EditUserOrGuildMemberProfileViewModel2.Event event) {
        widgetEditUserOrGuildMemberProfile.handleEvent(event);
    }

    public static final /* synthetic */ void access$setAvatarSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, Function1 function1) {
        widgetEditUserOrGuildMemberProfile.avatarSelectedResult = function1;
    }

    public static final /* synthetic */ void access$setBannerSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, Function1 function1) {
        widgetEditUserOrGuildMemberProfile.bannerSelectedResult = function1;
    }

    public static final /* synthetic */ void access$setCurrentBioFromEditor(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        widgetEditUserOrGuildMemberProfile.setCurrentBioFromEditor();
    }

    public static final /* synthetic */ void access$setImageSelectedResult$p(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, Function1 function1) {
        widgetEditUserOrGuildMemberProfile.imageSelectedResult = function1;
    }

    private final void configureAvatarSelect(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        this.avatarSelectedResult = new AnonymousClass1(viewState);
        SelectorBottomSheet2[] selectorBottomSheet2Arr = new SelectorBottomSheet2[1];
        selectorBottomSheet2Arr[0] = new SelectorBottomSheet2(viewState.getMeMember() != null ? viewState.getHasAvatarForDisplay() ? getString(R.string.change_guild_member_avatar) : getString(R.string.upload_guild_member_avatar) : viewState.getHasAvatarForDisplay() ? getString(R.string.user_settings_change_avatar) : getString(R.string.user_settings_upload_avatar), null, null, null, null, null, null, 116);
        List listMutableListOf = Collections2.mutableListOf(selectorBottomSheet2Arr);
        if (viewState.getHasAvatarForDisplay()) {
            listMutableListOf.add(new SelectorBottomSheet2(viewState.getMeMember() != null ? getString(R.string.change_identity_modal_reset_primary_avatar) : getString(R.string.user_settings_remove_avatar), null, null, null, null, Integer.valueOf(ColorCompat.getColor(requireContext(), R.color.status_red_500)), null, 84));
        }
        getBinding().o.setOnAvatarEdit(new AnonymousClass2(listMutableListOf));
    }

    private final void configureBannerSelect(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        this.bannerSelectedResult = new AnonymousClass1();
        getBinding().o.setOnBannerPress(new AnonymousClass2(viewState));
    }

    private final void configureBio(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        Drawable drawable;
        List<Node<MessageRenderContext>> bioAst = viewState.getBioAst();
        boolean showBioEditor = viewState.getShowBioEditor();
        CardView cardView = getBinding().f2640b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
        boolean z2 = cardView.getVisibility() == 0;
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.bioHelpText");
        textView.setVisibility(viewState.getMeMember() != null ? 0 : 8);
        TextView textView2 = getBinding().e;
        Drawable drawable2 = null;
        textView2.setText(viewState.getMeMember() != null ? FormatUtils.j(textView2, R.string.change_identity_bio_header, new Object[0], null, 4) : FormatUtils.j(textView2, R.string.user_profile_about_me, new Object[0], null, 4));
        if (viewState.getMeMember() != null && (drawable = ContextCompat.getDrawable(textView2.getContext(), R.drawable.ic_nitro_wheel_16dp)) != null) {
            TextView textView3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.bioHeader");
            DrawableCompat.setTint(drawable, ColorCompat.getThemedColor(textView3, R.attr.colorHeaderSecondary));
            drawable2 = drawable;
        }
        com.discord.utilities.drawable.DrawableCompat.setCompoundDrawablesCompat$default(textView2, (Drawable) null, (Drawable) null, drawable2, (Drawable) null, 11, (Object) null);
        CardView cardView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.bioPreviewCard");
        cardView2.setVisibility(showBioEditor ^ true ? 0 : 8);
        CardView cardView3 = getBinding().f2640b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.bioEditorCard");
        cardView3.setVisibility(showBioEditor ? 0 : 8);
        if (!showBioEditor) {
            if (bioAst != null) {
                LinkifiedTextView linkifiedTextView = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.bioPreviewText");
                Context context = linkifiedTextView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.bioPreviewText.context");
                getBinding().h.setDraweeSpanStringBuilder(AstRenderer.render(bioAst, new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetEditUserOrGuildMemberProfile$configureBio$renderContext$1(getViewModel()), null, null, 14328, null)));
                return;
            }
            return;
        }
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.setText(textInputLayout, viewState.getCurrentBio());
        if (z2) {
            return;
        }
        getBinding().d.requestFocus();
        TextInputLayout textInputLayout2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.moveCursorToEnd(textInputLayout2);
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.bioEditorTextInputFieldWrap");
        showKeyboard(textInputLayout3);
    }

    private final void configureFab(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.saveFab");
        floatingActionButton.setVisibility(viewState.getShowSaveFab() ? 0 : 8);
    }

    private final void configureNick(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        boolean z2 = viewState.getGuild() != null;
        LinearLayout linearLayout = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.nickContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "textInputLayout");
        String currentNickname = viewState.getCurrentNickname();
        textInputLayout.setEndIconVisible(!(currentNickname == null || currentNickname.length() == 0));
        ViewExtensions.setEnabledAndAlpha$default(textInputLayout, viewState.getCanEditNickname(), 0.0f, 2, null);
        textInputLayout.setHint(viewState.getCanEditNickname() ? getString(R.string.nickname) : getString(R.string.change_identity_modal_change_nickname_disabled));
        textInputLayout.setPlaceholderText(viewState.getUser().getUsername());
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$1(this, viewState));
        textInputLayout.setEndIconOnClickListener(new WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$2(this, viewState));
        TextInputLayout textInputLayout2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.setNicknameText");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        if (!Intrinsics3.areEqual(viewState.getCurrentNickname(), textOrEmpty)) {
            ViewExtensions.setText(textInputLayout, viewState.getCurrentNickname());
            if (textOrEmpty.length() == 0) {
                EditText editText = textInputLayout.getEditText();
                Selection.setSelection(editText != null ? editText.getText() : null, ViewExtensions.getTextOrEmpty(textInputLayout).length());
            }
        }
    }

    private final void configureUI(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
        if (viewState instanceof EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded) {
            EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded = (EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded) viewState;
            if (loaded.getGuild() != null) {
                setActionBarSubtitle(loaded.getGuild().getName());
            }
            configureNick(loaded);
            getBinding().k.setVisibility(loaded.getGuild() != null ? 0 : 8);
            if (loaded.getGuild() != null) {
                TextView textView = getBinding().j;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildMemberProfileHelpTextOverall");
                textView.setText(FormatUtils.k(this, R.string.change_identity_help_text_overall, new Object[]{loaded.getGuild().getName()}, null, 4));
            }
            configureBio(loaded);
            configureAvatarSelect(loaded);
            configureBannerSelect(loaded);
            configureFab(loaded);
            AppFragment.setOnBackPressed$default(this, new AnonymousClass3(viewState), 0, 2, null);
        }
    }

    private final WidgetSettingsUserProfileBinding getBinding() {
        return (WidgetSettingsUserProfileBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getGuildId() {
        return (Long) this.guildId.getValue();
    }

    private final EditUserOrGuildMemberProfileViewModel2 getViewModel() {
        return (EditUserOrGuildMemberProfileViewModel2) this.viewModel.getValue();
    }

    private final boolean handleBackPressed(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        if (viewState.isEditingBio()) {
            setCurrentBioFromEditor();
            return true;
        }
        if (!viewState.getIsDirty() || this.discardConfirmed.get()) {
            return false;
        }
        ViewDialogConfirmationBinding viewDialogConfirmationBindingB = ViewDialogConfirmationBinding.b(LayoutInflater.from(getActivity()));
        Intrinsics3.checkNotNullExpressionValue(viewDialogConfirmationBindingB, "ViewDialogConfirmationBi…tInflater.from(activity))");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewDialogConfirmationBindingB.a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(requ…logBinding.root).create()");
        viewDialogConfirmationBindingB.d.setText(R.string.discard_changes);
        viewDialogConfirmationBindingB.e.setText(R.string.discard_changes_description);
        viewDialogConfirmationBindingB.f2185b.setOnClickListener(new AnonymousClass1(alertDialogCreate));
        viewDialogConfirmationBindingB.c.setText(R.string.okay);
        viewDialogConfirmationBindingB.c.setOnClickListener(new AnonymousClass2(alertDialogCreate));
        alertDialogCreate.show();
        return true;
    }

    private final void handleEvent(EditUserOrGuildMemberProfileViewModel2.Event event) {
        if (Intrinsics3.areEqual(event, EditUserOrGuildMemberProfileViewModel2.Event.UserUpdateRequestCompleted.INSTANCE)) {
            DimmerView.setDimmed$default(getBinding().i, false, false, 2, null);
        }
    }

    private final void setCurrentBioFromEditor() {
        TextInputEditText textInputEditText = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.bioEditorTextInputField");
        getViewModel().updateBio(String.valueOf(textInputEditText.getText()));
        getViewModel().updateIsEditingBio(false);
        getBinding().d.clearFocus();
        hideKeyboard(getBinding().d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0] */
    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) throws IOException {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        if (!StringsJVM.startsWith$default(mimeType, "image", false, 2, null)) {
            AppToast.g(getContext(), R.string.user_settings_image_upload_filetype_error, 0, null, 12);
            return;
        }
        if (!Intrinsics3.areEqual(mimeType, "image/gif")) {
            MGImages.requestImageCrop(requireContext(), this, uri, Intrinsics3.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 5.0f : 1.0f, Intrinsics3.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 2.0f : 1.0f, Intrinsics3.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? MAX_BANNER_IMAGE_SIZE : 1024);
            return;
        }
        Long fileSizeBytes = FileUtils2.getFileSizeBytes(requireContext(), uri);
        if (fileSizeBytes != null && fileSizeBytes.longValue() >= 31457280) {
            AppToast.h(requireContext(), FormatUtils.k(this, R.string.user_settings_image_upload_file_too_large, new Object[]{30}, null, 4), 0, null, 12);
            return;
        }
        Context context = getContext();
        Function1<? super String, Unit> widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = this.imageSelectedResult;
        if (widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 != null) {
            widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = new WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0(widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0] */
    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = this.imageSelectedResult;
        if (widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 != null) {
            widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = new WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0(widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (getGuildId() != null) {
            setActionBarTitle(R.string.change_identity);
        } else {
            setActionBarTitle(R.string.user_settings_user_profile);
            setActionBarSubtitle(R.string.user_settings);
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().m.setOnClickListener(new AnonymousClass1(view));
        ((TouchInterceptingCoordinatorLayout) view).setOnInterceptTouchEvent(new AnonymousClass2());
        getBinding().c.setRawInputType(1);
        getBinding().g.setOnClickListener(new AnonymousClass3());
        getBinding().o.setOnAvatarRepresentativeColorUpdated(new AnonymousClass4());
        getBinding().o.setOnBadgeClick(new AnonymousClass5());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<EditUserOrGuildMemberProfileViewModel2.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetEditUserOrGuildMemberProfile.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModel().observeHeaderViewState());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetEditUserOrGuildMemberProfile.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
