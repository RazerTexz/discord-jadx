package com.discord.widgets.stage;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.a.GuildVideoAtCapacityDialog;
import b.a.d.AppToast;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppTransitionActivity;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.RxCoroutineUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.Result3;
import d0.f0._Sequences2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import s.a.CancellableContinuationImpl5;

/* compiled from: StageChannelJoinHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J9\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\rJw\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJi\u0010%\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\u0010\u001f\u001a\u00060\u0006j\u0002`\u001e2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0007¢\u0006\u0004\b%\u0010&Jc\u0010'\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u001f\u001a\u00060\u0006j\u0002`\u001e2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/discord/widgets/stage/StageChannelJoinHelper;", "", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lkotlin/Function0;", "", "onJoinVerified", "verifyStageJoinability", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JLkotlin/jvm/functions/Function0;)V", "", "warnedAboutBlockedUsers", "launchFullscreen", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreVoiceStates;", "voiceStatesStore", "Lcom/discord/stores/StoreUserRelationships;", "userRelationshipsStore", "onCompleted", "connectToStage", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JZZLcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreVoiceStates;Lcom/discord/stores/StoreUserRelationships;Lkotlin/jvm/functions/Function0;)V", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreLurking;", "lurkingStore", "selectedVoiceChannelStore", "lurkAndJoinStage", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Lkotlinx/coroutines/CoroutineScope;JJZLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreLurking;Lcom/discord/stores/StoreVoiceChannelSelected;)V", "lurkAndJoinStageAsync", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JJZLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreLurking;Lcom/discord/stores/StoreVoiceChannelSelected;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "lurkJob", "Lkotlinx/coroutines/Job;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StageChannelJoinHelper {
    public static final StageChannelJoinHelper INSTANCE = new StageChannelJoinHelper();
    private static Job lurkJob;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VoiceChannelJoinabilityUtils2.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoiceChannelJoinabilityUtils2.GUILD_VIDEO_AT_CAPACITY.ordinal()] = 1;
            iArr[VoiceChannelJoinabilityUtils2.PERMISSIONS_MISSING.ordinal()] = 2;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_FULL.ordinal()] = 3;
            iArr[VoiceChannelJoinabilityUtils2.CHANNEL_DOES_NOT_EXIST.ordinal()] = 4;
            iArr[VoiceChannelJoinabilityUtils2.CAN_JOIN.ordinal()] = 5;
        }
    }

    /* compiled from: StageChannelJoinHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
        }
    }

    /* compiled from: StageChannelJoinHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ StoreChannels $channelsStore;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $launchFullscreen;
        public final /* synthetic */ Function0 $onCompleted;
        public final /* synthetic */ StoreUserRelationships $userRelationshipsStore;
        public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;
        public final /* synthetic */ StoreVoiceStates $voiceStatesStore;
        public final /* synthetic */ boolean $warnedAboutBlockedUsers;

        /* compiled from: StageChannelJoinHelper.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceChannelSelected$JoinVoiceChannelResult;", "it", "", "invoke", "(Lcom/discord/stores/StoreVoiceChannelSelected$JoinVoiceChannelResult;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<StoreVoiceChannelSelected.JoinVoiceChannelResult, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceChannelSelected.JoinVoiceChannelResult joinVoiceChannelResult) {
                invoke2(joinVoiceChannelResult);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreVoiceChannelSelected.JoinVoiceChannelResult joinVoiceChannelResult) {
                Intrinsics3.checkNotNullParameter(joinVoiceChannelResult, "it");
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                if (anonymousClass2.$launchFullscreen) {
                    WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, anonymousClass2.$context, anonymousClass2.$channelId, true, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 8, null);
                }
                AnonymousClass2.this.$onCompleted.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StoreChannels storeChannels, long j, StoreVoiceStates storeVoiceStates, StoreUserRelationships storeUserRelationships, boolean z2, StoreVoiceChannelSelected storeVoiceChannelSelected, FragmentManager fragmentManager, boolean z3, Function0 function0, Context context) {
            super(0);
            this.$channelsStore = storeChannels;
            this.$channelId = j;
            this.$voiceStatesStore = storeVoiceStates;
            this.$userRelationshipsStore = storeUserRelationships;
            this.$warnedAboutBlockedUsers = z2;
            this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
            this.$fragmentManager = fragmentManager;
            this.$launchFullscreen = z3;
            this.$onCompleted = function0;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2() {
            boolean z2;
            Object next;
            Channel channel = this.$channelsStore.getChannel(this.$channelId);
            if (channel != null) {
                Map mapEmptyMap = (Map) outline.c(channel, this.$voiceStatesStore.get());
                if (mapEmptyMap == null) {
                    mapEmptyMap = Maps6.emptyMap();
                }
                Sequence map = _Sequences2.map(_Sequences2.filter(_Collections.asSequence(mapEmptyMap.values()), new StageChannelJoinHelper2(channel)), StageChannelJoinHelper3.INSTANCE);
                Map<Long, Integer> relationships = this.$userRelationshipsStore.getRelationships();
                if (!this.$warnedAboutBlockedUsers) {
                    Iterator it = map.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        Integer num = relationships.get(Long.valueOf(((Number) next).longValue()));
                        if (num != null && num.intValue() == 2) {
                            break;
                        }
                    }
                    z2 = (next == null || this.$voiceChannelSelectedStore.getSelectedVoiceChannelId() == this.$channelId) ? false : true;
                }
                if (!z2) {
                    ObservableExtensionsKt.appSubscribe$default(this.$voiceChannelSelectedStore.selectVoiceChannel(this.$channelId), StageChannelJoinHelper.INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
                } else {
                    WidgetStageAudienceBlockedBottomSheet.INSTANCE.show(this.$fragmentManager, this.$channelId, this.$launchFullscreen);
                    this.$onCompleted.invoke();
                }
            }
        }
    }

    /* compiled from: StageChannelJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStage$1", f = "StageChannelJoinHelper.kt", l = {123}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuilds $guildsStore;
        public final /* synthetic */ boolean $launchFullscreen;
        public final /* synthetic */ StoreLurking $lurkingStore;
        public final /* synthetic */ StoreVoiceChannelSelected $selectedVoiceChannelStore;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation continuation) {
            super(2, continuation);
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$guildId = j;
            this.$channelId = j2;
            this.$launchFullscreen = z2;
            this.$guildsStore = storeGuilds;
            this.$lurkingStore = storeLurking;
            this.$selectedVoiceChannelStore = storeVoiceChannelSelected;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$context, this.$fragmentManager, this.$guildId, this.$channelId, this.$launchFullscreen, this.$guildsStore, this.$lurkingStore, this.$selectedVoiceChannelStore, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
                Context context = this.$context;
                FragmentManager fragmentManager = this.$fragmentManager;
                long j = this.$guildId;
                long j2 = this.$channelId;
                boolean z2 = this.$launchFullscreen;
                StoreGuilds storeGuilds = this.$guildsStore;
                StoreLurking storeLurking = this.$lurkingStore;
                StoreVoiceChannelSelected storeVoiceChannelSelected = this.$selectedVoiceChannelStore;
                this.label = 1;
                if (stageChannelJoinHelper.lurkAndJoinStageAsync(context, fragmentManager, j, j2, z2, storeGuilds, storeLurking, storeVoiceChannelSelected, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    /* compiled from: StageChannelJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.stage.StageChannelJoinHelper", f = "StageChannelJoinHelper.kt", l = {180, Opcodes.IF_ICMPEQ, Opcodes.IF_ACMPNE}, m = "lurkAndJoinStageAsync")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "launchFullscreen", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreLurking;", "lurkingStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "selectedVoiceChannelStore", "Lkotlin/coroutines/Continuation;", "continuation", "", "lurkAndJoinStageAsync", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;JJZLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreLurking;Lcom/discord/stores/StoreVoiceChannelSelected;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl3 {
        public long J$0;
        public long J$1;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StageChannelJoinHelper.this.lurkAndJoinStageAsync(null, null, 0L, 0L, false, null, null, null, this);
        }
    }

    /* compiled from: StageChannelJoinHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "kotlin.jvm.PlatformType", "ids", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Set<? extends Long>, Boolean> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass3(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
            return call2((Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Set<Long> set) {
            return Boolean.valueOf(set.contains(Long.valueOf(this.$guildId)));
        }
    }

    /* compiled from: StageChannelJoinHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Channel, Boolean> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Channel channel) {
            return Boolean.valueOf(channel == null);
        }
    }

    /* compiled from: StageChannelJoinHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreLurking $lurkingStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(StoreLurking storeLurking, long j) {
            super(0);
            this.$lurkingStore = storeLurking;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$lurkingStore.removeOldLurkingGuilds(this.$guildId);
        }
    }

    private StageChannelJoinHelper() {
    }

    public static /* synthetic */ void connectToStage$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, long j, boolean z2, boolean z3, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StoreUserRelationships storeUserRelationships, Function0 function0, int i, Object obj) {
        stageChannelJoinHelper.connectToStage(context, fragmentManager, j, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? true : z3, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates, (i & 256) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships, (i & 512) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    public static /* synthetic */ void lurkAndJoinStage$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, CoroutineScope coroutineScope, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, int i, Object obj) {
        stageChannelJoinHelper.lurkAndJoinStage(context, fragmentManager, coroutineScope, j, j2, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 128) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking, (i & 256) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected);
    }

    public static /* synthetic */ Object lurkAndJoinStageAsync$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation continuation, int i, Object obj) {
        return stageChannelJoinHelper.lurkAndJoinStageAsync(context, fragmentManager, j, j2, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking, (i & 128) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, continuation);
    }

    @MainThread
    public final void connectToStage(Context context, FragmentManager fragmentManager, long channelId, boolean warnedAboutBlockedUsers, boolean launchFullscreen, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreChannels channelsStore, StoreVoiceStates voiceStatesStore, StoreUserRelationships userRelationshipsStore, Function0<Unit> onCompleted) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
        Intrinsics3.checkNotNullParameter(voiceStatesStore, "voiceStatesStore");
        Intrinsics3.checkNotNullParameter(userRelationshipsStore, "userRelationshipsStore");
        Intrinsics3.checkNotNullParameter(onCompleted, "onCompleted");
        verifyStageJoinability(context, fragmentManager, channelId, new AnonymousClass2(channelsStore, channelId, voiceStatesStore, userRelationshipsStore, warnedAboutBlockedUsers, voiceChannelSelectedStore, fragmentManager, launchFullscreen, onCompleted, context));
    }

    @MainThread
    public final void lurkAndJoinStage(Context context, FragmentManager fragmentManager, CoroutineScope coroutineScope, long guildId, long channelId, boolean launchFullscreen, StoreGuilds guildsStore, StoreLurking lurkingStore, StoreVoiceChannelSelected selectedVoiceChannelStore) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(guildsStore, "guildsStore");
        Intrinsics3.checkNotNullParameter(lurkingStore, "lurkingStore");
        Intrinsics3.checkNotNullParameter(selectedVoiceChannelStore, "selectedVoiceChannelStore");
        Job job = lurkJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        lurkJob = coroutineScope != null ? f.H0(coroutineScope, null, null, new AnonymousClass1(context, fragmentManager, guildId, channelId, launchFullscreen, guildsStore, lurkingStore, selectedVoiceChannelStore, null), 3, null) : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object lurkAndJoinStageAsync(Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        FragmentManager fragmentManager2;
        StoreGuilds storeGuilds2;
        StoreLurking storeLurking2;
        long j3;
        long j4;
        StageChannelJoinHelper stageChannelJoinHelper;
        Object obj;
        StoreVoiceChannelSelected storeVoiceChannelSelected2;
        Context context2;
        boolean z3;
        StoreLurking storeLurking3;
        Context context3;
        StoreVoiceChannelSelected storeVoiceChannelSelected3;
        StageChannelJoinHelper stageChannelJoinHelper2;
        FragmentManager fragmentManager3;
        boolean z4;
        Observable<Channel> observableZ;
        boolean z5;
        StageChannelJoinHelper stageChannelJoinHelper3;
        long j5;
        long j6;
        StoreLurking storeLurking4;
        FragmentManager fragmentManager4;
        Context context4;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj2);
            storeVoiceChannelSelected.clear();
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = context;
            fragmentManager2 = fragmentManager;
            anonymousClass1.L$2 = fragmentManager2;
            storeGuilds2 = storeGuilds;
            anonymousClass1.L$3 = storeGuilds2;
            storeLurking2 = storeLurking;
            anonymousClass1.L$4 = storeLurking2;
            anonymousClass1.L$5 = storeVoiceChannelSelected;
            anonymousClass1.J$0 = j;
            anonymousClass1.J$1 = j2;
            anonymousClass1.Z$0 = z2;
            anonymousClass1.label = 1;
            CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(anonymousClass1), 1);
            cancellableContinuationImpl5.A();
            storeLurking.startLurking(j, boxing.boxLong(j2), false, new StageChannelJoinHelper4(cancellableContinuationImpl5), new StageChannelJoinHelper5(cancellableContinuationImpl5));
            Object objU = cancellableContinuationImpl5.u();
            if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(anonymousClass1);
            }
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = j;
            j4 = j2;
            stageChannelJoinHelper = this;
            obj = objU;
            storeVoiceChannelSelected2 = storeVoiceChannelSelected;
            context2 = context;
            z3 = z2;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z6 = anonymousClass1.Z$0;
                    long j7 = anonymousClass1.J$1;
                    j6 = anonymousClass1.J$0;
                    storeLurking4 = (StoreLurking) anonymousClass1.L$3;
                    FragmentManager fragmentManager5 = (FragmentManager) anonymousClass1.L$2;
                    Context context5 = (Context) anonymousClass1.L$1;
                    StageChannelJoinHelper stageChannelJoinHelper4 = (StageChannelJoinHelper) anonymousClass1.L$0;
                    Result3.throwOnFailure(obj2);
                    stageChannelJoinHelper3 = stageChannelJoinHelper4;
                    z5 = z6;
                    j5 = j7;
                    fragmentManager4 = fragmentManager5;
                    context4 = context5;
                    connectToStage$default(stageChannelJoinHelper3, context4, fragmentManager4, j5, false, z5, null, null, null, null, new AnonymousClass5(storeLurking4, j6), 488, null);
                    return boxing.boxBoolean(true);
                }
                z4 = anonymousClass1.Z$0;
                j4 = anonymousClass1.J$1;
                j3 = anonymousClass1.J$0;
                storeVoiceChannelSelected3 = (StoreVoiceChannelSelected) anonymousClass1.L$4;
                storeLurking3 = (StoreLurking) anonymousClass1.L$3;
                fragmentManager3 = (FragmentManager) anonymousClass1.L$2;
                context3 = (Context) anonymousClass1.L$1;
                stageChannelJoinHelper2 = (StageChannelJoinHelper) anonymousClass1.L$0;
                Result3.throwOnFailure(obj2);
                observableZ = storeVoiceChannelSelected3.observeSelectedChannel().y(AnonymousClass4.INSTANCE).z();
                Intrinsics3.checkNotNullExpressionValue(observableZ, "selectedVoiceChannelStor…= null }\n        .first()");
                anonymousClass1.L$0 = stageChannelJoinHelper2;
                anonymousClass1.L$1 = context3;
                anonymousClass1.L$2 = fragmentManager3;
                anonymousClass1.L$3 = storeLurking3;
                anonymousClass1.L$4 = null;
                anonymousClass1.J$0 = j3;
                anonymousClass1.J$1 = j4;
                anonymousClass1.Z$0 = z4;
                anonymousClass1.label = 3;
                if (RxCoroutineUtils.awaitSingle(observableZ, anonymousClass1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                z5 = z4;
                stageChannelJoinHelper3 = stageChannelJoinHelper2;
                j5 = j4;
                j6 = j3;
                storeLurking4 = storeLurking3;
                fragmentManager4 = fragmentManager3;
                context4 = context3;
                connectToStage$default(stageChannelJoinHelper3, context4, fragmentManager4, j5, false, z5, null, null, null, null, new AnonymousClass5(storeLurking4, j6), 488, null);
                return boxing.boxBoolean(true);
            }
            boolean z7 = anonymousClass1.Z$0;
            j4 = anonymousClass1.J$1;
            j3 = anonymousClass1.J$0;
            StoreVoiceChannelSelected storeVoiceChannelSelected4 = (StoreVoiceChannelSelected) anonymousClass1.L$5;
            StoreLurking storeLurking5 = (StoreLurking) anonymousClass1.L$4;
            StoreGuilds storeGuilds3 = (StoreGuilds) anonymousClass1.L$3;
            FragmentManager fragmentManager6 = (FragmentManager) anonymousClass1.L$2;
            context2 = (Context) anonymousClass1.L$1;
            StageChannelJoinHelper stageChannelJoinHelper5 = (StageChannelJoinHelper) anonymousClass1.L$0;
            Result3.throwOnFailure(obj2);
            storeVoiceChannelSelected2 = storeVoiceChannelSelected4;
            storeLurking2 = storeLurking5;
            obj = obj2;
            z3 = z7;
            fragmentManager2 = fragmentManager6;
            stageChannelJoinHelper = stageChannelJoinHelper5;
            storeGuilds2 = storeGuilds3;
        }
        if (((Unit) obj) == null) {
            return boxing.boxBoolean(false);
        }
        Observable<Set<Long>> observableZ2 = storeGuilds2.observeGuildIds().y(new AnonymousClass3(j3)).z();
        Intrinsics3.checkNotNullExpressionValue(observableZ2, "guildsStore\n        .obs…in ids }\n        .first()");
        anonymousClass1.L$0 = stageChannelJoinHelper;
        anonymousClass1.L$1 = context2;
        anonymousClass1.L$2 = fragmentManager2;
        anonymousClass1.L$3 = storeLurking2;
        anonymousClass1.L$4 = storeVoiceChannelSelected2;
        anonymousClass1.L$5 = null;
        anonymousClass1.J$0 = j3;
        anonymousClass1.J$1 = j4;
        anonymousClass1.Z$0 = z3;
        anonymousClass1.label = 2;
        if (RxCoroutineUtils.awaitSingle(observableZ2, anonymousClass1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        storeLurking3 = storeLurking2;
        context3 = context2;
        storeVoiceChannelSelected3 = storeVoiceChannelSelected2;
        stageChannelJoinHelper2 = stageChannelJoinHelper;
        fragmentManager3 = fragmentManager2;
        z4 = z3;
        observableZ = storeVoiceChannelSelected3.observeSelectedChannel().y(AnonymousClass4.INSTANCE).z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "selectedVoiceChannelStor…= null }\n        .first()");
        anonymousClass1.L$0 = stageChannelJoinHelper2;
        anonymousClass1.L$1 = context3;
        anonymousClass1.L$2 = fragmentManager3;
        anonymousClass1.L$3 = storeLurking3;
        anonymousClass1.L$4 = null;
        anonymousClass1.J$0 = j3;
        anonymousClass1.J$1 = j4;
        anonymousClass1.Z$0 = z4;
        anonymousClass1.label = 3;
        if (RxCoroutineUtils.awaitSingle(observableZ, anonymousClass1) != coroutine_suspended) {
        }
    }

    @MainThread
    public final void verifyStageJoinability(Context context, FragmentManager fragmentManager, long channelId, Function0<Unit> onJoinVerified) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(onJoinVerified, "onJoinVerified");
        int iOrdinal = VoiceChannelJoinabilityUtils.INSTANCE.getJoinability(channelId).ordinal();
        if (iOrdinal == 0) {
            onJoinVerified.invoke();
            return;
        }
        if (iOrdinal == 1) {
            AppToast.g(context, R.string.channel_locked, 0, null, 12);
            return;
        }
        if (iOrdinal == 2) {
            GuildVideoAtCapacityDialog.INSTANCE.a(fragmentManager);
        } else if (iOrdinal == 3) {
            AppToast.g(context, R.string.unable_to_join_channel_full, 0, null, 12);
        } else {
            if (iOrdinal != 4) {
                return;
            }
            AppToast.g(context, R.string.guild_settings_public_welcome_invalid_channel, 0, null, 12);
        }
    }
}
