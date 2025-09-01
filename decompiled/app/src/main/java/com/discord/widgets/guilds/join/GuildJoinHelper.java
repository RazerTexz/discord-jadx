package com.discord.widgets.guilds.join;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildCaptchaUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* compiled from: GuildJoinHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¯\u0001\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "isLurker", "", "Lcom/discord/primitives/SessionId;", "sessionId", "directoryChannelId", "source", "Ljava/lang/Class;", "errorClass", "Lkotlin/Function1;", "Lrx/Subscription;", "", "subscriptionHandler", "Lcom/discord/utilities/error/Error;", "errorHandler", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "Lcom/discord/api/guild/Guild;", "onNext", "joinGuild", "(Landroid/content/Context;JZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Class;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.join.GuildJoinHelperKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildJoinHelper {

    /* compiled from: GuildJoinHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.GuildJoinHelperKt$joinGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Long $directoryChannelId;
        public final /* synthetic */ Class $errorClass;
        public final /* synthetic */ Function1 $errorHandler;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ boolean $isLurker;
        public final /* synthetic */ Function1 $onNext;
        public final /* synthetic */ String $sessionId;
        public final /* synthetic */ Function1 $subscriptionHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, long j, boolean z2, String str, Long l, Class cls, Function1 function1, Function1 function12, Function1 function13) {
            super(1);
            this.$context = context;
            this.$guildId = j;
            this.$isLurker = z2;
            this.$sessionId = str;
            this.$directoryChannelId = l;
            this.$errorClass = cls;
            this.$subscriptionHandler = function1;
            this.$errorHandler = function12;
            this.$onNext = function13;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            GuildCaptchaUtils.handleHttpException(error, this.$context, new JoinArgs(this.$guildId, this.$isLurker, this.$sessionId, this.$directoryChannelId, this.$errorClass, this.$subscriptionHandler, this.$errorHandler, this.$onNext));
        }
    }

    public static final void joinGuild(Context context, long j, boolean z2, String str, Long l, String str2, Class<?> cls, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function12, CaptchaHelper.CaptchaPayload captchaPayload, Function1<? super Guild, Unit> function13) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        Intrinsics3.checkNotNullParameter(function13, "onNext");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinGuild(j, z2, str, l, new RestAPIParams.InviteCode(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), str2), false, 1, null)), cls, (Context) null, function1, new AnonymousClass1(context, j, z2, str, l, cls, function1, function12, function13), (Function0) null, (Function0) null, function13, 50, (Object) null);
    }

    public static /* synthetic */ void joinGuild$default(Context context, long j, boolean z2, String str, Long l, String str2, Class cls, Function1 function1, Function1 function12, CaptchaHelper.CaptchaPayload captchaPayload, Function1 function13, int i, Object obj) {
        joinGuild(context, j, z2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : str2, cls, (i & 128) != 0 ? null : function1, (i & 256) != 0 ? null : function12, (i & 512) != 0 ? null : captchaPayload, function13);
    }
}
