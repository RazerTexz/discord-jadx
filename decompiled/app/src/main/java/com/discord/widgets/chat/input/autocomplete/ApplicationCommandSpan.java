package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.commands.ApplicationCommandOption;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ApplicationCommandSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\u001a\b\u0002\u0010\u0018\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/ApplicationCommandSpan;", "Lcom/discord/utilities/textprocessing/SimpleRoundedBackgroundSpan;", "Lcom/discord/models/commands/ApplicationCommandOption;", "commandOption", "Lcom/discord/models/commands/ApplicationCommandOption;", "getCommandOption", "()Lcom/discord/models/commands/ApplicationCommandOption;", "", "commandValue", "Ljava/lang/String;", "getCommandValue", "()Ljava/lang/String;", "", "startIndex", "endIndex", "edgeHorizontalPadding", "edgeHorizontalMargin", "backgroundColor", "", "cornerRadius", "textColor", "", "isTrimEnabled", "Lkotlin/Function1;", "transformSpannedText", "<init>", "(Lcom/discord/models/commands/ApplicationCommandOption;Ljava/lang/String;IIIIIFLjava/lang/Integer;ZLkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ApplicationCommandSpan extends SimpleRoundedBackgroundSpan {
    private final ApplicationCommandOption commandOption;
    private final String commandValue;

    public /* synthetic */ ApplicationCommandSpan(ApplicationCommandOption applicationCommandOption, String str, int i, int i2, int i3, int i4, int i5, float f, Integer num, boolean z2, Function1 function1, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationCommandOption, str, i, i2, i3, i4, i5, f, (i6 & 256) != 0 ? null : num, (i6 & 512) != 0 ? true : z2, (i6 & 1024) != 0 ? null : function1);
    }

    public final ApplicationCommandOption getCommandOption() {
        return this.commandOption;
    }

    public final String getCommandValue() {
        return this.commandValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandSpan(ApplicationCommandOption applicationCommandOption, String str, int i, int i2, int i3, int i4, int i5, float f, Integer num, boolean z2, Function1<? super String, String> function1) {
        super(i, i2, i3, i4, i5, f, num, z2, function1, 0, 512, null);
        Intrinsics3.checkNotNullParameter(applicationCommandOption, "commandOption");
        this.commandOption = applicationCommandOption;
        this.commandValue = str;
    }
}
