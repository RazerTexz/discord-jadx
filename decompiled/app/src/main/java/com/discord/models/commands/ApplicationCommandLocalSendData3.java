package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandData3;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ApplicationCommandLocalSendData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a=\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u001a\u0010\u0005\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\b\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00012\u001a\u0010\u0005\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\b\u0010\t*\n\u0010\n\"\u00020\u00032\u00020\u0003¨\u0006\u000b"}, d2 = {"", "Lcom/discord/widgets/chat/input/models/ApplicationCommandValue;", "Lkotlin/Function1;", "Lcom/discord/api/commands/ApplicationCommandValue;", "Lcom/discord/models/commands/ApiApplicationCommandValue;", "mappingFunction", "toRestParams", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "toRestParam", "(Lcom/discord/widgets/chat/input/models/ApplicationCommandValue;Lkotlin/jvm/functions/Function1;)Lcom/discord/api/commands/ApplicationCommandValue;", "ApiApplicationCommandValue", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.models.commands.ApplicationCommandLocalSendDataKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommandLocalSendData3 {
    public static final ApplicationCommandData3 toRestParam(ApplicationCommandValue applicationCommandValue, Function1<? super ApplicationCommandData3, ApplicationCommandData3> function1) {
        Intrinsics3.checkNotNullParameter(applicationCommandValue, "$this$toRestParam");
        Intrinsics3.checkNotNullParameter(function1, "mappingFunction");
        String name = applicationCommandValue.getName();
        Object value = applicationCommandValue.getValue();
        List<ApplicationCommandValue> options = applicationCommandValue.getOptions();
        return new ApplicationCommandData3(name, value, applicationCommandValue.getType(), options != null ? toRestParams(options, function1) : null, applicationCommandValue.getFocused());
    }

    public static final List<ApplicationCommandData3> toRestParams(List<ApplicationCommandValue> list, Function1<? super ApplicationCommandData3, ApplicationCommandData3> function1) {
        Intrinsics3.checkNotNullParameter(list, "$this$toRestParams");
        Intrinsics3.checkNotNullParameter(function1, "mappingFunction");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke(toRestParam((ApplicationCommandValue) it.next(), function1)));
        }
        return arrayList;
    }
}
