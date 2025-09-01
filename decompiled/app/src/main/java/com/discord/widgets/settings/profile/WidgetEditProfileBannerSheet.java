package com.discord.widgets.settings.profile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.b.SingleValuePropPremiumUpsellDialog;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import b.k.a.a.ColorPickerDialogListener;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetEditProfileBannerSheetBinding;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;

/* compiled from: WidgetEditProfileBannerSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b>\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bR\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R0\u0010(\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00040'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001d\u00100\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u001a\u001a\u0004\b0\u00101R(\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010 \u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001d\u0010:\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/discord/widgets/settings/profile/WidgetEditProfileBannerSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$ViewState;", "viewState", "", "configureUi", "(Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$ViewState;)V", "configureStringsForGuild", "()V", "navigateToUpsellModal", "", "initialColor", "launchColorPicker", "(I)V", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel;", "viewModel", "Lkotlin/Function0;", "onChangeProfileBannerImage", "Lkotlin/jvm/functions/Function0;", "getOnChangeProfileBannerImage", "()Lkotlin/jvm/functions/Function0;", "setOnChangeProfileBannerImage", "(Lkotlin/jvm/functions/Function0;)V", "defaultBannerColor", "I", "Lkotlin/Function1;", "onColorSelected", "Lkotlin/jvm/functions/Function1;", "getOnColorSelected", "()Lkotlin/jvm/functions/Function1;", "setOnColorSelected", "(Lkotlin/jvm/functions/Function1;)V", "", "isGuildContext$delegate", "isGuildContext", "()Z", "onRemoveProfileBannerImage", "getOnRemoveProfileBannerImage", "setOnRemoveProfileBannerImage", "Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", "binding", "Lcom/jaredrummler/android/colorpicker/ColorPickerDialog;", "colorPickerDialog", "Lcom/jaredrummler/android/colorpicker/ColorPickerDialog;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet extends AppBottomSheet {
    private static final String ARG_DEFAULT_BANNER_COLOR_HEX = "ARG_DEFAULT_BANNER_COLOR_HEX";
    private static final String ARG_HAS_BANNER_IMAGE = "ARG_HAS_BANNER_IMAGE";
    private static final String ARG_INITIAL_COLOR_PREVIEW_HEX = "ARG_INITIAL_COLOR_PREVIEW_HEX";
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ColorPickerDialog colorPickerDialog;
    private int defaultBannerColor;

    /* renamed from: isGuildContext$delegate, reason: from kotlin metadata */
    private final Lazy isGuildContext;
    private Function0<Unit> onChangeProfileBannerImage;
    private Function1<? super Integer, Unit> onColorSelected;
    private Function0<Unit> onRemoveProfileBannerImage;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEditProfileBannerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEditProfileBannerSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJy\u0010\u0013\u001a\u00020\r2\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/settings/profile/WidgetEditProfileBannerSheet$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "defaultBannerColorHex", "initialColorPreviewHex", "", "hasBannerImage", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function0;", "", "onChangeProfileBannerImage", "onRemoveProfileBannerImage", "Lkotlin/Function1;", "", "onColorSelected", "show", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLandroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", WidgetEditProfileBannerSheet.ARG_DEFAULT_BANNER_COLOR_HEX, "Ljava/lang/String;", WidgetEditProfileBannerSheet.ARG_HAS_BANNER_IMAGE, WidgetEditProfileBannerSheet.ARG_INITIAL_COLOR_PREVIEW_HEX, WidgetEditProfileBannerSheet.DIALOG_TAG_COLOR_PICKER, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Long l, String str, String str2, boolean z2, FragmentManager fragmentManager, Function0 function0, Function0 function02, Function1 function1, int i, Object obj) {
            companion.show((i & 1) != 0 ? null : l, str, str2, z2, fragmentManager, (i & 32) != 0 ? WidgetEditProfileBannerSheet2.INSTANCE : function0, (i & 64) != 0 ? WidgetEditProfileBannerSheet3.INSTANCE : function02, (i & 128) != 0 ? WidgetEditProfileBannerSheet4.INSTANCE : function1);
        }

        public final void show(Long guildId, String defaultBannerColorHex, String initialColorPreviewHex, boolean hasBannerImage, FragmentManager fragmentManager, Function0<Unit> onChangeProfileBannerImage, Function0<Unit> onRemoveProfileBannerImage, Function1<? super Integer, Unit> onColorSelected) {
            Intrinsics3.checkNotNullParameter(defaultBannerColorHex, "defaultBannerColorHex");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(onChangeProfileBannerImage, "onChangeProfileBannerImage");
            Intrinsics3.checkNotNullParameter(onRemoveProfileBannerImage, "onRemoveProfileBannerImage");
            Intrinsics3.checkNotNullParameter(onColorSelected, "onColorSelected");
            WidgetEditProfileBannerSheet widgetEditProfileBannerSheet = new WidgetEditProfileBannerSheet();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetEditProfileBannerSheet.ARG_DEFAULT_BANNER_COLOR_HEX, defaultBannerColorHex);
            bundle.putString(WidgetEditProfileBannerSheet.ARG_INITIAL_COLOR_PREVIEW_HEX, initialColorPreviewHex);
            bundle.putBoolean(WidgetEditProfileBannerSheet.ARG_HAS_BANNER_IMAGE, hasBannerImage);
            if (guildId != null) {
                bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            widgetEditProfileBannerSheet.setArguments(bundle);
            widgetEditProfileBannerSheet.setOnChangeProfileBannerImage(onChangeProfileBannerImage);
            widgetEditProfileBannerSheet.setOnRemoveProfileBannerImage(onRemoveProfileBannerImage);
            widgetEditProfileBannerSheet.setOnColorSelected(onColorSelected);
            widgetEditProfileBannerSheet.show(fragmentManager, WidgetEditProfileBannerSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$configureUi$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Ref$ObjectRef $bannerColor;

        public AnonymousClass1(Ref$ObjectRef ref$ObjectRef) {
            this.$bannerColor = ref$ObjectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditProfileBannerSheet widgetEditProfileBannerSheet = WidgetEditProfileBannerSheet.this;
            Integer num = (Integer) this.$bannerColor.element;
            WidgetEditProfileBannerSheet.access$launchColorPicker(widgetEditProfileBannerSheet, num != null ? num.intValue() : WidgetEditProfileBannerSheet.access$getDefaultBannerColor$p(widgetEditProfileBannerSheet));
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$configureUi$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ EditProfileBannerSheetViewModel.ViewState $viewState;

        public AnonymousClass2(EditProfileBannerSheetViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getShowPremiumUpsell()) {
                WidgetEditProfileBannerSheet.access$navigateToUpsellModal(WidgetEditProfileBannerSheet.this);
            } else {
                WidgetEditProfileBannerSheet.this.getOnChangeProfileBannerImage().invoke();
                WidgetEditProfileBannerSheet.this.dismiss();
            }
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$isGuildContext$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Boolean> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return WidgetEditProfileBannerSheet.access$getArgumentsOrDefault$p(WidgetEditProfileBannerSheet.this).getLong("com.discord.intent.extra.EXTRA_GUILD_ID") > 0;
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"com/discord/widgets/settings/profile/WidgetEditProfileBannerSheet$launchColorPicker$1", "Lb/k/a/a/f;", "", "dialogId", "selectedColor", "", "onColorSelected", "(II)V", "onColorReset", "(I)V", "onDialogDismissed", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$launchColorPicker$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ColorPickerDialogListener {
        public AnonymousClass1() {
        }

        @Override // b.k.a.a.ColorPickerDialogListener
        public void onColorReset(int dialogId) {
            WidgetEditProfileBannerSheet.access$getViewModel$p(WidgetEditProfileBannerSheet.this).updateColorPreview(null);
            WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(null);
        }

        @Override // b.k.a.a.ColorPickerDialogListener
        public void onColorSelected(int dialogId, int selectedColor) {
            EditProfileBannerSheetViewModel editProfileBannerSheetViewModelAccess$getViewModel$p = WidgetEditProfileBannerSheet.access$getViewModel$p(WidgetEditProfileBannerSheet.this);
            ColorCompat colorCompat = ColorCompat.INSTANCE;
            editProfileBannerSheetViewModelAccess$getViewModel$p.updateColorPreview(colorCompat.getColorHexFromColorInt(selectedColor));
            WidgetEditProfileBannerSheet.this.getOnColorSelected().invoke(Integer.valueOf(colorCompat.removeAlphaComponent(selectedColor)));
        }

        @Override // b.k.a.a.ColorPickerDialogListener
        public void onDialogDismissed(int dialogId) {
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<EditProfileBannerSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditProfileBannerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditProfileBannerSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetEditProfileBannerSheet.access$configureUi(WidgetEditProfileBannerSheet.this, viewState);
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditProfileBannerSheet.access$navigateToUpsellModal(WidgetEditProfileBannerSheet.this);
        }
    }

    /* compiled from: WidgetEditProfileBannerSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEditProfileBannerSheet.this.getOnRemoveProfileBannerImage().invoke();
            WidgetEditProfileBannerSheet.this.dismiss();
        }
    }

    public WidgetEditProfileBannerSheet() {
        super(false, 1, null);
        this.onChangeProfileBannerImage = WidgetEditProfileBannerSheet6.INSTANCE;
        this.onRemoveProfileBannerImage = WidgetEditProfileBannerSheet8.INSTANCE;
        this.onColorSelected = WidgetEditProfileBannerSheet7.INSTANCE;
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEditProfileBannerSheet5.INSTANCE, null, 2, null);
        this.isGuildContext = LazyJVM.lazy(new AnonymousClass2());
        WidgetEditProfileBannerSheet9 widgetEditProfileBannerSheet9 = new WidgetEditProfileBannerSheet9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EditProfileBannerSheetViewModel.class), new WidgetEditProfileBannerSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetEditProfileBannerSheet9));
    }

    public static final /* synthetic */ void access$configureUi(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, EditProfileBannerSheetViewModel.ViewState viewState) {
        widgetEditProfileBannerSheet.configureUi(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        return widgetEditProfileBannerSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ int access$getDefaultBannerColor$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        return widgetEditProfileBannerSheet.defaultBannerColor;
    }

    public static final /* synthetic */ EditProfileBannerSheetViewModel access$getViewModel$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        return widgetEditProfileBannerSheet.getViewModel();
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, int i) {
        widgetEditProfileBannerSheet.launchColorPicker(i);
    }

    public static final /* synthetic */ void access$navigateToUpsellModal(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        widgetEditProfileBannerSheet.navigateToUpsellModal();
    }

    public static final /* synthetic */ void access$setDefaultBannerColor$p(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet, int i) {
        widgetEditProfileBannerSheet.defaultBannerColor = i;
    }

    private final void configureStringsForGuild() {
        MaterialTextView materialTextView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.bannerColorItemTitle");
        materialTextView.setText(FormatUtils.k(this, R.string.change_identity_profile_color, new Object[0], null, 4));
        MaterialTextView materialTextView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.bannerChangeImageItemTitle");
        materialTextView2.setText(FormatUtils.k(this, R.string.change_identity_profile_banner, new Object[0], null, 4));
        MaterialTextView materialTextView3 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.bannerRemoveImageItem");
        materialTextView3.setText(FormatUtils.k(this, R.string.change_identity_reset_banner, new Object[0], null, 4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Integer] */
    private final void configureUi(EditProfileBannerSheetViewModel.ViewState viewState) {
        if (viewState instanceof EditProfileBannerSheetViewModel.ViewState) {
            String bannerColorHex = viewState.getBannerColorHex();
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            if (isGuildContext()) {
                configureStringsForGuild();
            }
            if (bannerColorHex != null) {
                try {
                    ref$ObjectRef.element = Integer.valueOf(Color.parseColor(bannerColorHex));
                } catch (IllegalArgumentException e) {
                    Logger.e$default(AppLog.g, outline.w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
                }
            }
            if (((Integer) ref$ObjectRef.element) != null) {
                ImageView imageView = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.bannerColorPreview");
                ColorCompat2.tintWithColor(imageView, ((Integer) ref$ObjectRef.element).intValue());
            }
            ImageView imageView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.bannerColorPreview");
            imageView2.setVisibility(((Integer) ref$ObjectRef.element) == null ? 4 : 0);
            getBinding().d.setOnClickListener(new AnonymousClass1(ref$ObjectRef));
            MaterialButton materialButton = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellButton");
            materialButton.setVisibility(viewState.getShowPremiumUpsell() ? 0 : 8);
            MaterialButton materialButton2 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellButton");
            if ((materialButton2.getVisibility() == 0) && !getViewModel().getUpsellViewedTracked()) {
                AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.CustomProfileBannerUpsell, new Traits.Location(Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER, null, null, 24, null), null, null, 12, null);
                getViewModel().setUpsellViewedTracked(true);
            }
            getBinding().f2369b.setOnClickListener(new AnonymousClass2(viewState));
        }
        KotlinExtensions.getExhaustive(Unit.a);
    }

    private final WidgetEditProfileBannerSheetBinding getBinding() {
        return (WidgetEditProfileBannerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final EditProfileBannerSheetViewModel getViewModel() {
        return (EditProfileBannerSheetViewModel) this.viewModel.getValue();
    }

    private final boolean isGuildContext() {
        return ((Boolean) this.isGuildContext.getValue()).booleanValue();
    }

    private final void launchColorPicker(@ColorInt int initialColor) {
        ColorPickerDialog.k kVar = new ColorPickerDialog.k();
        kVar.h = initialColor;
        kVar.f3148s = ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundPrimary);
        kVar.i = false;
        kVar.j = false;
        kVar.f = 0;
        kVar.a = R.string.user_settings_banner_color_title;
        kVar.r = ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        kVar.f3149x = fontUtils.getThemedFontResId(getContext(), R.attr.font_display_bold);
        kVar.l = true;
        kVar.e = R.string.color_picker_use_default;
        kVar.p = ColorCompat.getThemedColor(getContext(), R.attr.color_brand);
        kVar.d = R.string.select;
        kVar.w = ColorCompat.getColor(getContext(), R.color.white);
        kVar.f3150y = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_semibold);
        kVar.t = ColorCompat.getThemedColor(getContext(), R.attr.colorTextMuted);
        kVar.u = R.drawable.drawable_cpv_edit_text_background;
        kVar.f3151z = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogA = kVar.a();
        colorPickerDialogA.k = new AnonymousClass1();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogA.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
        this.colorPickerDialog = colorPickerDialogA;
    }

    private final void navigateToUpsellModal() {
        SingleValuePropPremiumUpsellDialog.Companion companion = SingleValuePropPremiumUpsellDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        AnalyticsTracker.PremiumUpsellType premiumUpsellType = AnalyticsTracker.PremiumUpsellType.CustomProfileUpsellModal;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        String string = FormatUtils.i(resources, R.string.premium_profile_customization_upsell_header, new Object[0], null, 4).toString();
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        companion.a(parentFragmentManager, premiumUpsellType, R.drawable.img_profile_banner_value_prop, string, FormatUtils.i(resources2, R.string.premium_profile_customization_upsell_body, new Object[0], null, 4).toString(), Traits.Location.Page.USER_SETTINGS, "User Profile", Traits.Location.Obj.EDIT_PROFILE_BANNER);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_edit_profile_banner_sheet;
    }

    public final Function0<Unit> getOnChangeProfileBannerImage() {
        return this.onChangeProfileBannerImage;
    }

    public final Function1<Integer, Unit> getOnColorSelected() {
        return this.onColorSelected;
    }

    public final Function0<Unit> getOnRemoveProfileBannerImage() {
        return this.onRemoveProfileBannerImage;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
        ColorPickerDialog colorPickerDialog = this.colorPickerDialog;
        if (colorPickerDialog != null) {
            colorPickerDialog.dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetEditProfileBannerSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence charSequenceI;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().h.setOnClickListener(new AnonymousClass1());
        getBinding().g.setOnClickListener(new AnonymousClass2());
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_HAS_BANNER_IMAGE);
        MaterialTextView materialTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.bannerChangeImageItemTitle");
        if (z2) {
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            charSequenceI = FormatUtils.i(resources, R.string.user_settings_change_profile_banner, new Object[0], null, 4);
        } else {
            Resources resources2 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            charSequenceI = FormatUtils.i(resources2, R.string.user_settings_upload_banner, new Object[0], null, 4);
        }
        materialTextView.setText(charSequenceI);
        MaterialTextView materialTextView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.bannerRemoveImageItem");
        materialTextView2.setVisibility(z2 ? 0 : 8);
    }

    public final void setOnChangeProfileBannerImage(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onChangeProfileBannerImage = function0;
    }

    public final void setOnColorSelected(Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onColorSelected = function1;
    }

    public final void setOnRemoveProfileBannerImage(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onRemoveProfileBannerImage = function0;
    }
}
