package com.discord.widgets.chat.input.autocomplete;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.i.c.m.d.k.CommonUtils;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatInputApplicationCommandsBinding;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.LoadState;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.WidgetChatInputAutocompleteStickerAdapter;
import com.discord.widgets.chat.input.WidgetChatInputCategoriesAdapter2;
import com.discord.widgets.chat.input.WidgetChatInputEditText;
import com.discord.widgets.chat.input.applicationcommands.SelectedApplicationCommandAdapter;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel4;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel5;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel6;
import com.discord.widgets.chat.input.autocomplete.InputEditTextAction;
import com.discord.widgets.chat.input.autocomplete.adapter.ChatInputAutocompleteAdapter;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.FlexInputListener2;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;
import rx.Observable;

/* compiled from: InputAutocomplete.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010A\u001a\u00020@\u0012\u0010\b\u0002\u0010M\u001a\n\u0018\u00010&j\u0004\u0018\u0001`L\u0012\u0006\u0010n\u001a\u00020F\u0012\u0006\u0010x\u001a\u00020u\u0012\u0006\u0010y\u001a\u00020u\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010v\u001a\u00020u\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010i\u001a\u00020h¢\u0006\u0004\bz\u0010{J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0011\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0016J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010(\u001a\n\u0018\u00010&j\u0004\u0018\u0001`'2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b(\u0010)J!\u0010.\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u0004¢\u0006\u0004\b2\u0010\u0016J\u001b\u00106\u001a\u0004\u0018\u0001052\n\b\u0002\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b6\u00107J\u001d\u0010:\u001a\u0012\u0012\u0004\u0012\u000203\u0012\b\u0012\u0006\u0012\u0002\b\u00030908¢\u0006\u0004\b:\u0010;J\r\u0010=\u001a\u00020<¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u0004¢\u0006\u0004\b?\u0010\u0016R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010M\u001a\n\u0018\u00010&j\u0004\u0018\u0001`L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001d\u0010W\u001a\u00020R8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010\\\u001a\u00020[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R0\u0010b\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010l\u001a\u00020k8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010HR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010s\u001a\u00020r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010v\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010wR\u0016\u0010y\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010w¨\u0006|"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputAutocomplete;", "", "Lcom/discord/widgets/chat/input/autocomplete/Event;", "event", "", "handleEvent", "(Lcom/discord/widgets/chat/input/autocomplete/Event;)V", "Lcom/discord/widgets/chat/input/autocomplete/ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/chat/input/autocomplete/ViewState;)V", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;", "autocompleteViewState", "configureAutocomplete", "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState;)V", "Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;", "selectedCommandViewState", "configureSelectedCommand", "(Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState;)V", "Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState$SelectedCommand;", "(Lcom/discord/widgets/chat/input/autocomplete/SelectedCommandViewState$SelectedCommand;)V", "hideSelectedCommand", "()V", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$CommandBrowser;", "browser", "configureCommandBrowser", "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$CommandBrowser;)V", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$Autocomplete;", "autocomplete", "configureAutocompleteBrowser", "(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewState$Autocomplete;)V", "hideAutocomplete", "Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "action", "applyEditTextAction", "(Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;)V", "", "topPosition", "", "Lcom/discord/primitives/ApplicationId;", "getCurrentlySelectedCategory", "(I)Ljava/lang/Long;", "Landroid/text/Spannable;", "spannable", "Lkotlin/ranges/IntRange;", "spanRange", "removeSpans", "(Landroid/text/Spannable;Lkotlin/ranges/IntRange;)V", "removePillSpans", "(Landroid/text/Spannable;)V", "onViewBoundOrOnResume", "Lcom/discord/models/commands/ApplicationCommandOption;", "focusedOption", "Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "getApplicationCommandData", "(Lcom/discord/models/commands/ApplicationCommandOption;)Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "", "Lcom/lytefast/flexinput/model/Attachment;", "getCommandAttachments", "()Ljava/util/Map;", "Lcom/discord/widgets/chat/MessageContent;", "getInputContent", "()Lcom/discord/widgets/chat/MessageContent;", "onCommandInputsSendError", "Lcom/lytefast/flexinput/widget/FlexEditText;", "editText", "Lcom/lytefast/flexinput/widget/FlexEditText;", "Lcom/discord/app/AppFragment;", "fragment", "Lcom/discord/app/AppFragment;", "Landroid/widget/TextView;", "stickerHeader", "Landroid/widget/TextView;", "Lcom/discord/widgets/chat/input/WidgetChatInputAutocompleteStickerAdapter;", "stickersAdapter", "Lcom/discord/widgets/chat/input/WidgetChatInputAutocompleteStickerAdapter;", "Lcom/discord/primitives/ChannelId;", "channel", "Ljava/lang/Long;", "Lcom/discord/widgets/chat/input/autocomplete/adapter/ChatInputAutocompleteAdapter;", "autocompleteAdapter", "Lcom/discord/widgets/chat/input/autocomplete/adapter/ChatInputAutocompleteAdapter;", "Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel;", "viewModel", "Lcom/lytefast/flexinput/fragment/FlexInputFragment;", "flexInputFragment", "Lcom/lytefast/flexinput/fragment/FlexInputFragment;", "Landroid/view/View;", "stickersContainer", "Landroid/view/View;", "Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandAdapter;", "selectedApplicationCommandAdapter", "Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandAdapter;", "Lkotlin/Function1;", "onPerformCommandAutocomplete", "Lkotlin/jvm/functions/Function1;", "getOnPerformCommandAutocomplete", "()Lkotlin/jvm/functions/Function1;", "setOnPerformCommandAutocomplete", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/WidgetChatInputApplicationCommandsBinding;", "selectedApplicationCommandUiBinding", "Lcom/discord/databinding/WidgetChatInputApplicationCommandsBinding;", "Lcom/discord/widgets/chat/input/ChatInputApplicationsAdapter;", "categoriesAdapter", "Lcom/discord/widgets/chat/input/ChatInputApplicationsAdapter;", "autocompleteHeader", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "", "commandBrowserOpen", "Z", "Landroidx/recyclerview/widget/RecyclerView;", "stickersRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "autocompleteRecyclerView", "commandBrowserAppsRecyclerView", "<init>", "(Lcom/discord/app/AppFragment;Lcom/lytefast/flexinput/fragment/FlexInputFragment;Lcom/discord/widgets/chat/input/AppFlexInputViewModel;Lcom/lytefast/flexinput/widget/FlexEditText;Ljava/lang/Long;Landroid/widget/TextView;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroid/widget/TextView;Lcom/discord/databinding/WidgetChatInputApplicationCommandsBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class InputAutocomplete {
    private final ChatInputAutocompleteAdapter autocompleteAdapter;
    private final TextView autocompleteHeader;
    private final RecyclerView autocompleteRecyclerView;
    private final WidgetChatInputCategoriesAdapter2 categoriesAdapter;
    private final Long channel;
    private final RecyclerView commandBrowserAppsRecyclerView;
    private boolean commandBrowserOpen;
    private final FlexEditText editText;
    private final FlexInputFragment flexInputFragment;
    private final AppFlexInputViewModel flexInputViewModel;
    private final AppFragment fragment;
    private Function1<? super ApplicationCommandOption, Unit> onPerformCommandAutocomplete;
    private final SelectedApplicationCommandAdapter selectedApplicationCommandAdapter;
    private final WidgetChatInputApplicationCommandsBinding selectedApplicationCommandUiBinding;
    private final TextView stickerHeader;
    private final WidgetChatInputAutocompleteStickerAdapter stickersAdapter;
    private final View stickersContainer;
    private final RecyclerView stickersRecyclerView;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/chat/input/autocomplete/InputAutocomplete$1", "Lcom/lytefast/flexinput/FlexInputAttachmentListener;", "Lcom/lytefast/flexinput/model/Attachment;", "attachment", "", "onAttachmentSelected", "(Lcom/lytefast/flexinput/model/Attachment;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$1, reason: invalid class name */
    public static final class AnonymousClass1 implements FlexInputListener2 {
        public AnonymousClass1() {
        }

        @Override // com.lytefast.flexinput.FlexInputListener2
        public void onAttachmentSelected(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).setAttachment(attachment);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"com/discord/widgets/chat/input/autocomplete/InputAutocomplete$2", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "I", "getStart", "()I", "setStart", "(I)V", "getBefore", "setBefore", "getCount", "setCount", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$2, reason: invalid class name */
    public static final class AnonymousClass2 implements TextWatcher {
        private int before;
        private int count;
        private int start;

        public AnonymousClass2() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s2) {
            Intrinsics3.checkNotNullParameter(s2, "s");
            InputAutocomplete.access$applyEditTextAction(InputAutocomplete.this, InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).onInputTextChanged(s2, this.start, this.before, this.count));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
        }

        public final int getBefore() {
            return this.before;
        }

        public final int getCount() {
            return this.count;
        }

        public final int getStart() {
            return this.start;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s2, int start, int before, int count) {
            this.start = start;
            this.before = before;
            this.count = count;
        }

        public final void setBefore(int i) {
            this.before = i;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final void setStart(int i) {
            this.start = i;
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "start", "end", "", "invoke", "(II)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function2<Integer, Integer, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).onSelectionChanged(InputAutocomplete.access$getEditText$p(InputAutocomplete.this).getEditableText().toString(), i, i2);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/commands/Application;", "it", "", "invoke", "(Lcom/discord/models/commands/Application;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Application, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Application application) {
            invoke2(application);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Application application) {
            Intrinsics3.checkNotNullParameter(application, "it");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).selectCommandBrowserApplication(application);
            InputAutocomplete.access$getCategoriesAdapter$p(InputAutocomplete.this).selectApplication(application.getId());
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "it", "", "invoke", "(Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Autocompletable, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Autocompletable autocompletable) {
            invoke2(autocompletable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Autocompletable autocompletable) {
            Intrinsics3.checkNotNullParameter(autocompletable, "it");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).selectAutocompleteItem(autocompletable);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/sticker/Sticker;", "sticker", "", "invoke", "(Lcom/discord/api/sticker/Sticker;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<Sticker, Unit> {
        public AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
            invoke2(sticker);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Sticker sticker) {
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).selectStickerItem(sticker);
            Context context = InputAutocomplete.access$getEditText$p(InputAutocomplete.this).getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "editText.context");
            MessageManager.sendMessage$default(new MessageManager(context, null, null, null, null, null, null, null, null, 510, null), null, null, null, null, CollectionsJVM.listOf(sticker), false, null, null, null, 495, null);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/commands/ApplicationCommandOption;", "it", "", "invoke", "(Lcom/discord/models/commands/ApplicationCommandOption;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function1<ApplicationCommandOption, Unit> {
        public AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandOption applicationCommandOption) {
            invoke2(applicationCommandOption);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandOption applicationCommandOption) {
            Intrinsics3.checkNotNullParameter(applicationCommandOption, "it");
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).selectCommandOption(applicationCommandOption);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "firstVisibleItem", "lastVisibleItem", "", "invoke", "(II)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$configureAutocompleteBrowser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Integer, Integer, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            int iMin = Math.min(i2, InputAutocomplete.access$getAutocompleteAdapter$p(InputAutocomplete.this).getPageSize() - 1);
            if (i >= 0 && iMin >= i) {
                Ranges2 ranges2 = new Ranges2(i, iMin);
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2, 10));
                Iterator<Integer> it = ranges2.iterator();
                while (it.hasNext()) {
                    arrayList.add(InputAutocomplete.access$getAutocompleteAdapter$p(InputAutocomplete.this).getItem(((Iterators4) it).nextInt()));
                }
                InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).checkEmojiAutocompleteUpsellViewed(arrayList);
            }
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "i", "i2", "", "invoke", "(II)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$configureCommandBrowser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Integer, Integer, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            Long lAccess$getCurrentlySelectedCategory;
            if (i >= 0 && (lAccess$getCurrentlySelectedCategory = InputAutocomplete.access$getCurrentlySelectedCategory(InputAutocomplete.this, i)) != null) {
                long jLongValue = lAccess$getCurrentlySelectedCategory.longValue();
                InputAutocomplete.access$getCategoriesAdapter$p(InputAutocomplete.this).selectApplication(jLongValue);
                int positionOfApplication = InputAutocomplete.access$getCategoriesAdapter$p(InputAutocomplete.this).getPositionOfApplication(jLongValue);
                if (positionOfApplication >= 0) {
                    InputAutocomplete.access$getCommandBrowserAppsRecyclerView$p(InputAutocomplete.this).smoothScrollToPosition(positionOfApplication);
                }
            }
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).onCommandsBrowserScroll(i, i2, InputAutocomplete.access$getAutocompleteAdapter$p(InputAutocomplete.this).getPageSize());
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$handleEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AutocompleteViewModel5 $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AutocompleteViewModel5 autocompleteViewModel5) {
            super(0);
            this.$event = autocompleteViewModel5;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            InputAutocomplete.access$getViewModel$p(InputAutocomplete.this).onAttachmentRemoved(((AutocompleteViewModel5.PreviewAttachment) this.$event).getAttachment());
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "spoiler", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$handleEvent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ AutocompleteViewModel5 $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AutocompleteViewModel5 autocompleteViewModel5) {
            super(1);
            this.$event = autocompleteViewModel5;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            ((AutocompleteViewModel5.PreviewAttachment) this.$event).getAttachment().setSpoiler(z2);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$handleEvent$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            InputAutocomplete.access$getFragment$p(InputAutocomplete.this).showKeyboard(InputAutocomplete.access$getEditText$p(InputAutocomplete.this));
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/autocomplete/ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<AutocompleteViewModel7, Unit> {
        public AnonymousClass1(InputAutocomplete inputAutocomplete) {
            super(1, inputAutocomplete, InputAutocomplete.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/autocomplete/ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AutocompleteViewModel7 autocompleteViewModel7) {
            invoke2(autocompleteViewModel7);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AutocompleteViewModel7 autocompleteViewModel7) {
            Intrinsics3.checkNotNullParameter(autocompleteViewModel7, "p1");
            InputAutocomplete.access$configureUI((InputAutocomplete) this.receiver, autocompleteViewModel7);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/chat/input/autocomplete/InputEditTextAction;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<InputEditTextAction, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InputEditTextAction inputEditTextAction) {
            invoke2(inputEditTextAction);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InputEditTextAction inputEditTextAction) {
            InputAutocomplete inputAutocomplete = InputAutocomplete.this;
            Intrinsics3.checkNotNullExpressionValue(inputEditTextAction, "it");
            InputAutocomplete.access$applyEditTextAction(inputAutocomplete, inputEditTextAction);
        }
    }

    /* compiled from: InputAutocomplete.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/Event;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/autocomplete/Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocomplete$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<AutocompleteViewModel5, Unit> {
        public AnonymousClass3(InputAutocomplete inputAutocomplete) {
            super(1, inputAutocomplete, InputAutocomplete.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/input/autocomplete/Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AutocompleteViewModel5 autocompleteViewModel5) {
            invoke2(autocompleteViewModel5);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AutocompleteViewModel5 autocompleteViewModel5) {
            Intrinsics3.checkNotNullParameter(autocompleteViewModel5, "p1");
            InputAutocomplete.access$handleEvent((InputAutocomplete) this.receiver, autocompleteViewModel5);
        }
    }

    public InputAutocomplete(AppFragment appFragment, FlexInputFragment flexInputFragment, AppFlexInputViewModel appFlexInputViewModel, FlexEditText flexEditText, Long l, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, View view, RecyclerView recyclerView3, TextView textView2, WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding) {
        Intrinsics3.checkNotNullParameter(appFragment, "fragment");
        Intrinsics3.checkNotNullParameter(flexInputFragment, "flexInputFragment");
        Intrinsics3.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        Intrinsics3.checkNotNullParameter(flexEditText, "editText");
        Intrinsics3.checkNotNullParameter(textView, "autocompleteHeader");
        Intrinsics3.checkNotNullParameter(recyclerView, "autocompleteRecyclerView");
        Intrinsics3.checkNotNullParameter(recyclerView2, "commandBrowserAppsRecyclerView");
        Intrinsics3.checkNotNullParameter(view, "stickersContainer");
        Intrinsics3.checkNotNullParameter(recyclerView3, "stickersRecyclerView");
        Intrinsics3.checkNotNullParameter(textView2, "stickerHeader");
        Intrinsics3.checkNotNullParameter(widgetChatInputApplicationCommandsBinding, "selectedApplicationCommandUiBinding");
        this.fragment = appFragment;
        this.flexInputFragment = flexInputFragment;
        this.flexInputViewModel = appFlexInputViewModel;
        this.editText = flexEditText;
        this.channel = l;
        this.autocompleteHeader = textView;
        this.autocompleteRecyclerView = recyclerView;
        this.commandBrowserAppsRecyclerView = recyclerView2;
        this.stickersContainer = view;
        this.stickersRecyclerView = recyclerView3;
        this.stickerHeader = textView2;
        this.selectedApplicationCommandUiBinding = widgetChatInputApplicationCommandsBinding;
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = new ChatInputAutocompleteAdapter();
        this.autocompleteAdapter = chatInputAutocompleteAdapter;
        InputAutocomplete2 inputAutocomplete2 = new InputAutocomplete2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(appFragment);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(appFragment, Reflection2.getOrCreateKotlinClass(AutocompleteViewModel.class), new InputAutocomplete$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(inputAutocomplete2));
        appFlexInputViewModel.setAttachmentSelectedListener(new AnonymousClass1());
        flexEditText.addTextChangedListener(new AnonymousClass2());
        flexEditText.setOnSelectionChangedListener(new AnonymousClass3());
        WidgetChatInputCategoriesAdapter2 widgetChatInputCategoriesAdapter2 = new WidgetChatInputCategoriesAdapter2();
        this.categoriesAdapter = widgetChatInputCategoriesAdapter2;
        widgetChatInputCategoriesAdapter2.setOnClickApplication(new AnonymousClass4());
        RecyclerView.LayoutManager selfHealingLinearLayoutManager = new SelfHealingLinearLayoutManager(recyclerView2, widgetChatInputCategoriesAdapter2, 0, false, 8, null);
        recyclerView2.setAdapter(widgetChatInputCategoriesAdapter2);
        recyclerView2.setLayoutManager(selfHealingLinearLayoutManager);
        recyclerView2.setItemAnimator(null);
        chatInputAutocompleteAdapter.setOnItemSelected(new AnonymousClass5());
        recyclerView.setAdapter(chatInputAutocompleteAdapter);
        recyclerView.setItemAnimator(null);
        recyclerView.setBackgroundColor(ColorCompat.getThemedColor(flexEditText, R.attr.colorBackgroundSecondary));
        WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter = (WidgetChatInputAutocompleteStickerAdapter) MGRecyclerAdapter.INSTANCE.configure(new WidgetChatInputAutocompleteStickerAdapter(recyclerView3, new AnonymousClass6()));
        this.stickersAdapter = widgetChatInputAutocompleteStickerAdapter;
        recyclerView3.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView3, widgetChatInputAutocompleteStickerAdapter, 0, false, 8, null));
        recyclerView3.setAdapter(widgetChatInputAutocompleteStickerAdapter);
        RecyclerView recyclerView4 = widgetChatInputApplicationCommandsBinding.c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "selectedApplicationComma…plicationCommandsRecycler");
        SelectedApplicationCommandAdapter selectedApplicationCommandAdapter = new SelectedApplicationCommandAdapter(recyclerView4, new AnonymousClass7());
        this.selectedApplicationCommandAdapter = selectedApplicationCommandAdapter;
        selectedApplicationCommandAdapter.getRecycler().setLayoutManager(new SelfHealingLinearLayoutManager(selectedApplicationCommandAdapter.getRecycler(), selectedApplicationCommandAdapter, 0, false, 8, null));
        selectedApplicationCommandAdapter.getRecycler().setAdapter(selectedApplicationCommandAdapter);
        selectedApplicationCommandAdapter.getRecycler().setItemAnimator(null);
    }

    public static final /* synthetic */ void access$applyEditTextAction(InputAutocomplete inputAutocomplete, InputEditTextAction inputEditTextAction) {
        inputAutocomplete.applyEditTextAction(inputEditTextAction);
    }

    public static final /* synthetic */ void access$configureUI(InputAutocomplete inputAutocomplete, AutocompleteViewModel7 autocompleteViewModel7) {
        inputAutocomplete.configureUI(autocompleteViewModel7);
    }

    public static final /* synthetic */ ChatInputAutocompleteAdapter access$getAutocompleteAdapter$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.autocompleteAdapter;
    }

    public static final /* synthetic */ WidgetChatInputCategoriesAdapter2 access$getCategoriesAdapter$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.categoriesAdapter;
    }

    public static final /* synthetic */ Long access$getChannel$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.channel;
    }

    public static final /* synthetic */ RecyclerView access$getCommandBrowserAppsRecyclerView$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.commandBrowserAppsRecyclerView;
    }

    public static final /* synthetic */ Long access$getCurrentlySelectedCategory(InputAutocomplete inputAutocomplete, int i) {
        return inputAutocomplete.getCurrentlySelectedCategory(i);
    }

    public static final /* synthetic */ FlexEditText access$getEditText$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.editText;
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.flexInputViewModel;
    }

    public static final /* synthetic */ AppFragment access$getFragment$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.fragment;
    }

    public static final /* synthetic */ AutocompleteViewModel access$getViewModel$p(InputAutocomplete inputAutocomplete) {
        return inputAutocomplete.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(InputAutocomplete inputAutocomplete, AutocompleteViewModel5 autocompleteViewModel5) {
        inputAutocomplete.handleEvent(autocompleteViewModel5);
    }

    private final void applyEditTextAction(InputEditTextAction action) {
        if (!Intrinsics3.areEqual(this.editText.getEditableText().toString(), action.getAssumedInput().toString())) {
            return;
        }
        if (action instanceof InputEditTextAction.ClearSpans) {
            Editable editableText = this.editText.getEditableText();
            Intrinsics3.checkNotNullExpressionValue(editableText, "editText.editableText");
            removeSpans$default(this, editableText, null, 2, null);
            Editable editableText2 = this.editText.getEditableText();
            Intrinsics3.checkNotNullExpressionValue(editableText2, "editText.editableText");
            removePillSpans(editableText2);
            return;
        }
        if (action instanceof InputEditTextAction.ReplaceCharacterStyleSpans) {
            Editable editableText3 = this.editText.getEditableText();
            Intrinsics3.checkNotNullExpressionValue(editableText3, "editText.editableText");
            removeSpans$default(this, editableText3, null, 2, null);
            for (Map.Entry<Ranges2, List<CharacterStyle>> entry : ((InputEditTextAction.ReplaceCharacterStyleSpans) action).getSpans().entrySet()) {
                Ranges2 key = entry.getKey();
                Iterator<T> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    this.editText.getEditableText().setSpan((CharacterStyle) it.next(), key.getFirst(), key.getLast(), 33);
                }
            }
            return;
        }
        if (action instanceof InputEditTextAction.InsertText) {
            InputEditTextAction.InsertText insertText = (InputEditTextAction.InsertText) action;
            this.editText.getEditableText().replace(insertText.getInsertRange().getFirst(), insertText.getInsertRange().getLast(), insertText.getToAppend());
            this.editText.setSelection(Math.min(insertText.getSelectionIndex(), this.editText.getEditableText().length()));
            return;
        }
        if (action instanceof InputEditTextAction.RemoveText) {
            InputEditTextAction.RemoveText removeText = (InputEditTextAction.RemoveText) action;
            this.editText.getEditableText().replace(removeText.getRange().getFirst(), removeText.getRange().getLast(), "");
            this.editText.setSelection(removeText.getSelectionIndex());
            return;
        }
        if (!(action instanceof InputEditTextAction.ReplacePillSpans)) {
            if (action instanceof InputEditTextAction.SelectText) {
                InputEditTextAction.SelectText selectText = (InputEditTextAction.SelectText) action;
                this.editText.setSelection(selectText.getSelection().getFirst(), selectText.getSelection().getLast());
                return;
            } else {
                if (!(action instanceof InputEditTextAction.ReplaceText)) {
                    boolean z2 = action instanceof InputEditTextAction.None;
                    return;
                }
                InputEditTextAction.ReplaceText replaceText = (InputEditTextAction.ReplaceText) action;
                this.editText.setText(replaceText.getNewText());
                this.editText.setSelection(replaceText.getSelectionIndex());
                return;
            }
        }
        Editable editableText4 = this.editText.getEditableText();
        Intrinsics3.checkNotNullExpressionValue(editableText4, "editText.editableText");
        removePillSpans(editableText4);
        for (Map.Entry<Ranges2, List<CharacterStyle>> entry2 : ((InputEditTextAction.ReplacePillSpans) action).getSpans().entrySet()) {
            Ranges2 key2 = entry2.getKey();
            Iterator<T> it2 = entry2.getValue().iterator();
            while (it2.hasNext()) {
                this.editText.getEditableText().setSpan((CharacterStyle) it2.next(), key2.getFirst(), key2.getLast(), 33);
            }
        }
    }

    private final void configureAutocomplete(AutocompleteViewModel4 autocompleteViewState) {
        if (autocompleteViewState instanceof AutocompleteViewModel4.Autocomplete) {
            configureAutocompleteBrowser((AutocompleteViewModel4.Autocomplete) autocompleteViewState);
        } else if (autocompleteViewState instanceof AutocompleteViewModel4.CommandBrowser) {
            configureCommandBrowser((AutocompleteViewModel4.CommandBrowser) autocompleteViewState);
        } else if (Intrinsics3.areEqual(autocompleteViewState, AutocompleteViewModel4.Hidden.INSTANCE)) {
            hideAutocomplete();
        }
        if (!(autocompleteViewState instanceof AutocompleteViewModel4.CommandBrowser)) {
            this.commandBrowserOpen = false;
        }
        StoreStream.INSTANCE.getAutocomplete().setAutocompleteVisible(!(autocompleteViewState instanceof AutocompleteViewModel4.Hidden));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureAutocompleteBrowser(AutocompleteViewModel4.Autocomplete autocomplete) {
        List<Autocompletable> autocompletables;
        boolean z2 = !autocomplete.getStickers().isEmpty();
        if (!(this.autocompleteRecyclerView.getVisibility() == 0)) {
            this.autocompleteRecyclerView.setVisibility(0);
        }
        if (this.commandBrowserAppsRecyclerView.getVisibility() == 0) {
            this.commandBrowserAppsRecyclerView.setVisibility(8);
        }
        if (StringsJVM.startsWith$default(autocomplete.getToken(), String.valueOf(LeadingIdentifier.EMOJI_AND_STICKERS.getIdentifier()), false, 2, null) && (!autocomplete.getAutocompletables().isEmpty())) {
            this.autocompleteHeader.setVisibility(0);
            TextView textView = this.autocompleteHeader;
            textView.setText(FormatUtils.j(textView, R.string.emoji_matching, new Object[]{autocomplete.getToken()}, null, 4));
        } else {
            this.autocompleteHeader.setVisibility(8);
        }
        this.autocompleteHeader.setTextColor(ColorCompat.getThemedColor(this.autocompleteHeader, R.attr.colorTextNormal));
        if (autocomplete.isAutocomplete()) {
            this.autocompleteHeader.setVisibility(StringsJVM.isBlank(autocomplete.getToken()) ^ true ? 0 : 8);
            if (autocomplete.isError()) {
                TextView textView2 = this.autocompleteHeader;
                textView2.setText(FormatUtils.j(textView2, R.string.application_command_autocomplete_failed, new Object[0], null, 4));
                this.autocompleteHeader.setTextColor(ColorCompat.getThemedColor(this.autocompleteHeader, R.attr.colorTextDanger));
            } else if (autocomplete.isLoading()) {
                TextView textView3 = this.autocompleteHeader;
                textView3.setText(FormatUtils.j(textView3, R.string.options_matching, new Object[]{autocomplete.getToken()}, null, 4));
            } else {
                List<Autocompletable> autocompletables2 = autocomplete.getAutocompletables();
                if (autocompletables2 == null || autocompletables2.isEmpty()) {
                    TextView textView4 = this.autocompleteHeader;
                    textView4.setText(FormatUtils.j(textView4, R.string.application_command_autocomplete_no_options, new Object[0], null, 4));
                }
            }
        }
        this.autocompleteAdapter.setVisiblePositionListener(new AnonymousClass1());
        getViewModel().onAutocompleteItemsUpdated();
        if (!autocomplete.isLoading() || autocomplete.isError()) {
            autocompletables = autocomplete.getAutocompletables();
        } else {
            autocompletables = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                autocompletables.add(new ApplicationCommandLoadingPlaceholder(null, 1, null));
            }
        }
        ChatInputAutocompleteAdapter.setData$default(this.autocompleteAdapter, autocompletables, z2, false, 4, null);
        this.stickersRecyclerView.setVisibility(z2 ? 0 : 8);
        this.stickersContainer.setVisibility(z2 ? 0 : 8);
        if (z2) {
            TextView textView5 = this.stickerHeader;
            textView5.setText(FormatUtils.j(textView5, R.string.stickers_matching, new Object[]{StringsJVM.replace$default(autocomplete.getToken(), String.valueOf(LeadingIdentifier.EMOJI_AND_STICKERS.getIdentifier()), "", false, 4, (Object) null)}, null, 4));
            this.stickersAdapter.setData(autocomplete.getStickers());
        }
    }

    private final void configureCommandBrowser(AutocompleteViewModel4.CommandBrowser browser) {
        this.autocompleteHeader.setVisibility(8);
        this.stickersContainer.setVisibility(8);
        List<Autocompletable> flattenCommandsModel = browser.getDiscoverCommands().getFlattenCommandsModel();
        boolean z2 = (flattenCommandsModel.isEmpty() ^ true) || browser.getDiscoverCommands().getLoadState().isLoading();
        if (!this.commandBrowserOpen && z2) {
            this.commandBrowserOpen = true;
            StoreStream.Companion companion = StoreStream.INSTANCE;
            companion.getAnalytics().trackApplicationCommandBrowserOpened(companion.getChannelsSelected().getId());
        }
        if ((this.autocompleteRecyclerView.getVisibility() == 0) != z2) {
            this.autocompleteRecyclerView.setVisibility(z2 ? 0 : 8);
        }
        boolean z3 = browser.getApplications().size() > 1;
        if ((this.commandBrowserAppsRecyclerView.getVisibility() == 0) != z3) {
            this.commandBrowserAppsRecyclerView.setVisibility(z3 ? 0 : 8);
            if (z3) {
                this.categoriesAdapter.selectApplication(0L);
                this.commandBrowserAppsRecyclerView.smoothScrollToPosition(0);
            }
        }
        this.categoriesAdapter.setApplicationData(browser.getApplications());
        this.autocompleteAdapter.setVisiblePositionListener(new AnonymousClass1());
        if (this.autocompleteAdapter.getPageSize() > 3 && (browser.getDiscoverCommands().getLoadState() instanceof LoadState.JustLoadedUp)) {
            RecyclerView recyclerView = this.autocompleteRecyclerView;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
            View childAt = this.autocompleteRecyclerView.getChildAt(0);
            Intrinsics3.checkNotNullExpressionValue(childAt, "autocompleteRecyclerView.getChildAt(0)");
            this.autocompleteAdapter.scrollToPosition((flattenCommandsModel.size() - this.autocompleteAdapter.getPageSize()) + childAdapterPosition, childAt.getTop(), false);
        }
        if ((!flattenCommandsModel.isEmpty()) && this.autocompleteAdapter.getPageSize() == 4 && (this.autocompleteAdapter.getItem(0) instanceof ApplicationCommandLoadingPlaceholder) && (this.autocompleteAdapter.getItem(3) instanceof ApplicationCommandLoadingPlaceholder) && (flattenCommandsModel.get(0) instanceof ApplicationCommandLoadingPlaceholder)) {
            this.autocompleteAdapter.scrollToPosition(3, 0, false);
        }
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = this.autocompleteAdapter;
        if (browser.getDiscoverCommands().getLoadState() instanceof LoadState.Loading) {
            flattenCommandsModel = new ArrayList<>();
            int iCount = _Collections.count(new Ranges2(1, 4));
            for (int i = 0; i < iCount; i++) {
                flattenCommandsModel.add(new ApplicationCommandLoadingPlaceholder(null, 1, null));
            }
        }
        chatInputAutocompleteAdapter.setData(flattenCommandsModel, false, browser.getDiscoverCommands().getLoadState() instanceof LoadState.Loading);
    }

    private final void configureSelectedCommand(AutocompleteViewModel6 selectedCommandViewState) {
        if (Intrinsics3.areEqual(selectedCommandViewState, AutocompleteViewModel6.Hidden.INSTANCE)) {
            hideSelectedCommand();
        } else if (selectedCommandViewState instanceof AutocompleteViewModel6.SelectedCommand) {
            configureSelectedCommand((AutocompleteViewModel6.SelectedCommand) selectedCommandViewState);
        }
    }

    private final void configureUI(AutocompleteViewModel7 viewState) {
        configureAutocomplete(viewState.getAutocompleteViewState());
        configureSelectedCommand(viewState.getSelectedCommandViewState());
    }

    public static /* synthetic */ ApplicationCommandData getApplicationCommandData$default(InputAutocomplete inputAutocomplete, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandOption = null;
        }
        return inputAutocomplete.getApplicationCommandData(applicationCommandOption);
    }

    private final Long getCurrentlySelectedCategory(int topPosition) {
        Application application;
        ChatInputAutocompleteAdapter chatInputAutocompleteAdapter = this.autocompleteAdapter;
        Integer headerPositionForItem = chatInputAutocompleteAdapter.getHeaderPositionForItem(topPosition);
        Autocompletable item = chatInputAutocompleteAdapter.getItem(headerPositionForItem != null ? headerPositionForItem.intValue() : 0);
        if (!(item instanceof ApplicationPlaceholder)) {
            item = null;
        }
        ApplicationPlaceholder applicationPlaceholder = (ApplicationPlaceholder) item;
        if (applicationPlaceholder == null || (application = applicationPlaceholder.getApplication()) == null) {
            return null;
        }
        return Long.valueOf(application.getId());
    }

    private final AutocompleteViewModel getViewModel() {
        return (AutocompleteViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleEvent(AutocompleteViewModel5 event) {
        if (event instanceof AutocompleteViewModel5.ScrollAutocompletablesToApplication) {
            AutocompleteViewModel5.ScrollAutocompletablesToApplication scrollAutocompletablesToApplication = (AutocompleteViewModel5.ScrollAutocompletablesToApplication) event;
            ChatInputAutocompleteAdapter.scrollToPosition$default(this.autocompleteAdapter, scrollAutocompletablesToApplication.getTargetPosition(), 0, false, 6, null);
            this.categoriesAdapter.selectApplication(scrollAutocompletablesToApplication.getApplicationId());
            if (this.categoriesAdapter.getPositionOfApplication(scrollAutocompletablesToApplication.getApplicationId()) != -1) {
                this.commandBrowserAppsRecyclerView.smoothScrollToPosition(this.categoriesAdapter.getPositionOfApplication(scrollAutocompletablesToApplication.getApplicationId()));
                return;
            }
            return;
        }
        if (event instanceof AutocompleteViewModel5.RequestAutocompleteData) {
            Function1<? super ApplicationCommandOption, Unit> function1 = this.onPerformCommandAutocomplete;
            if (function1 != null) {
                function1.invoke(((AutocompleteViewModel5.RequestAutocompleteData) event).getOption());
                return;
            }
            return;
        }
        if (event instanceof AutocompleteViewModel5.PickAttachment) {
            this.flexInputViewModel.onGalleryButtonClicked();
            return;
        }
        if (event instanceof AutocompleteViewModel5.PreviewAttachment) {
            CommonUtils.r(this.flexInputFragment.requireContext(), this.flexInputFragment.l());
            AttachmentBottomSheet.Companion companion = AttachmentBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = this.flexInputFragment.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "flexInputFragment.childFragmentManager");
            Attachment<?> attachment = ((AutocompleteViewModel5.PreviewAttachment) event).getAttachment();
            Objects.requireNonNull(attachment, "null cannot be cast to non-null type com.lytefast.flexinput.model.Attachment<kotlin.Any>");
            companion.show(childFragmentManager, attachment, new AnonymousClass1(event), new AnonymousClass2(event), new AnonymousClass3());
        }
    }

    private final void hideAutocomplete() {
        this.autocompleteRecyclerView.setVisibility(8);
        this.commandBrowserAppsRecyclerView.setVisibility(8);
        this.stickersContainer.setVisibility(8);
        this.autocompleteHeader.setVisibility(8);
    }

    private final void hideSelectedCommand() {
        this.flexInputViewModel.setModeSingleSelect(false);
        this.flexInputViewModel.setAttachmentViewEnabled(true);
        ConstraintLayout constraintLayout = this.selectedApplicationCommandUiBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "selectedApplicationCommandUiBinding.root");
        constraintLayout.setVisibility(8);
    }

    private final void removePillSpans(Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (obj instanceof SimpleRoundedBackgroundSpan) {
                spannable.removeSpan(obj);
            }
        }
    }

    private final void removeSpans(Spannable spannable, Ranges2 spanRange) {
        for (Object obj : spannable.getSpans(spanRange.getFirst(), spanRange.getLast(), Object.class)) {
            if ((obj instanceof CharacterStyle) && !(obj instanceof SimpleRoundedBackgroundSpan)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static /* synthetic */ void removeSpans$default(InputAutocomplete inputAutocomplete, Spannable spannable, Ranges2 ranges2, int i, Object obj) {
        if ((i & 2) != 0) {
            ranges2 = new Ranges2(0, spannable.length());
        }
        inputAutocomplete.removeSpans(spannable, ranges2);
    }

    public final ApplicationCommandData getApplicationCommandData(ApplicationCommandOption focusedOption) {
        return getViewModel().getApplicationSendData(focusedOption);
    }

    public final Map<ApplicationCommandOption, Attachment<?>> getCommandAttachments() {
        return getViewModel().getCommandAttachments();
    }

    public final MessageContent getInputContent() {
        WidgetChatInputEditText.Companion companion = WidgetChatInputEditText.INSTANCE;
        String stringSafe = companion.toStringSafe(this.editText);
        String stringSafe2 = companion.toStringSafe(this.editText);
        int length = stringSafe2.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics3.compare(stringSafe2.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        String string = stringSafe2.subSequence(i, length + 1).toString();
        return !TextUtils.isEmpty(string) ? getViewModel().replaceAutocompletableDataWithServerValues(stringSafe) : new MessageContent(string, Collections2.emptyList());
    }

    public final Function1<ApplicationCommandOption, Unit> getOnPerformCommandAutocomplete() {
        return this.onPerformCommandAutocomplete;
    }

    public final void onCommandInputsSendError() {
        getViewModel().onApplicationCommandSendError();
    }

    public final void onViewBoundOrOnResume() {
        this.autocompleteAdapter.configureSubscriptions(this.fragment);
        Observable<AutocompleteViewModel7> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this.fragment, null, 2, null), InputAutocomplete.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        Observable<InputEditTextAction> observableR2 = getViewModel().observeEditTextActions().r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "viewModel.observeEditTex…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR2, this.fragment, null, 2, null), InputAutocomplete.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this.fragment, null, 2, null), InputAutocomplete.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(this), 62, (Object) null);
    }

    public final void setOnPerformCommandAutocomplete(Function1<? super ApplicationCommandOption, Unit> function1) {
        this.onPerformCommandAutocomplete = function1;
    }

    private final void configureSelectedCommand(AutocompleteViewModel6.SelectedCommand viewState) {
        this.flexInputViewModel.setModeSingleSelect(true);
        this.flexInputViewModel.setAttachmentViewEnabled(false);
        ConstraintLayout constraintLayout = this.selectedApplicationCommandUiBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "selectedApplicationCommandUiBinding.root");
        constraintLayout.setVisibility(0);
        this.selectedApplicationCommandAdapter.clear();
        this.selectedApplicationCommandAdapter.setApplicationCommand(viewState.getSelectedCommand(), viewState.getSelectedApplication());
        ApplicationCommandOption selectedCommandOption = viewState.getSelectedCommandOption();
        if (selectedCommandOption != null) {
            if (viewState.getSelectedCommandOptionErrors().contains(selectedCommandOption)) {
                TextView textView = this.selectedApplicationCommandUiBinding.f2301b;
                Intrinsics3.checkNotNullExpressionValue(textView, "selectedApplicationComma…CommandsOptionDescription");
                Resources resources = this.editText.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "editText.resources");
                textView.setText(StoreApplicationCommandsKt.getErrorText(selectedCommandOption, resources));
                WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding = this.selectedApplicationCommandUiBinding;
                TextView textView2 = widgetChatInputApplicationCommandsBinding.f2301b;
                ConstraintLayout constraintLayout2 = widgetChatInputApplicationCommandsBinding.a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "selectedApplicationCommandUiBinding.root");
                textView2.setTextColor(ColorCompat.getColor(constraintLayout2.getContext(), R.color.status_red_500));
            } else {
                TextView textView3 = this.selectedApplicationCommandUiBinding.f2301b;
                Intrinsics3.checkNotNullExpressionValue(textView3, "selectedApplicationComma…CommandsOptionDescription");
                Resources resources2 = this.editText.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "editText.resources");
                textView3.setText(StoreApplicationCommandsKt.getDescriptionText(selectedCommandOption, resources2));
                this.selectedApplicationCommandUiBinding.f2301b.setTextColor(ColorCompat.getThemedColor(this.editText.getContext(), R.attr.colorTextNormal));
            }
            this.selectedApplicationCommandAdapter.highlightOption(selectedCommandOption);
        } else {
            TextView textView4 = this.selectedApplicationCommandUiBinding.f2301b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "selectedApplicationComma…CommandsOptionDescription");
            ApplicationCommand selectedCommand = viewState.getSelectedCommand();
            Resources resources3 = this.editText.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources3, "editText.resources");
            textView4.setText(StoreApplicationCommandsKt.getDescriptionText(selectedCommand, resources3));
            this.selectedApplicationCommandUiBinding.f2301b.setTextColor(ColorCompat.getThemedColor(this.editText.getContext(), R.attr.colorTextNormal));
            this.selectedApplicationCommandAdapter.clearParamOptionHighlight();
        }
        this.selectedApplicationCommandAdapter.setVerified(viewState.getValidSelectedCommandOptions(), viewState.getSelectedCommandOptionErrors());
    }

    public /* synthetic */ InputAutocomplete(AppFragment appFragment, FlexInputFragment flexInputFragment, AppFlexInputViewModel appFlexInputViewModel, FlexEditText flexEditText, Long l, TextView textView, RecyclerView recyclerView, RecyclerView recyclerView2, View view, RecyclerView recyclerView3, TextView textView2, WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appFragment, flexInputFragment, appFlexInputViewModel, flexEditText, (i & 16) != 0 ? null : l, textView, recyclerView, recyclerView2, view, recyclerView3, textView2, widgetChatInputApplicationCommandsBinding);
    }
}
