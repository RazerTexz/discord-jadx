package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwner2;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.coroutines.AppCoroutineScope;
import com.discord.utilities.coroutines.RxCoroutineExtensions;
import com.discord.utilities.error.AppCancellationException;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guilds.GuildCaptchaUtils;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.guilds.join.InviteArgs;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.hubs.WidgetHubEmailViewModel2;
import com.discord.widgets.hubs.WidgetHubEmailViewModel3;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import d0.Result3;
import d0.w.SafeContinuationJvm;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import retrofit2.HttpException;
import rx.Observable;

/* compiled from: InviteJoinHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ´\u0001\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112&\b\u0002\u0010\u0016\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132$\b\u0002\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132$\b\u0002\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/discord/widgets/guilds/invite/InviteJoinHelper;", "", "Lcom/discord/models/domain/ModelInvite;", "modelInvite", "", "navigateToGuild", "(Lcom/discord/models/domain/ModelInvite;)V", "Landroid/content/Context;", "context", "Lcom/discord/app/AppFragment;", "appFragment", "navigateToChannel", "(Landroid/content/Context;Lcom/discord/app/AppFragment;Lcom/discord/models/domain/ModelInvite;)V", "invite", "Ljava/lang/Class;", "javaClass", "fragment", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Lkotlin/Function2;", "Lcom/discord/utilities/error/Error;", "Lkotlin/coroutines/Continuation;", "onInvitePostError", "onInvitePostSuccess", "onInviteFlowFinished", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "Lkotlinx/coroutines/Job;", "joinViaInvite", "(Lcom/discord/models/domain/ModelInvite;Ljava/lang/Class;Lcom/discord/app/AppFragment;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)Lkotlinx/coroutines/Job;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class InviteJoinHelper {
    public static final InviteJoinHelper INSTANCE = new InviteJoinHelper();

    /* compiled from: InviteJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$1", f = "InviteJoinHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<Error, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Error error, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(error, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* compiled from: InviteJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$2", f = "InviteJoinHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* compiled from: InviteJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$3", f = "InviteJoinHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* compiled from: InviteJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$4", f = "InviteJoinHelper.kt", l = {79, 104, 117, 118, Opcodes.IINC, Opcodes.LOOKUPSWITCH, 200}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$4, reason: invalid class name */
    public static final class AnonymousClass4 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ CaptchaHelper.CaptchaPayload $captchaPayload;
        public final /* synthetic */ AppFragment $fragment;
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ Class $javaClass;
        public final /* synthetic */ String $location;
        public final /* synthetic */ Function2 $onInviteFlowFinished;
        public final /* synthetic */ Function2 $onInvitePostError;
        public final /* synthetic */ Function2 $onInvitePostSuccess;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AppFragment appFragment, ModelInvite modelInvite, String str, Function2 function2, CaptchaHelper.CaptchaPayload captchaPayload, Class cls, Function2 function22, Function2 function23, Continuation continuation) {
            super(2, continuation);
            this.$fragment = appFragment;
            this.$invite = modelInvite;
            this.$location = str;
            this.$onInvitePostSuccess = function2;
            this.$captchaPayload = captchaPayload;
            this.$javaClass = cls;
            this.$onInvitePostError = function22;
            this.$onInviteFlowFinished = function23;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass4(this.$fragment, this.$invite, this.$location, this.$onInvitePostSuccess, this.$captchaPayload, this.$javaClass, this.$onInvitePostError, this.$onInviteFlowFinished, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:107:0x024d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x024e  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0285  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x02c9  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x02d0  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x02d7  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x02df  */
        /* JADX WARN: Removed duplicated region for block: B:152:0x031c  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x0370  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x037e  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x03ba  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x03d2  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x03e5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01ac  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01d2  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01d4  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01d7  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01f2 A[Catch: AppCancellationException -> 0x0053, TRY_ENTER, TryCatch #0 {AppCancellationException -> 0x0053, blocks: (B:10:0x003d, B:13:0x004c, B:104:0x023b, B:93:0x01f2, B:95:0x0202, B:97:0x0208, B:99:0x020c, B:101:0x0212), top: B:194:0x000b }] */
        /* JADX WARN: Type inference failed for: r0v16, types: [T, android.content.Context] */
        /* JADX WARN: Type inference failed for: r7v15, types: [T, androidx.fragment.app.FragmentManager, java.lang.Object] */
        @Override // d0.w.i.a.ContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref$ObjectRef ref$ObjectRef;
            ModelInvite modelInvite;
            Channel channel;
            Guild guild;
            Object orThrow;
            Long lBoxLong;
            boolean z2;
            Boolean boolBoxBoolean;
            Ref$ObjectRef ref$ObjectRef2;
            ModelInvite modelInvite2;
            Function2 function2;
            ModelInvite modelInvite3;
            Object orThrow2;
            Long lBoxLong2;
            List<GuildFeature> listM;
            List<GuildFeature> listM2;
            List<GuildFeature> listM3;
            Guild guild2;
            Object objAppAwaitSingle;
            Ref$ObjectRef ref$ObjectRef3;
            Long lBoxLong3;
            ModelInvite modelInvite4;
            Function2 function22;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            try {
            } catch (AppCancellationException e) {
                e = e;
            }
            switch (this.label) {
                case 0:
                    Result3.throwOnFailure(obj);
                    Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                    ref$ObjectRef4.element = this.$fragment.requireContext();
                    Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
                    ?? parentFragmentManager = this.$fragment.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
                    ref$ObjectRef5.element = parentFragmentManager;
                    Guild guild3 = this.$invite.guild;
                    boolean z3 = (guild3 == null || (listM3 = guild3.m()) == null || !listM3.contains(GuildFeature.MEMBER_VERIFICATION_GATE_ENABLED)) ? false : true;
                    Guild guild4 = this.$invite.guild;
                    boolean z4 = (guild4 == null || (listM2 = guild4.m()) == null || listM2.contains(GuildFeature.PREVIEW_ENABLED)) ? false : true;
                    Guild guild5 = this.$invite.guild;
                    boolean z5 = (guild5 == null || (listM = guild5.m()) == null || !listM.contains(GuildFeature.HUB)) ? false : true;
                    if (z5 && !GrowthTeamFeatures.INSTANCE.isHubEnabled()) {
                        AppToast.g((Context) ref$ObjectRef4.element, R.string.discord_u_coming_soon_to_mobile, 0, null, 12);
                    } else if (z5 && GrowthTeamFeatures.INSTANCE.isHubEmailConnectionEnabled()) {
                        Context context = (Context) ref$ObjectRef4.element;
                        WidgetHubEmailViewModel3 widgetHubEmailViewModel3 = WidgetHubEmailViewModel3.Invite;
                        Guild guild6 = this.$invite.guild;
                        String name = guild6 != null ? guild6.getName() : null;
                        if (name == null) {
                            name = "";
                        }
                        AppScreen2.d(context, WidgetHubEmailFlow.class, new WidgetHubEmailViewModel2(name, this.$invite.getApproximateMemberCount(), widgetHubEmailViewModel3));
                        FragmentActivity activity = this.$fragment.getActivity();
                        if (activity != null) {
                            activity.onBackPressed();
                        }
                    } else if (z3 && z4) {
                        this.L$0 = ref$ObjectRef4;
                        this.L$1 = ref$ObjectRef5;
                        this.L$2 = null;
                        this.L$3 = this;
                        this.label = 1;
                        SafeContinuationJvm safeContinuationJvm = new SafeContinuationJvm(IntrinsicsJvm.intercepted(this));
                        MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
                        Context context2 = (Context) ref$ObjectRef4.element;
                        Guild guild7 = this.$invite.guild;
                        memberVerificationUtils.maybeShowVerificationGate(context2, (FragmentManager) ref$ObjectRef5.element, (guild7 == null || (lBoxLong2 = boxing.boxLong(guild7.getId())) == null) ? -1L : lBoxLong2.longValue(), this.$location, this.$invite, new InviteJoinHelper2(safeContinuationJvm), new InviteJoinHelper3(safeContinuationJvm));
                        orThrow2 = safeContinuationJvm.getOrThrow();
                        if (orThrow2 == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                            DebugProbes.probeCoroutineSuspended(this);
                        }
                        if (orThrow2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ref$ObjectRef2 = ref$ObjectRef4;
                        modelInvite3 = null;
                        if (!((Boolean) orThrow2).booleanValue()) {
                            return Unit.a;
                        }
                        guild2 = this.$invite.guild;
                        if (guild2 == null) {
                            if (((guild2 == null || (lBoxLong3 = boxing.boxLong(guild2.getId())) == null) ? null : StoreStream.INSTANCE.getGuilds().getGuilds().get(boxing.boxLong(lBoxLong3.longValue()))) == null) {
                            }
                        }
                    } else {
                        ref$ObjectRef2 = ref$ObjectRef4;
                        modelInvite3 = null;
                        guild2 = this.$invite.guild;
                        if (((guild2 == null || (lBoxLong3 = boxing.boxLong(guild2.getId())) == null) ? null : StoreStream.INSTANCE.getGuilds().getGuilds().get(boxing.boxLong(lBoxLong3.longValue()))) == null) {
                            RestAPI api = RestAPI.INSTANCE.getApi();
                            ModelInvite modelInvite5 = this.$invite;
                            String str = this.$location;
                            CaptchaHelper.CaptchaPayload captchaPayload = this.$captchaPayload;
                            String captchaKey = captchaPayload != null ? captchaPayload.getCaptchaKey() : null;
                            CaptchaHelper.CaptchaPayload captchaPayload2 = this.$captchaPayload;
                            Observable observableUi = ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(api.postInviteCode(modelInvite5, str, new RestAPIParams.InviteCode(captchaKey, captchaPayload2 != null ? captchaPayload2.getCaptchaRqtoken() : null)), false, 1, null));
                            Context context3 = (Context) ref$ObjectRef2.element;
                            Boolean boolBoxBoolean2 = boxing.boxBoolean(true);
                            this.L$0 = ref$ObjectRef2;
                            this.L$1 = modelInvite3;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 3;
                            objAppAwaitSingle = RxCoroutineExtensions.appAwaitSingle(observableUi, context3, boolBoxBoolean2, this);
                            if (objAppAwaitSingle == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            modelInvite4 = (ModelInvite) objAppAwaitSingle;
                            try {
                                function22 = this.$onInvitePostSuccess;
                                this.L$0 = ref$ObjectRef2;
                                this.L$1 = modelInvite4;
                                this.label = 4;
                            } catch (AppCancellationException e2) {
                                e = e2;
                                modelInvite2 = modelInvite4;
                                Throwable cause = e.getCause();
                                if (cause instanceof HttpException) {
                                    GuildCaptchaUtils.handleHttpException(e.getError(), this.$fragment, new InviteArgs(this.$invite, this.$javaClass, this.$location, this.$onInvitePostError, this.$onInvitePostSuccess, this.$onInviteFlowFinished));
                                    modelInvite = modelInvite2;
                                    ref$ObjectRef = ref$ObjectRef2;
                                    channel = this.$invite.getChannel();
                                    if (channel != null) {
                                    }
                                    return Unit.a;
                                }
                                Function2 function23 = this.$onInvitePostError;
                                Error errorCreate = cause != null ? Error.create(cause) : null;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 5;
                                if (function23.invoke(errorCreate, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.a;
                            }
                            if (function22.invoke(modelInvite4, this) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            modelInvite2 = modelInvite4;
                            modelInvite = modelInvite2;
                            ref$ObjectRef = ref$ObjectRef2;
                            channel = this.$invite.getChannel();
                            if (channel != null) {
                            }
                        } else {
                            Function2 function24 = this.$onInvitePostSuccess;
                            ModelInvite modelInvite6 = this.$invite;
                            this.L$0 = ref$ObjectRef2;
                            this.L$1 = modelInvite3;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 2;
                            if (function24.invoke(modelInvite6, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            modelInvite = modelInvite3;
                            ref$ObjectRef3 = ref$ObjectRef2;
                            ref$ObjectRef = ref$ObjectRef3;
                            channel = this.$invite.getChannel();
                            if (channel != null) {
                                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                                if (ChannelUtils.w(channel)) {
                                    Long l = StoreStream.INSTANCE.getPermissions().getPermissionsByChannel().get(boxing.boxLong(channel.getId()));
                                    if ((l == null || (boolBoxBoolean = boxing.boxBoolean(PermissionUtils.can(Permission.CONNECT, boxing.boxLong(l.longValue())))) == null) ? false : boolBoxBoolean.booleanValue()) {
                                        z2 = true;
                                    }
                                    Boolean boolBoxBoolean3 = boxing.boxBoolean(z2);
                                    if (boolBoxBoolean3 == null) {
                                    }
                                    guild = this.$invite.guild;
                                    if (guild == null) {
                                    }
                                } else {
                                    z2 = false;
                                    Boolean boolBoxBoolean32 = boxing.boxBoolean(z2);
                                    boolean zBooleanValue = boolBoxBoolean32 == null ? boolBoxBoolean32.booleanValue() : false;
                                    guild = this.$invite.guild;
                                    if (guild == null) {
                                        ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                                        function2 = this.$onInviteFlowFinished;
                                        if (modelInvite == null) {
                                            modelInvite = this.$invite;
                                        }
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.label = 7;
                                        if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (((guild == null || (lBoxLong = boxing.boxLong(guild.getId())) == null) ? 0L : lBoxLong.longValue()) > 0) {
                                            if (this.$invite.getGuildScheduledEvent() == null) {
                                                Channel channel2 = this.$invite.getChannel();
                                                if (channel2 == null || !ChannelUtils.J(channel2)) {
                                                    Channel channel3 = this.$invite.getChannel();
                                                    if (channel3 == null || !ChannelUtils.D(channel3) || zBooleanValue) {
                                                        InviteJoinHelper.access$navigateToChannel(InviteJoinHelper.INSTANCE, (Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                    } else {
                                                        InviteJoinHelper.access$navigateToGuild(InviteJoinHelper.INSTANCE, this.$invite);
                                                    }
                                                } else if (zBooleanValue) {
                                                    this.L$0 = ref$ObjectRef;
                                                    this.L$1 = modelInvite;
                                                    this.L$2 = this;
                                                    this.L$3 = null;
                                                    this.label = 6;
                                                    SafeContinuationJvm safeContinuationJvm2 = new SafeContinuationJvm(IntrinsicsJvm.intercepted(this));
                                                    this.$fragment.requestMicrophone(new InviteJoinHelper4(safeContinuationJvm2), new InviteJoinHelper5(safeContinuationJvm2));
                                                    orThrow = safeContinuationJvm2.getOrThrow();
                                                    if (orThrow == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                                                        DebugProbes.probeCoroutineSuspended(this);
                                                    }
                                                    if (orThrow == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    if (((Boolean) orThrow).booleanValue()) {
                                                        InviteJoinHelper.access$navigateToGuild(InviteJoinHelper.INSTANCE, this.$invite);
                                                    } else {
                                                        InviteJoinHelper.access$navigateToChannel(InviteJoinHelper.INSTANCE, (Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                    }
                                                } else {
                                                    InviteJoinHelper.access$navigateToGuild(InviteJoinHelper.INSTANCE, this.$invite);
                                                }
                                            } else {
                                                GuildScheduledEvent guildScheduledEvent = this.$invite.getGuildScheduledEvent();
                                                if ((guildScheduledEvent != null ? guildScheduledEvent.getStatus() : null) != GuildScheduledEventStatus.ACTIVE) {
                                                    InviteJoinHelper.access$navigateToGuild(InviteJoinHelper.INSTANCE, this.$invite);
                                                }
                                            }
                                        }
                                        function2 = this.$onInviteFlowFinished;
                                        if (modelInvite == null) {
                                        }
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.label = 7;
                                        if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return Unit.a;
                case 1:
                    ModelInvite modelInvite7 = (ModelInvite) this.L$2;
                    Ref$ObjectRef ref$ObjectRef6 = (Ref$ObjectRef) this.L$0;
                    Result3.throwOnFailure(obj);
                    ref$ObjectRef2 = ref$ObjectRef6;
                    modelInvite3 = modelInvite7;
                    orThrow2 = obj;
                    if (!((Boolean) orThrow2).booleanValue()) {
                    }
                    guild2 = this.$invite.guild;
                    return Unit.a;
                case 2:
                    modelInvite = (ModelInvite) this.L$1;
                    ref$ObjectRef3 = (Ref$ObjectRef) this.L$0;
                    Result3.throwOnFailure(obj);
                    ref$ObjectRef = ref$ObjectRef3;
                    channel = this.$invite.getChannel();
                    if (channel != null) {
                    }
                    return Unit.a;
                case 3:
                    ref$ObjectRef2 = (Ref$ObjectRef) this.L$0;
                    Result3.throwOnFailure(obj);
                    objAppAwaitSingle = obj;
                    modelInvite4 = (ModelInvite) objAppAwaitSingle;
                    function22 = this.$onInvitePostSuccess;
                    this.L$0 = ref$ObjectRef2;
                    this.L$1 = modelInvite4;
                    this.label = 4;
                    if (function22.invoke(modelInvite4, this) != coroutine_suspended) {
                    }
                    break;
                case 4:
                    modelInvite2 = (ModelInvite) this.L$1;
                    ref$ObjectRef2 = (Ref$ObjectRef) this.L$0;
                    Result3.throwOnFailure(obj);
                    modelInvite = modelInvite2;
                    ref$ObjectRef = ref$ObjectRef2;
                    channel = this.$invite.getChannel();
                    if (channel != null) {
                    }
                    return Unit.a;
                case 5:
                    Result3.throwOnFailure(obj);
                    return Unit.a;
                case 6:
                    modelInvite = (ModelInvite) this.L$1;
                    ref$ObjectRef = (Ref$ObjectRef) this.L$0;
                    Result3.throwOnFailure(obj);
                    orThrow = obj;
                    if (((Boolean) orThrow).booleanValue()) {
                    }
                    function2 = this.$onInviteFlowFinished;
                    if (modelInvite == null) {
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 7;
                    if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                    }
                    return Unit.a;
                case 7:
                    Result3.throwOnFailure(obj);
                    return Unit.a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private InviteJoinHelper() {
    }

    public static final /* synthetic */ void access$navigateToChannel(InviteJoinHelper inviteJoinHelper, Context context, AppFragment appFragment, ModelInvite modelInvite) {
        inviteJoinHelper.navigateToChannel(context, appFragment, modelInvite);
    }

    public static final /* synthetic */ void access$navigateToGuild(InviteJoinHelper inviteJoinHelper, ModelInvite modelInvite) {
        inviteJoinHelper.navigateToGuild(modelInvite);
    }

    public static /* synthetic */ Job joinViaInvite$default(InviteJoinHelper inviteJoinHelper, ModelInvite modelInvite, Class cls, AppFragment appFragment, String str, Function2 function2, Function2 function22, Function2 function23, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        return inviteJoinHelper.joinViaInvite(modelInvite, cls, appFragment, str, (i & 16) != 0 ? new AnonymousClass1(null) : function2, (i & 32) != 0 ? new AnonymousClass2(null) : function22, (i & 64) != 0 ? new AnonymousClass3(null) : function23, (i & 128) != 0 ? null : captchaPayload);
    }

    private final void navigateToChannel(Context context, AppFragment appFragment, ModelInvite modelInvite) {
        Channel channel = modelInvite.getChannel();
        if (channel != null) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(context, channel.getId());
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            if (ChannelUtils.J(channel)) {
                if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(channel.getGuildId()))) {
                    WidgetCallPreviewFullscreen.Companion.launch$default(WidgetCallPreviewFullscreen.INSTANCE, context, channel.getId(), null, 4, null);
                    return;
                }
                WidgetVoiceBottomSheet.Companion companion = WidgetVoiceBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
                companion.show(parentFragmentManager, channel.getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
                return;
            }
            if (ChannelUtils.D(channel)) {
                StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
                Context contextRequireContext = appFragment.requireContext();
                FragmentManager parentFragmentManager2 = appFragment.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "appFragment.parentFragmentManager");
                StageChannelJoinHelper.connectToStage$default(stageChannelJoinHelper, contextRequireContext, parentFragmentManager2, channel.getId(), false, false, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
            }
        }
    }

    private final void navigateToGuild(ModelInvite modelInvite) {
        Guild guild = modelInvite.guild;
        if (guild != null) {
            StoreStream.INSTANCE.getGuildSelected().set(guild.getId());
        }
        GuildScheduledEvent guildScheduledEvent = modelInvite.getGuildScheduledEvent();
        if (guildScheduledEvent != null) {
            WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.enqueue(guildScheduledEvent.getId());
        }
    }

    public final Job joinViaInvite(ModelInvite invite, Class<?> javaClass, AppFragment fragment, String location, Function2<? super Error, ? super Continuation<? super Unit>, ? extends Object> onInvitePostError, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(onInvitePostError, "onInvitePostError");
        Intrinsics3.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        Intrinsics3.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        Intrinsics3.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        return AppCoroutineScope.appLaunch$default(LifecycleOwner2.getLifecycleScope(viewLifecycleOwner), javaClass, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass4(fragment, invite, location, onInvitePostSuccess, captchaPayload, javaClass, onInvitePostError, onInviteFlowFinished, null), 6, (Object) null);
    }
}
