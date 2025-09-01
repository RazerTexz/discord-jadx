package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.b.SingleValuePropPremiumUpsellDialog;
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
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetChangeGuildIdentityBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
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
import rx.functions.Action1;
import rx.functions.Func0;

/* compiled from: WidgetChangeGuildIdentity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b8\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\b2\b\b\u0001\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0013\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\u0010R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001d\u00100\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u00106\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010'¨\u0006:"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentity;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState$Loaded;", "viewState", "", "handleBackPressed", "(Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState$Loaded;)Z", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState;", "", "configureUI", "(Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState;)V", "configureNickname", "(Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState$Loaded;)V", "configureUpsell", "configureAvatar", "navigateToUpsellModal", "()V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "showToast", "(I)V", "", "(Ljava/lang/String;)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "mimeType", "onImageChosen", "(Landroid/net/Uri;Ljava/lang/String;)V", "onImageCropped", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "imagesChangeDetector", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "Lkotlin/Function1;", "avatarSelectedResult", "Lkotlin/jvm/functions/Function1;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "discardConfirmed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel;", "viewModel", "Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", "binding", "imageSelectedResult", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChangeGuildIdentity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String USER_GUILD_PROFILE_VIEWED_CACHE_KEY = "USER_GUILD_PROFILE_VIEWED_CACHE_KEY";
    private Function1<? super String, Unit> avatarSelectedResult;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicBoolean discardConfirmed;
    private Function1<? super String, Unit> imageSelectedResult;
    private final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentity$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "source", "Landroid/content/Context;", "context", "", "launch", "(JLjava/lang/String;Landroid/content/Context;)V", WidgetChangeGuildIdentity.USER_GUILD_PROFILE_VIEWED_CACHE_KEY, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, String source, Context context) {
            Intrinsics3.checkNotNullParameter(source, "source");
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId).putExtra("com.discord.intent.extra.EXTRA_SOURCE", source);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…nts.EXTRA_SOURCE, source)");
            AppScreen2.d(context, WidgetChangeGuildIdentity.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "dataUrl", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureAvatar$1, reason: invalid class name */
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
            WidgetChangeGuildIdentity.access$getViewModel$p(WidgetChangeGuildIdentity.this).updateAvatar(str);
        }
    }

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureAvatar$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ List $avatarSheetOptions;
        public final /* synthetic */ WidgetChangeGuildIdentityViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetChangeGuildIdentity.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "selectedItemPosition", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureAvatar$2$1, reason: invalid class name */
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
                    WidgetChangeGuildIdentity.access$getViewModel$p(WidgetChangeGuildIdentity.this).updateAvatar(null);
                } else {
                    WidgetChangeGuildIdentity widgetChangeGuildIdentity = WidgetChangeGuildIdentity.this;
                    WidgetChangeGuildIdentity.access$setImageSelectedResult$p(widgetChangeGuildIdentity, WidgetChangeGuildIdentity.access$getAvatarSelectedResult$p(widgetChangeGuildIdentity));
                    WidgetChangeGuildIdentity.this.openMediaChooser();
                }
            }
        }

        public AnonymousClass2(WidgetChangeGuildIdentityViewModel.ViewState.Loaded loaded, List list) {
            this.$viewState = loaded;
            this.$avatarSheetOptions = list;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getShouldUpsell()) {
                WidgetChangeGuildIdentity.access$navigateToUpsellModal(WidgetChangeGuildIdentity.this);
                return;
            }
            SelectorBottomSheet.Companion aVar = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetChangeGuildIdentity.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            aVar.a(childFragmentManager, "", this.$avatarSheetOptions, false, new AnonymousClass1());
        }
    }

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public final /* synthetic */ WidgetChangeGuildIdentityViewModel.ViewState $viewState;

        public AnonymousClass1(WidgetChangeGuildIdentityViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            return Boolean.valueOf(WidgetChangeGuildIdentity.access$handleBackPressed(WidgetChangeGuildIdentity.this, (WidgetChangeGuildIdentityViewModel.ViewState.Loaded) this.$viewState));
        }
    }

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureUpsell$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChangeGuildIdentity.access$navigateToUpsellModal(WidgetChangeGuildIdentity.this);
        }
    }

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$handleBackPressed$1, reason: invalid class name */
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

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$handleBackPressed$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass2(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChangeGuildIdentity.access$getDiscardConfirmed$p(WidgetChangeGuildIdentity.this).set(true);
            this.$dialog.dismiss();
            FragmentActivity activity = WidgetChangeGuildIdentity.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ View $view;

        public AnonymousClass2(View view) {
            this.$view = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModelAccess$getViewModel$p = WidgetChangeGuildIdentity.access$getViewModel$p(WidgetChangeGuildIdentity.this);
            Context context = this.$view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            widgetChangeGuildIdentityViewModelAccess$getViewModel$p.saveMemberChanges(context);
            DimmerView.setDimmed$default(WidgetChangeGuildIdentity.access$getBinding$p(WidgetChangeGuildIdentity.this).f2252b, true, false, 2, null);
        }
    }

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetChangeGuildIdentityViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeGuildIdentityViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChangeGuildIdentityViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetChangeGuildIdentity.access$configureUI(WidgetChangeGuildIdentity.this, viewState);
        }
    }

    /* compiled from: WidgetChangeGuildIdentity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/guilds/profile/WidgetChangeGuildIdentityViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetChangeGuildIdentityViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeGuildIdentityViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChangeGuildIdentityViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            boolean z2 = true;
            if (!(event instanceof WidgetChangeGuildIdentityViewModel.Event.MemberUpdateFailed)) {
                if (event instanceof WidgetChangeGuildIdentityViewModel.Event.MemberUpdateSucceeded) {
                    WidgetChangeGuildIdentity.access$showToast(WidgetChangeGuildIdentity.this, R.string.per_guild_identity_saved);
                    WidgetChangeGuildIdentity.access$getDiscardConfirmed$p(WidgetChangeGuildIdentity.this).set(true);
                    FragmentActivity activity = WidgetChangeGuildIdentity.this.getActivity();
                    if (activity != null) {
                        activity.onBackPressed();
                        return;
                    }
                    return;
                }
                return;
            }
            WidgetChangeGuildIdentityViewModel.Event.MemberUpdateFailed memberUpdateFailed = (WidgetChangeGuildIdentityViewModel.Event.MemberUpdateFailed) event;
            String errorMessage = memberUpdateFailed.getErrorMessage();
            if (errorMessage != null && errorMessage.length() != 0) {
                z2 = false;
            }
            if (z2) {
                WidgetChangeGuildIdentity.access$showToast(WidgetChangeGuildIdentity.this, R.string.change_identity_modal_unknown_error);
            } else {
                WidgetChangeGuildIdentity.access$showToast(WidgetChangeGuildIdentity.this, memberUpdateFailed.getErrorMessage());
            }
        }
    }

    public WidgetChangeGuildIdentity() {
        super(R.layout.widget_change_guild_identity);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChangeGuildIdentity5.INSTANCE, null, 2, null);
        this.imageSelectedResult = WidgetChangeGuildIdentity6.INSTANCE;
        this.avatarSelectedResult = WidgetChangeGuildIdentity4.INSTANCE;
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
        this.discardConfirmed = new AtomicBoolean(false);
        WidgetChangeGuildIdentity8 widgetChangeGuildIdentity8 = new WidgetChangeGuildIdentity8(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChangeGuildIdentityViewModel.class), new WidgetChangeGuildIdentity$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChangeGuildIdentity8));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel.ViewState viewState) {
        widgetChangeGuildIdentity.configureUI(viewState);
    }

    public static final /* synthetic */ Function1 access$getAvatarSelectedResult$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.avatarSelectedResult;
    }

    public static final /* synthetic */ WidgetChangeGuildIdentityBinding access$getBinding$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.getBinding();
    }

    public static final /* synthetic */ AtomicBoolean access$getDiscardConfirmed$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.discardConfirmed;
    }

    public static final /* synthetic */ Function1 access$getImageSelectedResult$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.imageSelectedResult;
    }

    public static final /* synthetic */ WidgetChangeGuildIdentityViewModel access$getViewModel$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        return widgetChangeGuildIdentity.getViewModel();
    }

    public static final /* synthetic */ boolean access$handleBackPressed(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel.ViewState.Loaded loaded) {
        return widgetChangeGuildIdentity.handleBackPressed(loaded);
    }

    public static final /* synthetic */ void access$navigateToUpsellModal(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        widgetChangeGuildIdentity.navigateToUpsellModal();
    }

    public static final /* synthetic */ void access$setAvatarSelectedResult$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity, Function1 function1) {
        widgetChangeGuildIdentity.avatarSelectedResult = function1;
    }

    public static final /* synthetic */ void access$setImageSelectedResult$p(WidgetChangeGuildIdentity widgetChangeGuildIdentity, Function1 function1) {
        widgetChangeGuildIdentity.imageSelectedResult = function1;
    }

    public static final /* synthetic */ void access$showToast(WidgetChangeGuildIdentity widgetChangeGuildIdentity, int i) {
        widgetChangeGuildIdentity.showToast(i);
    }

    private final void configureAvatar(WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        SimpleDraweeView simpleDraweeView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        IconUtils.setIcon$default(simpleDraweeView, viewState.getDisplayedAvatarURL(), 0, (Function1) null, this.imagesChangeDetector, 12, (Object) null);
        this.avatarSelectedResult = new AnonymousClass1();
        List listMutableListOf = Collections2.mutableListOf(new SelectorBottomSheet2(getString(R.string.change_guild_member_avatar), null, null, null, null, null, null, 116));
        if (viewState.getDisplayingGuildAvatar()) {
            listMutableListOf.add(new SelectorBottomSheet2(getString(R.string.change_identity_modal_reset_primary_avatar), null, null, null, null, Integer.valueOf(ColorCompat.getColor(requireContext(), R.color.status_red_500)), null, 84));
        }
        getBinding().e.setOnClickListener(new AnonymousClass2(viewState, listMutableListOf));
    }

    private final void configureNickname(WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "textInputLayout");
        String currentNickname = viewState.getCurrentNickname();
        textInputLayout.setEndIconVisible(!(currentNickname == null || currentNickname.length() == 0));
        ViewExtensions.setEnabledAndAlpha$default(textInputLayout, viewState.getCanChangeNickname(), 0.0f, 2, null);
        textInputLayout.setHint(viewState.getCanChangeNickname() ? getString(R.string.nickname) : getString(R.string.change_identity_modal_change_nickname_disabled));
        textInputLayout.setPlaceholderText(viewState.getMeUser().getUsername());
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetChangeGuildIdentity2(this, viewState));
        textInputLayout.setEndIconOnClickListener(new WidgetChangeGuildIdentity3(this, viewState));
        TextInputLayout textInputLayout2 = getBinding().g;
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

    private final void configureUI(WidgetChangeGuildIdentityViewModel.ViewState viewState) {
        if (viewState instanceof WidgetChangeGuildIdentityViewModel.ViewState.Loaded) {
            if (!getViewModel().getTrackedModalOpen()) {
                AnalyticsTracker.INSTANCE.openModal("Change Server Identity", new Traits.Source(Traits.Location.Page.GUILD_CHANNEL, getViewModel().getSourceSection(), null, null, null, 28, null));
                getViewModel().setTrackedModalOpen(true);
            }
            WidgetChangeGuildIdentityViewModel.ViewState.Loaded loaded = (WidgetChangeGuildIdentityViewModel.ViewState.Loaded) viewState;
            configureNickname(loaded);
            configureAvatar(loaded);
            configureUpsell(loaded);
            AppFragment.setOnBackPressed$default(this, new AnonymousClass1(viewState), 0, 2, null);
            DimmerView.setDimmed$default(getBinding().f2252b, loaded.getDimmed(), false, 2, null);
            FloatingActionButton floatingActionButton = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.saveFab");
            floatingActionButton.setVisibility(loaded.getShowSaveFab() ? 0 : 8);
        }
    }

    private final void configureUpsell(WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        LinearLayout linearLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.upsellSection");
        linearLayout.setVisibility(viewState.getShouldUpsell() ? 0 : 8);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        if (getViewModel().getTrackedUpsell() || !viewState.getShouldUpsell()) {
            return;
        }
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.PerGuildIdentityInline, new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, "Change Per Server Identity Modal", "Nitro upsell button", null, null, 24, null), null, null, 12, null);
        getViewModel().setTrackedUpsell(true);
    }

    private final WidgetChangeGuildIdentityBinding getBinding() {
        return (WidgetChangeGuildIdentityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChangeGuildIdentityViewModel getViewModel() {
        return (WidgetChangeGuildIdentityViewModel) this.viewModel.getValue();
    }

    private final boolean handleBackPressed(WidgetChangeGuildIdentityViewModel.ViewState.Loaded viewState) {
        hideKeyboard(getBinding().g);
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

    private final void navigateToUpsellModal() {
        SingleValuePropPremiumUpsellDialog.Companion bVar = SingleValuePropPremiumUpsellDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker.PremiumUpsellType premiumUpsellType = AnalyticsTracker.PremiumUpsellType.PerGuildIdentityUpsellModal;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        String string = FormatUtils.i(resources, R.string.guild_member_avatar_upsell_title, new Object[0], null, 4).toString();
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        bVar.a(parentFragmentManager, premiumUpsellType, R.drawable.per_guild_identity_modal_image, string, FormatUtils.i(resources2, R.string.guild_member_avatar_upsell_body, new Object[0], null, 4).toString(), Traits.Location.Page.GUILD_CHANNEL, "Change Per Server Identity Modal", "Nitro upsell button");
    }

    private final void showToast(@StringRes int text) {
        AppToast.i(this, text, 0, 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$sam$rx_functions_Action1$0] */
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
            MGImages.requestImageCrop(requireContext(), this, uri, 1.0f, 1.0f, 1024);
            return;
        }
        Context context = getContext();
        Function1<? super String, Unit> widgetChangeGuildIdentity7 = this.imageSelectedResult;
        if (widgetChangeGuildIdentity7 != null) {
            widgetChangeGuildIdentity7 = new WidgetChangeGuildIdentity7(widgetChangeGuildIdentity7);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetChangeGuildIdentity7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$sam$rx_functions_Action1$0] */
    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> widgetChangeGuildIdentity7 = this.imageSelectedResult;
        if (widgetChangeGuildIdentity7 != null) {
            widgetChangeGuildIdentity7 = new WidgetChangeGuildIdentity7(widgetChangeGuildIdentity7);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetChangeGuildIdentity7);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        SharedPreferences.Editor editorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(USER_GUILD_PROFILE_VIEWED_CACHE_KEY, true);
        editorEdit.apply();
        setActionBarTitle(R.string.change_identity);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().f.setOnClickListener(new AnonymousClass2(view));
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.setNicknameText");
        showKeyboard(textInputLayout);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChangeGuildIdentity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChangeGuildIdentity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    public static final /* synthetic */ void access$showToast(WidgetChangeGuildIdentity widgetChangeGuildIdentity, String str) {
        widgetChangeGuildIdentity.showToast(str);
    }

    private final void showToast(String text) {
        AppToast.j(this, text, 0, 4);
    }
}
