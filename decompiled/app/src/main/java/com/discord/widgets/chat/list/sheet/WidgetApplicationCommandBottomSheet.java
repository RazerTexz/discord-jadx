package com.discord.widgets.chat.list.sheet;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandData3;
import com.discord.api.user.User;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetApplicationCommandBottomSheetBinding;
import com.discord.models.commands.Application;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetApplicationCommandBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ!\u0010\n\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\tR\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState;)V", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded;", "configureCommandTitle", "(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded;)V", "configureSlashCommandString", "Lcom/discord/api/commands/ApplicationCommandValue;", "option", "Landroid/text/Spannable;", "(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded;Lcom/discord/api/commands/ApplicationCommandValue;)Landroid/text/Spannable;", "configureSlashCommandStringOptions", "", "getContentViewResId", "()I", "onResume", "()V", "configureLoaded", "Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", "binding", "Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet extends AppBottomSheet {
    public static final String ARG_MESSAGE_NONCE = "arg_message_nonce";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetApplicationCommandBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "interactionId", "messageId", "channelId", "guildId", "userId", "applicationId", "", "messageNonce", "", "show", "(Landroidx/fragment/app/FragmentManager;JJJLjava/lang/Long;JJLjava/lang/String;)V", "ARG_MESSAGE_NONCE", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long interactionId, long messageId, long channelId, Long guildId, long userId, long applicationId, String messageNonce) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            boolean z2 = false;
            Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-03_android_app_slash_commands_bottom_sheet_disabled", false);
            if (userExperiment != null && userExperiment.getBucket() == 1) {
                z2 = true;
            }
            if (z2) {
                return;
            }
            WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet = new WidgetApplicationCommandBottomSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_INTERACTION_ID", interactionId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            if (guildId != null) {
                bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            bundleT.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_APPLICATION_ID", applicationId);
            bundleT.putString(WidgetApplicationCommandBottomSheet.ARG_MESSAGE_NONCE, messageNonce);
            widgetApplicationCommandBottomSheet.setArguments(bundleT);
            widgetApplicationCommandBottomSheet.show(fragmentManager, WidgetApplicationCommandBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureLoaded$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded $viewState;

        public AnonymousClass1(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = WidgetApplicationCommandBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            AppToast.c(contextRequireContext, WidgetApplicationCommandBottomSheet5.toSlashCommandCopyString(this.$viewState.getApplicationCommandData(), this.$viewState.getCommandValues()), 0, 4);
            WidgetApplicationCommandBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetApplicationCommandBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetApplicationCommandBottomSheet.access$configureUI(WidgetApplicationCommandBottomSheet.this, viewState);
        }
    }

    public WidgetApplicationCommandBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetApplicationCommandBottomSheet2.INSTANCE, null, 2, null);
        WidgetApplicationCommandBottomSheet4 widgetApplicationCommandBottomSheet4 = new WidgetApplicationCommandBottomSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetApplicationCommandBottomSheetViewModel.class), new WidgetApplicationCommandBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetApplicationCommandBottomSheet4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet, WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
        widgetApplicationCommandBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet) {
        return widgetApplicationCommandBottomSheet.getArgumentsOrDefault();
    }

    private final void configureCommandTitle(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        String name;
        String nick;
        User bot;
        StringBuilder sbQ = outline.Q(MentionUtils.SLASH_CHAR);
        sbQ.append(viewState.getApplicationCommandData().getName());
        String string = sbQ.toString();
        Application application = viewState.getApplication();
        String username = null;
        if (application == null || (bot = application.getBot()) == null || (name = bot.getUsername()) == null) {
            Application application2 = viewState.getApplication();
            name = application2 != null ? application2.getName() : null;
        }
        int themedColor = ColorCompat.getThemedColor(requireContext(), R.attr.colorTextNormal);
        Application application3 = viewState.getApplication();
        if (application3 != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f2226b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.commandBottomSheetCommandAvatar");
            IconUtils.setApplicationIcon(simpleDraweeView, application3);
        }
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandTitle");
        Object[] objArr = new Object[2];
        GuildMember interactionUser = viewState.getInteractionUser();
        if (interactionUser == null || (nick = interactionUser.getNick()) == null) {
            com.discord.models.user.User user = viewState.getUser();
            if (user != null) {
                username = user.getUsername();
            }
        } else {
            username = nick;
        }
        objArr[0] = username;
        objArr[1] = string;
        CharSequence charSequenceD = FormatUtils.d(textView, R.string.system_message_application_command_used_as_title, objArr, new WidgetApplicationCommandBottomSheet3(this, viewState, themedColor));
        TextView textView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.commandBottomSheetCommandTitle");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.commandBottomSheetCommandTitle");
        textView3.setText(charSequenceD);
        TextView textView4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.commandBottomShe…mmandTitleApplicationName");
        textView4.setVisibility(name != null ? 0 : 8);
        TextView textView5 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.commandBottomShe…mmandTitleApplicationName");
        textView5.setText(name);
    }

    private final void configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        ApplicationCommandData applicationCommandData = viewState.getApplicationCommandData();
        List<ApplicationCommandData3> listB = viewState.getApplicationCommandData().b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        StringBuilder sbQ = outline.Q(MentionUtils.SLASH_CHAR);
        sbQ.append(applicationCommandData.getName());
        sbQ.append(' ');
        spannableStringBuilder.append((CharSequence) sbQ.toString());
        if (listB != null) {
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandData3) it.next()));
            }
        }
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandContent");
        textView.setText(spannableStringBuilder);
    }

    private final Spannable configureSlashCommandStringOptions(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState, ApplicationCommandData3 option) {
        Integer valueColor;
        int themedColor = ColorCompat.getThemedColor(this, R.attr.colorHeaderPrimary);
        WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam slashCommandParam = viewState.getCommandValues().get(option.getName());
        if ((slashCommandParam != null ? slashCommandParam.getValueColor() : null) != null && ((valueColor = slashCommandParam.getValueColor()) == null || valueColor.intValue() != 0)) {
            themedColor = slashCommandParam.getValueColor().intValue();
        }
        String value = slashCommandParam != null ? slashCommandParam.getValue() : null;
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) option.getName());
        if (!(value == null || StringsJVM.isBlank(value))) {
            SpannableStringBuilder spannableStringBuilderAppend2 = spannableStringBuilderAppend.append((CharSequence) ": ");
            Intrinsics3.checkNotNullExpressionValue(spannableStringBuilderAppend2, "builder.append(\": \")");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(themedColor);
            int length = spannableStringBuilderAppend2.length();
            spannableStringBuilderAppend2.append((CharSequence) (value + ' '));
            spannableStringBuilderAppend2.setSpan(foregroundColorSpan, length, spannableStringBuilderAppend2.length(), 17);
        }
        Intrinsics3.checkNotNullExpressionValue(spannableStringBuilderAppend, "builder");
        return spannableStringBuilderAppend;
    }

    private final void configureUI(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
        boolean z2 = viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Loading;
        ProgressBar progressBar = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.commandBottomSheetCommandLoader");
        progressBar.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.commandBottomSheetCommandCopyButton");
        materialButton.setEnabled(!z2);
        if (!(viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded)) {
            if (viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Failed) {
                dismiss();
            }
        } else {
            MaterialButton materialButton2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.commandBottomSheetCommandCopyButton");
            materialButton2.setEnabled(true);
            configureLoaded((WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded) viewState);
        }
    }

    private final WidgetApplicationCommandBottomSheetBinding getBinding() {
        return (WidgetApplicationCommandBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetApplicationCommandBottomSheetViewModel getViewModel() {
        return (WidgetApplicationCommandBottomSheetViewModel) this.viewModel.getValue();
    }

    public final void configureLoaded(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        configureCommandTitle(viewState);
        configureSlashCommandString(viewState);
        getBinding().d.setOnClickListener(new AnonymousClass1(viewState));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_application_command_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetApplicationCommandBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    private final Spannable configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState, ApplicationCommandData3 option) {
        List<ApplicationCommandData3> listC = option.c();
        if (listC == null || listC.isEmpty()) {
            return configureSlashCommandStringOptions(viewState, option);
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) (option.getName() + ' '));
        List<ApplicationCommandData3> listC2 = option.c();
        if (listC2 != null) {
            Iterator<T> it = listC2.iterator();
            while (it.hasNext()) {
                spannableStringBuilderAppend.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandData3) it.next()));
            }
        }
        return spannableStringBuilderAppend;
    }
}
