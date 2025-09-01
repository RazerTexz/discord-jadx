package com.discord.widgets.guilds;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import b.k.a.a.ColorPickerDialogListener;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildFolderSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import f0.e0.Util7;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetGuildFolderSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettings;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;", "state", "", "configureUI", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;)V", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;)V", "", "currentColor", "", "getColorsToDisplay", "(I)[I", ModelAuditLogEntry.CHANGE_KEY_COLOR, "rgbColorToARGB", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "argbColorToRGB", "(I)I", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState$Loaded;", "data", "launchColorPicker", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState$Loaded;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", "binding", "Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildFolderSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildFolderSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildFolderSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettings$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/FolderId;", "folderId", "", "create", "(Landroid/content/Context;J)V", "", WidgetGuildFolderSettings.DIALOG_TAG_COLOR_PICKER, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long folderId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetGuildFolderSettings.class, new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetGuildFolderSettings.access$getViewModel$p(WidgetGuildFolderSettings.this).setName(editable.toString());
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetGuildFolderSettingsViewModel.ViewState $state;

        public AnonymousClass2(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            this.$state = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildFolderSettings.access$launchColorPicker(WidgetGuildFolderSettings.this, (WidgetGuildFolderSettingsViewModel.ViewState.Loaded) this.$state);
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildFolderSettings.access$getViewModel$p(WidgetGuildFolderSettings.this).saveFolder();
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"com/discord/widgets/guilds/WidgetGuildFolderSettings$launchColorPicker$1", "Lb/k/a/a/f;", "", "dialogId", "selectedColor", "", "onColorSelected", "(II)V", "onColorReset", "(I)V", "onDialogDismissed", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$launchColorPicker$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ColorPickerDialogListener {
        public AnonymousClass1() {
        }

        @Override // b.k.a.a.ColorPickerDialogListener
        public void onColorReset(int dialogId) {
            WidgetGuildFolderSettings.access$getViewModel$p(WidgetGuildFolderSettings.this).setColor(Integer.valueOf(WidgetGuildFolderSettings.access$argbColorToRGB(WidgetGuildFolderSettings.this, ColorCompat.getThemedColor(WidgetGuildFolderSettings.this.getContext(), R.attr.color_brand))));
        }

        @Override // b.k.a.a.ColorPickerDialogListener
        public void onColorSelected(int dialogId, int selectedColor) {
            WidgetGuildFolderSettings.access$getViewModel$p(WidgetGuildFolderSettings.this).setColor(Integer.valueOf(WidgetGuildFolderSettings.access$argbColorToRGB(WidgetGuildFolderSettings.this, selectedColor)));
        }

        @Override // b.k.a.a.ColorPickerDialogListener
        public void onDialogDismissed(int dialogId) {
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGuildFolderSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildFolderSettings widgetGuildFolderSettings) {
            super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildFolderSettings.access$configureUI((WidgetGuildFolderSettings) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetGuildFolderSettingsViewModel.Event, Unit> {
        public AnonymousClass2(WidgetGuildFolderSettings widgetGuildFolderSettings) {
            super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildFolderSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildFolderSettings.access$handleEvent((WidgetGuildFolderSettings) this.receiver, event);
        }
    }

    public WidgetGuildFolderSettings() {
        super(R.layout.widget_guild_folder_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildFolderSettings2.INSTANCE, null, 2, null);
        WidgetGuildFolderSettings3 widgetGuildFolderSettings3 = new WidgetGuildFolderSettings3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildFolderSettingsViewModel.class), new WidgetGuildFolderSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildFolderSettings3));
    }

    public static final /* synthetic */ int access$argbColorToRGB(WidgetGuildFolderSettings widgetGuildFolderSettings, int i) {
        return widgetGuildFolderSettings.argbColorToRGB(i);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel.ViewState viewState) {
        widgetGuildFolderSettings.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetGuildFolderSettingsViewModel access$getViewModel$p(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        return widgetGuildFolderSettings.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel.Event event) {
        widgetGuildFolderSettings.handleEvent(event);
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel.ViewState.Loaded loaded) {
        widgetGuildFolderSettings.launchColorPicker(loaded);
    }

    private final int argbColorToRGB(int color) {
        return Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
    }

    private final void configureUI(WidgetGuildFolderSettingsViewModel.ViewState state) {
        int themedColor;
        if (state instanceof WidgetGuildFolderSettingsViewModel.ViewState.Loaded) {
            View view = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.guildFolderSettingsColorDisplay");
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.drawable_circle_white_1);
            WidgetGuildFolderSettingsViewModel.ViewState.Loaded loaded = (WidgetGuildFolderSettingsViewModel.ViewState.Loaded) state;
            Integer numRgbColorToARGB = rgbColorToARGB(loaded.getFormState().getColor());
            if (numRgbColorToARGB != null) {
                themedColor = numRgbColorToARGB.intValue();
            } else {
                View view2 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildFolderSettingsColorDisplay");
                themedColor = ColorCompat.getThemedColor(view2, R.attr.color_brand);
            }
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(themedColor, PorterDuff.Mode.SRC_ATOP));
                View view3 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(view3, "binding.guildFolderSettingsColorDisplay");
                view3.setBackground(drawable);
            }
            TextInputLayout textInputLayout = getBinding().f2413b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editGuildFolderName");
            ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
            TextInputLayout textInputLayout2 = getBinding().f2413b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editGuildFolderName");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
            if (!Intrinsics3.areEqual(loaded.getFormState().getName(), textOrEmpty)) {
                TextInputLayout textInputLayout3 = getBinding().f2413b;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editGuildFolderName");
                ViewExtensions.setText(textInputLayout3, loaded.getFormState().getName());
                if (textOrEmpty.length() == 0) {
                    TextInputLayout textInputLayout4 = getBinding().f2413b;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editGuildFolderName");
                    EditText editText = textInputLayout4.getEditText();
                    Editable text = editText != null ? editText.getText() : null;
                    TextInputLayout textInputLayout5 = getBinding().f2413b;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.editGuildFolderName");
                    Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout5).length());
                }
            }
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildFolderColorName");
            StringBuilder sb = new StringBuilder();
            sb.append(MentionUtils.CHANNELS_CHAR);
            String strX = Util7.x(themedColor);
            Objects.requireNonNull(strX, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strX.substring(2);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
            textView.setText(sb.toString());
            getBinding().d.setOnClickListener(new AnonymousClass2(state));
            FloatingActionButton floatingActionButton = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.guildFolderSettingsSave");
            floatingActionButton.setVisibility(loaded.getShowSave() ? 0 : 8);
            getBinding().f.setOnClickListener(new AnonymousClass3());
        }
    }

    private final WidgetGuildFolderSettingsBinding getBinding() {
        return (WidgetGuildFolderSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @ColorInt
    private final int[] getColorsToDisplay(@ColorInt int currentColor) throws Resources.NotFoundException {
        int[] intArray = getResources().getIntArray(R.array.color_picker_palette);
        Intrinsics3.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…ray.color_picker_palette)");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (int i : intArray) {
            arrayList.add(Integer.valueOf(i));
            if (i == currentColor) {
                z2 = true;
            }
        }
        if (!z2) {
            arrayList.add(Integer.valueOf(currentColor));
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Number) arrayList.get(i2)).intValue();
        }
        return iArr;
    }

    private final WidgetGuildFolderSettingsViewModel getViewModel() {
        return (WidgetGuildFolderSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildFolderSettingsViewModel.Event event) {
        if (!(event instanceof WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsSuccess)) {
            if (event instanceof WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsFailure) {
                AppToast.g(getContext(), ((WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsFailure) event).getFailureMessageStringRes(), 0, null, 12);
            }
        } else {
            AppToast.i(this, ((WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsSuccess) event).getSuccessMessageStringRes(), 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    private final void launchColorPicker(WidgetGuildFolderSettingsViewModel.ViewState.Loaded data) {
        Integer numRgbColorToARGB = rgbColorToARGB(data.getFormState().getColor());
        int iIntValue = numRgbColorToARGB != null ? numRgbColorToARGB.intValue() : ColorCompat.getThemedColor(getContext(), R.attr.color_brand);
        ColorPickerDialog.k kVar = new ColorPickerDialog.k();
        kVar.h = iIntValue;
        kVar.f3148s = ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundPrimary);
        kVar.i = false;
        kVar.g = getColorsToDisplay(iIntValue);
        kVar.a = R.string.guild_folder_color;
        kVar.r = ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        kVar.f3149x = fontUtils.getThemedFontResId(getContext(), R.attr.font_display_bold);
        kVar.o = ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundAccent);
        kVar.c = R.string.color_picker_custom;
        kVar.v = ColorCompat.getColor(getContext(), R.color.white);
        kVar.f3147b = R.string.color_picker_presets;
        kVar.p = ColorCompat.getThemedColor(getContext(), R.attr.color_brand);
        kVar.d = R.string.select;
        kVar.l = true;
        kVar.e = R.string.reset;
        kVar.w = ColorCompat.getColor(getContext(), R.color.white);
        kVar.f3150y = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_semibold);
        kVar.q = ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundModifierAccent);
        kVar.t = ColorCompat.getThemedColor(getContext(), R.attr.colorTextMuted);
        kVar.u = R.drawable.drawable_cpv_edit_text_background;
        kVar.f3151z = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogA = kVar.a();
        colorPickerDialogA.k = new AnonymousClass1();
        AppFragment.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogA.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final Integer rgbColorToARGB(Integer color) {
        if (color != null) {
            return Integer.valueOf((int) (color.intValue() + 4278190080L));
        }
        return null;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.server_folder_settings);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetGuildFolderSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildFolderSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Fragment fragmentFindFragmentByTag = parentFragmentManager.findFragmentByTag(DIALOG_TAG_COLOR_PICKER);
        if (fragmentFindFragmentByTag != null) {
            parentFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
    }
}
