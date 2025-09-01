package com.discord.widgets.channels;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelPickerSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.SearchInputView;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheetViewModel;
import com.discord.widgets.chat.AutocompleteUtils;
import d0.LazyJVM;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetChannelPickerBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u00018\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0007¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00042\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010+\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u001d\u0010.\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010#\u001a\u0004\b-\u0010*R\u001d\u00103\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010#\u001a\u0004\b1\u00102R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "Lkotlin/Function0;", "setOnCancel", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/databinding/WidgetChannelPickerSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelPickerSheetBinding;", "binding", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel;", "viewModel", "", "guildId$delegate", "getGuildId", "()J", "guildId", "selectedChannelId$delegate", "getSelectedChannelId", "selectedChannelId", "", "hideAnnouncementChannels$delegate", "getHideAnnouncementChannels", "()Z", "hideAnnouncementChannels", "Lcom/discord/widgets/channels/WidgetchannelPickerAdapter;", "adapter", "Lcom/discord/widgets/channels/WidgetchannelPickerAdapter;", "Lkotlin/jvm/functions/Function0;", "com/discord/widgets/channels/WidgetChannelPickerBottomSheet$itemClickListener$1", "itemClickListener", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheet$itemClickListener$1;", "<init>", "()V", "Companion", "SelectionType", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet extends AppBottomSheet {
    private static final String ARG_CHANNEL_PICKER_GUILD_ID = "ARG_CHANNEL_PICKER_GUILD_ID";
    private static final String ARG_HIDE_ANNOUNCEMENT_CHANNELS = "ARG_HIDE_ANNOUNCEMENT_CHANNELS";
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String ARG_SELECTED_CHANNEL_ID = "ARG_SELECTED_CHANNEL_ID";
    private static final int CHANNEL_PICKER_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int CHANNEL_PICKER_VIEW_FLIPPER_RESULT = 1;
    private static final String RESULT_EXTRA_CHANNEL_ICON_RES_ID = "RESULT_EXTRA_CHANNEL_ICON_RES_ID";
    private static final String RESULT_EXTRA_CHANNEL_ID = "RESULT_EXTRA_CHANNEL_ID";
    private static final String RESULT_EXTRA_CHANNEL_NAME = "RESULT_EXTRA_CHANNEL_NAME";
    private static final String RESULT_EXTRA_SELECTION_TYPE = "RESULT_EXTRA_SELECTION_TYPE";
    private WidgetChannelPickerAdapter3 adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: hideAnnouncementChannels$delegate, reason: from kotlin metadata */
    private final Lazy hideAnnouncementChannels;
    private final WidgetChannelPickerBottomSheet6 itemClickListener;
    private Function0<Unit> onCancel;

    /* renamed from: selectedChannelId$delegate, reason: from kotlin metadata */
    private final Lazy selectedChannelId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelPickerBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelPickerSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetChannelPickerBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%JO\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\u000b\u001a\u001e\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u000e\u0010\u000fJW\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0011\u001a\u00060\u0007j\u0002`\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0019¨\u0006&"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheet$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "requestKey", "Lkotlin/Function3;", "", "Lcom/discord/primitives/ChannelId;", "", "", "onChannelSelected", "Lkotlin/Function0;", "onCreateChannelSelected", "registerForResult", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/primitives/GuildId;", "guildId", "selectedChannelId", "onCancel", "", "hideAnnouncementChannels", "launch", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;JLjava/lang/Long;Lkotlin/jvm/functions/Function0;Z)V", WidgetChannelPickerBottomSheet.ARG_CHANNEL_PICKER_GUILD_ID, "Ljava/lang/String;", WidgetChannelPickerBottomSheet.ARG_HIDE_ANNOUNCEMENT_CHANNELS, "ARG_REQUEST_KEY", WidgetChannelPickerBottomSheet.ARG_SELECTED_CHANNEL_ID, "CHANNEL_PICKER_VIEW_FLIPPER_LOADING_STATE", "I", "CHANNEL_PICKER_VIEW_FLIPPER_RESULT", WidgetChannelPickerBottomSheet.RESULT_EXTRA_CHANNEL_ICON_RES_ID, WidgetChannelPickerBottomSheet.RESULT_EXTRA_CHANNEL_ID, WidgetChannelPickerBottomSheet.RESULT_EXTRA_CHANNEL_NAME, WidgetChannelPickerBottomSheet.RESULT_EXTRA_SELECTION_TYPE, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                SelectionType.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[SelectionType.CREATE_CHANNEL.ordinal()] = 1;
                iArr[SelectionType.CHANNEL.ordinal()] = 2;
                iArr[SelectionType.UNKNOWN.ordinal()] = 3;
            }
        }

        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Fragment fragment, String str, long j, Long l, Function0 function0, boolean z2, int i, Object obj) {
            companion.launch(fragment, str, j, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : function0, (i & 32) != 0 ? false : z2);
        }

        public final void launch(Fragment fragment, String requestKey, long guildId, Long selectedChannelId, Function0<Unit> onCancel, boolean hideAnnouncementChannels) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = new WidgetChannelPickerBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetChannelPickerBottomSheet.ARG_REQUEST_KEY, requestKey);
            bundle.putLong(WidgetChannelPickerBottomSheet.ARG_CHANNEL_PICKER_GUILD_ID, guildId);
            bundle.putBoolean(WidgetChannelPickerBottomSheet.ARG_HIDE_ANNOUNCEMENT_CHANNELS, hideAnnouncementChannels);
            if (selectedChannelId != null) {
                bundle.putLong(WidgetChannelPickerBottomSheet.ARG_SELECTED_CHANNEL_ID, selectedChannelId.longValue());
            }
            widgetChannelPickerBottomSheet.setArguments(bundle);
            widgetChannelPickerBottomSheet.setOnCancel(onCancel);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetChannelPickerBottomSheet.show(parentFragmentManager, WidgetChannelPickerBottomSheet.class.getName());
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function3<? super Long, ? super String, ? super Integer, Unit> onChannelSelected, Function0<Unit> onCreateChannelSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onChannelSelected, "onChannelSelected");
            Intrinsics3.checkNotNullParameter(onCreateChannelSelected, "onCreateChannelSelected");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetChannelPickerBottomSheet2(requestKey, onCreateChannelSelected, onChannelSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelPickerBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheet$SelectionType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "UNKNOWN", "CREATE_CHANNEL", AutocompleteUtils.CHANNEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum SelectionType {
        UNKNOWN,
        CREATE_CHANNEL,
        CHANNEL;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: WidgetChannelPickerBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheet$SelectionType$Companion;", "", "", "value", "Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheet$SelectionType;", "fromInt", "(I)Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheet$SelectionType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final SelectionType fromInt(int value) {
                SelectionType selectionType = (SelectionType) _Arrays.getOrNull(SelectionType.values(), value);
                return selectionType != null ? selectionType : SelectionType.UNKNOWN;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: WidgetChannelPickerBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/channels/WidgetChannelPickerBottomSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetChannelPickerBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetChannelPickerBottomSheet.access$configureUI(WidgetChannelPickerBottomSheet.this, viewState);
        }
    }

    /* compiled from: WidgetChannelPickerBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "searchQuery", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$onViewCreated$1, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            WidgetChannelPickerBottomSheet.access$getViewModel$p(WidgetChannelPickerBottomSheet.this).updateSearchQuery(str);
        }
    }

    public WidgetChannelPickerBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelPickerBottomSheet3.INSTANCE, null, 2, null);
        this.selectedChannelId = LazyJVM.lazy(new WidgetChannelPickerBottomSheet7(this));
        this.guildId = LazyJVM.lazy(new WidgetChannelPickerBottomSheet4(this));
        this.hideAnnouncementChannels = LazyJVM.lazy(new WidgetChannelPickerBottomSheet5(this));
        WidgetChannelPickerBottomSheet8 widgetChannelPickerBottomSheet8 = new WidgetChannelPickerBottomSheet8(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelPickerBottomSheetViewModel.class), new WidgetChannelPickerBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelPickerBottomSheet8));
        this.itemClickListener = new WidgetChannelPickerBottomSheet6(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet, WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
        widgetChannelPickerBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getGuildId();
    }

    public static final /* synthetic */ boolean access$getHideAnnouncementChannels$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getHideAnnouncementChannels();
    }

    public static final /* synthetic */ long access$getSelectedChannelId$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getSelectedChannelId();
    }

    public static final /* synthetic */ WidgetChannelPickerBottomSheetViewModel access$getViewModel$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getViewModel();
    }

    private final void configureUI(WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetChannelPickerBottomSheetViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2264b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.channelPickerAppFlipper");
            appViewFlipper.setDisplayedChild(0);
            SearchInputView searchInputView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(searchInputView, "binding.channelPickerSearchInput");
            searchInputView.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetChannelPickerBottomSheetViewModel.ViewState.Loaded) {
            SearchInputView searchInputView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(searchInputView2, "binding.channelPickerSearchInput");
            searchInputView2.setVisibility(0);
            AppViewFlipper appViewFlipper2 = getBinding().f2264b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.channelPickerAppFlipper");
            appViewFlipper2.setDisplayedChild(1);
            WidgetChannelPickerAdapter3 widgetChannelPickerAdapter3 = this.adapter;
            if (widgetChannelPickerAdapter3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            widgetChannelPickerAdapter3.setItems(((WidgetChannelPickerBottomSheetViewModel.ViewState.Loaded) viewState).getAdapterItems());
        }
    }

    private final WidgetChannelPickerSheetBinding getBinding() {
        return (WidgetChannelPickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final boolean getHideAnnouncementChannels() {
        return ((Boolean) this.hideAnnouncementChannels.getValue()).booleanValue();
    }

    private final long getSelectedChannelId() {
        return ((Number) this.selectedChannelId.getValue()).longValue();
    }

    private final WidgetChannelPickerBottomSheetViewModel getViewModel() {
        return (WidgetChannelPickerBottomSheetViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnCancel$default(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        widgetChannelPickerBottomSheet.setOnCancel(function0);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelPickerBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channel_picker_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new WidgetChannelPickerAdapter3(this.itemClickListener, this, null, 4, null);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.channelPickerRecycler");
        WidgetChannelPickerAdapter3 widgetChannelPickerAdapter3 = this.adapter;
        if (widgetChannelPickerAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(widgetChannelPickerAdapter3);
        getBinding().d.a(this, new AnonymousClass1());
    }

    public final void setOnCancel(Function0<Unit> onCancel) {
        this.onCancel = onCancel;
    }
}
