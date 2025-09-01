package com.discord.utilities.rest;

import android.content.Context;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.utilities.error.Error;
import d0.Tuples;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: RestAPIAbortMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/rest/RestAPIAbortMessages;", "", "", "abortCode", "getAbortCodeMessageResId", "(I)Ljava/lang/Integer;", "Lcom/discord/utilities/error/Error;", "errorResponse", "Lkotlin/Function0;", "", "onHandle", "", "onDefault", "handleAbortCodeOrDefault", "(Lcom/discord/utilities/error/Error;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "", "MESSAGES", "Ljava/util/Map;", "<init>", "()V", "ResponseResolver", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RestAPIAbortMessages {
    public static final RestAPIAbortMessages INSTANCE = new RestAPIAbortMessages();
    private static final Map<Integer, Integer> MESSAGES;

    /* compiled from: RestAPIAbortMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/rest/RestAPIAbortMessages$ResponseResolver;", "", "Landroid/content/Context;", "context", "", "abortCode", "", "username", "", "getRelationshipResponse", "(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/CharSequence;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ResponseResolver {
        public static final ResponseResolver INSTANCE = new ResponseResolver();

        private ResponseResolver() {
        }

        public final CharSequence getRelationshipResponse(Context context, int abortCode, String username) {
            Intrinsics3.checkNotNullParameter(username, "username");
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(abortCode);
            int iIntValue = abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : R.string.add_friend_error_other;
            if (abortCode != 80000) {
                if (context != null) {
                    return FormatUtils.h(context, iIntValue, new Object[0], null, 4);
                }
                return null;
            }
            if (context != null) {
                return FormatUtils.h(context, iIntValue, new Object[]{username}, null, 4);
            }
            return null;
        }
    }

    /* compiled from: RestAPIAbortMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.rest.RestAPIAbortMessages$handleAbortCodeOrDefault$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return true;
        }
    }

    static {
        Integer numValueOf = Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED);
        Integer numValueOf2 = Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INCOMING_BLOCKED);
        Integer numValueOf3 = Integer.valueOf(R.string.add_friend_error_other);
        MESSAGES = Maps6.mapOf(Tuples.to(numValueOf, Integer.valueOf(R.string.bot_requires_email_verification)), Tuples.to(Integer.valueOf(RestAPIAbortCodes.INVALID_MESSAGE_SEND_USER), Integer.valueOf(R.string.bot_dm_send_failed)), Tuples.to(Integer.valueOf(RestAPIAbortCodes.RATE_LIMIT_DM_OPEN), Integer.valueOf(R.string.bot_dm_rate_limited)), Tuples.to(Integer.valueOf(RestAPIAbortCodes.SEND_MESSAGE_TEMPORARILY_DISABLED), Integer.valueOf(R.string.bot_dm_send_message_temporarily_disabled)), Tuples.to(numValueOf, Integer.valueOf(R.string.add_friend_error_invalid_discord_tag)), Tuples.to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_FRIENDS), Integer.valueOf(R.string.add_friend_error_too_many_friends)), Tuples.to(numValueOf2, numValueOf3), Tuples.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_SELF), numValueOf3), Tuples.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_USER_BOT), numValueOf3), Tuples.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_INVALID_DISCORD_TAG), numValueOf3), Tuples.to(Integer.valueOf(RestAPIAbortCodes.RELATIONSHIP_ALREADY_FRIENDS), Integer.valueOf(R.string.add_friend_error_already_friends)), Tuples.to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_THREADS), Integer.valueOf(R.string.too_many_threads_message)), Tuples.to(Integer.valueOf(RestAPIAbortCodes.TOO_MANY_ANNOUNCEMENT_THREADS), Integer.valueOf(R.string.too_many_announcement_threads_message)), Tuples.to(Integer.valueOf(RestAPIAbortCodes.SLOWMODE_RATE_LIMITED), Integer.valueOf(R.string.channel_slowmode_desc_short)));
    }

    private RestAPIAbortMessages() {
    }

    public static final Integer getAbortCodeMessageResId(int abortCode) {
        return MESSAGES.get(Integer.valueOf(abortCode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleAbortCodeOrDefault$default(RestAPIAbortMessages restAPIAbortMessages, Error error, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function02 = AnonymousClass1.INSTANCE;
        }
        restAPIAbortMessages.handleAbortCodeOrDefault(error, function0, function02);
    }

    public final void handleAbortCodeOrDefault(Error errorResponse, Function0<Unit> onHandle, Function0<Boolean> onDefault) {
        Intrinsics3.checkNotNullParameter(errorResponse, "errorResponse");
        Intrinsics3.checkNotNullParameter(onHandle, "onHandle");
        Intrinsics3.checkNotNullParameter(onDefault, "onDefault");
        if (errorResponse.getType() != Error.Type.DISCORD_BAD_REQUEST) {
            errorResponse.setShowErrorToasts(onDefault.invoke().booleanValue());
        } else {
            errorResponse.setShowErrorToasts(false);
            onHandle.invoke();
        }
    }
}
