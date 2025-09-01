package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMemberVerificationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.views.MemberVerificationAvatarView;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel;
import com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetMemberVerification.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b#\u0010\u0013J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerification;", "Lcom/discord/app/AppFragment;", "Lcom/discord/models/guild/Guild;", "parseInviteGuild", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;)V", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState$Loaded;", "configureLoadedUI", "(Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState$Loaded;)V", "configureVerificationBanner", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetMemberVerificationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetMemberVerificationBinding;", "binding", "Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "rulesAdapter", "Lcom/discord/widgets/servers/member_verification/MemberVerificationRulesAdapter;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetMemberVerification extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetMemberVerification.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_INVITE_GUILD = "INTENT_EXTRA_INVITE_GUILD";
    private static final String INTENT_EXTRA_LOCATION = "INTENT_EXTRA_LOCATION";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private MemberVerificationRulesAdapter rulesAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetMemberVerification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerification$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Lcom/discord/models/domain/ModelInvite;", "invite", "", "create", "(Landroid/content/Context;JLjava/lang/String;Lcom/discord/models/domain/ModelInvite;)V", "INTENT_EXTRA_GUILD_ID", "Ljava/lang/String;", WidgetMemberVerification.INTENT_EXTRA_INVITE_GUILD, WidgetMemberVerification.INTENT_EXTRA_LOCATION, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, Context context, long j, String str, ModelInvite modelInvite, int i, Object obj) {
            if ((i & 8) != 0) {
                modelInvite = null;
            }
            companion.create(context, j, str, modelInvite);
        }

        public final void create(Context context, long guildId, String location, ModelInvite invite) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetMemberVerification.INTENT_EXTRA_LOCATION, location);
            if ((invite != null ? invite.guild : null) != null) {
                intent.putExtra(WidgetMemberVerification.INTENT_EXTRA_INVITE_GUILD, new Gson().m(invite.guild));
            }
            AppScreen2.d(context, WidgetMemberVerification.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ApplicationStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationStatus.PENDING.ordinal()] = 1;
            iArr[ApplicationStatus.APPROVED.ordinal()] = 2;
            WidgetMemberVerificationViewModel.VerificationType.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[WidgetMemberVerificationViewModel.VerificationType.EMAIL.ordinal()] = 1;
            iArr2[WidgetMemberVerificationViewModel.VerificationType.PHONE.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetMemberVerification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$configureLoadedUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMemberVerification.access$getViewModel$p(WidgetMemberVerification.this).applyToJoinGuild();
        }
    }

    /* compiled from: WidgetMemberVerification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$configureVerificationBanner$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserEmailVerify.INSTANCE.launch(WidgetMemberVerification.this.requireContext(), WidgetUserAccountVerifyBase.Mode.UNFORCED);
        }
    }

    /* compiled from: WidgetMemberVerification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$configureVerificationBanner$2, reason: invalid class name */
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
            WidgetUserPhoneManage.INSTANCE.launch(WidgetMemberVerification.this.requireContext(), WidgetUserAccountVerifyBase.Mode.UNFORCED, WidgetUserPhoneManage.Companion.Source.GUILD_PHONE_REQUIRED);
        }
    }

    /* compiled from: WidgetMemberVerification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isTermsApproved", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetMemberVerification.access$getViewModel$p(WidgetMemberVerification.this).updateTermsApproval(z2);
        }
    }

    /* compiled from: WidgetMemberVerification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "fieldIndex", "", "value", "", "invoke", "(ILjava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<Integer, Object, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Object obj) {
            invoke(num.intValue(), obj);
            return Unit.a;
        }

        public final void invoke(int i, Object obj) {
            Intrinsics3.checkNotNullParameter(obj, "value");
            WidgetMemberVerification.access$getViewModel$p(WidgetMemberVerification.this).updateFormValidation(i, obj);
        }
    }

    /* compiled from: WidgetMemberVerification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetMemberVerificationViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetMemberVerification widgetMemberVerification) {
            super(1, widgetMemberVerification, WidgetMemberVerification.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetMemberVerificationViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetMemberVerificationViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetMemberVerification.access$configureUI((WidgetMemberVerification) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetMemberVerification.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event;", "event", "", "invoke", "(Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetMemberVerificationViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetMemberVerificationViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetMemberVerificationViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (!(event instanceof WidgetMemberVerificationViewModel.Event.Success)) {
                if (event instanceof WidgetMemberVerificationViewModel.Event.Error) {
                    AppToast.i(WidgetMemberVerification.this, R.string.guild_settings_public_update_failed, 0, 4);
                    return;
                }
                return;
            }
            WidgetMemberVerification.this.requireActivity().finish();
            WidgetMemberVerificationViewModel.Event.Success success = (WidgetMemberVerificationViewModel.Event.Success) event;
            int iOrdinal = success.getApplicationStatus().ordinal();
            if (iOrdinal == 1) {
                if (success.getGuildId() == null || success.getGuildName() == null) {
                    return;
                }
                MemberVerificationPendingDialog.INSTANCE.enqueue(success.getGuildId().longValue(), MemberVerificationPendingViewModel.DialogState.PENDING);
                return;
            }
            if (iOrdinal == 3 && success.getGuildId() != null && success.getGuildName() != null && success.getLastSeen() == null) {
                MemberVerificationSuccessDialog.INSTANCE.enqueue(success.getGuildId().longValue());
            }
        }
    }

    public WidgetMemberVerification() {
        super(R.layout.widget_member_verification);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetMemberVerification2.INSTANCE, null, 2, null);
        WidgetMemberVerification3 widgetMemberVerification3 = new WidgetMemberVerification3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetMemberVerificationViewModel.class), new WidgetMemberVerification$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetMemberVerification3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetMemberVerification widgetMemberVerification, WidgetMemberVerificationViewModel.ViewState viewState) {
        widgetMemberVerification.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetMemberVerificationViewModel access$getViewModel$p(WidgetMemberVerification widgetMemberVerification) {
        return widgetMemberVerification.getViewModel();
    }

    public static final /* synthetic */ Guild access$parseInviteGuild(WidgetMemberVerification widgetMemberVerification) {
        return widgetMemberVerification.parseInviteGuild();
    }

    private final void configureLoadedUI(WidgetMemberVerificationViewModel.ViewState.Loaded viewState) {
        NestedScrollView nestedScrollView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.memberVerificationScrollview");
        nestedScrollView.setVisibility(0);
        getBinding().e.setIsLoading(viewState.getSubmitting());
        DimmerView.setDimmed$default(getBinding().f2488b, false, false, 2, null);
        LoadingButton loadingButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.memberVerificationRulesConfirm");
        loadingButton.setEnabled(!viewState.getDisabled());
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.memberVerificationRulesRecycler");
        recyclerView.setVisibility(viewState.isRulesListVisible() ? 0 : 8);
        MemberVerificationAvatarView memberVerificationAvatarView = getBinding().d;
        Guild guild = viewState.getGuild();
        Objects.requireNonNull(memberVerificationAvatarView);
        boolean z2 = guild != null && guild.hasIcon();
        TextView textView = memberVerificationAvatarView.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationText");
        textView.setVisibility(z2 ^ true ? 0 : 8);
        if (z2) {
            SimpleDraweeView simpleDraweeView = memberVerificationAvatarView.binding.f214b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.memberVerificationAvatar");
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForGuild$default(guild, null, false, null, 14, null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            TextView textView2 = memberVerificationAvatarView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.memberVerificationText");
            textView2.setText("");
        } else {
            TextView textView3 = memberVerificationAvatarView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.memberVerificationText");
            textView3.setText(guild != null ? guild.getShortName() : null);
        }
        getBinding().e.setOnClickListener(new AnonymousClass1());
        MemberVerificationRulesAdapter memberVerificationRulesAdapter = this.rulesAdapter;
        if (memberVerificationRulesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        memberVerificationRulesAdapter.setData(viewState.getFormItems());
        configureVerificationBanner(viewState);
    }

    private final void configureUI(WidgetMemberVerificationViewModel.ViewState viewState) {
        if (viewState instanceof WidgetMemberVerificationViewModel.ViewState.Invalid) {
            AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
            requireActivity().finish();
        } else if (viewState instanceof WidgetMemberVerificationViewModel.ViewState.Loaded) {
            configureLoadedUI((WidgetMemberVerificationViewModel.ViewState.Loaded) viewState);
        } else {
            if (!(viewState instanceof WidgetMemberVerificationViewModel.ViewState.Loading)) {
                throw new NoWhenBranchMatchedException();
            }
            NestedScrollView nestedScrollView = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.memberVerificationScrollview");
            nestedScrollView.setVisibility(8);
            DimmerView.setDimmed$default(getBinding().f2488b, true, false, 2, null);
        }
    }

    private final void configureVerificationBanner(WidgetMemberVerificationViewModel.ViewState.Loaded viewState) {
        MemberVerificationView memberVerificationView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(memberVerificationView, "binding.memberVerificationContainer");
        memberVerificationView.setVisibility(viewState.getVerificationType() != null ? 0 : 8);
        WidgetMemberVerificationViewModel.VerificationType verificationType = viewState.getVerificationType();
        if (verificationType == null) {
            return;
        }
        int iOrdinal = verificationType.ordinal();
        if (iOrdinal == 0) {
            getBinding().c.configure(R.drawable.ic_phone_verification_24dp, R.string.member_verification_form_item_phone_verification_label, !viewState.getNeedsAdditionalVerification(), new AnonymousClass2());
        } else {
            if (iOrdinal != 1) {
                return;
            }
            getBinding().c.configure(R.drawable.ic_email_verification_24dp, R.string.member_verification_form_item_email_verification_label, !viewState.getNeedsAdditionalVerification(), new AnonymousClass1());
        }
    }

    public static final void create(Context context, long j, String str, ModelInvite modelInvite) {
        INSTANCE.create(context, j, str, modelInvite);
    }

    private final WidgetMemberVerificationBinding getBinding() {
        return (WidgetMemberVerificationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetMemberVerificationViewModel getViewModel() {
        return (WidgetMemberVerificationViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Guild parseInviteGuild() throws JsonSyntaxException {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_INVITE_GUILD);
        if (stringExtra == 0) {
            return (Guild) stringExtra;
        }
        return (Guild) f.E1(Guild.class).cast(new Gson().g(stringExtra, Guild.class));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.memberVerificationRulesRecycler");
        this.rulesAdapter = new MemberVerificationRulesAdapter(recyclerView, this);
        getBinding().f.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.memberVerificationRulesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        MemberVerificationRulesAdapter memberVerificationRulesAdapter = this.rulesAdapter;
        if (memberVerificationRulesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        memberVerificationRulesAdapter.setOnUpdateRulesApproval(new AnonymousClass1());
        MemberVerificationRulesAdapter memberVerificationRulesAdapter2 = this.rulesAdapter;
        if (memberVerificationRulesAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        memberVerificationRulesAdapter2.setOnUserInputDataEntered(new AnonymousClass2());
        RecyclerView recyclerView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.memberVerificationRulesRecycler");
        MemberVerificationRulesAdapter memberVerificationRulesAdapter3 = this.rulesAdapter;
        if (memberVerificationRulesAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        recyclerView3.setAdapter(memberVerificationRulesAdapter3);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetMemberVerification.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetMemberVerification.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
