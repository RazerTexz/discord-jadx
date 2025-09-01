package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageRaisedHandsBottomSheetBinding;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b3\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010$\u001a\u00060\u001fj\u0002` 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010(R\u001d\u0010/\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState;)V", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded;", "configureToggleSpeakerState", "(Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded;)V", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event;)V", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getAdapter", "()Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter;", "adapter", "", "Lcom/discord/primitives/ChannelId;", "channelId$delegate", "getChannelId", "()J", "channelId", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel;", "viewModel", "Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", "binding", "", "hasReceivedInitialRaisedHandsState", "Z", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStageRaisedHandsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private boolean hasReceivedInitialRaisedHandsState;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheet;", "show", "(Landroidx/fragment/app/FragmentManager;J)Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheet;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final WidgetStageRaisedHandsBottomSheet show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet = new WidgetStageRaisedHandsBottomSheet();
            widgetStageRaisedHandsBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetStageRaisedHandsBottomSheet.show(fragmentManager, WidgetStageRaisedHandsBottomSheet.class.getSimpleName());
            return widgetStageRaisedHandsBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03451 extends Lambda implements Function0<Unit> {
            public C03451() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppToast.g(WidgetStageRaisedHandsBottomSheet.this.getContext(), R.string.stage_channel_permission_microphone_denied, 0, null, 12);
            }
        }

        /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetStageRaisedHandsBottomSheet.access$getViewModel$p(WidgetStageRaisedHandsBottomSheet.this).setSpeakingState(false);
            }
        }

        public AnonymousClass1(WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean zIsSpeaker = this.$viewState.isSpeaker();
            if (zIsSpeaker) {
                WidgetStageRaisedHandsBottomSheet.access$getViewModel$p(WidgetStageRaisedHandsBottomSheet.this).setSpeakingState(true);
            } else {
                if (zIsSpeaker) {
                    return;
                }
                WidgetStageRaisedHandsBottomSheet.this.requestMicrophone(new C03451(), new AnonymousClass2());
            }
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetStageRaisedHandsBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetStageRaisedHandsBottomSheet.access$configureUI(WidgetStageRaisedHandsBottomSheet.this, viewState);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetStageRaisedHandsBottomSheetViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetStageRaisedHandsBottomSheet.access$handleEvent(WidgetStageRaisedHandsBottomSheet.this, event);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceUser", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(WidgetStageRaisedHandsBottomSheet.access$getChannelId$p(WidgetStageRaisedHandsBottomSheet.this));
            FragmentManager parentFragmentManager = WidgetStageRaisedHandsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, parentFragmentManager, null, null, null, null, 120, null);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "p1", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass3(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "dismissRequestToSpeak", "dismissRequestToSpeak(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).dismissRequestToSpeak(voiceUser);
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "p1", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass4(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "inviteToSpeak", "inviteToSpeak(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).inviteToSpeak(voiceUser);
        }
    }

    public WidgetStageRaisedHandsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageRaisedHandsBottomSheet4.INSTANCE, null, 2, null);
        this.adapter = LazyJVM.lazy(new WidgetStageRaisedHandsBottomSheet3(this));
        this.channelId = LazyJVM.lazy(new WidgetStageRaisedHandsBottomSheet5(this));
        WidgetStageRaisedHandsBottomSheet6 widgetStageRaisedHandsBottomSheet6 = new WidgetStageRaisedHandsBottomSheet6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetStageRaisedHandsBottomSheetViewModel.class), new WidgetStageRaisedHandsBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStageRaisedHandsBottomSheet6));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet, WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
        widgetStageRaisedHandsBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetBinding access$getBinding$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getChannelId();
    }

    public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel access$getViewModel$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet, WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
        widgetStageRaisedHandsBottomSheet.handleEvent(event);
    }

    private final void configureToggleSpeakerState(WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded viewState) {
        String string;
        int i;
        getBinding().g.setOnClickListener(new AnonymousClass1(viewState));
        MaterialTextView materialTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.toggleSpeakerStateButton");
        boolean zIsSpeaker = viewState.isSpeaker();
        if (zIsSpeaker) {
            string = getString(R.string.move_me_to_audience);
        } else {
            if (zIsSpeaker) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(R.string.moderator_raise_own_hand);
        }
        materialTextView.setText(string);
        ImageView imageView = getBinding().h;
        boolean zIsSpeaker2 = viewState.isSpeaker();
        if (zIsSpeaker2) {
            i = R.drawable.ic_stage_move_to_audience;
        } else {
            if (zIsSpeaker2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.drawable.ic_stage_move_to_speaker;
        }
        imageView.setImageResource(i);
    }

    private final void configureUI(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded) {
            WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded loaded = (WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded) viewState;
            getBinding().f.setText(loaded.isRequestToSpeakEnabled() ? R.string.request_to_speak_area_all_roles : R.string.request_to_speak_area_all_roles_disabled);
            SwitchMaterial switchMaterial = getBinding().d;
            switchMaterial.setEnabled(!loaded.isUpdatingRequestToSpeakPermissions());
            if (!loaded.isUpdatingRequestToSpeakPermissions()) {
                ViewExtensions.setProgrammaticChecked(switchMaterial, loaded.isRequestToSpeakEnabled(), new WidgetStageRaisedHandsBottomSheet2(this, viewState));
            }
            if (!this.hasReceivedInitialRaisedHandsState) {
                this.hasReceivedInitialRaisedHandsState = true;
                switchMaterial.jumpDrawablesToCurrentState();
            }
            Group group = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(group, "binding.raisedHandsEmptyGroup");
            group.setVisibility(loaded.getIsEmpty() ? 0 : 8);
            MaterialTextView materialTextView = getBinding().f2657b;
            Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.raisedHandsCountLabel");
            FormatUtils.n(materialTextView, R.string.request_to_speak_list_title, new Object[]{Integer.valueOf(loaded.getRaisedHandsParticipants().size())}, null, 4);
            configureToggleSpeakerState(loaded);
            getAdapter().setData(loaded.getRaisedHandsParticipants());
        }
    }

    private final WidgetStageRaisedHandsBottomSheetAdapter getAdapter() {
        return (WidgetStageRaisedHandsBottomSheetAdapter) this.adapter.getValue();
    }

    private final WidgetStageRaisedHandsBottomSheetBinding getBinding() {
        return (WidgetStageRaisedHandsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetStageRaisedHandsBottomSheetViewModel getViewModel() {
        return (WidgetStageRaisedHandsBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
        if (event instanceof WidgetStageRaisedHandsBottomSheetViewModel.Event.Dismiss) {
            dismiss();
        } else if (event instanceof WidgetStageRaisedHandsBottomSheetViewModel.Event.Error) {
            ((WidgetStageRaisedHandsBottomSheetViewModel.Event.Error) event).getError().showToasts(getContext());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_stage_raised_hands_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStageRaisedHandsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetStageRaisedHandsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.hasReceivedInitialRaisedHandsState = false;
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().e;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.widget_stage_raised_hands_divider);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        maxHeightRecyclerView.addItemDecoration(dividerItemDecoration);
        getAdapter().setOnViewProfile(new AnonymousClass2());
        getAdapter().setOnDismissRequest(new AnonymousClass3(getViewModel()));
        getAdapter().setOnInviteToSpeak(new AnonymousClass4(getViewModel()));
        MGRecyclerAdapter.INSTANCE.configure(getAdapter());
    }
}
