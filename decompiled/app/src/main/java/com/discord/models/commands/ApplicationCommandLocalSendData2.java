package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandData3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: ApplicationCommandLocalSendData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00060\u0000j\u0002`\u00012\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/commands/ApplicationCommandValue;", "Lcom/discord/models/commands/ApiApplicationCommandValue;", "it", "invoke", "(Lcom/discord/api/commands/ApplicationCommandValue;)Lcom/discord/api/commands/ApplicationCommandValue;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.models.commands.ApplicationCommandLocalSendData$toRestApiApplicationCommandDataParam$attachmentConvertedOptions$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommandLocalSendData2 extends Lambda implements Function1<ApplicationCommandData3, ApplicationCommandData3> {
    public final /* synthetic */ Ref$IntRef $attachmentCounter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandLocalSendData2(Ref$IntRef ref$IntRef) {
        super(1);
        this.$attachmentCounter = ref$IntRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ApplicationCommandData3 invoke(ApplicationCommandData3 applicationCommandData3) {
        return invoke2(applicationCommandData3);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ApplicationCommandData3 invoke2(ApplicationCommandData3 applicationCommandData3) {
        Intrinsics3.checkNotNullParameter(applicationCommandData3, "it");
        if (applicationCommandData3.getType() != 11) {
            return applicationCommandData3;
        }
        ApplicationCommandData3 applicationCommandData3A = ApplicationCommandData3.a(applicationCommandData3, null, String.valueOf(this.$attachmentCounter.element), 0, null, null, 29);
        this.$attachmentCounter.element++;
        return applicationCommandData3A;
    }
}
