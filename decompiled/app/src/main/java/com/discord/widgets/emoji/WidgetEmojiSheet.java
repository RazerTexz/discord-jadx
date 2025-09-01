package com.discord.widgets.emoji;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetEmojiSheetBinding;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.emoji.EmojiSheetViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.text.NumberFormat;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetEmojiSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b=\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0014\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0012H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00105\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001d\u0010<\u001a\u0002088B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010)\u001a\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/discord/widgets/emoji/WidgetEmojiSheet;", "Lcom/discord/app/AppBottomSheet;", "", "showLoading", "()V", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiCustom;", "viewState", "configureCustomEmoji", "(Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiCustom;)V", "", "isUserPremium", "isUserInGuild", "Lcom/discord/models/guild/Guild;", "guild", "configureButtons", "(ZZLcom/discord/models/guild/Guild;)V", "isCurrent", "isPublic", "", "approximateOnline", "configureGuildSection", "(Lcom/discord/models/guild/Guild;ZZLjava/lang/Integer;)V", "canFavorite", "isFavorite", "configureFavorite", "(ZZ)V", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiUnicode;", "configureUnicodeEmoji", "(Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState$EmojiUnicode;)V", "isCurrentGuild", "isGuildPublic", "getCustomEmojiInfoText", "(ZZZZ)I", "getContentViewResId", "()I", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "emojiIdAndType$delegate", "Lkotlin/Lazy;", "getEmojiIdAndType", "()Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "emojiIdAndType", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "imageChangeDetector", "Lcom/discord/utilities/images/MGImages$DistinctChangeDetector;", "Lcom/discord/databinding/WidgetEmojiSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetEmojiSheetBinding;", "binding", "emojiSizePx", "I", "Lcom/discord/widgets/emoji/EmojiSheetViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/emoji/EmojiSheetViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEmojiSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEmojiSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEmojiSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMOJI_ID_AND_TYPE = "EXTRA_EMOJI_ID_AND_TYPE";
    private static final int FLIPPER_INDEX_CONTENT = 0;
    private static final int FLIPPER_INDEX_LOADING = 1;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: emojiIdAndType$delegate, reason: from kotlin metadata */
    private final Lazy emojiIdAndType;
    private final int emojiSizePx;
    private final MGImages.DistinctChangeDetector imageChangeDetector;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetEmojiSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/emoji/WidgetEmojiSheet$Companion;", "", "Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;", "emojiIdAndType", "", "getNoticeName", "(Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;)Ljava/lang/String;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "show", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;)V", "enqueueNotice", "(Lcom/discord/utilities/textprocessing/node/EmojiNode$EmojiIdAndType;)V", WidgetEmojiSheet.EXTRA_EMOJI_ID_AND_TYPE, "Ljava/lang/String;", "", "FLIPPER_INDEX_CONTENT", "I", "FLIPPER_INDEX_LOADING", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final String getNoticeName(EmojiNode.EmojiIdAndType emojiIdAndType) {
            String str = "Emoji Sheet: " + emojiIdAndType.toString();
            Intrinsics3.checkNotNullExpressionValue(str, "StringBuilder(\"Emoji She…)\n            .toString()");
            return str;
        }

        public final void enqueueNotice(EmojiNode.EmojiIdAndType emojiIdAndType) {
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            String noticeName = getNoticeName(emojiIdAndType);
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(noticeName, null, 0L, 0, false, null, 0L, false, 0L, new WidgetEmojiSheet6(emojiIdAndType, noticeName), Opcodes.INVOKEVIRTUAL, null));
        }

        public final void show(FragmentManager fragmentManager, EmojiNode.EmojiIdAndType emojiIdAndType) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            WidgetEmojiSheet widgetEmojiSheet = new WidgetEmojiSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetEmojiSheet.EXTRA_EMOJI_ID_AND_TYPE, emojiIdAndType);
            widgetEmojiSheet.setArguments(bundle);
            widgetEmojiSheet.show(fragmentManager, WidgetEmojiSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEmojiSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/emoji/EmojiSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.emoji.WidgetEmojiSheet$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<EmojiSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmojiSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmojiSheetViewModel.ViewState viewState) {
            Unit unit;
            Intrinsics3.checkNotNullParameter(viewState, "it");
            if (Intrinsics3.areEqual(viewState, EmojiSheetViewModel.ViewState.Loading.INSTANCE)) {
                WidgetEmojiSheet.access$showLoading(WidgetEmojiSheet.this);
                unit = Unit.a;
            } else if (viewState instanceof EmojiSheetViewModel.ViewState.EmojiCustom) {
                WidgetEmojiSheet.access$configureCustomEmoji(WidgetEmojiSheet.this, (EmojiSheetViewModel.ViewState.EmojiCustom) viewState);
                unit = Unit.a;
            } else if (viewState instanceof EmojiSheetViewModel.ViewState.EmojiUnicode) {
                WidgetEmojiSheet.access$configureUnicodeEmoji(WidgetEmojiSheet.this, (EmojiSheetViewModel.ViewState.EmojiUnicode) viewState);
                unit = Unit.a;
            } else {
                if (!Intrinsics3.areEqual(viewState, EmojiSheetViewModel.ViewState.Invalid.INSTANCE) && !Intrinsics3.areEqual(viewState, EmojiSheetViewModel.ViewState.Dismiss.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                WidgetEmojiSheet.this.dismiss();
                unit = Unit.a;
            }
            KotlinExtensions.getExhaustive(unit);
        }
    }

    public WidgetEmojiSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEmojiSheet7.INSTANCE, null, 2, null);
        this.emojiSizePx = IconUtils.getMediaProxySize(DimenUtils.dpToPixels(48));
        this.imageChangeDetector = new MGImages.DistinctChangeDetector();
        WidgetEmojiSheet9 widgetEmojiSheet9 = new WidgetEmojiSheet9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EmojiSheetViewModel.class), new WidgetEmojiSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetEmojiSheet9));
        this.emojiIdAndType = LazyJVM.lazy(new WidgetEmojiSheet8(this));
    }

    public static final /* synthetic */ void access$configureCustomEmoji(WidgetEmojiSheet widgetEmojiSheet, EmojiSheetViewModel.ViewState.EmojiCustom emojiCustom) {
        widgetEmojiSheet.configureCustomEmoji(emojiCustom);
    }

    public static final /* synthetic */ void access$configureUnicodeEmoji(WidgetEmojiSheet widgetEmojiSheet, EmojiSheetViewModel.ViewState.EmojiUnicode emojiUnicode) {
        widgetEmojiSheet.configureUnicodeEmoji(emojiUnicode);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetEmojiSheet widgetEmojiSheet) {
        return widgetEmojiSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ EmojiNode.EmojiIdAndType access$getEmojiIdAndType$p(WidgetEmojiSheet widgetEmojiSheet) {
        return widgetEmojiSheet.getEmojiIdAndType();
    }

    public static final /* synthetic */ EmojiSheetViewModel access$getViewModel$p(WidgetEmojiSheet widgetEmojiSheet) {
        return widgetEmojiSheet.getViewModel();
    }

    public static final /* synthetic */ void access$showLoading(WidgetEmojiSheet widgetEmojiSheet) {
        widgetEmojiSheet.showLoading();
    }

    private final void configureButtons(boolean isUserPremium, boolean isUserInGuild, Guild guild) {
        WidgetEmojiSheetBinding binding = getBinding();
        if (guild == null) {
            FrameLayout frameLayout = binding.f2377b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "buttonContainer");
            frameLayout.setVisibility(8);
            return;
        }
        if (!isUserPremium) {
            FrameLayout frameLayout2 = binding.f2377b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "buttonContainer");
            frameLayout2.setVisibility(0);
            MaterialButton materialButton = binding.q;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "premiumBtn");
            materialButton.setVisibility(0);
            MaterialButton materialButton2 = binding.o;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "joinBtn");
            materialButton2.setVisibility(8);
            binding.q.setOnClickListener(new WidgetEmojiSheet2(this, guild, isUserPremium, isUserInGuild));
            return;
        }
        if (isUserInGuild) {
            FrameLayout frameLayout3 = binding.f2377b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "buttonContainer");
            frameLayout3.setVisibility(8);
            return;
        }
        FrameLayout frameLayout4 = binding.f2377b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout4, "buttonContainer");
        frameLayout4.setVisibility(0);
        MaterialButton materialButton3 = binding.q;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "premiumBtn");
        materialButton3.setVisibility(8);
        MaterialButton materialButton4 = binding.o;
        Intrinsics3.checkNotNullExpressionValue(materialButton4, "joinBtn");
        materialButton4.setVisibility(0);
        binding.o.setOnClickListener(new WidgetEmojiSheet3(this, guild, isUserPremium, isUserInGuild));
    }

    private final void configureCustomEmoji(EmojiSheetViewModel.ViewState.EmojiCustom viewState) {
        WidgetEmojiSheetBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        AppViewFlipper appViewFlipper = binding.a;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.root");
        ViewParent parent = appViewFlipper.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(150L);
            TransitionManager.beginDelayedTransition(viewGroup, changeBounds);
        }
        EmojiSheetViewModel.Companion.CustomEmojGuildInfo emojiGuildInfo = viewState.getEmojiGuildInfo();
        if (!(emojiGuildInfo instanceof EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known)) {
            emojiGuildInfo = null;
        }
        EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known known = (EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known) emojiGuildInfo;
        boolean zIsPublic = viewState.getEmojiGuildInfo().getIsPublic();
        boolean zIsUserInGuild = viewState.getEmojiGuildInfo().getIsUserInGuild();
        EmojiNode.EmojiIdAndType.Custom emojiCustom = viewState.getEmojiCustom();
        boolean zIsUserPremium = viewState.isUserPremium();
        boolean zIsCurrentGuild = viewState.isCurrentGuild();
        WidgetEmojiSheetBinding binding2 = getBinding();
        SimpleDraweeView simpleDraweeView = binding2.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "emojiIv");
        MGImages.setImage$default(simpleDraweeView, ModelEmojiCustom.getImageUri(emojiCustom.getId(), emojiCustom.isAnimated(), this.emojiSizePx), 0, 0, false, null, this.imageChangeDetector, 60, null);
        TextView textView = binding2.p;
        Intrinsics3.checkNotNullExpressionValue(textView, "nameTv");
        textView.setText(MentionUtils.EMOJIS_AND_STICKERS_CHAR + emojiCustom.getName() + MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        TextView textView2 = binding2.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "emojiInfoTv");
        textView2.setText(getString(getCustomEmojiInfoText(zIsCurrentGuild, zIsUserInGuild, zIsPublic, zIsUserPremium)));
        configureButtons(zIsUserPremium, zIsUserInGuild, known != null ? known.getGuild() : null);
        configureGuildSection(known != null ? known.getGuild() : null, zIsCurrentGuild, zIsPublic, known != null ? known.getApproximateOnline() : null);
        configureFavorite(viewState.getCanFavorite(), viewState.isFavorite());
        AppViewFlipper appViewFlipper2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.emojiSheetFlipper");
        appViewFlipper2.setDisplayedChild(0);
    }

    private final void configureFavorite(boolean canFavorite, boolean isFavorite) {
        FrameLayout frameLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.favoriteContainer");
        frameLayout.setVisibility(canFavorite ? 0 : 8);
        MaterialButton materialButton = getBinding().f;
        ViewExtensions.fadeBy(materialButton, !isFavorite, 200L);
        materialButton.setOnClickListener(new WidgetEmojiSheet4(this, isFavorite));
        MaterialButton materialButton2 = getBinding().h;
        ViewExtensions.fadeBy(materialButton2, isFavorite, 200L);
        materialButton2.setOnClickListener(new WidgetEmojiSheet5(this, isFavorite));
    }

    private final void configureGuildSection(Guild guild, boolean isCurrent, boolean isPublic, Integer approximateOnline) {
        WidgetEmojiSheetBinding binding = getBinding();
        if (guild == null || isCurrent) {
            LinearLayout linearLayout = binding.k;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "guildContainer");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = binding.k;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "guildContainer");
        linearLayout2.setVisibility(0);
        if (guild.hasIcon()) {
            SimpleDraweeView simpleDraweeView = binding.m;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "guildIv");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, guild, 0, (MGImages.ChangeDetector) this.imageChangeDetector, true, 4, (Object) null);
        } else {
            binding.j.setBackgroundResource(R.drawable.drawable_circle_black);
            int themedColor = ColorCompat.getThemedColor(requireContext(), R.attr.colorBackgroundSecondary);
            FrameLayout frameLayout = binding.j;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "guildAvatarWrap");
            frameLayout.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            TextView textView = binding.i;
            Intrinsics3.checkNotNullExpressionValue(textView, "guildAvatarText");
            textView.setText(guild.getShortName());
        }
        int i = guild.getFeatures().contains(GuildFeature.PARTNERED) ? R.drawable.ic_partnered_badge_banner : guild.getFeatures().contains(GuildFeature.VERIFIED) ? R.drawable.ic_verified_badge_banner : 0;
        TextView textView2 = binding.n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "guildNameTv");
        DrawableCompat.setCompoundDrawablesCompat(textView2, i, 0, 0, 0);
        TextView textView3 = binding.n;
        Intrinsics3.checkNotNullExpressionValue(textView3, "guildNameTv");
        textView3.setText(guild.getName());
        int i2 = isPublic ? R.string.emoji_popout_public_server : R.string.emoji_popout_private_server;
        String str = null;
        CharSequence charSequenceK = FormatUtils.k(this, i2, new Object[0], null, 4);
        if (approximateOnline != null) {
            str = FormatUtils.k(this, R.string.instant_invite_guild_members_online, new Object[]{NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext())).format(Integer.valueOf(approximateOnline.intValue()))}, null, 4).toString() + " • ";
        }
        if (str == null) {
            str = "";
        }
        TextView textView4 = binding.l;
        Intrinsics3.checkNotNullExpressionValue(textView4, "guildInfoTv");
        textView4.setText(str + charSequenceK);
    }

    private final void configureUnicodeEmoji(EmojiSheetViewModel.ViewState.EmojiUnicode viewState) {
        WidgetEmojiSheetBinding binding = getBinding();
        SimpleDraweeView simpleDraweeView = binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "emojiIv");
        MGImages.setImage$default(simpleDraweeView, viewState.getEmojiUnicode().getImageUri(true, this.emojiSizePx, requireContext()), 0, 0, false, null, this.imageChangeDetector, 60, null);
        TextView textView = binding.p;
        Intrinsics3.checkNotNullExpressionValue(textView, "nameTv");
        textView.setText(MentionUtils.EMOJIS_AND_STICKERS_CHAR + viewState.getEmojiUnicode().getFirstName() + MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        TextView textView2 = binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "emojiInfoTv");
        textView2.setText(getString(R.string.emoji_popout_standard_emoji_description));
        FrameLayout frameLayout = binding.f2377b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "buttonContainer");
        frameLayout.setVisibility(8);
        LinearLayout linearLayout = binding.k;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "guildContainer");
        linearLayout.setVisibility(8);
        configureFavorite(viewState.getCanFavorite(), viewState.isFavorite());
        AppViewFlipper appViewFlipper = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.emojiSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final WidgetEmojiSheetBinding getBinding() {
        return (WidgetEmojiSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getCustomEmojiInfoText(boolean isCurrentGuild, boolean isUserInGuild, boolean isGuildPublic, boolean isUserPremium) {
        return (!isCurrentGuild || isUserPremium) ? (isCurrentGuild && isUserPremium) ? R.string.emoji_popout_premium_current_guild_description : (!isUserInGuild || isUserPremium) ? (isUserInGuild && isUserPremium) ? R.string.emoji_popout_premium_joined_guild_description : (!isGuildPublic || isUserPremium) ? (isGuildPublic && isUserPremium) ? R.string.emoji_popout_premium_unjoined_discoverable_guild_description : R.string.emoji_popout_premium_unjoined_private_guild_description : R.string.emoji_popout_unjoined_discoverable_guild_description : R.string.emoji_popout_joined_guild_description : R.string.emoji_popout_current_guild_description;
    }

    private final EmojiNode.EmojiIdAndType getEmojiIdAndType() {
        return (EmojiNode.EmojiIdAndType) this.emojiIdAndType.getValue();
    }

    private final EmojiSheetViewModel getViewModel() {
        return (EmojiSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, EmojiNode.EmojiIdAndType emojiIdAndType) {
        INSTANCE.show(fragmentManager, emojiIdAndType);
    }

    private final void showLoading() {
        AppViewFlipper appViewFlipper = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.emojiSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetEmojiSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_emoji_sheet;
    }
}
