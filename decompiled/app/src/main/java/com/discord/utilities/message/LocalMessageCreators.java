package com.discord.utilities.message;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.application.Application;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.LocalAttachment;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.NonceGenerator;
import com.discord.models.message.Message;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.time.Clock;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import org.objectweb.asm.Opcodes;

/* compiled from: LocalMessageCreators.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a¿\u0001\u0010 \u001a\u00020\u001f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b \u0010!\u001a3\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006¢\u0006\u0004\b\"\u0010#\u001a=\u0010)\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2&\u0010(\u001a\"\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020&\u0018\u00010%j\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020&\u0018\u0001`'¢\u0006\u0004\b)\u0010*\u001a[\u00101\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b1\u00102\u001a7\u00101\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\b\u00100\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b1\u00103\u001a%\u00104\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"", "content", "", "channelId", "Lcom/discord/api/user/User;", "author", "", "mentions", "", "unsent", "hasLocalUploads", "Lcom/discord/api/application/Application;", "application", "Lcom/discord/api/message/activity/MessageActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/api/message/LocalAttachment;", "localAttachments", "lastManualAttemptTimestamp", "initialAttemptTimestamp", "", "numRetries", "Lcom/discord/api/sticker/BaseSticker;", "stickers", "Lcom/discord/api/message/MessageReference;", "messageReference", "Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;", "allowedMentions", "Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;", "captchaPayload", "Lcom/discord/models/message/Message;", "createLocalMessage", "(Ljava/lang/String;JLcom/discord/api/user/User;Ljava/util/List;ZZLcom/discord/api/application/Application;Lcom/discord/api/message/activity/MessageActivity;Lcom/discord/utilities/time/Clock;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Lcom/discord/api/message/MessageReference;Lcom/discord/api/message/allowedmentions/MessageAllowedMentions;Lcom/discord/utilities/captcha/CaptchaHelper$CaptchaPayload;)Lcom/discord/models/message/Message;", "createInvalidAttachmentsMessage", "(JLcom/discord/api/user/User;Lcom/discord/utilities/time/Clock;Ljava/util/List;)Lcom/discord/models/message/Message;", "other", "Ljava/util/LinkedHashMap;", "Lcom/discord/api/message/reaction/MessageReaction;", "Lkotlin/collections/LinkedHashMap;", "reactions", "createWithReactions", "(Lcom/discord/models/message/Message;Ljava/util/LinkedHashMap;)Lcom/discord/models/message/Message;", "nonce", "commandName", "interactionAuthor", "isFailed", "isLoading", "interactionId", "createLocalApplicationCommandMessage", "(JLjava/lang/String;JLcom/discord/api/user/User;Lcom/discord/api/user/User;ZZLjava/lang/Long;Lcom/discord/utilities/time/Clock;)Lcom/discord/models/message/Message;", "(Lcom/discord/models/message/Message;Ljava/lang/Long;ZZLcom/discord/utilities/time/Clock;)Lcom/discord/models/message/Message;", "createThreadStarterMessageNotFoundMessage", "(JLcom/discord/api/user/User;Lcom/discord/utilities/time/Clock;)Lcom/discord/models/message/Message;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.message.LocalMessageCreatorsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class LocalMessageCreators {
    public static final Message createInvalidAttachmentsMessage(long j, User user, Clock clock, List<LocalAttachment> list) {
        Intrinsics3.checkNotNullParameter(user, "author");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(list, "localAttachments");
        long jComputeNonce = NonceGenerator.INSTANCE.computeNonce(clock);
        UtcDateTime utcDateTime = new UtcDateTime(clock.currentTimeMillis());
        Boolean bool = Boolean.FALSE;
        return new Message(jComputeNonce, j, null, user, "", utcDateTime, null, bool, bool, Collections2.emptyList(), Collections2.emptyList(), Collections2.emptyList(), Collections2.emptyList(), Collections2.emptyList(), String.valueOf(jComputeNonce), bool, null, -3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, null, null, null, null, list, null, -2147483644, 94, null);
    }

    public static final Message createLocalApplicationCommandMessage(long j, String str, long j2, User user, User user2, boolean z2, boolean z3, Long l, Clock clock) {
        Intrinsics3.checkNotNullParameter(user2, "application");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        int i = z2 ? -4 : -5;
        Long l2 = z3 ? 128L : null;
        UtcDateTime utcDateTime = new UtcDateTime(clock.currentTimeMillis());
        Interaction interaction = new Interaction(l, 2, str, user, null);
        return new Message(j, j2, null, user2, "", utcDateTime, null, null, null, null, null, null, null, null, String.valueOf(j), null, null, Integer.valueOf(i), null, null, Long.valueOf(user2.getId()), null, l2, null, null, null, interaction, null, null, null, null, null, false, null, null, null, null, null, null, -72499260, Opcodes.LAND, null);
    }

    public static final Message createLocalMessage(String str, long j, User user, List<User> list, boolean z2, boolean z3, Application application, MessageActivity messageActivity, Clock clock, List<LocalAttachment> list2, Long l, Long l2, Integer num, List<? extends BaseSticker> list3, MessageReference messageReference, MessageAllowedMentions messageAllowedMentions, CaptchaHelper.CaptchaPayload captchaPayload) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(str, "content");
        Intrinsics3.checkNotNullParameter(user, "author");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        long jComputeNonce = NonceGenerator.INSTANCE.computeNonce(clock);
        int i = z2 ? -2 : -1;
        UtcDateTime utcDateTime = new UtcDateTime(clock.currentTimeMillis());
        Boolean bool = Boolean.FALSE;
        List listEmptyList = Collections2.emptyList();
        List listEmptyList2 = Collections2.emptyList();
        List listEmptyList3 = Collections2.emptyList();
        List listEmptyList4 = Collections2.emptyList();
        String strValueOf = String.valueOf(jComputeNonce);
        Integer numValueOf = Integer.valueOf(i);
        if (list3 != null) {
            arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((BaseSticker) it.next()).c());
            }
        } else {
            arrayList = null;
        }
        return new Message(jComputeNonce, j, null, user, str, utcDateTime, null, bool, bool, list, listEmptyList, listEmptyList2, listEmptyList3, listEmptyList4, strValueOf, bool, null, numValueOf, messageActivity, application, null, messageReference, null, null, arrayList, null, null, null, null, null, Boolean.FALSE, null, z3, messageAllowedMentions, num, l, l2, list2, captchaPayload, -2147483644, 0, null);
    }

    public static /* synthetic */ Message createLocalMessage$default(String str, long j, User user, List list, boolean z2, boolean z3, Application application, MessageActivity messageActivity, Clock clock, List list2, Long l, Long l2, Integer num, List list3, MessageReference messageReference, MessageAllowedMentions messageAllowedMentions, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        return createLocalMessage(str, j, user, list, z2, z3, application, messageActivity, clock, list2, l, l2, num, list3, messageReference, messageAllowedMentions, (i & 65536) != 0 ? null : captchaPayload);
    }

    public static final Message createThreadStarterMessageNotFoundMessage(long j, User user, Clock clock) {
        Intrinsics3.checkNotNullParameter(user, "author");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        long jComputeNonce = NonceGenerator.INSTANCE.computeNonce(clock);
        return new Message(jComputeNonce, j, null, user, "", new UtcDateTime(clock.currentTimeMillis()), null, null, null, null, null, null, null, null, String.valueOf(jComputeNonce), null, null, -7, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -147516, Opcodes.LAND, null);
    }

    public static final Message createWithReactions(Message message, LinkedHashMap<String, MessageReaction> linkedHashMap) {
        List listEmptyList;
        Collection<MessageReaction> collectionValues;
        Intrinsics3.checkNotNullParameter(message, "other");
        if (linkedHashMap == null || (collectionValues = linkedHashMap.values()) == null || (listEmptyList = _Collections.toList(collectionValues)) == null) {
            listEmptyList = Collections2.emptyList();
        }
        return Message.copy$default(message, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, listEmptyList, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -8193, Opcodes.LAND, null);
    }

    public static final Message createLocalApplicationCommandMessage(Message message, Long l, boolean z2, boolean z3, Clock clock) {
        Intrinsics3.checkNotNullParameter(message, "other");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Interaction interaction = message.getInteraction();
        String name = interaction != null ? interaction.getName() : null;
        Interaction interaction2 = message.getInteraction();
        User user = interaction2 != null ? interaction2.getUser() : null;
        long id2 = message.getId();
        long channelId = message.getChannelId();
        User author = message.getAuthor();
        Intrinsics3.checkNotNull(author);
        return createLocalApplicationCommandMessage(id2, name, channelId, user, author, z2, z3, l, clock);
    }
}
