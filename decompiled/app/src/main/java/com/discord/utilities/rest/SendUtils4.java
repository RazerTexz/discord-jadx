package com.discord.utilities.rest;

import com.discord.api.commands.ApplicationCommandType;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SendUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/widgets/chat/input/models/ApplicationCommandValue;", "value", "invoke", "(Lcom/discord/widgets/chat/input/models/ApplicationCommandValue;)Lcom/discord/widgets/chat/input/models/ApplicationCommandValue;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rest.SendUtils$getSendCommandPayload$attachmentCorrectedMessage$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SendUtils4 extends Lambda implements Function1<ApplicationCommandValue, ApplicationCommandValue> {
    public final /* synthetic */ List $fileAttachments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendUtils4(List list) {
        super(1);
        this.$fileAttachments = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ApplicationCommandValue invoke(ApplicationCommandValue applicationCommandValue) {
        return invoke2(applicationCommandValue);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ApplicationCommandValue invoke2(ApplicationCommandValue applicationCommandValue) {
        Intrinsics3.checkNotNullParameter(applicationCommandValue, "value");
        if (applicationCommandValue.getType() != ApplicationCommandType.ATTACHMENT.getType()) {
            return applicationCommandValue;
        }
        for (Attachment attachment : this.$fileAttachments) {
            if (Intrinsics3.areEqual(attachment.getUri().toString(), applicationCommandValue.getValue())) {
                return ApplicationCommandValue.copy$default(applicationCommandValue, null, attachment.getDisplayName(), 0, null, null, 29, null);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
